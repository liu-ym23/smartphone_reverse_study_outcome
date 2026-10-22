package V8;

import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes4.dex */
public class a implements InterfaceC1561g {
    public static final /* synthetic */ Z7.t[] b;

    /* renamed from: a, reason: collision with root package name */
    public final W8.h f1388a;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        b = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public a(W8.l storageManager, S7.a aVar) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.f1388a = new W8.h((W8.i) storageManager, aVar);
    }

    @Override // i8.InterfaceC1561g
    public boolean isEmpty() {
        return ((List) S0.b.g1(this.f1388a, b[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return ((List) S0.b.g1(this.f1388a, b[0])).iterator();
    }

    @Override // i8.InterfaceC1561g
    public final boolean k(G8.c cVar) {
        return N9.j.B(this, cVar);
    }

    @Override // i8.InterfaceC1561g
    public final InterfaceC1556b m(G8.c cVar) {
        return N9.j.q(this, cVar);
    }
}
