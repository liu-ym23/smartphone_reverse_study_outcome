package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.load.engine.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.bumptech.glide.f.g<com.bumptech.glide.load.g, v<?>> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h.a f3573a;

    @Override // com.bumptech.glide.f.g
    public /* synthetic */ int a(v<?> r3) {
        return a2((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.b.h
    public /* synthetic */ v a(com.bumptech.glide.load.g r3) {
        return (v) ZeusTransformUtils.preCheckCast(super.c((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.f.g
    public /* synthetic */ void a(com.bumptech.glide.load.g r3, v<?> r4) {
        a2((com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin"), (v) ZeusTransformUtils.preCheckCast(r4, v.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.b.h
    public /* synthetic */ v b(com.bumptech.glide.load.g r3, v r4) {
        return (v) ZeusTransformUtils.preCheckCast(super.b((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin"), (v) ZeusTransformUtils.wrapperContextForParams(r4, v.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin");
    }

    public g(long r1) {
        super(r1);
    }

    @Override // com.bumptech.glide.load.engine.b.h
    public void a(h.a r3) {
        this.f3573a = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.bumptech.glide.load.g r3, v<?> r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        v<?> r6 = (v) ZeusTransformUtils.wrapperContextForParams(r4, v.class, "com.obric.aiagent.plugin");
        h.a r2 = this.f3573a;
        if (r2 == null) goto L7;
        if (r6 == null) goto L8;
        r2.b(r6);
        return;
    L8:
        return;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(v<?> r3) {
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return super.a(null);
    L7:
        return r4.e();
    }

    @Override // com.bumptech.glide.load.engine.b.h
    public void a(int r5) {
        if (r5 < 40) goto L6;
        c();
        return;
    L6:
        if (r5 < 20) goto L8;
    L9:
        a(b() / 2);
        return;
    L8:
        if (r5 == 15) goto L9;
    }
}
