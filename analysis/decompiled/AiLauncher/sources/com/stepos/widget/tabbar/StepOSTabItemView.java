package com.stepos.widget.tabbar;

import C0.c;
import Y8.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.internal.StepOSTrace;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u0005*\u0002Eb\b\u0001\u0018\u0000 e2\u00020\u0001:\u0001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b#\u0010\u0011J\u001f\u0010&\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010(\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0004\b'\u0010\nJ\u000f\u0010*\u001a\u00020\bH\u0000¢\u0006\u0004\b)\u0010\fJ\u000f\u0010+\u001a\u00020\bH\u0014¢\u0006\u0004\b+\u0010\fJ\u000f\u0010,\u001a\u00020\bH\u0014¢\u0006\u0004\b,\u0010\fJ\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\nJ\u001f\u00106\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010AR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010NR\"\u0010U\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u0002038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", x5.d.EXTRA_ENABLED, "LY8/t;", "syncPressFeedback", "(Z)V", "installRippleFeedback", "()V", "syncStateVisual", "Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "style", "applyLabelAppearance", "(Lcom/stepos/widget/tabbar/StepOSTabItemStyle;)V", "Lcom/stepos/widget/tabbar/StepOSTab;", "tab", "selected", "applyIcon", "(Lcom/stepos/widget/tabbar/StepOSTab;Z)V", "applyBadge", "(Lcom/stepos/widget/tabbar/StepOSTab;)V", "", "count", "onIcon", "Landroid/widget/FrameLayout$LayoutParams;", "badgeLayoutParams", "(IZ)Landroid/widget/FrameLayout$LayoutParams;", "", "contentDescriptionWithBadge", "(Lcom/stepos/widget/tabbar/StepOSTab;)Ljava/lang/CharSequence;", "applySelectedBlend", "applyStyle$StepOSWidget_release", "applyStyle", "bind$StepOSWidget_release", "bind", "setTabSelected$StepOSWidget_release", "setTabSelected", "releaseGlass$StepOSWidget_release", "releaseGlass", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "pressed", "setPressed", "", "x", "y", "drawableHotspotChanged", "(FF)V", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "labelView", "Landroid/widget/TextView;", "Landroid/widget/FrameLayout;", "iconSlot", "Landroid/widget/FrameLayout;", "com/stepos/widget/tabbar/StepOSTabItemView$labelHost$1", "labelHost", "Lcom/stepos/widget/tabbar/StepOSTabItemView$labelHost$1;", "badgeView", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Landroid/graphics/Paint;", "fillPaint", "Landroid/graphics/Paint;", "Lcom/stepos/widget/tabbar/TabPressLight;", "pressLight", "Lcom/stepos/widget/tabbar/TabPressLight;", "pressLightEnabled", "Z", "selectedBlendPaint", "visibleIndex", "I", "getVisibleIndex$StepOSWidget_release", "()I", "setVisibleIndex$StepOSWidget_release", "(I)V", "boundTab", "Lcom/stepos/widget/tabbar/StepOSTab;", "itemStyle", "Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "appliedBlurRadius", "F", "cornerRadius", "com/stepos/widget/tabbar/StepOSTabItemView$roundedOutlineProvider$1", "roundedOutlineProvider", "Lcom/stepos/widget/tabbar/StepOSTabItemView$roundedOutlineProvider$1;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabItemView extends LinearLayout {
    private static final Companion Companion = new Companion(null);
    private static final float NO_GLASS = -1.0f;
    private float appliedBlurRadius;
    private final TextView badgeView;
    private StepOSTab boundTab;
    private float cornerRadius;
    private final Paint fillPaint;
    private final GlassDelegate glassDelegate;
    private final FrameLayout iconSlot;
    private final ImageView iconView;
    private StepOSTabItemStyle itemStyle;
    private final StepOSTabItemView$labelHost$1 labelHost;
    private final TextView labelView;
    private final TabPressLight pressLight;
    private boolean pressLightEnabled;
    private final StepOSTabItemView$roundedOutlineProvider$1 roundedOutlineProvider;
    private final Paint selectedBlendPaint;
    private int visibleIndex;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabItemView$Companion;", "", "<init>", "()V", "NO_GLASS", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, android.view.ViewGroup, com.stepos.widget.tabbar.StepOSTabItemView$labelHost$1] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.ViewOutlineProvider, com.stepos.widget.tabbar.StepOSTabItemView$roundedOutlineProvider$1] */
    public StepOSTabItemView(final Context context) throws Resources.NotFoundException {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        ImageView imageView = new ImageView(context);
        this.iconView = imageView;
        TextView textView = new TextView(context);
        this.labelView = textView;
        FrameLayout frameLayout = new FrameLayout(context);
        this.iconSlot = frameLayout;
        ?? r32 = new FrameLayout(context) { // from class: com.stepos.widget.tabbar.StepOSTabItemView$labelHost$1
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            public void onLayout(boolean changed, int left, int top, int right, int bottom) throws Resources.NotFoundException {
                super.onLayout(changed, left, top, right, bottom);
                if (this.badgeView.getParent() != this || this.badgeView.getVisibility() != 0 || this.badgeView.getWidth() == 0 || this.labelView.getWidth() == 0) {
                    return;
                }
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_padding_level1);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_topbar_item_badge_padding_top);
                int left2 = getLayoutDirection() == 1 ? (this.labelView.getLeft() - dimensionPixelSize) - this.badgeView.getWidth() : this.labelView.getRight() + dimensionPixelSize;
                int i10 = dimensionPixelSize2 - top;
                this.badgeView.layout(left2, i10, this.badgeView.getWidth() + left2, this.badgeView.getHeight() + i10);
            }
        };
        this.labelHost = r32;
        TextView textView2 = new TextView(context);
        this.badgeView = textView2;
        this.glassDelegate = new GlassDelegate(this);
        this.fillPaint = new Paint(1);
        this.pressLight = new TabPressLight(this, context.getColor(R.color.stepos_tabbar_item_press_light), getResources().getInteger(R.integer.stepos_tabbar_press_light_enter_duration), getResources().getInteger(R.integer.stepos_tabbar_press_light_exit_duration));
        Paint paint = new Paint();
        paint.setBlendMode(BlendMode.PLUS);
        this.selectedBlendPaint = paint;
        this.appliedBlurRadius = -1.0f;
        ?? r52 = new ViewOutlineProvider() { // from class: com.stepos.widget.tabbar.StepOSTabItemView$roundedOutlineProvider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(this.this$0.cornerRadius, Math.min(view.getWidth(), view.getHeight()) / 2.0f));
            }
        };
        this.roundedOutlineProvider = r52;
        setOrientation(1);
        setGravity(49);
        setClickable(true);
        setFocusable(true);
        setBackground(null);
        setOutlineProvider(r52);
        setClipToOutline(true);
        setClipToPadding(false);
        setClipChildren(false);
        HotspotRipple hotspotRipple = HotspotRipple.INSTANCE;
        hotspotRipple.applyPressScale$StepOSWidget_release(frameLayout);
        hotspotRipple.applyPressScale$StepOSWidget_release(r32);
        installRippleFeedback();
        installRippleFeedback();
        setPaddingRelative(getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_padding_top), getPaddingEnd(), getPaddingBottom());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_size);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        r32.setClipChildren(false);
        r32.setClipToPadding(false);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        textView2.setMinWidth(dimensionPixelSize2);
        textView2.setMinimumHeight(dimensionPixelSize2);
        textView2.setGravity(17);
        textView2.setIncludeFontPadding(false);
        textView2.setMaxLines(1);
        textView2.setTextAppearance(R.style.StepOSTextAppearance_Caption_L);
        textView2.setTextColor(context.getColor(R.color.stepos_tabbar_item_badge_text));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimensionPixelSize2 / 2.0f);
        gradientDrawable.setColor(context.getColor(R.color.stepos_tabbar_item_badge));
        textView2.setBackground(gradientDrawable);
        textView2.setVisibility(8);
        textView2.setImportantForAccessibility(2);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_padding_level2);
        textView2.setPaddingRelative(dimensionPixelSize3, 0, dimensionPixelSize3, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize2);
        layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_offset_start));
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_offset_top);
        t tVar = t.f7040a;
        frameLayout.addView(textView2, layoutParams);
        addView(frameLayout, new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        r32.addView(textView, new FrameLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_icon_label_spacing);
        addView((View) r32, layoutParams2);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        imageView.setImportantForAccessibility(2);
        frameLayout.setImportantForAccessibility(2);
        r32.setImportantForAccessibility(2);
        textView.setImportantForAccessibility(2);
    }

    private final void applyBadge(StepOSTab tab) throws Resources.NotFoundException {
        int badgeCount = tab.getBadgeCount();
        if (badgeCount <= 0) {
            this.badgeView.setVisibility(8);
            this.badgeView.setText((CharSequence) null);
            return;
        }
        this.badgeView.setText(String.valueOf(badgeCount));
        boolean z10 = this.iconView.getVisibility() == 0;
        ViewGroup viewGroup = z10 ? this.iconSlot : this.labelHost;
        FrameLayout.LayoutParams layoutParamsBadgeLayoutParams = badgeLayoutParams(badgeCount, z10);
        if (this.badgeView.getParent() != viewGroup) {
            ViewParent parent = this.badgeView.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.badgeView);
            }
            viewGroup.addView(this.badgeView, layoutParamsBadgeLayoutParams);
        } else {
            this.badgeView.setLayoutParams(layoutParamsBadgeLayoutParams);
        }
        this.badgeView.setVisibility(0);
        if (z10) {
            this.iconSlot.setVisibility(0);
        }
    }

    private final void applyIcon(StepOSTab tab, boolean selected) {
        StepOSTabItemStyle stepOSTabItemStyle;
        Drawable selectedIconValue = tab.getSelectedIconValue();
        boolean z10 = selected && selectedIconValue != null;
        if (!z10) {
            selectedIconValue = tab.getIconValue();
        }
        this.iconView.setImageDrawable(selectedIconValue);
        ImageView imageView = this.iconView;
        ColorStateList iconTint = null;
        if (!z10 && (stepOSTabItemStyle = this.itemStyle) != null) {
            iconTint = stepOSTabItemStyle.getIconTint();
        }
        imageView.setImageTintList(iconTint);
        this.iconView.setVisibility(selectedIconValue == null ? 8 : 0);
        this.iconSlot.setVisibility(selectedIconValue == null ? 8 : 0);
    }

    private final void applyLabelAppearance(StepOSTabItemStyle style) {
        int labelTextAppearance = style.getLabelTextAppearance();
        if (labelTextAppearance != 0) {
            this.labelView.setTextAppearance(labelTextAppearance);
        }
        ColorStateList labelTextColor = style.getLabelTextColor();
        if (labelTextColor != null) {
            this.labelView.setTextColor(labelTextColor);
        }
    }

    private final void applySelectedBlend(boolean selected) {
        if (!selected || getResources().getBoolean(R.bool.stepos_tabbar_glass_light)) {
            this.iconView.setLayerType(0, null);
            this.labelView.setLayerType(0, null);
        } else {
            this.iconView.setLayerType(2, this.selectedBlendPaint);
            this.labelView.setLayerType(2, this.selectedBlendPaint);
        }
    }

    private final FrameLayout.LayoutParams badgeLayoutParams(int count, boolean onIcon) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_size);
        if (count < 10) {
            this.badgeView.setPaddingRelative(0, 0, 0, 0);
        } else {
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_padding_level2);
            this.badgeView.setPaddingRelative(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
        }
        int i10 = count < 10 ? dimensionPixelSize : -2;
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_offset_start);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_badge_offset_top);
        if (!onIcon) {
            return new FrameLayout.LayoutParams(i10, dimensionPixelSize);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, dimensionPixelSize);
        layoutParams.setMarginStart(dimensionPixelSize3);
        layoutParams.topMargin = dimensionPixelSize4;
        return layoutParams;
    }

    private final CharSequence contentDescriptionWithBadge(StepOSTab tab) throws Resources.NotFoundException {
        CharSequence contentDescription = tab.getContentDescription();
        int badgeCount = tab.getBadgeCount();
        if (badgeCount <= 0) {
            return contentDescription;
        }
        String quantityString = getResources().getQuantityString(R.plurals.stepos_tabbar_item_badge_desc, badgeCount, Integer.valueOf(badgeCount));
        kotlin.jvm.internal.p.h(quantityString, "getQuantityString(...)");
        if (contentDescription == null || contentDescription.length() == 0) {
            return quantityString;
        }
        return ((Object) contentDescription) + ", " + quantityString;
    }

    private final void installRippleFeedback() {
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, this, getContext().getColor(R.color.stepos_tabbar_item_ripple), 0.0f, true, false, 0.0f, 36, null);
    }

    private final void syncPressFeedback(boolean enabled) {
        if (this.pressLightEnabled != enabled) {
            this.pressLightEnabled = enabled;
            if (enabled) {
                setForeground(null);
                this.pressLight.release$StepOSWidget_release();
            } else {
                this.pressLight.release$StepOSWidget_release();
                installRippleFeedback();
            }
            invalidate();
            return;
        }
        if (enabled) {
            if (getForeground() != null) {
                setForeground(null);
            }
        } else if (getForeground() == null) {
            installRippleFeedback();
        }
    }

    private final void syncStateVisual() {
        StepOSTabItemStyle stepOSTabItemStyle = this.itemStyle;
        if (stepOSTabItemStyle == null) {
            return;
        }
        this.cornerRadius = stepOSTabItemStyle.getCornerRadius();
        this.fillPaint.setColor(stepOSTabItemStyle.getFillColor());
        setAlpha(isSelected() ? stepOSTabItemStyle.getAlphaSelected() : stepOSTabItemStyle.getAlpha());
        applySelectedBlend(isSelected());
        if (isSelected() || stepOSTabItemStyle.getBlurRadius() <= 0.0f || !stepOSTabItemStyle.getIsGlassEnabled() || !isAttachedToWindow() || getVisibility() != 0) {
            releaseGlass$StepOSWidget_release();
        } else if (this.appliedBlurRadius == stepOSTabItemStyle.getBlurRadius()) {
            this.glassDelegate.updateCornerRadius$StepOSWidget_release(this.cornerRadius);
        } else {
            this.appliedBlurRadius = stepOSTabItemStyle.getBlurRadius();
            GlassDelegate.applyBlurOnly$StepOSWidget_release$default(this.glassDelegate, 0, this.cornerRadius, stepOSTabItemStyle.getBlurRadius(), 0, 8, null);
        }
        setClipToOutline(true);
        invalidateOutline();
        invalidate();
    }

    public final void applyStyle$StepOSWidget_release(StepOSTabItemStyle style) {
        kotlin.jvm.internal.p.i(style, "style");
        this.itemStyle = style;
        syncPressFeedback(style.getIsPressLightEnabled());
        setPaddingRelative(style.getPaddingHorizontal(), getPaddingTop(), style.getPaddingHorizontal(), getPaddingBottom());
        applyLabelAppearance(style);
        StepOSTab stepOSTab = this.boundTab;
        if (stepOSTab != null) {
            applyIcon(stepOSTab, isSelected());
        }
        syncStateVisual();
    }

    public final void bind$StepOSWidget_release(StepOSTab tab, boolean selected) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(tab, "tab");
        this.boundTab = tab;
        applyIcon(tab, selected);
        this.labelView.setText(tab.getTitle());
        TextView textView = this.labelView;
        CharSequence title = tab.getTitle();
        textView.setVisibility((title == null || title.length() == 0) ? 8 : 0);
        applyBadge(tab);
        setContentDescription(contentDescriptionWithBadge(tab));
        setEnabled(tab.getEnabled());
        this.iconView.setEnabled(tab.getEnabled());
        this.badgeView.setEnabled(tab.getEnabled());
        this.labelView.setEnabled(tab.getEnabled());
        setVisibility(tab.getVisible() ? 0 : 8);
        syncStateVisual();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (Color.alpha(this.fillPaint.getColor()) != 0) {
            float width = getWidth();
            float height = getHeight();
            float f10 = this.cornerRadius;
            canvas2 = canvas;
            canvas2.drawRoundRect(0.0f, 0.0f, width, height, f10, f10, this.fillPaint);
        } else {
            canvas2 = canvas;
        }
        if (this.pressLightEnabled) {
            this.pressLight.draw$StepOSWidget_release(canvas2);
        }
        super.dispatchDraw(canvas2);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        if (this.pressLightEnabled) {
            this.pressLight.onHotspotChanged$StepOSWidget_release(x10, y10);
        }
    }

    /* renamed from: getVisibleIndex$StepOSWidget_release, reason: from getter */
    public final int getVisibleIndex() {
        return this.visibleIndex;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        syncStateVisual();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.pressLight.release$StepOSWidget_release();
        releaseGlass$StepOSWidget_release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        C0.c cVarS0 = C0.c.S0(info);
        cVarS0.J0(isSelected());
        cVarS0.p0(c.g.a(0, 1, this.visibleIndex, 1, false, isSelected()));
    }

    public final void releaseGlass$StepOSWidget_release() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedBlurRadius = -1.0f;
        applySelectedBlend(false);
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (this.pressLightEnabled) {
            this.pressLight.onPressedChanged$StepOSWidget_release(isPressed());
        }
    }

    public final void setTabSelected$StepOSWidget_release(boolean selected) {
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:TabItem.setTabSelected");
        try {
            setSelected(selected);
            StepOSTab stepOSTab = this.boundTab;
            if (stepOSTab != null) {
                applyIcon(stepOSTab, selected);
                applyBadge(stepOSTab);
            }
            syncStateVisual();
            t tVar = t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public final void setVisibleIndex$StepOSWidget_release(int i10) {
        this.visibleIndex = i10;
    }
}
