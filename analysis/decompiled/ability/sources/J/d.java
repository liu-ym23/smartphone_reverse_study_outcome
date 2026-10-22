package J;

import H.h;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import w0.C2086g;

/* loaded from: classes2.dex */
public final class d implements L0.e {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f860a = new HashMap();

    public d() {
        L0.d.f925a.a(this);
    }

    @Override // L0.e
    public final void e(long j5) {
        HashMap map = this.f860a;
        if (map.isEmpty()) {
            return;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            b bVar = (b) entry.getValue();
            if (j5 - bVar.b > 120000) {
                it.remove();
                int i = bVar.c;
                float f = i > 0 ? bVar.f858a / i : -1.0f;
                if (h.b) {
                    Log.i("<monitor><perf>", U7.a.e(new String[]{"聚合 fps: " + str + " , value: " + f}));
                }
                if (f > 0.0f) {
                    if (f > 60.0f) {
                        f = 60.0f;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("fps", f);
                        JSONObject jSONObjectA = C2086g.b().a("fps");
                        jSONObjectA.put("scene", str);
                        P.e eVar = new P.e("fps", str, "", jSONObject, jSONObjectA, null);
                        eVar.f = O0.a.a().b();
                        if (h.b) {
                            Log.d("ApmInsight", U7.a.e(new String[]{"Receive:FpsData"}));
                        }
                        O.a.g().c(eVar);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
