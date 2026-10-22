package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable r100, int r101, int r102, Bitmap.Config r103) {
        if ((r100 instanceof BitmapDrawable) == false) goto L19;
        BitmapDrawable r104 = (BitmapDrawable) r100;
        if (r104.getBitmap() == null) goto L18;
        if (r103 == null) goto L10;
        if (r104.getBitmap().getConfig() != r103) goto L19;
    L10:
        if (r101 != r104.getBitmap().getWidth()) goto L16;
        if (r102 != r104.getBitmap().getHeight()) goto L16;
        return r104.getBitmap();
    L16:
        return Bitmap.createScaledBitmap(r104.getBitmap(), r101, r102, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        Rect r105 = r100.getBounds();
        int r106 = r105.left;
        int r107 = r105.top;
        int r108 = r105.right;
        int r109 = r105.bottom;
        if (r103 != null) goto L22;
        r103 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r110 = Bitmap.createBitmap(r101, r102, r103);
        r100.setBounds(0, 0, r101, r102);
        r100.draw(new Canvas(r110));
        r100.setBounds(r106, r107, r108, r109);
        return r110;
    }

    public static final Bitmap toBitmapOrNull(Drawable r100, int r101, int r102, Bitmap.Config r103) {
        if ((r100 instanceof BitmapDrawable) == false) goto L9;
        if (((BitmapDrawable) r100).getBitmap() != null) goto L9;
        return null;
    L9:
        return toBitmap(r100, r101, r102, r103);
    }

    public static final void updateBounds(Drawable r100, int r101, int r102, int r103, int r104) {
        r100.setBounds(r101, r102, r103, r104);
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable r100, int r101, int r102, Bitmap.Config r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.getIntrinsicWidth();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.getIntrinsicHeight();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = null;
    L12:
        return toBitmap(r100, r101, r102, r103);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable r100, int r101, int r102, Bitmap.Config r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.getIntrinsicWidth();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.getIntrinsicHeight();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = null;
    L12:
        return toBitmapOrNull(r100, r101, r102, r103);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.getBounds().left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.getBounds().top;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.getBounds().right;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.getBounds().bottom;
    L14:
        updateBounds(r100, r101, r102, r103, r104);
    }
}
