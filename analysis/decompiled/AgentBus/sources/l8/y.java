package l8;

import java.util.Collection;

/* loaded from: classes.dex */
public final class y extends s implements v8.b {

    /* renamed from: a, reason: collision with root package name */
    public final e9.c f5887a;

    public y(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        this.f5887a = cVar;
    }

    @Override // v8.b
    public final e a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof y) {
            return q7.k.a(this.f5887a, ((y) obj).f5887a);
        }
        return false;
    }

    @Override // v8.b
    public final /* bridge */ /* synthetic */ Collection getAnnotations() {
        return d7.z.f2978f;
    }

    public final int hashCode() {
        return this.f5887a.hashCode();
    }

    public final String toString() {
        return y.class.getName() + ": " + this.f5887a;
    }
}
