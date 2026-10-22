package com.bytedance.android.ui.base.widget.icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ui/base/widget/icon/IconTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomColorStateList", "Landroid/content/res/ColorStateList;", "bottomIconSize", "endColorStateList", "endIconSize", "startColorStateList", "startIconSize", "topColorStateList", "topIconSize", "applyState", "", "drawableStateChanged", "setCompoundDrawablesBounds", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IconTextView extends AppCompatTextView {
    private ColorStateList bottomColorStateList;
    private int bottomIconSize;
    private ColorStateList endColorStateList;
    private int endIconSize;
    private ColorStateList startColorStateList;
    private int startIconSize;
    private ColorStateList topColorStateList;
    private int topIconSize;

    public IconTextView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public IconTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void applyState() {
        ColorStateList r100 = this.startColorStateList;
        if (r100 == null) goto L7;
        int r101 = r100.getColorForState(getDrawableState(), -16777216);
        Drawable r102 = getCompoundDrawables()[0];
        if (r102 == null) goto L7;
        r102.setColorFilter(new PorterDuffColorFilter(r101, PorterDuff.Mode.SRC_IN));
    L7:
        ColorStateList r103 = this.topColorStateList;
        if (r103 == null) goto L12;
        int r104 = r103.getColorForState(getDrawableState(), -16777216);
        Drawable r105 = getCompoundDrawables()[1];
        if (r105 == null) goto L12;
        r105.setColorFilter(new PorterDuffColorFilter(r104, PorterDuff.Mode.SRC_IN));
    L12:
        ColorStateList r106 = this.endColorStateList;
        if (r106 == null) goto L17;
        int r107 = r106.getColorForState(getDrawableState(), -16777216);
        Drawable r108 = getCompoundDrawables()[2];
        if (r108 == null) goto L17;
        r108.setColorFilter(new PorterDuffColorFilter(r107, PorterDuff.Mode.SRC_IN));
    L17:
        ColorStateList r109 = this.bottomColorStateList;
        if (r109 == null) goto L23;
        int r110 = r109.getColorForState(getDrawableState(), -16777216);
        Drawable r111 = getCompoundDrawables()[3];
        if (r111 == null) goto L24;
        r111.setColorFilter(new PorterDuffColorFilter(r110, PorterDuff.Mode.SRC_IN));
        return;
    L24:
        return;
    }

    private final void setCompoundDrawablesBounds() {
        Drawable[] r100 = getCompoundDrawables();
        boolean r101 = false;
        Drawable r102 = r100[0];
        Drawable r103 = null;
        if (r102 == null) goto L13;
        int r104 = this.startIconSize;
        if (r104 <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        Drawable r106 = r102;
    L11:
        if (r106 == null) goto L13;
        IconExtKt.setDrawableSize(r106, r104);
        goto L13
    L10:
        r106 = null;
        goto L11
    L7:
        r105 = false;
    L13:
        Drawable r107 = r100[1];
        if (r107 == null) goto L24;
        int r108 = this.topIconSize;
        if (r108 <= 0) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L21;
        Drawable r110 = r107;
    L22:
        if (r110 == null) goto L24;
        IconExtKt.setDrawableSize(r110, r108);
        goto L24
    L21:
        r110 = null;
        goto L22
    L18:
        r109 = false;
    L24:
        Drawable r111 = r100[2];
        if (r111 == null) goto L35;
        int r112 = this.endIconSize;
        if (r112 <= 0) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == false) goto L32;
        Drawable r114 = r111;
    L33:
        if (r114 == null) goto L35;
        IconExtKt.setDrawableSize(r114, r112);
        goto L35
    L32:
        r114 = null;
        goto L33
    L29:
        r113 = false;
    L35:
        Drawable r115 = r100[3];
        if (r115 == null) goto L44;
        int r116 = this.bottomIconSize;
        if (r116 <= 0) goto L40;
        r101 = true;
    L40:
        if (r101 == false) goto L42;
        r103 = r115;
    L42:
        if (r103 == null) goto L44;
        IconExtKt.setDrawableSize(r103, r116);
    L44:
        super.setCompoundDrawables(r102, r107, r111, r115);
        applyState();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setCompoundDrawablesBounds();
    }

    public IconTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon_bottom_color, R.attr.icon_bottom_size, R.attr.icon_end_color, R.attr.icon_end_size, R.attr.icon_start_color, R.attr.icon_start_size, R.attr.icon_top_color, R.attr.icon_top_size});
        this.startColorStateList = r103.getColorStateList(4);
        this.topColorStateList = r103.getColorStateList(6);
        this.endColorStateList = r103.getColorStateList(2);
        this.bottomColorStateList = r103.getColorStateList(0);
        this.startIconSize = r103.getDimensionPixelSize(5, 0);
        this.topIconSize = r103.getDimensionPixelSize(7, 0);
        this.endIconSize = r103.getDimensionPixelSize(3, 0);
        this.bottomIconSize = r103.getDimensionPixelSize(1, 0);
        r103.recycle();
        setCompoundDrawablesBounds();
        return;
    }

    public /* synthetic */ IconTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
