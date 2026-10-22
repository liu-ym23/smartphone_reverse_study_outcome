package com.stepos.core.ota.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import com.stepos.aicgroup.f;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.ota.IOtaProcessControl;
import com.stepos.core.ota.IOtaTaskListener;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.bridge.CallbackSubscriber;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.domain.UserUninstallPolicy;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.UserUninstallStore;
import h0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import lb.n;
import mb.x;
import mb.y;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessClient {
    private static final long BIND_WATCHDOG_MS = 30000;
    private static final long REBIND_RETRY_MAX_MS = 300000;
    private static final long REBIND_RETRY_MS = 5000;
    private static final String TAG = "OtaProcessClient";
    private static final MutableStateFlow<Map<String, OtaStateSnapshot>> _ipcState;
    private static volatile Context appContext;
    private static volatile CallbackSubscriber callbackBridge;
    private static final ServiceConnection connection;
    private static final StateFlow<Map<String, OtaStateSnapshot>> ipcState;
    private static volatile zb.a<n> onConnected;
    private static volatile CompletableDeferred<IOtaProcessControl> pendingConnect;
    private static final IOtaTaskListener taskListener;
    public static final OtaProcessClient INSTANCE = new OtaProcessClient();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static final AtomicReference<IOtaProcessControl> controlRef = new AtomicReference<>();
    private static final BindAttemptState bindState = new BindAttemptState();
    private static final AtomicInteger consecutiveBindTimeouts = new AtomicInteger(0);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessClient$doBind$1", f = "OtaProcessClient.kt", l = {255, 268}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessClient$doBind$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ boolean $autoCreate;
        final /* synthetic */ long $bindToken;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, boolean z, long j10, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$context = context;
            this.$autoCreate = z;
            this.$bindToken = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$autoCreate, this.$bindToken, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context applicationContext;
            Object objA;
            Context context;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                applicationContext = this.$context.getApplicationContext();
                Intent className = new Intent(OtaProcessService.ACTION).setClassName(applicationContext, OtaProcessService.class.getName());
                g.e(className, "setClassName(...)");
                if (this.$autoCreate) {
                    try {
                        applicationContext.startService(className);
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
                try {
                    objA = Boolean.valueOf(applicationContext.bindService(className, OtaProcessClient.connection, this.$autoCreate ? 1 : 0));
                } catch (Throwable th2) {
                    objA = kotlin.c.a(th2);
                }
                Boolean bool = Boolean.FALSE;
                boolean z = objA instanceof Result.Failure;
                Object obj2 = objA;
                if (z) {
                    obj2 = bool;
                }
                if (((Boolean) obj2).booleanValue()) {
                    this.L$0 = coroutineScope;
                    this.L$1 = applicationContext;
                    this.label = 1;
                    if (DelayKt.delay(30000L, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                try {
                    applicationContext.unbindService(OtaProcessClient.connection);
                    n nVar = n.f10413a;
                } catch (Throwable th3) {
                    kotlin.c.a(th3);
                }
                OtaProcessClient.bindState.fail(this.$bindToken);
                return n.f10413a;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                context = (Context) this.L$0;
                kotlin.c.b(obj);
                OtaProcessClient otaProcessClient = OtaProcessClient.INSTANCE;
                g.c(context);
                otaProcessClient.reconcileInterruptedAsync(context, "bind_watchdog_retry");
                return n.f10413a;
            }
            applicationContext = (Context) this.L$1;
            kotlin.c.b(obj);
            if (OtaProcessClient.bindState.claimTimeout(this.$bindToken, OtaProcessClient.controlRef.get() != null)) {
                AIEngineLogger.w(LogModule.OTA, OtaProcessClient.TAG, "bind watchdog: not connected in 30000ms, unbind & reset for retry");
                try {
                    applicationContext.unbindService(OtaProcessClient.connection);
                    n nVar2 = n.f10413a;
                } catch (Throwable th4) {
                    kotlin.c.a(th4);
                }
                synchronized (OtaProcessClient.INSTANCE) {
                    try {
                        CompletableDeferred completableDeferred = OtaProcessClient.pendingConnect;
                        if (completableDeferred != null) {
                            Job.DefaultImpls.cancel$default(completableDeferred, null, 1, null);
                        }
                        OtaProcessClient.pendingConnect = null;
                        n nVar3 = n.f10413a;
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
                long jRebindBackoffMs = OtaProcessClientKt.rebindBackoffMs(OtaProcessClient.consecutiveBindTimeouts.incrementAndGet(), 5000L, 300000L);
                this.L$0 = applicationContext;
                this.L$1 = null;
                this.label = 2;
                if (DelayKt.delay(jRebindBackoffMs, this) != coroutineSingletons) {
                    context = applicationContext;
                    OtaProcessClient otaProcessClient2 = OtaProcessClient.INSTANCE;
                    g.c(context);
                    otaProcessClient2.reconcileInterruptedAsync(context, "bind_watchdog_retry");
                }
                return coroutineSingletons;
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessClient$ensureConnected$3", f = "OtaProcessClient.kt", l = {307}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessClient$ensureConnected$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<CoroutineScope, qb.b<? super IOtaProcessControl>, Object> {
        final /* synthetic */ CompletableDeferred<IOtaProcessControl> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CompletableDeferred<IOtaProcessControl> completableDeferred, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
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
            CompletableDeferred<IOtaProcessControl> completableDeferred = this.$deferred;
            this.label = 1;
            Object objAwait = completableDeferred.await(this);
            return objAwait == coroutineSingletons ? coroutineSingletons : objAwait;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super IOtaProcessControl> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessClient$reconcileInterruptedAsync$1", f = "OtaProcessClient.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessClient$reconcileInterruptedAsync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04031 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $trigger;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04031(Context context, String str, qb.b<? super C04031> bVar) {
            super(2, bVar);
            this.$context = context;
            this.$trigger = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04031(this.$context, this.$trigger, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            InterruptedResumeGuard interruptedResumeGuard = InterruptedResumeGuard.INSTANCE;
            Context applicationContext = this.$context.getApplicationContext();
            g.e(applicationContext, "getApplicationContext(...)");
            interruptedResumeGuard.reconcile(applicationContext, this.$trigger);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04031) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessClient$withDownloadControl$2", f = "OtaProcessClient.kt", l = {290}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessClient$withDownloadControl$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ l<IOtaProcessControl, Boolean> $block;
        final /* synthetic */ Context $ctx;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Context context, l<? super IOtaProcessControl, Boolean> lVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$ctx = context;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$ctx, this.$block, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnonymousClass2 anonymousClass2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                OtaProcessClient otaProcessClient = OtaProcessClient.INSTANCE;
                Context context = this.$ctx;
                this.L$0 = coroutineScope;
                this.label = 1;
                anonymousClass2 = this;
                obj = OtaProcessClient.ensureConnected$default(otaProcessClient, context, 0L, anonymousClass2, 2, null);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                anonymousClass2 = this;
            }
            IOtaProcessControl iOtaProcessControl = (IOtaProcessControl) obj;
            if (iOtaProcessControl == null) {
                return n.f10413a;
            }
            try {
                anonymousClass2.$block.invoke(iOtaProcessControl).getClass();
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        MutableStateFlow<Map<String, OtaStateSnapshot>> MutableStateFlow = StateFlowKt.MutableStateFlow(kotlin.collections.b.d0());
        _ipcState = MutableStateFlow;
        ipcState = MutableStateFlow;
        connection = new ServiceConnection() { // from class: com.stepos.core.ota.process.OtaProcessClient$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                OtaProcessClient.bindState.invalidate();
                OtaProcessClient.consecutiveBindTimeouts.set(0);
                IOtaProcessControl iOtaProcessControlAsInterface = IOtaProcessControl.Stub.asInterface(iBinder);
                OtaProcessClient.controlRef.set(iOtaProcessControlAsInterface);
                synchronized (OtaProcessClient.INSTANCE) {
                    try {
                        CompletableDeferred completableDeferred = OtaProcessClient.pendingConnect;
                        if (completableDeferred != null) {
                            g.c(iOtaProcessControlAsInterface);
                            completableDeferred.complete(iOtaProcessControlAsInterface);
                        }
                        OtaProcessClient.pendingConnect = null;
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    iOtaProcessControlAsInterface.setTaskListener(OtaProcessClient.taskListener);
                    iOtaProcessControlAsInterface.syncAbilityMappings("");
                } catch (Throwable th2) {
                    kotlin.c.a(th2);
                }
                AIEngineLogger.i(LogModule.OTA, "OtaProcessClient", "connected to OtaProcessService");
                Context context = OtaProcessClient.appContext;
                if (context != null) {
                    OtaProcessClient.INSTANCE.reconcileInterruptedAsync(context, "service_connected");
                }
                try {
                    zb.a<n> onConnected2 = OtaProcessClient.INSTANCE.getOnConnected();
                    if (onConnected2 != null) {
                        onConnected2.invoke();
                        n nVar2 = n.f10413a;
                    }
                } catch (Throwable th3) {
                    kotlin.c.a(th3);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OtaProcessClient.bindState.invalidate();
                OtaProcessClient.controlRef.set(null);
                OtaProcessClient otaProcessClient = OtaProcessClient.INSTANCE;
                synchronized (otaProcessClient) {
                    try {
                        CompletableDeferred completableDeferred = OtaProcessClient.pendingConnect;
                        if (completableDeferred != null) {
                            Job.DefaultImpls.cancel$default(completableDeferred, null, 1, null);
                        }
                        OtaProcessClient.pendingConnect = null;
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                otaProcessClient.restoreOnProcessGone("disconnect");
                Context context = OtaProcessClient.appContext;
                if (context != null) {
                    try {
                        context.unbindService(OtaProcessClient.connection);
                    } catch (Throwable th2) {
                        kotlin.c.a(th2);
                    }
                    OtaProcessClient.INSTANCE.reconcileInterruptedAsync(context, "service_disconnected");
                }
            }
        };
        taskListener = new IOtaTaskListener.Stub() { // from class: com.stepos.core.ota.process.OtaProcessClient$taskListener$1
            @Override // com.stepos.core.ota.IOtaTaskListener
            public void onIdleExitRequested() {
                OtaProcessClient.INSTANCE.restoreOnProcessGone("idleExit");
                Context context = OtaProcessClient.appContext;
                if (context == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(OtaProcessClient.scope, null, null, new OtaProcessClient$taskListener$1$onIdleExitRequested$1(context, null), 3, null);
            }

            @Override // com.stepos.core.ota.IOtaTaskListener
            public void onTaskUpdate(String otaId, int i10, int i11, int i12, long j10, long j11, int[] iArr, boolean z) {
                Object value;
                Map map;
                g.f(otaId, "otaId");
                SetBuilder setBuilder = new SetBuilder();
                if (iArr != null) {
                    for (int i13 : iArr) {
                        TriggerSource triggerSource = (TriggerSource) kotlin.collections.a.w0(i13, TriggerSource.getEntries());
                        if (triggerSource != null) {
                            setBuilder.add(triggerSource);
                        }
                    }
                }
                OtaStateSnapshot otaStateSnapshot = new OtaStateSnapshot(otaId, OtaStateCodec.INSTANCE.decodeState(i10, j10, j11), i11, i12, SystemClock.elapsedRealtime(), y.j(setBuilder), null, z, false, false, 832, null);
                MutableStateFlow mutableStateFlow = OtaProcessClient._ipcState;
                do {
                    value = mutableStateFlow.getValue();
                    map = (Map) value;
                } while (!mutableStateFlow.compareAndSet(value, (UserUninstallStore.INSTANCE.contains(otaId) || (otaStateSnapshot.getState() instanceof OtaState.Removed)) ? kotlin.collections.b.h0(otaId, map) : kotlin.collections.b.k0(map, new Pair(otaId, otaStateSnapshot))));
            }
        };
    }

    private OtaProcessClient() {
    }

    private final IOtaProcessControl ctrl() {
        return controlRef.get();
    }

    private final void doBind(Context context, boolean z) {
        Long lTryBegin = bindState.tryBegin(controlRef.get() != null);
        if (lTryBegin != null) {
            long jLongValue = lTryBegin.longValue();
            ensureCallbackBridge();
            appContext = context.getApplicationContext();
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(context, z, jLongValue, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean download$lambda$14(String str, TriggerSource triggerSource, String str2, Set set, boolean z, IOtaProcessControl it) {
        g.f(it, "it");
        return it.download(str, triggerSource.ordinal(), str2, (String[]) set.toArray(new String[0]), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ensureCallbackBridge$lambda$5(String otaId) {
        g.f(otaId, "otaId");
        return ModelPathStore.INSTANCE.getPath(otaId);
    }

    public static /* synthetic */ Object ensureConnected$default(OtaProcessClient otaProcessClient, Context context, long j10, qb.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 8000;
        }
        return otaProcessClient.ensureConnected(context, j10, bVar);
    }

    public static /* synthetic */ boolean pause$default(OtaProcessClient otaProcessClient, String str, PauseReason pauseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pauseReason = PauseReason.USER;
        }
        return otaProcessClient.pause(str, pauseReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreOnProcessGone(String str) {
        Map<String, OtaStateSnapshot> value;
        Map<String, OtaStateSnapshot> snapshots = OtaTaskSnapshotStore.INSTANCE.toSnapshots();
        Set<String> setKeySet = _ipcState.getValue().keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (UserUninstallStore.INSTANCE.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        Set setR0 = kotlin.collections.a.R0(arrayList);
        Set<String> setKeySet2 = snapshots.keySet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setKeySet2) {
            if (UserUninstallStore.INSTANCE.contains((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        LinkedHashSet linkedHashSetW = x.W(setR0, arrayList2);
        MutableStateFlow<Map<String, OtaStateSnapshot>> mutableStateFlow = _ipcState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OtaSnapshotMerge.INSTANCE.mergeForProcessExit(value, snapshots, linkedHashSetW)));
        LogModule logModule = LogModule.OTA;
        int size = _ipcState.getValue().size();
        int size2 = snapshots.size();
        StringBuilder sbF = e.f("process gone (", str, "): merged live+disk snapshots, keys=", size, " disk=");
        sbF.append(size2);
        AIEngineLogger.w(logModule, TAG, sbF.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resume$lambda$16(String str, TriggerSource triggerSource, IOtaProcessControl it) {
        g.f(it, "it");
        return it.resume(str, triggerSource.ordinal());
    }

    private final boolean withDownloadControl(l<? super IOtaProcessControl, Boolean> lVar) {
        Object objA;
        Context contextRequireAppContext = OtaRuntime.INSTANCE.requireAppContext();
        OtaProcessBootstrap.INSTANCE.ensureRemoteProcess(contextRequireAppContext);
        IOtaProcessControl iOtaProcessControlCtrl = ctrl();
        if (iOtaProcessControlCtrl == null) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass2(contextRequireAppContext, lVar, null), 3, null);
            return true;
        }
        try {
            objA = (Boolean) lVar.invoke(iOtaProcessControlCtrl);
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

    public final boolean attach(String abilityId, TriggerSource source) {
        Object objA;
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Boolean.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.attachSource(abilityId, source.ordinal()) : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void bindAsync(Context context) {
        g.f(context, "context");
        doBind(context, true);
    }

    public final void bindIfAlive(Context context) {
        g.f(context, "context");
        doBind(context, false);
    }

    public final CallbackSubscriber callbacks() {
        CallbackSubscriber callbackSubscriber = callbackBridge;
        if (callbackSubscriber != null) {
            return callbackSubscriber;
        }
        throw new IllegalStateException("OtaProcessClient not initialized");
    }

    public final boolean cancel(String abilityId) {
        Object objA;
        Map<String, OtaStateSnapshot> value;
        LinkedHashMap linkedHashMapO0;
        g.f(abilityId, "abilityId");
        try {
            String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(abilityId);
            LinkedHashSet linkedHashSetV = x.V(x.V(OtaBucketLegacy.INSTANCE.allBucketIds(strResolveAnyToOta), strResolveAnyToOta), abilityId);
            Iterator it = linkedHashSetV.iterator();
            while (it.hasNext()) {
                OtaTaskSnapshotStore.INSTANCE.clear((String) it.next());
            }
            MutableStateFlow<Map<String, OtaStateSnapshot>> mutableStateFlow = _ipcState;
            do {
                value = mutableStateFlow.getValue();
                Map<String, OtaStateSnapshot> map = value;
                g.f(map, "<this>");
                linkedHashMapO0 = kotlin.collections.b.o0(map);
                Set setKeySet = linkedHashMapO0.keySet();
                g.f(setKeySet, "<this>");
                setKeySet.removeAll(linkedHashSetV);
            } while (!mutableStateFlow.compareAndSet(value, kotlin.collections.b.i0(linkedHashMapO0)));
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Boolean.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.cancel(abilityId) : true);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean checkUpdate(String abilityId, TriggerSource source) {
        Object objA;
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Boolean.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.checkUpdate(abilityId, source.ordinal()) : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean detach(String abilityId, String clientTag) {
        Object objA;
        g.f(abilityId, "abilityId");
        g.f(clientTag, "clientTag");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Boolean.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.detach(abilityId, clientTag) : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean download(final String abilityId, final TriggerSource source, final String str, final Set<String> plugins, final boolean z) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        g.f(plugins, "plugins");
        return withDownloadControl(new l() { // from class: com.stepos.core.ota.process.a
            @Override // zb.l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OtaProcessClient.download$lambda$14(abilityId, source, str, plugins, z, (IOtaProcessControl) obj));
            }
        });
    }

    public final void ensureCallbackBridge() {
        Map<String, OtaStateSnapshot> value;
        Map<String, OtaStateSnapshot> map;
        if (callbackBridge != null) {
            return;
        }
        MutableStateFlow<Map<String, OtaStateSnapshot>> mutableStateFlow = _ipcState;
        if (mutableStateFlow.getValue().isEmpty()) {
            do {
                value = mutableStateFlow.getValue();
                map = value;
                if (map.isEmpty()) {
                    Map<String, OtaStateSnapshot> snapshots = OtaTaskSnapshotStore.INSTANCE.toSnapshots();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, OtaStateSnapshot> entry : snapshots.entrySet()) {
                        if (UserUninstallPolicy.INSTANCE.keepSnapshotKey(UserUninstallStore.INSTANCE.contains(entry.getKey()))) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    map = linkedHashMap;
                }
            } while (!mutableStateFlow.compareAndSet(value, map));
        }
        callbackBridge = new CallbackSubscriber(scope, _ipcState, new com.stepos.core.common.telemetry.b(20));
    }

    public final Object ensureConnected(Context context, long j10, qb.b<? super IOtaProcessControl> bVar) {
        CompletableDeferred<IOtaProcessControl> completableDeferredCompletableDeferred$default;
        IOtaProcessControl iOtaProcessControl = controlRef.get();
        if (iOtaProcessControl != null) {
            return iOtaProcessControl;
        }
        synchronized (this) {
            completableDeferredCompletableDeferred$default = pendingConnect;
            if (completableDeferredCompletableDeferred$default == null) {
                completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                pendingConnect = completableDeferredCompletableDeferred$default;
            }
        }
        bindAsync(context);
        return TimeoutKt.withTimeoutOrNull(j10, new AnonymousClass3(completableDeferredCompletableDeferred$default, null), bVar);
    }

    public final StateFlow<Map<String, OtaStateSnapshot>> getIpcState() {
        return ipcState;
    }

    public final zb.a<n> getOnConnected() {
        return onConnected;
    }

    public final int getProgress(String abilityId) {
        Object objA;
        g.f(abilityId, "abilityId");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Integer.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.getProgress(abilityId) : 0);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    public final int getStatus(String abilityId) {
        Object objA;
        g.f(abilityId, "abilityId");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Integer.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.getStatus(abilityId) : 0);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    public final boolean pause(String abilityId, PauseReason reason) {
        Object objA;
        g.f(abilityId, "abilityId");
        g.f(reason, "reason");
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            objA = Boolean.valueOf(iOtaProcessControlCtrl != null ? iOtaProcessControlCtrl.pauseWithReason(abilityId, reason.ordinal()) : true);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.TRUE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void persistAndShutdownOta() {
        Object objA;
        Object objA2;
        try {
            Context context = appContext;
            if (context != null) {
                ModelDownloadNotifier modelDownloadNotifier = new ModelDownloadNotifier(context);
                Iterator<T> it = snapshot().keySet().iterator();
                while (it.hasNext()) {
                    modelDownloadNotifier.dismissForModel((String) it.next());
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "clear notifications on cta withdraw failed", thB);
        }
        try {
            IOtaProcessControl iOtaProcessControlCtrl = ctrl();
            if (iOtaProcessControlCtrl != null) {
                iOtaProcessControlCtrl.requestShutdownPersisting();
                objA2 = n.f10413a;
            } else {
                objA2 = null;
            }
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "persistAndShutdownOta failed", thB2);
        }
    }

    public final void reconcileInterruptedAsync(Context context, String trigger) {
        g.f(context, "context");
        g.f(trigger, "trigger");
        appContext = context.getApplicationContext();
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04031(context, trigger, null), 3, null);
    }

    public final boolean resume(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return withDownloadControl(new f(6, abilityId, source));
    }

    public final void setOnConnected(zb.a<n> aVar) {
        onConnected = aVar;
    }

    public final Map<String, OtaStateSnapshot> snapshot() {
        if (controlRef.get() != null) {
            return _ipcState.getValue();
        }
        Map<String, OtaStateSnapshot> snapshots = OtaTaskSnapshotStore.INSTANCE.toSnapshots();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, OtaStateSnapshot> entry : snapshots.entrySet()) {
            if (UserUninstallPolicy.INSTANCE.keepSnapshotKey(UserUninstallStore.INSTANCE.contains(entry.getKey()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final void syncMappings() {
        try {
            IOtaProcessControl iOtaProcessControl = controlRef.get();
            if (iOtaProcessControl != null) {
                iOtaProcessControl.syncAbilityMappings("");
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }
}
