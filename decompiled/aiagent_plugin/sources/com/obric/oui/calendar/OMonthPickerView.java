package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: OMonthPickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMonthPickerView extends ViewGroup {
    private final List<MonthDayChip> chips;
    private int columnCount;
    private int dayTextAppearance;
    private final int defStyleAttr;
    private final int defStyleRes;
    private int itemHorizontalPaddingPx;
    private int itemSizePx;
    private int itemVerticalPaddingPx;
    private List<String> labels;
    private a onDaysChangedListener;
    private int selectedBackgroundColor;
    private int selectedTextFontWeight;
    private m selectionMode;
    private int unSelectedBackgroundColor;
    private int unselectedTextFontWeight;

    /* JADX INFO: compiled from: OMonthPickerView.kt */
    private static final class MonthDayChip extends AppCompatCheckedTextView {
        private int selectedBackgroundColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackgroundColor;
        private final int unselectedTextFontWeight;

        public MonthDayChip(Context r3, int r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "context");
            super(r6);
            this.selectedTextFontWeight = r4;
            this.unselectedTextFontWeight = r5;
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackgroundColor = r1;
            this.unSelectedBackgroundColor = r2;
            regenerateBackground();
        }

        @Override // android.widget.CheckedTextView, android.widget.Checkable
        public void setChecked(boolean r2) {
            if (isChecked() == r2) goto L5;
            boolean r0 = true;
        L6:
            super.setChecked(r2);
            if (r0 == false) goto L10;
            applyTextFontWeight();
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void setSize(int r1) {
            this.sizePx = r1;
            requestLayout();
            regenerateBackground();
        }

        public final void applyTextFontWeight() {
            if (isChecked() == false) goto L5;
            int r0 = this.selectedTextFontWeight;
        L6:
            com.obric.oui.d.f.a((TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.aiagent.plugin"), r0);
            return;
        L5:
            r0 = this.unselectedTextFontWeight;
            goto L6
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(this.sizePx, r2), AppCompatCheckedTextView.resolveSize(this.sizePx, r3));
        }

        private final void regenerateBackground() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackgroundColor), Drawable.class, "com.obric.aiagent.plugin"));
            r0.addState(new int[]{R.attr.state_pressed}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackgroundColor), Drawable.class, "com.obric.aiagent.plugin"));
            r0.addState(new int[0], (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.unSelectedBackgroundColor), Drawable.class, "com.obric.aiagent.plugin"));
            setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
        }

        private final ShapeDrawable circleDrawable(int r4) {
            ShapeDrawable r3 = new ShapeDrawable((Shape) ZeusTransformUtils.preCheckCast(new OvalShape(), Shape.class, "com.obric.aiagent.plugin"));
            r3.getPaint().setColor(r4);
            return r3;
        }
    }

    /* JADX INFO: compiled from: OMonthPickerView.kt */
    public interface a {
        void a(List<Integer> r1);
    }

    public OMonthPickerView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OMonthPickerView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OMonthPickerView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public static /* synthetic */ void lambda$cTOGSA9xrD53tGQHFd5CZwA_FaI(OMonthPickerView r0, MonthDayChip r1, View r2) {
        m990createChildren$lambda3$lambda2$lambda1(r0, r1, r2);
    }

    public /* synthetic */ OMonthPickerView(Context r2, AttributeSet r3, int r4, int r5, int r6, d.h.b.h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.omonthPickerViewStyle, "attr", "omonthPickerViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.style.OStyleV2_OMonthPickerView_DayNight, "style", "OStyleV2_OMonthPickerView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    public OMonthPickerView(Context r4, AttributeSet r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        super(r8, r9, r6);
        this.defStyleAttr = r6;
        this.defStyleRes = r7;
        this.selectionMode = m.f34389b;
        this.columnCount = 1;
        this.labels = generateDefaultLabels();
        this.selectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.integer.oui_font_weight_bold, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_bold"));
        this.unselectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.integer.oui_font_weight_regular, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_regular"));
        this.chips = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        initAttrs(r8, r9);
        setClipChildren(false);
        setClipToPadding(false);
        createChildren();
    }

    private final void initAttrs(Context r13, AttributeSet r14) {
        TypedArray r15 = ((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.OMonthPickerView, this.defStyleAttr, this.defStyleRes);
        d.h.b.o.c(r15, "context.obtainStyledAttr…    defStyleRes\n        )");
    L33:
        th = move-exception;
        r15.recycle();
        throw th;
    L4:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_selectedBackgroundColor")) == false) goto L7;
        this.selectedBackgroundColor = r15.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_selectedBackgroundColor"), this.selectedBackgroundColor);     // Catch: Throwable -> L33
    L7:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_unSelectedBackgroundColor")) == false) goto L10;
        this.unSelectedBackgroundColor = r15.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_unSelectedBackgroundColor"), this.unSelectedBackgroundColor);     // Catch: Throwable -> L33
    L10:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_dayTextAppearance, "styleable", "OMonthPickerView_o_pv_dayTextAppearance")) == false) goto L13;
        this.dayTextAppearance = r15.getResourceId(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_dayTextAppearance, "styleable", "OMonthPickerView_o_pv_dayTextAppearance"), this.dayTextAppearance);     // Catch: Throwable -> L33
    L13:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_selectionMode, "styleable", "OMonthPickerView_o_pv_selectionMode")) == false) goto L20;
        if (r15.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_selectionMode, "styleable", "OMonthPickerView_o_pv_selectionMode"), this.selectionMode.ordinal()) != m.f34388a.ordinal()) goto L17;
        m r16 = m.f34388a;     // Catch: Throwable -> L33
    L18:
        this.selectionMode = r16;     // Catch: Throwable -> L33
        goto L20
    L17:
        r16 = m.f34389b;     // Catch: Throwable -> L33
    L20:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_mpv_columnCount, "styleable", "OMonthPickerView_o_mpv_columnCount")) == false) goto L23;
        this.columnCount = d.l.n.c(r15.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_mpv_columnCount, "styleable", "OMonthPickerView_o_mpv_columnCount"), this.columnCount), 1);     // Catch: Throwable -> L33
    L23:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemSize, "styleable", "OMonthPickerView_o_pv_itemSize")) == false) goto L26;
        this.itemSizePx = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemSize, "styleable", "OMonthPickerView_o_pv_itemSize"), this.itemSizePx);     // Catch: Throwable -> L33
    L26:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemHPadding, "styleable", "OMonthPickerView_o_pv_itemHPadding")) == false) goto L29;
        this.itemHorizontalPaddingPx = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemHPadding, "styleable", "OMonthPickerView_o_pv_itemHPadding"), this.itemHorizontalPaddingPx);     // Catch: Throwable -> L33
    L29:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemVPadding, "styleable", "OMonthPickerView_o_pv_itemVPadding")) == false) goto L31;
        this.itemVerticalPaddingPx = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OMonthPickerView_o_pv_itemVPadding, "styleable", "OMonthPickerView_o_pv_itemVPadding"), this.itemVerticalPaddingPx);     // Catch: Throwable -> L33
    L31:
        r15.recycle();
    }

    private final void createChildren() {
        removeAllViews();
        this.chips.clear();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.labels, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "context");
        final MonthDayChip r3 = new MonthDayChip(r4, this.selectedTextFontWeight, this.unselectedTextFontWeight);
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
        r3.setGravity(17);
        applyDayTextAppearance(r3);
        r3.applyTextFontWeight();
        r3.setIncludeFontPadding(false);
        r3.setSingleLine(true);
        r3.setTextAlignment(4);
        r3.setClickable(true);
        r3.setFocusable(true);
        r3.setSize(this.itemSizePx);
        r3.setBackgroundColorColor(this.selectedBackgroundColor, this.unSelectedBackgroundColor);
        r3.setOnClickListener(new $$Lambda$OMonthPickerView$cTOGSA9xrD53tGQHFd5CZwA_FaI(this, r3));
        View r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        int r5 = this.itemSizePx;
        addView(r2, new ViewGroup.LayoutParams(r5, r5));
        this.chips.add(r3);
        goto L4
    }

    /* JADX INFO: renamed from: createChildren$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    private static final void m990createChildren$lambda3$lambda2$lambda1(OMonthPickerView r3, MonthDayChip r4, View r5) {
        d.h.b.o.e(r3, "this$0");
        d.h.b.o.e(r4, "$this_apply");
        if (r3.selectionMode != m.f34388a) goto L8;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        MonthDayChip r0 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r6.next(), MonthDayChip.class, "com.obric.aiagent.plugin");
        r0.setChecked(d.h.b.o.a(r0, r4));
    L9:
        r3.dispatchSelection();
        return;
    L8:
        r4.toggle();
        goto L9
    }

    private final int getRowCount() {
        int r0 = getDayCount();
        int r1 = this.columnCount;
        return ((r0 + r1) - 1) / r1;
    }

    private final int getFullRowWidth() {
        int r0 = this.columnCount;
        return (this.itemSizePx * r0) + ((r0 - 1) * this.itemHorizontalPaddingPx);
    }

    private final int getContentHeight() {
        return (getRowCount() * this.itemSizePx) + ((getRowCount() - 1) * this.itemVerticalPaddingPx);
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getSize(r8);
        int r2 = 0;
        if (View.MeasureSpec.getMode(r8) == 0) goto L14;
        if (r0 <= 0) goto L14;
        int r1 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = this.columnCount;
        int r4 = this.itemSizePx;
        if (((r3 * r4) + ((r3 - 1) * this.itemHorizontalPaddingPx)) <= r1) goto L14;
        int r5 = r1 - (r4 * r3);
        if (r5 > 0) goto L10;
    L12:
        int r6 = 0;
    L13:
        this.itemHorizontalPaddingPx = r6;
        goto L14
    L10:
        if (r3 <= 1) goto L12;
        r6 = r5 / (r3 - 1);
    L14:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + getFullRowWidth()) + getPaddingRight(), r8), ViewGroup.resolveSize((getPaddingTop() + getContentHeight()) + getPaddingBottom(), r9));
        int r10 = View.MeasureSpec.makeMeasureSpec(this.itemSizePx, 1073741824);
        int r11 = getChildCount();
    L15:
        if (r2 >= r11) goto L17;
        getChildAt(r2).measure(r10, r10);
        r2 = r2 + 1;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = r10 - r8;
        int r13 = (r12 - getPaddingLeft()) - getPaddingRight();
        int r14 = getFullRowWidth();
        int r15 = (r13 - r14) / 2;
        int r16 = 0;
        int r17 = getPaddingLeft() + d.l.n.c(r15, 0);
        int r18 = (r12 - getPaddingRight()) - d.l.n.c(r15, 0);
        int r19 = getChildCount();
    L3:
        if (r16 >= r19) goto L9;
        int r110 = r16 + 1;
        View r0 = getChildAt(r16);
        int r1 = this.columnCount;
        int r2 = r16 / r1;
        int r20 = r16 % r1;
        int r3 = getPaddingTop() + (r2 * (this.itemSizePx + this.itemVerticalPaddingPx));
        if (g.a() == false) goto L7;
        int r4 = this.itemSizePx;
        int r21 = r18 - (r20 * (this.itemHorizontalPaddingPx + r4));
        int r5 = r21 - r4;
    L8:
        r0.layout(r5, r3, r21, this.itemSizePx + r3);
        r16 = r110;
        goto L3
    L7:
        int r6 = this.itemSizePx;
        int r22 = (r20 * (this.itemHorizontalPaddingPx + r6)) + r17;
        int r23 = r6 + r22;
        r5 = r22;
        r21 = r23;
        goto L8
    }

    private final void dispatchSelection() {
        a r0 = this.onDaysChangedListener;
        if (r0 == null) goto L7;
        r0.a(getSelectedDays());
        return;
    }

    private final List<String> generateDefaultLabels() {
        ArrayList r3 = new ArrayList(31);
        int r1 = 0;
    L3:
        if (r1 >= 31) goto L6;
        r1 = r1 + 1;
        r3.add(String.valueOf(r1));
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setSelectionMode(m r8) {
        d.h.b.o.e(r8, "mode");
        this.selectionMode = r8;
        if (r8 != m.f34388a) goto L31;
        Iterator<MonthDayChip> r9 = this.chips.iterator();
        int r1 = 0;
    L6:
        if (r9.hasNext() == false) goto L11;
        if (((MonthDayChip) ZeusTransformUtils.preCheckCast(r9.next(), MonthDayChip.class, "com.obric.aiagent.plugin")).isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
    L14:
        if (r10.hasNext() == false) goto L24;
        Object r4 = r10.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L18;
        p.c();
    L18:
        MonthDayChip r6 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r4, MonthDayChip.class, "com.obric.aiagent.plugin");
        if (r2 != r1) goto L22;
        if (r1 < 0) goto L22;
        boolean r3 = true;
    L23:
        r6.setChecked(r3);
        r2 = r5;
    L22:
        r3 = false;
        goto L23
    L24:
        dispatchSelection();
        return;
    L11:
        r1 = -1;
        goto L12
    }

    public final m getSelectionMode() {
        return this.selectionMode;
    }

    public final void setColumnCount(int r2) {
        int r3 = d.l.n.c(r2, 1);
        if (this.columnCount != r3) goto L5;
        return;
    L5:
        this.columnCount = r3;
        requestLayout();
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final void setLabels(List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "newLabels");
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r0 = getSelectedDays();
        if (r9.size() == getChildCount()) goto L8;
        boolean r2 = true;
    L9:
        this.labels = p.o((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"));
        if (r2 == false) goto L12;
        createChildren();
    L13:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L24;
        Object r3 = r11.next();
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 >= 0) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L15;
        r1.add(r3);
        goto L15
    L19:
        if (r4 >= this.labels.size()) goto L21;
        r5 = true;
        goto L22
    L24:
        setSelectedDays((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"));
        requestLayout();
        return;
    L12:
        updateChildrenText();
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    public final void setLabels(String[] r2) {
        d.h.b.o.e(r2, "newLabels");
        setLabels(d.a.i.g(r2));
    }

    public final List<String> getLabels() {
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(this.labels, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final int getDayCount() {
        return this.labels.size();
    }

    private final void updateChildrenText() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        p.c();
    L8:
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r3, MonthDayChip.class, "com.obric.aiagent.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(this.labels.get(r1), CharSequence.class, "com.obric.aiagent.plugin"));
        r1 = r4;
        goto L4
    }

    public final void setSelectedDays(List<Integer> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "days");
        int r3 = 0;
        if (this.selectionMode != m.f34388a) goto L18;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(p.l(r9), Integer.class, "com.obric.aiagent.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L25;
        Object r4 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L10;
        p.c();
    L10:
        MonthDayChip r6 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r4, MonthDayChip.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        r6.setChecked(r7);
        r2 = r5;
        goto L6
    L14:
        if (r2 != r10.intValue()) goto L16;
        r7 = true;
    L25:
        dispatchSelection();
        return;
    L18:
        Set r11 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"));
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r1.hasNext() == false) goto L25;
        Object r12 = r1.next();
        int r13 = r3 + 1;
        if (r3 >= 0) goto L24;
        p.c();
    L24:
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r12, MonthDayChip.class, "com.obric.aiagent.plugin")).setChecked(r11.contains(Integer.valueOf(r3)));
        r3 = r13;
        goto L20
    }

    public final List<Integer> getSelectedDays() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L16;
        Object r3 = r7.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        p.c();
    L9:
        if (((MonthDayChip) ZeusTransformUtils.preCheckCast(r3, MonthDayChip.class, "com.obric.aiagent.plugin")).isChecked() == false) goto L11;
        Integer r5 = Integer.valueOf(r2);
    L12:
        if (r5 == null) goto L14;
        r0.add(r5);
    L14:
        r2 = r4;
        goto L4
    L11:
        r5 = null;
        goto L12
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public final void clearSelection() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r0.next(), MonthDayChip.class, "com.obric.aiagent.plugin")).setChecked(false);
        goto L4
    L6:
        dispatchSelection();
    }

    public final void setOnDaysChangedListener(a r3) {
        this.onDaysChangedListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public final void setBackgroundColorColor(int r4, int r5) {
        this.selectedBackgroundColor = r4;
        this.unSelectedBackgroundColor = r5;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r3.next(), MonthDayChip.class, "com.obric.aiagent.plugin")).setBackgroundColorColor(r4, r5);
        goto L4
    }

    public final void setDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.dayTextAppearance = r4;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        MonthDayChip r0 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r5.next(), MonthDayChip.class, "com.obric.aiagent.plugin");
        applyDayTextAppearance(r0);
        r0.applyTextFontWeight();
        r0.setIncludeFontPadding(false);
        goto L6
    }

    public final void setItemDiameterDp(int r4) {
        this.itemSizePx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r5.next(), MonthDayChip.class, "com.obric.aiagent.plugin")).setSize(this.itemSizePx);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r1) {
        setItemPaddingDp(r1, r1);
    }

    public final void setItemPaddingDp(int r3, int r4) {
        this.itemHorizontalPaddingPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        this.itemVerticalPaddingPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        requestLayout();
    }

    private final void applyDayTextAppearance(MonthDayChip r4) {
        if (this.dayTextAppearance == 0) goto L6;
        r4.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.dayTextAppearance);
        return;
    }
}
