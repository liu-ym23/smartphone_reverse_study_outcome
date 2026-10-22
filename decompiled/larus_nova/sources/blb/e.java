package blb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    static {
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x009e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:50331806), block:B:32:0x009e */
    public static Bitmap a(String r110, ImageInfo r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Intrinsics.checkNotNullParameter(r111, "sourceImageInfo");
        int r100 = Math.min(r111.f426421a, r111.f426422b);
        boolean r101 = true;
        if ((r100 % 2) != 1) goto L5;
        r100 = r100 + 1;
    L5:
        if (r100 <= r112) goto L10;
        int r102 = 1;
    L7:
        int r103 = r102 << 1;
        if (r103 > (r100 / r112)) goto L11;
        r102 = r103;
    L11:
        int r104 = RangesKt.coerceAtLeast(r102, 1);
        Closeable r105 = null;
        Bitmap r106 = null;
        r106 = null;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L37 Exception -> L39 OutOfMemoryError -> L47
        BitmapFactory.Options r113 = new BitmapFactory.Options();     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
        r113.inSampleSize = r104;     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
        Bitmap r114 = BitmapFactory.decodeStream(r107, null, r113);     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
    L63:
        com.ss.android.lark.image.uploader.utils.a.a(r107);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        com.ss.android.lark.image.uploader.utils.d r108 = com.ss.android.lark.image.uploader.utils.d.f426439a;     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        Intrinsics.checkNotNull(r114);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        Bitmap r115 = r108.a(r114, r111.f426426f);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        if (Intrinsics.areEqual(r114, r115) == true) goto L61;
        r114.recycle();     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        r114 = r115;
        goto L61
    L61:
    L23:
        Exception e100 = e;
    L42:
        int r116 = com.ss.android.lark.image.uploader.utils.c.f426438a;     // Catch: Throwable -> L31
        com.ss.android.lark.image.uploader.utils.c.b("SampleSizeCompressor", "image compress failed:" + e100, null, false);     // Catch: Throwable -> L31
        if (r101 == true) goto L46;
        if (r114 == null) goto L46;
        r114.recycle();     // Catch: Throwable -> L31
    L54:
        com.ss.android.lark.image.uploader.utils.a.a(r107);
        return r106;
    L46:
        r106 = r114;
    L25:
        OutOfMemoryError e101 = e;
    L50:
        int r117 = com.ss.android.lark.image.uploader.utils.c.f426438a;     // Catch: Throwable -> L31
        com.ss.android.lark.image.uploader.utils.c.b("SampleSizeCompressor", "image compress out of memory :" + e101.getMessage(), null, false);     // Catch: Throwable -> L31
        if (r101 == true) goto L46;
        if (r114 == null) goto L46;
        r114.recycle();     // Catch: Throwable -> L31
        goto L54
    L19:
        if (RangesKt.coerceAtMost(r114.getWidth(), r114.getHeight()) <= (((double) r112) * 1.1d)) goto L22;
        int r118 = r114.getWidth();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        int r109 = r114.getHeight();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        float r119 = (r112 * 1.0f) / RangesKt.coerceAtMost(r118, r109);     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        Bitmap r120 = Bitmap.createScaledBitmap(r114, (int) (r118 * r119), (int) (r109 * r119), false);     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        r114.recycle();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        r114 = r120;
        goto L22
    L22:
        com.ss.android.lark.image.uploader.utils.a.a(r107);
        return r114;
    L27:
        e100 = e;
    L41:
        r101 = false;
    L29:
        e101 = e;
    L49:
        r101 = false;
    L33:
        e = move-exception;
        e100 = e;
        r114 = null;
    L35:
        e = move-exception;
        e101 = e;
        r114 = null;
        goto L49
    L31:
        th = th;
        r105 = r5;
    L56:
        com.ss.android.lark.image.uploader.utils.a.a(r105);
        throw th;
    L39:
        e = move-exception;
        e100 = e;
        r114 = null;
        r107 = null;
    L47:
        e = move-exception;
        e101 = e;
        r114 = null;
        r107 = null;
    L37:
        th = th;
        goto L56
    L10:
        r102 = 1;
        goto L11
    }
}
