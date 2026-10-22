package ma;

import com.stepos.statsapp.v3.lib.plugin.emitter.remote.f;
import java.util.ArrayList;
import java.util.HashMap;
import o1.r;
import o1.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8532a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8533b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8534c;

    public static void b(String str) throws JSONException {
        f fVar;
        try {
            ua.c.a("ConfigController", "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            ua.c.a("ConfigController", "parseConfigJson 2, config json:" + jSONObject);
            ua.c.a("ConfigController", "parseAndApply, version: " + jSONObject.getInt("version"));
            boolean z10 = jSONObject.getBoolean("active");
            JSONObject jSONObject2 = jSONObject.getJSONObject("uploadPolicy");
            boolean z11 = jSONObject2.getBoolean("onStart");
            boolean z12 = jSONObject2.getBoolean("onCharge");
            boolean z13 = jSONObject2.getBoolean("onReconnect");
            long j10 = jSONObject2.getLong("interval") * 60000;
            int i = jSONObject2.getInt("cacheCapacity");
            long j11 = jSONObject2.getLong("mobileQuota");
            int i3 = jSONObject2.getInt("neartimeInterval");
            pa.c cVar = d.f8538a.f8542d;
            if (cVar == null) {
                ua.c.b("SDKInstanceImpl", "getEmitter fail, tracker is null");
                fVar = null;
            } else {
                fVar = cVar.f9933a;
            }
            fVar.e(z10, z11, z12, z13, j10, i, j11, i3);
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                String string = jSONObject3.getString("name");
                map.put(string, new pa.a(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean("neartime")));
            }
            pa.c cVar2 = d.f8538a.f8542d;
            if (cVar2 != null) {
                cVar2.a(map);
            }
        } catch (Exception e10) {
            ua.c.b("ConfigController", "parseAndApply error, " + e10.getMessage());
        }
    }

    public boolean a(long j10) {
        Object obj;
        ArrayList arrayList = (ArrayList) ((n6.a) this.f8534c).f8776c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            if (r.a(((u) obj).f9088a, j10)) {
                break;
            }
            i++;
        }
        u uVar = (u) obj;
        if (uVar != null) {
            return uVar.f9095h;
        }
        return false;
    }
}
