package Aa;

import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import E9.O;
import Z8.C1173v;
import Z8.X;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.B0;
import ya.S;
import ya.v0;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1351a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC0819y f1352b = d.f1332a;

    /* renamed from: c, reason: collision with root package name */
    public static final a f1353c;

    /* renamed from: d, reason: collision with root package name */
    public static final S f1354d;

    /* renamed from: e, reason: collision with root package name */
    public static final S f1355e;

    /* renamed from: f, reason: collision with root package name */
    public static final O f1356f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<O> f1357g;

    static {
        String str = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        p.h(str, "format(...)");
        ga.e eVarM = ga.e.m(str);
        p.h(eVarM, "special(...)");
        f1353c = new a(eVarM);
        f1354d = d(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        f1355e = d(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        e eVar = new e();
        f1356f = eVar;
        f1357g = X.d(eVar);
    }

    public static final f a(ErrorScopeKind kind, boolean z10, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        return z10 ? new j(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)) : new f(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final f b(ErrorScopeKind kind, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        return a(kind, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final g d(ErrorTypeKind kind, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        return f1351a.g(kind, C1173v.m(), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final boolean m(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            return false;
        }
        i iVar = f1351a;
        return iVar.n(interfaceC0803h) || iVar.n(interfaceC0803h.b()) || interfaceC0803h == f1352b;
    }

    public static final boolean o(S s10) {
        if (s10 == null) {
            return false;
        }
        v0 v0VarH0 = s10.H0();
        return (v0VarH0 instanceof h) && ((h) v0VarH0).h() == ErrorTypeKind.UNINFERRED_TYPE_VARIABLE;
    }

    public final g c(ErrorTypeKind kind, v0 typeConstructor, String... formatParams) {
        p.i(kind, "kind");
        p.i(typeConstructor, "typeConstructor");
        p.i(formatParams, "formatParams");
        return f(kind, C1173v.m(), typeConstructor, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final h e(ErrorTypeKind kind, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        return new h(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final g f(ErrorTypeKind kind, List<? extends B0> arguments, v0 typeConstructor, String... formatParams) {
        p.i(kind, "kind");
        p.i(arguments, "arguments");
        p.i(typeConstructor, "typeConstructor");
        p.i(formatParams, "formatParams");
        return new g(typeConstructor, b(ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final g g(ErrorTypeKind kind, List<? extends B0> arguments, String... formatParams) {
        p.i(kind, "kind");
        p.i(arguments, "arguments");
        p.i(formatParams, "formatParams");
        return f(kind, arguments, e(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final a h() {
        return f1353c;
    }

    public final InterfaceC0819y i() {
        return f1352b;
    }

    public final Set<O> j() {
        return f1357g;
    }

    public final S k() {
        return f1355e;
    }

    public final S l() {
        return f1354d;
    }

    public final boolean n(InterfaceC0803h interfaceC0803h) {
        return interfaceC0803h instanceof a;
    }

    public final String p(S type) {
        p.i(type, "type");
        Da.d.z(type);
        v0 v0VarH0 = type.H0();
        p.g(v0VarH0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((h) v0VarH0).i(0);
    }
}
