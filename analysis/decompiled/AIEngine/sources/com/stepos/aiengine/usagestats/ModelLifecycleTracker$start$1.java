package com.stepos.aiengine.usagestats;

import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import h6.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.usagestats.ModelLifecycleTracker$start$1", f = "ModelLifecycleTracker.kt", l = {ErrorCodes.NOT_SET_VERSION_CODE_ERROR, ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelLifecycleTracker$start$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f5931a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5932b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public static final a<T> f5933a = new a<>();

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, b bVar) {
            for (x xVar : ((Map) obj).values()) {
                ConcurrentHashMap<String, Integer> concurrentHashMap = ModelLifecycleTracker.f5929b;
                int i10 = xVar.f9357b;
                String str = xVar.f9356a;
                if (i10 == 6 || i10 == 3) {
                    Integer num = concurrentHashMap.get(str);
                    if (num == null || num.intValue() != i10) {
                        concurrentHashMap.put(str, Integer.valueOf(i10));
                        boolean z = i10 == 6;
                        OtaModelClient.f5871a.getClass();
                        ConcurrentHashMap<String, Boolean> concurrentHashMap2 = OtaModelClient.f5872b;
                        Boolean bool = concurrentHashMap2.get(str);
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                        if (zBooleanValue) {
                            n6.a.f10642a.getClass();
                            n6.a.a("model_update_complete", kotlin.collections.b.g0(new Pair("result", z ? "success" : "fail"), new Pair("model_name", str)));
                        } else {
                            n6.a.f10642a.getClass();
                            n6.a.a("model_download_complete", kotlin.collections.b.g0(new Pair("result", z ? "success" : "fail"), new Pair("model_name", str)));
                        }
                        LogModule logModule = LogModule.SYSTEM;
                        StringBuilder sbS = ai.onnxruntime.a.s("report ", zBooleanValue ? "update" : "download", " otaId=", str, " success=");
                        sbS.append(z);
                        AIEngineLogger.i(logModule, "ModelLifecycleTracker", sbS.toString());
                        concurrentHashMap2.remove(str);
                    }
                } else if (i10 == 2) {
                    concurrentHashMap.remove(str);
                }
            }
            return n.f10413a;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelLifecycleTracker$start$1 modelLifecycleTracker$start$1 = new ModelLifecycleTracker$start$1(2, bVar);
        modelLifecycleTracker$start$1.f5932b = obj;
        return modelLifecycleTracker$start$1;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        ((ModelLifecycleTracker$start$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        return CoroutineSingletons.f10059a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[Catch: all -> 0x0024, PHI: r1
      0x002e: PHI (r1v5 kotlinx.coroutines.CoroutineScope) = 
      (r1v1 kotlinx.coroutines.CoroutineScope)
      (r1v3 kotlinx.coroutines.CoroutineScope)
      (r1v9 kotlinx.coroutines.CoroutineScope)
     binds: [B:14:0x0026, B:25:0x0068, B:6:0x000c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x0024, blocks: (B:15:0x002e, B:18:0x0044, B:10:0x0020), top: B:27:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0068 -> B:15:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.f5931a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r1 = r6.f5932b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.c.b(r7)
            goto L2e
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1c:
            java.lang.Object r1 = r6.f5932b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.c.b(r7)     // Catch: java.lang.Throwable -> L24
            goto L44
        L24:
            r7 = move-exception
            goto L47
        L26:
            kotlin.c.b(r7)
            java.lang.Object r7 = r6.f5932b
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            r1 = r7
        L2e:
            com.stepos.aiengine.modelmanager.OtaModelClient r7 = com.stepos.aiengine.modelmanager.OtaModelClient.f5871a     // Catch: java.lang.Throwable -> L24
            r7.getClass()     // Catch: java.lang.Throwable -> L24
            kotlinx.coroutines.flow.Flow r7 = com.stepos.aiengine.modelmanager.OtaModelClient.l()     // Catch: java.lang.Throwable -> L24
            com.stepos.aiengine.usagestats.ModelLifecycleTracker$start$1$a<T> r4 = com.stepos.aiengine.usagestats.ModelLifecycleTracker$start$1.a.f5933a     // Catch: java.lang.Throwable -> L24
            r6.f5932b = r1     // Catch: java.lang.Throwable -> L24
            r6.f5931a = r3     // Catch: java.lang.Throwable -> L24
            java.lang.Object r7 = r7.collect(r4, r6)     // Catch: java.lang.Throwable -> L24
            if (r7 != r0) goto L44
            goto L6a
        L44:
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L24
            goto L4b
        L47:
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L4b:
            java.lang.Throwable r7 = kotlin.Result.b(r7)
            if (r7 == 0) goto L5e
            com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.SYSTEM
            java.lang.String r5 = "taskStateFlow collect ended, will retry"
            java.lang.Object[] r7 = new java.lang.Object[]{r5, r7}
            java.lang.String r5 = "ModelLifecycleTracker"
            com.stepos.core.common.log.AIEngineLogger.w(r4, r5, r7)
        L5e:
            r6.f5932b = r1
            r6.f5931a = r2
            r4 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r7 != r0) goto L2e
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.usagestats.ModelLifecycleTracker$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
