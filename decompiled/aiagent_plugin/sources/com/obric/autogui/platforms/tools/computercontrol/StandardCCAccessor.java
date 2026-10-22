package com.obric.autogui.platforms.tools.computercontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchEvent;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi;
import com.obric.autogui.common.api.platform.display.TaskPreservingDisplayAccessor;
import com.obric.autogui.common.api.platform.display.capture.BitmapScreenshot;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor;
import com.obric.autogui.platforms.tools.internal.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: StandardCCAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardCCAccessor extends BaseManagedDisplayAccessor implements TaskPreservingDisplayAccessor {
    private static final Companion Companion = null;
    private static final int MAX_TOUCH_PRESSURE = 255;
    private static final int NO_TASK_TO_PRESERVE = -1;
    private static final String TAG = "Std/CCInfo";
    private final Context appContext;
    private final AtomicInteger pendingTaskId;
    private final CCSessionAccessor sessionAccessor;

    /* JADX INFO: compiled from: StandardCCAccessor.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor
    public String managedDisplayLogName() {
        return "CC";
    }

    public final CCSessionAccessor getSessionAccessor() {
        return this.sessionAccessor;
    }

    public StandardCCAccessor(Context r9, Display r10, CCSessionAccessor r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        CCSessionAccessor r13 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r11, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r10, "display");
        o.e(r13, "sessionAccessor");
        super(r12, r10, r13.getDisplaySize(), r10.getRotation(), TAG);
        this.sessionAccessor = r13;
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.pendingTaskId = new AtomicInteger(-1);
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor
    public boolean shouldHandleDisplayChanged(int r1) {
        if (r1 != getDisplayId()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor, com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean isDestroyed() {
        if (getMIsDestroyed() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.sessionAccessor.isClosed() == true) goto L8;
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.display.SurfaceChangeable
    public void setSurface(Surface r4) {
        CCActionResult r5 = AOPlatformTools.INSTANCE.computerControl().setSurface(this.sessionAccessor, r4);
        if (ZeusTransformUtils.instanceOf(r5, CCActionResult.Failed.class) == false) goto L6;
        Loog.INSTANCE.w(TAG, "[CC/" + getDisplayId() + "] setSurface failed: " + r5);
        return;
    }

    @Override // com.obric.autogui.platforms.tools.display.a
    public a captureDisplayInternal(Context r10, ScreenshotConfig r11) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), "context");
        if (this.sessionAccessor.isClosed() == true) goto L5;
        ScreenshotResult r9 = AOPlatformTools.INSTANCE.computerControl().screenshot(this.sessionAccessor, r11);
        ScreenshotResult.Status r12 = r9.getStatus();
        IScreenshot r0 = r9.getPic();
        Float r2 = null;
        if (r0 == null) goto L9;
        Bitmap r1 = r0.getBitmap();
    L10:
        IScreenshot r3 = r9.getPic();
        if (r3 == null) goto L13;
        float r13 = r3.getScale();
    L24:
        return new a(r12, r1, r13, r9.getHeifAttachment());
    L13:
        if (r11 == null) goto L22;
        Float r14 = Float.valueOf(r11.getScale());
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        r2 = r14;
    L20:
        if (r2 == null) goto L22;
        r13 = r2.floatValue();
        goto L24
    L17:
        r4 = false;
    L22:
        r13 = 1.0f;
        goto L24
    L9:
        r1 = null;
        goto L10
    L5:
        return new a(ScreenshotResult.Status.ScreenClosed, null, 0.0f, null, 14, null);
    }

    @Override // com.obric.autogui.platforms.tools.display.a
    public IScreenshot provideScreenshotPic(a r3) {
        o.e(r3, "displayScreenshot");
        Bitmap r2 = r3.b();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (IScreenshot) ZeusTransformUtils.preCheckCast(new BitmapScreenshot(r2, r3.c(), AOOperatingSpace.SpaceType.ComputerControl), IScreenshot.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean injectIntoDisplay(MotionEvent r13) {
        o.e(r13, "event");
        int r0 = r13.getActionIndex();
        CCActionResult r14 = AOPlatformTools.INSTANCE.computerControl().sendTouchEvent(this.sessionAccessor, new CCTouchEvent(r13.getPointerId(r0), r13.getToolType(r0), r13.getActionMasked(), (int) r13.getX(r0), (int) r13.getY(r0), d.i.a.a(r13.getPressure() * MAX_TOUCH_PRESSURE), d.i.a.a(r13.getTouchMajor(r0)), 1000000 * r13.getEventTime()));
        if (ZeusTransformUtils.instanceOf(r14, CCActionResult.Failed.class) == false) goto L6;
        Loog.INSTANCE.w(TAG, "[CC/" + getDisplayId() + "] sendTouchEvent failed: " + r14);
        return false;
    L6:
        return true;
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean moveTaskTo(Context r3, int r4, DisplayAccessor r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r8 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r5, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "targetDisplay");
        return super.moveTaskTo(r7, r4, r8, r6);
    }

    @Override // com.obric.autogui.common.api.platform.display.TaskPreservingDisplayAccessor
    public boolean scheduleTaskMoveToMainDisplayBeforeDestroy(int r2) {
        if (r2 > 0) goto L4;
        return false;
    L4:
        if (isDestroyed() == true) goto L10;
        this.pendingTaskId.set(r2);
        return true;
    L10:
        return false;
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean isPackageVisible(String r2) {
        o.e(r2, "packageName");
        return super.isPackageVisible(r2);
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor
    public Object destroyDisplayResource(d<? super x> r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        int r10 = this.pendingTaskId.getAndSet(-1);
        if (r10 > 0) goto L15;
    L10:
        CCActionResult r11 = AOPlatformTools.INSTANCE.computerControl().close(this.sessionAccessor);
        if (ZeusTransformUtils.instanceOf(r11, CCActionResult.Failed.class) == false) goto L14;
        Loog.INSTANCE.w(TAG, "[CC/" + getDisplayId() + "] close failed: " + r11);
    L14:
        return x.f38692a;
    L15:
        IAutoActionDisplayApi r4 = AOPlatformTools.INSTANCE.display();     // Catch: Exception -> L8
        Context r5 = this.appContext;     // Catch: Exception -> L8
        o.c(r5, "appContext");     // Catch: Exception -> L8
        DisplayAccessor r6 = r4.getMDAccess(r5);     // Catch: Exception -> L8
        if (r6 == null) goto L10;
        Context r7 = this.appContext;     // Catch: Exception -> L8
        o.c(r7, "appContext");     // Catch: Exception -> L8
        super.moveTaskTo(r7, r10, r6, false);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "[CC/" + getDisplayId() + "] failed to preserve task=" + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L10
    }
}
