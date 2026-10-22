package com.bytedance.apm.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.d.a<com.bytedance.apm.d.b.a> {
    private static long q = 30000;
    private static boolean r = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f4538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile List<String> f4539e;
    private List<Pattern> f;
    private List<String> g;
    private List<Pattern> h;
    private List<String> i;
    private List<String> j;
    private List<String> k;
    private boolean l;
    private boolean m;
    private double n;
    private boolean o;
    private c p;

    /* JADX INFO: renamed from: com.bytedance.apm.d.a.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetDataPipeline.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: NetDataPipeline.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f4540a = null;

        static /* synthetic */ d a() {
            return f4540a;
        }

        static {
            f4540a = new d(null);
        }
    }

    static {
    }

    /* synthetic */ d(AnonymousClass1 r1) {
        this();
    }

    @Override // com.bytedance.apm.d.a
    public /* synthetic */ boolean b(com.bytedance.apm.d.b r3) {
        return a((com.bytedance.apm.d.b.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.d.b.class, "com.obric.aiagent.plugin"), com.bytedance.apm.d.b.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.apm.d.a
    public /* synthetic */ void c(com.bytedance.apm.d.b r3) {
        b((com.bytedance.apm.d.b.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.d.b.class, "com.obric.aiagent.plugin"), com.bytedance.apm.d.b.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.apm.d.a
    public /* synthetic */ void d(com.bytedance.apm.d.b r3) {
        c((com.bytedance.apm.d.b.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.d.b.class, "com.obric.aiagent.plugin"), com.bytedance.apm.d.b.a.class, "com.obric.aiagent.plugin"));
    }

    private d() {
        this.f4537c = true;
        this.l = true;
        this.m = false;
    }

    public static d c() {
        return a.a();
    }

    public void a(c r3) {
        this.p = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public void b(boolean r1) {
        this.o = r1;
    }

    @Override // com.bytedance.apm.d.a, com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r4, boolean r5) {
        JSONObject r6 = p.a(r4, "network_image_modules");
        if (r6 == null) goto L14;
        JSONObject r7 = p.a(r6, "network");
        if (r7 == null) goto L10;
        this.f4539e = p.b(r7, "api_block_list");
        this.f = p.d(r7, "api_block_list");
        this.g = p.c(r7, "api_allow_list");
        this.h = p.e(r7, "api_allow_list");
        boolean r1 = false;
        this.f4536b = r7.optInt("enable_api_all_upload", 0);
        this.f4537c = r7.optBoolean("enable_trace_log", true);
        this.f4538d = r7.optInt("enable_api_error_upload", 1);
        if (r7.optInt("enable_cancel_error_report") != 1) goto L9;
        r1 = true;
    L9:
        this.m = r1;
        this.j = p.c(r7, "request_allow_header");
        this.k = p.c(r7, "response_allow_header");
        this.n = r7.optDouble("enable_base_api_all", 0.0d);
    L10:
        JSONObject r8 = p.a(r6, "image");
        if (r8 == null) goto L15;
        this.i = p.c(r8, "image_allow_list");
        return;
    L15:
        return;
    }

    public boolean a(com.bytedance.apm.d.b.a r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.f4544d) == true) goto L6;
        return true;
    }

    public void b(com.bytedance.apm.d.b.a r1) {
        if (b() == true) goto L5;
        boolean r0 = true;
    L6:
        r1.a(r0);     // Catch: JSONException -> L11
        if (g() == false) goto L9;
        r1.e();     // Catch: JSONException -> L11
    L9:
        r1.a("ttnet");     // Catch: JSONException -> L11
        return;
    L5:
        r0 = false;
    }

    public void c(com.bytedance.apm.d.b.a r1) {
        d(r1);
    }

    private boolean a(String r2) {
        return p.a(r2, this.g, this.h);
    }

    private boolean b(String r2) {
        return p.a(r2, this.f4539e, this.f);
    }

    private boolean c(String r1) {
        return p.a(r1, this.i);
    }

    private boolean a(String r4, JSONObject r5) {
        if (c(r4) == false) goto L5;
    L16:
        return false;
    L5:
        if (m.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L10;
        if (this.o == false) goto L16;
    L10:
        if (a(r5) == true) goto L12;
        return true;
    L12:
        if (this.m == true) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean a(String r4, String r5, JSONObject r6) {
        if (TextUtils.equals(r4, "api_all") == false) goto L12;
        if (d() == false) goto L8;
        b(r5, r6);
        return true;
    L8:
        if (b(r5) == true) goto L17;
        return b(r5, r6);
    L17:
        return false;
    L12:
        if (TextUtils.equals(r4, "api_error") == false) goto L17;
        if (this.f4538d != 1) goto L17;
        return true;
    }

    private void d(com.bytedance.apm.d.b.a r8) {
        String r0 = r8.f4544d;
        String r3 = r8.f4541a;
        boolean r1 = !r8.h.isNull("hit_rules");
        if (r1 == false) goto L5;
    L7:
        JSONObject r4 = r8.a();
        i.a(r4, r8.h);
        if (r4 != null) goto L11;
        return;
    L11:
        if (r1 == false) goto L13;
    L16:
        boolean r6 = true;
    L18:
        if (this.l == false) goto L20;
        a(r4, r8.f4541a);
    L20:
        b(r4);
        if (this.p != null) goto L23;
    L27:
        a(r3, r3, r4, r6, true);
        return;
    L23:
        if ("api_all".equals(r3) == false) goto L27;
        if (r8.h.optBoolean("download", false) == true) goto L27;
        this.p.a(r0, r8.h);
        goto L27
    L13:
        if (a(r3, r0, r4) == true) goto L16;
        r6 = false;
        goto L18
    L5:
        if (a(r0, r8.h) == true) goto L7;
    }

    private boolean a(JSONObject r2) {
        if (r2 != null) goto L12;
        return false;
    L12:
        String r1 = r2.optString("cronet_internal_error_code");     // Catch: Exception -> L11
        if ("11".equals(r2.optString("cronet_error_code")) == false) goto L14;
        if ("-999".equals(r1) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    private void b(JSONObject r3) {
        a(this.j, r3, "requestHeader");
        a(this.k, r3, "responseHeader");
    }

    private void a(List<String> r6, JSONObject r7, String r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L32;
        if (r7 == null) goto L33;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L34;
        String r9 = r7.optString(r8);     // Catch: JSONException -> L17 Exception -> L20
        if (TextUtils.isEmpty(r9) == true) goto L35;
        JSONObject r1 = new JSONObject(r9);     // Catch: JSONException -> L17 Exception -> L20
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L17 Exception -> L20
        Iterator<String> r2 = r1.keys();     // Catch: JSONException -> L17 Exception -> L20
    L11:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L17 Exception -> L20
        if (r5.contains(r3) == false) goto L11;
        r10.put(r3, r1.opt(r3));     // Catch: JSONException -> L17 Exception -> L20
        goto L11
    L15:
        r7.put(r8, r10.toString());     // Catch: JSONException -> L17 Exception -> L20
    L36:
        return;
    L35:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
        return;
    L34:
        return;
    L33:
        return;
    }

    private void a(JSONObject r5, String r6) {
        if (r5 == null) goto L30;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r6, "api_all") == false) goto L8;
        r5.put("net_log_type", "api_all_v2");     // Catch: Exception -> L25
    L12:
        if (d() == false) goto L17;
        if (f() == false) goto L17;
        r5.put("inject_tracelog", "01");     // Catch: Exception -> L25
    L21:
        double r0 = this.n;     // Catch: Exception -> L25
        if (r0 == 0.0d) goto L31;
        r5.put("enable_base_api_all", r0);     // Catch: Exception -> L25
        return;
    L31:
        return;
    L17:
        if (e() != 1) goto L21;
        if (f() == false) goto L21;
        r5.put("inject_tracelog", "02");     // Catch: Exception -> L25
        goto L21
    L8:
        if (TextUtils.equals(r6, "api_error") == false) goto L12;
        r5.put("net_log_type", "api_error_v2");     // Catch: Exception -> L25
        goto L12
    }

    private boolean b(String r5, JSONObject r6) {
        if (d() == false) goto L5;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r7 = 1;
    L14:
        boolean r0 = com.bytedance.apm.m.c.b("smart_traffic");
        if (r0 == false) goto L24;
        r7 = r7 | 4;
    L24:
        r6.put("hit_rules", r7);     // Catch: JSONException -> L23
    L18:
        if (r4 == true) goto L26;
        if (r0 == false) goto L22;
        return true;
    L22:
        return false;
    L26:
        return true;
    L13:
        r7 = 0;
        goto L14
    L5:
        if (this.f4536b != 0) goto L10;
        if (a(r5) == true) goto L10;
        r4 = false;
        goto L11
    }

    public boolean d() {
        if (this.l == true) goto L5;
    L7:
        return false;
    L5:
        if (this.n == 0.0d) goto L7;
        return true;
    }

    public int e() {
        return this.f4536b;
    }

    public boolean f() {
        return this.f4537c;
    }

    public static void a(long r0) {
        q = r0;
    }

    public static void c(boolean r0) {
        r = r0;
    }

    public static boolean g() {
        if (r == true) goto L6;
        return false;
    L6:
        if (com.bytedance.apm.c.u() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - com.bytedance.apm.c.u()) <= q) goto L11;
        return false;
    L11:
        return true;
    }
}
