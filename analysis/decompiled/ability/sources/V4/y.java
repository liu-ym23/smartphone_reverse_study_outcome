package V4;

/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f1383a;

    public y(String sessionKey) {
        kotlin.jvm.internal.k.f(sessionKey, "sessionKey");
        this.f1383a = sessionKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && kotlin.jvm.internal.k.b(this.f1383a, ((y) obj).f1383a);
    }

    public final int hashCode() {
        return this.f1383a.hashCode();
    }

    public final String toString() {
        return B7.a.m("SyncHistoryRequest(sessionKey=", this.f1383a, ")");
    }
}
