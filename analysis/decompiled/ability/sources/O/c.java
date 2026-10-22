package O;

import B0.d;
import B0.f;
import H.h;
import android.text.TextUtils;
import android.util.Log;
import ca.AbstractC0897f;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends N.a {
    public static final /* synthetic */ int p = 0;
    public volatile ArrayList e;
    public ArrayList f;
    public ArrayList g;
    public ArrayList h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1030j;
    public boolean k;
    public boolean l;
    public String m;
    public final LinkedList n = new LinkedList();
    public boolean o;

    @Override // N.a
    public final boolean b(N.b bVar) {
        return !TextUtils.isEmpty(((P.a) bVar).c);
    }

    @Override // N.a
    public final void d(N.b bVar) {
        P.a aVar = (P.a) bVar;
        if (C4.a.c().b() && this.f1030j) {
            String str = aVar.c;
            if (AbstractC0897f.h(h.f711a) || this.i) {
                boolean z10 = true;
                if ("collect_all".equals(this.m) ? true : "allow_list".equals(this.m) ? S0.b.Z(this.g, this.h, str) : "block_list".equals(this.m) ? !S0.b.Z(this.e, this.f, str) : false) {
                    JSONObject jSONObjectA = aVar.a();
                    S0.b.W(jSONObjectA, aVar.f);
                    if (jSONObjectA == null) {
                        return;
                    }
                    if (jSONObjectA.optInt("data_type") == 3) {
                        z10 = this.k;
                    } else if (!this.k && !this.l) {
                        z10 = false;
                    }
                    if (this.n.size() > 0 && !aVar.f.optBoolean("download", false)) {
                        for (B0.c cVar : this.n) {
                            if (cVar != null) {
                                JSONObject jSONObject = aVar.f;
                                switch (cVar.f173a) {
                                    case 0:
                                        d dVar = (d) cVar.b;
                                        if (dVar.f174a) {
                                            if (h.b) {
                                                Log.i("BizTrafficStats", U7.a.e(new String[]{"deliver ", str, jSONObject.toString()}));
                                            }
                                            dVar.s(str, jSONObject);
                                            break;
                                        } else {
                                            break;
                                        }
                                    default:
                                        f fVar = (f) cVar.b;
                                        if (fVar.b) {
                                            fVar.s(str, jSONObject);
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            }
                        }
                    }
                    if (z10) {
                        try {
                            jSONObjectA.put("is_sample", this.k ? 1 : 0);
                            jSONObjectA.put("filters", O0.a.a().b());
                        } catch (Exception unused) {
                        }
                        N.a.a("network", "network", jSONObjectA, z10);
                    }
                }
            }
        }
    }

    @Override // N.a
    public final void f(N.b bVar) {
        P.a aVar = (P.a) bVar;
        try {
            int i = (ActivityLifeObserver.getInstance() == null ? 1 : !ActivityLifeObserver.getInstance().isForeground() ? 1 : 0) ^ 1;
            JSONObject jSONObject = aVar.f;
            if (jSONObject.isNull("front")) {
                jSONObject.put("front", i);
            }
            if (jSONObject.isNull("net_consume_type")) {
                jSONObject.put("net_consume_type", "network");
            }
        } catch (JSONException unused) {
        }
    }

    @Override // N.a, C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject = (jSONObject == null || TextUtils.isEmpty("network_image_modules")) ? null : jSONObject.optJSONObject("network_image_modules");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = TextUtils.isEmpty("network") ? null : jSONObjectOptJSONObject.optJSONObject("network");
            if (jSONObjectOptJSONObject2 != null) {
                this.o = true;
                this.i = jSONObjectOptJSONObject2.optInt("enable_net_monitor_with_net_disable") == 1;
                this.f1030j = jSONObjectOptJSONObject2.optInt("enable_net_monitor") == 1;
                this.k = jSONObjectOptJSONObject2.optInt("enable_success_net_sample") == 1;
                this.l = jSONObjectOptJSONObject2.optInt("ignore_neterror_sampling") == 1;
                String strOptString = jSONObjectOptJSONObject2.optString("filter_info");
                try {
                    if (TextUtils.isEmpty(strOptString)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    String strOptString2 = jSONObject2.optString("selected", "");
                    this.m = strOptString2;
                    if ("collect_all".equals(strOptString2)) {
                        return;
                    }
                    if ("allow_list".equals(this.m)) {
                        this.g = S0.b.t("allow_list", jSONObject2);
                        this.h = S0.b.k0("allow_list", jSONObject2);
                    } else if ("block_list".equals(this.m)) {
                        this.e = S0.b.t("block_list", jSONObject2);
                        this.f = S0.b.k0("block_list", jSONObject2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
