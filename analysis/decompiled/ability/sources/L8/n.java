package L8;

import X8.AbstractC0272c;
import X8.H;
import X8.K;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;

/* loaded from: classes4.dex */
public final class n implements K {

    /* renamed from: a, reason: collision with root package name */
    public final Set f941a;
    public final C7.f b;

    public n(Set set) {
        H.b.getClass();
        H attributes = H.c;
        kotlin.jvm.internal.k.f(attributes, "attributes");
        AbstractC0272c.v(Z8.i.a(ErrorScopeKind.c, true, "unknown integer literal type"), attributes, this, EmptyList.f4893a, false);
        this.b = kotlin.a.a(new l());
        this.f941a = set;
    }

    @Override // X8.K
    public final e8.i c() {
        throw null;
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        return null;
    }

    @Override // X8.K
    public final Collection e() {
        return (List) this.b.getF4884a();
    }

    @Override // X8.K
    public final boolean f() {
        return false;
    }

    @Override // X8.K
    public final List getParameters() {
        return EmptyList.f4893a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IntegerLiteralType");
        sb.append("[" + D7.v.I0(this.f941a, ",", null, null, m.f940a, 30) + ']');
        return sb.toString();
    }
}
