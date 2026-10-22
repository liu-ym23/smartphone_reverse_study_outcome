package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.log.Log;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;
    private static final String TAG = "WebpBitmapFactory";

    public WebpBitmapFactory() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native Bitmap nativeDecodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103, float r104, byte[] r105);

    private static native Bitmap nativeDecodeStream(InputStream r100, BitmapFactory.Options r101, float r102, byte[] r103);

    static {
        INVOKESTATIC_com_bumptech_glide_integration_webp_WebpBitmapFactory_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("glide-webp");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bumptech_glide_integration_webp_WebpBitmapFactory_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_integration_webp_WebpBitmapFactory_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static Bitmap decodeFile(String r100) {
        return decodeFile(r100, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor r100) {
        return decodeFileDescriptor(r100, null, null);
    }

    public static Bitmap decodeStream(InputStream r100) {
        return decodeStream(r100, null, null);
    }

    private static byte[] getImageHeader(InputStream r100) {
        if (r100.markSupported() == true) goto L5;
        r100 = new BufferedInputStream(r100, 21);
    L5:
        r100.mark(21);
        byte[] r101 = new byte[21];
        r100.read(r101, 0, 21);     // Catch: IOException -> L8
        r100.reset();     // Catch: IOException -> L8
        return r101;
    L8:
        return null;
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options r100) {
        if (r100 == null) goto L7;
        byte[] r101 = r100.inTempStorage;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new byte[8192];
    }

    private static float getScaleFromOptions(BitmapFactory.Options r100) {
        float r101 = 1.0f;
        if (r100 == null) goto L15;
        int r102 = r100.inSampleSize;
        if (r102 <= 1) goto L8;
        r101 = 1.0f / r102;
    L8:
        if (r100.inScaled == false) goto L16;
        int r103 = r100.inDensity;
        int r104 = r100.inTargetDensity;
        int r105 = r100.inScreenDensity;
        if (r103 == 0) goto L17;
        if (r104 == 0) goto L18;
        if (r103 != r105) goto L14;
        return r101;
    L14:
        return r104 / r103;
    L18:
        return r101;
    L17:
        return r101;
    L16:
        return r101;
    L15:
        return 1.0f;
    }

    private static void setDefaultPadding(Rect r100) {
        if (r100 == null) goto L5;
        r100.top = -1;
        r100.left = -1;
        r100.bottom = -1;
        r100.right = -1;
        return;
    }

    private static InputStream wrapToMarkSupportedStream(InputStream r100) {
        if (r100.markSupported() == false) goto L5;
        return r100;
    L5:
        return new BufferedInputStream(r100, 8192);
    }

    public static Bitmap decodeFile(String r100, BitmapFactory.Options r101) {
        PolarisFileInputStreamWrapper r102 = null;
        Bitmap r103 = null;
        r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L9 Exception -> L11
        r103 = decodeStream(r104, null, r101);     // Catch: Exception -> L7 Throwable -> L17
    L28:
        r104.close();     // Catch: IOException -> L22
    L16:
        return r103;
    L7:
        e = e;
    L13:
        Log.e(TAG, "Unable to decode stream: " + e.toString());     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
    L17:
        th = th;
        r102 = r104;
    L19:
        if (r102 != null) goto L26;
    L21:
        throw th;
    L26:
        r102.close();     // Catch: IOException -> L23
        goto L21
    L11:
        e = e;
        r104 = null;
    L9:
        th = th;
        goto L19
    }

    public static Bitmap decodeResource(Resources r100, int r101) {
        return decodeResource(r100, r101, null);
    }

    private static void setDensityFromOptions(Bitmap r100, BitmapFactory.Options r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L27;
        int r102 = r101.inDensity;
        if (r102 == 0) goto L18;
        r100.setDensity(r102);
        int r103 = r101.inTargetDensity;
        if (r103 == 0) goto L16;
        if (r102 != r103) goto L11;
        return;
    L11:
        if (r102 != r101.inScreenDensity) goto L14;
        return;
    L14:
        if (r101.inScaled == false) goto L24;
        r100.setDensity(r103);
        return;
    L24:
        return;
    L16:
        return;
    L18:
        if (r101.inBitmap == null) goto L26;
        r100.setDensity(160);
        return;
    L26:
        return;
    L27:
        return;
    }

    private static void setWebpBitmapOptions(Bitmap r100, BitmapFactory.Options r101) {
        setDensityFromOptions(r100, r101);
        if (r101 == null) goto L6;
        r101.outMimeType = MimeType.WEBP;
        return;
    }

    private static Bitmap createBitmap(int r100, int r101, BitmapFactory.Options r102) {
        if (r102 == null) goto L9;
        Bitmap r103 = r102.inBitmap;
        if (r103 == null) goto L9;
        if (r103.isMutable() == false) goto L9;
        return r102.inBitmap;
    L9:
        Bitmap r104 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
        r104.setHasAlpha(true);
        r104.eraseColor(0);
        return r104;
    }

    public static Bitmap decodeByteArray(byte[] r100, int r101, int r102) {
        return decodeByteArray(r100, r101, r102, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor r100, Rect r101, BitmapFactory.Options r102) {
        InputStream r103 = wrapToMarkSupportedStream(new PolarisFileInputStreamWrapper(r100));
    L9:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L13
    L11:
        throw th;
    L4:
        if (webpSupportRequired(getImageHeader(r103), 0, 21) == false) goto L6;
        Bitmap r104 = nativeDecodeStream(r103, r102, getScaleFromOptions(r102), getInTempStorageFromOptions(r102));     // Catch: Throwable -> L9
        setWebpBitmapOptions(r104, r102);     // Catch: Throwable -> L9
        setDefaultPadding(r101);     // Catch: Throwable -> L9
    L14:
        r103.close();     // Catch: Throwable -> L12
    L8:
        return r104;
    L6:
        r104 = BitmapFactory.decodeFileDescriptor(r100, r101, r102);     // Catch: Throwable -> L9
        goto L14
    }

    public static Bitmap decodeResource(Resources r100, int r101, BitmapFactory.Options r102) {
        InputStream r103 = null;
        Bitmap r104 = null;
        r104 = null;
        TypedValue r105 = new TypedValue();     // Catch: Throwable -> L11 Exception -> L15
        InputStream r106 = r100.openRawResource(r101, r105);     // Catch: Throwable -> L11 Exception -> L15
    L34:
        r104 = decodeResourceStream(r100, r105, r106, null, r102);     // Catch: Throwable -> L9 Exception -> L27
        if (r106 != null) goto L28;
    L18:
        if (r104 != null) goto L25;
        if (r102 == null) goto L25;
        if (r102.inBitmap == null) goto L25;
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    L25:
        return r104;
    L28:
        r106.close();     // Catch: IOException -> L8
        goto L18
    L9:
        th = th;
        r103 = r106;
    L12:
        if (r103 != null) goto L30;
    L14:
        throw th;
    L30:
        r103.close();     // Catch: IOException -> L26
    L16:
        if (r106 == null) goto L18;
    L15:
        r106 = null;
    L11:
        th = th;
        goto L12
    }

    public static Bitmap decodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        InputStream r103 = wrapToMarkSupportedStream(r100);
        if (webpSupportRequired(getImageHeader(r103), 0, 21) == false) goto L9;
        Bitmap r104 = nativeDecodeStream(r103, r102, getScaleFromOptions(r102), getInTempStorageFromOptions(r102));
        setWebpBitmapOptions(r104, r102);
        setDefaultPadding(r101);
        return r104;
    L9:
        return BitmapFactory.decodeStream(r103, r101, r102);
    }

    private static boolean setOutDimensions(BitmapFactory.Options r100, int r101, int r102) {
        if (r100 == null) goto L5;
        r100.outWidth = r101;
        r100.outHeight = r102;
        return r100.inJustDecodeBounds;
    L5:
        return false;
    }

    public static boolean webpSupportRequired(byte[] r100, int r101, int r102) {
        WebpHeaderParser.getType(r100, r101, r102);     // Catch: IOException -> L4
        return false;
    L4:
        WebpHeaderParser.WebpImageType r103 = WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
        return false;
    }

    public static Bitmap decodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r110) {
        if ((r101 | r102) < 0) goto L12;
        if (r100.length < (r101 + r102)) goto L12;
        if (webpSupportRequired(r100, r101, r102) == false) goto L10;
        Bitmap r103 = nativeDecodeByteArray(r100, r101, r102, r110, getScaleFromOptions(r110), getInTempStorageFromOptions(r110));
        setWebpBitmapOptions(r103, r110);
        return r103;
    L10:
        return BitmapFactory.decodeByteArray(r100, r101, r102, r110);
    L12:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static Bitmap decodeResourceStream(Resources r100, TypedValue r101, InputStream r102, Rect r103, BitmapFactory.Options r104) {
        if (r104 != null) goto L5;
        r104 = new BitmapFactory.Options();
    L5:
        if (r104.inDensity != 0) goto L14;
        if (r101 == null) goto L14;
        int r105 = r101.density;
        if (r105 != 0) goto L11;
        r104.inDensity = 160;
        goto L14
    L11:
        if (r105 == 65535) goto L14;
        r104.inDensity = r105;
    L14:
        if (r104.inTargetDensity != 0) goto L18;
        if (r100 == null) goto L18;
        r104.inTargetDensity = INVOKEVIRTUAL_com_bumptech_glide_integration_webp_WebpBitmapFactory_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100).densityDpi;
    L18:
        return decodeStream(r102, r103, r104);
    }
}
