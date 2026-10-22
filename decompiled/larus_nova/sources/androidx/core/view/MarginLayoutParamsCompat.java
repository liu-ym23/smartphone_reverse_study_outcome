package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams r100) {
        int r101 = r100.getLayoutDirection();
        if (r101 != 0) goto L5;
        return r101;
    L5:
        if (r101 == 1) goto L9;
        return 0;
    L9:
        return r101;
    }

    @ReplaceWith(expression = "lp.getMarginEnd()")
    public static int getMarginEnd(ViewGroup.MarginLayoutParams r100) {
        return r100.getMarginEnd();
    }

    @ReplaceWith(expression = "lp.getMarginStart()")
    public static int getMarginStart(ViewGroup.MarginLayoutParams r100) {
        return r100.getMarginStart();
    }

    @ReplaceWith(expression = "lp.isMarginRelative()")
    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams r100) {
        return r100.isMarginRelative();
    }

    @ReplaceWith(expression = "lp.resolveLayoutDirection(layoutDirection)")
    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r100, int r101) {
        r100.resolveLayoutDirection(r101);
    }

    @ReplaceWith(expression = "lp.setLayoutDirection(layoutDirection)")
    public static void setLayoutDirection(ViewGroup.MarginLayoutParams r100, int r101) {
        r100.setLayoutDirection(r101);
    }

    @ReplaceWith(expression = "lp.setMarginEnd(marginEnd)")
    public static void setMarginEnd(ViewGroup.MarginLayoutParams r100, int r101) {
        r100.setMarginEnd(r101);
    }

    @ReplaceWith(expression = "lp.setMarginStart(marginStart)")
    public static void setMarginStart(ViewGroup.MarginLayoutParams r100, int r101) {
        r100.setMarginStart(r101);
    }
}
