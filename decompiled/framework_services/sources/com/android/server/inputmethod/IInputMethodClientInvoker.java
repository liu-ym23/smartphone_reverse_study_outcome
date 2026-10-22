package com.android.server.inputmethod;

import android.os.Binder;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.inputmethod.ImeTracker;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.InputBindResult;

/* JADX INFO: loaded from: classes2.dex */
final class IInputMethodClientInvoker {
    private static final boolean DEBUG = false;
    private static final String TAG = "InputMethodManagerService";
    private final Handler mHandler;
    private final boolean mIsProxy;
    private final IInputMethodClient mTarget;

    /* JADX INFO: renamed from: $r8$lambda$-Kdju1_EXd9J6Azs1wMip_57lL0, reason: not valid java name */
    public static /* synthetic */ void m4636$r8$lambda$Kdju1_EXd9J6Azs1wMip_57lL0(IInputMethodClientInvoker r0, int r1, int r2) {
        r0.lambda$onUnbindMethod$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$4vBH5dzq5LhwPcmgjldbMQdWn6I(IInputMethodClientInvoker r0, boolean r1, boolean r2) {
        r0.lambda$setActive$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$8K2ipAv29I48Hvp3wxVM87DxhD8(IInputMethodClientInvoker r0, InputBindResult r1, int r2) {
        r0.lambda$onStartInputResult$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$AoIlvIX3rP6SUO6OlBC_XdXM6X4(IInputMethodClientInvoker r0, boolean r1) {
        r0.lambda$setImeTraceEnabled$10(r1);
    }

    public static /* synthetic */ void $r8$lambda$OuPksNuQ9tCWWn7A6QY0aRiqbeI(IInputMethodClientInvoker r0, InputBindResult r1) {
        r0.lambda$onBindMethod$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$T7Gu5ioQQZTjloGBga4SNiKv3W4(IInputMethodClientInvoker r0, boolean r1) {
        r0.lambda$reportFullscreenMode$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$TqfpVjKrgSh4f5zBJva6YHyPOus(IInputMethodClientInvoker r0, int r1, int r2) {
        r0.lambda$onUnbindAccessibilityService$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VE1DYoKcKG6RshAekspt91ACmH4(IInputMethodClientInvoker r0, boolean r1, ImeTracker.Token r2) {
        r0.lambda$setImeVisibility$7(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$a3G7cYid-zOg_bx0EwyiClrvHT8, reason: not valid java name */
    public static /* synthetic */ void m4637$r8$lambda$a3G7cYidzOg_bx0EwyiClrvHT8(IInputMethodClientInvoker r0, boolean r1) {
        r0.lambda$scheduleStartInputIfNecessary$8(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dMZI-RMrMXtaM_w1zOlvHaqwIis, reason: not valid java name */
    public static /* synthetic */ void m4638$r8$lambda$dMZIRMrMXtaM_w1zOlvHaqwIis(IInputMethodClientInvoker r0, boolean r1, boolean r2) {
        r0.lambda$setInteractive$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hNuUID-hbMFkEXk-7itpoMVvaOA, reason: not valid java name */
    public static /* synthetic */ void m4639$r8$lambda$hNuUIDhbMFkEXk7itpoMVvaOA(IInputMethodClientInvoker r0, String r1) {
        r0.lambda$throwExceptionFromSystem$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$ilAVoPrQ9_gbCB1sD6s20h3tul0(IInputMethodClientInvoker r0, IBinder r1) {
        r0.lambda$resetAiWriting$12(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$t0530uO66e6JqhlHFYiF7K-M9KM, reason: not valid java name */
    public static /* synthetic */ void m4640$r8$lambda$t0530uO66e6JqhlHFYiF7KM9KM(IInputMethodClientInvoker r0, InputBindResult r1, int r2) {
        r0.lambda$onBindAccessibilityService$2(r1, r2);
    }

    static IInputMethodClientInvoker create(IInputMethodClient inputMethodClient, Handler handler) {
        boolean isProxy = Binder.isProxy(inputMethodClient);
        if (isProxy == false) goto L5;
        Handler r2 = null;
    L7:
        return new IInputMethodClientInvoker(inputMethodClient, isProxy, r2);
    L5:
        r2 = handler;
        goto L7
    }

    static IInputMethodClientInvoker create$ravenwood(IInputMethodClient inputMethodClient, Handler handler) {
        return new IInputMethodClientInvoker(inputMethodClient, true, null);
    }

    private IInputMethodClientInvoker(IInputMethodClient target, boolean isProxy, Handler handler) {
        this.mTarget = target;
        this.mIsProxy = isProxy;
        this.mHandler = handler;
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
        Slog.w(TAG, "IPC failed at IInputMethodClientInvoker#" + getCallerMethodName(), e);
        return;
    }

    void onBindMethod(final InputBindResult res) {
        if (this.mIsProxy == false) goto L5;
        onBindMethodInternal(res);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda1(this, res));
    }

    private /* synthetic */ void lambda$onBindMethod$0(InputBindResult res) {
        onBindMethodInternal(res);
    }

    private void onBindMethodInternal(InputBindResult res) {
        this.mTarget.onBindMethod(res);     // Catch: Throwable -> L8 RemoteException -> L10
    L4:
        if (res.channel != null) goto L6;
    L24:
        return;
    L6:
        if (this.mIsProxy == false) goto L24;
    L7:
        res.channel.dispose();
    L8:
        th = move-exception;
        if (res.channel != null) goto L21;
    L23:
        throw th;
    L21:
        if (this.mIsProxy == false) goto L23;
        res.channel.dispose();
    L10:
        e = move-exception;
        logRemoteException(e);     // Catch: Throwable -> L8
        if (res.channel == null) goto L24;
        if (this.mIsProxy == false) goto L24;
        goto L7
    }

    void onStartInputResult(final InputBindResult res, final int startInputSeq) {
        if (this.mIsProxy == false) goto L5;
        onStartInputResultInternal(res, startInputSeq);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda3(this, res, startInputSeq));
    }

    private /* synthetic */ void lambda$onStartInputResult$1(InputBindResult res, int startInputSeq) {
        onStartInputResultInternal(res, startInputSeq);
    }

    private void onStartInputResultInternal(InputBindResult res, int startInputSeq) {
        this.mTarget.onStartInputResult(res, startInputSeq);     // Catch: Throwable -> L8 RemoteException -> L10
    L4:
        if (res.channel != null) goto L6;
    L24:
        return;
    L6:
        if (this.mIsProxy == false) goto L24;
    L7:
        res.channel.dispose();
    L8:
        th = move-exception;
        if (res.channel != null) goto L21;
    L23:
        throw th;
    L21:
        if (this.mIsProxy == false) goto L23;
        res.channel.dispose();
    L10:
        e = move-exception;
        logRemoteException(e);     // Catch: Throwable -> L8
        if (res.channel == null) goto L24;
        if (this.mIsProxy == false) goto L24;
        goto L7
    }

    void onBindAccessibilityService(final InputBindResult res, final int id) {
        if (this.mIsProxy == false) goto L5;
        onBindAccessibilityServiceInternal(res, id);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda6(this, res, id));
    }

    private /* synthetic */ void lambda$onBindAccessibilityService$2(InputBindResult res, int id) {
        onBindAccessibilityServiceInternal(res, id);
    }

    private void onBindAccessibilityServiceInternal(InputBindResult res, int id) {
        this.mTarget.onBindAccessibilityService(res, id);     // Catch: Throwable -> L8 RemoteException -> L10
    L4:
        if (res.channel != null) goto L6;
    L24:
        return;
    L6:
        if (this.mIsProxy == false) goto L24;
    L7:
        res.channel.dispose();
    L8:
        th = move-exception;
        if (res.channel != null) goto L21;
    L23:
        throw th;
    L21:
        if (this.mIsProxy == false) goto L23;
        res.channel.dispose();
    L10:
        e = move-exception;
        logRemoteException(e);     // Catch: Throwable -> L8
        if (res.channel == null) goto L24;
        if (this.mIsProxy == false) goto L24;
        goto L7
    }

    void onUnbindMethod(final int sequence, final int unbindReason) {
        if (this.mIsProxy == false) goto L5;
        onUnbindMethodInternal(sequence, unbindReason);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda0(this, sequence, unbindReason));
    }

    private /* synthetic */ void lambda$onUnbindMethod$3(int sequence, int unbindReason) {
        onUnbindMethodInternal(sequence, unbindReason);
    }

    private void onUnbindMethodInternal(int sequence, int unbindReason) {
        this.mTarget.onUnbindMethod(sequence, unbindReason);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void onUnbindAccessibilityService(final int sequence, final int id) {
        if (this.mIsProxy == false) goto L5;
        onUnbindAccessibilityServiceInternal(sequence, id);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda4(this, sequence, id));
    }

    private /* synthetic */ void lambda$onUnbindAccessibilityService$4(int sequence, int id) {
        onUnbindAccessibilityServiceInternal(sequence, id);
    }

    private void onUnbindAccessibilityServiceInternal(int sequence, int id) {
        this.mTarget.onUnbindAccessibilityService(sequence, id);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setActive(final boolean active, final boolean fullscreen) {
        if (this.mIsProxy == false) goto L5;
        setActiveInternal(active, fullscreen);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda9(this, active, fullscreen));
    }

    private /* synthetic */ void lambda$setActive$5(boolean active, boolean fullscreen) {
        setActiveInternal(active, fullscreen);
    }

    private void setActiveInternal(boolean active, boolean fullscreen) {
        this.mTarget.setActive(active, fullscreen);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setInteractive(final boolean interactive, final boolean fullscreen) {
        if (this.mIsProxy == false) goto L5;
        setInteractiveInternal(interactive, fullscreen);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda7(this, interactive, fullscreen));
    }

    private /* synthetic */ void lambda$setInteractive$6(boolean interactive, boolean fullscreen) {
        setInteractiveInternal(interactive, fullscreen);
    }

    private void setInteractiveInternal(boolean interactive, boolean fullscreen) {
        this.mTarget.setInteractive(interactive, fullscreen);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setImeVisibility(final boolean visible, final ImeTracker.Token statsToken) {
        if (this.mIsProxy == false) goto L5;
        setImeVisibilityInternal(visible, statsToken);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda10(this, visible, statsToken));
    }

    private /* synthetic */ void lambda$setImeVisibility$7(boolean visible, ImeTracker.Token statsToken) {
        setImeVisibilityInternal(visible, statsToken);
    }

    private void setImeVisibilityInternal(boolean visible, ImeTracker.Token statsToken) {
        ImeTracker.forLogging().onProgress(statsToken, 78);     // Catch: RemoteException -> L5
        this.mTarget.setImeVisibility(visible, statsToken);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        logRemoteException(e);
        ImeTracker.forLogging().onFailed(statsToken, 78);
    }

    void scheduleStartInputIfNecessary(final boolean fullscreen) {
        if (this.mIsProxy == false) goto L5;
        scheduleStartInputIfNecessaryInternal(fullscreen);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda11(this, fullscreen));
    }

    private /* synthetic */ void lambda$scheduleStartInputIfNecessary$8(boolean fullscreen) {
        scheduleStartInputIfNecessaryInternal(fullscreen);
    }

    private void scheduleStartInputIfNecessaryInternal(boolean fullscreen) {
        this.mTarget.scheduleStartInputIfNecessary(fullscreen);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void reportFullscreenMode(final boolean fullscreen) {
        if (this.mIsProxy == false) goto L5;
        reportFullscreenModeInternal(fullscreen);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda8(this, fullscreen));
    }

    private /* synthetic */ void lambda$reportFullscreenMode$9(boolean fullscreen) {
        reportFullscreenModeInternal(fullscreen);
    }

    private void reportFullscreenModeInternal(boolean fullscreen) {
        this.mTarget.reportFullscreenMode(fullscreen);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void setImeTraceEnabled(final boolean enabled) {
        if (this.mIsProxy == false) goto L5;
        setImeTraceEnabledInternal(enabled);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda12(this, enabled));
    }

    private /* synthetic */ void lambda$setImeTraceEnabled$10(boolean enabled) {
        setImeTraceEnabledInternal(enabled);
    }

    private void setImeTraceEnabledInternal(boolean enabled) {
        this.mTarget.setImeTraceEnabled(enabled);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void throwExceptionFromSystem(final String message) {
        if (this.mIsProxy == false) goto L5;
        throwExceptionFromSystemInternal(message);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda5(this, message));
    }

    private /* synthetic */ void lambda$throwExceptionFromSystem$11(String message) {
        throwExceptionFromSystemInternal(message);
    }

    private void throwExceptionFromSystemInternal(String message) {
        this.mTarget.throwExceptionFromSystem(message);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    IBinder asBinder() {
        return this.mTarget.asBinder();
    }

    private void resetAiWritingInternal(IBinder windowToken) {
        this.mTarget.resetAiWriting(windowToken);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        logRemoteException(e);
    }

    void resetAiWriting(final IBinder windowToken) {
        if (this.mIsProxy == false) goto L5;
        resetAiWritingInternal(windowToken);
        return;
    L5:
        this.mHandler.post(new IInputMethodClientInvoker$$ExternalSyntheticLambda2(this, windowToken));
    }

    private /* synthetic */ void lambda$resetAiWriting$12(IBinder windowToken) {
        resetAiWritingInternal(windowToken);
    }
}
