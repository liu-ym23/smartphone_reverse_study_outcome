package com.bytedance.android.ui.base.widget.icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0014\u001a\u00020\u000e2\b\b\u0003\u0010\u0015\u001a\u00020\u00072\b\b\u0003\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ui/base/widget/icon/IconImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colorStateList", "Landroid/content/res/ColorStateList;", "iconSize", "", "applyState", "", "drawableStateChanged", "initMatrix", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setIconColor", "res", "color", "setIconSize", "size", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IconImageView extends AppCompatImageView {
    private ColorStateList colorStateList;
    private float iconSize;

    public IconImageView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public IconImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void applyState() {
        ColorStateList r100 = this.colorStateList;
        if (r100 == null) goto L6;
        setColorFilter(new PorterDuffColorFilter(r100.getColorForState(getDrawableState(), -16777216), PorterDuff.Mode.SRC_IN));
        return;
    }

    private final void initMatrix() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        if (this.iconSize != 0.0f) goto L7;
        return;
    L7:
        if (getMeasuredWidth() <= 0) goto L21;
        int r100 = getDrawable().getIntrinsicWidth();
        int r101 = getDrawable().getIntrinsicHeight();
        if (r100 <= 0) goto L20;
        if (r101 <= 0) goto L22;
        ImageView.ScaleType r102 = getScaleType();
        ImageView.ScaleType r103 = ImageView.ScaleType.MATRIX;
        if (r102 == r103) goto L16;
        setScaleType(r103);
    L16:
        float r104 = Math.min(this.iconSize, getMeasuredWidth());
        float r105 = Math.min(this.iconSize, getMeasuredHeight());
        float r106 = r104 / r100;
        float r107 = r105 / r101;
        float r108 = (float) Math.rint((getMeasuredWidth() - r104) * 0.5f);
        float r109 = (float) Math.rint((getMeasuredHeight() - r105) * 0.5f);
        Matrix r110 = new Matrix();
        r110.setScale(r106, r107);
        r110.postTranslate(r108, r109);
        setImageMatrix(r110);
        return;
    L22:
        return;
    L20:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        applyState();
    }

    public final void setIconColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colorStateList");
        this.colorStateList = r100;
        applyState();
    }

    public final void setIconSize(float r100) {
        if (this.iconSize == r100) goto L6;
        this.iconSize = r100;
        initMatrix();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        initMatrix();
    }

    public final void setIconColor(int r100, int r101) {
        if (r100 == 0) goto L4;
        this.colorStateList = ContextCompat.getColorStateList(getContext(), r100);
    L6:
        applyState();
        return;
    L4:
        if (r101 == 0) goto L6;
        this.colorStateList = ColorStateList.valueOf(r101);
        goto L6
    }

    public IconImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon_color, R.attr.icon_size});
        this.colorStateList = r103.getColorStateList(0);
        this.iconSize = r103.getDimension(1, 0.0f);
        r103.recycle();
        applyState();
        return;
    }

    public /* synthetic */ IconImageView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void setIconColor$default(IconImageView r100, int r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = 0;
    L7:
        if ((r103 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        r100.setIconColor(r101, r102);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconColor");
    }
}
