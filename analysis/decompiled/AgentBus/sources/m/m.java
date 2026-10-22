package m;

import n.l0;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final n0.e f6077a;

    /* renamed from: b, reason: collision with root package name */
    public final q7.m f6078b;

    /* renamed from: c, reason: collision with root package name */
    public final l0 f6079c;

    /* JADX WARN: Multi-variable type inference failed */
    public m(n0.e eVar, p7.k kVar, l0 l0Var) {
        this.f6077a = eVar;
        this.f6078b = (q7.m) kVar;
        this.f6079c = l0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f6077a.equals(mVar.f6077a) && this.f6078b.equals(mVar.f6078b) && this.f6079c.equals(mVar.f6079c);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ((this.f6079c.hashCode() + ((this.f6078b.hashCode() + (this.f6077a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ChangeSize(alignment=" + this.f6077a + ", size=" + this.f6078b + ", animationSpec=" + this.f6079c + ", clip=true)";
    }
}
