package V4;

/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final String f1380a;
    public final String b;
    public final String c;
    public final long d;

    public u(String id, String str, String str2, long j5) {
        kotlin.jvm.internal.k.f(id, "id");
        this.f1380a = id;
        this.b = str;
        this.c = str2;
        this.d = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.k.b(this.f1380a, uVar.f1380a) && kotlin.jvm.internal.k.b(this.b, uVar.b) && kotlin.jvm.internal.k.b(this.c, uVar.c) && this.d == uVar.d;
    }

    public final int hashCode() {
        int iHashCode = this.f1380a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return Long.hashCode(this.d) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("RemoteChatMessage(id=", this.f1380a, ", role=", this.b, ", content=");
        B7.a.y(this.d, this.c, ", time=", sbW);
        sbW.append(")");
        return sbW.toString();
    }
}
