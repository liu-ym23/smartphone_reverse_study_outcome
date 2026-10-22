package ua;

import E9.InterfaceC0819y;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import p9.InterfaceC5074l;
import xa.InterfaceC5864g;
import xa.InterfaceC5869l;

/* renamed from: ua.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5617c implements E9.K {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5869l f42588a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5640z f42589b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0819y f42590c;

    /* renamed from: d, reason: collision with root package name */
    public C5627m f42591d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5864g<ga.c, E9.E> f42592e;

    public AbstractC5617c(InterfaceC5869l storageManager, InterfaceC5640z finder, InterfaceC0819y moduleDescriptor) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(finder, "finder");
        kotlin.jvm.internal.p.i(moduleDescriptor, "moduleDescriptor");
        this.f42588a = storageManager;
        this.f42589b = finder;
        this.f42590c = moduleDescriptor;
        this.f42592e = storageManager.f(new C5616b(this));
    }

    public static final E9.E f(AbstractC5617c abstractC5617c, ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        AbstractC5631q abstractC5631qE = abstractC5617c.e(fqName);
        if (abstractC5631qE == null) {
            return null;
        }
        abstractC5631qE.F0(abstractC5617c.g());
        return abstractC5631qE;
    }

    @Override // E9.K
    public void a(ga.c fqName, Collection<E9.E> packageFragments) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        Ia.a.a(packageFragments, this.f42592e.invoke(fqName));
    }

    @Override // E9.F
    public List<E9.E> b(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return C1173v.q(this.f42592e.invoke(fqName));
    }

    @Override // E9.K
    public boolean c(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return (this.f42592e.u(fqName) ? (E9.E) this.f42592e.invoke(fqName) : e(fqName)) == null;
    }

    public abstract AbstractC5631q e(ga.c cVar);

    public final C5627m g() {
        C5627m c5627m = this.f42591d;
        if (c5627m != null) {
            return c5627m;
        }
        kotlin.jvm.internal.p.A("components");
        return null;
    }

    public final InterfaceC5640z h() {
        return this.f42589b;
    }

    public final InterfaceC0819y i() {
        return this.f42590c;
    }

    public final InterfaceC5869l j() {
        return this.f42588a;
    }

    @Override // E9.F
    public Collection<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return Z8.Y.e();
    }

    public final void l(C5627m c5627m) {
        kotlin.jvm.internal.p.i(c5627m, "<set-?>");
        this.f42591d = c5627m;
    }
}
