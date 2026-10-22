package com.bytedance.frameworks.baselib.network.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTCookieConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7989a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f7990b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f7991c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f7992d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f7993e;
    private static volatile boolean f;
    private static volatile boolean g;
    private static volatile boolean h;
    private static volatile boolean i;
    private static final Set<String> j = null;
    private static volatile boolean k;
    private static volatile long l;
    private static volatile long m;
    private static volatile boolean n;
    private static volatile long o;
    private static volatile boolean p;
    private static volatile boolean q;
    private static volatile boolean r;
    private static volatile boolean s;

    static {
        f7992d = new CopyOnWriteArraySet();
        f7993e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        j = new CopyOnWriteArraySet();
        k = false;
        l = 60000;
        m = 3600;
        n = false;
        o = 10;
        p = false;
        q = true;
        r = false;
        s = false;
    }

    public static boolean a() {
        return f7989a;
    }

    public static boolean b() {
        return f7990b;
    }

    public static boolean c() {
        return f7991c;
    }

    public static boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        String r6 = r5.trim();
        int r0 = r6.indexOf(59);
        if (r0 == (-1)) goto L9;
        r6 = r6.substring(0, r0);
    L9:
        Iterator<String> r1 = f7992d.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        if (r6.startsWith(((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")) + "=") == false) goto L11;
        return true;
    L16:
        return false;
    }

    public static boolean d() {
        return !h;
    }

    public static boolean b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (j.contains(r1) == false) goto L7;
        return true;
    }

    public static boolean e() {
        return i;
    }

    public static boolean f() {
        return k;
    }

    public static long g() {
        return l;
    }

    public static long h() {
        return m;
    }

    public static boolean i() {
        if (n == true) goto L5;
    L7:
        return false;
    L5:
        if (r == true) goto L7;
        return true;
    }

    public static long j() {
        return o;
    }

    public static boolean k() {
        return p;
    }

    public static boolean l() {
        return r;
    }

    public static void a(JSONObject r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        m();
        boolean r1 = false;
        if (r9.optInt("cookie_save_v2_enabled", 0) <= 0) goto L7;
        boolean r0 = true;
    L8:
        f7989a = r0;
        if (r9.optInt("cookie_batch", 0) <= 0) goto L11;
        boolean r2 = true;
    L12:
        f7990b = r2;
        if (r9.optInt("enable_flush_cookie_for_region", 0) <= 0) goto L15;
        boolean r3 = true;
    L16:
        f7991c = r3;
        JSONArray r4 = r9.optJSONArray("disable_share_cookie_keys");
        if (r4 == null) goto L29;
        if (r4.length() <= 0) goto L29;
        HashSet r5 = new HashSet();
        int r6 = 0;
    L22:
        if (r6 >= r4.length()) goto L27;
        String r7 = r4.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L26;
        r5.add(r7);
    L26:
        r6 = r6 + 1;
        goto L22
    L27:
        f7992d.addAll(r5);
    L29:
        if (r9.optInt("dispatch_update_cookie_enable", 0) <= 0) goto L31;
        boolean r8 = true;
    L32:
        f7993e = r8;
        if (r9.optInt("pre_url_dispatch_enabled", 0) <= 0) goto L35;
        boolean r10 = true;
    L36:
        f = r10;
        if (r9.optInt("ttnet_dedup_cookie", 0) <= 0) goto L39;
        boolean r11 = true;
    L40:
        g = r11;
        if (r9.optInt("cookie_detail_log_enabled", 0) <= 0) goto L43;
        boolean r12 = true;
    L44:
        h = r12;
        if (r9.optInt("cookie_event_report_enabled", 0) <= 0) goto L47;
        boolean r13 = true;
    L48:
        i = r13;
        JSONArray r14 = r9.optJSONArray("cookie_log_keys");
        if (r14 == null) goto L61;
        if (r14.length() <= 0) goto L61;
        HashSet r15 = new HashSet();
        int r16 = 0;
    L54:
        if (r16 >= r14.length()) goto L59;
        String r17 = r14.optString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L58;
        r15.add(r17);
    L58:
        r16 = r16 + 1;
        goto L54
    L59:
        j.addAll(r15);
    L61:
        if (r9.optInt("cookie_sync_disabled", 0) <= 0) goto L63;
        boolean r18 = true;
    L64:
        k = r18;
        long r19 = 60000;
        long r20 = r9.optLong("cookie_sync_delay_ms", 60000);
        if (r20 <= 0) goto L67;
        r19 = r20;
    L67:
        l = r19;
        long r21 = 3600;
        long r22 = r9.optLong("cookie_sync_retry_s", 3600);
        if (r22 <= 0) goto L70;
        r21 = r22;
    L70:
        m = r21;
        if (r9.optInt("ttnet_cookie_init_v2_enabled", 0) <= 0) goto L73;
        boolean r23 = true;
    L74:
        n = r23;
        long r24 = 10;
        long r25 = r9.optLong("cookie_init_cs_delay_s", 10);
        if (r25 <= 0) goto L77;
        r24 = r25;
    L77:
        o = r24;
        if (r9.optInt("tt_cookie_rel_test_enabled", 0) <= 0) goto L80;
        boolean r26 = true;
    L81:
        p = r26;
        if (r9.optInt("tt_cookie_local_rm_enabled", 1) <= 0) goto L84;
        boolean r27 = true;
    L85:
        q = r27;
        if (r9.optInt("cookie_wrap_disabled", 0) <= 0) goto L88;
        boolean r28 = true;
    L89:
        r = r28;
        if (r9.optInt("cookie_cs_by_state_disabled", 0) <= 0) goto L92;
        r1 = true;
    L92:
        s = r1;
        return;
    L88:
        r28 = false;
        goto L89
    L84:
        r27 = false;
        goto L85
    L80:
        r26 = false;
        goto L81
    L73:
        r23 = false;
        goto L74
    L63:
        r18 = false;
        goto L64
    L47:
        r13 = false;
        goto L48
    L43:
        r12 = false;
        goto L44
    L39:
        r11 = false;
        goto L40
    L35:
        r10 = false;
        goto L36
    L31:
        r8 = false;
        goto L32
    L15:
        r3 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    private static void m() {
        f7989a = false;
        f7990b = false;
        f7991c = false;
        f7992d.clear();
        f7993e = false;
        f = false;
        g = false;
        h = false;
        j.clear();
        i = false;
        k = false;
        l = 60000;
        m = 3600;
        n = false;
        o = 10;
        p = false;
        q = true;
        r = false;
        s = false;
    }
}
