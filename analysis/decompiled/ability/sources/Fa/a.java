package Fa;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Size;
import com.stepos.statsrpk.service.c;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a {
    public static String a(Bitmap bitmap) throws Exception {
        k.f(bitmap, "bitmap");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            k.c(strEncodeToString);
            return strEncodeToString;
        } catch (Exception e) {
            c.n("Bitmap to Base64 failed: ", e.getMessage(), "Bitmap2Base64Converter");
            throw e;
        }
    }

    public static String b(a aVar, Bitmap bitmap, Size size) {
        aVar.getClass();
        k.f(bitmap, "bitmap");
        if (size == null) {
            return a(bitmap);
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, size.getWidth(), size.getHeight(), true);
        try {
            return a(bitmapCreateScaledBitmap);
        } finally {
            if (bitmapCreateScaledBitmap != bitmap && !bitmapCreateScaledBitmap.isRecycled()) {
                bitmapCreateScaledBitmap.recycle();
            }
        }
    }
}
