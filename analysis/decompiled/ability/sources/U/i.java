package U;

import D9.n;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f1248a = 0;
    public final JSONObject b = new JSONObject();
    public final ArrayList c = new ArrayList();
    public final R5.b d = new R5.b();
    public final g e = new g();
    public JSONObject f = new JSONObject();
    public final h g = new h();
    public final d h = new d();
    public final O2.a i = new O2.a(3);

    /* renamed from: j, reason: collision with root package name */
    public final f f1249j = new f();
    public final c k = new c();
    public String l;
    public String m;
    public final n n;

    public i() {
        n nVar = new n();
        nVar.f443a = "";
        nVar.b = H.h.g();
        this.n = nVar;
    }

    public final String toString() {
        n nVar = this.n;
        O2.a aVar = this.i;
        f fVar = this.f1249j;
        h hVar = this.g;
        R5.b bVar = this.d;
        g gVar = this.e;
        d dVar = this.h;
        JSONObject jSONObject = this.b;
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList = this.c;
        if (!arrayList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((e) it.next()).f1244a);
            }
            try {
                jSONObject2.put("address_list", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jSONObject.put("dns", jSONObject2);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("remote", (String) bVar.b);
            jSONObject3.put("remote_host", (String) bVar.c);
            jSONObject3.put("remote_port", (String) bVar.d);
            jSONObject3.put("socket_reused", bVar.f1153a);
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("socket", jSONObject3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("code", gVar.f1246a);
            jSONObject4.put("sent_bytes", gVar.b);
            jSONObject4.put("received_bytes", gVar.c);
            jSONObject4.put("via_proxy", gVar.d);
            jSONObject4.put("network_accessed", gVar.e);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("response", jSONObject4);
        } catch (JSONException e12) {
            e12.printStackTrace();
        }
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6.put(TypedValues.TransitionType.S_DURATION, hVar.b);
            jSONObject6.put("request_sent_time", hVar.c);
            jSONObject6.put("response_recv_time", hVar.d);
            jSONObject6.put("start_time", hVar.f1247a);
            jSONObject5.put("request", jSONObject6);
        } catch (JSONException e13) {
            e13.printStackTrace();
        }
        JSONObject jSONObject7 = new JSONObject();
        try {
            jSONObject7.put("ttfb", dVar.e);
            jSONObject7.put("dns", dVar.f1243a);
            jSONObject7.put("tcp", dVar.b);
            jSONObject7.put("ssl", dVar.c);
            jSONObject7.put("send", dVar.d);
            jSONObject7.put("header_recv", dVar.f);
            jSONObject7.put("body_recv", dVar.g);
            jSONObject5.put("detailed_duration", jSONObject7);
        } catch (JSONException e14) {
            e14.printStackTrace();
        }
        try {
            jSONObject.put("timing", jSONObject5);
        } catch (JSONException e15) {
            e15.printStackTrace();
        }
        JSONObject jSONObject8 = new JSONObject();
        try {
            jSONObject8.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, (String) aVar.b);
            jSONObject8.put(BffConstant.Type.Url, (String) aVar.c);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        try {
            jSONObject.put("base", jSONObject8);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        JSONObject jSONObject9 = new JSONObject();
        try {
            jSONObject9.put("stack", fVar.f1245a);
            jSONObject9.put("error_msg", (String) fVar.c);
            jSONObject9.put("error_class", (String) fVar.d);
            jSONObject9.put("error_code", fVar.b);
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        try {
            jSONObject.put("error", jSONObject9);
        } catch (JSONException e19) {
            e19.printStackTrace();
        }
        JSONObject jSONObject10 = new JSONObject();
        try {
            c cVar = this.k;
            cVar.d = 0;
            if (cVar.c) {
                cVar.d = 5;
            } else if (cVar.b) {
                if (cVar.f1242a) {
                    cVar.d = 3;
                }
            } else if (cVar.f1242a) {
                cVar.d = 1;
            }
            jSONObject10.put("cache_type", cVar.d);
        } catch (JSONException e20) {
            e20.printStackTrace();
        }
        try {
            jSONObject.put("cache", jSONObject10);
        } catch (JSONException e21) {
            e21.printStackTrace();
        }
        JSONObject jSONObject11 = new JSONObject();
        try {
            jSONObject11.put("libcore", nVar.f443a);
            jSONObject11.put("version", "");
            jSONObject11.put("is_main_process", nVar.b);
        } catch (JSONException e22) {
            e22.printStackTrace();
        }
        try {
            jSONObject.put("other", jSONObject11);
        } catch (JSONException e23) {
            e23.printStackTrace();
        }
        try {
            if (!TextUtils.isEmpty(this.l)) {
                jSONObject.put("external_trace_id", this.l);
            }
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("x-rum-traceparent", this.m);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
