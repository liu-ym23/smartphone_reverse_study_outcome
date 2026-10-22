package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f26481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<String> f26482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f26483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Random f26484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f26485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<de> f26486f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f26488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f26489c;

        private a() {
        }

        public /* synthetic */ a(byte r100) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        cz f26490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f26491b;

        private b() {
        }

        public /* synthetic */ b(byte r100) {
            this();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f26492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f26493b;

        public final int hashCode() {
            Map<String, List<a>> r100 = this.f26492a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            Map<String, String> r103 = this.f26493b;
            if (r103 == null) goto L10;
            r101 = r103.hashCode();
        L10:
            return r102 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        private c() {
            this.f26492a = new HashMap(8);
            this.f26493b = new HashMap(8);
        }

        public /* synthetic */ c(byte r100) {
            this();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (c.class != r100.getClass()) goto L15;
            c r101 = (c) r100;
            if (this.f26492a.equals(r101.f26492a) == false) goto L15;
            if (this.f26493b.equals(r101.f26493b) == false) goto L15;
            return true;
        }
    }

    private static List<de> b() {
        ArrayList r100 = null;
        List<de> r101 = f26486f;     // Catch: Throwable -> L22
        monitor-enter(r101);     // Catch: Throwable -> L22
        List<de> r102 = f26486f;     // Catch: Throwable -> L14
        if (r102 != null) goto L8;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r100;
    L8:
        if (r102.size() <= 0) goto L12;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L14
        r103.addAll(f26486f);     // Catch: Throwable -> L19
        f26486f.clear();     // Catch: Throwable -> L19
        r100 = r103;
        goto L12
    L31:
        Throwable th10 = th;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L19
        throw th10;     // Catch: Throwable -> L18
    L21:
        return r103;
    L19:
        th10 = th;
    L14:
        th = move-exception;
        r103 = r100;
        th10 = th;
    L34:
        return null;
    }

    static {
        f26481a = new ConcurrentHashMap(8);
        f26482b = Collections.synchronizedList(new ArrayList(8));
        f26483c = new ConcurrentHashMap(8);
        f26484d = new Random();
        f26485e = new ConcurrentHashMap(8);
        f26486f = Collections.synchronizedList(new ArrayList(16));
    }

    public static void a() {
        Context r100 = bj.f26201c;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        return;
    L5:
        df.a(b(), r100);     // Catch: Throwable -> L7
        return;
    }

    private static boolean a(a r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f26489c != 1.0d) goto L8;
        return false;
    L8:
        long r101 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r100.f26487a) == false) goto L11;
    L25:
        return false;
    L11:
        if (r100.f26488b <= 0) goto L25;
        long r102 = r101 - bs.a(r100.f26487a, "HH:mm:ss").getTimeInMillis();
        if (r102 <= 0) goto L25;
        if (r102 >= (r100.f26488b * 1000)) goto L25;
        if (r100.f26489c != AudioStats.AUDIO_AMPLITUDE_NONE) goto L20;
        return true;
    L20:
        if (f26484d != null) goto L22;
        f26484d = new Random();
    L22:
        f26484d.setSeed(((long) UUID.randomUUID().hashCode()) + r101);
        if (f26484d.nextDouble() <= r100.f26489c) goto L25;
        return true;
    }

    private static synchronized void a(String r100) {
        monitor-enter(cu.class);
    L10:
        th = move-exception;
        cd.a(th, "hlUtil", "rc");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f26481a.containsKey(r100) == false) goto L7;
        f26481a.remove(r100);     // Catch: Throwable -> L10
    L7:
        SharedPreferences.Editor r101 = ci.b(bj.f26201c, "Yb3Blbl9odHRwX2NvbnRyb2w");     // Catch: Throwable -> L10
        ci.a(r101, r100);     // Catch: Throwable -> L10
        ci.a(r101);     // Catch: Throwable -> L10
        monitor-exit(cu.class);
    }

    private static boolean a(List<a> r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.size() <= 0) goto L14;
        Iterator<a> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        if (a(r101.next()) == false) goto L9;
        return true;
    }

    public static synchronized String a(String r100, String r101) throws bh {
        monitor-enter(cu.class);
        System.currentTimeMillis();     // Catch: Throwable -> L49 bh -> L53
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L47:
        monitor-exit(cu.class);
        return r100;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L47;
        Context r102 = bj.f26201c;     // Catch: Throwable -> L49 bh -> L53
    L23:
        th = move-exception;
        cd.a(th, "hlUtil", "llhl");     // Catch: Throwable -> L49 bh -> L53
    L26:
        if (f26481a != null) goto L28;
    L45:
        monitor-exit(cu.class);
        return r100;
    L28:
        if (f26481a.size() <= 0) goto L45;
        if (f26481a.containsKey(r101) == true) goto L34;
        monitor-exit(cu.class);
        return r100;
    L34:
        c r103 = f26481a.get(r101);     // Catch: Throwable -> L49 bh -> L53
        if (r103 != null) goto L39;
        monitor-exit(cu.class);
        return r100;
    L39:
        if (a(r100, r103, r101) == true) goto L44;
        String r104 = b(r100, r103, r101);     // Catch: Throwable -> L49 bh -> L53
        monitor-exit(cu.class);
        return r104;
    L44:
        throw new bh("服务QPS超限");     // Catch: Throwable -> L49 bh -> L53
    L11:
        if (f26482b != null) goto L13;
        f26482b = Collections.synchronizedList(new ArrayList(8));     // Catch: Throwable -> L23
    L13:
        if (r102 == null) goto L26;
        if (f26482b.contains(r101) == true) goto L26;
        f26482b.add(r101);     // Catch: Throwable -> L23
        String r105 = ci.b(r102, "Yb3Blbl9odHRwX2NvbnRyb2w", r101);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L26;
        a(r101, new JSONObject(r105));     // Catch: Throwable -> L23
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L55
    L49:
        th = move-exception;
        cd.a(th, "hlUtil", "pcr");     // Catch: Throwable -> L55
        return r100;
    }

    private static void b(c r100, JSONObject r101) {
        JSONObject r102 = r101.optJSONObject("domainMap");     // Catch: Throwable -> L13
        if (r102 != null) goto L5;
        return;
    L5:
        JSONArray r103 = r102.names();     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
        return;
    L8:
        HashMap r104 = new HashMap(8);     // Catch: Throwable -> L13
        int r105 = r103.length();     // Catch: Throwable -> L13
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        String r107 = r103.optString(r106);     // Catch: Throwable -> L13
        r104.put(r107, r102.optString(r107));     // Catch: Throwable -> L13
        r106 = r106 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        r100.f26493b = r104;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        cd.a(th, "hlUtil", "pdr");
    }

    private static void a(c r110, JSONObject r111) {
        JSONArray r112 = r111.optJSONArray("block");     // Catch: Throwable -> L30
        if (r112 != null) goto L6;
        return;
    L6:
        HashMap r100 = new HashMap(8);     // Catch: Throwable -> L30
        byte r101 = 0;
        int r102 = 0;
    L8:
        if (r102 >= r112.length()) goto L28;
        JSONObject r103 = r112.optJSONObject(r102);     // Catch: Throwable -> L30
        if (r103 == null) goto L27;
        String r104 = r103.optString("api");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (r104.startsWith(HTTP.URL_DEFAULT) == true) goto L17;
        r104 = HTTP.URL_DEFAULT.concat(r104);     // Catch: Throwable -> L30
    L17:
        if (r104.endsWith(HTTP.URL_DEFAULT) == false) goto L19;
        r104 = r104.substring(0, r104.length() - 1);     // Catch: Throwable -> L30
    L19:
        JSONArray r105 = r103.optJSONArray("periods");     // Catch: Throwable -> L30
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L30
        int r107 = 0;
    L21:
        if (r107 >= r105.length()) goto L26;
        JSONObject r108 = r105.optJSONObject(r107);     // Catch: Throwable -> L30
        if (r108 == null) goto L25;
        a r109 = new a(r101);     // Catch: Throwable -> L30
        r109.f26487a = r108.optString(GearStrategyConsts.EV_SELECT_BEGIN);     // Catch: Throwable -> L30
        r109.f26488b = r108.optInt("duration");     // Catch: Throwable -> L30
        r109.f26489c = r108.optDouble("percent");     // Catch: Throwable -> L30
        r106.add(r109);     // Catch: Throwable -> L30
    L25:
        r107 = r107 + 1;     // Catch: Throwable -> L30
        goto L21
    L26:
        r100.put(r104, r106);     // Catch: Throwable -> L30
    L27:
        r102 = r102 + 1;     // Catch: Throwable -> L30
        goto L8
    L28:
        r110.f26492a = r100;     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        cd.a(th, "hlUtil", "pbr");
    }

    public static void a(URL r110, cz r111) {
        if (f26483c != null) goto L6;
        f26483c = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L6:
        Map<String, List<String>> r100 = r111.f26525b;     // Catch: Throwable -> L29
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.containsKey("nb") == false) goto L32;
        List<String> r101 = r111.f26525b.get("nb");     // Catch: Throwable -> L29
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.size() <= 0) goto L34;
        byte r102 = 0;
        String[] r103 = ((String) ListProtector.get(r101, 0)).split("#");     // Catch: Throwable -> L29
        if (r103.length >= 2) goto L18;
        return;
    L18:
        int r104 = CastIntegerProtector.parseInt(r103[0]);     // Catch: Throwable -> L29
        long r105 = CastIntegerProtector.parseInt(r103[1]);     // Catch: Throwable -> L29
        b r106 = new b(r102);     // Catch: Throwable -> L29
        r106.f26490a = r111;     // Catch: Throwable -> L29
        if (r105 > 0) goto L21;
        r105 = 30;
    L21:
        r106.f26491b = SystemClock.elapsedRealtime() + (r105 * 1000);     // Catch: Throwable -> L29
        if (r104 != 1) goto L25;
        f26483c.put("app", r106);     // Catch: Throwable -> L29
        return;
    L25:
        if (r104 != 2) goto L35;
        if (r110 == null) goto L36;
        f26483c.put(r110.getPath(), r106);     // Catch: Throwable -> L29
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    public static void a(boolean r100, String r101) {
        Context r102 = bj.f26201c;     // Catch: Throwable -> L14
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L14
        r103.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L14
        if (r100 == false) goto L11;
        r103.put("type", cc.f26377g);     // Catch: Throwable -> L14
    L12:
        r103.put("name", r101);     // Catch: Throwable -> L14
        r103.put("version", cc.a(r101));     // Catch: Throwable -> L14
        String r104 = r103.toString();     // Catch: Throwable -> L14
        de r105 = new de(r102, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L14
        r105.a(r104);     // Catch: Throwable -> L14
        df.a(r105, r102);     // Catch: Throwable -> L14
        return;
    L11:
        r103.put("type", cc.f26376f);     // Catch: Throwable -> L14
        goto L12
    L18:
        return;
    }

    public static synchronized void a(br r100, JSONObject r101) {
        monitor-enter(cu.class);
        if (r100 != null) goto L30;
        monitor-exit(cu.class);
        return;
    L30:
        String r102 = r100.b();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == false) goto L11;
        monitor-exit(cu.class);
        return;
    L11:
        if (r101 != null) goto L14;
        a(r102);     // Catch: Throwable -> L21
    L14:
        if (bj.a(r101.optString("able", null), false) == true) goto L18;
        a(r102);     // Catch: Throwable -> L21
        monitor-exit(cu.class);
        return;
    L18:
        ci.a(bj.f26201c, "Yb3Blbl9odHRwX2NvbnRyb2w", r102, r101.toString());     // Catch: Throwable -> L21
        a(r102, r101);     // Catch: Throwable -> L21
        monitor-exit(cu.class);
        return;
    L21:
        th = move-exception;
        cd.a(th, "hlUtil", "par");     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    private static void a(String r100, c r101) {
    L7:
        th = move-exception;
        cd.a(th, "hlUtil", "ucr");
        return;
    L3:
        if (f26481a != null) goto L5;
        f26481a = new ConcurrentHashMap(8);     // Catch: Throwable -> L7
    L5:
        f26481a.put(r100, r101);     // Catch: Throwable -> L7
    }

    private static void a(String r100, JSONObject r101) {
        c r102 = new c(0);     // Catch: Throwable -> L10
        a(r102, r101);     // Catch: Throwable -> L10
        b(r102, r101);     // Catch: Throwable -> L10
        if (r102.f26493b == null) goto L5;
    L8:
        a(r100, r102);     // Catch: Throwable -> L10
        return;
    L5:
        if (r102.f26492a != null) goto L8;
        a(r100);     // Catch: Throwable -> L10
        return;
    }

    public static cz a(String r100, String r110, String r111) {
        if (f26483c != null) goto L7;
        return null;
    L7:
        if (f26483c.containsKey("app") == false) goto L17;
        b r112 = f26483c.get("app");     // Catch: Throwable -> L36
        if (SystemClock.elapsedRealtime() > r112.f26491b) goto L15;
        cz r113 = r112.f26490a;     // Catch: Throwable -> L36
        if (r113 == null) goto L13;
        r113.f26528e = false;     // Catch: Throwable -> L36
    L13:
        a(true, r111, r100, 1);     // Catch: Throwable -> L36
        return r113;
    L15:
        f26483c.remove("app");     // Catch: Throwable -> L36
        goto L35
    L17:
        if (TextUtils.isEmpty(r100) == true) goto L21;
        r110 = r100;
    L21:
        if (TextUtils.isEmpty(r110) == false) goto L23;
        return null;
    L23:
        Uri r114 = UriProtector.parse(r110);     // Catch: Throwable -> L36
        if (r114 == null) goto L35;
        String r115 = r114.getPath();     // Catch: Throwable -> L36
        if (f26483c.containsKey(r115) == false) goto L35;
        b r101 = f26483c.get(r115);     // Catch: Throwable -> L36
        if (SystemClock.elapsedRealtime() > r101.f26491b) goto L34;
        cz r116 = r101.f26490a;     // Catch: Throwable -> L36
        if (r116 == null) goto L32;
        r116.f26528e = false;     // Catch: Throwable -> L36
    L32:
        a(true, r111, r100, 2);     // Catch: Throwable -> L36
        return r116;
    L34:
        f26483c.remove(r115);     // Catch: Throwable -> L36
    L35:
        return null;
    }

    private static void b(String r100, String r101, String r102) {
        Context r103 = bj.f26201c;     // Catch: Throwable -> L27
        if (r103 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (f26485e != null) goto L10;
        f26485e = new ConcurrentHashMap(8);     // Catch: Throwable -> L27
    L10:
        ConcurrentHashMap<String, String> r104 = f26485e;     // Catch: Throwable -> L27
        monitor-enter(r104);     // Catch: Throwable -> L27
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L13:
        if (f26485e.containsKey(r101) == false) goto L16;
        monitor-exit(r104);     // Catch: Throwable -> L23
        return;
    L16:
        f26485e.put(r101, r102);     // Catch: Throwable -> L23
        monitor-exit(r104);     // Catch: Throwable -> L23
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L27
        r105.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L27
        r105.put("type", cc.f26380j);     // Catch: Throwable -> L27
        r105.put("name", r100);     // Catch: Throwable -> L27
        r105.put("version", cc.a(r100));     // Catch: Throwable -> L27
        r105.put("domain", r101 + "#" + r102);     // Catch: Throwable -> L27
        String r106 = r105.toString();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r106) == false) goto L21;
        return;
    L21:
        de r107 = new de(r103, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L27
        r107.a(r106);     // Catch: Throwable -> L27
        df.a(r107, r103);     // Catch: Throwable -> L27
        return;
    }

    private static boolean a(String r100, c r101, String r102) {
        Map<String, List<a>> r103 = r101.f26492a;     // Catch: Throwable -> L24
        if (r103 != null) goto L6;
    L23:
        return false;
    L6:
        if (r103.size() <= 0) goto L23;
        if (r103.containsKey("*") == false) goto L17;
        Iterator<Map.Entry<String, List<a>>> r104 = r103.entrySet().iterator();     // Catch: Throwable -> L24
    L12:
        if (r104.hasNext() == false) goto L26;
        if (a(r104.next().getValue()) == false) goto L12;
        a(false, r102, r100, 1);     // Catch: Throwable -> L24
        return true;
    L26:
        return false;
    L17:
        String r105 = UriProtector.parse(r100).getPath();     // Catch: Throwable -> L24
        if (r103.containsKey(r105) == false) goto L26;
        if (a(r103.get(r105)) == false) goto L26;
        a(false, r102, r100, 2);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        cd.a(th, "hlUtil", "inb");
        goto L26
    }

    private static String b(String r100, c r101, String r102) {
        Map<String, String> r103 = r101.f26493b;     // Catch: Throwable -> L12
        if (r103 != null) goto L5;
    L11:
        return r100;
    L5:
        if (r103.size() <= 0) goto L11;
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L12
        String r105 = r104.getAuthority();     // Catch: Throwable -> L12
        if (r103.containsKey(r105) == false) goto L17;
        String r106 = r103.get(r105);     // Catch: Throwable -> L12
        r100 = r104.buildUpon().authority(r106).toString();     // Catch: Throwable -> L12
        b(r102, r105, r106);     // Catch: Throwable -> L12
        return r100;
    L17:
        return r100;
    L12:
        th = move-exception;
        cd.a(th, "hlUtil", "pdr");
        return r100;
    }

    private static void a(boolean r100, String r101, String r102, int r103) {
        Context r104 = bj.f26201c;     // Catch: Throwable -> L30
        if (r104 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L36;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L30
        r105.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L30
        String r106 = cc.a(r101);     // Catch: Throwable -> L30
        if (r100 == false) goto L12;
        r105.put("type", cc.f26379i);     // Catch: Throwable -> L30
    L13:
        r105.put("name", r101);     // Catch: Throwable -> L30
        r105.put("version", r106);     // Catch: Throwable -> L30
        r105.put("uri", UriProtector.parse(r102).getPath());     // Catch: Throwable -> L30
        r105.put("blockLevel", r103);     // Catch: Throwable -> L30
        String r107 = r105.toString();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r107) == false) goto L16;
        return;
    L16:
        de r108 = new de(r104, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L30
        r108.a(r107);     // Catch: Throwable -> L30
        if (f26486f != null) goto L19;
        f26486f = Collections.synchronizedList(new ArrayList(16));     // Catch: Throwable -> L30
    L19:
        List<de> r109 = f26486f;     // Catch: Throwable -> L30
        monitor-enter(r109);     // Catch: Throwable -> L30
        f26486f.add(r108);     // Catch: Throwable -> L26
        if (f26486f.size() < 15) goto L24;
        a();     // Catch: Throwable -> L26
    L24:
        monitor-exit(r109);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
        goto L37
    L12:
        r105.put("type", cc.f26378h);     // Catch: Throwable -> L30
        goto L13
    L36:
        return;
    }
}
