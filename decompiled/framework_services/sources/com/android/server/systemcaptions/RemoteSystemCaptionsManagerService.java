package com.android.server.systemcaptions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.function.pooled.PooledLambda;

/* JADX INFO: loaded from: classes3.dex */
final class RemoteSystemCaptionsManagerService {
    private static final int MSG_BIND = 1;
    private static final String SERVICE_INTERFACE = "android.service.systemcaptions.SystemCaptionsManagerService";
    private static final String TAG = null;
    private boolean mBinding;
    private final ComponentName mComponentName;
    private final Context mContext;
    private boolean mDestroyed;
    private final Handler mHandler;
    private final Intent mIntent;
    private final Object mLock;
    private IBinder mService;
    private final RemoteServiceConnection mServiceConnection;
    private final int mUserId;
    private final boolean mVerbose;

    private class RemoteServiceConnection implements ServiceConnection {
        final /* synthetic */ RemoteSystemCaptionsManagerService this$0;

        /* synthetic */ RemoteServiceConnection(RemoteSystemCaptionsManagerService r1, RemoteSystemCaptionsManagerServiceIA r2) {
            this(r1);
        }

        private RemoteServiceConnection(RemoteSystemCaptionsManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = RemoteSystemCaptionsManagerService.m8451$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (RemoteSystemCaptionsManagerService.m8452$$Nest$fgetmVerbose(this.this$0) == false) goto L10;
            Slog.v(RemoteSystemCaptionsManagerService.m8455$$Nest$sfgetTAG(), "onServiceConnected()");     // Catch: Throwable -> L7
        L10:
            if (RemoteSystemCaptionsManagerService.m8450$$Nest$fgetmDestroyed(this.this$0) == true) goto L17;
            if (RemoteSystemCaptionsManagerService.m8449$$Nest$fgetmBinding(this.this$0) == false) goto L17;
            RemoteSystemCaptionsManagerService.m8453$$Nest$fputmBinding(this.this$0, false);     // Catch: Throwable -> L7
            RemoteSystemCaptionsManagerService.m8454$$Nest$fputmService(this.this$0, service);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L17:
            Slog.wtf(RemoteSystemCaptionsManagerService.m8455$$Nest$sfgetTAG(), "onServiceConnected() dispatched after unbindService");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object r0 = RemoteSystemCaptionsManagerService.m8451$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (RemoteSystemCaptionsManagerService.m8452$$Nest$fgetmVerbose(this.this$0) == false) goto L9;
            Slog.v(RemoteSystemCaptionsManagerService.m8455$$Nest$sfgetTAG(), "onServiceDisconnected()");     // Catch: Throwable -> L7
        L9:
            RemoteSystemCaptionsManagerService.m8453$$Nest$fputmBinding(this.this$0, true);     // Catch: Throwable -> L7
            RemoteSystemCaptionsManagerService.m8454$$Nest$fputmService(this.this$0, null);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0SlyYF_OiivMoU_g-J8qI6co27s, reason: not valid java name */
    public static /* synthetic */ void m8448$r8$lambda$0SlyYF_OiivMoU_gJ8qI6co27s(RemoteSystemCaptionsManagerService r0) {
        r0.handleEnsureBound();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8449$$Nest$fgetmBinding(RemoteSystemCaptionsManagerService r0) {
        return r0.mBinding;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8450$$Nest$fgetmDestroyed(RemoteSystemCaptionsManagerService r0) {
        return r0.mDestroyed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8451$$Nest$fgetmLock(RemoteSystemCaptionsManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVerbose, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8452$$Nest$fgetmVerbose(RemoteSystemCaptionsManagerService r0) {
        return r0.mVerbose;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8453$$Nest$fputmBinding(RemoteSystemCaptionsManagerService r0, boolean r1) {
        r0.mBinding = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8454$$Nest$fputmService(RemoteSystemCaptionsManagerService r0, IBinder r1) {
        r0.mService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8455$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = RemoteSystemCaptionsManagerService.class.getSimpleName();
    }

    RemoteSystemCaptionsManagerService(Context context, ComponentName componentName, int userId, boolean verbose) {
        this.mLock = new Object();
        this.mServiceConnection = new RemoteServiceConnection(this, null);
        this.mBinding = false;
        this.mDestroyed = false;
        this.mContext = context;
        this.mComponentName = componentName;
        this.mUserId = userId;
        this.mVerbose = verbose;
        this.mIntent = new Intent(SERVICE_INTERFACE).setComponent(componentName);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    void initialize() {
        if (this.mVerbose == false) goto L5;
        Slog.v(TAG, "initialize()");
    L5:
        scheduleBind();
    }

    public void destroy() {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new RemoteSystemCaptionsManagerService$$ExternalSyntheticLambda1(), this));
    }

    void handleDestroy() {
        if (this.mVerbose == false) goto L5;
        Slog.v(TAG, "handleDestroy()");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mDestroyed == true) goto L10;
        this.mDestroyed = true;     // Catch: Throwable -> L12
        ensureUnboundLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L10:
        if (this.mVerbose == false) goto L14;
        Slog.v(TAG, "handleDestroy(): Already destroyed");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
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

    private void scheduleBind() {
        if (this.mHandler.hasMessages(1) == true) goto L5;
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new RemoteSystemCaptionsManagerService$$ExternalSyntheticLambda0(), this).setWhat(1));
        return;
    L5:
        if (this.mVerbose == false) goto L10;
        Slog.v(TAG, "scheduleBind(): already scheduled");
        return;
    }

    private void handleEnsureBound() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mService != null) goto L19;
        if (this.mBinding == true) goto L19;
        if (this.mVerbose == false) goto L14;
        Slog.v(TAG, "handleEnsureBound(): binding");     // Catch: Throwable -> L12
    L14:
        this.mBinding = true;     // Catch: Throwable -> L12
        boolean willBind = this.mContext.bindServiceAsUser(this.mIntent, this.mServiceConnection, 67112961, this.mHandler, new UserHandle(this.mUserId));     // Catch: Throwable -> L12
        if (willBind == true) goto L17;
        Slog.w(TAG, "Could not bind to " + this.mIntent + " with flags 67112961");     // Catch: Throwable -> L12
        this.mBinding = false;     // Catch: Throwable -> L12
        this.mService = null;     // Catch: Throwable -> L12
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L12
    }

    private void ensureUnboundLocked() {
        if (this.mService == null) goto L5;
    L7:
        this.mBinding = false;
        this.mService = null;
        if (this.mVerbose == false) goto L10;
        Slog.v(TAG, "ensureUnbound(): unbinding");
    L10:
        this.mContext.unbindService(this.mServiceConnection);
        return;
    L5:
        if (this.mBinding == true) goto L7;
    }
}
