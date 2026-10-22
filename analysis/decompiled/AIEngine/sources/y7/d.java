package y7;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends l.b {

    /* renamed from: e, reason: collision with root package name */
    public String f14172e;
    public ArrayList h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f14173a;

        /* renamed from: b, reason: collision with root package name */
        public String f14174b;

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Tag(tagId=");
            sb2.append(this.f14173a);
            sb2.append(", tagName=");
            return ai.onnxruntime.a.o(sb2, this.f14174b, ")");
        }
    }

    public static d g(String str) throws JSONException {
        s7.a.a("BasicStatus", "string to sub tags status start");
        s7.a.a("BasicStatus", "string to sub tags status start, statusText: " + str);
        try {
            d dVar = new d();
            JSONObject jSONObject = new JSONObject(str);
            l.b.d(jSONObject, dVar);
            if (!jSONObject.isNull("push_id")) {
                dVar.f14172e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("tag_list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("tag_list");
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    a aVar = new a();
                    if (!jSONObject2.isNull("tag_id")) {
                        aVar.f14173a = jSONObject2.getInt("tag_id");
                    }
                    if (!jSONObject2.isNull("tag_name")) {
                        aVar.f14174b = jSONObject2.getString("tag_name");
                    }
                    arrayList.add(aVar);
                }
                dVar.h = arrayList;
            }
            s7.a.b("BasicStatus", "string to sub tags status success, SubTagsStatus: " + dVar);
            return dVar;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "string to sub tags status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // l.b
    public final String toString() {
        return " SubTagsStatus(" + super.toString() + ", pushId=" + this.f14172e + ", tagList=" + this.h + ")";
    }
}
