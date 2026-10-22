package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.DiffContext;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.c0;
import com.bytedance.android.anya.d0;
import com.bytedance.android.anya.p;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class MVIBindingImpl<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> implements m<STATE, ACTION> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f41625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<q<?, ?>, c0<?>> f41626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<a0, Boolean>> f41627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lb.a f41628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f41630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BaseMVIView<STATE, ACTION> f41631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseMVIViewModel<STATE, ACTION> f41632h;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MVIBindingImpl f41633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f41634b;

        public a(MVIBindingImpl r100, Function1 r101) {
            this.f41633a = r100;
            this.f41634b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            List<Function1<a0, Boolean>> r100 = this.f41633a.f41627c;
            ArrayList r101 = (ArrayList) r100;
            r101.remove(this.f41634b);
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MVIBindingImpl f41635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f41636b;

        public b(MVIBindingImpl r100, Function1 r101) {
            this.f41635a = r100;
            this.f41636b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f41635a.f41632h.f41552j.remove(this.f41636b);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.q
    public final void a() {
        if (this.f41629e == false) goto L5;
        return;
    L5:
        lb.a r100 = this.f41628d;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L8:
        MVIState r101 = this.f41632h.L();
        BaseMVIViewModel<STATE, ACTION> r102 = this.f41632h;
        Iterator r103 = r100.f508289a.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        lb.b r104 = (lb.b) r103.next();
        int r105 = lb.a.f508281c;
        r104.c(lb.a.C6668a.a(r101, true), r102);
        goto L10
    L12:
        CompositeDisposable r106 = this.f41625a;
        lb.a r107 = this.f41632h.S();
        lb.a r108 = this.f41628d;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L15:
        r107.f508289a.add((T) r108);
        r106.add(Disposables.fromAction(new lb.g(r107, r108)));
        Iterator<Map.Entry<q<?, ?>, c0<?>>> r109 = this.f41632h.d1().iterator();
    L17:
        if (r109.hasNext() == false) goto L19;
        Map.Entry<q<?, ?>, c0<?>> r110 = r109.next();
        this.f41626b.put(r110.getKey(), r110.getValue());
        goto L17
    L19:
        ReentrantLock r111 = this.f41632h.K().f41642b;
        r111.lock();
        this.f41631g.h(this.f41632h.L(), this);     // Catch: Throwable -> L23
        this.f41631g.c(new com.bytedance.android.anya.k(this.f41632h.L(), (DiffContext.a) this.f41630f.getValue(), true));     // Catch: Throwable -> L23
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r111.unlock();
        Function1<lb.e, Unit> r113 = new MVIBindingImpl$bind$diffConsumer$1(this);
        this.f41632h.f41552j.add(r113);
        this.f41625a.addAll(new Disposable[]{Disposables.fromAction(new b(this, r113)), this.f41632h.f41553k.a(new MVIBindingImpl$bind$4(this))});
        this.f41629e = true;
        return;
    L23:
        th = move-exception;
        r111.unlock();
        throw th;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final DiffContext f() {
        return (DiffContext.a) this.f41630f.getValue();
    }

    @Override // com.bytedance.android.anya.q
    public final void unbind() {
        if (this.f41629e == true) goto L5;
        return;
    L5:
        this.f41629e = false;
        this.f41625a.clear();
        this.f41631g.j();
        this.f41631g.f41537b = null;
        ((LinkedHashMap) this.f41626b).clear();
        lb.a r100 = this.f41628d;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L8:
        r100.b(this);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void b(ACTION r100) {
        mb.c r101 = mb.a.f512756a;
        String r102 = "sendAction " + r100;
        mb.c r103 = mb.a.f512756a;
        if (r103 == null) goto L5;
        r103.logW("ttlive_anya", r102);
    L5:
        this.f41632h.b0(r100);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void c(Map<q<?, ?>, ? extends d0<?, ?>> r100) {
        Iterator<Map.Entry<q<?, ?>, ? extends d0<?, ?>>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<q<?, ?>, ? extends d0<?, ?>> r102 = r101.next();
        q<?, ?> r103 = r102.getKey();
        d0<STATE, ? super c0<STATE>> r104 = (d0) r102.getValue();
        c0 r105 = (c0) ((LinkedHashMap) this.f41626b).get(r103);
        if (r105 == null) goto L4;
        if (r104 == 0) goto L10;
        r105.f41584a = r104;
        goto L4
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewReflexComponent<com.bytedance.android.anya.MVIReflexState<*>, com.bytedance.android.anya.MVIViewModelReflexComponent<com.bytedance.android.anya.MVIReflexState<*>>>");
    }

    @Override // com.bytedance.android.anya.internal.m
    public final Disposable d(Function1<? super a0, Boolean> r100) {
        ((ArrayList) this.f41627c).add(r100);
        return Disposables.fromAction(new a(this, r100));
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void e(Map<q<?, ?>, ? extends d0<?, ?>> r100) {
        Iterator<Map.Entry<q<?, ?>, ? extends d0<?, ?>>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<q<?, ?>, ? extends d0<?, ?>> r102 = r101.next();
        q<?, ?> r103 = r102.getKey();
        d0<?, ?> r104 = r102.getValue();
        c0 r105 = (c0) ((LinkedHashMap) this.f41626b).get(r103);
        if (r105 == null) goto L4;
        if (r104 == null) goto L10;
        Intrinsics.areEqual(r105.f41584a, r104);
        goto L4
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewReflexComponent<com.bytedance.android.anya.MVIReflexState<*>, com.bytedance.android.anya.MVIViewModelReflexComponent<com.bytedance.android.anya.MVIReflexState<*>>>");
    }

    public MVIBindingImpl(BaseMVIView<STATE, ACTION> r100, BaseMVIViewModel<STATE, ACTION> r101) {
        this.f41631g = r100;
        this.f41632h = r101;
        this.f41625a = new CompositeDisposable();
        this.f41626b = new LinkedHashMap();
        this.f41627c = new ArrayList();
        this.f41630f = LazyKt.lazy(MVIBindingImpl$diffContext$2.INSTANCE);
    }
}
