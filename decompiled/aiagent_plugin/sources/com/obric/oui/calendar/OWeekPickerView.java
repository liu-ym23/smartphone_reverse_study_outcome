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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OWeekPickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OWeekPickerView extends LinearLayout {
    private final List<DayChip> chips;
    private int dayTextAppearance;
    private final int defStyleAttr;
    private final int defStyleRes;
    private int firstDayOfWeek;
    private int itemHorizontalPaddingPx;
    private int itemSizePx;
    private String[] labels;
    private a onDaysChangedListener;
    private final List<Boolean> selectable;
    private int selectedBackgroundColor;
    private int selectedTextFontWeight;
    private m selectionMode;
    private int unSelectedBackgroundColor;
    private int unselectedTextFontWeight;

    /* JADX INFO: compiled from: OWeekPickerView.kt */
    private static final class DayChip extends AppCompatCheckedTextView {
        private int selectedBackGroudColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackGroudColor;
        private final int unselectedTextFontWeight;

        public DayChip(Context r3, int r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "context");
            super(r6);
            this.selectedTextFontWeight = r4;
            this.unselectedTextFontWeight = r5;
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackGroudColor = r1;
            this.unSelectedBackGroudColor = r2;
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
            int r0 = this.sizePx;
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(r0, r2), AppCompatCheckedTextView.resolveSize(r0, r3));
        }

        private final void regenerateBackground() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackGroudColor), Drawable.class, "com.obric.aiagent.plugin"));
            r0.addState(new int[]{R.attr.state_pressed}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackGroudColor), Drawable.class, "com.obric.aiagent.plugin"));
            r0.addState(new int[0], (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.unSelectedBackGroudColor), Drawable.class, "com.obric.aiagent.plugin"));
            setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
        }

        private final ShapeDrawable circleDrawable(int r4) {
            ShapeDrawable r3 = new ShapeDrawable((Shape) ZeusTransformUtils.preCheckCast(new OvalShape(), Shape.class, "com.obric.aiagent.plugin"));
            r3.getPaint().setColor(r4);
            return r3;
        }
    }

    /* JADX INFO: compiled from: OWeekPickerView.kt */
    public interface a {
        void a(List<Integer> r1);
    }

    public OWeekPickerView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OWeekPickerView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OWeekPickerView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public static /* synthetic */ void lambda$ewGUl9CT2QM6cYtDOUSkhuzb81Y(OWeekPickerView r0, int r1, DayChip r2, View r3) {
        m991createChildren$lambda1$lambda0(r0, r1, r2, r3);
    }

    public /* synthetic */ OWeekPickerView(Context r2, AttributeSet r3, int r4, int r5, int r6, d.h.b.h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.oweekPickerViewStyle, "attr", "oweekPickerViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.style.OStyleV2_OWeekPickerView_DayNight, "style", "OStyleV2_OWeekPickerView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    public OWeekPickerView(Context r4, AttributeSet r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        super(r8, r9, r6);
        this.defStyleAttr = r6;
        this.defStyleRes = r7;
        this.selectionMode = m.f34389b;
        this.selectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.integer.oui_font_weight_bold, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_bold"));
        this.unselectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.integer.oui_font_weight_regular, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_regular"));
        this.firstDayOfWeek = 2;
        this.labels = generateLabels(r8, 2);
        this.chips = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.selectable = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        initAttrs(r8, r9);
        String[] r10 = generateLabels(r8, this.firstDayOfWeek);
        this.labels = r10;
        resetSelectable(r10.length);
        setOrientation(0);
        setGravity(17);
        createChildren();
    }

    private final void initAttrs(Context r12, AttributeSet r13) {
        TypedArray r14 = ((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.OWeekPickerView, this.defStyleAttr, this.defStyleRes);
        d.h.b.o.c(r14, "context.obtainStyledAttr…    defStyleRes\n        )");
    L30:
        th = move-exception;
        r14.recycle();
        throw th;
    L4:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_selectedBackgroundColor")) == false) goto L7;
        this.selectedBackgroundColor = r14.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_selectedBackgroundColor"), this.selectedBackgroundColor);     // Catch: Throwable -> L30
    L7:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_unSelectedBackgroundColor")) == false) goto L10;
        this.unSelectedBackgroundColor = r14.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_unSelectedBackgroundColor"), this.unSelectedBackgroundColor);     // Catch: Throwable -> L30
    L10:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_dayTextAppearance, "styleable", "OWeekPickerView_o_pv_dayTextAppearance")) == false) goto L13;
        this.dayTextAppearance = r14.getResourceId(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_dayTextAppearance, "styleable", "OWeekPickerView_o_pv_dayTextAppearance"), this.dayTextAppearance);     // Catch: Throwable -> L30
    L13:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_selectionMode, "styleable", "OWeekPickerView_o_pv_selectionMode")) == false) goto L20;
        if (r14.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_selectionMode, "styleable", "OWeekPickerView_o_pv_selectionMode"), this.selectionMode.ordinal()) != m.f34388a.ordinal()) goto L17;
        m r15 = m.f34388a;     // Catch: Throwable -> L30
    L18:
        this.selectionMode = r15;     // Catch: Throwable -> L30
        goto L20
    L17:
        r15 = m.f34389b;     // Catch: Throwable -> L30
    L20:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_itemSize, "styleable", "OWeekPickerView_o_pv_itemSize")) == false) goto L23;
        this.itemSizePx = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_itemSize, "styleable", "OWeekPickerView_o_pv_itemSize"), this.itemSizePx);     // Catch: Throwable -> L30
    L23:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_itemHPadding, "styleable", "OWeekPickerView_o_pv_itemHPadding")) == false) goto L26;
        this.itemHorizontalPaddingPx = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_pv_itemHPadding, "styleable", "OWeekPickerView_o_pv_itemHPadding"), this.itemHorizontalPaddingPx);     // Catch: Throwable -> L30
    L26:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek, "styleable", "OWeekPickerView_o_wpv_firstDayOfWeek")) == false) goto L28;
        this.firstDayOfWeek = r14.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek, "styleable", "OWeekPickerView_o_wpv_firstDayOfWeek"), this.firstDayOfWeek);     // Catch: Throwable -> L30
    L28:
        r14.recycle();
    }

    private static final String generateLabels$labelOf(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        switch(r3) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        String r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_sat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_sat"));
        d.h.b.o.c(r5, "context.getString(R.stri…calendar_day_of_week_sat)");
        return r5;
    L6:
        String r6 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_fri, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_fri"));
        d.h.b.o.c(r6, "context.getString(R.stri…calendar_day_of_week_fri)");
        return r6;
    L7:
        String r7 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_thu, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_thu"));
        d.h.b.o.c(r7, "context.getString(R.stri…calendar_day_of_week_thu)");
        return r7;
    L8:
        String r8 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_wed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_wed"));
        d.h.b.o.c(r8, "context.getString(R.stri…calendar_day_of_week_wed)");
        return r8;
    L9:
        String r9 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_tue, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_tue"));
        d.h.b.o.c(r9, "context.getString(R.stri…calendar_day_of_week_tue)");
        return r9;
    L10:
        String r10 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_mon, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_mon"));
        d.h.b.o.c(r10, "context.getString(R.stri…calendar_day_of_week_mon)");
        return r10;
    L11:
        String r11 = r4.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_calendar_day_of_week_sun, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar_day_of_week_sun"));
        d.h.b.o.c(r11, "context.getString(R.stri…calendar_day_of_week_sun)");
        return r11;
    }

    private final String[] generateLabels(Context r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        String[] r1 = new String[7];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 7) goto L5;
        r1[r3] = "";
        r3 = r3 + 1;
    L5:
        if (r2 >= 7) goto L7;
        r1[r2] = formatDefaultLabelForFontScale(r8, generateLabels$labelOf(r8, r7));
        r7 = (r7 % 7) + 1;
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    }

    private final String formatDefaultLabelForFontScale(Context r2, String r3) {
        if (com.obric.oui.d.h.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().fontScale) == true) goto L5;
        return r3;
    L5:
        Character r1 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L13;
        String r4 = Character.valueOf(Character.toUpperCase(r1.charValue())).toString();
        if (r4 != null) goto L12;
        return r3;
    L12:
        return r4;
    L13:
        return r3;
    }

    private final void createChildren() {
        removeAllViews();
        this.chips.clear();
        int r0 = this.labels.length;
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "context");
        final DayChip r4 = new DayChip(r5, this.selectedTextFontWeight, this.unselectedTextFontWeight);
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.labels[r2], CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setGravity(17);
        applyDayTextAppearance(r4);
        r4.applyTextFontWeight();
        r4.setSingleLine(true);
        r4.setTextAlignment(4);
        r4.setClickable(true);
        r4.setFocusable(true);
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.selectable.get(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L7;
        float r7 = 1.0f;
    L8:
        r4.setAlpha(r7);
        r4.setSize(this.itemSizePx);
        r4.setBackgroundColorColor(this.selectedBackgroundColor, this.unSelectedBackgroundColor);
        r4.setChecked(false);
        r4.setOnClickListener(new $$Lambda$OWeekPickerView$ewGUl9CT2QM6cYtDOUSkhuzb81Y(this, r2, r4));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        int r9 = this.itemHorizontalPaddingPx / 2;
        if (r2 != 0) goto L11;
        int r10 = 0;
    L13:
        if (r2 != d.a.i.f(this.labels)) goto L15;
        r9 = 0;
    L15:
        r8.setMargins(r10, 0, r9, 0);
        r8.gravity = 17;
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.chips.add(r4);
        r2 = r3;
        goto L3
    L11:
        r10 = r9;
        goto L13
    L7:
        r7 = 0.45f;
        goto L8
    }

    /* JADX INFO: renamed from: createChildren$lambda-1$lambda-0, reason: not valid java name */
    private static final void m991createChildren$lambda1$lambda0(OWeekPickerView r2, int r3, DayChip r4, View r5) {
        d.h.b.o.e(r2, "this$0");
        d.h.b.o.e(r4, "$this_apply");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2.selectable.get(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L6;
        return;
    L6:
        if (r2.selectionMode != m.f34388a) goto L11;
        Iterator<DayChip> r6 = r2.chips.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        DayChip r7 = (DayChip) ZeusTransformUtils.preCheckCast(r6.next(), DayChip.class, "com.obric.aiagent.plugin");
        r7.setChecked(d.h.b.o.a(r7, r4));
    L12:
        r2.dispatchSelection();
        return;
    L11:
        r4.toggle();
        goto L12
    }

    private final void resetSelectable(int r4) {
        this.selectable.clear();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.selectable.add(true);
        r0 = r0 + 1;
        goto L3
    }

    private final void resizeSelectable(int r7) {
        List r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(this.selectable, Iterable.class, "com.obric.aiagent.plugin"));
        this.selectable.clear();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        List<Boolean> r3 = this.selectable;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(p.d(r0, r1), Boolean.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        boolean r5 = true;
    L8:
        r3.add(Boolean.valueOf(r5));
        r1 = r1 + 1;
        goto L3
    L7:
        r5 = r4.booleanValue();
        goto L8
    }

    private final void updateLabels(String[] r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L9;
        p.c();
    L9:
        if (((DayChip) ZeusTransformUtils.preCheckCast(r5, DayChip.class, "com.obric.aiagent.plugin")).isChecked() == false) goto L11;
        Integer r7 = Integer.valueOf(r4);
    L12:
        if (r7 == null) goto L14;
        r1.add(r7);
    L14:
        r4 = r6;
        goto L4
    L11:
        r7 = null;
        goto L12
    L15:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r9.length == getChildCount()) goto L18;
        boolean r8 = true;
    L19:
        Object[] r10 = Arrays.copyOf(r9, r9.length);
        d.h.b.o.c(r10, "copyOf(this, size)");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r10, String[].class, "com.obric.aiagent.plugin");
        this.labels = r11;
        if (r8 == false) goto L22;
        resizeSelectable(r11.length);
        createChildren();
    L23:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L34;
        Object r15 = r14.next();
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r16 >= 0) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == false) goto L25;
        r13.add(r15);
        goto L25
    L29:
        if (r16 >= this.labels.length) goto L31;
        r17 = true;
        goto L32
    L34:
        setSelectedDays((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));
        requestLayout();
        return;
    L22:
        updateChildrenText();
        goto L23
    L18:
        r8 = false;
        goto L19
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
        ((DayChip) ZeusTransformUtils.preCheckCast(r3, DayChip.class, "com.obric.aiagent.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(this.labels[r1], CharSequence.class, "com.obric.aiagent.plugin"));
        r1 = r4;
        goto L4
    }

    private final void dispatchSelection() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L9;
        p.c();
    L9:
        if (((DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.aiagent.plugin")).isChecked() == false) goto L11;
        r0.add(Integer.valueOf(r3));
    L11:
        r3 = r5;
        goto L4
    L12:
        a r7 = this.onDaysChangedListener;
        if (r7 == null) goto L20;
        r7.a(r0);
        return;
    }

    public final void setSelectionMode(m r8) {
        d.h.b.o.e(r8, "mode");
        this.selectionMode = r8;
        if (r8 != m.f34388a) goto L31;
        Iterator<DayChip> r9 = this.chips.iterator();
        int r1 = 0;
    L6:
        if (r9.hasNext() == false) goto L11;
        if (((DayChip) ZeusTransformUtils.preCheckCast(r9.next(), DayChip.class, "com.obric.aiagent.plugin")).isChecked() == true) goto L12;
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
        DayChip r6 = (DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.aiagent.plugin");
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

    public final void setBackgroundColorColor(int r4, int r5) {
        this.selectedBackgroundColor = r4;
        this.unSelectedBackgroundColor = r5;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((DayChip) ZeusTransformUtils.preCheckCast(r3.next(), DayChip.class, "com.obric.aiagent.plugin")).setBackgroundColorColor(r4, r5);
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
        DayChip r0 = (DayChip) ZeusTransformUtils.preCheckCast(r5.next(), DayChip.class, "com.obric.aiagent.plugin");
        applyDayTextAppearance(r0);
        r0.applyTextFontWeight();
        goto L6
    }

    public final void setItemSizeDp(int r4) {
        this.itemSizePx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DayChip) ZeusTransformUtils.preCheckCast(r5.next(), DayChip.class, "com.obric.aiagent.plugin")).setSize(this.itemSizePx);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemHorizontalPaddingDp(int r3) {
        int r4 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        this.itemHorizontalPaddingPx = r4;
        updateChildMargins(r4);
    }

    public final void setOnDaysChangedListener(a r3) {
        this.onDaysChangedListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public final void setFirstDayOfWeek(int r3) {
        this.firstDayOfWeek = r3;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "context");
        updateLabels(generateLabels(r4, this.firstDayOfWeek));
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
        DayChip r6 = (DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.aiagent.plugin");
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
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.chips, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r1.hasNext() == false) goto L25;
        Object r11 = r1.next();
        int r12 = r3 + 1;
        if (r3 >= 0) goto L24;
        p.c();
    L24:
        ((DayChip) ZeusTransformUtils.preCheckCast(r11, DayChip.class, "com.obric.aiagent.plugin")).setChecked(r9.contains(Integer.valueOf(r3)));
        r3 = r12;
        goto L20
    }

    public final void setDaySelectable(int r3, boolean r4) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        this.selectable.set(r3, Boolean.valueOf(r4));
        DayChip r2 = (DayChip) ZeusTransformUtils.preCheckCast(p.d(this.chips, r3), DayChip.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L17;
        if (r4 == false) goto L14;
        float r5 = 1.0f;
    L15:
        r2.setAlpha(r5);
        return;
    L14:
        r5 = 0.45f;
        goto L15
    L17:
        return;
    L5:
        if (r3 >= this.labels.length) goto L7;
        r0 = true;
        goto L7
    }

    public final void setLabels(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "newLabels");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r5 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        updateLabels((String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.aiagent.plugin"));
    }

    public final void setLabels(String[] r2) {
        d.h.b.o.e(r2, "newLabels");
        setLabels(d.a.i.g(r2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r1 = View.MeasureSpec.getMode(r9);
        int r2 = this.itemHorizontalPaddingPx;
        if (r1 == 0) goto L12;
        if (r0 <= 0) goto L12;
        int r3 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r4 = getChildCount();
        int r5 = d.l.n.c(r4 - 1, 0);
        int r6 = this.itemSizePx;
        if (((r4 * r6) + (this.itemHorizontalPaddingPx * r5)) <= r3) goto L12;
        int r7 = r3 - (r4 * r6);
        if (r7 <= 0) goto L11;
        if (r5 <= 0) goto L11;
        r2 = r7 / r5;
    L11:
        r2 = 0;
    L12:
        updateChildMargins(r2);
        super.onMeasure(r9, r10);
    }

    private final void updateChildMargins(int r10) {
        int r11 = r10 / 2;
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L16;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2 != 0) goto L10;
        int r7 = 0;
    L12:
        if (r2 != (getChildCount() - 1)) goto L14;
        int r8 = 0;
    L15:
        r6.setMargins(r7, 0, r8, 0);
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L16
    L14:
        r8 = r11;
        goto L15
    L10:
        r7 = r11;
    L16:
        r2 = r3;
        goto L3
    }

    private final void applyDayTextAppearance(DayChip r4) {
        if (this.dayTextAppearance == 0) goto L6;
        r4.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.dayTextAppearance);
        return;
    }
}
