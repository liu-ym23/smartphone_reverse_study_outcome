package com.android.ttcjpaysdk.ocr.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.hardware.Camera;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.router.CJRouteOutMonitorUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.view.CJOcrTransferActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import f06.b;
import f06.c;
import f06.d;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class OCRCodeUtil {
    public OCRCodeUtil() {
    }

    public static boolean cameraIsCanUse() {
        return true;
    }

    public static int clamp(int r100, int r101, int r102) {
        if (r100 >= r101) goto L4;
        return r101;
    L4:
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        return r100;
    }

    public static boolean isHasCameraPermission() {
        ICJPayBPEAService r100 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Exception -> L13
        if (r100 == null) goto L6;
        Camera r101 = r100.openCamera("bpea-cjpay_android_open_camera_util");     // Catch: Exception -> L13
    L7:
        Field r102 = r101.getClass().getDeclaredField("mHasPermission");     // Catch: Exception -> L13
        r102.setAccessible(true);     // Catch: Exception -> L13
        Boolean r103 = (Boolean) r102.get(r101);     // Catch: Exception -> L13
        if (r100 == null) goto L10;
        r100.releaseCamera(r101, "bpea-cjpay_android_release_camera_util");     // Catch: Exception -> L13
    L11:
        return r103.booleanValue();
    L10:
        com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_android_hardware_Camera_release(r101);     // Catch: Exception -> L13
        goto L11
    L6:
        r101 = com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_android_hardware_Camera_open();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#isHasCameraPermission", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeUtil#isHasCameraPermission", e);
        e.printStackTrace();
        return true;
    }

    private static Camera com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_android_hardware_Camera_open() {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r110 = new b();
        d r111 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r110);
        if (r111.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r110, false);
        return (Camera) r111.f474983b;
    L6:
        Camera r112 = Camera.open();
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r112, r110, true);
        return r112;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static byte[] bitmap2Bytes(Bitmap r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r100.compress(Bitmap.CompressFormat.JPEG, 100, r101);
        return r101.toByteArray();
    }

    private static void com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_android_hardware_Camera_release(Camera r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    public static Point getScreenResolution(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r102 = new Point();
        r101.getSize(r102);
        return r102;
    }

    public static void startAppDetailSetting(Context r100) {
        Intent r101 = new Intent();     // Catch: Throwable -> L4
        r101.addFlags(268435456);     // Catch: Throwable -> L4
        r101.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Throwable -> L4
        r101.setData(Uri.fromParts("package", r100.getPackageName(), null));     // Catch: Throwable -> L4
        CJRouteOutMonitorUtils.INSTANCE.injectRouteOutCertIdToIntent("41489154", r101);     // Catch: Throwable -> L4
        r100.startActivity(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#startAppDetailSetting", th);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeUtil#startAppDetailSetting", th);
        th.printStackTrace();
    }

    public static int dp2px(Context r100, float r101) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_utils_OCRCodeUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static Bitmap makeTintBitmap(Bitmap r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), r100.getConfig());
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        r104.setColorFilter(new PorterDuffColorFilter(r101, PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, 0.0f, 0.0f, r104);
        return r102;
    }

    public static Bitmap readUriToBitmap(Context r100, Uri r101) {
        InputStream r102 = null;
        Bitmap r103 = null;
        r103 = null;
        InputStream r104 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: Throwable -> L14 FileNotFoundException -> L16
        r103 = BitmapFactory.decodeStream(r104);     // Catch: Throwable -> L10 FileNotFoundException -> L12
        r104.close();     // Catch: IOException -> L7
    L23:
        return r103;
    L7:
        e = e;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#readUriToBitmap", e);
        StringBuilder r105 = new StringBuilder("");
    L9:
        r105.append(e.getMessage());
        CJLogger.b("readUriToBitmap close", r105.toString());
    L12:
        e = e;
    L18:
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#readUriToBitmap", e);     // Catch: Throwable -> L10
        CJLogger.b("readUriToBitmap", "" + e.getMessage());     // Catch: Throwable -> L10
        r104.close();     // Catch: IOException -> L21
    L21:
        e = e;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#readUriToBitmap", e);
        r105 = new StringBuilder("");
    L10:
        th = th;
        r102 = r104;
    L31:
        r102.close();     // Catch: IOException -> L26
    L28:
        throw th;
    L26:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#readUriToBitmap", e);
        CJLogger.b("readUriToBitmap close", "" + e.getMessage());
        goto L28
    L16:
        e = e;
        r104 = null;
    L14:
        th = th;
        goto L31
    }

    public static void startAppDetailSetting(Activity r100, final Function1<Boolean, Unit> r101) {
        Intent r102 = new Intent();     // Catch: Throwable -> L10
        r102.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Throwable -> L10
        r102.setData(Uri.fromParts("package", r100.getPackageName(), null));     // Catch: Throwable -> L10
        if (r100 != null) goto L5;
    L7:
        if (r101 == null) goto L15;
        r101.invoke(Boolean.FALSE);     // Catch: Throwable -> L10
    L15:
        return;
    L5:
        if (r100.isFinishing() == true) goto L7;
        CJOcrTransferActivity.startOcrTransferActivity(r100, r102, new AnonymousClass1(r101));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r101 == null) goto L13;
        r101.invoke(Boolean.FALSE);
    L13:
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#startAppDetailSettingWithCallback", th);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeUtil#startAppDetailSettingWithCallback", th);
    }

    public static float distance(float r100, float r101, float r102, float r103) {
        float r104 = r100 - r102;
        float r105 = r101 - r103;
        return (float) Math.sqrt((r104 * r104) + (r105 * r105));
    }

    public static String createIdentityResult(String r100, String r101, String r102, int r103, String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L4
        r105.put("type", r100);     // Catch: Exception -> L4
        r105.put("id_name", r101);     // Catch: Exception -> L4
        r105.put("id_code", r102);     // Catch: Exception -> L4
        r105.put("card_input_type", r103);     // Catch: Exception -> L4
        r105.put("msg", r104);     // Catch: Exception -> L4
        return r105.toString();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#createIdentityResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeUtil#createIdentityResult", e);
        return null;
    }

    public static String createResult(String r100, String r101, String r102, int r103, String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L4
        r105.put("type", r100);     // Catch: Exception -> L4
        r105.put("result", r101);     // Catch: Exception -> L4
        r105.put("cropped_img", r102);     // Catch: Exception -> L4
        r105.put("card_input_type", r103);     // Catch: Exception -> L4
        r105.put("msg", r104);     // Catch: Exception -> L4
        return r105.toString();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeUtil#createResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeUtil#createResult", e);
        return null;
    }
}
