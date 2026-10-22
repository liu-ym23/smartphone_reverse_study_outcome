package com.android.server.autofill;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InlineSuggestion;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.view.inputmethod.InlineSuggestionsResponse;
import com.android.internal.inputmethod.IInlineSuggestionsResponseCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.autofill.ui.InlineFillUi;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class AutofillInlineSuggestionsRequestSession {
    private static final String TAG = null;
    private AutofillId mAutofillId;
    private final ComponentName mComponentName;
    private boolean mDestroyed;
    private final Handler mHandler;
    private AutofillId mImeCurrentFieldId;
    private boolean mImeInputStarted;
    private boolean mImeInputViewStarted;
    private InlineSuggestionsRequest mImeRequest;
    private Consumer<InlineSuggestionsRequest> mImeRequestConsumer;
    private boolean mImeRequestReceived;
    private boolean mImeSessionInvalidated;
    private boolean mImeShowing;
    private InlineFillUi mInlineFillUi;
    private final InputMethodManagerInternal mInputMethodManagerInternal;
    private final Object mLock;
    private boolean mPreviousHasNonPinSuggestionShow;
    private Boolean mPreviousResponseIsNotEmpty;
    private IInlineSuggestionsResponseCallback mResponseCallback;
    private final InlineFillUi.InlineUiEventCallback mUiCallback;
    private final Bundle mUiExtras;
    private final int mUserId;

    private static final class InlineSuggestionsRequestCallbackImpl implements InlineSuggestionsRequestCallback {
        private final WeakReference<AutofillInlineSuggestionsRequestSession> mSession;

        public static /* synthetic */ void $r8$lambda$27E6I88g_3BBvmWFctvtXTYm1W4(AutofillInlineSuggestionsRequestSession r0) {
            AutofillInlineSuggestionsRequestSession.m2233$$Nest$mhandleOnInputMethodStartInputView(r0);
        }

        public static /* synthetic */ void $r8$lambda$4VprBKRyoUVd8iTl9B80HvfJYYg(AutofillInlineSuggestionsRequestSession r0) {
            AutofillInlineSuggestionsRequestSession.m2235$$Nest$mhandleOnReceiveImeSessionInvalidated(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$PWGqhoWJR2-UtROIn36FwRblHnA, reason: not valid java name */
        public static /* synthetic */ void m2239$r8$lambda$PWGqhoWJR2UtROIn36FwRblHnA(AutofillInlineSuggestionsRequestSession r0, AutofillId r1, boolean r2, boolean r3) {
            AutofillInlineSuggestionsRequestSession.m2236$$Nest$mhandleOnReceiveImeStatusUpdated(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$TUGMhX1JV-d61kz5yMksLAO7fiI, reason: not valid java name */
        public static /* synthetic */ void m2240$r8$lambda$TUGMhX1JVd61kz5yMksLAO7fiI(AutofillInlineSuggestionsRequestSession r0, boolean r1, boolean r2) {
            AutofillInlineSuggestionsRequestSession.m2237$$Nest$mhandleOnReceiveImeStatusUpdated(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$YvLupYiesupUB2572ifB6U1j6FI(AutofillInlineSuggestionsRequestSession r0, InlineSuggestionsRequest r1, IInlineSuggestionsResponseCallback r2) {
            AutofillInlineSuggestionsRequestSession.m2234$$Nest$mhandleOnReceiveImeRequest(r0, r1, r2);
        }

        /* synthetic */ InlineSuggestionsRequestCallbackImpl(AutofillInlineSuggestionsRequestSession r1, AutofillInlineSuggestionsRequestSessionIA r2) {
            this(r1);
        }

        private InlineSuggestionsRequestCallbackImpl(AutofillInlineSuggestionsRequestSession session) {
            this.mSession = new WeakReference(session);
        }

        public void onInlineSuggestionsUnsupported() {
            if (Helper.sDebug == false) goto L5;
            Slog.d(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInlineSuggestionsUnsupported() called.");
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda1(), session, null, null));
            return;
        }

        public void onInlineSuggestionsRequest(InlineSuggestionsRequest request, IInlineSuggestionsResponseCallback callback) {
            if (Helper.sDebug == false) goto L5;
            Slog.d(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInlineSuggestionsRequest() received: " + request);
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda1(), session, request, callback));
            return;
        }

        public void onInputMethodStartInput(AutofillId imeFieldId) {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInputMethodStartInput() received on " + imeFieldId);
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda2(), session, imeFieldId, true, false));
            return;
        }

        public void onInputMethodShowInputRequested(boolean requestResult) {
            if (Helper.sVerbose == false) goto L6;
            Slog.v(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInputMethodShowInputRequested() received: " + requestResult);
            return;
        }

        public void onInputMethodStartInputView() {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInputMethodStartInputView() received");
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda4(), session));
            return;
        }

        public void onInputMethodFinishInputView() {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInputMethodFinishInputView() received");
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda3(), session, true, false));
            return;
        }

        public void onInputMethodFinishInput() {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInputMethodFinishInput() received");
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda3(), session, false, false));
            return;
        }

        public void onInlineSuggestionsSessionInvalidated() {
            if (Helper.sDebug == false) goto L5;
            Slog.d(AutofillInlineSuggestionsRequestSession.m2238$$Nest$sfgetTAG(), "onInlineSuggestionsSessionInvalidated() called.");
        L5:
            AutofillInlineSuggestionsRequestSession session = this.mSession.get();
            if (session == null) goto L9;
            AutofillInlineSuggestionsRequestSession.m2232$$Nest$fgetmHandler(session).sendMessage(PooledLambda.obtainMessage(new AutofillInlineSuggestionsRequestSession$InlineSuggestionsRequestCallbackImpl$$ExternalSyntheticLambda0(), session));
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2232$$Nest$fgetmHandler(AutofillInlineSuggestionsRequestSession r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnInputMethodStartInputView, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2233$$Nest$mhandleOnInputMethodStartInputView(AutofillInlineSuggestionsRequestSession r0) {
        r0.handleOnInputMethodStartInputView();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnReceiveImeRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2234$$Nest$mhandleOnReceiveImeRequest(AutofillInlineSuggestionsRequestSession r0, InlineSuggestionsRequest r1, IInlineSuggestionsResponseCallback r2) {
        r0.handleOnReceiveImeRequest(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnReceiveImeSessionInvalidated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2235$$Nest$mhandleOnReceiveImeSessionInvalidated(AutofillInlineSuggestionsRequestSession r0) {
        r0.handleOnReceiveImeSessionInvalidated();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnReceiveImeStatusUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2236$$Nest$mhandleOnReceiveImeStatusUpdated(AutofillInlineSuggestionsRequestSession r0, AutofillId r1, boolean r2, boolean r3) {
        r0.handleOnReceiveImeStatusUpdated(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnReceiveImeStatusUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2237$$Nest$mhandleOnReceiveImeStatusUpdated(AutofillInlineSuggestionsRequestSession r0, boolean r1, boolean r2) {
        r0.handleOnReceiveImeStatusUpdated(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2238$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = AutofillInlineSuggestionsRequestSession.class.getSimpleName();
    }

    AutofillInlineSuggestionsRequestSession(InputMethodManagerInternal inputMethodManagerInternal, int userId, ComponentName componentName, Handler handler, Object lock, AutofillId autofillId, Consumer<InlineSuggestionsRequest> requestConsumer, Bundle uiExtras, InlineFillUi.InlineUiEventCallback callback) {
        this.mPreviousResponseIsNotEmpty = null;
        this.mDestroyed = false;
        this.mImeSessionInvalidated = false;
        this.mImeShowing = false;
        this.mInputMethodManagerInternal = inputMethodManagerInternal;
        this.mUserId = userId;
        this.mComponentName = componentName;
        this.mHandler = handler;
        this.mLock = lock;
        this.mUiExtras = uiExtras;
        this.mUiCallback = callback;
        this.mAutofillId = autofillId;
        this.mImeRequestConsumer = requestConsumer;
    }

    AutofillId getAutofillIdLocked() {
        return this.mAutofillId;
    }

    Optional<InlineSuggestionsRequest> getInlineSuggestionsRequestLocked() {
        if (this.mDestroyed == false) goto L7;
        return Optional.empty();
    L7:
        return Optional.ofNullable(this.mImeRequest);
    }

    boolean onInlineSuggestionsResponseLocked(InlineFillUi inlineFillUi) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "onInlineSuggestionsResponseLocked called for:" + inlineFillUi.getAutofillId());
    L9:
        if (this.mImeRequest != null) goto L11;
    L17:
        return false;
    L11:
        if (this.mResponseCallback == null) goto L17;
        if (this.mImeSessionInvalidated == true) goto L17;
        this.mAutofillId = inlineFillUi.getAutofillId();
        this.mInlineFillUi = inlineFillUi;
        maybeUpdateResponseToImeLocked();
        return true;
    }

    void destroySessionLocked() {
        this.mDestroyed = true;
        if (this.mImeRequestReceived == true) goto L6;
        Slog.w(TAG, "Never received an InlineSuggestionsRequest from the IME for " + this.mAutofillId);
        return;
    }

    void onCreateInlineSuggestionsRequestLocked() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        this.mImeSessionInvalidated = false;
        if (Helper.sDebug == false) goto L8;
        Slog.d(TAG, "onCreateInlineSuggestionsRequestLocked called: " + this.mAutofillId);
    L8:
        this.mInputMethodManagerInternal.onCreateInlineSuggestionsRequest(this.mUserId, new InlineSuggestionsRequestInfo(this.mComponentName, this.mAutofillId, this.mUiExtras), new InlineSuggestionsRequestCallbackImpl(this, null));
    }

    void resetInlineFillUiLocked() {
        this.mInlineFillUi = null;
    }

    private void maybeUpdateResponseToImeLocked() {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "maybeUpdateResponseToImeLocked called");
    L6:
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        if (this.mResponseCallback != null) goto L11;
        return;
    L11:
        if (this.mImeInputViewStarted == true) goto L13;
        return;
    L13:
        if (this.mInlineFillUi != null) goto L15;
        return;
    L15:
        if (match(this.mAutofillId, this.mImeCurrentFieldId) == false) goto L26;
        InlineSuggestionsResponse response = this.mInlineFillUi.getInlineSuggestionsResponse();
        boolean isEmptyResponse = response.getInlineSuggestions().isEmpty();
        if (isEmptyResponse == true) goto L19;
    L21:
        maybeNotifyFillUiEventLocked(response.getInlineSuggestions());
        updateResponseToImeUncheckLocked(response);
        this.mPreviousResponseIsNotEmpty = Boolean.valueOf(!isEmptyResponse);
        return;
    L19:
        if (Boolean.FALSE.equals(this.mPreviousResponseIsNotEmpty) == false) goto L21;
        return;
    }

    private void updateResponseToImeUncheckLocked(InlineSuggestionsResponse response) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (Helper.sDebug == false) goto L13;
        Slog.d(TAG, "Send inline response: " + response.getInlineSuggestions().size());
    L13:
        this.mResponseCallback.onInlineSuggestionsResponse(this.mAutofillId, response);     // Catch: RemoteException -> L10
        return;
    L11:
        Slog.e(TAG, "RemoteException sending InlineSuggestionsResponse to IME");
    }

    private void maybeNotifyFillUiEventLocked(List<InlineSuggestion> suggestions) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        boolean hasSuggestionToShow = false;
        int i = 0;
    L7:
        if (i >= suggestions.size()) goto L13;
        InlineSuggestion suggestion = suggestions.get(i);
        if (suggestion.getInfo().isPinned() == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        hasSuggestionToShow = true;
    L13:
        if (Helper.sDebug == false) goto L15;
        Slog.d(TAG, "maybeNotifyFillUiEventLoked(): hasSuggestionToShow=" + hasSuggestionToShow + ", mPreviousHasNonPinSuggestionShow=" + this.mPreviousHasNonPinSuggestionShow);
    L15:
        if (hasSuggestionToShow == true) goto L17;
    L19:
        if (hasSuggestionToShow == false) goto L21;
    L23:
        this.mPreviousHasNonPinSuggestionShow = hasSuggestionToShow;
        return;
    L21:
        if (this.mPreviousHasNonPinSuggestionShow == false) goto L23;
        this.mUiCallback.notifyInlineUiHidden(this.mAutofillId);
        goto L23
    L17:
        if (this.mPreviousHasNonPinSuggestionShow == true) goto L19;
        this.mUiCallback.notifyInlineUiShown(this.mAutofillId);
        goto L23
    }

    private void handleOnReceiveImeRequest(InlineSuggestionsRequest request, IInlineSuggestionsResponseCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == true) goto L20;
        if (this.mImeRequestReceived == true) goto L20;
        this.mImeRequestReceived = true;     // Catch: Throwable -> L13
        this.mImeSessionInvalidated = false;     // Catch: Throwable -> L13
        if (request == null) goto L16;
        if (callback == null) goto L16;
        this.mImeRequest = request;     // Catch: Throwable -> L13
        this.mResponseCallback = callback;     // Catch: Throwable -> L13
        handleOnReceiveImeStatusUpdated(this.mAutofillId, true, false);     // Catch: Throwable -> L13
    L16:
        if (this.mImeRequestConsumer == null) goto L18;
        this.mImeRequestConsumer.accept(this.mImeRequest);     // Catch: Throwable -> L13
        this.mImeRequestConsumer = null;     // Catch: Throwable -> L13
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void handleOnReceiveImeStatusUpdated(boolean imeInputStarted, boolean imeInputViewStarted) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mImeShowing = imeInputViewStarted;     // Catch: Throwable -> L8
        if (this.mImeCurrentFieldId == null) goto L23;
        boolean imeInputViewStartedChanged = false;
        if (this.mImeInputStarted == imeInputStarted) goto L15;
        boolean imeInputStartedChanged = true;
    L17:
        if (this.mImeInputViewStarted == imeInputViewStarted) goto L19;
        imeInputViewStartedChanged = true;
    L19:
        this.mImeInputStarted = imeInputStarted;     // Catch: Throwable -> L8
        this.mImeInputViewStarted = imeInputViewStarted;     // Catch: Throwable -> L8
        if (imeInputStartedChanged == true) goto L22;
        if (imeInputViewStartedChanged == false) goto L23;
    L22:
        maybeUpdateResponseToImeLocked();     // Catch: Throwable -> L8
        goto L23
    L15:
        imeInputStartedChanged = false;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void handleOnReceiveImeStatusUpdated(AutofillId imeFieldId, boolean imeInputStarted, boolean imeInputViewStarted) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (imeFieldId == null) goto L12;
        this.mImeCurrentFieldId = imeFieldId;     // Catch: Throwable -> L8
    L12:
        handleOnReceiveImeStatusUpdated(imeInputStarted, imeInputViewStarted);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void handleOnInputMethodStartInputView() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUiCallback.onInputMethodStartInputView();     // Catch: Throwable -> L7
        handleOnReceiveImeStatusUpdated(true, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleOnReceiveImeSessionInvalidated() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mImeSessionInvalidated = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    boolean isImeShowing() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mImeShowing == false) goto L11;
        r1 = true;
        goto L12
    }

    private static boolean match(AutofillId autofillId, AutofillId imeClientFieldId) {
        if (autofillId == null) goto L7;
        if (imeClientFieldId == null) goto L7;
        if (autofillId.getViewId() != imeClientFieldId.getViewId()) goto L7;
        return true;
    L7:
        return false;
    }
}
