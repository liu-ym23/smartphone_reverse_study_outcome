package com.obric.autogui.platforms.tools.computercontrol;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionConfig;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionRequestResult;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.space.cc.CCBackgroundSurface;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.autogui.common.api.space.cc.ICCSpaceSpawner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.k;
import d.o;

/* JADX INFO: compiled from: StandardCCSpaceSpawner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardCCSpaceSpawner implements ICCSpaceSpawner {
    private static final String CC_SESSION_NAME = "auto_action";
    private static final Companion Companion = null;
    private static final String TAG = "CCSpawner";

    /* JADX INFO: compiled from: StandardCCSpaceSpawner.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner$createSpace$1, reason: invalid class name */
    /* JADX INFO: compiled from: StandardCCSpaceSpawner.kt */
    @f(b = "StandardCCSpaceSpawner.kt", c = {105}, d = "createSpace", e = "com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StandardCCSpaceSpawner this$0;

        AnonymousClass1(StandardCCSpaceSpawner r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return StandardCCSpaceSpawner.access$createSpace(this.this$0, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner$spawn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StandardCCSpaceSpawner.kt */
    @f(b = "StandardCCSpaceSpawner.kt", c = {46, 53}, d = "spawn", e = "com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner")
    static final class C11611 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StandardCCSpaceSpawner this$0;

        C11611(StandardCCSpaceSpawner r3, d.c.d<? super C11611> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.spawn(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StandardCCSpaceSpawner() {
    }

    public static final /* synthetic */ Object access$createSpace(StandardCCSpaceSpawner r8, Context r9, DisplayManager r10, CCSessionAccessor r11, CCBackgroundSurface r12, d.c.d r13) {
        return r8.createSpace((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r11, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.autogui.common.api.space.cc.CCBackgroundSurface] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r6v10, types: [com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.content.Context] */
    @Override // com.obric.autogui.common.api.space.cc.ICCSpaceSpawner
    public Object spawn(Context r23, CCLifecycleListener r24, d.c.d<? super CCSpace> r25) {
        ?? r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r3 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r24, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C11611.class) == false) goto L7;
        C11611 r5 = (C11611) ZeusTransformUtils.preCheckCast(r4, C11611.class, "com.obric.aiagent.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        C11611 r11 = r5;
        Object r6 = r11.result;
        Object r7 = b.a();
        int r8 = r11.label;
        CCSpace r10 = null;
        if (r8 == 0) goto L22;
        if (r8 == 1) goto L17;
        if (r8 != 2) goto L16;
        CCBackgroundSurface r2 = (CCBackgroundSurface) ZeusTransformUtils.preCheckCast(r11.L$0, CCBackgroundSurface.class, "com.obric.aiagent.plugin");
        o.a(r6);     // Catch: Throwable -> L20
    L32:
        r10 = (CCSpace) ZeusTransformUtils.preCheckCast(r6, CCSpace.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
    L36:
        if (r10 != null) goto L38;
        r2.release();
    L38:
        return r10;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r2 = (CCBackgroundSurface) ZeusTransformUtils.preCheckCast(r11.L$3, CCBackgroundSurface.class, "com.obric.aiagent.plugin");
        DisplayManager r0 = (DisplayManager) ZeusTransformUtils.preCheckCast(r11.L$2, DisplayManager.class, "com.obric.aiagent.plugin");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(r11.L$1, Context.class, "com.obric.aiagent.plugin");
        StandardCCSpaceSpawner r12 = (StandardCCSpaceSpawner) ZeusTransformUtils.preCheckCast(r11.L$0, StandardCCSpaceSpawner.class, "com.obric.aiagent.plugin");
        o.a(r6);     // Catch: Throwable -> L20
        DisplayManager r13 = r0;
        ?? r14 = r9;
        ?? r15 = r12;
    L27:
        CCSessionRequestResult r16 = (CCSessionRequestResult) ZeusTransformUtils.preCheckCast(r6, CCSessionRequestResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r16, CCSessionRequestResult.Success.class) == false) goto L34;
        CCSessionAccessor r17 = ((CCSessionRequestResult.Success) ZeusTransformUtils.preCheckCast(r16, CCSessionRequestResult.Success.class, "com.obric.aiagent.plugin")).getSession();     // Catch: Throwable -> L20
        r11.L$0 = r2;     // Catch: Throwable -> L20
        r11.L$1 = null;     // Catch: Throwable -> L20
        r11.L$2 = null;     // Catch: Throwable -> L20
        r11.L$3 = null;     // Catch: Throwable -> L20
        r11.label = 2;     // Catch: Throwable -> L20
        r6 = r15.createSpace(r14, r13, r17, r2, r11);     // Catch: Throwable -> L20
        if (r6 != r7) goto L32;
        return r7;
    L34:
        if (ZeusTransformUtils.instanceOf(r16, CCSessionRequestResult.Failed.class) == false) goto L40;
        Loog.INSTANCE.e(TAG, "request ComputerControlSession failed: " + r16, ((CCSessionRequestResult.Failed) ZeusTransformUtils.preCheckCast(r16, CCSessionRequestResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());     // Catch: Throwable -> L20
        goto L36
    L40:
        throw new k();     // Catch: Throwable -> L20
    L22:
        o.a(r6);
        Object r18 = r1.getSystemService("display");
        d.h.b.o.a(r18, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager r19 = (DisplayManager) ZeusTransformUtils.preCheckCast(r18, DisplayManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r20 = getDesiredMetrics(r19);
        maybeAdjustMetricsForCC(r20);
        CCBackgroundSurface r110 = new CCBackgroundSurface();
        CCSessionConfig r111 = new CCSessionConfig(CC_SESSION_NAME, null, d.c.b.a.b.a(r20.widthPixels), d.c.b.a.b.a(r20.heightPixels), d.c.b.a.b.a(r20.densityDpi), null, 34, null);
        Loog.INSTANCE.i(TAG, "request ComputerControlSession, config=" + r111);
        ?? r21 = AOPlatformTools.INSTANCE.computerControl();     // Catch: Throwable -> L41
        r11.L$0 = this;     // Catch: Throwable -> L41
        r11.L$1 = r1;     // Catch: Throwable -> L41
        r11.L$2 = r19;     // Catch: Throwable -> L41
        r11.L$3 = r110;     // Catch: Throwable -> L41
        r11.label = 1;     // Catch: Throwable -> L41
        Object r22 = r21.requestSession(r1, r111, r3, r11);     // Catch: Throwable -> L41
        if (r22 != r7) goto L26;
        return r7;
    L26:
        r15 = this;
        r13 = r19;
        r6 = r22;
        r14 = r1;
        r2 = r110;
    L41:
        th = th;
        r1 = r110;
    L43:
        r1.release();
        throw th;
    L20:
        th = th;
    L7:
        r5 = new C11611(this, r4);
        goto L8
    }

    private final Object createSpace(Context r7, DisplayManager r8, CCSessionAccessor r9, CCBackgroundSurface r10, d.c.d<? super CCSpace> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        CCSessionAccessor r13 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r9, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r14, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r15 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CCSpace r4 = (CCSpace) ZeusTransformUtils.preCheckCast(r0.L$1, CCSpace.class, "com.obric.aiagent.plugin");
        CCSessionAccessor r16 = (CCSessionAccessor) ZeusTransformUtils.preCheckCast(r0.L$0, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.a(r6);
        return r4;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        Display r17 = r8.getDisplay(r13.getDisplayId());
        if (r17 != null) goto L32;
        Loog.INSTANCE.e(TAG, "ComputerControlSession display unavailable; displayId=" + r13.getDisplayId());
        AOPlatformTools.INSTANCE.computerControl().close(r13);
        return null;
    L32:
        StandardCCAccessor r3 = new StandardCCAccessor(r12, r17, r13);     // Catch: Throwable -> L23
        Loog.INSTANCE.i(TAG, "ComputerControlSession created; displayId=" + r13.getDisplayId() + ", displaySize=" + r13.getDisplaySize());     // Catch: Throwable -> L21
        return new CCSpace(r13, (DisplayAccessor) ZeusTransformUtils.preCheckCast(r3, DisplayAccessor.class, "com.obric.aiagent.plugin"), r10);
    L21:
        th = th;
    L25:
        Loog.INSTANCE.e(TAG, "create CCSpace failed.", th);
        if (r3 == null) goto L30;
        r0.L$0 = r13;
        r0.L$1 = null;
        r0.label = 1;
        if (r3.destroy(r0) != r15) goto L38;
        return r15;
    L38:
        return null;
    L30:
        AOPlatformTools.INSTANCE.computerControl().close(r13);
        return null;
    L23:
        th = th;
        r3 = null;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    private final DisplayMetrics getDesiredMetrics(DisplayManager r2) {
        DisplayMetrics r1 = new DisplayMetrics();
        r2.getDisplay(AOSystemTools.INSTANCE.getMainDisplayId()).getRealMetrics(r1);
        return r1;
    }

    private final void maybeAdjustMetricsForCC(DisplayMetrics r3) {
        if (r3.widthPixels <= r3.heightPixels) goto L6;
        Loog.INSTANCE.d(TAG, "request ComputerControlSession in landscape, swap width and height");
        int r2 = r3.heightPixels;
        r3.heightPixels = r3.widthPixels;
        r3.widthPixels = r2;
        return;
    }
}
