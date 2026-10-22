package com.obric.autogui.common.api.space.vd.spawn;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.vd.VDConfig;
import com.obric.autogui.common.api.space.vd.VDSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VDSpaceSpawner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDSpaceSpawner {
    public static final Companion Companion = null;
    private static final String TAG = "VDSpawner";
    private final Context context;
    private final DisplayManager sDisplayManager;

    /* JADX INFO: compiled from: VDSpaceSpawner.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.vd.spawn.VDSpaceSpawner$spawn$1, reason: invalid class name */
    /* JADX INFO: compiled from: VDSpaceSpawner.kt */
    @f(b = "VDSpaceSpawner.kt", c = {98}, d = "spawn", e = "com.obric.autogui.common.api.space.vd.spawn.VDSpaceSpawner")
    static final class AnonymousClass1 extends d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ VDSpaceSpawner this$0;

        AnonymousClass1(VDSpaceSpawner r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.spawn((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VDSpaceSpawner(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.context = r5;
        Object r6 = r5.getSystemService("display");
        o.a(r6, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.sDisplayManager = (DisplayManager) ZeusTransformUtils.preCheckCast(r6, DisplayManager.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Object access$createAutoActionVD(VDSpaceSpawner r2, Context r3, String r4, DisplayMetrics r5, d.c.d r6) {
        return r2.createAutoActionVD((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Context getContext() {
        return this.context;
    }

    private final DisplayMetrics getDesiredMetrics() {
        DisplayManager r2 = this.sDisplayManager;
        DisplayMetrics r0 = new DisplayMetrics();
        r2.getDisplay(AOSystemTools.INSTANCE.getMainDisplayId()).getRealMetrics(r0);
        return r0;
    }

    private final void maybeAdjustMetricsForVD(DisplayMetrics r3) {
        if (r3.widthPixels <= r3.heightPixels) goto L6;
        Loog.INSTANCE.d(TAG, "initVirtualDisplay in landscape, swap width and height");
        int r2 = r3.heightPixels;
        r3.heightPixels = r3.widthPixels;
        r3.widthPixels = r2;
        return;
    }

    private final Object createAutoActionVD(Context r8, String r9, DisplayMetrics r10, d.c.d<? super DisplayAccessor> r11) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super DisplayAccessor> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return AOPlatformTools.INSTANCE.display().createVD(r7, new VDConfig(r9, r10.widthPixels, r10.heightPixels, r10.densityDpi, VDConfig.Type.DefaultOperatingSpace), r12);
    }

    public final Object spawn(d.c.d<? super VDSpace> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r11);
    L17:
        DisplayAccessor r8 = (DisplayAccessor) ZeusTransformUtils.preCheckCast(r11, DisplayAccessor.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L22;
        Loog.INSTANCE.e(TAG, "createAutoActionVD failed.");
        return null;
    L22:
        return new VDSpace(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        DisplayMetrics r12 = getDesiredMetrics();
        maybeAdjustMetricsForVD(r12);
        Loog.INSTANCE.d(TAG, "initVirtualDisplay, metrics=" + r12);
        Context r4 = this.context;
        r0.label = 1;
        r11 = createAutoActionVD(r4, "auto_action", r12, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }
}
