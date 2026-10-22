package com.bytedance.android.livesdk.utils;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158940a = 0;

    @JvmStatic
    public static final int b() {
        return c(1, false);
    }

    @JvmStatic
    public static final int p() {
        Integer r100 = j40.r2.f497292a.getValue();
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        return 0;
    L11:
        if (r100.intValue() != 2) goto L13;
        return 2;
    L6:
        if (r100.intValue() != 1) goto L8;
        return 1;
    }

    @JvmStatic
    public static final int a() {
        Object r100 = com.bytedance.android.live.core.utils.s1.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Integer r101 = null;
        if ((r100 instanceof WindowManager) == true) goto L5;
        r100 = null;
    L5:
        WindowManager r102 = (WindowManager) r100;
        if (r102 == null) goto L10;
        Display r103 = r102.getDefaultDisplay();
        if (r103 == null) goto L10;
        r101 = Integer.valueOf(r103.getRotation());
    L10:
        ALogger.d("OrientationUtils", "realOrientation:" + r101);
        if (r101 != null) goto L14;
    L16:
        if (r101 != null) goto L19;
    L21:
        if (r101 != null) goto L24;
    L26:
        if (r101 != null) goto L29;
        return 1;
    L29:
        if (r101.intValue() != 3) goto L34;
        return 8;
    L34:
        return 1;
    L24:
        if (r101.intValue() != 2) goto L26;
        return 9;
    L19:
        if (r101.intValue() != 1) goto L21;
        return 0;
    L14:
        if (r101.intValue() != 0) goto L16;
        return 1;
    }

    @JvmStatic
    public static final int d() {
        if (PadConfigUtils.c() == false) goto L6;
        return 13;
    L6:
        j40.g1.f497226a.getValue().booleanValue();
        return 6;
    }

    @JvmStatic
    public static final boolean l() {
        Resources r100 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r100 == null) goto L7;
        Configuration r101 = r100.getConfiguration();
        if (r101 == null) goto L7;
        int r102 = r101.orientation;
    L9:
        if (PadConfigUtils.c() == false) goto L19;
        Resources r103 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r103 == null) goto L17;
        Configuration r104 = r103.getConfiguration();
        if (r104 == null) goto L17;
        if (r104.orientation != 2) goto L17;
        return true;
    L17:
        return false;
    L19:
        return i(r102);
    L7:
        r102 = 1;
        goto L9
    }

    @JvmStatic
    public static final boolean n() {
        Resources r100 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r100 == null) goto L9;
        Configuration r101 = r100.getConfiguration();
        if (r101 == null) goto L9;
        if (r101.orientation != 2) goto L9;
        return true;
    L9:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final boolean f(int r100) {
        if (PadConfigUtils.c() == false) goto L6;
        PadConfigUtils.e(com.bytedance.android.live.core.utils.s1.getContext());
        return false;
    L6:
        return i(r100);
    }

    @JvmStatic
    public static final boolean g(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return f(r100.getRequestedOrientation());
    }

    @JvmStatic
    public static final boolean i(int r100) {
        if (r100 != 0) goto L4;
        return true;
    L4:
        if (r100 != 8) goto L6;
        return true;
    L6:
        if (j40.g1.f497226a.getValue().booleanValue() == true) goto L8;
        return false;
    L8:
        if (r100 == 6) goto L16;
        return false;
    L16:
        return true;
    }

    @Deprecated(message = "pad 兼容好像有问题")
    @JvmStatic
    public static final boolean j(Activity r100) {
        if (PadConfigUtils.c() == false) goto L6;
        PadConfigUtils.c();
    L6:
        if (PadConfigUtils.c() == false) goto L9;
        PadConfigUtils.c();
        return false;
    L9:
        if (r100 != null) goto L11;
    L12:
        if (r100 == null) goto L16;
        if (r100.getRequestedOrientation() != 8) goto L16;
        return true;
    L16:
        if (j40.g1.f497226a.getValue().booleanValue() == false) goto L22;
        if (r100 == null) goto L22;
        if (r100.getRequestedOrientation() != 6) goto L22;
        return true;
    L22:
        return false;
    L11:
        if (r100.getRequestedOrientation() != 0) goto L12;
        return true;
    }

    @JvmStatic
    public static final boolean k(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Settings.System.getInt(r100.getContentResolver(), "accelerometer_rotation", 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final boolean m(int r100) {
        if (PadConfigUtils.c() == false) goto L13;
        Resources r101 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r101 == null) goto L11;
        Configuration r102 = r101.getConfiguration();
        if (r102 == null) goto L11;
        if (r102.orientation != 2) goto L11;
        return true;
    L11:
        return false;
    L13:
        return i(r100);
    }

    @JvmStatic
    public static final boolean o(int r100) {
        if (PadConfigUtils.c() == false) goto L6;
        if (r100 == 2) goto L10;
    L8:
        return false;
    L10:
        return true;
    L6:
        if (r100 != 2) goto L8;
        return true;
    }

    @JvmStatic
    public static final int c(int r100, boolean r101) {
        if (PadConfigUtils.c() == false) goto L7;
        if (r101 == false) goto L7;
        return r100;
    L7:
        if (PadConfigUtils.c() == false) goto L10;
        PadConfigUtils.c();
        return 13;
    L10:
        return r100;
    }

    @JvmStatic
    public static final boolean h(Boolean r100, int r101) {
        if (PadConfigUtils.c() == false) goto L9;
        if (PadConfigUtils.e(com.bytedance.android.live.core.utils.s1.getContext()) == false) goto L11;
        return false;
    L11:
        return Intrinsics.areEqual(r100, Boolean.FALSE);
    L9:
        return i(r101);
    }

    @JvmStatic
    public static final int e(Activity r100, boolean r101, int r102) {
        if (p() != 1) goto L5;
    L6:
        if (r100 != null) goto L8;
    L16:
        if (p() != 0) goto L19;
        return 0;
    L19:
        return d();
    L8:
        if (k(r100) == false) goto L14;
        if (r101 == true) goto L14;
        if (r102 != 8) goto L14;
        return 8;
    L14:
        return 0;
    L5:
        if (p() != 2) goto L16;
        goto L6
    }
}
