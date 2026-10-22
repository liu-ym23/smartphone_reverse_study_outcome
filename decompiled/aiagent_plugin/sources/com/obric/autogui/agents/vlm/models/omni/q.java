package com.obric.autogui.agents.vlm.models.omni;

import com.google.gson.JsonObject;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: OmniRequestDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements com.obric.autogui.agents.vlm.models.impl.request.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autogui.agents.vlm.models.impl.d.C0690d f28458a;

    /* JADX INFO: compiled from: OmniRequestDelegate.kt */
    @d.c.b.a.f(b = "OmniRequestDelegate.kt", c = {68, 74}, d = "requestModel", e = "com.obric.autogui.agents.vlm.models.omni.OmniRequestDelegate")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28463e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        /* synthetic */ Object k;
        final /* synthetic */ q l;
        int m;

        a(q r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.k = r8;
            this.m |= Integer.MIN_VALUE;
            return this.l.a(null, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public q() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public void a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r2) {
        d.h.b.o.e(r2, "inferenceContext");
        this.f28458a = r2;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r21, String r22, String r23, int r24, JsonObject r25, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r26) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.m & Integer.MIN_VALUE) == 0) goto L7;
        r3.m -= Integer.MIN_VALUE;
    L8:
        a r12 = r3;
        Object r2 = r12.k;
        Object r4 = d.c.a.b.a();
        int r5 = r12.m;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.f28460b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r6 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r12.f28459a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L62:
        com.obric.autogui.agents.vlm.b.C0677b r13 = r6;
    L63:
        r13.b(false);
        return new o(r13, r0, 1800000);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.session.a r7 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r12.j, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.upload.b.c r8 = (com.obric.autogui.agents.vlm.models.omni.upload.b.c) ZeusTransformUtils.preCheckCast(r12.i, com.obric.autogui.agents.vlm.models.omni.upload.b.c.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r12.h, String.class, "com.obric.aiagent.plugin");
        Boolean r10 = (Boolean) ZeusTransformUtils.preCheckCast(r12.g, Boolean.class, "com.obric.aiagent.plugin");
        r r11 = (r) ZeusTransformUtils.preCheckCast(r12.f, r.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.d.C0690d r14 = (com.obric.autogui.agents.vlm.models.impl.d.C0690d) ZeusTransformUtils.preCheckCast(r12.f28463e, com.obric.autogui.agents.vlm.models.impl.d.C0690d.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r12.f28462d, String.class, "com.obric.aiagent.plugin");
        JsonObject r16 = (JsonObject) ZeusTransformUtils.preCheckCast(r12.f28461c, JsonObject.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r12.f28460b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r18 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r12.f28459a, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        JsonObject r19 = r16;
        r13 = r18;
    L43:
        List<ViewHierarchyDump> r110 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        String r111 = r9;
        com.obric.autogui.agents.vlm.models.impl.d.C0690d r20 = r14;
        String r112 = r17;
        JsonObject r27 = r19;
        com.obric.autogui.session.a r113 = r7;
        com.obric.autogui.agents.vlm.models.omni.upload.b.c r114 = r8;
        r r28 = r11;
        r0 = r15;
        Boolean r115 = r10;
    L45:
        if (r20 == null) goto L49;
        com.obric.autogui.agents.vlm.models.c.b r29 = r20.b();
        if (r29 == null) goto L49;
        int r30 = r29.b();
    L50:
        r114.a(r113, r110, r112, r30, r111);
        if (r28 == null) goto L63;
        if (r20 == null) goto L57;
        com.obric.autogui.agents.vlm.models.c.b r31 = r20.b();
        if (r31 == null) goto L57;
        ScreenshotResult r32 = r31.g();
    L58:
        boolean r33 = r13.g();
        boolean r34 = r13.f();
        r12.f28459a = r13;
        r12.f28460b = r0;
        r12.f28461c = null;
        r12.f28462d = null;
        r12.f28463e = null;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r12.i = null;
        r12.j = null;
        r12.m = 2;
        if (r28.a(0, r27, r32, r33, r34, r112, r115, r12) != r4) goto L61;
        return r4;
    L61:
        r6 = r13;
    L57:
        r32 = null;
    L49:
        r30 = r13.a().s();
        goto L50
    L16:
        d.o.a(r2);
        r15 = r21.b();
        r14 = this.f28458a;
        r11 = t.f28523a.a(r15);
        if (r14 == null) goto L21;
        com.obric.autogui.agents.vlm.models.c.b r35 = r14.b();
        if (r35 == null) goto L21;
        r10 = r35.f();
    L22:
        String r36 = a(r11, r21.f());
        if (r14 == null) goto L27;
        com.obric.autogui.agents.vlm.models.c.b r37 = r14.b();
        if (r37 == null) goto L27;
        ScreenshotResult r116 = r37.g();
    L28:
        if (r14 == null) goto L32;
        com.obric.autogui.agents.vlm.models.c.b r38 = r14.b();
        if (r38 == null) goto L32;
        int r39 = r38.b();
    L33:
        com.obric.autogui.agents.vlm.models.omni.upload.s.f28827a.a(r21.a(), r116, r22, r39, r36);
        r8 = com.obric.autogui.agents.vlm.models.omni.upload.b.c.f28614a;
        com.obric.autogui.session.a r40 = r21.a();
        if (r14 == null) goto L44;
        com.obric.autogui.agents.vlm.models.c.b r41 = r14.b();
        if (r41 == null) goto L44;
        au<List<ViewHierarchyDump>> r42 = r41.k();
        if (r42 == null) goto L44;
        r13 = r21;
        r12.f28459a = r13;
        r17 = r22;
        r12.f28460b = r17;
        r19 = r25;
        r12.f28461c = r19;
        r12.f28462d = r15;
        r12.f28463e = r14;
        r12.f = r11;
        r12.g = r10;
        r12.h = r36;
        r12.i = r8;
        r12.j = r40;
        r12.m = 1;
        Object r43 = r42.a(r12);
        if (r43 != r4) goto L42;
        return r4;
    L42:
        r9 = r36;
        r7 = r40;
        r2 = r43;
    L44:
        r13 = r21;
        r111 = r36;
        r110 = null;
        r0 = r15;
        r27 = r25;
        r113 = r40;
        r115 = r10;
        r20 = r14;
        r112 = r22;
        r114 = r8;
        r28 = r11;
    L32:
        r39 = r21.a().s();
    L27:
        r116 = null;
    L21:
        r10 = null;
    L7:
        r3 = new a(this, r1);
        goto L8
    }

    private final String a(r r3, boolean r4) {
        if (r3 == null) goto L16;
        l r5 = r3.e();
        if (r5 == null) goto L16;
        com.obric.autogui.agents.vlm.models.omni.intent.g r6 = r5.a();
        if (r6 == null) goto L16;
        String r7 = r6.g();
        if (r7 == null) goto L16;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L16;
        return r7;
    L16:
        if (r4 == true) goto L19;
        return "first_image";
    L19:
        return null;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object b(d.c.d<? super d.x> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        this.f28458a = null;
        return d.x.f38692a;
    }
}
