package com.obric.event.task.base.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TMLog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f32687b;

    static {
        f32686a = new e();
    }

    private e() {
    }

    private final d a() {
        d r2 = f32687b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (d) ZeusTransformUtils.preCheckCast(c.f32685a, d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.event.task.base.b.d
    public void a(String r2, String r3) {
        o.e(r2, "tag");
        a().a(r2, r3);
    }

    @Override // com.obric.event.task.base.b.d
    public void c(String r2, String r3) {
        o.e(r2, "tag");
        a().c(r2, r3);
    }

    @Override // com.obric.event.task.base.b.d
    public void d(String r2, String r3) {
        o.e(r2, "tag");
        a().d(r2, r3);
    }

    @Override // com.obric.event.task.base.b.d
    public void b(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        a().b(r2, r3, r4);
    }

    @Override // com.obric.event.task.base.b.d
    public void b(String r2, String r3) {
        o.e(r2, "tag");
        a().b(r2, r3);
    }

    @Override // com.obric.event.task.base.b.d
    public void a(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        a().a(r2, r3, r4);
    }
}
