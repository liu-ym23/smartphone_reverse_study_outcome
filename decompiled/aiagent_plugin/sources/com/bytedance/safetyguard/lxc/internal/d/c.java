package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f10186b;

    static {
        f10185a = new c();
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public String a(String r1) {
        return this.f10186b.a(r1);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r2, String r3) {
        d.h.b.o.e(r2, "tag");
        d.h.b.o.e(r3, "message");
        this.f10186b.a(r2, r3);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r2, String r3, Throwable r4) {
        d.h.b.o.e(r2, "tag");
        d.h.b.o.e(r3, "message");
        this.f10186b.a(r2, r3, r4);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r2, String r3) {
        d.h.b.o.e(r2, "tag");
        d.h.b.o.e(r3, "message");
        this.f10186b.b(r2, r3);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r2, String r3, Throwable r4) {
        d.h.b.o.e(r2, "tag");
        d.h.b.o.e(r3, "message");
        this.f10186b.b(r2, r3, r4);
    }

    private c() {
        this.f10186b = new ad((com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.a.f9703a.a(), com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"));
    }
}
