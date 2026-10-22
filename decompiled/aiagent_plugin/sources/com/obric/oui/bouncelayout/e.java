package com.obric.oui.bouncelayout;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: BounceOverscrollDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<Integer> f34152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<BounceEdgeEffect[]> f34153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f34154c;

    public e(d.h.a.a<Integer> r3, d.h.a.a<BounceEdgeEffect[]> r4) {
        d.h.a.a<Integer> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<BounceEdgeEffect[]> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "sizePxProvider");
        o.e(r6, "effectsProvider");
        this.f34152a = r5;
        this.f34153b = r6;
    }

    public final float a() {
        return this.f34154c;
    }

    public final void b() {
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f34152a.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r0 <= 0) goto L5;
        a(r0);
        return;
    L5:
        c();
    }

    public final void a(float r2) {
        this.f34154c = n.a(r2, 0.0f);
        c();
    }

    public final void c() {
        BounceEdgeEffect[] r0 = (BounceEdgeEffect[]) ZeusTransformUtils.preCheckCast(this.f34153b.invoke(), BounceEdgeEffect[].class, "com.obric.aiagent.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BounceEdgeEffect r3 = r0[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L3;
        r3.setMaxOverscrollPx(this.f34154c);
        goto L3
    }
}
