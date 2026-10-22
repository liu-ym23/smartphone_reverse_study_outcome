package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AutoResizePriceContainer;", "Landroid/widget/RelativeLayout;", "", "width", "", "setMaxWidth", "", "enable", "setIsMeasureChildFullWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoResizePriceContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f45862c;

    public AutoResizePriceContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoResizePriceContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setIsMeasureChildFullWidth(boolean r100) {
        this.f45862c = r100;
    }

    public final void setMaxWidth(int r100) {
        this.f45860a = r100;
        requestLayout();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (this.f45860a > 0) goto L5;
    L9:
        super.onMeasure(r110, r111);
    L11:
        if (getChildCount() >= 1) goto L13;
        return;
    L13:
        int r100 = getChildCount();
        int r101 = 0;
        int r102 = 0;
    L14:
        if (r101 >= r100) goto L27;
        View r103 = getChildAt(r101);
        if (r103.getVisibility() != 0) goto L26;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L20;
        ViewGroup.LayoutParams r105 = null;
    L21:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L24;
        int r107 = r106.leftMargin + r106.rightMargin;
    L25:
        r102 = r102 + (r103.getMeasuredWidth() + r107);
        goto L26
    L24:
        r107 = 0;
        goto L25
    L20:
        r105 = r104;
    L26:
        r101 = r101 + 1;
        goto L14
    L27:
        int r108 = getMeasuredWidth();
        if (getMeasuredWidth() < r102) goto L31;
        r102 = r108;
    L31:
        int r109 = this.f45860a;
        if (r109 <= 0) goto L87;
        if (1 > r102) goto L35;
        if (r109 < r102) goto L35;
        return;
    L35:
        int r112 = this.f45861b;
        if (1 > r112) goto L40;
        if (r109 < r112) goto L40;
        return;
    L40:
        float r113 = (r109 * 1.0f) / r102;
        int r114 = getChildCount();
        this.f45861b = 0;
        int r115 = 0;
    L41:
        if (r115 >= r114) goto L96;
        View r116 = getChildAt(r115);
        if (r116.getVisibility() != 0) goto L86;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117.width == (-1)) goto L47;
    L49:
        int r118 = View.MeasureSpec.getMode(r110);
        int r119 = View.MeasureSpec.getSize(r110);
        if (r118 == 1073741824) goto L53;
        r119 = this.f45860a;
    L53:
        setMeasuredDimension(r119, r111);
        boolean r120 = r116 instanceof i;
        if (r120 == true) goto L56;
        Object r121 = null;
    L57:
        i r122 = (i) r121;
        if (r122 == null) goto L60;
        r122.setMaxWidth(r116.getMeasuredWidth() * r113);
    L60:
        boolean r123 = r116 instanceof AutoResizePriceContainer;
        if (r123 == true) goto L63;
        View r124 = null;
    L64:
        AutoResizePriceContainer r125 = (AutoResizePriceContainer) r124;
        if (r125 == null) goto L67;
        r125.setMaxWidth((int) (((AutoResizePriceContainer) r116).getMeasuredWidth() * r113));
    L67:
        ViewGroup.LayoutParams r126 = r116.getLayoutParams();
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r126 = null;
    L70:
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        if (r127 == null) goto L73;
        r127.leftMargin = (int) (r127.leftMargin * r113);
        r127.rightMargin = (int) (r127.rightMargin * r113);
        r116.setLayoutParams(r127);
    L73:
        r116.setPadding((int) (r116.getPaddingLeft() * r113), r116.getPaddingTop(), (int) (r116.getPaddingRight() * r113), r116.getPaddingBottom());
        int r128 = r117.height;
        if (r128 != (-1)) goto L76;
        int r129 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(0, getMeasuredHeight()), 1073741824);
    L78:
        if (r117.width != (-1)) goto L80;
        r116.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(0, getMeasuredWidth()), 1073741824), r129);
        goto L86
    L80:
        if (r123 == true) goto L84;
        if (r120 == true) goto L84;
        r116.measure(RelativeLayout.getChildMeasureSpec(r110, 0, (int) (r116.getMeasuredWidth() * r113)), r129);
    L84:
        this.f45861b += (int) (r116.getMeasuredWidth() * r113);
        goto L86
    L76:
        r129 = RelativeLayout.getChildMeasureSpec(r111, 0, r128);
        goto L78
    L63:
        r124 = r116;
        goto L64
    L56:
        r121 = r116;
        goto L57
    L47:
        if (r117.height != (-1)) goto L49;
    L86:
        r115 = r115 + 1;
        goto L41
    L96:
        return;
    L87:
        return;
    L5:
        if (this.f45862c == false) goto L9;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), r111);
        int r130 = View.MeasureSpec.getSize(r110);
        if (getMeasuredWidth() <= r130) goto L11;
        setMeasuredDimension(r130, getMeasuredHeight());
        goto L11
    }

    public AutoResizePriceContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AutoResizePriceContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
