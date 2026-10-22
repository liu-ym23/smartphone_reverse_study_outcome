package com.android.server.inputmethod;

import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Slog;
import android.view.InputChannel;
import android.view.MotionEvent;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputMethodSubtype;
import android.window.ImeOnBackInvokedDispatcher;
import com.android.internal.inputmethod.IConnectionlessHandwritingCallback;
import com.android.internal.inputmethod.IInlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.IInputMethod;
import com.android.internal.inputmethod.IInputMethodPrivilegedOperations;
import com.android.internal.inputmethod.IInputMethodSession;
import com.android.internal.inputmethod.IInputMethodSessionCallback;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class IInputMethodInvoker {
    private static final boolean DEBUG = false;
    private static final String TAG = "InputMethodManagerService";
    private final IInputMethod mTarget;

    static IInputMethodInvoker create(IInputMethod inputMethod) {
        if (inputMethod != null) goto L6;
        return null;
    L6:
        if (Binder.isProxy(inputMethod) == false) goto L10;
        return new IInputMethodInvoker(inputMethod);
    L10:
        throw new UnsupportedOperationException(inputMethod + " must have been a BinderProxy.");
    }

    private static String getCallerMethodName() {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if (callStack.length > 4) goto L7;
        return "<bottom of call stack>";
    L7:
        return callStack[4].getMethodName();
    }

    private static void logRemoteException(RemoteException e) {
        if ((e instanceof DeadObjectException) == true) goto L6;
        Slog.w(TAG, "IPC failed at IInputMethodInvoker#" + getCallerMethodName(), e);
        return;
    }

    static int getBinderIdentityHashCode(IInputMethodInvoker obj) {
        if (obj != null) goto L6;
        return 0;
    L6:
        return System.identityHashCode(obj.mTarget);
    }

    private IInputMethodInvoker(IInputMethod target) {
        this.mTarget = target;
    }

    IBinder asBinder() {
        return this.mTarget.asBinder();
    }

    void initializeInternal(IBinder token, IInputMethodPrivilegedOperations privilegedOperations, int navigationBarFlags) {
        IInputMethod.InitParams params = new IInputMethod.InitParams();
        params.token = token;
        params.privilegedOperations = privilegedOperations;
        params.navigationBarFlags = navigationBarFlags;
        this.mTarget.initializeInternal(params);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        logRemoteException(e);
    }

    void onCreateInlineSuggestionsRequest(InlineSuggestionsRequestInfo requestInfo, IInlineSuggestionsRequestCallback cb) {
        this.mTarget.onCreateInlineSuggestionsRequest(requestInfo, cb);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void bindInput(InputBinding binding) {
        this.mTarget.bindInput(binding);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void unbindInput() {
        this.mTarget.unbindInput();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void startInput(IBinder startInputToken, IRemoteInputConnection remoteInputConnection, EditorInfo editorInfo, boolean restarting, int navButtonFlags, ImeOnBackInvokedDispatcher imeDispatcher) {
        IInputMethod.StartInputParams params = new IInputMethod.StartInputParams();
        params.startInputToken = startInputToken;
        params.remoteInputConnection = remoteInputConnection;
        params.editorInfo = editorInfo;
        params.restarting = restarting;
        params.navigationBarFlags = navButtonFlags;
        params.imeDispatcher = imeDispatcher;
        this.mTarget.startInput(params);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        logRemoteException(e);
    }

    void onNavButtonFlagsChanged(int navButtonFlags) {
        this.mTarget.onNavButtonFlagsChanged(navButtonFlags);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void createSession(InputChannel channel, IInputMethodSessionCallback callback) {
        this.mTarget.createSession(channel, callback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setSessionEnabled(IInputMethodSession session, boolean enabled) {
        this.mTarget.setSessionEnabled(session, enabled);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    boolean showSoftInput(IBinder showInputToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver) {
        ImeTracker.forLogging().onProgress(statsToken, 77);     // Catch: RemoteException -> L6
        this.mTarget.showSoftInput(showInputToken, statsToken, flags, resultReceiver);     // Catch: RemoteException -> L6
        return true;
    L6:
        e = move-exception;
        logRemoteException(e);
        ImeTracker.forLogging().onFailed(statsToken, 77);
        return false;
    }

    boolean hideSoftInput(IBinder hideInputToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver) {
        ImeTracker.forLogging().onProgress(statsToken, 77);     // Catch: RemoteException -> L6
        this.mTarget.hideSoftInput(hideInputToken, statsToken, flags, resultReceiver);     // Catch: RemoteException -> L6
        return true;
    L6:
        e = move-exception;
        logRemoteException(e);
        ImeTracker.forLogging().onFailed(statsToken, 77);
        return false;
    }

    void updateEditorToolType(int toolType) {
        this.mTarget.updateEditorToolType(toolType);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void changeInputMethodSubtype(InputMethodSubtype subtype) {
        this.mTarget.changeInputMethodSubtype(subtype);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void canStartStylusHandwriting(int requestId, IConnectionlessHandwritingCallback connectionlessCallback, CursorAnchorInfo cursorAnchorInfo, boolean isConnectionlessForDelegation) {
        this.mTarget.canStartStylusHandwriting(requestId, connectionlessCallback, cursorAnchorInfo, isConnectionlessForDelegation);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    boolean startStylusHandwriting(int requestId, InputChannel channel, List<MotionEvent> events) {
        this.mTarget.startStylusHandwriting(requestId, channel, events);     // Catch: RemoteException -> L5
        return true;
    L5:
        e = move-exception;
        logRemoteException(e);
        return false;
    }

    void commitHandwritingDelegationTextIfAvailable() {
        this.mTarget.commitHandwritingDelegationTextIfAvailable();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void discardHandwritingDelegationText() {
        this.mTarget.discardHandwritingDelegationText();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void initInkWindow() {
        this.mTarget.initInkWindow();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void finishStylusHandwriting() {
        this.mTarget.finishStylusHandwriting();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void removeStylusHandwritingWindow() {
        this.mTarget.removeStylusHandwritingWindow();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setStylusWindowIdleTimeoutForTest(long timeout) {
        this.mTarget.setStylusWindowIdleTimeoutForTest(timeout);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }
}
