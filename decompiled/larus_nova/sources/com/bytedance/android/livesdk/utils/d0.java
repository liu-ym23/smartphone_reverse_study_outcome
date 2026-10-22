package com.bytedance.android.livesdk.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158926a = 0;

    static {
    }

    public static boolean a(Bitmap r100, int r101, int r110, Bitmap r111) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r111, "croppedBitmap");
        int r102 = RangesKt.coerceAtMost(r111.getWidth(), r100.getWidth() - r101);
        int r103 = RangesKt.coerceAtMost(r111.getHeight(), r100.getHeight() - r110);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L16;
        int r105 = RangesKt.coerceAtLeast(r103 - 10, 0);
    L5:
        if (r105 >= r103) goto L15;
        if (r100.getPixel(r101 + r104, r110 + r105) == r111.getPixel(r104, r105)) goto L14;
        return false;
    L14:
        r105 = r105 + 1;
        goto L5
    L12:
        e = move-exception;
        ALogger.e("BitmapCropHelper", e);
    L10:
        e = move-exception;
        ALogger.e("BitmapCropHelper", e);
        goto L14
    L15:
        r104 = r104 + 1;
        goto L3
    L16:
        return true;
    }

    public static boolean b(Bitmap r100, String r101, String r102, boolean r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "dirPath");
        Intrinsics.checkNotNullParameter(r102, "name");
        if ((!Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) == false) goto L6;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed, not mounted");
        return false;
    L6:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == false) goto L9;
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.getPath() + HTTP.URL_DEFAULT + r102);
    L47:
        e = move-exception;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed(catch1) ", e);
        return false;
    L14:
        if (r104.exists() == false) goto L16;
    L19:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);
        ALogger.d("BitmapCropHelper", "the size of the cropped picture before compression: " + r104.length());
        if (r110 == true) goto L55;
    L24:
        boolean r106 = r100.compress(Bitmap.CompressFormat.PNG, 100, r105);     // Catch: Throwable -> L33 Exception -> L35
    L25:
        if (r106 == true) goto L27;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed, compress failed");     // Catch: Throwable -> L33 Exception -> L35
    L27:
        r105.flush();     // Catch: Throwable -> L33 Exception -> L35
        r105.close();     // Catch: Exception -> L30
        r100.recycle();     // Catch: Exception -> L30
    L32:
        return r106;
    L30:
        e = move-exception;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed(catch3) ", e);
        goto L32
    L35:
        e = move-exception;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed(catch2) ", e);     // Catch: Throwable -> L33
        r105.close();     // Catch: Exception -> L39
        r100.recycle();     // Catch: Exception -> L39
    L41:
        return false;
    L39:
        e = move-exception;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed(catch3) ", e);
        goto L41
    L55:
        if (r100.getByteCount() <= r111) goto L24;
        double r112 = Math.sqrt(((double) r100.getByteCount()) / ((double) r111));     // Catch: Throwable -> L33 Exception -> L35
        r106 = Bitmap.createScaledBitmap(r100, (int) (((double) r100.getWidth()) / r112), (int) (((double) r100.getHeight()) / r112), true).compress(Bitmap.CompressFormat.PNG, 100, r105);     // Catch: Throwable -> L33 Exception -> L35
    L33:
        th = move-exception;
        r105.close();     // Catch: Exception -> L44
        r100.recycle();     // Catch: Exception -> L44
    L46:
        throw th;
    L44:
        e = move-exception;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed(catch3) ", e);
        goto L46
    L16:
        if (r104.createNewFile() == true) goto L19;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed, createNewFile failed");     // Catch: Exception -> L47
        return false;
    L9:
        if (r103.mkdirs() == true) goto L12;
        ALogger.e("BitmapCropHelper", "saveBitmapToSD failed, mkdirs failed");
        return false;
    }
}
