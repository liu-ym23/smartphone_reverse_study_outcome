package com.bytedance.android.ui.base.widget.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ui.base.widget.icon.IconTextView;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u0010\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "Lcom/bytedance/android/ui/base/widget/icon/IconTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alwaysClickable", "", "getAlwaysClickable", "()Z", "setAlwaysClickable", "(Z)V", "isBgAdded", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setBgColor", "color", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CornersButton extends IconTextView {
    private boolean alwaysClickable;
    private boolean isBgAdded;

    public CornersButton(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public CornersButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final boolean getAlwaysClickable() {
        return this.alwaysClickable;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (isEnabled() == true) goto L11;
        if (this.alwaysClickable == false) goto L11;
        if (r100.getActionMasked() != 1) goto L9;
        performClick();
    L9:
        super.onTouchEvent(r100);
        return true;
    L11:
        return super.onTouchEvent(r100);
    }

    public final void setAlwaysClickable(boolean r100) {
        this.alwaysClickable = r100;
    }

    public final void setBgColor(int r100) {
        if ((getBackground() instanceof BackgroundDrawable) == false) goto L9;
        Drawable r101 = getBackground();
        if (r101 == null) goto L8;
        ((BackgroundDrawable) r101).setBgColor(r100).invalidate();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    }

    public CornersButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.checked, com.larus.nova.R.attr.always_clickable, com.larus.nova.R.attr.bg_checkedColor, com.larus.nova.R.attr.bg_checkedEndColor, com.larus.nova.R.attr.bg_checkedStartColor, com.larus.nova.R.attr.bg_color, com.larus.nova.R.attr.bg_colorOrientation, com.larus.nova.R.attr.bg_cornerRadius, com.larus.nova.R.attr.bg_endColor, com.larus.nova.R.attr.bg_startColor, com.larus.nova.R.attr.bg_strokeCheckedColor, com.larus.nova.R.attr.bg_strokeColor, com.larus.nova.R.attr.bg_strokeWidth, com.larus.nova.R.attr.icon_bottom_color, com.larus.nova.R.attr.icon_bottom_size, com.larus.nova.R.attr.icon_end_color, com.larus.nova.R.attr.icon_end_size, com.larus.nova.R.attr.icon_start_color, com.larus.nova.R.attr.icon_start_size, com.larus.nova.R.attr.icon_top_color, com.larus.nova.R.attr.icon_top_size});
        this.alwaysClickable = r103.getBoolean(1, this.alwaysClickable);
        r103.recycle();
    L5:
        setBackground(new BackgroundDrawable(r100, r101, false));
    }

    public /* synthetic */ CornersButton(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.isBgAdded == false) goto L5;
        return;
    L5:
        if ((getBackground() instanceof BackgroundDrawable) == true) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L25;
        this.isBgAdded = true;
        Drawable r105 = getBackground();
        if (r105 == null) goto L22;
        BackgroundDrawable r106 = (BackgroundDrawable) r105;
        float r107 = 0;
        if (r106.getCornerRadiusTL() <= r107) goto L13;
    L20:
        r106.invalidate();
        return;
    L13:
        if (r106.getCornerRadiusTR() > r107) goto L20;
        if (r106.getCornerRadiusBL() > r107) goto L20;
        if (r106.getCornerRadiusBR() > r107) goto L20;
        r106.setCornerRadius(getHeight() / 2).invalidate();
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    }
}
