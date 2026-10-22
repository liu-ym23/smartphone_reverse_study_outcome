package k8;

import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;

/* renamed from: k8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1636e implements X8.K {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1637f f4845a;

    public C1636e(AbstractC1637f abstractC1637f) {
        this.f4845a = abstractC1637f;
    }

    @Override // X8.K
    public final e8.i c() {
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(this.f4845a);
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        return this.f4845a;
    }

    @Override // X8.K
    public final Collection e() {
        Collection collectionE = ((V8.t) this.f4845a).T0().Q().e();
        kotlin.jvm.internal.k.e(collectionE, "getSupertypes(...)");
        return collectionE;
    }

    @Override // X8.K
    public final boolean f() {
        return true;
    }

    @Override // X8.K
    public final List getParameters() {
        List list = ((V8.t) this.f4845a).p;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.k.n("typeConstructorParameters");
        throw null;
    }

    public final String toString() {
        return "[typealias " + this.f4845a.getName().b() + ']';
    }
}
