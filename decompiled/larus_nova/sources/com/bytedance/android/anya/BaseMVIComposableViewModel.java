package com.bytedance.android.anya;

import android.os.Handler;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftPanelViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIComposableViewModel<STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIViewModel<STATE, ACTION> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.anya.dsl.h<STATE, ACTION> f41523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<ACTION, Unit> f41524r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function2<j0<STATE>, ACTION, Unit> f41525s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function2<o, ACTION, Unit> f41526t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function2<o, ACTION, Unit> f41527u;

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public boolean L0(ACTION r100) {
        return false;
    }

    public boolean e1() {
        return false;
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final Sequence<Map.Entry<com.bytedance.android.anya.internal.q<?, ?>, c0<?>>> d1() {
        return SequencesKt.plus(MapsKt.asSequence((Map) this.f41558p.getValue()), SequencesKt.flatMap(CollectionsKt.asSequence(this.f41523q.f41596a), BaseMVIComposableViewModel$visitReflexComponents$1.INSTANCE));
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel, com.bytedance.android.anya.internal.j
    public final void k() {
        super.k();
        this.f41555m.dispose();
        if (q0.f41749d == false) goto L24;
        Iterator r100 = this.f41523q.a().iterator();
    L6:
        if (r100.hasNext() == false) goto L31;
        Object r101 = ((com.bytedance.android.anya.dsl.i) r100.next()).f41597a;
        if (r101 == null) goto L23;
        BaseMVIViewModel r102 = (BaseMVIViewModel) r101;
        if ((r102 instanceof f) == true) goto L12;
        BaseMVIViewModel r103 = null;
    L13:
        f r104 = (f) r103;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        if ((r102 instanceof g) == true) goto L19;
        r102 = null;
    L19:
        g r105 = (g) r102;
        if (r105 == null) goto L6;
        r105.dispose();
        goto L6
    L12:
        r103 = r102;
        goto L13
    L23:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIViewModel<*, *>");
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void o0() {
        super.o0();
        if ((this instanceof GiftPanelViewModel) == false) goto L5;
        K().f41649i = e1();
    L5:
        Iterator r100 = this.f41523q.a().iterator();
    L7:
        if (r100.hasNext() == false) goto L31;
        com.bytedance.android.anya.dsl.i r101 = (com.bytedance.android.anya.dsl.i) r100.next();
        Object r102 = r101.f41597a;
        if (r102 == null) goto L30;
        BaseMVIViewModel r103 = (BaseMVIViewModel) r102;
        BaseMVIViewModel r104 = null;
        if ((r103 instanceof f) == true) goto L13;
        BaseMVIViewModel r105 = null;
    L14:
        f r106 = (f) r105;
        if (r106 == null) goto L18;
        com.bytedance.android.anya.internal.b r107 = K();
        lb.a r108 = S();
        BaseMVIComposableViewModel$initializeInternal$1$1 r109 = new BaseMVIComposableViewModel$initializeInternal$1$1(this);
        r106.f41605q = r107;
        r106.f41606r = r108;
        r106.f41607s = r109;
        r106.f41608t = true;
    L18:
        if ((r103 instanceof g) == false) goto L21;
        r104 = r103;
    L21:
        g r110 = (g) r104;
        if (r110 == null) goto L24;
        com.bytedance.android.anya.internal.b r111 = K();
        lb.a r112 = S();
        BaseMVIComposableViewModel$initializeInternal$1$2 r113 = new BaseMVIComposableViewModel$initializeInternal$1$2(this);
        r110.f41612v = r111;
        r110.f41613w = r112;
        r110.f41614x = r113;
        r110.f41615y = true;
    L24:
        Object r114 = r101.f41598b.invoke(this.f41554l, L());
        if (r114 == null) goto L28;
        ((SubStatePropertyImpl) r114).d(r103.L());
        Disposable r115 = r103.f41553k.a(new BaseMVIComposableViewModel$initializeInternal$$inlined$forEach$lambda$1(this));
        CompositeDisposable r116 = this.f41555m;
        Handler r117 = com.bytedance.android.anya.internal.v.f41726a;
        r116.add(r115);
        j0<STATE> r118 = r103.f41551i;
        j0 r119 = this.f41551i;
        r118.f41735f = r119;
        r119.f41730a.add(r118);
        r103.f0();
        goto L7
    L28:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.SubStatePropertyImpl<STATE, *>");
    L13:
        r105 = r103;
        goto L14
    L30:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIViewModel<*, *>");
    L31:
        final LinkedHashMap r120 = new LinkedHashMap();
        ArrayList r121 = new ArrayList();
        Iterator r122 = this.f41523q.a().iterator();
    L33:
        if (r122.hasNext() == false) goto L41;
        com.bytedance.android.anya.dsl.i r123 = (com.bytedance.android.anya.dsl.i) r122.next();
        Object r124 = r123.f41597a;
        u0 r125 = (u0) r123.f41598b.invoke(this.f41554l, L());
        Object r126 = r120.get(r125);
        if (r126 != null) goto L37;
        r126 = new ArrayList();
        r120.put(r125, r126);
    L37:
        List r127 = (List) r126;
        r127.add(r124);
        if (r127.size() <= 1) goto L33;
        r121.add(r125);
        goto L33
    L41:
        if ((!r121.isEmpty()) == true) goto L44;
        return;
    L44:
        throw new IllegalStateException(("There are multiple viewModels binding to same subState: " + CollectionsKt.joinToString$default(r121, ",", null, null, 0, null, new BaseMVIComposableViewModel$checkDuplicatedSubModels$errMsg$1(r120), 30, null)).toString());
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public void p0() {
        super.p0();
        if ((this instanceof GiftPanelViewModel) == false) goto L8;
        com.bytedance.android.anya.internal.b r100 = K();
        if (r100.f41649i == false) goto L9;
        r100.K(true, null);
        r100.f41649i = false;
        return;
    L9:
        return;
    }

    public BaseMVIComposableViewModel(Collection<? extends b0<STATE, ?, ?>> r100) {
        L();
        com.bytedance.android.anya.dsl.h<STATE, ACTION> r101 = new com.bytedance.android.anya.dsl.h();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        b0 r103 = (b0) r102.next();
        if (r103 == null) goto L9;
        r103.d(r101);
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewModelChildNode<STATE, *, ACTION>");
    L10:
        this.f41523q = r101;
        this.f41524r = (Function1<ACTION, Unit>) new BaseMVIComposableViewModel$dispatchReduce$1(this);
        this.f41525s = (Function2<j0<STATE>, ACTION, Unit>) new BaseMVIComposableViewModel$dispatchPostReduce$1(this);
        this.f41526t = (Function2<o, ACTION, Unit>) new BaseMVIComposableViewModel$handleActionAsReducer$1(this);
        this.f41527u = (Function2<o, ACTION, Unit>) new BaseMVIComposableViewModel$dispatchActionAsReducer$1(this);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void e0(com.bytedance.android.anya.internal.l r100, p r101) {
        if (L0(r101) == false) goto L5;
        Y(r101, r100.f41695a);
        return;
    L5:
        Function2<o, ACTION, Unit> r102 = this.f41526t;
        Function2<o, ACTION, Unit> r103 = this.f41527u;
        r102.invoke(r100, r101);
        r103.invoke(r100, r101);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void w0(j0 r100, MVIState r101, p r102) {
        throw new IllegalStateException("won't go in here".toString());
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void x0(j0<STATE> r100, ACTION r101, com.bytedance.android.anya.internal.p r102) {
        r100.f41734e = r102;
        r100.f41731b = false;
        ((LinkedHashMap) r100.f41732c).clear();
        h1(r100, L(), r101, this.f41525s);     // Catch: Throwable -> L6
        r100.f41733d.putAll(r100.f41732c);
        return;
    L6:
        th = move-exception;
        r100.f41733d.putAll(r100.f41732c);
        throw th;
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public final void y0(l0<STATE> r100, STATE r101, ACTION r102) {
        s1(r100, r101, r102, this.f41524r);
    }

    public void h1(j0<STATE> r100, STATE r101, ACTION r102, Function2<? super j0<STATE>, ? super ACTION, Unit> r103) {
        r103.invoke(r100, r102);
    }

    public void s1(l0<STATE> r100, STATE r101, ACTION r102, Function1<? super ACTION, Unit> r103) {
        r103.invoke(r102);
    }
}
