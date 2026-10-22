package w4;

import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import v5.c;
import v5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f6200a;

    /* renamed from: b, reason: collision with root package name */
    public final i f6201b;

    public a(c cVar, i iVar) {
        this.f6200a = cVar;
        this.f6201b = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        i iVar = this.f6201b;
        if (iVar == null) {
            a aVar = (a) obj;
            if (aVar.f6201b == null) {
                return p.a(this.f6200a, aVar.f6200a);
            }
        }
        return p.a(iVar, ((a) obj).f6201b);
    }

    public final int hashCode() {
        i iVar = this.f6201b;
        return iVar != null ? iVar.hashCode() : ((h) this.f6200a).hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TypeInfo(");
        Object obj = this.f6201b;
        if (obj == null) {
            obj = this.f6200a;
        }
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }
}
