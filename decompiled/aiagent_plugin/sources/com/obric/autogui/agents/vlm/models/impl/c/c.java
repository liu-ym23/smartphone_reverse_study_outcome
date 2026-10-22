package com.obric.autogui.agents.vlm.models.impl.c;

import android.content.ComponentName;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.o;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PageStateDigest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f27619a = null;

    /* JADX INFO: compiled from: PageStateDigest.kt */
    @f(b = "PageStateDigest.kt", c = {125}, d = "fromModelRequest", e = "com.obric.autogui.agents.vlm.models.impl.pagestate.PageStateDigestFactory")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27624e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27619a = new c();
    }

    public static /* synthetic */ com.obric.autogui.agents.a.d.c lambda$fLW3f4gg_8LqVpFsblcPcLUGEw4(IScreenshot r0) {
        return a(r0);
    }

    private c() {
    }

    public final Object a(ScreenshotResult r21, List<ViewHierarchyDump> r22, Long r23, d.c.d<? super b> r24) {
        c r0 = this;
        ScreenshotResult r1 = r21;
        List<ViewHierarchyDump> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r7 = d.c.a.b.a();
        int r8 = r5.h;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(r5.f27624e, Boolean.class, "com.obric.aiagent.plugin");
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r5.f27623d, Long.class, "com.obric.aiagent.plugin");
        r2 = (List) ZeusTransformUtils.preCheckCast(r5.f27622c, List.class, "com.obric.aiagent.plugin");
        ScreenshotResult r10 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r5.f27621b, ScreenshotResult.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r5.f27620a, c.class, "com.obric.aiagent.plugin");
        o.a(r6);
        Long r12 = r9;
        r1 = r10;
        Boolean r13 = r3;
        r0 = r11;
        Object r14 = r6;
    L36:
        c r15 = r0;
        com.obric.autogui.agents.a.d.c r17 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
    L37:
        Long r16 = r12;
    L39:
        if (r1 == null) goto L41;
        ComponentName r18 = r1.getTopComponent();
    L43:
        if (d.h.b.o.a(r13, d.c.b.a.b.a(true)) == true) goto L45;
        List<ViewHierarchyDump> r19 = r2;
    L47:
        return r15.a(r16, "model_request", r18, r19, r17, r13);
    L45:
        r19 = null;
        goto L47
    L41:
        r18 = null;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        if (r1 != null) goto L17;
    L25:
        r13 = null;
    L27:
        if (d.h.b.o.a(r13, d.c.b.a.b.a(true)) == false) goto L29;
        r16 = r23;
        r15 = r0;
        r17 = null;
        goto L39
    L29:
        if (r1 == null) goto L31;
        final IScreenshot r20 = r21.getPic();
    L32:
        if (r20 == null) goto L38;
        d.h.a.a r110 = new $$Lambda$c$fLW3f4gg_8LqVpFsblcPcLUGEw4(r20);
        r5.f27620a = r0;
        r5.f27621b = r1;
        r5.f27622c = r2;
        r12 = r23;
        r5.f27623d = r12;
        r5.f27624e = r13;
        r5.h = 1;
        r14 = r20.withResourcesLocked(r110, r5);
        if (r14 != r7) goto L36;
        return r7;
    L38:
        r12 = r23;
        r15 = r0;
        r17 = null;
        goto L37
    L31:
        r20 = null;
        goto L32
    L17:
        if (r21.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L19;
    L24:
        r13 = d.c.b.a.b.a(true);
        goto L27
    L19:
        if ((r21.getFlags() & 1) != 0) goto L24;
        if (r21.getStatus() != ScreenshotResult.Status.Ok) goto L25;
        r13 = d.c.b.a.b.a(false);
    L7:
        r5 = new a(r0, r4);
        goto L8
    }

    private static final com.obric.autogui.agents.a.d.c a(IScreenshot r2) {
        IScreenshot r3 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.agents.a.d.d.f26364a.a(r3.getBitmap());
    }

    public final b a(com.obric.autogui.agents.a.l.c r9, long r10) {
        d.h.b.o.e(r9, "baseline");
        Long r2 = Long.valueOf(r10);
        ComponentName r4 = r9.a();
        List<ViewHierarchyDump> r5 = r9.b();
        com.obric.autogui.agents.a.d.c r6 = r9.c();
        Boolean r11 = true;
        r11.booleanValue();
        if (r9.e() == false) goto L5;
        Boolean r7 = r11;
    L7:
        return a(r2, "action_effect_baseline", r4, r5, r6, r7);
    L5:
        r7 = null;
        goto L7
    }

    public final com.obric.autogui.agents.vlm.models.impl.c.a a(b r14, b r15) {
        d.h.b.o.e(r15, "preAction");
        Integer r13 = null;
        if (r14 == null) goto L5;
        ComponentName r0 = r14.getActivity();
    L7:
        if (r0 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r14 == null) goto L14;
        Integer r3 = r14.c();
    L15:
        if (r3 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r14 == null) goto L22;
        byte[] r4 = r14.f();
    L23:
        byte[] r6 = r15.f();
        if (r4 == null) goto L27;
        if (r6 == null) goto L27;
        boolean r9 = true;
    L29:
        if (r5 == true) goto L31;
    L33:
        boolean r1 = false;
    L34:
        if (r7 == true) goto L36;
    L38:
        boolean r8 = false;
    L39:
        if (r9 == true) goto L41;
    L43:
        boolean r10 = false;
    L44:
        if (r14 == null) goto L46;
        Long r2 = r14.g();
    L47:
        if (r2 == null) goto L52;
        if (r15.g() == null) goto L52;
        r13 = Integer.valueOf(Long.bitCount(r14.g().longValue() ^ r15.g().longValue()));
    L52:
        return new com.obric.autogui.agents.vlm.models.impl.c.a(r5, r1, r7, r8, r9, r10, r13);
    L46:
        r2 = null;
        goto L47
    L41:
        if (Arrays.equals(r4, r6) == true) goto L43;
        r10 = true;
        goto L44
    L36:
        if (d.h.b.o.a(r3, r15.c()) == true) goto L38;
        r8 = true;
        goto L39
    L31:
        if (d.h.b.o.a(r0, r15.getActivity()) == true) goto L33;
        r1 = true;
    L27:
        r9 = false;
        goto L29
    L22:
        r4 = null;
        goto L23
    L17:
        if (r15.c() == null) goto L19;
        r7 = true;
        goto L20
    L14:
        r3 = null;
        goto L15
    L9:
        if (r15.getActivity() == null) goto L11;
        r5 = true;
        goto L12
    L5:
        r0 = null;
        goto L7
    }

    private final b a(Long r16, String r17, ComponentName r18, List<ViewHierarchyDump> r19, com.obric.autogui.agents.a.d.c r20, Boolean r21) {
        List<ViewHierarchyDump> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Integer r7 = com.obric.autogui.agents.a.n.a.f26730a.c(r1);
        if (r1 == null) goto L5;
        int r8 = r1.size();
    L6:
        if (r1 == null) goto L10;
        List<VHNode> r2 = com.obric.autogui.agents.a.n.a.f26730a.a(r1);
        if (r2 == null) goto L10;
        int r9 = r2.size();
    L12:
        if (r20 == null) goto L14;
        byte[] r10 = a(r20);
    L15:
        if (r20 == null) goto L17;
        Long r11 = Long.valueOf(r20.a());
    L18:
        if (r20 == null) goto L20;
        Integer r12 = Integer.valueOf(r20.b());
    L21:
        if (r20 == null) goto L23;
        Integer r13 = Integer.valueOf(r20.c());
    L25:
        return new b(r16, r17, r18, r7, r8, r9, r10, r11, r12, r13, r21);
    L23:
        r13 = null;
        goto L25
    L20:
        r12 = null;
        goto L21
    L17:
        r11 = null;
        goto L18
    L14:
        r10 = null;
    L10:
        r9 = 0;
        goto L12
    L5:
        r8 = 0;
        goto L6
    }

    private final byte[] a(com.obric.autogui.agents.a.d.c r4) {
        MessageDigest r3 = MessageDigest.getInstance("SHA-256");
        r3.update(ByteBuffer.allocate(8).putLong(r4.a()).array());
        r3.update(ByteBuffer.allocate(4).putInt(r4.b()).array());
        r3.update(ByteBuffer.allocate(4).putInt(r4.c()).array());
        r3.update(r4.d());
        byte[] r5 = r3.digest();
        d.h.b.o.c(r5, "digest(...)");
        return r5;
    }
}
