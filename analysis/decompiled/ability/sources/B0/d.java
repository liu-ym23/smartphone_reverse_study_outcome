package B0;

import H.h;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import ca.AbstractC0897f;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f174a;
    public boolean b;
    public HashMap c;
    public HashMap d;
    public HashMap e;
    public HashMap f;
    public HashMap g;
    public HashMap h;
    public volatile long i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f175j;
    public double k;
    public c l;

    @Override // B0.b
    public final void a() {
        this.f174a = true;
        this.b = true;
        int i = O.c.p;
        O.c cVar = O.b.f1029a;
        c cVar2 = this.l;
        if (cVar.n.contains(cVar2) || cVar2 == null) {
            return;
        }
        cVar.n.add(cVar2);
    }

    @Override // B0.b
    public final void b(String str) {
        if (this.f175j == null) {
            this.f175j = new HashMap();
        }
        this.f175j.put(str, new HashMap());
    }

    @Override // B0.b
    public final void c(JSONObject jSONObject) {
    }

    @Override // B0.b
    public final void clear() {
        HashMap map = this.c;
        if (map != null) {
            map.clear();
        }
        HashMap map2 = this.d;
        if (map2 != null) {
            map2.clear();
        }
        HashMap map3 = this.e;
        if (map3 != null) {
            map3.clear();
        }
        HashMap map4 = this.f;
        if (map4 != null) {
            map4.clear();
        }
        HashMap map5 = this.g;
        if (map5 != null) {
            map5.clear();
        }
        this.i = 0L;
    }

    @Override // B0.b
    public final Map d() {
        return this.d;
    }

    public final void e(long j5, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zP = AbstractC0897f.p(h.f711a);
        boolean zIsForeground = ActivityLifeObserver.getInstance().isForeground();
        if (this.b && j5 > this.k) {
            String.format("trafficBytes: %d, sourceId: %s, business: %s, isWifi: %b, isFront: %b", Long.valueOf(j5), str2, str, Boolean.valueOf(zP), Boolean.valueOf(zIsForeground));
        }
        if (h.b) {
            Log.i("APM-TrafficInfo", U7.a.e(new String[]{String.format("trafficBytes: %d, sourceId: %s, business: %s, isWifi: %b, isFront: %b", Long.valueOf(j5), str2, str, Boolean.valueOf(zP), Boolean.valueOf(zIsForeground))}));
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        if (this.e == null) {
            this.e = new HashMap();
        }
        if (this.f == null) {
            this.f = new HashMap();
        }
        if (this.g == null) {
            this.g = new HashMap();
        }
        if (this.c.containsKey(str)) {
            ((a) this.c.get(str)).c(j5, str2);
        } else {
            a aVar = new a(str);
            aVar.c(j5, str2);
            this.c.put(str, aVar);
        }
        if (zP && !zIsForeground) {
            if (this.d.containsKey(str)) {
                ((a) this.d.get(str)).c(j5, str2);
            } else {
                a aVar2 = new a(str);
                aVar2.c(j5, str2);
                this.d.put(str, aVar2);
            }
        }
        if (zP && zIsForeground) {
            if (this.e.containsKey(str)) {
                ((a) this.e.get(str)).c(j5, str2);
            } else {
                a aVar3 = new a(str);
                aVar3.c(j5, str2);
                this.e.put(str, aVar3);
            }
        }
        if (!zP && !zIsForeground) {
            if (this.f.containsKey(str)) {
                ((a) this.f.get(str)).c(j5, str2);
            } else {
                a aVar4 = new a(str);
                aVar4.c(j5, str2);
                this.f.put(str, aVar4);
            }
        }
        if (!zP && zIsForeground) {
            if (this.g.containsKey(str)) {
                ((a) this.g.get(str)).c(j5, str2);
            } else {
                a aVar5 = new a(str);
                aVar5.c(j5, str2);
                this.g.put(str, aVar5);
            }
        }
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey(str)) {
            ((a) this.h.get(str)).c(j5, str2);
        } else {
            a aVar6 = new a(str);
            aVar6.c(j5, str2);
            this.h.put(str, aVar6);
        }
        HashMap map = this.f175j;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map map2 = (Map) ((Map.Entry) it.next()).getValue();
                if (map2.containsKey(str)) {
                    ((a) map2.get(str)).c(j5, str2);
                } else {
                    a aVar7 = new a(str);
                    aVar7.c(j5, str2);
                    map2.put(str, aVar7);
                }
            }
        }
    }

    @Override // B0.b
    public final Map f() {
        return this.c;
    }

    @Override // B0.b
    public final Map g() {
        return this.h;
    }

    @Override // B0.b
    public final Map h() {
        return this.e;
    }

    @Override // B0.b
    public final void k(long j5, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f174a) {
            L0.d.f925a.b(new A2.b(this, str2, j5, str));
            boolean zP = AbstractC0897f.p(h.f711a);
            boolean zIsForeground = ActivityLifeObserver.getInstance().isForeground();
            if (this.b && j5 > this.k) {
                String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s, isWifi: %b, isFront: %b", Long.valueOf(j5), str, str2, str3 == null ? "" : str3, jSONObject == null ? "" : jSONObject.toString(), jSONObject2 == null ? "" : jSONObject2.toString(), Boolean.valueOf(zP), Boolean.valueOf(zIsForeground));
            }
            if (h.b) {
                Log.i("APM-TrafficInfo", U7.a.e(new String[]{String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s, isWifi: %b, isFront: %b", Long.valueOf(j5), str, str2, str3 == null ? "" : str3, jSONObject == null ? "" : jSONObject.toString(), jSONObject2 != null ? jSONObject2.toString() : "", Boolean.valueOf(zP), Boolean.valueOf(zIsForeground))}));
            }
            this.i += j5;
        }
    }

    @Override // B0.b
    public final void l(String str) {
        HashMap map = this.f175j;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // B0.b
    public final void m(double d) {
        this.k = d;
    }

    @Override // B0.b
    public final void o(double d) {
    }

    @Override // B0.b
    public final Map q() {
        return this.f;
    }

    @Override // B0.b
    public final void s(String str, JSONObject jSONObject) {
        if (!this.f174a || TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("request_log");
            if (jSONObjectOptJSONObject == null) {
                String strOptString = jSONObject.optString("request_log");
                if (!TextUtils.isEmpty(strOptString)) {
                    jSONObjectOptJSONObject = new JSONObject(strOptString);
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("response");
            long jOptLong = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optLong("received_bytes") + jSONObjectOptJSONObject2.optLong("sent_bytes") : 0L;
            this.i += jOptLong;
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("other");
            String strOptString2 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("libcore") : "okhttp";
            if (!TextUtils.isEmpty(str)) {
                try {
                    str = Uri.parse(str).buildUpon().clearQuery().build().toString();
                } catch (Exception unused) {
                }
            }
            e(jOptLong, strOptString2, str);
            A0.c.f69a.b(jOptLong, path);
        } catch (Throwable unused2) {
        }
    }

    @Override // B0.b
    public final Map c(String str) {
        if (this.f175j == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (Map) this.f175j.get(str);
    }

    @Override // B0.b
    public final long b() {
        return this.i;
    }

    @Override // B0.b
    public final Map c() {
        return this.g;
    }
}
