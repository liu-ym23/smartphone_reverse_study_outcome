package d2;

import a2.AbstractC0155a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f extends AbstractC0536a {

    /* renamed from: d, reason: collision with root package name */
    public String f12429d;

    /* renamed from: e, reason: collision with root package name */
    public List f12430e;

    public static f c(String str) throws JSONException {
        AbstractC0155a.a("BasicStatus", "string to sub tags status start");
        AbstractC0155a.a("BasicStatus", "string to sub tags status start, statusText: " + str);
        try {
            f fVar = new f();
            JSONObject jSONObject = new JSONObject(str);
            AbstractC0536a.b(jSONObject, fVar);
            if (!jSONObject.isNull("push_id")) {
                fVar.f12429d = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("tag_list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("tag_list");
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    e eVar = new e();
                    if (!jSONObject2.isNull("tag_id")) {
                        eVar.f12427a = jSONObject2.getInt("tag_id");
                    }
                    if (!jSONObject2.isNull("tag_name")) {
                        eVar.f12428b = jSONObject2.getString("tag_name");
                    }
                    arrayList.add(eVar);
                }
                fVar.f12430e = arrayList;
            }
            AbstractC0155a.b("BasicStatus", "string to sub tags status success, SubTagsStatus: " + fVar);
            return fVar;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "string to sub tags status error, " + e4.getMessage());
            return null;
        }
    }

    @Override // d2.AbstractC0536a
    public final String toString() {
        return " SubTagsStatus(" + super.toString() + ", pushId=" + this.f12429d + ", tagList=" + this.f12430e + ")";
    }
}
