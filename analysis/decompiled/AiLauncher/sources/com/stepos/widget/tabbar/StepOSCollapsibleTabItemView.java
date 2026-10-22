package com.stepos.widget.tabbar;

import C0.c;
import Y8.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.widget.R;
import com.stepos.widget.internal.HotspotRipple;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0014¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00105\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "tab", "", "selected", "LY8/t;", "applyIcon", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;Z)V", "applySelectedBlend", "(Z)V", "", "labelTextAppearance", "Landroid/content/res/ColorStateList;", "labelTextColor", "iconTint", "applyStyle$StepOSWidget_release", "(ILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "applyStyle", "effectiveEnabled", "bind$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;ZZ)V", "bind", "setTabSelected$StepOSWidget_release", "setTabSelected", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "onDetachedFromWindow", "()V", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "labelView", "Landroid/widget/TextView;", "Landroid/graphics/Paint;", "selectedBlendPaint", "Landroid/graphics/Paint;", "", "itemCornerRadius", "F", "boundTab", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "itemIconTint", "Landroid/content/res/ColorStateList;", "lightGlass", "Z", "visibleIndex", "I", "getVisibleIndex$StepOSWidget_release", "()I", "setVisibleIndex$StepOSWidget_release", "(I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSCollapsibleTabItemView extends LinearLayout {
    private StepOSCollapsibleTab boundTab;
    private final ImageView iconView;
    private final float itemCornerRadius;
    private ColorStateList itemIconTint;
    private final TextView labelView;
    private final boolean lightGlass;
    private final Paint selectedBlendPaint;
    private int visibleIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabItemView(Context context) throws Resources.NotFoundException {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        ImageView imageView = new ImageView(context);
        this.iconView = imageView;
        TextView textView = new TextView(context);
        this.labelView = textView;
        Paint paint = new Paint();
        paint.setBlendMode(BlendMode.PLUS);
        this.selectedBlendPaint = paint;
        float dimension = getResources().getDimension(R.dimen.stepos_collapsible_tabbar_item_corner_radius);
        this.itemCornerRadius = dimension;
        this.lightGlass = getResources().getBoolean(R.bool.stepos_collapsible_tabbar_glass_light);
        setOrientation(1);
        setGravity(49);
        setClickable(true);
        setFocusable(true);
        setBackground(null);
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, this, context.getColor(R.color.stepos_collapsible_tabbar_item_ripple), dimension, false, false, 0.0f, 56, null);
        Resources resources = getResources();
        int i10 = R.dimen.stepos_collapsible_tabbar_item_padding_horizontal;
        setPaddingRelative(resources.getDimensionPixelSize(i10), getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_item_padding_top), getResources().getDimensionPixelSize(i10), 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_item_icon_size);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(imageView, new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_item_icon_label_spacing);
        t tVar = t.f7040a;
        addView(textView, layoutParams);
        imageView.setImportantForAccessibility(2);
        textView.setImportantForAccessibility(2);
    }

    private final void applyIcon(StepOSCollapsibleTab tab, boolean selected) {
        Drawable selectedIconValue = tab.getSelectedIconValue();
        boolean z10 = selected && selectedIconValue != null;
        if (!z10) {
            selectedIconValue = tab.getIconValue();
        }
        this.iconView.setImageDrawable(selectedIconValue);
        this.iconView.setImageTintList(z10 ? null : this.itemIconTint);
    }

    private final void applySelectedBlend(boolean selected) {
        if (!selected || this.lightGlass) {
            this.iconView.setLayerType(0, null);
            this.labelView.setLayerType(0, null);
        } else {
            this.iconView.setLayerType(2, this.selectedBlendPaint);
            this.labelView.setLayerType(2, this.selectedBlendPaint);
        }
    }

    public final void applyStyle$StepOSWidget_release(int labelTextAppearance, ColorStateList labelTextColor, ColorStateList iconTint) {
        if (labelTextAppearance != 0) {
            this.labelView.setTextAppearance(labelTextAppearance);
        }
        if (labelTextColor != null) {
            this.labelView.setTextColor(labelTextColor);
        }
        this.itemIconTint = iconTint;
        StepOSCollapsibleTab stepOSCollapsibleTab = this.boundTab;
        if (stepOSCollapsibleTab != null) {
            applyIcon(stepOSCollapsibleTab, isSelected());
        }
    }

    public final void bind$StepOSWidget_release(StepOSCollapsibleTab tab, boolean selected, boolean effectiveEnabled) {
        kotlin.jvm.internal.p.i(tab, "tab");
        this.boundTab = tab;
        this.labelView.setText(tab.getTitle());
        setContentDescription(tab.getContentDescription());
        setEnabled(effectiveEnabled);
        this.iconView.setEnabled(effectiveEnabled);
        this.labelView.setEnabled(effectiveEnabled);
        setVisibility(tab.getVisible() ? 0 : 8);
        setTabSelected$StepOSWidget_release(selected);
    }

    /* renamed from: getVisibleIndex$StepOSWidget_release, reason: from getter */
    public final int getVisibleIndex() {
        return this.visibleIndex;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        applySelectedBlend(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
        C0.c cVarS0 = C0.c.S0(info);
        cVarS0.k0(true);
        cVarS0.J0(isSelected());
        cVarS0.p0(c.g.a(0, 1, this.visibleIndex, 1, false, isSelected()));
    }

    public final void setTabSelected$StepOSWidget_release(boolean selected) {
        setSelected(selected);
        StepOSCollapsibleTab stepOSCollapsibleTab = this.boundTab;
        if (stepOSCollapsibleTab != null) {
            applyIcon(stepOSCollapsibleTab, selected);
        }
        applySelectedBlend(selected);
    }

    public final void setVisibleIndex$StepOSWidget_release(int i10) {
        this.visibleIndex = i10;
    }
}
