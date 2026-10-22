package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: OPopoverFilterMenuView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopoverFilterMenuView extends OPopoverMenuView {
    private List<ViewGroup> itemContainers;
    private int itemHeight;
    private final int itemVerticalMargin;
    private int itemWidth;
    private ArrayList<a> items;
    private Map<Integer, CheckableImageView> radioMap;
    private boolean topDividerVisibility;

    /* JADX INFO: compiled from: OPopoverFilterMenuView.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f36024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f36025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Typeface f36026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private b<? super Integer, x> f36027d;

        public final CharSequence a() {
            return this.f36024a;
        }

        public final boolean b() {
            return this.f36025b;
        }

        public final Typeface c() {
            return this.f36026c;
        }

        public final b<Integer, x> d() {
            return this.f36027d;
        }
    }

    public OPopoverFilterMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverFilterMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$rkgVK1DN1t2R8R2AuUijXkFVukY(OPopoverFilterMenuView r0, int r1, a r2, View r3) {
        m1133addPopoverItems$lambda1$lambda0(r0, r1, r2, r3);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$initView(OPopoverFilterMenuView r0) {
        r0.initView();
    }

    public static final /* synthetic */ void access$setItemHeight$p(OPopoverFilterMenuView r0, int r1) {
        r0.itemHeight = r1;
    }

    public static final /* synthetic */ void access$setItemWidth$p(OPopoverFilterMenuView r0, int r1) {
        r0.itemWidth = r1;
    }

    public static final /* synthetic */ void access$setItems$p(OPopoverFilterMenuView r0, ArrayList r1) {
        r0.items = r1;
    }

    public static final /* synthetic */ void access$setTopDividerVisibility$p(OPopoverFilterMenuView r0, boolean r1) {
        r0.topDividerVisibility = r1;
    }

    public OPopoverFilterMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.items = new ArrayList();
        this.radioMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.itemContainers = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.itemVerticalMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        this.itemWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 188);
        this.itemHeight = (int) ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_list_item_menu, "dimen", "oui_h_list_item_menu"));
    }

    private final void initView() {
        setOrientation(1);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(this.itemWidth, this.itemHeight), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        addPopoverItems();
    }

    public final void selectItem(int r5) {
        Iterator<Map.Entry<Integer, CheckableImageView>> r4 = this.radioMap.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        CheckableImageView r2 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r0.getValue(), CheckableImageView.class, "com.obric.aiagent.plugin");
        if (r5 != r1) goto L8;
        boolean r3 = true;
    L9:
        r2.setChecked(r3);
        goto L4
    L8:
        r3 = false;
        goto L9
    }

    private final void addPopoverItems() {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.items, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r2 = false;
        final int r4 = 0;
    L4:
        if (r1.hasNext() == false) goto L30;
        Object r5 = r1.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        p.c();
    L8:
        final a r7 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        View r8 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_popover_menu_filter, "layout", "o_item_popover_menu_filter"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), r2, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
        PopoverMenuLinearLayout r9 = (PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r8, PopoverMenuLinearLayout.class, "com.obric.aiagent.plugin");
        OStateGradientDrawable r10 = new OStateGradientDrawable();
        r10.setCornerRadius(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20));
        ColorStateList r11 = androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.o_pop_list_item_bg_color, "color", "o_pop_list_item_bg_color"));
        o.a(r11);
        o.c(r11, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r10.setSolidColors(r11);
        r9.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r10, Drawable.class, "com.obric.aiagent.plugin"));
        LinearLayout r12 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(this.itemWidth, this.itemHeight);
        ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.item_container, DbHelper.COL_ID, "item_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        CheckableImageView r15 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.popover_menu_radio, DbHelper.COL_ID, "popover_menu_radio")), CheckableImageView.class, "com.obric.aiagent.plugin");
        OTextView r16 = (OTextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_action, DbHelper.COL_ID, "tv_popover_action")), OTextView.class, "com.obric.aiagent.plugin");
        List<ViewGroup> r17 = this.itemContainers;
        o.c(r14, "itemContainer");
        r17.add(r14);
        r9.setOnClickListener(new $$Lambda$OPopoverFilterMenuView$rkgVK1DN1t2R8R2AuUijXkFVukY(this, r4, r7));
        if (this.topDividerVisibility == false) goto L14;
        View r3 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, DbHelper.COL_ID, "top_divider"));
        r3.setVisibility(0);
        if (r4 != 0) goto L14;
        r3.setVisibility(4);
    L14:
        if (this.items.size() != 1) goto L16;
        r9.setIndexPos(PopoverMenuLinearLayout.a.f36034d);
        r2 = false;
        r13.setMargins(0, 0, 0, 0);
    L23:
        registerPressedCallback(r9);
        if (r7.a() == null) goto L27;
        r16.setText(r7.a());
    L27:
        if (r7.c() == null) goto L29;
        r16.setTypeface(r7.c());
    L29:
        r15.setChecked(r7.b());
        r15.setImageTintList(ColorStateList.valueOf(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_7, "color", "oui_accent_7"))));
        Map<Integer, CheckableImageView> r18 = this.radioMap;
        Integer r19 = Integer.valueOf(r4);
        o.c(r15, "radio");
        r18.put(r19, r15);
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.leftMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        r20.rightMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r12.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        r4 = r6;
        goto L4
    L16:
        r2 = false;
        if (r4 != (this.items.size() - 1)) goto L19;
        r9.setIndexPos(PopoverMenuLinearLayout.a.f36032b);
        r13.setMargins(0, 0, 0, 0);
        goto L23
    L19:
        if (r4 < 0) goto L23;
        if (r4 != 0) goto L22;
        r9.setIndexPos(PopoverMenuLinearLayout.a.f36031a);
    L22:
        r13.setMargins(0, 0, 0, this.itemVerticalMargin);
        goto L23
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1133addPopoverItems$lambda1$lambda0(OPopoverFilterMenuView r0, int r1, a r2, View r3) {
        o.e(r0, "this$0");
        o.e(r2, "$item");
        r0.selectItem(r1);
        b<Integer, x> r4 = r2.d();
        if (r4 == null) goto L7;
        r4.invoke(Integer.valueOf(r1));
        return;
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    public void onSizeChanged(int r6, int r7, int r8, int r9) {
        super.onSizeChanged(r6, r7, r8, r9);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.itemContainers, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        ViewGroup r10 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5.next(), ViewGroup.class, "com.obric.aiagent.plugin");
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        ViewGroup.LayoutParams r1 = ((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        ViewGroup.LayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = 0;
        if (r2 == null) goto L11;
        int r12 = r2.leftMargin;
    L12:
        int r13 = r6 - r12;
        ViewGroup.LayoutParams r14 = ((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        r3 = r14;
    L16:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L19;
        r4 = r15.rightMargin;
    L19:
        r0.width = r13 - r4;
        r11.setLayoutParams(r0);
        goto L4
    L11:
        r12 = 0;
        goto L12
    }
}
