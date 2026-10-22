package Aa;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import Z8.C1173v;
import Z8.X;
import Z8.Y;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import p9.InterfaceC5074l;
import ra.C5231d;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public class f implements InterfaceC5238k {

    /* renamed from: b, reason: collision with root package name */
    public final ErrorScopeKind f1339b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1340c;

    public f(ErrorScopeKind kind, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        this.f1339b = kind;
        String debugMessage = kind.getDebugMessage();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(debugMessage, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        p.h(str, "format(...)");
        this.f1340c = str;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        return Y.e();
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        String str = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{name}, 1));
        p.h(str, "format(...)");
        ga.e eVarM = ga.e.m(str);
        p.h(eVarM, "special(...)");
        return new a(eVarM);
    }

    @Override // ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        p.i(kindFilter, "kindFilter");
        p.i(nameFilter, "nameFilter");
        return C1173v.m();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        return Y.e();
    }

    @Override // ra.InterfaceC5238k
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        return X.d(new b(i.f1351a.h()));
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        return Y.e();
    }

    @Override // ra.InterfaceC5238k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<O> a(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        return i.f1351a.j();
    }

    public final String i() {
        return this.f1340c;
    }

    public String toString() {
        return "ErrorScope{" + this.f1340c + '}';
    }
}
