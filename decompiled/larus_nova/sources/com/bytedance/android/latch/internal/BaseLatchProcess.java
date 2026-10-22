package com.bytedance.android.latch.internal;

import android.content.Context;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.internal.jsb.module.LatchInternalModule;
import com.bytedance.android.latch.internal.jsb.module.LynxLatchModule;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import com.bytedance.android.latch.internal.util.LatchException;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class BaseLatchProcess extends AbsLatchProcess {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f58227r = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f58228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f58229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LatchStateHolder f58230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JsWorker f58231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BehaviorSubject<g> f58232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f58233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy<BaseLatchProcess$lynxModuleCreation$1.AnonymousClass1> f58234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f58235q;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f58242a = null;

        static {
            f58242a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Throwable) r100, "it");
            return "";
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f58243a = null;

        static {
            f58243a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Throwable) r100, "it");
            return "";
        }
    }

    public static final class c<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T1, T2, R> f58244a = null;

        static {
            f58244a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            String r102 = (String) r100;
            String r103 = (String) r101;
            Intrinsics.checkNotNullParameter(r102, "t1");
            Intrinsics.checkNotNullParameter(r103, "t2");
            if ((!StringsKt.isBlank(r102)) == true) goto L5;
            Pair r104 = new Pair(-1001, "failed to load init script");
            throw new LatchException(((Number) r104.component1()).intValue(), (String) r104.component2(), null, 4, null);
        L5:
            if ((!StringsKt.isBlank(r103)) == true) goto L7;
            Pair r105 = new Pair(-1002, "failed to load prefetch script");
            throw new LatchException(((Number) r105.component1()).intValue(), (String) r105.component2(), null, 4, null);
        L7:
            return new Pair(r102, r103);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLatchProcess f58247a;

        public d(BaseLatchProcess r100) {
            this.f58247a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            String r102 = (String) r101.component1();
            String r103 = (String) r101.component2();
            this.f58247a.f58222g.b();
            BaseLatchProcess.l(this.f58247a, g.a.f58250a);
            BaseLatchProcess r104 = this.f58247a;
            int r105 = 0;
            Pair[] r106 = {TuplesKt.to("NativeModules.get('latch').readyToRunScript()", null), TuplesKt.to(r102, BaseLatchProcess.k(this.f58247a, "init.js")), TuplesKt.to("NativeModules.get('latch').initJsFinished()", null), TuplesKt.to(r103, BaseLatchProcess.k(this.f58247a, "prefetch.js"))};
            JsWorker r107 = r104.f58231m;
        L3:
            if (r105 >= 4) goto L5;
            Pair r108 = r106[r105];
            String r109 = (String) r108.component1();
            String r110 = (String) r108.component2();
            r107.evaluateJavaScript(r109);
            r105 = r105 + 1;
            goto L3
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLatchProcess f58248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LatchProcessOptions f58249b;

        public e(BaseLatchProcess r100, LatchProcessOptions r101) {
            this.f58248a = r100;
            this.f58249b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            BaseLatchProcess r102 = this.f58248a;
            LatchException.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            if ((r101 instanceof LatchException) == false) goto L5;
            LatchException r103 = (LatchException) r101;
        L9:
            BaseLatchProcess.l(r102, new g.b(r103));
            hx.a r104 = this.f58249b.f58207d;
            if (r104 == null) goto L13;
            r104.c(this.f58248a, new dx.b("failed to load latch process", 3, 4));
            return;
        L13:
            return;
        L5:
            String r105 = r101.getMessage();
            if (r105 != null) goto L8;
            r105 = "[unknown error]";
        L8:
            r103 = new LatchException(-1000, r105, r101);
            goto L9
        }
    }

    public static final class f {
    }

    public static abstract class g {

        public static final class a extends g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f58250a = null;

            static {
                f58250a = new a();
            }

            public a() {
            }
        }

        public static final class b extends g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LatchException f58251a;

            public b(LatchException r100) {
                Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
                this.f58251a = r100;
            }
        }

        public static final class c extends g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f58252a = null;

            static {
                f58252a = new c();
            }

            public c() {
            }
        }

        public static final class d extends g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f58253a = null;

            static {
                f58253a = new d();
            }

            public d() {
            }
        }

        public g() {
        }
    }

    public static final class h<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLatchProcess f58254a;

        public h(BaseLatchProcess r100) {
            this.f58254a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Intrinsics.checkNotNullParameter((Pair) r100, "it");
            return this.f58254a.f58233o.get();
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLatchProcess f58255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<JSONObject, Unit> f58256b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(BaseLatchProcess r100, Function1<? super JSONObject, Unit> r101) {
            this.f58255a = r100;
            this.f58256b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            this.f58255a.f58222g.j((String) r101.getFirst());
            this.f58256b.invoke((JSONObject) r101.getSecond());
        }
    }

    static {
    }

    @Override // com.bytedance.android.latch.internal.AbsLatchProcess, com.bytedance.android.latch.a.d
    public final List<com.bytedance.android.latch.a.c> a() {
        List<com.bytedance.android.latch.a.c> r100 = CollectionsKt.mutableListOf(new com.bytedance.android.latch.a.c[]{this.f58234p.getValue()});
        r100.addAll(super.a());
        return r100;
    }

    public void n(JsWorker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    }

    public abstract void p(JSModuleManager r100);

    @Override // com.bytedance.android.latch.internal.util.a
    public void j() {
        if (this.f58234p.isInitialized() == false) goto L7;
        Function0<Unit> r100 = ((LynxLatchModule.a) this.f58234p.getValue().getParams()).f58315d;
        if (r100 == null) goto L7;
        r100.invoke();
    L7:
        this.f58229k.dispose();
        this.f58231m.terminate();
    }

    public final void m(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "updateListener");
        com.bytedance.android.latch.internal.util.b.d(this.f58230l.f58267k.filter(new h(this)).subscribe(new i(this, r100)), this.f58229k);
    }

    public static final String k(BaseLatchProcess r100, String r101) {
        r100.getClass();
        return ((String) r100.f58235q.getValue()) + '/' + r101;
    }

    public static final void l(BaseLatchProcess r100, g r101) {
        g r102 = r100.f58232n.getValue();
        if (r102 == null) goto L10;
        if ((r102 instanceof g.b) == true) goto L11;
        r100.f58232n.onNext(r101);
        return;
    L11:
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public BaseLatchProcess(Context r210, final LatchOptions r211, final String r212, com.bytedance.android.latch.a.b r213, LatchPerfMetricCollector r214, LatchProcessOptions r215, com.bytedance.android.latch.internal.f r216) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "options");
        Intrinsics.checkNotNullParameter(r212, "pageUrl");
        Intrinsics.checkNotNullParameter(r213, "dataHolder");
        Intrinsics.checkNotNullParameter(r214, "perfMetric");
        Intrinsics.checkNotNullParameter(r215, "processOptions");
        Intrinsics.checkNotNullParameter(r216, "methodListenerStore");
        super(r211, r212, "vmsdk", r214, r216, r215);
        this.f58228j = r210;
        CompositeDisposable r100 = new CompositeDisposable();
        this.f58229k = r100;
        LatchStateHolder r101 = new LatchStateHolder(r216, new BaseLatchProcess$createStateHolder$1(this), new BaseLatchProcess$createStateHolder$2(this), new BaseLatchProcess$createStateHolder$3(this), new BaseLatchProcess$createStateHolder$4(this), r214, this.f58220e);
        com.bytedance.android.latch.internal.util.b.d(r101, r100);
        this.f58230l = r101;
        com.bytedance.android.latch.internal.a r102 = this.f58222g;
        JSModuleManager r110 = new JSModuleManager(r210);
        p(r110);
        r110.b("latch", LatchInternalModule.class, new LatchInternalModule.a(r101, r213, r102));
        JsWorker r103 = new JsWorker(r110, JsWorker.EngineType.QUICKJS, null, false, "latch");
        n(r103);
        r103.setOnMessageCallback(new BaseLatchProcess$createJsWorker$3$1(this));
        r103.setOnErrorCallback(new BaseLatchProcess$createJsWorker$3$2(this));
        this.f58231m = r103;
        this.f58232n = BehaviorSubject.createDefault(g.c.f58252a);
        this.f58233o = new AtomicBoolean(false);
        this.f58234p = LazyKt.lazy(new BaseLatchProcess$lynxModuleCreation$1(this));
        this.f58235q = LazyKt.lazy(new BaseLatchProcess$pageCachePrefix$2(r212));
        com.bytedance.android.latch.internal.a r104 = this.f58222g;
        LatchPerfMetricCollector.c(r104.f58278e, LatchPerfMetricCollector.PerfPoints.WORKER_READY, null, null, 0, 14);
        r104.h(102);
        r104.g(new dx.b("workerReady", 0, 6));
        com.bytedance.android.latch.internal.util.b.d(Single.zip(Single.create(new AnonymousClass1(r211, this, r212)).subscribeOn(Schedulers.io()).onErrorReturn(a.f58242a), Single.create(new AnonymousClass3(r211, this, r212)).subscribeOn(Schedulers.io()).onErrorReturn(b.f58243a), c.f58244a).subscribe(new d(this), new e(this, r215)), r100);
    }
}
