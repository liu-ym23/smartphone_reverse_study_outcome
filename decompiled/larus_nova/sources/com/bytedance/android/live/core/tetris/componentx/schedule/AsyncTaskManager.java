package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes45.dex */
public final class AsyncTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function1<Continuation<? super Unit>, Object>> f65531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f65532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, AtomicReference<a>> f65533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, CountDownLatch> f65534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, CountDownLatch> f65535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f65536f;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager$a$a, reason: collision with other inner class name */
        public static final class C1076a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1076a f65537a = null;

            static {
                f65537a = new C1076a();
            }

            public C1076a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Exception f65538a;

            public b(Exception r100) {
                Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
                this.f65538a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f65539a = null;

            static {
                f65539a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f65540a = null;

            static {
                f65540a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f65541a = null;

            static {
                f65541a = new e();
            }

            public e() {
            }
        }

        public a() {
        }
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("initSchedulerIntance", "taskName");
        Function1 r100 = (Function1) ((LinkedHashMap) this.f65531a).get("initSchedulerIntance");
        if (r100 == null) goto L16;
        Object r101 = ((LinkedHashMap) this.f65533c).get("initSchedulerIntance");
        Intrinsics.checkNotNull(r101);
        AtomicReference r102 = (AtomicReference) r101;
        a.c r103 = a.c.f65539a;
        a.e r104 = a.e.f65541a;
    L6:
        if (r102.compareAndSet(r103, r104) == true) goto L7;
        if (r102.get() == r103) goto L6;
        boolean r105 = false;
    L11:
        if (r105 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(this.f65536f, null, null, new AsyncTaskManager$startAsync$1(this, "initSchedulerIntance", r100, null), 3, null);
        return;
    L7:
        r105 = true;
        goto L11
    L16:
        throw new IllegalArgumentException("Task initSchedulerIntance not configured");
    }

    public AsyncTaskManager() {
        this.f65531a = new LinkedHashMap();
        this.f65532b = new LinkedHashMap();
        this.f65533c = new LinkedHashMap();
        this.f65534d = new LinkedHashMap();
        this.f65535e = new LinkedHashMap();
        this.f65536f = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final void b(Pair<String, ? extends Function1<? super Continuation<? super Unit>, ? extends Object>>... r100) {
        Intrinsics.checkNotNullParameter(r100, "taskPairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Function1<? super Continuation<? super Unit>, ? extends Object>> r103 = r100[r102];
        String r104 = r103.component1();
        Function1<? super Continuation<? super Unit>, ? extends Object> r105 = r103.component2();
        this.f65531a.put(r104, (Function1<Continuation<? super Unit>, Object>) r105);
        this.f65533c.put(r104, new AtomicReference(a.c.f65539a));
        this.f65534d.put(r104, new CountDownLatch(1));
        this.f65535e.put(r104, new CountDownLatch(1));
        r102 = r102 + 1;
        goto L3
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        BuildersKt.runBlocking$default(null, new AsyncTaskManager$runSync$1(this, r100, null), 1, null);
    }

    public final void e(Pair<String, ? extends List<String>>... r100) {
        Intrinsics.checkNotNullParameter(r100, "dependencyPairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends List<String>> r103 = r100[r102];
        String r104 = r103.component1();
        List<String> r105 = r103.component2();
        this.f65532b.put(r104, r105);
        r102 = r102 + 1;
        goto L3
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cc -> B:52:0x0167). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0121 -> B:19:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0197 -> B:52:0x0167). Please report as a decompilation issue!!! */
    public final Object a(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof AsyncTaskManager$checkAndWaitForDependencies$1) == false) goto L7;
        AsyncTaskManager$checkAndWaitForDependencies$1 r100 = (AsyncTaskManager$checkAndWaitForDependencies$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L17;
        if (r104 == 3) goto L18;
        if (r104 == 4) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Iterator r106 = (Iterator) r100.L$2;
        String r107 = (String) r100.L$1;
        AsyncTaskManager r112 = (AsyncTaskManager) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L41:
        r100.L$0 = r112;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.label = 3;
        if (r112.a(r107, r100) == r103) goto L43;
    L19:
        Iterator r108 = r106;
        String r109 = r107;
    L52:
        r105 = 1;
    L26:
        if (r108.hasNext() == false) goto L63;
        String r113 = (String) r108.next();
        Object r114 = ((LinkedHashMap) r112.f65533c).get(r113);
        Intrinsics.checkNotNull(r114);
        a r115 = (a) ((AtomicReference) r114).get();
        if (Intrinsics.areEqual(r115, a.c.f65539a) == false) goto L33;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r109 + " ， 它的依赖task是 " + r113 + " ，依赖的task的执行状态是 TaskStatus.NOT_STARTED(未开始)");
        r100.L$0 = r112;
        r100.L$1 = r109;
        r100.L$2 = r108;
        r100.label = r105;
        if (r112.d(r113, r100) != r103) goto L52;
        return r103;
    L33:
        if (Intrinsics.areEqual(r115, a.e.f65541a) == false) goto L45;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r109 + " ， 它的依赖task是 " + r113 + " ，依赖的task的执行状态是 TaskStatus.SCHEDULED(正在调度中)");
        r100.L$0 = r112;
        r100.L$1 = r109;
        r100.L$2 = r108;
        r100.label = 2;
        Object r116 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskExecutionStart$2(r112, r113, null), r100);
        if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r116 = Unit.INSTANCE;
    L38:
        if (r116 != r103) goto L40;
        return r103;
    L40:
        r107 = r109;
        r106 = r108;
        goto L41
    L45:
        if (Intrinsics.areEqual(r115, a.d.f65540a) == false) goto L54;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r109 + " ， 它的依赖task是 " + r113 + " ，依赖的task的执行状态是 TaskStatus.RUNNING(正在执行中)");
        r100.L$0 = r112;
        r100.L$1 = r109;
        r100.L$2 = r108;
        r100.label = 4;
        Object r117 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskCompletion$2(r112, r113, null), r100);
        if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        if (r117 != r103) goto L52;
        goto L52
    L50:
        if (Unit.INSTANCE != r103) goto L52;
        return r103;
    L54:
        if ((r115 instanceof a.b) == false) goto L61;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r109 + " ， 它的依赖task是 " + r113 + " ，依赖的task的执行状态是 TaskStatus.FAILED(存在异常)");
        if (r115 != null) goto L60;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager.TaskStatus.FAILED");
    L60:
        throw ((a.b) r115).f65538a;
    L61:
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r109 + " ， 它的依赖task是 " + r113 + " ，依赖的task的执行状态是 TaskStatus.COMPLETED(已完成)");
        goto L52
    L63:
        return Unit.INSTANCE;
    L43:
        return r103;
    L18:
        r106 = (Iterator) r100.L$2;
        r107 = (String) r100.L$1;
        r112 = (AsyncTaskManager) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L19
    L20:
        ResultKt.throwOnFailure(r102);
        r109 = r110;
        List r118 = (List) ((LinkedHashMap) this.f65532b).get(r109);
        if (r118 == null) goto L23;
        r108 = r118.iterator();
        r112 = this;
        goto L26
    L23:
        return Unit.INSTANCE;
    L7:
        r100 = new AsyncTaskManager$checkAndWaitForDependencies$1(this, r111);
        goto L8
    }

    public final Object d(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof AsyncTaskManager$runSyncInternal$1) == false) goto L7;
        AsyncTaskManager$runSyncInternal$1 r100 = (AsyncTaskManager$runSyncInternal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L26;
        if (r103 == 1) goto L25;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L23;
        if (r103 == 4) goto L22;
        if (r103 != 5) goto L21;
        r110 = (String) r100.L$1;
        AsyncTaskManager r104 = (AsyncTaskManager) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L18
    L65:
        Object r113 = ((LinkedHashMap) r104.f65533c).get(r110);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r113);     // Catch: Exception -> L18
        ((AtomicReference) r113).set(a.C1076a.f65537a);     // Catch: Exception -> L18
        Object r114 = ((LinkedHashMap) r104.f65534d).get(r110);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r114);     // Catch: Exception -> L18
        ((CountDownLatch) r114).countDown();     // Catch: Exception -> L18
    L79:
        return Unit.INSTANCE;
    L18:
        e = e;
        AsyncTaskManager r105 = r104;
    L69:
        Object r106 = ((LinkedHashMap) r105.f65533c).get(r110);
        Intrinsics.checkNotNull(r106);
        ((AtomicReference) r106).set(new a.b(e));
        Object r115 = ((LinkedHashMap) r105.f65534d).get(r110);
        Intrinsics.checkNotNull(r115);
        ((CountDownLatch) r115).countDown();
        throw e;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Function1 r116 = (Function1) r100.L$2;
        String r107 = (String) r100.L$1;
        r105 = (AsyncTaskManager) r100.L$0;
        ResultKt.throwOnFailure(r112);
        Function1 r117 = r116;
        r110 = r107;
    L60:
        Object r108 = ((LinkedHashMap) r105.f65533c).get(r110);
        Intrinsics.checkNotNull(r108);
        ((AtomicReference) r108).set(a.d.f65540a);
        Object r109 = ((LinkedHashMap) r105.f65535e).get(r110);
        Intrinsics.checkNotNull(r109);
        ((CountDownLatch) r109).countDown();
        r100.L$0 = r105;     // Catch: Exception -> L68
        r100.L$1 = r110;     // Catch: Exception -> L68
        r100.L$2 = null;     // Catch: Exception -> L68
        r100.label = 5;     // Catch: Exception -> L68
        if (r117.invoke(r100) != r102) goto L64;
        return r102;
    L64:
        r104 = r105;
    L68:
        e = e;
        goto L69
    L23:
        ResultKt.throwOnFailure(r112);
        goto L79
    L24:
        r110 = (String) r100.L$1;
        AsyncTaskManager r118 = (AsyncTaskManager) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L51:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        if (r118.d(r110, r100) != r102) goto L79;
        return r102;
    L25:
        ResultKt.throwOnFailure(r112);
    L41:
        return Unit.INSTANCE;
    L26:
        ResultKt.throwOnFailure(r112);
        r117 = (Function1) ((LinkedHashMap) this.f65531a).get(r110);
        if (r117 == null) goto L81;
        Object r119 = ((LinkedHashMap) this.f65533c).get(r110);
        Intrinsics.checkNotNull(r119);
        a r120 = (a) ((AtomicReference) r119).get();
        if (Intrinsics.areEqual(r120, a.C1076a.f65537a) == false) goto L33;
        return Unit.INSTANCE;
    L33:
        if (Intrinsics.areEqual(r120, a.d.f65540a) == false) goto L43;
        r100.label = 1;
        Object r121 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskCompletion$2(this, r110, null), r100);
        if (r121 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r121 = Unit.INSTANCE;
    L38:
        if (r121 != r102) goto L41;
        return r102;
    L43:
        if (Intrinsics.areEqual(r120, a.e.f65541a) == false) goto L55;
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.label = 2;
        Object r122 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskExecutionStart$2(this, r110, null), r100);
        if (r122 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        r122 = Unit.INSTANCE;
    L48:
        if (r122 != r102) goto L50;
        return r102;
    L50:
        r118 = this;
        goto L51
    L55:
        if (Intrinsics.areEqual(r120, a.c.f65539a) == false) goto L72;
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.L$2 = r117;
        r100.label = 4;
        if (a(r110, r100) != r102) goto L59;
        return r102;
    L59:
        r105 = this;
        goto L60
    L72:
        if ((r120 instanceof a.b) == false) goto L79;
        if (r120 != null) goto L77;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager.TaskStatus.FAILED");
    L77:
        throw ((a.b) r120).f65538a;
    L81:
        throw new IllegalArgumentException("Task " + r110 + " not configured");
    L7:
        r100 = new AsyncTaskManager$runSyncInternal$1(this, r111);
        goto L8
    }
}
