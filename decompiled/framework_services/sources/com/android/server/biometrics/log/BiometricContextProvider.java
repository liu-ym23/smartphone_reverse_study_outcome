package com.android.server.biometrics.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.biometrics.AuthenticateOptions;
import android.hardware.biometrics.common.OperationContext;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import android.view.WindowManager;
import com.android.internal.statusbar.IStatusBarService;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class BiometricContextProvider implements BiometricContext {
    private static final int SESSION_TYPES = 3;
    private static final String TAG = "BiometricContextProvider";
    private static BiometricContextProvider sInstance;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private int mDisplayState;
    private int mDockState;
    final BroadcastReceiver mDockStateReceiver;
    private int mFoldState;
    private final Handler mHandler;
    private boolean mIsHardwareIgnoringTouches;
    private final Map<Integer, BiometricContextSessionInfo> mSession;
    private final Map<OperationContextExt, Consumer<OperationContext>> mSubscribers;
    private final WindowManager mWindowManager;

    /* JADX INFO: renamed from: $r8$lambda$czs0m7JxoyF3UyAEi0-v9zxhbJI, reason: not valid java name */
    public static /* synthetic */ void m2599$r8$lambda$czs0m7JxoyF3UyAEi0v9zxhbJI(BiometricContextProvider r0, OperationContextExt r1, Consumer r2) {
        r0.lambda$notifySubscribers$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tdKTXSEedSBAtsJt9TChv52O5tM(BiometricContextProvider r0) {
        r0.notifySubscribers();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2600$$Nest$fgetmDisplayState(BiometricContextProvider r0) {
        return r0.mDisplayState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFoldState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2601$$Nest$fgetmFoldState(BiometricContextProvider r0) {
        return r0.mFoldState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsHardwareIgnoringTouches, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2602$$Nest$fgetmIsHardwareIgnoringTouches(BiometricContextProvider r0) {
        return r0.mIsHardwareIgnoringTouches;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m2603$$Nest$fgetmSession(BiometricContextProvider r0) {
        return r0.mSession;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2604$$Nest$fputmDisplayState(BiometricContextProvider r0, int r1) {
        r0.mDisplayState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2605$$Nest$fputmDockState(BiometricContextProvider r0, int r1) {
        r0.mDockState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFoldState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2606$$Nest$fputmFoldState(BiometricContextProvider r0, int r1) {
        r0.mFoldState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsHardwareIgnoringTouches, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2607$$Nest$fputmIsHardwareIgnoringTouches(BiometricContextProvider r0, boolean r1) {
        r0.mIsHardwareIgnoringTouches = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2608$$Nest$mnotifyChanged(BiometricContextProvider r0) {
        r0.notifyChanged();
    }

    static BiometricContextProvider defaultProvider(Context context) {
        monitor-enter(BiometricContextProvider.class);
    L14:
        th = move-exception;
        Throwable r8 = th;
    L25:
        monitor-exit(BiometricContextProvider.class);     // Catch: Throwable -> L10
        throw r8;
    L5:
        if (sInstance != null) goto L22;
    L29:
        sInstance = new BiometricContextProvider(context, (WindowManager) context.getSystemService("window"), IStatusBarService.Stub.asInterface(ServiceManager.getServiceOrThrow("statusbar")), null, new AuthSessionCoordinator());     // Catch: Throwable -> L10 ServiceManager.ServiceNotFoundException -> L12
    L12:
        e = move-exception;
        Throwable r9 = e;
    L20:
        throw new IllegalStateException("Failed to find required service", r9);     // Catch: Throwable -> L10
    L16:
        e = move-exception;
        r9 = e;
    L22:
        monitor-exit(BiometricContextProvider.class);     // Catch: Throwable -> L10
        return sInstance;
    L10:
        th = move-exception;
        r8 = th;
        goto L25
    }

    public BiometricContextProvider(Context context, WindowManager windowManager, IStatusBarService service, Handler handler, AuthSessionCoordinator authSessionCoordinator) {
        this.mSubscribers = new ConcurrentHashMap();
        this.mSession = new ConcurrentHashMap();
        this.mDockState = 0;
        this.mFoldState = 0;
        this.mDisplayState = 0;
        this.mIsHardwareIgnoringTouches = false;
        this.mDockStateReceiver = new AnonymousClass1(this);
        this.mWindowManager = windowManager;
        this.mAuthSessionCoordinator = authSessionCoordinator;
        this.mHandler = handler;
        subscribeBiometricContextListener(service);
        subscribeDockState(context);
    }

    private void subscribeBiometricContextListener(IStatusBarService service) {
        service.setBiometicContextListener(new AnonymousClass2(this));     // Catch: RemoteException -> L4
        service.registerSessionListener(3, new AnonymousClass3(this));     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to register biometric context listener", e);
    }

    private void subscribeDockState(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.DOCK_EVENT");
        context.registerReceiver(this.mDockStateReceiver, filter);
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public OperationContextExt updateContext(OperationContextExt operationContext, boolean isCryptoOperation) {
        return operationContext.update(this, isCryptoOperation);
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public BiometricContextSessionInfo getKeyguardEntrySessionInfo() {
        return this.mSession.get(1);
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public BiometricContextSessionInfo getBiometricPromptSessionInfo() {
        return this.mSession.get(2);
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public boolean isAod() {
        if (this.mDisplayState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public boolean isAwake() {
        switch(this.mDisplayState) {
            case 0: goto L6;
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public boolean isDisplayOn() {
        if (this.mWindowManager.getDefaultDisplay().getState() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public int getDockedState() {
        return this.mDockState;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public int getFoldState() {
        return this.mFoldState;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public int getCurrentRotation() {
        return this.mWindowManager.getDefaultDisplay().getRotation();
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public int getDisplayState() {
        return this.mDisplayState;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public boolean isHardwareIgnoringTouches() {
        return this.mIsHardwareIgnoringTouches;
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public void subscribe(OperationContextExt context, Consumer<OperationContext> startHalConsumer, Consumer<OperationContext> updateContextConsumer, AuthenticateOptions options) {
        this.mSubscribers.put(updateContext(context, context.isCrypto()), updateContextConsumer);
        if (options == null) goto L5;
        startHalConsumer.accept(context.toAidlContext(options));
        return;
    L5:
        startHalConsumer.accept(context.toAidlContext());
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public void unsubscribe(OperationContextExt context) {
        this.mSubscribers.remove(context);
    }

    @Override // com.android.server.biometrics.log.BiometricContext
    public AuthSessionCoordinator getAuthSessionCoordinator() {
        return this.mAuthSessionCoordinator;
    }

    private void notifyChanged() {
        if (this.mHandler == null) goto L5;
        this.mHandler.post(new BiometricContextProvider$$ExternalSyntheticLambda1(this));
        return;
    L5:
        notifySubscribers();
    }

    private void notifySubscribers() {
        this.mSubscribers.forEach(new BiometricContextProvider$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$notifySubscribers$0(OperationContextExt context, Consumer consumer) {
        consumer.accept(context.update(this, context.isCrypto()).toAidlContext());
    }

    public String toString() {
        return "[keyguard session: " + getKeyguardEntrySessionInfo() + ", bp session: " + getBiometricPromptSessionInfo() + ", displayState: " + getDisplayState() + ", isAwake: " + isAwake() + ", isHardwareIgnoring: " + isHardwareIgnoringTouches() + ", isDisplayOn: " + isDisplayOn() + ", dock: " + getDockedState() + ", rotation: " + getCurrentRotation() + ", foldState: " + this.mFoldState + "]";
    }
}
