package r4;

import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5089a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f5090b;

    public a(String str, w4.a aVar) {
        this.f5089a = str;
        this.f5090b = aVar;
        if (n.t1(str)) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return p.a(this.f5089a, aVar.f5089a) && p.a(this.f5090b, aVar.f5090b);
    }

    public final int hashCode() {
        return this.f5090b.hashCode() + (this.f5089a.hashCode() * 31);
    }

    public final String toString() {
        return "AttributeKey: " + this.f5089a;
    }
}
