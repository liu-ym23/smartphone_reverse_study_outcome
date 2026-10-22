package y8;

import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public y f15959a;

    /* renamed from: b, reason: collision with root package name */
    public y f15960b;

    public final String a() {
        String string = new JSONObject().put("rules", new JSONObject(this.f15959a.f16022c)).put("grants", new JSONObject(this.f15960b.f16022c)).toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f15959a.equals(eVar.f15959a) && this.f15960b.equals(eVar.f15960b);
    }

    public final int hashCode() {
        return this.f15960b.hashCode() + (this.f15959a.hashCode() * 31);
    }

    public final String toString() {
        return "LedgerBundle(rules=" + this.f15959a + ", grants=" + this.f15960b + ")";
    }
}
