package com.obric.autogui.platforms.tools.display;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.Display;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayStatusListener;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.BitmapScreenshot;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: StandardMDAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autogui.platforms.tools.display.a {
    private static final String TAG = "Std/DispAcc/MD";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30161a = null;

    /* JADX INFO: compiled from: StandardMDAccessor.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30161a = new a(null);
    }

    public d(Context r3, Display r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r4, "display");
        super(r4);
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public DisplayedAppInfo getTopDisplayedApp() {
        if (Build.VERSION.SDK_INT < 32) goto L11;
        if (VDTaskStackObserver.f30162a.a() == false) goto L11;
        Integer r0 = VDTaskStackObserver.f30162a.b(getDisplayId());
        if (r0 == null) goto L11;
        DisplayedAppInfo r1 = VDTaskStackObserver.f30162a.a(r0.intValue());
        Loog.INSTANCE.d(TAG, "getTopDisplayedApp: Using cache for displayId=" + getDisplayId() + " -> " + r1);
        return r1;
    L11:
        return super.getTopDisplayedApp();
    }

    @Override // com.obric.autogui.platforms.tools.display.a
    public com.obric.autogui.platforms.tools.internal.b.a captureDisplayInternal(Context r8, ScreenshotConfig r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        if (r9 == null) goto L19;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r9.getExcludingPackages(), Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L19;
        if (getDisplayId() == 0) goto L15;
        Loog.INSTANCE.e(TAG, "captureDisplay (" + getDisplayId() + "): excludingPackages is only valid for DefaultDisplay.");
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.NotSupported, null, 0.0f, null, 14, null);
    L15:
        return com.obric.autogui.platforms.tools.internal.a.h.f30335a.a(r10, null, r9.getExcludingPackages(), r9.getScale());
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L19:
        return super.captureDisplayInternal(r10, r9);
    }

    @Override // com.obric.autogui.platforms.tools.display.a
    public IScreenshot provideScreenshotPic(com.obric.autogui.platforms.tools.internal.b.a r3) {
        o.e(r3, "displayScreenshot");
        Bitmap r2 = r3.b();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (IScreenshot) ZeusTransformUtils.preCheckCast(new BitmapScreenshot(r2, r3.c(), AOOperatingSpace.SpaceType.MainDisplay), IScreenshot.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public void registerStatusListener(DisplayStatusListener r2) {
        DisplayStatusListener r1 = (DisplayStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, DisplayStatusListener.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.e(TAG, "registerStatusListener: MainDisplay is not supported.");
    }
}
