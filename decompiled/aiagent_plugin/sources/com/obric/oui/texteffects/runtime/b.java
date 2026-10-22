package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.texteffects.a.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.k;
import d.l.n;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f36452a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f36454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Float> f36455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f36456e;
    private final float f;
    private final float g;

    /* JADX INFO: renamed from: com.obric.oui.texteffects.runtime.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
    static final class AnonymousClass1 extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f36457a;

        AnonymousClass1(View r1) {
            this.f36457a = r1;
            super(0);
        }

        public final Float a() {
            Integer r0 = Integer.valueOf(this.f36457a.getWidth());
            if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
            boolean r1 = true;
        L6:
            Float r2 = null;
            if (r1 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L13;
            r2 = Float.valueOf(r0.intValue());
        L13:
            if (r2 != null) goto L15;
            float r3 = this.f36457a.getMeasuredWidth();
        L17:
            return Float.valueOf(r3);
        L15:
            r3 = r2.floatValue();
            goto L17
        L5:
            r1 = false;
            goto L6
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f36452a = new a(null);
    }

    public b(String r3, View r4, d.h.a.a<Float> r5, int r6, float r7) {
        d.h.a.a<Float> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "bindingKey");
        o.e(r4, "view");
        o.e(r8, "textWidthProvider");
        this.f36453b = r3;
        this.f36454c = r4;
        this.f36455d = r8;
        this.f36456e = r6;
        this.f = r7;
        this.g = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics().density;
    }

    public final String a() {
        return this.f36453b;
    }

    public final View b() {
        return this.f36454c;
    }

    public /* synthetic */ b(String r7, View r8, d.h.a.a r9, int r10, float r11, int r12, h r13) {
        d.h.a.a r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r14 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8), d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d.h.a.a r3 = r14;
        if ((r12 & 8) == 0) goto L8;
        r10 = 4;
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = 248.0f;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    public final void c() {
        this.f36454c.setVisibility(this.f36456e);
        View r2 = this.f36454c;
        r2.setTranslationX(-r2.getMeasuredWidth());
    }

    public final void a(c r4, float r5) {
        o.e(r4, "frame");
        g r0 = r4.g();
        if (r0 == null) goto L6;
        b().setTranslationX(a(r0, r5));
    L6:
        g r1 = r4.h();
        if (r1 == null) goto L11;
        b().setTranslationY(a(r1, r5));
    L11:
        if (Float.isNaN(r4.d()) == true) goto L13;
        this.f36454c.setAlpha(n.a(r4.d(), 0.0f, 1.0f));
    L13:
        View r6 = this.f36454c;
        Float r7 = r4.j();
        int r2 = 0;
        if (r7 != null) goto L17;
    L20:
        r6.setVisibility(r2);
        com.obric.oui.texteffects.a r8 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == true) goto L23;
        return;
    L23:
        if (com.obric.oui.texteffects.a.b() == false) goto L27;
        a(o.a("OUITextEffects/", "ExternalBinding"), "apply binding=" + a() + ", alpha=" + b().getAlpha() + ", visibility=" + b().getVisibility() + ", translationX=" + b().getTranslationX() + ", translationY=" + b().getTranslationY());
        return;
    L27:
        return;
    L17:
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue() > 0.001f) goto L20;
        r2 = this.f36456e;
        goto L20
    }

    private final float a(g r5, float r6) {
        if (ZeusTransformUtils.instanceOf(r5, g.b.class) == false) goto L6;
        return ((g.b) ZeusTransformUtils.preCheckCast(r5, g.b.class, "com.obric.aiagent.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.a.class) == false) goto L9;
        float r7 = ((g.a) ZeusTransformUtils.preCheckCast(r5, g.a.class, "com.obric.aiagent.plugin")).a();
        return this.g * r7;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, g.e.class) == false) goto L13;
        float r8 = ((g.e) ZeusTransformUtils.preCheckCast(r5, g.e.class, "com.obric.aiagent.plugin")).a();
        float r4 = this.g;
    L26:
        return r6 + (r8 * r4);
    L13:
        if (ZeusTransformUtils.instanceOf(r5, g.d.class) == false) goto L16;
        r6 = -d();
        r8 = ((g.d) ZeusTransformUtils.preCheckCast(r5, g.d.class, "com.obric.aiagent.plugin")).a();
        r4 = this.g;
        goto L26
    L16:
        if (ZeusTransformUtils.instanceOf(r5, g.f.class) == false) goto L19;
        return n.a(((Number) ZeusTransformUtils.preCheckCast(this.f36455d.invoke(), Number.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f) * ((g.f) ZeusTransformUtils.preCheckCast(r5, g.f.class, "com.obric.aiagent.plugin")).a();
    L19:
        if (ZeusTransformUtils.instanceOf(r5, g.c.class) == false) goto L23;
        float r0 = a(((g.c) ZeusTransformUtils.preCheckCast(r5, g.c.class, "com.obric.aiagent.plugin")).a(), r6);
        return ((a(((g.c) ZeusTransformUtils.preCheckCast(r5, g.c.class, "com.obric.aiagent.plugin")).b(), r6) - r0) * n.a(((g.c) ZeusTransformUtils.preCheckCast(r5, g.c.class, "com.obric.aiagent.plugin")).c(), 0.0f, 1.0f)) + r0;
    L23:
        throw new k();
    }

    private final float d() {
        Integer r0 = Integer.valueOf(this.f36454c.getMeasuredWidth());
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
        Integer r3 = Integer.valueOf(b().getWidth());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        int r6 = 0;
    L13:
        if (r1 > r6) goto L16;
        r5 = false;
    L16:
        if (r5 == true) goto L19;
        r0 = null;
    L19:
        if (r0 != null) goto L21;
        int r2 = this.f36454c.getWidth();
    L22:
        if (r2 <= 0) goto L25;
        return r2;
    L25:
        return ZeusTransformUtils.getResources(this.f36454c, "com.obric.aiagent.plugin").getDisplayMetrics().density * this.f;
    L21:
        r2 = r0.intValue();
        goto L22
    L12:
        r6 = r3.intValue();
        goto L13
    L5:
        r4 = false;
        goto L7
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
