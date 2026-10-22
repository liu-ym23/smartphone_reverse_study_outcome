package com.baidu.mshield.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f32364a = null;

    static {
        f32364a = new HashMap();
    }

    public static String a() {
        return a("mod");
    }

    public static String b() {
        return a("arv");
    }

    public static String a(String r100) {
        HashMap<String, String> r101 = f32364a;     // Catch: Throwable -> L15
        if (r101.size() <= 0) goto L21;
        monitor-enter(r101);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (r101.containsKey(r100) == false) goto L10;
        String r102 = r101.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return "";
    L21:
        return "";
    L15:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return "";
    }

    public static String b(Context r110) {
        String r111 = a(r110);     // Catch: Throwable -> L144
        if (TextUtils.isEmpty(r111) == false) goto L7;
        return "";
    L7:
        if (r111.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) == false) goto L11;
        return "EmotionUI";
    L11:
        if (r111.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == false) goto L15;
        return "MagicUI";
    L15:
        if (r111.equalsIgnoreCase("XIAOMI") == false) goto L19;
        return com.baidu.sec.privacy.f.g.a("ro.miui.ui.version.name", "MIUI");
    L19:
        if (r111.equalsIgnoreCase("OPPO") == false) goto L23;
        return "ColorOS";
    L23:
        if (r111.equalsIgnoreCase("VIVO") == false) goto L27;
        return com.baidu.sec.privacy.f.g.a("ro.vivo.os.name", "Funtouch");
    L27:
        if (r111.equalsIgnoreCase("BBK") == false) goto L31;
        return "BBK";
    L31:
        if (r111.equalsIgnoreCase("MEIZU") == false) goto L35;
        return com.baidu.sec.privacy.f.g.a("ro.build.user", "Flyme");
    L35:
        if (r111.equalsIgnoreCase(SmEditTextLeakOpt.SAMSUNG) == false) goto L39;
        return "SAMSUNG";
    L39:
        if (r111.equalsIgnoreCase("GiONEE") == false) goto L44;
        return com.baidu.sec.privacy.f.g.a("ro.build.display.id", "Amigo");
    L44:
        if (r111.equalsIgnoreCase(RomUtils.ROM_ZTE) == false) goto L55;
        String r112 = a();     // Catch: Throwable -> L144
        if (TextUtils.isEmpty(r112) == true) goto L52;
        if (r112.equalsIgnoreCase("X9180") == false) goto L52;
        return "Bliss";
    L52:
        return com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", RomUtils.ROM_ZTE);
    L55:
        if (r111.equalsIgnoreCase("LeMobile") == false) goto L58;
        return "EUI";
    L58:
        if (r111.equalsIgnoreCase("Letv") == false) goto L61;
        return "EUI";
    L61:
        if (r111.equalsIgnoreCase(RomUtils.ROM_LENOVO) == false) goto L64;
        return RomUtils.ROM_LENOVO;
    L64:
        if (r111.equalsIgnoreCase("YuLong") == false) goto L68;
        return "COOLUI";
    L68:
        if (r111.equalsIgnoreCase("OnePlus") == false) goto L72;
        return "H2OS";
    L72:
        if (r111.equalsIgnoreCase("QiKU") == false) goto L76;
        return "QIKU";
    L76:
        if (r111.equalsIgnoreCase("nubia") == false) goto L80;
        return com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", "NUBIAUI");
    L80:
        if (r111.equalsIgnoreCase("motorola") == false) goto L84;
        return "MOTOROLA";
    L84:
        if (r111.equalsIgnoreCase("HTC") == false) goto L88;
        return "HTC Sense";
    L88:
        if (r111.equalsIgnoreCase("ZUK") == false) goto L92;
        return "ZUI";
    L92:
        if (r111.equalsIgnoreCase("coolpad") == false) goto L96;
        return "COOLPAD";
    L96:
        if (r111.equalsIgnoreCase(AppConstants.CHANNEL_360) == false) goto L100;
        return com.baidu.sec.privacy.f.g.a("ro.build.uiversion", AppConstants.CHANNEL_360);
    L100:
        if (r111.equalsIgnoreCase("K-Touch") == false) goto L104;
        return "KTOUCH";
    L104:
        if (r111.equalsIgnoreCase("MeiTu") == false) goto L108;
        return com.baidu.sec.privacy.f.g.a("ro.build.user", "MEITU");
    L108:
        if (r111.equalsIgnoreCase("DOOV") == false) goto L112;
        return com.baidu.sec.privacy.f.g.a("ro.fota.oem", "DOOV");
    L112:
        if (r111.equalsIgnoreCase("TCL") == false) goto L115;
        return "TCL";
    L115:
        if (r111.equalsIgnoreCase("Yota Devices Limited") == false) goto L119;
        return "Yota";
    L119:
        if (r111.equalsIgnoreCase("lge") == false) goto L123;
        return com.baidu.sec.privacy.f.g.a("ro.build.product", "LGE");
    L123:
        if (r111.equalsIgnoreCase("hisense") == false) goto L127;
        return "VISION";
    L127:
        if (r111.equalsIgnoreCase("Changhong") == false) goto L131;
        return "CHANGHONG";
    L131:
        if (r111.equalsIgnoreCase("Sony") == false) goto L134;
        return "Sony";
    L134:
        if (r111.equalsIgnoreCase("smartisan") == false) goto L137;
        return "smartisan";
    L137:
        if (r111.equalsIgnoreCase("NM") == false) goto L141;
        return "newman";
    L141:
        if (r111.equalsIgnoreCase("REALME") == false) goto L146;
        return "realmeUI";
    L146:
        return "";
    L144:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        goto L146
    }

    public static String c(Context r100) {
        String r101 = a(r100);     // Catch: Throwable -> L139
        String r102 = com.baidu.sec.privacy.f.g.a("ro.build.display.id", "");     // Catch: Throwable -> L139
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return r102;
    L8:
        if (r101.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) == false) goto L13;
        return com.baidu.sec.privacy.f.g.a(com.alipay.sdk.m.c.a.f25238a, r102);
    L13:
        if (r101.equalsIgnoreCase("XIAOMI") == false) goto L18;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", r102);
    L18:
        if (r101.equalsIgnoreCase("OPPO") == false) goto L22;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.opporom", r102);
    L22:
        if (r101.equalsIgnoreCase("VIVO") == false) goto L26;
        return com.baidu.sec.privacy.f.g.a("ro.vivo.rom.version", r102);
    L26:
        if (r101.equalsIgnoreCase("BBK") == false) goto L30;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.bbk", r102);
    L30:
        if (r101.equalsIgnoreCase("MEIZU") == false) goto L34;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", r102);
    L34:
        if (r101.equalsIgnoreCase("SAMSUNG") == false) goto L37;
        return r102;
    L37:
        if (r101.equalsIgnoreCase("GiONEE") == false) goto L41;
        return r102;
    L41:
        if (r101.equalsIgnoreCase(RomUtils.ROM_ZTE) == false) goto L49;
        String r103 = com.baidu.sec.privacy.f.g.a("ro.build.rom.id", r102);     // Catch: Throwable -> L139
        if (r102.equals(r103) == false) goto L143;
        String r104 = com.baidu.sec.privacy.f.g.a("apps.setting.product.release", r102);     // Catch: Throwable -> L139
        if (r102.equals(r104) == true) goto L47;
        return r104;
    L47:
        return com.baidu.sec.privacy.f.g.a("ro.bliss.display.version", r102);
    L143:
        return r103;
    L49:
        if (r101.equalsIgnoreCase("LeMobile") == true) goto L138;
        if (r101.equalsIgnoreCase("Letv") == true) goto L138;
        if (r101.equalsIgnoreCase(RomUtils.ROM_LENOVO) == false) goto L66;
        String r105 = a();     // Catch: Throwable -> L139
        if (TextUtils.isEmpty(r105) == false) goto L58;
    L136:
        return r102;
    L58:
        if (r105.equalsIgnoreCase("Lenovo A5800-D") == false) goto L62;
        return com.baidu.sec.privacy.f.g.a("ro.build.cmccdisplay.id", r102);
    L62:
        if (r105.equalsIgnoreCase("Lenovo K900") == false) goto L136;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", r102);
    L66:
        if (r101.equalsIgnoreCase("YuLong") == false) goto L69;
        return r102;
    L69:
        if (r101.equalsIgnoreCase("OnePlus") == false) goto L73;
        return com.baidu.sec.privacy.f.g.a("ro.rom.version", r102);
    L73:
        if (r101.equalsIgnoreCase("QiKU") == false) goto L77;
        return com.baidu.sec.privacy.f.g.a("ro.build.uiversion", r102);
    L77:
        if (r101.equalsIgnoreCase("nubia") == false) goto L81;
        return com.baidu.sec.privacy.f.g.a("ro.build.rom.id", r102);
    L81:
        if (r101.equalsIgnoreCase("motorola") == false) goto L84;
        return r102;
    L84:
        if (r101.equalsIgnoreCase("HTC") == false) goto L88;
        return com.baidu.sec.privacy.f.g.a("ro.build.sense.version", r102);
    L88:
        if (r101.equalsIgnoreCase("ZUK") == false) goto L92;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", r102);
    L92:
        if (r101.equalsIgnoreCase("K-Touch") == false) goto L96;
        return com.baidu.sec.privacy.f.g.a("ro.yunos.version", r102);
    L96:
        if (r101.equalsIgnoreCase("MeiTu") == false) goto L101;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.meios", r102);
    L101:
        if (r101.equalsIgnoreCase("DOOV") == false) goto L105;
        return com.baidu.sec.privacy.f.g.a("ro.fota.version", r102);
    L105:
        if (r101.equalsIgnoreCase("hisense") == false) goto L117;
        String r106 = a();     // Catch: Throwable -> L139
        if (TextUtils.isEmpty(r106) == true) goto L136;
        if (r106.equalsIgnoreCase("hisense e76") == false) goto L113;
        return com.baidu.sec.privacy.f.g.a("ro.hs.ui.style", r102);
    L113:
        if (r106.equalsIgnoreCase("hisense e51-m") == false) goto L136;
        return com.baidu.sec.privacy.f.g.a("hw.cabl.version", r102);
    L117:
        if (r101.equalsIgnoreCase("Changhong") == false) goto L121;
        return com.baidu.sec.privacy.f.g.a("ro.fota.version", r102);
    L121:
        if (r101.equalsIgnoreCase("smartisan") == false) goto L125;
        return com.baidu.sec.privacy.f.g.a("ro.smartisan.version", r102);
    L125:
        if (r101.equalsIgnoreCase("NM") == false) goto L129;
        return com.baidu.sec.privacy.f.g.a("ro.xh.display.version", r102);
    L129:
        if (r101.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == false) goto L133;
        return com.baidu.sec.privacy.f.g.a(com.alipay.sdk.m.c.a.f25238a, r102);
    L133:
        if (r101.equalsIgnoreCase("REALME") == false) goto L136;
        return com.baidu.sec.privacy.f.g.a("ro.build.version.opporom", r102);
    L138:
        return com.baidu.sec.privacy.f.g.a("ro.letv.release.version", r102);
    L139:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return "";
    }

    public static void a(HashMap<String, String> r100) {
        if (r100 == null) goto L11;
        HashMap<String, String> r101 = f32364a;
        monitor-enter(r101);
        r101.putAll(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b(HashMap<String, String> r100) {
        if (r100 == null) goto L25;
    L17:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return;
    L4:
        if (r100.size() == 0) goto L26;
        HashMap<String, String> r101 = f32364a;     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L14
        f32364a.put(r103, r100.get(r103));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
    L27:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L26:
        return;
    }

    public static String a(Context r100) {
        return com.baidu.sec.privacy.e.a.a(r100).b();
    }
}
