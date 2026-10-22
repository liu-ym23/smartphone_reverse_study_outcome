package com.bytedance.bdturing.setting;

import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6595a;

    @Override // com.bytedance.bdturing.setting.a
    public String a() {
        return this.f6595a.a();
    }

    @Override // com.bytedance.bdturing.setting.a
    public f b() {
        return this.f6595a.b();
    }

    @Override // com.bytedance.bdturing.setting.a
    public com.bytedance.bdturing.ttnet.b c() {
        return this.f6595a.c();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String d() {
        return this.f6595a.d();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String e() {
        return this.f6595a.e();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String f() {
        return this.f6595a.f();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String g() {
        return this.f6595a.g();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String h() {
        return this.f6595a.h();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String i() {
        return this.f6595a.i();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String j() {
        return this.f6595a.j();
    }

    @Override // com.bytedance.bdturing.setting.a
    public String k() {
        return this.f6595a.k();
    }

    @Override // com.bytedance.bdturing.setting.a
    public Looper m() {
        return this.f6595a.m();
    }

    public b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.d(r4, "configProvider");
        this.f6595a = r4;
    }

    @Override // com.bytedance.bdturing.setting.a
    public String l() {
        String r2 = this.f6595a.l();
        if (o.a(r2, e.f6601a.a()) == false) goto L6;
    L19:
        return r2;
    L6:
        if (o.a(r2, e.f6602b.a()) == true) goto L19;
        if (o.a(r2, e.f6603c.a()) == true) goto L19;
        if (o.a(r2, e.f6604d.a()) == true) goto L19;
        if (o.a(r2, e.f6605e.a()) == true) goto L19;
        if (com.bytedance.bdturing.g.a() == false) goto L19;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("not support this region"), Throwable.class, "com.obric.aiagent.plugin"));
    }
}
