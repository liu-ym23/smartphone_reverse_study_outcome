package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26199a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f26200b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f26201c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f26202d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f26203e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Vector<e> f26204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, Integer> f26205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f26206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f26207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f26208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f26209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f26210l;

    public interface a {
        void a(b r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f26215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f26216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f26217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f26219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSONObject f26220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public a f26221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0501b f26222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f26223i;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f26224a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f26225b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public JSONObject f26226c;

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.amap.api.col.s.bj$b$b, reason: collision with other inner class name */
        public static class C0501b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f26227a;

            public C0501b() {
            }
        }

        public b() {
            this.f26218d = -1;
            this.f26219e = 0;
        }

        public static /* synthetic */ boolean a(b r100, boolean r101) {
            r100.f26223i = r101;
            return r101;
        }
    }

    public static class c extends ct {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f26228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, String> f26229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f26230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f26231f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f26232j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f26233k;

        @Override // com.amap.api.col.s.ct
        public final String i() {
            return "3.0";
        }

        @Override // com.amap.api.col.s.bp, com.amap.api.col.s.cy
        public final String a_() {
        L12:
            return null;
        L3:
            if (this.f26230e == false) goto L5;
            String r100 = "https://restsdk.amap.com/v3/iasdkauth";
        L17:
            if (TextUtils.isEmpty(this.f26232j) == true) goto L10;
            return r100.replace("restsdk.amap.com", this.f26232j);
        L10:
            Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L12
            return r101.buildUpon().authority("dualstack-" + r101.getAuthority()).build().toString();
        L5:
            r100 = "http://restsdk.amap.com/v3/iasdkauth";
            goto L17
        }

        @Override // com.amap.api.col.s.ct
        public final byte[] d() {
            String r100 = bm.s(this.f26479a);
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r100 = bq.a(new StringBuilder(r100).reverse().toString());
        L5:
            HashMap r101 = new HashMap();
            if (TextUtils.isEmpty(this.f26228c) == false) goto L8;
            String r102 = "";
        L9:
            r101.put("authkey", r102);
            r101.put("plattype", "android");
            r101.put("product", this.f26480b.b());
            r101.put("version", this.f26480b.c());
            r101.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
            StringBuilder r103 = new StringBuilder();
            r103.append(Build.VERSION.SDK_INT);
            r101.put("androidversion", r103.toString());
            r101.put("deviceId", r100);
            r101.put("manufacture", Build.MANUFACTURER);
            Map<String, String> r104 = this.f26229d;
            if (r104 != null) goto L12;
        L14:
            r101.put("abitype", bs.a(this.f26479a));
            r101.put("ext", this.f26480b.e());
            return bs.a(bs.a(r101));
        L12:
            if (r104.isEmpty() == true) goto L14;
            r101.putAll(this.f26229d);
            goto L14
        L8:
            r102 = this.f26228c;
            goto L9
        }

        @Override // com.amap.api.col.s.cy
        public final Map<String, String> f() {
            if (TextUtils.isEmpty(this.f26233k) == true) goto L6;
            HashMap r100 = new HashMap();
            r100.put("host", this.f26233k);
            return r100;
        L6:
            return null;
        }

        @Override // com.amap.api.col.s.cy
        public final String h() {
            if (this.f26230e == false) goto L5;
            String r100 = "https://restsdk.amap.com/v3/iasdkauth";
        L11:
            if (TextUtils.isEmpty(this.f26231f) == true) goto L13;
            return r100.replace("restsdk.amap.com", this.f26231f);
        L13:
            return r100;
        L14:
            return r100;
        L5:
            r100 = "http://restsdk.amap.com/v3/iasdkauth";
            goto L11
        }

        @Override // com.amap.api.col.s.cy
        public final String j() {
            if (TextUtils.isEmpty(this.f26233k) == true) goto L7;
            return this.f26233k;
        L7:
            return super.j();
        }

        public final boolean a() {
            return this.f26230e;
        }

        public c(Context r100, br r101, String r102, String r103, String r104, String r105) {
            super(r100, r101);
            this.f26228c = r102;
            this.f26229d = null;
            this.f26230e = true;
            this.f26231f = r103;
            this.f26232j = r104;
            this.f26233k = r105;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        br f26234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f26235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a f26236c;

        private d() {
        }

        public /* synthetic */ d(byte r100) {
            this();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f26238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AtomicInteger f26239c;

        public final int a() {
            AtomicInteger r100 = this.f26239c;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.get();
        }

        public final String b() {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
            r100.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, this.f26237a);     // Catch: Throwable -> L4
            r100.put("f", this.f26238b);     // Catch: Throwable -> L4
            r100.put("h", this.f26239c.get());     // Catch: Throwable -> L4
            return r100.toString();
        L4:
            return "";
        }

        public static /* synthetic */ String a(e r100) {
            return r100.f26238b;
        }

        public static e b(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L8;
            return null;
        L8:
            JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L7
            return new e(r101.optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY), r101.optString("f"), r101.optInt("h"));
        L7:
            return null;
        }

        public static /* synthetic */ String c(e r100) {
            return r100.f26237a;
        }

        public static /* synthetic */ AtomicInteger b(e r100) {
            return r100.f26239c;
        }

        public final void a(String r100) {
            this.f26238b = r100;
        }

        public e(String r100, String r101, int r102) {
            this.f26237a = r100;
            this.f26238b = r101;
            this.f26239c = new AtomicInteger(r102);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f26240a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f26241b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f26242c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f26243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f26244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f26245f;
    }

    static {
        f26204f = new Vector();
        f26205g = new HashMap();
        f26206h = null;
        f26207i = 0;
        f26202d = false;
        f26208j = new ConcurrentHashMap(8);
        f26209k = new ConcurrentHashMap(8);
        f26210l = new ConcurrentHashMap(8);
    }

    public static boolean a() {
        Context r100 = f26201c;
        if (r100 == null) goto L68;
        if (r100 == null) goto L18;
        String r101 = bm.r(r100);     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(f26206h) == true) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (f26206h.equals(r101) == false) goto L15;
        if ((System.currentTimeMillis() - f26207i) >= 60000) goto L15;
    L52:
        Context r102 = f26201c;
        if (r102 == null) goto L61;
        String r103 = bm.r(r102);
        if (TextUtils.isEmpty(r103) == true) goto L61;
        Integer r104 = f26205g.get(r103.toUpperCase());
        if (r104 == null) goto L61;
        if (r104.intValue() < 2) goto L61;
        boolean r105 = true;
    L62:
        if (r105 == true) goto L65;
        return false;
    L65:
        if (b() == false) goto L68;
        return true;
    L61:
        r105 = false;
    L15:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        f26206h = r101;     // Catch: Throwable -> L50
    L20:
        f26207i = System.currentTimeMillis();     // Catch: Throwable -> L50
        f26205g.clear();     // Catch: Throwable -> L50
        Iterator r106 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L50
    L21:
        if (r106.hasNext() == false) goto L52;
        NetworkInterface r107 = (NetworkInterface) r106.next();     // Catch: Throwable -> L50
        if (r107.getInterfaceAddresses().isEmpty() == true) goto L21;
        String r108 = r107.getDisplayName();     // Catch: Throwable -> L50
        Iterator<InterfaceAddress> r109 = r107.getInterfaceAddresses().iterator();     // Catch: Throwable -> L50
        int r110 = 0;
    L27:
        if (r109.hasNext() == false) goto L40;
        InetAddress r111 = r109.next().getAddress();     // Catch: Throwable -> L50
        if ((r111 instanceof Inet6Address) == true) goto L31;
        if ((r111 instanceof Inet4Address) == false) goto L27;
        Inet4Address r112 = (Inet4Address) r111;     // Catch: Throwable -> L50
        if (a(r112) == true) goto L27;
        if (r112.getHostAddress().startsWith(bs.c("FMTkyLjE2OC40My4")) == true) goto L27;
        r110 = r110 | 1;     // Catch: Throwable -> L50
        goto L27
    L31:
        if (a((Inet6Address) r111) == true) goto L27;
        r110 = r110 | 2;     // Catch: Throwable -> L50
        goto L27
    L40:
        if (r110 == 0) goto L21;
        if (r108 == null) goto L45;
        if (r108.startsWith("wlan") == false) goto L45;
        f26205g.put("WIFI", Integer.valueOf(r110));     // Catch: Throwable -> L50
    L45:
        if (r108 == null) goto L21;
        if (r108.startsWith("rmnet") == false) goto L21;
        f26205g.put("MOBILE", Integer.valueOf(r110));     // Catch: Throwable -> L50
        goto L21
    L18:
        if ((System.currentTimeMillis() - f26207i) >= 10000) goto L20;
    L50:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "ipstack");
    L68:
        if (f26203e == true) goto L70;
        return false;
    L70:
        e r113 = a(f26201c, "IPV6_CONFIG_NAME");
        if (r113 != null) goto L74;
        return false;
    L74:
        if (r113.a() >= 5) goto L76;
        return true;
    L76:
        return false;
    }

    public static boolean b() {
        Context r100 = f26201c;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = bm.r(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        Integer r102 = f26205g.get(r101.toUpperCase());
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void c() {
        if (f26202d == false) goto L12;
        return;
    L12:
        f26202d = true;     // Catch: Throwable -> L11
        Context r100 = f26201c;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        return;
    L9:
        bo.a.f26307a.a(f26201c);     // Catch: Throwable -> L11
        b(f26201c);     // Catch: Throwable -> L11
        f.f26240a = ci.a(r100, "open_common", "ucf", f.f26240a);     // Catch: Throwable -> L11
        f.f26241b = ci.a(r100, "open_common", "fsv2", f.f26241b);     // Catch: Throwable -> L11
        f.f26242c = ci.a(r100, "open_common", "usc", f.f26242c);     // Catch: Throwable -> L11
        f.f26243d = ci.a(r100, "open_common", "umv", f.f26243d);     // Catch: Throwable -> L11
        f.f26244e = ci.a(r100, "open_common", "ust", f.f26244e);     // Catch: Throwable -> L11
        f.f26245f = ci.a(r100, "open_common", "ustv", f.f26245f);     // Catch: Throwable -> L11
        return;
    }

    public static /* synthetic */ ConcurrentHashMap d() {
        return f26210l;
    }

    public static void a(int r100) {
        if (r100 == 2) goto L19;
        return;
    L19:
        e r101 = a(f26201c, "IPV6_CONFIG_NAME");     // Catch: Throwable -> L18
        String r102 = bs.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L18
        if (r102.equals(e.a(r101)) == true) goto L8;
        r101.a(r102);     // Catch: Throwable -> L18
        e.b(r101).set(0);     // Catch: Throwable -> L18
    L8:
        e.b(r101).incrementAndGet();     // Catch: Throwable -> L18
        Context r103 = f26201c;     // Catch: Throwable -> L18
        if (r101 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(e.c(r101)) == true) goto L22;
        String r104 = r101.b();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r104) == true) goto L23;
        if (r103 == null) goto L24;
        new ci("IPV6_CONFIG_NAME").a(r103, RXScreenCaptureService.KEY_INDEX, r104);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public static synchronized void b(String r100) {
        monitor-enter(bj.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f26209k != null) goto L9;
        monitor-exit(bj.class);
        return;
    L9:
        if (f26209k.containsKey(r100) == false) goto L11;
        f26209k.remove(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(bj.class);
    }

    public static synchronized long c(String r100) {
        monitor-enter(bj.class);
    L12:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "glcut");     // Catch: Throwable -> L17
    L14:
        monitor-exit(bj.class);
        return 0;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f26208j != null) goto L8;
        f26208j = new ConcurrentHashMap(8);     // Catch: Throwable -> L12
    L8:
        if (f26208j.containsKey(r100) == false) goto L14;
        long r101 = f26208j.get(r100).longValue();     // Catch: Throwable -> L12
        monitor-exit(bj.class);
        return r101;
    }

    public static synchronized boolean a(String r100) {
        monitor-enter(bj.class);
    L24:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(bj.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        monitor-exit(bj.class);
        return false;
    L10:
        if (f26210l != null) goto L14;
        monitor-exit(bj.class);
        return false;
    L14:
        if (f26209k != null) goto L17;
        f26209k = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (f26210l.containsKey(r100) == false) goto L26;
        if (f26209k.containsKey(r100) == true) goto L26;
        f26209k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(bj.class);
        return true;
    }

    private static void b(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f26203e = ci.a(r100, "open_common", "a2", true);
    }

    private static void a(br r100) {
        if (r100 == null) goto L17;
        if (TextUtils.isEmpty(r100.b()) == false) goto L6;
        return;
    L6:
        String r101 = r100.d();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = r100.c();     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        cc.a(r100.b(), r101);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    private static boolean a(InetAddress r100) {
        if (r100.isLoopbackAddress() == false) goto L5;
        return true;
    L5:
        if (r100.isLinkLocalAddress() == false) goto L7;
        return true;
    L7:
        if (r100.isAnyLocalAddress() == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static void a(Context r100) {
        if (r100 == null) goto L5;
        f26201c = r100.getApplicationContext();
        return;
    }

    private static synchronized e a(Context r100, String r101) {
        monitor-enter(bj.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r102 = 0;
    L8:
        if (r102 >= f26204f.size()) goto L15;
        e r103 = f26204f.get(r102);     // Catch: Throwable -> L31
        if (r103 == null) goto L14;
        if (r101.equals(e.c(r103)) == false) goto L14;
    L16:
        if (r103 == null) goto L19;
        monitor-exit(bj.class);
        return r103;
    L19:
        if (r100 != null) goto L22;
        monitor-exit(bj.class);
        return null;
    L22:
        e r104 = e.b(new ci(r101).a(r100, RXScreenCaptureService.KEY_INDEX));     // Catch: Throwable -> L31
        String r105 = bs.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L31
        if (r104 != null) goto L26;
        r104 = new e("IPV6_CONFIG_NAME", r105, 0);     // Catch: Throwable -> L31
    L26:
        if (r105.equals(e.a(r104)) == true) goto L28;
        r104.a(r105);     // Catch: Throwable -> L31
        e.b(r104).set(0);     // Catch: Throwable -> L31
    L28:
        f26204f.add(r104);     // Catch: Throwable -> L31
        monitor-exit(bj.class);
        return r104;
    L14:
        r102 = r102 + 1;
    L15:
        r103 = null;
        goto L16
    }

    private static synchronized void b(String r100, long r101) {
        monitor-enter(bj.class);
    L19:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "ucut");     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (f26210l != null) goto L7;
    L17:
        monitor-exit(bj.class);
        return;
    L7:
        if (f26210l.containsKey(r100) == false) goto L17;
        if (f26208j != null) goto L12;
        f26208j = new ConcurrentHashMap(8);     // Catch: Throwable -> L19
    L12:
        f26208j.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L19
        Context r102 = f26201c;     // Catch: Throwable -> L19
        if (r102 == null) goto L15;
        SharedPreferences.Editor r103 = ci.b(r102, "open_common");     // Catch: Throwable -> L19
        ci.a(r103, r100, r101);     // Catch: Throwable -> L19
        ci.a(r103);     // Catch: Throwable -> L19
    L15:
        monitor-exit(bj.class);
    }

    public static synchronized boolean a(String r100, long r101) {
        monitor-enter(bj.class);
        boolean r102 = false;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        monitor-exit(bj.class);
        return false;
    L10:
        if (r101 <= c(r100)) goto L21;
        if (f26209k != null) goto L14;
    L16:
        long r103 = 0;
    L17:
        if ((SystemClock.elapsedRealtime() - r103) <= 30000) goto L21;
        r102 = true;
        goto L21
    L14:
        if (f26209k.containsKey(r100) == false) goto L16;
        r103 = f26209k.get(r100).longValue();     // Catch: Throwable -> L23
    L21:
        monitor-exit(bj.class);
        return r102;
    }

    public static synchronized void b(String r100, boolean r101) {
        monitor-enter(bj.class);
        a(r100, r101, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(bj.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean a(String r100, boolean r101) {
    L10:
        return r101;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String[] r102 = URLDecoder.decode(r100).split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L10
        if ((r102[r102.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    private static void a(Context r100, br r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("amap_sdk_auth_fail", "1");
        r103.put("amap_sdk_auth_fail_type", r102);
        r103.put("amap_sdk_name", r101.b());
        r103.put("amap_sdk_version", r101.d());
        String r104 = new JSONObject(r103).toString();
        if (TextUtils.isEmpty(r104) == false) goto L8;
        return;
    L8:
        de r105 = new de(r100, "core", EventConstant.Value.AUTH_VERSION_2, "O001");     // Catch: bh -> L7
        r105.a(r104);     // Catch: bh -> L7
        df.a(r105, r100);     // Catch: bh -> L7
        return;
    }

    private static void a(Context r100, br r101, Throwable r102) {
        a(r100, r101, r102.getMessage());
    }

    public static synchronized void a(Context r100, br r101, String r102, a r103) {
        monitor-enter(bj.class);
        if (r100 == null) goto L35;
        if (r101 == null) goto L35;
    L28:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "rglc");     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L8:
        if (f26201c != null) goto L10;
        f26201c = r100.getApplicationContext();     // Catch: Throwable -> L28
    L10:
        String r104 = r101.b();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r104) == false) goto L14;
        monitor-exit(bj.class);
        return;
    L14:
        a(r101);     // Catch: Throwable -> L28
        if (f26210l != null) goto L18;
        f26210l = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L18:
        if (f26209k != null) goto L21;
        f26209k = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L21:
        if (f26208j != null) goto L24;
        f26208j = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L24:
        if (f26210l.containsKey(r104) == true) goto L26;
        d r105 = new d(0);     // Catch: Throwable -> L28
        r105.f26234a = r101;     // Catch: Throwable -> L28
        r105.f26235b = r102;     // Catch: Throwable -> L28
        r105.f26236c = r103;     // Catch: Throwable -> L28
        f26210l.put(r104, r105);     // Catch: Throwable -> L28
        long r106 = ci.c(f26201c, "open_common", r104);     // Catch: Throwable -> L28
        f26208j.put(r104, Long.valueOf(r106));     // Catch: Throwable -> L28
    L26:
        monitor-exit(bj.class);
        return;
    L35:
        monitor-exit(bj.class);
    }

    private static void a(Context r110, br r111, String r112, b r210, JSONObject r211) throws JSONException {
        b.a r113 = new b.a();
        r113.f26224a = false;
        r113.f26225b = false;
        r210.f26221g = r113;
        String[] r100 = r112.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L15
        if (r100 == null) goto L18;
        if (r100.length <= 0) goto L18;
        int r114 = r100.length;     // Catch: Throwable -> L15
        int r115 = 0;
    L8:
        if (r115 >= r114) goto L18;
        String r116 = r100[r115];     // Catch: Throwable -> L15
        if (r211.has(r116) == false) goto L14;
        r210.f26220f.putOpt(r116, r211.get(r116));     // Catch: Throwable -> L15
    L14:
        r115 = r115 + 1;
        r100 = r100;
    L18:
        if (bs.a(r211, "16H") == false) goto L24;
        b.a(r210, a(JSONObjectProtectorUtils.getJSONObject(r211, "16H").optString("able"), false));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 16H");
    L24:
        if (bs.a(r211, "11K") == false) goto L32;
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r211, "11K");     // Catch: Throwable -> L29
        r113.f26224a = a(JSONObjectProtectorUtils.getString(r101, "able"), false);     // Catch: Throwable -> L29
        if (r101.has("off") == false) goto L32;
        r113.f26226c = JSONObjectProtectorUtils.getJSONObject(r101, "off");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 11K");
    L32:
        if (bs.a(r211, "145") == false) goto L38;
        r210.f26215a = JSONObjectProtectorUtils.getJSONObject(r211, "145");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 145");
    L38:
        if (bs.a(r211, "14D") == false) goto L44;
        r210.f26216b = JSONObjectProtectorUtils.getJSONObject(r211, "14D");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 14D");
    L44:
        if (bs.a(r211, "151") == false) goto L53;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r211, "151");     // Catch: Throwable -> L50
        b.C0501b r117 = new b.C0501b();     // Catch: Throwable -> L50
        if (r102 == null) goto L48;
        r117.f26227a = a(r102.optString("able"), false);     // Catch: Throwable -> L50
    L48:
        r210.f26222h = r117;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 151");
    L53:
        if (bs.a(r211, "17S") == false) goto L65;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r211, "17S");     // Catch: Throwable -> L62
        if (r103 == null) goto L65;
        boolean r104 = a(r103.optString("able"), false);     // Catch: Throwable -> L62
        if (r104 == f26203e) goto L65;
        f26203e = r104;     // Catch: Throwable -> L62
        if (r110 == null) goto L65;
        SharedPreferences.Editor r105 = ci.b(r110, "open_common");     // Catch: Throwable -> L62
        ci.a(r105, "a2", r104);     // Catch: Throwable -> L62
        ci.a(r105);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        cd.a(th, "AuthConfigManager", "load 17S");
    L65:
        if (bs.a(r211, "15K") == true) goto L102;
    L92:
        String r106 = "AuthConfigManager";
    L94:
        if (bs.a(r211, "183") == false) goto L125;
        cu.a(r111, JSONObjectProtectorUtils.getJSONObject(r211, "183"));     // Catch: Throwable -> L97
        return;
    L97:
        th = move-exception;
        cd.a(th, r106, "load 183");
        return;
    L125:
        return;
    L102:
        JSONObject r107 = JSONObjectProtectorUtils.getJSONObject(r211, "15K");     // Catch: Throwable -> L89
        if (r107 == null) goto L92;
        boolean r108 = a(r107.optString("ucf"), f.f26240a);     // Catch: Throwable -> L89
        boolean r118 = a(r107.optString("fsv2"), f.f26241b);     // Catch: Throwable -> L89
        boolean r119 = a(r107.optString("usc"), f.f26242c);     // Catch: Throwable -> L89
        int r120 = r107.optInt("umv", f.f26243d);     // Catch: Throwable -> L89
        boolean r109 = a(r107.optString("ust"), f.f26244e);     // Catch: Throwable -> L89
        int r121 = r107.optInt("ustv", f.f26245f);     // Catch: Throwable -> L89
        if (r108 == f.f26240a) goto L71;
    L81:
        String r122 = "AuthConfigManager";
    L82:
        f.f26240a = r108;     // Catch: Throwable -> L87
        f.f26241b = r118;     // Catch: Throwable -> L87
        f.f26242c = r119;     // Catch: Throwable -> L87
        f.f26243d = r120;     // Catch: Throwable -> L87
        f.f26244e = r109;     // Catch: Throwable -> L87
        f.f26245f = r121;     // Catch: Throwable -> L87
        SharedPreferences.Editor r123 = ci.b(r110, "open_common");     // Catch: Throwable -> L85
        ci.a(r123, "ucf", f.f26240a);     // Catch: Throwable -> L85
        ci.a(r123, "fsv2", f.f26241b);     // Catch: Throwable -> L85
        ci.a(r123, "usc", f.f26242c);     // Catch: Throwable -> L85
        ci.a(r123, "umv", f.f26243d);     // Catch: Throwable -> L85
        ci.a(r123, "ust", f.f26244e);     // Catch: Throwable -> L85
        ci.a(r123, "ustv", f.f26245f);     // Catch: Throwable -> L85
        ci.a(r123);     // Catch: Throwable -> L85
    L86:
        r106 = r122;
    L87:
        th = th;
    L91:
        r106 = r122;
        cd.a(th, r106, "load 15K");
        goto L94
    L71:
        if (r118 != f.f26241b) goto L81;
        if (r119 != f.f26242c) goto L81;
        int r124 = f.f26243d;     // Catch: Throwable -> L89
        if (r120 != r124) goto L81;
        r122 = "AuthConfigManager";
        if (r109 != f.f26244e) goto L82;
        if (r121 == r124) goto L86;
    L89:
        th = th;
        r122 = "AuthConfigManager";
    L15:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "co");
        goto L18
    }

    public static void a(String r100, boolean r101, boolean r102, boolean r103, long r104) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (f26201c == null) goto L28;
        HashMap r105 = new HashMap();
        r105.put("url", r100);
        r105.put("downLevel", String.valueOf(r102));
        String r106 = "0";
        if (bm.p(f26201c) != 0) goto L10;
        Object r107 = "0";
    L11:
        r105.put("ant", r107);
        if (r101 == false) goto L14;
        String r108 = "6";
    L15:
        r105.put("type", r108);
        if (r103 == true) goto L19;
        r106 = "1";
    L19:
        r105.put("status", r106);
        r105.put("duration", String.valueOf(r104));
        String r109 = new JSONObject(r105).toString();
        if (TextUtils.isEmpty(r109) == false) goto L25;
        return;
    L25:
        de r110 = new de(f26201c, "core", EventConstant.Value.AUTH_VERSION_2, "O002");     // Catch: bh -> L24
        r110.a(r109);     // Catch: bh -> L24
        df.a(r110, f26201c);     // Catch: bh -> L24
        return;
    L29:
        return;
    L14:
        r108 = "4";
        goto L15
    L10:
        r107 = "1";
        goto L11
    }

    public static synchronized void a(final String r100, boolean r101, final String r102, final String r103, final String r104) {
        monitor-enter(bj.class);
    L29:
        th = move-exception;
        cd.a(th, INotificationHitPoint.NoticeType.AT, "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(bj.class);
        return;
    L9:
        if (f26209k != null) goto L11;
        f26209k = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        f26209k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (f26210l != null) goto L16;
        monitor-exit(bj.class);
        return;
    L16:
        if (f26210l.containsKey(r100) == true) goto L20;
        monitor-exit(bj.class);
        return;
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L23;
        monitor-exit(bj.class);
        return;
    L23:
        if (r101 == true) goto L25;
    L26:
        cg.c().submit(new AnonymousClass1(r100, r102, r103, r104));     // Catch: Throwable -> L29
        monitor-exit(bj.class);
        return;
    L25:
        cu.a(true, r100);     // Catch: Throwable -> L29
        goto L26
    }

    public static b a(Context r100, br r101, String r102, String r103, String r104, String r105) {
        return b(r100, r101, r102, r103, r104, r105);
    }

    private static b b(Context r210, br r211, String r212, String r213, String r214, String r215) {
        b r100 = new b();
        r100.f26220f = new JSONObject();
        bo.a.f26307a.a(r210);
        b(r210);
        if (r210 == null) goto L5;
        f26201c = r210.getApplicationContext();
    L5:
        String r110 = null;
        a(r211);     // Catch: Throwable -> L83 IllegalBlockSizeException -> L88 bh -> L93
        new cs();     // Catch: Throwable -> L83 IllegalBlockSizeException -> L88 bh -> L93
        boolean r101 = TextUtils.isEmpty(r212);     // Catch: Throwable -> L83 IllegalBlockSizeException -> L88 bh -> L93
        if (r101 == false) goto L165;
        String r111 = r212;
    L161:
        String r112 = "17I";
        b r113 = r100;
        String r102 = r111;
        String r114 = "result";
        String r115 = INotificationHitPoint.NoticeType.AT;
        String r216 = "ver";
        String r116 = "lc";
        String r217 = "infocode";
        c r103 = new c(r210, r211, r102, r213, r214, r215);     // Catch: bh -> L63 Throwable -> L148
        cz r104 = cs.a(r103, r103.a());     // Catch: bh -> L63 Throwable -> L148
        if (r101 == false) goto L26;
        return r113;
    L26:
        if (r104 != null) goto L169;
        byte[] r105 = null;
    L55:
        byte[] r106 = new byte[16];     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        byte[] r107 = new byte[r105.length - 16];     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        System.arraycopy(r105, 0, r106, 0, 16);     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        System.arraycopy(r105, 16, r107, 0, r105.length - 16);     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        SecretKeySpec r108 = new SecretKeySpec(r106, bs.c("EQUVT"));     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        Cipher r109 = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        r109.init(2, r108, new IvParameterSpec(bs.c()));     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        r110 = bs.a(r109.doFinal(r107));     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
    L98:
        String r117 = r111;
        if (r105 != null) goto L102;
        return r113;
    L102:
        if (TextUtils.isEmpty(r110) == false) goto L104;
        r110 = bs.a(r105);
    L104:
        String r118 = r110;
        if (TextUtils.isEmpty(r118) == false) goto L151;
        a(r210, r211, "result is null");
    L151:
        JSONObject r119 = new JSONObject(r118);     // Catch: Throwable -> L144
        if (r119.has("status") == false) goto L146;
        int r120 = JSONObjectProtectorUtils.getInt(r119, "status");     // Catch: Throwable -> L144
        if (r120 != 1) goto L112;
        f26199a = 1;     // Catch: Throwable -> L144
    L127:
        String r121 = r216;
    L132:
        th = move-exception;
        cd.a(th, r115, r116);     // Catch: Throwable -> L144
    L134:
        String r122 = r114;
        if (bs.a(r119, r122) == false) goto L146;
        JSONObject r123 = JSONObjectProtectorUtils.getJSONObject(r119, r122);     // Catch: Throwable -> L144
        a(r210, r211, r117, r113, r123);     // Catch: Throwable -> L144
        String r124 = r112;
        if (bs.a(r123, r124) == false) goto L155;
        JSONObject r125 = JSONObjectProtectorUtils.getJSONObject(r123, r124);     // Catch: Throwable -> L144
        boolean r126 = a(r125.optString("na"), false);     // Catch: Throwable -> L144
        boolean r127 = a(r125.optString("aa"), false);     // Catch: Throwable -> L144
        cc.f26374d = r126;     // Catch: Throwable -> L144
        cc.f26375e = r127;     // Catch: Throwable -> L144
    L155:
        JSONObject r128 = JSONObjectProtectorUtils.getJSONObject(r123, "15K");     // Catch: Throwable -> L147
        boolean r129 = a(r128.optString("isTargetAble"), false);     // Catch: Throwable -> L147
        if (a(r128.optString("able"), false) == true) goto L142;
        bo r130 = bo.a.f26307a;     // Catch: Throwable -> L147
        bo.b(r210);     // Catch: Throwable -> L147
    L154:
        goto L146
    L142:
        bo.a.f26307a.a(r210, r129);     // Catch: Throwable -> L147
        goto L154
    L129:
        if (r119.has(r121) == false) goto L134;
        r113.f26218d = JSONObjectProtectorUtils.getInt(r119, r121);     // Catch: Throwable -> L132
    L112:
        if (r120 != 0) goto L127;
        if (r104 == null) goto L116;
        String r131 = r104.f26526c;     // Catch: Throwable -> L144
        String r132 = r104.f26527d;     // Catch: Throwable -> L144
    L117:
        bs.a(r210, r131, r132, r119);     // Catch: Throwable -> L144
        f26199a = 0;     // Catch: Throwable -> L144
        if (r119.has("info") == false) goto L120;
        f26200b = JSONObjectProtectorUtils.getString(r119, "info");     // Catch: Throwable -> L144
    L120:
        String r133 = "";
        String r134 = r217;
        if (r119.has(r134) == false) goto L123;
        r133 = JSONObjectProtectorUtils.getString(r119, r134);     // Catch: Throwable -> L144
    L123:
        cg.a(r211, "/v3/iasdkauth", f26200b, r132, r131, r133);     // Catch: Throwable -> L144
        if (f26199a != 0) goto L127;
        r113.f26217c = f26200b;     // Catch: Throwable -> L144
        return r113;
    L116:
        r131 = "authcsid";
        r132 = "authgsid";
    L146:
        return r113;
    L144:
        th = move-exception;
        cd.a(th, r115, r116);
        goto L146
    L61:
        e = e;
    L97:
        r113.f26217c = e.a();
        a(r210, r211, e.a());
        cg.a(r211, "/v3/iasdkauth", e);
    L59:
        e = e;
    L92:
        a(r210, r211, e);
    L57:
        th = th;
    L87:
        cg.c(th, r115, r116);
        a(r210, r211, th);
        goto L98
    L169:
        r105 = r104.f26524a;     // Catch: Throwable -> L48 IllegalBlockSizeException -> L50 bh -> L52
        Map<String, List<String>> r135 = r104.f26525b;     // Catch: Throwable -> L46
        if (r135 == null) goto L55;
        if (r135.containsKey("lct") == false) goto L55;
        List<String> r136 = r135.get("lct");     // Catch: Throwable -> L46
        if (r136 == null) goto L55;
        if (r136.size() <= 0) goto L55;
        String r137 = (String) ListProtector.get(r136, 0);     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r137) == true) goto L55;
        long r138 = CastLongProtector.valueOf(r137).longValue();     // Catch: Throwable -> L46
        r113.f26219e = r138;     // Catch: Throwable -> L46
        if (r211 == null) goto L55;
        if (r138 == 0) goto L55;
        String r139 = r211.b();     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r139) == true) goto L55;
        b(r139, r113.f26219e);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        cg.c(th, r115, "lct");     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 bh -> L61
        goto L55
    L52:
        e = e;
        r105 = null;
    L50:
        e = e;
        r105 = null;
    L48:
        th = th;
        r105 = null;
        goto L87
    L63:
        e = e;
    L75:
        String r140 = r111;
    L171:
        throw e;     // Catch: Throwable -> L77 IllegalBlockSizeException -> L79 bh -> L81
    L81:
        e = e;
    L95:
        r111 = r140;
    L96:
        r104 = null;
        r105 = null;
    L79:
        e = e;
    L90:
        r111 = r140;
    L91:
        r104 = null;
        r105 = null;
    L77:
        th = th;
    L85:
        r111 = r140;
    L86:
        r104 = null;
        r105 = null;
    L175:
    L71:
        e = e;
    L69:
        e = e;
    L67:
        th = th;
        goto L86
    L66:
        throw new bh("未知的错误");     // Catch: Throwable -> L67 IllegalBlockSizeException -> L69 bh -> L71
    L73:
        e = e;
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
    L16:
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
        goto L175
    L165:
        StringBuilder r141 = new StringBuilder();     // Catch: Throwable -> L14 bh -> L17
        r140 = r212;
        r141.append(r140);     // Catch: bh -> L12 Throwable -> L150
        r141.append(";15K;16H;17I;17S;183");     // Catch: bh -> L12 Throwable -> L150
        r111 = r141.toString();     // Catch: bh -> L12 Throwable -> L150
        goto L161
    L12:
        e = e;
    L19:
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
    L15:
        r111 = r140;
        goto L16
    L17:
        e = e;
        r140 = r212;
    L14:
        r140 = r212;
        goto L15
    L93:
        e = e;
        r140 = r212;
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
    L88:
        e = e;
        r140 = r212;
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
    L83:
        th = th;
        r140 = r212;
        r112 = "17I";
        r217 = "infocode";
        r114 = "result";
        r216 = "ver";
        r113 = r100;
        r115 = INotificationHitPoint.NoticeType.AT;
        r116 = "lc";
        goto L85
    }
}
