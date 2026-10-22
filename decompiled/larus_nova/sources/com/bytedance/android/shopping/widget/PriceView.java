package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class PriceView extends com.bytedance.android.ec.core.widget.price.PriceView {
    public static final /* synthetic */ int C = 0;
    public Boolean A;
    public String B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f187226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f187227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f187228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f187229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f187230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f187231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f187232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f187233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f187234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f187235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f187236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f187237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f187238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f187239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f187240q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f187241r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f187242s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f187243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f187244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f187245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f187246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f187247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f187248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f187249z;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PriceView f187250a;

        public a(PriceView r100) {
            this.f187250a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (r101 != null) goto L5;
            return;
        L5:
            PriceView r102 = this.f187250a;
            int r103 = PriceView.C;
            r101.setText(r102.D());
        }
    }

    private float getCalculateViewWidth() {
        float r100 = 0.0f;
        if (TextUtils.isEmpty(this.f187233j) == true) goto L12;
        float r101 = this.f187227d.measureText(this.f187233j);
        if (TextUtils.isEmpty(this.f187234k) == true) goto L8;
        r101 = r101 + this.f187228e.measureText(this.f187234k);
    L8:
        if (TextUtils.isEmpty(null) == true) goto L14;
        r101 = r101 + this.f187227d.measureText(null);
        if (TextUtils.isEmpty(null) == true) goto L14;
        r101 = r101 + this.f187228e.measureText(null);
    L14:
        if (this.f187232i == true) goto L16;
        float r102 = this.f187244u + this.f187238o;
    L18:
        if (TextUtils.isEmpty(this.f187245v) == true) goto L21;
        r100 = this.f187248y.measureText(this.f187245v);
    L21:
        return ((((r102 + r101) + r100) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
    L16:
        r102 = 0.0f;
        goto L18
    L12:
        r101 = 0.0f;
        goto L14
    }

    public final String D() {
        if (TextUtils.isEmpty(this.f187233j) == false) goto L5;
        return null;
    L5:
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(this.B) == false) goto L12;
        Context r101 = getContext();
        if (this.f187242s == false) goto L10;
        int r102 = R.string.shopping_original_price;
    L11:
        r100.append(r101.getString(r102));
    L13:
        r100.append(this.f187233j);
        if (TextUtils.isEmpty(this.f187234k) == true) goto L17;
        r100.append(this.f187234k);
    L17:
        if (TextUtils.isEmpty(null) == false) goto L23;
        r100.append(getContext().getString(R.string.shopping_currency_yuan));
        if (TextUtils.isEmpty(this.f187245v) == true) goto L22;
        r100.append(this.f187245v);
    L22:
        return r100.toString();
    L23:
        throw null;
    L10:
        r102 = R.string.shopping_current_price;
        goto L11
    L12:
        r100.append(this.B);
        goto L13
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView
    public final boolean x() {
        if (this.A != null) goto L6;
        this.A = Boolean.valueOf(ECSettingKeys.J0());
    L6:
        return this.A.booleanValue();
    }

    public PriceView(Context r100) {
        super(r100);
        this.f187229f = new Paint();
        this.f187230g = -364470;
        this.f187232i = false;
        this.f187236m = UIUtils.sp2px(getContext(), 20.0f);
        this.f187238o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f187239p = UIUtils.sp2px(getContext(), 1.0f);
        this.f187244u = 0.0f;
        this.f187246w = UIUtils.sp2px(getContext(), 10.0f);
        this.f187247x = -364470;
        this.f187249z = 0.0f;
        this.A = null;
        E(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        super.draw(r110);
        if (x() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f187231h) == true) goto L8;
    L9:
        float r100 = getHeight();
        Paint.FontMetrics r101 = this.f187226c.getFontMetrics();
        Paint.FontMetrics r102 = this.f187227d.getFontMetrics();
        if (this.f187235l <= this.f187236m) goto L12;
        float r103 = getPaddingTop();
        float r104 = r101.descent;
        float r105 = (r103 + (((r100 + r104) - r101.ascent) / 2.0f)) - r104;
    L13:
        float r106 = getPaddingLeft();
        if (this.f187232i == true) goto L19;
        if (TextUtils.isEmpty(this.f187231h) == true) goto L19;
        r110.drawText(this.f187231h, getPaddingLeft(), r105, this.f187226c);
        r106 = r106 + (this.f187244u + this.f187238o);
    L19:
        if (TextUtils.isEmpty(this.f187233j) == true) goto L36;
        r110.drawText(this.f187233j, r106, r105, this.f187227d);
        float r107 = this.f187227d.measureText(this.f187233j);
        if (TextUtils.isEmpty(this.f187234k) == true) goto L23;
        float r108 = this.f187228e.measureText(this.f187234k);
    L25:
        if (TextUtils.isEmpty(this.f187234k) == true) goto L28;
        r110.drawText(this.f187234k, r106 + r107, r105, this.f187228e);
    L28:
        if (TextUtils.isEmpty(null) == true) goto L33;
        float r109 = (r106 + r108) + r107;
        r110.drawText(null, r109, r105, this.f187227d);
        if (TextUtils.isEmpty(null) == true) goto L36;
        r110.drawText(null, r109 + this.f187227d.measureText(null), r105, this.f187228e);
        goto L36
    L33:
        if (TextUtils.isEmpty(this.f187245v) == true) goto L36;
        r110.drawText(this.f187245v, (r106 + r108) + r107, r105, this.f187248y);
        goto L36
    L23:
        r108 = 0.0f;
    L36:
        if (this.f187242s == false) goto L40;
        this.f187229f.setColor(this.f187230g);
        this.f187229f.setStrokeWidth(this.f187239p);
        r110.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f187229f);
        return;
    L40:
        return;
    L12:
        float r111 = getPaddingTop();
        float r112 = r102.descent;
        r105 = (r111 + (((r100 + r112) - r102.ascent) / 2.0f)) - r112;
        goto L13
    L8:
        if (TextUtils.isEmpty(this.f187233j) == false) goto L9;
    }

    public void setExtraText(final String r100) {
        if (x() == false) goto L5;
        C(new l(r100));
        return;
    L5:
        this.f187245v = r100;
        requestLayout();
        invalidate();
    }

    public void setExtraTextColor(final int r100) {
        if (x() == false) goto L5;
        C(new i(r100));
        return;
    L5:
        this.f187247x = r100;
        this.f187248y.setColor(r100);
        requestLayout();
        invalidate();
    }

    public void setHideYang(final boolean r100) {
        if (x() == false) goto L5;
        C(new o(r100));
        return;
    L5:
        this.f187232i = r100;
        invalidate();
        requestLayout();
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView, com.bytedance.android.ec.core.widget.i
    public void setMaxWidth(float r100) {
        if (x() == true) goto L5;
        this.f187249z = r100;
        requestLayout();
        invalidate();
        return;
    L5:
        if (r100 <= 0.0f) goto L7;
        super.setMaxWidth(r100);
    L8:
        C(new d());
        return;
    L7:
        super.setMaxWidth(Integer.MAX_VALUE);
        goto L8
    }

    public void setPriceText(final String r100) {
        if (x() == false) goto L6;
        C(new e(r100));
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (this.f187243t == true) goto L10;
    L12:
        this.f187233j = r100;
        this.f187234k = null;
    L13:
        requestLayout();
        invalidate();
        return;
    L10:
        if (r100.contains(".") == false) goto L12;
        int r101 = r100.indexOf(".");
        this.f187233j = r100.substring(0, r101);
        this.f187234k = r100.substring(r101);
        goto L13
    }

    public void setPriceTextColor(final int r100) {
        if (x() == false) goto L5;
        C(new f(r100));
        return;
    L5:
        this.f187230g = r100;
        this.f187226c.setColor(r100);
        this.f187227d.setColor(this.f187230g);
        this.f187228e.setColor(this.f187230g);
        this.f187229f.setColor(this.f187230g);
        invalidate();
        requestLayout();
    }

    public void setShowDeleteLine(final boolean r100) {
        if (x() == false) goto L5;
        C(new h(r100));
        return;
    L5:
        this.f187242s = r100;
        invalidate();
        requestLayout();
    }

    public void setSpaceSize(final float r100) {
        if (x() == false) goto L5;
        C(new g(r100));
        return;
    L5:
        this.f187238o = r100;
        invalidate();
        requestLayout();
    }

    public void setThinDecimal(final boolean r100) {
        if (x() == false) goto L5;
        C(new k(this, r100));
        return;
    L5:
        this.f187243t = r100;
        if (r100 == true) goto L8;
        this.f187228e.setTextSize(this.f187236m);
    L12:
        invalidate();
        requestLayout();
        return;
    L8:
        if (this.f187237n != 0.0f) goto L10;
        this.f187237n = this.f187236m * 0.8f;
    L10:
        this.f187228e.setTextSize(this.f187237n);
        goto L12
    }

    public void setYangBold(final boolean r100) {
        if (x() == false) goto L5;
        C(new m(r100));
        return;
    L5:
        this.f187241r = r100;
        if (r100 == false) goto L8;
        this.f187226c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    public void setYangTextSize(final float r100) {
        if (x() == false) goto L5;
        C(new n(this, r100));
        return;
    L5:
        this.f187235l = r100;
        this.f187226c.setTextSize(r100);
        requestLayout();
        invalidate();
    }

    public void setupCustomPrefix4ContentDescription(String r100) {
        if (x() == true) goto L6;
        this.B = r100;
        setContentDescription(D());
        return;
    }

    public PriceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f187229f = new Paint();
        this.f187230g = -364470;
        this.f187232i = false;
        this.f187236m = UIUtils.sp2px(getContext(), 20.0f);
        this.f187238o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f187239p = UIUtils.sp2px(getContext(), 1.0f);
        this.f187244u = 0.0f;
        this.f187246w = UIUtils.sp2px(getContext(), 10.0f);
        this.f187247x = -364470;
        this.f187249z = 0.0f;
        this.A = null;
        E(r100, r101);
    }

    public final void E(Context r100, AttributeSet r101) {
        if (r101 == null) goto L6;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.autoResizeByMeasureWidth, R.attr.extraText, R.attr.extraTextColor, R.attr.extraTextSize, R.attr.hideYang, R.attr.maxPriceText, R.attr.minTextSize, R.attr.needPriceBorder, R.attr.prefixSpaceSize, R.attr.prefixText, R.attr.prefixTextBold, R.attr.prefixTextColor, R.attr.prefixTextSize, R.attr.priceBold, R.attr.priceDecimalTextSize, R.attr.priceText, R.attr.priceTextColor, R.attr.priceTextSize, R.attr.priceViewMaxWidth, R.attr.showDeleteLine, R.attr.spaceSize, R.attr.suffixTextSize, R.attr.thinDecimal, R.attr.yangTextSize});
        this.f187233j = r102.getString(15);
        this.f187230g = r102.getColor(16, -364470);
        this.f187236m = r102.getDimension(17, this.f187236m);
        this.f187237n = r102.getDimension(14, this.f187237n);
        this.f187235l = r102.getDimension(23, 0.0f);
        this.f187232i = r102.getBoolean(4, false);
        this.f187238o = r102.getDimension(20, this.f187238o);
        this.f187240q = r102.getBoolean(13, this.f187240q);
        this.f187242s = r102.getBoolean(19, this.f187242s);
        this.f187243t = r102.getBoolean(22, false);
        this.f187245v = r102.getString(1);
        this.f187247x = r102.getColor(2, -364470);
        this.f187246w = r102.getDimension(3, this.f187246w);
        this.f187249z = r102.getDimension(18, this.f187249z);
        r102.recycle();
    L6:
        if (x() == false) goto L10;
        C(new j(this));
        float r103 = this.f187249z;
        if (r103 <= 0.0f) goto L31;
        setMaxWidth(r103);
        return;
    L31:
        return;
    L10:
        setFocusable(true);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        setPriceText(this.f187233j);
        setWillNotDraw(false);
        if (this.f187235l != 0.0f) goto L13;
        this.f187235l = this.f187236m * 0.8f;
    L13:
        this.f187231h = r100.getString(R.string.price_symbol_yang);
        Paint r104 = new Paint();
        this.f187226c = r104;
        r104.setTextSize(this.f187235l);
        this.f187226c.setColor(this.f187230g);
        this.f187226c.setAntiAlias(true);
        if (this.f187241r == false) goto L16;
        this.f187226c.setTypeface(Typeface.DEFAULT_BOLD);
    L16:
        Paint r105 = new Paint();
        this.f187227d = r105;
        r105.setTextSize(this.f187236m);
        this.f187227d.setColor(this.f187230g);
        this.f187227d.setAntiAlias(true);
        if (this.f187240q == false) goto L19;
        this.f187227d.setTypeface(Typeface.DEFAULT_BOLD);
    L19:
        Paint r106 = new Paint();
        this.f187228e = r106;
        if (this.f187243t == true) goto L22;
        r106.setTextSize(this.f187236m);
    L26:
        this.f187228e.setColor(this.f187230g);
        this.f187228e.setAntiAlias(true);
        if (this.f187240q == false) goto L29;
        this.f187228e.setTypeface(Typeface.DEFAULT_BOLD);
    L29:
        Paint r107 = new Paint();
        this.f187248y = r107;
        r107.setColor(this.f187247x);
        this.f187248y.setAntiAlias(true);
        this.f187248y.setTextSize(this.f187246w);
        return;
    L22:
        if (this.f187237n != 0.0f) goto L24;
        this.f187237n = this.f187236m * 0.8f;
    L24:
        r106.setTextSize(this.f187237n);
        goto L26
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (x() == false) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        if (TextUtils.isEmpty(this.f187231h) == true) goto L8;
        Rect r102 = new Rect();
        Paint r103 = this.f187226c;
        String r104 = this.f187231h;
        r103.getTextBounds(r104, 0, r104.length(), r102);
        this.f187244u = r102.width();
    L8:
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r100);
        if (r105 == 1073741824) goto L35;
        float r107 = getCalculateViewWidth();
        float r108 = this.f187249z;
        if (r108 > 0.0f) goto L14;
    L32:
        if (r106 != 0) goto L34;
        r106 = (int) r107;
        goto L35
    L34:
        r106 = (int) Math.min(r107, r106);
        goto L35
    L14:
        if (r107 <= r108) goto L32;
    L16:
        if (r107 <= this.f187249z) goto L32;
        float r109 = this.f187236m;
        if (r109 <= 1.0f) goto L32;
        float r110 = r109 - 1.0f;
        if (r110 < 0.0f) goto L22;
        Paint r111 = this.f187227d;
        this.f187236m = r110;
        r111.setTextSize(r110);
    L22:
        float r112 = this.f187237n - 1.0f;
        if (r112 < 0.0f) goto L25;
        Paint r113 = this.f187228e;
        this.f187237n = r112;
        r113.setTextSize(r112);
    L25:
        float r114 = this.f187235l - 1.0f;
        if (r114 < 0.0f) goto L28;
        Paint r115 = this.f187226c;
        this.f187235l = r114;
        r115.setTextSize(r114);
    L28:
        float r116 = this.f187246w - 1.0f;
        if (r116 < 0.0f) goto L31;
        Paint r117 = this.f187248y;
        this.f187246w = r116;
        r117.setTextSize(r116);
    L31:
        r107 = getCalculateViewWidth();
    L35:
        int r118 = View.MeasureSpec.getMode(r101);
        int r119 = TextView.getDefaultSize(getMinimumHeight(), r101);
        if (r118 == 1073741824) goto L42;
        float r120 = ((this.f187236m + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r119 != 0) goto L41;
        r119 = Math.round(r120);
        goto L42
    L41:
        r119 = Math.round(Math.min(r120, r119));
    L42:
        setMeasuredDimension(r106, r119);
    }

    public PriceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f187229f = new Paint();
        this.f187230g = -364470;
        this.f187232i = false;
        this.f187236m = UIUtils.sp2px(getContext(), 20.0f);
        this.f187238o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f187239p = UIUtils.sp2px(getContext(), 1.0f);
        this.f187244u = 0.0f;
        this.f187246w = UIUtils.sp2px(getContext(), 10.0f);
        this.f187247x = -364470;
        this.f187249z = 0.0f;
        this.A = null;
        E(r100, r101);
    }
}
