package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.store.kv.IKVStore;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w1 {
    public static final String[] n = {"channel", ExceptionManagerStepOS.PACKAGE, "app_version"};
    public volatile boolean a;
    public final Context b;
    public final u1 c;
    public boolean e;
    public final IKVStore g;
    public final e5 h;
    public final d i;

    @Deprecated
    public boolean l;
    public volatile JSONObject d = new JSONObject();
    public final Set<p1> f = new LinkedHashSet(32);
    public int j = 0;
    public final Set<String> k = new HashSet(4);
    public final Set<String> m = new HashSet();

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", w1.this.i.m);
                jSONObject.put("did", w1.this.d.optString("device_id", ""));
                jSONObject.put("bdDid", w1.this.c());
                jSONObject.put("ssid", w1.this.i());
                jSONObject.put("installId", w1.this.f());
                jSONObject.put("uuid", w1.this.k());
                jSONObject.put("uuidType", w1.this.l());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements EventBus.DataFetcher {
        public final /* synthetic */ JSONObject a;

        public b(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            r.c(this.a, jSONObject);
            try {
                jSONObject.put("appId", w1.this.i.m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public w1(d dVar, Context context, u1 u1Var) {
        this.l = false;
        this.i = dVar;
        this.b = context;
        this.c = u1Var;
        IKVStore iKVStore = u1Var.f;
        this.g = iKVStore;
        this.h = dVar.d.a(dVar, context, u1Var);
        this.l = iKVStore.getBoolean("forbid_report_phone_detail_info", false);
        boolean z = u1Var.f.getBoolean("is_first_app_launch", true);
        String userUniqueId = u1Var.c.getUserUniqueId();
        String userUniqueIdType = u1Var.c.getUserUniqueIdType();
        if (r.d(userUniqueId) && z) {
            i(userUniqueId);
        }
        if (r.d(userUniqueIdType) && z) {
            j(userUniqueIdType);
        }
        if (z) {
            u1Var.f.putBoolean("is_first_app_launch", false);
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean e(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("device_id", "");
            String strOptString2 = jSONObject.optString("install_id", "");
            String strOptString3 = jSONObject.optString("bd_did", "");
            if ((r.a(strOptString) || r.a(strOptString3)) && r.a(strOptString2)) {
                return true;
            }
        }
        return false;
    }

    public final String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public final synchronized void a(String str) {
        String strOptString = this.d.optString("ab_sdk_version");
        if (!TextUtils.isEmpty(strOptString)) {
            for (String str2 : strOptString.split(",")) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    this.i.D.debug(Collections.singletonList("DeviceManager"), com.bytedance.bdtracker.a.a("addExposedVid ready added: ", strOptString), new Object[0]);
                    return;
                }
            }
            str = strOptString + "," + str;
        }
        f(str);
        a(str, this.c.d());
    }

    public void b(String str) {
        e5 e5Var = this.h;
        if (e5Var instanceof e5) {
            e5Var.e.D.debug(e5Var.g, "DeviceParamsProvider#clearDidAndIid clearKey=" + str + " sDeviceId=" + e5.l, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                e5.l = null;
                String strA = com.bytedance.bdtracker.a.a("clear_key_prefix", str);
                InitConfig initConfig = e5Var.f.c;
                IKVStore iKVStoreA = v4.a(initConfig, e5Var.a, initConfig.getSpName());
                if (iKVStoreA.getBoolean(strA, false)) {
                    e5Var.e.D.debug(e5Var.g, "clearKey:{} is already cleared", str);
                } else {
                    iKVStoreA.putBoolean(strA, true);
                    if (iKVStoreA.contains("device_id")) {
                        iKVStoreA.remove("device_id");
                    }
                    if (iKVStoreA.contains("install_id")) {
                        iKVStoreA.remove("install_id");
                    }
                    e5Var.b.a("device_id");
                    e5Var.e.D.debug(e5Var.g, "clearKey:{} installId and deviceId finish", str);
                }
            }
        }
        this.c.f.remove("device_token");
    }

    public final void b(JSONObject jSONObject) {
        this.d = jSONObject;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("set_header", new b(jSONObject));
    }

    public String c() {
        return this.d.optString("bd_did", "");
    }

    public final Set<String> c(String str) {
        String[] strArrSplit;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public final JSONObject d() {
        if (this.a) {
            return this.d.optJSONObject("custom");
        }
        u1 u1Var = this.c;
        if (u1Var != null) {
            try {
                return new JSONObject(u1Var.d.getString("header_custom_info", null));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void d(String str) {
        JSONObject jSONObjectD;
        if (TextUtils.isEmpty(str) || (jSONObjectD = d()) == null || !jSONObjectD.has(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, jSONObjectD);
        jSONObject.remove(str);
        c(jSONObject);
    }

    public JSONObject e() {
        if (this.a) {
            return this.d;
        }
        return null;
    }

    public String f() {
        return this.d.optString("install_id", "");
    }

    public String g() {
        return this.d.optString("openudid", "");
    }

    public int h() {
        if (e(this.d)) {
            return this.g.getInt("version_code", 0) == this.d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public boolean h(String str) {
        if (!a("ssid", (Object) str)) {
            return false;
        }
        this.g.putString(this.c.f(), str);
        return true;
    }

    public String i() {
        if (this.a) {
            return this.d.optString("ssid", "");
        }
        u1 u1Var = this.c;
        return u1Var != null ? u1Var.f.getString(u1Var.f(), "") : "";
    }

    public String j() {
        return this.d.optString("udid", "");
    }

    public String k() {
        if (this.a) {
            return this.d.optString("user_unique_id", "");
        }
        u1 u1Var = this.c;
        return u1Var != null ? u1Var.g() : "";
    }

    public String l() {
        return this.d.optString("user_unique_id_type", this.c.h());
    }

    public int m() {
        int iOptInt = this.a ? this.d.optInt("version_code", -1) : k5.a(this.b);
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            iOptInt = this.a ? this.d.optInt("version_code", -1) : k5.a(this.b);
        }
        return iOptInt;
    }

    public String n() {
        String strOptString = this.a ? this.d.optString("app_version") : k5.b(this.b);
        for (int i = 0; i < 3 && TextUtils.isEmpty(strOptString); i++) {
            strOptString = this.a ? this.d.optString("app_version") : k5.b(this.b);
        }
        return strOptString;
    }

    public boolean o() {
        return this.e;
    }

    public boolean p() {
        return e(this.d);
    }

    public boolean q() {
        h1 h1Var;
        this.f.add(new q1(this.i, this.c));
        this.f.add(new t1(this.i, this.b, this.c));
        this.f.add(new z1(this.i, this.b));
        this.f.add(new b2(this.b));
        this.f.add(new g2(this.b, this.c, this, this.i.getInitConfig() != null ? this.i.getInitConfig().getSensitiveInfoProvider() : null));
        this.f.add(new c2(this.b));
        this.f.add(new e2(this.i, this.b, this.c));
        this.f.add(new f2());
        this.f.add(new h2(this.b, this.c, this));
        this.f.add(new i2(this.i, this.b));
        this.f.add(new j2(this.c, this.b));
        this.f.add(new x1(this.b, this.c, this));
        this.f.add(new s1(this.c));
        this.f.add(new m1(this.b));
        this.f.add(new r1(this.i));
        this.f.add(new a2(this.b, this.c));
        this.f.add(new d2(this.b, this.c));
        JSONObject jSONObject = this.d;
        JSONObject jSONObject2 = new JSONObject();
        r.a(jSONObject2, jSONObject);
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (p1 p1Var : this.f) {
            if (this.c.c.getLoaderFilters().contains(p1Var.a())) {
                IAppLogLogger iAppLogLogger = this.i.D;
                StringBuilder sbA = com.bytedance.bdtracker.a.a("Filter ");
                sbA.append(p1Var.a());
                sbA.append(" Loader");
                iAppLogLogger.debug(sbA.toString(), new Object[0]);
            } else {
                if (!p1Var.a || p1Var.c || (!this.c.j() && p1Var.d)) {
                    try {
                        p1Var.a = p1Var.a(jSONObject2);
                    } catch (SecurityException e) {
                        if (!p1Var.b) {
                            i++;
                            IAppLogLogger iAppLogLogger2 = this.i.D;
                            List<String> listSingletonList = Collections.singletonList("DeviceManager");
                            StringBuilder sbA2 = com.bytedance.bdtracker.a.a("loadHeader mCountPermission: ");
                            sbA2.append(this.j);
                            iAppLogLogger2.warn(listSingletonList, sbA2.toString(), e);
                            if (!p1Var.a && this.j > 10) {
                                p1Var.a = true;
                            }
                        }
                    } catch (JSONException e2) {
                        this.i.D.error("loader load error", e2, new Object[0]);
                    }
                    if (!p1Var.a && !p1Var.b) {
                        i2++;
                    }
                }
                this.i.D.debug(Collections.singletonList("DeviceManager"), "Loader:{} is ready:{}", p1Var.a(), Boolean.valueOf(p1Var.a));
                z &= p1Var.a || p1Var.b;
            }
        }
        if (z) {
            for (String str : n) {
                boolean zIsEmpty = TextUtils.isEmpty(jSONObject2.optString(str));
                z &= !zIsEmpty;
                if (zIsEmpty) {
                    this.i.D.warn(Collections.singletonList("DeviceManager"), "Key " + str + " is empty!", new Object[0]);
                }
            }
        }
        synchronized (this) {
            JSONObject jSONObject3 = this.d;
            for (String str2 : this.k) {
                this.i.D.debug("Loader newHeader remove " + str2, new Object[0]);
                jSONObject2.remove(str2);
            }
            b(jSONObject2);
            Iterator<String> itKeys = jSONObject3.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a(next, jSONObject3.opt(next));
            }
            this.a = z;
        }
        this.i.D.debug(Collections.singletonList("DeviceManager"), "Loader header ready:{}, permission count:{}, header:{}", Boolean.valueOf(this.a), Integer.valueOf(this.j), this.d);
        if (i > 0 && i == i2) {
            this.j++;
            if (h() != 0) {
                this.j += 10;
            }
        }
        if (this.a && (h1Var = this.i.y) != null) {
            h1Var.onIdLoaded(c(), f(), i());
        }
        if (!LogUtils.isDisabled() && r.d(i())) {
            LogUtils.sendJsonFetcher("local_did_load", new a());
        }
        return this.a;
    }

    @Deprecated
    public boolean r() {
        return !this.l;
    }

    public final void e(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ab_sdk_version", str);
            this.i.onEventV3("abtest_exposure", jSONObject, 0);
        } catch (Throwable th) {
            this.i.D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
        }
    }

    public final void c(JSONObject jSONObject) {
        if (a("custom", jSONObject)) {
            this.c.d.putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "");
        }
    }

    public void f(String str) {
        if (a("ab_sdk_version", (Object) str)) {
            this.c.d.putString("ab_sdk_version", str);
        }
    }

    public synchronized void g(String str) {
        Set<String> setC = c(this.c.d());
        String strD = this.c.d();
        Set<String> setC2 = c(this.d.optString("ab_sdk_version"));
        setC2.removeAll(setC);
        setC2.addAll(c(str));
        u1 u1Var = this.c;
        u1Var.b.D.debug(Collections.singletonList("ConfigManager"), "setExternalAbVersion:{}", str);
        u1Var.d.putString("external_ab_version", str);
        u1Var.h = null;
        f(a(setC2));
        if (!r.a(strD, this.c.d())) {
            a(b(), this.c.d());
        }
    }

    public void j(String str) {
        if (a("user_unique_id_type", (Object) str)) {
            this.c.d.putString("user_unique_id_type", str);
        }
    }

    public void a() {
        f(null);
        g("");
        a((JSONObject) null);
        this.m.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d A[Catch: all -> 0x0085, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x000f, B:8:0x001d, B:10:0x0028, B:11:0x002c, B:13:0x0032, B:15:0x003a, B:17:0x0042, B:20:0x0051, B:21:0x0063, B:23:0x0080), top: B:29:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void d(org.json.JSONObject r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 != 0) goto Lf
            com.bytedance.bdtracker.d r1 = r10.i     // Catch: java.lang.Throwable -> L85
            com.bytedance.applog.log.IAppLogLogger r1 = r1.D     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = "null abconfig"
            r1.warn(r3, r2)     // Catch: java.lang.Throwable -> L85
        Lf:
            org.json.JSONObject r1 = r10.d     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "ab_sdk_version"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> L85
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L85
            if (r2 != 0) goto L83
            java.util.Set r2 = r10.c(r1)     // Catch: java.lang.Throwable -> L85
            java.util.HashSet r3 = new java.util.HashSet     // Catch: java.lang.Throwable -> L85
            r3.<init>()     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L63
            java.util.Iterator r4 = r11.keys()     // Catch: java.lang.Throwable -> L85
        L2c:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L85
            if (r5 == 0) goto L63
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L85
            boolean r6 = r5 instanceof java.lang.String     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L2c
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L85
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L85
            if (r6 != 0) goto L2c
            org.json.JSONObject r5 = r11.getJSONObject(r5)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            java.lang.String r6 = "vid"
            java.lang.String r5 = r5.optString(r6)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            r3.add(r5)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            goto L2c
        L50:
            r5 = move-exception
            com.bytedance.bdtracker.d r6 = r10.i     // Catch: java.lang.Throwable -> L85
            com.bytedance.applog.log.IAppLogLogger r6 = r6.D     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "DeviceManager"
            java.util.List r7 = java.util.Collections.singletonList(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L85
            java.lang.String r9 = "JSON handle failed"
            r6.error(r7, r9, r5, r8)     // Catch: java.lang.Throwable -> L85
            goto L2c
        L63:
            com.bytedance.bdtracker.u1 r11 = r10.c     // Catch: java.lang.Throwable -> L85
            java.lang.String r11 = r11.d()     // Catch: java.lang.Throwable -> L85
            java.util.Set r0 = r10.c(r11)     // Catch: java.lang.Throwable -> L85
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L85
            r2.retainAll(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r10.a(r2)     // Catch: java.lang.Throwable -> L85
            r10.f(r0)     // Catch: java.lang.Throwable -> L85
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L85
            if (r1 != 0) goto L83
            r10.a(r0, r11)     // Catch: java.lang.Throwable -> L85
        L83:
            monitor-exit(r10)
            return
        L85:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L85
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.d(org.json.JSONObject):void");
    }

    public boolean i(String str) {
        if (!a("user_unique_id", (Object) str)) {
            return false;
        }
        this.c.d.putString("user_unique_id", r.a((Object) str));
        return true;
    }

    public <T> T a(String str, T t, Class<T> cls) {
        return (T) this.i.j.a(this.d, str, (String) t, (Class<String>) cls);
    }

    public final void a(String str, String str2) {
        if (this.c.i() && this.c.c.isAbEnable()) {
            Set<String> setC = c(str);
            setC.removeAll(c(str2));
            h1 h1Var = this.i.y;
            if (h1Var != null) {
                h1Var.onAbVidsChange(a(setC), str2);
            }
        }
    }

    public synchronized boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        boolean z2;
        this.i.D.debug(Collections.singletonList("DeviceManager"), "saveRegisterInfo -> uuid:" + str + ", did:" + str2 + ", iid:" + str3 + ", ssid:" + str4 + ", did:" + str5 + ", cd:" + str6 + ", response:{}", jSONObject);
        if (!r.a(k(), str)) {
            this.i.D.debug(1, "saveRegisterInfo interrupted for uuid is changed", new Object[0]);
            return true;
        }
        this.e = jSONObject.optInt("new_user", 0) > 0;
        String strOptString = jSONObject.optString("device_token", "");
        boolean zA = r.a(str2);
        boolean zA2 = r.a(str3);
        boolean zA3 = r.a(str5);
        boolean zA4 = r.a(str6);
        try {
            boolean zA5 = r.a(str4);
            int i = this.g.getInt("version_code", 0);
            int iOptInt = this.d.optInt("version_code", 0);
            if (i != iOptInt) {
                this.g.putInt("version_code", iOptInt);
            }
            String string = this.g.getString("channel", "");
            String strOptString2 = this.d.optString("channel", "");
            if (!TextUtils.equals(string, strOptString2)) {
                this.g.putString("channel", strOptString2);
            }
            this.g.putString("device_token", strOptString);
            if ((zA || (zA3 && zA4)) && zA2) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.g.putLong("register_time", jCurrentTimeMillis);
                a("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zA && (!zA3 || !zA4)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                this.i.onEventV3("tt_fetch_did_error", jSONObject2, 0);
            }
            String strB = this.h.b();
            String string2 = this.g.getString("bd_did", null);
            this.i.D.debug(Collections.singletonList("DeviceManager"), "device: od=" + strB + " nd=" + str2 + " ck=" + zA, new Object[0]);
            if (zA) {
                if (str2.equals(this.d.optString("device_id"))) {
                    z2 = false;
                } else {
                    JSONObject jSONObject3 = this.d;
                    JSONObject jSONObject4 = new JSONObject();
                    r.a(jSONObject4, jSONObject3);
                    jSONObject4.put("device_id", str2);
                    b(jSONObject4);
                    this.h.b(str2);
                    z2 = true;
                }
                if (!str2.equals(strB)) {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            if (zA3 && a("bd_did", (Object) str5)) {
                this.g.putString("bd_did", str5);
                z2 = true;
            }
            String strOptString3 = this.d.optString("install_id", "");
            if (zA2 && a("install_id", (Object) str3)) {
                this.g.putString("install_id", str3);
                z2 = true;
            }
            String strOptString4 = this.d.optString("ssid", "");
            boolean z3 = (zA5 && h(str4)) ? true : z2;
            if (this.i.y != null) {
                this.i.y.onRemoteIdGet(z3, string2, str5, strOptString3, str3, strOptString4, str4);
            }
            z = false;
        } catch (Throwable th) {
            z = false;
            this.i.D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
        }
        return ((zA || (zA3 && zA4)) && zA2) ? true : z;
    }

    public String b() {
        if (this.a) {
            return this.d.optString("ab_sdk_version", "");
        }
        u1 u1Var = this.c;
        return u1Var != null ? u1Var.d.getString("ab_sdk_version", "") : "";
    }

    public void a(JSONObject jSONObject) {
        u1 u1Var = this.c;
        u1Var.b.D.debug(Collections.singletonList("ConfigManager"), "setAbConfig:{}", jSONObject);
        u1Var.d.putString("ab_configure", jSONObject == null ? "" : jSONObject.toString());
        u1Var.g = null;
        if (!LogUtils.isDisabled()) {
            LogUtils.sendJsonFetcher("set_abconfig", new v1(u1Var, jSONObject));
        }
        d(jSONObject);
    }

    public void a(HashMap<String, Object> map) {
        JSONObject jSONObject;
        if (map == null || map.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONObject jSONObjectD = d();
            if (jSONObjectD != null) {
                r.a(jSONObject, jSONObjectD);
            }
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                this.i.D.error(Collections.singletonList("DeviceManager"), "Set custom header failed", th, new Object[0]);
            }
        }
        c(jSONObject);
    }

    public final boolean a(String str, Object obj) {
        Object objOpt = this.d.opt(str);
        if (obj == objOpt || (obj != null && obj.equals(objOpt))) {
            if (this.a || obj != null || objOpt != null) {
                return false;
            }
            this.i.D.debug(com.bytedance.bdtracker.a.a("未初始化时都为 null 无法做到赋值的: ", str), new Object[0]);
            return true;
        }
        synchronized (this) {
            try {
                JSONObject jSONObject = this.d;
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, jSONObject);
                jSONObject2.put(str, obj);
                if (!this.a && obj == null) {
                    this.k.add(str);
                }
                b(jSONObject2);
            } catch (JSONException e) {
                this.i.D.error(Collections.singletonList("DeviceManager"), "Update header:{} to value:{} failed", e, str, obj);
            }
        }
        this.i.D.debug(Collections.singletonList("DeviceManager"), "Update header:{} from old:{} to new value:{}", str, objOpt, obj);
        return true;
    }
}
