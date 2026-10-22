package R8;

import X8.A;
import X8.w;
import h8.InterfaceC1522e;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1522e f1159a;

    public c(InterfaceC1522e interfaceC1522e) {
        this.f1159a = interfaceC1522e;
    }

    public final boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return k.b(this.f1159a, cVar != null ? cVar.f1159a : null);
    }

    @Override // R8.d
    public final w getType() {
        A aG = this.f1159a.g();
        k.e(aG, "getDefaultType(...)");
        return aG;
    }

    public final int hashCode() {
        return this.f1159a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Class{");
        A aG = this.f1159a.g();
        k.e(aG, "getDefaultType(...)");
        sb.append(aG);
        sb.append('}');
        return sb.toString();
    }
}
