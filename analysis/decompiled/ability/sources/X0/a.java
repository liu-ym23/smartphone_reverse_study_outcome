package X0;

import H4.o;
import M0.d;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import cc.dd.ee.dd.cc.ff.cc.c$a;
import g1.AbstractC1451a;
import java.util.HashMap;
import k1.AbstractC1620b;
import org.json.JSONObject;
import v0.C2054a;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public volatile C5.b f1499a;
    public C2054a b;

    public final void a(C5.b bVar, boolean z10) {
        C2054a c2054a;
        JSONObject jSONObjectB;
        if (bVar != null) {
            synchronized (this) {
                this.f1499a = bVar;
            }
            if (!z10 || (c2054a = this.b) == null || ((SharedPreferences) c2054a.f6763a) == null || (jSONObjectB = bVar.b()) == null) {
                return;
            }
            String string = jSONObjectB.toString();
            if (AbstractC1451a.f4467a) {
                o.r("APM-Downgrade", "DowngradeData-save-" + string);
            }
            ((SharedPreferences) c2054a.f6763a).edit().putString("rule", jSONObjectB.toString()).apply();
        }
    }

    public final boolean b(int i, JSONObject jSONObject) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (this.f1499a == null || System.currentTimeMillis() > this.f1499a.b) {
            return true;
        }
        d dVar = (d) AbstractC1620b.a(d.class);
        if (dVar == null) {
            String strValueOf = String.valueOf(i);
            String strOptString = jSONObject.optString("log_type");
            synchronized (this) {
                try {
                    c$a c_a = c$a.SERVICE_MONITOR;
                    if ("service_monitor".equals(strOptString)) {
                        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_SERVICE);
                        b bVar = (b) ((HashMap) this.f1499a.c).get(c_a);
                        if (bVar != null) {
                            JSONObject jSONObject2 = (JSONObject) bVar.b.get(strValueOf);
                            if (jSONObject2 == null || jSONObject2.optInt(strOptString2, -1) == -1) {
                                return bVar.f1500a;
                            }
                            if (jSONObject2.optInt(strOptString2, -1) != 1) {
                                z12 = false;
                            }
                            return z12;
                        }
                    } else {
                        b bVar2 = (b) ((HashMap) this.f1499a.c).get(c$a.OTHER_LOG_TYPE);
                        if (bVar2 != null) {
                            JSONObject jSONObject3 = (JSONObject) bVar2.b.get(strValueOf);
                            if (jSONObject3 == null || jSONObject3.optInt(strOptString, -1) == -1) {
                                return bVar2.f1500a;
                            }
                            if (jSONObject3.optInt(strOptString, -1) != 1) {
                                z12 = false;
                            }
                            return z12;
                        }
                    }
                    return true;
                } finally {
                }
            }
        }
        JSONObject jSONObject4 = (JSONObject) this.f1499a.d;
        C5.b bVar3 = this.f1499a;
        JSONObject jSONObjectB = jSONObject4 != null ? (JSONObject) bVar3.d : bVar3.b();
        if (jSONObject != null && jSONObjectB != null) {
            try {
                String strValueOf2 = String.valueOf(i);
                String strOptString3 = jSONObject.optString(NotificationCompat.CATEGORY_SERVICE);
                synchronized (dVar) {
                    try {
                        if ("event_log".equals(strOptString3)) {
                            String strOptString4 = jSONObject.optString("event_name");
                            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("service_monitor");
                            if (jSONObjectOptJSONObject != null) {
                                z10 = jSONObjectOptJSONObject.optInt("default", 1) == 1;
                                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strValueOf2);
                                if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.optInt(strOptString4, -1) == -1) {
                                    z12 = z10;
                                } else {
                                    z11 = jSONObjectOptJSONObject2.optInt(strOptString4, -1) == 1;
                                    z12 = z11;
                                }
                            }
                        } else {
                            JSONObject jSONObjectOptJSONObject3 = jSONObjectB.optJSONObject("other");
                            if (jSONObjectOptJSONObject3 != null) {
                                z10 = jSONObjectOptJSONObject3.optInt("default", 1) == 1;
                                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(strValueOf2);
                                if (jSONObjectOptJSONObject4 == null || jSONObjectOptJSONObject4.optInt(strOptString3, -1) == -1) {
                                    z12 = z10;
                                } else {
                                    z11 = jSONObjectOptJSONObject4.optInt(strOptString3, -1) == 1;
                                    z12 = z11;
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (AbstractC1451a.f4467a) {
            o.f("APM-Downgrade", z12 + " aid:" + i + " :" + jSONObject.toString());
        }
        return z12;
    }
}
