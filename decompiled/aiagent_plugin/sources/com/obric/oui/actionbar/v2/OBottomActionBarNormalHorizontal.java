package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.d.a.b;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OBottomActionBarNormalHorizontal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomActionBarNormalHorizontal extends FrameLayout {
    public static final a Companion = null;
    private static final int MAX_BUTTONS = 2;
    public static final String TAG = "OBottomActionBarNormalHorizontal";
    private final int BOTTOM_ACTION_PADDING_BOTTOM;
    private final int BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    private int buttonGap;
    private int defaultPaddingBottom;
    private ODivider divider;
    private FrameLayout headerContainer;
    private LinearLayout horizontalContainer;
    private int maxButtons;
    private View root;

    /* JADX INFO: compiled from: OBottomActionBarNormalHorizontal.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBarNormalHorizontal(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: lambda$sD585snicY-vMCVyeoEhx_r5M1k, reason: not valid java name */
    public static /* synthetic */ WindowInsets m967lambda$sD585snicYvMCVyeoEhx_r5M1k(OBottomActionBarNormalHorizontal r0, View r1, WindowInsets r2) {
        return m968lambda3$lambda2(r0, r1, r2);
    }

    public OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13);
        this.BOTTOM_ACTION_PADDING_BOTTOM = 24;
        this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE = 40;
        this.buttonGap = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        this.maxButtons = 2;
        ZeusTransformUtils.inflate(r12, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_v2_normal_horizontal, "layout", "o_widget_bottom_action_bar_v2_normal_horizontal"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_action_bar_root, DbHelper.COL_ID, "bottom_action_bar_root"));
        o.c(r0, "findViewById(R.id.bottom_action_bar_root)");
        this.root = r0;
        this.defaultPaddingBottom = r0.getPaddingBottom();
        ODivider r1 = new ODivider(r12, null, 0, 6, null);
        this.divider = r1;
        addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0.6d)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_horizontal_container, DbHelper.COL_ID, "action_bar_horizontal_container"));
        o.c(r2, "findViewById(R.id.action_bar_horizontal_container)");
        this.horizontalContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_header_container, DbHelper.COL_ID, "action_bar_header_container"));
        o.c(r3, "findViewById(R.id.action_bar_header_container)");
        this.headerContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.aiagent.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        int[] r4 = R.styleable.OBottomActionBar;
        o.c(r4, "OBottomActionBar");
        TypedArray r14 = r12.obtainStyledAttributes(r13, r4, 0, 0);
        o.c(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, "styleable", "OBottomActionBar_oui_widgetFitInsetBottom"), true) == false) goto L5;
        com.obric.oui.window.a r15 = com.obric.oui.window.a.f36851a;
        updateLayoutForInsetBottom(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), null, true).f36824e);
        setOnApplyWindowInsetsListener(new $$Lambda$OBottomActionBarNormalHorizontal$sD585snicYvMCVyeoEhx_r5M1k(this));
    L5:
        r14.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalHorizontal(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM() {
        return this.BOTTOM_ACTION_PADDING_BOTTOM;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE() {
        return this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    }

    /* JADX INFO: renamed from: lambda-3$lambda-2, reason: not valid java name */
    private static final WindowInsets m968lambda3$lambda2(OBottomActionBarNormalHorizontal r1, View r2, WindowInsets r3) {
        o.e(r1, "this$0");
        o.e(r2, "$noName_0");
        o.e(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f36851a;
        r1.updateLayoutForInsetBottom(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r3, true).f36824e);
        return r3;
    }

    public final void updateLayoutForInsetBottom(int r8) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        if (com.obric.oui.window.a.f(r0) == true) goto L7;
        if (r8 <= 0) goto L7;
        int r1 = this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    L8:
        View r2 = this.root;
        r2.setPaddingRelative(r2.getPaddingLeft(), this.root.getPaddingTop(), this.root.getPaddingRight(), Math.max(r8, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r1)));
        return;
    L7:
        r1 = this.BOTTOM_ACTION_PADDING_BOTTOM;
        goto L8
    }

    public final void showDivider(boolean r1) {
        ODivider r0 = this.divider;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final int getButtonCount() {
        return this.horizontalContainer.getChildCount();
    }

    public final void setButtons(List<? extends View> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "buttons");
        if (r7.size() <= this.maxButtons) goto L6;
        b.d(TAG, "Cannot set more than " + this.maxButtons + " buttons");
        return;
    L6:
        this.horizontalContainer.removeAllViews();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if (r7.size() == 1) goto L13;
        r4 = false;
    L13:
        addButton(r2, r4);
        goto L8
    }

    private final void addButton(View r5, boolean r6) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L5;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r0.width, r0.height);
    L6:
        if (r6 == false) goto L8;
        r2.width = -1;
    L9:
        LinearLayout r7 = this.horizontalContainer;
        if (r7.getChildCount() <= 0) goto L12;
        r2.leftMargin = this.buttonGap;
    L12:
        x r4 = x.f38692a;
        r7.addView(r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r2.width = 0;
        r2.weight = 1.0f;
        goto L9
    L5:
        r2 = new LinearLayout.LayoutParams(-1, -2);
        goto L6
    }

    public final void removeButton(View r2) {
        o.e(r2, "button");
        this.horizontalContainer.removeView(r2);
    }

    public final void removeButton() {
        if (this.horizontalContainer.getChildCount() != 0) goto L6;
        b.d(TAG, "No buttons to remove");
        return;
    L6:
        LinearLayout r1 = this.horizontalContainer;
        r1.removeViewAt(r1.getChildCount() - 1);
    }

    public final void removeAllButtons() {
        this.horizontalContainer.removeAllViews();
    }

    public final int getMaxButtonCount() {
        return this.maxButtons;
    }

    public final void setMaxButtonCount(int r3) {
        if (this.horizontalContainer.getChildCount() <= r3) goto L6;
        b.e(TAG, "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r3 <= 0) goto L8;
        this.maxButtons = r3;
        return;
    L8:
        b.e(TAG, "Max button count must be greater than 0");
    }

    public final void setHeaderView(View r3) {
        o.e(r3, "headerView");
        this.headerContainer.removeAllViews();
        this.headerContainer.addView(r3);
        ViewGroup.LayoutParams r4 = this.horizontalContainer.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r5.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    }

    public final void removeHeaderView() {
        this.headerContainer.removeAllViews();
        ViewGroup.LayoutParams r0 = this.horizontalContainer.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r1.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
    }

    public final boolean hasHeaderView() {
        if (this.headerContainer.getChildCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
