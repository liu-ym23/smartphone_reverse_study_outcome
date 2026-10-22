package c5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f1095a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1096b;

    public w(int i8, Object obj) {
        this.f1095a = i8;
        this.f1096b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f1095a == wVar.f1095a && kotlin.jvm.internal.p.a(this.f1096b, wVar.f1096b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f1095a) * 31;
        Object obj = this.f1096b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f1095a + ", value=" + this.f1096b + ')';
    }
}
