package m4;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6147f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f6148g;

    public /* synthetic */ a(String str, int i2) {
        this.f6147f = i2;
        this.f6148g = str;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        JSONObject jSONObjectOptJSONObject;
        switch (this.f6147f) {
            case 0:
                JSONObject jSONObject = (JSONObject) obj;
                q7.k.e(jSONObject, "cfg");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("channels");
                if (jSONObjectOptJSONObject2 != null) {
                    jSONObjectOptJSONObject2.remove(this.f6148g);
                }
                return c7.r.f1986a;
            case 1:
                JSONObject jSONObject2 = (JSONObject) obj;
                q7.k.e(jSONObject2, "cfg");
                JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("skills");
                if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("entries")) != null) {
                    jSONObjectOptJSONObject.remove(this.f6148g);
                }
                return c7.r.f1986a;
            default:
                Map map = (Map) obj;
                q7.k.e(map, "it");
                Object obj2 = map.get("jobId");
                return Boolean.valueOf(q7.k.a(obj2 instanceof String ? (String) obj2 : null, this.f6148g));
        }
    }
}
