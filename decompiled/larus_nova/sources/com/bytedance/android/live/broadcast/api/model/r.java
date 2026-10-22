package com.bytedance.android.live.broadcast.api.model;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Range;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f59035a = null;

    static {
        f59035a = new z1(0);
    }

    @JvmStatic
    public static final boolean c() {
        Integer r100 = com.bytedance.android.livesdk.sharedpref.b.f158117a.a();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public static void a(int r100) {
        int r101 = Build.VERSION.SDK_INT;
        Object r102 = jc1.a.b().getApplicationContext().getSystemService("camera");
        if (r102 == null) goto L38;
        CameraCharacteristics r103 = ((CameraManager) r102).getCameraCharacteristics(String.valueOf(r100));     // Catch: Exception -> L34
        Integer r104 = (Integer) r103.get(CameraCharacteristics.LENS_FACING);     // Catch: Exception -> L34
        z1 r105 = f59035a;
        if (r101 < 30) goto L18;
        Range r106 = (Range) r103.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);     // Catch: Exception -> L34
        if (r106 != null) goto L11;
        return;
    L11:
        ALogger.i("CameraZoomManager", "isFront:" + r104 + ",range:" + ((Float) r106.getLower()) + "---" + ((Float) r106.getUpper()));     // Catch: Exception -> L34
        if (r104 != null) goto L15;
    L17:
        r105.f59054b = new a2(((Number) r106.getUpper()).floatValue(), ((Number) r106.getLower()).floatValue());     // Catch: Exception -> L34
        return;
    L15:
        if (r104.intValue() != 0) goto L17;
        r105.f59053a = new a2(((Number) r106.getUpper()).floatValue(), ((Number) r106.getLower()).floatValue());     // Catch: Exception -> L34
        return;
    L18:
        Float r107 = (Float) r103.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);     // Catch: Exception -> L34
        ALogger.i("CameraZoomManager", "isFront:" + r104 + ",range:" + r107);     // Catch: Exception -> L34
        if (r104 != null) goto L22;
    L29:
        if (r107 == null) goto L31;
        float r108 = r107.floatValue();     // Catch: Exception -> L34
    L32:
        r105.f59054b = new a2(r108, 1.0f);     // Catch: Exception -> L34
        return;
    L31:
        r108 = 1.0f;
        goto L32
    L22:
        if (r104.intValue() != 0) goto L29;
        if (r107 == null) goto L26;
        float r109 = r107.floatValue();     // Catch: Exception -> L34
    L27:
        r105.f59053a = new a2(r109, 1.0f);     // Catch: Exception -> L34
        return;
    L26:
        r109 = 1.0f;
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    public static a2 b(int r100) {
        z1 r101 = f59035a;
        if (r101.f59053a == null) goto L5;
    L7:
        if (r100 == 1) goto L13;
        if (r100 == 0) goto L14;
        return null;
    L14:
        return r101.f59054b;
    L13:
        return r101.f59053a;
    L5:
        if (r101.f59054b != null) goto L7;
        a(0);
        a(1);
        goto L7
    }

    @JvmStatic
    public static final void d(y1 r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "currentRatioEntry");
        boolean r102 = c();
        ALogger.i("CameraZoomManager", "set ratio:" + r101);
        if (r102 == false) goto L5;
        r100.f59046a = r101;
    L6:
        r100.f59048c = r101;
        return;
    L5:
        r100.f59047b = r101;
        goto L6
    }
}
