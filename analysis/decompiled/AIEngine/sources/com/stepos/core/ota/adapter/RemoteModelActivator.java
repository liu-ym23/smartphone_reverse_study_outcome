package com.stepos.core.ota.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.IModelActivationHost;
import com.stepos.core.ota.domain.port.ModelActivator;
import com.stepos.core.ota.process.OtaProcess;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteModelActivator implements ModelActivator {
    public static final String ACTION = "com.stepos.aiengine.action.MODEL_ACTIVATION_HOST";
    public static final Companion Companion = new Companion(null);
    private final String TAG;
    private final RemoteModelActivator$connection$1 connection;
    private final Context context;
    private volatile IModelActivationHost host;
    private volatile CompletableDeferred<IModelActivationHost> hostLatch;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.adapter.RemoteModelActivator$awaitHost$3", f = "RemoteModelActivator.kt", l = {70}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.adapter.RemoteModelActivator$awaitHost$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<CoroutineScope, b<? super IModelActivationHost>, Object> {
        final /* synthetic */ CompletableDeferred<IModelActivationHost> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CompletableDeferred<IModelActivationHost> completableDeferred, b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass3(this.$deferred, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            CompletableDeferred<IModelActivationHost> completableDeferred = this.$deferred;
            this.label = 1;
            Object objAwait = completableDeferred.await(this);
            return objAwait == coroutineSingletons ? coroutineSingletons : objAwait;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super IModelActivationHost> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.adapter.RemoteModelActivator", f = "RemoteModelActivator.kt", l = {89}, m = "currentVersion")
    /* renamed from: com.stepos.core.ota.adapter.RemoteModelActivator$currentVersion$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteModelActivator.this.currentVersion(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.adapter.RemoteModelActivator", f = "RemoteModelActivator.kt", l = {101}, m = "deactivate")
    /* renamed from: com.stepos.core.ota.adapter.RemoteModelActivator$deactivate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03861 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03861(b<? super C03861> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteModelActivator.this.deactivate(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.stepos.core.ota.adapter.RemoteModelActivator$connection$1] */
    public RemoteModelActivator(Context context) {
        g.f(context, "context");
        this.context = context;
        this.TAG = "RemoteModelActivator";
        this.connection = new ServiceConnection() { // from class: com.stepos.core.ota.adapter.RemoteModelActivator$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IModelActivationHost iModelActivationHostAsInterface = IModelActivationHost.Stub.asInterface(iBinder);
                this.this$0.host = iModelActivationHostAsInterface;
                RemoteModelActivator remoteModelActivator = this.this$0;
                synchronized (remoteModelActivator) {
                    try {
                        CompletableDeferred completableDeferred = remoteModelActivator.hostLatch;
                        if (completableDeferred != null) {
                            g.c(iModelActivationHostAsInterface);
                            completableDeferred.complete(iModelActivationHostAsInterface);
                        }
                        remoteModelActivator.hostLatch = null;
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                AIEngineLogger.i(LogModule.OTA, this.this$0.TAG, "activation host connected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                this.this$0.host = null;
                RemoteModelActivator remoteModelActivator = this.this$0;
                synchronized (remoteModelActivator) {
                    remoteModelActivator.hostLatch = null;
                    n nVar = n.f10413a;
                }
                AIEngineLogger.w(LogModule.OTA, this.this$0.TAG, "activation host disconnected");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitHost(long j10, b<? super IModelActivationHost> bVar) {
        CompletableDeferred<IModelActivationHost> completableDeferredCompletableDeferred$default;
        IModelActivationHost iModelActivationHost = this.host;
        if (iModelActivationHost != null) {
            return iModelActivationHost;
        }
        synchronized (this) {
            completableDeferredCompletableDeferred$default = this.hostLatch;
            if (completableDeferredCompletableDeferred$default == null) {
                completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                this.hostLatch = completableDeferredCompletableDeferred$default;
            }
        }
        return TimeoutKt.withTimeoutOrNull(j10, new AnonymousClass3(completableDeferredCompletableDeferred$default, null), bVar);
    }

    public static /* synthetic */ Object awaitHost$default(RemoteModelActivator remoteModelActivator, long j10, b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 8000;
        }
        return remoteModelActivator.awaitHost(j10, bVar);
    }

    public static /* synthetic */ boolean deactivateBlocking$default(RemoteModelActivator remoteModelActivator, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 3000;
        }
        return remoteModelActivator.deactivateBlocking(str, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.core.ota.domain.port.ModelActivator
    /* renamed from: activate-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo115activateyxL6bBk(java.lang.String r12, int r13, java.lang.String r14, java.lang.String r15, qb.b<? super kotlin.Result<lb.n>> r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.stepos.core.ota.adapter.RemoteModelActivator$activate$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.core.ota.adapter.RemoteModelActivator$activate$1 r1 = (com.stepos.core.ota.adapter.RemoteModelActivator$activate$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ota.adapter.RemoteModelActivator$activate$1 r1 = new com.stepos.core.ota.adapter.RemoteModelActivator$activate$1
            r1.<init>(r11, r0)
        L1a:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r1.label
            r10 = 1
            if (r2 == 0) goto L31
            if (r2 != r10) goto L29
            kotlin.c.b(r0)
            goto L4c
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            kotlin.c.b(r0)
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.adapter.RemoteModelActivator$activate$2 r2 = new com.stepos.core.ota.adapter.RemoteModelActivator$activate$2
            r8 = 0
            r6 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.label = r10
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r1)
            if (r0 != r9) goto L4c
            return r9
        L4c:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f9987a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.RemoteModelActivator.mo115activateyxL6bBk(java.lang.String, int, java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    public final void bindActivationHost(Context appContext) {
        g.f(appContext, "appContext");
        if (OtaProcess.INSTANCE.isOtaProcess(appContext)) {
            Intent intent = new Intent(ACTION).setPackage(appContext.getPackageName());
            g.e(intent, "setPackage(...)");
            appContext.bindService(intent, this.connection, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object currentVersion(java.lang.String r9, qb.b<? super java.lang.Integer> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.core.ota.adapter.RemoteModelActivator.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.core.ota.adapter.RemoteModelActivator$currentVersion$1 r0 = (com.stepos.core.ota.adapter.RemoteModelActivator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.core.ota.adapter.RemoteModelActivator$currentVersion$1 r0 = new com.stepos.core.ota.adapter.RemoteModelActivator$currentVersion$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r7 = -1
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r8 = r4.L$0
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L2f
            goto L4d
        L2f:
            r0 = move-exception
            r8 = r0
            goto L5d
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.c.b(r10)
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L2f
            r4.label = r2     // Catch: java.lang.Throwable -> L2f
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r10 = awaitHost$default(r1, r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L2f
            if (r10 != r0) goto L4d
            return r0
        L4d:
            com.stepos.core.ota.IModelActivationHost r10 = (com.stepos.core.ota.IModelActivationHost) r10     // Catch: java.lang.Throwable -> L2f
            if (r10 == 0) goto L56
            int r8 = r10.getCurrentVersion(r9)     // Catch: java.lang.Throwable -> L2f
            goto L57
        L56:
            r8 = r7
        L57:
            java.lang.Integer r9 = new java.lang.Integer     // Catch: java.lang.Throwable -> L2f
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2f
            goto L61
        L5d:
            kotlin.Result$Failure r9 = kotlin.c.a(r8)
        L61:
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            boolean r10 = r9 instanceof kotlin.Result.Failure
            if (r10 == 0) goto L6b
            r9 = r8
        L6b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.RemoteModelActivator.currentVersion(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deactivate(java.lang.String r8, qb.b<? super java.lang.Boolean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.core.ota.adapter.RemoteModelActivator.C03861
            if (r0 == 0) goto L14
            r0 = r9
            com.stepos.core.ota.adapter.RemoteModelActivator$deactivate$1 r0 = (com.stepos.core.ota.adapter.RemoteModelActivator.C03861) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.core.ota.adapter.RemoteModelActivator$deactivate$1 r0 = new com.stepos.core.ota.adapter.RemoteModelActivator$deactivate$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r7 = r4.L$0
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            kotlin.c.b(r9)     // Catch: java.lang.Throwable -> L59
            goto L49
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.c.b(r9)
            r4.L$0 = r8     // Catch: java.lang.Throwable -> L59
            r4.label = r2     // Catch: java.lang.Throwable -> L59
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r7
            java.lang.Object r9 = awaitHost$default(r1, r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L59
            if (r9 != r0) goto L49
            return r0
        L49:
            com.stepos.core.ota.IModelActivationHost r9 = (com.stepos.core.ota.IModelActivationHost) r9     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L50
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L59
            return r7
        L50:
            boolean r7 = r9.deactivate(r8)     // Catch: java.lang.Throwable -> L59
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L59
            goto L5f
        L59:
            r0 = move-exception
            r7 = r0
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L5f:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            boolean r9 = r7 instanceof kotlin.Result.Failure
            if (r9 == 0) goto L66
            r7 = r8
        L66:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.RemoteModelActivator.deactivate(java.lang.String, qb.b):java.lang.Object");
    }

    public final boolean deactivateBlocking(String otaId, long j10) {
        Object objA;
        g.f(otaId, "otaId");
        try {
            objA = (Boolean) BuildersKt.runBlocking(Dispatchers.getIO(), new RemoteModelActivator$deactivateBlocking$1$1(j10, this, otaId, null));
            objA.getClass();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void unbind(Context appContext) {
        g.f(appContext, "appContext");
        try {
            appContext.unbindService(this.connection);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        this.host = null;
    }
}
