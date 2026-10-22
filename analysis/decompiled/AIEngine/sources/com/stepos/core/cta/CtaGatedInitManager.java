package com.stepos.core.cta;

import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import gc.o;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaGatedInitManager {
    private static final String OTA_PROCESS_SUFFIX = ":ota";
    private static final String TAG = "CtaGatedInitManager";
    private static volatile Context appRef;
    private static volatile boolean bootstrapped;
    private static boolean lastCta;
    private static boolean lastService;
    private static ContentObserver observer;
    private static boolean stateInitialized;
    public static final CtaGatedInitManager INSTANCE = new CtaGatedInitManager();
    private static final LinkedHashMap<String, CtaGatedInitializer> initializers = new LinkedHashMap<>();
    private static final Object lock = new Object();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CtaGate.values().length];
            try {
                iArr[CtaGate.CTA_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CtaGate.CTA_AND_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.cta.CtaGatedInitManager$bootstrap$2", f = "CtaGatedInitManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.cta.CtaGatedInitManager$bootstrap$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ Context $appContext;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$appContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(this.$appContext, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            CtaGatedInitManager ctaGatedInitManager = CtaGatedInitManager.INSTANCE;
            Context context = this.$appContext;
            g.c(context);
            ctaGatedInitManager.evaluate(context);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.cta.CtaGatedInitManager$refresh$1", f = "CtaGatedInitManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.cta.CtaGatedInitManager$refresh$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ Context $appContext;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$appContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass1(this.$appContext, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            CtaGatedInitManager ctaGatedInitManager = CtaGatedInitManager.INSTANCE;
            Context context = this.$appContext;
            g.c(context);
            ctaGatedInitManager.evaluate(context);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private CtaGatedInitManager() {
    }

    private final boolean admitted(CtaGate ctaGate, boolean z, boolean z3) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[ctaGate.ordinal()];
        if (i10 == 1) {
            return z;
        }
        if (i10 == 2) {
            return z && z3;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n bootstrap$lambda$2$lambda$1(Context context) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CtaGatedInitManager$bootstrap$1$1$1(context, null), 3, null);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void evaluate(Context context) {
        Object objA;
        l<Context, n> onServiceDisabled;
        Object objA2;
        Object objA3;
        synchronized (lock) {
            try {
                CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
                boolean zHasCTAPermission = cTAPermissionManager.hasCTAPermission();
                boolean zIsModelServiceEnabled = cTAPermissionManager.isModelServiceEnabled();
                boolean z = lastCta;
                boolean z3 = lastService;
                boolean z10 = stateInitialized;
                if (z10 && zHasCTAPermission == z && zIsModelServiceEnabled == z3) {
                    return;
                }
                lastCta = zHasCTAPermission;
                lastService = zIsModelServiceEnabled;
                boolean z11 = true;
                stateInitialized = true;
                boolean z12 = z10 && z && !zHasCTAPermission;
                if (!z10 || !z3 || zIsModelServiceEnabled || !zHasCTAPermission) {
                    z11 = false;
                }
                for (CtaGatedInitializer ctaGatedInitializer : initializers.values()) {
                    g.e(ctaGatedInitializer, "next(...)");
                    CtaGatedInitializer ctaGatedInitializer2 = ctaGatedInitializer;
                    boolean zAdmitted = !z10 ? false : INSTANCE.admitted(ctaGatedInitializer2.getGate(), z, z3);
                    if (INSTANCE.admitted(ctaGatedInitializer2.getGate(), zHasCTAPermission, zIsModelServiceEnabled) && !zAdmitted) {
                        try {
                            ctaGatedInitializer2.getOnGrant().invoke(context);
                            objA3 = n.f10413a;
                        } catch (Throwable th) {
                            objA3 = kotlin.c.a(th);
                        }
                        Throwable thB = Result.b(objA3);
                        if (thB != null) {
                            AIEngineLogger.e(LogModule.SYSTEM, TAG, ctaGatedInitializer2.getName() + " onGrant failed", thB);
                        }
                    } else if (z12) {
                        l<Context, n> onRevoke = ctaGatedInitializer2.getOnRevoke();
                        if (onRevoke != null) {
                            try {
                                onRevoke.invoke(context);
                                objA = n.f10413a;
                            } catch (Throwable th2) {
                                objA = kotlin.c.a(th2);
                            }
                            Throwable thB2 = Result.b(objA);
                            if (thB2 != null) {
                                AIEngineLogger.e(LogModule.SYSTEM, TAG, ctaGatedInitializer2.getName() + " onRevoke failed", thB2);
                            }
                        }
                    } else if (z11 && ctaGatedInitializer2.getGate() == CtaGate.CTA_AND_SERVICE && (onServiceDisabled = ctaGatedInitializer2.getOnServiceDisabled()) != null) {
                        try {
                            onServiceDisabled.invoke(context);
                            objA2 = n.f10413a;
                        } catch (Throwable th3) {
                            objA2 = kotlin.c.a(th3);
                        }
                        Throwable thB3 = Result.b(objA2);
                        if (thB3 != null) {
                            AIEngineLogger.e(LogModule.SYSTEM, TAG, ctaGatedInitializer2.getName() + " onServiceDisabled failed", thB3);
                        }
                    }
                }
                AIEngineLogger.i(LogModule.SYSTEM, TAG, "evaluate cta=" + zHasCTAPermission + " service=" + zIsModelServiceEnabled + " (was cta=" + z + " service=" + z3 + ")");
                n nVar = n.f10413a;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    private final boolean isMainProcess() {
        Object objA;
        try {
            objA = Application.getProcessName();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        boolean z = false;
        if (str != null && o.e0(str, ":ota", false)) {
            z = true;
        }
        return !z;
    }

    public final void bootstrap(Context context) {
        g.f(context, "context");
        if (!isMainProcess()) {
            AIEngineLogger.i(LogModule.SYSTEM, TAG, "bootstrap skipped: non-main process");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        appRef = applicationContext;
        synchronized (lock) {
            try {
                if (!bootstrapped) {
                    bootstrapped = true;
                    AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
                    g.c(applicationContext);
                    observer = aiEngineSystemSettings.registerSwitchObserver(applicationContext, new c(applicationContext, 0));
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass2(applicationContext, null), 3, null);
    }

    public final void refresh(Context context) {
        g.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        appRef = applicationContext;
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(applicationContext, null), 3, null);
    }

    public final void register(CtaGatedInitializer initializer) {
        g.f(initializer, "initializer");
        synchronized (lock) {
            initializers.put(initializer.getName(), initializer);
            n nVar = n.f10413a;
        }
    }
}
