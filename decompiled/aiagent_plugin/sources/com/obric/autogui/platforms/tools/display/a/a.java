package com.obric.autogui.platforms.tools.display.a;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplayConfig;
import android.os.Build;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.vd.VDConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StandardOperatingSpaceVDCreator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String TAG = "Std/OpS-VD-Creator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0803a f30149a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f30150d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f30151e = 0;
    private static final int f = 0;
    private static final int g = 0;
    private static final int h = 0;
    private static final int i = 0;
    private static final int j = 0;
    private static final int k = 0;
    private static final int l = 0;
    private static final int m = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f30152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DisplayManager f30153c;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.display.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardOperatingSpaceVDCreator.kt */
    public static final class C0803a {
        public /* synthetic */ C0803a(h r1) {
            this();
        }

        private C0803a() {
        }
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f30152b = r5;
        Object r6 = r5.getSystemService("display");
        o.a(r6, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.f30153c = (DisplayManager) ZeusTransformUtils.preCheckCast(r6, DisplayManager.class, "com.obric.aiagent.plugin");
    }

    public final Context getContext() {
        return this.f30152b;
    }

    static {
        f30149a = new C0803a(null);
        f30150d = 1;
        f30151e = 4;
        f = 64;
        g = 128;
        h = 512;
        i = 1024;
        j = 4096;
        k = 16384;
        l = 32768;
        m = 65536;
    }

    public boolean a(VDConfig r1) {
        o.e(r1, "config");
        if (Build.VERSION.SDK_INT < 34) goto L5;
        return true;
    L5:
        return false;
    }

    public DisplayAccessor b(VDConfig r8) {
        o.e(r8, "config");
        if (a(r8) == true) goto L7;
        Loog.INSTANCE.w(TAG, "createVD() is not supported on this platform.");
        return null;
    L7:
        if (r8.getType() == VDConfig.Type.DefaultOperatingSpace) goto L10;
        Loog.INSTANCE.w(TAG, "Calling with incompatible type: " + r8.getType());
        return null;
    L10:
        VirtualDisplayConfig.Builder r0 = new VirtualDisplayConfig.Builder(r8.getName(), r8.getWidthPixels(), r8.getHeightPixels(), r8.getDensityDpi());
        r0.setFlags(a());
        VirtualDisplay r1 = this.f30153c.createVirtualDisplay(r0.build());     // Catch: Throwable -> L17
        if (r1 != null) goto L16;
        Loog.INSTANCE.e(TAG, "createVD() failed (vd is null)");
        return null;
    L16:
        return (DisplayAccessor) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.display.vd.a(this.f30152b, r1, r8), DisplayAccessor.class, "com.obric.aiagent.plugin");
    L17:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "createVD() failed", th);
        return null;
    }

    public int a() {
        return ((((((((f30150d | f30151e) | f) | g) | h) | i) | j) | k) | l) | m;
    }
}
