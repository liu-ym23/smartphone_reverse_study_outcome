package V4;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f1381a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;

    public v(String sessionKey, String sessionId, String title, long j5, long j6) {
        kotlin.jvm.internal.k.f(sessionKey, "sessionKey");
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(title, "title");
        this.f1381a = sessionKey;
        this.b = sessionId;
        this.c = title;
        this.d = j5;
        this.e = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return kotlin.jvm.internal.k.b(this.f1381a, vVar.f1381a) && kotlin.jvm.internal.k.b(this.b, vVar.b) && kotlin.jvm.internal.k.b(this.c, vVar.c) && this.d == vVar.d && this.e == vVar.e;
    }

    public final int hashCode() {
        return Long.hashCode(this.e) + androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(this.f1381a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("RemoteConversation(sessionKey=", this.f1381a, ", sessionId=", this.b, ", title=");
        B7.a.y(this.d, this.c, ", createdAt=", sbW);
        sbW.append(", updatedAt=");
        sbW.append(this.e);
        sbW.append(")");
        return sbW.toString();
    }
}
