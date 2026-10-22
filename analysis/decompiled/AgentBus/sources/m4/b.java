package m4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6154f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f6155g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f6156h;

    public /* synthetic */ b(String str, int i2, boolean z4) {
        this.f6154f = i2;
        this.f6155g = z4;
        this.f6156h = str;
    }

    @Override // p7.k
    public final Object invoke(Object obj) throws JSONException {
        String str;
        Object next;
        switch (this.f6154f) {
            case 0:
                JSONObject jSONObject = (JSONObject) obj;
                q7.k.e(jSONObject, "cfg");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tools");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("tools", jSONObjectOptJSONObject);
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("deny");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                    jSONObjectOptJSONObject.put("deny", jSONArrayOptJSONArray);
                }
                Iterator it = nb.i.N(0, jSONArrayOptJSONArray.length()).iterator();
                while (true) {
                    v7.c cVar = (v7.c) it;
                    boolean zHasNext = cVar.hasNext();
                    str = this.f6156h;
                    if (zHasNext) {
                        next = cVar.next();
                        if (q7.k.a(jSONArrayOptJSONArray.optString(((Number) next).intValue()), str)) {
                        }
                    } else {
                        next = null;
                    }
                }
                Integer num = (Integer) next;
                if (this.f6155g) {
                    if (num != null) {
                        jSONArrayOptJSONArray.remove(num.intValue());
                    }
                } else if (num == null) {
                    jSONArrayOptJSONArray.put(str);
                }
                break;
            default:
                Map map = (Map) obj;
                q7.k.e(map, "cfg");
                Object obj2 = map.get("tools");
                Map linkedHashMap = q7.z.f(obj2) ? (Map) obj2 : null;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    map.put("tools", linkedHashMap);
                }
                Object obj3 = linkedHashMap.get("deny");
                List arrayList = q7.z.e(obj3) ? (List) obj3 : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put("deny", arrayList);
                }
                boolean z4 = this.f6155g;
                String str2 = this.f6156h;
                if (z4) {
                    arrayList.remove(str2);
                } else if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
                break;
        }
        return c7.r.f1986a;
    }
}
