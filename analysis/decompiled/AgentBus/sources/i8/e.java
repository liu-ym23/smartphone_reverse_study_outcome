package i8;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements v9.m0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t9.s f4762a;

    public e(t9.s sVar) {
        this.f4762a = sVar;
    }

    @Override // v9.m0
    public final boolean a() {
        return true;
    }

    @Override // v9.m0
    public final f8.g c() {
        return this.f4762a;
    }

    @Override // v9.m0
    public final Collection d() {
        Collection collectionD = this.f4762a.I0().E0().d();
        q7.k.d(collectionD, "declarationDescriptor.un…pe.constructor.supertypes");
        return collectionD;
    }

    @Override // v9.m0
    public final List getParameters() {
        List list = this.f4762a.f9854v;
        if (list != null) {
            return list;
        }
        q7.k.j("typeConstructorParameters");
        throw null;
    }

    @Override // v9.m0
    public final c8.h n() {
        return l9.d.e(this.f4762a);
    }

    public final String toString() {
        return "[typealias " + this.f4762a.getName().b() + ']';
    }
}
