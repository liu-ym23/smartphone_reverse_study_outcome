package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f902a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f903b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f904c;

    public l(Object obj, Object obj2, Object obj3) {
        this.f902a = obj;
        this.f903b = obj2;
        this.f904c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.p.a(this.f902a, lVar.f902a) && kotlin.jvm.internal.p.a(this.f903b, lVar.f903b) && kotlin.jvm.internal.p.a(this.f904c, lVar.f904c);
    }

    public final int hashCode() {
        Object obj = this.f902a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f903b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f904c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f902a + ", " + this.f903b + ", " + this.f904c + ')';
    }
}
