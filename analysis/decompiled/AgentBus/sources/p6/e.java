package p6;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e extends g6.a {

    /* renamed from: e, reason: collision with root package name */
    public String f8497e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f8498f;

    public static e i(String str) throws JSONException {
        j6.a.a("BasicStatus", "string to sub tags status start");
        j6.a.a("BasicStatus", "string to sub tags status start, statusText: " + str);
        try {
            e eVar = new e(1);
            JSONObject jSONObject = new JSONObject(str);
            g6.a.e(jSONObject, eVar);
            if (!jSONObject.isNull("push_id")) {
                eVar.f8497e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("tag_list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("tag_list");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    d dVar = new d();
                    if (!jSONObject2.isNull("tag_id")) {
                        dVar.f8495a = jSONObject2.getInt("tag_id");
                    }
                    if (!jSONObject2.isNull("tag_name")) {
                        dVar.f8496b = jSONObject2.getString("tag_name");
                    }
                    arrayList.add(dVar);
                }
                eVar.f8498f = arrayList;
            }
            j6.a.b("BasicStatus", "string to sub tags status success, SubTagsStatus: " + eVar);
            return eVar;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "string to sub tags status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final String toString() {
        return " SubTagsStatus(" + super.toString() + ", pushId=" + this.f8497e + ", tagList=" + this.f8498f + ")";
    }
}
