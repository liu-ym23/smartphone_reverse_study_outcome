package com.android.server.pm;

import android.app.IInstantAppResolver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.InstantAppRequestInfo;
import android.content.pm.InstantAppResolveInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import android.util.TimedRemoteCaller;
import com.android.internal.os.BackgroundThread;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
final class InstantAppResolverConnection implements IBinder.DeathRecipient {
    private static final long BIND_SERVICE_TIMEOUT_MS = 0;
    private static final long CALL_SERVICE_TIMEOUT_MS = 0;
    private static final boolean DEBUG_INSTANT = false;
    private static final int STATE_BINDING = 1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PENDING = 2;
    private static final String TAG = "PackageManager";
    private final Handler mBgHandler;
    private int mBindState;
    private final Context mContext;
    private final GetInstantAppResolveInfoCaller mGetInstantAppResolveInfoCaller;
    private final Intent mIntent;
    private final Object mLock;
    private IInstantAppResolver mRemoteInstance;
    private final ServiceConnection mServiceConnection;

    /* JADX INFO: renamed from: com.android.server.pm.InstantAppResolverConnection$1, reason: invalid class name */
    class AnonymousClass1 extends IRemoteCallback.Stub {
        final /* synthetic */ PhaseTwoCallback val$callback;
        final /* synthetic */ Handler val$callbackHandler;
        final /* synthetic */ long val$startTime;

        public static /* synthetic */ void $r8$lambda$4KiXaFsakX0utsiRk3ODSEkT6tM(PhaseTwoCallback r0, ArrayList r1, long r2) {
            lambda$sendResult$0(r0, r1, r2);
        }

        AnonymousClass1(InstantAppResolverConnection this$0, Handler r2, PhaseTwoCallback r3, long r4) {
            this.val$callbackHandler = r2;
            this.val$callback = r3;
            this.val$startTime = r4;
        }

        public void sendResult(Bundle data) throws RemoteException {
            final ArrayList<InstantAppResolveInfo> resolveList = data.getParcelableArrayList("android.app.extra.RESOLVE_INFO", InstantAppResolveInfo.class);
            Handler r1 = this.val$callbackHandler;
            final PhaseTwoCallback r2 = this.val$callback;
            final long r3 = this.val$startTime;
            r1.post(new InstantAppResolverConnection$1$$ExternalSyntheticLambda0(r2, resolveList, r3));
        }

        private static /* synthetic */ void lambda$sendResult$0(PhaseTwoCallback callback, ArrayList resolveList, long startTime) {
            callback.onPhaseTwoResolved(resolveList, startTime);
        }
    }

    public static class ConnectionException extends Exception {
        public static final int FAILURE_BIND = 1;
        public static final int FAILURE_CALL = 2;
        public static final int FAILURE_INTERRUPTED = 3;
        public final int failure;

        public ConnectionException(int _failure) {
            this.failure = _failure;
        }
    }

    private static final class GetInstantAppResolveInfoCaller extends TimedRemoteCaller<List<InstantAppResolveInfo>> {
        private final IRemoteCallback mCallback;

        static /* synthetic */ void access$000(GetInstantAppResolveInfoCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public GetInstantAppResolveInfoCaller() {
            super(InstantAppResolverConnection.m6690$$Nest$sfgetCALL_SERVICE_TIMEOUT_MS());
            this.mCallback = new AnonymousClass1(this);
        }

        public List<InstantAppResolveInfo> getInstantAppResolveInfoList(IInstantAppResolver target, InstantAppRequestInfo request) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.getInstantAppResolveInfoList(request, sequence, this.mCallback);
            return (List) getResultTimed(sequence);
        }
    }

    private final class MyServiceConnection implements ServiceConnection {
        final /* synthetic */ InstantAppResolverConnection this$0;

        /* synthetic */ MyServiceConnection(InstantAppResolverConnection r1, InstantAppResolverConnectionIA r2) {
            this(r1);
        }

        private MyServiceConnection(InstantAppResolverConnection r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (InstantAppResolverConnection.m6691$$Nest$sfgetDEBUG_INSTANT() == false) goto L5;
            Slog.d("PackageManager", "Connected to instant app resolver");
        L5:
            Object r0 = InstantAppResolverConnection.m6686$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            InstantAppResolverConnection.m6688$$Nest$fputmRemoteInstance(this.this$0, IInstantAppResolver.Stub.asInterface(service));     // Catch: Throwable -> L11
            if (InstantAppResolverConnection.m6685$$Nest$fgetmBindState(this.this$0) != 2) goto L22;
            InstantAppResolverConnection.m6687$$Nest$fputmBindState(this.this$0, 0);     // Catch: Throwable -> L11
        L22:
            service.linkToDeath(this.this$0, 0);     // Catch: Throwable -> L11 RemoteException -> L15
        L17:
            InstantAppResolverConnection.m6686$$Nest$fgetmLock(this.this$0).notifyAll();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L16:
            InstantAppResolverConnection.m6689$$Nest$mhandleBinderDiedLocked(this.this$0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            if (InstantAppResolverConnection.m6691$$Nest$sfgetDEBUG_INSTANT() == false) goto L5;
            Slog.d("PackageManager", "Disconnected from instant app resolver");
        L5:
            Object r0 = InstantAppResolverConnection.m6686$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            InstantAppResolverConnection.m6689$$Nest$mhandleBinderDiedLocked(this.this$0);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class PhaseTwoCallback {
        abstract void onPhaseTwoResolved(List<InstantAppResolveInfo> r1, long r2);

        public PhaseTwoCallback() {
        }
    }

    public static /* synthetic */ void $r8$lambda$66W2s2mMKe4pk_xXCScH9RCqav8(InstantAppResolverConnection r0) {
        r0.lambda$optimisticBind$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBindState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6685$$Nest$fgetmBindState(InstantAppResolverConnection r0) {
        return r0.mBindState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6686$$Nest$fgetmLock(InstantAppResolverConnection r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBindState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6687$$Nest$fputmBindState(InstantAppResolverConnection r0, int r1) {
        r0.mBindState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteInstance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6688$$Nest$fputmRemoteInstance(InstantAppResolverConnection r0, IInstantAppResolver r1) {
        r0.mRemoteInstance = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBinderDiedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6689$$Nest$mhandleBinderDiedLocked(InstantAppResolverConnection r0) {
        r0.handleBinderDiedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCALL_SERVICE_TIMEOUT_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6690$$Nest$sfgetCALL_SERVICE_TIMEOUT_MS() {
        return CALL_SERVICE_TIMEOUT_MS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_INSTANT, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6691$$Nest$sfgetDEBUG_INSTANT() {
        return DEBUG_INSTANT;
    }

    static {
        if (Build.IS_ENG == false) goto L5;
        long r0 = 500;
    L6:
        BIND_SERVICE_TIMEOUT_MS = r0;
        if (Build.IS_ENG == false) goto L9;
        long r1 = 200;
    L10:
        CALL_SERVICE_TIMEOUT_MS = r1;
        DEBUG_INSTANT = Build.IS_DEBUGGABLE;
        return;
    L9:
        r1 = 100;
        goto L10
    L5:
        r0 = 300;
        goto L6
    }

    public InstantAppResolverConnection(Context context, ComponentName componentName, String action) {
        this.mLock = new Object();
        this.mGetInstantAppResolveInfoCaller = new GetInstantAppResolveInfoCaller();
        this.mServiceConnection = new MyServiceConnection(this, null);
        this.mBindState = 0;
        this.mContext = context;
        this.mIntent = new Intent(action).setComponent(componentName);
        this.mBgHandler = BackgroundThread.getHandler();
    }

    public List<InstantAppResolveInfo> getInstantAppResolveInfoList(InstantAppRequestInfo request) throws ConnectionException {
        throwIfCalledOnMainThread();
        IInstantAppResolver target = getRemoteInstanceLazy(request.getToken());     // Catch: Throwable -> L14 InterruptedException -> L32 TimeoutException -> L34
    L56:
        List<InstantAppResolveInfo> r1 = this.mGetInstantAppResolveInfoCaller.getInstantAppResolveInfoList(target, request);     // Catch: Throwable -> L14 RemoteException -> L16 TimeoutException -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mLock.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L21:
        monitor-enter(this.mLock);
        this.mLock.notifyAll();     // Catch: Throwable -> L26
        return null;
    L26:
        th = move-exception;
        throw th;
    L31:
        throw new ConnectionException(2);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mLock.notifyAll();     // Catch: Throwable -> L45
        throw th;
    L45:
        th = move-exception;
        throw th;
    L37:
        throw new ConnectionException(3);     // Catch: Throwable -> L14
    L39:
        throw new ConnectionException(1);     // Catch: Throwable -> L14
    }

    public void getInstantAppIntentFilterList(InstantAppRequestInfo request, PhaseTwoCallback callback, Handler callbackHandler, long startTime) throws ConnectionException {
        AnonymousClass1 r0 = new AnonymousClass1(this, callbackHandler, callback, startTime);
        getRemoteInstanceLazy(request.getToken()).getInstantAppIntentFilterList(request, r0);     // Catch: RemoteException -> L5 InterruptedException -> L7 TimeoutException -> L9
        return;
    L18:
        return;
    L13:
        throw new ConnectionException(3);
    L15:
        throw new ConnectionException(1);
    }

    private IInstantAppResolver getRemoteInstanceLazy(String token) throws ConnectionException, TimeoutException, InterruptedException {
        long binderToken = Binder.clearCallingIdentity();
        IInstantAppResolver r2 = bind(token);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(binderToken);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(binderToken);
        throw th;
    }

    private void waitForBindLocked(String token) throws TimeoutException, InterruptedException {
        long startMillis = SystemClock.uptimeMillis();
    L4:
        if (this.mBindState == 0) goto L13;
        if (this.mRemoteInstance != null) goto L17;
        long elapsedMillis = SystemClock.uptimeMillis() - startMillis;
        long remainingMillis = BIND_SERVICE_TIMEOUT_MS - elapsedMillis;
        if (remainingMillis <= 0) goto L12;
        this.mLock.wait(remainingMillis);
        goto L4
    L12:
        throw new TimeoutException("[" + token + "] Didn't bind to resolver in time!");
    L17:
        return;
    }

    private IInstantAppResolver bind(String token) throws ConnectionException, TimeoutException, InterruptedException {
        boolean doUnbind = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteInstance == null) goto L12;
        IInstantAppResolver r2 = this.mRemoteInstance;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L12:
        if (this.mBindState != 2) goto L26;
        if (DEBUG_INSTANT == false) goto L102;
        Slog.i("PackageManager", "[" + token + "] Previous bind timed out; waiting for connection");     // Catch: Throwable -> L9
    L102:
        waitForBindLocked(token);     // Catch: Throwable -> L9 TimeoutException -> L21
        if (this.mRemoteInstance == null) goto L26;
        IInstantAppResolver r3 = this.mRemoteInstance;     // Catch: Throwable -> L9 TimeoutException -> L21
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r3;
    L24:
        doUnbind = true;
    L26:
        if (this.mBindState == 1) goto L28;
        this.mBindState = 1;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        boolean wasBound = false;
        IInstantAppResolver instance = null;
        if (doUnbind == false) goto L52;
    L45:
        th = move-exception;
        IInstantAppResolver instance2 = instance;
        boolean wasBound2 = wasBound;
        monitor-enter(this.mLock);
        if (wasBound2 == false) goto L85;
        if (instance2 != null) goto L85;
        this.mBindState = 2;     // Catch: Throwable -> L83
    L86:
        this.mLock.notifyAll();     // Catch: Throwable -> L83
        throw th;
    L85:
        this.mBindState = 0;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        throw th;
    L42:
        if (DEBUG_INSTANT == false) goto L96;
        Slog.i("PackageManager", "[" + token + "] Previous connection never established; rebinding");     // Catch: Throwable -> L45
    L96:
        this.mContext.unbindService(this.mServiceConnection);     // Catch: Throwable -> L45 Exception -> L49
    L49:
        e = move-exception;
        Slog.e("PackageManager", "[" + token + "] Service already unbound", e);     // Catch: Throwable -> L45
    L52:
        if (DEBUG_INSTANT == false) goto L54;
        Slog.v("PackageManager", "[" + token + "] Binding to instant app resolver");     // Catch: Throwable -> L45
    L54:
        wasBound = this.mContext.bindServiceAsUser(this.mIntent, this.mServiceConnection, AudioFormat.AAC_MAIN, UserHandle.SYSTEM);     // Catch: Throwable -> L45
        if (wasBound == false) goto L76;
        Object r4 = this.mLock;     // Catch: Throwable -> L45
        monitor-enter(r4);     // Catch: Throwable -> L45
        waitForBindLocked(token);     // Catch: Throwable -> L73
        instance = this.mRemoteInstance;     // Catch: Throwable -> L73
        monitor-exit(r4);     // Catch: Throwable -> L73
        Object r7 = this.mLock;
        monitor-enter(r7);
        if (wasBound == false) goto L67;
        if (instance != null) goto L67;
        this.mBindState = 2;     // Catch: Throwable -> L65
    L68:
        this.mLock.notifyAll();     // Catch: Throwable -> L65
        monitor-exit(r7);     // Catch: Throwable -> L65
        return instance;
    L67:
        this.mBindState = 0;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    L73:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L76:
        Slog.w("PackageManager", "[" + token + "] Failed to bind to: " + this.mIntent);     // Catch: Throwable -> L45
        throw new ConnectionException(1);     // Catch: Throwable -> L45
    L28:
        if (DEBUG_INSTANT == false) goto L30;
        Slog.i("PackageManager", "[" + token + "] Another thread is binding; waiting for connection");     // Catch: Throwable -> L9
    L30:
        waitForBindLocked(token);     // Catch: Throwable -> L9
        if (this.mRemoteInstance == null) goto L36;
        IInstantAppResolver r5 = this.mRemoteInstance;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r5;
    L36:
        throw new ConnectionException(1);     // Catch: Throwable -> L9
    }

    private void throwIfCalledOnMainThread() {
        if (Thread.currentThread() == this.mContext.getMainLooper().getThread()) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot invoke on the main thread");
    }

    void optimisticBind() {
        this.mBgHandler.post(new InstantAppResolverConnection$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$optimisticBind$0() {
    L9:
        e = move-exception;
        Slog.e("PackageManager", "Optimistic bind failed.", e);
        return;
    L4:
        if (bind("Optimistic Bind") != null) goto L6;
        return;
    L6:
        if (DEBUG_INSTANT == false) goto L17;
        Slog.i("PackageManager", "Optimistic bind succeeded.");     // Catch: Throwable -> L9
        return;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (DEBUG_INSTANT == false) goto L5;
        Slog.d("PackageManager", "Binder to instant app resolver died");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        handleBinderDiedLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        optimisticBind();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void handleBinderDiedLocked() {
        if (this.mRemoteInstance != null) goto L13;
    L8:
        this.mRemoteInstance = null;
        this.mContext.unbindService(this.mServiceConnection);     // Catch: Exception -> L11
        return;
    L12:
        return;
    L13:
        this.mRemoteInstance.asBinder().unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L6
        goto L8
    }
}
