package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.dtf.face.api.IDTFacade;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes28.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f27814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f27815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f27816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f27817d;

    static {
        f27814a = new ConcurrentHashMap();
        f27815b = new ConcurrentHashMap();
        f27816c = false;
    }

    private static void b() {
        String[] r100 = p3.e(f27817d, "Localizable/strings/en/Localizable_map.strings").split("\";");     // Catch: Exception -> L18
        int r101 = r100.length;     // Catch: Exception -> L18
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L30;
        String r103 = r100[r102];     // Catch: Exception -> L18
        if (r103.isEmpty() == true) goto L17;
        int r104 = r103.indexOf("\"");     // Catch: Exception -> L18
        int r105 = r103.indexOf("\"=\"");     // Catch: Exception -> L18
        if (r104 < 0) goto L17;
        if (r105 < 0) goto L17;
        String r106 = r103.substring(r104 + 1, r105);     // Catch: Exception -> L18
        String r107 = r103.substring(r105 + 3);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r106) == true) goto L17;
        if (TextUtils.isEmpty(r107) == true) goto L17;
        f27815b.put(r106, r107);     // Catch: Exception -> L18
    L17:
        r102 = r102 + 1;
        goto L4
    L30:
        return;
    L18:
        e = move-exception;
        t6.a(e, "DynamicStringManager", "loadEnglishLanguageFile error)");
    }

    private static void a() {
        switch(l5.c()) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L26;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L7;
            case 20: goto L6;
            case 21: goto L5;
            default: goto L26;
        };
    L5:
        String r100 = "az";
    L28:
        if (TextUtils.isEmpty(r100) == false) goto L31;
        return;
    L31:
        monitor-enter(p0.class);
    L48:
        th = move-exception;
        throw th;
    L33:
        if (f27816c == false) goto L36;
        monitor-exit(p0.class);     // Catch: Throwable -> L48
        return;
    L36:
        f27814a.clear();     // Catch: Throwable -> L48
        b();     // Catch: Exception -> L44 Throwable -> L48
        if (a(r100) == true) goto L42;
        monitor-exit(p0.class);     // Catch: Throwable -> L48
        return;
    L42:
        f27816c = true;     // Catch: Exception -> L44 Throwable -> L48
    L46:
        monitor-exit(p0.class);     // Catch: Throwable -> L48
        return;
    L44:
        e = move-exception;
        t6.a(e, "DynamicStringManager", "Initialization error)");     // Catch: Throwable -> L48
        goto L46
    L6:
        r100 = "uk";
        goto L28
    L7:
        r100 = SRStrategy.MEDIAINFO_KEY_CACHE_SIZE;
        goto L28
    L8:
        r100 = "pl";
        goto L28
    L9:
        r100 = "vi";
        goto L28
    L10:
        r100 = "id";
        goto L28
    L11:
        r100 = "ms";
        goto L28
    L12:
        r100 = "ru";
        goto L28
    L13:
        r100 = "it";
        goto L28
    L14:
        r100 = "he";
        goto L28
    L15:
        r100 = "tr";
        goto L28
    L16:
        r100 = RTLUtil.ARABIA_LANG;
        goto L28
    L17:
        r100 = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO;
        goto L28
    L18:
        r100 = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA;
        goto L28
    L19:
        r100 = "th";
        goto L28
    L20:
        r100 = "de";
        goto L28
    L21:
        r100 = "fr";
        goto L28
    L22:
        r100 = GXTemplateKey.GAIAX_PT;
        goto L28
    L23:
        r100 = "es";
        goto L28
    L24:
        r100 = "zh-Hant-HK";
        goto L28
    L25:
        r100 = "zh-Hans";
        goto L28
    L26:
        r100 = "en";
        goto L28
    }

    public p0() {
    }

    private static boolean a(String r100) {
        String[] r101 = p3.e(f27817d, "Localizable/strings/" + r100 + "/Localizable_map.strings").split("\";");     // Catch: Exception -> L20
        int r102 = r101.length;     // Catch: Exception -> L20
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L18;
        String r104 = r101[r103];     // Catch: Exception -> L20
        if (r104.isEmpty() == true) goto L17;
        int r105 = r104.indexOf("\"");     // Catch: Exception -> L20
        int r106 = r104.indexOf("\"=\"");     // Catch: Exception -> L20
        if (r105 < 0) goto L17;
        if (r106 < 0) goto L17;
        String r107 = r104.substring(r105 + 1, r106);     // Catch: Exception -> L20
        String r108 = r104.substring(r106 + 3);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r107) == true) goto L17;
        if (TextUtils.isEmpty(r108) == true) goto L17;
        f27814a.put(r107, r108);     // Catch: Exception -> L20
    L17:
        r103 = r103 + 1;
        goto L4
    L18:
        return true;
    L20:
        e = move-exception;
        t6.a(e, "DynamicStringManager", "loadLanguageFile error)");
        return false;
    }

    public static String a(int r100) {
        if (f27817d != null) goto L5;
        return null;
    L5:
        String r101 = b5.a().getString(r100);
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return null;
    L9:
        if (f27816c == true) goto L11;
        a();
    L11:
        String r102 = f27814a.get(r101);
        if (r102 != null) goto L14;
        String r103 = f27815b.get(r101);
        if (TextUtils.isEmpty(r103) == false) goto L22;
        return r103;
    L22:
        if (r103.contains("\\n") == true) goto L24;
        return r103;
    L24:
        return r103.replace("\\n", "\n");
    L14:
        if (TextUtils.isEmpty(r102) == false) goto L16;
        return r102;
    L16:
        if (r102.contains("\\n") == true) goto L18;
        return r102;
    L18:
        return r102.replace("\\n", "\n");
    }

    public static void a(Context r100) {
        f27817d = r100;
        if (f27816c == false) goto L5;
        return;
    L5:
        a();
    }
}
