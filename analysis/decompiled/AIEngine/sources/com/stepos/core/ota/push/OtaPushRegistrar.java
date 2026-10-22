package com.stepos.core.ota.push;

import android.content.Context;
import android.os.Build;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGate;
import com.stepos.core.cta.CtaGatedInitializer;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaRuntime;
import h0.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import mb.l;
import o7.a;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushRegistrar {
    private static final String APP_ID = "154965";
    private static final String APP_KEY = "6116b01ad9154880bc41075fb5e9e5c7";
    public static final OtaPushRegistrar INSTANCE;
    private static final String TAG = "OtaPushRegistrar";
    private static final CtaGatedInitializer ctaInitializer;
    private static final AtomicBoolean pushRegistered;
    private static final CoroutineScope scope;
    private static final AtomicBoolean serverSubscribed;
    private static final AtomicBoolean subscribing;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.OtaPushRegistrar$register$1", f = "OtaPushRegistrar.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.OtaPushRegistrar$register$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ Context $appContext;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.core.ota.push.OtaPushRegistrar$register$1$1", f = "OtaPushRegistrar.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ota.push.OtaPushRegistrar$register$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00631 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
            final /* synthetic */ Context $appContext;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00631(Context context, b<? super C00631> bVar) {
                super(2, bVar);
                this.$appContext = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final b<n> create(Object obj, b<?> bVar) {
                return new C00631(this.$appContext, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                OtaPushRegistrar otaPushRegistrar = OtaPushRegistrar.INSTANCE;
                Context context = this.$appContext;
                g.c(context);
                otaPushRegistrar.registerPushSdk(context, OtaPushRegistrar.APP_ID, OtaPushRegistrar.APP_KEY);
                return n.f10413a;
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
                return ((C00631) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.core.ota.push.OtaPushRegistrar$register$1$2", f = "OtaPushRegistrar.kt", l = {123}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ota.push.OtaPushRegistrar$register$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
            final /* synthetic */ Context $appContext;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Context context, b<? super AnonymousClass2> bVar) {
                super(2, bVar);
                this.$appContext = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final b<n> create(Object obj, b<?> bVar) {
                return new AnonymousClass2(this.$appContext, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    OtaPushRegistrar otaPushRegistrar = OtaPushRegistrar.INSTANCE;
                    Context context = this.$appContext;
                    g.c(context);
                    this.label = 1;
                    if (otaPushRegistrar.subscribeServer(context, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
                return n.f10413a;
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
                return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$appContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$appContext, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00631(this.$appContext, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$appContext, null), 3, null);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.OtaPushRegistrar", f = "OtaPushRegistrar.kt", l = {204}, m = "subscribeServer")
    /* renamed from: com.stepos.core.ota.push.OtaPushRegistrar$subscribeServer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04091 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C04091(b<? super C04091> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaPushRegistrar.this.subscribeServer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.OtaPushRegistrar$unregister$1", f = "OtaPushRegistrar.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.OtaPushRegistrar$unregister$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04101 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ Context $appContext;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04101(Context context, b<? super C04101> bVar) {
            super(2, bVar);
            this.$appContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C04101 c04101 = new C04101(this.$appContext, bVar);
            c04101.L$0 = obj;
            return c04101;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Context context = this.$appContext;
            try {
                if ("StepX".equalsIgnoreCase(Build.BRAND)) {
                    p7.c cVar = a.C0117a.f10777a.f10772b;
                    cVar.f11458b = OtaPushRegistrar.APP_ID;
                    cVar.f11459c = OtaPushRegistrar.APP_KEY;
                    cVar.c(context);
                } else {
                    s7.a.e("5.0.7", "please invoke unRegister on device Build-in StepOS");
                }
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, OtaPushRegistrar.TAG, "PushSDK unRegister failed", thB);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C04101) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        OtaPushRegistrar otaPushRegistrar = new OtaPushRegistrar();
        INSTANCE = otaPushRegistrar;
        pushRegistered = new AtomicBoolean(false);
        serverSubscribed = new AtomicBoolean(false);
        subscribing = new AtomicBoolean(false);
        scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        ctaInitializer = new CtaGatedInitializer("ota-push", CtaGate.CTA_AND_SERVICE, new OtaPushRegistrar$ctaInitializer$1(otaPushRegistrar), new OtaPushRegistrar$ctaInitializer$2(otaPushRegistrar), new com.stepos.core.common.telemetry.b(21));
    }

    private OtaPushRegistrar() {
    }

    private final void cancelActivePushDownloads() {
        Object objA;
        try {
            Set setS0 = l.s0(new TriggerSource[]{TriggerSource.PUSH_FORCE, TriggerSource.PUSH, TriggerSource.SILENT});
            for (Map.Entry<String, OtaStateSnapshot> entry : OtaRuntime.INSTANCE.snapshot().entrySet()) {
                String key = entry.getKey();
                OtaStateSnapshot value = entry.getValue();
                if (value.getState().isActive() && !value.getSources().contains(TriggerSource.USER)) {
                    Set<TriggerSource> sources = value.getSources();
                    if (!(sources instanceof Collection) || !sources.isEmpty()) {
                        Iterator<T> it = sources.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (setS0.contains((TriggerSource) it.next())) {
                                AIEngineLogger.i(LogModule.OTA, TAG, "cancel active push download otaId=" + key + " sources=" + value.getSources());
                                OtaRuntime.INSTANCE.dispatcher().cancel(key);
                                break;
                            }
                        }
                    }
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "cancelActivePushDownloads failed", thB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n ctaInitializer$lambda$0(Context it) {
        g.f(it, "it");
        ModelAutoUpdateManager.INSTANCE.pauseAllOnServiceDisabled("service_switch_off");
        return n.f10413a;
    }

    private final void diag(String str) {
        e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCtaGranted(Context context) {
        registerIfCtaGranted(context);
        ModelAutoUpdateManager.INSTANCE.resumeSilentPaused("cta_grant");
        OtaDeepBinderServiceImpl.Companion.rescanUpdatablePendingAfterRegrant(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerPushSdk(Context context, String str, String str2) {
        Object objA;
        if (!pushRegistered.compareAndSet(false, true)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "PushSDK register skipped: already done in this process");
            diag("PushSDK register skipped: already registered");
            return;
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "PushSDK register: appId=" + str);
        diag("PushSDK register start appId=" + str);
        try {
            n7.a.a(context, str, str2);
            diag("PushSDK register invoked appId=" + str);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            pushRegistered.set(false);
            AIEngineLogger.e(LogModule.OTA, TAG, "PushSDK register failed", thB);
            OtaPushRegistrar otaPushRegistrar = INSTANCE;
            String simpleName = thB.getClass().getSimpleName();
            String message = thB.getMessage();
            StringBuilder sbS = ai.onnxruntime.a.s("PushSDK register failed appId=", str, " err=", simpleName, ":");
            sbS.append(message);
            otaPushRegistrar.diag(sbS.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:12:0x003c, B:34:0x00a9, B:35:0x00d5, B:37:0x00f9, B:30:0x008c, B:39:0x00fe, B:40:0x010c, B:27:0x0075), top: B:45:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:12:0x003c, B:34:0x00a9, B:35:0x00d5, B:37:0x00f9, B:30:0x008c, B:39:0x00fe, B:40:0x010c, B:27:0x0075), top: B:45:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010c A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:12:0x003c, B:34:0x00a9, B:35:0x00d5, B:37:0x00f9, B:30:0x008c, B:39:0x00fe, B:40:0x010c, B:27:0x0075), top: B:45:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008a -> B:35:0x00d5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a3 -> B:34:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object subscribeServer(android.content.Context r14, qb.b<? super lb.n> r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.OtaPushRegistrar.subscribeServer(android.content.Context, qb.b):java.lang.Object");
    }

    public final CtaGatedInitializer getCtaInitializer() {
        return ctaInitializer;
    }

    public final void register(Context context) {
        g.f(context, "context");
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "register skipped: :ota process");
            diag("register skipped: ota process");
        } else {
            Context applicationContext = context.getApplicationContext();
            diag("register: launch PushSDK register + server subscribe");
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(applicationContext, null), 3, null);
        }
    }

    public final void registerIfCtaGranted(Context context) {
        g.f(context, "context");
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "register skipped: :ota process");
            diag("register skipped: ota process");
            return;
        }
        if (!CTAPermissionManager.INSTANCE.isModelOtaAllowed()) {
            AIEngineLogger.i(LogModule.OTA, TAG, "register skipped: CTA not granted");
            diag("register skipped: CTA not granted");
            return;
        }
        diag("registerIfCtaGranted: start register + condition watcher + worker");
        register(context);
        ModelAutoUpdateManager modelAutoUpdateManager = ModelAutoUpdateManager.INSTANCE;
        modelAutoUpdateManager.start();
        ModelUpdateConditionManager.INSTANCE.start(context, modelAutoUpdateManager);
        ModelAutoUpdateWorkScheduler modelAutoUpdateWorkScheduler = ModelAutoUpdateWorkScheduler.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        g.e(applicationContext, "getApplicationContext(...)");
        modelAutoUpdateWorkScheduler.schedulePeriodic(applicationContext);
        diag("registerIfCtaGranted: trigger startup discovery");
        ModelAutoUpdateManager.tryRun$default(modelAutoUpdateManager, "registrar_start", false, 2, null);
    }

    public final void unregister(Context context) {
        g.f(context, "context");
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        ModelUpdateConditionManager modelUpdateConditionManager = ModelUpdateConditionManager.INSTANCE;
        g.c(applicationContext);
        modelUpdateConditionManager.stop(applicationContext);
        ModelAutoUpdateWorkScheduler.INSTANCE.cancelAll(applicationContext);
        PendingAutoUpdateStore.INSTANCE.clearAll();
        cancelActivePushDownloads();
        ModelAutoUpdateManager.INSTANCE.pauseAllOnServiceDisabled("cta_revoked");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04101(applicationContext, null), 3, null);
        pushRegistered.set(false);
        serverSubscribed.set(false);
        AIEngineLogger.i(LogModule.OTA, TAG, "unregistered: push off + pending cleared + active downloads stopped");
    }
}
