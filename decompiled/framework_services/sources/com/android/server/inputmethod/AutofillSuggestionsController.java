package com.android.server.inputmethod;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.view.inputmethod.InputMethodInfo;
import com.android.internal.inputmethod.IInlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.IInlineSuggestionsResponseCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;

/* JADX INFO: loaded from: classes2.dex */
final class AutofillSuggestionsController {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private final InputMethodBindingController mBindingController;
    private IBinder mCurHostInputToken;
    private InlineSuggestionsRequestCallback mInlineSuggestionsRequestCallback;
    private CreateInlineSuggestionsRequest mPendingInlineSuggestionsRequest;

    private static final class CreateInlineSuggestionsRequest {
        final InlineSuggestionsRequestCallback mCallback;
        final String mPackageName;
        final InlineSuggestionsRequestInfo mRequestInfo;

        CreateInlineSuggestionsRequest(InlineSuggestionsRequestInfo requestInfo, InlineSuggestionsRequestCallback callback, String packageName) {
            this.mRequestInfo = requestInfo;
            this.mCallback = callback;
            this.mPackageName = packageName;
        }
    }

    private final class InlineSuggestionsRequestCallbackDecorator extends IInlineSuggestionsRequestCallback.Stub {
        private final InlineSuggestionsRequestCallback mCallback;
        private final int mImeDisplayId;
        private final String mImePackageName;
        private final IBinder mImeToken;
        final /* synthetic */ AutofillSuggestionsController this$0;

        InlineSuggestionsRequestCallbackDecorator(AutofillSuggestionsController r1, InlineSuggestionsRequestCallback callback, String imePackageName, int displayId, IBinder imeToken) {
            this.this$0 = r1;
            this.mCallback = callback;
            this.mImePackageName = imePackageName;
            this.mImeDisplayId = displayId;
            this.mImeToken = imeToken;
        }

        public void onInlineSuggestionsUnsupported() {
            this.mCallback.onInlineSuggestionsUnsupported();
        }

        public void onInlineSuggestionsRequest(InlineSuggestionsRequest request, IInlineSuggestionsResponseCallback callback) throws RemoteException {
            if (this.mImePackageName.equals(request.getHostPackageName()) == false) goto L17;
            request.setHostDisplayId(this.mImeDisplayId);
            monitor-enter(ImfLock.class);
            IBinder curImeToken = AutofillSuggestionsController.m4632$$Nest$fgetmBindingController(this.this$0).getCurToken();     // Catch: Throwable -> L9
            if (this.mImeToken != curImeToken) goto L11;
            AutofillSuggestionsController.m4633$$Nest$fputmCurHostInputToken(this.this$0, request.getHostInputToken());     // Catch: Throwable -> L9
        L11:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            this.mCallback.onInlineSuggestionsRequest(request, callback);
            return;
        L9:
            th = move-exception;
            throw th;
        L17:
            throw new SecurityException("Host package name in the provide request=[" + request.getHostPackageName() + "] doesn't match the IME package name=[" + this.mImePackageName + "].");
        }

        public void onInputMethodStartInput(AutofillId imeFieldId) {
            this.mCallback.onInputMethodStartInput(imeFieldId);
        }

        public void onInputMethodShowInputRequested(boolean requestResult) {
            this.mCallback.onInputMethodShowInputRequested(requestResult);
        }

        public void onInputMethodStartInputView() {
            this.mCallback.onInputMethodStartInputView();
        }

        public void onInputMethodFinishInputView() {
            this.mCallback.onInputMethodFinishInputView();
        }

        public void onInputMethodFinishInput() {
            this.mCallback.onInputMethodFinishInput();
        }

        public void onInlineSuggestionsSessionInvalidated() {
            this.mCallback.onInlineSuggestionsSessionInvalidated();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBindingController, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputMethodBindingController m4632$$Nest$fgetmBindingController(AutofillSuggestionsController r0) {
        return r0.mBindingController;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurHostInputToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4633$$Nest$fputmCurHostInputToken(AutofillSuggestionsController r0, IBinder r1) {
        r0.mCurHostInputToken = r1;
    }

    static {
        TAG = AutofillSuggestionsController.class.getSimpleName();
    }

    AutofillSuggestionsController(InputMethodBindingController bindingController) {
        this.mBindingController = bindingController;
    }

    void onResetSystemUi() {
        this.mCurHostInputToken = null;
    }

    IBinder getCurHostInputToken() {
        return this.mCurHostInputToken;
    }

    void onCreateInlineSuggestionsRequest(InlineSuggestionsRequestInfo requestInfo, InlineSuggestionsRequestCallback callback, boolean touchExplorationEnabled) {
        clearPendingInlineSuggestionsRequest();
        this.mInlineSuggestionsRequestCallback = callback;
        String imeId = this.mBindingController.getSelectedMethodId();
        InputMethodInfo imi = InputMethodSettingsRepository.get(this.mBindingController.getUserId()).getMethodMap().get(imeId);
        if (imi != null) goto L5;
    L11:
        callback.onInlineSuggestionsUnsupported();
        return;
    L5:
        if (isInlineSuggestionsEnabled(imi, touchExplorationEnabled) == false) goto L11;
        this.mPendingInlineSuggestionsRequest = new CreateInlineSuggestionsRequest(requestInfo, callback, imi.getPackageName());
        if (this.mBindingController.getCurMethod() == null) goto L13;
        performOnCreateInlineSuggestionsRequest();
        return;
    }

    void performOnCreateInlineSuggestionsRequest() {
        if (this.mPendingInlineSuggestionsRequest != null) goto L5;
        return;
    L5:
        IInputMethodInvoker curMethod = this.mBindingController.getCurMethod();
        if (curMethod == null) goto L8;
        InlineSuggestionsRequestCallbackDecorator r1 = new InlineSuggestionsRequestCallbackDecorator(this, this.mPendingInlineSuggestionsRequest.mCallback, this.mPendingInlineSuggestionsRequest.mPackageName, this.mBindingController.getCurTokenDisplayId(), this.mBindingController.getCurToken());
        curMethod.onCreateInlineSuggestionsRequest(this.mPendingInlineSuggestionsRequest.mRequestInfo, r1);
    L9:
        clearPendingInlineSuggestionsRequest();
        return;
    L8:
        Slog.w(TAG, "No IME connected! Abandoning inline suggestions creation request.");
        goto L9
    }

    private void clearPendingInlineSuggestionsRequest() {
        this.mPendingInlineSuggestionsRequest = null;
    }

    private static boolean isInlineSuggestionsEnabled(InputMethodInfo imi, boolean touchExplorationEnabled) {
        if (imi.isInlineSuggestionsEnabled() == false) goto L8;
        if (touchExplorationEnabled == true) goto L6;
    L7:
        return true;
    L6:
        if (imi.supportsInlineSuggestionsWithTouchExploration() == true) goto L7;
    L8:
        return false;
    }

    void invalidateAutofillSession() {
        if (this.mInlineSuggestionsRequestCallback == null) goto L6;
        this.mInlineSuggestionsRequestCallback.onInlineSuggestionsSessionInvalidated();
        return;
    }
}
