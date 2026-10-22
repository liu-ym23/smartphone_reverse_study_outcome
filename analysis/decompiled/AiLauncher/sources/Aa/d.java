package Aa;

import E9.C0818x;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0819y;
import E9.L;
import Z8.C1173v;
import Z8.Y;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class d implements InterfaceC0819y {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1332a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final ga.e f1333b;

    /* renamed from: c, reason: collision with root package name */
    public static final List<InterfaceC0819y> f1334c;

    /* renamed from: d, reason: collision with root package name */
    public static final List<InterfaceC0819y> f1335d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<InterfaceC0819y> f1336e;

    /* renamed from: f, reason: collision with root package name */
    public static final Y8.h f1337f;

    static {
        ga.e eVarM = ga.e.m(ErrorEntity.ERROR_MODULE.getDebugText());
        p.h(eVarM, "special(...)");
        f1333b = eVarM;
        f1334c = C1173v.m();
        f1335d = C1173v.m();
        f1336e = Y.e();
        f1337f = C4848b.b(c.f1331a);
    }

    public static final C9.g c0() {
        return C9.g.f1776h.a();
    }

    @Override // E9.InterfaceC0803h
    public InterfaceC0803h a() {
        return this;
    }

    @Override // E9.InterfaceC0803h
    public InterfaceC0803h b() {
        return null;
    }

    @Override // E9.InterfaceC0819y
    public L f0(ga.c fqName) {
        p.i(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // E9.InterfaceC0819y
    public C9.j g() {
        return (C9.j) f1337f.getValue();
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        return F9.g.f2609m0.b();
    }

    @Override // E9.A
    public ga.e getName() {
        return y0();
    }

    @Override // E9.InterfaceC0819y
    public Collection<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        p.i(fqName, "fqName");
        p.i(nameFilter, "nameFilter");
        return C1173v.m();
    }

    @Override // E9.InterfaceC0819y
    public <T> T q0(C0818x<T> capability) {
        p.i(capability, "capability");
        return null;
    }

    @Override // E9.InterfaceC0819y
    public boolean u(InterfaceC0819y targetModule) {
        p.i(targetModule, "targetModule");
        return false;
    }

    @Override // E9.InterfaceC0819y
    public List<InterfaceC0819y> u0() {
        return f1335d;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> visitor, D d10) {
        p.i(visitor, "visitor");
        return null;
    }

    public ga.e y0() {
        return f1333b;
    }
}
