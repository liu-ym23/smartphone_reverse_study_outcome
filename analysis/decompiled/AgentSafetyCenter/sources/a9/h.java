package a9;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends j {

    /* renamed from: a, reason: collision with root package name */
    public c f264a;

    /* renamed from: b, reason: collision with root package name */
    public String f265b;

    /* renamed from: c, reason: collision with root package name */
    public String f266c;

    /* renamed from: d, reason: collision with root package name */
    public String f267d;

    /* renamed from: e, reason: collision with root package name */
    public String f268e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f269f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f270g;

    /* renamed from: h, reason: collision with root package name */
    public List f271h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public long f272j;

    @Override // a9.j
    public final String a() {
        return this.f265b;
    }

    @Override // a9.j
    public final String b() throws JSONException {
        List list = this.f271h;
        Integer num = this.f270g;
        String str = this.f268e;
        String str2 = this.f267d;
        List list2 = this.i;
        JSONObject jSONObjectPut = new JSONObject().put("ok", false).put("code", this.f264a.f254c).put("message", this.f265b);
        String str3 = this.f266c;
        if (str3 != null && !hc.h.g0(str3)) {
            jSONObjectPut.put("method", str3);
        }
        if (str2 != null && !hc.h.g0(str2)) {
            jSONObjectPut.put("original_path", str2);
        }
        if (str != null) {
            String str4 = !hc.h.g0(str) ? str : null;
            if (str4 != null) {
                Integer num2 = this.f269f;
                jSONObjectPut.put(str4, num2 != null ? num2.intValue() : 0);
            }
        }
        if (num != null) {
            jSONObjectPut.put("error_count", num.intValue());
        }
        if (!list.isEmpty()) {
            jSONObjectPut.put("errors", new JSONArray((Collection) kb.l.J0(list, 10)));
        }
        if (list2 != null && !list2.isEmpty() && list2.size() > 1) {
            jSONObjectPut.put("original_paths", new JSONArray((Collection) list2));
        }
        if (str3 != null || str != null || num != null || (list2 != null && !list2.isEmpty())) {
            jSONObjectPut.put("timestamp", this.f272j);
        }
        String string = jSONObjectPut.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f264a == hVar.f264a && yb.k.a(this.f265b, hVar.f265b) && yb.k.a(this.f266c, hVar.f266c) && yb.k.a(this.f267d, hVar.f267d) && yb.k.a(this.f268e, hVar.f268e) && yb.k.a(this.f269f, hVar.f269f) && yb.k.a(this.f270g, hVar.f270g) && this.f271h.equals(hVar.f271h) && yb.k.a(this.i, hVar.i) && this.f272j == hVar.f272j;
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(this.f264a.hashCode() * 31, 31, this.f265b);
        String str = this.f266c;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f267d;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f268e;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f269f;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f270g;
        int iE = androidx.activity.b.e(this.f271h, (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31, 31);
        List list = this.i;
        return Long.hashCode(this.f272j) + ((iE + (list != null ? list.hashCode() : 0)) * 31);
    }

    public final String toString() {
        c cVar = this.f264a;
        String str = this.f265b;
        String str2 = this.f266c;
        String str3 = this.f267d;
        String str4 = this.f268e;
        Integer num = this.f269f;
        Integer num2 = this.f270g;
        List list = this.f271h;
        List list2 = this.i;
        long j10 = this.f272j;
        StringBuilder sb2 = new StringBuilder("Error(code=");
        sb2.append(cVar);
        sb2.append(", message=");
        sb2.append(str);
        sb2.append(", method=");
        androidx.activity.b.u(sb2, str2, ", originalPath=", str3, ", affectedCountName=");
        sb2.append(str4);
        sb2.append(", affectedCount=");
        sb2.append(num);
        sb2.append(", errorCount=");
        sb2.append(num2);
        sb2.append(", errors=");
        sb2.append(list);
        sb2.append(", originalPaths=");
        sb2.append(list2);
        sb2.append(", timestamp=");
        sb2.append(j10);
        sb2.append(")");
        return sb2.toString();
    }
}
