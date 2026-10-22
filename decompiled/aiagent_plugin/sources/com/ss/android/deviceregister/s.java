package com.ss.android.deviceregister;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: OldImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class s implements n {
    private static final String TAG = "OldImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f37448c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f37449d = null;
    private static volatile boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.deviceregister.a.d f37450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37451b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37452e;

    public s() {
        this.f37452e = false;
    }

    static {
        f37448c = new Object();
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Context r1, boolean r2, boolean r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        if (com.ss.android.deviceregister.base.v.h() == false) goto L5;
        r.a(r5);
    L5:
        com.ss.android.deviceregister.base.f.a(r5);
        this.f37450a = new com.ss.android.deviceregister.a.d(r5, r3);
        com.ss.android.deviceregister.a.a.a(this.f37451b);
        com.ss.android.deviceregister.base.v.a(this.f37450a);
    }

    @Override // com.ss.android.deviceregister.n
    public void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f37450a.e();
        com.ss.android.deviceregister.a.c.b(r4);
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.f37450a == null) goto L5;
        Object r2 = h.a(r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a(r5, r4);
    L9:
        com.ss.android.deviceregister.base.b.a(r5).edit().remove("device_token").commit();
        return;
    L5:
        r2 = new e(r5, g.k());
        goto L7
    }

    @Override // com.ss.android.deviceregister.n
    public void a(boolean r1) {
        this.f37451b = r1;
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L9;
        com.ss.android.deviceregister.a.e.a(r1);
        return;
    }

    @Override // com.ss.android.deviceregister.n
    public String a() {
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 == null) goto L7;
        String r3 = r2.h();
        if (Logger.debug() == false) goto L9;
        com.ss.android.common.util.e.b("OldImpl getInstallId() called,return value : " + r3);
        return r3;
    L9:
        return r3;
    L7:
        return "";
    }

    @Override // com.ss.android.deviceregister.n
    public String b() {
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 == null) goto L5;
        String r3 = r2.g();
    L7:
        if (Logger.debug() == false) goto L9;
        com.ss.android.common.util.e.b("OldImpl getDeviceId() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }

    public String h() {
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 == null) goto L5;
        String r3 = r2.i();
    L7:
        if (Logger.debug() == false) goto L9;
        com.ss.android.common.util.e.b("OldImpl getOpenUdId() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }

    public String i() {
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 == null) goto L5;
        String r3 = r2.k();
    L7:
        if (Logger.debug() == false) goto L9;
        com.ss.android.common.util.e.b("OldImpl getClientUDID() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }

    @Override // com.ss.android.deviceregister.n
    public String c() {
        if (TextUtils.isEmpty(f37449d) == false) goto L15;
        Object r1 = f37448c;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f37449d) == false) goto L9;
        f37449d = UUID.randomUUID().toString();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L15:
        return f37449d;
    }

    @Override // com.ss.android.deviceregister.n
    public void d() {
        com.ss.android.deviceregister.a.d r0 = this.f37450a;
        if (r0 == null) goto L8;
        r0.f();
        if (Logger.debug() == false) goto L9;
        com.ss.android.common.util.e.b("OldImpl updateDeviceInfo call  device_register");
        return;
    L9:
        return;
    }

    @Override // com.ss.android.deviceregister.n
    public void a(com.ss.android.deviceregister.base.j r2) {
        com.ss.android.deviceregister.a.e.a((com.ss.android.deviceregister.base.j) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.base.j.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.n
    public boolean e() {
        return this.f37452e;
    }

    @Override // com.ss.android.deviceregister.n
    public void b(boolean r1) {
        com.ss.android.deviceregister.base.b.a(r1);
    }

    @Override // com.ss.android.deviceregister.n
    public void c(boolean r1) {
        com.ss.android.deviceregister.base.v.a(r1);
    }

    @Override // com.ss.android.deviceregister.n
    public boolean b(Context r2) {
        return h.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.n
    public void a(g.a r2) {
        com.ss.android.deviceregister.a.e.a((g.a) ZeusTransformUtils.wrapperContextForParams(r2, g.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Map<String, String> r10, Context r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L24;
        if (this.f37450a == null) goto L24;
        String r4 = h();
        if (r4 == null) goto L10;
        r12.put("openudid", r4);
    L10:
        String r2 = i();
        if (r2 == null) goto L13;
        r12.put("clientudid", r2);
    L13:
        String r3 = a();
        if (r3 == null) goto L16;
        r12.put("install_id", r3);
    L16:
        String r1 = b();
        if (r1 == null) goto L19;
        r12.put("device_id", r1);
    L19:
        String r9 = d(r13);
        if (TextUtils.isEmpty(r9) == true) goto L39;
        r12.put("klink_egdi", r9);
        return;
    L39:
        return;
    L24:
        if (this.f37450a != null) goto L40;
        if (r13 == null) goto L41;
        SharedPreferences r5 = r13.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);
        String r7 = r5.getString("device_id", "");
        if (TextUtils.isEmpty(r7) == true) goto L29;
        r12.put("device_id", r7);
    L29:
        String r6 = r5.getString("install_id", "");
        if (TextUtils.isEmpty(r6) == true) goto L32;
        r12.put("install_id", r6);
    L32:
        String r8 = r13.getSharedPreferences(com.ss.android.deviceregister.base.b.c(), 0).getString("openudid", null);
        if (TextUtils.isEmpty(r8) == true) goto L35;
        r12.put("openudid", r8);
    L35:
        String r14 = d(r13);
        if (TextUtils.isEmpty(r14) == true) goto L42;
        r12.put("klink_egdi", r14);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // com.ss.android.deviceregister.n
    public boolean a(Context r2, JSONObject r3, boolean r4) {
        return com.ss.android.deviceregister.base.v.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.ss.android.deviceregister.n
    public int f() {
        return com.ss.android.deviceregister.base.v.b();
    }

    @Override // com.ss.android.deviceregister.n
    public void b(Context r2, String r3) {
        com.ss.android.deviceregister.base.v.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.ss.android.deviceregister.n
    public void a(String r1) {
        com.ss.android.deviceregister.base.v.a(r1);
    }

    @Override // com.ss.android.deviceregister.n
    public String a(Context r2) {
        return com.ss.android.deviceregister.base.v.c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.n
    public void d(boolean r1) {
        f = r1;
    }

    @Override // com.ss.android.deviceregister.n
    public boolean g() {
        return f;
    }

    @Override // com.ss.android.deviceregister.n
    public boolean e(boolean r2) {
        f = r2;
        com.ss.android.deviceregister.a.d r1 = this.f37450a;
        if (r1 != null) goto L6;
        return false;
    L6:
        f37449d = null;
        r1.a(r2);
        return true;
    }

    @Override // com.ss.android.deviceregister.n
    public void a(boolean r3, long r4, t r6) {
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.aiagent.plugin");
        f = r3;
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(r3, r4, r7);
    }

    public String d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.ss.android.deviceregister.a.d r2 = this.f37450a;
        if (r2 != null) goto L7;
        return r4.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).getString("klink_egdi", "");
    L7:
        return r2.n();
    }
}
