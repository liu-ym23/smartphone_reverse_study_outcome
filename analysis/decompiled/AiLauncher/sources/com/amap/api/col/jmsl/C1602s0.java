package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1607t1;
import com.amap.api.col.jmsl.E1;
import com.amap.api.col.jmsl.s7;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
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
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1602s0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f16864a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f16865b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Context f16866c = null;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f16867d = true;

    /* renamed from: z, reason: collision with root package name */
    public static volatile boolean f16889z;

    /* renamed from: e, reason: collision with root package name */
    public static Vector<f> f16868e = new Vector<>();

    /* renamed from: f, reason: collision with root package name */
    public static Map<String, Integer> f16869f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static String f16870g = null;

    /* renamed from: h, reason: collision with root package name */
    public static long f16871h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static volatile boolean f16872i = false;

    /* renamed from: j, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, h> f16873j = new ConcurrentHashMap<>(8);

    /* renamed from: k, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, Long> f16874k = new ConcurrentHashMap<>(8);

    /* renamed from: l, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, e> f16875l = new ConcurrentHashMap<>(8);

    /* renamed from: m, reason: collision with root package name */
    public static boolean f16876m = false;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f16877n = false;

    /* renamed from: o, reason: collision with root package name */
    public static int f16878o = s7.DEFAULT_RETRY_TIMEOUT;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f16879p = true;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f16880q = false;

    /* renamed from: r, reason: collision with root package name */
    public static int f16881r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f16882s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f16883t = false;

    /* renamed from: u, reason: collision with root package name */
    public static int f16884u = 3;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f16885v = false;

    /* renamed from: w, reason: collision with root package name */
    public static ConcurrentHashMap<String, Boolean> f16886w = new ConcurrentHashMap<>();

    /* renamed from: x, reason: collision with root package name */
    public static ConcurrentHashMap<String, Boolean> f16887x = new ConcurrentHashMap<>();

    /* renamed from: y, reason: collision with root package name */
    public static ArrayList<E1.a> f16888y = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    public static Queue<E1.c> f16863A = new LinkedList();

    /* renamed from: com.amap.api.col.jmsl.s0$a */
    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f16890d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f16891e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f16892f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f16893g;

        public a(String str, String str2, String str3, String str4) {
            this.f16890d = str;
            this.f16891e = str2;
            this.f16892f = str3;
            this.f16893g = str4;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            e eVar = (e) C1602s0.f16875l.get(this.f16890d);
            if (eVar == null) {
                return;
            }
            b bVar = eVar.f16906c;
            c cVarB = C1602s0.b(C1602s0.f16866c, eVar.f16904a, eVar.f16905b, null, false, "DEF_ID", this.f16891e, this.f16892f, this.f16893g);
            if (bVar != null) {
                bVar.onReceiveAuthConfig(cVarB);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.s0$b */
    public interface b {
        void onReceiveAuthConfig(c cVar);
    }

    /* renamed from: com.amap.api.col.jmsl.s0$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f16894a;

        /* renamed from: b, reason: collision with root package name */
        public long f16895b = 0;

        /* renamed from: c, reason: collision with root package name */
        public JSONObject f16896c;

        /* renamed from: d, reason: collision with root package name */
        public a f16897d;

        /* renamed from: com.amap.api.col.jmsl.s0$c$a */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f16898a;

            /* renamed from: b, reason: collision with root package name */
            public JSONObject f16899b;
        }

        public static /* synthetic */ boolean a(c cVar, boolean z10) {
            return z10;
        }
    }

    /* renamed from: com.amap.api.col.jmsl.s0$d */
    public static class d extends AbstractC1576l1 {

        /* renamed from: A, reason: collision with root package name */
        public String f16900A;

        /* renamed from: B, reason: collision with root package name */
        public String f16901B;

        /* renamed from: y, reason: collision with root package name */
        public String f16902y;

        /* renamed from: z, reason: collision with root package name */
        public Map<String, String> f16903z;

        public d(Context context, C1569j2 c1569j2, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, c1569j2);
            this.f16902y = str;
            this.f16903z = map;
            this.f16900A = str2;
            this.f16901B = str4;
            setHttpProtocol(s7.c.HTTPS);
            setDegradeAbility(s7.a.FIX);
        }

        @Override // com.amap.api.col.jmsl.s7
        public final String getIPDNSName() {
            return !TextUtils.isEmpty(this.f16901B) ? this.f16901B : super.getIPDNSName();
        }

        @Override // com.amap.api.col.jmsl.C1, com.amap.api.col.jmsl.s7
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.jmsl.AbstractC1576l1
        public final String getLogVersion() {
            return "3.0";
        }

        @Override // com.amap.api.col.jmsl.AbstractC1576l1
        public final byte[] getRawDatas() {
            return null;
        }

        @Override // com.amap.api.col.jmsl.AbstractC1576l1, com.amap.api.col.jmsl.s7
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f16901B)) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("host", this.f16901B);
            return map;
        }

        @Override // com.amap.api.col.jmsl.AbstractC1576l1
        public final byte[] getRsaAesRawDatas() {
            String string;
            String strZ = S0.z(this.mContext);
            if (!TextUtils.isEmpty(strZ)) {
                strZ = L1.c(new StringBuilder(strZ).reverse().toString());
            }
            HashMap map = new HashMap();
            map.put("authkey", TextUtils.isEmpty(this.f16902y) ? "" : this.f16902y);
            map.put("plattype", UxipConstants.f30662a);
            map.put("ccver", "1");
            map.put("product", this.mSDKInfo.g());
            map.put("version", this.mSDKInfo.h());
            map.put("output", "json");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            map.put("androidversion", sb2.toString());
            map.put("deviceId", strZ);
            map.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map2 = this.f16903z;
            if (map2 != null && !map2.isEmpty()) {
                map.putAll(this.f16903z);
            }
            map.put("abitype", C1604s2.b(this.mContext));
            map.put("ext", this.mSDKInfo.a());
            if (map.size() == 0) {
                string = null;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    boolean z10 = true;
                    for (Map.Entry entry : map.entrySet()) {
                        if (z10) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append((String) entry.getValue());
                            z10 = false;
                        } else {
                            stringBuffer.append(Const.STR_MART_ADD);
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append((String) entry.getValue());
                        }
                    }
                } catch (Throwable th) {
                    C1611u1.b(th, "ut", "abP");
                }
                string = stringBuffer.toString();
            }
            return C1604s2.t(string);
        }

        @Override // com.amap.api.col.jmsl.AbstractC1576l1, com.amap.api.col.jmsl.s7
        public final String getURL() {
            String str = "http://" + C1532a1.c(this.mContext).a(0) + "/v3/iasdkauth";
            String str2 = this.f16900A;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString();
                }
            } catch (Throwable unused) {
            }
            return str;
        }
    }

    /* renamed from: com.amap.api.col.jmsl.s0$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public C1569j2 f16904a;

        /* renamed from: b, reason: collision with root package name */
        public String f16905b;

        /* renamed from: c, reason: collision with root package name */
        public b f16906c;

        public e() {
        }

        public /* synthetic */ e(byte b10) {
            this();
        }
    }

    /* renamed from: com.amap.api.col.jmsl.s0$f */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f16907a;

        /* renamed from: b, reason: collision with root package name */
        public String f16908b;

        /* renamed from: c, reason: collision with root package name */
        public AtomicInteger f16909c;

        public f(String str, String str2, int i10) {
            this.f16907a = str;
            this.f16908b = str2;
            this.f16909c = new AtomicInteger(i10);
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f16909c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f16908b = str;
        }

        public final String d() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Const.INTENT_KEY_APIKEY, this.f16907a);
                jSONObject.put("f", this.f16908b);
                jSONObject.put(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, this.f16909c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.s0$g */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f16910a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f16911b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f16912c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f16913d = 0;

        /* renamed from: e, reason: collision with root package name */
        public static boolean f16914e = false;

        /* renamed from: f, reason: collision with root package name */
        public static int f16915f;
    }

    /* renamed from: com.amap.api.col.jmsl.s0$h */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f16916a;

        /* renamed from: b, reason: collision with root package name */
        public String f16917b;

        public h(Long l10, String str) {
            this.f16916a = 0L;
            this.f16917b = "";
            this.f16916a = l10.longValue();
            this.f16917b = str;
        }
    }

    public static void A(E1.c cVar) {
        if (cVar != null && f16885v) {
            synchronized (f16863A) {
                f16863A.offer(cVar);
                E1.h("----新增一个 耗时 缓存----");
            }
        }
    }

    public static C1569j2 B(String str) {
        e eVar = f16875l.get(str);
        if (eVar != null) {
            return eVar.f16904a;
        }
        return null;
    }

    public static void C(Context context) {
        if (context == null) {
            return;
        }
        f16867d = C1575l0.j(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_INFO, true);
    }

    public static boolean D() {
        Integer num;
        Context context = f16866c;
        if (context == null) {
            return false;
        }
        String strT = S0.t(context);
        return (TextUtils.isEmpty(strT) || (num = f16869f.get(strT.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static E1.c E() {
        synchronized (f16863A) {
            try {
                E1.c cVarPoll = f16863A.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void F(Context context) {
        f16879p = C1575l0.j(context, "open_common", "a13", true);
        f16882s = C1575l0.j(context, "open_common", "a6", true);
        f16880q = C1575l0.j(context, "open_common", "a7", false);
        f16878o = C1575l0.a(context, "open_common", "a8", s7.DEFAULT_RETRY_TIMEOUT);
        f16881r = C1575l0.a(context, "open_common", "a9", 3);
        f16883t = C1575l0.j(context, "open_common", "a10", false);
        f16884u = C1575l0.a(context, "open_common", "a11", 3);
        f16885v = C1575l0.j(context, "open_common", "a12", false);
    }

    public static synchronized void G(String str) {
        if (f16874k == null) {
            return;
        }
        if (f16874k.containsKey(str)) {
            f16874k.remove(str);
        }
    }

    public static E1.a H() {
        if (f16889z) {
            return null;
        }
        synchronized (f16888y) {
            try {
                if (f16889z) {
                    return null;
                }
                Collections.sort(f16888y);
                if (f16888y.size() <= 0) {
                    return null;
                }
                E1.a aVarA = f16888y.get(0).a();
                f16889z = true;
                return aVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean I(String str) {
        f fVarC;
        try {
            if (!TextUtils.isEmpty(str) && f16883t && f16887x.get(str) == null) {
                Context context = f16866c;
                if (context == null || (fVarC = c(context, x(str, "a15"), "open_common")) == null) {
                    return true;
                }
                if (fVarC.a() < f16884u) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean J() {
        f fVarC;
        Context context = f16866c;
        if (context != null) {
            try {
                String strT = S0.t(context);
                if (TextUtils.isEmpty(f16870g) || TextUtils.isEmpty(strT) || !f16870g.equals(strT) || System.currentTimeMillis() - f16871h >= 60000) {
                    if (!TextUtils.isEmpty(strT)) {
                        f16870g = strT;
                    }
                    f16871h = System.currentTimeMillis();
                    f16869f.clear();
                    if (M1.a.a()) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (it.hasNext()) {
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                                String displayName = networkInterface.getDisplayName();
                                Iterator<InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                                int i10 = 0;
                                while (it2.hasNext()) {
                                    InetAddress address = it2.next().getAddress();
                                    if (address instanceof Inet6Address) {
                                        if (!v((Inet6Address) address)) {
                                            i10 |= 2;
                                        }
                                    } else if (address instanceof Inet4Address) {
                                        Inet4Address inet4Address = (Inet4Address) address;
                                        if (!v(inet4Address) && !inet4Address.getHostAddress().startsWith(C1604s2.m("FMTkyLjE2OC40My4"))) {
                                            i10 |= 1;
                                        }
                                    }
                                }
                                if (i10 != 0) {
                                    if (displayName != null && displayName.startsWith("wlan")) {
                                        f16869f.put("WIFI", Integer.valueOf(i10));
                                    } else if (displayName != null && displayName.startsWith("rmnet")) {
                                        f16869f.put("MOBILE", Integer.valueOf(i10));
                                    }
                                }
                            }
                        }
                    } else {
                        f16869f.put("WIFI", 3);
                        f16869f.put("MOBILE", 3);
                    }
                }
            } catch (Throwable th) {
                C1611u1.b(th, "at", "ipstack");
            }
            if (!D()) {
                return false;
            }
            if (L()) {
                return true;
            }
        }
        return f16867d && (fVarC = c(f16866c, "IPV6_CONFIG_NAME", "open_common")) != null && fVarC.a() < 5;
    }

    public static synchronized boolean K(String str) {
        try {
        } finally {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f16875l == null) {
            return false;
        }
        if (f16874k == null) {
            f16874k = new ConcurrentHashMap<>(8);
        }
        if (f16875l.containsKey(str) && !f16874k.containsKey(str)) {
            f16874k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            return true;
        }
        return false;
    }

    public static boolean L() {
        Integer num;
        Context context = f16866c;
        if (context == null) {
            return false;
        }
        String strT = S0.t(context);
        return (TextUtils.isEmpty(strT) || (num = f16869f.get(strT.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static boolean M(String str) {
        f fVarC;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f16879p && f16886w.get(str) == null) {
                Context context = f16866c;
                if (context == null || (fVarC = c(context, x(str, "a14"), "open_common")) == null) {
                    return true;
                }
                if (fVarC.a() < f16881r) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void N() {
        if (f16872i) {
            return;
        }
        try {
            Context context = f16866c;
            if (context == null) {
                return;
            }
            f16872i = true;
            C1607t1.a.f16962a.b(context);
            f16867d = C1575l0.j(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_INFO, true);
            F(context);
            g.f16910a = C1575l0.j(context, "open_common", "ucf", g.f16910a);
            g.f16911b = C1575l0.j(context, "open_common", "fsv2", g.f16911b);
            g.f16912c = C1575l0.j(context, "open_common", "usc", g.f16912c);
            g.f16913d = C1575l0.a(context, "open_common", "umv", g.f16913d);
            g.f16914e = C1575l0.j(context, "open_common", "ust", g.f16914e);
            g.f16915f = C1575l0.a(context, "open_common", "ustv", g.f16915f);
        } catch (Throwable unused) {
        }
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.amap.api.col.jmsl.C1602s0.c b(android.content.Context r25, com.amap.api.col.jmsl.C1569j2 r26, java.lang.String r27, java.util.Map<java.lang.String, java.lang.String> r28, boolean r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1602s0.b(android.content.Context, com.amap.api.col.jmsl.j2, java.lang.String, java.util.Map, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.jmsl.s0$c");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.amap.api.col.jmsl.C1602s0.f c(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<com.amap.api.col.jmsl.s0> r0 = com.amap.api.col.jmsl.C1602s0.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L29
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L2e
            r1 = r3
        Lc:
            java.util.Vector<com.amap.api.col.jmsl.s0$f> r4 = com.amap.api.col.jmsl.C1602s0.f16868e     // Catch: java.lang.Throwable -> L29
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L29
            if (r1 >= r4) goto L2e
            java.util.Vector<com.amap.api.col.jmsl.s0$f> r4 = com.amap.api.col.jmsl.C1602s0.f16868e     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L29
            com.amap.api.col.jmsl.s0$f r4 = (com.amap.api.col.jmsl.C1602s0.f) r4     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L2b
            java.lang.String r5 = com.amap.api.col.jmsl.C1602s0.f.f(r4)     // Catch: java.lang.Throwable -> L29
            boolean r5 = r7.equals(r5)     // Catch: java.lang.Throwable -> L29
            if (r5 == 0) goto L2b
            goto L2f
        L29:
            r6 = move-exception
            goto L8d
        L2b:
            int r1 = r1 + 1
            goto Lc
        L2e:
            r4 = r2
        L2f:
            if (r4 == 0) goto L33
            monitor-exit(r0)
            return r4
        L33:
            if (r6 != 0) goto L37
            monitor-exit(r0)
            return r2
        L37:
            java.lang.String r1 = ""
            java.lang.String r6 = com.amap.api.col.jmsl.C1575l0.m(r6, r8, r7, r1)     // Catch: java.lang.Throwable -> L29
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L44
            goto L61
        L44:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L61
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L61
            com.amap.api.col.jmsl.s0$f r6 = new com.amap.api.col.jmsl.s0$f     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = "a"
            java.lang.String r1 = r8.optString(r1)     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "f"
            java.lang.String r4 = r8.optString(r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = "h"
            int r8 = r8.optInt(r5)     // Catch: java.lang.Throwable -> L61
            r6.<init>(r1, r4, r8)     // Catch: java.lang.Throwable -> L61
            r2 = r6
        L61:
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = "yyyyMMdd"
            java.lang.String r6 = com.amap.api.col.jmsl.C1604s2.a(r4, r6)     // Catch: java.lang.Throwable -> L29
            if (r2 != 0) goto L72
            com.amap.api.col.jmsl.s0$f r2 = new com.amap.api.col.jmsl.s0$f     // Catch: java.lang.Throwable -> L29
            r2.<init>(r7, r6, r3)     // Catch: java.lang.Throwable -> L29
        L72:
            java.lang.String r7 = com.amap.api.col.jmsl.C1602s0.f.b(r2)     // Catch: java.lang.Throwable -> L29
            boolean r7 = r6.equals(r7)     // Catch: java.lang.Throwable -> L29
            if (r7 != 0) goto L86
            r2.c(r6)     // Catch: java.lang.Throwable -> L29
            java.util.concurrent.atomic.AtomicInteger r6 = com.amap.api.col.jmsl.C1602s0.f.e(r2)     // Catch: java.lang.Throwable -> L29
            r6.set(r3)     // Catch: java.lang.Throwable -> L29
        L86:
            java.util.Vector<com.amap.api.col.jmsl.s0$f> r6 = com.amap.api.col.jmsl.C1602s0.f16868e     // Catch: java.lang.Throwable -> L29
            r6.add(r2)     // Catch: java.lang.Throwable -> L29
            monitor-exit(r0)
            return r2
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1602s0.c(android.content.Context, java.lang.String, java.lang.String):com.amap.api.col.jmsl.s0$f");
    }

    public static String d(String str) {
        e eVar;
        if (!f16875l.containsKey(str) || (eVar = f16875l.get(str)) == null) {
            return null;
        }
        return eVar.f16905b;
    }

    public static void f(Context context) {
        try {
            if (f16876m) {
                return;
            }
            K0.f16146b = C1575l0.j(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_NB, true);
            K0.f16147c = C1575l0.j(context, "open_common", "a5", true);
            f16876m = true;
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, C1569j2 c1569j2, String str) {
        HashMap map = new HashMap();
        map.put("amap_sdk_auth_fail", "1");
        map.put("amap_sdk_auth_fail_type", str);
        map.put("amap_sdk_name", c1569j2.g());
        map.put("amap_sdk_version", c1569j2.d());
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            C1558h c1558h = new C1558h(context, "core", "2.0", "O001");
            c1558h.a(string);
            C1594q.d(c1558h, context);
        } catch (g5 unused) {
        }
    }

    public static synchronized void h(Context context, C1569j2 c1569j2, String str, b bVar) {
        if (context == null || c1569j2 == null) {
            return;
        }
        try {
            if (f16866c == null) {
                f16866c = context.getApplicationContext();
            }
            String strG = c1569j2.g();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            m(c1569j2);
            if (f16875l == null) {
                f16875l = new ConcurrentHashMap<>(8);
            }
            if (f16874k == null) {
                f16874k = new ConcurrentHashMap<>(8);
            }
            if (f16873j == null) {
                f16873j = new ConcurrentHashMap<>(8);
            }
            if (!f16875l.containsKey(strG)) {
                e eVar = new e((byte) 0);
                eVar.f16904a = c1569j2;
                eVar.f16905b = str;
                eVar.f16906c = bVar;
                f16875l.put(strG, eVar);
                long j10 = 0;
                try {
                    j10 = f16866c.getSharedPreferences("open_common", 0).getLong(strG, 0L);
                } catch (Throwable th) {
                    C1541c2.b(th, "csp", "glv");
                }
                f16873j.put(strG, new h(Long.valueOf(j10), C1575l0.m(f16866c, "open_common", strG + "lct-info", "")));
                f(f16866c);
                z(f16866c);
            }
        } catch (Throwable th2) {
            C1611u1.b(th2, "at", "rglc");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x024e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0346 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0309 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(android.content.Context r20, com.amap.api.col.jmsl.C1569j2 r21, java.lang.String r22, com.amap.api.col.jmsl.C1602s0.c r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1602s0.i(android.content.Context, com.amap.api.col.jmsl.j2, java.lang.String, com.amap.api.col.jmsl.s0$c, org.json.JSONObject):void");
    }

    public static void j(Context context, String str) {
        C1567j0.c(context, str);
    }

    public static void k(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f16907a)) {
            return;
        }
        String strD = fVar.d();
        if (TextUtils.isEmpty(strD) || context == null) {
            return;
        }
        SharedPreferences.Editor editorB = C1575l0.b(context, str2);
        editorB.putString(str, strD);
        C1575l0.e(editorB);
    }

    public static void l(E1.c cVar) {
        synchronized (f16888y) {
            boolean z10 = false;
            for (int i10 = 0; i10 < f16888y.size(); i10++) {
                try {
                    E1.a aVar = f16888y.get(i10);
                    if (cVar.f16028c.equals(aVar.f16015a) && cVar.f16029d.equals(aVar.f16018d)) {
                        int i11 = cVar.f16038m;
                        int i12 = aVar.f16019e;
                        if (i11 == i12) {
                            z10 = true;
                            if (i12 == 1) {
                                aVar.f16022h = ((aVar.f16023i.get() * aVar.f16022h) + cVar.f16031f) / (aVar.f16023i.get() + 1);
                            }
                            aVar.f16023i.getAndIncrement();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z10) {
                f16888y.add(new E1.a(cVar));
            }
            E1.h("----新增一个 异常 缓存---");
        }
    }

    public static void m(C1569j2 c1569j2) {
        if (c1569j2 != null) {
            try {
                if (TextUtils.isEmpty(c1569j2.g())) {
                    return;
                }
                String strD = c1569j2.d();
                if (TextUtils.isEmpty(strD)) {
                    strD = c1569j2.h();
                }
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                K0.b(c1569j2.g(), strD);
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, long j10, String str2) {
        try {
            if (f16875l != null && f16875l.containsKey(str)) {
                if (f16873j == null) {
                    f16873j = new ConcurrentHashMap<>(8);
                }
                f16873j.put(str, new h(Long.valueOf(j10), str2));
                Context context = f16866c;
                if (context != null) {
                    SharedPreferences.Editor editorB = C1575l0.b(context, "open_common");
                    C1575l0.g(editorB, str, j10);
                    C1575l0.h(editorB, str + "lct-info", str2);
                    C1575l0.e(editorB);
                }
            }
        } catch (Throwable th) {
            C1611u1.b(th, "at", "ucut");
        }
    }

    public static void o(String str, String str2) {
        f fVarC = c(f16866c, str, str2);
        String strA = C1604s2.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!strA.equals(fVarC.f16908b)) {
            fVarC.c(strA);
            fVarC.f16909c.set(0);
        }
        fVarC.f16909c.incrementAndGet();
        k(f16866c, str, str2, fVarC);
    }

    public static synchronized void p(String str, boolean z10, String str2, String str3, String str4) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (f16874k == null) {
                f16874k = new ConcurrentHashMap<>(8);
            }
            f16874k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            if (f16875l == null) {
                return;
            }
            if (f16875l.containsKey(str)) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z10) {
                    C1615v1.i(true, str);
                }
                V1.h().f(new a(str, str2, str3, str4));
            }
        } catch (Throwable th) {
            C1611u1.b(th, "at", "lca");
        }
    }

    public static void q(String str, boolean z10, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str) || f16866c == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("downLevel", String.valueOf(z10));
        map.put("ant", S0.s(f16866c) == 0 ? "0" : "1");
        if (z12) {
            map.put("type", z10 ? "9" : "8");
        } else {
            map.put("type", z10 ? "6" : UxipConstants.f30661Y);
        }
        map.put("status", z11 ? "0" : "1");
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            C1558h c1558h = new C1558h(f16866c, "core", "2.0", "O002");
            c1558h.a(string);
            C1594q.d(c1558h, f16866c);
        } catch (g5 unused) {
        }
    }

    public static void r(boolean z10, E1.a aVar) {
        if (!f16889z || aVar == null) {
            return;
        }
        synchronized (f16888y) {
            if (z10) {
                try {
                    Iterator<E1.a> it = f16888y.iterator();
                    while (it.hasNext()) {
                        E1.a next = it.next();
                        if (next.f16015a.equals(aVar.f16015a) && next.f16018d.equals(aVar.f16018d) && next.f16019e == aVar.f16019e) {
                            if (next.f16023i == aVar.f16023i) {
                                it.remove();
                                E1.h("----错误上传成功，删除-----");
                            } else {
                                next.f16023i.set(next.f16023i.get() - aVar.f16023i.get());
                                E1.h("----错误上传成功，减小错误次数-----");
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            f16889z = false;
            Iterator<E1.a> it2 = f16888y.iterator();
            E1.h("-----缓存池中已有错误数据-----");
            while (it2.hasNext()) {
                E1.a next2 = it2.next();
                E1.h("----path=" + next2.f16018d + "-counts=" + next2.f16023i + "-code=" + next2.f16019e + "----");
            }
            E1.h("---------------------------------");
        }
    }

    public static void s(boolean z10, String str) {
        try {
            E1.h("--markHostNameFailed---hostname=".concat(String.valueOf(str)));
            if (f16879p || z10) {
                if ((f16883t || !z10) && !TextUtils.isEmpty(str)) {
                    if (z10) {
                        if (f16887x.get(str) != null) {
                            return;
                        }
                        f16887x.put(str, Boolean.TRUE);
                        o(x(str, "a15"), "open_common");
                        return;
                    }
                    if (f16886w.get(str) != null) {
                        return;
                    }
                    f16886w.put(str, Boolean.TRUE);
                    o(x(str, "a14"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean t(String str, long j10) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        h hVarW = w(str);
        long jLongValue = 0;
        if (j10 != (hVarW != null ? hVarW.f16916a : 0L)) {
            if (f16874k != null && f16874k.containsKey(str)) {
                jLongValue = f16874k.get(str).longValue();
            }
            if (SystemClock.elapsedRealtime() - jLongValue > 30000) {
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean u(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return z10;
        }
        String[] strArrSplit = URLDecoder.decode(str).split("/");
        return strArrSplit[strArrSplit.length - 1].charAt(4) % 2 == 1;
    }

    public static boolean v(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    public static synchronized h w(String str) {
        try {
            if (f16873j == null) {
                f16873j = new ConcurrentHashMap<>(8);
            }
        } finally {
            return new h(0L, "");
        }
        if (f16873j.containsKey(str)) {
            return f16873j.get(str);
        }
        return new h(0L, "");
    }

    public static String x(String str, String str2) {
        return str2 + "_" + L1.b(str.getBytes());
    }

    public static void y() {
        try {
            f fVarC = c(f16866c, "IPV6_CONFIG_NAME", "open_common");
            String strA = C1604s2.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!strA.equals(fVarC.f16908b)) {
                fVarC.c(strA);
                fVarC.f16909c.set(0);
            }
            fVarC.f16909c.incrementAndGet();
            k(f16866c, "IPV6_CONFIG_NAME", "open_common", fVarC);
        } catch (Throwable unused) {
        }
    }

    public static void z(Context context) {
        try {
            if (f16877n) {
                return;
            }
            u(C1575l0.m(context, "open_common", "a16", ""), true);
            try {
                context.getSharedPreferences("open_common", 0).getLong("a17", 86400000L);
            } catch (Throwable th) {
                C1541c2.b(th, "csp", "glv");
            }
            f16877n = true;
        } catch (Throwable unused) {
        }
    }
}
