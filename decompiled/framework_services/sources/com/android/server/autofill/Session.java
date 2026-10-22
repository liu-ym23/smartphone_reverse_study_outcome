package com.android.server.autofill;

import android.R;
import android.app.ActivityTaskManager;
import android.app.IAssistDataReceiver;
import android.app.PendingIntent;
import android.app.assist.AssistStructure;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ServiceInfo;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.metrics.LogMaker;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.os.TransactionTooLargeException;
import android.service.assist.classification.FieldClassification;
import android.service.assist.classification.FieldClassificationRequest;
import android.service.assist.classification.FieldClassificationResponse;
import android.service.autofill.AutofillFieldClassificationService;
import android.service.autofill.CompositeUserData;
import android.service.autofill.ConvertCredentialResponse;
import android.service.autofill.Dataset;
import android.service.autofill.Field;
import android.service.autofill.FieldClassificationUserData;
import android.service.autofill.FillContext;
import android.service.autofill.FillRequest;
import android.service.autofill.FillResponse;
import android.service.autofill.InlinePresentation;
import android.service.autofill.InternalSanitizer;
import android.service.autofill.InternalValidator;
import android.service.autofill.SaveInfo;
import android.service.autofill.SaveRequest;
import android.service.autofill.UserData;
import android.service.autofill.ValueFinder;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.LocalLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.view.KeyEvent;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.autofill.IAutoFillManagerClient;
import android.view.autofill.IAutofillWindowPresenter;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.RemoteViews;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.QuintConsumer;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.autofill.ui.AutoFillUI;
import com.android.server.autofill.ui.InlineFillUi;
import com.android.server.autofill.ui.PendingUi;
import com.android.server.pm.PackageManagerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
final class Session implements RemoteFillService.FillServiceCallbacks, ViewState.Listener, AutoFillUI.AutoFillUiCallback, ValueFinder, RemoteFieldClassificationService.FieldClassificationServiceCallbacks {
    private static final String ACTION_DELAYED_FILL = "android.service.autofill.action.DELAYED_FILL";
    static final int AUGMENTED_AUTOFILL_REQUEST_ID = 1;
    private static final boolean DBG = false;
    private static final long DEFAULT_UNASSIGNED_TIME = -1;
    private static final int DEFAULT__FIELD_CLASSIFICATION_REQUEST_ID_SNAPSHOT = -2;
    private static final int DEFAULT__FILL_REQUEST_ID_SNAPSHOT = -2;
    public static final String EXTRA_KEY_DETECTIONS = "detections";
    private static final String EXTRA_REQUEST_ID = "android.service.autofill.extra.REQUEST_ID";
    private static final String PCC_HINTS_DELIMITER = ",";
    static final String REQUEST_ID_KEY = "autofill_request_id";
    static final String SESSION_ID_KEY = "autofill_session_id";
    private static final int SHOW_FILL_DIALOG_NO = 0;
    private static final int SHOW_FILL_DIALOG_WAIT = 2;
    private static final int SHOW_FILL_DIALOG_YES = 1;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_FINISHED = 2;
    public static final int STATE_REMOVED = 3;
    public static final int STATE_UNKNOWN = 0;
    private static final String TAG = "AutofillSession";
    private static RequestId mRequestId;
    private static AtomicInteger sIdCounterForPcc;
    public final int id;
    private IBinder mActivityToken;
    private final AssistDataReceiverImpl mAssistReceiver;
    private Runnable mAugmentedAutofillDestroyer;
    private ArrayList<AutofillId> mAugmentedAutofillableIds;
    private ArrayList<LogMaker> mAugmentedRequestsLogs;
    private final ClassificationState mClassificationState;
    private IAutoFillManagerClient mClient;
    private Bundle mClientState;
    private Bundle mClientStateForSecondary;
    private IBinder.DeathRecipient mClientVulture;
    private final boolean mCompatMode;
    private final ComponentName mComponentName;
    private final Context mContext;
    private ArrayList<FillContext> mContexts;
    private final ComponentName mCredentialAutofillService;
    private AutofillId mCurrentViewId;
    private final BroadcastReceiver mDelayedFillBroadcastReceiver;
    private boolean mDelayedFillBroadcastReceiverRegistered;
    private PendingIntent mDelayedFillPendingIntent;
    boolean mDestroyed;
    private IExtSession mExt;
    private int mFieldClassificationIdSnapshot;
    private final long mFillDialogMinWaitAfterImeAnimationMs;
    private Runnable mFillDialogRunnable;
    private final long mFillDialogTimeoutMs;
    private FillRequestEventLogger mFillRequestEventLogger;
    private int mFillRequestIdSnapshot;
    private FillResponseEventLogger mFillResponseEventLogger;
    public final int mFlags;
    private final Handler mHandler;
    private boolean mHasCallback;
    private boolean mIgnoreViewStateResetToEmpty;
    private long mImeAnimationFinishTimeMs;
    private long mImeAnimationStartTimeMs;
    private final boolean mImproveFillDialogEnabled;
    final AutofillInlineSessionController mInlineSessionController;
    private boolean mIsPrimaryCredential;
    private AutofillId[] mLastFillDialogTriggerIds;
    private Pair<Integer, InlineSuggestionsRequest> mLastInlineSuggestionsRequest;
    private long mLastInputStartTime;
    private long mLatencyBaseTime;
    final Object mLock;
    private boolean mLogViewEntered;
    private boolean mLoggedInlineDatasetShown;
    private final MetricsLogger mMetricsLogger;
    private final PccAssistDataReceiverImpl mPccAssistReceiver;
    private PendingUi mPendingSaveUi;
    private PresentationStatsEventLogger mPresentationStatsEventLogger;
    private AutofillId mPreviousNonNullEnteredViewId;
    private boolean mPreviouslyFillDialogPotentiallyStarted;
    private final RemoteFillService mRemoteFillService;
    private int mRequestCount;
    private final SparseArray<LogMaker> mRequestLogs;
    private SparseArray<FillResponse> mResponses;
    private SaveEventLogger mSaveEventLogger;
    private boolean mSaveOnAllViewsInvisible;
    private final SecondaryProviderHandler mSecondaryProviderHandler;
    private SparseArray<FillResponse> mSecondaryResponses;
    private ArrayList<String> mSelectedDatasetIds;
    private final AutofillManagerServiceImpl mService;
    private SessionCommittedEventLogger mSessionCommittedEventLogger;
    private final SessionFlags mSessionFlags;
    private int mSessionState;
    private final long mStartTime;
    private final AutoFillUI mUi;
    private final LocalLog mUiLatencyHistory;
    private long mUiShownTime;
    private AssistStructure.ViewNode mUrlBar;
    private final ArrayMap<AutofillId, ViewState> mViewStates;
    private boolean mWaitForImeAnimation;
    private final LocalLog mWtfHistory;
    public final int taskId;
    public final int uid;
    public final int userId;

    final class AssistDataReceiverImpl extends IAssistDataReceiver.Stub {
        private FillRequest mLastFillRequest;
        private FillRequest mPendingFillRequest;
        private InlineSuggestionsRequest mPendingInlineSuggestionsRequest;
        private boolean mWaitForInlineRequest;
        final /* synthetic */ Session this$0;

        AssistDataReceiverImpl(Session this$0) {
            this.this$0 = this$0;
        }

        Consumer<InlineSuggestionsRequest> newAutofillRequestLocked(ViewState viewState, boolean isInlineRequest) {
            this.mPendingFillRequest = null;
            this.mWaitForInlineRequest = isInlineRequest;
            this.mPendingInlineSuggestionsRequest = null;
            if (isInlineRequest == false) goto L6;
            WeakReference<AssistDataReceiverImpl> assistDataReceiverWeakReference = new WeakReference(this);
            WeakReference<ViewState> viewStateWeakReference = new WeakReference(viewState);
            return new InlineSuggestionRequestConsumer(assistDataReceiverWeakReference, viewStateWeakReference);
        L6:
            return null;
        }

        void handleInlineSuggestionRequest(InlineSuggestionsRequest inlineSuggestionsRequest, ViewState viewState) {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(Session.TAG, "handleInlineSuggestionRequest(): inline suggestion request received");
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (this.mWaitForInlineRequest == false) goto L20;
            if (this.mPendingInlineSuggestionsRequest != null) goto L20;
            if (inlineSuggestionsRequest == null) goto L14;
            boolean r1 = true;
        L15:
            this.mWaitForInlineRequest = r1;     // Catch: Throwable -> L18
            this.mPendingInlineSuggestionsRequest = inlineSuggestionsRequest;     // Catch: Throwable -> L18
            maybeRequestFillLocked();     // Catch: Throwable -> L18
            viewState.resetState(65536);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L14:
            r1 = false;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L18
        }

        void maybeRequestFillLocked() {
            if (this.mPendingFillRequest == null) goto L5;
            Session.m2363$$Nest$fputmFieldClassificationIdSnapshot(this.this$0, Session.m2378$$Nest$sfgetsIdCounterForPcc().get());
            if (this.mWaitForInlineRequest == false) goto L21;
            if (this.mPendingInlineSuggestionsRequest != null) goto L17;
            if (Helper.sVerbose == false) goto L43;
            Slog.v(Session.TAG, "maybeRequestFillLocked(): cancelling calling fill request due to waiting for inline request and pending inline request is currently empty");
            return;
        L43:
            return;
        L17:
            if (Helper.sVerbose == false) goto L19;
            Slog.v(Session.TAG, "maybeRequestFillLocked(): adding inline request to pending fill request");
        L19:
            this.mPendingFillRequest = new FillRequest(this.mPendingFillRequest.getId(), this.mPendingFillRequest.getFillContexts(), this.mPendingFillRequest.getHints(), this.mPendingFillRequest.getClientState(), this.mPendingFillRequest.getFlags(), this.mPendingInlineSuggestionsRequest, this.mPendingFillRequest.getDelayedFillIntentSender());
        L23:
            this.mLastFillRequest = this.mPendingFillRequest;
            if (Helper.sVerbose == false) goto L27;
            Slog.v(Session.TAG, "maybeRequestFillLocked(): sending fill request");
        L27:
            if (this.this$0.shouldRequestSecondaryProvider(this.mPendingFillRequest.getFlags()) == false) goto L35;
            if (Session.m2356$$Nest$fgetmSecondaryProviderHandler(this.this$0) == null) goto L35;
            Slog.v(Session.TAG, "Requesting fill response to secondary provider.");
            if (Session.m2352$$Nest$fgetmIsPrimaryCredential(this.this$0) == true) goto L33;
            this.mPendingFillRequest = Session.m2365$$Nest$maddCredentialManagerDataToClientState(this.this$0, this.mPendingFillRequest, this.mPendingInlineSuggestionsRequest, this.this$0.id);
        L33:
            Session.m2356$$Nest$fgetmSecondaryProviderHandler(this.this$0).onFillRequest(this.mPendingFillRequest, this.mPendingFillRequest.getFlags(), Session.m2343$$Nest$fgetmClient(this.this$0).asBinder());
        L40:
            this.mPendingInlineSuggestionsRequest = null;
            this.mWaitForInlineRequest = false;
            this.mPendingFillRequest = null;
            long fillRequestSentRelativeTimestamp = SystemClock.elapsedRealtime() - Session.m2353$$Nest$fgetmLatencyBaseTime(this.this$0);
            Session.m2354$$Nest$fgetmPresentationStatsEventLogger(this.this$0).maybeSetFillRequestSentTimestampMs((int) fillRequestSentRelativeTimestamp);
            Session.m2351$$Nest$fgetmFillRequestEventLogger(this.this$0).maybeSetLatencyFillRequestSentMillis((int) fillRequestSentRelativeTimestamp);
            Session.m2351$$Nest$fgetmFillRequestEventLogger(this.this$0).logAndEndEvent();
            return;
        L35:
            if (Session.m2355$$Nest$fgetmRemoteFillService(this.this$0) == null) goto L40;
            if (Session.m2352$$Nest$fgetmIsPrimaryCredential(this.this$0) == false) goto L39;
            this.mPendingFillRequest = Session.m2365$$Nest$maddCredentialManagerDataToClientState(this.this$0, this.mPendingFillRequest, this.mPendingInlineSuggestionsRequest, this.this$0.id);
            Session.m2355$$Nest$fgetmRemoteFillService(this.this$0).onFillCredentialRequest(this.mPendingFillRequest, Session.m2343$$Nest$fgetmClient(this.this$0).asBinder());
            goto L40
        L39:
            Session.m2355$$Nest$fgetmRemoteFillService(this.this$0).onFillRequest(this.mPendingFillRequest);
            goto L40
        L21:
            if (Helper.sVerbose == false) goto L23;
            Slog.v(Session.TAG, "maybeRequestFillLocked(): not adding inline request to pending fill request");
            goto L23
        L5:
            if (Helper.sVerbose == false) goto L42;
            Slog.v(Session.TAG, "maybeRequestFillLocked(): cancelling calling fill request due to empty pending fill request");
            return;
        }

        public void onHandleAssistData(Bundle resultData) throws RemoteException {
            if (Session.m2355$$Nest$fgetmRemoteFillService(this.this$0) != null) goto L6;
            Session.m2376$$Nest$mwtf(this.this$0, null, "onHandleAssistData() called without a remote service. mForAugmentedAutofillOnly: %s", new Object[]{Boolean.valueOf(SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(Session.m2358$$Nest$fgetmSessionFlags(this.this$0)))});
            return;
        L6:
            AutofillId currentViewId = Session.m2349$$Nest$fgetmCurrentViewId(this.this$0);
            if (currentViewId != null) goto L10;
            Slog.w(Session.TAG, "No current view id - session might have finished");
            return;
        L10:
            AssistStructure structure = (AssistStructure) resultData.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_STRUCTURE, AssistStructure.class);
            if (structure != null) goto L14;
            Slog.e(Session.TAG, "No assist structure - app might have crashed providing it");
            return;
        L14:
            Bundle receiverExtras = resultData.getBundle(ActivityTaskManagerInternal.ASSIST_KEY_RECEIVER_EXTRAS);
            if (receiverExtras != null) goto L18;
            Slog.e(Session.TAG, "No receiver extras - app might have crashed providing it");
            return;
        L18:
            int requestId = receiverExtras.getInt(Session.EXTRA_REQUEST_ID);
            if (Helper.sVerbose == false) goto L21;
            Slog.v(Session.TAG, "New structure for requestId " + requestId + ": " + structure);
        L21:
            Object r15 = this.this$0.mLock;
            monitor-enter(r15);
            structure.ensureDataForAutofill();     // Catch: Throwable -> L29 RuntimeException -> L65
        L25:
            ArrayList<AutofillId> ids = Helper.getAutofillIds(structure, false);     // Catch: Throwable -> L29
            int i = 0;
        L27:
            if (i >= ids.size()) goto L31;
            ids.get(i).setSessionId(this.this$0.id);     // Catch: Throwable -> L29
            i = i + 1;     // Catch: Throwable -> L29
            goto L27
        L31:
            int flags = structure.getFlags();     // Catch: Throwable -> L29
            if (Session.m2346$$Nest$fgetmCompatMode(this.this$0) == false) goto L44;
            String[] urlBarIds = Session.m2357$$Nest$fgetmService(this.this$0).getUrlBarResourceIdsForCompatMode(Session.m2347$$Nest$fgetmComponentName(this.this$0).getPackageName());     // Catch: Throwable -> L29
            if (Helper.sDebug == false) goto L36;
            Slog.d(Session.TAG, "url_bars in compat mode: " + Arrays.toString(urlBarIds));     // Catch: Throwable -> L29
        L36:
            if (urlBarIds == null) goto L43;
            Session.m2364$$Nest$fputmUrlBar(this.this$0, Helper.sanitizeUrlBar(structure, urlBarIds));     // Catch: Throwable -> L29
            if (Session.m2359$$Nest$fgetmUrlBar(this.this$0) == null) goto L43;
            AutofillId urlBarId = Session.m2359$$Nest$fgetmUrlBar(this.this$0).getAutofillId();     // Catch: Throwable -> L29
            if (Helper.sDebug == false) goto L42;
            Slog.d(Session.TAG, "Setting urlBar as id=" + urlBarId + " and domain " + Session.m2359$$Nest$fgetmUrlBar(this.this$0).getWebDomain());     // Catch: Throwable -> L29
        L42:
            ViewState viewState = new ViewState(urlBarId, this.this$0, 512, Session.m2352$$Nest$fgetmIsPrimaryCredential(this.this$0));     // Catch: Throwable -> L29
            Session.m2360$$Nest$fgetmViewStates(this.this$0).put(urlBarId, viewState);     // Catch: Throwable -> L29
        L43:
            int flags2 = flags | 2;     // Catch: Throwable -> L29
        L45:
            structure.sanitizeForParceling(true);     // Catch: Throwable -> L29
            if (Session.m2348$$Nest$fgetmContexts(this.this$0) != null) goto L48;
            Session.m2361$$Nest$fputmContexts(this.this$0, new ArrayList(1));     // Catch: Throwable -> L29
        L48:
            Session.m2348$$Nest$fgetmContexts(this.this$0).add(new FillContext(requestId, structure, currentViewId));     // Catch: Throwable -> L29
            Session.m2366$$Nest$mcancelCurrentRequestLocked(this.this$0);     // Catch: Throwable -> L29
            int numContexts = Session.m2348$$Nest$fgetmContexts(this.this$0).size();     // Catch: Throwable -> L29
            int i2 = 0;
        L49:
            if (i2 >= numContexts) goto L51;
            Session.m2368$$Nest$mfillContextWithAllowedValuesLocked(this.this$0, (FillContext) Session.m2348$$Nest$fgetmContexts(this.this$0).get(i2), flags2);     // Catch: Throwable -> L29
            i2 = i2 + 1;     // Catch: Throwable -> L29
            goto L49
        L51:
            ArrayList<FillContext> contexts = Session.m2370$$Nest$mmergePreviousSessionLocked(this.this$0, false);     // Catch: Throwable -> L29
            List<String> hints = Session.m2369$$Nest$mgetTypeHintsForProvider(this.this$0);     // Catch: Throwable -> L29
            Bundle sendBackClientState = Session.m2344$$Nest$fgetmClientState(this.this$0);     // Catch: Throwable -> L29
            Session.m2377$$Nest$sfgetmRequestId();     // Catch: Throwable -> L29
            if (RequestId.isSecondaryProvider(requestId) == false) goto L54;
            Bundle sendBackClientState2 = Session.m2345$$Nest$fgetmClientStateForSecondary(this.this$0);     // Catch: Throwable -> L29
        L55:
            Session.m2362$$Nest$fputmDelayedFillPendingIntent(this.this$0, Session.m2367$$Nest$mcreatePendingIntent(this.this$0, requestId));     // Catch: Throwable -> L29
            if (Session.m2350$$Nest$fgetmDelayedFillPendingIntent(this.this$0) != null) goto L58;
            IntentSender r14 = null;
        L59:
            FillRequest request = new FillRequest(requestId, contexts, hints, sendBackClientState2, flags2, null, r14);     // Catch: Throwable -> L29
            this.mPendingFillRequest = request;     // Catch: Throwable -> L29
            maybeRequestFillLocked();     // Catch: Throwable -> L29
            monitor-exit(r15);     // Catch: Throwable -> L29
            if (Session.m2340$$Nest$fgetmActivityToken(this.this$0) == null) goto L75;
            Session.m2357$$Nest$fgetmService(this.this$0).sendActivityAssistDataToContentCapture(Session.m2340$$Nest$fgetmActivityToken(this.this$0), resultData);
            return;
        L75:
            return;
        L58:
            r14 = Session.m2350$$Nest$fgetmDelayedFillPendingIntent(this.this$0).getIntentSender();     // Catch: Throwable -> L29
            goto L59
        L54:
            sendBackClientState2 = sendBackClientState;
            goto L55
        L44:
            flags2 = flags;
        L65:
            e = move-exception;
            Session.m2376$$Nest$mwtf(this.this$0, e, "Exception lazy loading assist structure for %s: %s", new Object[]{structure.getActivityComponent(), e});     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        }

        public void onHandleAssistScreenshot(Bitmap screenshot) {
        }

        void processDelayedFillLocked(int requestId, FillResponse response) {
            if (this.mLastFillRequest != null) goto L5;
            return;
        L5:
            if (requestId != this.mLastFillRequest.getId()) goto L9;
            Slog.v(Session.TAG, "processDelayedFillLocked: calling onFillRequestSuccess with new response");
            this.this$0.onFillRequestSuccess(requestId, response, Session.m2357$$Nest$fgetmService(this.this$0).getServicePackageName(), this.mLastFillRequest.getFlags());
            return;
        }
    }

    private static class AugmentedAutofillErrorCallback implements Runnable {
        WeakReference<Session> mSessionWeakRef;

        AugmentedAutofillErrorCallback(Session session) {
            this.mSessionWeakRef = new WeakReference(session);
        }

        @Override // java.lang.Runnable
        public void run() {
            Session session = this.mSessionWeakRef.get();
            if (Session.m2379$$Nest$smlogIfSessionNull(session, "AugmentedAutofillErrorCallback:") == false) goto L5;
            return;
        L5:
            Session.m2373$$Nest$monAugmentedAutofillErrorCallback(session);
        }
    }

    private static class AugmentedAutofillInlineSuggestionRendererOnResultListener implements RemoteCallback.OnResultListener {
        final AutofillId mFocusedId;
        Consumer<InlineSuggestionsRequest> mRequestAugmentedAutofill;
        WeakReference<Session> mSessionWeakRef;

        AugmentedAutofillInlineSuggestionRendererOnResultListener(Session session, AutofillId focussedId, Consumer<InlineSuggestionsRequest> requestAugmentedAutofill) {
            this.mSessionWeakRef = new WeakReference(session);
            this.mFocusedId = focussedId;
            this.mRequestAugmentedAutofill = requestAugmentedAutofill;
        }

        public void onResult(Bundle result) {
            Session session = this.mSessionWeakRef.get();
            if (Session.m2379$$Nest$smlogIfSessionNull(session, "AugmentedAutofillInlineSuggestionRendererOnResultListener:") == false) goto L5;
            return;
        L5:
            Object r1 = session.mLock;
            monitor-enter(r1);
            session.mInlineSessionController.onCreateInlineSuggestionsRequestLocked(this.mFocusedId, this.mRequestAugmentedAutofill, result);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private static class AugmentedAutofillInlineSuggestionRequestConsumer implements Consumer<InlineSuggestionsRequest> {
        final AutofillValue mCurrentValue;
        final AutofillId mFocusedId;
        final boolean mIsAllowlisted;
        final int mMode;
        WeakReference<Session> mSessionWeakRef;

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(InlineSuggestionsRequest r1) {
            accept2(r1);
        }

        AugmentedAutofillInlineSuggestionRequestConsumer(Session session, AutofillId focussedId, boolean isAllowlisted, int mode, AutofillValue currentValue) {
            this.mSessionWeakRef = new WeakReference(session);
            this.mFocusedId = focussedId;
            this.mIsAllowlisted = isAllowlisted;
            this.mMode = mode;
            this.mCurrentValue = currentValue;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(InlineSuggestionsRequest inlineSuggestionsRequest) {
            Session session = this.mSessionWeakRef.get();
            if (Session.m2379$$Nest$smlogIfSessionNull(session, "AugmentedAutofillInlineSuggestionRequestConsumer:") == false) goto L5;
            return;
        L5:
            Session.m2374$$Nest$monAugmentedAutofillInlineSuggestionAccept(session, inlineSuggestionsRequest, this.mFocusedId, this.mIsAllowlisted, this.mMode, this.mCurrentValue);
        }
    }

    private static class AugmentedAutofillInlineSuggestionsResponseCallback implements Function<InlineFillUi, Boolean> {
        WeakReference<Session> mSessionWeakRef;

        @Override // java.util.function.Function
        public /* bridge */ /* synthetic */ Boolean apply(InlineFillUi r1) {
            return apply2(r1);
        }

        AugmentedAutofillInlineSuggestionsResponseCallback(Session session) {
            this.mSessionWeakRef = new WeakReference(session);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Boolean apply2(InlineFillUi inlineFillUi) {
            Session session = this.mSessionWeakRef.get();
            if (Session.m2379$$Nest$smlogIfSessionNull(session, "AugmentedAutofillInlineSuggestionsResponseCallback:") == true) goto L5;
            Object r1 = session.mLock;
            monitor-enter(r1);
            Boolean r2 = Boolean.valueOf(session.mInlineSessionController.setInlineFillUiLocked(inlineFillUi));     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        L5:
            return false;
        }
    }

    private static final class ClassificationState {
        private static final int STATE_INITIAL = 1;
        private static final int STATE_INVALIDATED = 5;
        private static final int STATE_PENDING_ASSIST_REQUEST = 2;
        private static final int STATE_PENDING_REQUEST = 3;
        private static final int STATE_RESPONSE = 4;
        private ArrayMap<AutofillId, Set<String>> mClassificationCombinedHintsMap;
        private ArrayMap<AutofillId, Set<String>> mClassificationGroupHintsMap;
        private ArrayMap<AutofillId, Set<String>> mClassificationHintsMap;
        private ArrayMap<String, Set<AutofillId>> mGroupHintsToAutofillIdMap;
        private ArrayMap<String, Set<AutofillId>> mHintsToAutofillIdMap;
        private FieldClassificationResponse mLastFieldClassificationResponse;
        private FieldClassificationRequest mPendingFieldClassificationRequest;
        private int mState;

        @Retention(RetentionPolicy.SOURCE)
        @interface ClassificationRequestState {
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClassificationCombinedHintsMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m2380$$Nest$fgetmClassificationCombinedHintsMap(ClassificationState r0) {
            return r0.mClassificationCombinedHintsMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGroupHintsToAutofillIdMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m2381$$Nest$fgetmGroupHintsToAutofillIdMap(ClassificationState r0) {
            return r0.mGroupHintsToAutofillIdMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHintsToAutofillIdMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m2382$$Nest$fgetmHintsToAutofillIdMap(ClassificationState r0) {
            return r0.mHintsToAutofillIdMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastFieldClassificationResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ FieldClassificationResponse m2383$$Nest$fgetmLastFieldClassificationResponse(ClassificationState r0) {
            return r0.mLastFieldClassificationResponse;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingFieldClassificationRequest, reason: not valid java name */
        static /* bridge */ /* synthetic */ FieldClassificationRequest m2384$$Nest$fgetmPendingFieldClassificationRequest(ClassificationState r0) {
            return r0.mPendingFieldClassificationRequest;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2385$$Nest$fgetmState(ClassificationState r0) {
            return r0.mState;
        }

        /* JADX INFO: renamed from: -$$Nest$monAssistStructureReceived, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2386$$Nest$monAssistStructureReceived(ClassificationState r0, AssistStructure r1) {
            r0.onAssistStructureReceived(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monFieldClassificationRequestSent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2387$$Nest$monFieldClassificationRequestSent(ClassificationState r0) {
            r0.onFieldClassificationRequestSent();
        }

        /* JADX INFO: renamed from: -$$Nest$mprocessResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2388$$Nest$mprocessResponse(ClassificationState r0) {
            return r0.processResponse();
        }

        /* JADX INFO: renamed from: -$$Nest$mshouldTriggerRequest, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2389$$Nest$mshouldTriggerRequest(ClassificationState r0) {
            return r0.shouldTriggerRequest();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePendingRequest, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2390$$Nest$mupdatePendingRequest(ClassificationState r0) {
            r0.updatePendingRequest();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateResponseReceived, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2391$$Nest$mupdateResponseReceived(ClassificationState r0, FieldClassificationResponse r1) {
            r0.updateResponseReceived(r1);
        }

        /* synthetic */ ClassificationState(SessionIA r1) {
            this();
        }

        private ClassificationState() {
            this.mState = 1;
        }

        private String stateToString() {
            switch(this.mState) {
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            return "STATE_INVALIDATED";
        L8:
            return "STATE_RESPONSE";
        L10:
            return "STATE_PENDING_REQUEST";
        L12:
            return "STATE_PENDING_ASSIST_REQUEST";
        L14:
            return "STATE_INITIAL";
        L5:
            return "UNKNOWN_CLASSIFICATION_STATE_" + this.mState;
        }

        private boolean processResponse() {
            if (this.mClassificationHintsMap != null) goto L5;
        L7:
            FieldClassificationResponse response = this.mLastFieldClassificationResponse;
            if (response != null) goto L11;
            return false;
        L11:
            this.mClassificationHintsMap = new ArrayMap();
            this.mClassificationGroupHintsMap = new ArrayMap();
            this.mHintsToAutofillIdMap = new ArrayMap();
            this.mGroupHintsToAutofillIdMap = new ArrayMap();
            this.mClassificationCombinedHintsMap = new ArrayMap();
            Set<FieldClassification> classifications = response.getClassifications();
            Iterator<FieldClassification> r3 = classifications.iterator();
        L13:
            if (r3.hasNext() == false) goto L18;
            FieldClassification classification = r3.next();
            AutofillId id = classification.getAutofillId();
            Set<String> hintDetections = classification.getHints();
            Set<String> groupHintsDetections = classification.getGroupHints();
            ArraySet<String> combinedHints = new ArraySet(hintDetections);
            this.mClassificationHintsMap.put(id, hintDetections);
            if (groupHintsDetections == null) goto L17;
            this.mClassificationGroupHintsMap.put(id, groupHintsDetections);
            combinedHints.addAll(groupHintsDetections);
        L17:
            this.mClassificationCombinedHintsMap.put(id, combinedHints);
            processDetections(hintDetections, id, this.mHintsToAutofillIdMap);
            processDetections(groupHintsDetections, id, this.mGroupHintsToAutofillIdMap);
            goto L13
        L18:
            return true;
        L5:
            if (this.mClassificationHintsMap.isEmpty() == true) goto L7;
            return true;
        }

        private static void processDetections(Set<String> detections, AutofillId id, ArrayMap<String, Set<AutofillId>> currentMap) {
            Iterator<String> r0 = detections.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            String detection = r0.next();
            if (currentMap.containsKey(detection) == false) goto L8;
            Set<AutofillId> autofillIds = currentMap.get(detection);
        L9:
            autofillIds.add(id);
            currentMap.put(detection, autofillIds);
            goto L4
        L8:
            autofillIds = new ArraySet();
            goto L9
        }

        private void invalidateState() {
            this.mState = 5;
        }

        private void updatePendingAssistData() {
            this.mState = 2;
        }

        private void updatePendingRequest() {
            this.mState = 3;
        }

        private void updateResponseReceived(FieldClassificationResponse response) {
            this.mState = 4;
            this.mLastFieldClassificationResponse = response;
            this.mPendingFieldClassificationRequest = null;
            processResponse();
        }

        private void onAssistStructureReceived(AssistStructure structure) {
            this.mState = 3;
            this.mPendingFieldClassificationRequest = new FieldClassificationRequest(structure);
        }

        private void onFieldClassificationRequestSent() {
            this.mState = 3;
            this.mPendingFieldClassificationRequest = null;
        }

        private boolean shouldTriggerRequest() {
            if (this.mState != 1) goto L5;
            return true;
        L5:
            if (this.mState == 5) goto L10;
            return false;
        L10:
            return true;
        }

        public String toString() {
            return "ClassificationState: [state=" + stateToString() + ", mPendingFieldClassificationRequest=" + this.mPendingFieldClassificationRequest + ", mLastFieldClassificationResponse=" + this.mLastFieldClassificationResponse + ", mClassificationHintsMap=" + this.mClassificationHintsMap + ", mClassificationGroupHintsMap=" + this.mClassificationGroupHintsMap + ", mHintsToAutofillIdMap=" + this.mHintsToAutofillIdMap + ", mGroupHintsToAutofillIdMap=" + this.mGroupHintsToAutofillIdMap + "]";
        }
    }

    private static class DatasetComputationContainer {
        Map<AutofillId, Set<Dataset>> mAutofillIdToDatasetMap;
        Set<AutofillId> mAutofillIds;
        Set<Dataset> mDatasets;

        /* synthetic */ DatasetComputationContainer(SessionIA r1) {
            this();
        }

        private DatasetComputationContainer() {
            this.mAutofillIds = new LinkedHashSet();
            this.mDatasets = new LinkedHashSet();
            this.mAutofillIdToDatasetMap = new LinkedHashMap();
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("DatasetComputationContainer[");
            if (this.mAutofillIds == null) goto L6;
            builder.append(", autofillIds=");
            builder.append(this.mAutofillIds);
        L6:
            if (this.mDatasets == null) goto L9;
            builder.append(", mDatasets=");
            builder.append(this.mDatasets);
        L9:
            if (this.mAutofillIdToDatasetMap == null) goto L11;
            builder.append(", mAutofillIdToDatasetMap=");
            builder.append(this.mAutofillIdToDatasetMap);
        L11:
            builder.append(']');
            return builder.toString();
        }
    }

    private final class PccAssistDataReceiverImpl extends IAssistDataReceiver.Stub {
        final /* synthetic */ Session this$0;

        /* synthetic */ PccAssistDataReceiverImpl(Session r1, SessionIA r2) {
            this(r1);
        }

        private PccAssistDataReceiverImpl(Session r1) {
            this.this$0 = r1;
        }

        void maybeRequestFieldClassificationFromServiceLocked() {
            if (ClassificationState.m2384$$Nest$fgetmPendingFieldClassificationRequest(Session.m2342$$Nest$fgetmClassificationState(this.this$0)) != null) goto L6;
            Slog.w(Session.TAG, "Received AssistData without pending classification request");
            return;
        L6:
            RemoteFieldClassificationService remoteFieldClassificationService = Session.m2357$$Nest$fgetmService(this.this$0).getRemoteFieldClassificationServiceLocked();
            if (remoteFieldClassificationService == null) goto L9;
            WeakReference<RemoteFieldClassificationService.FieldClassificationServiceCallbacks> fieldClassificationServiceCallbacksWeakRef = new WeakReference(this.this$0);
            remoteFieldClassificationService.onFieldClassificationRequest(ClassificationState.m2384$$Nest$fgetmPendingFieldClassificationRequest(Session.m2342$$Nest$fgetmClassificationState(this.this$0)), fieldClassificationServiceCallbacksWeakRef);
        L9:
            ClassificationState.m2387$$Nest$monFieldClassificationRequestSent(Session.m2342$$Nest$fgetmClassificationState(this.this$0));
        }

        public void onHandleAssistData(Bundle resultData) throws RemoteException {
            AssistStructure structure = (AssistStructure) resultData.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_STRUCTURE, AssistStructure.class);
            if (structure != null) goto L6;
            Slog.e(Session.TAG, "No assist structure for pcc detection - app might have crashed providing it");
            return;
        L6:
            Bundle receiverExtras = resultData.getBundle(ActivityTaskManagerInternal.ASSIST_KEY_RECEIVER_EXTRAS);
            if (receiverExtras != null) goto L10;
            Slog.e(Session.TAG, "No receiver extras for pcc detection - app might have crashed providing it");
            return;
        L10:
            int requestId = receiverExtras.getInt(Session.EXTRA_REQUEST_ID);
            if (Helper.sVerbose == false) goto L13;
            Slog.v(Session.TAG, "New structure for PCC Detection: requestId " + requestId + ": " + structure);
        L13:
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            structure.ensureDataForAutofill();     // Catch: Throwable -> L21 RuntimeException -> L26
        L17:
            ArrayList<AutofillId> ids = Helper.getAutofillIds(structure, false);     // Catch: Throwable -> L21
            int i = 0;
        L19:
            if (i >= ids.size()) goto L23;
            ids.get(i).setSessionId(this.this$0.id);     // Catch: Throwable -> L21
            i = i + 1;     // Catch: Throwable -> L21
            goto L19
        L23:
            ClassificationState.m2386$$Nest$monAssistStructureReceived(Session.m2342$$Nest$fgetmClassificationState(this.this$0), structure);     // Catch: Throwable -> L21
            maybeRequestFieldClassificationFromServiceLocked();     // Catch: Throwable -> L21
            monitor-exit(r3);     // Catch: Throwable -> L21
            return;
        L26:
            e = move-exception;
            Session.m2376$$Nest$mwtf(this.this$0, e, "Exception lazy loading assist structure for %s: %s", new Object[]{structure.getActivityComponent(), e});     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        }

        public void onHandleAssistScreenshot(Bitmap screenshot) {
        }
    }

    static final class SaveResult {
        private boolean mLogSaveShown;
        private boolean mRemoveSession;
        private int mSaveDialogNotShowReason;

        SaveResult(boolean logSaveShown, boolean removeSession, int saveDialogNotShowReason) {
            this.mLogSaveShown = logSaveShown;
            this.mRemoveSession = removeSession;
            this.mSaveDialogNotShowReason = saveDialogNotShowReason;
        }

        public boolean isLogSaveShown() {
            return this.mLogSaveShown;
        }

        public void setLogSaveShown(boolean logSaveShown) {
            this.mLogSaveShown = logSaveShown;
        }

        public boolean isRemoveSession() {
            return this.mRemoveSession;
        }

        public void setRemoveSession(boolean removeSession) {
            this.mRemoveSession = removeSession;
        }

        public int getNoSaveUiReason() {
            return this.mSaveDialogNotShowReason;
        }

        public void setSaveDialogNotShowReason(int saveDialogNotShowReason) {
            this.mSaveDialogNotShowReason = saveDialogNotShowReason;
        }

        public String toString() {
            return "SaveResult: [logSaveShown=" + this.mLogSaveShown + ", removeSession=" + this.mRemoveSession + ", saveDialogNotShowReason=" + this.mSaveDialogNotShowReason + "]";
        }
    }

    private final class SessionFlags {
        private boolean mAugmentedAutofillOnly;
        private boolean mAutofillDisabled;
        private boolean mExpiredResponse;
        private boolean mFillDialogDisabled;
        private boolean mInlineSupportedByService;
        private boolean mScreenHasCredmanField;
        private boolean mShowingSaveUi;

        /* JADX INFO: renamed from: -$$Nest$fgetmAugmentedAutofillOnly, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2392$$Nest$fgetmAugmentedAutofillOnly(SessionFlags r0) {
            return r0.mAugmentedAutofillOnly;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmExpiredResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2393$$Nest$fgetmExpiredResponse(SessionFlags r0) {
            return r0.mExpiredResponse;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFillDialogDisabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2394$$Nest$fgetmFillDialogDisabled(SessionFlags r0) {
            return r0.mFillDialogDisabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInlineSupportedByService, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2395$$Nest$fgetmInlineSupportedByService(SessionFlags r0) {
            return r0.mInlineSupportedByService;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmScreenHasCredmanField, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2396$$Nest$fgetmScreenHasCredmanField(SessionFlags r0) {
            return r0.mScreenHasCredmanField;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShowingSaveUi, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2397$$Nest$fgetmShowingSaveUi(SessionFlags r0) {
            return r0.mShowingSaveUi;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAugmentedAutofillOnly, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2398$$Nest$fputmAugmentedAutofillOnly(SessionFlags r0, boolean r1) {
            r0.mAugmentedAutofillOnly = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAutofillDisabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2399$$Nest$fputmAutofillDisabled(SessionFlags r0, boolean r1) {
            r0.mAutofillDisabled = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmExpiredResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2400$$Nest$fputmExpiredResponse(SessionFlags r0, boolean r1) {
            r0.mExpiredResponse = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmFillDialogDisabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2401$$Nest$fputmFillDialogDisabled(SessionFlags r0, boolean r1) {
            r0.mFillDialogDisabled = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmInlineSupportedByService, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2402$$Nest$fputmInlineSupportedByService(SessionFlags r0, boolean r1) {
            r0.mInlineSupportedByService = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmScreenHasCredmanField, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2403$$Nest$fputmScreenHasCredmanField(SessionFlags r0, boolean r1) {
            r0.mScreenHasCredmanField = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmShowingSaveUi, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2404$$Nest$fputmShowingSaveUi(SessionFlags r0, boolean r1) {
            r0.mShowingSaveUi = r1;
        }

        /* synthetic */ SessionFlags(Session r1, SessionIA r2) {
            this(r1);
        }

        private SessionFlags(Session r1) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface SessionState {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ShowFillDialogState {
    }

    public static /* synthetic */ void $r8$lambda$0y215a1EU78SChzf8b3_hVgSeEo(Session r0, int r1, int r2) {
        r0.handleLogContextCommitted(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$FbsvPUWI2xE8TY4EgwSP_y3FnrU(Session r0, Consumer r1, int r2, InlineSuggestionsRequest r3) {
        r0.lambda$inlineSuggestionsRequestCacheDecorator$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$GJIY_txwAd6DOj-ST5MNqvqjpzM, reason: not valid java name */
    public static /* synthetic */ void m2338$r8$lambda$GJIY_txwAd6DOjST5MNqvqjpzM(Session r0) {
        r0.logSaveShown();
    }

    public static /* synthetic */ void $r8$lambda$MMPvmfECzqbJIa_uyV3zZlYxpcE(Session r0) {
        r0.removeFromService();
    }

    public static /* synthetic */ void $r8$lambda$Sn2jczMPhGLnGGz2COobcUk52MQ(Session r0, String r1, FillResponse r2, AutofillId r3, int r4) {
        r0.lambda$createFillDialogEvalRunnable$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$XTC9c8ILczzto9H1CCE47uucrrk(Session r0, FillResponse r1, int r2) {
        r0.onSecondaryFillResponse(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$aoiAlfqcqd3BR8Cp8JNfrlRKwO4(Session r0) {
        r0.lambda$setClientLocked$0();
    }

    public static /* synthetic */ void $r8$lambda$so1BZplX0oCazGmXB_3aZUQmB0w(Session r0, IntentSender r1, Intent r2) {
        r0.doStartIntentSender(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ze66iNuONRNDIcHL-_i0N5Hmag8, reason: not valid java name */
    public static /* synthetic */ void m2339$r8$lambda$ze66iNuONRNDIcHL_i0N5Hmag8(Session r0, int r1, IntentSender r2, Intent r3, boolean r4) {
        r0.startAuthentication(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m2340$$Nest$fgetmActivityToken(Session r0) {
        return r0.mActivityToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssistReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssistDataReceiverImpl m2341$$Nest$fgetmAssistReceiver(Session r0) {
        return r0.mAssistReceiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClassificationState, reason: not valid java name */
    static /* bridge */ /* synthetic */ ClassificationState m2342$$Nest$fgetmClassificationState(Session r0) {
        return r0.mClassificationState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAutoFillManagerClient m2343$$Nest$fgetmClient(Session r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientState, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m2344$$Nest$fgetmClientState(Session r0) {
        return r0.mClientState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientStateForSecondary, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m2345$$Nest$fgetmClientStateForSecondary(Session r0) {
        return r0.mClientStateForSecondary;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCompatMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2346$$Nest$fgetmCompatMode(Session r0) {
        return r0.mCompatMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m2347$$Nest$fgetmComponentName(Session r0) {
        return r0.mComponentName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContexts, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2348$$Nest$fgetmContexts(Session r0) {
        return r0.mContexts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentViewId, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillId m2349$$Nest$fgetmCurrentViewId(Session r0) {
        return r0.mCurrentViewId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDelayedFillPendingIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingIntent m2350$$Nest$fgetmDelayedFillPendingIntent(Session r0) {
        return r0.mDelayedFillPendingIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFillRequestEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ FillRequestEventLogger m2351$$Nest$fgetmFillRequestEventLogger(Session r0) {
        return r0.mFillRequestEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsPrimaryCredential, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2352$$Nest$fgetmIsPrimaryCredential(Session r0) {
        return r0.mIsPrimaryCredential;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLatencyBaseTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2353$$Nest$fgetmLatencyBaseTime(Session r2) {
        return r2.mLatencyBaseTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPresentationStatsEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ PresentationStatsEventLogger m2354$$Nest$fgetmPresentationStatsEventLogger(Session r0) {
        return r0.mPresentationStatsEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteFillService, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteFillService m2355$$Nest$fgetmRemoteFillService(Session r0) {
        return r0.mRemoteFillService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecondaryProviderHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ SecondaryProviderHandler m2356$$Nest$fgetmSecondaryProviderHandler(Session r0) {
        return r0.mSecondaryProviderHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillManagerServiceImpl m2357$$Nest$fgetmService(Session r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionFlags m2358$$Nest$fgetmSessionFlags(Session r0) {
        return r0.mSessionFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUrlBar, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssistStructure.ViewNode m2359$$Nest$fgetmUrlBar(Session r0) {
        return r0.mUrlBar;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmViewStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m2360$$Nest$fgetmViewStates(Session r0) {
        return r0.mViewStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmContexts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2361$$Nest$fputmContexts(Session r0, ArrayList r1) {
        r0.mContexts = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDelayedFillPendingIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2362$$Nest$fputmDelayedFillPendingIntent(Session r0, PendingIntent r1) {
        r0.mDelayedFillPendingIntent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFieldClassificationIdSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2363$$Nest$fputmFieldClassificationIdSnapshot(Session r0, int r1) {
        r0.mFieldClassificationIdSnapshot = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUrlBar, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2364$$Nest$fputmUrlBar(Session r0, AssistStructure.ViewNode r1) {
        r0.mUrlBar = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddCredentialManagerDataToClientState, reason: not valid java name */
    static /* bridge */ /* synthetic */ FillRequest m2365$$Nest$maddCredentialManagerDataToClientState(Session r0, FillRequest r1, InlineSuggestionsRequest r2, int r3) {
        return r0.addCredentialManagerDataToClientState(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelCurrentRequestLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2366$$Nest$mcancelCurrentRequestLocked(Session r0) {
        r0.cancelCurrentRequestLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mcreatePendingIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingIntent m2367$$Nest$mcreatePendingIntent(Session r0, int r1) {
        return r0.createPendingIntent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfillContextWithAllowedValuesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2368$$Nest$mfillContextWithAllowedValuesLocked(Session r0, FillContext r1, int r2) {
        r0.fillContextWithAllowedValuesLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTypeHintsForProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2369$$Nest$mgetTypeHintsForProvider(Session r0) {
        return r0.getTypeHintsForProvider();
    }

    /* JADX INFO: renamed from: -$$Nest$mmergePreviousSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2370$$Nest$mmergePreviousSessionLocked(Session r0, boolean r1) {
        return r0.mergePreviousSessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyFillUiHidden, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2371$$Nest$mnotifyFillUiHidden(Session r0, AutofillId r1) {
        r0.notifyFillUiHidden(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyFillUiShown, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2372$$Nest$mnotifyFillUiShown(Session r0, AutofillId r1) {
        r0.notifyFillUiShown(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monAugmentedAutofillErrorCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2373$$Nest$monAugmentedAutofillErrorCallback(Session r0) {
        r0.onAugmentedAutofillErrorCallback();
    }

    /* JADX INFO: renamed from: -$$Nest$monAugmentedAutofillInlineSuggestionAccept, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2374$$Nest$monAugmentedAutofillInlineSuggestionAccept(Session r0, InlineSuggestionsRequest r1, AutofillId r2, boolean r3, int r4, AutofillValue r5) {
        r0.onAugmentedAutofillInlineSuggestionAccept(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$monInputMethodStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2375$$Nest$monInputMethodStart(Session r0) {
        r0.onInputMethodStart();
    }

    /* JADX INFO: renamed from: -$$Nest$mwtf, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2376$$Nest$mwtf(Session r0, Exception r1, String r2, Object[] r3) {
        r0.wtf(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmRequestId, reason: not valid java name */
    static /* bridge */ /* synthetic */ RequestId m2377$$Nest$sfgetmRequestId() {
        return mRequestId;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsIdCounterForPcc, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m2378$$Nest$sfgetsIdCounterForPcc() {
        return sIdCounterForPcc;
    }

    /* JADX INFO: renamed from: -$$Nest$smlogIfSessionNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2379$$Nest$smlogIfSessionNull(Session r0, String r1) {
        return logIfSessionNull(r0, r1);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteFillService) r1);
    }

    static {
        mRequestId = new RequestId();
        sIdCounterForPcc = new AtomicInteger(2);
    }

    void onSwitchInputMethodLocked() {
        if (SessionFlags.m2393$$Nest$fgetmExpiredResponse(this.mSessionFlags) == false) goto L6;
        return;
    L6:
        if (shouldResetSessionStateOnInputMethodSwitch() == false) goto L11;
        SessionFlags.m2400$$Nest$fputmExpiredResponse(this.mSessionFlags, true);
        this.mAugmentedAutofillableIds = null;
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == false) goto L12;
        this.mCurrentViewId = null;
        return;
    L12:
        return;
    }

    private boolean shouldResetSessionStateOnInputMethodSwitch() {
        if (this.mService.getRemoteInlineSuggestionRenderServiceLocked() != null) goto L6;
        return false;
    L6:
        if (SessionFlags.m2395$$Nest$fgetmInlineSupportedByService(this.mSessionFlags) == false) goto L8;
        return true;
    L8:
        ViewState state = this.mViewStates.get(this.mCurrentViewId);
        if (state != null) goto L11;
    L13:
        return false;
    L11:
        if ((state.getState() & 4096) == 0) goto L13;
        return true;
    }

    protected void setShowingSavingUi(boolean val) {
        SessionFlags.m2404$$Nest$fputmShowingSaveUi(this.mSessionFlags, val);
    }

    private FillRequest addCredentialManagerDataToClientState(FillRequest pendingFillRequest, InlineSuggestionsRequest pendingInlineSuggestionsRequest, int sessionId) {
        if (pendingFillRequest.getClientState() != null) goto L6;
        pendingFillRequest = new FillRequest(pendingFillRequest.getId(), pendingFillRequest.getFillContexts(), pendingFillRequest.getHints(), new Bundle(), pendingFillRequest.getFlags(), pendingInlineSuggestionsRequest, pendingFillRequest.getDelayedFillIntentSender());
    L6:
        pendingFillRequest.getClientState().putInt(SESSION_ID_KEY, sessionId);
        pendingFillRequest.getClientState().putInt(REQUEST_ID_KEY, pendingFillRequest.getId());
        ResultReceiver resultReceiver = constructCredentialManagerCallback(pendingFillRequest.getId());
        pendingFillRequest.getClientState().putParcelable("android.credentials.AUTOFILL_RESULT_RECEIVER", resultReceiver);
        return pendingFillRequest;
    }

    private List<String> getTypeHintsForProvider() {
        if (this.mService.isPccClassificationEnabled() == false) goto L5;
        String typeHints = this.mService.getMaster().getPccProviderHints();
        if (Helper.sVerbose == false) goto L10;
        Slog.v(TAG, "TypeHints flag:" + typeHints);
    L10:
        if (TextUtils.isEmpty(typeHints) == false) goto L14;
        return new ArrayList();
    L14:
        return List.of(typeHints.split(PCC_HINTS_DELIMITER));
    L5:
        return Collections.EMPTY_LIST;
    }

    private PendingIntent createPendingIntent(int requestId) {
        Slog.d(TAG, "createPendingIntent for request " + requestId);
        long identity = Binder.clearCallingIdentity();
        Intent intent = new Intent(ACTION_DELAYED_FILL).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).putExtra(EXTRA_REQUEST_ID, requestId);     // Catch: Throwable -> L6
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, this.id, intent, 1375731712);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return pendingIntent;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void clearPendingIntentLocked() {
        Slog.d(TAG, "clearPendingIntentLocked");
        if (this.mDelayedFillPendingIntent != null) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mDelayedFillPendingIntent.cancel();     // Catch: Throwable -> L9
        this.mDelayedFillPendingIntent = null;     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void registerDelayedFillBroadcastLocked() {
        if (this.mDelayedFillBroadcastReceiverRegistered == true) goto L6;
        Slog.v(TAG, "registerDelayedFillBroadcastLocked()");
        IntentFilter intentFilter = new IntentFilter(ACTION_DELAYED_FILL);
        this.mContext.registerReceiver(this.mDelayedFillBroadcastReceiver, intentFilter);
        this.mDelayedFillBroadcastReceiverRegistered = true;
        return;
    }

    private void unregisterDelayedFillBroadcastLocked() {
        if (this.mDelayedFillBroadcastReceiverRegistered == false) goto L6;
        Slog.v(TAG, "unregisterDelayedFillBroadcastLocked()");
        this.mContext.unregisterReceiver(this.mDelayedFillBroadcastReceiver);
        this.mDelayedFillBroadcastReceiverRegistered = false;
        return;
    }

    private AutofillId[] getIdsOfAllViewStatesLocked() {
        int numViewState = this.mViewStates.size();
        AutofillId[] ids = new AutofillId[numViewState];
        int i = 0;
    L3:
        if (i >= numViewState) goto L6;
        ids[i] = this.mViewStates.valueAt(i).id;
        i = i + 1;
        goto L3
    L6:
        return ids;
    }

    public String findByAutofillId(AutofillId id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillValue value = findValueLocked(id);     // Catch: Throwable -> L11
        String r2 = null;
        if (value != null) goto L7;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L7:
        if (value.isText() == false) goto L14;
        String r3 = value.getTextValue().toString();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L14:
        if (value.isList() == false) goto L23;
        CharSequence[] options = getAutofillOptionsFromContextsLocked(id);     // Catch: Throwable -> L11
        if (options == null) goto L22;
        int index = value.getListValue();     // Catch: Throwable -> L11
        CharSequence option = options[index];     // Catch: Throwable -> L11
        if (option == null) goto L20;
        r2 = option.toString();     // Catch: Throwable -> L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L22:
        Slog.w(TAG, "findByAutofillId(): no autofill options for id " + id);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public AutofillValue findRawValueByAutofillId(AutofillId id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillValue r1 = findValueLocked(id);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private AutofillValue findValueLocked(AutofillId autofillId) {
        AutofillValue value = findValueFromThisSessionOnlyLocked(autofillId);
        if (value != null) goto L5;
        ArrayList<Session> previousSessions = this.mService.getPreviousSessionsLocked(this);
        if (previousSessions != null) goto L9;
        return null;
    L9:
        if (Helper.sDebug == false) goto L11;
        Slog.d(TAG, "findValueLocked(): looking on " + previousSessions.size() + " previous sessions for autofillId " + autofillId);
    L11:
        int i = 0;
    L13:
        if (i >= previousSessions.size()) goto L23;
        Session previousSession = previousSessions.get(i);
        AutofillValue previousValue = previousSession.findValueFromThisSessionOnlyLocked(autofillId);
        if (previousValue != null) goto L17;
        i = i + 1;
        goto L13
    L17:
        return getSanitizedValue(Helper.createSanitizers(previousSession.getSaveInfoLocked()), autofillId, previousValue);
    L23:
        return null;
    L5:
        return getSanitizedValue(Helper.createSanitizers(getSaveInfoLocked()), autofillId, value);
    }

    private AutofillValue findValueFromThisSessionOnlyLocked(AutofillId autofillId) {
        ViewState state = this.mViewStates.get(autofillId);
        if (state == null) goto L5;
        AutofillValue value = state.getCurrentValue();
        if (value != null) goto L12;
    L13:
        AutofillValue candidateSaveValue = state.getCandidateSaveValue();
        if (candidateSaveValue != null) goto L16;
    L21:
        if (value == null) goto L23;
        return value;
    L23:
        if (Helper.sDebug == false) goto L27;
        Slog.d(TAG, "findValueLocked(): no current value for " + autofillId + ", checking value from previous fill contexts");
        return getValueFromContextsLocked(autofillId);
    L27:
        return value;
    L16:
        if (candidateSaveValue.isEmpty() == true) goto L21;
        if (Helper.sDebug == false) goto L20;
        Slog.d(TAG, "findValueLocked(): current value for " + autofillId + " is empty, using candidateSaveValue instead.");
    L20:
        return candidateSaveValue;
    L12:
        if (value.isEmpty() == false) goto L21;
    L5:
        if (Helper.sDebug == false) goto L28;
        Slog.d(TAG, "findValueLocked(): no view state for " + autofillId);
        return null;
    L28:
        return null;
    }

    private void fillContextWithAllowedValuesLocked(FillContext fillContext, int flags) {
        AssistStructure.ViewNode[] nodes = fillContext.findViewNodesByAutofillIds(getIdsOfAllViewStatesLocked());
        int numViewState = this.mViewStates.size();
        int i = 0;
    L3:
        if (i >= numViewState) goto L24;
        ViewState viewState = this.mViewStates.valueAt(i);
        AssistStructure.ViewNode node = nodes[i];
        if (node == null) goto L7;
        AutofillValue currentValue = viewState.getCurrentValue();
        AutofillValue filledValue = viewState.getAutofilledValue();
        AssistStructure.AutofillOverlay overlay = new AssistStructure.AutofillOverlay();
        if (filledValue == null) goto L15;
        if (filledValue.equals(currentValue) == false) goto L15;
        overlay.value = currentValue;
    L15:
        if (this.mCurrentViewId == null) goto L21;
        overlay.focused = this.mCurrentViewId.equals(viewState.id);
        if (overlay.focused == false) goto L21;
        if ((flags & 1) == 0) goto L21;
        overlay.value = currentValue;
    L21:
        node.setAutofillOverlay(overlay);
    L22:
        i = i + 1;
        goto L3
    L7:
        if (Helper.sVerbose == false) goto L22;
        Slog.v(TAG, "fillContextWithAllowedValuesLocked(): no node for " + viewState.id);
        goto L22
    }

    private void cancelCurrentRequestLocked() {
        if (this.mRemoteFillService != null) goto L6;
        wtf(null, "cancelCurrentRequestLocked() called without a remote service. mForAugmentedAutofillOnly: %s", new Object[]{Boolean.valueOf(SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags))});
        return;
    L6:
        int canceledRequest = this.mRemoteFillService.cancelCurrentRequest();
        if (canceledRequest != Integer.MIN_VALUE) goto L9;
        return;
    L9:
        if (this.mContexts == null) goto L22;
        this.mFillResponseEventLogger.startLogForNewResponse();
        this.mFillResponseEventLogger.maybeSetRequestId(canceledRequest);
        this.mFillResponseEventLogger.maybeSetAppPackageUid(this.uid);
        this.mFillResponseEventLogger.maybeSetResponseStatus(3);
        this.mFillResponseEventLogger.maybeSetLatencyFillResponseReceivedMillis((int) (SystemClock.elapsedRealtime() - this.mLatencyBaseTime));
        this.mFillResponseEventLogger.logAndEndEvent();
        int numContexts = this.mContexts.size();
        int i = numContexts - 1;
    L11:
        if (i < 0) goto L24;
        if (this.mContexts.get(i).getRequestId() == canceledRequest) goto L15;
        i = i - 1;
        goto L11
    L15:
        if (Helper.sDebug == false) goto L17;
        Slog.d(TAG, "cancelCurrentRequest(): id = " + canceledRequest);
    L17:
        this.mContexts.remove(i);
        return;
    L24:
        return;
    }

    private boolean isViewFocusedLocked(int flags) {
        if ((flags & 16) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private Optional<Integer> requestNewFillResponseLocked(ViewState viewState, int newState, int flags) {
        boolean isSecondary = shouldRequestSecondaryProvider(flags);
        if (isSecondary == false) goto L5;
        FillResponse existingResponse = viewState.getSecondaryResponse();
    L6:
        this.mFillRequestEventLogger.startLogForNewRequest();
        this.mRequestCount++;
        this.mFillRequestEventLogger.maybeSetAppPackageUid(this.uid);
        this.mFillRequestEventLogger.maybeSetFlags(this.mFlags);
        if (this.mPreviouslyFillDialogPotentiallyStarted == false) goto L10;
        this.mFillRequestEventLogger.maybeSetRequestTriggerReason(3);
    L13:
        if (existingResponse == null) goto L15;
        setViewStatesLocked(existingResponse, 1, true, true);
        this.mFillRequestEventLogger.maybeSetRequestTriggerReason(5);
    L15:
        SessionFlags.m2400$$Nest$fputmExpiredResponse(this.mSessionFlags, false);
        this.mSessionState = 1;
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == true) goto L64;
        if (this.mRemoteFillService == null) goto L64;
        viewState.setState(newState);
        int requestId = mRequestId.nextId(isSecondary);
        int ordinal = this.mRequestLogs.size() + 1;
        LogMaker log = newLogMaker(907).addTaggedData(1454, Integer.valueOf(ordinal));
        if (flags == 0) goto L23;
        log.addTaggedData(1452, Integer.valueOf(flags));
    L23:
        this.mRequestLogs.put(requestId, log);
        if (Helper.sVerbose == false) goto L27;
        Slog.v(TAG, "Requesting structure for request #" + ordinal + " ,requestId=" + requestId + ", flags=" + flags);
    L27:
        if ((flags & 2048) != 0) goto L30;
    L30:
        this.mFillRequestEventLogger.maybeSetRequestId(requestId);
        this.mFillRequestEventLogger.maybeSetAutofillServiceUid(getAutofillServiceUid());
        this.mSaveEventLogger.maybeSetAutofillServiceUid(getAutofillServiceUid());
        this.mSessionCommittedEventLogger.maybeSetAutofillServiceUid(getAutofillServiceUid());
        if (SessionFlags.m2395$$Nest$fgetmInlineSupportedByService(this.mSessionFlags) == false) goto L33;
        this.mFillRequestEventLogger.maybeSetInlineSuggestionHostUid(this.mContext, this.userId);
    L33:
        this.mFillRequestEventLogger.maybeSetIsFillDialogEligible(!SessionFlags.m2394$$Nest$fgetmFillDialogDisabled(this.mSessionFlags));
        cancelCurrentRequestLocked();
        if (this.mService.isPccClassificationEnabled() == true) goto L36;
    L41:
        RemoteInlineSuggestionRenderService remoteRenderService = this.mService.getRemoteInlineSuggestionRenderServiceLocked();
        if (SessionFlags.m2395$$Nest$fgetmInlineSupportedByService(this.mSessionFlags) == false) goto L56;
        if (remoteRenderService == null) goto L56;
        if (isViewFocusedLocked(flags) == false) goto L47;
    L50:
        Consumer<InlineSuggestionsRequest> inlineSuggestionsRequestConsumer = this.mAssistReceiver.newAutofillRequestLocked(viewState, true);
        if (inlineSuggestionsRequestConsumer == null) goto L57;
        AutofillId focusedId = this.mCurrentViewId;
        WeakReference sessionWeakReference = new WeakReference(this);
        InlineSuggestionRendorInfoCallbackOnResultListener inlineSuggestionRendorInfoCallbackOnResultListener = new InlineSuggestionRendorInfoCallbackOnResultListener(sessionWeakReference, requestId, inlineSuggestionsRequestConsumer, focusedId);
        RemoteCallback inlineSuggestionRendorInfoCallback = new RemoteCallback(inlineSuggestionRendorInfoCallbackOnResultListener, this.mHandler);
        remoteRenderService.getInlineSuggestionsRendererInfo(inlineSuggestionRendorInfoCallback);
        viewState.setState(65536);
    L57:
        requestAssistStructureLocked(requestId, flags);
        if (this.mImproveFillDialogEnabled == false) goto L61;
        enableFillDialog();
    L61:
        return Optional.of(Integer.valueOf(requestId));
    L47:
        if (isRequestSupportFillDialog(flags) == true) goto L50;
    L56:
        this.mAssistReceiver.newAutofillRequestLocked(viewState, false);
        goto L57
    L36:
        if (ClassificationState.m2382$$Nest$fgetmHintsToAutofillIdMap(this.mClassificationState) != null) goto L41;
        if (Helper.sVerbose == false) goto L40;
        Slog.v(TAG, "triggering field classification");
    L40:
        requestAssistStructureForPccLocked(flags | 512);
    L64:
        if (Helper.sVerbose == false) goto L66;
        Slog.v(TAG, "requestNewFillResponse(): triggering augmented autofill instead (mForAugmentedAutofillOnly=" + SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) + ", flags=" + flags + ")");
    L66:
        SessionFlags.m2398$$Nest$fputmAugmentedAutofillOnly(this.mSessionFlags, true);
        this.mFillRequestEventLogger.maybeSetRequestId(1);
        this.mFillRequestEventLogger.maybeSetIsAugmented(true);
        this.mFillRequestEventLogger.logAndEndEvent();
        triggerAugmentedAutofillLocked(flags);
        return Optional.empty();
    L10:
        if ((flags & 1) == 0) goto L12;
        this.mFillRequestEventLogger.maybeSetRequestTriggerReason(1);
        goto L13
    L12:
        this.mFillRequestEventLogger.maybeSetRequestTriggerReason(4);
        goto L13
    L5:
        existingResponse = viewState.getResponse();
        goto L6
    }

    private boolean isRequestSupportFillDialog(int flags) {
        if ((flags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void requestAssistStructureForPccLocked(int flags) {
        if (ClassificationState.m2389$$Nest$mshouldTriggerRequest(this.mClassificationState) == true) goto L5;
        return;
    L5:
        this.mFillRequestIdSnapshot = sIdCounterForPcc.get();
        ClassificationState.m2390$$Nest$mupdatePendingRequest(this.mClassificationState);
    L6:
        int requestId = sIdCounterForPcc.getAndIncrement();
        if (requestId == Integer.MIN_VALUE) goto L6;
        if (Helper.sVerbose == false) goto L26;
        Slog.v(TAG, "request id is " + requestId + ", requesting assist structure for pcc");
    L26:
        Bundle receiverExtras = new Bundle();     // Catch: RemoteException -> L19
        receiverExtras.putInt(EXTRA_REQUEST_ID, requestId);     // Catch: RemoteException -> L19
        long identity = Binder.clearCallingIdentity();     // Catch: RemoteException -> L19
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: RemoteException -> L19
        throw th;     // Catch: RemoteException -> L19
    L13:
        if (ActivityTaskManager.getService().requestAutofillData(this.mPccAssistReceiver, receiverExtras, this.mActivityToken, flags) == true) goto L18;
        Slog.w(TAG, "failed to request autofill data for " + this.mActivityToken);     // Catch: Throwable -> L16
    L18:
        Binder.restoreCallingIdentity(identity);     // Catch: RemoteException -> L19
        return;
    }

    private void requestAssistStructureLocked(int requestId, int flags) {
        Bundle receiverExtras = new Bundle();     // Catch: RemoteException -> L10
        receiverExtras.putInt(EXTRA_REQUEST_ID, requestId);     // Catch: RemoteException -> L10
        long identity = Binder.clearCallingIdentity();     // Catch: RemoteException -> L10
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: RemoteException -> L10
        throw th;     // Catch: RemoteException -> L10
    L4:
        if (ActivityTaskManager.getService().requestAutofillData(this.mAssistReceiver, receiverExtras, this.mActivityToken, flags) == true) goto L9;
        Slog.w(TAG, "failed to request autofill data for " + this.mActivityToken);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(identity);     // Catch: RemoteException -> L10
        return;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    Session(com.android.server.autofill.AutofillManagerServiceImpl r19, com.android.server.autofill.ui.AutoFillUI r20, android.content.Context r21, android.os.Handler r22, int r23, java.lang.Object r24, int r25, int r26, int r27, android.os.IBinder r28, android.os.IBinder r29, boolean r30, android.util.LocalLog r31, android.util.LocalLog r32, android.content.ComponentName r33, android.content.ComponentName r34, boolean r35, boolean r36, boolean r37, int r38, com.android.server.inputmethod.InputMethodManagerInternal r39, boolean r40) {
        com.android.internal.logging.MetricsLogger r0 = new com.android.internal.logging.MetricsLogger();
        r18.mMetricsLogger = r0;
        r18.mSessionState = 0;
        android.util.ArrayMap<android.view.autofill.AutofillId, com.android.server.autofill.ViewState> r0 = new android.util.ArrayMap();
        r18.mViewStates = r0;
        r18.mFillRequestIdSnapshot = -2;
        r18.mFieldClassificationIdSnapshot = -2;
        android.util.SparseArray<android.metrics.LogMaker> r0 = new android.util.SparseArray(1);
        r18.mRequestLogs = r0;
        com.android.server.autofill.Session.AssistDataReceiverImpl r0 = new com.android.server.autofill.Session.AssistDataReceiverImpl(r18);
        r18.mAssistReceiver = r0;
        com.android.server.autofill.SessionIA r14 = null;
        com.android.server.autofill.Session.PccAssistDataReceiverImpl r0 = new com.android.server.autofill.Session.PccAssistDataReceiverImpl(r18, r14);
        r18.mPccAssistReceiver = r0;
        com.android.server.autofill.Session.ClassificationState r0 = new com.android.server.autofill.Session.ClassificationState(r14);
        r18.mClassificationState = r0;
        android.content.BroadcastReceiver r0 = new com.android.server.autofill.Session.AnonymousClass1(r18);
        r18.mDelayedFillBroadcastReceiver = r0;
        r18.mImeAnimationFinishTimeMs = -1;
        r18.mImeAnimationStartTimeMs = -1;
        r18.mLastInputStartTime = -1;
        java.lang.Object[] r2 = {r18};
        android.pico.utils.IExtBase r0 = android.pico.utils.ExtImplFactory.getImpl(com.android.server.autofill.IExtSession.class, r2);
        com.android.server.autofill.IExtSession r0 = (com.android.server.autofill.IExtSession) r0;
        r18.mExt = r0;
        if (r25 >= 0) goto L5;
        java.lang.Integer r2 = java.lang.Integer.valueOf(r25);
        java.lang.Object[] r2 = {r2};
        wtf(null, "Non-positive sessionId: %s", r2);
    L5:
        r18.id = r25;
        r18.mFlags = r38;
        r18.userId = r23;
        r18.taskId = r26;
        r18.uid = r27;
        r18.mService = r19;
        r18.mLock = r24;
        r18.mUi = r20;
        r18.mHandler = r22;
        android.content.ComponentName r0 = getCredentialAutofillService(r21);
        r18.mCredentialAutofillService = r0;
        if (r40 == false) goto L14;
        android.content.ComponentName r13 = r18.mCredentialAutofillService;
        if (r33 == null) goto L13;
        android.content.ComponentName r0 = r18.mCredentialAutofillService;
        boolean r0 = r33.equals(r0);
        if (r0 == true) goto L13;
        android.content.ComponentName r2 = r13;
        android.content.ComponentName r13 = r33;
    L15:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder();
        r1.append("Primary service component name: ");
        r1.append(r2);
        r1.append(", secondary service component name: ");
        r1.append(r13);
        java.lang.String r1 = r1.toString();
        android.util.Slog.v(com.android.server.autofill.Session.TAG, r1);
        if (r2 != null) goto L18;
        com.android.server.autofill.RemoteFillService r0 = null;
        android.content.ComponentName r16 = r2;
    L19:
        r4.mRemoteFillService = r0;
        if (r13 != null) goto L22;
        android.content.ComponentName r17 = r13;
        com.android.server.autofill.SecondaryProviderHandler r0 = null;
        android.content.Context r1 = r21;
    L23:
        r4.mSecondaryProviderHandler = r0;
        r4.mActivityToken = r28;
        r4.mHasCallback = r30;
        r4.mUiLatencyHistory = r31;
        r4.mWtfHistory = r32;
        java.lang.Object r0 = com.android.server.LocalServices.getService(com.android.server.wm.ActivityTaskManagerInternal.class);
        com.android.server.wm.ActivityTaskManagerInternal r0 = (com.android.server.wm.ActivityTaskManagerInternal) r0;
        int r5 = r0.getDisplayId(r28);
        android.content.Context r0 = com.android.server.autofill.Helper.getDisplayContext(r1, r5);
        r4.mContext = r0;
        r4.mComponentName = r34;
        r4.mCompatMode = r35;
        r4.mSessionState = 1;
        long r0 = android.os.SystemClock.elapsedRealtime();
        r4.mStartTime = r0;
        long r0 = r4.mStartTime;
        r4.mLatencyBaseTime = r0;
        r4.mRequestCount = 0;
        long r0 = r4.mLatencyBaseTime;
        com.android.server.autofill.PresentationStatsEventLogger r0 = com.android.server.autofill.PresentationStatsEventLogger.createPresentationLog(r25, r27, r0);
        r4.mPresentationStatsEventLogger = r0;
        com.android.server.autofill.FillRequestEventLogger r0 = com.android.server.autofill.FillRequestEventLogger.forSessionId(r25);
        r4.mFillRequestEventLogger = r0;
        com.android.server.autofill.FillResponseEventLogger r0 = com.android.server.autofill.FillResponseEventLogger.forSessionId(r25);
        r4.mFillResponseEventLogger = r0;
        com.android.server.autofill.SessionCommittedEventLogger r0 = com.android.server.autofill.SessionCommittedEventLogger.forSessionId(r25);
        r4.mSessionCommittedEventLogger = r0;
        com.android.server.autofill.SessionCommittedEventLogger r0 = r4.mSessionCommittedEventLogger;
        r0.maybeSetComponentPackageUid(r27);
        long r0 = r4.mLatencyBaseTime;
        com.android.server.autofill.SaveEventLogger r0 = com.android.server.autofill.SaveEventLogger.forSessionId(r25, r0);
        r4.mSaveEventLogger = r0;
        r4.mIsPrimaryCredential = r40;
        boolean r0 = android.view.autofill.AutofillFeatureFlags.shouldIgnoreViewStateResetToEmpty();
        r4.mIgnoreViewStateResetToEmpty = r0;
        boolean r0 = android.view.autofill.AutofillFeatureFlags.isImproveFillDialogEnabled();
        if (r0 == false) goto L26;
        boolean r0 = true;
    L27:
        r4.mImproveFillDialogEnabled = r0;
        long r0 = android.view.autofill.AutofillFeatureFlags.getFillDialogTimeoutMs();
        r4.mFillDialogTimeoutMs = r0;
        long r0 = android.view.autofill.AutofillFeatureFlags.getFillDialogMinWaitAfterImeAnimationtEndMs();
        r4.mFillDialogMinWaitAfterImeAnimationMs = r0;
        java.lang.Object r1 = r4.mLock;
        monitor-enter(r1);
        com.android.server.autofill.SessionIA r2 = null;
        com.android.server.autofill.Session.SessionFlags r0 = new com.android.server.autofill.Session.SessionFlags(r4, r2);     // Catch: java.lang.Throwable -> L33
        r4.mSessionFlags = r0;     // Catch: java.lang.Throwable -> L33
        com.android.server.autofill.Session.SessionFlags r0 = r4.mSessionFlags;     // Catch: java.lang.Throwable -> L33
        com.android.server.autofill.Session.SessionFlags.m2398$$Nest$fputmAugmentedAutofillOnly(r0, r37);     // Catch: java.lang.Throwable -> L33
        com.android.server.autofill.Session.SessionFlags r0 = r4.mSessionFlags;     // Catch: java.lang.Throwable -> L33
        com.android.server.autofill.AutofillManagerServiceImpl r2 = r4.mService;     // Catch: java.lang.Throwable -> L33
        boolean r2 = r2.isInlineSuggestionsEnabledLocked();     // Catch: java.lang.Throwable -> L33
        com.android.server.autofill.Session.SessionFlags.m2402$$Nest$fputmInlineSupportedByService(r0, r2);     // Catch: java.lang.Throwable -> L33
        setClientLocked(r29);     // Catch: java.lang.Throwable -> L33
        monitor-exit(r1);     // Catch: java.lang.Throwable -> L33
        java.lang.Object r5 = r4.mLock;
        com.android.server.autofill.ui.InlineFillUi.InlineUiEventCallback r6 = new com.android.server.autofill.Session.AnonymousClass2(r4);
        com.android.server.autofill.AutofillInlineSessionController r0 = new com.android.server.autofill.AutofillInlineSessionController(r39, r23, r34, r22, r5, r6);
        r4.mInlineSessionController = r0;
        com.android.internal.logging.MetricsLogger r0 = r4.mMetricsLogger;
        android.metrics.LogMaker r1 = newLogMaker(com.android.internal.util.FrameworkStatsLog.DEVICE_ORIENTATION_CHANGED);
        java.lang.Integer r2 = java.lang.Integer.valueOf(r38);
        android.metrics.LogMaker r1 = r1.addTaggedData(1452, r2);
        r0.write(r1);
        r18.mLogViewEntered = false;
        return;
    L33:
        r0 = move-exception;
    L41:
        throw r0;
    L37:
        r0 = move-exception;
        goto L41
    L26:
        r0 = false;
        goto L27
    L22:
        com.android.server.autofill.SecondaryProviderHandler.SecondaryProviderCallback r4 = new com.android.server.autofill.Session$$ExternalSyntheticLambda1(r4);
        android.content.ComponentName r6 = r4.mCredentialAutofillService;
        android.content.ComponentName r5 = r13;
        r1 = r21;
        r0 = new com.android.server.autofill.SecondaryProviderHandler(r1, r23, r36, r4, r5, r6);
        goto L23
    L18:
        android.content.ComponentName r6 = r18.mCredentialAutofillService;
        r0 = new com.android.server.autofill.RemoteFillService(r21, r2, r23, r18, r36, r6);
        android.content.ComponentName r16 = r2;
    L13:
        r2 = r13;
        r13 = null;
        goto L15
    L14:
        android.content.ComponentName r0 = r18.mCredentialAutofillService;
        r2 = r33;
        r13 = r0;
        goto L15
    }

    private ComponentName getCredentialAutofillService(Context context) {
        ComponentName componentName = null;
        String credentialManagerAutofillCompName = context.getResources().getString(R.string.config_dozeLongPressSensorType);
        if (credentialManagerAutofillCompName != null) goto L5;
    L7:
        if (componentName != null) goto L9;
        Slog.w(TAG, "Invalid CredentialAutofillService");
    L9:
        return componentName;
    L5:
        if (credentialManagerAutofillCompName.isEmpty() == true) goto L7;
        componentName = ComponentName.unflattenFromString(credentialManagerAutofillCompName);
        goto L7
    }

    IBinder getActivityTokenLocked() {
        return this.mActivityToken;
    }

    void switchActivity(IBinder newActivity, IBinder newClient) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#switchActivity() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mActivityToken = newActivity;     // Catch: Throwable -> L9
        setClientLocked(newClient);     // Catch: Throwable -> L9
        updateTrackedIdsLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void setClientLocked(IBinder client) {
        unlinkClientVultureLocked();
        this.mClient = IAutoFillManagerClient.Stub.asInterface(client);
        this.mClientVulture = new Session$$ExternalSyntheticLambda10(this);
        this.mClient.asBinder().linkToDeath(this.mClientVulture, 0);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "could not set binder death listener on autofill client: " + e);
        this.mClientVulture = null;
    }

    private /* synthetic */ void lambda$setClientLocked$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.d(TAG, "handling death of " + this.mActivityToken + " when saving=" + SessionFlags.m2397$$Nest$fgetmShowingSaveUi(this.mSessionFlags));     // Catch: Throwable -> L7
        if (SessionFlags.m2397$$Nest$fgetmShowingSaveUi(this.mSessionFlags) == false) goto L9;
        this.mUi.hideFillUi(this);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mUi.destroyAll(this.mPendingSaveUi, this, false);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void unlinkClientVultureLocked() {
        if (this.mClient != null) goto L5;
        return;
    L5:
        if (this.mClientVulture == null) goto L12;
        boolean unlinked = this.mClient.asBinder().unlinkToDeath(this.mClientVulture, 0);
        if (unlinked == true) goto L9;
        Slog.w(TAG, "unlinking vulture from death failed for " + this.mActivityToken);
    L9:
        this.mClientVulture = null;
        return;
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onFillRequestSuccess(int requestId, FillResponse response, String servicePackageName, int requestFlags) {
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mPresentationStatsEventLogger.maybeSetRequestId(requestId);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.startLogForNewResponse();     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetRequestId(requestId);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetAppPackageUid(this.uid);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(2);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.startResponseProcessingTime();     // Catch: Throwable -> L9
        long fillRequestReceivedRelativeTimestamp = SystemClock.elapsedRealtime() - this.mLatencyBaseTime;     // Catch: Throwable -> L9
        this.mPresentationStatsEventLogger.maybeSetFillResponseReceivedTimestampMs((int) fillRequestReceivedRelativeTimestamp);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetLatencyFillResponseReceivedMillis((int) fillRequestReceivedRelativeTimestamp);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetDetectionPreference(getDetectionPreferenceForLogging());     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L12;
        Slog.w(TAG, "Call to Session#onFillRequestSuccess() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(5);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L12:
        if (SessionFlags.m2397$$Nest$fgetmShowingSaveUi(this.mSessionFlags) == false) goto L16;
        Slog.w(TAG, "Call to Session#onFillRequestSuccess() rejected - session: " + this.id + " is showing saveUi");     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(5);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L16:
        LogMaker requestLog = this.mRequestLogs.get(requestId);     // Catch: Throwable -> L9
        if (requestLog == null) goto L19;
        requestLog.setType(10);     // Catch: Throwable -> L9
    L21:
        if (response != null) goto L28;
        this.mFillResponseEventLogger.maybeSetTotalDatasetsProvided(0);     // Catch: Throwable -> L9
        if (requestLog == null) goto L25;
        requestLog.addTaggedData(909, -1);     // Catch: Throwable -> L9
    L25:
        processNullResponseLocked(requestId, requestFlags);     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L28:
        AutofillId[] fieldClassificationIds = response.getFieldClassificationIds();     // Catch: Throwable -> L9
        if (fieldClassificationIds != null) goto L31;
    L35:
        this.mLastFillDialogTriggerIds = response.getFillDialogTriggerIds();     // Catch: Throwable -> L9
        if ((response.getFlags() & 4) == 0) goto L38;
        Slog.v(TAG, "Service requested to wait for delayed fill response.");     // Catch: Throwable -> L9
        registerDelayedFillBroadcastLocked();     // Catch: Throwable -> L9
    L38:
        this.mService.setLastResponseLocked(this.id, response);     // Catch: Throwable -> L9
        if (this.mLogViewEntered == false) goto L41;
        this.mLogViewEntered = false;     // Catch: Throwable -> L9
        this.mService.logViewEntered(this.id, null, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L9
    L41:
        monitor-exit(r5);     // Catch: Throwable -> L9
        long disableDuration = response.getDisableDuration();
        if (disableDuration <= 0) goto L45;
        boolean autofillDisabled = true;
    L46:
        if (autofillDisabled == false) goto L77;
        int flags = response.getFlags();
        if ((flags & 2) == 0) goto L50;
        boolean disableActivityOnly = true;
    L52:
        if (disableActivityOnly == false) goto L54;
        ComponentName r14 = this.mComponentName;
    L55:
        notifyDisableAutofillToClient(disableDuration, r14);
        if (disableActivityOnly == false) goto L58;
        this.mService.disableAutofillForActivity(this.mComponentName, disableDuration, this.id, this.mCompatMode);
        long disableDuration2 = disableDuration;
    L59:
        Object r6 = this.mLock;
        monitor-enter(r6);
        SessionFlags.m2399$$Nest$fputmAutofillDisabled(this.mSessionFlags, true);     // Catch: Throwable -> L66
        if (triggerAugmentedAutofillLocked(requestFlags) == null) goto L70;
        SessionFlags.m2398$$Nest$fputmAugmentedAutofillOnly(this.mSessionFlags, true);     // Catch: Throwable -> L66
        if (Helper.sDebug == false) goto L68;
        Slog.d(TAG, "Service disabled autofill for " + this.mComponentName + ", but session is kept for augmented autofill only");     // Catch: Throwable -> L66
    L68:
        monitor-exit(r6);     // Catch: Throwable -> L66
        return;
    L70:
        monitor-exit(r6);     // Catch: Throwable -> L66
        if (Helper.sDebug == false) goto L77;
        StringBuilder r0 = new StringBuilder("Service disabled autofill for ");
        r0.append(this.mComponentName);
        r0.append(": flags=");
        r0.append(flags);
        StringBuilder message = r0.append(", duration=");
        TimeUtils.formatDuration(disableDuration2, message);
        Slog.d(TAG, message.toString());
    L66:
        th = move-exception;
        throw th;
    L58:
        this.mService.disableAutofillForApp(this.mComponentName.getPackageName(), disableDuration, this.id, this.mCompatMode);
        disableDuration2 = disableDuration;
        goto L59
    L54:
        r14 = null;
        goto L55
    L50:
        disableActivityOnly = false;
    L77:
        List<Dataset> datasetList = response.getDatasets();
        if (datasetList == null) goto L82;
        if (datasetList.isEmpty() == true) goto L82;
    L83:
        if (autofillDisabled == false) goto L92;
    L85:
        if (autofillDisabled == false) goto L87;
        int r1 = 4;
    L88:
        notifyUnavailableToClient(r1, null);
        Object r9 = this.mLock;
        monitor-enter(r9);
        this.mInlineSessionController.setInlineFillUiLocked(InlineFillUi.emptyUi(this.mCurrentViewId));     // Catch: Throwable -> L111
        monitor-exit(r9);     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        throw th;
    L87:
        r1 = 0;
    L92:
        if (requestLog != null) goto L94;
    L100:
        if (datasetList != null) goto L102;
        int r10 = 0;
    L103:
        int datasetCount = r10;
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mFillResponseEventLogger.maybeSetTotalDatasetsProvided(datasetCount);     // Catch: Throwable -> L108
        this.mFillResponseEventLogger.maybeSetAvailableCount(datasetCount);     // Catch: Throwable -> L108
        processResponseLockedForPcc(response, response.getClientState(), requestFlags);     // Catch: Throwable -> L108
        this.mFillResponseEventLogger.maybeSetLatencyResponseProcessingMillis();     // Catch: Throwable -> L108
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L108
        monitor-exit(r11);     // Catch: Throwable -> L108
        return;
    L108:
        th = move-exception;
        throw th;
    L102:
        r10 = datasetList.size();
        goto L103
    L94:
        if (response.getDatasets() != null) goto L96;
        int r2 = 0;
    L97:
        requestLog.addTaggedData(909, Integer.valueOf(r2));
        if (fieldClassificationIds == null) goto L100;
        requestLog.addTaggedData(1271, Integer.valueOf(fieldClassificationIds.length));
        goto L100
    L96:
        r2 = response.getDatasets().size();
    L82:
        if (response.getAuthentication() == null) goto L85;
    L45:
        autofillDisabled = false;
        goto L46
    L31:
        if (this.mService.isFieldClassificationEnabledLocked() == true) goto L35;
        Slog.w(TAG, "Ignoring " + response + " because field detection is disabled");     // Catch: Throwable -> L9
        processNullResponseLocked(requestId, requestFlags);     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L19:
        Slog.w(TAG, "onFillRequestSuccess(): no request log for id " + requestId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void processResponseLockedForPcc(FillResponse response, Bundle newClientState, int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FillResponse response2 = getEffectiveFillResponse(response);     // Catch: Throwable -> L8
        if (isEmptyResponse(response2) == false) goto L14;
        if (response2 == null) goto L10;
        int r1 = response2.getRequestId();     // Catch: Throwable -> L8
    L11:
        processNullResponseLocked(r1, flags);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        r1 = 0;
        goto L11
    L14:
        processResponseLocked(response2, newClientState, flags);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isEmptyResponse(FillResponse response) {
        boolean r0 = true;
        if (response != null) goto L5;
        return true;
    L5:
        SaveInfo saveInfo = response.getSaveInfo();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (response.getDatasets() == null) goto L15;
        if (response.getDatasets().isEmpty() == true) goto L15;
    L26:
        r0 = false;
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return r0;
    L15:
        if (response.getAuthentication() != null) goto L26;
        if (saveInfo == null) goto L24;
        if (ArrayUtils.isEmpty(saveInfo.getOptionalIds()) == false) goto L26;
        if (ArrayUtils.isEmpty(saveInfo.getRequiredIds()) == false) goto L26;
        if ((saveInfo.getFlags() & 4) != 0) goto L26;
    L24:
        if (ArrayUtils.isEmpty(response.getFieldClassificationIds()) == false) goto L26;
        goto L26
    }

    private FillResponse getEffectiveFillResponse(FillResponse response) {
        SessionIA r1 = null;
        DatasetComputationContainer autofillProviderContainer = new DatasetComputationContainer(r1);
        computeDatasetsForProviderAndUpdateContainer(response, autofillProviderContainer);
        if (this.mService.isPccClassificationEnabled() == false) goto L5;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L20:
        th = move-exception;
        throw th;
    L12:
        if (ClassificationState.m2385$$Nest$fgetmState(this.mClassificationState) != 4) goto L42;
        if (ClassificationState.m2383$$Nest$fgetmLastFieldClassificationResponse(this.mClassificationState) == null) goto L42;
        if (ClassificationState.m2388$$Nest$mprocessResponse(this.mClassificationState) == true) goto L22;
        monitor-exit(r2);     // Catch: Throwable -> L20
        return response;
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L20
        boolean preferAutofillProvider = this.mService.getMaster().preferProviderOverPcc();
        boolean shouldUseFallback = this.mService.getMaster().shouldUsePccFallback();
        if (preferAutofillProvider == false) goto L31;
        if (shouldUseFallback == true) goto L31;
        if (Helper.sVerbose == false) goto L30;
        Slog.v(TAG, "preferAutofillProvider but no fallback");
    L30:
        return createShallowCopy(response, autofillProviderContainer);
    L31:
        DatasetComputationContainer detectionPccContainer = new DatasetComputationContainer(r1);
        computeDatasetsForPccAndUpdateContainer(response, detectionPccContainer);
        if (preferAutofillProvider == false) goto L36;
        DatasetComputationContainer resultContainer = autofillProviderContainer;
        if (shouldUseFallback == false) goto L40;
        addFallbackDatasets(autofillProviderContainer, detectionPccContainer);
    L40:
        return createShallowCopy(response, resultContainer);
    L36:
        resultContainer = detectionPccContainer;
        if (shouldUseFallback == false) goto L40;
        addFallbackDatasets(detectionPccContainer, autofillProviderContainer);
    L42:
        if (Helper.sVerbose == false) goto L51;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L20
        r3.append("PCC classification no last response:");     // Catch: Throwable -> L20
        boolean r6 = false;
        if (ClassificationState.m2383$$Nest$fgetmLastFieldClassificationResponse(this.mClassificationState) != null) goto L46;
        boolean r5 = true;
    L47:
        r3.append(r5);     // Catch: Throwable -> L20
        r3.append(" ,ineligible state=");     // Catch: Throwable -> L20
        if (ClassificationState.m2385$$Nest$fgetmState(this.mClassificationState) == 4) goto L50;
        r6 = true;
    L50:
        r3.append(r6);     // Catch: Throwable -> L20
        Slog.v(TAG, r3.toString());     // Catch: Throwable -> L20
        goto L51
    L46:
        r5 = false;
    L51:
        FillResponse r4 = createShallowCopy(response, autofillProviderContainer);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return r4;
    L5:
        if (Helper.sVerbose == false) goto L8;
        Slog.v(TAG, "PCC classification is disabled");
    L8:
        return createShallowCopy(response, autofillProviderContainer);
    }

    private void onSecondaryFillResponse(FillResponse fillResponse, int flags) {
        if (fillResponse != null) goto L4;
        return;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mFillResponseEventLogger.startLogForNewResponse();     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetRequestId(fillResponse.getRequestId());     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetAppPackageUid(this.uid);     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetResponseStatus(2);     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.startResponseProcessingTime();     // Catch: Throwable -> L11
        long fillRequestReceivedRelativeTimestamp = SystemClock.elapsedRealtime() - this.mLatencyBaseTime;     // Catch: Throwable -> L11
        this.mPresentationStatsEventLogger.maybeSetFillResponseReceivedTimestampMs((int) fillRequestReceivedRelativeTimestamp);     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetLatencyFillResponseReceivedMillis((int) fillRequestReceivedRelativeTimestamp);     // Catch: Throwable -> L11
        if (this.mDestroyed == false) goto L13;
        Slog.w(TAG, "Call to Session#onSecondaryFillResponse() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetResponseStatus(5);     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        List<Dataset> datasetList = fillResponse.getDatasets();     // Catch: Throwable -> L11
        if (datasetList != null) goto L16;
        int datasetCount = 0;
    L17:
        this.mFillResponseEventLogger.maybeSetTotalDatasetsProvided(datasetCount);     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.maybeSetAvailableCount(datasetCount);     // Catch: Throwable -> L11
        if (this.mSecondaryResponses != null) goto L20;
        this.mSecondaryResponses = new SparseArray(2);     // Catch: Throwable -> L11
    L20:
        this.mSecondaryResponses.put(fillResponse.getRequestId(), fillResponse);     // Catch: Throwable -> L11
        setViewStatesLocked(fillResponse, 2, false, false);     // Catch: Throwable -> L11
        ViewState currentView = this.mViewStates.get(this.mCurrentViewId);     // Catch: Throwable -> L11
        if (currentView == null) goto L23;
        currentView.maybeCallOnFillReady(flags);     // Catch: Throwable -> L11
    L23:
        this.mFillResponseEventLogger.maybeSetLatencyResponseProcessingMillis();     // Catch: Throwable -> L11
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        datasetCount = datasetList.size();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private FillResponse createShallowCopy(FillResponse response, DatasetComputationContainer container) {
        return FillResponse.shallowCopy(response, new ArrayList(container.mDatasets), getEligibleSaveInfo(response));
    }

    private SaveInfo getEligibleSaveInfo(FillResponse response) {
        SaveInfo saveInfo = response.getSaveInfo();
        if (saveInfo != null) goto L5;
    L45:
        return saveInfo;
    L5:
        if (ArrayUtils.isEmpty(saveInfo.getOptionalIds()) == false) goto L45;
        if (ArrayUtils.isEmpty(saveInfo.getRequiredIds()) == false) goto L45;
        if ((saveInfo.getFlags() & 4) != 0) goto L45;
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayMap<String, Set<AutofillId>> hintsToAutofillIdMap = ClassificationState.m2382$$Nest$fgetmHintsToAutofillIdMap(this.mClassificationState);     // Catch: Throwable -> L24
        if (hintsToAutofillIdMap == null) goto L41;
        if (hintsToAutofillIdMap.isEmpty() == true) goto L41;
        ArraySet<AutofillId> ids = new ArraySet();     // Catch: Throwable -> L24
        int saveType = saveInfo.getType();     // Catch: Throwable -> L24
        if (saveType != 0) goto L27;
        Iterator<Set<AutofillId>> r5 = hintsToAutofillIdMap.values().iterator();     // Catch: Throwable -> L24
    L22:
        if (r5.hasNext() == false) goto L35;
        ids.addAll(r5.next());     // Catch: Throwable -> L24
    L35:
        if (ids.isEmpty() == false) goto L38;
        monitor-exit(r1);     // Catch: Throwable -> L24
        return saveInfo;
    L38:
        AutofillId[] autofillIds = new AutofillId[ids.size()];     // Catch: Throwable -> L24
        this.mSaveEventLogger.maybeSetIsFrameworkCreatedSaveInfo(true);     // Catch: Throwable -> L24
        ids.toArray(autofillIds);     // Catch: Throwable -> L24
        SaveInfo r6 = SaveInfo.copy(saveInfo, autofillIds);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return r6;
    L27:
        Set<String> hints = HintsHelper.getHintsForSaveType(saveType);     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, Set<AutofillId>>> r7 = hintsToAutofillIdMap.entrySet().iterator();     // Catch: Throwable -> L24
    L29:
        if (r7.hasNext() == false) goto L35;
        Map.Entry<String, Set<AutofillId>> entry = r7.next();     // Catch: Throwable -> L24
        String hint = entry.getKey();     // Catch: Throwable -> L24
        if (hints.contains(hint) == false) goto L29;
        ids.addAll(entry.getValue());     // Catch: Throwable -> L24
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L24
        return saveInfo;
    L24:
        th = move-exception;
        throw th;
    }

    private void addFallbackDatasets(DatasetComputationContainer c1, DatasetComputationContainer c2) {
        Iterator<AutofillId> r0 = c2.mAutofillIds.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        AutofillId id = r0.next();
        if (c1.mAutofillIds.contains(id) == true) goto L4;
        if (c2.mAutofillIdToDatasetMap.get(id).isEmpty() == true) goto L9;
        Set<Dataset> datasets = c2.mAutofillIdToDatasetMap.get(id);
        Set<Dataset> copyDatasets = new LinkedHashSet(datasets);
        c1.mAutofillIds.add(id);
        c1.mAutofillIdToDatasetMap.put(id, copyDatasets);
        c1.mDatasets.addAll(copyDatasets);
        Iterator<Dataset> r4 = datasets.iterator();
    L12:
        if (r4.hasNext() == false) goto L4;
        Dataset dataset = r4.next();
        Iterator r6 = dataset.getFieldIds().iterator();
    L15:
        if (r6.hasNext() == false) goto L12;
        AutofillId currentId = (AutofillId) r6.next();
        if (currentId.equals(id) == true) goto L15;
        c2.mAutofillIdToDatasetMap.get(currentId).remove(dataset);
        goto L15
    L9:
        return;
    }

    private void computeDatasetsForProviderAndUpdateContainer(FillResponse response, DatasetComputationContainer container) {
        boolean isPccEnabled = this.mService.isPccClassificationEnabled();
        if (isPccEnabled == false) goto L5;
        int globalPickReason = 2;
    L6:
        List<Dataset> datasets = response.getDatasets();
        if (datasets != null) goto L9;
        return;
    L9:
        Map<AutofillId, Set<Dataset>> autofillIdToDatasetMap = new LinkedHashMap();
        Set<Dataset> eligibleDatasets = new LinkedHashSet();
        Set<AutofillId> eligibleAutofillIds = new LinkedHashSet();
        Iterator r8 = response.getDatasets().iterator();
    L11:
        if (r8.hasNext() == false) goto L52;
        Dataset dataset = (Dataset) r8.next();
        if (dataset.getFieldIds() == null) goto L11;
        if (dataset.getFieldIds().isEmpty() == true) goto L11;
        int pickReason = globalPickReason;
        if (dataset.getAutofillDatatypes() == null) goto L43;
        if (dataset.getAutofillDatatypes().isEmpty() == true) goto L43;
        boolean conversionRequired = false;
        int newSize = dataset.getFieldIds().size();
        Iterator r13 = dataset.getFieldIds().iterator();
    L23:
        if (r13.hasNext() == false) goto L28;
        if (((AutofillId) r13.next()) != null) goto L23;
        conversionRequired = true;
        newSize = newSize - 1;
        goto L23
    L28:
        if (newSize == 0) goto L11;
        if (conversionRequired == false) goto L43;
        int pickReason2 = 3;
        ArrayList<AutofillId> fieldIds = new ArrayList(newSize);
        ArrayList<AutofillValue> fieldValues = new ArrayList(newSize);
        ArrayList<RemoteViews> fieldPresentations = new ArrayList(newSize);
        ArrayList<RemoteViews> fieldDialogPresentations = new ArrayList(newSize);
        ArrayList<InlinePresentation> fieldInlinePresentations = new ArrayList(newSize);
        ArrayList<InlinePresentation> fieldInlineTooltipPresentations = new ArrayList(newSize);
        ArrayList<Dataset.DatasetFieldFilter> fieldFilters = new ArrayList(newSize);
        int i = 0;
    L32:
        int pickReason3 = pickReason2;
        if (i >= dataset.getFieldIds().size()) goto L39;
        AutofillId id = (AutofillId) dataset.getFieldIds().get(i);
        if (id == null) goto L38;
        fieldIds.add(id);
        fieldValues.add((AutofillValue) dataset.getFieldValues().get(i));
        fieldPresentations.add(dataset.getFieldPresentation(i));
        fieldDialogPresentations.add(dataset.getFieldDialogPresentation(i));
        fieldInlinePresentations.add(dataset.getFieldInlinePresentation(i));
        fieldInlineTooltipPresentations.add(dataset.getFieldInlineTooltipPresentation(i));
        fieldFilters.add(dataset.getFilter(i));
    L38:
        i = i + 1;
        pickReason2 = pickReason3;
        goto L32
    L39:
        dataset = new Dataset(fieldIds, fieldValues, fieldPresentations, fieldDialogPresentations, fieldInlinePresentations, fieldInlineTooltipPresentations, fieldFilters, new ArrayList(), dataset.getFieldContent(), null, null, null, null, dataset.getId(), dataset.getAuthentication());
        pickReason = pickReason3;
    L43:
        dataset.setEligibleReasonReason(pickReason);
        eligibleDatasets.add(dataset);
        Iterator r1 = dataset.getFieldIds().iterator();
    L45:
        if (r1.hasNext() == false) goto L50;
        AutofillId id2 = (AutofillId) r1.next();
        eligibleAutofillIds.add(id2);
        Set<Dataset> datasetForIds = autofillIdToDatasetMap.get(id2);
        if (datasetForIds != null) goto L49;
        datasetForIds = new LinkedHashSet();
    L49:
        datasetForIds.add(dataset);
        autofillIdToDatasetMap.put(id2, datasetForIds);
        goto L45
    L50:
        globalPickReason = globalPickReason;
        isPccEnabled = isPccEnabled;
        datasets = datasets;
        r8 = r8;
        goto L11
    L52:
        container.mAutofillIdToDatasetMap = autofillIdToDatasetMap;
        container.mDatasets = eligibleDatasets;
        container.mAutofillIds = eligibleAutofillIds;
        return;
    L5:
        globalPickReason = 1;
        goto L6
    }

    private void computeDatasetsForPccAndUpdateContainer(FillResponse response, DatasetComputationContainer container) {
        Session r1 = this;
        List<Dataset> datasets = response.getDatasets();
        if (datasets != null) goto L5;
        return;
    L5:
        Object r14 = r1.mLock;
        monitor-enter(r14);
        Map<String, Set<AutofillId>> hintsToAutofillIdMap = ClassificationState.m2382$$Nest$fgetmHintsToAutofillIdMap(r1.mClassificationState);     // Catch: Throwable -> L74
        Map<String, Set<AutofillId>> groupHintsToAutofillIdMap = ClassificationState.m2381$$Nest$fgetmGroupHintsToAutofillIdMap(r1.mClassificationState);     // Catch: Throwable -> L74
        Map<AutofillId, Set<Dataset>> map = new LinkedHashMap();     // Catch: Throwable -> L74
        Set<Dataset> eligibleDatasets = new LinkedHashSet();     // Catch: Throwable -> L74
        Set<AutofillId> eligibleAutofillIds = new LinkedHashSet();     // Catch: Throwable -> L74
        int i = 0;
    L8:
        if (i >= datasets.size()) goto L68;
        int pickReason = 4;
        Dataset dataset = datasets.get(i);     // Catch: Throwable -> L36
        if (dataset.getAutofillDatatypes() != null) goto L14;
        Map<String, Set<AutofillId>> hintsToAutofillIdMap2 = hintsToAutofillIdMap;
        Map<AutofillId, Set<Dataset>> map2 = map;
        int i2 = i;
        List<Dataset> datasets2 = datasets;
        Map<String, Set<AutofillId>> groupHintsToAutofillIdMap2 = groupHintsToAutofillIdMap;
        Set<AutofillId> eligibleAutofillIds2 = eligibleAutofillIds;
        Set<Dataset> eligibleDatasets2 = eligibleDatasets;
    L67:
        i = i2 + 1;
        r1 = this;
        map = map2;
        eligibleDatasets = eligibleDatasets2;
        eligibleAutofillIds = eligibleAutofillIds2;
        groupHintsToAutofillIdMap = groupHintsToAutofillIdMap2;
        datasets = datasets2;
        hintsToAutofillIdMap = hintsToAutofillIdMap2;
        goto L8
    L14:
        if (dataset.getAutofillDatatypes().isEmpty() == false) goto L16;
        hintsToAutofillIdMap2 = hintsToAutofillIdMap;
        map2 = map;
        i2 = i;
        datasets2 = datasets;
        groupHintsToAutofillIdMap2 = groupHintsToAutofillIdMap;
        eligibleAutofillIds2 = eligibleAutofillIds;
        eligibleDatasets2 = eligibleDatasets;
        goto L67
    L16:
        ArrayList<AutofillId> fieldIds = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<AutofillValue> fieldValues = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<RemoteViews> fieldPresentations = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<RemoteViews> fieldDialogPresentations = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<InlinePresentation> fieldInlinePresentations = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<InlinePresentation> fieldInlineTooltipPresentations = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<Dataset.DatasetFieldFilter> fieldFilters = new ArrayList();     // Catch: Throwable -> L36
        Set<AutofillId> datasetAutofillIds = new LinkedHashSet();     // Catch: Throwable -> L36
        Set<AutofillId> additionalDatasetAutofillIds = new LinkedHashSet();     // Catch: Throwable -> L36
        Set<AutofillId> additionalEligibleAutofillIds = new LinkedHashSet();     // Catch: Throwable -> L36
        boolean isDatasetAvailable = false;
        Set<Dataset> eligibleDatasets3 = eligibleDatasets;
        int j = 0;
    L17:
        Map<AutofillId, Set<Dataset>> map3 = map;
        if (j >= dataset.getAutofillDatatypes().size()) goto L53;
        if (dataset.getAutofillDatatypes().get(j) == null) goto L22;
        i = i;
        Dataset dataset2 = dataset;
        eligibleDatasets3 = eligibleDatasets3;
        ArrayList<AutofillId> fieldIds2 = fieldIds;
        ArrayList<RemoteViews> fieldPresentations2 = fieldPresentations;
        map3 = map3;
        Set<AutofillId> additionalEligibleAutofillIds2 = additionalEligibleAutofillIds;
        datasets = datasets;
        Set<AutofillId> additionalDatasetAutofillIds2 = additionalDatasetAutofillIds;
        groupHintsToAutofillIdMap = groupHintsToAutofillIdMap;
        eligibleAutofillIds = eligibleAutofillIds;
        String hint = (String) dataset2.getAutofillDatatypes().get(j);     // Catch: Throwable -> L34
        if (hintsToAutofillIdMap.containsKey(hint) == false) goto L51;
        Map<String, Set<AutofillId>> hintsToAutofillIdMap3 = hintsToAutofillIdMap;
        ArrayList<AutofillId> tempIds = new ArrayList(hintsToAutofillIdMap.get(hint));     // Catch: Throwable -> L34
        if (tempIds.isEmpty() == false) goto L46;
        int pickReason2 = pickReason;
        ArrayList<AutofillValue> fieldValues2 = fieldValues;
        Set<AutofillId> datasetAutofillIds2 = datasetAutofillIds;
    L52:
        j = j + 1;     // Catch: Throwable -> L34
        r1 = this;
        datasetAutofillIds = datasetAutofillIds2;
        fieldIds = fieldIds2;
        fieldValues = fieldValues2;
        fieldPresentations = fieldPresentations2;
        eligibleAutofillIds = eligibleAutofillIds;
        groupHintsToAutofillIdMap = groupHintsToAutofillIdMap;
        i = i;
        eligibleDatasets3 = eligibleDatasets3;
        hintsToAutofillIdMap = hintsToAutofillIdMap3;
        pickReason = pickReason2;
        dataset = dataset2;
        additionalDatasetAutofillIds = additionalDatasetAutofillIds2;
        datasets = datasets;
        map = map3;
        additionalEligibleAutofillIds = additionalEligibleAutofillIds2;
        goto L17
    L46:
        Iterator<AutofillId> r17 = tempIds.iterator();     // Catch: Throwable -> L34
    L48:
        if (r17.hasNext() == false) goto L50;
        AutofillId autofillId = r17.next();     // Catch: Throwable -> L34
        eligibleAutofillIds.add(autofillId);     // Catch: Throwable -> L34
        ArrayList<AutofillId> tempIds2 = tempIds;
        Set<AutofillId> datasetAutofillIds3 = datasetAutofillIds;
        datasetAutofillIds3.add(autofillId);     // Catch: Throwable -> L34
        int pickReason3 = pickReason;
        ArrayList<AutofillValue> fieldValues3 = fieldValues;
        copyFieldsFromDataset(dataset2, j, autofillId, fieldIds2, fieldValues3, fieldPresentations2, fieldDialogPresentations, fieldInlinePresentations, fieldInlineTooltipPresentations, fieldFilters);     // Catch: Throwable -> L34
        datasetAutofillIds = datasetAutofillIds3;
        hint = hint;
        tempIds = tempIds2;
        fieldValues = fieldValues3;
        pickReason = pickReason3;
        goto L48
    L50:
        pickReason2 = pickReason;
        fieldValues2 = fieldValues;
        datasetAutofillIds2 = datasetAutofillIds;
        isDatasetAvailable = true;
        goto L52
    L51:
        hintsToAutofillIdMap3 = hintsToAutofillIdMap;
        pickReason2 = pickReason;
        fieldValues2 = fieldValues;
        datasetAutofillIds2 = datasetAutofillIds;
        goto L52
    L22:
        if (dataset.getFieldIds() != null) goto L78;
    L28:
        int pickReason4 = pickReason;
    L29:
        AutofillId autofillId2 = (AutofillId) dataset.getFieldIds().get(j);     // Catch: Throwable -> L36
        if (ClassificationState.m2380$$Nest$fgetmClassificationCombinedHintsMap(r1.mClassificationState).containsKey(autofillId2) == true) goto L39;
        Set<AutofillId> additionalEligibleAutofillIds3 = additionalEligibleAutofillIds;
        additionalEligibleAutofillIds3.add(autofillId2);     // Catch: Throwable -> L36
        additionalDatasetAutofillIds2 = additionalDatasetAutofillIds;
        additionalDatasetAutofillIds2.add(autofillId2);     // Catch: Throwable -> L34
        additionalEligibleAutofillIds2 = additionalEligibleAutofillIds3;
        fieldIds2 = fieldIds;
        dataset2 = dataset;
        fieldPresentations2 = fieldPresentations;
        r1.copyFieldsFromDataset(dataset2, j, autofillId2, fieldIds2, fieldValues, fieldPresentations2, fieldDialogPresentations, fieldInlinePresentations, fieldInlineTooltipPresentations, fieldFilters);     // Catch: Throwable -> L34
    L40:
        hintsToAutofillIdMap3 = hintsToAutofillIdMap;
        fieldValues2 = fieldValues;
        pickReason2 = pickReason4;
        datasetAutofillIds2 = datasetAutofillIds;
    L34:
        th = th;
    L76:
        monitor-exit(r14);     // Catch: Throwable -> L72
        throw th;
    L39:
        fieldIds2 = fieldIds;
        additionalEligibleAutofillIds2 = additionalEligibleAutofillIds;
        additionalDatasetAutofillIds2 = additionalDatasetAutofillIds;
        dataset2 = dataset;
        fieldPresentations2 = fieldPresentations;
        goto L40
    L78:
        if (dataset.getFieldIds().get(j) == null) goto L28;
        pickReason4 = 5;
    L26:
        th = th;
        goto L76
    L53:
        hintsToAutofillIdMap2 = hintsToAutofillIdMap;
        i2 = i;
        int pickReason5 = pickReason;
        Dataset dataset3 = dataset;
        Set<Dataset> eligibleDatasets4 = eligibleDatasets3;
        ArrayList<AutofillId> fieldIds3 = fieldIds;
        ArrayList<AutofillValue> fieldValues4 = fieldValues;
        ArrayList<RemoteViews> fieldPresentations3 = fieldPresentations;
        Map<AutofillId, Set<Dataset>> map4 = map3;
        Set<AutofillId> datasetAutofillIds4 = datasetAutofillIds;
        Set<AutofillId> additionalEligibleAutofillIds4 = additionalEligibleAutofillIds;
        datasets2 = datasets;
        Set<AutofillId> additionalDatasetAutofillIds3 = additionalDatasetAutofillIds;
        groupHintsToAutofillIdMap2 = groupHintsToAutofillIdMap;
        eligibleAutofillIds2 = eligibleAutofillIds;
        if (isDatasetAvailable == false) goto L65;
        datasetAutofillIds4.addAll(additionalDatasetAutofillIds3);     // Catch: Throwable -> L34
        eligibleAutofillIds2.addAll(additionalEligibleAutofillIds4);     // Catch: Throwable -> L34
        Dataset newDataset = new Dataset(fieldIds3, fieldValues4, fieldPresentations3, fieldDialogPresentations, fieldInlinePresentations, fieldInlineTooltipPresentations, fieldFilters, new ArrayList(), dataset3.getFieldContent(), null, null, null, null, dataset3.getId(), dataset3.getAuthentication());     // Catch: Throwable -> L34
        int pickReason6 = pickReason5;
        newDataset.setEligibleReasonReason(pickReason6);     // Catch: Throwable -> L34
        eligibleDatasets2 = eligibleDatasets4;
        eligibleDatasets2.add(newDataset);     // Catch: Throwable -> L34
        Iterator<AutofillId> r16 = datasetAutofillIds4.iterator();     // Catch: Throwable -> L34
    L57:
        if (r16.hasNext() == false) goto L64;
        AutofillId autofillId3 = r16.next();     // Catch: Throwable -> L34
        Dataset dataset4 = dataset3;
        Set<AutofillId> datasetAutofillIds5 = datasetAutofillIds4;
        Map<AutofillId, Set<Dataset>> map5 = map4;
        if (map5.containsKey(autofillId3) == false) goto L61;
        Set<Dataset> newDatasets = map5.get(autofillId3);     // Catch: Throwable -> L34
    L62:
        newDatasets.add(newDataset);     // Catch: Throwable -> L34
        map5.put(autofillId3, newDatasets);     // Catch: Throwable -> L34
        map4 = map5;
        datasetAutofillIds4 = datasetAutofillIds5;
        dataset3 = dataset4;
        pickReason6 = pickReason6;
        goto L57
    L61:
        newDatasets = new LinkedHashSet();     // Catch: Throwable -> L34
        goto L62
    L64:
        map2 = map4;
        goto L67
    L65:
        map2 = map4;
        eligibleDatasets2 = eligibleDatasets4;
    L36:
        th = th;
        goto L76
    L68:
        Map<AutofillId, Set<Dataset>> map6 = map;
        Set<AutofillId> eligibleAutofillIds3 = eligibleAutofillIds;
        Set<Dataset> eligibleDatasets5 = eligibleDatasets;
        container.mAutofillIds = eligibleAutofillIds3;     // Catch: Throwable -> L72
        container.mDatasets = eligibleDatasets5;     // Catch: Throwable -> L72
        container.mAutofillIdToDatasetMap = map6;     // Catch: Throwable -> L72
        monitor-exit(r14);     // Catch: Throwable -> L72
        return;
    L72:
        th = th;
    L74:
        th = th;
        goto L76
    }

    private void copyFieldsFromDataset(Dataset dataset, int index, AutofillId autofillId, ArrayList<AutofillId> fieldIds, ArrayList<AutofillValue> fieldValues, ArrayList<RemoteViews> fieldPresentations, ArrayList<RemoteViews> fieldDialogPresentations, ArrayList<InlinePresentation> fieldInlinePresentations, ArrayList<InlinePresentation> fieldInlineTooltipPresentations, ArrayList<Dataset.DatasetFieldFilter> fieldFilters) {
        fieldIds.add(autofillId);
        fieldValues.add((AutofillValue) dataset.getFieldValues().get(index));
        fieldPresentations.add(dataset.getFieldPresentation(index));
        fieldDialogPresentations.add(dataset.getFieldDialogPresentation(index));
        fieldInlinePresentations.add(dataset.getFieldInlinePresentation(index));
        fieldInlineTooltipPresentations.add(dataset.getFieldInlineTooltipPresentation(index));
        fieldFilters.add(dataset.getFilter(index));
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onFillRequestFailure(int requestId, Throwable t) {
        CharSequence message = t.getMessage();
        boolean timedOut = t instanceof TimeoutException;
        boolean showMessage = !TextUtils.isEmpty(message);
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mFillResponseEventLogger.startLogForNewResponse();     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetRequestId(requestId);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetAppPackageUid(this.uid);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetAvailableCount(-1);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetTotalDatasetsProvided(-1);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetDetectionPreference(getDetectionPreferenceForLogging());     // Catch: Throwable -> L9
        long fillRequestReceivedRelativeTimestamp = SystemClock.elapsedRealtime() - this.mLatencyBaseTime;     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetLatencyFillResponseReceivedMillis((int) fillRequestReceivedRelativeTimestamp);     // Catch: Throwable -> L9
        unregisterDelayedFillBroadcastLocked();     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L12;
        Slog.w(TAG, "Call to Session#onFillRequestFailureOrTimeout(req=" + requestId + ") rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(5);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        return;
    L12:
        if (Helper.sDebug == false) goto L18;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L9
        r12.append("finishing session due to service ");     // Catch: Throwable -> L9
        if (timedOut == false) goto L16;
        String r13 = "timeout";
    L17:
        r12.append(r13);     // Catch: Throwable -> L9
        Slog.d(TAG, r12.toString());     // Catch: Throwable -> L9
        goto L18
    L16:
        r13 = "failure";
    L18:
        this.mService.resetLastResponse();     // Catch: Throwable -> L9
        this.mLastFillDialogTriggerIds = null;     // Catch: Throwable -> L9
        LogMaker requestLog = this.mRequestLogs.get(requestId);     // Catch: Throwable -> L9
        if (requestLog != null) goto L21;
        Slog.w(TAG, "onFillRequestFailureOrTimeout(): no log for id " + requestId);     // Catch: Throwable -> L9
    L25:
        if (showMessage == false) goto L32;
        int targetSdk = this.mService.getTargedSdkLocked();     // Catch: Throwable -> L9
        if (targetSdk < 29) goto L29;
        showMessage = false;
        Slog.w(TAG, "onFillRequestFailureOrTimeout(): not showing '" + message + "' because service's targeting API " + targetSdk);     // Catch: Throwable -> L9
    L29:
        if (message == null) goto L32;
        requestLog.addTaggedData(1572, Integer.valueOf(message.length()));     // Catch: Throwable -> L9
    L32:
        if ((t instanceof TimeoutException) == false) goto L35;
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(5);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(4);     // Catch: Throwable -> L9
    L38:
        this.mPresentationStatsEventLogger.logAndEndEvent("fill request failure");     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetLatencyResponseProcessingMillis();     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        notifyUnavailableToClient(6, null);
        if (showMessage == false) goto L43;
        getUiForShowing().showError(message, this);
    L43:
        removeFromService();
        return;
    L35:
        if ((t instanceof TransactionTooLargeException) == false) goto L37;
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(7);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(6);     // Catch: Throwable -> L9
        goto L38
    L37:
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(7);     // Catch: Throwable -> L9
        this.mFillResponseEventLogger.maybeSetResponseStatus(1);     // Catch: Throwable -> L9
        goto L38
    L21:
        if (timedOut == false) goto L23;
        int r14 = 2;
    L24:
        requestLog.setType(r14);     // Catch: Throwable -> L9
        goto L25
    L23:
        r14 = 11;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onSaveRequestSuccess(String servicePackageName, IntentSender intentSender) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SessionFlags.m2404$$Nest$fputmShowingSaveUi(this.mSessionFlags, false);     // Catch: Throwable -> L9
        int r2 = 1;
        this.mSaveEventLogger.maybeSetIsSaved(true);     // Catch: Throwable -> L9
        this.mSaveEventLogger.maybeSetLatencySaveFinishMillis();     // Catch: Throwable -> L9
        this.mSaveEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#onSaveRequestSuccess() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        LogMaker r1 = newLogMaker(918, servicePackageName);
        if (intentSender != null) goto L16;
        r2 = 10;
    L16:
        LogMaker log = r1.setType(r2);
        this.mMetricsLogger.write(log);
        if (intentSender != null) goto L19;
    L22:
        removeFromService();
        return;
    L19:
        if (Helper.sDebug == false) goto L21;
        Slog.d(TAG, "Starting intent sender on save()");
    L21:
        startIntentSenderAndFinishSession(intentSender);
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onSaveRequestFailure(CharSequence message, String servicePackageName) {
        boolean showMessage = !TextUtils.isEmpty(message);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SessionFlags.m2404$$Nest$fputmShowingSaveUi(this.mSessionFlags, false);     // Catch: Throwable -> L9
        this.mSaveEventLogger.maybeSetLatencySaveFinishMillis();     // Catch: Throwable -> L9
        this.mSaveEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#onSaveRequestFailure() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        if (showMessage == false) goto L15;
        int targetSdk = this.mService.getTargedSdkLocked();     // Catch: Throwable -> L9
        if (targetSdk < 29) goto L15;
        showMessage = false;
        Slog.w(TAG, "onSaveRequestFailure(): not showing '" + message + "' because service's targeting API " + targetSdk);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L9
        LogMaker log = newLogMaker(918, servicePackageName).setType(11);
        if (message == null) goto L19;
        log.addTaggedData(1572, Integer.valueOf(message.length()));
    L19:
        this.mMetricsLogger.write(log);
        if (showMessage == false) goto L22;
        getUiForShowing().showError(message, this);
    L22:
        removeFromService();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onConvertCredentialRequestSuccess(ConvertCredentialResponse convertCredentialResponse) {
        Dataset dataset = convertCredentialResponse.getDataset();
        Bundle clientState = convertCredentialResponse.getClientState();
        if (dataset == null) goto L9;
        int requestId = -1;
        if (clientState == null) goto L7;
        requestId = clientState.getInt("android.view.autofill.extra.AUTOFILL_REQUEST_ID");
    L8:
        fill(requestId, -1, dataset, 4);
        return;
    L7:
        Slog.e(TAG, "onConvertCredentialRequestSuccess(): client state is null, this would cause loss in logging.");
        goto L8
    L9:
        Slog.e(TAG, "onConvertCredentialRequestSuccess(): dataset inside response is null");
    }

    private FillContext getFillContextByRequestIdLocked(int requestId) {
        if (this.mContexts != null) goto L5;
        return null;
    L5:
        int numContexts = this.mContexts.size();
        int i = 0;
    L6:
        if (i >= numContexts) goto L12;
        FillContext context = this.mContexts.get(i);
        if (context.getRequestId() == requestId) goto L9;
        i = i + 1;
        goto L6
    L9:
        return context;
    L12:
        return null;
    }

    public void onServiceDied(RemoteFillService service) {
        Slog.w(TAG, "removing session because service died");
        Object r0 = this.mLock;
        monitor-enter(r0);
        forceRemoveFromServiceLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void authenticate(int requestId, int datasetIndex, IntentSender intent, Bundle extras, int uiType) {
        if (Helper.sDebug == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("authenticate(): requestId=");
        r2.append(requestId);
        r2.append("; datasetIdx=");
        r2.append(datasetIndex);
        r2.append("; intentSender=");
        IntentSender r3 = intent;
        r2.append(r3);
        Slog.d(TAG, r2.toString());
    L6:
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mPresentationStatsEventLogger.maybeSetAuthenticationType(2);     // Catch: Throwable -> L13
        if (this.mDestroyed == false) goto L39;
        Slog.w(TAG, "Call to Session#authenticate() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        return;
    L39:
        Intent fillInIntent = createAuthFillInIntentLocked(requestId, extras);     // Catch: Throwable -> L22
        if (fillInIntent != null) goto L26;
        forceRemoveFromServiceLocked();     // Catch: Throwable -> L22
        monitor-exit(r4);     // Catch: Throwable -> L22
        return;
    L26:
        this.mService.setAuthenticationSelected(this.id, this.mClientState, uiType, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L34
        monitor-exit(r4);     // Catch: Throwable -> L22
        int authenticationId = AutofillManager.makeAuthenticationId(requestId, datasetIndex);
        Handler r10 = this.mHandler;
        QuintConsumer r0 = new Session$$ExternalSyntheticLambda11();
        Integer r5 = Integer.valueOf(authenticationId);
        if (uiType != 2) goto L31;
        boolean r6 = true;
    L32:
        r10.sendMessage(PooledLambda.obtainMessage(r0, this, r5, r3, fillInIntent, Boolean.valueOf(r6)));
        return;
    L31:
        r6 = false;
    L22:
        th = th;
    L35:
        monitor-exit(r4);     // Catch: Throwable -> L34
        throw th;
    L34:
        th = th;
    L13:
        th = th;
        goto L35
    L5:
        r3 = intent;
        goto L6
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void fill(int requestId, int datasetIndex, Dataset dataset, int uiType) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L18
        throw th;
    L18:
        th = th;
        goto L20
    L5:
        if (this.mDestroyed == true) goto L22;
        monitor-exit(r1);     // Catch: Throwable -> L14
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda6(), this, Integer.valueOf(requestId), Integer.valueOf(datasetIndex), dataset, true, Integer.valueOf(uiType)));
        return;
    L22:
        Slog.w(TAG, "Call to Session#fill() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L20
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void save() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#save() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mSaveEventLogger.maybeSetLatencySaveRequestMillis();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda2(), this.mService, this));
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void cancelSave() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SessionFlags.m2404$$Nest$fputmShowingSaveUi(this.mSessionFlags, false);     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#cancelSave() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda7(), this));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void onShown(int uiType, int numDatasetsShown) {
        Object r7 = this.mLock;
        monitor-enter(r7);
        this.mPresentationStatsEventLogger.maybeSetDisplayPresentationType(uiType);     // Catch: Throwable -> L9
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(1);     // Catch: Throwable -> L9
        if (uiType != 2) goto L12;
        this.mPresentationStatsEventLogger.maybeIncrementCountShown();     // Catch: Throwable -> L9
        if (this.mLoggedInlineDatasetShown == true) goto L11;
        this.mService.logDatasetShown(this.id, this.mClientState, uiType, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L9
        Slog.d(TAG, "onShown(): " + uiType + ", " + numDatasetsShown);     // Catch: Throwable -> L9
    L11:
        this.mLoggedInlineDatasetShown = true;     // Catch: Throwable -> L9
    L13:
        monitor-exit(r7);     // Catch: Throwable -> L9
        return;
    L12:
        this.mPresentationStatsEventLogger.logWhenDatasetShown(numDatasetsShown);     // Catch: Throwable -> L9
        this.mPresentationStatsEventLogger.maybeSetSuggestionPresentedTimestampMs();     // Catch: Throwable -> L9
        this.mService.logDatasetShown(this.id, this.mClientState, uiType, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L9
        Slog.d(TAG, "onShown(): " + uiType + ", " + numDatasetsShown);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void requestShowFillUi(AutofillId id, int width, int height, IAutofillWindowPresenter presenter) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L21:
        th = th;
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L17
        throw th;
    L5:
        if (this.mDestroyed == false) goto L12;
        Slog.w(TAG, "Call to Session#requestShowFillUi() rejected - session: " + id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L32
    L12:
        if (id.equals(this.mCurrentViewId) == false) goto L28;
        ViewState view = this.mViewStates.get(id);     // Catch: Throwable -> L21 RemoteException -> L23
    L36:
        this.mClient.requestShowFillUi(this.id, id, width, height, view.getVirtualBounds(), presenter);     // Catch: Throwable -> L17 RemoteException -> L19
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L19:
        e = move-exception;
        RemoteException e = e;
    L26:
        Slog.e(TAG, "Error requesting to show fill UI", e);     // Catch: Throwable -> L17
    L23:
        e = move-exception;
        e = e;
        goto L26
    L28:
        if (Helper.sDebug == false) goto L30;
        Slog.d(TAG, "Do not show full UI on " + id + " as it is not the current view (" + this.mCurrentViewId + ") anymore");     // Catch: Throwable -> L17
    L17:
        th = th;
        goto L32
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void dispatchUnhandledKey(AutofillId id, KeyEvent keyEvent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L12;
        Slog.w(TAG, "Call to Session#dispatchUnhandledKey() rejected - session: " + id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (id.equals(this.mCurrentViewId) == true) goto L23;
        Slog.w(TAG, "Do not dispatch unhandled key on " + id + " as it is not the current view (" + this.mCurrentViewId + ") anymore");     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L23:
        this.mClient.dispatchUnhandledKey(this.id, id, keyEvent);     // Catch: Throwable -> L9 RemoteException -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "Error requesting to dispatch unhandled key", e);     // Catch: Throwable -> L9
        goto L18
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void requestHideFillUi(AutofillId id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClient.requestHideFillUi(this.id, id);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(id);     // Catch: Throwable -> L6
        this.mPresentationStatsEventLogger.markShownCountAsResettable();     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error requesting to hide fill UI", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void requestHideFillUiWhenDestroyed(AutofillId id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClient.requestHideFillUiWhenDestroyed(this.id, id);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(id);     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error requesting to hide fill UI", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void cancelSession() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeFromServiceLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void startIntentSenderAndFinishSession(IntentSender intentSender) {
        startIntentSender(intentSender, null);
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void startIntentSender(IntentSender intentSender, Intent intent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#startIntentSender() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        if (intent != null) goto L13;
        removeFromServiceLocked();     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda5(), this, intentSender, intent));
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void requestShowSoftInput(AutofillId id) {
        IAutoFillManagerClient client = getClient();
        if (client == null) goto L11;
        client.requestShowSoftInput(id);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Error sending input show up notification", e);
        return;
    }

    @Override // com.android.server.autofill.ui.AutoFillUI.AutoFillUiCallback
    public void requestFallbackFromFillDialog() {
        setFillDialogDisabled();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentViewId != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPresentationStatsEventLogger.logAndEndEvent("fallback from fill dialog");     // Catch: Throwable -> L8
        startNewEventForPresentationStatsEventLogger();     // Catch: Throwable -> L8
        ViewState currentView = this.mViewStates.get(this.mCurrentViewId);     // Catch: Throwable -> L8
        logPresentationStatsOnViewEnteredLocked(currentView.getResponse(), false);     // Catch: Throwable -> L8
        currentView.maybeCallOnFillReady(this.mFlags);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void notifyFillUiHidden(AutofillId autofillId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClient.notifyFillUiHidden(this.id, autofillId);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error sending fill UI hidden notification", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void notifyFillUiShown(AutofillId autofillId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClient.notifyFillUiShown(this.id, autofillId);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error sending fill UI shown notification", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void onInputMethodStart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastInputStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void doStartIntentSender(IntentSender intentSender, Intent intent) {
        Object r0 = this.mLock;     // Catch: RemoteException -> L10
        monitor-enter(r0);     // Catch: RemoteException -> L10
        this.mClient.startIntentSender(intentSender, intent);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    L16:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Error launching auth intent", e);
    }

    void setAuthenticationResultLocked(Bundle data, int authenticationId) {
        if (this.mDestroyed == false) goto L7;
        Slog.w(TAG, "Call to Session#setAuthenticationResultLocked() rejected - session: " + this.id + " destroyed");
        return;
    L7:
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "setAuthenticationResultLocked(): id= " + authenticationId + ", data=" + data);
    L9:
        int requestId = AutofillManager.getRequestIdFromAuthenticationId(authenticationId);
        if (requestId != 1) goto L14;
        setAuthenticationResultForAugmentedAutofillLocked(data, authenticationId);
        this.mPresentationStatsEventLogger.logAndEndEvent("authentication - augmented");
        return;
    L14:
        if (this.mResponses != null) goto L18;
        Slog.w(TAG, "setAuthenticationResultLocked(" + authenticationId + "): no responses");
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(2);
        this.mPresentationStatsEventLogger.logAndEndEvent("authentication - no response");
        removeFromService();
        return;
    L18:
        if (RequestId.isSecondaryProvider(requestId) == false) goto L20;
        FillResponse r4 = this.mSecondaryResponses.get(requestId);
    L21:
        FillResponse authenticatedResponse = r4;
        if (authenticatedResponse == null) goto L89;
        if (data == null) goto L89;
        int datasetIdx = AutofillManager.getDatasetIdFromAuthenticationId(authenticationId);
        Dataset dataset = null;
        if (datasetIdx == 65535) goto L31;
        dataset = (Dataset) authenticatedResponse.getDatasets().get(datasetIdx);
        if (dataset != null) goto L31;
        Slog.w(TAG, "no dataset with index " + datasetIdx + " on fill response");
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(2);
        this.mPresentationStatsEventLogger.logAndEndEvent("authentication - no datasets");
        removeFromService();
        return;
    L31:
        SessionFlags.m2400$$Nest$fputmExpiredResponse(this.mSessionFlags, false);
        Parcelable result = data.getParcelable("android.view.autofill.extra.AUTHENTICATION_RESULT");
        GetCredentialException exception = (GetCredentialException) data.getSerializable("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", GetCredentialException.class);
        Bundle newClientState = data.getBundle("android.view.autofill.extra.CLIENT_STATE");
        if (Helper.sDebug == false) goto L35;
        Slog.d(TAG, "setAuthenticationResultLocked(): result=" + result + ", clientState=" + newClientState + ", authenticationId=" + authenticationId);
    L35:
        if (exception == null) goto L47;
        if (exception.getType().equals("android.credentials.GetCredentialException.TYPE_USER_CANCELED") == true) goto L47;
        if (dataset != null) goto L40;
        return;
    L40:
        if (dataset.getFieldIds().size() == 1) goto L42;
        return;
    L42:
        if (Helper.sDebug == false) goto L44;
        Slog.d(TAG, "setAuthenticationResultLocked(): result returns withCredential Manager Exception");
    L44:
        sendCredentialManagerResponseToApp(null, exception, (AutofillId) dataset.getFieldIds().get(0));
        return;
    L47:
        if ((result instanceof FillResponse) == false) goto L53;
        if (Helper.sDebug == false) goto L51;
        Slog.d(TAG, "setAuthenticationResultLocked(): received FillResponse from authentication flow");
    L51:
        logAuthenticationStatusLocked(requestId, FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_720P_HD_ALMOST);
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(1);
        replaceResponseLocked(authenticatedResponse, (FillResponse) result, newClientState);
        return;
    L53:
        if ((result instanceof GetCredentialResponse) == false) goto L67;
        if (Helper.sDebug == false) goto L57;
        Slog.d(TAG, "Received GetCredentialResponse from authentication flow");
    L57:
        GetCredentialResponse response = (GetCredentialResponse) result;
        if (dataset == null) goto L94;
        if (dataset.getFieldIds().size() != 1) goto L94;
        AutofillId autofillId = (AutofillId) dataset.getFieldIds().get(0);
        if (Helper.sDebug == false) goto L64;
        Slog.d(TAG, "Received GetCredentialResponse from authentication flow,for autofillId: " + autofillId);
    L64:
        sendCredentialManagerResponseToApp(response, null, autofillId);
    L94:
        return;
    L67:
        if ((result instanceof Dataset) == false) goto L85;
        if (Helper.sDebug == false) goto L72;
        Slog.d(TAG, "setAuthenticationResultLocked(): received Dataset from authentication flow");
    L72:
        if (datasetIdx == 65535) goto L83;
        logAuthenticationStatusLocked(requestId, 1126);
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(1);
        if (newClientState != null) goto L76;
    L79:
        Dataset datasetFromResult = getEffectiveDatasetForAuthentication((Dataset) result);
        Dataset oldDataset = (Dataset) authenticatedResponse.getDatasets().get(datasetIdx);
        if (isAuthResultDatasetEphemeral(oldDataset, data) == true) goto L82;
        authenticatedResponse.getDatasets().set(datasetIdx, datasetFromResult);
    L82:
        autoFill(requestId, datasetIdx, datasetFromResult, false, 0);
        return;
    L76:
        if (Helper.sDebug == false) goto L78;
        Slog.d(TAG, "Updating client state from auth dataset");
    L78:
        setClientState(newClientState, requestId);
        goto L79
    L83:
        Slog.w(TAG, "invalid index (" + datasetIdx + ") for authentication id " + authenticationId);
        logAuthenticationStatusLocked(requestId, 1127);
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(2);
        return;
    L85:
        if (result == null) goto L87;
        Slog.w(TAG, "service returned invalid auth type: " + result);
    L87:
        logAuthenticationStatusLocked(requestId, 1128);
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(2);
        processNullResponseLocked(requestId, 0);
        return;
    L89:
        Slog.w(TAG, "no authenticated response");
        this.mPresentationStatsEventLogger.maybeSetAuthenticationResult(2);
        this.mPresentationStatsEventLogger.logAndEndEvent("authentication - bad response");
        removeFromService();
        return;
    L20:
        r4 = this.mResponses.get(requestId);
        goto L21
    }

    private Dataset getDatasetFromCredentialResponse(GetCredentialResponse result) {
        if (result != null) goto L5;
        return null;
    L5:
        Bundle bundle = result.getCredential().getData();
        if (bundle != null) goto L9;
        return null;
    L9:
        return (Dataset) bundle.getParcelable("android.view.autofill.extra.AUTHENTICATION_RESULT", Dataset.class);
    }

    Dataset getEffectiveDatasetForAuthentication(Dataset authenticatedDataset) {
        FillResponse response = getEffectiveFillResponse(new FillResponse.Builder().addDataset(authenticatedDataset).build());
        if (response != null) goto L5;
    L21:
        StringBuilder r1 = new StringBuilder();
        r1.append("No datasets in fill response on authentication. response = ");
        if (response != null) goto L24;
        String r2 = "null";
    L25:
        r1.append(r2);
        Log.wtf(TAG, r1.toString());
        return authenticatedDataset;
    L24:
        r2 = response.toString();
        goto L25
    L5:
        if (response.getDatasets().size() == 0) goto L21;
        List<Dataset> datasets = response.getDatasets();
        Dataset result = (Dataset) response.getDatasets().get(0);
        if (datasets.size() <= 1) goto L32;
        Dataset.Builder builder = new Dataset.Builder();
        Iterator<Dataset> r4 = datasets.iterator();
    L11:
        if (r4.hasNext() == false) goto L19;
        Dataset dataset = r4.next();
        if (dataset.getFieldIds().isEmpty() == true) goto L11;
        int i = 0;
    L16:
        if (i >= dataset.getFieldIds().size()) goto L11;
        builder.setField((AutofillId) dataset.getFieldIds().get(i), new Field.Builder().setValue((AutofillValue) dataset.getFieldValues().get(i)).build());
        i = i + 1;
        goto L16
    L19:
        Dataset result2 = builder.setId(authenticatedDataset.getId()).build();
        return result2;
    L32:
        return result;
    }

    private static boolean isAuthResultDatasetEphemeral(Dataset oldDataset, Bundle authResultData) {
        if (authResultData.containsKey("android.view.autofill.extra.AUTHENTICATION_RESULT_EPHEMERAL_DATASET") == false) goto L7;
        return authResultData.getBoolean("android.view.autofill.extra.AUTHENTICATION_RESULT_EPHEMERAL_DATASET");
    L7:
        return isPinnedDataset(oldDataset);
    }

    private static boolean isPinnedDataset(Dataset dataset) {
        if (dataset != null) goto L4;
        return false;
    L4:
        if (dataset.getFieldIds() == null) goto L20;
        int numOfFields = dataset.getFieldIds().size();
        int i = 0;
    L6:
        if (i >= numOfFields) goto L21;
        InlinePresentation inlinePresentation = dataset.getFieldInlinePresentation(i);
        if (inlinePresentation == null) goto L13;
        if (inlinePresentation.isPinned() == false) goto L13;
        return true;
    L13:
        i = i + 1;
        goto L6
    L21:
        return false;
    L20:
        return false;
    }

    void setAuthenticationResultForAugmentedAutofillLocked(Bundle data, int authId) {
        ClipData r0 = null;
        if (data != null) goto L5;
        Dataset dataset = null;
    L7:
        if (Helper.sDebug == false) goto L11;
        Slog.d(TAG, "Auth result for augmented autofill: sessionId=" + this.id + ", authId=" + authId + ", dataset=" + dataset);
    L11:
        if (dataset != null) goto L13;
    L15:
        AutofillId fieldId = null;
    L17:
        if (dataset != null) goto L19;
    L21:
        AutofillValue value = null;
    L23:
        if (dataset == null) goto L25;
        r0 = dataset.getFieldContent();
    L25:
        ClipData content = r0;
        if (fieldId == null) goto L50;
        if (value != null) goto L30;
        if (content == null) goto L50;
    L30:
        RemoteAugmentedAutofillService remoteAugmentedAutofillService = this.mService.getRemoteAugmentedAutofillServiceIfCreatedLocked();
        if (remoteAugmentedAutofillService != null) goto L34;
        Slog.e(TAG, "Can't fill after auth: RemoteAugmentedAutofillService is null");
        this.mService.resetLastAugmentedAutofillResponse();
        removeFromServiceLocked();
        return;
    L34:
        fieldId.setSessionId(this.id);
        this.mCurrentViewId = fieldId;
        Bundle clientState = data.getBundle("android.view.autofill.extra.CLIENT_STATE");
        this.mService.logAugmentedAutofillSelected(this.id, dataset.getId(), clientState);
        if (content == null) goto L38;
        AutofillUriGrantsManager autofillUgm = remoteAugmentedAutofillService.getAutofillUriGrantsManager();
        autofillUgm.grantUriPermissions(this.mComponentName, this.mActivityToken, this.userId, content);
    L38:
        if (Helper.sDebug == false) goto L55;
        Slog.d(TAG, "Filling after auth: fieldId=" + fieldId + ", value=" + value + ", content=" + content);
    L55:
        if (content == null) goto L44;
        this.mClient.autofillContent(this.id, fieldId, content);     // Catch: RemoteException -> L42
    L54:
    L47:
        this.mInlineSessionController.setInlineFillUiLocked(InlineFillUi.emptyUi(fieldId));
        return;
    L44:
        this.mClient.autofill(this.id, dataset.getFieldIds(), dataset.getFieldValues(), true);     // Catch: RemoteException -> L42
    L42:
        e = move-exception;
        Slog.w(TAG, "Error filling after auth: fieldId=" + fieldId + ", value=" + value + ", content=" + content, e);
    L50:
        if (Helper.sDebug == false) goto L52;
        Slog.d(TAG, "Rejecting empty/invalid auth result");
    L52:
        this.mService.resetLastAugmentedAutofillResponse();
        removeFromServiceLocked();
        return;
    L19:
        if (dataset.getFieldValues().size() != 1) goto L21;
        value = (AutofillValue) dataset.getFieldValues().get(0);
        goto L23
    L13:
        if (dataset.getFieldIds().size() != 1) goto L15;
        fieldId = (AutofillId) dataset.getFieldIds().get(0);
        goto L17
    L5:
        dataset = (Dataset) data.getParcelable("android.view.autofill.extra.AUTHENTICATION_RESULT", Dataset.class);
        goto L7
    }

    void setHasCallbackLocked(boolean hasIt) {
        if (this.mDestroyed == false) goto L6;
        Slog.w(TAG, "Call to Session#setHasCallbackLocked() rejected - session: " + this.id + " destroyed");
        return;
    L6:
        this.mHasCallback = hasIt;
    }

    private FillResponse getLastResponseLocked(String logPrefixFmt) {
        if (Helper.sDebug == false) goto L6;
        if (logPrefixFmt == null) goto L6;
        String logPrefix = String.format(logPrefixFmt, new Object[]{Integer.valueOf(this.id)});
    L8:
        if (this.mContexts != null) goto L13;
        if (logPrefix == null) goto L11;
        Slog.d(TAG, logPrefix + ": no contexts");
    L11:
        return null;
    L13:
        if (this.mResponses == null) goto L15;
        int lastResponseIdx = getLastResponseIndexLocked();
        if (lastResponseIdx >= 0) goto L24;
        if (logPrefix == null) goto L23;
        Slog.w(TAG, logPrefix + ": did not get last response. mResponses=" + this.mResponses + ", mViewStates=" + this.mViewStates);
    L23:
        return null;
    L24:
        FillResponse response = this.mResponses.valueAt(lastResponseIdx);
        if (Helper.sVerbose == false) goto L28;
        if (logPrefix == null) goto L28;
        Slog.v(TAG, logPrefix + ": mResponses=" + this.mResponses + ", mContexts=" + this.mContexts + ", mViewStates=" + this.mViewStates);
    L28:
        return response;
    L15:
        if (Helper.sVerbose == false) goto L18;
        if (logPrefix == null) goto L18;
        Slog.v(TAG, logPrefix + ": no responses on session");
    L18:
        return null;
    L6:
        logPrefix = null;
        goto L8
    }

    private SaveInfo getSaveInfoLocked() {
        FillResponse response = getLastResponseLocked(null);
        if (response != null) goto L6;
        return null;
    L6:
        return response.getSaveInfo();
    }

    int getSaveInfoFlagsLocked() {
        SaveInfo saveInfo = getSaveInfoLocked();
        if (saveInfo != null) goto L6;
        return 0;
    L6:
        return saveInfo.getFlags();
    }

    private Helper.SaveInfoStats getSaveInfoStatsLocked() {
        if (this.mContexts != null) goto L10;
        if (Helper.sVerbose == false) goto L8;
        Slog.v(TAG, "getSaveInfoStatsLocked(): mContexts is null");
    L8:
        return new Helper.SaveInfoStats(-1, -1);
    L10:
        return Helper.getSaveInfoStatsFromFillResponses(this.mResponses);
    }

    public void logContextCommitted() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "logContextCommitted (" + this.id + "): commit_reason:0 no_save_reason:0");
    L5:
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda4(), this, 0, 0));
        Object r0 = this.mLock;
        monitor-enter(r0);
        logAllEventsLocked(0);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void logContextCommittedLocked(int saveDialogNotShowReason, int commitReason) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "logContextCommittedLocked (" + this.id + "): commit_reason:" + commitReason + " no_save_reason:" + saveDialogNotShowReason);
    L5:
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda4(), this, Integer.valueOf(saveDialogNotShowReason), Integer.valueOf(commitReason)));
        this.mSessionCommittedEventLogger.maybeSetCommitReason(commitReason);
        this.mSessionCommittedEventLogger.maybeSetRequestCount(this.mRequestCount);
        Helper.SaveInfoStats saveInfoStats = getSaveInfoStatsLocked();
        this.mSessionCommittedEventLogger.maybeSetSaveInfoCount(saveInfoStats.saveInfoCount);
        this.mSessionCommittedEventLogger.maybeSetSaveDataTypeCount(saveInfoStats.saveDataTypeCount);
        SessionCommittedEventLogger r1 = this.mSessionCommittedEventLogger;
        if (getSaveInfoLocked() == null) goto L8;
        boolean r2 = true;
    L9:
        r1.maybeSetLastFillResponseHasSaveInfo(r2);
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(1);
        return;
    L8:
        r2 = false;
        goto L9
    }

    private void handleLogContextCommitted(int saveDialogNotShowReason, int commitReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FillResponse lastResponse = getLastResponseLocked("logContextCommited(%s)");     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        if (lastResponse != null) goto L9;
        Slog.w(TAG, "handleLogContextCommitted(): last response is null");
        return;
    L9:
        UserData genericUserData = this.mService.getUserData();
        FieldClassificationUserData r2 = lastResponse.getUserData();
        if (r2 != null) goto L13;
        if (genericUserData != null) goto L13;
        FieldClassificationUserData userData = null;
    L19:
        FieldClassificationStrategy fcStrategy = this.mService.getFieldClassificationStrategy();
        if (userData == null) goto L23;
        if (fcStrategy == null) goto L23;
        logFieldClassificationScore(fcStrategy, userData, saveDialogNotShowReason, commitReason);
        return;
    L23:
        logContextCommitted(null, null, saveDialogNotShowReason, commitReason);
        return;
    L13:
        if (r2 == null) goto L16;
        if (genericUserData == null) goto L16;
        userData = new CompositeUserData(genericUserData, r2);
    L16:
        if (r2 == null) goto L18;
        userData = r2;
        goto L19
    L18:
        userData = this.mService.getUserData();
    L25:
        th = move-exception;
        throw th;
    }

    private void logContextCommitted(ArrayList<AutofillId> detectedFieldIds, ArrayList<android.service.autofill.FieldClassification> detectedFieldClassifications, int saveDialogNotShowReason, int commitReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        logContextCommittedLocked(detectedFieldIds, detectedFieldClassifications, saveDialogNotShowReason, commitReason);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void logContextCommittedLocked(ArrayList<AutofillId> detectedFieldIds, ArrayList<android.service.autofill.FieldClassification> detectedFieldClassifications, int saveDialogNotShowReason, int commitReason) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "logContextCommittedLocked (" + this.id + "): commit_reason:" + commitReason + " no_save_reason:" + saveDialogNotShowReason);
    L5:
        FillResponse lastResponse = getLastResponseLocked("logContextCommited(%s)");
        if (lastResponse != null) goto L8;
        return;
    L8:
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(PresentationStatsEventLogger.getNoPresentationEventReason(commitReason));
        this.mPresentationStatsEventLogger.logAndEndEvent("Context committed");
        int flags = lastResponse.getFlags();
        if ((flags & 1) == 0) goto L11;
        ArraySet<String> ignoredDatasets = null;
        int responseCount = this.mResponses.size();
        int i = 0;
        boolean hasAtLeastOneDataset = false;
    L16:
        if (i >= responseCount) goto L52;
        FillResponse response = this.mResponses.valueAt(i);
        List<Dataset> datasets = response.getDatasets();
        if (datasets == null) goto L49;
        if (datasets.isEmpty() == true) goto L49;
        int j = 0;
    L24:
        if (j >= datasets.size()) goto L46;
        Dataset dataset = datasets.get(j);
        int flags2 = flags;
        String datasetId = dataset.getId();
        if (datasetId == null) goto L28;
        ArraySet<String> ignoredDatasets2 = ignoredDatasets;
        if (this.mSelectedDatasetIds == null) goto L39;
        if (this.mSelectedDatasetIds.contains(datasetId) == false) goto L39;
        hasAtLeastOneDataset = true;
        ignoredDatasets = ignoredDatasets2;
    L45:
        j = j + 1;
        flags = flags2;
    L39:
        if (Helper.sVerbose == false) goto L41;
        Slog.v(TAG, "adding ignored dataset " + datasetId);
    L41:
        if (ignoredDatasets2 != null) goto L43;
        ArraySet<String> ignoredDatasets3 = new ArraySet();
    L44:
        ignoredDatasets3.add(datasetId);
        hasAtLeastOneDataset = true;
        ignoredDatasets = ignoredDatasets3;
        goto L45
    L43:
        ignoredDatasets3 = ignoredDatasets2;
        goto L44
    L28:
        if (Helper.sVerbose == false) goto L31;
        Slog.v(TAG, "logContextCommitted() skipping idless dataset " + dataset);
    L31:
        ignoredDatasets = ignoredDatasets;
        goto L45
    L46:
        flags = flags;
    L51:
        i = i + 1;
        flags = flags;
    L49:
        if (Helper.sVerbose == false) goto L51;
        Slog.v(TAG, "logContextCommitted() no datasets at " + i);
        goto L51
    L52:
        int i2 = 0;
        ArrayMap<AutofillId, ArraySet<String>> manuallyFilledIds = null;
        ArrayList<String> changedDatasetIds = null;
        ArrayList<AutofillId> changedFieldIds = null;
        ArraySet<String> ignoredDatasets4 = ignoredDatasets;
    L54:
        if (i2 >= this.mViewStates.size()) goto L142;
        ViewState viewState = this.mViewStates.valueAt(i2);
        int state = viewState.getState();
        if ((state & 8) != 0) goto L58;
        int i3 = i2;
        ArraySet<String> ignoredDatasets5 = ignoredDatasets4;
    L140:
        ignoredDatasets4 = ignoredDatasets5;
        changedFieldIds = changedFieldIds;
        changedDatasetIds = changedDatasetIds;
    L141:
        i2 = i3 + 1;
        responseCount = responseCount;
        goto L54
    L58:
        if ((state & 2048) == 0) goto L76;
        String datasetId2 = viewState.getDatasetId();
        if (datasetId2 != null) goto L62;
        StringBuilder r15 = new StringBuilder();
        i3 = i2;
        r15.append("logContextCommitted(): no dataset id on ");
        r15.append(viewState);
        Slog.w(TAG, r15.toString());
        ignoredDatasets5 = ignoredDatasets4;
        goto L140
    L62:
        i3 = i2;
        AutofillValue autofilledValue = viewState.getAutofilledValue();
        AutofillValue currentValue = viewState.getCurrentValue();
        if (autofilledValue != null) goto L65;
    L70:
        ArraySet<String> ignoredDatasets6 = ignoredDatasets4;
        if (Helper.sDebug == false) goto L73;
        Slog.d(TAG, "logContextCommitted() found changed state: " + viewState);
    L73:
        if (changedFieldIds != null) goto L75;
        changedFieldIds = new ArrayList();
        changedDatasetIds = new ArrayList();
    L75:
        changedFieldIds.add(viewState.id);
        changedDatasetIds.add(datasetId2);
        responseCount = responseCount;
        ignoredDatasets4 = ignoredDatasets6;
        goto L141
    L65:
        if (autofilledValue.equals(currentValue) == false) goto L70;
        if (Helper.sDebug == false) goto L69;
        StringBuilder r1 = new StringBuilder();
        ignoredDatasets5 = ignoredDatasets4;
        r1.append("logContextCommitted(): ignoring changed ");
        r1.append(viewState);
        r1.append(" because it has same value that was autofilled");
        Slog.d(TAG, r1.toString());
        goto L140
    L69:
        ignoredDatasets5 = ignoredDatasets4;
        goto L140
    L76:
        i3 = i2;
        ignoredDatasets5 = ignoredDatasets4;
        AutofillValue currentValue2 = viewState.getCurrentValue();
        if (currentValue2 == null) goto L79;
        if (hasAtLeastOneDataset == false) goto L140;
        int j2 = 0;
    L84:
        if (j2 >= responseCount) goto L137;
        FillResponse response2 = this.mResponses.valueAt(j2);
        List<Dataset> datasets2 = response2.getDatasets();
        if (datasets2 == null) goto L134;
        if (datasets2.isEmpty() == true) goto L134;
        ArrayMap<AutofillId, ArraySet<String>> manuallyFilledIds2 = manuallyFilledIds;
        int k = 0;
    L91:
        changedFieldIds = changedFieldIds;
        if (k >= datasets2.size()) goto L131;
        Dataset dataset2 = datasets2.get(k);
        int k2 = k;
        String datasetId3 = dataset2.getId();
        if (datasetId3 == null) goto L96;
        changedDatasetIds = changedDatasetIds;
        ArrayList<String> changedDatasetIds2 = dataset2.getFieldValues();
        int l = 0;
    L101:
        int responseCount2 = responseCount;
        if (l >= changedDatasetIds2.size()) goto L119;
        AutofillValue candidate = (AutofillValue) changedDatasetIds2.get(l);
        if (currentValue2.equals(candidate) == true) goto L106;
        currentValue2 = currentValue2;
        l = l;
        changedDatasetIds2 = changedDatasetIds2;
    L118:
        l = l + 1;
        responseCount = responseCount2;
        currentValue2 = currentValue2;
        changedDatasetIds2 = changedDatasetIds2;
        goto L101
    L106:
        if (Helper.sDebug == false) goto L109;
        Slog.d(TAG, "field " + viewState.id + " was manually filled with value set by dataset " + datasetId3);
    L109:
        if (manuallyFilledIds2 != null) goto L111;
        ArrayMap<AutofillId, ArraySet<String>> manuallyFilledIds3 = new ArrayMap();
    L112:
        ArraySet<String> datasetIds = manuallyFilledIds3.get(viewState.id);
        if (datasetIds != null) goto L116;
        datasetIds = new ArraySet(1);
        manuallyFilledIds3.put(viewState.id, datasetIds);
    L116:
        datasetIds.add(datasetId3);
        manuallyFilledIds2 = manuallyFilledIds3;
        goto L118
    L111:
        manuallyFilledIds3 = manuallyFilledIds2;
        goto L112
    L119:
        AutofillValue currentValue3 = currentValue2;
        if (this.mSelectedDatasetIds == null) goto L124;
        if (this.mSelectedDatasetIds.contains(datasetId3) == false) goto L124;
    L130:
        k = k2 + 1;
        changedFieldIds = changedFieldIds;
        changedDatasetIds = changedDatasetIds;
        responseCount = responseCount2;
        currentValue2 = currentValue3;
    L124:
        if (Helper.sVerbose == false) goto L126;
        Slog.v(TAG, "adding ignored dataset " + datasetId3);
    L126:
        if (ignoredDatasets5 != null) goto L128;
        ArraySet<String> ignoredDatasets7 = new ArraySet();
    L129:
        ignoredDatasets7.add(datasetId3);
        ignoredDatasets5 = ignoredDatasets7;
        goto L130
    L128:
        ignoredDatasets7 = ignoredDatasets5;
        goto L129
    L96:
        if (Helper.sVerbose == false) goto L99;
        Slog.v(TAG, "logContextCommitted() skipping idless dataset " + dataset2);
    L99:
        currentValue3 = currentValue2;
        responseCount2 = responseCount;
        goto L130
    L131:
        currentValue2 = currentValue2;
        changedDatasetIds = changedDatasetIds;
        responseCount = responseCount;
        manuallyFilledIds = manuallyFilledIds2;
    L136:
        j2 = j2 + 1;
        changedFieldIds = changedFieldIds;
        changedDatasetIds = changedDatasetIds;
        responseCount = responseCount;
        currentValue2 = currentValue2;
    L134:
        if (Helper.sVerbose == false) goto L136;
        Slog.v(TAG, "logContextCommitted() no datasets at " + j2);
        goto L136
    L137:
        responseCount = responseCount;
        ignoredDatasets4 = ignoredDatasets5;
        goto L141
    L79:
        if (Helper.sDebug == false) goto L140;
        Slog.d(TAG, "logContextCommitted(): skipping view without current value ( " + viewState + ")");
        goto L140
    L142:
        ArraySet<String> ignoredDatasets8 = ignoredDatasets4;
        ArrayList<AutofillId> changedFieldIds2 = changedFieldIds;
        ArrayList<String> changedDatasetIds3 = changedDatasetIds;
        if (manuallyFilledIds == null) goto L148;
        int size = manuallyFilledIds.size();
        ArrayList<AutofillId> manuallyFilledFieldIds = new ArrayList(size);
        ArrayList<ArrayList<String>> manuallyFilledDatasetIds = new ArrayList(size);
        int i4 = 0;
    L145:
        if (i4 >= size) goto L147;
        AutofillId fieldId = manuallyFilledIds.keyAt(i4);
        ArraySet<String> datasetIds2 = manuallyFilledIds.valueAt(i4);
        manuallyFilledFieldIds.add(fieldId);
        manuallyFilledDatasetIds.add(new ArrayList(datasetIds2));
        i4 = i4 + 1;
        goto L145
    L147:
        ArrayList<AutofillId> manuallyFilledFieldIds2 = manuallyFilledFieldIds;
        ArrayList<ArrayList<String>> manuallyFilledDatasetIds2 = manuallyFilledDatasetIds;
    L149:
        this.mService.logContextCommittedLocked(this.id, this.mClientState, this.mSelectedDatasetIds, ignoredDatasets8, changedFieldIds2, changedDatasetIds3, manuallyFilledFieldIds2, manuallyFilledDatasetIds2, detectedFieldIds, detectedFieldClassifications, this.mComponentName, this.mCompatMode, saveDialogNotShowReason, shouldAddEventToHistory());
        this.mSessionCommittedEventLogger.maybeSetCommitReason(commitReason);
        this.mSessionCommittedEventLogger.maybeSetRequestCount(this.mRequestCount);
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(saveDialogNotShowReason);
        return;
    L148:
        manuallyFilledFieldIds2 = null;
        manuallyFilledDatasetIds2 = null;
        goto L149
    L11:
        if (Helper.sVerbose == false) goto L175;
        Slog.v(TAG, "logContextCommittedLocked(): ignored by flags " + flags);
        return;
    }

    private void logFieldClassificationScore(FieldClassificationStrategy fcStrategy, FieldClassificationUserData userData, int saveDialogNotShowReason, int commitReason) {
        String[] userValues = userData.getValues();
        String[] categoryIds = userData.getCategoryIds();
        String defaultAlgorithm = userData.getFieldClassificationAlgorithm();
        Bundle defaultArgs = userData.getDefaultFieldClassificationArgs();
        ArrayMap<String, String> algorithms = userData.getFieldClassificationAlgorithms();
        ArrayMap<String, Bundle> args = userData.getFieldClassificationArgs();
        if (userValues == null) goto L25;
        if (categoryIds == null) goto L25;
        if (userValues.length != categoryIds.length) goto L25;
        int maxFieldsSize = UserData.getMaxFieldClassificationIdsSize();
        ArrayList<AutofillId> detectedFieldIds = new ArrayList(maxFieldsSize);
        ArrayList<android.service.autofill.FieldClassification> detectedFieldClassifications = new ArrayList(maxFieldsSize);
        Object r2 = this.mLock;
        monitor-enter(r2);
        Collection<ViewState> viewStates = this.mViewStates.values();     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        int viewsSize = viewStates.size();
        AutofillId[] autofillIds = new AutofillId[viewsSize];
        ArrayList<AutofillValue> currentValues = new ArrayList(viewsSize);
        Iterator<ViewState> r3 = viewStates.iterator();
        int k = 0;
    L14:
        if (r3.hasNext() == false) goto L16;
        ViewState viewState = r3.next();
        currentValues.add(viewState.getCurrentValue());
        autofillIds[k] = viewState.id;
        k = k + 1;
        currentValues = currentValues;
        goto L14
    L16:
        RemoteCallback callback = new RemoteCallback(new LogFieldClassificationScoreOnResultListener(this, saveDialogNotShowReason, commitReason, viewsSize, autofillIds, userValues, categoryIds, detectedFieldIds, detectedFieldClassifications));
        fcStrategy.calculateScores(callback, currentValues, userValues, categoryIds, defaultAlgorithm, defaultArgs, algorithms, args);
        return;
    L18:
        th = th;
    L34:
        throw th;
    L22:
        th = th;
    L25:
        int idsLength = -1;
        if (userValues != 0) goto L28;
        int valuesLength = -1;
    L29:
        if (categoryIds == 0) goto L32;
        idsLength = categoryIds.length;
    L32:
        Slog.w(TAG, "setScores(): user data mismatch: values.length = " + valuesLength + ", ids.length = " + idsLength);
        return;
    L28:
        valuesLength = userValues.length;
        goto L29
    }

    void handleLogFieldClassificationScore(Bundle result, int saveDialogNotShowReason, int commitReason, int viewsSize, AutofillId[] autofillIds, String[] userValues, String[] categoryIds, ArrayList<AutofillId> detectedFieldIds, ArrayList<android.service.autofill.FieldClassification> detectedFieldClassifications) {
        if (result == null) goto L5;
        AutofillFieldClassificationService.Scores scores = (AutofillFieldClassificationService.Scores) result.getParcelable("scores", AutofillFieldClassificationService.Scores.class);
        if (scores != null) goto L13;
        Slog.w(TAG, "No field classification score on " + result);
        return;
    L13:
        int j = 0;
        int i = 0;
    L15:
        if (i >= viewsSize) goto L58;
        AutofillId autofillId = autofillIds[i];     // Catch: ArrayIndexOutOfBoundsException -> L43
        ArrayMap<String, Float> scoresByField = null;
        j = 0;
    L18:
        if (j >= userValues.length) goto L45;
        String categoryId = categoryIds[j];     // Catch: ArrayIndexOutOfBoundsException -> L43
        float score = scores.scores[i][j];     // Catch: ArrayIndexOutOfBoundsException -> L43
        if (score <= 0.0f) goto L39;
        if (scoresByField != null) goto L27;
        int i2 = i;
        scoresByField = new ArrayMap(userValues.length);     // Catch: ArrayIndexOutOfBoundsException -> L25
    L28:
        Float currentScore = scoresByField.get(categoryId);     // Catch: ArrayIndexOutOfBoundsException -> L25
        if (currentScore == null) goto L36;
        if (currentScore.floatValue() <= score) goto L36;
        if (Helper.sVerbose == false) goto L42;
        Slog.v(TAG, "skipping score " + score + " because it's less than " + currentScore);     // Catch: ArrayIndexOutOfBoundsException -> L25
    L42:
        j = j + 1;     // Catch: ArrayIndexOutOfBoundsException -> L25
        userValues = userValues;
        i = i2;
    L36:
        if (Helper.sVerbose == false) goto L38;
        Slog.v(TAG, "adding score " + score + " at index " + j + " and id " + autofillId);     // Catch: ArrayIndexOutOfBoundsException -> L25
    L38:
        scoresByField.put(categoryId, Float.valueOf(score));     // Catch: ArrayIndexOutOfBoundsException -> L25
    L25:
        e = e;
    L56:
        wtf(e, "Error accessing FC score at [%d, %d] (%s): %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(j), scores, e});
        return;
    L27:
        i2 = i;
        goto L28
    L39:
        i2 = i;
        if (Helper.sVerbose == false) goto L42;
        Slog.v(TAG, "skipping score 0 at index " + j + " and id " + autofillId);     // Catch: ArrayIndexOutOfBoundsException -> L25
        goto L42
    L45:
        int i3 = i;
        if (scoresByField == null) goto L48;
        ArrayList<android.service.autofill.FieldClassification.Match> matches = new ArrayList(scoresByField.size());     // Catch: ArrayIndexOutOfBoundsException -> L25
        j = 0;
    L51:
        int j2 = scoresByField.size();     // Catch: ArrayIndexOutOfBoundsException -> L25
        if (j >= j2) goto L54;
        String fieldId = scoresByField.keyAt(j);     // Catch: ArrayIndexOutOfBoundsException -> L25
        matches.add(new android.service.autofill.FieldClassification.Match(fieldId, scoresByField.valueAt(j).floatValue()));     // Catch: ArrayIndexOutOfBoundsException -> L25
        j = j + 1;     // Catch: ArrayIndexOutOfBoundsException -> L25
        goto L51
    L54:
        detectedFieldIds.add(autofillId);     // Catch: ArrayIndexOutOfBoundsException -> L25
        detectedFieldClassifications.add(new android.service.autofill.FieldClassification(matches));     // Catch: ArrayIndexOutOfBoundsException -> L25
    L55:
        i = i3 + 1;
        goto L15
    L48:
        if (Helper.sVerbose == false) goto L55;
        Slog.v(TAG, "no score for autofillId=" + autofillId);     // Catch: ArrayIndexOutOfBoundsException -> L25
    L43:
        e = e;
        i2 = i;
        goto L56
    L58:
        logContextCommitted(detectedFieldIds, detectedFieldClassifications, saveDialogNotShowReason, commitReason);
        return;
    L5:
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "setFieldClassificationScore(): no results");
    L7:
        logContextCommitted(null, null, saveDialogNotShowReason, commitReason);
    }

    public void logSaveUiShown() {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new Session$$ExternalSyntheticLambda9(), this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.android.server.autofill.SaveEventLogger] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public SaveResult showSaveLocked() {
        if (this.mDestroyed == false) goto L6;
        Slog.w(TAG, "Call to Session#showSaveLocked() rejected - session: " + this.id + " destroyed");
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(9);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, false, 0);
    L6:
        this.mSessionState = 2;
        FillResponse response = getLastResponseLocked("showSaveLocked(%s)");
        if (response != null) goto L9;
        SaveInfo saveInfo = null;
    L11:
        if (SessionFlags.m2396$$Nest$fgetmScreenHasCredmanField(this.mSessionFlags) == true) goto L13;
        if (saveInfo != null) goto L24;
        if (Helper.sVerbose == false) goto L21;
        Slog.v(TAG, "showSaveLocked(" + this.id + "): no saveInfo from service");
    L21:
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(2);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, true, 1);
    L24:
        if ((saveInfo.getFlags() & 4) == 0) goto L31;
        if (Helper.sDebug == false) goto L28;
        Slog.v(TAG, "showSaveLocked(" + this.id + "): service asked to delay save");
    L28:
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(3);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, false, 2);
    L31:
        if (this.mExt.isInTestProcess(this.mService.getServicePackageName()) == true) goto L36;
        SaveResult res = this.mExt.showPasswdSaveLocked(response, saveInfo, this.mViewStates, this.mSaveEventLogger, this.mComponentName, this.mService.getServicePackageName(), this.mContext, this.mCompatMode);
        if (res == null) goto L35;
        return res;
    L35:
        Log.d(TAG, "showSaveLocked(" + this.id + "): no passwd save result, saveInfo.getType()=" + saveInfo.getType());
    L37:
        ArrayMap<AutofillId, InternalSanitizer> sanitizers = Helper.createSanitizers(saveInfo);
        ArrayMap<AutofillId, AutofillValue> currentValues = new ArrayMap();
        ArraySet<AutofillId> savableIds = new ArraySet();
        AutofillId[] requiredIds = saveInfo.getRequiredIds();
        boolean allRequiredAreNotEmpty = true;
        boolean atLeastOneChanged = false;
        boolean isUpdate = false;
        if (requiredIds == null) goto L103;
        int i = 0;
    L41:
        if (i >= requiredIds.length) goto L102;
        AutofillId id = requiredIds[i];
        if (id != null) goto L45;
        Slog.w(TAG, "null autofill id on " + Arrays.toString(requiredIds));
        allRequiredAreNotEmpty = allRequiredAreNotEmpty;
    L97:
        i = i + 1;
        allRequiredAreNotEmpty = allRequiredAreNotEmpty;
        goto L41
    L45:
        savableIds.add(id);
        ViewState viewState = this.mViewStates.get(id);
        if (viewState == null) goto L47;
        AutofillValue value = viewState.getCurrentValue();
        if (value != null) goto L51;
    L54:
        AutofillValue candidateSaveValue = viewState.getCandidateSaveValue();
        if (candidateSaveValue != null) goto L57;
    L62:
        AutofillValue initialValue = getValueFromContextsLocked(id);
        if (initialValue == null) goto L98;
        if (Helper.sDebug == false) goto L68;
        Slog.d(TAG, "Value of required field " + id + " didn't change; using initial value (" + initialValue + ") instead");
    L68:
        value = initialValue;
    L69:
        AutofillValue value2 = getSanitizedValue(sanitizers, id, value);
        if (value2 == null) goto L72;
        viewState.setSanitizedValue(value2);
        currentValues.put(id, value2);
        AutofillValue filledValue = viewState.getAutofilledValue();
        if (value2.equals(filledValue) == true) goto L97;
        boolean changed = true;
        if (filledValue != null) goto L90;
        AutofillValue initialValue2 = getValueFromContextsLocked(id);
        if (initialValue2 != null) goto L82;
    L88:
        this.mSaveEventLogger.maybeSetIsNewField(true);
        changed = true;
    L91:
        if (changed == false) goto L97;
        if (Helper.sDebug == false) goto L95;
        Slog.d(TAG, "found a change on required " + id + ": " + filledValue + " => " + value2);
    L95:
        atLeastOneChanged = true;
        goto L97
    L82:
        if (initialValue2.equals(value2) == false) goto L88;
        if (Helper.sDebug == false) goto L87;
        Slog.d(TAG, "id " + id + " is part of dataset but initial value didn't change: " + value2);
    L87:
        changed = false;
        goto L91
    L90:
        isUpdate = true;
        goto L91
    L72:
        if (Helper.sDebug == false) goto L74;
        Slog.d(TAG, "value of required field " + id + " failed sanitization");
    L74:
        boolean allRequiredAreNotEmpty2 = false;
    L104:
        AutofillId[] optionalIds = saveInfo.getOptionalIds();
        if (Helper.sVerbose == false) goto L111;
        StringBuilder r3 = new StringBuilder();
        r3.append("allRequiredAreNotEmpty: ");
        r3.append(allRequiredAreNotEmpty2);
        r3.append(" hasOptional: ");
        if (optionalIds == null) goto L109;
        boolean r4 = true;
    L110:
        r3.append(r4);
        Slog.v(TAG, r3.toString());
        goto L111
    L109:
        r4 = false;
    L111:
        if (allRequiredAreNotEmpty2 == true) goto L113;
        int saveDialogNotShowReason = 3;
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(4);
        this.mSaveEventLogger.logAndEndEvent();
    L173:
        if (Helper.sDebug == false) goto L176;
        Slog.d(TAG, "showSaveLocked(" + this.id + "): with no changes, comes no responsibilities.allRequiredAreNotNull=" + allRequiredAreNotEmpty2 + ", atLeastOneChanged=" + atLeastOneChanged);
    L176:
        return new SaveResult(false, true, saveDialogNotShowReason);
    L113:
        if (optionalIds == null) goto L168;
        if (atLeastOneChanged == false) goto L118;
        if (isUpdate == true) goto L168;
    L118:
        int i2 = 0;
    L120:
        if (i2 >= optionalIds.length) goto L166;
        AutofillId id2 = optionalIds[i2];
        savableIds.add(id2);
        ViewState viewState2 = this.mViewStates.get(id2);
        if (viewState2 != null) goto L125;
        Slog.w(TAG, "no ViewState for optional " + id2);
        i2 = i2;
        AutofillId[] optionalIds2 = optionalIds;
        sanitizers = sanitizers;
    L165:
        i2 = i2 + 1;
        optionalIds = optionalIds2;
        sanitizers = sanitizers;
        goto L120
    L125:
        if ((viewState2.getState() & 8) == 0) goto L160;
        AutofillValue currentValue = viewState2.getCurrentValue();
        if (currentValue != null) goto L129;
    L132:
        AutofillValue candidateSaveValue2 = viewState2.getCandidateSaveValue();
        if (candidateSaveValue2 != null) goto L135;
    L141:
        i2 = i2;
    L142:
        AutofillValue value3 = getSanitizedValue(sanitizers, id2, currentValue);
        if (value3 == null) goto L145;
        optionalIds2 = optionalIds;
        currentValues.put(id2, value3);
        AutofillValue filledValue2 = viewState2.getAutofilledValue();
        if (value3.equals(filledValue2) == false) goto L151;
        sanitizers = sanitizers;
        goto L165
    L151:
        if (Helper.sDebug == false) goto L154;
        Slog.d(TAG, "found a change on optional " + id2 + ": " + filledValue2 + " => " + value3);
    L154:
        if (filledValue2 == null) goto L156;
        isUpdate = true;
    L157:
        atLeastOneChanged = true;
        goto L165
    L156:
        this.mSaveEventLogger.maybeSetIsNewField(true);
        goto L157
    L145:
        if (Helper.sDebug == false) goto L147;
        StringBuilder r13 = new StringBuilder();
        optionalIds2 = optionalIds;
        r13.append("value of opt. field ");
        r13.append(id2);
        r13.append(" failed sanitization");
        Slog.d(TAG, r13.toString());
        sanitizers = sanitizers;
        goto L165
    L147:
        optionalIds2 = optionalIds;
        sanitizers = sanitizers;
        goto L165
    L135:
        if (candidateSaveValue2.isEmpty() == true) goto L141;
        if (Helper.sVerbose == false) goto L140;
        Slog.v(TAG, "current value is empty, using cached last non-empty value instead");
    L140:
        currentValue = candidateSaveValue2;
        goto L142
    L129:
        if (currentValue.isEmpty() == true) goto L132;
        i2 = i2;
        goto L142
    L160:
        i2 = i2;
        optionalIds2 = optionalIds;
        sanitizers = sanitizers;
        AutofillValue initialValue3 = getValueFromContextsLocked(id2);
        if (Helper.sDebug == false) goto L163;
        Slog.d(TAG, "no current value for " + id2 + "; initial value is " + initialValue3);
    L163:
        if (initialValue3 == null) goto L165;
        currentValues.put(id2, initialValue3);
        goto L165
    L166:
        boolean atLeastOneChanged2 = atLeastOneChanged;
    L170:
        if (atLeastOneChanged2 == true) goto L178;
        saveDialogNotShowReason = 4;
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(5);
        this.mSaveEventLogger.logAndEndEvent();
        atLeastOneChanged = atLeastOneChanged2;
        goto L173
    L178:
        if (Helper.sDebug == false) goto L180;
        Slog.d(TAG, "at least one field changed, validate fields for save UI");
    L180:
        InternalValidator validator = saveInfo.getValidator();
        if (validator == null) goto L199;
        LogMaker log = newLogMaker(1133);
        boolean isValid = validator.isValid(this);     // Catch: Exception -> L186
        if (Helper.sDebug == false) goto L189;
        Slog.d(TAG, validator + " returned " + isValid);     // Catch: Exception -> L186
    L189:
        if (isValid == false) goto L191;
        int r9 = 10;
    L192:
        log.setType(r9);     // Catch: Exception -> L186
        this.mMetricsLogger.write(log);
        if (isValid == true) goto L199;
        Slog.i(TAG, "not showing save UI because fields failed validation");
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(6);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, true, 5);
    L191:
        r9 = 5;
    L186:
        e = move-exception;
        Slog.e(TAG, "Not showing save UI because validation failed:", e);
        log.setType(11);
        this.mMetricsLogger.write(log);
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(6);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, true, 5);
    L199:
        List<Dataset> datasets = response.getDatasets();
        if (datasets == null) goto L233;
        int i3 = 0;
    L203:
        if (i3 >= datasets.size()) goto L232;
        Dataset dataset = datasets.get(i3);
        ArrayMap<AutofillId, AutofillValue> datasetValues = Helper.getFields(dataset);
        if (Helper.sVerbose == false) goto L207;
        Slog.v(TAG, "Checking if saved fields match contents of dataset #" + i3 + ": " + dataset + "; savableIds=" + savableIds);
    L207:
        int j = 0;
    L209:
        if (j >= savableIds.size()) goto L228;
        AutofillId id3 = savableIds.valueAt(j);
        AutofillValue currentValue2 = currentValues.get(id3);
        if (currentValue2 == null) goto L213;
        List<Dataset> datasets2 = datasets;
        InternalValidator validator2 = validator;
        AutofillValue datasetValue = datasetValues.get(id3);
        if (currentValue2.equals(datasetValue) == false) goto L219;
        ArrayMap<AutofillId, AutofillValue> currentValues2 = currentValues;
        if (Helper.sVerbose == false) goto L226;
        Slog.v(TAG, "no dataset changes for id " + id3);
    L226:
        j = j + 1;
        datasets = datasets2;
        validator = validator2;
        currentValues = currentValues2;
        goto L209
    L219:
        if (Helper.sDebug == false) goto L222;
        Slog.d(TAG, "found a dataset change on id " + id3 + ": from " + datasetValue + " to " + currentValue2);
    L222:
        i3 = i3 + 1;
        datasets = datasets2;
        validator = validator2;
        currentValues = currentValues;
        goto L203
    L213:
        if (Helper.sDebug == false) goto L215;
        datasets2 = datasets;
        StringBuilder r1 = new StringBuilder();
        validator2 = validator;
        r1.append("dataset has value for field that is null: ");
        r1.append(id3);
        Slog.d(TAG, r1.toString());
        currentValues2 = currentValues;
        goto L226
    L215:
        datasets2 = datasets;
        validator2 = validator;
        currentValues2 = currentValues;
        goto L226
    L228:
        if (Helper.sDebug == false) goto L230;
        Slog.d(TAG, "ignoring Save UI because all fields match contents of dataset #" + i3 + ": " + dataset);
    L230:
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(7);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(false, true, 6);
    L232:
        ?? r12 = 1;
    L234:
        IAutoFillManagerClient client = getClient();
        this.mPendingSaveUi = new PendingUi(new Binder(), this.id, client);
        Object r2 = this.mLock;
        monitor-enter(r2);
        Drawable serviceIcon = getServiceIcon(response);     // Catch: Throwable -> L255
        CharSequence serviceLabel = getServiceLabel(response);     // Catch: Throwable -> L255
        monitor-exit(r2);     // Catch: Throwable -> L255
        if (serviceLabel == null) goto L252;
        if (serviceIcon != null) goto L241;
        ?? r10 = 0;
    L253:
        wtf(null, "showSaveLocked(): no service label or icon", new Object[r10]);
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(r12);
        this.mSaveEventLogger.logAndEndEvent();
        return new SaveResult(r10, r12, r10);
    L241:
        getUiForShowing().showSaveUi(serviceLabel, serviceIcon, this.mService.getServicePackageName(), saveInfo, this, this.mComponentName, this, this.mContext, this.mPendingSaveUi, isUpdate, this.mCompatMode, response.getShowSaveDialogIcon(), this.mSaveEventLogger);
        if (client != null) goto L267;
    L247:
        SessionFlags.m2404$$Nest$fputmShowingSaveUi(this.mSessionFlags, true);
        if (Helper.sDebug == false) goto L251;
        Slog.d(TAG, "Good news, everyone! All checks passed, show save UI for " + this.id + "!");
    L251:
        return new SaveResult(true, false, 0);
    L267:
        client.setSaveUiState(this.id, true);     // Catch: RemoteException -> L245
    L245:
        e = move-exception;
        Slog.e(TAG, "Error notifying client to set save UI state to shown: " + e);
        goto L247
    L252:
        r10 = 0;
    L255:
        th = th;
    L261:
        throw th;
    L259:
        th = th;
        goto L261
    L233:
        r12 = 1;
    L168:
        atLeastOneChanged2 = atLeastOneChanged;
        goto L170
    L98:
        boolean allRequiredAreNotEmpty3 = Helper.sDebug;
        if (allRequiredAreNotEmpty3 == false) goto L101;
        Slog.d(TAG, "empty value for required " + id);
    L101:
        allRequiredAreNotEmpty2 = false;
        goto L104
    L57:
        if (candidateSaveValue.isEmpty() == true) goto L62;
        if (Helper.sVerbose == false) goto L61;
        Slog.v(TAG, "current value is empty, using cached last non-empty value instead");
    L61:
        value = candidateSaveValue;
        allRequiredAreNotEmpty = allRequiredAreNotEmpty;
        goto L69
    L51:
        if (value.isEmpty() == true) goto L54;
        allRequiredAreNotEmpty = allRequiredAreNotEmpty;
        goto L69
    L47:
        Slog.w(TAG, "showSaveLocked(): no ViewState for required " + id);
        allRequiredAreNotEmpty2 = false;
        goto L104
    L102:
        allRequiredAreNotEmpty2 = allRequiredAreNotEmpty;
        goto L104
    L103:
        allRequiredAreNotEmpty2 = true;
        goto L104
    L36:
        Log.d(TAG, "showSaveLocked(" + this.id + "): no FEAT_PASSWD_NOTE or is test process, packageName=" + this.mService.getServicePackageName());
        goto L37
    L13:
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "Call to Session#showSaveLocked() rejected - there is credman field in screen");
    L16:
        return new SaveResult(false, true, 0);
    L9:
        saveInfo = response.getSaveInfo();
        goto L11
    }

    private void logSaveShown() {
        this.mService.logSaveShown(this.id, this.mClientState, shouldAddEventToHistory());
    }

    protected AutofillValue getSanitizedValue(ArrayMap<AutofillId, InternalSanitizer> sanitizers, AutofillId id, AutofillValue value) {
        if (sanitizers == null) goto L19;
        if (value == null) goto L19;
        ViewState state = this.mViewStates.get(id);
        if (state != null) goto L8;
        AutofillValue sanitized = null;
    L9:
        if (sanitized != null) goto L18;
        InternalSanitizer sanitizer = sanitizers.get(id);
        if (sanitizer != null) goto L13;
        return value;
    L13:
        sanitized = sanitizer.sanitize(value);
        if (Helper.sDebug == false) goto L16;
        Slog.d(TAG, "Value for " + id + "(" + value + ") sanitized to " + sanitized);
    L16:
        if (state == null) goto L18;
        state.setSanitizedValue(sanitized);
    L18:
        return sanitized;
    L8:
        sanitized = state.getSanitizedValue();
    L19:
        return value;
    }

    boolean isSaveUiShowingLocked() {
        return SessionFlags.m2397$$Nest$fgetmShowingSaveUi(this.mSessionFlags);
    }

    private AssistStructure.ViewNode getViewNodeFromContextsLocked(AutofillId autofillId) {
        int numContexts = this.mContexts.size();
        int i = numContexts - 1;
    L3:
        if (i < 0) goto L8;
        FillContext context = this.mContexts.get(i);
        AssistStructure.ViewNode node = Helper.findViewNodeByAutofillId(context.getStructure(), autofillId);
        if (node != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return node;
    L8:
        return null;
    }

    protected AutofillValue getValueFromContextsLocked(AutofillId autofillId) {
        int numContexts = this.mContexts.size();
        int i = numContexts - 1;
    L3:
        if (i < 0) goto L14;
        FillContext context = this.mContexts.get(i);
        AssistStructure.ViewNode node = Helper.findViewNodeByAutofillId(context.getStructure(), autofillId);
        if (node == null) goto L13;
        AutofillValue value = node.getAutofillValue();
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "getValueFromContexts(" + this.id + SliceClientPermissions.SliceAuthority.DELIMITER + autofillId + ") at " + i + ": " + value);
    L9:
        if (value == null) goto L13;
        if (value.isEmpty() == true) goto L13;
        return value;
    L13:
        i = i - 1;
        goto L3
    L14:
        return null;
    }

    private CharSequence[] getAutofillOptionsFromContextsLocked(AutofillId autofillId) {
        int numContexts = this.mContexts.size();
        int i = numContexts - 1;
    L3:
        if (i < 0) goto L11;
        FillContext context = this.mContexts.get(i);
        AssistStructure.ViewNode node = Helper.findViewNodeByAutofillId(context.getStructure(), autofillId);
        if (node == null) goto L10;
        if (node.getAutofillOptions() == null) goto L10;
        return node.getAutofillOptions();
    L10:
        i = i - 1;
        goto L3
    L11:
        return null;
    }

    private void updateValuesForSaveLocked() {
        ArrayMap<AutofillId, InternalSanitizer> sanitizers = Helper.createSanitizers(getSaveInfoLocked());
        int numContexts = this.mContexts.size();
        int contextNum = 0;
    L3:
        if (contextNum >= numContexts) goto L35;
        FillContext context = this.mContexts.get(contextNum);
        AssistStructure.ViewNode[] nodes = context.findViewNodesByAutofillIds(getIdsOfAllViewStatesLocked());
        if (Helper.sVerbose == false) goto L7;
        Slog.v(TAG, "updateValuesForSaveLocked(): updating " + context);
    L7:
        int viewStateNum = 0;
    L9:
        if (viewStateNum >= this.mViewStates.size()) goto L30;
        ViewState viewState = this.mViewStates.valueAt(viewStateNum);
        AutofillId id = viewState.id;
        AutofillValue value = viewState.getCurrentValue();
        if (value == null) goto L13;
        AssistStructure.ViewNode node = nodes[viewStateNum];
        if (node != null) goto L19;
        Slog.w(TAG, "callSaveLocked(): did not find node with id " + id);
    L29:
        viewStateNum = viewStateNum + 1;
        goto L9
    L19:
        if (Helper.sVerbose == false) goto L21;
        Slog.v(TAG, "updateValuesForSaveLocked(): updating " + id + " to " + value);
    L21:
        AutofillValue sanitizedValue = viewState.getSanitizedValue();
        if (sanitizedValue != null) goto L24;
        sanitizedValue = getSanitizedValue(sanitizers, id, value);
    L24:
        if (sanitizedValue == null) goto L27;
        node.updateAutofillValue(sanitizedValue);
        goto L29
    L27:
        if (Helper.sDebug == false) goto L29;
        Slog.d(TAG, "updateValuesForSaveLocked(): not updating field " + id + " because it failed sanitization");
        goto L29
    L13:
        if (Helper.sVerbose == false) goto L29;
        Slog.v(TAG, "updateValuesForSaveLocked(): skipping " + id);
        goto L29
    L30:
        context.getStructure().sanitizeForParceling(false);
        if (Helper.sVerbose == false) goto L33;
        Slog.v(TAG, "updateValuesForSaveLocked(): dumping structure of " + context + " before calling service.save()");
        context.getStructure().dump(false);
    L33:
        contextNum = contextNum + 1;
        goto L3
    }

    void callSaveLocked() {
        if (this.mDestroyed == false) goto L7;
        Slog.w(TAG, "Call to Session#callSaveLocked() rejected - session: " + this.id + " destroyed");
        this.mSaveEventLogger.maybeSetIsSaved(false);
        this.mSaveEventLogger.logAndEndEvent();
        return;
    L7:
        if (this.mRemoteFillService != null) goto L11;
        wtf(null, "callSaveLocked() called without a remote service. mForAugmentedAutofillOnly: %s", new Object[]{Boolean.valueOf(SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags))});
        this.mSaveEventLogger.maybeSetIsSaved(false);
        this.mSaveEventLogger.logAndEndEvent();
        return;
    L11:
        if (Helper.sVerbose == false) goto L14;
        Slog.v(TAG, "callSaveLocked(" + this.id + "): mViewStates=" + this.mViewStates);
    L14:
        if (this.mContexts != null) goto L17;
        Slog.w(TAG, "callSaveLocked(): no contexts");
        this.mSaveEventLogger.maybeSetIsSaved(false);
        this.mSaveEventLogger.logAndEndEvent();
        return;
    L17:
        updateValuesForSaveLocked();
        cancelCurrentRequestLocked();
        ArrayList<FillContext> contexts = mergePreviousSessionLocked(true);
        FieldClassificationResponse fieldClassificationResponse = ClassificationState.m2383$$Nest$fgetmLastFieldClassificationResponse(this.mClassificationState);
        if (this.mService.isPccClassificationEnabled() == false) goto L26;
        if (fieldClassificationResponse == null) goto L26;
        if (fieldClassificationResponse.getClassifications().isEmpty() == true) goto L26;
        if (this.mClientState != null) goto L25;
        this.mClientState = new Bundle();
    L25:
        this.mClientState.putParcelableArrayList(EXTRA_KEY_DETECTIONS, new ArrayList(fieldClassificationResponse.getClassifications()));
    L26:
        SaveRequest saveRequest = new SaveRequest(contexts, this.mClientState, this.mSelectedDatasetIds);
        this.mRemoteFillService.onSaveRequest(saveRequest);
    }

    private ArrayList<FillContext> mergePreviousSessionLocked(boolean forSave) {
        ArrayList<Session> previousSessions = this.mService.getPreviousSessionsLocked(this);
        if (previousSessions == null) goto L29;
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "mergeSessions(" + this.id + "): Merging the content of " + previousSessions.size() + " sessions for task " + this.taskId);
    L7:
        ArrayList<FillContext> contexts = new ArrayList();
        int i = 0;
    L9:
        if (i >= previousSessions.size()) goto L27;
        Session previousSession = previousSessions.get(i);
        ArrayList<FillContext> previousContexts = previousSession.mContexts;
        if (previousContexts != null) goto L13;
        Slog.w(TAG, "mergeSessions(" + this.id + "): Not merging null contexts from " + previousSession.id);
    L26:
        i = i + 1;
        goto L9
    L13:
        if (forSave == false) goto L16;
        previousSession.updateValuesForSaveLocked();
    L16:
        if (Helper.sDebug == false) goto L18;
        Slog.d(TAG, "mergeSessions(" + this.id + "): adding " + previousContexts.size() + " context from previous session #" + previousSession.id);
    L18:
        contexts.addAll(previousContexts);
        if (this.mClientState != null) goto L26;
        if (previousSession.mClientState == null) goto L26;
        if (Helper.sDebug == false) goto L25;
        Slog.d(TAG, "mergeSessions(" + this.id + "): setting client state from previous session" + previousSession.id);
    L25:
        this.mClientState = previousSession.mClientState;
        goto L26
    L27:
        contexts.addAll(this.mContexts);
        return contexts;
    L29:
        return new ArrayList(this.mContexts);
    }

    private Optional<Integer> requestNewFillResponseOnViewEnteredIfNecessaryLocked(AutofillId id, ViewState viewState, int flags) {
        if (this.mExt.isPasswdAutofillRequest(viewState, id) == false) goto L7;
        return Optional.empty();
    L7:
        if ((flags & 1) == 0) goto L14;
        SessionFlags.m2398$$Nest$fputmAugmentedAutofillOnly(this.mSessionFlags, false);
        if (Helper.sDebug == false) goto L12;
        Slog.d(TAG, "Re-starting session on view " + id + " and flags " + flags);
    L12:
        return requestNewFillResponseLocked(viewState, 256, flags);
    L14:
        if (shouldStartNewPartitionLocked(id, flags) == false) goto L21;
        if (Helper.sDebug == false) goto L18;
        Slog.d(TAG, "Starting partition or augmented request for view id " + id + ": " + viewState.getStateAsString());
    L18:
        SessionFlags.m2398$$Nest$fputmAugmentedAutofillOnly(this.mSessionFlags, false);
        return requestNewFillResponseLocked(viewState, 32, flags);
    L21:
        if (Helper.sVerbose == false) goto L24;
        Slog.v(TAG, "Not starting new partition for view " + id + ": " + viewState.getStateAsString());
    L24:
        return Optional.empty();
    }

    private boolean shouldStartNewPartitionLocked(AutofillId id, int flags) {
        ViewState currentView = this.mViewStates.get(id);
        if (shouldRequestSecondaryProvider(flags) == false) goto L5;
        SparseArray<FillResponse> responses = this.mSecondaryResponses;
    L7:
        if (responses != null) goto L15;
        if (currentView == null) goto L13;
        if ((currentView.getState() & 65536) != 0) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (SessionFlags.m2393$$Nest$fgetmExpiredResponse(this.mSessionFlags) == true) goto L17;
        int numResponses = responses.size();
        if (numResponses < AutofillManagerService.getPartitionMaxCount()) goto L24;
        Slog.e(TAG, "Not starting a new partition on " + id + " because session " + this.id + " reached maximum of " + AutofillManagerService.getPartitionMaxCount());
        return false;
    L24:
        int responseNum = 0;
    L25:
        if (responseNum >= numResponses) goto L51;
        FillResponse response = responses.valueAt(responseNum);
        if (ArrayUtils.contains(response.getIgnoredIds(), id) == true) goto L28;
        SaveInfo saveInfo = response.getSaveInfo();
        if (saveInfo != null) goto L32;
    L36:
        List<Dataset> datasets = response.getDatasets();
        if (datasets == null) goto L47;
        int numDatasets = datasets.size();
        int dataSetNum = 0;
    L39:
        if (dataSetNum >= numDatasets) goto L47;
        ArrayList<AutofillId> fields = datasets.get(dataSetNum).getFieldIds();
        if (fields == null) goto L45;
        if (fields.contains(id) == false) goto L45;
        return false;
    L45:
        dataSetNum = dataSetNum + 1;
    L47:
        if (ArrayUtils.contains(response.getAuthenticationIds(), id) == true) goto L48;
        responseNum = responseNum + 1;
        goto L25
    L48:
        return false;
    L32:
        if (ArrayUtils.contains(saveInfo.getOptionalIds(), id) == true) goto L35;
        if (ArrayUtils.contains(saveInfo.getRequiredIds(), id) == false) goto L36;
    L35:
        return false;
    L28:
        return false;
    L51:
        return true;
    L17:
        if (Helper.sDebug == false) goto L19;
        Slog.d(TAG, "Starting a new partition because the response has expired.");
    L19:
        return true;
    L5:
        responses = this.mResponses;
        goto L7
    }

    boolean shouldRequestSecondaryProvider(int flags) {
        if (this.mService.isAutofillCredmanIntegrationEnabled() == true) goto L5;
    L17:
        return false;
    L5:
        if (this.mSecondaryProviderHandler == null) goto L17;
        if (this.mIsPrimaryCredential == false) goto L14;
        if ((flags & 2048) == 0) goto L12;
        return false;
    L12:
        return true;
    L14:
        if ((flags & 2048) != 0) goto L16;
        return false;
    L16:
        return true;
    }

    void updateLocked(AutofillId id, Rect virtualBounds, AutofillValue value, int action, int flags) {
        if (this.mDestroyed == false) goto L7;
        Slog.w(TAG, "updateLocked(" + id + "):  rejected - session: destroyed");
        return;
    L7:
        if (action != 5) goto L13;
        SessionFlags.m2400$$Nest$fputmExpiredResponse(this.mSessionFlags, true);
        if (Helper.sDebug == false) goto L11;
        Slog.d(TAG, "updateLocked(" + id + "): Set the response has expired.");
    L11:
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReasonIfNoReasonExists(3);
        this.mPresentationStatsEventLogger.logAndEndEvent("ACTION_RESPONSE_EXPIRED");
        return;
    L13:
        id.setSessionId(this.id);
        ViewState viewState = this.mViewStates.get(id);
        if (Helper.sVerbose == false) goto L17;
        Slog.v(TAG, "updateLocked(" + id + "): id=" + this.id + ", action=" + actionAsString(action) + ", flags=" + flags + ", mCurrentViewId=" + this.mCurrentViewId + ", mExpiredResponse=" + SessionFlags.m2393$$Nest$fgetmExpiredResponse(this.mSessionFlags) + ", viewState=" + viewState);
    L17:
        if (viewState != null) goto L41;
        if (action == 1) goto L28;
        if (action == 4) goto L28;
        if (action == 2) goto L28;
        if (Helper.sVerbose == false) goto L220;
        Slog.v(TAG, "Ignoring specific action when viewState=null");
        return;
    L220:
        return;
    L28:
        if (Helper.sVerbose == false) goto L30;
        Slog.v(TAG, "Creating viewState for " + id);
    L30:
        boolean isIgnored = isIgnoredLocked(id);
        if (isIgnored == false) goto L33;
        int r12 = 128;
    L34:
        ViewState viewState2 = new ViewState(id, this, r12, this.mIsPrimaryCredential);
        this.mViewStates.put(id, viewState2);
        if (isIgnored == true) goto L37;
        ViewState viewState3 = viewState2;
    L42:
        boolean r11 = false;
        if ((flags & 256) == 0) goto L49;
        if (Helper.sDebug == false) goto L47;
        Log.d(TAG, "force to reset fill dialog state");
    L47:
        SessionFlags.m2401$$Nest$fputmFillDialogDisabled(this.mSessionFlags, false);
    L49:
        if ((flags & 512) == 0) goto L53;
        requestAssistStructureForPccLocked(flags);
        return;
    L53:
        if ((flags & 1024) == 0) goto L56;
        SessionFlags.m2403$$Nest$fputmScreenHasCredmanField(this.mSessionFlags, true);
    L56:
        switch(action) {
            case 1: goto L203;
            case 2: goto L105;
            case 3: goto L96;
            case 4: goto L59;
            default: goto L57;
        };
    L57:
        Slog.w(TAG, "updateLocked(): unknown action: " + action);
        return;
    L105:
        this.mLatencyBaseTime = SystemClock.elapsedRealtime();
        boolean wasPreviouslyFillDialog = this.mPreviouslyFillDialogPotentiallyStarted;
        this.mPreviouslyFillDialogPotentiallyStarted = false;
        if (Helper.sVerbose == false) goto L109;
        if (virtualBounds == null) goto L109;
        Slog.v(TAG, "entered on virtual child " + id + ": " + virtualBounds);
    L109:
        boolean isSameViewEntered = Objects.equals(this.mCurrentViewId, viewState3.id);
        this.mCurrentViewId = viewState3.id;
        if (value == null) goto L113;
        viewState3.setCurrentValue(value);
    L113:
        if (isSameViewEntered == false) goto L115;
    L118:
        boolean r0 = true;
    L120:
        if (this.mCurrentViewId == null) goto L123;
        this.mPreviousNonNullEnteredViewId = this.mCurrentViewId;
    L123:
        if ((flags & 2048) == 0) goto L125;
        r11 = true;
    L125:
        boolean isCredmanRequested = r11;
        if (shouldRequestSecondaryProvider(flags) == false) goto L137;
        Optional<Integer> maybeRequestIdCred = requestNewFillResponseOnViewEnteredIfNecessaryLocked(id, viewState3, flags);
        if (maybeRequestIdCred.isPresent() == false) goto L131;
        Slog.v(TAG, "Started a new fill request for secondary provider.");
        return;
    L131:
        FillResponse response = viewState3.getSecondaryResponse();
        if (response == null) goto L134;
        logPresentationStatsOnViewEnteredLocked(response, isCredmanRequested);
    L134:
        viewState3.update(value, virtualBounds, flags);
        return;
    L137:
        if (this.mCompatMode == true) goto L139;
    L144:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L200:
        th = th;
    L201:
        monitor-exit(r4);     // Catch: Throwable -> L200
        throw th;
    L147:
        if (this.mLogViewEntered == false) goto L214;
    L151:
        this.mLogViewEntered = true;     // Catch: Throwable -> L149
        monitor-exit(r4);     // Catch: Throwable -> L149
        if ((flags & 1) == 0) goto L156;
    L175:
        Optional<Integer> maybeNewRequestId = requestNewFillResponseOnViewEnteredIfNecessaryLocked(id, viewState3, flags);
        if (wasPreviouslyFillDialog == true) goto L184;
        if (isSameViewEntered == true) goto L179;
    L180:
        this.mPresentationStatsEventLogger.logAndEndEvent("new view entered");
        startNewEventForPresentationStatsEventLogger();
        if (maybeNewRequestId.isPresent() == false) goto L184;
        this.mPresentationStatsEventLogger.maybeSetRequestId(maybeNewRequestId.get().intValue());
        goto L184
    L179:
        if (maybeNewRequestId.isPresent() == true) goto L180;
    L184:
        logPresentationStatsOnViewEnteredLocked(viewState3.getResponse(), isCredmanRequested);
        this.mPresentationStatsEventLogger.updateTextFieldLength(value);
        if (isSameViewEntered == false) goto L189;
        setFillDialogDisabledAndStartInput();
        return;
    L189:
        if (this.mExt.isPasswdAutofillRequest(viewState3, id) == true) goto L216;
        viewState3.update(value, virtualBounds, flags);
        return;
    L216:
        this.mExt.showAutofillUi(viewState3.getResponse(), this.mViewStates, id, value, viewState3, virtualBounds, flags);     // Catch: Exception -> L194
        return;
    L194:
        e = e;
    L198:
        Slog.e(TAG, "showAutofillUi error:", e);
        return;
    L196:
        e = e;
        goto L198
    L156:
        if (this.mAugmentedAutofillableIds == null) goto L169;
        if (this.mAugmentedAutofillableIds.contains(id) == false) goto L169;
        if (isSameViewEntered == true) goto L165;
        if (Helper.sDebug == false) goto L163;
        Slog.d(TAG, "trigger augmented autofill.");
    L163:
        triggerAugmentedAutofillLocked(flags);
        return;
    L165:
        if (Helper.sDebug == false) goto L226;
        Slog.d(TAG, "skip augmented autofill for same view: same view entered");
        return;
    L226:
        return;
    L169:
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == false) goto L175;
        if (isSameViewEntered == false) goto L175;
        if (Helper.sDebug == false) goto L227;
        Slog.d(TAG, "skip augmented autofill for same view: standard autofill disabled.");
        return;
    L227:
        return;
    L149:
        th = th;
        goto L201
    L214:
        this.mService.logViewEntered(this.id, null, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L149
        goto L151
    L139:
        if ((viewState3.getState() & 512) == 0) goto L144;
        if (Helper.sDebug == false) goto L224;
        Slog.d(TAG, "Ignoring VIEW_ENTERED on URL BAR (id=" + id + ")");
        return;
    L224:
        return;
    L115:
        if (Objects.equals(this.mCurrentViewId, this.mPreviousNonNullEnteredViewId) == true) goto L118;
        r0 = false;
        goto L120
    L203:
        this.mCurrentViewId = viewState3.id;
        this.mPreviousNonNullEnteredViewId = viewState3.id;
        viewState3.update(value, virtualBounds, flags);
        startNewEventForPresentationStatsEventLogger();
        this.mPresentationStatsEventLogger.maybeSetIsNewRequest(true);
        if (isRequestSupportFillDialog(flags) == true) goto L206;
        SessionFlags.m2401$$Nest$fputmFillDialogDisabled(this.mSessionFlags, true);
        this.mPreviouslyFillDialogPotentiallyStarted = false;
    L207:
        Optional<Integer> maybeRequestId = requestNewFillResponseLocked(viewState3, 16, flags);
        if (maybeRequestId.isPresent() == false) goto L234;
        this.mPresentationStatsEventLogger.maybeSetRequestId(maybeRequestId.get().intValue());
        return;
    L234:
        return;
    L206:
        this.mPreviouslyFillDialogPotentiallyStarted = true;
        goto L207
    L59:
        if (this.mCompatMode == false) goto L93;
        if ((viewState3.getState() & 512) == 0) goto L93;
        if (this.mUrlBar != null) goto L65;
        String currentUrl = null;
    L66:
        if (currentUrl != null) goto L69;
        wtf(null, "URL bar value changed, but current value is null", new Object[0]);
        return;
    L69:
        if (value != null) goto L71;
    L90:
        wtf(null, "URL bar value changed to null or non-text: %s", new Object[]{value});
        return;
    L71:
        if (value.isText() == false) goto L90;
        String newUrl = value.getTextValue().toString();
        if (newUrl.equals(currentUrl) == false) goto L80;
        if (Helper.sDebug == false) goto L222;
        Slog.d(TAG, "Ignoring change on URL bar as it's the same");
        return;
    L222:
        return;
    L80:
        if (this.mSaveOnAllViewsInvisible == false) goto L86;
        if (Helper.sDebug == false) goto L223;
        Slog.d(TAG, "Ignoring change on URL because session will finish when views are gone");
        return;
    L223:
        return;
    L86:
        if (Helper.sDebug == false) goto L88;
        Slog.d(TAG, "Finishing session because URL bar changed");
    L88:
        forceRemoveFromServiceLocked(5);
        return;
    L65:
        currentUrl = this.mUrlBar.getText().toString().trim();
    L93:
        if (Objects.equals(value, viewState3.getCurrentValue()) == true) goto L229;
        logIfViewClearedLocked(id, value, viewState3);
        updateViewStateAndUiOnValueChangedLocked(id, value, viewState3, flags);
        return;
    L229:
        return;
    L96:
        if (Objects.equals(this.mCurrentViewId, viewState3.id) == true) goto L98;
        return;
    L98:
        if (Helper.sVerbose == false) goto L100;
        Slog.v(TAG, "Exiting view " + id);
    L100:
        this.mUi.hideFillUi(this);
        this.mUi.hideFillDialog(this);
        hideAugmentedAutofillLocked(viewState3);
        this.mInlineSessionController.resetInlineFillUiLocked();
        if ((viewState3.getState() & 65536) != 0) goto L104;
        this.mCurrentViewId = null;
    L104:
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(2);
        return;
    L37:
        if (Helper.sDebug == false) goto L221;
        Slog.d(TAG, "updateLocked(): ignoring view " + viewState2);
        return;
    L221:
        return;
    L33:
        r12 = 1;
        goto L34
    L41:
        viewState3 = viewState;
        goto L42
    }

    private void logPresentationStatsOnViewEnteredLocked(FillResponse response, boolean isCredmanRequested) {
        this.mPresentationStatsEventLogger.maybeSetIsCredentialRequest(isCredmanRequested);
        this.mPresentationStatsEventLogger.maybeSetFieldClassificationRequestId(this.mFieldClassificationIdSnapshot);
        this.mPresentationStatsEventLogger.maybeSetAutofillServiceUid(getAutofillServiceUid());
        this.mPresentationStatsEventLogger.maybeSetFocusedId(this.mCurrentViewId);
        if (response == null) goto L6;
        this.mPresentationStatsEventLogger.maybeSetRequestId(response.getRequestId());
        this.mPresentationStatsEventLogger.maybeSetAvailableCount(response.getDatasets(), this.mCurrentViewId);
        return;
    }

    private void hideAugmentedAutofillLocked(ViewState viewState) {
        if ((viewState.getState() & 4096) == 0) goto L6;
        viewState.resetState(4096);
        cancelAugmentedAutofillLocked();
        return;
    }

    private boolean isIgnoredLocked(AutofillId id) {
        FillResponse response = getLastResponseLocked(null);
        if (response != null) goto L7;
        return false;
    L7:
        return ArrayUtils.contains(response.getIgnoredIds(), id);
    }

    private void logIfViewClearedLocked(AutofillId id, AutofillValue value, ViewState viewState) {
        if (value == null) goto L6;
        if (value.isEmpty() == true) goto L6;
        return;
    L6:
        if (viewState.getCurrentValue() != null) goto L8;
        return;
    L8:
        if (viewState.getCurrentValue().isText() == true) goto L10;
        return;
    L10:
        if (viewState.getCurrentValue().getTextValue() != null) goto L12;
        return;
    L12:
        if (getSaveInfoLocked() == null) goto L22;
        int length = viewState.getCurrentValue().getTextValue().length();
        if (Helper.sDebug == false) goto L16;
        Slog.d(TAG, "updateLocked(" + id + "): resetting value that was " + length + " chars long");
    L16:
        LogMaker log = newLogMaker(1124).addTaggedData(1125, Integer.valueOf(length));
        this.mMetricsLogger.write(log);
        return;
    }

    private void updateViewStateAndUiOnValueChangedLocked(AutofillId id, AutofillValue value, ViewState viewState, int flags) {
        String textValue = null;
        if (this.mIgnoreViewStateResetToEmpty == false) goto L19;
        if (value == null) goto L8;
        if (value.isEmpty() == false) goto L19;
    L8:
        if (viewState.getCurrentValue() == null) goto L19;
        if (viewState.getCurrentValue().isText() == false) goto L19;
        if (viewState.getCurrentValue().getTextValue() == null) goto L19;
        if (viewState.getCurrentValue().getTextValue().length() <= 1) goto L19;
        if (Helper.sVerbose == false) goto L18;
        Slog.v(TAG, "value is resetting to empty, caching the last non-empty value");
    L18:
        viewState.setCandidateSaveValue(viewState.getCurrentValue());
    L20:
        if (value != null) goto L22;
    L29:
        textValue = null;
    L30:
        updateFilteringStateOnValueChangedLocked(textValue, viewState);
        viewState.setCurrentValue(value);
        String filterText = textValue;
        AutofillValue filledValue = viewState.getAutofilledValue();
        if (textValue == null) goto L34;
        this.mPresentationStatsEventLogger.onFieldTextUpdated(viewState, value);
    L34:
        if (filledValue == null) goto L51;
        if (filledValue.equals(value) == false) goto L43;
        if (Helper.sVerbose == false) goto L40;
        Slog.v(TAG, "ignoring autofilled change on id " + id);
    L40:
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(viewState.id);
        viewState.resetState(8);
        return;
    L43:
        if (viewState.id.equals(this.mCurrentViewId) == false) goto L51;
        if ((viewState.getState() & 4) == 0) goto L51;
        if (Helper.sVerbose == false) goto L49;
        Slog.v(TAG, "field changed after autofill on id " + id);
    L49:
        viewState.resetState(4);
        ViewState currentView = this.mViewStates.get(this.mCurrentViewId);
        currentView.maybeCallOnFillReady(flags);
    L51:
        if (viewState.id.equals(this.mCurrentViewId) == false) goto L59;
        if ((viewState.getState() & 8192) == 0) goto L59;
        if ((viewState.getState() & 32768) == 0) goto L57;
        this.mInlineSessionController.disableFilterMatching(viewState.id);
    L57:
        this.mInlineSessionController.filterInlineFillUiLocked(this.mCurrentViewId, filterText);
    L65:
        viewState.setState(8);
        getUiForShowing().filterFillUi(filterText, this);
        return;
    L59:
        if (viewState.id.equals(this.mCurrentViewId) == false) goto L65;
        if ((viewState.getState() & 4096) == 0) goto L65;
        if (TextUtils.isEmpty(filterText) == true) goto L65;
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(this.mCurrentViewId);
        goto L65
    L22:
        if (value.isText() == false) goto L29;
        CharSequence text = value.getTextValue();
        if (text == null) goto L30;
        textValue = text.toString();
    L19:
        viewState.setCandidateSaveValue(null);
        goto L20
    }

    private void updateFilteringStateOnValueChangedLocked(String newTextValue, ViewState viewState) {
        if (newTextValue != null) goto L4;
        newTextValue = "";
    L4:
        AutofillValue currentValue = viewState.getCurrentValue();
        if (currentValue != null) goto L7;
    L10:
        String currentTextValue = "";
    L12:
        if ((viewState.getState() & 16384) != 0) goto L17;
        if (Helper.containsCharsInOrder(newTextValue, currentTextValue) == true) goto L20;
        viewState.setState(16384);
        return;
    L20:
        return;
    L17:
        if (Helper.containsCharsInOrder(currentTextValue, newTextValue) == true) goto L22;
        viewState.setState(32768);
        return;
    L22:
        return;
    L7:
        if (currentValue.isText() == false) goto L10;
        currentTextValue = currentValue.getTextValue().toString();
        goto L12
    }

    private void resetImeAnimationState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWaitForImeAnimation = false;     // Catch: Throwable -> L8
        this.mImeAnimationStartTimeMs = -1;     // Catch: Throwable -> L8
        this.mImeAnimationFinishTimeMs = -1;     // Catch: Throwable -> L8
        this.mLastInputStartTime = -1;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.ViewState.Listener
    public void onFillReady(FillResponse response, AutofillId filledId, AutofillValue value, int flags) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mPresentationStatsEventLogger.maybeSetFieldClassificationRequestId(this.mFieldClassificationIdSnapshot);     // Catch: Throwable -> L9
        if (this.mDestroyed == false) goto L11;
        Slog.w(TAG, "Call to Session#onFillReady() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(9);     // Catch: Throwable -> L9
        this.mSaveEventLogger.logAndEndEvent();     // Catch: Throwable -> L9
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(6);     // Catch: Throwable -> L9
        this.mPresentationStatsEventLogger.logAndEndEvent("on fill ready");     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L9
        if (value != null) goto L15;
    L17:
        String filterText = null;
    L18:
        Object r4 = this.mService.mLock;
        monitor-enter(r4);
        CharSequence serviceLabel = this.mService.getServiceLabelLocked();     // Catch: Throwable -> L87
        Drawable serviceIcon = this.mService.getServiceIconLocked();     // Catch: Throwable -> L87
        monitor-exit(r4);     // Catch: Throwable -> L87
        if (serviceLabel == null) goto L85;
        if (serviceIcon == null) goto L85;
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mPresentationStatsEventLogger.maybeSetSuggestionSentTimestampMs();     // Catch: Throwable -> L78
        monitor-exit(r5);     // Catch: Throwable -> L78
        AutofillId[] ids = response.getFillDialogTriggerIds();
        if (ids == null) goto L50;
        if (ArrayUtils.contains(ids, filledId) == false) goto L50;
        int fillDialogState = requestShowFillDialog(response, filledId, filterText, flags);
        if (fillDialogState != 1) goto L45;
        Object r6 = this.mLock;
        monitor-enter(r6);
        ViewState currentView = this.mViewStates.get(this.mCurrentViewId);     // Catch: Throwable -> L42
        currentView.setState(131072);     // Catch: Throwable -> L42
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(0);     // Catch: Throwable -> L42
        monitor-exit(r6);     // Catch: Throwable -> L42
        setFillDialogDisabled();
        resetImeAnimationState();
        return;
    L42:
        th = move-exception;
        throw th;
    L45:
        if (fillDialogState != 0) goto L47;
        resetImeAnimationState();
        setFillDialogDisabled();
        goto L50
    L47:
        return;
    L50:
        if (response.supportsInlineSuggestions() == false) goto L64;
        Object r7 = this.mLock;
        monitor-enter(r7);
    L58:
        th = move-exception;
        throw th;
    L54:
        if (requestShowInlineSuggestionsLocked(response, filterText) == false) goto L60;
        ViewState currentView2 = this.mViewStates.get(this.mCurrentViewId);     // Catch: Throwable -> L58
        currentView2.setState(8192);     // Catch: Throwable -> L58
        this.mPresentationStatsEventLogger.maybeSetInlinePresentationAndSuggestionHostUid(this.mContext, this.userId);     // Catch: Throwable -> L58
        monitor-exit(r7);     // Catch: Throwable -> L58
        return;
    L60:
        monitor-exit(r7);     // Catch: Throwable -> L58
    L64:
        getUiForShowing().showFillUi(filledId, response, filterText, this.mService.getServicePackageName(), this.mComponentName, serviceLabel, serviceIcon, this, this.mContext, this.id, this.mCompatMode, this.mService.getMaster().getMaxInputLengthForAutofill());
        Object r2 = this.mLock;
        monitor-enter(r2);
    L71:
        th = move-exception;
        throw th;
    L67:
        if (this.mUiShownTime != 0) goto L74;
        this.mUiShownTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L71
        long duration = this.mUiShownTime - this.mStartTime;     // Catch: Throwable -> L71
        if (Helper.sDebug == false) goto L73;
        StringBuilder msg = new StringBuilder("1st UI for ");     // Catch: Throwable -> L71
        msg.append(this.mActivityToken);     // Catch: Throwable -> L71
        msg.append(" shown in ");     // Catch: Throwable -> L71
        TimeUtils.formatDuration(duration, msg);     // Catch: Throwable -> L71
        Slog.d(TAG, msg.toString());     // Catch: Throwable -> L71
    L73:
        StringBuilder historyLog = new StringBuilder("id=");     // Catch: Throwable -> L71
        historyLog.append(this.id);     // Catch: Throwable -> L71
        historyLog.append(" app=");     // Catch: Throwable -> L71
        historyLog.append(this.mActivityToken);     // Catch: Throwable -> L71
        historyLog.append(" svc=");     // Catch: Throwable -> L71
        historyLog.append(this.mService.getServicePackageName());     // Catch: Throwable -> L71
        historyLog.append(" latency=");     // Catch: Throwable -> L71
        TimeUtils.formatDuration(duration, historyLog);     // Catch: Throwable -> L71
        this.mUiLatencyHistory.log(historyLog.toString());     // Catch: Throwable -> L71
        addTaggedDataToRequestLogLocked(response.getRequestId(), 1145, Long.valueOf(duration));     // Catch: Throwable -> L71
    L74:
        monitor-exit(r2);     // Catch: Throwable -> L71
        return;
    L78:
        th = th;
    L104:
        throw th;
    L82:
        th = th;
    L85:
        wtf(null, "onFillReady(): no service label or icon", new Object[0]);
        return;
    L87:
        th = th;
    L109:
        throw th;
    L91:
        th = th;
        goto L109
    L15:
        if (value.isText() == false) goto L17;
        String filterText2 = value.getTextValue().toString();
        filterText = filterText2;
    L9:
        th = th;
    L97:
        throw th;
    L95:
        th = th;
        goto L97
    }

    private boolean isCredmanIntegrationActive(FillResponse response) {
        if ((response.getFlags() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateFillDialogTriggerIdsLocked() {
        List<AutofillId> r0 = null;
        FillResponse response = getLastResponseLocked(null);
        if (response != null) goto L5;
        return;
    L5:
        AutofillId[] ids = response.getFillDialogTriggerIds();
        if (ids == null) goto L9;
        r0 = Arrays.asList(ids);
    L9:
        notifyClientFillDialogTriggerIds(r0);
    }

    private void notifyClientFillDialogTriggerIds(List<AutofillId> fieldIds) {
    L6:
        e = move-exception;
        Slog.w(TAG, "Cannot set trigger ids for fill dialog", e);
        return;
    L4:
        if (Helper.sVerbose == false) goto L8;
        Slog.v(TAG, "notifyFillDialogTriggerIds(): " + fieldIds);     // Catch: RemoteException -> L6
    L8:
        getClient().notifyFillDialogTriggerIds(fieldIds);     // Catch: RemoteException -> L6
    }

    private boolean isFillDialogUiEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (SessionFlags.m2394$$Nest$fgetmFillDialogDisabled(this.mSessionFlags) == false) goto L10;
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(1);     // Catch: Throwable -> L7
    L10:
        if (SessionFlags.m2396$$Nest$fgetmScreenHasCredmanField(this.mSessionFlags) == false) goto L13;
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(2);     // Catch: Throwable -> L7
    L13:
        if (SessionFlags.m2394$$Nest$fgetmFillDialogDisabled(this.mSessionFlags) == false) goto L15;
    L17:
        r2 = false;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L15:
        if (SessionFlags.m2396$$Nest$fgetmScreenHasCredmanField(this.mSessionFlags) == true) goto L17;
    L7:
        th = move-exception;
        throw th;
    }

    private void enableFillDialog() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Enabling Fill Dialog....");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SessionFlags.m2401$$Nest$fputmFillDialogDisabled(this.mSessionFlags, false);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        notifyClientFillDialogTriggerIds(null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void setFillDialogDisabled() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Disabling Fill Dialog.");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SessionFlags.m2401$$Nest$fputmFillDialogDisabled(this.mSessionFlags, true);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        notifyClientFillDialogTriggerIds(null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void setFillDialogDisabledAndStartInput() {
        if (getUiForShowing().isFillDialogShowing() == false) goto L12;
        setFillDialogDisabled();
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillId id = this.mCurrentViewId;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        requestShowSoftInput(id);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private int requestShowFillDialog(FillResponse response, AutofillId filledId, String filterText, int flags) {
        if (isFillDialogUiEnabled() == true) goto L9;
        if (Helper.sDebug == false) goto L7;
        Log.w(TAG, "requestShowFillDialog(): fill dialog is disabled");
    L7:
        return 0;
    L9:
        if (this.mImproveFillDialogEnabled == true) goto L20;
        if ((flags & 128) == 0) goto L17;
        if (Helper.sDebug == false) goto L15;
        Log.w(TAG, "requestShowFillDialog(): IME is showing");
    L15:
        return 0;
    L17:
        if (this.mInlineSessionController.isImeShowing() == false) goto L20;
        return 0;
    L20:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L56:
        th = th;
    L65:
        monitor-exit(r4);     // Catch: Throwable -> L36
        throw th;
    L23:
        if (this.mLastFillDialogTriggerIds == null) goto L60;
        if (ArrayUtils.contains(this.mLastFillDialogTriggerIds, filledId) == false) goto L60;
        if (this.mImproveFillDialogEnabled == true) goto L32;
    L53:
        monitor-exit(r4);     // Catch: Throwable -> L36
        showFillDialog(response, filledId, filterText);
        return 1;
    L32:
        if (this.mInlineSessionController.isImeShowing() == false) goto L53;
        long currentTimestampMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L36
        long durationMs = currentTimestampMs - this.mLastInputStartTime;     // Catch: Throwable -> L36
        if (Helper.sVerbose == false) goto L39;
        Log.d(TAG, "IME is showing. Checking for elapsed time ");     // Catch: Throwable -> L36
        Log.d(TAG, "IME is showing. Timestamps start: " + this.mLastInputStartTime + " current: " + currentTimestampMs + " duration: " + durationMs + " mFillDialogTimeoutMs: " + this.mFillDialogTimeoutMs);     // Catch: Throwable -> L36
    L39:
        if (this.mWaitForImeAnimation == false) goto L43;
        Log.d(TAG, "Waiting for ime animation to complete before showing fill dialog");     // Catch: Throwable -> L36
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(4);     // Catch: Throwable -> L36
        this.mFillDialogRunnable = createFillDialogEvalRunnable(response, filledId, filterText, flags);     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 2;
    L43:
        long effectiveDuration = currentTimestampMs - Math.max(this.mLastInputStartTime, this.mImeAnimationFinishTimeMs);     // Catch: Throwable -> L36
        this.mPresentationStatsEventLogger.maybeSetFillDialogReadyToShowMs(currentTimestampMs);     // Catch: Throwable -> L36
        this.mPresentationStatsEventLogger.maybeSetImeAnimationFinishMs(Math.max(this.mLastInputStartTime, this.mImeAnimationFinishTimeMs));     // Catch: Throwable -> L36
        if (effectiveDuration < this.mFillDialogTimeoutMs) goto L49;
        Log.d(TAG, "Fill dialog not shown since IME has been up for more time than " + this.mFillDialogTimeoutMs + "ms");     // Catch: Throwable -> L36
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(5);     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 0;
    L49:
        if (effectiveDuration >= this.mFillDialogMinWaitAfterImeAnimationMs) goto L53;
        Runnable runnable = createFillDialogEvalRunnable(response, filledId, filterText, flags);     // Catch: Throwable -> L36
        this.mHandler.postDelayed(runnable, this.mFillDialogMinWaitAfterImeAnimationMs - effectiveDuration);     // Catch: Throwable -> L36
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(6);     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 2;
    L60:
        if (Helper.sDebug == false) goto L62;
        Log.w(TAG, "Last fill dialog triggered ids are changed.");     // Catch: Throwable -> L36
    L62:
        this.mPresentationStatsEventLogger.maybeSetFillDialogNotShownReason(3);     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 0;
    L36:
        th = th;
        goto L65
    }

    private Runnable createFillDialogEvalRunnable(final FillResponse response, final AutofillId filledId, final String filterText, final int flags) {
        return new Session$$ExternalSyntheticLambda8(this, filterText, response, filledId, flags);
    }

    private /* synthetic */ void lambda$createFillDialogEvalRunnable$1(String filterText, FillResponse response, AutofillId filledId, int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillValue value = AutofillValue.forText(filterText);     // Catch: Throwable -> L7
        onFillReady(response, filledId, value, flags);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void showFillDialog(FillResponse response, AutofillId filledId, String filterText) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        Drawable serviceIcon = getServiceIcon(response);     // Catch: Throwable -> L13
        PresentationStatsEventLogger logger = this.mPresentationStatsEventLogger;     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L9
        getUiForShowing().showFillDialog(filledId, response, filterText, this.mService.getServicePackageName(), this.mComponentName, serviceIcon, this, this.id, this.mCompatMode, logger, this.mLock);
        return;
    L9:
        th = th;
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L14
    L15:
        throw th;
    L11:
        th = th;
        goto L14
    L22:
        th = th;
        goto L14
    }

    private Drawable getServiceIcon(FillResponse response) {
        Drawable serviceIcon = null;
        int iconResourceId = response.getIconResourceId();
        if (iconResourceId == 0) goto L10;
        long token = Binder.clearCallingIdentity();
        serviceIcon = this.mService.getMaster().getContext().getPackageManager().getDrawable(this.mService.getServicePackageName(), iconResourceId, null);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L10:
        if (serviceIcon != null) goto L15;
        Drawable serviceIcon2 = this.mService.getServiceIconLocked();
        return serviceIcon2;
    L15:
        return serviceIcon;
    }

    private CharSequence getServiceLabel(FillResponse response) {
        CharSequence serviceLabel = null;
        int customServiceNameId = response.getServiceDisplayNameResourceId();
        if (customServiceNameId == 0) goto L10;
        long token = Binder.clearCallingIdentity();
        serviceLabel = this.mService.getMaster().getContext().getPackageManager().getText(this.mService.getServicePackageName(), customServiceNameId, null);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L10:
        if (serviceLabel != null) goto L15;
        CharSequence serviceLabel2 = this.mService.getServiceLabelLocked();
        return serviceLabel2;
    L15:
        return serviceLabel;
    }

    private boolean requestShowInlineSuggestionsLocked(final FillResponse response, String filterText) {
        if (this.mCurrentViewId != null) goto L6;
        Log.w(TAG, "requestShowInlineSuggestionsLocked(): no view currently focused");
        return false;
    L6:
        final AutofillId focusedId = this.mCurrentViewId;
        Optional<InlineSuggestionsRequest> inlineSuggestionsRequest = this.mInlineSessionController.getInlineSuggestionsRequestLocked();
        if (inlineSuggestionsRequest.isPresent() == true) goto L10;
        Log.w(TAG, "InlineSuggestionsRequest unavailable");
        return false;
    L10:
        RemoteInlineSuggestionRenderService remoteRenderService = this.mService.getRemoteInlineSuggestionRenderServiceLocked();
        if (remoteRenderService != null) goto L14;
        Log.w(TAG, "RemoteInlineSuggestionRenderService not found");
        return false;
    L14:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mLoggedInlineDatasetShown = false;     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        InlineFillUi.InlineFillUiInfo inlineFillUiInfo = new InlineFillUi.InlineFillUiInfo(inlineSuggestionsRequest.get(), focusedId, filterText, remoteRenderService, this.userId, this.id);
        InlineFillUi inlineFillUi = InlineFillUi.forAutofill(inlineFillUiInfo, response, new AnonymousClass3(this, response, focusedId), this.mService.getMaster().getMaxInputLengthForAutofill());
        return this.mInlineSessionController.setInlineFillUiLocked(inlineFillUi);
    L20:
        th = th;
    L28:
        throw th;
    L24:
        th = th;
        goto L28
    }

    private ResultReceiver constructCredentialManagerCallback(final int requestId) {
        final Handler r1 = this.mHandler;
        ResultReceiver resultReceiver = new AnonymousClass4(this, r1, requestId);
        ResultReceiver ipcFriendlyResultReceiver = toIpcFriendlyResultReceiver(resultReceiver);
        return ipcFriendlyResultReceiver;
    }

    private ResultReceiver toIpcFriendlyResultReceiver(ResultReceiver resultReceiver) {
        Parcel parcel = Parcel.obtain();
        resultReceiver.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ResultReceiver ipcFriendly = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        return ipcFriendly;
    }

    boolean isDestroyed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDestroyed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    IAutoFillManagerClient getClient() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IAutoFillManagerClient r1 = this.mClient;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyUnavailableToClient(int sessionFinishedState, ArrayList<AutofillId> autofillableIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentViewId != null) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L25:
    L13:
        e = move-exception;
        Slog.e(TAG, "Error notifying client no fill UI: id=" + this.mCurrentViewId, e);     // Catch: Throwable -> L8
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mHasCallback == false) goto L15;
        this.mClient.notifyNoFillUi(this.id, this.mCurrentViewId, sessionFinishedState);     // Catch: Throwable -> L8 RemoteException -> L13
    L24:
    L15:
        if (sessionFinishedState == 0) goto L24;
        this.mClient.setSessionFinished(sessionFinishedState, autofillableIds);     // Catch: Throwable -> L8 RemoteException -> L13
        goto L24
    }

    private void notifyDisableAutofillToClient(long disableDuration, ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentViewId != null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        this.mClient.notifyDisableAutofill(disableDuration, componentName);     // Catch: Throwable -> L8 RemoteException -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Error notifying client disable autofill: id=" + this.mCurrentViewId, e);     // Catch: Throwable -> L8
        goto L14
    }

    private void updateTrackedIdsLocked() {
        FillResponse response = getLastResponseLocked(null);
        if (response != null) goto L5;
        return;
    L5:
        ArraySet<AutofillId> trackedViews = null;
        this.mSaveOnAllViewsInvisible = false;
        SaveInfo saveInfo = response.getSaveInfo();
        if (saveInfo == null) goto L28;
        AutofillId saveTriggerId = saveInfo.getTriggerId();
        if (saveTriggerId == null) goto L10;
        writeLog(1228);
        this.mSaveEventLogger.maybeSetSaveUiShownReason(3);
    L10:
        int flags = saveInfo.getFlags();
        if ((flags & 1) == 0) goto L13;
        boolean r11 = true;
    L14:
        this.mSaveOnAllViewsInvisible = r11;
        this.mFillResponseEventLogger.maybeSetSaveUiTriggerIds(1);
        this.mSaveEventLogger.maybeSetRequestId(response.getRequestId());
        this.mSaveEventLogger.maybeSetAppPackageUid(this.uid);
        this.mSaveEventLogger.maybeSetSaveUiTriggerIds(1);
        this.mSaveEventLogger.maybeSetFlag(flags);
        if (this.mSaveOnAllViewsInvisible == false) goto L25;
        if (0 != 0) goto L19;
        trackedViews = new ArraySet();
    L19:
        if (saveInfo.getRequiredIds() == null) goto L22;
        Collections.addAll(trackedViews, saveInfo.getRequiredIds());
        this.mSaveEventLogger.maybeSetSaveUiShownReason(1);
    L22:
        if (saveInfo.getOptionalIds() == null) goto L25;
        Collections.addAll(trackedViews, saveInfo.getOptionalIds());
        this.mSaveEventLogger.maybeSetSaveUiShownReason(2);
    L25:
        if ((flags & 2) == 0) goto L27;
        this.mSaveEventLogger.maybeSetSaveUiShownReason(0);
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(8);
        boolean saveOnFinish = false;
        AutofillId saveTriggerId2 = saveTriggerId;
        int flags2 = flags;
        ArraySet<AutofillId> trackedViews2 = trackedViews;
    L30:
        if (response.getAuthentication() == null) goto L32;
        boolean hasAuthentication = true;
    L33:
        List<Dataset> datasets = response.getDatasets();
        ArraySet<AutofillId> fillableIds = null;
        if (datasets == null) goto L56;
        int i = 0;
    L37:
        if (i >= datasets.size()) goto L55;
        Dataset dataset = datasets.get(i);
        ArrayList<AutofillId> fieldIds = dataset.getFieldIds();
        if (fieldIds == null) goto L54;
        int j = 0;
    L43:
        if (j >= fieldIds.size()) goto L52;
        AutofillId id = fieldIds.get(j);
        if (id == null) goto L50;
        if (trackedViews2 != null) goto L48;
    L49:
        fillableIds = ArrayUtils.add(fillableIds, id);
        goto L50
    L48:
        if (trackedViews2.contains(id) == false) goto L49;
    L50:
        j = j + 1;
        goto L43
    L52:
        if (dataset.getAuthentication() == null) goto L54;
        hasAuthentication = true;
    L54:
        i = i + 1;
        goto L37
    L55:
        boolean hasAuthentication2 = hasAuthentication;
        ArraySet<AutofillId> fillableIds2 = fillableIds;
    L102:
        boolean hasAuthentication3 = Helper.sVerbose;     // Catch: RemoteException -> L92
        if (hasAuthentication3 == false) goto L110;
        StringBuilder r0 = new StringBuilder();     // Catch: RemoteException -> L65
        r0.append("updateTrackedIdsLocked(): trackedViews: ");     // Catch: RemoteException -> L65
        r0.append(trackedViews2);     // Catch: RemoteException -> L65
        r0.append(" fillableIds: ");     // Catch: RemoteException -> L65
        r0.append(fillableIds2);     // Catch: RemoteException -> L65
        r0.append(" triggerId: ");     // Catch: RemoteException -> L65
        r0.append(saveTriggerId2);     // Catch: RemoteException -> L65
        r0.append(" saveOnFinish:");     // Catch: RemoteException -> L65
        r0.append(saveOnFinish);     // Catch: RemoteException -> L65
        r0.append(" flags: ");     // Catch: RemoteException -> L65
        r0.append(flags2);     // Catch: RemoteException -> L65
        r0.append(" hasSaveInfo: ");     // Catch: RemoteException -> L65
        if (saveInfo == null) goto L62;
        boolean r10 = true;
    L63:
        r0.append(r10);     // Catch: RemoteException -> L65
        Slog.v(TAG, r0.toString());     // Catch: RemoteException -> L65
        goto L110
    L62:
        r10 = false;
    L65:
        e = e;
    L94:
        Slog.w(TAG, "Cannot set tracked ids", e);
        return;
    L110:
        this.mClient.setTrackedViews(this.id, Helper.toArray(trackedViews2), this.mSaveOnAllViewsInvisible, saveOnFinish, Helper.toArray(fillableIds2), saveTriggerId2, hasAuthentication2);     // Catch: RemoteException -> L80
        return;
    L80:
        e = e;
    L82:
        e = e;
    L84:
        e = e;
    L86:
        e = e;
    L88:
        e = e;
    L90:
        e = e;
    L92:
        e = e;
        goto L94
    L56:
        hasAuthentication2 = hasAuthentication;
        fillableIds2 = null;
        goto L102
    L32:
        hasAuthentication = false;
        goto L33
    L27:
        saveOnFinish = true;
        saveTriggerId2 = saveTriggerId;
        flags2 = flags;
        trackedViews2 = trackedViews;
        goto L30
    L13:
        r11 = false;
        goto L14
    L28:
        this.mSaveEventLogger.maybeSetSaveUiNotShownReason(2);
        saveOnFinish = true;
        saveTriggerId2 = null;
        flags2 = 0;
        trackedViews2 = null;
        goto L30
    }

    void setAutofillFailureLocked(List<AutofillId> ids, boolean isRefill) {
        if (Helper.sVerbose == true) goto L5;
    L7:
        int i = 0;
    L9:
        if (i >= ids.size()) goto L17;
        AutofillId id = ids.get(i);
        ViewState viewState = this.mViewStates.get(id);
        if (viewState != null) goto L13;
        Slog.w(TAG, "setAutofillFailure(): no view for id " + id);
    L16:
        i = i + 1;
        goto L9
    L13:
        viewState.resetState(4);
        int state = viewState.getState();
        viewState.setState(state | 1024);
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "Changed state of " + id + " to " + viewState.getStateAsString());
        goto L16
    L17:
        this.mPresentationStatsEventLogger.maybeSetViewFillFailureCounts(ids, isRefill);
        return;
    L5:
        if (ids.isEmpty() == true) goto L7;
        Slog.v(TAG, "Total views that failed to populate: " + ids.size());
        goto L7
    }

    void setViewAutofilledLocked(AutofillId id) {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "View autofilled: " + id);
    L6:
        if (id.getSessionId() != 0) goto L8;
        id.setSessionId(this.id);
    L8:
        this.mPresentationStatsEventLogger.maybeAddSuccessId(id);
    }

    void setNotifyNotExpiringResponseDuringAuth() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPresentationStatsEventLogger.maybeSetNotifyNotExpiringResponseDuringAuth();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setLogViewEnteredIgnoredDuringAuth() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPresentationStatsEventLogger.notifyViewEnteredIgnoredDuringAuthCount();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void replaceResponseLocked(FillResponse oldResponse, FillResponse newResponse, Bundle newClientState) {
        setViewStatesLocked(oldResponse, 1, true, true);
        newResponse.setRequestId(oldResponse.getRequestId());
        processResponseLockedForPcc(newResponse, newClientState, 0);
    }

    private void processNullResponseLocked(int requestId, int flags) {
        unregisterDelayedFillBroadcastLocked();
        if ((flags & 1) == 0) goto L5;
        getUiForShowing().showError(R.string.autofill_window_title, this);
    L5:
        FillContext context = getFillContextByRequestIdLocked(requestId);
        if (context == null) goto L8;
        AssistStructure structure = context.getStructure();
        ArrayList<AutofillId> autofillableIds = Helper.getAutofillIds(structure, true);
    L9:
        this.mFillResponseEventLogger.maybeSetAvailableCount(0);
        this.mFillResponseEventLogger.maybeSetLatencyResponseProcessingMillis();
        this.mFillResponseEventLogger.logAndEndEvent();
        this.mService.resetLastResponse();
        this.mAugmentedAutofillDestroyer = triggerAugmentedAutofillLocked(flags);
        if (this.mAugmentedAutofillDestroyer != null) goto L18;
        if ((flags & 4) != 0) goto L18;
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "canceling session " + this.id + " when service returned null and it cannot be augmented. AutofillableIds: " + autofillableIds);
    L16:
        notifyUnavailableToClient(2, autofillableIds);
        removeFromService();
        return;
    L18:
        if ((flags & 4) == 0) goto L24;
        if (Helper.sVerbose == false) goto L22;
        Slog.v(TAG, "keeping session " + this.id + " when service returned null and augmented service is disabled for password fields. AutofillableIds: " + autofillableIds);
    L22:
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(this.mCurrentViewId);
    L26:
        this.mAugmentedAutofillableIds = autofillableIds;
        this.mClient.setState(32);     // Catch: RemoteException -> L29
        return;
    L29:
        e = move-exception;
        Slog.e(TAG, "Error setting client to autofill-only", e);
        return;
    L24:
        if (Helper.sVerbose == false) goto L26;
        Slog.v(TAG, "keeping session " + this.id + " when service returned null but it can be augmented. AutofillableIds: " + autofillableIds);
        goto L26
    L8:
        Slog.w(TAG, "processNullResponseLocked(): no context for req " + requestId);
        autofillableIds = null;
        goto L9
    }

    private Runnable triggerAugmentedAutofillLocked(int flags) {
        if ((flags & 4) == 0) goto L5;
        return null;
    L5:
        int supportedModes = this.mService.getSupportedSmartSuggestionModesLocked();
        if (supportedModes == 0) goto L8;
        final RemoteAugmentedAutofillService remoteService = this.mService.getRemoteAugmentedAutofillServiceLocked();
        if (remoteService != null) goto L18;
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "triggerAugmentedAutofillLocked(): no service for user");
    L16:
        return null;
    L18:
        if ((supportedModes & 1) != 0) goto L20;
        Slog.w(TAG, "Unsupported Smart Suggestion mode: " + supportedModes);
        return null;
    L20:
        if (this.mCurrentViewId != null) goto L23;
        Slog.w(TAG, "triggerAugmentedAutofillLocked(): no view currently focused");
        return null;
    L23:
        boolean isAllowlisted = this.mService.isWhitelistedForAugmentedAutofillLocked(this.mComponentName);
        if (isAllowlisted == true) goto L31;
        if (Helper.sVerbose == false) goto L28;
        Slog.v(TAG, "triggerAugmentedAutofillLocked(): " + ComponentName.flattenToShortString(this.mComponentName) + " not whitelisted ");
    L28:
        logAugmentedAutofillRequestLocked(1, remoteService.getComponentName(), this.mCurrentViewId, isAllowlisted, null);
        return null;
    L31:
        if (Helper.sVerbose == false) goto L33;
        Slog.v(TAG, "calling Augmented Autofill Service (" + ComponentName.flattenToShortString(remoteService.getComponentName()) + ") on view " + this.mCurrentViewId + " using suggestion mode " + AutofillManager.getSmartSuggestionModeToString(1) + " when server returned null for session " + this.id);
    L33:
        this.mFillRequestEventLogger.startLogForNewRequest();
        this.mRequestCount++;
        this.mFillRequestEventLogger.maybeSetAppPackageUid(this.uid);
        this.mFillRequestEventLogger.maybeSetFlags(this.mFlags);
        this.mFillRequestEventLogger.maybeSetRequestId(1);
        this.mFillRequestEventLogger.maybeSetIsAugmented(true);
        this.mFillRequestEventLogger.logAndEndEvent();
        ViewState viewState = this.mViewStates.get(this.mCurrentViewId);
        viewState.setState(4096);
        AutofillValue currentValue = viewState.getCurrentValue();
        if (this.mAugmentedRequestsLogs != null) goto L36;
        this.mAugmentedRequestsLogs = new ArrayList();
    L36:
        LogMaker log = newLogMaker(1630, remoteService.getComponentName().getPackageName());
        this.mAugmentedRequestsLogs.add(log);
        AutofillId focusedId = this.mCurrentViewId;
        Consumer<InlineSuggestionsRequest> requestAugmentedAutofill = new AugmentedAutofillInlineSuggestionRequestConsumer(this, focusedId, isAllowlisted, 1, currentValue);
        RemoteInlineSuggestionRenderService remoteRenderService = this.mService.getRemoteInlineSuggestionRenderServiceLocked();
        if (remoteRenderService != null) goto L39;
    L52:
        requestAugmentedAutofill.accept(this.mInlineSessionController.getInlineSuggestionsRequestLocked().orElse(null));
    L54:
        if (this.mAugmentedAutofillDestroyer != null) goto L57;
        remoteService.getClass();
        this.mAugmentedAutofillDestroyer = new Session$$ExternalSyntheticLambda3(remoteService);
    L57:
        return this.mAugmentedAutofillDestroyer;
    L39:
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == true) goto L45;
        if (SessionFlags.m2395$$Nest$fgetmInlineSupportedByService(this.mSessionFlags) == false) goto L45;
        if (SessionFlags.m2393$$Nest$fgetmExpiredResponse(this.mSessionFlags) == false) goto L52;
    L45:
        if (isViewFocusedLocked(flags) == true) goto L49;
        if (isRequestSupportFillDialog(flags) == false) goto L52;
    L49:
        if (Helper.sDebug == false) goto L51;
        Slog.d(TAG, "Create inline request for augmented autofill");
    L51:
        remoteRenderService.getInlineSuggestionsRendererInfo(new RemoteCallback(new AugmentedAutofillInlineSuggestionRendererOnResultListener(this, focusedId, requestAugmentedAutofill), this.mHandler));
        goto L54
    L8:
        if (Helper.sVerbose == false) goto L10;
        Slog.v(TAG, "triggerAugmentedAutofillLocked(): no supported modes");
    L10:
        return null;
    }

    private static boolean logIfSessionNull(Session session, String logPrefix) {
        if (session != null) goto L7;
        Slog.wtf(TAG, logPrefix + " Session null");
        return true;
    L7:
        if (session.mDestroyed == false) goto L11;
        Slog.w(TAG, logPrefix + " Session destroyed, but following through");
        return false;
    L11:
        return false;
    }

    private void onAugmentedAutofillInlineSuggestionAccept(InlineSuggestionsRequest inlineSuggestionsRequest, AutofillId focussedId, boolean isAllowlisted, int mode, AutofillValue currentValue) {
        Object r7 = this.mLock;
        monitor-enter(r7);
        RemoteAugmentedAutofillService remoteService = this.mService.getRemoteAugmentedAutofillServiceLocked();     // Catch: Throwable -> L11
        ComponentName r3 = remoteService.getComponentName();     // Catch: Throwable -> L11
        if (inlineSuggestionsRequest == null) goto L7;
        boolean r0 = true;
    L8:
        logAugmentedAutofillRequestLocked(mode, r3, focussedId, isAllowlisted, Boolean.valueOf(r0));     // Catch: Throwable -> L11
        remoteService.onRequestAutofillLocked(this.id, this.mClient, this.taskId, this.mComponentName, this.mActivityToken, AutofillId.withoutSession(focussedId), currentValue, inlineSuggestionsRequest, new AugmentedAutofillInlineSuggestionsResponseCallback(this), new AugmentedAutofillErrorCallback(this), this.mService.getRemoteInlineSuggestionRenderServiceLocked(), this.userId);     // Catch: Throwable -> L11
        monitor-exit(r7);     // Catch: Throwable -> L11
        return;
    L7:
        r0 = false;
    L11:
        th = move-exception;
        throw th;
    }

    private void onAugmentedAutofillErrorCallback() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        cancelAugmentedAutofillLocked();     // Catch: Throwable -> L7
        this.mInlineSessionController.setInlineFillUiLocked(InlineFillUi.emptyUi(this.mCurrentViewId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void cancelAugmentedAutofillLocked() {
        RemoteAugmentedAutofillService remoteService = this.mService.getRemoteAugmentedAutofillServiceLocked();
        if (remoteService != null) goto L7;
        Slog.w(TAG, "cancelAugmentedAutofillLocked(): no service for user");
        return;
    L7:
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "cancelAugmentedAutofillLocked() on " + this.mCurrentViewId);
    L9:
        remoteService.onDestroyAutofillWindowsRequest();
    }

    private void setClientState(Bundle newClientState, int requestId) {
        if (RequestId.isSecondaryProvider(requestId) == false) goto L5;
        this.mClientStateForSecondary = newClientState;
        return;
    L5:
        this.mClientState = newClientState;
    }

    private void processResponseLocked(FillResponse newResponse, Bundle newClientState, int flags) {
        this.mUi.hideAll(this);
        if ((newResponse.getFlags() & 4) != 0) goto L5;
        Slog.d(TAG, "Service did not request to wait for delayed fill response.");
        unregisterDelayedFillBroadcastLocked();
    L5:
        int requestId = newResponse.getRequestId();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "processResponseLocked(): mCurrentViewId=" + this.mCurrentViewId + ",flags=" + flags + ", reqId=" + requestId + ", resp=" + newResponse + ",newClientState=" + newClientState);
    L9:
        if (this.mResponses != null) goto L11;
        this.mResponses = new SparseArray(2);
    L11:
        this.mResponses.put(requestId, newResponse);
        if (newClientState == null) goto L14;
        Bundle r1 = newClientState;
    L15:
        setClientState(r1, requestId);
        if (newClientState != null) goto L18;
    L20:
        boolean webviewRequestedCredman = false;
    L21:
        List<Dataset> datasetList = newResponse.getDatasets();
        this.mPresentationStatsEventLogger.maybeSetWebviewRequestedCredential(webviewRequestedCredman);
        this.mPresentationStatsEventLogger.maybeSetFieldClassificationRequestId(sIdCounterForPcc.get());
        this.mPresentationStatsEventLogger.maybeSetAvailableCount(datasetList, this.mCurrentViewId);
        this.mFillResponseEventLogger.maybeSetDatasetsCountAfterPotentialPccFiltering(datasetList);
        setViewStatesLocked(newResponse, 2, false, true);
        updateFillDialogTriggerIdsLocked();
        updateTrackedIdsLocked();
        if (this.mCurrentViewId != null) goto L24;
        return;
    L24:
        ViewState currentView = this.mViewStates.get(this.mCurrentViewId);
        currentView.maybeCallOnFillReady(flags);
        return;
    L18:
        if (newClientState.getBoolean("webview_requested_credential", false) == false) goto L20;
        webviewRequestedCredman = true;
        goto L21
    L14:
        r1 = newResponse.getClientState();
        goto L15
    }

    private void setViewStatesLocked(FillResponse response, int state, boolean clearResponse, boolean isPrimary) {
        List<Dataset> datasets = response.getDatasets();
        int r1 = 0;
        if (datasets != null) goto L5;
    L15:
        FillResponse response2 = response;
        int state2 = state;
        if (response2.getAuthentication() == null) goto L25;
        AutofillId[] r12 = response2.getAuthenticationIds();
        int r13 = r12.length;
        int r14 = 0;
    L19:
        if (r14 >= r13) goto L25;
        AutofillId autofillId = r12[r14];
        ViewState viewState = createOrUpdateViewStateLocked(autofillId, state2, null);
        if (clearResponse == true) goto L23;
        viewState.setResponse(response2, isPrimary);
    L24:
        r14 = r14 + 1;
        goto L19
    L23:
        viewState.setResponse(null, isPrimary);
    L25:
        SaveInfo saveInfo = response2.getSaveInfo();
        if (saveInfo == null) goto L39;
        AutofillId[] requiredIds = saveInfo.getRequiredIds();
        if (requiredIds == null) goto L33;
        int r15 = requiredIds.length;
        int r16 = 0;
    L31:
        if (r16 >= r15) goto L33;
        AutofillId id = requiredIds[r16];
        createOrUpdateViewStateLocked(id, state2, null);
        r16 = r16 + 1;
    L33:
        AutofillId[] optionalIds = saveInfo.getOptionalIds();
        if (optionalIds == null) goto L39;
        int r17 = optionalIds.length;
        int r3 = 0;
    L37:
        if (r3 >= r17) goto L39;
        AutofillId id2 = optionalIds[r3];
        createOrUpdateViewStateLocked(id2, state2, null);
        r3 = r3 + 1;
    L39:
        AutofillId[] authIds = response2.getAuthenticationIds();
        if (authIds == null) goto L45;
        int r18 = authIds.length;
    L43:
        if (r1 >= r18) goto L55;
        AutofillId id3 = authIds[r1];
        createOrUpdateViewStateLocked(id3, state2, null);
        r1 = r1 + 1;
        goto L43
    L55:
        return;
    L45:
        return;
    L5:
        if (datasets.isEmpty() == true) goto L15;
        int i = 0;
    L8:
        if (i >= datasets.size()) goto L14;
        Dataset dataset = datasets.get(i);
        if (dataset != null) goto L12;
        Slog.w(TAG, "Ignoring null dataset on " + datasets);
        FillResponse response3 = response;
        int state3 = state;
        boolean clearResponse2 = clearResponse;
        boolean isPrimary2 = isPrimary;
    L13:
        i = i + 1;
        response = response3;
        state = state3;
        clearResponse = clearResponse2;
        isPrimary = isPrimary2;
        goto L8
    L12:
        response3 = response;
        state3 = state;
        clearResponse2 = clearResponse;
        isPrimary2 = isPrimary;
        setViewStatesLocked(response3, dataset, state3, clearResponse2, isPrimary2);
        goto L13
    L14:
        response2 = response;
        state2 = state;
        goto L25
    }

    private void setViewStatesLocked(FillResponse response, Dataset dataset, int state, boolean clearResponse, boolean isPrimary) {
        ArrayList<AutofillId> ids = dataset.getFieldIds();
        ArrayList<AutofillValue> values = dataset.getFieldValues();
        int j = 0;
    L4:
        if (j >= ids.size()) goto L14;
        AutofillId id = ids.get(j);
        AutofillValue value = values.get(j);
        ViewState viewState = createOrUpdateViewStateLocked(id, state, value);
        String datasetId = dataset.getId();
        if (datasetId == null) goto L8;
        viewState.setDatasetId(datasetId);
    L8:
        if (clearResponse == false) goto L10;
        viewState.setResponse(null, isPrimary);
    L12:
        j = j + 1;
        goto L4
    L10:
        if (response == null) goto L12;
        viewState.setResponse(response, isPrimary);
        goto L12
    }

    private ViewState createOrUpdateViewStateLocked(AutofillId id, int state, AutofillValue value) {
        ViewState viewState = this.mViewStates.get(id);
        if (viewState == null) goto L5;
        viewState.setState(state);
    L10:
        if ((state & 4) == 0) goto L12;
        viewState.setAutofilledValue(value);
    L12:
        return viewState;
    L5:
        viewState = new ViewState(id, this, state, this.mIsPrimaryCredential);
        if (Helper.sVerbose == false) goto L8;
        Slog.v(TAG, "Adding autofillable view with id " + id + " and state " + state);
    L8:
        viewState.setCurrentValue(findValueLocked(id));
        this.mViewStates.put(id, viewState);
        goto L10
    }

    void autoFill(int requestId, int datasetIndex, Dataset dataset, boolean generateEvent, int uiType) {
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "autoFill(): requestId=" + requestId + "; datasetIdx=" + datasetIndex + "; dataset=" + dataset);
    L5:
        Object r9 = this.mLock;
        monitor-enter(r9);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mDestroyed == false) goto L14;
        Slog.w(TAG, "Call to Session#autoFill() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L12
        return;
    L14:
        this.mPresentationStatsEventLogger.maybeSetSelectedDatasetId(datasetIndex);     // Catch: Throwable -> L12
        this.mPresentationStatsEventLogger.maybeSetSelectedDatasetPickReason(dataset.getEligibleReason());     // Catch: Throwable -> L12
        if (dataset.getAuthentication() != null) goto L24;
        if (generateEvent == false) goto L19;
        this.mService.logDatasetSelected(dataset.getId(), this.id, this.mClientState, uiType, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L12
    L19:
        if (this.mCurrentViewId == null) goto L21;
        this.mInlineSessionController.hideInlineSuggestionsUiLocked(this.mCurrentViewId);     // Catch: Throwable -> L12
    L21:
        autoFillApp(dataset);     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L12
        return;
    L24:
        this.mService.logDatasetAuthenticationSelected(dataset.getId(), this.id, this.mClientState, uiType, this.mCurrentViewId, shouldAddEventToHistory());     // Catch: Throwable -> L12
        this.mPresentationStatsEventLogger.maybeSetAuthenticationType(1);     // Catch: Throwable -> L12
        setViewStatesLocked(null, dataset, 64, false, true);     // Catch: Throwable -> L12
        if (dataset.getCredentialFillInIntent() == null) goto L27;
        Slog.d(TAG, "Setting credential fill intent");     // Catch: Throwable -> L12
        Intent fillInIntent = dataset.getCredentialFillInIntent();     // Catch: Throwable -> L12
    L28:
        if (fillInIntent != null) goto L32;
        forceRemoveFromServiceLocked();     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L12
        return;
    L32:
        int authenticationId = AutofillManager.makeAuthenticationId(requestId, datasetIndex);     // Catch: Throwable -> L12
        startAuthentication(authenticationId, dataset.getAuthentication(), fillInIntent, false);     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L12
        return;
    L27:
        fillInIntent = createAuthFillInIntentLocked(requestId, this.mClientState);     // Catch: Throwable -> L12
        goto L28
    }

    private Intent createAuthFillInIntentLocked(int requestId, Bundle extras) {
        Intent fillInIntent = new Intent();
        FillContext context = getFillContextByRequestIdLocked(requestId);
        if (context != null) goto L7;
        wtf(null, "createAuthFillInIntentLocked(): no FillContext. requestId=%d; mContexts=%s", new Object[]{Integer.valueOf(requestId), this.mContexts});
        return null;
    L7:
        if (this.mLastInlineSuggestionsRequest != null) goto L9;
    L11:
        fillInIntent.putExtra("android.view.autofill.extra.ASSIST_STRUCTURE", context.getStructure());
        fillInIntent.putExtra("android.view.autofill.extra.CLIENT_STATE", extras);
        return fillInIntent;
    L9:
        if (((Integer) this.mLastInlineSuggestionsRequest.first).intValue() != requestId) goto L11;
        fillInIntent.putExtra("android.view.autofill.extra.INLINE_SUGGESTIONS_REQUEST", (Parcelable) this.mLastInlineSuggestionsRequest.second);
        goto L11
    }

    Consumer<InlineSuggestionsRequest> inlineSuggestionsRequestCacheDecorator(final Consumer<InlineSuggestionsRequest> consumer, final int requestId) {
        return new Session$$ExternalSyntheticLambda0(this, consumer, requestId);
    }

    private /* synthetic */ void lambda$inlineSuggestionsRequestCacheDecorator$2(Consumer consumer, int requestId, InlineSuggestionsRequest inlineSuggestionsRequest) {
        consumer.accept(inlineSuggestionsRequest);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastInlineSuggestionsRequest = Pair.create(Integer.valueOf(requestId), inlineSuggestionsRequest);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int getDetectionPreferenceForLogging() {
        if (this.mService.isPccClassificationEnabled() == true) goto L5;
        return 0;
    L5:
        if (this.mService.getMaster().preferProviderOverPcc() == false) goto L8;
        return 1;
    L8:
        return 2;
    }

    private void startNewEventForPresentationStatsEventLogger() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPresentationStatsEventLogger.startNewEvent();     // Catch: Throwable -> L7
        this.mPresentationStatsEventLogger.maybeSetNoPresentationEventReason(8);     // Catch: Throwable -> L7
        this.mPresentationStatsEventLogger.maybeSetDetectionPreference(getDetectionPreferenceForLogging());     // Catch: Throwable -> L7
        this.mPresentationStatsEventLogger.maybeSetAutofillServiceUid(getAutofillServiceUid());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startAuthentication(int authenticationId, IntentSender intent, Intent fillInIntent, boolean authenticateInline) {
        Object r1 = this.mLock;     // Catch: RemoteException -> L17
        monitor-enter(r1);     // Catch: RemoteException -> L17
        this.mClient.authenticate(this.id, authenticationId, intent, fillInIntent, authenticateInline);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        RemoteException e = e;
    L19:
        Slog.e(TAG, "Error launching auth intent", e);
        return;
    L9:
        th = move-exception;
        r9 = th;
    L17:
        e = move-exception;
        e = e;
        goto L19
    }

    public String toString() {
        return "Session: [id=" + this.id + ", component=" + this.mComponentName + ", state=" + sessionStateAsString(this.mSessionState) + "]";
    }

    void dumpLocked(String prefix, PrintWriter pw) {
        String prefix2 = prefix + "  ";
        pw.print(prefix);
        pw.print("id: ");
        pw.println(this.id);
        pw.print(prefix);
        pw.print("uid: ");
        pw.println(this.uid);
        pw.print(prefix);
        pw.print("taskId: ");
        pw.println(this.taskId);
        pw.print(prefix);
        pw.print("flags: ");
        pw.println(this.mFlags);
        pw.print(prefix);
        pw.print("displayId: ");
        pw.println(this.mContext.getDisplayId());
        pw.print(prefix);
        pw.print("state: ");
        pw.println(sessionStateAsString(this.mSessionState));
        pw.print(prefix);
        pw.print("mComponentName: ");
        pw.println(this.mComponentName);
        pw.print(prefix);
        pw.print("mActivityToken: ");
        pw.println(this.mActivityToken);
        pw.print(prefix);
        pw.print("mStartTime: ");
        pw.println(this.mStartTime);
        pw.print(prefix);
        pw.print("Time to show UI: ");
        if (this.mUiShownTime != 0) goto L5;
        pw.println("N/A");
    L6:
        int requestLogsSizes = this.mRequestLogs.size();
        pw.print(prefix);
        pw.print("mSessionLogs: ");
        pw.println(requestLogsSizes);
        int i = 0;
    L8:
        if (i >= requestLogsSizes) goto L10;
        int requestId = this.mRequestLogs.keyAt(i);
        LogMaker log = this.mRequestLogs.valueAt(i);
        pw.print(prefix2);
        pw.print('#');
        pw.print(i);
        pw.print(": req=");
        pw.print(requestId);
        pw.print(", log=");
        dumpRequestLog(pw, log);
        pw.println();
        i = i + 1;
        goto L8
    L10:
        pw.print(prefix);
        pw.print("mResponses: ");
        if (this.mResponses != null) goto L13;
        pw.println("null");
    L17:
        pw.print(prefix);
        pw.print("mCurrentViewId: ");
        pw.println(this.mCurrentViewId);
        pw.print(prefix);
        pw.print("mDestroyed: ");
        pw.println(this.mDestroyed);
        pw.print(prefix);
        pw.print("mShowingSaveUi: ");
        pw.println(SessionFlags.m2397$$Nest$fgetmShowingSaveUi(this.mSessionFlags));
        pw.print(prefix);
        pw.print("mPendingSaveUi: ");
        pw.println(this.mPendingSaveUi);
        int numberViews = this.mViewStates.size();
        pw.print(prefix);
        pw.print("mViewStates size: ");
        pw.println(this.mViewStates.size());
        int i2 = 0;
    L18:
        if (i2 >= numberViews) goto L20;
        pw.print(prefix);
        pw.print("ViewState at #");
        pw.println(i2);
        this.mViewStates.valueAt(i2).dump(prefix2, pw);
        i2 = i2 + 1;
        goto L18
    L20:
        pw.print(prefix);
        pw.print("mContexts: ");
        if (this.mContexts == null) goto L29;
        int numContexts = this.mContexts.size();
        int i3 = 0;
    L23:
        if (i3 >= numContexts) goto L30;
        FillContext context = this.mContexts.get(i3);
        pw.print(prefix2);
        pw.print(context);
        if (Helper.sVerbose == false) goto L27;
        pw.println("AssistStructure dumped at logcat)");
        context.getStructure().dump(false);
    L27:
        i3 = i3 + 1;
    L30:
        pw.print(prefix);
        pw.print("mHasCallback: ");
        pw.println(this.mHasCallback);
        if (this.mClientState == null) goto L33;
        pw.print(prefix);
        pw.print("mClientState: ");
        pw.print(this.mClientState.getSize());
        pw.println(" bytes");
    L33:
        pw.print(prefix);
        pw.print("mCompatMode: ");
        pw.println(this.mCompatMode);
        pw.print(prefix);
        pw.print("mUrlBar: ");
        if (this.mUrlBar != null) goto L36;
        pw.println("N/A");
    L37:
        pw.print(prefix);
        pw.print("mSaveOnAllViewsInvisible: ");
        pw.println(this.mSaveOnAllViewsInvisible);
        pw.print(prefix);
        pw.print("mSelectedDatasetIds: ");
        pw.println(this.mSelectedDatasetIds);
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == false) goto L41;
        pw.print(prefix);
        pw.println("For Augmented Autofill Only");
    L41:
        if (SessionFlags.m2394$$Nest$fgetmFillDialogDisabled(this.mSessionFlags) == false) goto L44;
        pw.print(prefix);
        pw.println("Fill Dialog disabled");
    L44:
        if (this.mLastFillDialogTriggerIds == null) goto L47;
        pw.print(prefix);
        pw.println("Last Fill Dialog trigger ids: ");
        pw.println(this.mSelectedDatasetIds);
    L47:
        if (this.mAugmentedAutofillDestroyer == null) goto L50;
        pw.print(prefix);
        pw.println("has mAugmentedAutofillDestroyer");
    L50:
        if (this.mAugmentedRequestsLogs == null) goto L53;
        pw.print(prefix);
        pw.print("number augmented requests: ");
        pw.println(this.mAugmentedRequestsLogs.size());
    L53:
        if (this.mAugmentedAutofillableIds == null) goto L56;
        pw.print(prefix);
        pw.print("mAugmentedAutofillableIds: ");
        pw.println(this.mAugmentedAutofillableIds);
    L56:
        if (this.mRemoteFillService == null) goto L65;
        this.mRemoteFillService.dump(prefix, pw);
        return;
    L65:
        return;
    L36:
        pw.print("id=");
        pw.print(this.mUrlBar.getAutofillId());
        pw.print(" domain=");
        pw.print(this.mUrlBar.getWebDomain());
        pw.print(" text=");
        Helper.printlnRedactedText(pw, this.mUrlBar.getText());
        goto L37
    L29:
        pw.println("null");
        goto L30
    L13:
        pw.println(this.mResponses.size());
        int i4 = 0;
    L15:
        if (i4 >= this.mResponses.size()) goto L17;
        pw.print(prefix2);
        pw.print('#');
        pw.print(i4);
        pw.print(' ');
        pw.println(this.mResponses.valueAt(i4));
        i4 = i4 + 1;
        goto L15
    L5:
        TimeUtils.formatDuration(this.mUiShownTime - this.mStartTime, pw);
        pw.println();
        goto L6
    }

    private static void dumpRequestLog(PrintWriter pw, LogMaker log) {
        pw.print("CAT=");
        pw.print(log.getCategory());
        pw.print(", TYPE=");
        int type = log.getType();
        switch(type) {
            case 2: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        pw.print("UNSUPPORTED");
    L8:
        pw.print('(');
        pw.print(type);
        pw.print(')');
        pw.print(", PKG=");
        pw.print(log.getPackageName());
        pw.print(", SERVICE=");
        pw.print(log.getTaggedData(908));
        pw.print(", ORDINAL=");
        pw.print(log.getTaggedData(1454));
        dumpNumericValue(pw, log, "FLAGS", 1452);
        dumpNumericValue(pw, log, "NUM_DATASETS", 909);
        dumpNumericValue(pw, log, "UI_LATENCY", 1145);
        int authStatus = Helper.getNumericValue(log, 1453);
        if (authStatus == 0) goto L18;
        pw.print(", AUTH_STATUS=");
        switch(authStatus) {
            case 912: goto L16;
            case 1126: goto L15;
            case 1127: goto L14;
            case 1128: goto L13;
            default: goto L12;
        };
    L12:
        pw.print("UNSUPPORTED");
    L17:
        pw.print('(');
        pw.print(authStatus);
        pw.print(')');
        goto L18
    L13:
        pw.print("INVALID_AUTHENTICATION");
        goto L17
    L14:
        pw.print("INVALID_DATASET_AUTHENTICATION");
        goto L17
    L15:
        pw.print("DATASET_AUTHENTICATED");
        goto L17
    L16:
        pw.print("AUTHENTICATED");
    L18:
        dumpNumericValue(pw, log, "FC_IDS", 1271);
        dumpNumericValue(pw, log, "COMPAT_MODE", 1414);
        return;
    L5:
        pw.print("FAILURE");
        goto L8
    L6:
        pw.print("SUCCESS");
        goto L8
    L7:
        pw.print("CLOSE");
        goto L8
    }

    private static void dumpNumericValue(PrintWriter pw, LogMaker log, String field, int tag) {
        int value = Helper.getNumericValue(log, tag);
        if (value == 0) goto L6;
        pw.print(", ");
        pw.print(field);
        pw.print('=');
        pw.print(value);
        return;
    }

    void sendCredentialManagerResponseToApp(GetCredentialResponse response, GetCredentialException exception, AutofillId viewId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L40;
        Slog.w(TAG, "Call to Session#sendCredentialManagerResponseToApp() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L40:
        ViewState viewState = this.mViewStates.get(viewId);     // Catch: Throwable -> L9 RemoteException -> L19
        if (this.mService.getMaster().getIsFillFieldsFromCurrentSessionOnly() == false) goto L22;
        if (viewState == null) goto L22;
        if (viewState.id.getSessionId() == this.id) goto L22;
        if (Helper.sVerbose == false) goto L22;
        Slog.v(TAG, "Skipping sending credential response to view: " + viewId + " as it isn't part of the current session: " + this.id);     // Catch: Throwable -> L9 RemoteException -> L19
    L22:
        if (exception != null) goto L24;
        if (response != null) goto L29;
        Slog.w(TAG, "sendCredentialManagerResponseToApp called with null responseand exception");     // Catch: Throwable -> L9 RemoteException -> L19
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L29:
        if (viewId.isVirtualInt() == false) goto L31;
        sendResponseToViewNode(viewId, response, null);     // Catch: Throwable -> L9 RemoteException -> L19
        goto L36
    L31:
        this.mClient.onGetCredentialResponse(this.id, viewId, response);     // Catch: Throwable -> L9 RemoteException -> L19
        goto L36
    L24:
        if (viewId.isVirtualInt() == false) goto L26;
        sendResponseToViewNode(viewId, null, exception);     // Catch: Throwable -> L9 RemoteException -> L19
        goto L36
    L26:
        this.mClient.onGetCredentialException(this.id, viewId, exception.getType(), exception.getMessage());     // Catch: Throwable -> L9 RemoteException -> L19
    L19:
        e = move-exception;
        Slog.w(TAG, "Error sending credential response to activity: " + e);     // Catch: Throwable -> L9
        goto L36
    }

    private void sendResponseToViewNode(AutofillId viewId, GetCredentialResponse response, GetCredentialException exception) {
        AssistStructure.ViewNode viewNode = getViewNodeFromContextsLocked(viewId);
        if (viewNode != null) goto L5;
    L12:
        Slog.w(TAG, "View node not found after GetCredentialResponse");
        return;
    L5:
        if (viewNode.getPendingCredentialCallback() == null) goto L12;
        Bundle resultData = new Bundle();
        if (response == null) goto L9;
        resultData.putParcelable("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", response);
        viewNode.getPendingCredentialCallback().send(0, resultData);
        return;
    L9:
        if (exception == null) goto L16;
        resultData.putStringArray("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", new String[]{exception.getType(), exception.getMessage()});
        viewNode.getPendingCredentialCallback().send(-1, resultData);
        return;
    }

    void autoFillApp(Dataset dataset) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L57:
        th = th;
    L71:
        monitor-exit(r1);     // Catch: Throwable -> L57
        throw th;
    L61:
        th = th;
        goto L71
    L78:
        if (this.mDestroyed == false) goto L76;
        Slog.w(TAG, "Call to Session#autoFillApp() rejected - session: " + this.id + " destroyed");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L76:
        int entryCount = dataset.getFieldIds().size();     // Catch: Throwable -> L61 RemoteException -> L63
        List<AutofillId> ids = new ArrayList(entryCount);     // Catch: Throwable -> L61 RemoteException -> L63
        List<AutofillValue> values = new ArrayList(entryCount);     // Catch: Throwable -> L61 RemoteException -> L63
        boolean waitingDatasetAuth = false;
        int numOfViewsFiltered = 0;
        int i = 0;
    L13:
        if (i >= entryCount) goto L38;
    L25:
        e = e;
    L68:
        Slog.w(TAG, "Error autofilling activity: " + e);     // Catch: Throwable -> L57
    L69:
        monitor-exit(r1);     // Catch: Throwable -> L57
        return;
    L15:
        if (dataset.getFieldValues().get(i) == null) goto L36;
        AutofillId viewId = (AutofillId) dataset.getFieldIds().get(i);     // Catch: Throwable -> L9 RemoteException -> L25
        ViewState viewState = this.mViewStates.get(viewId);     // Catch: Throwable -> L9 RemoteException -> L25
        if (this.mService.getMaster().getIsFillFieldsFromCurrentSessionOnly() == false) goto L28;
        if (viewState == null) goto L28;
        if (viewState.id.getSessionId() == this.id) goto L28;
        if (Helper.sVerbose == false) goto L27;
        Slog.v(TAG, "Skipping filling view: " + viewId + " as it isn't part of the current session: " + this.id);     // Catch: Throwable -> L9 RemoteException -> L25
    L27:
        numOfViewsFiltered = numOfViewsFiltered + 1;     // Catch: Throwable -> L9 RemoteException -> L25
    L28:
        ids.add(viewId);     // Catch: Throwable -> L9 RemoteException -> L25
        values.add((AutofillValue) dataset.getFieldValues().get(i));     // Catch: Throwable -> L9 RemoteException -> L25
        if (viewState == null) goto L36;
        if ((viewState.getState() & 64) == 0) goto L36;
        if (Helper.sVerbose == false) goto L35;
        Slog.v(TAG, "autofillApp(): view " + viewId + " waiting auth");     // Catch: Throwable -> L9 RemoteException -> L25
    L35:
        waitingDatasetAuth = true;
        viewState.resetState(64);     // Catch: Throwable -> L9 RemoteException -> L25
    L36:
        i = i + 1;
        goto L13
    L38:
        this.mPresentationStatsEventLogger.maybeSetFilteredFillableViewsCount(numOfViewsFiltered);     // Catch: Throwable -> L61 RemoteException -> L63
        if (ids.isEmpty() == true) goto L69;
        if (waitingDatasetAuth == false) goto L43;
        this.mUi.hideFillUi(this);     // Catch: Throwable -> L9 RemoteException -> L25
    L43:
        if (Helper.sVerbose == false) goto L45;
        Slog.v(TAG, "Total views to be autofilled: " + ids.size());     // Catch: Throwable -> L9 RemoteException -> L25
    L45:
        this.mPresentationStatsEventLogger.maybeSetViewFillablesAndCount(ids);     // Catch: Throwable -> L61 RemoteException -> L63
        if (Helper.sDebug == false) goto L48;
        Slog.d(TAG, "autoFillApp(): the buck is on the app: " + dataset);     // Catch: Throwable -> L9 RemoteException -> L25
    L48:
        this.mClient.autofill(this.id, ids, values, false);     // Catch: Throwable -> L61 RemoteException -> L63
        if (dataset.getId() == null) goto L79;
        if (this.mSelectedDatasetIds != null) goto L53;
        this.mSelectedDatasetIds = new ArrayList();     // Catch: Throwable -> L9 RemoteException -> L25
    L53:
        this.mSelectedDatasetIds.add(dataset.getId());     // Catch: Throwable -> L9 RemoteException -> L25
    L79:
        setViewStatesLocked(null, dataset, 4, false, true);     // Catch: Throwable -> L57 RemoteException -> L59
    L59:
        e = e;
        goto L68
    L63:
        e = e;
    L9:
        th = th;
        goto L71
    }

    public void setAutofillIdsAttemptedForRefillLocked(List<AutofillId> ids) {
        this.mPresentationStatsEventLogger.maybeUpdateViewFillablesForRefillAttempt(ids);
    }

    protected AutoFillUI getUiForShowing() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUi.setCallback(this);     // Catch: Throwable -> L7
        AutoFillUI r1 = this.mUi;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void logAllEventsLocked(int val) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "logAllEvents(" + this.id + "): commitReason: " + val);
    L5:
        this.mSessionCommittedEventLogger.maybeSetCommitReason(val);
        this.mSessionCommittedEventLogger.maybeSetRequestCount(this.mRequestCount);
        this.mSessionCommittedEventLogger.maybeSetSessionDurationMillis(SystemClock.elapsedRealtime() - this.mStartTime);
        this.mFillRequestEventLogger.logAndEndEvent();
        this.mFillResponseEventLogger.logAndEndEvent();
        this.mPresentationStatsEventLogger.logAndEndEvent("log all events");
        this.mSaveEventLogger.logAndEndEvent();
        this.mSessionCommittedEventLogger.logAndEndEvent();
    }

    RemoteFillService destroyLocked() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "destroyLocked for session: " + this.id);
    L5:
        logAllEventsLocked(5);
        if (this.mDestroyed == false) goto L9;
        return null;
    L9:
        clearPendingIntentLocked();
        unregisterDelayedFillBroadcastLocked();
        unlinkClientVultureLocked();
        this.mUi.destroyAll(this.mPendingSaveUi, this, true);
        this.mUi.clearCallback(this);
        if (this.mCurrentViewId == null) goto L12;
        this.mInlineSessionController.destroyLocked(this.mCurrentViewId);
    L12:
        RemoteInlineSuggestionRenderService remoteRenderService = this.mService.getRemoteInlineSuggestionRenderServiceLocked();
        if (remoteRenderService == null) goto L15;
        remoteRenderService.destroySuggestionViews(this.userId, this.id);
    L15:
        this.mDestroyed = true;
        int totalRequests = this.mRequestLogs.size();
        if (totalRequests <= 0) goto L24;
        if (Helper.sVerbose == false) goto L20;
        Slog.v(TAG, "destroyLocked(): logging " + totalRequests + " requests");
    L20:
        int i = 0;
    L21:
        if (i >= totalRequests) goto L24;
        this.mMetricsLogger.write(this.mRequestLogs.valueAt(i));
        i = i + 1;
    L24:
        if (this.mAugmentedRequestsLogs != null) goto L26;
        int totalAugmentedRequests = 0;
    L27:
        if (totalAugmentedRequests > 0) goto L29;
    L34:
        LogMaker log = newLogMaker(919).addTaggedData(1455, Integer.valueOf(totalRequests));
        if (totalAugmentedRequests <= 0) goto L38;
        log.addTaggedData(1631, Integer.valueOf(totalAugmentedRequests));
    L38:
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == false) goto L40;
        log.addTaggedData(1720, 1);
    L40:
        this.mMetricsLogger.write(log);
        return this.mRemoteFillService;
    L29:
        if (Helper.sVerbose == false) goto L31;
        Slog.v(TAG, "destroyLocked(): logging " + totalRequests + " augmented requests");
    L31:
        int i2 = 0;
    L32:
        if (i2 >= totalAugmentedRequests) goto L34;
        this.mMetricsLogger.write(this.mAugmentedRequestsLogs.get(i2));
        i2 = i2 + 1;
        goto L32
    L26:
        totalAugmentedRequests = this.mAugmentedRequestsLogs.size();
        goto L27
    }

    void forceRemoveFromServiceLocked() {
        forceRemoveFromServiceLocked(0);
    }

    void forceRemoveFromServiceIfForAugmentedOnlyLocked() {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "forceRemoveFromServiceIfForAugmentedOnlyLocked(" + this.id + "): " + SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags));
    L6:
        if (SessionFlags.m2392$$Nest$fgetmAugmentedAutofillOnly(this.mSessionFlags) == true) goto L8;
        return;
    L8:
        forceRemoveFromServiceLocked();
    }

    void forceRemoveFromServiceLocked(int clientState) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "forceRemoveFromServiceLocked(): " + this.mPendingSaveUi);
    L5:
        boolean isPendingSaveUi = isSaveUiPendingLocked();
        this.mPendingSaveUi = null;
        removeFromServiceLocked();
        this.mUi.destroyAll(this.mPendingSaveUi, this, false);
        if (isPendingSaveUi == false) goto L13;
    L11:
        destroyAugmentedAutofillWindowsLocked();
        return;
    L13:
        this.mClient.setSessionFinished(clientState, null);     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Error notifying client to finish session", e);
        goto L11
    }

    void destroyAugmentedAutofillWindowsLocked() {
        if (this.mAugmentedAutofillDestroyer == null) goto L6;
        this.mAugmentedAutofillDestroyer.run();
        this.mAugmentedAutofillDestroyer = null;
        return;
    }

    private void removeFromService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeFromServiceLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeFromServiceLocked() {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "removeFromServiceLocked(" + this.id + "): " + this.mPendingSaveUi);
    L6:
        if (this.mDestroyed == false) goto L10;
        Slog.w(TAG, "Call to Session#removeFromServiceLocked() rejected - session: " + this.id + " destroyed");
        return;
    L10:
        if (isSaveUiPendingLocked() == false) goto L13;
        Slog.i(TAG, "removeFromServiceLocked() ignored, waiting for pending save ui");
        return;
    L13:
        RemoteFillService remoteFillService = destroyLocked();
        this.mService.removeSessionLocked(this.id);
        if (remoteFillService == null) goto L17;
        remoteFillService.destroy();
    L17:
        if (this.mSecondaryProviderHandler == null) goto L19;
        this.mSecondaryProviderHandler.destroy();
    L19:
        this.mSessionState = 3;
    }

    public void notifyImeAnimationStart(long startTimeMs) {
        this.mImeAnimationStartTimeMs = startTimeMs;
        this.mWaitForImeAnimation = true;
    }

    public void notifyImeAnimationEnd(long endTimeMs) {
        this.mImeAnimationFinishTimeMs = endTimeMs;
        if (this.mFillDialogRunnable == null) goto L9;
        if (Helper.sVerbose == false) goto L7;
        Log.v(TAG, "Ime animation ended, starting fill dialog.");
    L7:
        this.mHandler.postDelayed(this.mFillDialogRunnable, this.mFillDialogMinWaitAfterImeAnimationMs);
        this.mFillDialogRunnable = null;
    L11:
        this.mWaitForImeAnimation = false;
        return;
    L9:
        if (Helper.sVerbose == false) goto L11;
        Log.v(TAG, "Ime animation ended, no runnable present.");
        goto L11
    }

    void onPendingSaveUi(int operation, IBinder token) {
        getUiForShowing().onPendingSaveUi(operation, token);
    }

    boolean isSaveUiPendingForTokenLocked(IBinder token) {
        if (isSaveUiPendingLocked() == true) goto L5;
    L7:
        return false;
    L5:
        if (token.equals(this.mPendingSaveUi.getToken()) == false) goto L7;
        return true;
    }

    private boolean isSaveUiPendingLocked() {
        if (this.mPendingSaveUi != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingSaveUi.getState() != 2) goto L7;
        return true;
    }

    private int getLastResponseIndexLocked() {
        if (this.mResponses != null) goto L5;
        return -1;
    L5:
        if (this.mResponses.size() == 0) goto L15;
        List<Integer> requestIdList = new ArrayList();
        int responseCount = this.mResponses.size();
        int i = 0;
    L8:
        if (i >= responseCount) goto L10;
        requestIdList.add(Integer.valueOf(this.mResponses.keyAt(i)));
        i = i + 1;
        goto L8
    L10:
        int i2 = RequestId.getLastRequestIdIndex(requestIdList);
        return i2;
    L15:
        return -1;
    }

    protected LogMaker newLogMaker(int category) {
        return newLogMaker(category, this.mService.getServicePackageName());
    }

    private LogMaker newLogMaker(int category, String servicePackageName) {
        return Helper.newLogMaker(category, this.mComponentName, servicePackageName, this.id, this.mCompatMode);
    }

    private void writeLog(int category) {
        this.mMetricsLogger.write(newLogMaker(category));
    }

    private void logAuthenticationStatusLocked(int requestId, int status) {
        addTaggedDataToRequestLogLocked(requestId, 1453, Integer.valueOf(status));
    }

    private void addTaggedDataToRequestLogLocked(int requestId, int tag, Object value) {
        LogMaker requestLog = this.mRequestLogs.get(requestId);
        if (requestLog != null) goto L6;
        Slog.w(TAG, "addTaggedDataToRequestLogLocked(tag=" + tag + "): no log for id " + requestId);
        return;
    L6:
        requestLog.addTaggedData(tag, value);
    }

    private void logAugmentedAutofillRequestLocked(int mode, ComponentName augmentedRemoteServiceName, AutofillId focusedId, boolean isWhitelisted, Boolean isInline) {
        String historyItem = "aug:id=" + this.id + " u=" + this.uid + " m=" + mode + " a=" + ComponentName.flattenToShortString(this.mComponentName) + " f=" + focusedId + " s=" + augmentedRemoteServiceName + " w=" + isWhitelisted + " i=" + isInline;
        this.mService.getMaster().logRequestLocked(historyItem);
    }

    boolean shouldAddEventToHistory() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        FillResponse lastResponse = getLastResponseLocked("shouldAddEventToHistory(%s)");     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (lastResponse != null) goto L10;
        return true;
    L10:
        if (RequestId.isSecondaryProvider(lastResponse.getRequestId()) == false) goto L13;
        return false;
    L13:
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    private void wtf(Exception e, String fmt, Object... args) {
        String message = String.format(fmt, args);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mWtfHistory.log(message);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (e == null) goto L8;
        Slog.wtf(TAG, message, e);
        return;
    L8:
        Slog.wtf(TAG, message);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static String actionAsString(int action) {
        switch(action) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "RESPONSE_EXPIRED";
    L7:
        return "VALUE_CHANGED";
    L9:
        return "VIEW_EXITED";
    L11:
        return "VIEW_ENTERED";
    L13:
        return "START_SESSION";
    L4:
        return "UNKNOWN_" + action;
    }

    private static String sessionStateAsString(int sessionState) {
        switch(sessionState) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "STATE_REMOVED";
    L7:
        return "STATE_FINISHED";
    L9:
        return "STATE_ACTIVE";
    L11:
        return "STATE_UNKNOWN";
    L4:
        return "UNKNOWN_SESSION_STATE_" + sessionState;
    }

    private int getAutofillServiceUid() {
        ServiceInfo serviceInfo = this.mService.getServiceInfo();
        if (serviceInfo != null) goto L6;
        return -1;
    L6:
        return serviceInfo.applicationInfo.uid;
    }

    @Override // com.android.server.autofill.RemoteFieldClassificationService.FieldClassificationServiceCallbacks
    public void onClassificationRequestSuccess(FieldClassificationResponse response) {
        ClassificationState.m2391$$Nest$mupdateResponseReceived(this.mClassificationState, response);
    }

    @Override // com.android.server.autofill.RemoteFieldClassificationService.FieldClassificationServiceCallbacks
    public void onClassificationRequestFailure(int requestId, CharSequence message) {
    }

    @Override // com.android.server.autofill.RemoteFieldClassificationService.FieldClassificationServiceCallbacks
    public void onClassificationRequestTimeout(int requestId) {
    }

    @Override // com.android.server.autofill.RemoteFieldClassificationService.FieldClassificationServiceCallbacks
    public void onServiceDied(RemoteFieldClassificationService service) {
        Slog.w(TAG, "removing session because service died");
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.autofill.RemoteFieldClassificationService.FieldClassificationServiceCallbacks
    public void logFieldClassificationEvent(long startTime, FieldClassificationResponse response, int status) {
        FieldClassificationEventLogger logger = FieldClassificationEventLogger.createLogger();
        logger.startNewLogForRequest();
        logger.maybeSetLatencyMillis(SystemClock.elapsedRealtime() - startTime);
        logger.maybeSetAppPackageUid(this.uid);
        logger.maybeSetNextFillRequestId(this.mFillRequestIdSnapshot + 1);
        logger.maybeSetRequestId(sIdCounterForPcc.get());
        logger.maybeSetSessionId(this.id);
        int count = -1;
        if (response == null) goto L5;
        count = response.getClassifications().size();
    L5:
        logger.maybeSetRequestStatus(status);
        logger.maybeSetCountClassifications(count);
        logger.logAndEndEvent();
        this.mFillRequestIdSnapshot = -2;
    }

    public IExtSession getExt() {
        return this.mExt;
    }
}
