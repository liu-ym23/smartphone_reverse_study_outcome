package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context r10) {
        this(r10, null);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MaterialTextAppearance);
        int r13 = readFirstAvailableDimension(getContext(), r12, new int[]{R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight});
        r12.recycle();
        if (r13 < 0) goto L6;
        setLineHeight(r13);
        return;
    }

    private static boolean canApplyTextAppearanceLineHeight(Context r10) {
        return MaterialAttributes.resolveBoolean(r10, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme r10, @Nullable AttributeSet r11, int r12, int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.MaterialTextView, r12, r13);
        int r15 = r14.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        r14.recycle();
        return r15;
    }

    private static int readFirstAvailableDimension(@NonNull Context r10, @NonNull TypedArray r11, @NonNull @StyleableRes int... r12) {
        int r13 = 0;
        int r14 = -1;
    L4:
        if (r13 >= r12.length) goto L7;
        if (r14 >= 0) goto L7;
        r14 = MaterialResources.getDimensionPixelSize(r10, r11, r12[r13], -1);
        r13 = r13 + 1;
    L7:
        return r14;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context r10, @NonNull Resources.Theme r11, @Nullable AttributeSet r12, int r13, int r14) {
        TypedArray r15 = r11.obtainStyledAttributes(r12, R.styleable.MaterialTextView, r13, r14);
        int r16 = readFirstAvailableDimension(r10, r15, new int[]{R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight});
        r15.recycle();
        if (r16 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        if (canApplyTextAppearanceLineHeight(r10) == false) goto L6;
        applyLineHeightFromViewAppearance(r10.getTheme(), r11);
        return;
    }

    public MaterialTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, android.R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public MaterialTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        if (canApplyTextAppearanceLineHeight(r14) == false) goto L10;
        Resources.Theme r15 = r14.getTheme();
        if (viewAttrsHasLineHeight(r14, r15, r11, r12, r13) == true) goto L11;
        int r16 = findViewAppearanceResourceId(r15, r11, r12, r13);
        if (r16 == (-1)) goto L12;
        applyLineHeightFromViewAppearance(r15, r16);
        return;
    L12:
        return;
    L11:
        return;
    }
}
