package com.obric.autogui.platforms.tools.display;

import android.app.TaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.platforms.tools.input.inject.e;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StandardDisplayAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements DisplayAccessor {
    public static final C0802a Companion = null;
    private static final String TAG = "Std/VDInfo";
    private static final int WINDOWING_MODE_FULLSCREEN = 1;
    private static final Set<String> sIgnoredTopAppPackages = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Display f30147d;
    private final Point mCachedDimensions;
    private boolean mCachedDimensionsValid;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.display.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardDisplayAccessor.kt */
    public static final class C0802a {
        public /* synthetic */ C0802a(h r1) {
            this();
        }

        private C0802a() {
        }
    }

    /* JADX INFO: compiled from: StandardDisplayAccessor.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30148a = null;

        static {
            int[] r0 = new int[DisplayAccessor.Rotation.values().length];
            r0[DisplayAccessor.Rotation.Rotation90.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DisplayAccessor.Rotation.Rotation270.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f30148a = r0;
        }
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public Object destroy(d.c.d<? super x> r3) {
        return destroy$suspendImpl(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean isDestroyed() {
        return false;
    }

    public abstract IScreenshot provideScreenshotPic(com.obric.autogui.platforms.tools.internal.b.a r1);

    public a(Display r2) {
        o.e(r2, "d");
        this.f30147d = r2;
        this.mCachedDimensions = new Point();
    }

    public final Display getD() {
        return this.f30147d;
    }

    static {
        Companion = new C0802a(null);
        sIgnoredTopAppPackages = ax.a(new String[]{IslandImpl.LIVE_CARD_HOST, "com.android.launcher3", "com.miui.home"});
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public int getDisplayId() {
        return this.f30147d.getDisplayId();
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public DisplayAccessor.Rotation getRotation() {
        return mapDisplayRotation(this.f30147d.getRotation());
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public m<Integer, Integer> getSpawnedDimensions() {
        return getDecoratedDimensions();
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public m<Integer, Integer> getDecoratedDimensions() {
        if (this.mCachedDimensionsValid == true) goto L5;
        this.f30147d.getRealSize(this.mCachedDimensions);
        if (this.mCachedDimensions.x <= this.mCachedDimensions.y) goto L9;
        Loog.INSTANCE.d(TAG, " > [Platform] Display[" + getDisplayId() + "] Landscape.");
        int r0 = this.mCachedDimensions.x;
        Point r1 = this.mCachedDimensions;
        r1.x = r1.y;
        this.mCachedDimensions.y = r0;
    L9:
        this.mCachedDimensionsValid = true;
        return new m(Integer.valueOf(this.mCachedDimensions.x), Integer.valueOf(this.mCachedDimensions.y));
    L5:
        return new m(Integer.valueOf(this.mCachedDimensions.x), Integer.valueOf(this.mCachedDimensions.y));
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public DisplayedAppInfo getTopDisplayedApp() {
        if (Build.VERSION.SDK_INT >= 32) goto L6;
        Loog.INSTANCE.e(TAG, "getTopDisplayedApp: not supported on SDK < Q");
        return null;
    L6:
        TaskInfo r0 = com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(getDisplayId());
        Loog.INSTANCE.d(TAG, " > [Platform] TopDisplayed[" + getDisplayId() + "] = " + r0);
        if (r0 != null) goto L10;
        return null;
    L10:
        return (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(new c(r0), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public Collection<DisplayedAppInfo> getTopDisplayedApps(int r11, boolean r12) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Loog.INSTANCE.e(TAG, "getDisplayedAppStack: not supported on SDK < Q");
        return (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.platforms.tools.internal.a.b.f30316a.a(r11, true, false, getDisplayId()), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L39;
        TaskInfo r0 = (TaskInfo) ZeusTransformUtils.preCheckCast(r14.next(), TaskInfo.class, "com.obric.aiagent.plugin");
        Set<String> r3 = sIgnoredTopAppPackages;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        ComponentName r6 = r0.baseActivity;
        c r7 = null;
        if (r6 == null) goto L12;
        String r8 = r6.getPackageName();
    L14:
        if (p.a(r5, r8) == true) goto L35;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        ComponentName r9 = r0.topActivity;
        if (r9 == null) goto L18;
        String r15 = r9.getPackageName();
    L20:
        if (p.a(r4, r15) == true) goto L35;
        if (Build.VERSION.SDK_INT < 32) goto L29;
        if (r0.isVisible() == true) goto L29;
        if (r12 == false) goto L29;
        Loog.INSTANCE.w(TAG, " - omitting invisible task with (tId=" + r0.taskId + ", topA=" + r0.topActivity + ").");
    L36:
        if (r7 == null) goto L8;
        r13.add(r7);
    L29:
        if (r0.topActivity != null) goto L31;
        Loog.INSTANCE.w(TAG, " - omitting task with null topActivity (tId=" + r0.taskId + ").");
        goto L36
    L31:
        int r16 = com.obric.autogui.platforms.tools.internal.a.e.f30325a.b(r0);
        if (r16 == 1) goto L34;
        Loog.INSTANCE.w(TAG, " - omitting task with non-fullscreen windowingMode (tId=" + r0.taskId + ", wm=" + r16 + ").");
        goto L36
    L34:
        r7 = new c(r0);
        goto L36
    L18:
        r15 = null;
    L35:
        Loog.INSTANCE.w(TAG, " - omitting Ignored package (tId=" + r0.taskId + ", topA=" + r0.topActivity + ").");
        goto L36
    L12:
        r8 = null;
        goto L14
    L39:
        return (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean isPackageVisible(String r2) {
        o.e(r2, "packageName");
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r2, getDisplayId());
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean moveTaskTo(Context r3, int r4, DisplayAccessor r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r8 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r5, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "targetDisplay");
        if (r8.getDisplayId() != getDisplayId()) goto L7;
        Loog.INSTANCE.w(TAG, "moveTaskTo: targetDisplay is the same as this display.");
        return true;
    L7:
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r4, r8.getDisplayId(), r6);
    }

    static /* synthetic */ Object destroy$suspendImpl(a r2, d.c.d<? super x> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.w(TAG, "Attempting to destroy an Accessor for Display#" + r2.getDisplayId() + "is not supported.");
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public final Object captureDisplay(Context r10, ScreenshotConfig r11, d.c.d<? super ScreenshotResult> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.platforms.tools.internal.b.a r15 = captureDisplayInternal(r13, r11);
        return new ScreenshotResult(r15.a(), provideScreenshotPic(r15), r15.d(), 0, null, null, 56, null);
    }

    public com.obric.autogui.platforms.tools.internal.b.a captureDisplayInternal(Context r9, ScreenshotConfig r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        m<Integer, Integer> r11 = getDecoratedDimensions();
        if (r10 == null) goto L5;
        float r0 = r10.getScale();
    L6:
        float r6 = r0;
        Loog.INSTANCE.e(TAG, "captureDisplayInternal, wh: " + r11 + ", scale: " + r6);
        int r1 = b.f30148a[getRotation().ordinal()];
        if (r1 != 1) goto L9;
    L11:
        r11 = new m(r11.b(), r11.a());
    L12:
        com.obric.autogui.platforms.tools.internal.a.h r2 = com.obric.autogui.platforms.tools.internal.a.h.f30335a;
        DisplayAccessor r4 = (DisplayAccessor) ZeusTransformUtils.preCheckCast(this, DisplayAccessor.class, "com.obric.aiagent.plugin");
        Rect r5 = new Rect(0, 0, ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r11.b(), Number.class, "com.obric.aiagent.plugin")).intValue());
        if (r10 == null) goto L15;
        ScreenshotConfig.HeifConfig r8 = r10.getHeifConfig();
    L17:
        return r2.a(r3, r4, r5, r6, r8);
    L15:
        r8 = null;
        goto L17
    L9:
        if (r1 == 2) goto L11;
    L5:
        r0 = 1.0f;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean injectIntoDisplay(MotionEvent r11) {
        o.e(r11, "event");
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a((InputEvent) ZeusTransformUtils.preCheckCast(r11, InputEvent.class, "com.obric.aiagent.plugin"), getDisplayId());
        e.a(e.f30311a, r11, 0, null, null, 14, null);
        return true;
    }

    public final DisplayAccessor.Rotation mapDisplayRotation(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L16;
        return DisplayAccessor.Rotation.Rotation0;
    L16:
        return DisplayAccessor.Rotation.Rotation270;
    L17:
        return DisplayAccessor.Rotation.Rotation180;
    L18:
        return DisplayAccessor.Rotation.Rotation90;
    L14:
        return DisplayAccessor.Rotation.Rotation0;
    }
}
