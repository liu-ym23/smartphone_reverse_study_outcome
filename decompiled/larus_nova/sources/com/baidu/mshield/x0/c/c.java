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
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32472b;

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f32473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f32474b;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_baidu_mshield_x0_c_c$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_x0_c_c$a__run$___twin___() {
            String r100 = "4";
            String r101 = "1";
            int r102 = this.f32473a.optInt("1", 0);     // Catch: Throwable -> L65
            String r103 = this.f32473a.optString("4", "");     // Catch: Throwable -> L65
            if (this.f32473a.has("7") == false) goto L6;
            int r104 = this.f32473a.optJSONObject("7").optInt("1", 1);     // Catch: Throwable -> L65
        L7:
            String r110 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L65
            com.baidu.mshield.b.c.a.b("detect app encryptStr====" + c.a());     // Catch: Throwable -> L65
            String r105 = com.baidu.xclient.gdid.a.b(c.a());     // Catch: Throwable -> L65
            com.baidu.mshield.b.c.a.b("detect app decryptStr====" + r105);     // Catch: Throwable -> L65
            if (TextUtils.isEmpty(r105) == true) goto L10;
            JSONObject r106 = new JSONObject(r105);     // Catch: Throwable -> L65
        L11:
            JSONObject r107 = new JSONObject();     // Catch: Throwable -> L65
            String r111 = "8";
            String r108 = "0";
            if (r106.length() <= 0) goto L63;
            Iterator<String> r112 = r106.keys();     // Catch: Throwable -> L65
        L16:
            if (r112.hasNext() == false) goto L63;
            String r113 = r112.next();     // Catch: Throwable -> L65
            Iterator<String> r114 = r112;
            JSONObject r115 = r106.optJSONObject(r113);     // Catch: Throwable -> L65
            JSONObject r116 = r106;
            String r109 = r115.optString("p");     // Catch: Throwable -> L65
            String r117 = r103;
            JSONObject r118 = r115.optJSONObject("f");     // Catch: Throwable -> L65
            JSONObject r119 = new JSONObject();     // Catch: Throwable -> L65
            String r210 = r110;
            PackageInfo r120 = b.b(this.f32474b, r109);     // Catch: Throwable -> L65
            if (r120 != null) goto L20;
            r102 = r102;
            String r121 = r108;
            int r122 = r104;
            String r211 = r113;
            String r123 = r111;
            r119.put(r101, r121);     // Catch: Throwable -> L65
        L62:
            JSONObject r124 = r107;
            r124.put(r211, r119);     // Catch: Throwable -> L65
            r111 = r123;
            r104 = r122;
            r112 = r114;
            r106 = r116;
            r103 = r117;
            r110 = r210;
            r107 = r124;
            r108 = r121;
            r102 = r102;
            r100 = r100;
            goto L16
        L20:
            if (r102 != 1) goto L23;
            r119.put(r108, e.a(new PolarisFileWrapper(r120.applicationInfo.sourceDir)));     // Catch: Throwable -> L65
        L23:
            r119.put(r101, r101);     // Catch: Throwable -> L65
            if (b.c(this.f32474b, r109) == false) goto L26;
            r119.put(r100, r101);     // Catch: Throwable -> L65
        L27:
            ArrayList r125 = new ArrayList();     // Catch: Throwable -> L65
            JSONObject r126 = new JSONObject();     // Catch: Throwable -> L65
            if (r118 == null) goto L41;
            Iterator<String> r212 = r118.keys();     // Catch: Throwable -> L65
        L32:
            if (r212.hasNext() == false) goto L41;
            r113 = r113;
            StringBuffer r127 = new StringBuffer();     // Catch: Throwable -> L65
            r104 = r104;
            String r128 = r212.next();     // Catch: Throwable -> L65
            r108 = r108;
            String r129 = r118.optString(r128);     // Catch: Throwable -> L65
            if (TextUtils.isEmpty(r129) == true) goto L32;
            String r310 = r101;
            if (new PolarisFileWrapper(r129).exists() == false) goto L40;
            String[] r130 = com.baidu.mshield.b.a.b.a(r129);     // Catch: Throwable -> L65
            r127.append(r130[0]);     // Catch: Throwable -> L65
            r127.append("#");     // Catch: Throwable -> L65
            r127.append(r130[1]);     // Catch: Throwable -> L65
            r127.append("#");     // Catch: Throwable -> L65
            r127.append(r130[2]);     // Catch: Throwable -> L65
            r127.append("#");     // Catch: Throwable -> L65
            r127.append(r130[3]);     // Catch: Throwable -> L65
        L40:
            r125.add(r129);     // Catch: Throwable -> L65
            r126.put(r128, r127.toString());     // Catch: Throwable -> L65
            r101 = r310;
            r111 = r111;
            r118 = r118;
        L41:
            String r311 = r101;
            String r213 = r108;
            JSONObject r312 = r118;
            int r214 = r104;
            r211 = r113;
            String r313 = r111;
            r119.put("3", String.valueOf(b.a(this.f32474b, r109, r125)));     // Catch: Throwable -> L65
            r119.put("5", r126.toString());     // Catch: Throwable -> L65
            r119.put("6", r120.firstInstallTime);     // Catch: Throwable -> L65
            r119.put("7", r120.lastUpdateTime);     // Catch: Throwable -> L65
            if (r312 != null) goto L46;
        L48:
            r101 = r311;
            r123 = r313;
            r121 = r213;
            r119.put(r123, r121);     // Catch: Throwable -> L65
        L50:
            r119.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r120.versionName);     // Catch: Throwable -> L65
            r122 = r214;
            if (r122 != 1) goto L62;
            String[] r131 = b.a(this.f32474b, r109);     // Catch: Throwable -> L65
            int r132 = 0;
        L54:
            if (r132 >= r131.length) goto L62;
            String r133 = r131[r132];     // Catch: Throwable -> L65
            StringBuffer r134 = new StringBuffer();     // Catch: Throwable -> L65
            if (TextUtils.isEmpty(r133) == true) goto L59;
            String[] r135 = com.baidu.mshield.b.a.b.a(r133);     // Catch: Throwable -> L65
            r134.append(r135[0]);     // Catch: Throwable -> L65
            r134.append("#");     // Catch: Throwable -> L65
            r134.append(r135[1]);     // Catch: Throwable -> L65
            r134.append("#");     // Catch: Throwable -> L65
            r134.append(r135[2]);     // Catch: Throwable -> L65
            r134.append("#");     // Catch: Throwable -> L65
            r134.append(r135[3]);     // Catch: Throwable -> L65
        L59:
            r119.put(String.valueOf(r132 + 10), r134.toString());     // Catch: Throwable -> L65
            r132 = r132 + 1;     // Catch: Throwable -> L65
            goto L54
        L46:
            if (r312.length() <= 0) goto L48;
            r101 = r311;
            r123 = r313;
            r119.put(r123, r101);     // Catch: Throwable -> L65
            r121 = r213;
            goto L50
        L26:
            r119.put(r100, r108);     // Catch: Throwable -> L65
        L63:
            JSONArray r136 = new JSONArray();     // Catch: Throwable -> L65
            JSONObject r137 = new JSONObject();     // Catch: Throwable -> L65
            r137.put("3", r107);     // Catch: Throwable -> L65
            r137.put(r108, r110);     // Catch: Throwable -> L65
            r137.put("5", r103);     // Catch: Throwable -> L65
            r137.put(r111, EngineImpl.getInstance(this.f32474b).getPropertyByType("mod"));     // Catch: Throwable -> L65
            r136.put(r137);     // Catch: Throwable -> L65
            com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + r136);     // Catch: Throwable -> L65
            d.b(this.f32474b, r136, "1001159");     // Catch: Throwable -> L65
            return;
        L10:
            r106 = new JSONObject();     // Catch: Throwable -> L65
            goto L11
        L6:
            r104 = 0;
        L65:
            th = move-exception;
            d.a(th);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_x0_c_c$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mshield_x0_c_c$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(JSONObject r100, Context r101) {
            this.f32473a = r100;
            this.f32474b = r101;
        }
    }

    public static /* synthetic */ String a() {
        return f32472b;
    }

    public static void a(Context r110) {
        com.baidu.mshield.x0.l.a r100 = new com.baidu.mshield.x0.l.a(r110);     // Catch: Throwable -> L30
        String r101 = r100.c("plc115");     // Catch: Throwable -> L30
        com.baidu.mshield.b.c.a.b("handleCollectRoutine: policy=" + r101);     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L30
        int r103 = 0;
        boolean r104 = true;
        if (r102.optInt("1", 0) == 1) goto L10;
        r104 = false;
    L10:
        com.baidu.mshield.b.c.a.b("handleCollectRoutine: sw=" + r104);     // Catch: Throwable -> L30
        if (r104 == true) goto L14;
        return;
    L14:
        if ((System.currentTimeMillis() - r100.h()) >= (((long) r102.optInt("3", 24)) * 3600000)) goto L17;
        com.baidu.mshield.b.c.a.b("handleCollectRoutine not time");     // Catch: Throwable -> L30
        return;
    L17:
        JSONObject r105 = r102.optJSONObject("5").optJSONObject("uv4");     // Catch: Throwable -> L30
        if (r105 == null) goto L34;
        int r106 = r105.optInt("3", 10);     // Catch: Throwable -> L30
        if (r105.has("7") == false) goto L23;
        r103 = r105.optJSONObject("7").optInt("2", 0);     // Catch: Throwable -> L30
    L23:
        if (r103 != 0) goto L25;
        f32472b = f32471a;     // Catch: Throwable -> L30
    L27:
        if (TextUtils.isEmpty(f32472b) == true) goto L35;
        new PthreadTimer("shield/x0/c/c").schedule(new a(r105, r110), r106 * 1000);     // Catch: Throwable -> L30
        return;
    L35:
        return;
    L25:
        f32472b = r105.optString("2");     // Catch: Throwable -> L30
        goto L27
    L34:
        return;
    L30:
        th = move-exception;
        d.a(th);
    }
}
