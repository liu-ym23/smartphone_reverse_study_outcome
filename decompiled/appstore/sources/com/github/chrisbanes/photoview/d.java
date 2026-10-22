package com.github.chrisbanes.photoview;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10325a = null;

        static {
            int[] r10 = new int[ImageView.ScaleType.values().length];
            f10325a = r10;
            r10[ImageView.ScaleType.MATRIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public static void a(float r10, float r11, float r12) {
        if (r10 >= r11) goto L10;
        if (r11 >= r12) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    L10:
        throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }

    public static int b(int r10) {
        return (r10 & 65280) >> 8;
    }

    public static boolean c(ImageView r10) {
        if (r10.getDrawable() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d(ImageView.ScaleType r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (a.f10325a[r10.ordinal()] == 1) goto L9;
        return true;
    L9:
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
