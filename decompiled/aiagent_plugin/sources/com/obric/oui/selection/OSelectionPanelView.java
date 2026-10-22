package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OSelectionPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OSelectionPanelView extends LinearLayout {
    private boolean allowDividersShow;
    public View bottomDivider;
    private final FrameLayout btnContainer;
    private b iconLoader;
    private final LinearLayout itemContainer;
    private final NestedScrollView itemScrollView;
    private final List<OSelectionPanelItemView> itemViews;
    private OSingleSelectionPanelView.a onItemSelectListener;
    private OMultiSelectionPanelView.a onMultiItemSelectListener;
    private final ConstraintLayout rootConstraintView;
    private boolean showSelectLabel;
    private boolean supportForMinHeight;

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    public static final class a implements b {
        public a() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.b
        public void a(ImageView r2, c r3, Context r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "iconImageView");
            o.e(r3, "data");
            o.e(r1, "context");
            r2.setImageDrawable(r3.a());
        }
    }

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    public interface b {
        void a(ImageView r1, c r2, Context r3);
    }

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f36161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f36162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f36163c;

        public c() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36161a, r6.f36161a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36162b, r6.f36162b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f36163c, r6.f36163c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Drawable r0 = this.f36161a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f36162b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f36163c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SelectionItemData(iconDrawable=" + this.f36161a + ", title=" + this.f36162b + ", iconUrl=" + this.f36163c + ')';
        }

        public c(Drawable r1, String r2, String r3) {
            this.f36161a = r1;
            this.f36162b = r2;
            this.f36163c = r3;
        }

        public /* synthetic */ c(Drawable r2, String r3, String r4, int r5, h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final Drawable a() {
            return this.f36161a;
        }

        public final String b() {
            return this.f36162b;
        }

        public final String c() {
            return this.f36163c;
        }
    }

    public OSelectionPanelView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSelectionPanelView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$CRf0vpWTGHxTuja7ZG9tAc4JBYE(OSelectionPanelView r0, OSelectionPanelItemView r1, int r2, View r3) {
        m1166setItems$lambda3$lambda2$lambda1(r0, r1, r2, r3);
    }

    public abstract void initHeight();

    public abstract boolean isMultiSelect();

    public abstract void select(int r1);

    public /* synthetic */ OSelectionPanelView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.style.OSelectionPanel, "style", "OSelectionPanel");
    L8:
        this(r7, r8, r4);
    }

    public OSelectionPanelView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r7, r6), Context.class, "com.obric.aiagent.plugin"), r8);
        this.showSelectLabel = true;
        this.iconLoader = (b) ZeusTransformUtils.preCheckCast(new a(), b.class, "com.obric.aiagent.plugin");
        this.supportForMinHeight = true;
        this.itemViews = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        LinearLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_selection_panel, "layout", "o_view_selection_panel"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setOrientation(1);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.item_container, DbHelper.COL_ID, "item_container"));
        o.c(r9, "findViewById(R.id.item_container)");
        this.itemContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_container, DbHelper.COL_ID, "btn_container"));
        o.c(r10, "findViewById(R.id.btn_container)");
        this.btnContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.item_scroll_view, DbHelper.COL_ID, "item_scroll_view"));
        o.c(r11, "findViewById(R.id.item_scroll_view)");
        this.itemScrollView = (NestedScrollView) ZeusTransformUtils.preCheckCast(r11, NestedScrollView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.root_constraint, DbHelper.COL_ID, "root_constraint"));
        o.c(r12, "findViewById(R.id.root_constraint)");
        this.rootConstraintView = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_divider, DbHelper.COL_ID, "bottom_divider"));
        o.c(r13, "findViewById(R.id.bottom_divider)");
        setBottomDivider(r13);
    }

    public final View getBottomDivider() {
        View r0 = this.bottomDivider;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("bottomDivider");
        return null;
    }

    public final void setBottomDivider(View r2) {
        o.e(r2, "<set-?>");
        this.bottomDivider = r2;
    }

    public final List<OSelectionPanelItemView> getItemViews() {
        return this.itemViews;
    }

    public final OSingleSelectionPanelView.a getOnItemSelectListener() {
        return this.onItemSelectListener;
    }

    public final void setOnItemSelectListener(OSingleSelectionPanelView.a r3) {
        this.onItemSelectListener = (OSingleSelectionPanelView.a) ZeusTransformUtils.wrapperContextForParams(r3, OSingleSelectionPanelView.a.class, "com.obric.aiagent.plugin");
    }

    public final OMultiSelectionPanelView.a getOnMultiItemSelectListener() {
        return this.onMultiItemSelectListener;
    }

    public final void setOnMultiItemSelectListener(OMultiSelectionPanelView.a r3) {
        this.onMultiItemSelectListener = (OMultiSelectionPanelView.a) ZeusTransformUtils.wrapperContextForParams(r3, OMultiSelectionPanelView.a.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void addBtnView$default(OSelectionPanelView r0, View r1, ViewGroup.LayoutParams r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.addBtnView(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBtnView");
    }

    public final void addBtnView(View r2, ViewGroup.LayoutParams r3) {
        o.e(r2, "view");
        if (r3 != null) goto L5;
        this.btnContainer.addView(r2);
        return;
    L5:
        this.btnContainer.addView(r2, r3);
    }

    public final void showDividers(boolean r1) {
        this.allowDividersShow = r1;
    }

    public final void needShowSelectLabel(boolean r1) {
        this.showSelectLabel = r1;
    }

    public final void showBottomDivider(boolean r1) {
        if (r1 == false) goto L4;
        getBottomDivider().setVisibility(0);
        return;
    L4:
        getBottomDivider().setVisibility(8);
    }

    public final void setItems(List<c> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        o.e(r16, "items");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        final int r0 = 0;
    L4:
        if (r17.hasNext() == false) goto L15;
        Object r2 = r17.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        p.c();
    L8:
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        List<OSelectionPanelItemView> r5 = getItemViews();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        final OSelectionPanelItemView r12 = new OSelectionPanelItemView(r6, null, false, this.allowDividersShow, 6, null);
        r12.setSelectMode(isMultiSelect());
        r12.showSelectLabel(this.showSelectLabel);
        if (r4.a() == null) goto L11;
    L13:
        k.a((View) ZeusTransformUtils.preCheckCast(r12.getIconView(), View.class, "com.obric.aiagent.plugin"));
        b r7 = this.iconLoader;
        ImageView r8 = r12.getIconView();
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        r7.a(r8, r4, r9);
    L14:
        r12.getTextView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        r12.setOnClickListener(new $$Lambda$OSelectionPanelView$CRf0vpWTGHxTuja7ZG9tAc4JBYE(this, r12, r0));
        this.itemContainer.addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        r5.add(r12);
        r0 = r3;
        goto L4
    L11:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L13;
        k.b((View) ZeusTransformUtils.preCheckCast(r12.getIconView(), View.class, "com.obric.aiagent.plugin"));
        goto L14
    L15:
        ((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(p.m(this.itemViews), OSelectionPanelItemView.class, "com.obric.aiagent.plugin")).dismissDivider();
        initHeight();
    }

    /* JADX INFO: renamed from: setItems$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1166setItems$lambda3$lambda2$lambda1(OSelectionPanelView r2, OSelectionPanelItemView r3, int r4, View r5) {
        o.e(r2, "this$0");
        o.e(r3, "$this_apply");
        if (r2.isMultiSelect() == false) goto L8;
        r3.setItemSelected(!r3.isItemSelected());
        r2.callMultiItemSelectListener();
        if (r3.isItemSelected() == false) goto L16;
        r2.callConcreteItemSelected(r4);
        return;
    L16:
        return;
    L8:
        if (r3.isItemSelected() == true) goto L13;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.itemViews, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        OSelectionPanelItemView r7 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r6.next(), OSelectionPanelItemView.class, "com.obric.aiagent.plugin");
        r7.setItemSelected(o.a(r5, r7));
    L13:
        r2.callItemSelectListener();
    }

    public final void setScrollViewHeight(int r6) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, r6);
        if (this.itemViews.size() < 4) goto L5;
    L7:
        this.itemScrollView.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (this.supportForMinHeight == false) goto L7;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-1, -2);
        r7.topToBottom = -1;
        r7.bottomToBottom = 0;
        this.btnContainer.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r0.bottomToTop = -1;
        goto L7
    }

    private final void callItemSelectListener() {
        if (isMultiSelect() == false) goto L5;
        return;
    L5:
        if (this.onItemSelectListener == null) goto L24;
        int r1 = 0;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.itemViews, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L25;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L12;
        p.c();
    L12:
        OSelectionPanelItemView r5 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, OSelectionPanelItemView.class, "com.obric.aiagent.plugin");
        if (r5.isItemSelected() == true) goto L14;
        r1 = r4;
        goto L8
    L14:
        OSingleSelectionPanelView.a r6 = getOnItemSelectListener();
        if (r6 == null) goto L23;
        r6.a(r5, r1);
        return;
    L23:
        return;
    L25:
        return;
    }

    private final void callMultiItemSelectListener() {
        if (isMultiSelect() == true) goto L5;
        return;
    L5:
        if (this.onMultiItemSelectListener == null) goto L25;
        List<OSelectionPanelItemView> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List<Integer> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r4 = 0;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.itemViews, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L12;
        p.c();
    L12:
        OSelectionPanelItemView r7 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r5, OSelectionPanelItemView.class, "com.obric.aiagent.plugin");
        if (r7.isItemSelected() == false) goto L15;
        r0.add(r7);
        r1.add(Integer.valueOf(r4));
    L15:
        r4 = r6;
        goto L8
    L16:
        OMultiSelectionPanelView.a r8 = this.onMultiItemSelectListener;
        if (r8 == null) goto L26;
        r8.a(r0, r1);
        return;
    L26:
        return;
    }

    private final void callConcreteItemSelected(int r1) {
        OMultiSelectionPanelView.a r0 = this.onMultiItemSelectListener;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    public final void setIconLoader(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "loader");
        this.iconLoader = r4;
    }

    public final void removeMinHeightConstraint() {
        this.rootConstraintView.setMinHeight(0);
        this.rootConstraintView.setMinimumHeight(0);
        this.supportForMinHeight = false;
    }

    public static /* synthetic */ void setItemMargin$default(OSelectionPanelView r1, int r2, int r3, int r4, int r5, int r6, Object r7) {
        if (r7 != null) goto L18;
        if ((r6 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = 0;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.dpToPx(12);
    L15:
        r1.setItemMargin(r2, r3, r4, r5);
        return;
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setItemMargin");
    }

    public final void setItemMargin(int r3, int r4, int r5, int r6) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(this.rootConstraintView.getLayoutParams());
        r0.setMargins(r3, r4, r5, r6);
        this.rootConstraintView.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.rootConstraintView.requestLayout();
    }

    private final int dpToPx(int r2) {
        return d.i.a.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density * r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
