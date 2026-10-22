package U0;

import A0.f;
import H.h;
import H4.o;
import a.AbstractC0291a;
import android.app.Application;
import android.text.TextUtils;
import g1.AbstractC1451a;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class b {
    public static volatile b e;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f1264a;
    public a b;
    public long c;
    public long d;

    public static b b() {
        if (e == null) {
            synchronized (b.class) {
                try {
                    if (e == null) {
                        b bVar = new b();
                        bVar.f1264a = new ConcurrentHashMap();
                        bVar.c = -1L;
                        bVar.d = -1L;
                        e = bVar;
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public final a a(String str) {
        a aVar;
        byte[] bArrF0;
        long j5 = this.c;
        long j6 = this.d;
        ConcurrentHashMap concurrentHashMap = this.f1264a;
        if (concurrentHashMap.containsKey(str)) {
            aVar = (a) concurrentHashMap.get(str);
        } else {
            f fVar = AbstractC0291a.b;
            fVar.a();
            a aVar2 = null;
            if (((File) fVar.b) != null && (bArrF0 = S0.b.F0(new File((File) fVar.b, androidx.appfunctions.metadata.a.l(str, ".bin")))) != null) {
                try {
                    a aVar3 = new a();
                    JSONObject jSONObject = new JSONObject(new String(bArrF0));
                    aVar3.g = S0.b.Q0("version_code", jSONObject);
                    aVar3.h = S0.b.Q0("version_name", jSONObject);
                    aVar3.f = S0.b.Q0("manifest_version_code", jSONObject);
                    aVar3.d = S0.b.Q0("update_version_code", jSONObject);
                    aVar3.e = S0.b.Q0("app_version", jSONObject);
                    aVar3.f1255j = S0.b.Q0("os", jSONObject);
                    aVar3.k = S0.b.Q0("device_platform", jSONObject);
                    aVar3.l = S0.b.Q0("os_version", jSONObject);
                    aVar3.m = S0.b.w0("os_api", jSONObject);
                    aVar3.n = S0.b.Q0("device_model", jSONObject);
                    aVar3.o = S0.b.Q0("device_brand", jSONObject);
                    aVar3.p = S0.b.Q0("device_manufacturer", jSONObject);
                    aVar3.f1256q = S0.b.Q0("process_name", jSONObject);
                    aVar3.f1257r = S0.b.I0("sid", jSONObject);
                    aVar3.f1258s = S0.b.Q0("rom_version", jSONObject);
                    aVar3.f1259t = S0.b.Q0("package", jSONObject);
                    aVar3.u = S0.b.Q0("monitor_version", jSONObject);
                    aVar3.c = S0.b.Q0("channel", jSONObject);
                    aVar3.f1254a = S0.b.w0("aid", jSONObject);
                    aVar3.b = S0.b.Q0("device_id", jSONObject);
                    aVar3.f1261w = S0.b.I0("phone_startup_time", jSONObject);
                    aVar3.i = S0.b.Q0("release_build", jSONObject);
                    aVar3.f1260v = S0.b.I0("uid", jSONObject);
                    aVar3.f1262x = S0.b.Q0("verify_info", jSONObject);
                    aVar3.f1251B = S0.b.Q0("current_update_version_code", jSONObject);
                    if (jSONObject.has("config_time")) {
                        aVar3.f1252C = S0.b.w0("config_time", jSONObject);
                    }
                    try {
                        aVar3.f1250A = new JSONObject((String) jSONObject.remove("filters"));
                    } catch (Exception unused) {
                    }
                    aVar3.f1263z = jSONObject;
                    aVar2 = aVar3;
                } catch (Exception unused2) {
                }
            }
            if (aVar2 == null) {
                return this.b;
            }
            concurrentHashMap.put(str, aVar2);
            aVar = aVar2;
        }
        if (aVar != null) {
            if (TextUtils.isEmpty(aVar.b)) {
                aVar.b = AbstractC1451a.C();
            }
            if (AbstractC1451a.c != null) {
                aVar.y = C1912a.b();
            }
            if (j6 != -1) {
                aVar.f1253D = j6;
                aVar.E = j5;
            }
            if (AbstractC1451a.f4467a) {
                o.f(S0.a.f1163a, "nptTime:" + j6 + " nptOffset:" + j5);
            }
            AbstractC1451a.c.getClass();
            Application application = h.f711a;
            aVar.f1260v = 0L;
            aVar.f1252C = AbstractC1451a.f4469q;
            a aVar4 = this.b;
            if (aVar4 != null) {
                aVar.f1251B = aVar4.d;
            }
        }
        return aVar;
    }
}
