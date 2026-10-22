package com.obric.autogui.platforms.tools.input.inject;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ScreenTap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "ScreenTap";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f30301b = null;

    /* JADX INFO: compiled from: ScreenTap.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScreenTap.kt */
    @f(b = "ScreenTap.kt", c = {41}, d = "perform", e = "com.obric.autogui.platforms.tools.input.inject.ScreenTap")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f30304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30305d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30304c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f30303b = r8;
            this.f30305d |= Integer.MIN_VALUE;
            return this.f30304c.a(0.0f, 0.0f, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScreenTap.kt */
    @f(b = "ScreenTap.kt", c = {121}, d = "tapInternal", e = "com.obric.autogui.platforms.tools.input.inject.ScreenTap")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f30310e;
        float f;
        float g;
        /* synthetic */ Object h;
        final /* synthetic */ d i;
        int j;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.h = r10;
            this.j |= Integer.MIN_VALUE;
            return d.a(this.i, 0, 0.0f, 0.0f, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public d() {
    }

    public static final /* synthetic */ Object a(d r10, long r11, float r13, float r14, long r15, InjectEventContext.Context r17, d.c.d r18) {
        return r10.a(r11, r13, r14, r15, r17, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f30300a = new a(null);
        f30301b = new AtomicLong(0);
    }

    public final Object a(float r24, float r25, long r26, InjectEventContext.Context r28, d.c.d<? super com.obric.autogui.common.e> r29) {
        long r0 = r26;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r5.f30305d & Integer.MIN_VALUE) == 0) goto L7;
        r5.f30305d -= Integer.MIN_VALUE;
    L8:
        b r8 = r5;
        Object r3 = r8.f30303b;
        Object r10 = d.c.a.b.a();
        int r6 = r8.f30305d;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r1 = r8.f30302a;
        o.a(r3);
    L32:
        com.obric.autogui.common.e r4 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L35;
        Loog.INSTANCE.d(TAG, "[TapInput] end tapSeq=" + r1 + ", result=" + r4.h() + ", ok=" + r4.g());
    L35:
        return r3;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        long r12 = f30301b.incrementAndGet();
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L18;
        Loog.INSTANCE.d(TAG, "[TapInput] begin tapSeq=" + r12 + ", x=" + r24 + ", y=" + r25 + ", requestedInterval=" + r0);
    L18:
        if (r24 > 0.0f) goto L20;
    L36:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[TapInput] invalid tapSeq=" + r12 + ", x=" + r24 + ", y=" + r25);
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_clicking_failed_invalid_input, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platfom_input_clicking_failed_invalid_input"), null, 2, null), "invalid_input", "x=" + r24 + ", y=" + r25 + ", intv=" + r0, false, null, 0, 28, null);
    L20:
        if (r25 <= 0.0f) goto L36;
        if (r0 >= 0) goto L25;
        r0 = 90;
    L25:
        long r7 = r0;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
        Loog.INSTANCE.d(TAG, "[TapInput] validated tapSeq=" + r12 + ", x=" + r24 + ", y=" + r25 + ", interval=" + r7);
    L28:
        r8.f30302a = r12;
        r8.f30305d = 1;
        r3 = a(r12, r24, r25, r7, r28, r8);
        if (r3 != r10) goto L31;
        return r10;
    L31:
        r1 = r12;
    L7:
        r5 = new b(this, r2);
        goto L8
    }

    private final Object a(long r43, float r45, float r46, long r47, InjectEventContext.Context r49, d.c.d<? super com.obric.autogui.common.e> r50) {
        float r15 = r45;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r50, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r2.j & Integer.MIN_VALUE) == 0) goto L7;
        r2.j -= Integer.MIN_VALUE;
    L8:
        c r7 = r2;
        Object r1 = r7.h;
        Object r8 = d.c.a.b.a();
        int r3 = r7.j;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r9 = r7.f30310e;
        long r10 = r7.f30309d;
        float r4 = r7.g;
        float r12 = r7.f;
        long r13 = r7.f30308c;
        InjectEventContext.Context r5 = (InjectEventContext.Context) ZeusTransformUtils.preCheckCast(r7.f30307b, InjectEventContext.Context.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.preCheckCast(r7.f30306a, d.class, "com.obric.aiagent.plugin");
        o.a(r1);
        d r30 = r6;
        InjectEventContext.Context r41 = r5;
        String r25 = ", injU=";
        String r29 = ", intv=";
        long r35 = r9;
        r15 = r12;
        long r11 = r13;
        float r14 = r4;
        String r16 = "x=";
        String r17 = "platfom_input_clicking_failed_system";
        String r18 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        String r19 = ", result=";
        String r110 = ", x=";
        String r111 = TAG;
        long r20 = r10;
        String r112 = ", y=";
    L36:
        com.obric.autogui.common.e r21 = r30.a(r11, "UP", 1, r35, SystemClock.uptimeMillis(), r15, r14, r41);
        if (r21.g() == true) goto L40;
        long r113 = r20;
        OmniDataFeedbackLog.INSTANCE.e(r111, "[TapInput] up failed tapSeq=" + r11 + r110 + r15 + r112 + r14 + r19 + r21.h());
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_clicking_failed_system, r18, r17), null, 2, null), "inject_motion_failed", r16 + r15 + r112 + r14 + r29 + r113 + r25 + r21.h(), false, null, 0, 28, null);
    L40:
        return r21;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        long r22 = SystemClock.uptimeMillis();
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L19;
        Loog.INSTANCE.d(TAG, "[TapInput] schedule tapSeq=" + r43 + ", downTime=" + r22 + ", interval=" + r47);
    L19:
        if (r47 != 0) goto L28;
        com.obric.autogui.common.e r114 = a(r43, "DOWN", 0, r22, r22, r45, r46, r49);
        com.obric.autogui.common.e r23 = a(r43, "UP", 1, r22, r22, r45, r46, r49);
        if (r114.g() == false) goto L27;
        if (r23.g() == false) goto L27;
        return com.obric.autogui.common.e.f29014b.a();
    L27:
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_clicking_failed_system, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platfom_input_clicking_failed_system"), null, 2, null), "inject_motion_failed", "x=" + r15 + ", y=" + r46 + ", intv=0, injD=" + r114.h() + ", injU=" + r23.h(), false, null, 0, 28, null);
    L28:
        r25 = ", injU=";
        r110 = ", x=";
        r19 = ", result=";
        r111 = TAG;
        r29 = ", intv=";
        com.obric.autogui.common.e r24 = a(r43, "DOWN", 0, r22, r22, r45, r46, r49);
        if (r24.g() == true) goto L32;
        OmniDataFeedbackLog.INSTANCE.e(r111, "[TapInput] down failed tapSeq=" + r43 + r110 + r15 + ", y=" + r46 + r19 + r24.h());
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_clicking_failed_system, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platfom_input_clicking_failed_system"), null, 2, null), "inject_motion_failed", "x=" + r15 + ", y=" + r46 + r29 + r47 + ", injD=" + r24.h(), false, null, 0, 28, null);
    L32:
        r14 = r46;
        r16 = "x=";
        r18 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r17 = "platfom_input_clicking_failed_system";
        AOThreadingTools r26 = AOThreadingTools.INSTANCE;
        r112 = ", y=";
        r7.f30306a = this;
        r7.f30307b = r49;
        r7.f30308c = r43;
        r7.f = r15;
        r7.g = r14;
        r7.f30309d = r47;
        r7.f30310e = r22;
        r7.j = 1;
        if (r26.delayForMillis(r47, r7) != r8) goto L35;
        return r8;
    L35:
        r30 = this;
        r20 = r47;
        r41 = r49;
        r35 = r22;
        r11 = r43;
    L7:
        r2 = new c(this, r0);
        goto L8
    }

    private final com.obric.autogui.common.e a(long r20, String r22, int r23, long r24, long r26, float r28, float r29, InjectEventContext.Context r30) {
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.d(TAG, "[TapInput] inject tapSeq=" + r20 + ", phase=" + r22 + ", action=" + MotionEvent.actionToString(r23) + ", downTime=" + r24 + ", eventTime=" + r26 + ", x=" + r28 + ", y=" + r29);
    L6:
        e r5 = e.f30311a;
        if (r23 != 0) goto L9;
        float r3 = 1.0f;
    L11:
        return e.a(r5, r23, r24, r26, r28, r29, r3, 0, "tapSeq=" + r20 + ",phase=" + r22, r30, 64, null);
    L9:
        r3 = 0.0f;
        goto L11
    }
}
