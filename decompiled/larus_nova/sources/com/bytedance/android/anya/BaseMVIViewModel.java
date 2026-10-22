package com.bytedance.android.anya;

import android.os.Handler;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIViewModel<STATE extends MVIState<?>, ACTION extends p> extends com.bytedance.android.anya.internal.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f41544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<BaseMVIDataStore<?>> f41545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0.a<STATE> f41546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f41547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f41548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.anya.internal.b f41549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l0<STATE> f41550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0<STATE> f41551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Function1<lb.e, Unit>> f41552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.anya.internal.d<a0> f41553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p0<STATE> f41554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f41555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f41556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public lb.a f41557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f41558p;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseMVIDataStore f41559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f41560b;

        public a(BaseMVIDataStore r100, Function2 r101) {
            this.f41559a = r100;
            this.f41560b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f41559a.f41529b.remove(this.f41560b);
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseMVIDataStore f41561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f41562b;

        public b(BaseMVIDataStore r100, f0 r101) {
            this.f41561a = r100;
            this.f41562b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f41561a.f41530c.remove(this.f41562b);
        }
    }

    public abstract STATE F(l0<STATE> r100);

    public void J0(com.bytedance.android.anya.internal.e r100, MVIState r101) {
    }

    public final STATE L() {
        return (STATE) this.f41548f.getValue();
    }

    public mb.b R() {
        return null;
    }

    public int U() {
        return 0;
    }

    public void q(com.bytedance.android.anya.dsl.l<STATE, r, ACTION> r100) {
    }

    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public void w0(j0<STATE> r100, STATE r101, ACTION r102) {
    }

    public com.bytedance.android.anya.internal.b K() {
        com.bytedance.android.anya.internal.b r100 = this.f41549g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_executor");
    L5:
        return r100;
    }

    public lb.a S() {
        lb.a r100 = this.f41557o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_tracer");
    L5:
        return r100;
    }

    public Sequence<Map.Entry<com.bytedance.android.anya.internal.q<?, ?>, c0<?>>> d1() {
        return MapsKt.asSequence((Map) this.f41558p.getValue());
    }

    public final void f0() {
        if (this.f41556n == true) goto L6;
        o0();
        p0();
        this.f41556n = true;
        return;
    }

    public void o0() {
        this.f41549g = new com.bytedance.android.anya.internal.b(this.f41544b, getClass().getSimpleName(), U(), R());
        this.f41557o = new lb.a(this, CollectionsKt.emptyList());
        Iterator<T> r100 = I().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        BaseMVIDataStore r101 = (BaseMVIDataStore) r100.next();
        Function2<Map<Object, ? extends j<?>>, lb.e, Unit> r102 = new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$1(this);
        ((ArrayList) r101.f41529b).add(r102);
        Disposable r103 = Disposables.fromAction(new a(r101, r102));
        CompositeDisposable r104 = this.f41555m;
        Handler r105 = com.bytedance.android.anya.internal.v.f41726a;
        r104.add(r103);
        f0 r106 = new f0(K(), new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$2(this), new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$3(this));
        ((ArrayList) r101.f41530c).add(r106);
        Disposable r107 = Disposables.fromAction(new b(r101, r106));
        this.f41555m.add(r107);
        goto L4
    }

    public BaseMVIViewModel() {
        if (q0.f41748c == false) goto L5;
        Scheduler r100 = Schedulers.io();
    L6:
        this.f41544b = r100;
        this.f41545c = SetsKt.emptySet();
        k0.a<STATE> r101 = new k0.a();
        this.f41546d = r101;
        this.f41547e = LazyKt.lazy(new BaseMVIViewModel$stateMachine$2(this));
        this.f41548f = LazyKt.lazy(new BaseMVIViewModel$state$2(this));
        l0<STATE> r102 = new l0(r101);
        this.f41550h = r102;
        this.f41551i = new j0(r102);
        PublishSubject.create();
        this.f41552j = Collections.synchronizedSet(new LinkedHashSet());
        this.f41553k = new com.bytedance.android.anya.internal.d();
        this.f41554l = new p0();
        this.f41555m = new CompositeDisposable();
        this.f41558p = LazyKt.lazy(new BaseMVIViewModel$reflexComponents$2(this));
        return;
    L5:
        r100 = Schedulers.computation();
        goto L6
    }

    @Override // com.bytedance.android.anya.internal.j
    public void k() {
        K().dispose();
    }

    public void p0() {
        Iterator<T> r100 = I().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final BaseMVIDataStore r101 = (BaseMVIDataStore) r100.next();
        K().R(new BaseMVIViewModel$postInit$$inlined$forEach$lambda$1(r101, this));
        goto L4
    }

    public Set<BaseMVIDataStore<?>> I() {
        return this.f41545c;
    }

    public final void K0(a0 r100) {
        this.f41553k.b(r100);
    }

    public boolean L0(ACTION r100) {
        return I().isEmpty();
    }

    public void N0(lb.e r100) {
        if ((!L().modifiedProperties.isEmpty()) == false) goto L12;
        Iterator<T> r101 = this.f41552j.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((Function1) r101.next()).invoke(r100);
        goto L6
    L8:
        r100.getClass();
        int r102 = lb.a.f508281c;
        lb.i r103 = lb.a.C6668a.a(r100.f508286d, true);
        Iterator r104 = r100.f508289a.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        ((lb.f) r104.next()).e(r103);
        goto L10
    L15:
        return;
    }

    public final void b0(final ACTION r100) {
        if (this.f41556n == false) goto L7;
        final lb.e r101 = S().k(new s(new com.bytedance.android.anya.a.C0764a(r100)));
        K();
        final com.bytedance.android.anya.internal.l r102 = new com.bytedance.android.anya.internal.l(r101, new BaseMVIViewModel$handleActionInternal$context$1(this, r101));
        K().R(new BaseMVIViewModel$handleActionInternal$1(this, r100, r101, r102));
        return;
    L7:
        throw new IllegalStateException((this + " is not initialized").toString());
    }

    public static final void n(BaseMVIViewModel r100, String r101) {
        r100.getClass();
        mb.c r102 = mb.a.f512756a;
        String r103 = r100.getClass().getSimpleName() + ' ' + r101;
        mb.c r104 = mb.a.f512756a;
        if (r104 == null) goto L6;
        r104.logD("ttlive_anya_vm", r103);
        return;
    }

    public final void E(m r100, Map<Object, ? extends j<?>> r101) {
        final lb.e r102 = S().k(new s(new com.bytedance.android.anya.a.b(r100.f41745a, r101)));
        String r103 = "consumeData source=" + r100.f41745a;     // Catch: Throwable -> L14
        mb.c r104 = mb.a.f512756a;     // Catch: Throwable -> L14
        String r105 = getClass().getSimpleName() + ' ' + r103;     // Catch: Throwable -> L14
        mb.c r106 = mb.a.f512756a;     // Catch: Throwable -> L14
        if (r106 == null) goto L6;
        r106.logD("ttlive_anya_vm", r105);     // Catch: Throwable -> L14
    L6:
        r102.d(this);     // Catch: Throwable -> L14
        J0(new com.bytedance.android.anya.internal.e(I(), r101, this.f41550h), L());     // Catch: Throwable -> L14
        r102.l(r101);
        com.bytedance.android.anya.internal.b r107 = K();
        Function0<Unit> r108 = new BaseMVIViewModel$consumeData$1(this, r102);
        if (r107.f41649i == false) goto L10;
        return;
    L10:
        if (r107.f41650j == true) goto L25;
        r107.L(r108, true);
        return;
    L25:
        return;
    L14:
        th = move-exception;
        r102.l(r101);
        com.bytedance.android.anya.internal.b r109 = K();
        Function0<Unit> r110 = new BaseMVIViewModel$consumeData$1(this, r102);
        if (r109.f41649i == false) goto L18;
    L21:
        throw th;
    L18:
        if (r109.f41650j == true) goto L21;
        r109.L(r110, true);
        goto L21
    }

    public final void T0(STATE r100, ACTION r101) {
        com.bytedance.android.anya.dsl.k r102 = (com.bytedance.android.anya.dsl.k) this.f41547e.getValue();
        l0<STATE> r103 = this.f41550h;
        if (r102.f41602a.isEmpty() == true) goto L17;
        k0.a<STATE> r104 = this.f41546d;
        if (r104 == null) goto L14;
        r r105 = r100.toBusinessState(r104);
        Map r106 = (Map) r102.f41602a.get(r105.getClass());
        if (r106 == null) goto L15;
        Function4 r107 = (Function4) r106.get(r101.getClass());
        if (r107 == null) goto L16;
        Unit r108 = (Unit) r107.invoke(r103, r100, r105, r101);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.ReadOnlyStateContext<STATE, *>");
    }

    public void X(o r100, ACTION r101) {
        if (L0(r101) == false) goto L6;
        Y(r101, ((com.bytedance.android.anya.internal.l) r100).f41695a);
        return;
    }

    public final void Y(ACTION r100, lb.e r101) {
        com.bytedance.android.anya.internal.p r102 = new com.bytedance.android.anya.internal.p(L(), null);
        r101.f508284b++;
        l0<STATE> r103 = this.f41550h;
        y0(r103, r103.f(), r100);
        int r104 = r101.f508284b - 1;
        r101.f508284b = r104;
        if (r104 != 0) goto L21;
        if (r101.f508289a.isEmpty() == true) goto L21;
        if (r101.f508286d.modifiedProperties.isEmpty() == true) goto L21;
        int r105 = lb.a.f508281c;
        lb.i r106 = lb.a.C6668a.a(r101.f508286d, false);
        Iterator r107 = r101.f508289a.iterator();
    L12:
        if (r107.hasNext() == false) goto L21;
        ((lb.f) r107.next()).i(r106);
    L21:
        x0(this.f41551i, r100, r102);     // Catch: Throwable -> L18
        r101.f508285c++;     // Catch: Throwable -> L18
        j0<STATE> r108 = this.f41551i;     // Catch: Throwable -> L18
        if (r108.f41731b == true) goto L21;
        r108.b();
        r101.k();
        return;
    L18:
        th = move-exception;
        this.f41551i.b();
        r101.k();
        throw th;
    }

    public void e0(com.bytedance.android.anya.internal.l r100, p r101) {
        X(r100, r101);
    }

    public void x0(j0<STATE> r100, ACTION r101, com.bytedance.android.anya.internal.p r102) {
        r100.f41734e = r102;
        r100.f41731b = false;
        ((LinkedHashMap) r100.f41732c).clear();
        w0(r100, L(), r101);     // Catch: Throwable -> L6
        r100.f41733d.putAll(r100.f41732c);
        return;
    L6:
        th = move-exception;
        r100.f41733d.putAll(r100.f41732c);
        throw th;
    }

    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public void y0(l0<STATE> r100, STATE r101, ACTION r102) {
        T0(r101, r102);
    }
}
