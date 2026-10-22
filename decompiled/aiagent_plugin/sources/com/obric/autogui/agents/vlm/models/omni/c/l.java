package com.obric.autogui.agents.vlm.models.omni.c;

import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: OAutoAppPrewarmConsumer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.r f28291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f28292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DisplayOperatingSpace f28293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f28294e;
    private final kotlinx.coroutines.f.a f;
    private final m g;
    private final q h;

    /* JADX INFO: compiled from: OAutoAppPrewarmConsumer.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ boolean a(a r0, com.obric.autogui.session.a r1) {
            return r0.a(r1);
        }

        private final boolean a(com.obric.autogui.session.a r2) {
            com.obric.autogui.session.state.b.c r1 = r2.m().d();
            if (r1.a() == BizStatus.OPERATING) goto L5;
        L11:
            return false;
        L5:
            if (r1.b() != null) goto L11;
            if (r1.c() != null) goto L9;
        L10:
            return true;
        L9:
            if (r1.c() != BizStatus.OPERATING) goto L11;
            goto L10
        }

        public final l a(com.obric.autogui.agents.vlm.models.omni.r r8, k r9) {
            d.h.b.o.e(r8, "owner");
            d.h.b.o.e(r9, "telemetry");
            com.obric.autogui.session.a r3 = com.obric.autogui.session.c.f30777a.b();
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.c() == true) goto L8;
        L30:
            return null;
        L8:
            if (d.h.b.o.a(r3.b(), r8.a()) == false) goto L30;
            if (r8.h() == true) goto L30;
            if (r3.J().e() == true) goto L30;
            if (a(r3) == false) goto L30;
            AOOperatingSpace r7 = OperatingSpaceManager.INSTANCE.getActiveSpace();
            if (ZeusTransformUtils.instanceOf(r7, DisplayOperatingSpace.class) == false) goto L20;
            DisplayOperatingSpace r4 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r7, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        L21:
            if (r4 != null) goto L24;
            return null;
        L24:
            if (r4.getType() != AOOperatingSpace.SpaceType.VirtualDisplay) goto L30;
            if (r4.isValid() == false) goto L30;
            r9.a(r3.a());
            return new l(r8, r3, r4, r9, null);
        L20:
            r4 = null;
            goto L21
        }
    }

    /* JADX INFO: compiled from: OAutoAppPrewarmConsumer.kt */
    @d.c.b.a.f(b = "OAutoAppPrewarmConsumer.kt", c = {106}, d = "awaitIdle", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.OAutoAppPrewarmConsumer")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f28296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f28297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28298d;

        b(l r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28297c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28296b = r3;
            this.f28298d |= Integer.MIN_VALUE;
            return this.f28297c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OAutoAppPrewarmConsumer.kt */
    @d.c.b.a.f(b = "OAutoAppPrewarmConsumer.kt", c = {35, 36, 38, 39, 41, 44, 109, 49, 60, 62, 63, 64, 65}, d = "consume", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.OAutoAppPrewarmConsumer")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f28303e;
        final /* synthetic */ l f;
        int g;

        c(l r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28303e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f28290a = new a(null);
    }

    public /* synthetic */ l(com.obric.autogui.agents.vlm.models.omni.r r2, com.obric.autogui.session.a r3, DisplayOperatingSpace r4, k r5, d.h.b.h r6) {
        this(r2, r3, (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"), r5);
    }

    private l(com.obric.autogui.agents.vlm.models.omni.r r3, com.obric.autogui.session.a r4, DisplayOperatingSpace r5, k r6) {
        DisplayOperatingSpace r7 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        this.f28291b = r3;
        this.f28292c = r4;
        this.f28293d = r7;
        this.f28294e = r6;
        this.f = kotlinx.coroutines.f.c.a(false, 1, null);
        this.g = new m();
        this.h = new q();
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.c.h
    public Object a(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28298d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28298d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f28296b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28298d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.f.a r6 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f28295a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L23:
        x r10 = x.f38692a;     // Catch: Throwable -> L20
        r6.b(null);
        return x.f38692a;
    L20:
        th = move-exception;
        r6.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r6 = this.f;
        r0.f28295a = r6;
        r0.f28298d = 1;
        if (r6.a(null, r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autogui.agents.vlm.models.omni.c.h
    public Object a(List<com.obric.autogui.agents.vlm.models.omni.c.b> r14, d.c.d<? super x> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r17, c.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        Object r18 = r1.f28303e;
        Object r9 = d.c.a.b.a();
        switch(r1.g) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            default: goto L11;
        };
    L12:
        d.o.a(r18);
    L120:
        return x.f38692a;
    L13:
        d.o.a(r18);
    L115:
        return x.f38692a;
    L14:
        d.o.a(r18);
    L108:
        return x.f38692a;
    L15:
        l r13 = (l) ZeusTransformUtils.preCheckCast(r1.f28299a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
        l r19 = r13;
    L102:
        r.c r110 = (r.c) ZeusTransformUtils.preCheckCast(r18, r.c.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L110;
        k r111 = r19.f28294e;
        r1.f28299a = null;
        r1.g = 11;
        if (r111.a("process_ready_timeout", r1) != r9) goto L108;
        return r9;
    L110:
        if (r19.a() == true) goto L116;
        k r112 = r19.f28294e;
        r1.f28299a = null;
        r1.g = 12;
        if (r112.a("consumer_not_current", r1) != r9) goto L115;
        return r9;
    L116:
        k r113 = r19.f28294e;
        r1.f28299a = null;
        r1.g = 13;
        if (r113.a(r110, r1) != r9) goto L120;
        return r9;
    L16:
        d.o.a(r18);
    L97:
        return x.f38692a;
    L17:
        kotlinx.coroutines.f.a r114 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f28302d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Intent r115 = (Intent) ZeusTransformUtils.preCheckCast(r1.f28301c, Intent.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.c.a r3 = (com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r1.f28300b, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin");
        l r0 = (l) ZeusTransformUtils.preCheckCast(r1.f28299a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Throwable -> L20
        l r2 = r0;
    L82:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L85;
        r r116 = (r) ZeusTransformUtils.preCheckCast(new r.a(o.i.a()), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        l r4 = r2;
    L91:
        r114.b(null);
        if (ZeusTransformUtils.instanceOf(r116, r.a.class) == false) goto L98;
        k r117 = r4.f28294e;
        String r118 = ((r.a) ZeusTransformUtils.preCheckCast(r116, r.a.class, "com.obric.aiagent.plugin")).a();
        r1.f28299a = null;
        r1.f28300b = null;
        r1.f28301c = null;
        r1.f28302d = null;
        r1.g = 9;
        if (r117.a(r118, r1) != r9) goto L97;
        return r9;
    L98:
        d.h.b.o.a(r116, "null cannot be cast to non-null type com.obric.autogui.agents.vlm.models.omni.prewarm.PrewarmBackendResult.Launched");
        r.b r119 = (r.b) ZeusTransformUtils.preCheckCast(r116, r.b.class, "com.obric.aiagent.plugin");
        q r5 = r4.h;
        DisplayOperatingSpace r6 = r4.f28293d;
        r.b r7 = (r.b) ZeusTransformUtils.preCheckCast(r116, r.b.class, "com.obric.aiagent.plugin");
        r1.f28299a = r4;
        r1.f28300b = null;
        r1.f28301c = null;
        r1.f28302d = null;
        r1.g = 10;
        r18 = r5.a(r6, r7, 5000, r1);
        if (r18 != r9) goto L101;
        return r9;
    L101:
        r19 = r4;
        goto L102
    L85:
        if (r2.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f28292c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3.b()) == false) goto L88;
        r116 = (r) ZeusTransformUtils.preCheckCast(new r.a(o.f28311a.a()), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r4 = r2;
        goto L91
    L88:
        if (r2.a() == true) goto L90;
        r116 = (r) ZeusTransformUtils.preCheckCast(new r.a("consumer_not_current"), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r4 = r2;
        goto L91
    L90:
        ce.b(r1.getContext());     // Catch: Throwable -> L20
        r116 = r2.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f28292c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2.f28293d, r3, r115);     // Catch: Throwable -> L20
        r4 = r2;
        goto L91
    L22:
        r114 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f28302d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r115 = (Intent) ZeusTransformUtils.preCheckCast(r1.f28301c, Intent.class, "com.obric.aiagent.plugin");
        r3 = (com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r1.f28300b, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin");
        l r8 = (l) ZeusTransformUtils.preCheckCast(r1.f28299a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
        l r10 = r8;
    L75:
        ce.b(r1.getContext());     // Catch: Throwable -> L20
        if (r10.a() == true) goto L78;
        r116 = (r) ZeusTransformUtils.preCheckCast(new r.a("consumer_not_current"), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r4 = r10;
        goto L91
    L78:
        com.obric.autogui.agents.vlm.models.impl.applist.black.p r120 = com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a;     // Catch: Throwable -> L20
        String r11 = r3.b();     // Catch: Throwable -> L20
        String r12 = r10.f28292c.a();     // Catch: Throwable -> L20
        r1.f28299a = r10;     // Catch: Throwable -> L20
        r1.f28300b = r3;     // Catch: Throwable -> L20
        r1.f28301c = r115;     // Catch: Throwable -> L20
        r1.f28302d = r114;     // Catch: Throwable -> L20
        r1.g = 8;     // Catch: Throwable -> L20
        r18 = r120.a(r11, r12, r1);     // Catch: Throwable -> L20
        r2 = r10;
        if (r18 != r9) goto L82;
        return r9;
    L23:
        d.o.a(r18);
    L70:
        return x.f38692a;
    L24:
        d.o.a(r18);
    L63:
        return x.f38692a;
    L25:
        com.obric.autogui.agents.vlm.models.omni.c.a r121 = (com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r1.f28300b, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin");
        l r122 = (l) ZeusTransformUtils.preCheckCast(r1.f28299a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
        l r123 = r122;
    L57:
        p r124 = (p) ZeusTransformUtils.preCheckCast(r18, p.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r124, p.b.class) == false) goto L64;
        k r125 = r123.f28294e;
        String r126 = ((p.b) ZeusTransformUtils.preCheckCast(r124, p.b.class, "com.obric.aiagent.plugin")).a().a();
        r1.f28299a = null;
        r1.f28300b = null;
        r1.g = 5;
        if (r125.a(r126, r1) != r9) goto L63;
        return r9;
    L64:
        Intent r127 = r123.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r123.f28292c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r121);
        if (r127 != null) goto L71;
        k r128 = r123.f28294e;
        r1.f28299a = null;
        r1.f28300b = null;
        r1.g = 6;
        if (r128.a("package_not_launchable", r1) != r9) goto L70;
        return r9;
    L71:
        kotlinx.coroutines.f.a r20 = r123.f;
        r1.f28299a = r123;
        r1.f28300b = r121;
        r1.f28301c = r127;
        r1.f28302d = r20;
        r1.g = 7;
        if (r20.a(null, r1) != r9) goto L74;
        return r9;
    L74:
        r3 = r121;
        r114 = r20;
        r10 = r123;
        r115 = r127;
        goto L75
    L26:
        d.o.a(r18);
    L53:
        return x.f38692a;
    L27:
        com.obric.autogui.agents.vlm.models.omni.c.b r129 = (com.obric.autogui.agents.vlm.models.omni.c.b) ZeusTransformUtils.preCheckCast(r1.f28300b, com.obric.autogui.agents.vlm.models.omni.c.b.class, "com.obric.aiagent.plugin");
        l r130 = (l) ZeusTransformUtils.preCheckCast(r1.f28299a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
        l r131 = r130;
    L40:
        Iterator r132 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r132.hasNext() == false) goto L46;
        Object r21 = r132.next();
        if (d.h.b.o.a(((com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin")).b(), r129.a()) == false) goto L42;
    L47:
        r121 = (com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin");
        if (r121 != null) goto L54;
        k r133 = r131.f28294e;
        r1.f28299a = null;
        r1.f28300b = null;
        r1.g = 3;
        if (r133.a("package_not_in_app_list", r1) != r9) goto L53;
        return r9;
    L54:
        m r134 = r131.g;
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r131.f28292c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r23 = r121.b();
        r1.f28299a = r131;
        r1.f28300b = r121;
        r1.g = 4;
        r18 = r134.a(r22, r23, r1);
        r123 = r131;
        if (r18 != r9) goto L57;
        return r9;
    L46:
        r21 = null;
        goto L47
    L28:
        d.o.a(r18);
    L35:
        return x.f38692a;
    L29:
        d.o.a(r18);
        ce.b(r1.getContext());
        com.obric.autogui.agents.vlm.models.omni.c.b r135 = (com.obric.autogui.agents.vlm.models.omni.c.b) ZeusTransformUtils.preCheckCast(d.a.p.l(r16), com.obric.autogui.agents.vlm.models.omni.c.b.class, "com.obric.aiagent.plugin");
        if (r135 != null) goto L36;
        k r136 = this.f28294e;
        r1.g = 1;
        if (r136.a("model_chose_skip", r1) != r9) goto L35;
        return r9;
    L36:
        Context r137 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f28292c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r1.f28299a = this;
        r1.f28300b = r135;
        r1.g = 2;
        r18 = e.a(r137, r1);
        if (r18 != r9) goto L39;
        return r9;
    L39:
        r131 = this;
        r129 = r135;
        goto L40
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        th = move-exception;
        b(null);
        throw th;
    L7:
        r1 = new c(this, r17);
        goto L8
    }

    private final boolean a() {
        if (g.f28262a.a() == true) goto L5;
    L17:
        return false;
    L5:
        if (this.f28291b.h() == true) goto L17;
        if (a.a(f28290a, this.f28292c) == false) goto L17;
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        com.obric.autogui.session.a r1 = this.f28292c;
        if (r0 != r1) goto L17;
        if (r1.J().e() == true) goto L17;
        AOOperatingSpace r2 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        DisplayOperatingSpace r3 = this.f28293d;
        if (r2 != r3) goto L17;
        if (r3.isValid() == false) goto L17;
        return true;
    }
}
