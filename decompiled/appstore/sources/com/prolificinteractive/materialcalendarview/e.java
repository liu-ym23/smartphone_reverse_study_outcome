package com.prolificinteractive.materialcalendarview;

import android.R;
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
import androidx.appcompat.widget.p;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class e extends AppCompatCheckedTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CalendarDay f17787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f17790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f17791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f17792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DayFormatter f17793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DayFormatter f17794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17796n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17797o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17798p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f17799q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f17800r;

    public e(Context r10, CalendarDay r11) {
        super(r10);
        this.f17788f = -7829368;
        this.f17790h = null;
        DayFormatter r12 = DayFormatter.DEFAULT;
        this.f17793k = r12;
        this.f17794l = r12;
        this.f17795m = true;
        this.f17796n = true;
        this.f17797o = false;
        this.f17798p = 4;
        this.f17799q = new Rect();
        this.f17800r = new Rect();
        this.f17789g = getResources().getInteger(R.integer.config_shortAnimTime);
        o(this.f17788f);
        setGravity(17);
        setTextAlignment(4);
        k(r11);
    }

    private void b(int r10, int r11) {
        int r12 = Math.min(r11, r10);
        int r13 = Math.abs(r11 - r10) / 2;
        if (r10 < r11) goto L5;
        this.f17799q.set(r13, 0, r12 + r13, r11);
        this.f17800r.set(r13, 0, r12 + r13, r11);
        return;
    L5:
        this.f17799q.set(0, r13, r10, r12 + r13);
        this.f17800r.set(0, r13, r10, r12 + r13);
    }

    private static Drawable c(int r10, int r11, Rect r12) {
        StateListDrawable r13 = new StateListDrawable();
        r13.setExitFadeDuration(r11);
        r13.addState(new int[]{R.attr.state_checked}, d(r10));
        r13.addState(new int[]{R.attr.state_pressed}, e(r10, r12));
        r13.addState(new int[0], d(0));
        return r13;
    }

    public static Drawable d(int r10) {
        ShapeDrawable r11 = new ShapeDrawable(new OvalShape());
        r11.getPaint().setColor(r10);
        return r11;
    }

    public static Drawable e(int r10, Rect r11) {
        return new RippleDrawable(ColorStateList.valueOf(r10), null, d(-1));
    }

    private void i() {
        Drawable r10 = this.f17791i;
        if (r10 == null) goto L5;
        setBackgroundDrawable(r10);
        return;
    L5:
        Drawable r11 = c(this.f17788f, this.f17789g, this.f17800r);
        this.f17792j = r11;
        setBackgroundDrawable(r11);
    }

    private void n() {
        int r10 = 0;
        boolean r11 = true;
        if (this.f17796n == true) goto L5;
    L9:
        boolean r12 = false;
    L11:
        if (this.f17795m == true) goto L13;
    L15:
        boolean r13 = false;
    L16:
        super.setEnabled(r13);
        boolean r14 = MaterialCalendarView.J(this.f17798p);
        if (MaterialCalendarView.K(this.f17798p) == true) goto L21;
        if (r14 == true) goto L21;
        boolean r15 = false;
    L22:
        boolean r16 = MaterialCalendarView.I(this.f17798p);
        boolean r17 = this.f17796n;
        if (r17 == true) goto L26;
        if (r14 == false) goto L26;
        r12 = true;
    L26:
        boolean r18 = this.f17795m;
        if (r18 == true) goto L31;
        if (r15 == false) goto L31;
        r12 = r12 | r17;
    L31:
        if (this.f17797o == false) goto L38;
        if (r16 == false) goto L38;
        if (r17 == false) goto L36;
        if (r18 == false) goto L36;
    L37:
        r12 = r12 | r11;
    L36:
        r11 = false;
    L38:
        if (r17 == true) goto L41;
        if (r12 == false) goto L41;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L41:
        if (r12 == true) goto L44;
        r10 = 4;
    L44:
        setVisibility(r10);
        return;
    L21:
        r15 = true;
        goto L22
    L13:
        if (this.f17797o == true) goto L15;
        r13 = true;
        goto L16
    L5:
        if (this.f17795m == false) goto L9;
        if (this.f17797o == true) goto L9;
        r12 = true;
        goto L11
    }

    public void a(f r10) {
        this.f17797o = r10.b();
        n();
        j(r10.c());
        p(r10.d());
        List r11 = r10.e();
        if (r11.isEmpty() == true) goto L9;
        h();
        SpannableString r12 = new SpannableString(h());
        Iterator r13 = r11.iterator();
        if (r13.hasNext() == true) goto L7;
        setText(r12);
        return;
    L7:
        p.a(r13.next());
        throw null;
    L9:
        setText(h());
    }

    public String f() {
        DayFormatter r10 = this.f17794l;
        if (r10 != null) goto L6;
        return this.f17793k.format(this.f17787e);
    L6:
        return r10.format(this.f17787e);
    }

    public CalendarDay g() {
        return this.f17787e;
    }

    public String h() {
        return this.f17793k.format(this.f17787e);
    }

    public void j(Drawable r10) {
        if (r10 != null) goto L4;
        this.f17790h = null;
    L5:
        invalidate();
        return;
    L4:
        this.f17790h = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void k(CalendarDay r10) {
        this.f17787e = r10;
        setText(h());
    }

    public void l(DayFormatter r10) {
        DayFormatter r11 = this.f17794l;
        if (r11 != this.f17793k) goto L5;
        r11 = r10;
    L5:
        this.f17794l = r11;
        if (r10 != null) goto L8;
        r10 = DayFormatter.DEFAULT;
    L8:
        this.f17793k = r10;
        CharSequence r12 = getText();
        if ((r12 instanceof Spanned) == false) goto L11;
        Object[] r13 = ((Spanned) r12).getSpans(0, r12.length(), Object.class);
    L12:
        SpannableString r14 = new SpannableString(h());
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

    public void m(DayFormatter r10) {
        if (r10 != null) goto L4;
        r10 = this.f17793k;
    L4:
        this.f17794l = r10;
        setContentDescription(f());
    }

    public void o(int r10) {
        this.f17788f = r10;
        i();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        Drawable r11 = this.f17790h;
        if (r11 == null) goto L5;
        r11.setBounds(this.f17799q);
        this.f17790h.setState(getDrawableState());
        this.f17790h.draw(r10);
    L5:
        this.f17792j.setBounds(this.f17800r);
        super.onDraw(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        b(r13 - r11, r14 - r12);
        i();
    }

    public void p(Drawable r10) {
        if (r10 != null) goto L4;
        this.f17791i = null;
    L5:
        i();
        return;
    L4:
        this.f17791i = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void q(int r10, boolean r11, boolean r12) {
        this.f17798p = r10;
        this.f17796n = r12;
        this.f17795m = r11;
        n();
    }
}
