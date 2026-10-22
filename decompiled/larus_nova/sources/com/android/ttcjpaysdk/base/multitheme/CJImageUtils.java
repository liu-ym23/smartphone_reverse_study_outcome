package com.android.ttcjpaysdk.base.multitheme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J$\u0010\u0014\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0016\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0006J\n\u0010\u0017\u001a\u00020\u0012*\u00020\u0012J\f\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/multitheme/CJImageUtils;", "", "()V", "INVERSE_COLOR_MATRIX", "Landroid/graphics/ColorMatrix;", "applyInverseToBackground", "", "view", "Landroid/view/View;", "applyInverseToImageView", "", "imageView", "Landroid/widget/ImageView;", "removeInverseFromBackground", "originalDrawable", "Landroid/graphics/drawable/Drawable;", "removeInverseFromImageView", "toCircleBitmap", "Landroid/graphics/Bitmap;", "source", "toggleBackgroundInverse", "isInverted", "toggleImageViewInverse", "invert", "toBitmap", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJImageUtils {
    public static final CJImageUtils INSTANCE = null;
    private static final ColorMatrix INVERSE_COLOR_MATRIX = null;

    private CJImageUtils() {
    }

    static {
        INSTANCE = new CJImageUtils();
        INVERSE_COLOR_MATRIX = new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public final boolean applyInverseToBackground(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Drawable r101 = r100.getBackground();
        if (r101 != null) goto L9;
        return false;
    L9:
        if ((r101 instanceof BitmapDrawable) == false) goto L12;
        ((BitmapDrawable) r101).setColorFilter(new ColorMatrixColorFilter(INVERSE_COLOR_MATRIX));
        return true;
    L12:
        Bitmap r102 = toBitmap(r101);
        if (r102 == null) goto L15;
        Bitmap r103 = invert(r102);
    L16:
        if (r103 == null) goto L19;
        r100.setBackground(new BitmapDrawable(r100.getResources(), r103));
        return true;
    L19:
        return false;
    L15:
        r103 = null;
        goto L16
    }

    public final void applyInverseToImageView(ImageView r100) {
        if (r100 == null) goto L6;
        r100.setColorFilter(new ColorMatrixColorFilter(INVERSE_COLOR_MATRIX));
        return;
    }

    public final Bitmap invert(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        Bitmap.Config r103 = r100.getConfig();
        if (r103 != null) goto L5;
        r103 = Bitmap.Config.ARGB_8888;
    L5:
        Bitmap r104 = Bitmap.createBitmap(r101, r102, r103);
        Canvas r105 = new Canvas(r104);
        Paint r106 = new Paint();
        r106.setColorFilter(new ColorMatrixColorFilter(INVERSE_COLOR_MATRIX));
        r105.drawBitmap(r100, 0.0f, 0.0f, r106);
        return r104;
    }

    public final void removeInverseFromImageView(ImageView r100) {
        if (r100 == null) goto L5;
        r100.clearColorFilter();
        return;
    }

    public final Bitmap toBitmap(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BitmapDrawable) == true) goto L5;
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        if (r101 <= 0) goto L12;
        if (r102 <= 0) goto L14;
        Bitmap r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r100.setBounds(0, 0, r104.getWidth(), r104.getHeight());
        r100.draw(r104);
        return r103;
    L14:
        return null;
    L12:
        return null;
    L5:
        return ((BitmapDrawable) r100).getBitmap();
    }

    public final Bitmap toCircleBitmap(Bitmap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = Math.min(r100.getWidth(), r100.getHeight());
        float r102 = r101 / 2.0f;
        Bitmap r103 = Bitmap.createBitmap(r101, r101, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        r104.drawCircle(r102, r102, r102, r105);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r104.drawBitmap(r100, (r101 - r100.getWidth()) / 2.0f, (r101 - r100.getHeight()) / 2.0f, r105);
        return r103;
    }

    public final void removeInverseFromBackground(View r100, Drawable r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == null) goto L6;
        r100.setBackground(r101);
        return;
    L6:
        Drawable r102 = r100.getBackground();
        if ((r102 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r103 = (BitmapDrawable) r102;
    L10:
        if (r103 == null) goto L14;
        r103.clearColorFilter();
        return;
    L14:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void toggleImageViewInverse(ImageView r100, boolean r101) {
        if (r101 == false) goto L4;
        applyInverseToImageView(r100);
        return;
    L4:
        removeInverseFromImageView(r100);
    }

    public final void toggleBackgroundInverse(View r100, boolean r101, Drawable r102) {
        if (r101 == false) goto L4;
        applyInverseToBackground(r100);
        return;
    L4:
        removeInverseFromBackground(r100, r102);
    }

    public static /* synthetic */ void removeInverseFromBackground$default(CJImageUtils r100, View r101, Drawable r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.removeInverseFromBackground(r101, r102);
    }

    public static /* synthetic */ void toggleBackgroundInverse$default(CJImageUtils r100, View r101, boolean r102, Drawable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.toggleBackgroundInverse(r101, r102, r103);
    }
}
