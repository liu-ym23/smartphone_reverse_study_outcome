package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.intent.j;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OpClickUI.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.operator.a.a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.b f29530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IScreenshot f29531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29532e;
    private Integer f;
    private Integer g;
    private com.obric.autogui.agents.vlm.models.a.a.b h;

    /* JADX INFO: compiled from: OpClickUI.kt */
    public static final class a extends com.obric.autogui.operator.a.a.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f29533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29534b;

        public a() {
            int r0 = 0;
            this(r0, r0, 3, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f29533a == r6.f29533a) goto L12;
            return false;
        L12:
            if (this.f29534b == r6.f29534b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f29533a) * 31) + Integer.hashCode(this.f29534b);
        }

        public String toString() {
            return "Input(longClickLengthMillis=" + this.f29533a + ", clickTimes=" + this.f29534b + ')';
        }

        public /* synthetic */ a(int r1, int r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 1;
        L8:
            this(r1, r2);
        }

        public final void a(int r1) {
            this.f29533a = r1;
        }

        public final int c() {
            return this.f29533a;
        }

        public final void b(int r1) {
            this.f29534b = r1;
        }

        public final int d() {
            return this.f29534b;
        }

        public a(int r9, int r10) {
            super(false, 0, 0, null, 15, null);
            this.f29533a = r9;
            this.f29534b = r10;
        }
    }

    public b() {
        this.f29529b = "ClickUI";
        this.f29530c = new com.obric.autogui.operator.a.c.b(c(), p.b(new com.obric.autogui.operator.a.c.c[]{new com.obric.autogui.operator.a.c.a.a(AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.click.activity_change.enable", false)), new com.obric.autogui.operator.a.c.a.a.c(), new com.obric.autogui.operator.a.c.a.a.b(), new com.obric.autogui.operator.a.c.a.a.a()}));
        this.f29532e = "";
    }

    @Override // com.obric.autogui.operator.a.a.c
    public String c() {
        return this.f29529b;
    }

    @Override // com.obric.autogui.operator.b
    public com.obric.autogui.operator.a.c.b a() {
        return this.f29530c;
    }

    @Override // com.obric.autogui.operator.a.a.c, com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L7;
        return false;
    L7:
        return super.b(r4);
    }

    @Override // com.obric.autogui.operator.a.a.c
    public Object a(Context r5, com.obric.autogui.operator.a.a.d r6, d.c.d<? super com.obric.autogui.common.e> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.a.c.a r10 = d();
        o.a(r10, "null cannot be cast to non-null type com.obric.autogui.operator.impl.op.OpClickUI.Input");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(c(), "performing click on: " + r6 + ", longClickIntv=" + r11.c());
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(c(), "ClickUI needs an ongoing session to be runnable.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L6:
        InjectEventContext.Context r4 = a(r0, r11);
        if (r11.c() <= 0) goto L11;
        return r6.a(r11.c(), r4, r9);
    L11:
        if (r11.d() <= 1) goto L15;
        return r6.b(r11.d(), r4, r9);
    L15:
        return r6.a(r4, r9);
    }

    private final InjectEventContext.Context a(com.obric.autogui.session.a r14, a r15) {
        String r1 = null;
        if (com.obric.autogui.common.a.h.f28984a.b() == true) goto L6;
        return null;
    L6:
        if (r14.c() == true) goto L8;
        return null;
    L8:
        r r0 = t.f28523a.a(r14.b());
        if (r0 == null) goto L38;
        l r2 = r0.e();
        if (r2 == null) goto L38;
        com.obric.autogui.agents.vlm.models.omni.intent.g r3 = r2.a();
        if (r3 == null) goto L38;
        j r4 = r3.c();
        if (r4 == null) goto L19;
        String r5 = r4.a();
        if (r5 == null) goto L19;
    L20:
        String r8 = r5;
        if (com.obric.autogui.common.a.h.f28984a.a(r8) == true) goto L23;
        return null;
    L23:
        String r16 = r3.g();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L26;
        String r7 = r16;
    L27:
        if (r7 != null) goto L29;
        return null;
    L29:
        String r6 = r14.b();
        String r9 = this.f29532e;
        Integer r10 = a(r9);
        if (r10 == null) goto L32;
        int r11 = r10.intValue();
    L33:
        Integer r12 = Integer.valueOf(r11);
        Integer r13 = this.f;
        Integer r17 = this.g;
        File r18 = r14.y().b();
        if (r18 == null) goto L37;
        r1 = r18.getAbsolutePath();
    L37:
        return new InjectEventContext.Context(r6, r9, r12, r7, r8, r13, r17, r1, true);
    L32:
        r11 = r14.s();
        goto L33
    L26:
        r7 = null;
    L19:
        r5 = a(r15);
    L38:
        return null;
    }

    private final String a(a r1) {
        if (r1.c() <= 0) goto L6;
        return "long_press";
    L6:
        if (r1.d() <= 1) goto L8;
        return "double_click";
    L8:
        return "click";
    }

    private final Integer a(String r2) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return null;
    L7:
        return d.o.o.d(d.o.o.a(r2, '_', ""));
    }

    @Override // com.obric.autogui.operator.b
    public void a(com.obric.autogui.operator.e r5) {
        o.e(r5, "step");
        super.a(r5);
        this.f29532e = r5.W();
        Integer r0 = Integer.valueOf(r5.O());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (Boolean.valueOf(r1).booleanValue() == true) goto L10;
        r0 = null;
    L10:
        this.g = r0;
        if (r0 == null) goto L13;
        ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
        Integer r2 = Integer.valueOf(r5.N());
    L14:
        this.f = r2;
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L17;
        this.h = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).n();
    L17:
        this.f29531d = null;
        return;
    L13:
        r2 = null;
        goto L14
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.obric.autogui.operator.b
    public void b(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.b(r2);
        this.f = null;
        this.g = null;
        IScreenshot r0 = this.f29531d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.f29531d = null;
    }
}
