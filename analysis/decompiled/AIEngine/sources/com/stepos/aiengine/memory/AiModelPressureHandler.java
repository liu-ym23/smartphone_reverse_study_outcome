package com.stepos.aiengine.memory;

import android.util.Log;
import b6.e;
import b6.g;
import b6.h;
import b7.r;
import com.stepos.aicgroup.memory.MemoryPressureCallback;
import com.stepos.aicgroup.memory.MemorySnapshot;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.model.ReleaseReason;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.ota.confirmui.i;
import gc.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import mb.m;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiModelPressureHandler implements MemoryPressureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final com.stepos.aiengine.memory.a f5784a;

    /* renamed from: b, reason: collision with root package name */
    public final g f5785b;

    /* renamed from: c, reason: collision with root package name */
    public final l<String, Set<Integer>> f5786c;

    /* renamed from: d, reason: collision with root package name */
    public final a f5787d;

    /* renamed from: e, reason: collision with root package name */
    public final zb.a<Long> f5788e;

    /* renamed from: f, reason: collision with root package name */
    public final h f5789f;

    /* renamed from: g, reason: collision with root package name */
    public final b6.a f5790g;
    public final zb.a<Integer> h;

    /* renamed from: i, reason: collision with root package name */
    public final zb.a<Integer> f5791i;

    /* renamed from: j, reason: collision with root package name */
    public final zb.a<Boolean> f5792j;

    /* renamed from: k, reason: collision with root package name */
    public final l<String, TaskPriority> f5793k;

    /* renamed from: l, reason: collision with root package name */
    public final p<Long, qb.b<? super n>, Object> f5794l;

    /* renamed from: m, reason: collision with root package name */
    public final e f5795m;

    /* renamed from: n, reason: collision with root package name */
    public final CoroutineScope f5796n;

    /* renamed from: o, reason: collision with root package name */
    public long f5797o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5798a;

        static {
            int[] iArr = new int[PressureLevel.values().length];
            try {
                iArr[PressureLevel.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PressureLevel.ULTRA_LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5798a = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.aiengine.memory.AiModelPressureHandler$onPressureLevelChanged$1", f = "AiModelPressureHandler.kt", l = {169}, m = "invokeSuspend")
    /* renamed from: com.stepos.aiengine.memory.AiModelPressureHandler$onPressureLevelChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5807a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PressureLevel f5809c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MemorySnapshot f5810d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f5811e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PressureLevel pressureLevel, MemorySnapshot memorySnapshot, long j10, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.f5809c = pressureLevel;
            this.f5810d = memorySnapshot;
            this.f5811e = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AiModelPressureHandler.this.new AnonymousClass1(this.f5809c, this.f5810d, this.f5811e, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f5807a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                this.f5807a = 1;
                if (AiModelPressureHandler.this.b(this.f5809c, this.f5810d, this.f5811e, this) == coroutineSingletons) {
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
    }

    public AiModelPressureHandler() {
        throw null;
    }

    public AiModelPressureHandler(com.stepos.aiengine.memory.a stateMachine, g gVar, l lVar, i iVar, h hVar, b6.a aVar, a9.a aVar2, a9.b bVar, a9.a aVar3, l lVar2, p pVar, e eVar) {
        com.stepos.cpuset.b bVar2 = new com.stepos.cpuset.b(3);
        d coroutineContext = CoroutineDispatcher.limitedParallelism$default(Dispatchers.getDefault(), 1, null, 2, null).plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        kotlin.jvm.internal.g.f(stateMachine, "stateMachine");
        kotlin.jvm.internal.g.f(coroutineContext, "coroutineContext");
        this.f5784a = stateMachine;
        this.f5785b = gVar;
        this.f5786c = lVar;
        this.f5787d = iVar;
        this.f5788e = bVar2;
        this.f5789f = hVar;
        this.f5790g = aVar;
        this.h = aVar2;
        this.f5791i = bVar;
        this.f5792j = aVar3;
        this.f5793k = lVar2;
        this.f5794l = pVar;
        this.f5795m = eVar;
        this.f5796n = CoroutineScopeKt.CoroutineScope(coroutineContext);
        this.f5797o = -4611686018427387904L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(PressureLevel pressureLevel, ReleaseReason releaseReason, String str) {
        String string;
        Object objA;
        Object objA2;
        int iIntValue;
        int rssTargetWithFgMb = this.f5792j.invoke().booleanValue() ? EngineRuntimeConfig.INSTANCE.getSnapshot().getRssTargetWithFgMb() : EngineRuntimeConfig.INSTANCE.getSnapshot().getRssTargetBgOnlyMb();
        int[] iArr = b.f5798a;
        int i10 = iArr[pressureLevel.ordinal()];
        boolean z = true;
        int iMin = i10 != 1 ? i10 != 2 ? rssTargetWithFgMb : Math.min(rssTargetWithFgMb, EngineRuntimeConfig.INSTANCE.getSnapshot().getAbsoluteTargetUltraLowMb()) : Math.min(rssTargetWithFgMb, EngineRuntimeConfig.INSTANCE.getSnapshot().getAbsoluteTargetLowMb());
        int iIntValue2 = this.h.invoke().intValue();
        if (iIntValue2 >= 0) {
            EngineMetrics.f6243t.set(iIntValue2);
        }
        EngineMetrics.f6244u.set(rssTargetWithFgMb);
        if (iIntValue2 >= 0 && iIntValue2 < iMin) {
            EngineMetrics.h.incrementAndGet();
            if (o.k0(str, "camera", false)) {
                EngineMetrics.B.incrementAndGet();
            }
            StringBuilder sbD = h0.e.d(iIntValue2, "[memory] rss ", iMin, "MB < gate ", "MB -> skip evict (");
            sbD.append(str);
            sbD.append(":");
            sbD.append(pressureLevel);
            sbD.append(")");
            Log.i("AiModelPressureHandler", sbD.toString());
            return 0;
        }
        int i11 = iArr[pressureLevel.ordinal()];
        (i11 != 1 ? i11 != 2 ? EngineMetrics.f6245v : EngineMetrics.f6247x : EngineMetrics.f6246w).incrementAndGet();
        if (iIntValue2 >= 0) {
            StringBuilder sbD2 = h0.e.d(iIntValue2, "[memory] rss ", iMin, "MB > gate ", "MB (+");
            h0.e.h(iIntValue2 - iMin, "MB over) -> evict (", str, ":", sbD2);
            sbD2.append(pressureLevel);
            sbD2.append(")");
            string = sbD2.toString();
        } else {
            StringBuilder sbE = h0.e.e("[memory] rss read failed (", iIntValue2, "), fail-open -> evict (", str, ":");
            sbE.append(pressureLevel);
            sbE.append(")");
            string = sbE.toString();
        }
        Log.i("AiModelPressureHandler", string);
        try {
            objA = this.f5785b.invoke();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w("AiModelPressureHandler", "candidatesProvider threw: " + thB.getMessage(), thB);
            return 0;
        }
        List<r> list = (List) objA;
        if (list.isEmpty()) {
            Log.i("AiModelPressureHandler", "[memory] " + str + " " + pressureLevel + ": no candidates (nothing loaded / all pinned)");
            return 0;
        }
        int i12 = pressureLevel == PressureLevel.ULTRA_LOW ? 1000 : 100;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        for (r rVar : list) {
            arrayList.add(new Pair(rVar, Integer.valueOf(this.f5793k.invoke(rVar.getModelId()).a())));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            boolean z3 = z;
            if (((Number) ((Pair) obj).f9986b).intValue() < i12) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
            z = z3;
        }
        boolean z10 = z;
        if (!arrayList3.isEmpty()) {
            EngineMetrics.f6233i.addAndGet(arrayList3.size());
            ArrayList arrayList4 = new ArrayList(m.Z(arrayList3, 10));
            int size2 = arrayList3.size();
            int i14 = 0;
            while (i14 < size2) {
                Object obj2 = arrayList3.get(i14);
                i14++;
                arrayList4.add(((r) ((Pair) obj2).f9985a).getModelId());
            }
            Log.i("AiModelPressureHandler", "[memory] tier filter: skip " + arrayList4 + " (score>=" + i12 + ")");
        }
        if (arrayList2.isEmpty()) {
            return 0;
        }
        com.stepos.core.common.telemetry.b bVar = new com.stepos.core.common.telemetry.b(23);
        com.stepos.core.common.cloud.d dVar = new com.stepos.core.common.cloud.d(25);
        final l[] lVarArr = new l[2];
        lVarArr[0] = bVar;
        lVarArr[z10 ? 1 : 0] = dVar;
        List listI0 = kotlin.collections.a.I0(arrayList2, new Comparator() { // from class: ob.a
            @Override // java.util.Comparator
            public final int compare(Object obj3, Object obj4) {
                for (l lVar : lVarArr) {
                    int iA = b.a((Comparable) lVar.invoke(obj3), (Comparable) lVar.invoke(obj4));
                    if (iA != 0) {
                        return iA;
                    }
                }
                return 0;
            }
        });
        ArrayList arrayList5 = new ArrayList(m.Z(listI0, 10));
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            arrayList5.add((r) ((Pair) it.next()).f9985a);
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f10074a = Integer.MAX_VALUE;
        try {
            objA2 = Integer.valueOf(((i) this.f5787d).b(arrayList5, releaseReason, new f6.a(this, ref$IntRef, iMin)));
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            Log.w("AiModelPressureHandler", "evictRunner threw: " + thB2.getMessage(), thB2);
        }
        boolean z11 = objA2 instanceof Result.Failure;
        if (!z11 && ((Number) objA2).intValue() > 0 && iIntValue2 >= 0 && (iIntValue = this.f5791i.invoke().intValue()) >= 0 && iIntValue <= iIntValue2) {
            EngineMetrics.f6248y.set(iIntValue2 - iIntValue);
        }
        if (z11) {
            objA2 = 0;
        }
        return ((Number) objA2).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0277 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.stepos.aicgroup.memory.PressureLevel r18, com.stepos.aicgroup.memory.MemorySnapshot r19, long r20, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.memory.AiModelPressureHandler.b(com.stepos.aicgroup.memory.PressureLevel, com.stepos.aicgroup.memory.MemorySnapshot, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void c(long j10) {
        if (j10 - this.f5797o < TimeUnit.MILLISECONDS.toNanos(EngineRuntimeConfig.INSTANCE.getSnapshot().getPressureNormalCooldownMs())) {
            return;
        }
        this.f5797o = j10;
        int iA = a(PressureLevel.NORMAL, ReleaseReason.f6339c, "normal-budget");
        if (iA > 0) {
            Log.i("AiModelPressureHandler", "[memory] NORMAL budget release: released=" + iA);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.aiengine.memory.AiModelPressureHandler$runBgCancel$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.aiengine.memory.AiModelPressureHandler$runBgCancel$1 r0 = (com.stepos.aiengine.memory.AiModelPressureHandler$runBgCancel$1) r0
            int r1 = r0.f5814c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5814c = r1
            goto L18
        L13:
            com.stepos.aiengine.memory.AiModelPressureHandler$runBgCancel$1 r0 = new com.stepos.aiengine.memory.AiModelPressureHandler$runBgCancel$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f5812a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f5814c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)     // Catch: java.lang.Throwable -> L54
            goto L51
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.c.b(r7)
            zb.p<java.lang.Long, qb.b<? super lb.n>, java.lang.Object> r6 = r6.f5794l
            if (r6 != 0) goto L39
            lb.n r6 = lb.n.f10413a
            return r6
        L39:
            com.stepos.core.common.runtime.EngineRuntimeConfig r7 = com.stepos.core.common.runtime.EngineRuntimeConfig.INSTANCE     // Catch: java.lang.Throwable -> L54
            com.stepos.core.common.runtime.EngineRuntimeConfig$Snapshot r7 = r7.getSnapshot()     // Catch: java.lang.Throwable -> L54
            long r4 = r7.getUltraLowCancelWaitMs()     // Catch: java.lang.Throwable -> L54
            java.lang.Long r7 = new java.lang.Long     // Catch: java.lang.Throwable -> L54
            r7.<init>(r4)     // Catch: java.lang.Throwable -> L54
            r0.f5814c = r3     // Catch: java.lang.Throwable -> L54
            java.lang.Object r6 = r6.invoke(r7, r0)     // Catch: java.lang.Throwable -> L54
            if (r6 != r1) goto L51
            return r1
        L51:
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L54
            goto L59
        L54:
            r6 = move-exception
            kotlin.Result$Failure r6 = kotlin.c.a(r6)
        L59:
            java.lang.Throwable r6 = kotlin.Result.b(r6)
            if (r6 == 0) goto L76
            java.lang.String r7 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "bgCancelRunner threw: "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "AiModelPressureHandler"
            android.util.Log.w(r0, r7, r6)
        L76:
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.memory.AiModelPressureHandler.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.stepos.aicgroup.memory.MemoryPressureCallback
    public final void onPressureLevelChanged(PressureLevel level, MemorySnapshot snapshot) {
        kotlin.jvm.internal.g.f(level, "level");
        kotlin.jvm.internal.g.f(snapshot, "snapshot");
        BuildersKt__Builders_commonKt.launch$default(this.f5796n, null, null, new AnonymousClass1(level, snapshot, this.f5788e.invoke().longValue(), null), 3, null);
    }
}
