package com.bytedance.apm6.cpu.c.a;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NormalCpuExceptionPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm6.service.d.b implements com.bytedance.apm6.cpu.c.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.apm6.cpu.c.d f5247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.service.d.a f5248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.cpu.c.g f5249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm6.cpu.c.g f5250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm6.cpu.c.g f5251e;
    private com.bytedance.apm6.cpu.c.g f;
    private com.bytedance.apm6.cpu.c.g g;

    public d() {
        this.f5248b = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        this.f5247a = new com.bytedance.apm6.cpu.c.d(this.f5248b);
        this.f5249c = new f(this.f5247a);
        this.f5250d = new g(this.f5247a);
        this.f5251e = new h(this.f5247a);
        this.f = new c(this.f5247a);
        this.g = new e(this.f5247a);
        this.f5247a.a(this.f5249c, this.f5250d, this.f5251e, this.f, this.g);
        this.f5248b.register(this);
    }

    @Override // com.bytedance.apm6.cpu.c.f
    public void a(com.bytedance.apm6.cpu.b.c r1) {
        this.f5247a.a(r1);
    }

    @Override // com.bytedance.apm6.cpu.c.f
    public void a() {
        this.f5247a.a();
    }

    @Override // com.bytedance.apm6.service.d.b, com.bytedance.apm6.service.d.c
    public void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.f5247a.a(false);
    }

    @Override // com.bytedance.apm6.service.d.b, com.bytedance.apm6.service.d.c
    public void b(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.f5247a.a(true);
    }
}
