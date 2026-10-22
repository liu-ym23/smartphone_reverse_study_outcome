package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32467a = "";

    /* JADX INFO: renamed from: com.baidu.mshield.x0.c.a$a, reason: collision with other inner class name */
    public static class C0655a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f32468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f32469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.baidu.mshield.x0.l.a f32470c;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_baidu_mshield_x0_c_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_x0_c_a$a__run$___twin___() {
            String r100 = "4";
            String r101 = "7";
            String r102 = "1";
            int r110 = this.f32468a.optInt("1", 0);     // Catch: Throwable -> L63
            String r111 = this.f32468a.optString("4", "");     // Catch: Throwable -> L63
            String r112 = this.f32468a.optString("5", "");     // Catch: Throwable -> L63
            String r113 = this.f32468a.optString("6", "");     // Catch: Throwable -> L63
            if (this.f32468a.has("7") == false) goto L6;
            int r114 = this.f32468a.optJSONObject("7").optInt("1", 1);     // Catch: Throwable -> L63
        L7:
            String r115 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L63
            com.baidu.mshield.b.c.a.b("detect app encryptStr====" + a.f32467a);     // Catch: Throwable -> L63
            String r103 = com.baidu.xclient.gdid.a.b(a.f32467a);     // Catch: Throwable -> L63
            com.baidu.mshield.b.c.a.b("detect app decryptStr====" + r103);     // Catch: Throwable -> L63
            if (TextUtils.isEmpty(r103) == true) goto L10;
            JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L63
        L11:
            JSONObject r105 = new JSONObject();     // Catch: Throwable -> L63
            String r116 = "8";
            String r117 = "0";
            if (r104.length() <= 0) goto L61;
            Iterator<String> r106 = r104.keys();     // Catch: Throwable -> L63
        L16:
            if (r106.hasNext() == false) goto L61;
            Iterator<String> r210 = r106;
            String r107 = r106.next();     // Catch: Throwable -> L63
            String r211 = r111;
            JSONObject r118 = r104.optJSONObject(r107);     // Catch: Throwable -> L63
            JSONObject r212 = r104;
            String r108 = r118.optString("p");     // Catch: Throwable -> L63
            String r213 = r115;
            JSONObject r119 = r118.optJSONObject("f");     // Catch: Throwable -> L63
            JSONObject r120 = new JSONObject();     // Catch: Throwable -> L63
            JSONObject r214 = r105;
            PackageInfo r109 = b.b(this.f32469b, r108);     // Catch: Throwable -> L63
            if (r109 == null) goto L59;
            String r215 = r107;
            if (r110 != 1) goto L23;
            r120.put(r117, e.a(new PolarisFileWrapper(r109.applicationInfo.sourceDir)));     // Catch: Throwable -> L63
        L23:
            r120.put(r102, r102);     // Catch: Throwable -> L63
            if (b.c(this.f32469b, r108) == false) goto L26;
            r120.put(r100, r102);     // Catch: Throwable -> L63
        L27:
            ArrayList r121 = new ArrayList();     // Catch: Throwable -> L63
            JSONObject r122 = new JSONObject();     // Catch: Throwable -> L63
            String r310 = r100;
            if (r119 == null) goto L41;
            Iterator<String> r311 = r119.keys();     // Catch: Throwable -> L63
        L32:
            if (r311.hasNext() == false) goto L41;
            r114 = r114;
            StringBuffer r123 = new StringBuffer();     // Catch: Throwable -> L63
            r117 = r117;
            String r124 = r311.next();     // Catch: Throwable -> L63
            r102 = r102;
            String r125 = r119.optString(r124);     // Catch: Throwable -> L63
            if (TextUtils.isEmpty(r125) == true) goto L32;
            String r312 = r116;
            if (new PolarisFileWrapper(r125).exists() == false) goto L40;
            String[] r126 = com.baidu.mshield.b.a.b.a(r125);     // Catch: Throwable -> L63
            r123.append(r126[0]);     // Catch: Throwable -> L63
            r123.append("#");     // Catch: Throwable -> L63
            r123.append(r126[1]);     // Catch: Throwable -> L63
            r123.append("#");     // Catch: Throwable -> L63
            r123.append(r126[2]);     // Catch: Throwable -> L63
            r123.append("#");     // Catch: Throwable -> L63
            r123.append(r126[3]);     // Catch: Throwable -> L63
        L40:
            r121.add(r125);     // Catch: Throwable -> L63
            r122.put(r124, r123.toString());     // Catch: Throwable -> L63
            r116 = r312;
            r119 = r119;
            r101 = r101;
        L41:
            String r313 = r102;
            JSONObject r314 = r119;
            String r315 = r117;
            String r316 = r116;
            int r317 = r114;
            r120.put("3", String.valueOf(b.a(this.f32469b, r108, r121)));     // Catch: Throwable -> L63
            r120.put("5", r122.toString());     // Catch: Throwable -> L63
            r120.put("6", r109.firstInstallTime);     // Catch: Throwable -> L63
            r101 = r101;
            r120.put(r101, r109.lastUpdateTime);     // Catch: Throwable -> L63
            if (r314 != null) goto L44;
        L46:
            r102 = r313;
            String r127 = r316;
            String r128 = r315;
            r120.put(r127, r128);     // Catch: Throwable -> L63
        L48:
            r120.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r109.versionName);     // Catch: Throwable -> L63
            r114 = r317;
            if (r114 != 1) goto L60;
            String[] r129 = b.a(this.f32469b, r108);     // Catch: Throwable -> L63
            int r130 = 0;
        L52:
            if (r130 >= r129.length) goto L60;
            String r131 = r129[r130];     // Catch: Throwable -> L63
            StringBuffer r132 = new StringBuffer();     // Catch: Throwable -> L63
            if (TextUtils.isEmpty(r131) == true) goto L57;
            String[] r133 = com.baidu.mshield.b.a.b.a(r131);     // Catch: Throwable -> L63
            r132.append(r133[0]);     // Catch: Throwable -> L63
            r132.append("#");     // Catch: Throwable -> L63
            r132.append(r133[1]);     // Catch: Throwable -> L63
            r132.append("#");     // Catch: Throwable -> L63
            r132.append(r133[2]);     // Catch: Throwable -> L63
            r132.append("#");     // Catch: Throwable -> L63
            r132.append(r133[3]);     // Catch: Throwable -> L63
        L57:
            r120.put(String.valueOf(r130 + 10), r132.toString());     // Catch: Throwable -> L63
            r130 = r130 + 1;     // Catch: Throwable -> L63
            r129 = r129;
        L60:
            r214.put(r215, r120);     // Catch: Throwable -> L63
            r105 = r214;
            r116 = r127;
            r117 = r128;
            r111 = r211;
            r106 = r210;
            r104 = r212;
            r115 = r213;
            r110 = r110;
            r100 = r310;
            goto L16
        L44:
            if (r314.length() <= 0) goto L46;
            r102 = r313;
            r127 = r316;
            r120.put(r127, r102);     // Catch: Throwable -> L63
            r128 = r315;
            goto L48
        L26:
            r120.put(r100, r117);     // Catch: Throwable -> L63
            goto L27
        L59:
            r310 = r100;
            r215 = r107;
            r110 = r110;
            r128 = r117;
            r127 = r116;
            r120.put(r102, r128);     // Catch: Throwable -> L63
        L61:
            JSONObject r134 = r105;
            String r216 = r111;
            JSONArray r135 = new JSONArray();     // Catch: Throwable -> L63
            JSONObject r136 = new JSONObject();     // Catch: Throwable -> L63
            r136.put("3", r134);     // Catch: Throwable -> L63
            r136.put(r117, r115);     // Catch: Throwable -> L63
            r136.put("5", r216);     // Catch: Throwable -> L63
            r136.put("6", r112);     // Catch: Throwable -> L63
            r136.put(r101, r113);     // Catch: Throwable -> L63
            r136.put(r116, EngineImpl.getInstance(this.f32469b).getPropertyByType("mod"));     // Catch: Throwable -> L63
            r135.put(r136);     // Catch: Throwable -> L63
            com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + r135);     // Catch: Throwable -> L63
            d.b(this.f32469b, r135, "1001159");     // Catch: Throwable -> L63
            StringBuffer r137 = new StringBuffer();     // Catch: Throwable -> L63
            r137.append(r216);     // Catch: Throwable -> L63
            r137.append("_");     // Catch: Throwable -> L63
            r137.append(r112);     // Catch: Throwable -> L63
            r137.append("_");     // Catch: Throwable -> L63
            r137.append(r113);     // Catch: Throwable -> L63
            this.f32470c.f(r137.toString());     // Catch: Throwable -> L63
            a.f32467a = "";     // Catch: Throwable -> L63
            return;
        L10:
            r104 = new JSONObject();     // Catch: Throwable -> L63
            goto L11
        L6:
            r114 = 0;
        L63:
            th = move-exception;
            d.a(th);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_x0_c_a$a_com_larus_apm_impl_protector_RunnableLancet_run(C0655a r100) {
            r100.com_baidu_mshield_x0_c_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C0655a(JSONObject r100, Context r101, com.baidu.mshield.x0.l.a r102) {
            this.f32468a = r100;
            this.f32469b = r101;
            this.f32470c = r102;
        }
    }

    public static void a(Context r100) {
        com.baidu.mshield.x0.l.a r101 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L18
        String r102 = r101.c("plc114");     // Catch: Throwable -> L18
        com.baidu.mshield.b.c.a.b("handleNativeCollect: policy=" + r102);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L18
        boolean r104 = false;
        if (r103.optInt("1", 0) != 1) goto L9;
        r104 = true;
    L9:
        com.baidu.mshield.b.c.a.b("handleNativeCollect: sw=" + r104);     // Catch: Throwable -> L18
        if (r104 == true) goto L12;
        return;
    L12:
        JSONObject r105 = r103.optJSONObject("5").optJSONObject("uv6");     // Catch: Throwable -> L18
        if (r105 == null) goto L23;
        com.baidu.mshield.b.c.a.b("detect app encrypt===" + f32467a);     // Catch: Throwable -> L18
        int r106 = r105.optInt("3", 10);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(f32467a) == true) goto L24;
        new PthreadTimer("shield/x0/c/a").schedule(new C0655a(r105, r100, r101), r106 * 1000);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L18:
        th = move-exception;
        d.a(th);
    }
}
