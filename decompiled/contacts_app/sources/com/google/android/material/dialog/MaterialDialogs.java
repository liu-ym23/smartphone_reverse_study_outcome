package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    public static InsetDrawable insetDrawable(Drawable r7, Rect r8) {
        return new InsetDrawable(r7, r8.left, r8.top, r8.right, r8.bottom);
    }

    public static Rect getDialogBackgroundInsets(Context r7, int r8, int r9) {
        TypedArray r10 = ThemeEnforcement.obtainStyledAttributes(r7, null, R.styleable.MaterialAlertDialog, r8, r9, new int[0]);
        int r11 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int r0 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int r1 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int r2 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        r10.recycle();
        if (r7.getResources().getConfiguration().getLayoutDirection() != 1) goto L6;
        r1 = r11;
        r11 = r1;
    L6:
        return new Rect(r11, r0, r1, r2);
    }
}
