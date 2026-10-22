package o4;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f7514a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f7515b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7516c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7517d;

    public q(String str, JSONObject jSONObject, int i2, String str2) {
        this.f7514a = str;
        this.f7515b = jSONObject;
        this.f7516c = i2;
        this.f7517d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return q7.k.a(this.f7514a, qVar.f7514a) && q7.k.a(this.f7515b, qVar.f7515b) && this.f7516c == qVar.f7516c && q7.k.a(this.f7517d, qVar.f7517d);
    }

    public final int hashCode() {
        int iHashCode = this.f7514a.hashCode() * 31;
        JSONObject jSONObject = this.f7515b;
        int iB = n.f.b(this.f7516c, (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31, 31);
        String str = this.f7517d;
        return iB + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "PendingRunEnd(sessionKey=" + this.f7514a + ", lifecycleData=" + this.f7515b + ", endSeq=" + this.f7516c + ", triggerRawJson=" + this.f7517d + ")";
    }
}
