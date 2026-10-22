package com.android.server.autofill;

import android.R;
import android.app.ActivityManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.metrics.LogMaker;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.autofill.AutofillServiceInfo;
import android.service.autofill.FieldClassification;
import android.service.autofill.FillEventHistory;
import android.service.autofill.FillResponse;
import android.service.autofill.UserData;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.LocalLog;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.autofill.AutofillFeatureFlags;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.autofill.IAutoFillManagerClient;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.autofill.ui.AutoFillUI;
import com.android.server.contentcapture.ContentCaptureManagerInternal;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
final class AutofillManagerServiceImpl extends AbstractPerUserSystemService<AutofillManagerServiceImpl, AutofillManagerService> {
    private static final int MAX_ABANDONED_SESSION_MILLIS = 30000;
    private static final int MAX_SESSION_ID_CREATE_TRIES = 2048;
    private static final String TAG = "AutofillManagerServiceImpl";
    private static final Random sRandom = null;
    private FillEventHistory mAugmentedAutofillEventHistory;
    private final AutofillManagerService.AutofillCompatState mAutofillCompatState;
    private RemoteCallbackList<IAutoFillManagerClient> mClients;
    private final ContentCaptureManagerInternal mContentCaptureManagerInternal;
    private final AutofillManagerService.DisabledInfoCache mDisabledInfoCache;
    private FillEventHistory mEventHistory;
    private final FieldClassificationStrategy mFieldClassificationStrategy;
    private final SparseArray<FillEventHistory> mFillHistories;
    private final Handler mHandler;
    private AutofillServiceInfo mInfo;
    private final InputMethodManagerInternal mInputMethodManagerInternal;
    private long mLastPrune;
    private final MetricsLogger mMetricsLogger;
    private RemoteAugmentedAutofillService mRemoteAugmentedAutofillService;
    private ServiceInfo mRemoteAugmentedAutofillServiceInfo;
    private RemoteFieldClassificationService mRemoteFieldClassificationService;
    private ServiceInfo mRemoteFieldClassificationServiceInfo;
    private RemoteInlineSuggestionRenderService mRemoteInlineSuggestionRenderService;
    private final SparseArray<Session> mSessions;
    private final AutoFillUI mUi;
    private final LocalLog mUiLatencyHistory;
    private UserData mUserData;
    private final UserManagerInternal mUserManagerInternal;
    private final LocalLog mWtfHistory;

    private class InlineSuggestionRenderCallbacksImpl implements RemoteInlineSuggestionRenderService.InlineSuggestionRenderCallbacks {
        final /* synthetic */ AutofillManagerServiceImpl this$0;

        /* synthetic */ InlineSuggestionRenderCallbacksImpl(AutofillManagerServiceImpl r1, AutofillManagerServiceImplIA r2) {
            this(r1);
        }

        private InlineSuggestionRenderCallbacksImpl(AutofillManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
            onServiceDied((RemoteInlineSuggestionRenderService) r1);
        }

        public void onServiceDied(RemoteInlineSuggestionRenderService service) {
            Slog.w(AutofillManagerServiceImpl.TAG, "remote service died: " + service);
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.resetExtServiceLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class PruneTask extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ AutofillManagerServiceImpl this$0;

        /* synthetic */ PruneTask(AutofillManagerServiceImpl r1, AutofillManagerServiceImplIA r2) {
            this(r1);
        }

        private PruneTask(AutofillManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... ignored) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int numSessionsToRemove = AutofillManagerServiceImpl.m2274$$Nest$fgetmSessions(this.this$0).size();     // Catch: Throwable -> L7
            SparseArray<IBinder> sessionsToRemove = new SparseArray(numSessionsToRemove);     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= numSessionsToRemove) goto L10;
            Session session = (Session) AutofillManagerServiceImpl.m2274$$Nest$fgetmSessions(this.this$0).valueAt(i);     // Catch: Throwable -> L7
            sessionsToRemove.put(session.id, session.getActivityTokenLocked());     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            ActivityTaskManagerInternal atmInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
            int i2 = 0;
        L12:
            if (i2 >= numSessionsToRemove) goto L17;
            if (atmInternal.getActivityName(sessionsToRemove.valueAt(i2)) == null) goto L16;
            sessionsToRemove.removeAt(i2);
            i2 = i2 - 1;
            numSessionsToRemove = numSessionsToRemove - 1;
        L16:
            i2 = i2 + 1;
            goto L12
        L17:
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            int i3 = 0;
        L20:
            if (i3 >= numSessionsToRemove) goto L38;
            Session sessionToRemove = (Session) AutofillManagerServiceImpl.m2274$$Nest$fgetmSessions(this.this$0).get(sessionsToRemove.keyAt(i3));     // Catch: Throwable -> L30
            if (sessionToRemove == null) goto L36;
            if (sessionsToRemove.valueAt(i3) != sessionToRemove.getActivityTokenLocked()) goto L36;
            if (sessionToRemove.isSaveUiShowingLocked() == false) goto L33;
            if (Helper.sVerbose == false) goto L36;
            Slog.v(AutofillManagerServiceImpl.TAG, "Session " + sessionToRemove.id + " is saving");     // Catch: Throwable -> L30
            goto L36
        L33:
            if (Helper.sDebug == false) goto L35;
            Slog.i(AutofillManagerServiceImpl.TAG, "Prune session " + sessionToRemove.id + " (" + sessionToRemove.getActivityTokenLocked() + ")");     // Catch: Throwable -> L30
        L35:
            sessionToRemove.removeFromServiceLocked();     // Catch: Throwable -> L30
        L36:
            i3 = i3 + 1;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        L38:
            monitor-exit(r4);     // Catch: Throwable -> L30
            return null;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteAugmentedAutofillService, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteAugmentedAutofillService m2273$$Nest$fgetmRemoteAugmentedAutofillService(AutofillManagerServiceImpl r0) {
        return r0.mRemoteAugmentedAutofillService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m2274$$Nest$fgetmSessions(AutofillManagerServiceImpl r0) {
        return r0.mSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteAugmentedAutofillService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2275$$Nest$fputmRemoteAugmentedAutofillService(AutofillManagerServiceImpl r0, RemoteAugmentedAutofillService r1) {
        r0.mRemoteAugmentedAutofillService = r1;
    }

    static {
        sRandom = new Random();
    }

    AutofillManagerServiceImpl(AutofillManagerService master, Object lock, LocalLog uiLatencyHistory, LocalLog wtfHistory, int userId, AutoFillUI ui, AutofillManagerService.AutofillCompatState autofillCompatState, boolean disabled, AutofillManagerService.DisabledInfoCache disableCache) {
        super(master, lock, userId);
        this.mMetricsLogger = new MetricsLogger();
        this.mHandler = new Handler(Looper.getMainLooper(), null, true);
        this.mSessions = new SparseArray();
        this.mFillHistories = new SparseArray();
        this.mLastPrune = 0;
        this.mUiLatencyHistory = uiLatencyHistory;
        this.mWtfHistory = wtfHistory;
        this.mUi = ui;
        this.mFieldClassificationStrategy = new FieldClassificationStrategy(getContext(), userId);
        this.mAutofillCompatState = autofillCompatState;
        this.mInputMethodManagerInternal = (InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class);
        this.mContentCaptureManagerInternal = (ContentCaptureManagerInternal) LocalServices.getService(ContentCaptureManagerInternal.class);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mDisabledInfoCache = disableCache;
        updateLocked(disabled);
    }

    boolean sendActivityAssistDataToContentCapture(IBinder activityToken, Bundle data) {
        if (this.mContentCaptureManagerInternal == null) goto L6;
        this.mContentCaptureManagerInternal.sendActivityAssistData(getUserId(), activityToken, data);
        return true;
    L6:
        return false;
    }

    void onBackKeyPressed() {
        RemoteAugmentedAutofillService remoteService = getRemoteAugmentedAutofillServiceLocked();
        if (remoteService == null) goto L6;
        remoteService.onDestroyAutofillWindowsRequest();
        return;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        forceRemoveAllSessionsLocked();
        boolean enabledChanged = super.updateLocked(disabled);
        if (enabledChanged == true) goto L5;
    L10:
        updateRemoteAugmentedAutofillService();
        getRemoteInlineSuggestionRenderServiceLocked();
        return enabledChanged;
    L5:
        if (isEnabledLocked() == true) goto L9;
        int sessionCount = this.mSessions.size();
        int i = sessionCount - 1;
    L7:
        if (i < 0) goto L9;
        Session session = this.mSessions.valueAt(i);
        session.removeFromServiceLocked();
        i = i - 1;
    L9:
        sendStateToClients(false);
        goto L10
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        List<ResolveInfo> resolveInfos = getContext().getPackageManager().queryIntentServicesAsUser(new Intent("android.service.autofill.AutofillService"), 8388736, this.mUserId);
        boolean serviceHasAutofillIntentFilter = false;
        Iterator<ResolveInfo> r3 = resolveInfos.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ResolveInfo resolveInfo = r3.next();
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo.getComponentName().equals(serviceComponent) == false) goto L4;
        serviceHasAutofillIntentFilter = true;
    L9:
        if (serviceHasAutofillIntentFilter == false) goto L12;
        this.mInfo = new AutofillServiceInfo(getContext(), serviceComponent, this.mUserId);
        return this.mInfo.getServiceInfo();
    L12:
        Slog.w(TAG, "Autofill service from '" + serviceComponent.getPackageName() + "' doesnot have intent filter android.service.autofill.AutofillService");
        throw new SecurityException("Service does not declare intent filter android.service.autofill.AutofillService");
    }

    String[] getUrlBarResourceIdsForCompatMode(String packageName) {
        return this.mAutofillCompatState.getUrlBarResourceIds(packageName, this.mUserId);
    }

    int addClientLocked(IAutoFillManagerClient client, ComponentName componentName, boolean credmanRequested) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ComponentName credComponentName = getCredentialAutofillService(getContext());     // Catch: Throwable -> L14
        if (credmanRequested == true) goto L17;
        if (this.mInfo != null) goto L9;
        ComponentName r3 = null;
    L11:
        if (Objects.equals(credComponentName, r3) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return 0;
    L9:
        r3 = this.mInfo.getServiceInfo().getComponentName();     // Catch: Throwable -> L14
    L17:
        if (this.mClients != null) goto L19;
        this.mClients = new RemoteCallbackList();     // Catch: Throwable -> L14
    L19:
        this.mClients.register(client);     // Catch: Throwable -> L14
        if (isEnabledLocked() == false) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return 1;
    L24:
        if (componentName != null) goto L26;
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return 0;
    L26:
        if (isAugmentedAutofillServiceAvailableLocked() == false) goto L32;
        if (isWhitelistedForAugmentedAutofillLocked(componentName) == false) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return 8;
    L14:
        th = move-exception;
        throw th;
    }

    void removeClientLocked(IAutoFillManagerClient client) {
        if (this.mClients == null) goto L6;
        this.mClients.unregister(client);
        return;
    }

    void setAuthenticationResultLocked(Bundle data, int sessionId, int authenticationId, int uid) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L8;
        return;
    L8:
        if (uid != session.uid) goto L20;
        Object r1 = session.mLock;
        monitor-enter(r1);
        session.setAuthenticationResultLocked(data, authenticationId);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void setHasCallback(int sessionId, int uid, boolean hasIt) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L8;
        return;
    L8:
        if (uid != session.uid) goto L20;
        Object r1 = this.mLock;
        monitor-enter(r1);
        session.setHasCallbackLocked(hasIt);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    long startSessionLocked(IBinder activityToken, int taskId, int clientUid, IBinder clientCallback, AutofillId autofillId, Rect virtualBounds, AutofillValue value, boolean hasCallback, ComponentName clientActivity, boolean compatMode, boolean bindInstantServiceAllowed, int flags) {
        if ((flags & 8) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean forAugmentedAutofillOnly = r0;
        if (isEnabledLocked() == true) goto L11;
        if (forAugmentedAutofillOnly == true) goto L11;
        return 0;
    L11:
        if (this.mUserManagerInternal.isVisibleBackgroundFullUser(this.mUserId) == false) goto L14;
        Slog.d(TAG, "Currently, autofill service does not support visible background users.");
        return 0;
    L14:
        String r1 = null;
        if (forAugmentedAutofillOnly == false) goto L17;
    L33:
        boolean forAugmentedAutofillOnly2 = forAugmentedAutofillOnly;
    L35:
        if (Helper.sVerbose == false) goto L37;
        StringBuilder r2 = new StringBuilder();
        r2.append("startSession(): token=");
        IBinder r3 = activityToken;
        r2.append(r3);
        r2.append(", flags=");
        r2.append(flags);
        r2.append(", forAugmentedAutofillOnly=");
        r2.append(forAugmentedAutofillOnly2);
        Slog.v(TAG, r2.toString());
    L38:
        pruneAbandonedSessionsLocked();
        Session newSession = createSessionByTokenLocked(r3, taskId, clientUid, clientCallback, hasCallback, clientActivity, compatMode, bindInstantServiceAllowed, forAugmentedAutofillOnly2, flags);
        if (newSession != null) goto L42;
        return 2147483647L;
    L42:
        if (this.mInfo == null) goto L45;
        r1 = this.mInfo.getServiceInfo().packageName;
    L45:
        String servicePackageName = r1;
        String historyItem = "id=" + newSession.id + " uid=" + clientUid + " a=" + clientActivity.toShortString() + " s=" + servicePackageName + " u=" + this.mUserId + " i=" + autofillId + " b=" + virtualBounds + " hc=" + hasCallback + " f=" + flags + " aa=" + forAugmentedAutofillOnly2;
        ((AutofillManagerService) this.mMaster).logRequestLocked(historyItem);
        Object r13 = newSession.mLock;
        monitor-enter(r13);
        newSession.updateLocked(autofillId, virtualBounds, value, 1, flags);     // Catch: Throwable -> L55
        monitor-exit(r13);     // Catch: Throwable -> L55
        if (forAugmentedAutofillOnly2 == false) goto L54;
        long result = ((long) newSession.id) | 4294967296L;
        return result;
    L54:
        return newSession.id;
    L55:
        th = move-exception;
        throw th;
    L37:
        r3 = activityToken;
        goto L38
    L17:
        if (isAutofillDisabledLocked(clientActivity) == false) goto L33;
        if (isWhitelistedForAugmentedAutofillLocked(clientActivity) == false) goto L25;
        if (Helper.sDebug == false) goto L23;
        Slog.d(TAG, "startSession(" + clientActivity + "): disabled by service but whitelisted for augmented autofill");
    L23:
        forAugmentedAutofillOnly2 = true;
        goto L35
    L25:
        if (Helper.sDebug == false) goto L27;
        Slog.d(TAG, "startSession(" + clientActivity + "): ignored because disabled by service and not whitelisted for augmented autofill");
    L27:
        IAutoFillManagerClient client = IAutoFillManagerClient.Stub.asInterface(clientCallback);
        client.setSessionFinished(4, null);     // Catch: RemoteException -> L30
    L32:
        return 2147483647L;
    L30:
        e = move-exception;
        Slog.w(TAG, "Could not notify " + clientActivity + " that it's disabled: " + e);
        goto L32
    L5:
        r0 = false;
        goto L6
    }

    private void pruneAbandonedSessionsLocked() {
        long now = System.currentTimeMillis();
        if (this.mLastPrune >= (now - 30000)) goto L8;
        this.mLastPrune = now;
        if (this.mSessions.size() <= 0) goto L9;
        new PruneTask(this, null).execute(new Void[0]);
        return;
    L9:
        return;
    }

    void setAutofillFailureLocked(int sessionId, int uid, List<AutofillId> ids, boolean isRefill) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "setAutofillFailure(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.setAutofillFailureLocked(ids, isRefill);
    }

    void setViewAutofilledLocked(int sessionId, int uid, AutofillId id) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "setViewAutofilled(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.setViewAutofilledLocked(id);
    }

    void notifyNotExpiringResponseDuringAuth(int sessionId, int uid) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "notifyNotExpiringResponseDuringAuth(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.setNotifyNotExpiringResponseDuringAuth();
    }

    void notifyViewEnteredIgnoredDuringAuthCount(int sessionId, int uid) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "notifyViewEnteredIgnoredDuringAuthCount(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.setLogViewEnteredIgnoredDuringAuth();
    }

    public void setAutofillIdsAttemptedForRefill(int sessionId, List<AutofillId> ids, int uid) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "setAutofillIdsAttemptedForRefill(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.setAutofillIdsAttemptedForRefillLocked(ids);
    }

    void finishSessionLocked(int sessionId, int uid, int commitReason) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session == null) goto L33;
        if (uid != session.uid) goto L33;
        int ret = Settings.Global.getInt(getContext().getContentResolver(), "apprecord_testmode", 0);     // Catch: Exception -> L19
        Slog.i(TAG, "finishSessionLocked ret=" + ret);     // Catch: Exception -> L19
        if (ret == 0) goto L15;
    L23:
        Session.SaveResult saveResult = session.showSaveLocked();
        session.logContextCommittedLocked(saveResult.getNoSaveUiReason(), commitReason);
        if (saveResult.isLogSaveShown() == false) goto L26;
        session.logSaveUiShown();
    L26:
        boolean finished = saveResult.isRemoveSession();
        if (Helper.sVerbose == false) goto L29;
        Slog.v(TAG, "finishSessionLocked(): session finished? " + finished + ", showing save UI? " + saveResult.isLogSaveShown());
    L29:
        if (finished == false) goto L38;
        session.removeFromServiceLocked();
        return;
    L38:
        return;
    L15:
        if (session.getUiForShowing() == null) goto L23;
        if (session.getUiForShowing().isSaveUiShowing() == false) goto L23;
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    L33:
        if (Helper.sVerbose == false) goto L39;
        Slog.v(TAG, "finishSessionLocked(): no session for " + sessionId + "(" + uid + ")");
        return;
    }

    void cancelSessionLocked(int sessionId, int uid) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L8;
    L12:
        Slog.w(TAG, "cancelSessionLocked(): no session for " + sessionId + "(" + uid + ")");
        return;
    L8:
        if (uid != session.uid) goto L12;
        session.removeFromServiceLocked();
    }

    void disableOwnedAutofillServicesLocked(int uid) {
        Slog.i(TAG, "disableOwnedServices(" + uid + "): " + this.mInfo);
        if (this.mInfo != null) goto L5;
        return;
    L5:
        ServiceInfo serviceInfo = this.mInfo.getServiceInfo();
        if (serviceInfo.applicationInfo.uid == uid) goto L9;
        Slog.w(TAG, "disableOwnedServices(): ignored when called by UID " + uid + " instead of " + serviceInfo.applicationInfo.uid + " for service " + this.mInfo);
        return;
    L9:
        long identity = Binder.clearCallingIdentity();
        String autoFillService = getComponentNameLocked();     // Catch: Throwable -> L13
        ComponentName componentName = serviceInfo.getComponentName();     // Catch: Throwable -> L13
        if (componentName.equals(ComponentName.unflattenFromString(autoFillService)) == false) goto L15;
        this.mMetricsLogger.action(1135, componentName.getPackageName());     // Catch: Throwable -> L13
        Settings.Secure.putStringForUser(getContext().getContentResolver(), "autofill_service", null, this.mUserId);     // Catch: Throwable -> L13
        forceRemoveAllSessionsLocked();     // Catch: Throwable -> L13
    L16:
        Binder.restoreCallingIdentity(identity);
        return;
    L15:
        Slog.w(TAG, "disableOwnedServices(): ignored because current service (" + serviceInfo + ") does not match Settings (" + autoFillService + ")");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private Session createSessionByTokenLocked(IBinder clientActivityToken, int taskId, int clientUid, IBinder clientCallback, boolean hasCallback, ComponentName clientActivity, boolean compatMode, boolean bindInstantServiceAllowed, boolean forAugmentedAutofillOnly, int flags) {
        int tries = 0;
    L3:
        boolean r2 = true;
        int tries2 = tries + 1;
        if (tries2 > 2048) goto L5;
        int sessionId = Math.abs(sRandom.nextInt());
        if (sessionId == 0) goto L28;
        if (sessionId == Integer.MAX_VALUE) goto L28;
        if (this.mSessions.indexOfKey(sessionId) >= 0) goto L28;
        assertCallerLocked(clientActivity, compatMode);
        if (this.mInfo != null) goto L16;
        ComponentName serviceComponentName = null;
    L18:
        if ((flags & 2048) == 0) goto L20;
    L19:
        boolean isPrimaryCredential = r2;
        Session newSession = new Session(this, this.mUi, getContext(), this.mHandler, this.mUserId, this.mLock, sessionId, taskId, clientUid, clientActivityToken, clientCallback, hasCallback, this.mUiLatencyHistory, this.mWtfHistory, serviceComponentName, clientActivity, compatMode, bindInstantServiceAllowed, forAugmentedAutofillOnly, flags, this.mInputMethodManagerInternal, isPrimaryCredential);
        this.mSessions.put(newSession.id, newSession);
        if (AutofillFeatureFlags.isMultipleFillEventHistoryEnabled() == false) goto L25;
        if (forAugmentedAutofillOnly == true) goto L25;
        this.mFillHistories.put(newSession.id, new FillEventHistory(sessionId, null));
    L25:
        return newSession;
    L20:
        r2 = false;
        goto L19
    L16:
        serviceComponentName = this.mInfo.getServiceInfo().getComponentName();
    L28:
        tries = tries2;
        goto L3
    L5:
        Slog.w(TAG, "Cannot create session in 2048 tries");
        return null;
    }

    private void assertCallerLocked(ComponentName componentName, boolean compatMode) {
        String packageName = componentName.getPackageName();
        PackageManager pm = getContext().getPackageManager();
        int callingUid = Binder.getCallingUid();
        int packageUid = pm.getPackageUidAsUser(packageName, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L17
        if (callingUid != packageUid) goto L6;
        return;
    L6:
        if (((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).hasRunningActivity(callingUid, packageName) == true) goto L22;
        String[] packages = pm.getPackagesForUid(callingUid);
        if (packages == null) goto L10;
        String callingPackage = packages[0];
    L11:
        Slog.w(TAG, "App (package=" + callingPackage + ", UID=" + callingUid + ") passed component (" + componentName + ") owned by UID " + packageUid);
        LogMaker log = new LogMaker(948).setPackageName(callingPackage).addTaggedData(908, getServicePackageName()).addTaggedData(949, componentName.flattenToShortString());
        if (compatMode == false) goto L14;
        log.addTaggedData(1414, 1);
    L14:
        this.mMetricsLogger.write(log);
        throw new SecurityException("Invalid component: " + componentName);
    L10:
        callingPackage = "uid-" + callingUid;
        goto L11
    L22:
        return;
    L19:
        throw new SecurityException("Could not verify UID for " + componentName);
    }

    boolean restoreSession(int sessionId, int uid, IBinder activityToken, IBinder appCallback) {
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L5;
        return false;
    L5:
        if (uid != session.uid) goto L11;
        session.switchActivity(activityToken, appCallback);
        return true;
    L11:
        return false;
    }

    boolean updateSessionLocked(int sessionId, int uid, AutofillId autofillId, Rect virtualBounds, AutofillValue value, int action, int flags) {
        Session session = this.mSessions.get(sessionId);
        if (session == null) goto L11;
        if (session.uid != uid) goto L11;
        session.updateLocked(autofillId, virtualBounds, value, action, flags);
        return false;
    L11:
        if ((flags & 1) == 0) goto L18;
        if (Helper.sDebug == false) goto L21;
        Slog.d(TAG, "restarting session " + sessionId + " due to manual request on " + autofillId);
        return true;
    L21:
        return true;
    L18:
        if (Helper.sVerbose == false) goto L20;
        Slog.v(TAG, "updateSessionLocked(): session gone for " + sessionId + "(" + uid + ")");
    L20:
        return false;
    }

    void callOnSessionDestroyed(int sessionId) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "removeSessionLocked(): removed " + sessionId);
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        FillEventHistory history = null;
    L13:
        th = move-exception;
        throw th;
    L9:
        if (AutofillFeatureFlags.isMultipleFillEventHistoryEnabled() == false) goto L16;
        if (this.mFillHistories == null) goto L16;
        history = this.mFillHistories.get(sessionId);     // Catch: Throwable -> L13
        this.mFillHistories.delete(sessionId);     // Catch: Throwable -> L13
    L16:
        if (this.mInfo == null) goto L31;
        if (this.mInfo.getServiceInfo() == null) goto L31;
        if (this.mMaster == 0) goto L23;
        RemoteFillService remoteService = new RemoteFillService(getContext(), this.mInfo.getServiceInfo().getComponentName(), this.mUserId, null, ((AutofillManagerService) this.mMaster).isInstantServiceAllowed(), null);     // Catch: Throwable -> L13
        remoteService.onSessionDestroyed(history);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L23:
        if (Helper.sVerbose == false) goto L25;
        Slog.v(TAG, "removeSessionLocked(): early return because mMaster is null");     // Catch: Throwable -> L13
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L31:
        if (Helper.sVerbose == false) goto L33;
        Slog.v(TAG, "removeSessionLocked(): early return because mInfo is null");     // Catch: Throwable -> L13
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L13
    }

    void removeSessionLocked(int sessionId) {
        this.mSessions.remove(sessionId);
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AutofillManagerServiceImpl$$ExternalSyntheticLambda0(), this, Integer.valueOf(sessionId)));
    }

    ArrayList<Session> getPreviousSessionsLocked(Session session) {
        int size = this.mSessions.size();
        ArrayList<Session> previousSessions = null;
        int i = 0;
    L3:
        if (i >= size) goto L15;
        Session previousSession = this.mSessions.valueAt(i);
        if (previousSession.taskId != session.taskId) goto L13;
        if (previousSession.id == session.id) goto L13;
        if ((previousSession.getSaveInfoFlagsLocked() & 4) == 0) goto L13;
        if (previousSessions != null) goto L12;
        previousSessions = new ArrayList(size);
    L12:
        previousSessions.add(previousSession);
    L13:
        i = i + 1;
        goto L3
    L15:
        return previousSessions;
    }

    void handleSessionSave(Session session) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessions.get(session.id) != null) goto L11;
        Slog.w(TAG, "handleSessionSave(): already gone: " + session.id);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        session.callSaveLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    void onPendingSaveUi(int operation, IBinder token) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "onPendingSaveUi(" + operation + "): " + token);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int sessionCount = this.mSessions.size();     // Catch: Throwable -> L14
        int i = sessionCount - 1;     // Catch: Throwable -> L14
    L8:
        if (i < 0) goto L18;
        Session session = this.mSessions.valueAt(i);     // Catch: Throwable -> L14
        if (session.isSaveUiPendingForTokenLocked(token) == true) goto L11;
        i = i - 1;     // Catch: Throwable -> L14
        goto L8
    L11:
        session.onPendingSaveUi(operation, token);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (Helper.sDebug == false) goto L28;
        Slog.d(TAG, "No pending Save UI for token " + token + " and operation " + DebugUtils.flagsToString(AutofillManager.class, "PENDING_UI_OPERATION_", operation));
        return;
    L28:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void notifyImeAnimationStart(int sessionId, long startTimeMs, int uid) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "notifyImeAnimationStart(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.notifyImeAnimationStart(startTimeMs);
    }

    public void notifyImeAnimationEnd(int sessionId, long endTimeMs, int uid) {
        if (isEnabledLocked() == true) goto L6;
        Slog.wtf(TAG, "Service not enabled");
        return;
    L6:
        Session session = this.mSessions.get(sessionId);
        if (session != null) goto L9;
    L13:
        Slog.v(TAG, "notifyImeAnimationEnd(): no session for " + sessionId + "(" + uid + ")");
        return;
    L9:
        if (uid != session.uid) goto L13;
        session.notifyImeAnimationEnd(endTimeMs);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void handlePackageUpdateLocked(String packageName) {
        ServiceInfo serviceInfo = this.mFieldClassificationStrategy.getServiceInfo();
        if (serviceInfo != null) goto L5;
        return;
    L5:
        if (serviceInfo.packageName.equals(packageName) == false) goto L9;
        resetExtServiceLocked();
        return;
    }

    void resetExtServiceLocked() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "reset autofill service in ExtServices.");
    L5:
        this.mFieldClassificationStrategy.reset();
        if (this.mRemoteInlineSuggestionRenderService == null) goto L9;
        this.mRemoteInlineSuggestionRenderService.destroy();
        this.mRemoteInlineSuggestionRenderService = null;
        return;
    }

    void destroyLocked() {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "destroyLocked()");
    L5:
        resetExtServiceLocked();
        int numSessions = this.mSessions.size();
        ArraySet<RemoteFillService> remoteFillServices = new ArraySet(numSessions);
        int i = 0;
    L6:
        if (i >= numSessions) goto L11;
        RemoteFillService remoteFillService = this.mSessions.valueAt(i).destroyLocked();
        if (remoteFillService == null) goto L10;
        remoteFillServices.add(remoteFillService);
    L10:
        i = i + 1;
        goto L6
    L11:
        this.mSessions.clear();
        if (AutofillFeatureFlags.isMultipleFillEventHistoryEnabled() == false) goto L14;
        this.mFillHistories.clear();
    L14:
        int i2 = 0;
    L16:
        if (i2 >= remoteFillServices.size()) goto L18;
        remoteFillServices.valueAt(i2).destroy();
        i2 = i2 + 1;
        goto L16
    L18:
        sendStateToClients(true);
        if (this.mClients == null) goto L26;
        this.mClients.kill();
        this.mClients = null;
        return;
    }

    void setLastResponseLocked(int sessionId, FillResponse response) {
        this.mEventHistory = new FillEventHistory(sessionId, response.getClientState());
    }

    void setLastAugmentedAutofillResponse(int sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAugmentedAutofillEventHistory = new FillEventHistory(sessionId, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetLastResponse() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEventHistory = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void resetLastAugmentedAutofillResponse() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAugmentedAutofillEventHistory = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isValidEventLocked(String method, int sessionId) {
        if (this.mEventHistory != null) goto L7;
        Slog.w(TAG, method + ": not logging event because history is null");
        return false;
    L7:
        if (sessionId != this.mEventHistory.getSessionId()) goto L9;
        return true;
    L9:
        if (Helper.sDebug == false) goto L11;
        Slog.d(TAG, method + ": not logging event for session " + sessionId + " because tracked session is " + this.mEventHistory.getSessionId());
    L11:
        return false;
    }

    void addEventToHistory(String eventName, int sessionId, FillEventHistory.Event event) {
        if (isValidEventLocked(eventName, sessionId) == false) goto L6;
        this.mEventHistory.addEvent(event);
    L6:
        if (AutofillFeatureFlags.isMultipleFillEventHistoryEnabled() == false) goto L14;
        FillEventHistory history = this.mFillHistories.get(sessionId);
        if (history == null) goto L11;
        history.addEvent(event);
        return;
    L11:
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, eventName + " not logged because FillEventHistory is not tracked for: " + sessionId);
        return;
    L16:
        return;
    }

    void setAuthenticationSelected(int sessionId, Bundle clientState, int uiType, AutofillId focusedId, boolean shouldAdd) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L21:
        if (shouldAdd == false) goto L7;
        FillEventHistory.Event event = new FillEventHistory.Event(2, null, clientState, null, null, null, null, null, null, null, null, 0, uiType, focusedId);     // Catch: Throwable -> L9
        addEventToHistory("setAuthenticationSelected()", sessionId, event);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "setAuthenticationSelected() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L19
    }

    void logDatasetAuthenticationSelected(String selectedDataset, int sessionId, Bundle clientState, int uiType, AutofillId focusedId, boolean shouldAdd) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L21:
        if (shouldAdd == false) goto L7;
        FillEventHistory.Event event = new FillEventHistory.Event(1, selectedDataset, clientState, null, null, null, null, null, null, null, null, 0, uiType, focusedId);     // Catch: Throwable -> L9
        addEventToHistory("logDatasetAuthenticationSelected()", sessionId, event);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "logDatasetAuthenticationSelected() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L19
    }

    void logSaveShown(int sessionId, Bundle clientState, boolean shouldAdd) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L22:
        if (shouldAdd == false) goto L7;
        FillEventHistory.Event event = new FillEventHistory.Event(3, null, clientState, null, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L9
        addEventToHistory("logSaveShown()", sessionId, event);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "logSaveShown() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L19
    }

    void logDatasetSelected(String selectedDataset, int sessionId, Bundle clientState, int uiType, AutofillId focusedId, boolean shouldAdd) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L21:
        if (shouldAdd == false) goto L7;
        FillEventHistory.Event event = new FillEventHistory.Event(0, selectedDataset, clientState, null, null, null, null, null, null, null, null, 0, uiType, focusedId);     // Catch: Throwable -> L9
        addEventToHistory("logDatasetSelected()", sessionId, event);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "logDatasetSelected() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L19
    }

    void logDatasetShown(int sessionId, Bundle clientState, int uiType, AutofillId focusedId, boolean shouldAdd) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L21:
        if (shouldAdd == false) goto L7;
        FillEventHistory.Event event = new FillEventHistory.Event(5, null, clientState, null, null, null, null, null, null, null, null, 0, uiType, focusedId);     // Catch: Throwable -> L9
        addEventToHistory("logDatasetShown()", sessionId, event);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "logDatasetShown() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
        goto L19
    }

    void logViewEnteredForHistory(int sessionId, Bundle clientState, FillEventHistory history, AutofillId focusedId) {
        if (history.getEvents() == null) goto L14;
        Iterator<FillEventHistory.Event> r0 = history.getEvents().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        FillEventHistory.Event event = r0.next();
        if (event.getType() != 6) goto L6;
        if (Helper.sVerbose == false) goto L19;
        Slog.v(TAG, "logViewEntered: already logged TYPE_VIEW_REQUESTED_AUTOFILL");
        return;
    L19:
        return;
    L14:
        history.addEvent(new FillEventHistory.Event(6, null, clientState, null, null, null, null, null, null, null, null, focusedId));
    }

    void logViewEntered(int sessionId, Bundle clientState, AutofillId focusedId, boolean shouldAdd) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (shouldAdd == true) goto L14;
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "logViewEntered() not logged because shouldAdd is false");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        if (isValidEventLocked("logViewEntered()", sessionId) == false) goto L17;
        logViewEnteredForHistory(sessionId, clientState, this.mEventHistory, focusedId);     // Catch: Throwable -> L9
    L17:
        if (AutofillFeatureFlags.isMultipleFillEventHistoryEnabled() == false) goto L21;
        FillEventHistory history = this.mFillHistories.get(sessionId);     // Catch: Throwable -> L9
        if (history == null) goto L21;
        logViewEnteredForHistory(sessionId, clientState, history, focusedId);     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void logAugmentedAutofillAuthenticationSelected(int sessionId, String selectedDataset, Bundle clientState) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L15:
        th = th;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L13
        throw th;
    L5:
        if (this.mAugmentedAutofillEventHistory == null) goto L18;
        if (this.mAugmentedAutofillEventHistory.getSessionId() != sessionId) goto L18;
        this.mAugmentedAutofillEventHistory.addEvent(new FillEventHistory.Event(1, selectedDataset, clientState, null, null, null, null, null, null, null, null, null));     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = th;
        goto L20
    }

    void logAugmentedAutofillSelected(int sessionId, String suggestionId, Bundle clientState) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L15:
        th = th;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L13
        throw th;
    L5:
        if (this.mAugmentedAutofillEventHistory == null) goto L18;
        if (this.mAugmentedAutofillEventHistory.getSessionId() != sessionId) goto L18;
        this.mAugmentedAutofillEventHistory.addEvent(new FillEventHistory.Event(0, suggestionId, clientState, null, null, null, null, null, null, null, null, null));     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = th;
        goto L20
    }

    void logAugmentedAutofillShown(int sessionId, Bundle clientState) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L13:
        th = th;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L13
        throw th;
    L15:
        th = th;
        goto L20
    L5:
        if (this.mAugmentedAutofillEventHistory == null) goto L18;
        if (this.mAugmentedAutofillEventHistory.getSessionId() != sessionId) goto L18;
        this.mAugmentedAutofillEventHistory.addEvent(new FillEventHistory.Event(5, null, clientState, null, null, null, null, null, null, null, null, 0, 2, null));     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
    }

    void logContextCommittedLocked(int sessionId, Bundle clientState, ArrayList<String> selectedDatasets, ArraySet<String> ignoredDatasets, ArrayList<AutofillId> changedFieldIds, ArrayList<String> changedDatasetIds, ArrayList<AutofillId> manuallyFilledFieldIds, ArrayList<ArrayList<String>> manuallyFilledDatasetIds, ComponentName appComponentName, boolean compatMode, boolean shouldAdd) {
        logContextCommittedLocked(sessionId, clientState, selectedDatasets, ignoredDatasets, changedFieldIds, changedDatasetIds, manuallyFilledFieldIds, manuallyFilledDatasetIds, null, null, appComponentName, compatMode, 0, shouldAdd);
    }

    void logContextCommittedLocked(int sessionId, Bundle clientState, ArrayList<String> selectedDatasets, ArraySet<String> ignoredDatasets, ArrayList<AutofillId> changedFieldIds, ArrayList<String> changedDatasetIds, ArrayList<AutofillId> manuallyFilledFieldIds, ArrayList<ArrayList<String>> manuallyFilledDatasetIds, ArrayList<AutofillId> detectedFieldIdsList, ArrayList<FieldClassification> detectedFieldClassificationsList, ComponentName appComponentName, boolean compatMode, int saveDialogNotShowReason, boolean shouldAdd) {
        if (shouldAdd == true) goto L9;
        if (Helper.sVerbose == false) goto L26;
        Slog.v(TAG, "logContextCommittedLocked() not logged because shouldAdd is false");
        return;
    L26:
        return;
    L9:
        if (Helper.sVerbose == false) goto L11;
        StringBuilder r7 = new StringBuilder();
        r7.append("logContextCommitted() with FieldClassification: id=");
        r7.append(sessionId);
        r7.append(", selectedDatasets=");
        ArrayList<String> r13 = selectedDatasets;
        r7.append(r13);
        r7.append(", ignoredDatasetIds=");
        ArraySet<String> r14 = ignoredDatasets;
        r7.append(r14);
        r7.append(", changedAutofillIds=");
        ArrayList<AutofillId> r15 = changedFieldIds;
        r7.append(r15);
        r7.append(", changedDatasetIds=");
        ArrayList<String> r8 = changedDatasetIds;
        r7.append(r8);
        r7.append(", manuallyFilledFieldIds=");
        r7.append(manuallyFilledFieldIds);
        r7.append(", detectedFieldIds=");
        r7.append(detectedFieldIdsList);
        r7.append(", detectedFieldClassifications=");
        r7.append(detectedFieldClassificationsList);
        r7.append(", appComponentName=");
        r7.append(appComponentName.toShortString());
        r7.append(", compatMode=");
        r7.append(compatMode);
        r7.append(", saveDialogNotShowReason=");
        r7.append(saveDialogNotShowReason);
        Slog.v(TAG, r7.toString());
    L13:
        if (detectedFieldIdsList == null) goto L21;
        AutofillId[] detectedFieldsIds = new AutofillId[detectedFieldIdsList.size()];
        detectedFieldIdsList.toArray(detectedFieldsIds);
        FieldClassification[] detectedFieldClassifications = new FieldClassification[detectedFieldClassificationsList.size()];
        detectedFieldClassificationsList.toArray(detectedFieldClassifications);
        int numberFields = detectedFieldsIds.length;
        int totalSize = 0;
        float totalScore = 0.0f;
        int i = 0;
    L15:
        if (i >= numberFields) goto L20;
        FieldClassification fc = detectedFieldClassifications[i];
        int i2 = i;
        List<FieldClassification.Match> matches = fc.getMatches();
        int size = matches.size();
        totalSize = totalSize + size;
        AutofillId[] detectedFieldsIds2 = detectedFieldsIds;
        int j = 0;
    L17:
        if (j >= size) goto L19;
        totalScore = totalScore + matches.get(j).getScore();
        j = j + 1;
        goto L17
    L19:
        i = i2 + 1;
        detectedFieldsIds = detectedFieldsIds2;
        goto L15
    L20:
        AutofillId[] detectedFieldsIds3 = detectedFieldsIds;
        int averageScore = (int) ((100.0f * totalScore) / totalSize);
        this.mMetricsLogger.write(Helper.newLogMaker(1273, appComponentName, getServicePackageName(), sessionId, compatMode).setCounterValue(numberFields).addTaggedData(1274, Integer.valueOf(averageScore)));
        FieldClassification[] detectedFieldClassifications2 = detectedFieldClassifications;
    L22:
        FillEventHistory.Event event = new FillEventHistory.Event(4, null, clientState, r13, r14, r15, r8, manuallyFilledFieldIds, manuallyFilledDatasetIds, detectedFieldsIds3, detectedFieldClassifications2, saveDialogNotShowReason, null);
        addEventToHistory("logContextCommittedLocked()", sessionId, event);
        return;
    L21:
        detectedFieldsIds3 = null;
        detectedFieldClassifications2 = null;
        goto L22
    L11:
        r13 = selectedDatasets;
        r14 = ignoredDatasets;
        r15 = changedFieldIds;
        r8 = changedDatasetIds;
        goto L13
    }

    FillEventHistory getFillEventHistory(int callingUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mEventHistory == null) goto L14;
        if (isCalledByServiceLocked("getFillEventHistory", callingUid) == false) goto L14;
        FillEventHistory r1 = this.mEventHistory;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L14:
        if (this.mAugmentedAutofillEventHistory != null) goto L16;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L16:
        if (isCalledByAugmentedAutofillServiceLocked("getFillEventHistory", callingUid) == false) goto L20;
        FillEventHistory r2 = this.mAugmentedAutofillEventHistory;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    }

    UserData getUserData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserData r1 = this.mUserData;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    UserData getUserData(int callingUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCalledByServiceLocked("getUserData", callingUid) == false) goto L11;
        UserData r1 = this.mUserData;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }

    void setUserData(int callingUid, UserData userData) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isCalledByServiceLocked("setUserData", callingUid) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUserData = userData;     // Catch: Throwable -> L8
        if (this.mUserData != null) goto L13;
        int numberFields = 0;
    L14:
        this.mMetricsLogger.write(new LogMaker(1272).setPackageName(getServicePackageName()).addTaggedData(914, Integer.valueOf(numberFields)));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        numberFields = this.mUserData.getCategoryIds().length;     // Catch: Throwable -> L8
        goto L14
    }

    private boolean isCalledByServiceLocked(String methodName, int callingUid) {
        int serviceUid = getServiceUidLocked();
        if (serviceUid == callingUid) goto L6;
        Slog.w(TAG, methodName + "() called by UID " + callingUid + ", but service UID is " + serviceUid);
        return false;
    L6:
        return true;
    }

    int getSupportedSmartSuggestionModesLocked() {
        return ((AutofillManagerService) this.mMaster).getSupportedSmartSuggestionModesLocked();
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        String prefix2 = prefix + "  ";
        pw.print(prefix);
        pw.print("UID: ");
        pw.println(getServiceUidLocked());
        pw.print(prefix);
        pw.print("Autofill Service Info: ");
        if (this.mInfo != null) goto L5;
        pw.println("N/A");
    L6:
        pw.print(prefix);
        pw.print("Default component: ");
        pw.println(getContext().getString(R.string.config_deviceSpecificDeviceStatePolicyProvider));
        pw.println();
        pw.print(prefix);
        pw.println("mAugmentedAutofillName: ");
        pw.print(prefix2);
        ((AutofillManagerService) this.mMaster).mAugmentedAutofillResolver.dumpShort(pw, this.mUserId);
        pw.println();
        if (this.mRemoteAugmentedAutofillService == null) goto L10;
        pw.print(prefix);
        pw.println("RemoteAugmentedAutofillService: ");
        this.mRemoteAugmentedAutofillService.dump(prefix2, pw);
    L10:
        if (this.mRemoteAugmentedAutofillServiceInfo == null) goto L12;
        pw.print(prefix);
        pw.print("RemoteAugmentedAutofillServiceInfo: ");
        pw.println(this.mRemoteAugmentedAutofillServiceInfo);
    L12:
        pw.println();
        pw.print(prefix);
        pw.println("mFieldClassificationService for system detection");
        pw.print(prefix2);
        pw.print("Default component: ");
        pw.println(getContext().getString(R.string.config_ethernet_iface_regex));
        pw.print(prefix2);
        ((AutofillManagerService) this.mMaster).mFieldClassificationResolver.dumpShort(pw, this.mUserId);
        pw.println();
        if (this.mRemoteFieldClassificationService == null) goto L15;
        pw.print(prefix);
        pw.println("RemoteFieldClassificationService: ");
        this.mRemoteFieldClassificationService.dump(prefix2, pw);
    L17:
        if (this.mRemoteFieldClassificationServiceInfo == null) goto L19;
        pw.print(prefix);
        pw.print("RemoteFieldClassificationServiceInfo: ");
        pw.println(this.mRemoteFieldClassificationServiceInfo);
    L20:
        pw.println();
        pw.print(prefix);
        pw.print("Field classification enabled: ");
        pw.println(isFieldClassificationEnabledLocked());
        pw.print(prefix);
        pw.print("Compat pkgs: ");
        ArrayMap<String, Long> compatPkgs = getCompatibilityPackagesLocked();
        if (compatPkgs != null) goto L23;
        pw.println("N/A");
    L24:
        pw.print(prefix);
        pw.print("Inline Suggestions Enabled: ");
        pw.println(isInlineSuggestionsEnabledLocked());
        pw.print(prefix);
        pw.print("Last prune: ");
        pw.println(this.mLastPrune);
        this.mDisabledInfoCache.dump(this.mUserId, prefix, pw);
        int size = this.mSessions.size();
        if (size != 0) goto L27;
        pw.print(prefix);
        pw.println("No sessions");
    L30:
        pw.print(prefix);
        pw.print("Clients: ");
        if (this.mClients != null) goto L33;
        pw.println("N/A");
    L35:
        if (this.mEventHistory != null) goto L37;
    L44:
        pw.print(prefix);
        pw.println("No event on last fill response");
    L45:
        pw.print(prefix);
        pw.print("User data: ");
        if (this.mUserData != null) goto L48;
        pw.println("N/A");
    L49:
        pw.print(prefix);
        pw.println("Field Classification strategy: ");
        this.mFieldClassificationStrategy.dump(prefix2, pw);
        return;
    L48:
        pw.println();
        this.mUserData.dump(prefix2, pw);
        goto L49
    L37:
        if (this.mEventHistory.getEvents() == null) goto L44;
        if (this.mEventHistory.getEvents().size() == 0) goto L44;
        pw.print(prefix);
        pw.println("Events of last fill response:");
        pw.print(prefix);
        int numEvents = this.mEventHistory.getEvents().size();
        int i = 0;
    L42:
        if (i >= numEvents) goto L45;
        FillEventHistory.Event event = this.mEventHistory.getEvents().get(i);
        pw.println("  " + i + ": eventType=" + event.getType() + " datasetId=" + event.getDatasetId());
        i = i + 1;
        goto L42
    L33:
        pw.println();
        this.mClients.dump(pw, prefix2);
        goto L35
    L27:
        pw.print(prefix);
        pw.print(size);
        pw.println(" sessions:");
        int i2 = 0;
    L28:
        if (i2 >= size) goto L30;
        pw.print(prefix);
        pw.print("#");
        pw.println(i2 + 1);
        this.mSessions.valueAt(i2).dumpLocked(prefix2, pw);
        i2 = i2 + 1;
        goto L28
    L23:
        pw.println(compatPkgs);
        goto L24
    L19:
        pw.print(prefix);
        pw.println("mRemoteFieldClassificationServiceInfo: null");
        goto L20
    L15:
        pw.print(prefix);
        pw.println("mRemoteFieldClassificationService: null");
        goto L17
    L5:
        pw.println();
        this.mInfo.dump(prefix2, pw);
        goto L6
    }

    void forceRemoveAllSessionsLocked() {
        int sessionCount = this.mSessions.size();
        if (sessionCount != 0) goto L6;
        this.mUi.destroyAll(null, null, false);
        return;
    L6:
        int i = sessionCount - 1;
    L7:
        if (i < 0) goto L10;
        this.mSessions.valueAt(i).forceRemoveFromServiceLocked();
        i = i - 1;
        goto L7
    }

    void forceRemoveForAugmentedOnlySessionsLocked() {
        int sessionCount = this.mSessions.size();
        int i = sessionCount - 1;
    L3:
        if (i < 0) goto L6;
        this.mSessions.valueAt(i).forceRemoveFromServiceIfForAugmentedOnlyLocked();
        i = i - 1;
        goto L3
    }

    void forceRemoveFinishedSessionsLocked() {
        int sessionCount = this.mSessions.size();
        int i = sessionCount - 1;
    L3:
        if (i < 0) goto L13;
        Session session = this.mSessions.valueAt(i);
        if (session.isSaveUiShowingLocked() == true) goto L7;
        session.destroyAugmentedAutofillWindowsLocked();
    L11:
        i = i - 1;
        goto L3
    L7:
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "destroyFinishedSessionsLocked(): " + session.id);
    L9:
        session.forceRemoveFromServiceLocked();
        goto L11
    }

    void listSessionsLocked(ArrayList<String> output) {
        int numSessions = this.mSessions.size();
        if (numSessions > 0) goto L5;
        return;
    L5:
        int i = 0;
    L6:
        if (i >= numSessions) goto L17;
        int id = this.mSessions.keyAt(i);
        if (this.mInfo != null) goto L10;
        String service = "no_svc";
    L12:
        if (this.mRemoteAugmentedAutofillServiceInfo != null) goto L14;
        String augmentedService = "no_aug";
    L15:
        output.add(String.format("%d:%s:%s", new Object[]{Integer.valueOf(id), service, augmentedService}));
        i = i + 1;
        goto L6
    L14:
        augmentedService = this.mRemoteAugmentedAutofillServiceInfo.getComponentName().flattenToShortString();
        goto L15
    L10:
        service = this.mInfo.getServiceInfo().getComponentName().flattenToShortString();
        goto L12
    }

    ArrayMap<String, Long> getCompatibilityPackagesLocked() {
        if (this.mInfo != null) goto L5;
        return null;
    L5:
        return this.mInfo.getCompatibilityPackages();
    }

    boolean isInlineSuggestionsEnabledLocked() {
        if (this.mInfo != null) goto L5;
        return false;
    L5:
        return this.mInfo.isInlineSuggestionsEnabled();
    }

    void requestSavedPasswordCount(IResultReceiver receiver) {
        RemoteFillService remoteService = new RemoteFillService(getContext(), this.mInfo.getServiceInfo().getComponentName(), this.mUserId, null, ((AutofillManagerService) this.mMaster).isInstantServiceAllowed(), ((AutofillManagerService) this.mMaster).mCredentialAutofillService);
        remoteService.onSavedPasswordCountRequest(receiver);
    }

    RemoteAugmentedAutofillService getRemoteAugmentedAutofillServiceLocked() {
        if (this.mRemoteAugmentedAutofillService != null) goto L18;
        String serviceName = ((AutofillManagerService) this.mMaster).mAugmentedAutofillResolver.getServiceName(this.mUserId);
        if (serviceName == null) goto L7;
        Pair<ServiceInfo, ComponentName> pair = RemoteAugmentedAutofillService.getComponentName(serviceName, this.mUserId, ((AutofillManagerService) this.mMaster).mAugmentedAutofillResolver.isTemporary(this.mUserId));
        if (pair != null) goto L13;
        return null;
    L13:
        this.mRemoteAugmentedAutofillServiceInfo = (ServiceInfo) pair.first;
        ComponentName componentName = (ComponentName) pair.second;
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "getRemoteAugmentedAutofillServiceLocked(): " + componentName);
    L16:
        RemoteAugmentedAutofillService.RemoteAugmentedAutofillServiceCallbacks callbacks = new AnonymousClass1(this);
        int serviceUid = this.mRemoteAugmentedAutofillServiceInfo.applicationInfo.uid;
        this.mRemoteAugmentedAutofillService = new RemoteAugmentedAutofillService(getContext(), serviceUid, componentName, this.mUserId, callbacks, ((AutofillManagerService) this.mMaster).isInstantServiceAllowed(), ((AutofillManagerService) this.mMaster).verbose, ((AutofillManagerService) this.mMaster).mAugmentedServiceIdleUnbindTimeoutMs, ((AutofillManagerService) this.mMaster).mAugmentedServiceRequestTimeoutMs);
        goto L18
    L7:
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "getRemoteAugmentedAutofillServiceLocked(): not set");
    L9:
        return null;
    L18:
        return this.mRemoteAugmentedAutofillService;
    }

    RemoteAugmentedAutofillService getRemoteAugmentedAutofillServiceIfCreatedLocked() {
        return this.mRemoteAugmentedAutofillService;
    }

    void updateRemoteAugmentedAutofillService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteAugmentedAutofillService != null) goto L7;
    L12:
        boolean available = isAugmentedAutofillServiceAvailableLocked();     // Catch: Throwable -> L9
        if (Helper.sVerbose == false) goto L15;
        Slog.v(TAG, "updateRemoteAugmentedAutofillService(): " + available);     // Catch: Throwable -> L9
    L15:
        if (available == false) goto L17;
        this.mRemoteAugmentedAutofillService = getRemoteAugmentedAutofillServiceLocked();     // Catch: Throwable -> L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "updateRemoteAugmentedAutofillService(): destroying old remote service");     // Catch: Throwable -> L9
    L11:
        forceRemoveForAugmentedOnlySessionsLocked();     // Catch: Throwable -> L9
        this.mRemoteAugmentedAutofillService.unbind();     // Catch: Throwable -> L9
        this.mRemoteAugmentedAutofillService = null;     // Catch: Throwable -> L9
        this.mRemoteAugmentedAutofillServiceInfo = null;     // Catch: Throwable -> L9
        resetAugmentedAutofillWhitelistLocked();     // Catch: Throwable -> L9
        goto L12
    }

    private boolean isAugmentedAutofillServiceAvailableLocked() {
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L6;
        Slog.v(TAG, "isAugmentedAutofillService(): setupCompleted=" + isSetupCompletedLocked() + ", disabled=" + isDisabledByUserRestrictionsLocked() + ", augmentedService=" + ((AutofillManagerService) this.mMaster).mAugmentedAutofillResolver.getServiceName(this.mUserId));
    L6:
        if (isSetupCompletedLocked() == true) goto L8;
        return false;
    L8:
        if (isDisabledByUserRestrictionsLocked() == false) goto L10;
        return false;
    L10:
        if (((AutofillManagerService) this.mMaster).mAugmentedAutofillResolver.getServiceName(this.mUserId) == null) goto L17;
        return true;
    L17:
        return false;
    }

    boolean isAugmentedAutofillServiceForUserLocked(int callingUid) {
        if (this.mRemoteAugmentedAutofillServiceInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRemoteAugmentedAutofillServiceInfo.applicationInfo.uid != callingUid) goto L7;
        return true;
    }

    boolean setAugmentedAutofillWhitelistLocked(List<String> packages, List<ComponentName> activities, int callingUid) {
        if (isCalledByAugmentedAutofillServiceLocked("setAugmentedAutofillWhitelistLocked", callingUid) == true) goto L7;
        return false;
    L7:
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "setAugmentedAutofillWhitelistLocked(packages=" + packages + ", activities=" + activities + ")");
    L9:
        allowlistForAugmentedAutofillPackages(packages, activities);
        if (this.mRemoteAugmentedAutofillServiceInfo == null) goto L12;
        String serviceName = this.mRemoteAugmentedAutofillServiceInfo.getComponentName().flattenToShortString();
    L13:
        LogMaker log = new LogMaker(1721).addTaggedData(908, serviceName);
        if (packages == null) goto L16;
        log.addTaggedData(1722, Integer.valueOf(packages.size()));
    L16:
        if (activities == null) goto L18;
        log.addTaggedData(1723, Integer.valueOf(activities.size()));
    L18:
        this.mMetricsLogger.write(log);
        return true;
    L12:
        Slog.e(TAG, "setAugmentedAutofillWhitelistLocked(): no service");
        serviceName = "N/A";
        goto L13
    }

    private boolean isCalledByAugmentedAutofillServiceLocked(String methodName, int callingUid) {
        RemoteAugmentedAutofillService service = getRemoteAugmentedAutofillServiceLocked();
        if (service != null) goto L7;
        Slog.w(TAG, methodName + "() called by UID " + callingUid + ", but there is no augmented autofill service defined for user " + getUserId());
        return false;
    L7:
        if (getAugmentedAutofillServiceUidLocked() == callingUid) goto L10;
        Slog.w(TAG, methodName + "() called by UID " + callingUid + ", but service UID is " + getAugmentedAutofillServiceUidLocked() + " for user " + getUserId());
        return false;
    L10:
        return true;
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

    private int getAugmentedAutofillServiceUidLocked() {
        if (this.mRemoteAugmentedAutofillServiceInfo != null) goto L10;
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L11;
        Slog.v(TAG, "getAugmentedAutofillServiceUid(): no mRemoteAugmentedAutofillServiceInfo");
        return -1;
    L11:
        return -1;
    L10:
        return this.mRemoteAugmentedAutofillServiceInfo.applicationInfo.uid;
    }

    boolean isWhitelistedForAugmentedAutofillLocked(ComponentName componentName) {
        return ((AutofillManagerService) this.mMaster).mAugmentedAutofillState.isWhitelisted(this.mUserId, componentName);
    }

    private void allowlistForAugmentedAutofillPackages(List<String> packages, List<ComponentName> components) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "whitelisting packages: " + packages + "and activities: " + components);     // Catch: Throwable -> L7
    L9:
        ((AutofillManagerService) this.mMaster).mAugmentedAutofillState.setWhitelist(this.mUserId, packages, components);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void resetAugmentedAutofillWhitelistLocked() {
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L5;
        Slog.v(TAG, "resetting augmented autofill whitelist");
    L5:
        ((AutofillManagerService) this.mMaster).mAugmentedAutofillState.resetWhitelist(this.mUserId);
    }

    private void sendStateToClients(boolean resetClient) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClients != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        RemoteCallbackList<IAutoFillManagerClient> clients = this.mClients;     // Catch: Throwable -> L8
        int userClientCount = clients.beginBroadcast();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int i = 0;
    L13:
        if (i >= userClientCount) goto L51;
        IAutoFillManagerClient client = (IAutoFillManagerClient) clients.getBroadcastItem(i);     // Catch: Throwable -> L42
        Object r4 = this.mLock;     // Catch: Throwable -> L42 RemoteException -> L44
        monitor-enter(r4);     // Catch: Throwable -> L42 RemoteException -> L44
        if (resetClient == true) goto L24;
        if (isClientSessionDestroyedLocked(client) == true) goto L24;
        boolean resetSession = false;
    L25:
        boolean isEnabled = isEnabledLocked();     // Catch: Throwable -> L22
        monitor-exit(r4);     // Catch: Throwable -> L22
        int flags = 0;
        if (isEnabled == false) goto L30;
        flags = 0 | 1;
    L30:
        if (resetSession == false) goto L32;
        flags = flags | 2;
    L32:
        if (resetClient == false) goto L35;
        flags = flags | 4;
    L35:
        if (Helper.sDebug == false) goto L38;
        flags = flags | 8;     // Catch: Throwable -> L42 RemoteException -> L44
    L38:
        if (Helper.sVerbose == false) goto L40;
        flags = flags | 16;     // Catch: Throwable -> L42 RemoteException -> L44
    L40:
        client.setState(flags);     // Catch: Throwable -> L42 RemoteException -> L44
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42 RemoteException -> L44
    L24:
        resetSession = true;
    L48:
        i = i + 1;
    L42:
        th = move-exception;
        clients.finishBroadcast();
        throw th;
    L51:
        clients.finishBroadcast();
    }

    private boolean isClientSessionDestroyedLocked(IAutoFillManagerClient client) {
        int sessionCount = this.mSessions.size();
        int i = 0;
    L3:
        if (i >= sessionCount) goto L9;
        Session session = this.mSessions.valueAt(i);
        if (session.getClient().equals(client) == true) goto L7;
        i = i + 1;
        goto L3
    L7:
        return session.isDestroyed();
    L9:
        return true;
    }

    void disableAutofillForApp(String packageName, long duration, int sessionId, boolean compatMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long expiration = SystemClock.elapsedRealtime() + duration;     // Catch: Throwable -> L14
        if (expiration >= 0) goto L7;
        expiration = Long.MAX_VALUE;
    L7:
        this.mDisabledInfoCache.addDisabledAppLocked(this.mUserId, packageName, expiration);     // Catch: Throwable -> L14
        if (duration <= 2147483647L) goto L10;
        int intDuration = Integer.MAX_VALUE;
    L11:
        this.mMetricsLogger.write(Helper.newLogMaker(1231, packageName, getServicePackageName(), sessionId, compatMode).addTaggedData(1145, Integer.valueOf(intDuration)));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        intDuration = (int) duration;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    void disableAutofillForActivity(ComponentName componentName, long duration, int sessionId, boolean compatMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long expiration = SystemClock.elapsedRealtime() + duration;     // Catch: Throwable -> L14
        if (expiration >= 0) goto L7;
        expiration = Long.MAX_VALUE;
    L7:
        this.mDisabledInfoCache.addDisabledActivityLocked(this.mUserId, componentName, expiration);     // Catch: Throwable -> L14
        if (duration <= 2147483647L) goto L10;
        int intDuration = Integer.MAX_VALUE;
    L11:
        LogMaker log = Helper.newLogMaker(1232, componentName, getServicePackageName(), sessionId, compatMode).addTaggedData(1145, Integer.valueOf(intDuration));     // Catch: Throwable -> L14
        this.mMetricsLogger.write(log);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        intDuration = (int) duration;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private boolean isAutofillDisabledLocked(ComponentName componentName) {
        return this.mDisabledInfoCache.isAutofillDisabledLocked(this.mUserId, componentName);
    }

    boolean isFieldClassificationEnabled(int callingUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCalledByServiceLocked("isFieldClassificationEnabled", callingUid) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r1 = isFieldClassificationEnabledLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    boolean isFieldClassificationEnabledLocked() {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "autofill_field_classification", 1, this.mUserId) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    FieldClassificationStrategy getFieldClassificationStrategy() {
        return this.mFieldClassificationStrategy;
    }

    String[] getAvailableFieldClassificationAlgorithms(int callingUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCalledByServiceLocked("getFCAlgorithms()", callingUid) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mFieldClassificationStrategy.getAvailableAlgorithms();
    }

    String getDefaultFieldClassificationAlgorithm(int callingUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCalledByServiceLocked("getDefaultFCAlgorithm()", callingUid) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mFieldClassificationStrategy.getDefaultAlgorithm();
    }

    RemoteInlineSuggestionRenderService getRemoteInlineSuggestionRenderServiceLocked() {
        if (this.mRemoteInlineSuggestionRenderService != null) goto L10;
        ComponentName componentName = RemoteInlineSuggestionRenderService.getServiceComponentName(getContext(), this.mUserId);
        AutofillManagerServiceImplIA r0 = null;
        if (componentName != null) goto L8;
        Slog.w(TAG, "No valid component found for InlineSuggestionRenderService");
        return null;
    L8:
        this.mRemoteInlineSuggestionRenderService = new RemoteInlineSuggestionRenderService(getContext(), componentName, "android.service.autofill.InlineSuggestionRenderService", this.mUserId, new InlineSuggestionRenderCallbacksImpl(this, r0), ((AutofillManagerService) this.mMaster).isBindInstantServiceAllowed(), ((AutofillManagerService) this.mMaster).verbose);
    L10:
        return this.mRemoteInlineSuggestionRenderService;
    }

    void onSwitchInputMethod() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int sessionCount = this.mSessions.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= sessionCount) goto L10;
        Session session = this.mSessions.valueAt(i);     // Catch: Throwable -> L7
        session.onSwitchInputMethodLocked();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    RemoteFieldClassificationService getRemoteFieldClassificationServiceLocked() {
        if (this.mRemoteFieldClassificationService != null) goto L22;
        String serviceName = ((AutofillManagerService) this.mMaster).mFieldClassificationResolver.getServiceName(this.mUserId);
        if (serviceName != null) goto L11;
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "getRemoteFieldClassificationServiceLocked(): not set");
    L9:
        return null;
    L11:
        if (Helper.sVerbose == false) goto L13;
        Slog.v(TAG, "getRemoteFieldClassificationServiceLocked serviceName: " + serviceName);
    L13:
        boolean sTemporaryFieldDetectionService = ((AutofillManagerService) this.mMaster).mFieldClassificationResolver.isTemporary(this.mUserId);
        Pair<ServiceInfo, ComponentName> pair = RemoteFieldClassificationService.getComponentName(serviceName, this.mUserId, sTemporaryFieldDetectionService);
        if (pair != null) goto L17;
        Slog.w(TAG, "RemoteFieldClassificationService.getComponentName returned null with serviceName: " + serviceName);
        return null;
    L17:
        this.mRemoteFieldClassificationServiceInfo = (ServiceInfo) pair.first;
        ComponentName componentName = (ComponentName) pair.second;
        if (Helper.sVerbose == false) goto L20;
        Slog.v(TAG, "getRemoteFieldClassificationServiceLocked(): " + componentName);
    L20:
        int serviceUid = this.mRemoteFieldClassificationServiceInfo.applicationInfo.uid;
        this.mRemoteFieldClassificationService = new RemoteFieldClassificationService(getContext(), componentName, serviceUid, this.mUserId);
    L22:
        return this.mRemoteFieldClassificationService;
    }

    RemoteFieldClassificationService getRemoteFieldClassificationServiceIfCreatedLocked() {
        return this.mRemoteFieldClassificationService;
    }

    public boolean isPccClassificationEnabled() {
        boolean result = isPccClassificationEnabledInternal();
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "pccEnabled: " + result);
    L5:
        return result;
    }

    public boolean isPccClassificationEnabledInternal() {
        boolean flagEnabled = ((AutofillManagerService) this.mMaster).isPccClassificationFlagEnabled();
        boolean r1 = false;
        if (flagEnabled == true) goto L5;
        return false;
    L5:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (getRemoteFieldClassificationServiceLocked() == null) goto L10;
        r1 = true;
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return r1;
    }

    public boolean isAutofillCredmanIntegrationEnabled() {
        return ((AutofillManagerService) this.mMaster).isAutofillCredmanIntegrationEnabled();
    }

    void updateRemoteFieldClassificationService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteFieldClassificationService != null) goto L7;
    L12:
        boolean available = isFieldClassificationServiceAvailableLocked();     // Catch: Throwable -> L9
        if (Helper.sVerbose == false) goto L15;
        Slog.v(TAG, "updateRemoteFieldClassificationService(): " + available);     // Catch: Throwable -> L9
    L15:
        if (available == false) goto L17;
        this.mRemoteFieldClassificationService = getRemoteFieldClassificationServiceLocked();     // Catch: Throwable -> L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "updateRemoteFieldClassificationService(): destroying old remote service");     // Catch: Throwable -> L9
    L11:
        this.mRemoteFieldClassificationService.unbind();     // Catch: Throwable -> L9
        this.mRemoteFieldClassificationService = null;     // Catch: Throwable -> L9
        this.mRemoteFieldClassificationServiceInfo = null;     // Catch: Throwable -> L9
        goto L12
    }

    private boolean isFieldClassificationServiceAvailableLocked() {
        if (((AutofillManagerService) this.mMaster).verbose == false) goto L6;
        Slog.v(TAG, "isFieldClassificationService(): setupCompleted=" + isSetupCompletedLocked() + ", disabled=" + isDisabledByUserRestrictionsLocked() + ", augmentedService=" + ((AutofillManagerService) this.mMaster).mFieldClassificationResolver.getServiceName(this.mUserId));
    L6:
        if (isSetupCompletedLocked() == true) goto L8;
        return false;
    L8:
        if (isDisabledByUserRestrictionsLocked() == false) goto L10;
        return false;
    L10:
        if (((AutofillManagerService) this.mMaster).mFieldClassificationResolver.getServiceName(this.mUserId) == null) goto L17;
        return true;
    L17:
        return false;
    }

    boolean isRemoteClassificationServiceForUserLocked(int callingUid) {
        if (this.mRemoteFieldClassificationServiceInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRemoteFieldClassificationServiceInfo.applicationInfo.uid != callingUid) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutofillManagerServiceImpl: [userId=");
        r0.append(this.mUserId);
        r0.append(", component=");
        if (this.mInfo == null) goto L5;
        ComponentName r1 = this.mInfo.getServiceInfo().getComponentName();
    L6:
        r0.append(r1);
        r0.append("]");
        return r0.toString();
    L5:
        r1 = null;
        goto L6
    }
}
