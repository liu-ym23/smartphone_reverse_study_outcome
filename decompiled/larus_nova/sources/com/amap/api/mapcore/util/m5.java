package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.tencent.connect.common.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
public class m5 {
    private static Queue<v7.c> A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f27562a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f27563b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f27564c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f27565d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Vector<e> f27566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Integer> f27567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f27568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f27569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f27570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, g> f27571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f27572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f27573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f27574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f27575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f27576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f27577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f27578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f27579r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f27580s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f27581t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static int f27582u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f27583v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f27584w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f27585x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static ArrayList<v7.a> f27586y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile boolean f27587z;

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f27591e;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            if (((d) m5.a().get(this.f27588b)) != null) goto L5;
            return;
        L5:
            m5.a(m5.f27564c, null, null, null, false, "DEF_ID", this.f27589c, this.f27590d, this.f27591e);
        }

        public a(String r100, String r101, String r102, String r103) {
            this.f27588b = r100;
            this.f27589c = r101;
            this.f27590d = r102;
            this.f27591e = r103;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f27592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f27593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f27594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f27595d;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f27596a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public JSONObject f27597b;

            public a() {
            }
        }

        public static /* synthetic */ boolean a(b r100, boolean r101) {
            return r101;
        }

        public b() {
            this.f27593b = 0;
        }
    }

    public static class c extends s7 {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f27598r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Map<String, String> f27599s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private String f27600t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f27601u;

        @Override // com.amap.api.mapcore.util.s7
        public final String f() {
            return "3.0";
        }

        @Override // com.amap.api.mapcore.util.s7
        public final byte[] i() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.y7
        public final String getIPDNSName() {
            if (TextUtils.isEmpty(this.f27601u) == true) goto L7;
            return this.f27601u;
        L7:
            return super.getIPDNSName();
        }

        @Override // com.amap.api.mapcore.util.y7
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f27601u) == true) goto L6;
            HashMap r100 = new HashMap();
            r100.put("host", this.f27601u);
            return r100;
        L6:
            return null;
        }

        @Override // com.amap.api.mapcore.util.y7
        public final String getURL() {
            String r100 = "http://" + p5.b(this.f27959o).a(0) + "/v3/iasdkauth";
            String r101 = this.f27600t;
            if (TextUtils.isEmpty(r101) == true) goto L10;
            return Uri.parse(r100).buildUpon().encodedAuthority(r101).build().toString();
        L10:
            return r100;
        L11:
            return r100;
        }

        @Override // com.amap.api.mapcore.util.s7
        public final byte[] j() {
            String r100 = o5.o(this.f27959o);
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r100 = t5.c(new StringBuilder(r100).reverse().toString());
        L5:
            HashMap r101 = new HashMap();
            if (TextUtils.isEmpty(this.f27598r) == false) goto L8;
            String r102 = "";
        L9:
            r101.put("authkey", r102);
            r101.put("plattype", "android");
            r101.put("ccver", "1");
            r101.put("product", this.f27960p.d());
            r101.put("version", this.f27960p.e());
            r101.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
            StringBuilder r103 = new StringBuilder();
            r103.append(Build.VERSION.SDK_INT);
            r101.put("androidversion", r103.toString());
            r101.put("deviceId", r100);
            r101.put("manufacture", Build.MANUFACTURER);
            Map<String, String> r104 = this.f27599s;
            if (r104 != null) goto L12;
        L14:
            r101.put("abitype", x5.a(this.f27959o));
            r101.put("ext", this.f27960p.a());
            if (r101.size() != 0) goto L17;
            String r105 = null;
        L31:
            return x5.e(r105);
        L17:
            StringBuffer r106 = new StringBuffer();
            Iterator r107 = r101.entrySet().iterator();     // Catch: Throwable -> L27
            boolean r108 = true;
        L19:
            if (r107.hasNext() == false) goto L29;
            Map.Entry r109 = (Map.Entry) r107.next();     // Catch: Throwable -> L27
            if (r108 == true) goto L24;
            r106.append("&");     // Catch: Throwable -> L27
            r106.append((String) r109.getKey());     // Catch: Throwable -> L27
            r106.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L27
            r106.append((String) r109.getValue());     // Catch: Throwable -> L27
            goto L19
        L24:
            r106.append((String) r109.getKey());     // Catch: Throwable -> L27
            r106.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L27
            r106.append((String) r109.getValue());     // Catch: Throwable -> L27
            r108 = false;
        L29:
            r105 = r106.toString();
        L27:
            th = move-exception;
            p6.a(th, "ut", "abP");
            goto L29
        L12:
            if (r104.isEmpty() == true) goto L14;
            r101.putAll(this.f27599s);
            goto L14
        L8:
            r102 = this.f27598r;
            goto L9
        }

        @Override // com.amap.api.mapcore.util.s5, com.amap.api.mapcore.util.y7
        public final String getIPV6URL() {
            return getURL();
        }

        public c(Context r100, w5 r101, String r102, Map<String, String> r103, String r104, String r105, String r106) {
            super(r100, r101);
            this.f27598r = r102;
            this.f27599s = r103;
            this.f27600t = r104;
            this.f27601u = r106;
            setHttpProtocol(y7.c.f28468b);
            setDegradeAbility(y7.a.f28455d);
        }
    }

    public static class d {
        private d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f27603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AtomicInteger f27604c;

        public final int a() {
            AtomicInteger r100 = this.f27604c;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.get();
        }

        public final String b() {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L10
            r100.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, this.f27602a);     // Catch: Throwable -> L10
            r100.put("f", this.f27603b);     // Catch: Throwable -> L10
            r100.put("h", this.f27604c.get());     // Catch: Throwable -> L10
            return r100.toString();
        L10:
            return "";
        }

        public static /* synthetic */ String a(e r100) {
            return r100.f27603b;
        }

        public static /* synthetic */ AtomicInteger b(e r100) {
            return r100.f27604c;
        }

        public static /* synthetic */ String c(e r100) {
            return r100.f27602a;
        }

        public final void a(String r100) {
            this.f27603b = r100;
        }

        public e(String r100, String r101, int r102) {
            this.f27602a = r100;
            this.f27603b = r101;
            this.f27604c = new AtomicInteger(r102);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f27605a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f27606b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f27607c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f27608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f27609e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f27610f;
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f27611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f27612b;

        public g(Long r100, String r101) {
            this.f27611a = 0;
            this.f27612b = "";
            this.f27611a = r100.longValue();
            this.f27612b = r101;
        }
    }

    static {
        f27566e = new Vector();
        f27567f = new HashMap();
        f27568g = null;
        f27569h = 0;
        f27570i = false;
        f27571j = new ConcurrentHashMap(8);
        f27572k = new ConcurrentHashMap(8);
        f27573l = new ConcurrentHashMap(8);
        f27574m = false;
        f27575n = false;
        f27576o = 5000;
        f27577p = true;
        f27578q = false;
        f27579r = 3;
        f27580s = true;
        f27581t = false;
        f27582u = 3;
        f27583v = false;
        f27584w = new ConcurrentHashMap();
        f27585x = new ConcurrentHashMap();
        f27586y = new ArrayList();
        A = new LinkedList();
    }

    public static void b() {
        e r100 = a(f27564c, "IPV6_CONFIG_NAME", "open_common");     // Catch: Throwable -> L8
        String r101 = x5.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L8
        if (r101.equals(e.a(r100)) == true) goto L6;
        r100.a(r101);     // Catch: Throwable -> L8
        e.b(r100).set(0);     // Catch: Throwable -> L8
    L6:
        e.b(r100).incrementAndGet();     // Catch: Throwable -> L8
        a(f27564c, "IPV6_CONFIG_NAME", "open_common", r100);     // Catch: Throwable -> L8
        return;
    }

    public static boolean c() {
        Context r100 = f27564c;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = o5.i(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        Integer r102 = f27567f.get(r101.toUpperCase());
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static v7.c d() {
        Queue<v7.c> r100 = A;
        monitor-enter(r100);
        v7.c r101 = A.poll();     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public static v7.a e() {
        if (f27587z == false) goto L5;
        return null;
    L5:
        ArrayList<v7.a> r100 = f27586y;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (f27587z == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(f27586y);     // Catch: Throwable -> L18
        if (f27586y.size() <= 0) goto L16;
        v7.a r101 = f27586y.get(0).a();     // Catch: Throwable -> L18
        f27587z = true;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return r101;
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L18
        return null;
    }

    public static boolean f() {
        Context r100 = f27564c;
        if (r100 == null) goto L71;
        String r101 = o5.i(r100);     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(f27568g) == true) goto L14;
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (f27568g.equals(r101) == false) goto L14;
        if ((System.currentTimeMillis() - f27569h) >= 60000) goto L14;
    L53:
        if (c() == true) goto L55;
        return false;
    L55:
        Context r102 = f27564c;
        if (r102 == null) goto L67;
        String r103 = o5.i(r102);
        if (TextUtils.isEmpty(r103) == true) goto L67;
        Integer r104 = f27567f.get(r103.toUpperCase());
        if (r104 == null) goto L67;
        if (r104.intValue() != 2) goto L67;
        boolean r105 = true;
    L68:
        if (r105 == false) goto L71;
        return true;
    L67:
        r105 = false;
    L14:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        f27568g = r101;     // Catch: Throwable -> L50
    L16:
        f27569h = System.currentTimeMillis();     // Catch: Throwable -> L50
        f27567f.clear();     // Catch: Throwable -> L50
        Iterator r106 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L50
    L17:
        if (r106.hasNext() == false) goto L53;
        NetworkInterface r107 = (NetworkInterface) r106.next();     // Catch: Throwable -> L50
        if (r107.getInterfaceAddresses().isEmpty() == true) goto L17;
        String r108 = r107.getDisplayName();     // Catch: Throwable -> L50
        Iterator<InterfaceAddress> r109 = r107.getInterfaceAddresses().iterator();     // Catch: Throwable -> L50
        int r110 = 0;
    L23:
        if (r109.hasNext() == false) goto L36;
        InetAddress r111 = r109.next().getAddress();     // Catch: Throwable -> L50
        if ((r111 instanceof Inet6Address) == true) goto L27;
        if ((r111 instanceof Inet4Address) == false) goto L23;
        Inet4Address r112 = (Inet4Address) r111;     // Catch: Throwable -> L50
        if (a(r112) == true) goto L23;
        if (r112.getHostAddress().startsWith(x5.b("FMTkyLjE2OC40My4")) == true) goto L23;
        r110 = r110 | 1;     // Catch: Throwable -> L50
        goto L23
    L27:
        if (a((Inet6Address) r111) == true) goto L23;
        r110 = r110 | 2;     // Catch: Throwable -> L50
        goto L23
    L36:
        if (r110 == 0) goto L17;
        if (r108 == null) goto L43;
        if (r108.startsWith("wlan") == false) goto L43;
        Map<String, Integer> r113 = f27567f;     // Catch: Throwable -> L50
        r113.put("WIFI", Integer.valueOf(r110));     // Catch: Throwable -> L50
    L43:
        if (r108 == null) goto L17;
        if (r108.startsWith("rmnet") == false) goto L17;
        Map<String, Integer> r114 = f27567f;     // Catch: Throwable -> L50
        r114.put("MOBILE", Integer.valueOf(r110));     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        p6.a(th, INotificationHitPoint.NoticeType.AT, "ipstack");
    L71:
        if (f27565d == true) goto L73;
        return false;
    L73:
        e r115 = a(f27564c, "IPV6_CONFIG_NAME", "open_common");
        if (r115 != null) goto L77;
        return false;
    L77:
        if (r115.a() >= 5) goto L79;
        return true;
    L79:
        return false;
    }

    public static void g() {
        if (f27570i == false) goto L23;
        return;
    L23:
        Context r100 = f27564c;     // Catch: Throwable -> L22
        if (r100 != null) goto L8;
        return;
    L8:
        f27570i = true;     // Catch: Throwable -> L22
        r5.a.f27931a.a(r100);     // Catch: Throwable -> L22
        f27565d = m7.a(r100, "open_common", "a2", true);     // Catch: Throwable -> L22
        a(r100);     // Catch: Throwable -> L22
        f.f27605a = m7.a(r100, "open_common", "ucf", f.f27605a);     // Catch: Throwable -> L22
        f.f27606b = m7.a(r100, "open_common", "fsv2", f.f27606b);     // Catch: Throwable -> L22
        f.f27607c = m7.a(r100, "open_common", "usc", f.f27607c);     // Catch: Throwable -> L22
        f.f27608d = m7.a(r100, "open_common", "umv", f.f27608d);     // Catch: Throwable -> L22
        f.f27609e = m7.a(r100, "open_common", "ust", f.f27609e);     // Catch: Throwable -> L22
        f.f27610f = m7.a(r100, "open_common", "ustv", f.f27610f);     // Catch: Throwable -> L22
        return;
    }

    public static /* synthetic */ ConcurrentHashMap a() {
        return f27573l;
    }

    public static void a(v7.c r100) {
        ArrayList<v7.a> r101 = f27586y;
        monitor-enter(r101);
        int r102 = 0;
        boolean r103 = false;
    L26:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (r102 >= f27586y.size()) goto L18;
        v7.a r104 = f27586y.get(r102);     // Catch: Throwable -> L23
        if (r100.f28229c.equals(r104.f28216a) == false) goto L17;
        if (r100.f28230d.equals(r104.f28219d) == false) goto L17;
        int r105 = r100.f28239m;     // Catch: Throwable -> L23
        int r106 = r104.f28220e;     // Catch: Throwable -> L23
        if (r105 != r106) goto L17;
        r103 = true;
        if (r106 != 1) goto L16;
        r104.f28223h = ((((long) r104.f28224i.get()) * r104.f28223h) + r100.f28232f) / ((long) (r104.f28224i.get() + 1));     // Catch: Throwable -> L23
    L16:
        r104.f28224i.getAndIncrement();     // Catch: Throwable -> L23
    L17:
        r102 = r102 + 1;     // Catch: Throwable -> L23
        goto L26
    L18:
        if (r103 == true) goto L20;
        f27586y.add(new v7.a(r100));     // Catch: Throwable -> L23
    L20:
        v7.a("----新增一个 异常 缓存---");     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
    }

    public static synchronized g b(String r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.amap.api.mapcore.util.m5> r0 = com.amap.api.mapcore.util.m5.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.m5$g> r1 = com.amap.api.mapcore.util.m5.f27571j     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L22
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L22
            com.amap.api.mapcore.util.m5.f27571j = r1     // Catch: java.lang.Throwable -> L22
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.m5$g> r1 = com.amap.api.mapcore.util.m5.f27571j     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.m5$g> r1 = com.amap.api.mapcore.util.m5.f27571j     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L22
            com.amap.api.mapcore.util.m5$g r3 = (com.amap.api.mapcore.util.m5.g) r3     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            com.amap.api.mapcore.util.p6.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L39
        L2a:
            com.amap.api.mapcore.util.m5$g r3 = new com.amap.api.mapcore.util.m5$g     // Catch: java.lang.Throwable -> L39
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = ""
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r0)
            return r3
        L39:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m5.b(java.lang.String):com.amap.api.mapcore.util.m5$g");
    }

    public static w5 c(String r100) {
        d r101 = f27573l.get(r100);
        return null;
    }

    public static synchronized void d(String r100) {
        monitor-enter(m5.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f27572k != null) goto L9;
        monitor-exit(m5.class);
        return;
    L9:
        if (f27572k.containsKey(r100) == false) goto L11;
        f27572k.remove(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(m5.class);
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (f27581t == true) goto L10;
        return false;
    L10:
        if (f27585x.get(r100) != null) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L15;
        return false;
    L15:
        Context r102 = f27564c;     // Catch: Throwable -> L25
        if (r102 != null) goto L18;
        return true;
    L18:
        e r103 = a(r102, b(r100, "a15"), "open_common");     // Catch: Throwable -> L25
        if (r103 != null) goto L21;
        return true;
    L21:
        if (r103.a() >= f27582u) goto L24;
        return true;
    L12:
        r101 = false;
    L24:
        return false;
    }

    public static synchronized boolean f(String r100) {
        monitor-enter(m5.class);
    L24:
        th = move-exception;
        p6.a(th, INotificationHitPoint.NoticeType.AT, "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(m5.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        monitor-exit(m5.class);
        return false;
    L10:
        if (f27573l != null) goto L14;
        monitor-exit(m5.class);
        return false;
    L14:
        if (f27572k != null) goto L17;
        f27572k = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (f27573l.containsKey(r100) == false) goto L26;
        if (f27572k.containsKey(r100) == true) goto L26;
        f27572k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(m5.class);
        return true;
    }

    public static boolean g(String r100) {
    L25:
        return true;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return true;
    L7:
        if (f27577p == true) goto L10;
        return false;
    L10:
        if (f27584w.get(r100) != null) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L15;
        return false;
    L15:
        Context r102 = f27564c;     // Catch: Throwable -> L25
        if (r102 != null) goto L18;
        return true;
    L18:
        e r103 = a(r102, b(r100, "a14"), "open_common");     // Catch: Throwable -> L25
        if (r103 != null) goto L21;
        return true;
    L21:
        if (r103.a() >= f27579r) goto L24;
        return true;
    L24:
        return false;
    L12:
        r101 = false;
        goto L13
    }

    public static void a(Context r100) {
        f27577p = m7.a(r100, "open_common", "a13", true);
        f27580s = m7.a(r100, "open_common", "a6", true);
        f27578q = m7.a(r100, "open_common", "a7", false);
        f27576o = m7.a(r100, "open_common", "a8", 5000);
        f27579r = m7.a(r100, "open_common", "a9", 3);
        f27581t = m7.a(r100, "open_common", "a10", false);
        f27582u = m7.a(r100, "open_common", "a11", 3);
        f27583v = m7.a(r100, "open_common", "a12", false);
    }

    public static void b(v7.c r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f27583v == true) goto L7;
        return;
    L7:
        Queue<v7.c> r101 = A;
        monitor-enter(r101);
        A.offer(r100);     // Catch: Throwable -> L12
        v7.a("----新增一个 耗时 缓存----");     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void a(w5 r100) {
        if (r100 == null) goto L17;
        if (TextUtils.isEmpty(r100.d()) == false) goto L6;
        return;
    L6:
        String r101 = r100.b();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = r100.e();     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        m6.a(r100.d(), r101);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public static long a(List<String> r100) {
        if (r100 == null) goto L15;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r100.size() <= 0) goto L16;
        String r101 = (String) ListProtector.get(r100, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r101) == true) goto L17;
        return CastLongProtector.valueOf(r101).longValue();
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
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

    public static String a(String r100) {
        if (f27573l.containsKey(r100) == false) goto L5;
        d r101 = f27573l.get(r100);
    L5:
        return null;
    }

    public static void a(boolean r100, v7.a r101) {
        if (f27587z == false) goto L32;
        if (r101 == null) goto L48;
        ArrayList<v7.a> r102 = f27586y;
        monitor-enter(r102);
        if (r100 == true) goto L33;
    L22:
        f27587z = false;     // Catch: Throwable -> L29
        Iterator<v7.a> r103 = f27586y.iterator();     // Catch: Throwable -> L29
        v7.a("-----缓存池中已有错误数据-----");     // Catch: Throwable -> L29
    L24:
        if (r103.hasNext() == false) goto L26;
        v7.a r104 = r103.next();     // Catch: Throwable -> L29
        v7.a("----path=" + r104.f28219d + "-counts=" + r104.f28224i + "-code=" + r104.f28220e + "----");     // Catch: Throwable -> L29
        goto L24
    L26:
        v7.a("---------------------------------");     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L33:
        Iterator<v7.a> r105 = f27586y.iterator();     // Catch: Throwable -> L29
    L11:
        if (r105.hasNext() == false) goto L22;
        v7.a r106 = r105.next();     // Catch: Throwable -> L29
        if (r106.f28216a.equals(r101.f28216a) == false) goto L11;
        if (r106.f28219d.equals(r101.f28219d) == false) goto L11;
        if (r106.f28220e != r101.f28220e) goto L11;
        if (r106.f28224i == r101.f28224i) goto L20;
        r106.f28224i.set(r106.f28224i.get() - r101.f28224i.get());     // Catch: Throwable -> L29
        v7.a("----错误上传成功，减小错误次数-----");     // Catch: Throwable -> L29
        goto L11
    L20:
        r105.remove();     // Catch: Throwable -> L29
        v7.a("----错误上传成功，删除-----");     // Catch: Throwable -> L29
        goto L11
    L48:
        return;
    }

    private static String b(String r100, String r101) {
        return r101 + "_" + t5.a(r100.getBytes());
    }

    public static void a(boolean r100, String r101) {
        v7.a("--markHostNameFailed---hostname=".concat(String.valueOf(r101)));     // Catch: Throwable -> L26
        if (f27577p == true) goto L8;
        if (r100 == true) goto L8;
        return;
    L8:
        if (f27581t == true) goto L12;
        if (r100 == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return;
    L15:
        if (r100 == true) goto L22;
        if (f27584w.get(r101) == null) goto L19;
        return;
    L19:
        f27584w.put(r101, Boolean.TRUE);     // Catch: Throwable -> L26
        a(b(r101, "a14"), "open_common");     // Catch: Throwable -> L26
        return;
    L22:
        if (f27585x.get(r101) == null) goto L24;
        return;
    L24:
        f27585x.put(r101, Boolean.TRUE);     // Catch: Throwable -> L26
        a(b(r101, "a15"), "open_common");     // Catch: Throwable -> L26
        return;
    }

    public static synchronized boolean a(String r100, long r101) {
        monitor-enter(m5.class);
        boolean r102 = false;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(m5.class);
        return false;
    L9:
        g r103 = b(r100);     // Catch: Throwable -> L26
        long r104 = 0;
        if (r103 == null) goto L12;
        long r105 = r103.f27611a;     // Catch: Throwable -> L26
    L14:
        if (r101 == r105) goto L24;
        if (f27572k != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r104) <= 30000) goto L24;
        r102 = true;
        goto L24
    L18:
        if (f27572k.containsKey(r100) == false) goto L20;
        r104 = f27572k.get(r100).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r105 = 0;
    L24:
        monitor-exit(m5.class);
        return r102;
    }

    private static void a(String r100, String r101) {
        e r102 = a(f27564c, r100, r101);
        String r103 = x5.a(System.currentTimeMillis(), "yyyyMMdd");
        if (r103.equals(e.a(r102)) == true) goto L5;
        r102.a(r103);
        e.b(r102).set(0);
    L5:
        e.b(r102).incrementAndGet();
        a(f27564c, r100, r101, r102);
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

    public static void a(Context r100, String r101) {
        l5.a(r100, r101);
    }

    private static synchronized e a(Context r100, String r101, String r102) {
        monitor-enter(m5.class);
        e r103 = null;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r104 = 0;
    L8:
        if (r104 >= f27566e.size()) goto L15;
        e r105 = f27566e.get(r104);     // Catch: Throwable -> L36
        if (r105 == null) goto L14;
        if (r101.equals(e.c(r105)) == false) goto L14;
    L16:
        if (r105 == null) goto L19;
        monitor-exit(m5.class);
        return r105;
    L19:
        if (r100 != null) goto L22;
        monitor-exit(m5.class);
        return null;
    L22:
        String r106 = m7.b(r100, r102, r101, "");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r106) == false) goto L42;
    L27:
        String r107 = x5.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L36
        if (r103 != null) goto L31;
        r103 = new e(r101, r107, 0);     // Catch: Throwable -> L36
    L31:
        if (r107.equals(e.a(r103)) == true) goto L33;
        r103.a(r107);     // Catch: Throwable -> L36
        e.b(r103).set(0);     // Catch: Throwable -> L36
    L33:
        f27566e.add(r103);     // Catch: Throwable -> L36
        monitor-exit(m5.class);
        return r103;
    L42:
        JSONObject r108 = new JSONObject(r106);     // Catch: Throwable -> L39
        r103 = new e(r108.optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY), r108.optString("f"), r108.optInt("h"));     // Catch: Throwable -> L39
    L14:
        r104 = r104 + 1;
    L15:
        r105 = null;
    L36:
        th = move-exception;
        throw th;
    }

    private static synchronized void a(String r100, long r101, String r102) {
        monitor-enter(m5.class);
    L19:
        th = move-exception;
        p6.a(th, INotificationHitPoint.NoticeType.AT, "ucut");     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (f27573l != null) goto L7;
    L17:
        monitor-exit(m5.class);
        return;
    L7:
        if (f27573l.containsKey(r100) == false) goto L17;
        if (f27571j != null) goto L12;
        f27571j = new ConcurrentHashMap(8);     // Catch: Throwable -> L19
    L12:
        f27571j.put(r100, new g(Long.valueOf(r101), r102));     // Catch: Throwable -> L19
        Context r103 = f27564c;     // Catch: Throwable -> L19
        if (r103 == null) goto L15;
        SharedPreferences.Editor r104 = m7.a(r103, "open_common");     // Catch: Throwable -> L19
        m7.a(r104, r100, r101);     // Catch: Throwable -> L19
        m7.a(r104, r100 + "lct-info", r102);     // Catch: Throwable -> L19
        m7.a(r104);     // Catch: Throwable -> L19
    L15:
        monitor-exit(m5.class);
    }

    private static void a(Context r100, w5 r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("amap_sdk_auth_fail", "1");
        r103.put("amap_sdk_auth_fail_type", r102);
        r103.put("amap_sdk_name", r101.d());
        r103.put("amap_sdk_version", r101.b());
        String r104 = new JSONObject(r103).toString();
        if (TextUtils.isEmpty(r104) == false) goto L8;
        return;
    L8:
        h8 r105 = new h8(r100, "core", EventConstant.Value.AUTH_VERSION_2, "O001");     // Catch: k5 -> L7
        r105.a(r104);     // Catch: k5 -> L7
        i8.a(r105, r100);     // Catch: k5 -> L7
        return;
    }

    public static void a(String r100, boolean r101, boolean r102, boolean r103) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (f27564c == null) goto L33;
        HashMap r104 = new HashMap();
        r104.put("url", r100);
        r104.put("downLevel", String.valueOf(r101));
        String r105 = "0";
        if (o5.h(f27564c) != 0) goto L10;
        Object r106 = "0";
    L11:
        r104.put("ant", r106);
        if (r103 == false) goto L17;
        if (r101 == false) goto L15;
        String r107 = Constants.VIA_SHARE_TYPE_MINI_PROGRAM;
    L16:
        r104.put("type", r107);
    L21:
        if (r102 == true) goto L24;
        r105 = "1";
    L24:
        r104.put("status", r105);
        String r108 = new JSONObject(r104).toString();
        if (TextUtils.isEmpty(r108) == false) goto L30;
        return;
    L30:
        h8 r109 = new h8(f27564c, "core", EventConstant.Value.AUTH_VERSION_2, "O002");     // Catch: k5 -> L29
        r109.a(r108);     // Catch: k5 -> L29
        i8.a(r109, f27564c);     // Catch: k5 -> L29
        return;
    L34:
        return;
    L15:
        r107 = "8";
        goto L16
    L17:
        if (r101 == false) goto L19;
        String r110 = "6";
    L20:
        r104.put("type", r110);
        goto L21
    L19:
        r110 = "4";
        goto L20
    L10:
        r106 = "1";
        goto L11
    }

    private static void a(Context r100, String r101, String r102, e r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(e.c(r103)) == true) goto L14;
        String r104 = r103.b();
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        SharedPreferences.Editor r105 = m7.a(r100, r102);
        r105.putString(r101, r104);
        m7.a(r105);
        return;
    }

    private static void a(Context r110, w5 r111, String r210, b r211, JSONObject r212) throws JSONException {
        b.a r112 = new b.a();
        r112.f27596a = false;
        r211.f27595d = r112;
        String[] r100 = r210.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L13
        if (r100 == null) goto L16;
        if (r100.length <= 0) goto L16;
        int r113 = r100.length;     // Catch: Throwable -> L13
        int r114 = 0;
    L8:
        if (r114 >= r113) goto L16;
        String r115 = r100[r114];     // Catch: Throwable -> L13
        if (r212.has(r115) == false) goto L12;
        r211.f27594c.putOpt(r115, r212.get(r115));     // Catch: Throwable -> L13
    L12:
        r114 = r114 + 1;
    L16:
        if (x5.a(r212, "16H") == false) goto L22;
        b.a(r211, a(r212.getJSONObject("16H").optString("able"), false));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 16H");
    L22:
        if (x5.a(r212, "11K") == false) goto L30;
        JSONObject r101 = r212.getJSONObject("11K");     // Catch: Throwable -> L27
        r112.f27596a = a(r101.getString("able"), false);     // Catch: Throwable -> L27
        if (r101.has("off") == false) goto L30;
        r112.f27597b = r101.getJSONObject("off");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 11K");
    L30:
        if (x5.a(r212, "145") == false) goto L36;
        r212.getJSONObject("145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 145");
    L36:
        if (x5.a(r212, "14D") == false) goto L42;
        r212.getJSONObject("14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 14D");
    L42:
        if (x5.a(r212, "151") == false) goto L50;
        JSONObject r102 = r212.getJSONObject("151");     // Catch: Throwable -> L47
        if (r102 == null) goto L50;
        a(r102.optString("able"), false);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 151");
    L50:
        if (x5.a(r212, "17S") == true) goto L143;
    L92:
        String r116 = "ust";
        String r117 = "umv";
    L94:
        if (x5.a(r212, "15K") == true) goto L155;
    L119:
        Context r103 = r110;
    L121:
        if (x5.a(r212, "183") == false) goto L127;
        u7.a(r111, r212.getJSONObject("183"));     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 183");
    L127:
        if (x5.a(r212, "17I") == false) goto L133;
        JSONObject r104 = r212.getJSONObject("17I");     // Catch: Throwable -> L130
        boolean r105 = a(r104.optString("na"), false);     // Catch: Throwable -> L130
        boolean r106 = a(r104.optString("aa"), false);     // Catch: Throwable -> L130
        m6.f27614b = r105;     // Catch: Throwable -> L130
        m6.f27615c = r106;     // Catch: Throwable -> L130
        SharedPreferences.Editor r107 = m7.a(r103, "open_common");     // Catch: Throwable -> L130
        m7.a(r107, "a4", r105);     // Catch: Throwable -> L130
        m7.a(r107, "a5", r106);     // Catch: Throwable -> L130
        m7.a(r107);     // Catch: Throwable -> L130
    L130:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 17I");
    L133:
        if (x5.a(r212, "1A4") == false) goto L172;
        JSONObject r108 = r212.getJSONObject("1A4");     // Catch: Throwable -> L138
        String r109 = r108.optString("ada");     // Catch: Throwable -> L138
        a(r109, true);     // Catch: Throwable -> L138
        long r118 = r108.optLong(CJPayFingerprintSharedPrefUtils.KEY_IV, 86400000);     // Catch: Throwable -> L138
        SharedPreferences.Editor r119 = m7.a(r103, "open_common");     // Catch: Throwable -> L138
        m7.a(r119, "a16", r109);     // Catch: Throwable -> L138
        m7.a(r119, "a17", r118);     // Catch: Throwable -> L138
        m7.a(r119);     // Catch: Throwable -> L138
        return;
    L138:
        th = move-exception;
        p6.a(th, "AuthConfigManager", "load 1A4");
        return;
    L172:
        return;
    L155:
        JSONObject r120 = r212.getJSONObject("15K");     // Catch: Throwable -> L117
        if (r120 == null) goto L119;
        boolean r121 = a(r120.optString("ucf"), f.f27605a);     // Catch: Throwable -> L117
        boolean r122 = a(r120.optString("fsv2"), f.f27606b);     // Catch: Throwable -> L117
        boolean r123 = a(r120.optString("usc"), f.f27607c);     // Catch: Throwable -> L117
        String r124 = r117;
        int r125 = r120.optInt(r124, f.f27608d);     // Catch: Throwable -> L117
        String r126 = r116;
        boolean r127 = a(r120.optString(r126), f.f27609e);     // Catch: Throwable -> L117
        int r128 = r120.optInt("ustv", f.f27610f);     // Catch: Throwable -> L117
        if (r121 == f.f27605a) goto L102;
    L110:
        f.f27605a = r121;     // Catch: Throwable -> L117
        f.f27606b = r122;     // Catch: Throwable -> L117
        f.f27607c = r123;     // Catch: Throwable -> L117
        f.f27608d = r125;     // Catch: Throwable -> L117
        f.f27609e = r127;     // Catch: Throwable -> L117
        f.f27610f = r128;     // Catch: Throwable -> L117
        r103 = r110;
        SharedPreferences.Editor r129 = m7.a(r103, "open_common");     // Catch: Throwable -> L116
        m7.a(r129, "ucf", f.f27605a);     // Catch: Throwable -> L116
        m7.a(r129, "fsv2", f.f27606b);     // Catch: Throwable -> L116
        m7.a(r129, "usc", f.f27607c);     // Catch: Throwable -> L116
        m7.a(r129, r124, f.f27608d);     // Catch: Throwable -> L116
        m7.a(r129, r126, f.f27609e);     // Catch: Throwable -> L116
        m7.a(r129, "ustv", f.f27610f);     // Catch: Throwable -> L116
        m7.a(r129);     // Catch: Throwable -> L116
        goto L121
    L102:
        if (r122 != f.f27606b) goto L110;
        if (r123 != f.f27607c) goto L110;
        int r130 = f.f27608d;     // Catch: Throwable -> L117
        if (r125 != r130) goto L110;
        if (r127 != f.f27609e) goto L110;
        if (r128 == r130) goto L119;
    L117:
        th = move-exception;
        r103 = r110;
        p6.a(th, "AuthConfigManager", "load 15K");
        goto L121
    L143:
        JSONObject r131 = r212.getJSONObject("17S");     // Catch: Throwable -> L88
        if (r131 == null) goto L58;
        boolean r132 = a(r131.optString("able"), false);     // Catch: Throwable -> L88
        if (r132 == f27565d) goto L58;
        f27565d = r132;     // Catch: Throwable -> L88
        if (r110 == null) goto L58;
        SharedPreferences.Editor r133 = m7.a(r110, "open_common");     // Catch: Throwable -> L88
        m7.a(r133, "a2", r132);     // Catch: Throwable -> L88
        m7.a(r133);     // Catch: Throwable -> L88
    L58:
        if (r131 == null) goto L92;
        boolean r134 = a(r131.optString("static_enable"), true);     // Catch: Throwable -> L88
        boolean r135 = a(r131.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L88
        int r136 = r131.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L88
        int r137 = r131.optInt("static_retry", 3);     // Catch: Throwable -> L88
        boolean r138 = a(r131.optString("bgp_enable"), true);     // Catch: Throwable -> L88
        r116 = "ust";
        boolean r139 = a(r131.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L86
        r117 = "umv";
        int r140 = r131.optInt("bgp_retry", 3);     // Catch: Throwable -> L84
        boolean r141 = a(r131.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L84
        if (r134 == f27577p) goto L66;
    L79:
        f27577p = r134;     // Catch: Throwable -> L84
        f27578q = r135;     // Catch: Throwable -> L84
        f27576o = r136;     // Catch: Throwable -> L84
        f27579r = r137;     // Catch: Throwable -> L84
        f27580s = r138;     // Catch: Throwable -> L84
        f27581t = r139;     // Catch: Throwable -> L84
        f27582u = r140;     // Catch: Throwable -> L84
        f27583v = r141;     // Catch: Throwable -> L84
        if (r110 == null) goto L82;
        SharedPreferences.Editor r142 = m7.a(r110, "open_common");     // Catch: Throwable -> L84
        m7.a(r142, "a13", r134);     // Catch: Throwable -> L84
        m7.a(r142, "a6", r138);     // Catch: Throwable -> L84
        m7.a(r142, "a7", r135);     // Catch: Throwable -> L84
        m7.a(r142, "a8", r136);     // Catch: Throwable -> L84
        m7.a(r142, "a9", r137);     // Catch: Throwable -> L84
        m7.a(r142, "a10", r139);     // Catch: Throwable -> L84
        m7.a(r142, "a11", r140);     // Catch: Throwable -> L84
        m7.a(r142, "a12", r141);     // Catch: Throwable -> L84
        m7.a(r142);     // Catch: Throwable -> L84
    L82:
        v7.a("static_enable=" + f27577p);     // Catch: Throwable -> L84
        v7.a("bgp_enable=" + f27580s);     // Catch: Throwable -> L84
        v7.a("static_ip_direct_enable=" + f27578q);     // Catch: Throwable -> L84
        v7.a("bgp_ip_direct_enable=" + f27581t);     // Catch: Throwable -> L84
        v7.a("perf_data_upload_enable=" + f27583v);     // Catch: Throwable -> L84
        goto L94
    L66:
        if (r135 != f27578q) goto L79;
        if (r136 != f27576o) goto L79;
        if (r137 != f27579r) goto L79;
        if (r138 != f27580s) goto L79;
        if (r139 != f27581t) goto L79;
        if (r140 != f27582u) goto L79;
        if (r141 == f27583v) goto L82;
    L84:
        th = th;
    L91:
        p6.a(th, "AuthConfigManager", "load 17S");
    L86:
        th = th;
    L90:
        r117 = "umv";
    L88:
        th = th;
        r116 = "ust";
    L13:
        th = move-exception;
        p6.a(th, INotificationHitPoint.NoticeType.AT, "co");
        goto L16
    }

    public static synchronized void a(String r100, boolean r101, String r102, String r103, String r104) {
        monitor-enter(m5.class);
    L29:
        th = move-exception;
        p6.a(th, INotificationHitPoint.NoticeType.AT, "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(m5.class);
        return;
    L9:
        if (f27572k != null) goto L11;
        f27572k = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        f27572k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (f27573l != null) goto L16;
        monitor-exit(m5.class);
        return;
    L16:
        if (f27573l.containsKey(r100) == true) goto L20;
        monitor-exit(m5.class);
        return;
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L23;
        monitor-exit(m5.class);
        return;
    L23:
        if (r101 == true) goto L25;
    L26:
        z8.f().d(new a(r100, r102, r103, r104));     // Catch: Throwable -> L29
        monitor-exit(m5.class);
        return;
    L25:
        u7.a(true, r100);     // Catch: Throwable -> L29
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [com.amap.api.mapcore.util.m5$b] */
    /* JADX WARN: Type inference failed for: r13v16, types: [com.amap.api.mapcore.util.m5$b] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.amap.api.mapcore.util.m5$b] */
    public static b a(Context r210, w5 r211, String r212, Map<String, String> r213, boolean r310, String r311, String r312, String r313, String r314) {
        String r110 = "infocode";
        String r111 = "info";
        ?? r112 = "result";
        b r100 = new b();
        r100.f27594c = new JSONObject();
        if (r210 == null) goto L5;
        f27564c = r210.getApplicationContext();
    L5:
        g();
        String r113 = null;
        a(r211);     // Catch: Throwable -> L92 IllegalBlockSizeException -> L96 k5 -> L100
        r7 r101 = new r7();     // Catch: Throwable -> L92 IllegalBlockSizeException -> L96 k5 -> L100
        boolean r114 = TextUtils.isEmpty(r212);     // Catch: Throwable -> L92 IllegalBlockSizeException -> L96 k5 -> L100
        if (r114 == false) goto L187;
    L15:
        String r115 = r212;
    L160:
        if (f27574m == true) goto L162;
        m6.f27614b = m7.a(r210, "open_common", "a4", true);     // Catch: Throwable -> L153
        m6.f27615c = m7.a(r210, "open_common", "a5", true);     // Catch: Throwable -> L153
        f27574m = true;     // Catch: Throwable -> L153
    L162:
        if (f27575n == true) goto L22;
        a(m7.b(r210, "open_common", "a16", ""), true);     // Catch: Throwable -> L159
        r7 r315 = r101;
        b r214 = r100;
        String r116 = "open_common";
        r210.getSharedPreferences("open_common", 0).getLong("a17", 86400000);     // Catch: Throwable -> L30
    L180:
        f27575n = true;     // Catch: Throwable -> L154
    L191:
        r7 r102 = r315;
        String r215 = "result";
        r112 = r214;
        String r216 = "ver";
        String r217 = r116;
        String r117 = "infocode";
        String r103 = r115;
        r110 = INotificationHitPoint.NoticeType.AT;
        String r218 = "info";
        r111 = "lc";
        String r219 = "";
        String r220 = "status";
        z7 r104 = r102.a(new c(r210, r211, r103, r213, r312, r313, r314));     // Catch: k5 -> L78 Throwable -> L157
        if (r114 == false) goto L185;
        return r112;
    L185:
        byte[] r105 = r104.f28591a;     // Catch: Throwable -> L72 IllegalBlockSizeException -> L74 k5 -> L76
        Map<String, List<String>> r106 = r104.f28592b;     // Catch: Throwable -> L62
        if (r106 != null) goto L46;
    L64:
        byte[] r107 = new byte[16];     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        byte[] r108 = new byte[r105.length - 16];     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        System.arraycopy(r105, 0, r107, 0, 16);     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        System.arraycopy(r105, 16, r108, 0, r105.length - 16);     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        SecretKeySpec r109 = new SecretKeySpec(r107, x5.b("EQUVT"));     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        Cipher r118 = Cipher.getInstance(x5.b("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        r118.init(2, r109, new IvParameterSpec(x5.c()));     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        r113 = x5.c(r118.doFinal(r108));     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        ?? r119 = r112;
    L104:
        String r120 = r115;
        if (r105 != null) goto L108;
        return r119;
    L108:
        if (TextUtils.isEmpty(r113) == false) goto L110;
        r113 = x5.c(r105);
    L110:
        String r121 = r113;
        if (TextUtils.isEmpty(r121) == false) goto L176;
        a(r210, r211, "result is null");
    L176:
        JSONObject r122 = new JSONObject(r121);     // Catch: Throwable -> L150
        String r123 = r220;
        if (r122.has(r123) == false) goto L152;
        int r124 = r122.getInt(r123);     // Catch: Throwable -> L150
        if (r124 != 1) goto L118;
        f27562a = 1;     // Catch: Throwable -> L150
    L135:
        String r125 = r216;
    L140:
        th = move-exception;
        p6.a(th, r110, r111);     // Catch: Throwable -> L150
    L142:
        String r126 = r215;
        if (x5.a(r122, r126) == false) goto L152;
        JSONObject r127 = r122.getJSONObject(r126);     // Catch: Throwable -> L150
        a(r210, r211, r120, r119, r127);     // Catch: Throwable -> L150
        JSONObject r128 = r127.getJSONObject("15K");     // Catch: Throwable -> L156
        boolean r129 = a(r128.optString("isTargetAble"), false);     // Catch: Throwable -> L156
        if (a(r128.optString("able"), false) == true) goto L148;
        r5.a.f27931a.getClass();     // Catch: Throwable -> L156
        SharedPreferences.Editor r130 = m7.a(r210, r217);     // Catch: Throwable -> L156
        m7.a(r130, "a3", true);     // Catch: Throwable -> L156
        m7.a(r130);     // Catch: Throwable -> L156
    L177:
        goto L152
    L148:
        r5.a.f27931a.a(r210, r129);     // Catch: Throwable -> L156
        goto L177
    L137:
        if (r122.has(r125) == false) goto L142;
        r122.getInt(r125);     // Catch: Throwable -> L140
    L118:
        if (r124 != 0) goto L135;
        if (r104 == null) goto L122;
        String r131 = r104.f28593c;     // Catch: Throwable -> L150
        String r132 = r104.f28594d;     // Catch: Throwable -> L150
    L123:
        x5.a(r210, r131, r132, r122);     // Catch: Throwable -> L150
        f27562a = 0;     // Catch: Throwable -> L150
        String r133 = r218;
        if (r122.has(r133) == false) goto L126;
        f27563b = r122.getString(r133);     // Catch: Throwable -> L150
    L126:
        String r134 = r117;
        if (r122.has(r134) == false) goto L131;
        r219 = r122.getString(r134);     // Catch: Throwable -> L150
    L131:
        t6.a(r211, "/v3/iasdkauth", f27563b, r132, r131, r219);     // Catch: Throwable -> L150
        if (f27562a != 0) goto L135;
        r119.f27592a = f27563b;     // Catch: Throwable -> L150
        return r119;
    L122:
        r131 = "authcsid";
        r132 = "authgsid";
    L152:
        return r119;
    L150:
        th = move-exception;
        p6.a(th, r110, r111);
        goto L152
    L70:
        e = e;
    L103:
        r112.f27592a = e.d();
        a(r210, r211, e.d());
        int r135 = t6.f28010i;
        t6.a(r211, "/v3/iasdkauth", e.g(), e.e(), e.b(), e.f());
        r119 = r112;
    L68:
        e = e;
    L99:
        a(r210, r211, e.getMessage());
        r119 = r112;
    L66:
        th = th;
    L95:
        t6.a(th, r110, r111);
        a(r210, r211, th.getMessage());
        r119 = r112;
        goto L104
    L46:
        if (r106.containsKey("lct") == false) goto L64;
        List<String> r136 = r106.get("lct");     // Catch: Throwable -> L62
        List<String> r137 = r106.get("lct-info");     // Catch: Throwable -> L62
        r112.f27593b = a(r136);     // Catch: Throwable -> L62
        if (r137 != null) goto L168;
    L54:
        String r138 = r219;
    L56:
        if (r112.f27593b == 0) goto L64;
        if (r211 == null) goto L64;
        String r139 = r211.d();     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r139) == true) goto L64;
        a(r139, r112.f27593b, r138);     // Catch: Throwable -> L62
        goto L64
    L168:
        if (r137.size() <= 0) goto L54;
        r138 = r137.get(0);     // Catch: Exception -> L155 Throwable -> L62
        if (TextUtils.isEmpty(r138) == true) goto L54;
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        t6.a(th, r110, "lct");     // Catch: Throwable -> L66 IllegalBlockSizeException -> L68 k5 -> L70
        goto L64
    L76:
        e = e;
        r105 = null;
    L74:
        e = e;
        r105 = null;
    L72:
        th = th;
        r105 = null;
        goto L95
    L78:
        e = move-exception;
        throw e;     // Catch: Throwable -> L86 IllegalBlockSizeException -> L88 k5 -> L90
    L83:
        e = move-exception;
        throw e;     // Catch: Throwable -> L86 IllegalBlockSizeException -> L88 k5 -> L90
    L82:
        throw new k5("未知的错误");     // Catch: Throwable -> L86 IllegalBlockSizeException -> L88 k5 -> L90
    L30:
        th = th;
    L166:
        t6.a(th, "csp", "glv");     // Catch: Throwable -> L158
    L32:
        th = th;
        r214 = r100;
        r116 = "open_common";
    L22:
        r315 = r101;
        r214 = r100;
        r116 = "open_common";
        goto L191
    L187:
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L86 IllegalBlockSizeException -> L88 k5 -> L90
    L9:
        if (TextUtils.isEmpty(r212) == true) goto L15;
        r115 = r212 + ";15K;16H;17I;1A4;17S;183";     // Catch: Throwable -> L12 k5 -> L13
        goto L160
    L90:
        e = e;
    L102:
        r104 = null;
        r105 = null;
    L88:
        e = e;
    L98:
        r104 = null;
        r105 = null;
    L86:
        th = th;
    L94:
        r104 = null;
        r105 = null;
        goto L95
    L100:
        e = e;
        r217 = "open_common";
        r219 = "";
        r117 = "infocode";
        r218 = "info";
        r215 = "result";
        r216 = "ver";
        r220 = "status";
        r112 = r100;
        r110 = INotificationHitPoint.NoticeType.AT;
        r111 = "lc";
        r115 = r212;
    L96:
        e = e;
        r217 = "open_common";
        r219 = "";
        r117 = "infocode";
        r218 = "info";
        r215 = "result";
        r216 = "ver";
        r220 = "status";
        r112 = r100;
        r110 = INotificationHitPoint.NoticeType.AT;
        r111 = "lc";
        r115 = r212;
    L92:
        th = th;
        r217 = "open_common";
        r219 = "";
        r117 = "infocode";
        r218 = "info";
        r215 = "result";
        r216 = "ver";
        r220 = "status";
        r112 = r100;
        r110 = INotificationHitPoint.NoticeType.AT;
        r111 = "lc";
        r115 = r212;
        goto L94
    }
}
