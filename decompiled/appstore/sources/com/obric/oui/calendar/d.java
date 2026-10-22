package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.common.oui.R$integer;
import com.obric.oui.calendar.format.DayFormatter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class d extends AppCompatCheckedTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CalendarDay f12690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f12694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f12695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f12696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DayFormatter f12697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DayFormatter f12698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f12706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f12707v;

    public d(Context r10, CalendarDay r11) {
        super(r10);
        this.f12691f = -7829368;
        this.f12692g = 40;
        this.f12693h = 50;
        this.f12694i = null;
        DayFormatter r12 = DayFormatter.DEFAULT;
        this.f12697l = r12;
        this.f12698m = r12;
        this.f12699n = true;
        this.f12700o = true;
        this.f12701p = true;
        this.f12702q = false;
        this.f12705t = 4;
        this.f12706u = new Rect();
        this.f12707v = new Rect();
        this.f12703r = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.f12704s = getResources().getInteger(R$integer.oui_font_weight_regular);
        r(this.f12691f);
        setGravity(17);
        setIncludeFontPadding(false);
        setTextAlignment(4);
        n(r11);
    }

    private void b() {
        if (isChecked() == false) goto L5;
        int r10 = this.f12703r;
    L6:
        td.f.a(this, r10);
        return;
    L5:
        r10 = this.f12704s;
        goto L6
    }

    public void a(e r10) {
        this.f12702q = r10.b();
        q();
        m(r10.c());
        s(r10.d());
        List r11 = r10.e();
        if (r11.isEmpty() == true) goto L9;
        i();
        SpannableString r12 = new SpannableString(i());
        Iterator r13 = r11.iterator();
        if (r13.hasNext() == true) goto L7;
        setText(r12);
        return;
    L7:
        androidx.appcompat.widget.p.a(r13.next());
        throw null;
    L9:
        setText(i());
    }

    public final void c(int r10, int r11) {
        int r12 = Math.min((int) d(this.f12692g), Math.min(r10, r11));
        int r13 = (r10 - r12) / 2;
        int r14 = (r11 - r12) / 2;
        int r15 = r13 + r12;
        int r16 = r12 + r14;
        this.f12706u.set(r13, r14, r15, r16);
        this.f12707v.set(r13, r14, r15, r16);
    }

    public final float d(float r10) {
        return r10 * getResources().getDisplayMetrics().density;
    }

    public final Drawable e(int r10, int r11, Rect r12) {
        StateListDrawable r13 = new StateListDrawable();
        r13.setExitFadeDuration(r11);
        r13.addState(new int[]{R.attr.state_checked}, f(r10));
        r13.addState(new int[0], f(0));
        return r13;
    }

    public final Drawable f(int r10) {
        ShapeDrawable r11 = new ShapeDrawable(new OvalShape());
        r11.getPaint().setColor(r10);
        return r11;
    }

    public String g() {
        DayFormatter r10 = this.f12698m;
        if (r10 != null) goto L6;
        return this.f12697l.format(this.f12690e);
    L6:
        return r10.format(this.f12690e);
    }

    public CalendarDay h() {
        return this.f12690e;
    }

    public String i() {
        return this.f12697l.format(this.f12690e);
    }

    public boolean j() {
        return this.f12701p;
    }

    public final void k() {
        Drawable r10 = this.f12695j;
        if (r10 == null) goto L5;
        setBackgroundDrawable(r10);
        return;
    L5:
        Drawable r11 = e(this.f12691f, 50, this.f12707v);
        this.f12696k = r11;
        setBackgroundDrawable(r11);
    }

    public void l(CalendarMode r10) {
        k();
    }

    public void m(Drawable r10) {
        if (r10 != null) goto L4;
        this.f12694i = null;
    L5:
        invalidate();
        return;
    L4:
        this.f12694i = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void n(CalendarDay r10) {
        this.f12690e = r10;
        setText(i());
    }

    public void o(DayFormatter r10) {
        DayFormatter r11 = this.f12698m;
        if (r11 != this.f12697l) goto L5;
        r11 = r10;
    L5:
        this.f12698m = r11;
        if (r10 != null) goto L8;
        r10 = DayFormatter.DEFAULT;
    L8:
        this.f12697l = r10;
        CharSequence r12 = getText();
        if ((r12 instanceof Spanned) == false) goto L11;
        Object[] r13 = ((Spanned) r12).getSpans(0, r12.length(), Object.class);
    L12:
        SpannableString r14 = new SpannableString(i());
        if (r13 == null) goto L17;
        int r15 = r13.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L17;
        r14.setSpan(r13[r16], 0, r14.length(), 33);
        r16 = r16 + 1;
    L17:
        setText(r14);
        return;
    L11:
        r13 = null;
        goto L12
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        Drawable r11 = this.f12694i;
        if (r11 == null) goto L5;
        r11.setBounds(this.f12706u);
        this.f12694i.setState(getDrawableState());
        this.f12694i.draw(r10);
    L5:
        this.f12696k.setBounds(this.f12707v);
        super.onDraw(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        c(r13 - r11, r14 - r12);
        k();
    }

    public void p(DayFormatter r10) {
        if (r10 != null) goto L4;
        r10 = this.f12697l;
    L4:
        this.f12698m = r10;
        setContentDescription(g());
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean r10 = super.performClick();
        dd.a.b(getContext(), 1);
        return r10;
    }

    public final void q() {
        int r10 = 0;
        if (this.f12700o == true) goto L5;
    L9:
        boolean r11 = false;
    L11:
        if (this.f12699n == true) goto L13;
    L15:
        boolean r12 = false;
    L16:
        super.setEnabled(r12);
        boolean r13 = MaterialCalendarView.H(this.f12705t);
        if (MaterialCalendarView.I(this.f12705t) == true) goto L21;
        if (r13 == true) goto L21;
        boolean r14 = false;
    L22:
        boolean r15 = MaterialCalendarView.G(this.f12705t);
        boolean r16 = this.f12700o;
        if (r16 == true) goto L26;
        if (r13 == false) goto L26;
        r11 = true;
    L26:
        boolean r17 = this.f12699n;
        if (r17 == true) goto L31;
        if (r14 == false) goto L31;
        r11 = r11 | r16;
    L31:
        if (this.f12702q == false) goto L38;
        if (r15 == false) goto L38;
        if (r16 == false) goto L36;
        if (r17 == false) goto L36;
        boolean r18 = true;
    L37:
        r11 = r11 | r18;
    L36:
        r18 = false;
    L38:
        if (r16 == true) goto L41;
        if (r11 == false) goto L41;
        this.f12701p = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L42:
        if (r11 == true) goto L45;
        r10 = 4;
    L45:
        setVisibility(r10);
        return;
    L41:
        this.f12701p = true;
    L21:
        r14 = true;
        goto L22
    L13:
        if (this.f12702q == true) goto L15;
        r12 = true;
        goto L16
    L5:
        if (this.f12699n == false) goto L9;
        if (this.f12702q == true) goto L9;
        r11 = true;
        goto L11
    }

    public void r(int r10) {
        this.f12691f = r10;
        k();
    }

    public void s(Drawable r10) {
        if (r10 != null) goto L4;
        this.f12695j = null;
    L5:
        k();
        return;
    L4:
        this.f12695j = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    @Override // android.widget.CheckedTextView, android.widget.Checkable
    public void setChecked(boolean r10) {
        if (isChecked() == r10) goto L5;
        boolean r11 = true;
    L6:
        super.setChecked(r10);
        if (r11 == false) goto L10;
        b();
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        setIncludeFontPadding(false);
        b();
    }

    public void t(int r10, boolean r11, boolean r12) {
        this.f12705t = r10;
        this.f12700o = r12;
        this.f12699n = r11;
        q();
    }
}
