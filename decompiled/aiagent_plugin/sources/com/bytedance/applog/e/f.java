package com.bytedance.applog.e;

import android.content.Context;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.log.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SamplingFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.sampling.c f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Engine f5581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.bytedance.applog.sampling.b f5582c;

    static /* synthetic */ Engine a(f r0) {
        return r0.f5581b;
    }

    public f(final Engine r2, final com.bytedance.applog.sampling.c r3) {
        this.f5582c = null;
        this.f5581b = r2;
        this.f5580a = r3;
        if (l.a() == true) goto L6;
        l.a("sampling_config", new AnonymousClass1(this, r2, r3));
        return;
    }

    public com.bytedance.applog.sampling.c b() {
        return this.f5580a;
    }

    @Override // com.bytedance.applog.e.e
    public boolean a(com.bytedance.applog.monitor.b r2, String r3, String r4) {
        if (com.bytedance.applog.monitor.b.f5759c.equals(r2) == true) goto L9;
        if (com.bytedance.applog.monitor.b.f5760d.equals(r2) == true) goto L9;
        return false;
    L9:
        return this.f5580a.a(c(), r3, r4);
    }

    @Override // com.bytedance.applog.e.e
    public boolean a() {
        return !this.f5580a.e();
    }

    public boolean a(String r2, JSONObject r3) {
        return this.f5580a.b(c(), r2, r3);
    }

    public static f a(Engine r4, String r5) {
        return new f(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5));
    }

    public static f a(Engine r4, JSONObject r5, f r6, String r7) {
        if (r5 != null) goto L5;
        return r6;
    L5:
        if (r6 != null) goto L9;
        return new f(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5, null));
    L9:
        return new f(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5, r6.b()));
    }

    private com.bytedance.applog.sampling.b c() {
        if (this.f5582c != null) goto L5;
        this.f5582c = new AnonymousClass2(this);
        return this.f5582c;
    L5:
        return this.f5582c;
    }
}
