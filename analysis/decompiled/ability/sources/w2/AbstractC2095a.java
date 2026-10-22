package w2;

import D7.N;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import androidx.core.app.NotificationCompat;
import com.apm.insight.Npth;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2095a {

    /* renamed from: a, reason: collision with root package name */
    public static final A1.a f6830a = new A1.a(19);
    public static int b = 0;
    public static boolean c = false;
    public static File d = null;
    public static volatile boolean e = false;
    public static volatile boolean f = false;
    public static Map g;

    public static f2.b a(String str, String str2, File... fileArr) throws Throwable {
        if (Npth.isStopUpload()) {
            return new f2.b(ComposerKt.providerKey);
        }
        try {
            b bVarC = com.apm.insight.g.c(h(str), null, true);
            bVarC.c("json", str2, true);
            bVarC.d(BffConstant.Type.File, null, fileArr);
            try {
                new JSONObject(bVarC.a());
                return new f2.b();
            } catch (JSONException e6) {
                return new f2.b(0, e6);
            }
        } catch (IOException e9) {
            e9.printStackTrace();
            return new f2.b(ComposerKt.reuseKey);
        }
    }

    public static f2.b b(String str, byte[] bArr, String str2, String str3, boolean z10) {
        try {
            HashMap map = new HashMap();
            map.put(HttpHeaders.CONTENT_TYPE, str2);
            if (str3 != null) {
                map.put("Content-Encoding", str3);
            }
            map.put("os", "Android");
            map.put("Accept-Encoding", "gzip");
            if (z10) {
                try {
                    String strJ = com.apm.insight.f.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        map.put("aid", strJ);
                        String strH = com.apm.insight.f.h(strJ);
                        if (!TextUtils.isEmpty(strH)) {
                            map.put("x-auth-token", strH);
                        }
                        String strI = com.apm.insight.f.i(strJ);
                        if (!TextUtils.isEmpty(strI)) {
                            map.put("device_id", strI);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (com.apm.insight.g.p == null) {
                com.apm.insight.g.p = new k();
            }
            return new f2.b(com.apm.insight.g.p.c(str, bArr, map).b);
        } catch (Throwable th) {
            S0.b.R(th);
            return new f2.b(ComposerKt.reuseKey, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f A[PHI: r4
      0x007f: PHI (r4v10 java.lang.String) = (r4v7 java.lang.String), (r4v11 java.lang.String) binds: [B:36:0x008a, B:33:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f2.b c(java.lang.String r3, byte[] r4, boolean r5, boolean r6) throws java.io.IOException {
        /*
            boolean r0 = com.apm.insight.Npth.isStopUpload()
            r1 = 201(0xc9, float:2.82E-43)
            if (r0 == 0) goto Le
            f2.b r3 = new f2.b
            r3.<init>(r1)
            return r3
        Le:
            if (r3 != 0) goto L16
            f2.b r3 = new f2.b
            r3.<init>(r1)
            return r3
        L16:
            if (r4 != 0) goto L1b
            r4 = 0
            byte[] r4 = new byte[r4]
        L1b:
            int r0 = r4.length
            r1 = 128(0x80, float:1.8E-43)
            r2 = 0
            if (r0 <= r1) goto L48
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream
            r1.<init>(r0)
            r1.write(r4)     // Catch: java.lang.Throwable -> L38
            r1.close()
            byte[] r4 = r0.toByteArray()
            goto L40
        L38:
            r4 = move-exception
            S0.b.p0(r4)     // Catch: java.lang.Throwable -> L43
            r1.close()
            r4 = r2
        L40:
            java.lang.String r2 = "gzip"
            goto L48
        L43:
            r3 = move-exception
            r1.close()
            throw r3
        L48:
            if (r4 != 0) goto L52
            f2.b r3 = new f2.b
            r4 = 202(0xca, float:2.83E-43)
            r3.<init>(r4)
            return r3
        L52:
            java.lang.String r0 = "application/json; charset=utf-8"
            if (r5 == 0) goto L9b
            com.apm.insight.runtime.ConfigManager r5 = com.apm.insight.g.g
            com.apm.insight.c r5 = r5.getEncryptImpl()
            s2.a r5 = (s2.C1912a) r5
            r5.getClass()
            int r5 = r4.length
            byte[] r5 = com.bytedance.applog.encryptor.EncryptorUtil.a(r5, r4)
            if (r5 == 0) goto L96
            java.net.URL r4 = new java.net.URL
            r4.<init>(r3)
            java.lang.String r4 = r4.getQuery()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L84
            java.lang.String r4 = "?"
            boolean r0 = r3.endsWith(r4)
            if (r0 != 0) goto L8d
        L7f:
            java.lang.String r3 = r3.concat(r4)
            goto L8d
        L84:
            java.lang.String r4 = "&"
            boolean r0 = r3.endsWith(r4)
            if (r0 != 0) goto L8d
            goto L7f
        L8d:
            java.lang.String r4 = "tt_data=a"
            java.lang.String r3 = androidx.appfunctions.metadata.a.l(r3, r4)
            java.lang.String r0 = "application/octet-stream;tt-data=a"
            r4 = r5
        L96:
            f2.b r3 = b(r3, r4, r0, r2, r6)
            return r3
        L9b:
            f2.b r3 = b(r3, r4, r0, r2, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.AbstractC2095a.c(java.lang.String, byte[], boolean, boolean):f2.b");
    }

    public static void d(String str, String str2, F.g... gVarArr) throws Throwable {
        if (Npth.isStopUpload()) {
            return;
        }
        try {
            HashMap map = new HashMap();
            String strJ = com.apm.insight.f.j();
            map.put("aid", strJ);
            String strH = com.apm.insight.f.h(strJ);
            if (!TextUtils.isEmpty(strH)) {
                map.put("x-auth-token", strH);
            }
            b bVarC = com.apm.insight.g.c(h(str), null, true);
            bVarC.c("json", str2, true);
            bVarC.e(gVarArr);
            try {
                new JSONObject(bVarC.a());
            } catch (JSONException e6) {
                e6.getMessage();
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
    }

    public static boolean e() {
        com.apm.insight.f fVar;
        if (d == null) {
            d = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/configCrash/configInvalid");
        }
        File file = d;
        try {
            Map mapP = g;
            if (mapP == null) {
                mapP = M.a.P(file);
            }
            g = mapP;
            if (mapP == null) {
                g = new HashMap();
                return true;
            }
            int size = mapP.size();
            ConcurrentLinkedQueue concurrentLinkedQueue = n2.c.f5346a;
            if (size >= concurrentLinkedQueue.size()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext() && (fVar = (com.apm.insight.f) it.next()) != null) {
                    arrayList.add(fVar.g());
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (!g.containsKey((String) it2.next())) {
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z10 = false;
                for (Map.Entry entry : g.entrySet()) {
                    try {
                        long jLongValue = Long.decode((String) entry.getValue()).longValue();
                        if (z2.d.d((String) entry.getKey())) {
                            z2.d dVar = (z2.d) z2.d.c.get((String) entry.getKey());
                            long jLongValue2 = 3600000;
                            if (dVar != null) {
                                try {
                                    jLongValue2 = Long.decode(N.k(dVar.f6928a, "over_all", "get_settings_interval")).longValue() * 1000;
                                } catch (Throwable unused) {
                                }
                            }
                            if (jCurrentTimeMillis - jLongValue > jLongValue2) {
                                z10 = true;
                            }
                        }
                    } catch (Throwable th) {
                        S0.b.R(th);
                    }
                }
                S0.b.N(z10 ? "config should be updated" : "config should not be updated");
                return z10;
            }
            return true;
        } catch (Throwable th2) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th2);
            return true;
        }
    }

    public static boolean f(String str, String str2, String str3, String str4, List list) {
        if (!Npth.isStopUpload()) {
            try {
                HashMap map = new HashMap();
                map.put("aid", str2);
                String strH = com.apm.insight.f.h(str2);
                if (!TextUtils.isEmpty(strH)) {
                    map.put("x-auth-token", strH);
                }
                b bVarC = com.apm.insight.g.c(str, map, false);
                bVarC.c("aid", str2, false);
                bVarC.c("device_id", str3, false);
                bVarC.c("os", "Android", false);
                bVarC.c("process_name", str4, false);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (file.exists()) {
                        HashMap map2 = new HashMap();
                        map2.put("logtype", "alog");
                        map2.put("scene", "崩溃");
                        bVarC.b(file.getName(), file, map2);
                    }
                }
                try {
                    if (new JSONObject(bVarC.a()).optInt("errno", -1) == 200) {
                        return true;
                    }
                } catch (JSONException unused) {
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static f2.b g(String str, String str2, boolean z10) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return c(str, str2.getBytes(), true, z10);
            }
            return new f2.b(ComposerKt.providerKey);
        } catch (Throwable th) {
            S0.b.p0(th);
            return new f2.b(ComposerKt.reuseKey, th);
        }
    }

    public static String h(String str) {
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str.concat("?");
                }
            } else if (!str.endsWith("&")) {
                str = str.concat("&");
            }
            return str + "have_dump=true&encrypt=true";
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void i() {
        if (!f) {
            j();
        }
        if (D2.b.f(com.apm.insight.g.f2160a) && e()) {
            m();
        }
    }

    public static void j() {
        try {
            if (!e && z2.k.f6933a) {
                f = true;
                File file = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/configCrash/configFile");
                if (file.exists()) {
                    z2.b.c(new JSONArray(M.a.c(file)), false);
                    e = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void k(String str, String str2, File... fileArr) {
        try {
            String strS = com.apm.insight.g.a().s();
            HashMap map = new HashMap();
            map.put("aid", strS);
            String strH = com.apm.insight.f.h(strS);
            if (!TextUtils.isEmpty(strH)) {
                map.put("x-auth-token", strH);
            }
            b bVarC = com.apm.insight.g.c(str, map, false);
            bVarC.c("aid", strS, false);
            bVarC.c("device_id", com.apm.insight.g.a().r(), false);
            bVarC.c("os", "Android", false);
            HashMap map2 = new HashMap();
            map2.put("logtype", "custom");
            map2.put("scene", "crash");
            map2.put("event_time", String.valueOf(System.currentTimeMillis()));
            map2.put("uuid", str2);
            bVarC.d("CustomFile.zip", map2, fileArr);
            bVarC.a();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static byte[] l() {
        com.apm.insight.f fVar;
        try {
            ConcurrentLinkedQueue concurrentLinkedQueue = n2.c.f5346a;
            JSONArray jSONArray = new JSONArray();
            Iterator it = n2.c.f5346a.iterator();
            while (it.hasNext() && (fVar = (com.apm.insight.f) it.next()) != null) {
                jSONArray.put(fVar.d(true));
            }
            try {
                if (com.apm.insight.g.f2163r) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (TextUtils.equals(jSONObjectOptJSONObject.optString("aid"), com.apm.insight.f.j())) {
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.put("protector_module#metas");
                            jSONObjectOptJSONObject.put("metas_module", jSONArray2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            String configUrl = com.apm.insight.g.g.getConfigUrl();
            byte[] bytes = jSONArray.toString().getBytes();
            try {
                TextUtils.isDigitsOnly(configUrl);
                return c(configUrl, bytes, false, false).b;
            } catch (IOException e6) {
                e6.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            S0.b.R(th);
            return null;
        }
    }

    public static synchronized void m() {
        try {
            int i = b;
            if (i > 0) {
                b = i - 1;
            }
            S0.b.N("try fetchApmConfig");
            if (com.stepos.statsrpk.d.l(com.apm.insight.g.f2160a)) {
                JSONArray jSONArrayOptJSONArray = null;
                try {
                    byte[] bArrL = l();
                    if (bArrL != null) {
                        jSONArrayOptJSONArray = new JSONObject(new String(bArrL)).optJSONArray(SettingsConfig.KEY_DATA);
                    }
                } catch (Throwable th) {
                    if (com.apm.insight.g.g.isDebugMode()) {
                        Log.e("npth", "npth NPTH Catch Error", th);
                    }
                }
                S0.b.N("after fetchApmConfig net " + jSONArrayOptJSONArray);
                if (jSONArrayOptJSONArray != null) {
                    z2.b.c(jSONArrayOptJSONArray, true);
                    b = 0;
                } else {
                    b -= 10;
                }
            } else {
                j();
                if (e) {
                    b = 0;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
