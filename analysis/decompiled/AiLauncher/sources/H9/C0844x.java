package H9;

import E9.InterfaceC0805j;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import ra.C5229b;
import ra.C5236i;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* renamed from: H9.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0844x extends AbstractC0834m implements E9.L {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f3219h = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C0844x.class, "fragments", "getFragments()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(C0844x.class, "empty", "getEmpty()Z", 0))};

    /* renamed from: c, reason: collision with root package name */
    public final F f3220c;

    /* renamed from: d, reason: collision with root package name */
    public final ga.c f3221d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h f3222e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5865h f3223f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5238k f3224g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0844x(F module, ga.c fqName, InterfaceC5869l storageManager) {
        super(F9.g.f2609m0.b(), fqName.g());
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        this.f3220c = module;
        this.f3221d = fqName;
        this.f3222e = storageManager.i(new C0841u(this));
        this.f3223f = storageManager.i(new C0842v(this));
        this.f3224g = new C5236i(storageManager, new C0843w(this));
    }

    public static final boolean F0(C0844x c0844x) {
        return E9.J.b(c0844x.getModule().G0(), c0844x.f());
    }

    public static final List G0(C0844x c0844x) {
        return E9.J.c(c0844x.getModule().G0(), c0844x.f());
    }

    public static final InterfaceC5238k K0(C0844x c0844x) {
        if (c0844x.isEmpty()) {
            return InterfaceC5238k.b.f38898b;
        }
        List<E9.E> listD0 = c0844x.d0();
        ArrayList arrayList = new ArrayList(C1174w.x(listD0, 10));
        Iterator<T> it = listD0.iterator();
        while (it.hasNext()) {
            arrayList.add(((E9.E) it.next()).m());
        }
        List listT0 = Z8.F.T0(arrayList, new P(c0844x.getModule(), c0844x.f()));
        return C5229b.f38851d.a("package view scope for " + c0844x.f() + " in " + c0844x.getModule().getName(), listT0);
    }

    @Override // E9.InterfaceC0803h
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public E9.L b() {
        if (f().c()) {
            return null;
        }
        return getModule().f0(f().d());
    }

    public final boolean I0() {
        return ((Boolean) C5868k.a(this.f3223f, this, f3219h[1])).booleanValue();
    }

    @Override // E9.L
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public F getModule() {
        return this.f3220c;
    }

    @Override // E9.L
    public List<E9.E> d0() {
        return (List) C5868k.a(this.f3222e, this, f3219h[0]);
    }

    public boolean equals(Object obj) {
        E9.L l10 = obj instanceof E9.L ? (E9.L) obj : null;
        return l10 != null && kotlin.jvm.internal.p.d(f(), l10.f()) && kotlin.jvm.internal.p.d(getModule(), l10.getModule());
    }

    @Override // E9.L
    public ga.c f() {
        return this.f3221d;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + f().hashCode();
    }

    @Override // E9.L
    public boolean isEmpty() {
        return I0();
    }

    @Override // E9.L
    public InterfaceC5238k m() {
        return this.f3224g;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> visitor, D d10) {
        kotlin.jvm.internal.p.i(visitor, "visitor");
        return visitor.f(this, d10);
    }
}
