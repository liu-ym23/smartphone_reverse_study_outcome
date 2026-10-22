package a9;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f258a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f259b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return yb.k.a(this.f258a, fVar.f258a) && yb.k.a(this.f259b, fVar.f259b);
    }

    public final int hashCode() {
        return this.f259b.hashCode() + (this.f258a.hashCode() * 31);
    }

    public final String toString() {
        return "RestoreItems(mediaInfos=" + this.f258a + ", garbageRecords=" + this.f259b + ")";
    }
}
