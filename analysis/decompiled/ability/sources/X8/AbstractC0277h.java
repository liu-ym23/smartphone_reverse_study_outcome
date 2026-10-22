package X8;

import d9.C1395p;
import i8.C1560f;
import i8.InterfaceC1561g;
import kotlin.jvm.internal.PropertyReference1Impl;

/* renamed from: X8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0277h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Z7.t[] f1532a;
    public static final C1395p b;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        f1532a = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.c(AbstractC0277h.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
        O2.a aVar = H.b;
        Z7.d dVarB = nVar.b(C0276g.class);
        aVar.getClass();
        String strL = dVarB.l();
        kotlin.jvm.internal.k.c(strL);
        b = new C1395p(aVar.o(strL));
    }

    public static final InterfaceC1561g a(H h) {
        InterfaceC1561g interfaceC1561g;
        kotlin.jvm.internal.k.f(h, "<this>");
        C0276g c0276g = (C0276g) b.getValue(h, f1532a[0]);
        return (c0276g == null || (interfaceC1561g = c0276g.f1531a) == null) ? C1560f.f4611a : interfaceC1561g;
    }
}
