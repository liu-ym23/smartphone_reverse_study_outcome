package com.obric.autogui.platforms.tools.display.vd;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.view.Display;
import android.view.Surface;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.vd.VDConfig;
import com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.x;

/* JADX INFO: compiled from: StandardVDAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends BaseManagedDisplayAccessor {
    private static final String TAG = "Std/VDInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0806a f30189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VirtualDisplay f30190b;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.display.vd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardVDAccessor.kt */
    public static final class C0806a {
        public /* synthetic */ C0806a(h r1) {
            this();
        }

        private C0806a() {
        }
    }

    static {
        f30189a = new C0806a(null);
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor
    public String managedDisplayLogName() {
        return "VD";
    }

    public a(Context r7, VirtualDisplay r8, VDConfig r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r8, "vd");
        o.e(r9, "config");
        Display r2 = r8.getDisplay();
        o.c(r2, "getDisplay(...)");
        super(r1, r2, new m(Integer.valueOf(r9.getWidthPixels()), Integer.valueOf(r9.getHeightPixels())), 0, TAG);
        this.f30190b = r8;
    }

    @Override // com.obric.autogui.common.api.platform.display.SurfaceChangeable
    public void setSurface(Surface r7) {
        Loog.INSTANCE.i(TAG, "[VD/" + getDisplayId() + "] -> setSurface before: old=" + describeSurface(this.f30190b.getSurface()) + ", new=" + describeSurface(r7));
        this.f30190b.setSurface(r7);
        Loog.INSTANCE.i(TAG, "[VD/" + getDisplayId() + "] -> setSurface after: current=" + describeSurface(this.f30190b.getSurface()));
    }

    @Override // com.obric.autogui.platforms.tools.display.a
    public IScreenshot provideScreenshotPic(com.obric.autogui.platforms.tools.internal.b.a r3) {
        o.e(r3, "displayScreenshot");
        Bitmap r0 = r3.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IScreenshot) ZeusTransformUtils.preCheckCast(new g(r0, r3.c(), this), IScreenshot.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor
    public Object destroyDisplayResource(d.c.d<? super x> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        this.f30190b.release();
        return x.f38692a;
    }
}
