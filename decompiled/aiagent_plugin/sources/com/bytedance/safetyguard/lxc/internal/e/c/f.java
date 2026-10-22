package com.bytedance.safetyguard.lxc.internal.e.c;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.l;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.n.j;
import d.n.m;
import d.o.i;
import d.o.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f10732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f10733b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final k f10734c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f10735d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final k f10736e = null;
    private static final k f = null;
    private static final k g = null;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")).length()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).length()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
    static final class b extends p implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10737a = null;

        static {
            f10737a = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(String r2) {
            o.e(r2, "it");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
    static final class c extends p implements d.h.a.b<Map.Entry<? extends String, ? extends List<? extends String>>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10738a;

        c(String r1) {
            this.f10738a = r1;
            super(1);
        }

        public final Boolean a(Map.Entry<String, ? extends List<String>> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            return Boolean.valueOf(d.o.o.a((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), this.f10738a, true));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Map.Entry<? extends String, ? extends List<? extends String>> r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
    static final class d extends p implements d.h.a.b<Map.Entry<? extends String, ? extends List<? extends String>>, j<? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f10739a = null;

        static {
            f10739a = new d();
        }

        d() {
            super(1);
        }

        public final j<String> a(Map.Entry<String, ? extends List<String>> r2) {
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
            o.e(r1, "it");
            return d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r1.getValue(), Iterable.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ j<? extends String> invoke(Map.Entry<? extends String, ? extends List<? extends String>> r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
    /* synthetic */ class e extends l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f10740a = null;

        static {
            f10740a = new e();
        }

        e() {
            super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            o.e(r2, "p0");
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.c.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
    /* synthetic */ class C0238f extends l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0238f f10741a = null;

        static {
            f10741a = new C0238f();
        }

        C0238f() {
            super(1, d.o.o.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            o.e(r2, "p0");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final com.bytedance.safetyguard.lxc.internal.e.c.c a(int r24, Map<String, ? extends List<String>> r25, byte[] r26, int r27, long r28, boolean r30, Set<String> r31) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.aiagent.plugin");
        o.e(r2, "headers");
        o.e(r26, "bodyBytes");
        o.e(r4, "sensitiveValues");
        String r13 = c(a(r2, DownloadHelper.CONTENT_TYPE));
        String r5 = a(r2, "Retry-After");
        if (r5 == null) goto L14;
        Long r6 = d.o.o.e(r5);
        if (r6 == null) goto L14;
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (0 <= r11) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L14;
        Long r16 = r6;
    L15:
        String r22 = b(a(r2, "X-Tt-Logid"));
        String r23 = b(a(r2, "X-Request-Id"));
        if (r30 == false) goto L18;
        JSONObject r3 = a(r26);
    L19:
        if (r30 == false) goto L24;
        if (r3 == null) goto L22;
        boolean r7 = true;
    L23:
        Boolean r14 = Boolean.valueOf(r7);
    L25:
        if (r3 == null) goto L27;
        JSONObject r8 = r3.optJSONObject("data");
    L28:
        if (r8 == null) goto L31;
        com.bytedance.safetyguard.lxc.internal.e.c.d r15 = com.bytedance.safetyguard.lxc.internal.e.c.d.f10727b;
    L30:
        com.bytedance.safetyguard.lxc.internal.e.c.d r17 = r15;
    L34:
        com.bytedance.safetyguard.lxc.internal.e.c.e r18 = a(r8, r3);
        String r19 = a(r8, r3, d.a.p.a(WsConstants.KEY_CONNECTION_ERROR));
        if (r19 != null) goto L37;
    L39:
        String r20 = null;
    L40:
        String r9 = a(r8, r3, d.a.p.b(new String[]{"error_description", "msg", "message"}));
        if (r9 == null) goto L43;
        String r21 = a(r9, r4);
    L45:
        if (o.a(r19, "authorization_pending") == false) goto L47;
    L69:
        com.bytedance.safetyguard.lxc.internal.e.c.b r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10717b;
    L71:
        if (r10 != com.bytedance.safetyguard.lxc.internal.e.c.b.f10716a) goto L73;
        g r110 = null;
    L75:
        return new com.bytedance.safetyguard.lxc.internal.e.c.c(r10, Integer.valueOf(r24), n.c(r27, 0), r26.length, n.a(r28, 0), r13, r14, r17, r16, r110);
    L73:
        r110 = new g(Integer.valueOf(r24), r18.a(), r20, r21, r22, r23);
        goto L75
    L47:
        if (o.a(r19, "slow_down") == true) goto L69;
        if (200 <= r24) goto L52;
    L54:
        boolean r29 = false;
    L55:
        if (r29 == true) goto L57;
        r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10718c;
        goto L71
    L57:
        if (r30 == false) goto L61;
        if (r3 != null) goto L61;
        r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f;
    L61:
        if (r18.b() == false) goto L64;
        r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f;
        goto L71
    L64:
        if (r18.a() != null) goto L68;
        if (r19 != null) goto L68;
        r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10716a;
    L68:
        r10 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10719d;
        goto L71
    L52:
        if (r24 >= 300) goto L54;
        r29 = true;
        goto L55
    L43:
        r21 = null;
        goto L45
    L37:
        if (f10732a.a((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L39;
        r20 = r19;
        goto L40
    L31:
        if (r3 == null) goto L33;
        r15 = com.bytedance.safetyguard.lxc.internal.e.c.d.f10726a;
        goto L30
    L33:
        r17 = null;
        goto L34
    L27:
        r8 = null;
        goto L28
    L22:
        r7 = false;
        goto L23
    L24:
        r14 = null;
        goto L25
    L18:
        r3 = null;
        goto L19
    L9:
        if (r11 >= 86401) goto L11;
        r12 = true;
    L14:
        r16 = null;
        goto L15
    }

    public static final String a(com.bytedance.safetyguard.lxc.internal.e.c.a r12, com.bytedance.safetyguard.lxc.internal.e.c.c r13) {
        o.e(r12, "context");
        o.e(r13, "diagnostics");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        String r1 = a(r12.a(), 128);
        if (r1 != null) goto L5;
        r1 = "sidecar";
    L5:
        a(r0, "component", r1);
        a(r0, "event", "http_request_finished");
        String r2 = r13.a().name();
        Locale r4 = Locale.ROOT;
        o.c(r4, "ROOT");
        String r3 = r2.toLowerCase(r4);
        o.c(r3, "toLowerCase(...)");
        a(r0, "outcome", r3);
        String r5 = a(r12.b(), 128);
        String r6 = SensitiveType.UNKNOWN;
        if (r5 != null) goto L8;
        r5 = SensitiveType.UNKNOWN;
    L8:
        a(r0, "operation", r5);
        String r7 = a(r12.c(), 16);
        if (r7 != null) goto L11;
        r7 = "UNKNOWN";
    L11:
        a(r0, "method", r7);
        String r8 = e(r12.d());
        if (r8 == null) goto L15;
        r6 = r8;
    L15:
        a(r0, "host", r6);
        a(r0, DownloadConstants.PATH_KEY, f(r12.e()));
        a(r0, PlatformConst.BUNDLE_KEY_BRAND, a(r12.f(), 128));
        a(r0, "appRef", d(r12.g()));
        a(r0, "deviceRef", d(r12.h()));
        a(r0, "sessionRef", d(r12.i()));
        a(r0, "pathRef", d(r12.j()));
        Integer r9 = r12.k();
        String r10 = null;
        if (r9 != null) goto L18;
    L23:
        r9 = null;
    L24:
        a(r0, "attempt", r9);
        a(r0, "polling", Boolean.valueOf(r12.l()));
        a(r0, "httpStatus", r13.b());
        g r14 = r13.j();
        if (r14 == null) goto L27;
        Integer r15 = r14.b();
    L28:
        a(r0, "upstreamCode", r15);
        g r16 = r13.j();
        if (r16 == null) goto L31;
        String r17 = r16.c();
    L32:
        a(r0, "oauthError", a(r17, 128));
        g r18 = r13.j();
        if (r18 == null) goto L35;
        String r19 = r18.e();
    L36:
        a(r0, "logId", b(r19));
        g r110 = r13.j();
        if (r110 == null) goto L39;
        String r111 = r110.f();
    L40:
        a(r0, "requestId", b(r111));
        a(r0, "durationMs", Long.valueOf(r13.e()));
        a(r0, "requestBytes", Integer.valueOf(r13.c()));
        a(r0, "responseBytes", Integer.valueOf(r13.d()));
        a(r0, "contentType", c(r13.f()));
        a(r0, "jsonParsed", r13.g());
        com.bytedance.safetyguard.lxc.internal.e.c.d r112 = r13.h();
        if (r112 == null) goto L45;
        String r113 = r112.name();
        if (r113 == null) goto L45;
        Locale r11 = Locale.ROOT;
        o.c(r11, "ROOT");
        r10 = r113.toLowerCase(r11);
        o.c(r10, "toLowerCase(...)");
    L45:
        a(r0, "envelope", r10);
        a(r0, "retryAfterSec", r13.i());
        g r114 = r13.j();
        if (r114 == null) goto L51;
        String r115 = r114.d();
        if (r115 == null) goto L51;
        r0.add("errorDescription=\"" + g(d.o.o.e(r115, 512)) + '\"');
    L51:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L39:
        r111 = null;
        goto L40
    L35:
        r19 = null;
        goto L36
    L31:
        r17 = null;
        goto L32
    L27:
        r15 = null;
        goto L28
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L20;
        boolean r20 = true;
    L21:
        if (r20 == false) goto L23;
    L20:
        r20 = false;
        goto L21
    }

    public static final String a(String r5) {
        o.e(r5, "pathAndQuery");
        String r6 = d.o.o.a(d.o.o.a(r5, '?', null, 2, null), '#', null, 2, null);
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return "/open-apis";
    L5:
        i r7 = g.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L9;
        return "/open-apis";
    L9:
        return "/open-apis/" + ((String) ZeusTransformUtils.preCheckCast(r7.d().get(1), String.class, "com.obric.aiagent.plugin")) + '/' + ((String) ZeusTransformUtils.preCheckCast(r7.d().get(2), String.class, "com.obric.aiagent.plugin"));
    }

    private static final JSONObject a(byte[] r4) {
        if (r4.length != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r1 = null;
        if (r0 == false) goto L19;
        return null;
    L19:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        Charset r3 = StandardCharsets.UTF_8;     // Catch: Throwable -> L11
        o.c(r3, "UTF_8");     // Catch: Throwable -> L11
        Object r5 = d.n.f(new JSONObject(new String(r4, r3)));     // Catch: Throwable -> L11
    L14:
        if (d.n.b(r5) == true) goto L18;
        r1 = r5;
    L18:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r1, JSONObject.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    private static final com.bytedance.safetyguard.lxc.internal.e.c.e a(JSONObject r1, JSONObject r2) {
        com.bytedance.safetyguard.lxc.internal.e.c.e r3 = a(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        com.bytedance.safetyguard.lxc.internal.e.c.e r4 = a(r2);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return new com.bytedance.safetyguard.lxc.internal.e.c.e(null, false);
    }

    private static final com.bytedance.safetyguard.lxc.internal.e.c.e a(JSONObject r11) {
        Integer r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator r1 = d.a.p.b(new String[]{MonitorConstants.CODE, "error_code"}).iterator();
    L7:
        if (r1.hasNext() == false) goto L52;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r11.has(r2) == false) goto L7;
        if (r11.isNull(r2) == true) goto L7;
        Object r12 = r11.opt(r2);
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r12, Number.class) == false) goto L39;
        Double r13 = Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        double r5 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).doubleValue();
        if (Double.isInfinite(r5) == false) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == true) goto L23;
    L32:
        boolean r6 = false;
    L33:
        if (r6 == true) goto L36;
        r13 = null;
    L36:
        if (r13 == null) goto L41;
        Integer r14 = Integer.valueOf((int) r13.doubleValue());
    L42:
        if (r14 != null) goto L45;
        return new com.bytedance.safetyguard.lxc.internal.e.c.e(null, true);
    L45:
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L48;
        r3 = false;
    L48:
        if (r3 == true) goto L51;
        r0 = r14;
    L51:
        return new com.bytedance.safetyguard.lxc.internal.e.c.e(r0, false);
    L41:
        r14 = null;
        goto L42
    L23:
        if ((r5 % 1.0d) != 0.0d) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L32;
        if (r5 < (-2.147483648E9d)) goto L32;
        if (r5 > 2.147483647E9d) goto L32;
        r6 = true;
        goto L33
    L25:
        r7 = false;
        goto L26
    L18:
        if (Double.isNaN(r5) == true) goto L20;
        r4 = true;
        goto L21
    L39:
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L41;
        o.a(r12);
        r14 = d.o.o.d(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L42
    L52:
        return null;
    }

    private static final String a(JSONObject r2, JSONObject r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        String r6 = a(r2, r5);
        if (r6 == null) goto L6;
        return r6;
    L6:
        return a(r3, r5);
    }

    private static final String a(JSONObject r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L22;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.has(r2) == false) goto L7;
        if (r4.isNull(r2) == true) goto L7;
        String r3 = r4.optString(r2);
        o.c(r3, "optString(...)");
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L7;
        return r8;
    L16:
        r9 = false;
        goto L17
    L22:
        return null;
    }

    private static final String a(String r8, Set<String> r9) {
        Iterator r10 = m.a(m.j(m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f10737a, d.h.a.b.class, "com.obric.aiagent.plugin"))), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")).a();
        String r2 = r8;
    L4:
        if (r10.hasNext() == false) goto L7;
        r2 = d.o.o.a(r2, (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"), "[REDACTED]", false, 4, null);
        goto L4
    L7:
        return d.o.o.e(com.bytedance.safetyguard.lxc.internal.a.c.a(r2), 512);
    }

    private static final String a(Map<String, ? extends List<String>> r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(d.a.p.p(m.g(m.j(m.a(m.d(m.c(m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).entrySet(), Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r3), d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f10739a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f10740a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(C0238f.f10741a, d.h.a.b.class, "com.obric.aiagent.plugin"))))), String.class, "com.obric.aiagent.plugin");
    }

    private static final String b(String r4) {
        if (r4 == null) goto L8;
        if (f10733b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        return r4;
    L8:
        return null;
    }

    private static final String c(String r4) {
        if (r4 == null) goto L14;
        String r5 = d.o.o.a(r4, ';', null, 2, null);
        if (r5 == null) goto L15;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r6 == null) goto L16;
        Locale r1 = Locale.ROOT;
        o.c(r1, "ROOT");
        String r7 = r6.toLowerCase(r1);
        o.c(r7, "toLowerCase(...)");
        if (r7 != null) goto L11;
        return null;
    L11:
        if (f10734c.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L13;
        return null;
    L13:
        return r7;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    private static final String a(String r4, int r5) {
        if (r4 == null) goto L16;
        int r1 = r4.length();
        boolean r2 = false;
        if (1 > r1) goto L8;
        if (r1 > r5) goto L8;
        r2 = true;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 != null) goto L13;
        return null;
    L13:
        if (f10735d.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L15;
        return null;
    L15:
        return r4;
    L16:
        return null;
    }

    private static final String d(String r1) {
        return a(r1, 128);
    }

    private static final String e(String r3) {
        if (r3.length() <= 253) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r3;
    L5:
        if (f10736e.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        r0 = true;
        goto L8
    }

    private static final String f(String r4) {
        if (r4 == null) goto L13;
        if (r4.length() <= 256) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        return r4;
    L7:
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        r1 = true;
    L13:
        return null;
    }

    private static final String g(String r12) {
        return d.o.o.a(d.o.o.a(r12, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    private static final void a(List<String> r2, String r3, Object r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r5.add(r3 + '=' + r4);
        return;
    }

    static {
        f10732a = new k("[A-Za-z0-9._:-]{1,128}");
        f10733b = new k("[A-Za-z0-9._:-]{1,128}");
        f10734c = new k("[a-z0-9!#$&^_.+-]+/[a-z0-9!#$&^_.+-]+");
        f10735d = new k("[A-Za-z0-9._:/-]+");
        f10736e = new k("[A-Za-z0-9.-]+");
        f = new k("/[A-Za-z0-9._~/-]*");
        g = new k("/open-apis/([A-Za-z0-9_-]+)/((?:v)[0-9]+)(?:/[^?#]*)?");
    }
}
