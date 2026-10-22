package s;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import e2.C1404a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v.C2053a;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f5975a;
    public final Context b;
    public final g c;
    public final SharedPreferences f;
    public final A5.c g;
    public final ArrayList e = new ArrayList(32);
    public int h = 0;
    public volatile JSONObject d = new JSONObject();

    public h(Application application, g gVar) {
        this.b = application;
        this.c = gVar;
        this.f = gVar.e;
        j jVar = (j) j.c.get(gVar);
        if (jVar == null) {
            synchronized (j.class) {
                try {
                    jVar = (j) j.c.get(gVar);
                    if (jVar == null) {
                        if (application == null) {
                            throw new IllegalArgumentException("context == null");
                        }
                        jVar = new j();
                        jVar.b = new C2053a(application);
                        if (jVar.f5976a == null) {
                            jVar.f5976a = new A5.c(application, gVar, jVar.b);
                        }
                    }
                } finally {
                }
            }
        }
        this.g = jVar.f5976a;
        HashMap map = gVar.b.k;
        JSONObject jSONObject = null;
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f5975a) {
                jSONObject = this.d.optJSONObject("custom");
            } else {
                try {
                    jSONObject = new JSONObject(gVar.c.getString("header_custom_info", null));
                } catch (Exception unused) {
                }
            }
            if (jSONObject != null) {
                U7.a.k(jSONObject2, jSONObject);
            }
            try {
                for (Map.Entry entry : map.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                w.h.a("", e);
            }
            jSONObject = jSONObject2;
        }
        if (c(jSONObject, "custom")) {
            this.c.c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }

    public static void b(String str, JSONObject jSONObject, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public final String a() {
        return this.d.optString("aid", this.c.b.f4335a);
    }

    public final boolean c(Object obj, String str) {
        boolean z10;
        Object objOpt = this.d.opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z10 = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    U7.a.k(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e) {
                    w.h.b(e);
                }
            }
            z10 = true;
        }
        w.h.a("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z10;
    }

    public final JSONObject d() {
        if (this.f5975a) {
            return this.d;
        }
        return null;
    }

    public final int e() {
        String strOptString = this.d.optString("device_id", "");
        String strOptString2 = this.d.optString("install_id", "");
        String strOptString3 = this.d.optString("bd_did", "");
        if ((U7.a.l(strOptString) || U7.a.l(strOptString3)) && U7.a.l(strOptString2)) {
            return this.f.getInt("version_code", 0) == this.d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public final int f() {
        int iOptInt = this.f5975a ? this.d.optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            h();
            iOptInt = this.f5975a ? this.d.optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public final String g() {
        String strOptString = this.f5975a ? this.d.optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            h();
            strOptString = this.f5975a ? this.d.optString("app_version", null) : null;
        }
        return strOptString;
    }

    public final boolean h() {
        synchronized (this.e) {
            try {
                boolean z10 = false;
                boolean z11 = true;
                if (this.e.size() == 0) {
                    this.e.add(new d(0, z11, z10));
                    this.e.add(new f(this.b, this.c, 0));
                    this.e.add(new C1910a(this.b, 1));
                    this.e.add(new C1910a(this.b, 2, false));
                    this.e.add(new d(2, z11, z10));
                    this.e.add(new C1910a(this.b, 3, false));
                    this.e.add(new f(this.b, this.c, 2));
                    this.e.add(new d(1, z11, z10));
                    this.e.add(new e(this.c, 1));
                    this.e.add(new C1910a(this.b, 5));
                    this.e.add(new k(this.b));
                    this.e.add(new i(this.b, this));
                    ArrayList arrayList = this.e;
                    Context context = this.b;
                    C1910a c1910a = new C1910a(4, z11, z10);
                    c1910a.e = context;
                    arrayList.add(c1910a);
                    if (C1404a.l) {
                        this.e.add(new f(this.b, this.c));
                    }
                    this.e.add(new e(this.c, 0));
                    ArrayList arrayList2 = this.e;
                    Context context2 = this.b;
                    C1910a c1910a2 = new C1910a(0, z11, z10);
                    c1910a2.e = context2;
                    arrayList2.add(c1910a2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        JSONObject jSONObject = this.d;
        JSONObject jSONObject2 = new JSONObject();
        U7.a.k(jSONObject2, jSONObject);
        Iterator it = this.e.iterator();
        int i = 0;
        int i6 = 0;
        boolean z12 = true;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!cVar.f5972a || cVar.c) {
                try {
                    cVar.f5972a = cVar.a(jSONObject2);
                } catch (SecurityException e) {
                    if (!cVar.b) {
                        i++;
                        StringBuilder sbF = M.a.f("loadHeader, ");
                        sbF.append(this.h);
                        w.h.a(sbF.toString(), e);
                        if (!cVar.f5972a && this.h > 10) {
                            cVar.f5972a = true;
                        }
                    }
                } catch (JSONException e6) {
                    w.h.b(e6);
                }
                if (!cVar.f5972a && !cVar.b) {
                    i6++;
                }
            } else {
                this.c.b();
                w.h.a("needSyncFromSub " + cVar + " false", null);
            }
            z12 &= cVar.f5972a || cVar.b;
        }
        JSONObject jSONObject3 = this.d;
        this.d = jSONObject2;
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(jSONObject3.opt(next), next);
        }
        this.f5975a = z12;
        if (w.h.b) {
            StringBuilder sbF2 = M.a.f("loadHeader, ");
            sbF2.append(this.f5975a);
            sbF2.append(", ");
            sbF2.append(this.h);
            sbF2.append(", ");
            sbF2.append(this.d.toString());
            w.h.a(sbF2.toString(), null);
        } else {
            StringBuilder sbF3 = M.a.f("loadHeader, ");
            sbF3.append(this.f5975a);
            sbF3.append(", ");
            sbF3.append(this.h);
            w.h.a(sbF3.toString(), null);
        }
        if (i > 0 && i == i6) {
            this.h++;
            if (e() != 0) {
                this.h += 10;
            }
        }
        if (this.f5975a) {
            w.b.c(a()).a(C1404a.c(this.c.b.f4335a).b(), this.d.optString("install_id", ""), this.d.optString("ssid", ""));
        }
        return this.f5975a;
    }
}
