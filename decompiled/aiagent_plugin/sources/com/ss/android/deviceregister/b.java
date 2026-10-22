package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BdtrackerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements n {
    private static final String TAG = "BdWrapperImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f37345a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f37346b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f37347c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.ss.android.common.a f37348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f37349e;
    private volatile String f;
    private volatile boolean g;

    static {
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Context r1, String r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Context r1, boolean r2, boolean r3, boolean r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Bundle r1) {
    }

    @Override // com.ss.android.deviceregister.n
    public void a(com.ss.android.deviceregister.base.j r2) {
        com.ss.android.deviceregister.base.j r1 = (com.ss.android.deviceregister.base.j) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.base.j.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.deviceregister.n
    public void a(String r1) {
    }

    @Override // com.ss.android.deviceregister.n
    public void a(boolean r1) {
    }

    @Override // com.ss.android.deviceregister.n
    public void c(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.deviceregister.n
    public void c(boolean r1) {
    }

    @Override // com.ss.android.deviceregister.n
    public void d() {
    }

    @Override // com.ss.android.deviceregister.n
    public void d(boolean r1) {
    }

    public b() {
        this.g = false;
    }

    @Override // com.ss.android.deviceregister.n
    public String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        String r0 = this.f;
        if (TextUtils.isEmpty(r0) == false) goto L8;
        if (this.f37348d == null) goto L8;
        r0 = this.f37348d.d();
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");     // Catch: Throwable -> L11
        this.f = r0;     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        com.ss.android.common.util.e.d("BdWrapperImpl getChannel", th);
        return r0;
    L16:
        return r0;
    }

    @Override // com.ss.android.deviceregister.n
    public String a() {
        return com.bytedance.applog.a.d();
    }

    @Override // com.ss.android.deviceregister.n
    public String b() {
        String r1 = com.bytedance.applog.a.c();
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    @Override // com.ss.android.deviceregister.n
    public String c() {
        return com.bytedance.bdinstall.j.o.a();
    }

    @Override // com.ss.android.deviceregister.n
    public boolean e() {
        return this.g;
    }

    @Override // com.ss.android.deviceregister.n
    public void b(boolean r1) {
        f37345a = r1;
    }

    @Override // com.ss.android.deviceregister.n
    public boolean b(Context r2) {
        return com.bytedance.applog.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.n
    public void a(g.a r3) {
        final g.a r4 = (g.a) ZeusTransformUtils.wrapperContextForParams(r3, g.a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        com.bytedance.applog.a.a(new AnonymousClass1(this, r4));
    }

    @Override // com.ss.android.deviceregister.n
    public void a(Map<String, String> r2, Context r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        com.bytedance.applog.a.a(r1);
        String r5 = com.bytedance.applog.a.e();
        if (r5 == null) goto L9;
        r1.put("user_id", r5);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.deviceregister.n
    public boolean a(Context r1, JSONObject r2, boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        JSONObject r4 = com.bytedance.applog.a.f();
        if (r4 == null) goto L6;
        ba.a(r2, r4);
        return true;
    L6:
        return false;
    }

    @Override // com.ss.android.deviceregister.n
    public int f() {
        int r0 = this.f37349e;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        if (this.f37348d != null) goto L7;
        return r0;
    L7:
        return this.f37348d.i();
    }

    @Override // com.ss.android.deviceregister.n
    public void b(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.a.a(r3);
    }

    @Override // com.ss.android.deviceregister.n
    public boolean g() {
        if (com.bytedance.bdinstall.i.d() != null) goto L7;
        return false;
    L7:
        return com.bytedance.bdinstall.i.d().d();
    }

    @Override // com.ss.android.deviceregister.n
    public boolean e(boolean r1) {
        com.bytedance.applog.a.a(r1);
        return true;
    }

    @Override // com.ss.android.deviceregister.n
    public void a(boolean r4, long r5, t r7) {
        final t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.applog.a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5, new AnonymousClass2(this, r8));
    }
}
