package com.obric.oui.bouncelayout;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: BounceTranslationDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<Float> f34155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<BounceEdgeEffect[]> f34156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f34157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<Float, x> f34158d;

    /* JADX INFO: compiled from: BounceTranslationDelegate.kt */
    static final class a extends p implements d.h.a.b<Float, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f34159a;

        a(f r1) {
            this.f34159a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return x.f38692a;
        }

        public final void a(float r3) {
            g r4 = f.a(this.f34159a);
            if (r4 == null) goto L7;
            r4.a(((Number) ZeusTransformUtils.preCheckCast(f.b(this.f34159a).invoke(), Number.class, "com.obric.aiagent.plugin")).floatValue());
            return;
        }
    }

    public f(d.h.a.a<Float> r3, d.h.a.a<BounceEdgeEffect[]> r4) {
        d.h.a.a<Float> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<BounceEdgeEffect[]> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "getTotalTranslation");
        o.e(r6, "effectsProvider");
        this.f34155a = r5;
        this.f34156b = r6;
        this.f34158d = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ g a(f r0) {
        return r0.f34157c;
    }

    public static final /* synthetic */ d.h.a.a b(f r0) {
        return r0.f34155a;
    }

    public final void a(g r3) {
        this.f34157c = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        a();
    }

    public final void a() {
        BounceEdgeEffect[] r0 = (BounceEdgeEffect[]) ZeusTransformUtils.preCheckCast(this.f34156b.invoke(), BounceEdgeEffect[].class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (this.f34157c != null) goto L11;
        int r5 = r0.length;
    L5:
        if (r2 >= r5) goto L10;
        BounceEdgeEffect r1 = r0[r2];
        r2 = r2 + 1;
        if (r1 == null) goto L5;
        r1.setOnTranslationChanged(null);
        goto L5
    L10:
        return;
    L11:
        int r3 = r0.length;
    L12:
        if (r2 >= r3) goto L17;
        BounceEdgeEffect r4 = r0[r2];
        r2 = r2 + 1;
        if (r4 == null) goto L12;
        r4.setOnTranslationChanged(this.f34158d);
        goto L12
    }
}
