package N;

import D9.l;
import H.h;
import H.k;
import L0.f;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import l0.AbstractC1654a;
import org.json.JSONArray;
import org.json.JSONObject;
import stepos.support.v7.widget.J;

/* loaded from: classes2.dex */
public abstract class a implements C.a {
    public static final AtomicInteger d = new AtomicInteger(0);
    public volatile boolean b;
    public volatile boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f1003a = new LinkedList();

    public static void a(String str, String str2, JSONObject jSONObject, boolean z10) {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        if (!h.f719x) {
            if (h.b) {
                Log.d("ApmInsight", U7.a.e(new String[]{"can not report，log send return"}));
                return;
            }
            return;
        }
        if (h.b) {
            int iIncrementAndGet = d.incrementAndGet();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("DATA_ID", iIncrementAndGet);
                jSONObject3.put("DATA_PROCESS", D2.b.a());
                jSONObject.put("DATA_DOCTOR", jSONObject3);
                AbstractC1654a.f5271a.b("DATA_RECEIVE", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.equals(str, "timer")) {
            JSONObject jSONObject4 = jSONObject == null ? new JSONObject() : jSONObject;
            try {
                if (jSONObject4.isNull("network_type")) {
                    jSONObject4.put("network_type", D2.b.c(h.f711a).f2214a);
                }
                if (jSONObject4.isNull("timestamp") || jSONObject4.optLong("timestamp") <= 0) {
                    jSONObject4.put("timestamp", System.currentTimeMillis());
                }
                if (jSONObject4.isNull("sid")) {
                    jSONObject4.put("sid", h.f());
                }
            } catch (Exception unused) {
            }
        }
        if (z10) {
            JSONArray jSONArray = null;
            if (jSONObject == null) {
                jSONObject2 = null;
            } else {
                try {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                } catch (Exception unused2) {
                    jSONObject2 = jSONObject;
                }
            }
            if (TextUtils.equals(str, "tracing")) {
                if ("batch_tracing".equals(str2)) {
                    if (jSONObject2 != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("wrapper_array_data")) != null) {
                        jSONArray = jSONArrayOptJSONArray;
                    }
                    R0.c cVar = new R0.c();
                    cVar.f1139a = jSONArray;
                    P0.a.b(cVar);
                } else {
                    R0.c cVar2 = new R0.c();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject2);
                    cVar2.f1139a = jSONArray2;
                    P0.a.b(cVar2);
                }
            } else if (TextUtils.equals(str, "common_log")) {
                R0.b bVar = new R0.b(str2, jSONObject2);
                l lVar = P0.a.f1059a;
                N0.a.a(bVar);
            } else {
                R0.b bVar2 = new R0.b(str, jSONObject2);
                l lVar2 = P0.a.f1059a;
                N0.a.a(bVar2);
            }
        }
        L0.d.f925a.c(new A1.a(8));
        if (TextUtils.equals(str, "ui_action")) {
            B1.b bVar3 = (B1.b) Q.a.a().b;
            LinkedList linkedList = (LinkedList) bVar3.c;
            if (linkedList.size() > bVar3.b) {
                linkedList.removeFirst();
            }
            linkedList.addLast(jSONObject);
        }
    }

    public boolean b(b bVar) {
        return true;
    }

    public final void c(b bVar) {
        J j5;
        Looper looperMyLooper = Looper.myLooper();
        f fVar = L0.d.f925a;
        L0.h hVar = fVar.b;
        if (looperMyLooper != ((hVar == null || (j5 = hVar.f928a) == null) ? null : j5.getLooper())) {
            fVar.b(new A.a(6, this, bVar));
        } else {
            e(bVar);
        }
    }

    public abstract void d(b bVar);

    public final void e(b bVar) {
        if (b(bVar)) {
            f(bVar);
            if (this.b) {
                d(bVar);
                return;
            }
            synchronized (this.f1003a) {
                try {
                    if (this.f1003a.size() > 1000) {
                        this.f1003a.poll();
                        if (!this.c) {
                            k.f723a.y("apm_cache_buffer_full");
                            this.c = true;
                        }
                    }
                    this.f1003a.add(bVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void f(b bVar) {
    }

    @Override // C.a
    public final void onReady() {
        this.b = true;
        L0.d.f925a.b(new A6.l(this, 12));
        if (h.b) {
            AbstractC1654a.f5271a.a("APM_SETTING_READY", null);
        }
    }

    @Override // C.a
    public void onRefresh(JSONObject jSONObject, boolean z10) {
    }
}
