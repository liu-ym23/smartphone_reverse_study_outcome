package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class DayView extends AppCompatCheckedTextView {
    private final Rect circleDrawableRect;
    private int circleSizeDp;
    private com.obric.oui.calendar.a.e contentDescriptionFormatter;
    private Drawable customBackground;
    private CalendarDay date;
    private final int fadeTime;
    private com.obric.oui.calendar.a.e formatter;
    private boolean isDecoratedDisabled;
    private boolean isInMonth;
    private boolean isInRange;
    private boolean isInVisibleEnabled;
    private Drawable mCircleDrawable;
    private int selectedTextFontWeight;
    private int selectionColor;
    private Drawable selectionDrawable;
    private int showOtherDates;
    private final Rect tempRect;
    private int unselectedTextFontWeight;

    public DayView(Context r7, CalendarDay r8) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"));
        this.selectionColor = -7829368;
        this.circleSizeDp = 40;
        this.fadeTime = 50;
        this.customBackground = null;
        com.obric.oui.calendar.a.e r9 = com.obric.oui.calendar.a.e.f34369a;
        this.formatter = r9;
        this.contentDescriptionFormatter = r9;
        this.isInRange = true;
        this.isInMonth = true;
        this.isInVisibleEnabled = true;
        this.isDecoratedDisabled = false;
        this.showOtherDates = 4;
        this.tempRect = new Rect();
        this.circleDrawableRect = new Rect();
        this.selectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.oui_font_weight_bold, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_bold"));
        this.unselectedTextFontWeight = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.oui_font_weight_regular, WsChannelMultiProcessSharedProvider.INT_TYPE, "oui_font_weight_regular"));
        setSelectionColor(this.selectionColor);
        setGravity(17);
        setIncludeFontPadding(false);
        setTextAlignment(4);
        setDay(r8);
    }

    public void setDay(CalendarDay r1) {
        this.date = r1;
        setText(getLabel());
    }

    public void setDayFormatter(com.obric.oui.calendar.a.e r8) {
        com.obric.oui.calendar.a.e r9 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        com.obric.oui.calendar.a.e r0 = this.contentDescriptionFormatter;
        if (r0 != this.formatter) goto L5;
        r0 = r9;
    L5:
        this.contentDescriptionFormatter = r0;
        if (r9 != null) goto L8;
        r9 = com.obric.oui.calendar.a.e.f34369a;
    L8:
        this.formatter = r9;
        CharSequence r10 = getText();
        Object[] r1 = null;
        if (ZeusTransformUtils.instanceOf(r10, Spanned.class) == false) goto L11;
        r1 = ((Spanned) ZeusTransformUtils.preCheckCast(r10, Spanned.class, "com.obric.aiagent.plugin")).getSpans(0, r10.length(), Object.class);
    L11:
        SpannableString r11 = new SpannableString(getLabel());
        if (r1 == null) goto L16;
        int r2 = r1.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L16;
        r11.setSpan(r1[r3], 0, r11.length(), 33);
        r3 = r3 + 1;
    L16:
        setText(r11);
    }

    public void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = this.formatter;
    L5:
        this.contentDescriptionFormatter = r4;
        setContentDescription(getContentDescriptionLabel());
    }

    public String getLabel() {
        return this.formatter.a(this.date);
    }

    public String getContentDescriptionLabel() {
        com.obric.oui.calendar.a.e r0 = this.contentDescriptionFormatter;
        if (r0 != null) goto L6;
        return this.formatter.a(this.date);
    L6:
        return r0.a(this.date);
    }

    public void setSelectionColor(int r1) {
        this.selectionColor = r1;
        regenerateBackground();
    }

    public void setCalendarMode(a r1) {
        regenerateBackground();
    }

    public void setSelectionDrawable(Drawable r2) {
        if (r2 != null) goto L4;
        this.selectionDrawable = null;
    L5:
        regenerateBackground();
        return;
    L4:
        this.selectionDrawable = r2.getConstantState().newDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"));
        goto L5
    }

    public void setCustomBackground(Drawable r2) {
        if (r2 != null) goto L4;
        this.customBackground = null;
    L5:
        invalidate();
        return;
    L4:
        this.customBackground = r2.getConstantState().newDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"));
        goto L5
    }

    public CalendarDay getDate() {
        return this.date;
    }

    private void setEnabled() {
        int r2 = 0;
        if (this.isInMonth == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.isInRange == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        super.setEnabled(r3);
        boolean r4 = MaterialCalendarView.showOtherMonths(this.showOtherDates);
        if (MaterialCalendarView.showOutOfRange(this.showOtherDates) == true) goto L21;
        if (r4 == true) goto L21;
        boolean r5 = false;
    L22:
        boolean r6 = MaterialCalendarView.showDecoratedDisabled(this.showOtherDates);
        boolean r7 = this.isInMonth;
        if (r7 == true) goto L26;
        if (r4 == false) goto L26;
        r0 = true;
    L26:
        boolean r8 = this.isInRange;
        if (r8 == true) goto L31;
        if (r5 == false) goto L31;
        r0 = r0 | r7;
    L31:
        if (this.isDecoratedDisabled == false) goto L38;
        if (r6 == false) goto L38;
        if (r7 == false) goto L36;
        if (r8 == false) goto L36;
        boolean r9 = true;
    L37:
        r0 = r0 | r9;
    L36:
        r9 = false;
    L38:
        if (r7 == true) goto L41;
        if (r0 == false) goto L41;
        this.isInVisibleEnabled = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L42:
        if (r0 == true) goto L45;
        r2 = 4;
    L45:
        setVisibility(r2);
        return;
    L41:
        this.isInVisibleEnabled = true;
    L21:
        r5 = true;
        goto L22
    L13:
        if (this.isDecoratedDisabled == true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (this.isInRange == false) goto L9;
        if (this.isDecoratedDisabled == true) goto L9;
        r0 = true;
        goto L11
    }

    public boolean isVisibleEnabled() {
        return this.isInVisibleEnabled;
    }

    public void setupSelection(int r1, boolean r2, boolean r3) {
        this.showOtherDates = r1;
        this.isInMonth = r3;
        this.isInRange = r2;
        setEnabled();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r3) {
        Drawable r0 = this.customBackground;
        if (r0 == null) goto L5;
        r0.setBounds(this.tempRect);
        this.customBackground.setState(getDrawableState());
        this.customBackground.draw(r3);
    L5:
        this.mCircleDrawable.setBounds(this.circleDrawableRect);
        super.onDraw(r3);
    }

    private void regenerateBackground() {
        Drawable r0 = this.selectionDrawable;
        if (r0 == null) goto L5;
        setBackgroundDrawable(r0);
        return;
    L5:
        Drawable r1 = generateBackground(this.selectionColor, 50, this.circleDrawableRect);
        this.mCircleDrawable = r1;
        setBackgroundDrawable(r1);
    }

    private Drawable generateBackground(int r3, int r4, Rect r5) {
        StateListDrawable r6 = new StateListDrawable();
        r6.setExitFadeDuration(r4);
        r6.addState(new int[]{android.R.attr.state_checked}, generateShapeDrawable(r3));
        r6.addState(new int[0], generateShapeDrawable(0));
        return r6;
    }

    private Drawable generateShapeDrawable(int r2) {
        ShapeDrawable r1 = new ShapeDrawable(new OvalShape());
        r1.getPaint().setColor(r2);
        return r1;
    }

    private Drawable generateRippleDrawable(int r2, Rect r3) {
        return new RippleDrawable(ColorStateList.valueOf(r2), null, generateShapeDrawable(-1));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        super.setTextAppearance((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        setIncludeFontPadding(false);
        applyTextFontWeight();
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

    private void applyTextFontWeight() {
        if (isChecked() == false) goto L5;
        int r0 = this.selectedTextFontWeight;
    L6:
        com.obric.oui.d.f.a(this, r0);
        return;
    L5:
        r0 = this.unselectedTextFontWeight;
        goto L6
    }

    void applyFacade(e r7) {
        this.isDecoratedDisabled = r7.f();
        setEnabled();
        setCustomBackground(r7.d());
        setSelectionDrawable(r7.c());
        List<e.a> r8 = r7.e();
        if (r8.isEmpty() == true) goto L9;
        String r0 = getLabel();
        SpannableString r1 = new SpannableString(getLabel());
        Iterator<e.a> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r1.setSpan(((e.a) ZeusTransformUtils.preCheckCast(r9.next(), e.a.class, "com.obric.aiagent.plugin")).f34383a, 0, r0.length(), 33);
        goto L6
    L8:
        setText(r1);
        return;
    L9:
        setText(getLabel());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        calculateBounds(r4 - r2, r5 - r3);
        regenerateBackground();
    }

    private void calculateBounds(int r4, int r5) {
        int r0 = Math.min((int) dpToPx(this.circleSizeDp), Math.min(r4, r5));
        int r6 = (r4 - r0) / 2;
        int r7 = (r5 - r0) / 2;
        int r2 = r6 + r0;
        int r1 = r0 + r7;
        this.tempRect.set(r6, r7, r2, r1);
        this.circleDrawableRect.set(r6, r7, r2, r1);
    }

    private float dpToPx(float r2) {
        return r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density;
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
        return r0;
    }
}
