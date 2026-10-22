package W0;

import android.util.Log;
import ca.AbstractC0897f;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.HashMap;
import k1.AbstractC1620b;
import o1.AbstractC1755a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m implements n {
    @Override // W0.n
    public final String a() {
        return "log";
    }

    @Override // W0.n
    public final ArrayList b() {
        g gVar = f.f1476a;
        T0.a aVar = gVar.l;
        return (aVar == null || S0.b.r0(aVar.b)) ? gVar.f : gVar.l.b;
    }

    @Override // W0.n
    public final byte[] c(HashMap map) {
        U0.a aVarA;
        try {
            JSONArray jSONArray = new JSONArray();
            for (Long l : map.keySet()) {
                U0.a aVarA2 = U0.b.b().a(String.valueOf(l));
                if (aVarA2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SettingsConfig.KEY_DATA, map.get(l));
                    jSONObject.put("header", AbstractC0897f.f(aVarA2));
                    jSONArray.put(jSONObject);
                } else if (AbstractC1451a.f4467a) {
                    String str = S0.a.f1163a;
                    String str2 = "HeaderInfo null for key " + l;
                    if (AbstractC1451a.f4467a) {
                        Log.w(str, str2);
                    }
                }
            }
            JSONArray jSONArrayC = d.f1474a.c();
            if (jSONArrayC.length() > 0 && (aVarA = U0.b.b().a(String.valueOf(AbstractC0897f.a()))) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SettingsConfig.KEY_DATA, jSONArrayC);
                jSONObject2.put("header", AbstractC0897f.f(aVarA));
                jSONArray.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("list", jSONArray);
            if (AbstractC1451a.f4467a) {
                H4.o.f(S0.a.f1163a, "request:" + jSONObject3);
            }
            if (((M0.e) AbstractC1620b.a(M0.e.class)) != null) {
                M0.e.a(jSONObject3);
            }
            return AbstractC1755a.a(jSONObject3.toString());
        } catch (Exception unused) {
            return null;
        }
    }
}
