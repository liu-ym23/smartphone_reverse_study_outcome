package com.bytedance.android.latch.prefetch.internal;

import android.content.Context;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.internal.AbsLatchProcess;
import com.bytedance.android.latch.internal.BaseLatchProcess;
import com.bytedance.android.latch.internal.LatchStateHolder;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import com.bytedance.android.latch.internal.util.LatchException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class NativePrefetchProcess extends AbsLatchProcess {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f58413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f58414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.latch.a.b f58415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f58416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b0 f58417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f58418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BehaviorSubject<BaseLatchProcess.g> f58419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy<NativePrefetchProcess$lynxModuleCreation$1.AnonymousClass1> f58420q;

    public static final class a<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativePrefetchProcess f58421a;

        public a(NativePrefetchProcess r100) {
            this.f58421a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Intrinsics.checkNotNullParameter((Pair) r100, "it");
            return this.f58421a.f58418o.get();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativePrefetchProcess f58422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<JSONObject, Unit> f58423b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(NativePrefetchProcess r100, Function1<? super JSONObject, Unit> r101) {
            this.f58422a = r100;
            this.f58423b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            this.f58422a.f58222g.j((String) r101.getFirst());
            this.f58423b.invoke((JSONObject) r101.getSecond());
        }
    }

    @Override // com.bytedance.android.latch.internal.AbsLatchProcess, com.bytedance.android.latch.a.d
    public final List<com.bytedance.android.latch.a.c> a() {
        List<com.bytedance.android.latch.a.c> r100 = CollectionsKt.mutableListOf(new com.bytedance.android.latch.a.c[]{this.f58420q.getValue()});
        r100.addAll(super.a());
        return r100;
    }

    @Override // com.bytedance.android.latch.internal.util.a
    public void j() {
    }

    public abstract o m();

    public final void n() {
        this.f58222g.b();
        this.f58222g.c();
        JSONObject r100 = com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to("data", this.f58413j.b(this.f58218c, this.f58415l, m()))});
        this.f58222g.i();
        b0 r101 = this.f58417n;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "returnValue");
        if (r100.has("data") == false) goto L11;
        Object r102 = r100.get("data");
        if ((r102 instanceof JSONObject) == false) goto L10;
        JSONObject r103 = (JSONObject) r102;
        if (g0.c(r103) == false) goto L9;
        final List<Pair<LatchStateHolder.JsonPath, JSONObject>> r104 = r101.k(r102);
    L12:
        LatchPerfMetricCollector r105 = r101.f58464e;
        if ((true ^ r104.isEmpty()) == false) goto L15;
        LatchPerfMetricCollector.TransferType r106 = LatchPerfMetricCollector.TransferType.OPTIMIZE;
    L16:
        r105.f(r106);
        Iterator<T> r107 = r104.iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        r101.f58469j.add((LatchStateHolder.JsonPath) ((Pair) r107.next()).getFirst());
        goto L18
    L20:
        r101.f58468i.onNext(r100);
        r101.f58467h.set(r104.size());
        Iterator<T> r108 = r104.iterator();
    L22:
        if (r108.hasNext() == false) goto L24;
        Pair r109 = (Pair) r108.next();
        LatchStateHolder.JsonPath r110 = (LatchStateHolder.JsonPath) r109.getFirst();
        JSONObject r111 = (JSONObject) r109.getSecond();
        r101.f58469j.add(r110);
        com.bytedance.android.latch.internal.f r112 = r101.f58461b;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        com.bytedance.android.latch.internal.util.b.d(r112.a(JSONObjectProtectorUtils.getString(r111, "__callback_id")).subscribe(new a0(r110, r101, r111)), r101.f58465f);
        goto L22
    L24:
        r101.f58467h.get();
        p(BaseLatchProcess.g.d.f58253a);
        return;
    L15:
        r106 = LatchPerfMetricCollector.TransferType.NORMAL;
        goto L16
    L9:
        r104 = new ArrayList();
        b0.l(r103, LatchStateHolder.JsonPath.f58271c, new PrefetchStateHolder$handleStructResult$1(r104));
        goto L12
    L10:
        r104 = r101.k(r102);
        goto L12
    L11:
        r104 = CollectionsKt.emptyList();
        goto L12
    }

    public final Context getContext() {
        return this.f58414k;
    }

    private final void p(BaseLatchProcess.g r100) {
        BaseLatchProcess.g r101 = this.f58419p.getValue();
        if (r101 == null) goto L10;
        if ((r101 instanceof BaseLatchProcess.g.b) == false) goto L7;
        return;
    L7:
        this.f58419p.onNext(r100);
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void l(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "updateListener");
        com.bytedance.android.latch.internal.util.b.d(this.f58417n.f58466g.filter(new a(this)).subscribe(new b(this, r100)), this.f58416m);
    }

    public static final void k(NativePrefetchProcess r100, JSONObject r101) {
        r100.getClass();
        String r102 = r101.optString("version", "");
        if (r100.f58413j.a(r102) == true) goto L13;
        r100.f58221f.put("prefetchStatusCode", -2006);
        r100.f58221f.put("prefetchErrMsg", "prefetch: version not match");
        r100.p(new BaseLatchProcess.g.b(new LatchException(-2006, "prefetch: version not match", null, 4, null)));
        LatchOptions r103 = r100.f58217b;
        if ((r103 instanceof ix.a) == false) goto L7;
        ix.a r104 = (ix.a) r103;
    L8:
        if (r104 == null) goto L14;
        x r105 = r104.f496313e;
        if (r105 == null) goto L15;
        r105.reload(r100.f58218c);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public NativePrefetchProcess(p r110, Context r111, LatchOptions r112, String r113, com.bytedance.android.latch.a.b r114, LatchPerfMetricCollector r115, LatchProcessOptions r116, com.bytedance.android.latch.internal.f r210) {
        Intrinsics.checkNotNullParameter(r110, "handler");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "options");
        Intrinsics.checkNotNullParameter(r113, "pageUrl");
        Intrinsics.checkNotNullParameter(r114, "dataHolder");
        Intrinsics.checkNotNullParameter(r115, "perfMetric");
        Intrinsics.checkNotNullParameter(r116, "processOptions");
        Intrinsics.checkNotNullParameter(r210, "methodListenerStore");
        super(r112, r113, "native", r115, r210, r116);
        this.f58413j = r110;
        this.f58414k = r111;
        this.f58415l = r114;
        this.f58416m = new CompositeDisposable();
        this.f58417n = new b0(this.f58219d, new NativePrefetchProcess$createStateHolder$1(this), new NativePrefetchProcess$createStateHolder$2(this), r115);
        this.f58418o = new AtomicBoolean(false);
        this.f58419p = BehaviorSubject.createDefault(BaseLatchProcess.g.c.f58252a);
        this.f58420q = LazyKt.lazy(new NativePrefetchProcess$lynxModuleCreation$1(this));
    }
}
