package b7;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f970a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f971b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f972c;
    public final Integer d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f973e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f974f;

    public i(boolean z, Integer num, boolean z2, Integer num2, boolean z8, boolean z9) {
        this.f970a = z;
        this.f971b = num;
        this.f972c = z2;
        this.d = num2;
        this.f973e = z8;
        this.f974f = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f970a == iVar.f970a && p.a(this.f971b, iVar.f971b) && this.f972c == iVar.f972c && p.a(this.d, iVar.d) && this.f973e == iVar.f973e && this.f974f == iVar.f974f;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f970a) * 31;
        Integer num = this.f971b;
        int iG = a8.b.g((iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31, this.f972c);
        Integer num2 = this.d;
        return Boolean.hashCode(this.f974f) + a8.b.g((iG + (num2 != null ? num2.hashCode() : 0)) * 31, 31, this.f973e);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f970a + ", clientMaxWindowBits=" + this.f971b + ", clientNoContextTakeover=" + this.f972c + ", serverMaxWindowBits=" + this.d + ", serverNoContextTakeover=" + this.f973e + ", unknownValues=" + this.f974f + ')';
    }
}
