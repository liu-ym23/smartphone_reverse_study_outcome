package com.obric.autogui.agents.a.a.a;

import android.graphics.PointF;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: ActionEffectActionHandlerFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
final class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f26180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.obric.autogui.agents.a.d.e f26181b;

    /* JADX INFO: compiled from: ActionEffectActionHandlerFactory.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26180a = new a(null);
    }

    public g() {
        super(com.obric.autogui.operator.b.EnumC0777b.f29870b);
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public com.obric.autogui.agents.a.a.a.a b() {
        return (com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast(new f(this.f26181b), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public Object a(d r4, com.obric.autogui.operator.e.C0780e r5, com.obric.autogui.operator.b r6, d.c.d<? super x> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5.a() != com.obric.autogui.operator.b.EnumC0777b.f29870b) goto L5;
        com.obric.autogui.operator.b.a r10 = r5.b();
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autogui.operator.a.b.b.a.class) == false) goto L9;
        com.obric.autogui.operator.a.b.b.a r11 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
    L10:
        if (r11 == null) goto L53;
        com.obric.autogui.operator.a.a.e r12 = r11.b();
        if (r12 == null) goto L53;
        com.obric.autogui.operator.a.a.f r13 = r12.a();
        if (r13 == null) goto L53;
        PointF r14 = AODeviceSpecificTools.INSTANCE.normaliseOperatingSpacePosition(new PointF(r13.a(), r13.b()));
        if (r14 == null) goto L18;
        float r15 = r14.x;
        boolean r16 = true;
        if (Float.isInfinite(r15) == false) goto L22;
    L24:
        boolean r17 = false;
    L25:
        if (r17 == false) goto L51;
        float r18 = r14.y;
        if (Float.isInfinite(r18) == false) goto L29;
    L31:
        boolean r19 = false;
    L32:
        if (r19 == false) goto L51;
        float r20 = r14.x;
        if (0.0f <= r20) goto L36;
    L38:
        boolean r21 = false;
    L39:
        if (r21 == false) goto L51;
        float r22 = r14.y;
        if (0.0f <= r22) goto L43;
    L45:
        r16 = false;
    L46:
        if (r16 == false) goto L51;
        float r1 = 1000;
        this.f26181b = new com.obric.autogui.agents.a.d.e(d.l.n.a(d.i.a.a(r14.x * r1), 0, 1000), d.l.n.a(d.i.a.a(r14.y * r1), 0, 1000));
        return x.f38692a;
    L43:
        if (r22 > 1.0f) goto L45;
    L36:
        if (r20 > 1.0f) goto L38;
        r21 = true;
        goto L39
    L29:
        if (Float.isNaN(r18) == true) goto L31;
        r19 = true;
    L51:
        return x.f38692a;
    L22:
        if (Float.isNaN(r15) == true) goto L24;
        r17 = true;
        goto L25
    L18:
        return x.f38692a;
    L53:
        return x.f38692a;
    L9:
        r11 = null;
        goto L10
    L5:
        return x.f38692a;
    }
}
