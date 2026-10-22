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

/* JADX INFO: compiled from: OBottomActionBarNormalVertical.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomActionBarNormalVertical extends FrameLayout {
    public static final a Companion = null;
    private static final int MAX_BUTTONS = 3;
    public static final String TAG = "OBottomActionBarNormalVertical";
    private final int BOTTOM_ACTION_PADDING_BOTTOM;
    private final int BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    private int buttonGap;
    private int defaultPaddingBottom;
    private ODivider divider;
    private FrameLayout headerContainer;
    private int maxButtons;
    private View root;
    private LinearLayout verticalContainer;

    /* JADX INFO: compiled from: OBottomActionBarNormalVertical.kt */
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
    public OBottomActionBarNormalVertical(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: lambda$V7R1qNDd4z_XD1-g8lKPJhqu7b4, reason: not valid java name */
    public static /* synthetic */ WindowInsets m969lambda$V7R1qNDd4z_XD1g8lKPJhqu7b4(OBottomActionBarNormalVertical r0, View r1, WindowInsets r2) {
        return m970lambda3$lambda2(r0, r1, r2);
    }

    public OBottomActionBarNormalVertical(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13);
        this.BOTTOM_ACTION_PADDING_BOTTOM = 24;
        this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE = 40;
        this.buttonGap = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        this.maxButtons = 3;
        FrameLayout.inflate(r12, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_v2_normal_vertical, "layout", "o_widget_bottom_action_bar_v2_normal_vertical"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_action_bar_root, DbHelper.COL_ID, "bottom_action_bar_root"));
        o.c(r0, "findViewById(R.id.bottom_action_bar_root)");
        this.root = r0;
        this.defaultPaddingBottom = r0.getPaddingBottom();
        ODivider r1 = new ODivider(r12, null, 0, 6, null);
        this.divider = r1;
        addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0.6d)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_vertical_container, DbHelper.COL_ID, "action_bar_vertical_container"));
        o.c(r2, "findViewById(R.id.action_bar_vertical_container)");
        this.verticalContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.aiagent.plugin");
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
        setOnApplyWindowInsetsListener(new $$Lambda$OBottomActionBarNormalVertical$V7R1qNDd4z_XD1g8lKPJhqu7b4(this));
    L5:
        r14.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalVertical(Context r2, AttributeSet r3, int r4, h r5) {
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
    private static final WindowInsets m970lambda3$lambda2(OBottomActionBarNormalVertical r1, View r2, WindowInsets r3) {
        o.e(r1, "this$0");
        o.e(r2, "$noName_0");
        o.e(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f36851a;
        r1.updateLayoutForInsetBottom(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r3, true).f36824e);
        return r3;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.headerContainer.getChildCount() <= 0) goto L19;
        int r0 = View.MeasureSpec.getSize(r11);
        int r1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10), Integer.MIN_VALUE);
        int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.verticalContainer.measure(r1, r3);
        int r4 = this.verticalContainer.getMeasuredHeight();
        int r5 = this.root.getPaddingTop() + this.root.getPaddingBottom();
        ViewGroup.LayoutParams r6 = this.verticalContainer.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        if (r7 != null) goto L10;
        int r8 = 0;
    L11:
        int r2 = Math.max(0, r0 - ((r5 + r8) + r4));
        this.headerContainer.measure(r1, r3);
        int r9 = this.headerContainer.getMeasuredHeight();
        ViewGroup.LayoutParams r12 = this.headerContainer.getLayoutParams();
        if (r2 >= r9) goto L17;
        if (r12.height == r2) goto L19;
        r12.height = r2;
        this.headerContainer.setLayoutParams(r12);
        goto L19
    L17:
        if (r12.height == (-2)) goto L19;
        r12.height = -2;
        this.headerContainer.setLayoutParams(r12);
        goto L19
    L10:
        r8 = r7.topMargin;
        goto L11
    L7:
        r7 = null;
    L19:
        super.onMeasure(r10, r11);
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
        return this.verticalContainer.getChildCount();
    }

    public final void setButtons(List<? extends View> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "buttons");
        this.verticalContainer.removeAllViews();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        addButton((View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public final void addButton(View r4) {
        o.e(r4, "button");
        int r0 = this.verticalContainer.getChildCount();
        int r1 = this.maxButtons;
        if (r0 < r1) goto L6;
        b.d(TAG, o.a("Maximum number of buttons reached: ", Integer.valueOf(r1)));
        return;
    L6:
        ViewGroup.LayoutParams r2 = r4.getLayoutParams();
        if (r2 == null) goto L9;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r2.width, r2.height);
    L10:
        LinearLayout r5 = this.verticalContainer;
        if (r5.getChildCount() <= 0) goto L13;
        r3.topMargin = this.buttonGap;
    L13:
        x r6 = x.f38692a;
        r5.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r3 = new LinearLayout.LayoutParams(-1, -2);
        goto L10
    }

    public final void removeButton(View r2) {
        o.e(r2, "button");
        this.verticalContainer.removeView(r2);
    }

    public final void removeButton() {
        if (this.verticalContainer.getChildCount() != 0) goto L6;
        b.d(TAG, "No buttons to remove");
        return;
    L6:
        LinearLayout r1 = this.verticalContainer;
        r1.removeViewAt(r1.getChildCount() - 1);
    }

    public final void removeAllButtons() {
        this.verticalContainer.removeAllViews();
    }

    public final int getMaxButtonCount() {
        return this.maxButtons;
    }

    public final void setMaxButtonCount(int r3) {
        if (this.verticalContainer.getChildCount() <= r3) goto L6;
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
        ViewGroup.LayoutParams r4 = this.verticalContainer.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r5.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    }

    public final void removeHeaderView() {
        this.headerContainer.removeAllViews();
        ViewGroup.LayoutParams r0 = this.verticalContainer.getLayoutParams();
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
