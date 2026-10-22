package L;

import W3.C0403n;
import i4.InterfaceC0761a;
import java.io.File;
import java.util.List;
import s4.I;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3691a = new g();

    private g() {
    }

    public final <T> f<T> a(k<T> kVar, M.b<T> bVar, List<? extends d<T>> list, I i5, InterfaceC0761a<? extends File> interfaceC0761a) {
        j4.k.g(kVar, "serializer");
        j4.k.g(list, "migrations");
        j4.k.g(i5, "scope");
        j4.k.g(interfaceC0761a, "produceFile");
        return new m(interfaceC0761a, kVar, C0403n.b(e.f3673a.b(list)), new M.a(), i5);
    }
}
