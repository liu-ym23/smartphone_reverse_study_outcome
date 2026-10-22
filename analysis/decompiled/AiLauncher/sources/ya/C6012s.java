package ya;

import kotlin.jvm.internal.PropertyReference1Impl;
import s9.InterfaceC5452d;
import w9.InterfaceC5752k;

/* renamed from: ya.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6012s {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f44122a = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C6012s.class, "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;", 1))};

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5452d f44123b;

    static {
        InterfaceC5452d interfaceC5452dD = s0.f44124b.d(kotlin.jvm.internal.t.b(r.class));
        kotlin.jvm.internal.p.g(interfaceC5452dD, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        f44123b = interfaceC5452dD;
    }

    public static final F9.g a(s0 s0Var) {
        F9.g gVarE;
        kotlin.jvm.internal.p.i(s0Var, "<this>");
        r rVarB = b(s0Var);
        return (rVarB == null || (gVarE = rVarB.e()) == null) ? F9.g.f2609m0.b() : gVarE;
    }

    public static final r b(s0 s0Var) {
        kotlin.jvm.internal.p.i(s0Var, "<this>");
        return (r) f44123b.getValue(s0Var, f44122a[0]);
    }
}
