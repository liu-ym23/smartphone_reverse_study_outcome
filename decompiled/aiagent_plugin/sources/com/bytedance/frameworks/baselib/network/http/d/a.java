package com.bytedance.frameworks.baselib.network.http.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.f.f;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.frameworks.baselib.network.http.j;
import com.bytedance.retrofit2.ad;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.e.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseSsCall.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c, com.bytedance.retrofit2.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8268a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f8269b = false;
    static final /* synthetic */ boolean j = true;
    protected com.bytedance.retrofit2.b.c f;
    protected com.bytedance.frameworks.baselib.network.http.b g;
    protected boolean h;
    protected volatile boolean i;

    static {
    }

    public int a(IOException r1) {
        return -1;
    }

    public abstract void a(af r1);

    public void a(com.bytedance.retrofit2.b.c r1, Exception r2) {
    }

    public void a(i r2) {
        i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
    }

    public abstract void a(String r1, com.bytedance.retrofit2.b.c r2, com.bytedance.frameworks.baselib.network.http.b r3, Map<String, String> r4);

    public void b(Exception r1) {
    }

    public abstract Context getContext();

    public boolean l() {
        return false;
    }

    public void o() {
    }

    public static void c(boolean r0) {
        f8268a = r0;
    }

    public static void d(boolean r0) {
        f8269b = r0;
    }

    public a(com.bytedance.retrofit2.b.c r4) {
        this.h = false;
        this.i = false;
        this.f = r4;
        this.g = com.bytedance.frameworks.baselib.network.http.b.a();
        if (r4.p() == null) goto L6;
        this.g.a(r4.p());
    L6:
        if (j == false) goto L8;
    L12:
        this.g.f8138d.aH();
        ad.b r5 = this.g.f8138d.aE.f;
        r5.f9416c = com.bytedance.frameworks.baselib.network.c.c().o;
        ad.b r6 = this.g.f8138d.aE.f;
        r6.f9417d = com.bytedance.frameworks.baselib.network.c.c().L;
        this.g.f8138d.af = "4.2.243.22-doubao";
        com.bytedance.frameworks.baselib.network.http.b r7 = this.g;
        r7.L = this.f.h();
        if (ZeusTransformUtils.instanceOf(this.f.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L22;
        com.bytedance.frameworks.baselib.network.http.b r8 = this.g;
        r8.f8137c = (T) ZeusTransformUtils.preCheckCast(this.f.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin");
        this.h = this.g.f8137c.n;
        List<com.bytedance.frameworks.baselib.network.http.c.C0184c> r9 = this.g.f8137c.B;
        if (r9 != null) goto L17;
        return;
    L17:
        if (r9.size() > 0) goto L19;
        return;
    L19:
        if (r9.size() > 3) goto L25;
        com.bytedance.frameworks.baselib.network.http.b r3 = this.g;
        r3.Z = new j(r9);
        return;
    L25:
        return;
    L22:
        return;
    L8:
        if (this.g.f8138d != null) goto L12;
        throw new AssertionError();
    }

    public com.bytedance.retrofit2.b.d m() {
        if (this.i == true) goto L80;
        o();
        a(this.f, this.g);
        p();
        long r0 = System.nanoTime();
        this.f = com.bytedance.frameworks.baselib.network.f.d.a(this.f, this.g);     // Catch: Throwable -> L81
    L6:
        boolean r2 = true;
        boolean r3 = false;
        a(this.f.b(), this.f, this.g, null);     // Catch: Throwable -> L46 Exception -> L48
    L44:
        e = move-exception;
        Exception r4 = e;
        r2 = false;
    L53:
        if (r2 == true) goto L67;
        b(r4);     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L61;
        if (((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a() != 304) goto L61;
        throw r4;     // Catch: Throwable -> L46
    L61:
        if (ZeusTransformUtils.instanceOf(r4, IOException.class) == true) goto L63;
    L65:
        a(this.f, r4);     // Catch: Throwable -> L46
        throw a(r4);     // Catch: Throwable -> L46
    L63:
        if ("Canceled".equals(r4.getMessage()) == false) goto L65;
        throw r4;     // Catch: Throwable -> L46
    L67:
        throw r4;     // Catch: Throwable -> L46
    L9:
        if (this.f.h() == true) goto L16;
        g.i r5 = g.i();     // Catch: Exception -> L44 Throwable -> L46
        if (r5 == null) goto L16;
        if (r5.a(this.f.b()) == false) goto L16;
        DeviceBandwidthSampler.a().b();     // Catch: Exception -> L44 Throwable -> L46
    L93:
        List<String> r6 = new ArrayList();     // Catch: Throwable -> L40 Exception -> L42
        a(this.g.f8138d);     // Catch: Throwable -> L22 IOException -> L24
        r6 = a(this.f, this.g, this, true, false);     // Catch: Throwable -> L22 IOException -> L24
        af r7 = this.g.f8138d;     // Catch: Throwable -> L40 Exception -> L42
    L20:
        r7.e(r0);     // Catch: Throwable -> L40 Exception -> L42
        a(this.g, this);     // Catch: Throwable -> L40 Exception -> L42
        i r12 = a(this.f.b(), this.f, this.g, this, this);     // Catch: Throwable -> L40 Exception -> L42
        a(r12);     // Catch: Throwable -> L40 Exception -> L42
        com.bytedance.retrofit2.b.d r1 = new com.bytedance.retrofit2.b.d(this.f.b(), c(), h(), a(this, r6), r12);     // Catch: Throwable -> L40 Exception -> L42
        r1.a(this.g);     // Catch: Throwable -> L40 Exception -> L42
        r1.c(this.g.P);     // Catch: Throwable -> L40 Exception -> L42
        if (this.f.h() == true) goto L34;
        j();
    L34:
        if (this.f.h() == true) goto L37;
        if (r2 == false) goto L37;
        DeviceBandwidthSampler.a().c();
    L37:
        return r1;
    L22:
        th = move-exception;
        this.g.f8138d.e(r0);     // Catch: Throwable -> L40 Exception -> L42
        throw th;     // Catch: Throwable -> L40 Exception -> L42
    L24:
        e = move-exception;
        a(this.f, a(e), this.g, this, e, true);     // Catch: Throwable -> L22
        r7 = this.g.f8138d;     // Catch: Throwable -> L40 Exception -> L42
    L42:
        e = move-exception;
        r4 = e;
        r2 = false;
    L40:
        th = th;
        r3 = r2;
    L68:
        if (0 == 0) goto L71;
        a(this.g, this, null);
    L71:
        if (this.f.h() == false) goto L73;
        if (0 != 0) goto L73;
    L75:
        if (this.f.h() == true) goto L78;
        if (r3 == false) goto L78;
        DeviceBandwidthSampler.a().c();
    L78:
        throw th;
    L73:
        j();
    L16:
        r2 = false;
    L46:
        th = th;
    L48:
        e = move-exception;
        this.g.f8138d.e(r0);     // Catch: Throwable -> L46 Exception -> L51
        throw e;     // Catch: Throwable -> L46 Exception -> L51
    L51:
        e = move-exception;
        r4 = e;
        goto L53
    L80:
        throw new IOException("request canceled");
    }

    public static void a(com.bytedance.retrofit2.b.c r1, com.bytedance.frameworks.baselib.network.http.b r2) {
        g.a(r2.f8138d);
        if (com.bytedance.frameworks.baselib.network.http.b.a.a(r1.l()) == true) goto L10;
        r2.f8138d.ag();
        com.bytedance.frameworks.baselib.network.http.b.a.b();     // Catch: Throwable -> L7
        r2.f8138d.ah();
        return;
    L7:
        th = move-exception;
        r2.f8138d.ah();
        throw th;
    }

    public void p() {
        if (l() == false) goto L5;
        return;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L7;
        return;
    L7:
        if (com.bytedance.common.utility.i.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L13;
        com.bytedance.frameworks.baselib.network.http.c.e r0 = new com.bytedance.frameworks.baselib.network.http.c.e("network not available for " + this.f.o());
        r0.a(false, false, this.f.b(), "", this.g);
        throw r0;
    }

    public List<String> a(com.bytedance.retrofit2.b.c r8, com.bytedance.frameworks.baselib.network.http.b r9, c r10, boolean r11, boolean r12) {
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r10, c.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.i r14 = g.a(r8, r13.c(), r9, r8.c(), r13.e(), r11, r12);
        ArrayList r15 = null;
        if (r14 == null) goto L12;
        if (r14.a() == false) goto L12;
        if (r9.Y == false) goto L9;
        r8 = r8.m().a(r14.d()).b();
    L9:
        a(r8, r9, r13, r14.c());
        return null;
    L12:
        if (com.bytedance.common.utility.j.a(r9.V) == true) goto L19;
        if (r14 != null) goto L15;
    L16:
        r15 = new ArrayList();
        if (com.bytedance.common.utility.j.a(r9.V) == true) goto L19;
        r15.add(r9.V);
        goto L19
    L15:
        if (r14.b() == true) goto L16;
    L19:
        return r15;
    }

    public void a(com.bytedance.retrofit2.b.c r10, com.bytedance.frameworks.baselib.network.http.b r11, c r12, Map<String, String> r13) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r12, c.class, "com.obric.aiagent.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        r6.j();
        r11.aa = System.currentTimeMillis();
        a(r10.b(), r10, r11, r14);
        a(r11.f8138d);     // Catch: IOException -> L5
        a(r10, r11, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        a(r10, a(e), r11, r6, e, false);
    }

    private void a(com.bytedance.retrofit2.b.c r8, int r9, com.bytedance.frameworks.baselib.network.http.b r10, c r11, IOException r12, boolean r13) {
        c r14 = (c) ZeusTransformUtils.wrapperContextForParams(r11, c.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.i r15 = g.a(r8, r9, r10, r8.c(), null, r13, false);
        if (r15 != null) goto L5;
        throw r12;
    L5:
        if (r15.a() == true) goto L7;
        throw r12;
    L7:
        if (r10.Y == false) goto L12;
        a(r8.m().a(r15.d()).b(), r10, r14, r15.c());
        return;
    L12:
        throw r12;
    }

    public void a(com.bytedance.frameworks.baselib.network.http.b r5, c r6) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
        long r0 = System.currentTimeMillis();
        r5.h = r0;
        r5.i = r0;
        r5.O = com.bytedance.frameworks.baselib.network.http.a.a(r4.d());
        a(r4.a("x-net-info.remoteaddr"), r5);
        if (r5.f8137c == 0) goto L5;
        T r7 = r5.f8137c;
        r7.f8188b = r4.c();
    L5:
        r5.P = r4.a("X-TT-LOGID");
        if (r5.P != null) goto L9;
        r5.P = "";
    L9:
        if (j == false) goto L11;
    L15:
        af r8 = r5.f8138d;
        r8.ah = r5.P;
        r5.F = r4.k();
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r5.U < 0) goto L20;
        r5.K.put("turing_callback", r5.U);     // Catch: Throwable -> L40
    L20:
        if (r5.X < 0) goto L24;
        r5.K.put("retry_for_account_cost", r5.X);     // Catch: Throwable -> L40
    L24:
        if (r5.T == false) goto L27;
        r5.K.put("turing_retry", "1");     // Catch: Throwable -> L40
    L27:
        if (r5.W == false) goto L30;
        r5.K.put("account_retry", "1");     // Catch: Throwable -> L40
    L30:
        if (r5.V == null) goto L33;
        r5.K.put("retry_by_header", r5.V);     // Catch: Throwable -> L40
    L33:
        if (r5.Z == null) goto L45;
        JSONObject r9 = r5.Z.c();     // Catch: Throwable -> L40
        if (r9 != null) goto L37;
        return;
    L37:
        if (r9.length() <= 0) goto L47;
        r5.K.put("rotation_host_retry", r9);     // Catch: Throwable -> L40
        r5.f8138d.b(r9);     // Catch: Throwable -> L40
        return;
    L47:
        return;
    L45:
        return;
    L11:
        if (r5.f8138d != null) goto L15;
        throw new AssertionError();
    }

    private static void a(String r1, com.bytedance.frameworks.baselib.network.http.b r2) {
        if (com.bytedance.common.utility.j.a(r1) == false) goto L10;
        return;
    L10:
        r2.w = r1;     // Catch: Throwable -> L9
        if (r2.f8137c == 0) goto L12;
        r2.f8137c.f8187a = r1;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private static boolean a(com.bytedance.retrofit2.b.c r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        if (r3.h() == false) goto L12;
        if (r5.c() < 200) goto L10;
        if (r5.c() >= 300) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r5.c() != 200) goto L15;
        return true;
    L15:
        return false;
    }

    public static i a(String r11, final com.bytedance.retrofit2.b.c r12, final com.bytedance.frameworks.baselib.network.http.b r13, c r14, com.bytedance.retrofit2.b.e r15) {
        final c r16 = (c) ZeusTransformUtils.wrapperContextForParams(r14, c.class, "com.obric.aiagent.plugin");
        final com.bytedance.retrofit2.b.e r17 = (com.bytedance.retrofit2.b.e) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.retrofit2.b.e.class, "com.obric.aiagent.plugin");
        r13.f8138d.az();
        boolean r0 = b(r13);     // Catch: Throwable -> L66
        i r1 = new AnonymousClass1(r16, r13, r12, r17);     // Catch: Throwable -> L66
        if (r12.h() == true) goto L6;
    L10:
        r13.f8138d.aD();     // Catch: Throwable -> L66
        if (f8268a == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        boolean r10 = r13.f8135a;     // Catch: Throwable -> L66
        InputStream r18 = null;
        String r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        int[] r7 = new int[1];     // Catch: Throwable -> L63
        InputStream r2 = r1.e_();     // Catch: Throwable -> L63
        byte[] r3 = f.a(r16.i(), r12.k(), r2, r7, r13.f8138d, r9, r10);     // Catch: Throwable -> L61
        f.a(r2);     // Catch: Throwable -> L66
        if (a(r12, r16) == true) goto L51;
        if (r0 == true) goto L51;
        if (r3 != null) goto L26;
    L44:
        com.bytedance.frameworks.baselib.network.http.c.d r6 = new com.bytedance.frameworks.baselib.network.http.c.d(r16.c(), "", r12.o(), r19);     // Catch: Throwable -> L66
        if (r12.h() == false) goto L47;
    L48:
        r6.a(true, false, r11, r13.P, r13);     // Catch: Throwable -> L66
        throw r6;     // Catch: Throwable -> L66
    L47:
        if (r16.c() == 304) goto L48;
        throw r6;     // Catch: Throwable -> L66
    L26:
        if (r3.length <= 0) goto L44;
        if (com.bytedance.common.utility.j.a(r16.d()) == true) goto L44;
        if (Logger.debug() == false) goto L32;
    L72:
        com.bytedance.frameworks.baselib.network.http.f.b r4 = new com.bytedance.frameworks.baselib.network.http.f.b(r16.d());     // Catch: Throwable -> L42
        if ("text".equalsIgnoreCase(r4.a()) == false) goto L36;
    L37:
        String r5 = r4.a("charset");     // Catch: Throwable -> L42
        if (com.bytedance.common.utility.j.a(r5) == false) goto L40;
        r5 = "utf-8";
    L40:
        r19 = new String(r3, r5);     // Catch: Throwable -> L42
        goto L44
    L36:
        if ("application/json".equalsIgnoreCase(r4.b()) == false) goto L44;
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
        goto L44
    L32:
        if (a(r13) == false) goto L44;
    L51:
        if (f.a(r16.d()) == false) goto L54;
        if (r3 == null) goto L54;
        f.a(r3, r3.length);     // Catch: Throwable -> L66
    L54:
        String r110 = r16.d();     // Catch: Throwable -> L66
        if (r3 != null) goto L58;
        r3 = new byte[0];     // Catch: Throwable -> L66
    L58:
        com.bytedance.retrofit2.e.g r111 = new com.bytedance.retrofit2.e.g(r110, r3, new String[0]);     // Catch: Throwable -> L66
        r13.f8138d.aA();
        return r111;
    L61:
        th = th;
        r18 = r2;
    L64:
        f.a(r18);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L63:
        th = th;
        goto L64
    L13:
        if (f8269b == false) goto L15;
        r9 = true;
        goto L16
    L6:
        if (a(r12, r16) == true) goto L8;
        if (r0 == false) goto L10;
    L8:
        r13.f8138d.aA();
        return r1;
    L66:
        th = move-exception;
        r13.f8138d.aA();
        throw th;
    }

    public static String a(com.bytedance.frameworks.baselib.network.http.b r9, Map<String, List<String>> r10, int r11, InputStream r12, String r13, boolean r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L36;
        return null;
    L36:
        r12 = f.a(r12, r15, r14, r9.f8138d);     // Catch: Throwable -> L29 Exception -> L31
        byte[] r16 = f.a(r14, r11, r12, new int[1], r9.f8138d, false, r9.f8135a);     // Catch: Throwable -> L29 Exception -> L31
        f.a(r12);
        if (r16 != null) goto L10;
        return null;
    L10:
        if (r16.length > 0) goto L12;
        return null;
    L12:
        if (com.bytedance.common.utility.j.a(r13) == false) goto L14;
        return null;
    L14:
        if (Logger.debug() == false) goto L16;
    L38:
        com.bytedance.frameworks.baselib.network.http.f.b r17 = new com.bytedance.frameworks.baselib.network.http.f.b(r13);     // Catch: Throwable -> L26
        if ("text".equalsIgnoreCase(r17.a()) == false) goto L20;
    L21:
        String r18 = r17.a("charset");     // Catch: Throwable -> L26
        if (com.bytedance.common.utility.j.a(r18) == false) goto L24;
        r18 = "utf-8";
    L24:
        return new String(r16, r18);
    L20:
        if ("application/json".equalsIgnoreCase(r17.b()) == true) goto L21;
        return null;
    L26:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        if (a(r9) == true) goto L38;
        return null;
    L29:
        th = move-exception;
        f.a(r12);
        throw th;
    L31:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L29
    }

    private static boolean a(com.bytedance.frameworks.baselib.network.http.b r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.f8137c == 0) goto L8;
        if (r1.f8137c.k == false) goto L8;
        return true;
    }

    private static boolean b(com.bytedance.frameworks.baselib.network.http.b r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.f8137c == 0) goto L8;
        if (r1.f8137c.j == false) goto L8;
        return true;
    }

    public static List<com.bytedance.retrofit2.b.b> a(c r8, List<String> r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<String, List<String>> r12 = r10.e();
        if (r12 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L22;
        if (r11 == null) goto L22;
        if (r11.isEmpty() == true) goto L22;
        boolean r4 = false;
        Iterator r5 = r11.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        if (r3.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L16;
        r4 = true;
    L20:
        if (r4 == true) goto L8;
    L22:
        Iterator r6 = ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r6.hasNext() == false) goto L8;
        r0.add(new com.bytedance.retrofit2.b.b(r3, (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin")));
        goto L24
    L26:
        return r0;
    }

    public static void a(com.bytedance.frameworks.baselib.network.http.b r2, c r3, Exception r4) {
        String r5 = a(((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin")).e());     // Catch: Throwable -> L14
        if (com.bytedance.common.utility.j.a(r5) == true) goto L6;
        r2.K.put("response-headers", r5);     // Catch: Throwable -> L14
    L6:
        String r6 = r4.getMessage();     // Catch: Throwable -> L14
        Throwable r0 = r4.getCause();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r6) == true) goto L12;
        if (r0 == null) goto L12;
        if (TextUtils.isEmpty(r0.getMessage()) == true) goto L12;
        r6 = r6 + ", cause = " + r0.getMessage();     // Catch: Throwable -> L14
    L12:
        r2.K.put("ex", r6);     // Catch: Throwable -> L14
    L17:
        if (com.bytedance.common.utility.j.a(r2.w) == false) goto L22;
        a(c(r4), r2);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    private static String a(Map<String, List<String>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L37;
    L36:
        return "";
    L37:
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L5:
        if (r10.isEmpty() == true) goto L36;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L34
        Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L34
    L9:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (com.bytedance.common.utility.j.a(r4) == true) goto L9;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L34
        int r7 = 0;
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L34
    L23:
        if (r8.hasNext() == false) goto L31;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (com.bytedance.common.utility.j.a(r12) == true) goto L23;
        if (r7 != 0) goto L29;
        r6.append(r12);     // Catch: Throwable -> L34
    L30:
        r7 = r7 + 1;     // Catch: Throwable -> L34
        goto L23
    L29:
        r6.append("; ").append(r12);     // Catch: Throwable -> L34
        goto L30
    L31:
        r2.put(r4, r6.toString());     // Catch: Throwable -> L34
        goto L9
    L32:
        return r2.toString();
    }

    private static String c(Exception r3) {
        if (r3 != null) goto L18;
        return "";
    L18:
        String r1 = r3.getMessage();     // Catch: Throwable -> L15
        if (r1 != null) goto L8;
    L14:
        return "";
    L8:
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L14;
        String[] r4 = r1.split("\\|");     // Catch: Throwable -> L15
        if (r4.length < 2) goto L17;
        return r4[0];
    L17:
        return "";
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public IOException a(Exception r2) {
        return new IOException(r2.getMessage(), r2.getCause());
    }
}
