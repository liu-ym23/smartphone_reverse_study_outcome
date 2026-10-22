package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d {
    public static int b(String r100) {
        if (hz2.a.f487670b == false) goto L6;
        return 1;
    L6:
        Map<String, Integer> r101 = com.bytedance.android.monitorV2.g.e().d().c();
        if (r101.containsKey(r100) == true) goto L11;
        return -1;
    L11:
        return r101.get(r100).intValue();
    }

    public static boolean d(String r100) {
        if (hz2.a.f487670b == false) goto L7;
        return true;
    L7:
        return com.bytedance.android.monitorV2.g.e().d().d().a(r100).tea_switch;
    }

    public static lz2.b e(String r100) {
        JSONObject r101 = l.r(r100);
        lz2.b r102 = new lz2.b();
        JSONObject r103 = r101.optJSONObject("data");     // Catch: Throwable -> L25
        r102.f511348c = l.j(r103, "update_time");     // Catch: Throwable -> L25
        r102.f511349d = l.g(r103, "duration");     // Catch: Throwable -> L25
        r102.f511350e = l.j(r103, Constant.KEY_SETTING_ID);     // Catch: Throwable -> L25
        long r104 = l.j(r103, "enable_switch");     // Catch: Throwable -> L25
        lz2.d r105 = new lz2.d();     // Catch: Throwable -> L25
        Switches.resetAll(r104);     // Catch: Throwable -> L25
        r102.f511347b = r105;     // Catch: Throwable -> L25
        r102.f511351f = g(l.i(r103, "all_event_sample"));     // Catch: Throwable -> L25
        JSONArray r106 = l.h(r103, DownloadSettingKeys.UrlInterceptConfig.HOST_LIST);     // Catch: Throwable -> L25
        HashSet r107 = new HashSet();     // Catch: Throwable -> L25
        if (r106 != null) goto L30;
    L14:
        r102.f511352g = r107;     // Catch: Throwable -> L25
        JSONObject r108 = l.i(r103, "check_filter");     // Catch: Throwable -> L25
        CheckFilter r109 = new CheckFilter();     // Catch: Throwable -> L25
        JSONObject r110 = l.i(r108, "filter");     // Catch: Throwable -> L21
        HashMap r111 = new HashMap();     // Catch: Throwable -> L21
        Iterator<String> r112 = com.bytedance.android.monitorV2.constant.a.f162994a.iterator();     // Catch: Throwable -> L21
    L17:
        if (r112.hasNext() == false) goto L19;
        String r113 = r112.next();     // Catch: Throwable -> L21
        r111.put(r113, l.b(l.h(r110, r113)));     // Catch: Throwable -> L21
        goto L17
    L19:
        r109 = new CheckFilter(r111, l.b(l.h(r108, "category")), l.l(r108, "id"));     // Catch: Throwable -> L21
    L23:
        r102.f511353h = r109;     // Catch: Throwable -> L25
    L27:
        return r102;
    L21:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L25
        goto L23
    L30:
    L12:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L25
        goto L14
    L6:
        if (r106.length() <= 0) goto L14;
        int r114 = 0;
    L9:
        if (r114 >= r106.length()) goto L14;
        r107.add(r106.optString(r114));     // Catch: Throwable -> L12
        r114 = r114 + 1;
        goto L9
    L25:
        th = move-exception;
        f.a("startup_handle", th);
        goto L27
    }

    public static lz2.b f(String r110) {
        long r100 = System.currentTimeMillis();
        lz2.b r101 = new lz2.b();
        JSONObject r111 = l.r(r110).optJSONObject("data");     // Catch: Throwable -> L26
        JSONObject r102 = l.i(r111, "bid_info");     // Catch: Throwable -> L26
        long r103 = l.j(r111, Constant.KEY_SETTING_ID);     // Catch: Throwable -> L26
        BidInfo r112 = new BidInfo();     // Catch: Throwable -> L26
        if (r102 == null) goto L24;
        Iterator<String> r104 = r102.keys();     // Catch: Throwable -> L26
    L8:
        if (r104.hasNext() == false) goto L23;
        String r105 = r104.next();     // Catch: Throwable -> L21
        JSONObject r113 = l.i(r102, r105);     // Catch: Throwable -> L21
        long r114 = l.j(r113, "hit_sample");     // Catch: Throwable -> L21
        BidInfo.BidConfig r115 = new BidInfo.BidConfig(r105);     // Catch: Throwable -> L21
        r115.hitSample = r114;     // Catch: Throwable -> L21
        r115.settingId = r103;     // Catch: Throwable -> L21
        r115.eventNameSample = g(l.i(r113, "event_name_sample"));     // Catch: Throwable -> L21
        Map<String, BidInfo.BidConfig> r116 = r112.f163078a;     // Catch: Throwable -> L21
        a(r115, r114);     // Catch: Throwable -> L21
        r116.put(r105, r115);     // Catch: Throwable -> L21
        JSONArray r117 = r113.optJSONArray("regex_list");     // Catch: Throwable -> L21
        if (r117 == null) goto L8;
        if (r117.length() <= 0) goto L8;
        int r118 = 0;
    L15:
        if (r118 >= r117.length()) goto L8;
        r112.f163079b.add(new lz2.a(r105, new Regex(r117.optString(r118))));     // Catch: Throwable -> L18
    L20:
        r118 = r118 + 1;
    L18:
        th = move-exception;
        f.a("startup_handle", th);     // Catch: Throwable -> L21
        goto L20
    L21:
        th = move-exception;
        f.a("startup_handle", th);     // Catch: Throwable -> L26
        goto L8
    L23:
        Collections.sort(r112.f163079b);     // Catch: Throwable -> L26
    L24:
        r101.f511346a = r112;     // Catch: Throwable -> L26
        nz2.b.a("HybridMonitor", "monitor setting parse bid cost: " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L26
        HashMap r119 = new HashMap();     // Catch: Throwable -> L26
        r119.put("bid_count", Long.valueOf((long) r101.f511346a.f163078a.size()));     // Catch: Throwable -> L26
        r119.put("regex_count", Long.valueOf(r101.f511346a.f163079b.size()));     // Catch: Throwable -> L26
        r119.put("setting_parse_time", Long.valueOf(System.currentTimeMillis() - r100));     // Catch: Throwable -> L26
        HashMap r106 = new HashMap();     // Catch: Throwable -> L26
        r106.put("setting_parse_type", "json");     // Catch: Throwable -> L26
        Map<String, Map<String, String>> r107 = InternalWatcher.f162982a;     // Catch: Throwable -> L26
        InternalWatcher.a(null, "setting_parse_perf", r106, r119);     // Catch: Throwable -> L26
    L28:
        return r101;
    L26:
        th = move-exception;
        f.a("startup_handle", th);
        goto L28
    }

    public static Map<String, Integer> g(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L13;
        return r101;
    L13:
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L10
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L10
        r101.put(r103, Integer.valueOf(l.g(r100, r103)));     // Catch: Throwable -> L10
    L12:
        return r101;
    L10:
        th = move-exception;
        f.a("startup_handle", th);
        goto L12
    }

    public static void a(BidInfo.BidConfig r100, long r101) {
        int r102 = 0;
    L4:
        if (r102 >= 46) goto L59;
        if (r102 == 0) goto L9;
        r101 = r101 >> 1;
    L9:
        if ((r101 % 2) != 1) goto L58;
        switch(r102) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            case 5: goto L52;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L48;
            case 10: goto L47;
            case 11: goto L46;
            case 12: goto L45;
            case 13: goto L44;
            case 14: goto L43;
            case 15: goto L42;
            case 16: goto L41;
            case 17: goto L40;
            case 18: goto L39;
            case 19: goto L38;
            case 20: goto L37;
            case 21: goto L36;
            case 22: goto L35;
            case 23: goto L34;
            case 24: goto L33;
            case 25: goto L32;
            case 26: goto L31;
            case 27: goto L30;
            case 28: goto L29;
            case 29: goto L28;
            case 30: goto L27;
            case 31: goto L26;
            case 32: goto L25;
            case 33: goto L24;
            case 34: goto L23;
            case 35: goto L22;
            case 36: goto L21;
            case 37: goto L20;
            case 38: goto L19;
            case 39: goto L18;
            case 40: goto L17;
            case 41: goto L16;
            case 42: goto L15;
            case 43: goto L14;
            case 44: goto L13;
            case 45: goto L12;
            default: goto L58;
        };
    L12:
        r100.res_loader_error_template_lynx = true;
        goto L58
    L13:
        r100.res_loader_error_lynx = true;
        goto L58
    L14:
        r100.res_loader_perf_template_lynx = true;
        goto L58
    L15:
        r100.res_loader_perf_lynx = true;
        goto L58
    L16:
        r100.res_loader_error_template_web = true;
        goto L58
    L17:
        r100.res_loader_error_web = true;
        goto L58
    L18:
        r100.res_loader_perf_template_web = true;
        goto L58
    L19:
        r100.res_loader_perf_web = true;
        goto L58
    L20:
        r100.tea_switch = true;
        goto L58
    L21:
        r100.static_error_lynx = true;
        goto L58
    L22:
        r100.js_exception_lynx = true;
        goto L58
    L23:
        r100.container_error = true;
        goto L58
    L24:
        r100.native_error_reactnative = true;
        goto L58
    L25:
        r100.jsb_error_reactnative = true;
        goto L58
    L26:
        r100.fetch_error_reactnative = true;
        goto L58
    L27:
        r100.blank_reactnative = true;
        goto L58
    L28:
        r100.performance_reactnative = true;
        goto L58
    L29:
        r100.navigation_start_lynx = true;
        goto L58
    L30:
        r100.native_error_lynx = true;
        goto L58
    L31:
        r100.jsb_perf_lynx = true;
        goto L58
    L32:
        r100.jsb_error_lynx = true;
        goto L58
    L33:
        r100.fetch_error_lynx = true;
        goto L58
    L34:
        r100.blank_lynx = true;
        goto L58
    L35:
        r100.performance_lynx = true;
        goto L58
    L36:
        r100.static_sri_web = true;
        goto L58
    L37:
        r100.navigation_start_web = true;
        goto L58
    L38:
        r100.native_error_web = true;
        goto L58
    L39:
        r100.falcon_perf_web = true;
        goto L58
    L40:
        r100.jsb_perf_web = true;
        goto L58
    L41:
        r100.jsb_error_web = true;
        goto L58
    L42:
        r100.fetch_error_web = true;
        goto L58
    L43:
        r100.blank_web = true;
        goto L58
    L44:
        r100.js_exception_web = true;
        goto L58
    L45:
        r100.static_error_web = true;
        goto L58
    L46:
        r100.static_perf_web = true;
        goto L58
    L47:
        r100.ajax_web = true;
        goto L58
    L48:
        r100.perf_web = true;
        goto L58
    L49:
        r100.custom_p8 = true;
        goto L58
    L50:
        r100.custom_p7 = true;
        goto L58
    L51:
        r100.custom_p6 = true;
        goto L58
    L52:
        r100.custom_p5 = true;
        goto L58
    L53:
        r100.custom_p4 = true;
        goto L58
    L54:
        r100.custom_p3 = true;
        goto L58
    L55:
        r100.custom_p2 = true;
        goto L58
    L56:
        r100.custom_p1 = true;
        goto L58
    L57:
        r100.custom_p0 = true;
    L58:
        r102 = r102 + 1;
        goto L4
    }

    public static int c(String r100, String r101) {
        if (hz2.a.f487670b == false) goto L6;
        return 1;
    L6:
        Map<String, Integer> r102 = com.bytedance.android.monitorV2.g.e().d().d().a(r100).eventNameSample;
        if (r102.containsKey(r101) == true) goto L11;
        return -1;
    L11:
        return r102.get(r101).intValue();
    }
}
