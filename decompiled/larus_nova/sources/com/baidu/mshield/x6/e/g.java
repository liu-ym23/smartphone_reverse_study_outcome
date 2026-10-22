package com.baidu.mshield.x6.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.baidu.mshield.x6.EngineImpl;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32595a;

    public final JSONObject b() {
        String r100 = "";
        JSONObject r101 = com.baidu.xclient.gdid.a.a();     // Catch: Throwable -> L115
        com.baidu.mshield.b.c.a.a("praseJsonData jsonObject=" + r101);     // Catch: Throwable -> L115
        if (r101 == null) goto L114;
        com.baidu.mshield.x6.b.b r102 = new com.baidu.mshield.x6.b.b(this.f32595a);     // Catch: Throwable -> L115
        r101.put("15004", com.baidu.mshield.x6.f.f.a());     // Catch: Throwable -> L115
        r101.put("15101", EngineImpl.getInstance(this.f32595a).getPropertyByType(EngineImpl.KEY_CUID));     // Catch: Throwable -> L115
        r101.put("15110", EngineImpl.getInstance(this.f32595a).getPropertyByType("aid"));     // Catch: Throwable -> L115
        r101.put("15018", EngineImpl.getInstance(this.f32595a).getPropertyByType(EngineImpl.KEY_OAID));     // Catch: Throwable -> L115
        String r103 = EngineImpl.getInstance(this.f32595a).getPropertyByType("sl");     // Catch: Throwable -> L115
        r101.put("07001", r103);     // Catch: Throwable -> L115
        String r110 = "0";
        if (com.baidu.mshield.x6.f.f.a(this.f32595a) == false) goto L19;
        Object r111 = "1";
    L20:
        r101.put("02037", r111);     // Catch: Throwable -> L115
        r101.put("17001", com.baidu.mshield.x6.c.b.a());     // Catch: Throwable -> L115
        r101.put("06005", a(this.f32595a));     // Catch: Throwable -> L115
        com.baidu.mshield.b.c.a.b("07001 sensor list=" + r103);     // Catch: Throwable -> L115
        r101.put("15100", com.baidu.mshield.x6.f.f.g(this.f32595a));     // Catch: Throwable -> L48
        boolean r104 = a.a(this.f32595a, com.baidu.mshield.x6.b.b.f32565n);     // Catch: Throwable -> L48
        boolean r112 = true;
        boolean r113 = a.a(this.f32595a, com.baidu.mshield.x6.b.b.f32565n, "2", true);     // Catch: Throwable -> L48
        if (r104 == false) goto L30;
        if (r113 == false) goto L30;
    L32:
        if (r112 == false) goto L34;
        Object r114 = "1";
    L35:
        r101.put("15090", r114);     // Catch: Throwable -> L48
        if (r104 == false) goto L39;
        Object r105 = "1";
    L40:
        r101.put("15093", r105);     // Catch: Throwable -> L48
        if (r102.C() == false) goto L45;
        Object r115 = "0";
    L46:
        r101.put("15099", r115);     // Catch: Throwable -> L48
    L50:
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L115
        r106.put("3", EngineImpl.getInstance(this.f32595a).getPropertyByType("p"));     // Catch: Throwable -> L115
        r106.put("4", EngineImpl.getInstance(this.f32595a).getPropertyByType("s"));     // Catch: Throwable -> L115
        EngineImpl.getInstance(this.f32595a).getSecApi().a(this.f32595a, r106);     // Catch: Throwable -> L115
        r101.put("1011105", r106);     // Catch: Throwable -> L115
        String r107 = com.baidu.mshield.x6.f.f.b(this.f32595a);     // Catch: Throwable -> L68
        if (TextUtils.isEmpty(r107) == true) goto L67;
        JSONObject r116 = new JSONObject(r107);     // Catch: Throwable -> L68
        String r108 = r116.optString("1");     // Catch: Throwable -> L68
        if (TextUtils.isEmpty(r108) == true) goto L59;
        String r117 = new String(com.baidu.mshield.b.a.c.b(Base64.decode(r108.getBytes(), 0)), XML.CHARSET_UTF8);     // Catch: Throwable -> L68
        com.baidu.mshield.b.c.a.a("getJsonDataPart18 ungzDrf : ".concat(r117));     // Catch: Throwable -> L68
    L128:
        String r109 = r116.optString("3");     // Catch: Throwable -> L65
        r100 = r116.optString("2");     // Catch: Throwable -> L63
    L76:
        String r118 = r100;
        r100 = r117;
    L79:
        if (TextUtils.isEmpty(r100) == true) goto L81;
        r110 = "1";
    L81:
        r101.put("15091", r110);     // Catch: Throwable -> L115
        r101.put("15082", r118 + "#" + r102.E());     // Catch: Throwable -> L115
        r101.put("15083", r109);     // Catch: Throwable -> L115
        if (TextUtils.isEmpty(r100) == true) goto L100;
        com.baidu.mshield.b.c.a.a("real machine sig is not empty");     // Catch: Throwable -> L115
        com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy datas===".concat(r100));     // Catch: Throwable -> L115
        long r119 = System.currentTimeMillis();     // Catch: Throwable -> L115
        List<String> r120 = com.baidu.mshield.x6.c.a.a(r100);     // Catch: Throwable -> L115
        r101.put("d0005", String.valueOf(System.currentTimeMillis() - r119));     // Catch: Throwable -> L115
        JSONArray r121 = new JSONArray();     // Catch: Throwable -> L115
        if (r120 != null) goto L88;
    L94:
        r101.put("15084", r121);     // Catch: Throwable -> L115
        long r122 = System.currentTimeMillis();     // Catch: Throwable -> L115
        JSONObject r123 = com.baidu.mshield.x6.c.a.b(r100);     // Catch: Throwable -> L115
        long r124 = System.currentTimeMillis();     // Catch: Throwable -> L115
        com.baidu.mshield.b.c.a.a("cpp param 2 result : " + r123);     // Catch: Throwable -> L115
        r101.put("d0006", String.valueOf(r124 - r122));     // Catch: Throwable -> L115
        r101.put("15085", r123.toString());     // Catch: Throwable -> L115
        goto L100
    L88:
        if (r120.size() <= 0) goto L94;
        Iterator<String> r125 = r120.iterator();     // Catch: Throwable -> L115
    L91:
        if (r125.hasNext() == false) goto L93;
        r121.put(r125.next());     // Catch: Throwable -> L115
        goto L91
    L93:
        com.baidu.mshield.b.c.a.a("getEmulatorResult 15084===" + r121);     // Catch: Throwable -> L115
    L100:
        if (a.a(this.f32595a, com.baidu.mshield.x6.b.b.f32566o) == false) goto L113;
        String r126 = com.baidu.mshield.x6.f.f.c(this.f32595a);     // Catch: Throwable -> L115
        if (TextUtils.isEmpty(r126) == true) goto L113;
        com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy===" + r126);     // Catch: Throwable -> L115
        List<String> r127 = com.baidu.mshield.x6.c.a.a(r126);     // Catch: Throwable -> L115
        JSONArray r128 = new JSONArray();     // Catch: Throwable -> L115
        if (r127 != null) goto L106;
    L112:
        r101.put("14001", r128);     // Catch: Throwable -> L115
        goto L113
    L106:
        if (r127.size() <= 0) goto L112;
        Iterator<String> r129 = r127.iterator();     // Catch: Throwable -> L115
    L109:
        if (r129.hasNext() == false) goto L111;
        r128.put(r129.next());     // Catch: Throwable -> L115
        goto L109
    L111:
        com.baidu.mshield.b.c.a.a("getEmulatorResult 14001===" + r128);     // Catch: Throwable -> L115
    L113:
        r101.put("15086", com.baidu.mshield.x6.f.f.e() + "#" + com.baidu.mshield.x6.f.f.d());     // Catch: Throwable -> L115
    L63:
        th = th;
    L70:
        com.baidu.mshield.x6.f.f.b(th);     // Catch: Throwable -> L115
        r101.put("15094", com.baidu.mshield.x6.f.f.a(th));     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);     // Catch: Throwable -> L115
    L65:
        th = th;
        r109 = "";
        goto L70
    L59:
        r117 = "";
        goto L128
    L67:
        r118 = "";
        r109 = r118;
    L68:
        th = th;
        r109 = "";
        r117 = r109;
        goto L70
    L45:
        r115 = "1";
        goto L46
    L39:
        r105 = "0";
        goto L40
    L34:
        r114 = "0";
    L30:
        r112 = false;
    L48:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);     // Catch: Throwable -> L115
        goto L50
    L19:
        r111 = "0";
    L114:
        return r101;
    L115:
        th = move-exception;
        a(th);
        return null;
    }

    public JSONObject a() {
        return b();
    L4:
        th = move-exception;
        a(th);
        return null;
    }

    public static String a(Context r100) {
        Intent r101 = INVOKEVIRTUAL_com_baidu_mshield_x6_e_g_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L10
        if (r101 != null) goto L6;
        return null;
    L6:
        String r102 = r101.getStringExtra("technology");     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return "unknown";
    L15:
        return r102;
    L10:
        e = move-exception;
        com.baidu.mshield.x6.f.f.b(e);
        return null;
    }

    public final void a(Throwable r100) {
        com.baidu.mshield.x6.f.f.b(r100);
    }

    public g(Context r100, int r101) {
        this.f32595a = r100;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_x6_e_g_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
