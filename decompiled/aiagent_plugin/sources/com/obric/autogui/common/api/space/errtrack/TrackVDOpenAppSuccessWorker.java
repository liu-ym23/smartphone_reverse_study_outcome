package com.obric.autogui.common.api.space.errtrack;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: TrackVDOpenAppSuccessWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackVDOpenAppSuccessWorker {
    public static final Companion Companion = null;
    private static final String TAG = "OpAppSuccTracker";
    private final Context context;
    private final DisplayOperatingSpace operatingSpace;
    private final ComponentName prevTopActivity;
    private final String targetAppPackage;

    /* JADX INFO: compiled from: TrackVDOpenAppSuccessWorker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.errtrack.TrackVDOpenAppSuccessWorker$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackVDOpenAppSuccessWorker.kt */
    @f(b = "TrackVDOpenAppSuccessWorker.kt", c = {35, 102}, d = "run", e = "com.obric.autogui.common.api.space.errtrack.TrackVDOpenAppSuccessWorker")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrackVDOpenAppSuccessWorker this$0;

        AnonymousClass1(TrackVDOpenAppSuccessWorker r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.run((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TrackVDOpenAppSuccessWorker(Context r3, String r4, ComponentName r5, DisplayOperatingSpace r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r8 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r6, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r4, "targetAppPackage");
        o.e(r5, "prevTopActivity");
        o.e(r8, "operatingSpace");
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.targetAppPackage = r4;
        this.prevTopActivity = r5;
        this.operatingSpace = r8;
    }

    public final Object run(d.c.d<? super x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r15, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        a r13 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.aiagent.plugin");
        TrackVDOpenAppSuccessWorker r0 = (TrackVDOpenAppSuccessWorker) ZeusTransformUtils.preCheckCast(r1.L$0, TrackVDOpenAppSuccessWorker.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L78:
    L75:
        th = move-exception;
        r13.b(null);
        throw th;
    L30:
        if (r0.operatingSpace.isValid() == true) goto L34;
        Loog.INSTANCE.w(TAG, "the operating space (" + r0.operatingSpace + ") is destroyed; skip tracking open app success.");     // Catch: Throwable -> L75
        x r17 = x.f38692a;     // Catch: Throwable -> L75
        r13.b(null);
        return r17;
    L34:
        DisplayedAppInfo r18 = r0.operatingSpace.fetchTopDisplayed();     // Catch: Throwable -> L75
        if (r18 == null) goto L37;
        ComponentName r19 = r18.getTopActivity();     // Catch: Throwable -> L75
    L40:
        if (o.a(r0.prevTopActivity, r19) == true) goto L45;
        Loog.INSTANCE.d(TAG, "the activity pkgName " + r0.targetAppPackage + " open OK");     // Catch: Throwable -> L75
        x r110 = x.f38692a;     // Catch: Throwable -> L75
        r13.b(null);
        return r110;
    L45:
        if (AutoActionAgent.INSTANCE.isOngoingSessionPaused() == false) goto L47;
        Loog.INSTANCE.d(TAG, "Paused & pkgName " + r0.targetAppPackage + " seems to not opened to the VD.");     // Catch: Throwable -> L75
    L72:
        x r111 = x.f38692a;     // Catch: Throwable -> L75
        r13.b(null);
        return x.f38692a;
    L47:
        Loog.INSTANCE.w(TAG, "the activity pkgName " + r0.targetAppPackage + " open failed (prev=" + r0.prevTopActivity + ", cur=" + r19 + ')');     // Catch: Throwable -> L75
        Loog.INSTANCE.w(TAG, " -> Bringing appPackage=" + r0.targetAppPackage + " to VD.");     // Catch: Throwable -> L75
        DisplayAccessor r112 = AOPlatformTools.INSTANCE.display().getMDAccess(r0.context);     // Catch: Throwable -> L75
        if (r112 != null) goto L53;
        Loog.INSTANCE.e(TAG, "ErrorTracking: Failed to get MDAccess.");     // Catch: Throwable -> L75
        x r113 = x.f38692a;     // Catch: Throwable -> L75
        r13.b(null);
        return r113;
    L53:
        Collection<DisplayedAppInfo> r2 = r112.getTopDisplayedApps(100, false);     // Catch: Throwable -> L75
        if (r2.isEmpty() == false) goto L58;
        Loog.INSTANCE.e(TAG, "ErrorTracking: TopDisplayedApps empty for the MD.");     // Catch: Throwable -> L75
        x r114 = x.f38692a;     // Catch: Throwable -> L75
        r13.b(null);
        return r114;
    L58:
        Iterator<DisplayedAppInfo> r5 = r2.iterator();     // Catch: Throwable -> L75
    L60:
        if (r5.hasNext() == false) goto L72;
        DisplayedAppInfo r6 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r5.next(), DisplayedAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        ComponentName r9 = r6.getTopActivity();     // Catch: Throwable -> L75
        if (r9 == null) goto L64;
        String r10 = r9.getPackageName();     // Catch: Throwable -> L75
    L66:
        if (o.a(r10, r0.targetAppPackage) == false) goto L60;
        boolean r11 = r112.moveTaskTo(r0.context, r6.getTaskId(), r0.operatingSpace.getDisplayAccessor(), true);     // Catch: Throwable -> L75
        Loog r12 = Loog.INSTANCE;     // Catch: Throwable -> L75
        StringBuilder r7 = new StringBuilder().append(" -- ErrorTracking: Moving MD Task (").append(r6).append(") to VD ").append(r0.operatingSpace).append(" (success=");     // Catch: Throwable -> L75
        if (r11 == false) goto L70;
        boolean r20 = true;
    L71:
        r12.w(TAG, r7.append(r20).append(')').toString());     // Catch: Throwable -> L75
        goto L60
    L70:
        r20 = false;
        goto L71
    L64:
        r10 = null;
        goto L66
    L37:
        r19 = null;
        goto L40
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        TrackVDOpenAppSuccessWorker this = (TrackVDOpenAppSuccessWorker) ZeusTransformUtils.preCheckCast(r1.L$0, TrackVDOpenAppSuccessWorker.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L25:
        a r115 = this.operatingSpace.getLock();
        r1.L$0 = this;
        r1.L$1 = r115;
        r1.label = 2;
        if (r115.a(null, r1) != r3) goto L28;
        return r3;
    L28:
        r0 = this;
        r13 = r115;
        goto L78
    L16:
        d.o.a(r16);
        if (this.operatingSpace.getType() != AOOperatingSpace.SpaceType.VirtualDisplay) goto L19;
    L22:
        r1.L$0 = this;
        r1.label = 1;
        if (ax.a(1500, r1) != r3) goto L25;
        return r3;
    L19:
        if (this.operatingSpace.getType() == AOOperatingSpace.SpaceType.ComputerControl) goto L22;
        Loog.INSTANCE.w(TAG, "skip tracking open app success for unsupported space type=" + this.operatingSpace.getType());
        return x.f38692a;
    L7:
        r1 = new AnonymousClass1(this, r15);
        goto L8
    }
}
