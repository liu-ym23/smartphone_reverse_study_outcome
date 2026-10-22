package J2;

import A6.l;
import B.b;
import B0.f;
import F.g;
import F.i;
import H.h;
import H.j;
import H.k;
import a0.AbstractC0293b;
import a0.C0295d;
import a0.C0296e;
import a1.C0298b;
import android.app.Application;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.impl.net.UserHttpServiceImpl;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.slardar.config.IConfigManager;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.args.SingleFileBundle;
import e3.C1417f;
import f1.C1431a;
import g1.AbstractC1451a;
import j0.AbstractC1591a;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k1.AbstractC1620b;
import l0.AbstractC1654a;
import m0.C1670d;
import org.json.JSONException;
import org.json.JSONObject;
import r0.AbstractC1874a;
import v0.C2054a;
import v1.AbstractC2055a;
import w0.AbstractC2083d;
import w0.AbstractC2092m;
import w0.C2081b;
import w0.C2082c;
import w0.C2091l;
import w0.C2093n;
import w0.C2094o;

/* loaded from: classes2.dex */
public final class d implements C.a {

    /* renamed from: a, reason: collision with root package name */
    public f f866a;
    public i0.c b;
    public i0.b c;
    public SlardarConfigManagerImpl d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public boolean h;
    public HashSet i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f867j;
    public boolean k;

    public final void a(JSONObject jSONObject) {
        C1670d c1670d;
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("version_code");
        String strOptString2 = jSONObject.optString("version_name");
        String strOptString3 = jSONObject.optString("manifest_version_code");
        String strOptString4 = jSONObject.optString("update_version_code");
        String strOptString5 = jSONObject.optString("app_version");
        C1670d c1670d2 = new C1670d();
        c1670d2.f5295a = strOptString;
        c1670d2.b = strOptString2;
        c1670d2.c = strOptString3;
        c1670d2.d = strOptString4;
        c1670d2.e = strOptString5;
        g gVar = AbstractC2055a.f6764a;
        gVar.c = c1670d2;
        y1.b bVar = (y1.b) gVar.b;
        synchronized (bVar) {
            c1670d = null;
            List listE = bVar.e(null, null, "_id DESC LIMIT 1", bVar);
            if (!S0.b.a0(listE)) {
                c1670d = (C1670d) listE.get(0);
            }
        }
        if (c1670d == null || !c1670d.equals((C1670d) gVar.c)) {
            y1.b bVar2 = (y1.b) gVar.b;
            C1670d c1670d3 = (C1670d) gVar.c;
            synchronized (bVar2) {
                if (c1670d3 == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("version_code", c1670d3.f5295a);
                contentValues.put("version_name", c1670d3.b);
                contentValues.put("manifest_version_code", c1670d3.c);
                contentValues.put("update_version_code", c1670d3.d);
                contentValues.put("app_version", c1670d3.e);
                bVar2.b(contentValues);
            }
        }
    }

    public final void b() {
        if (this.k) {
            return;
        }
        this.k = true;
        SlardarConfigManagerImpl slardarConfigManagerImpl = new SlardarConfigManagerImpl();
        this.d = slardarConfigManagerImpl;
        slardarConfigManagerImpl.registerConfigListener(this);
        L2.a.f930a.put(IConfigManager.class, this.d);
        a aVar = new a(0);
        ConcurrentHashMap concurrentHashMap = L2.a.b;
        concurrentHashMap.put(IMonitorLogManager.class, aVar);
        concurrentHashMap.put(IActivityLifeManager.class, new a(1));
        concurrentHashMap.put(IApmAgent.class, new a(2));
    }

    public final void c() {
        i0.c cVar;
        PackageInfo packageInfo;
        A8.d dVar = AbstractC1874a.f5670a;
        int i = ((SharedPreferences) dVar.b).getInt("monitor_status_value", 0);
        if (i == 4) {
            h.f719x = false;
        } else {
            h.f719x = true;
        }
        ((SharedPreferences) dVar.b).edit().putInt("monitor_status_value", i).apply();
        h.m = System.currentTimeMillis();
        S0.b.a0(this.b.f4597a);
        S0.b.a0(this.b.b);
        S0.b.a0(this.b.c);
        AbstractC1451a.f4474w = new C1417f(2);
        k.f723a.b = new i();
        JSONObject jSONObject = this.b.l;
        synchronized (h.class) {
            try {
                try {
                    if (h.f714r == null) {
                        h.f714r = new j();
                    }
                    jSONObject.put("os", "Android");
                    jSONObject.put("device_platform", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);
                    jSONObject.put("os_version", Build.VERSION.RELEASE);
                    jSONObject.put("os_api", Build.VERSION.SDK_INT);
                    jSONObject.put("device_model", Build.MODEL);
                    jSONObject.put("device_brand", Build.BRAND);
                    jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                    jSONObject.put("process_name", D2.b.a());
                    jSONObject.put("sid", h.f());
                    jSONObject.put("rom_version", e.c());
                    jSONObject.put("apm_version", h.p);
                    if (TextUtils.isEmpty(jSONObject.optString("version_name"))) {
                        packageInfo = h.f711a.getPackageManager().getPackageInfo(h.f711a.getPackageName(), 0);
                        jSONObject.put("version_name", packageInfo.versionName);
                    } else {
                        packageInfo = null;
                    }
                    if (TextUtils.isEmpty(jSONObject.optString("app_version"))) {
                        jSONObject.put("app_version", jSONObject.optString("version_name"));
                    }
                    if (TextUtils.isEmpty(jSONObject.optString("version_code"))) {
                        if (packageInfo == null) {
                            packageInfo = h.f711a.getPackageManager().getPackageInfo(h.f711a.getPackageName(), 0);
                        }
                        jSONObject.put("version_code", packageInfo.versionCode);
                    }
                    if (TextUtils.isEmpty(jSONObject.optString("package"))) {
                        jSONObject.put("package", h.f711a.getPackageName());
                    }
                    if (jSONObject.isNull("region")) {
                        jSONObject.put("region", Locale.getDefault().getCountry());
                    }
                    jSONObject.put("monitor_version", h.p);
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception unused) {
            }
            j jVar = h.f714r;
            jSONObject.optString("process_name");
            jVar.getClass();
            j jVar2 = h.f714r;
            jSONObject.optString("device_id");
            jVar2.getClass();
            try {
                h.f714r.f722a = jSONObject.optInt("aid");
                h.f714r.b = jSONObject.optString("channel");
                if (jSONObject.has("update_version_code")) {
                    if (jSONObject.get("update_version_code") instanceof String) {
                        h.f714r.c = Integer.valueOf(jSONObject.optString("update_version_code")).intValue();
                    } else {
                        h.f714r.c = jSONObject.optInt("update_version_code");
                    }
                }
                if (jSONObject.has("version_name")) {
                    h.f714r.d = jSONObject.optString("version_name");
                }
                if (jSONObject.has("manifest_version_code")) {
                    if (jSONObject.get("manifest_version_code") instanceof String) {
                        h.f714r.e = Integer.valueOf(jSONObject.optString("manifest_version_code")).intValue();
                    } else {
                        h.f714r.e = jSONObject.optInt("manifest_version_code");
                    }
                }
                if (jSONObject.has("version_code")) {
                    if (jSONObject.get("version_code") instanceof String) {
                        j jVar3 = h.f714r;
                        Integer.valueOf(jSONObject.optString("version_code")).getClass();
                        jVar3.getClass();
                    } else {
                        j jVar4 = h.f714r;
                        jSONObject.optInt("version_code");
                        jVar4.getClass();
                    }
                }
                if (jSONObject.has("app_version")) {
                    h.f714r.f = jSONObject.optString("app_version");
                }
                if (jSONObject.has("release_build")) {
                    h.f714r.g = jSONObject.optString("release_build");
                }
            } catch (Exception unused2) {
            }
            h.c = jSONObject;
            try {
                S0.b.q0(jSONObject, h.d);
                j jVar5 = h.f714r;
                JSONObject jSONObject2 = h.c;
                if (jSONObject2 == null) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(jSONObject2.toString());
                    } catch (Exception unused3) {
                    }
                }
                jVar5.h = jSONObject2;
            } catch (JSONException unused4) {
            }
        }
        C2054a c2054a = this.b.m;
        synchronized (h.class) {
            try {
                h.e = c2054a;
                if (h.f == null) {
                    h.f = new HashMap();
                }
                if (!h.f.containsKey("aid")) {
                    h.f.put("aid", h.c.optString("aid"));
                }
                if (!h.f.containsKey("device_id")) {
                    h.f.put("device_id", h.e.getDid());
                }
                if (!h.f.containsKey("device_platform")) {
                    h.f.put("device_platform", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);
                }
                h.f.put("os", "Android");
                if (!h.f.containsKey("update_version_code")) {
                    h.f.put("update_version_code", h.c.optString("update_version_code"));
                }
                if (!h.f.containsKey("version_code")) {
                    h.f.put("version_code", h.c.optString("version_code"));
                }
                if (!h.f.containsKey("channel")) {
                    h.f.put("channel", h.c.optString("channel"));
                }
                if (!h.f.containsKey("os_api")) {
                    h.f.put("os_api", Build.VERSION.SDK_INT + "");
                }
                if (!h.f.containsKey("user_id")) {
                    h.f.put("uid", h.e.getUserId());
                }
                if (h.f714r == null) {
                    h.f714r = new j();
                }
                h.f714r.i = new HashMap(h.f);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        i0.c cVar2 = this.b;
        UserHttpServiceImpl userHttpServiceImpl = cVar2.n;
        if (userHttpServiceImpl != null) {
            h.g = userHttpServiceImpl;
        }
        this.c = cVar2.f4599q;
        this.i = cVar2.o;
        N.d dVar2 = N.c.f1004a;
        dVar2.getClass();
        dVar2.b = h.g();
        dVar2.c = System.currentTimeMillis();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(dVar2);
        if (this.h) {
            List list = F0.c.f517D;
            F0.c cVar3 = F0.b.f516a;
            i0.c cVar4 = this.b;
            cVar3.getClass();
            i iVar = new i();
            if (!AbstractC1451a.f4465B) {
                AbstractC1451a.f4464A = iVar;
                AbstractC1451a.f4465B = true;
            }
            ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(cVar3);
            ActivityLifeObserver.getInstance().register(cVar3);
            Z6.k.b = cVar3;
            List list2 = cVar4.b;
            if (!S0.b.a0(list2)) {
                cVar3.i = new ArrayList(list2);
            }
            List list3 = cVar4.c;
            if (!S0.b.a0(list3)) {
                cVar3.k = new ArrayList(list3);
            }
            cVar3.f529w = cVar4.p;
        }
        i0.c cVar5 = this.b;
        if (cVar5 != null && cVar5.i) {
            C2082c c2082c = new C2082c();
            c2082c.h = 120L;
            c2082c.e = "memory";
            c2082c.d();
        }
        i0.c cVar6 = this.b;
        if (cVar6 != null && cVar6.k) {
            M9.f fVar = a1.c.f1629a;
            if (((AtomicBoolean) fVar.f981a).compareAndSet(false, true)) {
                fVar.e = (C1431a) AbstractC1620b.a(C1431a.class);
                fVar.d = L.d.a(AbstractC1451a.b, "apm_cpu_front");
                if (AbstractC1451a.P()) {
                    fVar.a();
                    s1.b.a(cc.dd.ee.kk.ff.c.c).c(new C0.b(fVar));
                }
                ((SharedPreferences) fVar.d).edit().putString(AbstractC1451a.A(), Process.myPid() + "," + ((C1431a) fVar.e).e).apply();
                C1431a c1431a = (C1431a) fVar.e;
                C0298b c0298b = new C0298b(fVar);
                synchronized (c1431a.f4433a) {
                    c1431a.f4433a.add(c0298b);
                }
                AbstractC1620b.a(M0.k.class);
            }
        }
        if (this.h && (cVar = this.b) != null && cVar.f4598j) {
            C2091l c2091l = new C2091l();
            c2091l.f6820j = 524288000L;
            c2091l.k = 524288000L;
            c2091l.l = 20;
            c2091l.m = 2592000000L;
            c2091l.p = new ArrayList();
            c2091l.f6821q = new ArrayList();
            c2091l.f6822r = new ArrayList();
            c2091l.f6823s = new ArrayList();
            c2091l.e = "disk";
            this.b.getClass();
            c2091l.d();
        }
        AbstractC1451a.P();
        boolean z10 = this.b.e;
        C2054a c2054aD = C2054a.d();
        this.b.getClass();
        c2054aD.getClass();
        O.a aVarG = O.a.g();
        aVarG.getClass();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(aVarG);
        int i6 = O.c.p;
        O.c cVar7 = O.b.f1029a;
        cVar7.getClass();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(cVar7);
        this.b.getClass();
        long j5 = this.b.p;
        L0.f fVar2 = L0.d.f925a;
        l lVar = new l(this, 9);
        long j6 = j5 * 1000;
        if (fVar2.c) {
            L0.h hVar = fVar2.b;
            hVar.c(Message.obtain(hVar.d, lVar), j6);
        }
        if (this.h) {
            a(h.d());
        }
        Application application = h.f711a;
        HashSet hashSet = this.i;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    ((H.i) it.next()).a(application);
                } catch (Throwable unused5) {
                }
            }
        }
        h2.d dVar3 = new h2.d();
        dVar3.f4555a = this.b.b;
        HashSet hashSet2 = this.i;
        if (hashSet2 != null) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                try {
                    ((H.i) it2.next()).b(dVar3);
                } catch (Throwable unused6) {
                }
            }
        }
        HashSet hashSet3 = this.i;
        if (hashSet3 != null) {
            Iterator it3 = hashSet3.iterator();
            while (it3.hasNext()) {
                try {
                    ((H.i) it3.next()).getClass();
                } catch (Throwable unused7) {
                }
            }
        }
        L0.f fVar3 = L0.d.f925a;
        this.b.getClass();
        fVar3.f926a = null;
        i0.c cVar8 = this.b;
        List list4 = cVar8.b;
        if (!S0.b.a0(list4)) {
            try {
                String host = new URL((String) list4.get(0)).getHost();
                if (!TextUtils.isEmpty(h.f713q)) {
                    host = h.f713q;
                }
                S0.b.f = host;
                int i10 = Z.a.f1581a;
            } catch (MalformedURLException unused8) {
            }
            W0.g gVar = W0.f.f1476a;
            gVar.getClass();
            if (!S0.b.r0(list4)) {
                gVar.f.clear();
                gVar.f.addAll(list4);
            }
        }
        W0.g gVar2 = W0.f.f1476a;
        ArrayList arrayList = AbstractC1591a.d;
        gVar2.getClass();
        if (!S0.b.r0(arrayList)) {
            gVar2.g.clear();
            gVar2.g.addAll(arrayList);
        }
        List list5 = cVar8.c;
        if (!S0.b.r0(list5)) {
            gVar2.h.clear();
            gVar2.h.addAll(list5);
        }
        if (!S0.b.a0(list4)) {
            String str = (String) list5.get(0);
            if (!TextUtils.isEmpty(str)) {
                t1.a.h = str;
            }
        }
        this.b.getClass();
        L2.a.f930a.put(IHttpService.class, new IHttpService() { // from class: com.bytedance.apm.internal.ApmDelegate$8
            @Override // com.bytedance.services.apm.api.IHttpService
            public B.e buildMultipartUpload(String str2, String str3, boolean z11) {
                return h.g.buildMultipartUpload(str2, str3, z11);
            }

            @Override // com.bytedance.services.apm.api.IHttpService
            public b doGet(String str2, Map<String, String> map) {
                return h.g.doGet(str2, map);
            }

            @Override // com.bytedance.services.apm.api.IHttpService
            public b doPost(String str2, byte[] bArr, Map<String, String> map) {
                return h.g.doPost(str2, bArr, map);
            }

            @Override // com.bytedance.services.apm.api.IHttpService
            public b uploadFiles(String str2, List<File> list6, Map<String, String> map) {
                return h.g.uploadFiles(str2, list6, map);
            }

            @Override // com.bytedance.services.apm.api.IHttpService
            public B.e buildMultipartUpload(String str2, String str3, Map<String, String> map, boolean z11) {
                return h.g.buildMultipartUpload(str2, str3, map, z11);
            }
        });
        if (h.b) {
            if (this.h) {
                AbstractC1654a.f5271a.a("APM_START", null);
            } else {
                AbstractC1654a.f5271a.a("APM_START_OTHER_PROCESS", null);
            }
        }
    }

    @Override // C.a
    public final void onReady() throws IOException {
        this.e = true;
        JSONObject config = this.d.getConfig();
        if (this.h) {
            JSONObject jSONObjectU = S0.b.u("performance_modules", config, SingleFileBundle.KEY_FILE_DESCRIPTOR);
            if ((jSONObjectU == null ? 0 : jSONObjectU.optInt("enable_upload", 0)) == 1) {
                C2081b c2081b = new C2081b();
                c2081b.g = 800;
                c2081b.h = 600000L;
                c2081b.e = SingleFileBundle.KEY_FILE_DESCRIPTOR;
                c2081b.d();
            }
            C2094o c2094o = new C2094o();
            c2094o.g = 600000L;
            c2094o.e = "thread";
            c2094o.d();
        }
        if (this.b.h) {
            JSONObject jSONObjectU2 = S0.b.u("performance_modules", config, "battery");
            if ((jSONObjectU2 == null ? 0 : jSONObjectU2.optInt("enable_upload", 0)) == 1) {
                Application application = h.f711a;
                String strA = D2.b.a();
                if ((strA == null || !strA.contains(":")) && strA != null && strA.equals(application.getPackageName())) {
                    C0296e c0296e = new C0296e();
                    C2093n c2093n = AbstractC2092m.f6826a;
                    c2093n.a();
                    c0296e.d();
                    C0295d c0295d = new C0295d();
                    c0295d.e = "battery";
                    c2093n.a();
                    c0295d.d();
                }
                AbstractC0293b.f1624a.d();
            }
        }
        this.b.getClass();
        Boolean bool = (Boolean) AbstractC2083d.f6808a.b.get("block_monitor");
        if ((bool != null ? bool.booleanValue() : false) && !this.f867j) {
            this.f867j = true;
            L0.a.f923a.post(new A1.a(7));
            g0.b bVar = new g0.b();
            g0.g gVar = new g0.g();
            bVar.d = gVar;
            i0.c cVar = this.b;
            long j5 = cVar.g;
            if (j5 < 70) {
                j5 = 2500;
            }
            gVar.c = j5;
            if (5000 < j5) {
                gVar.d = j5 + 50;
            }
            gVar.b = cVar.f;
            ActivityLifeObserver.getInstance().register(bVar);
            ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(bVar);
            L0.h hVar = new L0.h();
            gVar.f4462a = hVar;
            hVar.f928a.start();
            h0.f.p.d(bVar);
            bVar.b = true;
            if (h.b) {
                Log.d("BlockDetector", U7.a.e(new String[]{"BlockDetector init: "}));
            }
            if (ActivityLifeObserver.getInstance().isForeground()) {
                bVar.e();
            }
        }
        JSONObject jSONObjectU3 = S0.b.u("performance_modules", config, "traffic");
        boolean z10 = (jSONObjectU3 == null ? 0 : jSONObjectU3.optInt("enable_collect", 0)) == 1;
        JSONObject jSONObjectU4 = S0.b.u("performance_modules", config, "traffic");
        boolean z11 = (jSONObjectU4 == null ? 0 : jSONObjectU4.optInt("enable_exception_collect", 0)) == 1;
        if (h.b) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"ApmDelegate initializing traffic: normalHit=" + z10 + " exceptionHit=" + z11}));
        }
        if (this.b.d) {
            if (z10 || z11) {
                A0.f fVar = A0.e.f71a;
                if (fVar.f72a) {
                    return;
                }
                fVar.f72a = true;
                ((C0.a) fVar.b).j(z10, z11);
            }
        }
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("general");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optBoolean("enable_active_upload_alog", true);
        }
    }
}
