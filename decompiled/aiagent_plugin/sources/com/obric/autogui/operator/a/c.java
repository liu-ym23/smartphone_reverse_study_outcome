package com.obric.autogui.operator.a;

import android.content.Context;
import android.content.Intent;
import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.input.IAutoActionInputApi;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.platform.input.InputTextResult;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.k;
import d.m;
import d.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: GUIActionRouter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "GUIActionRouter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f29713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f29714b = null;

    /* JADX INFO: compiled from: GUIActionRouter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29715a = null;

        static {
            int[] r0 = new int[CCActionFailureReason.values().length];
            r0[CCActionFailureReason.Unsupported.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CCActionFailureReason.InvalidSession.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CCActionFailureReason.SessionClosed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CCActionFailureReason.InvalidArgument.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CCActionFailureReason.ApiError.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f29715a = r0;
        }
    }

    /* JADX INFO: compiled from: GUIActionRouter.kt */
    @d.c.b.a.f(b = "GUIActionRouter.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT, 99, 100, 101}, d = "doubleTap", e = "com.obric.autogui.operator.impl.GUIActionRouter")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f29720e;
        float f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ c i;
        int j;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.h = r8;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(0.0f, 0.0f, 0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GUIActionRouter.kt */
    @d.c.b.a.f(b = "GUIActionRouter.kt", c = {150, 158}, d = "swipe", e = "com.obric.autogui.operator.impl.GUIActionRouter")
    static final class C0767c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f29724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f29725e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        C0767c(c r3, d.c.d<? super C0767c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.f = r10;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, 0, false, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private c() {
    }

    static {
        f29713a = new c();
        f29714b = new AtomicInteger(0);
    }

    public static /* synthetic */ Object a(c r10, float r11, float r12, long r13, AOOperatingSpace r15, InjectEventContext.Context r16, d.c.d r17, int r18, Object r19) {
        AOOperatingSpace r0 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r15, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r18 & 4) == 0) goto L5;
        long r5 = -1;
    L7:
        if ((r18 & 8) == 0) goto L9;
        AOOperatingSpace r7 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        InjectEventContext.Context r8 = null;
    L15:
        return r10.a(r11, r12, r5, r7, r8, r9);
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r0;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final Object a(float r9, float r10, long r11, AOOperatingSpace r13, InjectEventContext.Context r14, d.c.d<? super com.obric.autogui.common.e> r15) {
        AOOperatingSpace r16 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r13, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        CCSpace r17 = a(r16);
        if (r17 == null) goto L10;
        int r7 = a("tap", r14);
        if (r11 <= 0) goto L7;
        CCActionResult r12 = AOPlatformTools.INSTANCE.computerControl().tapWithInterval(r17.getSessionAccessor(), d.i.a.a(r9), d.i.a.a(r10), r11, r7);
    L8:
        a(r7, r12, r14);
        return a(r12, "tap", r17);
    L7:
        r12 = AOPlatformTools.INSTANCE.computerControl().tap(r17.getSessionAccessor(), d.i.a.a(r9), d.i.a.a(r10), r7);
        goto L8
    L10:
        IAutoActionInputApi r0 = AOPlatformTools.INSTANCE.input();
        if (r0 != null) goto L15;
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L15:
        return r0.tap(r9, r10, r11, r14, r6);
    }

    public static /* synthetic */ Object a(c r7, float r8, float r9, int r10, AOOperatingSpace r11, InjectEventContext.Context r12, d.c.d r13, int r14, Object r15) {
        AOOperatingSpace r16 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r11, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r14 & 8) == 0) goto L5;
        AOOperatingSpace r4 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        InjectEventContext.Context r5 = null;
    L11:
        return r7.a(r8, r9, r10, r4, r5, r6);
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public final Object a(float r27, float r28, int r29, AOOperatingSpace r30, InjectEventContext.Context r31, d.c.d<? super com.obric.autogui.common.e> r32) {
        float r9 = r27;
        float r10 = r28;
        int r11 = r29;
        InjectEventContext.Context r12 = r31;
        AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r30, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
    L8:
        b r14 = r3;
        Object r4 = r14.h;
        Object r15 = d.c.a.b.a();
        int r5 = r14.j;
        String r8 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L12;
        int r0 = r14.g;
        float r6 = r14.f;
        float r7 = r14.f29720e;
        com.obric.autogui.common.e r13 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14.f29719d, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        CCSpace r16 = (CCSpace) ZeusTransformUtils.preCheckCast(r14.f29718c, CCSpace.class, "com.obric.aiagent.plugin");
        InjectEventContext.Context r17 = (InjectEventContext.Context) ZeusTransformUtils.preCheckCast(r14.f29717b, InjectEventContext.Context.class, "com.obric.aiagent.plugin");
        c r18 = (c) ZeusTransformUtils.preCheckCast(r14.f29716a, c.class, "com.obric.aiagent.plugin");
        o.a(r4);
        r12 = r17;
        r10 = r6;
        CCSpace r19 = r16;
        r9 = r7;
    L27:
        int r20 = r18.a("doubleTap-second", r12);
        CCActionResult r21 = AOPlatformTools.INSTANCE.computerControl().tap(r19.getSessionAccessor(), d.i.a.a(r9), d.i.a.a(r10), r20);
        r18.a(r20, r21, r12);
        com.obric.autogui.common.e r22 = r18.a(r21, "doubleTap", r19);
        r8 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        String r23 = null;
    L45:
        if (r13.g() == false) goto L51;
        if (r22.g() == false) goto L51;
        return com.obric.autogui.common.e.f29014b.a();
    L51:
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_double_click_failed, r8, "agent_action_desc_string_double_click_failed"), r23, 2, r23), "double_click_failed", "f=" + r13.h() + ", s=" + r22.h() + ", ct=" + r0, false, null, 0, 28, null);
    L12:
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 != 4) goto L17;
        r0 = r14.g;
        com.obric.autogui.common.e r24 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14.f29716a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        o.a(r4);
        Object r25 = r4;
        r8 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r23 = null;
    L43:
        r13 = r24;
        r22 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r25, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r0 = r14.g;
        float r26 = r14.f;
        float r33 = r14.f29720e;
        IAutoActionInputApi r34 = (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(r14.f29718c, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.e r35 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14.f29717b, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        InjectEventContext.Context r110 = (InjectEventContext.Context) ZeusTransformUtils.preCheckCast(r14.f29716a, InjectEventContext.Context.class, "com.obric.aiagent.plugin");
        o.a(r4);
        float r36 = r26;
        float r37 = r33;
        IAutoActionInputApi r38 = r34;
        r8 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r24 = r35;
        InjectEventContext.Context r39 = r110;
    L40:
        r14.f29716a = r24;
        r23 = null;
        r14.f29717b = null;
        r14.f29718c = null;
        r14.g = r0;
        r14.j = 4;
        r25 = IAutoActionInputApi.DefaultImpls.tap$default(r38, r37, r36, 0, r39, r14, 4, null);
        if (r25 != r15) goto L43;
        return r15;
    L19:
        int r40 = r14.g;
        float r41 = r14.f;
        float r42 = r14.f29720e;
        IAutoActionInputApi r43 = (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(r14.f29717b, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        InjectEventContext.Context r111 = (InjectEventContext.Context) ZeusTransformUtils.preCheckCast(r14.f29716a, InjectEventContext.Context.class, "com.obric.aiagent.plugin");
        o.a(r4);
        int r112 = 3;
        r11 = r40;
        IAutoActionInputApi r44 = r43;
        InjectEventContext.Context r45 = r111;
        r10 = r41;
        r9 = r42;
    L36:
        com.obric.autogui.common.e r46 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        r14.f29716a = r45;
        r14.f29717b = r46;
        r14.f29718c = r44;
        r14.f29720e = r9;
        r14.f = r10;
        r14.g = r11;
        r14.j = r112;
        if (ax.a(200, r14) != r15) goto L39;
        return r15;
    L39:
        r38 = r44;
        r24 = r46;
        r37 = r9;
        r36 = r10;
        r39 = r45;
        r0 = r11;
        goto L40
    L21:
        o.a(r4);
        r19 = a(r1);
        if (r19 == null) goto L28;
        int r47 = a("doubleTap-first", r12);
        CCActionResult r48 = AOPlatformTools.INSTANCE.computerControl().tap(r19.getSessionAccessor(), d.i.a.a(r27), d.i.a.a(r28), r47);
        a(r47, r48, r12);
        com.obric.autogui.common.e r49 = a(r48, "doubleTap", r19);
        r14.f29716a = this;
        r14.f29717b = r12;
        r14.f29718c = r19;
        r14.f29719d = r49;
        r14.f29720e = r9;
        r14.f = r10;
        r14.g = r11;
        r14.j = 1;
        if (ax.a(200, r14) != r15) goto L26;
        return r15;
    L26:
        r13 = r49;
        r18 = this;
        r0 = r11;
        goto L27
    L28:
        IAutoActionInputApi r50 = AOPlatformTools.INSTANCE.input();
        if (r50 == null) goto L31;
        r14.f29716a = r12;
        r14.f29717b = r50;
        r14.f29720e = r9;
        r14.f = r10;
        r14.g = r11;
        r14.j = 2;
        r112 = 3;
        r4 = IAutoActionInputApi.DefaultImpls.tap$default(r50, r27, r28, 0, r31, r14, 4, null);
        if (r4 != r15) goto L35;
        return r15;
    L35:
        r45 = r31;
        r44 = r50;
        goto L36
    L31:
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L7:
        r3 = new b(this, r2);
        goto L8
    }

    public final Object a(m<Float, Float> r17, m<Float, Float> r18, long r19, boolean r21, AOOperatingSpace r22, InjectEventContext.Context r23, d.c.d<? super com.obric.autogui.common.e> r24) {
        AOOperatingSpace r2 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r22, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C0767c.class) == false) goto L7;
        C0767c r5 = (C0767c) ZeusTransformUtils.preCheckCast(r4, C0767c.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r15 = d.c.a.b.a();
        int r7 = r5.h;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r6);
    L36:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r0 = r5.f29725e;
        long r1 = r5.f29724d;
        IAutoActionInputApi r8 = (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(r5.f29723c, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        m<Float, Float> r9 = (m) ZeusTransformUtils.preCheckCast(r5.f29722b, m.class, "com.obric.aiagent.plugin");
        m<Float, Float> r10 = (m) ZeusTransformUtils.preCheckCast(r5.f29721a, m.class, "com.obric.aiagent.plugin");
        o.a(r6);
        long r11 = r1;
        IAutoActionInputApi r3 = r8;
        Object r12 = r6;
        boolean r13 = r0;
    L31:
        com.obric.autogui.common.e r14 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L37;
        r5.f29721a = r13;
        r5.f29722b = r13;
        r5.f29723c = 0;
        r5.h = 2;
        r6 = r3.swipe(r10, r9, r11, r13, r5);
        if (r6 != r15) goto L36;
        return r15;
    L37:
        return r14;
    L16:
        o.a(r6);
        if (r2 != null) goto L19;
        r2 = OperatingSpaceManager.INSTANCE.getActiveSpace();
    L19:
        AOOperatingSpace r16 = r2;
        CCSpace r20 = a(r16);
        if (r20 == null) goto L23;
        int r110 = a("swipe", r23);
        CCActionResult r25 = AOPlatformTools.INSTANCE.computerControl().swipeWithDuration(r20.getSessionAccessor(), d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r17.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()), d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r17.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()), d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r18.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()), d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r18.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()), r19, r110);
        a(r110, r25, r23);
        return a(r25, "swipe", r20);
    L23:
        r3 = AOPlatformTools.INSTANCE.input();
        if (r3 != null) goto L27;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot acquire input API.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L27:
        e r26 = e.f29835a;
        r5.f29721a = r17;
        r5.f29722b = r18;
        r5.f29723c = r3;
        r5.f29724d = r19;
        r13 = r21;
        r5.f29725e = r13;
        r5.h = 1;
        r12 = r26.a(r3, r16, r17, r18, r19, r21, r5);
        if (r12 != r15) goto L30;
        return r15;
    L30:
        r10 = r17;
        r11 = r19;
        r9 = r18;
    L7:
        r5 = new C0767c(this, r4);
        goto L8
    }

    public static /* synthetic */ Object a(c r11, m r12, m r13, long r14, boolean r16, AOOperatingSpace r17, InjectEventContext.Context r18, d.c.d r19, int r20, Object r21) {
        AOOperatingSpace r0 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r17, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r20 & 8) == 0) goto L5;
        boolean r7 = com.obric.autogui.common.a.d.f28974a.X();
    L7:
        if ((r20 & 16) == 0) goto L9;
        AOOperatingSpace r8 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        InjectEventContext.Context r9 = null;
    L15:
        return r11.a(r12, r13, r14, r7, r8, r9, r10);
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r0;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    private final int a(String r2, InjectEventContext.Context r3) {
        int r1 = f29714b.getAndIncrement();
        if (r3 == null) goto L5;
        InjectEventContext.INSTANCE.registerInjectEvent(r1, r3);
        Loog.INSTANCE.d(TAG, r2 + " register cc inject event, eventId=" + r1);
    L5:
        return r1;
    }

    private final void a(int r3, CCActionResult r4, InjectEventContext.Context r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, CCActionResult.Failed.class) == false) goto L8;
        InjectEventContext.INSTANCE.unregisterInjectEvent(r3, "cc-inject-failed-" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r4, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason());
        return;
    }

    public final Object a(AOOperatingSpace r9, String r10, boolean r11, d.c.d<? super InputTextResult> r12) {
        AOOperatingSpace r13 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r9, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super InputTextResult> r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        CCSpace r4 = a(r13);
        if (r4 == null) goto L14;
        CCActionResult r15 = AOPlatformTools.INSTANCE.computerControl().inputText(r4.getSessionAccessor(), r10, r11, true);
        if (d.h.b.o.a(r15, CCActionResult.Success.INSTANCE) == false) goto L8;
        a(this, "inputText", r4, null, 4, null);
        return InputTextResult.Companion.getOK();
    L8:
        if (ZeusTransformUtils.instanceOf(r15, CCActionResult.Failed.class) == false) goto L12;
        a("inputText", r4, (CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
        return a((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L12:
        throw new k();
    L14:
        return AOPlatformTools.INSTANCE.input().inputText(r13, r10, r11, r14);
    }

    public final com.obric.autogui.common.e a(AOOperatingSpace r3, int r4) {
        AOOperatingSpace r5 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "space");
        CCSpace r0 = a(r5);
        if (r0 == null) goto L7;
        return a(AOPlatformTools.INSTANCE.computerControl().key(r0.getSessionAccessor(), r4), "key", r0);
    L7:
        return AOPlatformTools.INSTANCE.input().key(r5, r4);
    }

    public static /* synthetic */ StartActivityResult a(c r1, Context r2, Intent r3, AOOperatingSpace r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r8 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r8 = null;
    L6:
        return r1.startActivity(r7, r3, r8);
    }

    public final StartActivityResult startActivity(Context r11, Intent r12, AOOperatingSpace r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r14 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r13, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r12, MemorySourceLinkType.INTENT);
        CCSpace r6 = a(r14);
        if (r6 == null) goto L13;
        CCActionResult r15 = AOPlatformTools.INSTANCE.computerControl().startActivity(r6.getSessionAccessor(), r3, r12);
        if (d.h.b.o.a(r15, CCActionResult.Success.INSTANCE) == false) goto L8;
        a(this, "startActivity", r6, null, 4, null);
        return StartActivityResult.Companion.getOK();
    L8:
        if (ZeusTransformUtils.instanceOf(r15, CCActionResult.Failed.class) == false) goto L12;
        a("startActivity", r6, (CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
        return b((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L12:
        throw new k();
    L13:
        if (r14 == null) goto L17;
        return AOPlatformTools.INSTANCE.packages().startActivity(r3, r12, r14);
    L17:
        return AOSystemTools.startActivity$default(AOSystemTools.INSTANCE, r3, r12, null, 4, null);
    }

    public static /* synthetic */ StartActivityResult a(c r1, Context r2, String r3, Intent r4, AOOperatingSpace r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r9 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r9 = null;
    L6:
        return r1.a(r8, r3, r4, r9);
    }

    public final StartActivityResult a(Context r9, String r10, Intent r11, AOOperatingSpace r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r14 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r12, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r10, "packageName");
        d.h.b.o.e(r11, "fallbackIntent");
        CCSpace r4 = a(r14);
        if (r4 == null) goto L5;
        CCActionResult r15 = AOPlatformTools.INSTANCE.computerControl().launchApplication(r4.getSessionAccessor(), r10);
        if (d.h.b.o.a(r15, CCActionResult.Success.INSTANCE) == false) goto L10;
        a(this, "launchApplication", r4, null, 4, null);
        return StartActivityResult.Companion.getOK();
    L10:
        if (ZeusTransformUtils.instanceOf(r15, CCActionResult.Failed.class) == false) goto L14;
        a("launchApplication", r4, (CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
        return b((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r15, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L14:
        throw new k();
    L5:
        return startActivity(r13, r11, r14);
    }

    private final CCSpace a(AOOperatingSpace r4) {
        AOOperatingSpace r3 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.a.c.f28972a.a().d() == true) goto L5;
        return null;
    L5:
        if (r3 != null) goto L8;
        r3 = OperatingSpaceManager.INSTANCE.getActiveSpace();
    L8:
        if (ZeusTransformUtils.instanceOf(r3, CCSpace.class) == false) goto L10;
        CCSpace r5 = (CCSpace) ZeusTransformUtils.preCheckCast(r3, CCSpace.class, "com.obric.aiagent.plugin");
    L11:
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.isValid() == true) goto L17;
        Loog.INSTANCE.w(TAG, "invalid space, action uses original path, spaceId=" + r5.getSpaceId() + ", displayId=" + r5.getDisplayId());
        return null;
    L17:
        return r5;
    L10:
        r5 = null;
        goto L11
    }

    private final com.obric.autogui.common.e a(CCActionResult r8, String r9, CCSpace r10) {
        if (d.h.b.o.a(r8, CCActionResult.Success.INSTANCE) == false) goto L6;
        a(this, r9, r10, null, 4, null);
        return com.obric.autogui.common.e.f29014b.a();
    L6:
        if (ZeusTransformUtils.instanceOf(r8, CCActionResult.Failed.class) == false) goto L10;
        a(r9, r10, (CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r8, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.e.f29014b.b("Computer Control " + r9 + " failed: " + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r8, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason());
    L10:
        throw new k();
    }

    private final InputTextResult a(CCActionResult.Failed r1) {
        CCActionFailureReason r0 = r1.getReason();
        int r2 = a.f29715a[r0.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L17;
        if (r2 == 4) goto L18;
        if (r2 == 5) goto L18;
        throw new k();
    L18:
        return new InputTextResult(InputTextResult.Status.ApiFailed);
    L17:
        return new InputTextResult(InputTextResult.Status.NotSupported);
    }

    private final StartActivityResult b(CCActionResult.Failed r1) {
        CCActionFailureReason r0 = r1.getReason();
        int r2 = a.f29715a[r0.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L17;
        if (r2 == 4) goto L18;
        if (r2 == 5) goto L18;
        throw new k();
    L18:
        return new StartActivityResult(StartActivityResult.Status.ApiFailed);
    L17:
        return new StartActivityResult(StartActivityResult.Status.NotSupported);
    }

    static /* synthetic */ void a(c r0, String r1, CCSpace r2, CCActionResult.Failed r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(String r15, CCSpace r16, CCActionResult.Failed r17) {
        if (r17 != null) goto L5;
        String r0 = r15 + " success, spaceId=" + r16.getSpaceId() + ", displayId=" + r16.getDisplayId();
    L7:
        if (r17 != null) goto L9;
        Loog.INSTANCE.d(TAG, r0);
        return;
    L9:
        Loog.INSTANCE.w(TAG, r0);
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "gui_action", r17.getReason().name(), com.obric.autogui.session.c.f30777a.b(), r16.getSessionAccessor(), null, null, r15, null, null, null, r17.getThrowable(), 944, null);
        return;
    L5:
        r0 = r15 + " failed, reason=" + r17.getReason() + ", spaceId=" + r16.getSpaceId() + ", displayId=" + r16.getDisplayId();
        goto L7
    }
}
