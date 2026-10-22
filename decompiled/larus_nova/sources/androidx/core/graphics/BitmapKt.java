package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n¨\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", MonitorConstants.CONNECT_TYPE_GET, "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap r100, Function1<? super Canvas, Unit> r101) {
        r101.invoke(new Canvas(r100));
        return r100;
    }

    public static final boolean contains(Bitmap r100, PointF r101) {
        float r102 = r101.x;
        if (r102 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r102 >= r100.getWidth()) goto L11;
        float r103 = r101.y;
        if (r103 < 0.0f) goto L11;
        if (r103 >= r100.getHeight()) goto L11;
        return true;
    }

    public static final boolean contains(Bitmap r100, Point r101) {
        int r102 = r100.getWidth();
        int r103 = r101.x;
        if (r103 < 0) goto L6;
        if (r103 >= r102) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L13;
        int r105 = r101.y;
        if (r105 < 0) goto L13;
        if (r105 >= r100.getHeight()) goto L13;
        return true;
    L13:
        return false;
    L6:
        r104 = false;
        goto L7
    }

    public static final Bitmap createBitmap(int r100, int r101, Bitmap.Config r102) {
        return Bitmap.createBitmap(r100, r101, r102);
    }

    public static final int get(Bitmap r100, int r101, int r102) {
        return r100.getPixel(r101, r102);
    }

    public static final Bitmap scale(Bitmap r100, int r101, int r102, boolean r103) {
        return Bitmap.createScaledBitmap(r100, r101, r102, r103);
    }

    public static final void set(Bitmap r100, int r101, int r102, int r103) {
        r100.setPixel(r101, r102, r103);
    }

    public static final Bitmap createBitmap(int r100, int r101, Bitmap.Config r102, boolean r103, ColorSpace r104) {
        return Bitmap.createBitmap(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r100, int r101, Bitmap.Config r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = Bitmap.Config.ARGB_8888;
    L6:
        return Bitmap.createBitmap(r100, r101, r102);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = true;
    L6:
        return Bitmap.createScaledBitmap(r100, r101, r102, r103);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r100, int r101, Bitmap.Config r102, boolean r103, ColorSpace r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r102 = Bitmap.Config.ARGB_8888;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = true;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r104 = ColorSpace.get(ColorSpace.Named.SRGB);
    L12:
        return Bitmap.createBitmap(r100, r101, r102, r103, r104);
    }
}
