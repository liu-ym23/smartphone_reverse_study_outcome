package com.bytedance.watson.assist.b;

import android.content.Context;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AssistStatImp.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f11814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f11815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.watson.assist.b.b.a f11816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.watson.assist.b.d.a f11817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.watson.assist.b.c.b f11818e;
    private com.bytedance.watson.assist.b.a.a f;
    private com.bytedance.watson.assist.a.a g;

    static {
    }

    private a(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), com.bytedance.watson.assist.a.a.f11794a);
    }

    private a(Context r3, com.bytedance.watson.assist.a.a r4) {
        this.f11815b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        com.bytedance.watson.assist.a.a r5 = com.bytedance.watson.assist.a.a.f11794a;
    L6:
        this.g = r5;
        this.f11816c = new com.bytedance.watson.assist.b.b.a(this.f11815b, this);
        this.f11817d = new com.bytedance.watson.assist.b.d.a(this.f11815b, this);
        this.f11818e = new com.bytedance.watson.assist.b.c.b(this.f11815b, this);
        this.f = new com.bytedance.watson.assist.b.a.a(this);
        com.bytedance.watson.assist.d.b.b("new assist obj:" + this + " config : " + r4);
        return;
    L5:
        r5 = r4;
        goto L6
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f11814a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11814a != null) goto L9;
        f11814a = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f11814a;
    }

    @Override // com.bytedance.watson.assist.a.c
    public c b() {
        com.bytedance.watson.assist.d.b.a("start, obj:" + this);
        this.f11816c.a();
        this.f11817d.a();
        this.f11818e.a();
        return this;
    }

    @Override // com.bytedance.watson.assist.a.c
    public com.bytedance.watson.assist.a.a a() {
        return this.g;
    }

    public String j() {
        return com.bytedance.watson.assist.d.a.c();
    }

    public List<List<Integer>> k() {
        return this.f11818e.d();
    }

    @Override // com.bytedance.watson.assist.a.c
    public c.b g() {
        return this.f11818e.e();
    }

    public boolean l() {
        return this.f11816c.b();
    }

    @Override // com.bytedance.watson.assist.a.c
    public int c() {
        return this.f11816c.c();
    }

    @Override // com.bytedance.watson.assist.a.c
    public int d() {
        return this.f11816c.d();
    }

    @Override // com.bytedance.watson.assist.a.c
    public float e() {
        return this.f11816c.e();
    }

    public int m() {
        return this.f11817d.b();
    }

    @Override // com.bytedance.watson.assist.a.c
    public void f() {
        this.f11818e.c();
    }

    @Override // com.bytedance.watson.assist.a.c
    public boolean h() {
        return this.f.a();
    }

    @Override // com.bytedance.watson.assist.a.c
    public boolean a(float r1) {
        return this.f.a(r1);
    }

    @Override // com.bytedance.watson.assist.a.c
    public c.a i() {
        c.a r0 = new c.a();
        r0.f11804a = j();
        r0.f11805b = l();
        r0.f11806c = d();
        r0.f11807d = m();
        r0.f11808e = c();
        r0.f = e();
        r0.g = k();
        return r0;
    }
}
