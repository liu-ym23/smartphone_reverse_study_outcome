package com.stepos.widget.tabbar;

import C0.c;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.internal.HotspotRipple;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 h2\u00020\u0001:\u0001hB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010#\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010'\u001a\u00020\u00062\b\b\u0001\u0010$\u001a\u00020\u0017H\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u001fH\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u001fH\u0000¢\u0006\u0004\b,\u0010*J\u001f\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017H\u0014¢\u0006\u0004\b0\u00101J7\u00107\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0017H\u0014¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0006H\u0014¢\u0006\u0004\b=\u0010\u000bR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00100Ej\b\u0012\u0004\u0012\u00020\u0010`F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u00050Ej\b\u0012\u0004\u0012\u00020\u0005`F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010QR\u0014\u0010S\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010QR\u0014\u0010T\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010QR\u0014\u0010U\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010QR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010XR\u0014\u0010Z\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bZ\u0010QR\u0014\u0010[\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b[\u0010QR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010^R\u0016\u0010`\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010QR\u0016\u0010a\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010QR*\u0010d\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\u001f8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010b\u001a\u0004\be\u0010f\"\u0004\bg\u0010*¨\u0006i"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabStrip;", "Lcom/stepos/widget/tabbar/StepOSCollapsibleGlassSurface;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "LY8/t;", "onTabClick", "<init>", "(Landroid/content/Context;Lp9/l;)V", "syncColors", "()V", "syncItems", "syncMode", "syncCompactIcon", "", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabItemView;", "visibleItemViews", "()Ljava/util/List;", "selectedVisibleItemView", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTabItemView;", "selectedTab", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "", "stripWidth", "count", "", "measureItemWidths", "(II)[I", "source", "selectedItemId", "", "announceSelection", "submitTabs$StepOSWidget_release", "(Ljava/util/List;IZ)V", "submitTabs", "color", "setSelectedColor$StepOSWidget_release", "(I)V", "setSelectedColor", x5.d.EXTRA_ENABLED, "applyGlassEnabled$StepOSWidget_release", "(Z)V", "applyGlassEnabled", "applyHostEnabled$StepOSWidget_release", "applyHostEnabled", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "onDetachedFromWindow", "Lp9/l;", "Lcom/stepos/widget/tabbar/StepOSTabIndicatorView;", "indicatorView", "Lcom/stepos/widget/tabbar/StepOSTabIndicatorView;", "Landroid/widget/ImageView;", "compactIconView", "Landroid/widget/ImageView;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "itemViews", "Ljava/util/ArrayList;", "tabs", "Landroid/graphics/Paint;", "compactBlendPaint", "Landroid/graphics/Paint;", "Landroid/graphics/drawable/Drawable;", "compactRipple", "Landroid/graphics/drawable/Drawable;", "outerPadding", "I", "itemHeight", "itemSpacing", "iconSize", "labelAppearance", "", "indicatorCornerRadius", "F", "indicatorBlurRadius", "indicatorColor", "indicatorTint", "Landroid/content/res/ColorStateList;", "labelTextColor", "Landroid/content/res/ColorStateList;", "iconTint", "selectedColor", "hostEnabled", "Z", UxipConstants.f30680s, "isCollapsed", "isCollapsed$StepOSWidget_release", "()Z", "setCollapsed$StepOSWidget_release", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSCollapsibleTabStrip extends StepOSCollapsibleGlassSurface {
    private static final Companion Companion = new Companion(null);
    private final Paint compactBlendPaint;
    private final ImageView compactIconView;
    private final Drawable compactRipple;
    private boolean hostEnabled;
    private final int iconSize;
    private ColorStateList iconTint;
    private final float indicatorBlurRadius;
    private final int indicatorColor;
    private final float indicatorCornerRadius;
    private final int indicatorTint;
    private final StepOSTabIndicatorView indicatorView;
    private boolean isCollapsed;
    private final int itemHeight;
    private final int itemSpacing;
    private final ArrayList<StepOSCollapsibleTabItemView> itemViews;
    private final int labelAppearance;
    private ColorStateList labelTextColor;
    private final InterfaceC5074l<StepOSCollapsibleTab, t> onTabClick;
    private final int outerPadding;
    private int selectedColor;
    private int selectedItemId;
    private final ArrayList<StepOSCollapsibleTab> tabs;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabStrip$Companion;", "", "<init>", "()V", "selectedColorStateList", "Landroid/content/res/ColorStateList;", "selected", "", "unselected", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ColorStateList selectedColorStateList(int selected, int unselected) {
            return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_activated}, new int[0]}, new int[]{selected, selected, unselected});
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StepOSCollapsibleTabStrip(Context context, InterfaceC5074l<? super StepOSCollapsibleTab, t> onTabClick) throws Resources.NotFoundException {
        super(context, null, 2, null);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onTabClick, "onTabClick");
        this.onTabClick = onTabClick;
        StepOSTabIndicatorView stepOSTabIndicatorView = new StepOSTabIndicatorView(context);
        this.indicatorView = stepOSTabIndicatorView;
        ImageView imageView = new ImageView(context);
        this.compactIconView = imageView;
        this.itemViews = new ArrayList<>(4);
        this.tabs = new ArrayList<>(4);
        Paint paint = new Paint();
        paint.setBlendMode(BlendMode.PLUS);
        this.compactBlendPaint = paint;
        HotspotRipple hotspotRipple = HotspotRipple.INSTANCE;
        this.compactRipple = HotspotRipple.create$StepOSWidget_release$default(hotspotRipple, context, androidx.core.content.a.c(context, com.stepos.widget.R.color.stepos_collapsible_tabbar_item_ripple), 0.0f, 0.0f, 12, null);
        this.outerPadding = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_padding);
        this.itemHeight = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_item_height);
        this.itemSpacing = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_item_spacing);
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_item_icon_size);
        this.iconSize = dimensionPixelSize;
        this.labelAppearance = com.stepos.widget.R.style.StepOSTextAppearance_TabBar_Label;
        this.indicatorCornerRadius = getResources().getDimension(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_indicator_corner_radius);
        this.indicatorBlurRadius = getResources().getFloat(com.stepos.widget.R.dimen.stepos_collapsible_tabbar_indicator_blur_radius);
        this.indicatorColor = androidx.core.content.a.c(context, com.stepos.widget.R.color.stepos_collapsible_tabbar_indicator_color);
        this.indicatorTint = androidx.core.content.a.c(context, com.stepos.widget.R.color.stepos_collapsible_tabbar_indicator_tint);
        this.selectedColor = androidx.core.content.a.c(context, com.stepos.widget.R.color.stepos_collapsible_tabbar_item_selected);
        this.hostEnabled = true;
        stepOSTabIndicatorView.setVisibility(8);
        super.addView(stepOSTabIndicatorView, new FrameLayout.LayoutParams(0, 0));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImportantForAccessibility(2);
        imageView.setVisibility(8);
        super.addView(imageView, new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.tabbar.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSCollapsibleTabStrip._init_$lambda$1(this.f31366a, view);
            }
        });
        hotspotRipple.applyPressScale$StepOSWidget_release(this);
        syncColors();
        syncMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip, View view) {
        StepOSCollapsibleTab stepOSCollapsibleTabSelectedTab;
        if (stepOSCollapsibleTabStrip.isCollapsed && (stepOSCollapsibleTabSelectedTab = stepOSCollapsibleTabStrip.selectedTab()) != null) {
            stepOSCollapsibleTabStrip.onTabClick.invoke(stepOSCollapsibleTabSelectedTab);
        }
    }

    private final int[] measureItemWidths(int stripWidth, int count) {
        if (count == 0) {
            return new int[0];
        }
        if (stripWidth <= 0) {
            return new int[count];
        }
        int i10 = (stripWidth - (this.outerPadding * 2)) - (this.itemSpacing * (count - 1));
        if (i10 <= 0) {
            return new int[count];
        }
        int i11 = i10 / count;
        int i12 = i10 % count;
        int[] iArr = new int[count];
        int i13 = 0;
        while (i13 < count) {
            iArr[i13] = (i13 < i12 ? 1 : 0) + i11;
            i13++;
        }
        return iArr;
    }

    private final StepOSCollapsibleTab selectedTab() {
        Object next;
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((StepOSCollapsibleTab) next).getItemId() == this.selectedItemId) {
                break;
            }
        }
        return (StepOSCollapsibleTab) next;
    }

    private final StepOSCollapsibleTabItemView selectedVisibleItemView() {
        Iterator<StepOSCollapsibleTab> it = this.tabs.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            StepOSCollapsibleTab next = it.next();
            if (next.getItemId() == this.selectedItemId && next.getVisible()) {
                break;
            }
            i10++;
        }
        return (StepOSCollapsibleTabItemView) F.t0(this.itemViews, i10);
    }

    public static /* synthetic */ void submitTabs$StepOSWidget_release$default(StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip, List list, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        stepOSCollapsibleTabStrip.submitTabs$StepOSWidget_release(list, i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitTabs$lambda$4$lambda$3(StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip, StepOSCollapsibleTab stepOSCollapsibleTab, View view) {
        stepOSCollapsibleTabStrip.onTabClick.invoke(stepOSCollapsibleTab);
    }

    private final void syncColors() {
        Companion companion = Companion;
        this.labelTextColor = companion.selectedColorStateList(this.selectedColor, androidx.core.content.a.c(getContext(), com.stepos.widget.R.color.stepos_collapsible_tabbar_item_label_unselected));
        this.iconTint = companion.selectedColorStateList(this.selectedColor, androidx.core.content.a.c(getContext(), com.stepos.widget.R.color.stepos_collapsible_tabbar_item_icon_unselected));
        Iterator<T> it = this.itemViews.iterator();
        while (it.hasNext()) {
            ((StepOSCollapsibleTabItemView) it.next()).applyStyle$StepOSWidget_release(this.labelAppearance, this.labelTextColor, this.iconTint);
        }
        StepOSTabIndicatorView.applyStyle$StepOSWidget_release$default(this.indicatorView, this.indicatorCornerRadius, this.indicatorBlurRadius, this.indicatorColor, this.indicatorTint, getIsGlassEnabled(), false, 32, null);
    }

    private final void syncCompactIcon() {
        StepOSCollapsibleTab stepOSCollapsibleTabSelectedTab = selectedTab();
        CharSequence contentDescription = null;
        Drawable selectedIconValue = stepOSCollapsibleTabSelectedTab != null ? stepOSCollapsibleTabSelectedTab.getSelectedIconValue() : null;
        boolean z10 = selectedIconValue != null;
        ImageView imageView = this.compactIconView;
        if (selectedIconValue == null) {
            selectedIconValue = stepOSCollapsibleTabSelectedTab != null ? stepOSCollapsibleTabSelectedTab.getIconValue() : null;
        }
        imageView.setImageDrawable(selectedIconValue);
        this.compactIconView.setImageTintList(z10 ? null : ColorStateList.valueOf(this.selectedColor));
        if (stepOSCollapsibleTabSelectedTab == null || getResources().getBoolean(com.stepos.widget.R.bool.stepos_collapsible_tabbar_glass_light)) {
            this.compactIconView.setLayerType(0, null);
        } else {
            this.compactIconView.setLayerType(2, this.compactBlendPaint);
        }
        if (this.isCollapsed && stepOSCollapsibleTabSelectedTab != null) {
            contentDescription = stepOSCollapsibleTabSelectedTab.getContentDescription();
        }
        setContentDescription(contentDescription);
    }

    private final void syncItems() {
        int i10 = 0;
        int i11 = 0;
        for (Object obj : this.tabs) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            StepOSCollapsibleTab stepOSCollapsibleTab = (StepOSCollapsibleTab) obj;
            int itemId = stepOSCollapsibleTab.getItemId();
            int i13 = this.selectedItemId;
            boolean z10 = itemId == i13 && i13 != 0;
            this.itemViews.get(i10).setVisibleIndex$StepOSWidget_release(i11);
            this.itemViews.get(i10).bind$StepOSWidget_release(stepOSCollapsibleTab, z10, this.hostEnabled && stepOSCollapsibleTab.getEnabled());
            if (stepOSCollapsibleTab.getVisible()) {
                i11++;
            }
            i10 = i12;
        }
        syncCompactIcon();
    }

    private final void syncMode() {
        StepOSCollapsibleTab stepOSCollapsibleTabSelectedTab;
        StepOSCollapsibleTab stepOSCollapsibleTabSelectedTab2;
        boolean z10 = false;
        this.compactIconView.setVisibility(this.isCollapsed ? 0 : 8);
        int i10 = 0;
        for (Object obj : this.itemViews) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            StepOSCollapsibleTabItemView stepOSCollapsibleTabItemView = (StepOSCollapsibleTabItemView) obj;
            StepOSCollapsibleTab stepOSCollapsibleTab = (StepOSCollapsibleTab) F.t0(this.tabs, i10);
            stepOSCollapsibleTabItemView.setVisibility((this.isCollapsed || stepOSCollapsibleTab == null || !stepOSCollapsibleTab.getVisible()) ? 8 : 0);
            i10 = i11;
        }
        if (this.hostEnabled && this.isCollapsed && (stepOSCollapsibleTabSelectedTab2 = selectedTab()) != null && stepOSCollapsibleTabSelectedTab2.getEnabled()) {
            z10 = true;
        }
        setClickable(z10);
        setFocusable(isClickable());
        CharSequence contentDescription = null;
        setForeground(this.isCollapsed ? this.compactRipple : null);
        setImportantForAccessibility(this.isCollapsed ? 1 : 0);
        if (this.isCollapsed && (stepOSCollapsibleTabSelectedTab = selectedTab()) != null) {
            contentDescription = stepOSCollapsibleTabSelectedTab.getContentDescription();
        }
        setContentDescription(contentDescription);
        StepOSTabIndicatorView stepOSTabIndicatorView = this.indicatorView;
        stepOSTabIndicatorView.setVisibility(this.isCollapsed ? 8 : stepOSTabIndicatorView.getVisibility());
        if (this.isCollapsed) {
            this.indicatorView.releaseGlass$StepOSWidget_release();
        }
        syncCompactIcon();
    }

    private final List<StepOSCollapsibleTabItemView> visibleItemViews() {
        ArrayList<StepOSCollapsibleTabItemView> arrayList = this.itemViews;
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (Object obj : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            if (this.tabs.get(i10).getVisible()) {
                arrayList2.add(obj);
            }
            i10 = i11;
        }
        return arrayList2;
    }

    public final void applyGlassEnabled$StepOSWidget_release(boolean enabled) {
        setGlassEnabled$StepOSWidget_release(enabled);
        StepOSTabIndicatorView.applyStyle$StepOSWidget_release$default(this.indicatorView, this.indicatorCornerRadius, this.indicatorBlurRadius, this.indicatorColor, this.indicatorTint, enabled, false, 32, null);
    }

    public final void applyHostEnabled$StepOSWidget_release(boolean enabled) {
        if (this.hostEnabled == enabled) {
            return;
        }
        this.hostEnabled = enabled;
        syncItems();
        syncMode();
    }

    /* renamed from: isCollapsed$StepOSWidget_release, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    @Override // com.stepos.widget.tabbar.StepOSCollapsibleGlassSurface, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.compactIconView.setLayerType(0, null);
        this.indicatorView.releaseGlass$StepOSWidget_release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i10;
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        C0.c cVarS0 = C0.c.S0(info);
        if (this.isCollapsed) {
            info.setClassName(Button.class.getName());
            cVarS0.k0(true);
            cVarS0.J0(this.selectedItemId != 0);
            return;
        }
        ArrayList<StepOSCollapsibleTab> arrayList = this.tabs;
        if (arrayList == null || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((StepOSCollapsibleTab) it.next()).getVisible() && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        } else {
            i10 = 0;
        }
        cVarS0.o0(c.f.b(1, i10, false, 1));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth;
        int i10;
        if (this.isCollapsed) {
            int width = (getWidth() - this.compactIconView.getMeasuredWidth()) / 2;
            int height = (getHeight() - this.compactIconView.getMeasuredHeight()) / 2;
            ImageView imageView = this.compactIconView;
            imageView.layout(width, height, imageView.getMeasuredWidth() + width, this.compactIconView.getMeasuredHeight() + height);
            return;
        }
        int i11 = this.outerPadding;
        boolean z10 = getLayoutDirection() == 1;
        int width2 = z10 ? getWidth() - this.outerPadding : this.outerPadding;
        for (StepOSCollapsibleTabItemView stepOSCollapsibleTabItemView : visibleItemViews()) {
            if (z10) {
                int measuredWidth2 = width2 - stepOSCollapsibleTabItemView.getMeasuredWidth();
                i10 = measuredWidth2 - this.itemSpacing;
                measuredWidth = width2;
                width2 = measuredWidth2;
            } else {
                measuredWidth = stepOSCollapsibleTabItemView.getMeasuredWidth() + width2;
                i10 = this.itemSpacing + measuredWidth;
            }
            stepOSCollapsibleTabItemView.layout(width2, i11, measuredWidth, this.itemHeight + i11);
            width2 = i10;
        }
        StepOSCollapsibleTabItemView stepOSCollapsibleTabItemViewSelectedVisibleItemView = selectedVisibleItemView();
        if (stepOSCollapsibleTabItemViewSelectedVisibleItemView == null) {
            this.indicatorView.setVisibility(8);
        } else {
            this.indicatorView.setVisibility(0);
            this.indicatorView.layout(stepOSCollapsibleTabItemViewSelectedVisibleItemView.getLeft(), stepOSCollapsibleTabItemViewSelectedVisibleItemView.getTop(), stepOSCollapsibleTabItemViewSelectedVisibleItemView.getRight(), stepOSCollapsibleTabItemViewSelectedVisibleItemView.getBottom());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.isCollapsed) {
            this.compactIconView.measure(View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824));
        } else {
            List<StepOSCollapsibleTabItemView> listVisibleItemViews = visibleItemViews();
            int[] iArrMeasureItemWidths = measureItemWidths(size, listVisibleItemViews.size());
            int i10 = 0;
            for (Object obj : listVisibleItemViews) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                ((StepOSCollapsibleTabItemView) obj).measure(View.MeasureSpec.makeMeasureSpec(iArrMeasureItemWidths[i10], 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824));
                i10 = i11;
            }
            ArrayList<StepOSCollapsibleTabItemView> arrayList = this.itemViews;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((StepOSCollapsibleTabItemView) obj2).getVisibility() == 8) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((StepOSCollapsibleTabItemView) it.next()).measure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
            }
            StepOSCollapsibleTabItemView stepOSCollapsibleTabItemViewSelectedVisibleItemView = selectedVisibleItemView();
            this.indicatorView.measure(View.MeasureSpec.makeMeasureSpec(stepOSCollapsibleTabItemViewSelectedVisibleItemView != null ? stepOSCollapsibleTabItemViewSelectedVisibleItemView.getMeasuredWidth() : 0, 1073741824), View.MeasureSpec.makeMeasureSpec(stepOSCollapsibleTabItemViewSelectedVisibleItemView != null ? this.itemHeight : 0, 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    public final void setCollapsed$StepOSWidget_release(boolean z10) {
        if (this.isCollapsed == z10) {
            return;
        }
        this.isCollapsed = z10;
        syncMode();
        requestLayout();
    }

    public final void setSelectedColor$StepOSWidget_release(int color) {
        if (this.selectedColor == color) {
            return;
        }
        this.selectedColor = color;
        syncColors();
        syncItems();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[LOOP:1: B:15:0x0049->B:17:0x004f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[LOOP:2: B:19:0x0065->B:21:0x006b, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void submitTabs$StepOSWidget_release(java.util.List<com.stepos.widget.tabbar.StepOSCollapsibleTab> r7, int r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.p.i(r7, r0)
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTab> r0 = r6.tabs
            int r0 = r0.size()
            int r1 = r7.size()
            if (r0 != r1) goto L43
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTab> r0 = r6.tabs
            v9.i r0 = Z8.C1173v.n(r0)
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L26
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L26
            goto La1
        L26:
            java.util.Iterator r0 = r0.iterator()
        L2a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto La1
            r1 = r0
            Z8.M r1 = (Z8.M) r1
            int r1 = r1.nextInt()
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTab> r2 = r6.tabs
            java.lang.Object r2 = r2.get(r1)
            java.lang.Object r1 = r7.get(r1)
            if (r2 == r1) goto L2a
        L43:
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTabItemView> r0 = r6.itemViews
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L59
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            r6.removeView(r1)
            goto L49
        L59:
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTabItemView> r0 = r6.itemViews
            r0.clear()
            r0 = r7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L65:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto La1
            java.lang.Object r1 = r0.next()
            com.stepos.widget.tabbar.StepOSCollapsibleTab r1 = (com.stepos.widget.tabbar.StepOSCollapsibleTab) r1
            com.stepos.widget.tabbar.StepOSCollapsibleTabItemView r2 = new com.stepos.widget.tabbar.StepOSCollapsibleTabItemView
            android.content.Context r3 = r6.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.p.h(r3, r4)
            r2.<init>(r3)
            int r3 = r6.labelAppearance
            android.content.res.ColorStateList r4 = r6.labelTextColor
            android.content.res.ColorStateList r5 = r6.iconTint
            r2.applyStyle$StepOSWidget_release(r3, r4, r5)
            com.stepos.widget.tabbar.c r3 = new com.stepos.widget.tabbar.c
            r3.<init>()
            r2.setOnClickListener(r3)
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTabItemView> r1 = r6.itemViews
            r1.add(r2)
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r3 = 0
            int r4 = r6.itemHeight
            r1.<init>(r3, r4)
            super.addView(r2, r1)
            goto L65
        La1:
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTab> r0 = r6.tabs
            r0.clear()
            java.util.ArrayList<com.stepos.widget.tabbar.StepOSCollapsibleTab> r0 = r6.tabs
            java.util.Collection r7 = (java.util.Collection) r7
            r0.addAll(r7)
            r6.selectedItemId = r8
            r6.syncItems()
            r6.syncMode()
            if (r9 == 0) goto Lc1
            com.stepos.widget.tabbar.StepOSCollapsibleTabItemView r7 = r6.selectedVisibleItemView()
            if (r7 == 0) goto Lc1
            r8 = 4
            r7.sendAccessibilityEvent(r8)
        Lc1:
            r6.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.tabbar.StepOSCollapsibleTabStrip.submitTabs$StepOSWidget_release(java.util.List, int, boolean):void");
    }
}
