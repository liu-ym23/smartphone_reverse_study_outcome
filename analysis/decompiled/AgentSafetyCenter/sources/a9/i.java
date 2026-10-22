package a9;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: a, reason: collision with root package name */
    public String f273a;

    /* renamed from: b, reason: collision with root package name */
    public String f274b;

    /* renamed from: c, reason: collision with root package name */
    public String f275c;

    /* renamed from: d, reason: collision with root package name */
    public int f276d;

    /* renamed from: e, reason: collision with root package name */
    public int f277e;

    /* renamed from: f, reason: collision with root package name */
    public List f278f;

    /* renamed from: g, reason: collision with root package name */
    public String f279g;

    /* renamed from: h, reason: collision with root package name */
    public List f280h;
    public long i;

    @Override // a9.j
    public final String a() {
        int i = this.f276d;
        String str = this.f275c;
        if (!str.equals("trashed_count")) {
            return str.equals("restored_count") ? k0.a.k(i, "已为您恢复", "个文件") : "操作成功";
        }
        return i + "个文件已经放入回收站";
    }

    @Override // a9.j
    public final String b() throws JSONException {
        String str;
        String str2 = this.f279g;
        int i = this.f276d;
        List list = this.f280h;
        JSONObject jSONObject = new JSONObject();
        String str3 = this.f275c;
        if (str3.equals("trashed_count")) {
            str = i + "个文件已经放入回收站";
        } else {
            str = null;
        }
        if (str != null) {
            jSONObject.put("总结", str);
        }
        jSONObject.put("ok", true).put("method", this.f273a).put("original_path", this.f274b).put(str3, i).put("error_count", this.f277e).put("timestamp", this.i).put("errors", new JSONArray((Collection) kb.l.J0(this.f278f, 10)));
        if (list != null && !list.isEmpty() && list.size() > 1) {
            jSONObject.put("original_paths", new JSONArray((Collection) list));
        }
        if (str2 != null && !hc.h.g0(str2)) {
            jSONObject.put("display_name", str2);
        }
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f273a.equals(iVar.f273a) && yb.k.a(this.f274b, iVar.f274b) && this.f275c.equals(iVar.f275c) && this.f276d == iVar.f276d && this.f277e == iVar.f277e && this.f278f.equals(iVar.f278f) && yb.k.a(this.f279g, iVar.f279g) && yb.k.a(this.f280h, iVar.f280h) && this.i == iVar.i;
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f278f, s.f.b(this.f277e, s.f.b(this.f276d, androidx.activity.b.d(androidx.activity.b.d(this.f273a.hashCode() * 31, 31, this.f274b), 31, this.f275c), 31), 31), 31);
        String str = this.f279g;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        List list = this.f280h;
        return Long.hashCode(this.i) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String str = this.f273a;
        String str2 = this.f274b;
        String str3 = this.f275c;
        int i = this.f276d;
        int i3 = this.f277e;
        List list = this.f278f;
        String str4 = this.f279g;
        List list2 = this.f280h;
        long j10 = this.i;
        StringBuilder sbP = androidx.activity.b.p("Success(method=", str, ", originalPath=", str2, ", affectedCountName=");
        sbP.append(str3);
        sbP.append(", affectedCount=");
        sbP.append(i);
        sbP.append(", errorCount=");
        sbP.append(i3);
        sbP.append(", errors=");
        sbP.append(list);
        sbP.append(", displayName=");
        sbP.append(str4);
        sbP.append(", originalPaths=");
        sbP.append(list2);
        sbP.append(", timestamp=");
        sbP.append(j10);
        sbP.append(")");
        return sbP.toString();
    }
}
