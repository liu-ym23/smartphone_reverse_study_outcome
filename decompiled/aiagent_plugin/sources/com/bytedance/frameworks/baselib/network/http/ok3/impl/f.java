package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.af;
import okhttp3.ttnet.TTNetUtils;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: compiled from: Ok3SsCall.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.frameworks.baselib.network.http.d.a implements WeakHandler.IHandler {
    static final /* synthetic */ boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    z f8477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ab f8478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ad f8479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    okhttp3.e f8480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile m f8481e;
    private final WeakHandler l;

    static {
    }

    public static /* synthetic */ ab lambda$4ig6bsehGB_z8RvB9F6ywcchi0M(com.bytedance.frameworks.baselib.network.http.c.a r0, af r1, ad r2) {
        return a(r0, r1, r2);
    }

    @Override // com.bytedance.retrofit2.b.e
    public boolean a(long r1) {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public InputStream g() {
        return null;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    public f(com.bytedance.retrofit2.b.c r6) {
        super(r6);
        this.f8477a = null;
        this.f8481e = null;
        this.g.G = 1;     // Catch: Exception -> L5
        this.g.K.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L5
        this.g.K.put("hcv", r.h());     // Catch: Exception -> L5
    L7:
        com.bytedance.frameworks.baselib.network.http.b r7 = this.g;
        r7.H = r.e();
        com.bytedance.frameworks.baselib.network.http.b r8 = this.g;
        r8.I = r.f();
        if (k == false) goto L10;
    L14:
        com.bytedance.retrofit2.af r9 = this.g.f8138d;
        r9.g = this.g.H;
        com.bytedance.retrofit2.af r10 = this.g.f8138d;
        r10.h = this.g.I;
        this.l = new WeakHandler(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.e.getService().j().getLooper(), this);
        String r11 = this.f.b();
        this.f8481e = new m(this.g, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.f8481e.a(r11, this.f.a());
        return;
    L10:
        if (this.g.f8138d != null) goto L14;
        throw new AssertionError();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public int c() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String d() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.g() == null) goto L12;
        x r2 = this.f8479c.g().b();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L12:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public Map<String, List<String>> e() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f().e();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String a(String r1) {
        ad r0 = this.f8479c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public InputStream f() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.g() == null) goto L7;
        return this.f8479c.g().e();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String h() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public boolean i() {
        return DownloadHelper.GZIP.equalsIgnoreCase(this.f8479c.b(DownloadHelper.CONTENT_ENCODING));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public void j() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L5;
    L7:
        okhttp3.e r1 = this.f8480d;
        if (r1 == null) goto L11;
        r1.c();
        return;
    L11:
        return;
    L5:
        if (r0.g() == null) goto L7;
        com.bytedance.frameworks.baselib.network.http.f.f.a(this.f8479c.g());
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public boolean k() {
        ad r0 = this.f8479c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.i() != null) goto L9;
        return false;
    L9:
        if (this.f8479c.h() != null) goto L11;
        return true;
    L11:
        if (this.f8479c.d() == 304) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void o() {
        if (r.d() == true) goto L6;
        return;
    L6:
        throw new com.bytedance.frameworks.baselib.network.http.c.h("request is not allowed using network");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public boolean l() {
        return this.h;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(String r3, com.bytedance.retrofit2.b.c r4, com.bytedance.frameworks.baselib.network.http.b r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        r5.f8138d.aa();     // Catch: Throwable -> L6 Exception -> L8
        a(r5);     // Catch: Throwable -> L6 Exception -> L8
        a(r4, r5, r7);     // Catch: Throwable -> L6 Exception -> L8
        r5.f8138d.ab();
        return;
    L8:
        e = move-exception;
        throw com.bytedance.retrofit2.f.c.a(e, r3, r5.P, r5);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r5.f8138d.ab();
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(com.bytedance.retrofit2.af r4) {
        if (this.f8480d == null) goto L10;
        long r0 = r4.ay();
        this.f8479c = this.f8480d.b();     // Catch: Throwable -> L7
        this.f8481e.b(this.f8479c);     // Catch: Throwable -> L7
        r4.d(r0);
        return;
    L7:
        th = move-exception;
        r4.d(r0);
        throw th;
    }

    private void a(com.bytedance.frameworks.baselib.network.http.b r4) {
        long r0 = -1;
        r0 = r4.f8138d.aw();     // Catch: Throwable -> L6
        this.f8477a = r.a();     // Catch: Throwable -> L6
        r4.f8138d.b(r0);
        return;
    L6:
        th = move-exception;
        r4.f8138d.b(r0);
        throw th;
    }

    private void a(com.bytedance.retrofit2.b.c r13, com.bytedance.frameworks.baselib.network.http.b r14, Map<String, String> r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        long r2 = r14.f8138d.ax();
        z.a r0 = this.f8477a.E();     // Catch: Throwable -> L108
        if (r14.f8137c == 0) goto L6;
        r0.b(r14.f8137c.t);     // Catch: Throwable -> L108
    L6:
        r0.a(com.bytedance.frameworks.baselib.network.http.g.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.b(com.bytedance.frameworks.baselib.network.http.g.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.c(com.bytedance.frameworks.baselib.network.http.g.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.a(r.g());     // Catch: Throwable -> L108
        r0.enableBoe(com.bytedance.frameworks.baselib.network.http.i.c.a());     // Catch: Throwable -> L108
        if (r14.f8137c == 0) goto L31;
        com.bytedance.frameworks.baselib.network.http.c r4 = r14.f8137c;     // Catch: Throwable -> L108
        if (r4.f8189c <= 0) goto L12;
        r0.a(r4.f8189c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L12:
        if (r4.f8191e <= 0) goto L15;
        r0.c(r4.f8191e, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L15:
        if (r4.f8190d <= 0) goto L18;
        r0.b(r4.f8190d, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L18:
        if (r4.y == false) goto L20;
        r0.a(Proxy.NO_PROXY);     // Catch: Throwable -> L108
    L20:
        final com.bytedance.frameworks.baselib.network.http.c.a r5 = r4.z;     // Catch: Throwable -> L108
        if (r5 != null) goto L23;
    L27:
        com.bytedance.frameworks.baselib.network.http.c.b r6 = r4.A;     // Catch: Throwable -> L108
        if (r6 == null) goto L30;
        r6.a(r0);     // Catch: Throwable -> L108
    L30:
        this.f8481e.a(r4);     // Catch: Throwable -> L108
        goto L31
    L23:
        if (r5.f8192a == null) goto L27;
        if (r5.f8193b == null) goto L27;
        r0.a(new $$Lambda$f$4ig6bsehGB_z8RvB9F6ywcchi0M(r5));     // Catch: Throwable -> L108
    L31:
        String r7 = r13.b();     // Catch: Throwable -> L108
        String r8 = null;
        if (this.f8477a.e() == null) goto L34;
        okhttp3.r r9 = this.f8477a.e().create(this.f8477a.a(new ab.a().originUrl(r7).a(r7).b()));     // Catch: Throwable -> L108
    L35:
        r0.a(new OkHttp3EventListener(r9, this.f8481e));     // Catch: Throwable -> L108
        this.f8477a = r0.E();     // Catch: Throwable -> L108
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L108
        if (r13.u() == false) goto L111;
    L41:
        List<com.bytedance.retrofit2.b.b> r10 = new ArrayList();     // Catch: Throwable -> L108
        long r11 = SystemClock.uptimeMillis();     // Catch: Throwable -> L108
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r12 = new com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b();     // Catch: Throwable -> L108
        String r17 = com.bytedance.frameworks.baselib.network.http.ok3.impl.a.c.a().a(r7, r13, r12, r10);     // Catch: Throwable -> L108
        r12.f8412e = SystemClock.uptimeMillis() - r11;     // Catch: Throwable -> L108
        this.f8481e.a(r12);     // Catch: Throwable -> L108
        if (r10.isEmpty() == false) goto L44;
        r10 = r13.c();     // Catch: Throwable -> L108
    L44:
        String r18 = com.bytedance.frameworks.baselib.network.http.i.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r17, r10);     // Catch: Throwable -> L108
        ab.a r19 = new ab.a().originUrl(r18).a(r18);     // Catch: Throwable -> L108
        Iterator<com.bytedance.retrofit2.b.b> r3 = r1.iterator();     // Catch: Throwable -> L108
    L46:
        if (r3.hasNext() == false) goto L49;
        com.bytedance.retrofit2.b.b r20 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        r19.b(r20.a(), r20.b());     // Catch: Throwable -> L108
        goto L46
    L49:
        if (Logger.debug() == false) goto L52;
        r19.b("fallback-reason", r.b(r13));     // Catch: Throwable -> L108
    L52:
        if (okhttp3.internal.e.f.c(r13.a()) == true) goto L54;
        ab.a r21 = r19.a(r13.a(), null);     // Catch: Throwable -> L108
    L56:
        if (r13.d() != null) goto L58;
    L62:
        r21.b(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L108
        Iterator<com.bytedance.retrofit2.b.b> r110 = r10.iterator();     // Catch: Throwable -> L108
    L65:
        if (r110.hasNext() == false) goto L76;
        com.bytedance.retrofit2.b.b r22 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r110.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        if (com.bytedance.common.utility.j.a(r22.a()) == true) goto L65;
        if (com.bytedance.common.utility.j.a(r22.b()) == true) goto L65;
        if (DownloadConstants.USER_AGENT.equals(r22.a()) == false) goto L74;
        r8 = r22.b();     // Catch: Throwable -> L108
    L74:
        r21.a(r22.a(), r22.b());     // Catch: Throwable -> L108
        goto L65
    L76:
        if (com.bytedance.common.utility.j.a(r8) == false) goto L81;
        r8 = com.bytedance.frameworks.baselib.network.http.g.l();     // Catch: Throwable -> L108
        if (com.bytedance.common.utility.j.a(r8) == true) goto L81;
        r8 = r8 + " " + r.h();     // Catch: Throwable -> L108
        r21.a(DownloadConstants.USER_AGENT, r8);     // Catch: Throwable -> L108
    L81:
        if (com.bytedance.common.utility.j.a(r8) == false) goto L117;
        r8 = r.b();     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r8) == true) goto L117;
        r21.a(DownloadConstants.USER_AGENT, r8);     // Catch: Throwable -> L108
    L117:
        r14.K.put("ua", r8);     // Catch: Exception -> L87 Throwable -> L108
    L89:
        if (r16 != null) goto L91;
    L100:
        ab r111 = r21.b();     // Catch: Throwable -> L108
        this.f8478b = r111;     // Catch: Throwable -> L108
        this.f8480d = this.f8477a.a(r111);     // Catch: Throwable -> L108
        r14.v = new URL(r18);     // Catch: Exception -> L103 Throwable -> L108
    L105:
        r14.f8138d.f9432b = r14.v;     // Catch: Throwable -> L108
        r14.f8138d.c(r2);
        return;
    L103:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L105
    L91:
        if (r16.isEmpty() == true) goto L100;
        Iterator r112 = r16.entrySet().iterator();     // Catch: Throwable -> L108
    L94:
        if (r112.hasNext() == false) goto L100;
        Map.Entry r113 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        String r23 = (String) ZeusTransformUtils.preCheckCast(r113.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r23) == true) goto L94;
        if (TextUtils.isEmpty(r114) == true) goto L94;
        r21.b(r23, r114);     // Catch: Throwable -> L108
        goto L94
    L87:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L89
    L58:
        if (r13.t() == true) goto L62;
        String r115 = r13.d().d();     // Catch: Throwable -> L108
        if (r115 == null) goto L62;
        r21.b("X-SS-STUB", r115);     // Catch: Throwable -> L108
        goto L62
    L54:
        r21 = r19.a(r13.a(), a(r13.d(), r13.e()));     // Catch: Throwable -> L108
        goto L56
    L111:
        r7 = a(r7, r13.a(), r1);     // Catch: Exception -> L39 Throwable -> L108
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L41
    L34:
        r9 = null;
    L108:
        th = move-exception;
        r14.f8138d.c(r2);
        throw th;
    }

    private static /* synthetic */ ab a(com.bytedance.frameworks.baselib.network.http.c.a r4, af r5, ad r6) {
        Iterator<okhttp3.h> r7 = r6.q().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        okhttp3.h r0 = (okhttp3.h) ZeusTransformUtils.preCheckCast(r7.next(), okhttp3.h.class, "com.obric.aiagent.plugin");
        if ("Basic".equalsIgnoreCase(r0.a()) == false) goto L4;
        String r8 = okhttp3.o.a(r4.f8192a, r4.f8193b, r0.c());
        if (TextUtils.equals(r8, r6.a().a("Proxy-Authorization")) == false) goto L12;
        return null;
    L12:
        return r6.a().h().a("Proxy-Authorization", r8).b();
    L13:
        return null;
    }

    private String a(String r12, String r13, List<com.bytedance.retrofit2.b.b> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().b() == true) goto L22;
        long r0 = System.currentTimeMillis();
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.e r16 = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().a(new com.bytedance.frameworks.baselib.network.http.ok3.impl.b.m(r12, r13, r15));
        long r2 = System.currentTimeMillis();
        if (r16 == null) goto L30;
        this.f8481e.a(this.f.a(), r16.f8444a, r2 - r0, false, r16.f8446c);
        if (r12.equals(r16.f8444a) == false) goto L9;
        return r12;
    L9:
        if (r16.f8444a.isEmpty() == false) goto L19;
        if (r16.f8445b.isEmpty() == true) goto L19;
        this.f8481e.a(r16.f8447d);
        StringBuilder r17 = new StringBuilder().append("ERR_TTNET_TRAFFIC_CONTROL_DROP");
        if (r16.f8447d != (-555)) goto L15;
        String r18 = "";
    L17:
        throw new Exception(r17.append(r18).append(", ").append(r16.f8447d).toString());
    L15:
        r18 = "_" + (-r16.f8447d);
    L19:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r16.f8444a) == true) goto L33;
        return r12;
    L33:
        return r16.f8444a;
    L30:
        return r12;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("Ok3SsCall", "fallback to host replace map");
    L24:
        long r19 = System.currentTimeMillis();
        String r1 = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().b(r12);
        long r3 = System.currentTimeMillis();
        if (r12.equals(r1) == false) goto L27;
        return r12;
    L27:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r1) == false) goto L35;
        this.f8481e.a(this.f.a(), r1, r3 - r19, true, null);
        return r1;
    L35:
        return r12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(com.bytedance.frameworks.baselib.network.http.b r3, com.bytedance.frameworks.baselib.network.http.d.c r4) {
        super.a(r3, (com.bytedance.frameworks.baselib.network.http.d.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.frameworks.baselib.network.http.d.c.class, "com.obric.aiagent.plugin"));
        if (r.c() == null) goto L6;
        r.c().a(this.f8478b, this.f8479c);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(com.bytedance.retrofit2.e.i r6) {
        com.bytedance.retrofit2.e.i r7 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.f.h() == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.e.g.class) == false) goto L17;
        this.g.f8138d.aB();
        com.bytedance.frameworks.baselib.network.http.h.b.a().a(this.f8479c, this.f.b(), ((com.bytedance.retrofit2.e.g) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.e.g.class, "com.obric.aiagent.plugin")).i());     // Catch: Throwable -> L12
    L10:
        this.g.f8138d.aC();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void b(Exception r2) {
        if (r.c() == null) goto L6;
        r.c().a(this.f8478b, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public IOException a(Exception r9) {
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.retrofit2.f.c.class) == false) goto L6;
        ((com.bytedance.retrofit2.f.c) ZeusTransformUtils.preCheckCast(r9, com.bytedance.retrofit2.f.c.class, "com.obric.aiagent.plugin")).a(false, true, this.f.b(), this.g.P, this.g);
        return (com.bytedance.retrofit2.f.c) ZeusTransformUtils.preCheckCast(r9, com.bytedance.retrofit2.f.c.class, "com.obric.aiagent.plugin");
    L6:
        com.bytedance.retrofit2.f.c r6 = new com.bytedance.retrofit2.f.c(r9.getMessage(), r9);
        r6.a(false, true, this.f.b(), this.g.P, this.g);
        return r6;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public int a(IOException r1) {
        return TTNetUtils.convertExceptionToErrorCode(r1);
    }

    @Override // com.bytedance.retrofit2.b.e
    public void n() {
        okhttp3.e r0 = this.f8480d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() == true) goto L10;
        this.f8481e.a();
        this.f8480d.c();
        this.i = true;
        return;
    }

    private static ac a(com.bytedance.retrofit2.e.j r2, ac r3) {
        final com.bytedance.retrofit2.e.j r4 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        if (r4 == null) goto L7;
        final x r5 = x.c(r4.b());
        return new AnonymousClass1(r5, r4);
    L7:
        return ac.a(null, "body=null");
    }
}
