package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveCouponPriceView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f119563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f119564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f119565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f119566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f119567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f119568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f119569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f119570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f119571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f119572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f119573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f119574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f119575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f119576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f119577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f119578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f119579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f119580r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f119581s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f119582t;

    public LiveCouponPriceView(Context r100) {
        super(r100);
        this.f119566d = new Paint();
        this.f119567e = -364470;
        this.f119569g = false;
        this.f119573k = UIUtils.sp2px(getContext(), 20.0f);
        this.f119575m = 0.0f;
        this.f119576n = UIUtils.sp2px(getContext(), 1.0f);
        this.f119582t = 0.0f;
        a(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        super.draw(r110);
        if (TextUtils.isEmpty(this.f119568f) == true) goto L5;
    L6:
        float r100 = getHeight();
        Paint.FontMetrics r101 = this.f119563a.getFontMetrics();
        Paint.FontMetrics r102 = this.f119564b.getFontMetrics();
        if (this.f119572j <= this.f119573k) goto L9;
        float r103 = getPaddingTop();
        float r104 = r101.descent;
        float r105 = (r103 + (((r100 + r104) - r101.ascent) / 2.0f)) - r104;
    L10:
        float r106 = getPaddingLeft();
        if (this.f119569g == true) goto L16;
        if (TextUtils.isEmpty(this.f119568f) == true) goto L16;
        r110.drawText(this.f119568f, getPaddingLeft(), r105, this.f119563a);
        r106 = r106 + (this.f119582t + this.f119575m);
    L16:
        if (TextUtils.isEmpty(this.f119570h) == true) goto L21;
        r110.drawText(this.f119570h, r106, r105, this.f119564b);
        if (TextUtils.isEmpty(this.f119571i) == true) goto L21;
        r110.drawText(this.f119571i, r106 + this.f119564b.measureText(this.f119570h), r105, this.f119565c);
    L21:
        if (this.f119580r == false) goto L25;
        this.f119566d.setColor(this.f119567e);
        this.f119566d.setStrokeWidth(this.f119576n);
        r110.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f119566d);
        return;
    L25:
        return;
    L9:
        float r107 = getPaddingTop();
        float r108 = r102.descent;
        r105 = (r107 + (((r100 + r108) - r102.ascent) / 2.0f)) - r108;
        goto L10
    L5:
        if (TextUtils.isEmpty(this.f119570h) == false) goto L6;
    }

    public void setPriceBold(boolean r100) {
        this.f119577o = r100;
        this.f119578p = r100;
        if (r100 == false) goto L6;
        this.f119564b.setTypeface(Typeface.DEFAULT_BOLD);
    L6:
        if (this.f119578p == false) goto L8;
        this.f119565c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    public void setPriceText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (this.f119581s == true) goto L7;
    L9:
        this.f119570h = r100;
        this.f119571i = null;
    L10:
        requestLayout();
        invalidate();
        return;
    L7:
        if (r100.contains(".") == false) goto L9;
        int r101 = r100.indexOf(".");
        this.f119570h = r100.substring(0, r101);
        this.f119571i = r100.substring(r101);
        goto L10
    }

    public void setPriceTextColor(int r100) {
        this.f119567e = r100;
        this.f119563a.setColor(r100);
        this.f119564b.setColor(this.f119567e);
        this.f119565c.setColor(this.f119567e);
        this.f119566d.setColor(this.f119567e);
        requestLayout();
        invalidate();
    }

    public void setPriceTextSize(float r100) {
        this.f119573k = r100;
        this.f119564b.setTextSize(r100);
        this.f119565c.setTextSize((r100 * 2.0f) / 3.0f);
        requestLayout();
        invalidate();
    }

    public void setYangTextSize(float r100) {
        this.f119572j = r100;
        this.f119563a.setTextSize(r100);
        requestLayout();
        invalidate();
    }

    public LiveCouponPriceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f119566d = new Paint();
        this.f119567e = -364470;
        this.f119569g = false;
        this.f119573k = UIUtils.sp2px(getContext(), 20.0f);
        this.f119575m = 0.0f;
        this.f119576n = UIUtils.sp2px(getContext(), 1.0f);
        this.f119582t = 0.0f;
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        if (r101 == null) goto L6;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.ec_hideYang, R.attr.ec_priceBold, R.attr.ec_priceDecimalTextSize, R.attr.ec_priceText, R.attr.ec_priceTextColor, R.attr.ec_priceTextSize, R.attr.ec_showDeleteLine, R.attr.ec_spaceSize, R.attr.ec_thinDecimal, R.attr.ec_yangTextSize, R.attr.hideYang, R.attr.priceBold, R.attr.priceDecimalTextSize, R.attr.priceText, R.attr.priceTextColor, R.attr.priceTextSize, R.attr.showDeleteLine, R.attr.spaceSize, R.attr.thinDecimal, R.attr.yangTextSize});
        this.f119570h = r102.getString(13);
        this.f119567e = r102.getColor(14, -364470);
        this.f119573k = r102.getDimension(15, this.f119573k);
        this.f119574l = r102.getDimension(12, 0.0f);
        this.f119572j = r102.getDimension(19, 0.0f);
        this.f119569g = r102.getBoolean(10, false);
        this.f119575m = r102.getDimension(17, this.f119575m);
        boolean r103 = r102.getBoolean(11, false);
        this.f119577o = r103;
        this.f119578p = r103;
        this.f119579q = r103;
        this.f119580r = r102.getBoolean(16, this.f119580r);
        this.f119581s = r102.getBoolean(18, false);
        r102.recycle();
        setPriceText(this.f119570h);
    L6:
        if (this.f119574l != 0.0f) goto L9;
        this.f119574l = (this.f119573k * 2.0f) / 3.0f;
    L9:
        if (this.f119572j != 0.0f) goto L11;
        this.f119572j = (this.f119573k * 2.0f) / 3.0f;
    L11:
        this.f119568f = r100.getString(R.string.ttlive_live_yuan);
        Paint r104 = new Paint();
        this.f119563a = r104;
        r104.setTextSize(this.f119572j);
        this.f119563a.setColor(this.f119567e);
        this.f119563a.setAntiAlias(true);
        if (this.f119579q == false) goto L14;
        this.f119563a.setTypeface(Typeface.DEFAULT_BOLD);
    L14:
        Paint r105 = new Paint();
        this.f119564b = r105;
        r105.setTextSize(this.f119573k);
        this.f119564b.setColor(this.f119567e);
        this.f119564b.setAntiAlias(true);
        if (this.f119577o == false) goto L17;
        this.f119564b.setTypeface(Typeface.DEFAULT_BOLD);
    L17:
        Paint r106 = new Paint();
        this.f119565c = r106;
        if (this.f119581s == false) goto L20;
        r106.setTextSize(this.f119574l);
    L21:
        this.f119565c.setColor(this.f119567e);
        this.f119565c.setAntiAlias(true);
        if (this.f119578p == false) goto L25;
        this.f119565c.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L25:
        return;
    L20:
        r106.setTextSize(this.f119573k);
        goto L21
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (TextUtils.isEmpty(this.f119568f) == true) goto L5;
        Rect r102 = new Rect();
        Paint r103 = this.f119563a;
        String r104 = this.f119568f;
        r103.getTextBounds(r104, 0, r104.length(), r102);
        this.f119582t = r102.width();
    L5:
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.getDefaultSize(getMinimumWidth(), r100);
        if (r105 == 1073741824) goto L21;
        float r107 = 0.0f;
        if (TextUtils.isEmpty(this.f119570h) == true) goto L13;
        float r108 = this.f119564b.measureText(this.f119570h);
        if (TextUtils.isEmpty(this.f119571i) == true) goto L15;
        r108 = r108 + this.f119565c.measureText(this.f119571i);
    L15:
        if (this.f119569g == true) goto L17;
        r107 = this.f119582t + this.f119575m;
    L17:
        float r109 = (((r107 + r108) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
        if (r106 != 0) goto L20;
        r106 = (int) r109;
        goto L21
    L20:
        r106 = (int) Math.min(r109, r106);
        goto L21
    L13:
        r108 = 0.0f;
    L21:
        int r110 = View.MeasureSpec.getMode(r101);
        int r111 = View.getDefaultSize(getMinimumHeight(), r101);
        if (r110 == 1073741824) goto L28;
        float r112 = ((this.f119573k + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r111 != 0) goto L27;
        r111 = Math.round(r112);
        goto L28
    L27:
        r111 = Math.round(Math.min(r112, r111));
    L28:
        setMeasuredDimension(r106, r111);
    }

    public LiveCouponPriceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f119566d = new Paint();
        this.f119567e = -364470;
        this.f119569g = false;
        this.f119573k = UIUtils.sp2px(getContext(), 20.0f);
        this.f119575m = 0.0f;
        this.f119576n = UIUtils.sp2px(getContext(), 1.0f);
        this.f119582t = 0.0f;
        a(r100, r101);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
