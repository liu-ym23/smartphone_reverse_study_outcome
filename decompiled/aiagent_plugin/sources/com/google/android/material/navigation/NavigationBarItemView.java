package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.aa;
import androidx.core.view.ViewCompat;
import androidx.core.view.w;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.g.c;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarItemView extends FrameLayout implements e.a {
    private static final a ACTIVE_INDICATOR_LABELED_TRANSFORM = null;
    private static final a ACTIVE_INDICATOR_UNLABELED_TRANSFORM = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private a activeIndicatorTransform;
    private final View activeIndicatorView;
    private BadgeDrawable badgeDrawable;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    private static class a {
        public float c(float r1, float r2) {
            return 1.0f;
        }

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public float a(float r3, float r4) {
            if (r4 != 0.0f) goto L5;
            float r0 = 0.8f;
        L7:
            if (r4 != 0.0f) goto L9;
            float r5 = 1.0f;
        L11:
            return com.google.android.material.animation.a.a(0.0f, 1.0f, r0, r5, r3);
        L9:
            r5 = 0.2f;
            goto L11
        L5:
            r0 = 0.0f;
            goto L7
        }

        public float b(float r1, float r2) {
            return com.google.android.material.animation.a.a(0.4f, 1.0f, r1);
        }

        public void a(float r2, float r3, View r4) {
            r4.setScaleX(b(r2, r3));
            r4.setScaleY(c(r2, r3));
            r4.setAlpha(a(r2, r3));
        }
    }

    private static class b extends a {
        private b() {
            super(null);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.a
        public float c(float r1, float r2) {
            return b(r1, r2);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public abstract int getItemLayoutResId();

    @Override // androidx.appcompat.view.menu.e.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean r1, char r2) {
    }

    public boolean showsIcon() {
        return true;
    }

    static /* synthetic */ ImageView access$200(NavigationBarItemView r0) {
        return r0.icon;
    }

    static /* synthetic */ void access$300(NavigationBarItemView r0, View r1) {
        r0.tryUpdateBadgeBounds(r1);
    }

    static /* synthetic */ void access$400(NavigationBarItemView r0, int r1) {
        r0.updateActiveIndicatorLayoutParams(r1);
    }

    static /* synthetic */ void access$500(NavigationBarItemView r0, float r1, float r2) {
        r0.setActiveIndicatorProgress(r1, r2);
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        AnonymousClass1 r1 = null;
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new a(r1);
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new b(r1);
    }

    public NavigationBarItemView(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        super(r9);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), getItemLayoutResId(), this, true, "com.obric.aiagent.plugin");
        this.iconContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_icon_container, DbHelper.COL_ID, "navigation_bar_item_icon_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.activeIndicatorView = findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_active_indicator_view, DbHelper.COL_ID, "navigation_bar_item_active_indicator_view"));
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_icon_view, DbHelper.COL_ID, "navigation_bar_item_icon_view")), ImageView.class, "com.obric.aiagent.plugin");
        this.icon = r10;
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_labels_group, DbHelper.COL_ID, "navigation_bar_item_labels_group")), ViewGroup.class, "com.obric.aiagent.plugin");
        this.labelGroup = r3;
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_small_label_view, DbHelper.COL_ID, "navigation_bar_item_small_label_view")), TextView.class, "com.obric.aiagent.plugin");
        this.smallLabel = r4;
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.navigation_bar_item_large_label_view, DbHelper.COL_ID, "navigation_bar_item_large_label_view")), TextView.class, "com.obric.aiagent.plugin");
        this.largeLabel = r0;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = r3.getPaddingBottom();
        ViewCompat.c(r4, 2);
        ViewCompat.c(r0, 2);
        setFocusable(true);
        calculateTextScaleFactors(r4.getTextSize(), r0.getTextSize());
        if (r10 == null) goto L6;
        r10.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.labelGroup.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = (r0.leftMargin + this.labelGroup.getMeasuredWidth()) + r0.rightMargin;
        return Math.max(getSuggestedIconWidth(), r1);
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.labelGroup.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        return ((getSuggestedIconHeight() + r0.topMargin) + this.labelGroup.getMeasuredHeight()) + r0.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void initialize(MenuItemImpl r3, int r4) {
        this.itemData = r3;
        setCheckable(r3.isCheckable());
        setChecked(r3.isChecked());
        setEnabled(r3.isEnabled());
        setIcon(r3.getIcon());
        setTitle(r3.getTitle());
        setId(r3.getItemId());
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L6;
        setContentDescription(r3.getContentDescription());
    L6:
        if (TextUtils.isEmpty(r3.getTooltipText()) == true) goto L8;
        CharSequence r5 = r3.getTooltipText();
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L12;
    L13:
        aa.a(this, r5);
    L15:
        if (r3.isVisible() == false) goto L17;
        int r6 = 0;
    L18:
        setVisibility(r6);
        this.initialized = true;
        return;
    L17:
        r6 = 8;
        goto L18
    L12:
        if (Build.VERSION.SDK_INT <= 23) goto L15;
    L8:
        r5 = r3.getTitle();
        goto L10
    }

    void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    private View getIconOrContainer() {
        FrameLayout r0 = this.iconContainer;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.icon;
    }

    public void setItemPosition(int r1) {
        this.itemPosition = r1;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean r2) {
        if (this.isShifting == r2) goto L6;
        this.isShifting = r2;
        refreshChecked();
        return;
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.labelVisibilityMode == r2) goto L6;
        this.labelVisibilityMode = r2;
        updateActiveIndicatorTransform();
        updateActiveIndicatorLayoutParams(getWidth());
        refreshChecked();
        return;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.smallLabel.setText(r4);
        this.largeLabel.setText(r4);
        MenuItemImpl r0 = this.itemData;
        if (r0 != null) goto L5;
    L6:
        setContentDescription(r4);
    L7:
        MenuItemImpl r1 = this.itemData;
        if (r1 == null) goto L14;
        if (TextUtils.isEmpty(r1.getTooltipText()) == true) goto L14;
        r4 = this.itemData.getTooltipText();
    L14:
        if (Build.VERSION.SDK_INT >= 21) goto L16;
    L17:
        aa.a(this, r4);
        return;
    L16:
        if (Build.VERSION.SDK_INT > 23) goto L17;
        return;
    L5:
        if (TextUtils.isEmpty(r0.getContentDescription()) == false) goto L7;
        goto L6
    }

    public void setCheckable(boolean r1) {
        refreshDrawableState();
    }

    @Override // android.view.View
    public void onSizeChanged(final int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        post(new AnonymousClass2(this, r1));
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L5;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        return;
    L5:
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
    }

    private void setActiveIndicatorProgress(float r3, float r4) {
        View r0 = this.activeIndicatorView;
        if (r0 == null) goto L5;
        this.activeIndicatorTransform.a(r3, r4, r0);
    L5:
        this.activeIndicatorProgress = r3;
    }

    private void maybeAnimateActiveIndicatorToProgress(final float r7) {
        if (this.activeIndicatorEnabled == true) goto L5;
    L14:
        setActiveIndicatorProgress(r7, r7);
        return;
    L5:
        if (this.initialized == false) goto L14;
        if (ViewCompat.I(this) == false) goto L14;
        ValueAnimator r0 = this.activeIndicatorAnimator;
        if (r0 == null) goto L12;
        r0.cancel();
        this.activeIndicatorAnimator = null;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, r7});
        this.activeIndicatorAnimator = r1;
        r1.addUpdateListener(new AnonymousClass3(this, r7));
        this.activeIndicatorAnimator.setInterpolator(com.google.android.material.f.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.motionEasingStandard, "attr", "motionEasingStandard"), com.google.android.material.animation.a.f13143b));
        this.activeIndicatorAnimator.setDuration(com.google.android.material.f.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.motionDurationLong1, "attr", "motionDurationLong1"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.integer.material_motion_duration_long_1, WsChannelMultiProcessSharedProvider.INT_TYPE, "material_motion_duration_long_1"))));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl r0 = this.itemData;
        if (r0 == null) goto L6;
        setChecked(r0.isChecked());
        return;
    }

    public void setChecked(boolean r9) {
        TextView r0 = this.largeLabel;
        r0.setPivotX(r0.getWidth() / 2);
        TextView r1 = this.largeLabel;
        r1.setPivotY(r1.getBaseline());
        TextView r2 = this.smallLabel;
        r2.setPivotX(r2.getWidth() / 2);
        TextView r3 = this.smallLabel;
        r3.setPivotY(r3.getBaseline());
        if (r9 == false) goto L5;
        float r4 = 1.0f;
    L6:
        maybeAnimateActiveIndicatorToProgress(r4);
        int r5 = this.labelVisibilityMode;
        if (r5 == (-1)) goto L23;
        if (r5 != 0) goto L10;
        if (r9 == false) goto L20;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L21:
        this.smallLabel.setVisibility(4);
    L32:
        refreshDrawableState();
        setSelected(r9);
        return;
    L20:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L21
    L10:
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L32;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L32
    L14:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r9 == false) goto L17;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r6 = this.smallLabel;
        float r7 = this.scaleUpFactor;
        setViewScaleValues(r6, r7, r7, 4);
        goto L32
    L17:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r8 = this.largeLabel;
        float r10 = this.scaleDownFactor;
        setViewScaleValues(r8, r10, r10, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L23:
        if (this.isShifting == false) goto L28;
        if (r9 == false) goto L26;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L27:
        this.smallLabel.setVisibility(4);
        goto L32
    L26:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L27
    L28:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r9 == false) goto L31;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r11 = this.smallLabel;
        float r12 = this.scaleUpFactor;
        setViewScaleValues(r11, r12, r12, 4);
        goto L32
    L31:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r13 = this.largeLabel;
        float r14 = this.scaleDownFactor;
        setViewScaleValues(r13, r14, r14, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L5:
        r4 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r7) {
        super.onInitializeAccessibilityNodeInfo(r7);
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 != null) goto L5;
    L10:
        androidx.core.view.accessibility.b r8 = androidx.core.view.accessibility.b.a(r7);
        r8.c(androidx.core.view.accessibility.b.g.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected() == false) goto L13;
        r8.h(false);
        r8.b(androidx.core.view.accessibility.b.a.f1442e);
    L13:
        r8.j(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.item_view_role_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "item_view_role_description")));
        return;
    L5:
        if (r0.isVisible() == false) goto L10;
        CharSequence r1 = this.itemData.getTitle();
        if (TextUtils.isEmpty(this.itemData.getContentDescription()) == true) goto L9;
        r1 = this.itemData.getContentDescription();
    L9:
        r7.setContentDescription(r1 + ", " + this.badgeDrawable.getContentDescription());
        goto L10
    }

    private int getItemVisiblePosition() {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        int r5 = r0.indexOfChild(this);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L10;
        View r3 = r0.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r3, NavigationBarItemView.class) == false) goto L9;
        if (r3.getVisibility() != 0) goto L9;
        r2 = r2 + 1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r2;
    }

    private static void setViewTopMarginAndGravity(View r3, int r4, int r5) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r0.topMargin = r4;
        r0.bottomMargin = r4;
        r0.gravity = r5;
        r3.setLayoutParams(r0);
    }

    private static void setViewScaleValues(View r0, float r1, float r2, int r3) {
        r0.setScaleX(r1);
        r0.setScaleY(r2);
        r0.setVisibility(r3);
    }

    private static void updateViewPaddingBottom(View r3, int r4) {
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        this.smallLabel.setEnabled(r3);
        this.largeLabel.setEnabled(r3);
        this.icon.setEnabled(r3);
        if (r3 == false) goto L5;
        ViewCompat.a(this, w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1002));
        return;
    L5:
        ViewCompat.a(this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        MenuItemImpl r0 = this.itemData;
        if (r0 != null) goto L5;
    L9:
        return r3;
    L5:
        if (r0.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
        goto L9
    }

    public void setIcon(Drawable r2) {
        if (r2 != this.originalIconDrawable) goto L5;
        return;
    L5:
        this.originalIconDrawable = r2;
        if (r2 == null) goto L14;
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L11;
        r2 = r0.newDrawable();
    L11:
        r2 = androidx.core.graphics.drawable.a.g(r2).mutate();
        this.wrappedIconDrawable = r2;
        ColorStateList r1 = this.iconTint;
        if (r1 == null) goto L14;
        androidx.core.graphics.drawable.a.a(r2, r1);
    L14:
        this.icon.setImageDrawable(r2);
    }

    public void setIconTintList(ColorStateList r2) {
        this.iconTint = r2;
        if (this.itemData == null) goto L8;
        Drawable r0 = this.wrappedIconDrawable;
        if (r0 == null) goto L9;
        androidx.core.graphics.drawable.a.a(r0, r2);
        this.wrappedIconDrawable.invalidateSelf();
        return;
    L9:
        return;
    }

    public void setIconSize(int r4) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.icon.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r0.width = r4;
        r0.height = r4;
        this.icon.setLayoutParams(r0);
    }

    public void setTextAppearanceInactive(int r2) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int r2) {
        setTextAppearanceWithoutFontScaling(this.largeLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    private static void setTextAppearanceWithoutFontScaling(TextView r3, int r4) {
        TextViewCompat.a(r3, r4);
        int r5 = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, 0);
        if (r5 == 0) goto L6;
        r3.setTextSize(0, r5);
        return;
    }

    public void setTextColor(ColorStateList r2) {
        if (r2 == null) goto L5;
        this.smallLabel.setTextColor(r2);
        this.largeLabel.setTextColor(r2);
        return;
    }

    private void calculateTextScaleFactors(float r3, float r4) {
        this.shiftAmount = r3 - r4;
        this.scaleUpFactor = (r4 * 1.0f) / r3;
        this.scaleDownFactor = (r3 * 1.0f) / r4;
    }

    public void setItemBackground(int r4) {
        if (r4 != 0) goto L4;
        Drawable r5 = null;
    L5:
        setItemBackground(r5);
        return;
    L4:
        r5 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        goto L5
    }

    public void setItemBackground(Drawable r2) {
        if (r2 != null) goto L4;
    L6:
        ViewCompat.a(this, r2);
        return;
    L4:
        if (r2.getConstantState() == null) goto L6;
        r2 = r2.getConstantState().newDrawable().mutate();
        goto L6
    }

    public void setItemPaddingTop(int r2) {
        if (this.itemPaddingTop == r2) goto L6;
        this.itemPaddingTop = r2;
        refreshChecked();
        return;
    }

    public void setItemPaddingBottom(int r2) {
        if (this.itemPaddingBottom == r2) goto L6;
        this.itemPaddingBottom = r2;
        refreshChecked();
        return;
    }

    public void setActiveIndicatorEnabled(boolean r2) {
        this.activeIndicatorEnabled = r2;
        View r0 = this.activeIndicatorView;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void setActiveIndicatorWidth(int r1) {
        this.activeIndicatorDesiredWidth = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    private void updateActiveIndicatorLayoutParams(int r4) {
        if (this.activeIndicatorView != null) goto L5;
        return;
    L5:
        int r5 = Math.min(this.activeIndicatorDesiredWidth, r4 - (this.activeIndicatorMarginHorizontal * 2));
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.activeIndicatorView.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L8;
        int r1 = r5;
    L9:
        r0.height = r1;
        r0.width = r5;
        this.activeIndicatorView.setLayoutParams(r0);
        return;
    L8:
        r1 = this.activeIndicatorDesiredHeight;
        goto L9
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (this.activeIndicatorResizeable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.labelVisibilityMode != 2) goto L7;
        return true;
    }

    public void setActiveIndicatorHeight(int r1) {
        this.activeIndicatorDesiredHeight = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int r1) {
        this.activeIndicatorMarginHorizontal = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public Drawable getActiveIndicatorDrawable() {
        View r0 = this.activeIndicatorView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBackground();
    }

    public void setActiveIndicatorDrawable(Drawable r1) {
        View r0 = this.activeIndicatorView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundDrawable(r1);
    }

    public void setActiveIndicatorResizeable(boolean r1) {
        this.activeIndicatorResizeable = r1;
    }

    void setBadge(BadgeDrawable r3) {
        if (this.badgeDrawable != r3) goto L6;
        return;
    L6:
        if (hasBadge() == true) goto L8;
    L10:
        this.badgeDrawable = r3;
        ImageView r4 = this.icon;
        if (r4 == null) goto L14;
        tryAttachBadgeToAnchor(r4);
        return;
    L14:
        return;
    L8:
        if (this.icon == null) goto L10;
        INVOKESTATIC_com_google_android_material_navigation_NavigationBarItemView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
        tryRemoveBadgeFromAnchor(this.icon);
        goto L10
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    private boolean hasBadge() {
        if (this.badgeDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void tryUpdateBadgeBounds(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        com.google.android.material.badge.a.b(this.badgeDrawable, r2, getCustomParentForBadge(r2));
    }

    private void tryAttachBadgeToAnchor(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        com.google.android.material.badge.a.a(this.badgeDrawable, r2, getCustomParentForBadge(r2));
        return;
    }

    private void tryRemoveBadgeFromAnchor(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        com.google.android.material.badge.a.a(this.badgeDrawable, r2);
    L7:
        this.badgeDrawable = null;
    }

    private FrameLayout getCustomParentForBadge(View r3) {
        if (r3 == this.icon) goto L5;
        return null;
    L5:
        if (com.google.android.material.badge.a.f13204a == true) goto L7;
        return null;
    L7:
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.icon.getParent(), FrameLayout.class, "com.obric.aiagent.plugin");
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getIconOrContainer().getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        return (Math.max(r1, r2.leftMargin) + this.icon.getMeasuredWidth()) + Math.max(r1, r2.rightMargin);
    L5:
        r1 = r0.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        goto L6
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 == null) goto L5;
        int r1 = r0.getMinimumHeight() / 2;
    L7:
        return (Math.max(r1, ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getIconOrContainer().getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin")).topMargin) + this.icon.getMeasuredWidth()) + r1;
    L5:
        r1 = 0;
        goto L7
    }

    public int getItemBackgroundResId() {
        return ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.drawable.mtrl_navigation_bar_item_background, "drawable", "mtrl_navigation_bar_item_background");
    }

    public int getItemDefaultMarginResId() {
        return ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.dimen.mtrl_navigation_bar_item_default_margin, "dimen", "mtrl_navigation_bar_item_default_margin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_navigation_NavigationBarItemView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
