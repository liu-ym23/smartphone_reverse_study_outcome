package p9;

import q7.k;
import v9.v;
import v9.z;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: f, reason: collision with root package name */
    public final f8.e f8529f;

    public c(f8.e eVar) {
        this.f8529f = eVar;
    }

    public final boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return k.a(this.f8529f, cVar != null ? cVar.f8529f : null);
    }

    @Override // p9.d
    public final v getType() {
        z zVarK = this.f8529f.k();
        k.d(zVarK, "classDescriptor.defaultType");
        return zVarK;
    }

    public final int hashCode() {
        return this.f8529f.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Class{");
        z zVarK = this.f8529f.k();
        k.d(zVarK, "classDescriptor.defaultType");
        sb2.append(zVarK);
        sb2.append('}');
        return sb2.toString();
    }
}
