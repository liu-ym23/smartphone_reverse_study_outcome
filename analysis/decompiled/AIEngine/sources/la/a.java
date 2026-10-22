package la;

import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import java.util.HashMap;
import la.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10378a = false;

    /* renamed from: b, reason: collision with root package name */
    public final String f10379b;

    /* renamed from: c, reason: collision with root package name */
    public sa.a f10380c;

    public a(String str) {
        this.f10379b = str;
    }

    public static void a(String str) {
        V3OfflineEmitter v3OfflineEmitter;
        try {
            ta.c.a("ConfigController", "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            ta.c.a("ConfigController", "parseConfigJson 2, config json:" + jSONObject);
            ta.c.a("ConfigController", "parseAndApply, version: " + jSONObject.getInt("version"));
            boolean z = jSONObject.getBoolean(ModelFlowMeta.KEY_ACTIVE);
            JSONObject jSONObject2 = jSONObject.getJSONObject("uploadPolicy");
            boolean z3 = jSONObject2.getBoolean("onStart");
            boolean z10 = jSONObject2.getBoolean("onCharge");
            boolean z11 = jSONObject2.getBoolean("onReconnect");
            long j10 = jSONObject2.getLong("interval") * HysteresisStrategy.DEFAULT_DWELL_MS;
            int i10 = jSONObject2.getInt("cacheCapacity");
            long j11 = jSONObject2.getLong("mobileQuota");
            int i11 = jSONObject2.getInt("neartimeInterval");
            oa.b bVar = c.a.f10391a.f10386d;
            if (bVar == null) {
                ta.c.b("SDKInstanceImpl", "getEmitter fail, tracker is null");
                v3OfflineEmitter = null;
            } else {
                v3OfflineEmitter = bVar.f10839a;
            }
            v3OfflineEmitter.b(z, z3, z10, z11, j10, i10, j11, i11);
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i12);
                String string = jSONObject3.getString("name");
                map.put(string, new oa.a(string, jSONObject3.getBoolean(ModelFlowMeta.KEY_ACTIVE), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean("neartime")));
            }
            oa.b bVar2 = c.a.f10391a.f10386d;
            if (bVar2 != null) {
                bVar2.a(map);
            }
        } catch (Exception e10) {
            ta.c.b("ConfigController", "parseAndApply error, " + e10.getMessage());
        }
    }
}
