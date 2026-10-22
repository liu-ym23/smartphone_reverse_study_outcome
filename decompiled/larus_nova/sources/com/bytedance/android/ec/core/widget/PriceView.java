package com.bytedance.android.ec.core.widget;

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

/* JADX INFO: loaded from: classes43.dex */
public class PriceView extends com.bytedance.android.ec.core.widget.price.PriceView {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f46019J = 0;
    public float A;
    public int B;
    public Paint C;
    public float D;
    public boolean E;
    public Boolean F;
    public String G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f46020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f46021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f46022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f46023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f46025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f46026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f46027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f46028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f46029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f46030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f46031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f46032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f46033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f46034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f46035r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f46036s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f46037t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f46038u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f46039v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f46040w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f46041x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f46042y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f46043z;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PriceView f46044a;

        public a(PriceView r100) {
            this.f46044a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (r101 != null) goto L5;
            return;
        L5:
            PriceView r102 = this.f46044a;
            int r103 = PriceView.f46019J;
            r101.setText(r102.D());
        }
    }

    private float getCalculateViewWidth() {
        float r100 = 0.0f;
        if (TextUtils.isEmpty(this.f46027j) == true) goto L12;
        float r101 = this.f46021d.measureText(this.f46027j);
        if (TextUtils.isEmpty(this.f46028k) == true) goto L8;
        r101 = r101 + this.f46022e.measureText(this.f46028k);
    L8:
        if (TextUtils.isEmpty(this.H) == true) goto L14;
        r101 = r101 + this.f46021d.measureText(this.H);
        if (TextUtils.isEmpty(this.I) == true) goto L14;
        r101 = r101 + this.f46022e.measureText(this.I);
    L14:
        if (TextUtils.isEmpty(this.f46039v) == true) goto L16;
        float r102 = this.f46041x.measureText(this.f46039v) + this.f46042y;
    L18:
        if (this.f46026i == true) goto L20;
        float r103 = this.f46038u + this.f46032o;
    L22:
        if (TextUtils.isEmpty(this.f46043z) == true) goto L25;
        r100 = this.C.measureText(this.f46043z);
    L25:
        return (((((r102 + r103) + r101) + r100) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
    L20:
        r103 = 0.0f;
        goto L22
    L16:
        r102 = 0.0f;
        goto L18
    L12:
        r101 = 0.0f;
        goto L14
    }

    public final String D() {
        if (TextUtils.isEmpty(this.f46027j) == false) goto L6;
        return null;
    L6:
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(this.G) == false) goto L13;
        Context r101 = getContext();
        if (this.f46036s == false) goto L11;
        int r102 = R.string.shopping_original_price;
    L12:
        r100.append(r101.getString(r102));
    L14:
        r100.append(this.f46027j);
        if (TextUtils.isEmpty(this.f46028k) == true) goto L18;
        r100.append(this.f46028k);
    L18:
        if (TextUtils.isEmpty(this.H) == true) goto L22;
        r100.append(this.H.replace("-", "至"));
        if (TextUtils.isEmpty(this.I) == true) goto L22;
        r100.append(this.I);
    L22:
        r100.append(getContext().getString(R.string.shopping_currency_yuan));
        if (TextUtils.isEmpty(this.f46043z) == true) goto L26;
        r100.append(this.f46043z);
    L26:
        return r100.toString();
    L11:
        r102 = R.string.shopping_current_price;
        goto L12
    L13:
        r100.append(this.G);
        goto L14
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView
    public final boolean x() {
        if (this.F != null) goto L6;
        this.F = Boolean.valueOf(ECSettingKeys.J0());
    L6:
        return this.F.booleanValue();
    }

    public String getExtraText() {
        return this.f46043z;
    }

    public String getMaxPriceDecimalText() {
        return this.I;
    }

    public String getMaxPriceIntegerText() {
        return this.H;
    }

    public String getPrefixText() {
        return this.f46039v;
    }

    public String getPriceDecimalText() {
        return this.f46028k;
    }

    public String getPriceIntegerText() {
        return this.f46027j;
    }

    public PriceView(Context r100) {
        super(r100);
        this.f46023f = new Paint();
        this.f46024g = -364470;
        this.f46026i = false;
        this.f46030m = UIUtils.sp2px(getContext(), 20.0f);
        this.f46032o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f46033p = UIUtils.sp2px(getContext(), 1.0f);
        this.f46038u = 0.0f;
        this.f46042y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        super.draw(r110);
        if (x() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f46025h) == true) goto L8;
    L9:
        float r100 = getHeight();
        Paint.FontMetrics r101 = this.f46020c.getFontMetrics();
        Paint.FontMetrics r102 = this.f46021d.getFontMetrics();
        if (this.f46029l <= this.f46030m) goto L12;
        float r103 = getPaddingTop();
        float r104 = r101.descent;
        float r105 = (r103 + (((r100 + r104) - r101.ascent) / 2.0f)) - r104;
    L13:
        float r106 = getPaddingLeft();
        if (TextUtils.isEmpty(this.f46039v) == true) goto L17;
        float r107 = this.f46041x.measureText(this.f46039v);
        r110.drawText(this.f46039v, r106, r105 - 2.0f, this.f46041x);
        r106 = r106 + (r107 + this.f46042y);
    L17:
        if (this.f46026i == true) goto L22;
        if (TextUtils.isEmpty(this.f46025h) == true) goto L22;
        r110.drawText(this.f46025h, r106, r105, this.f46020c);
        r106 = r106 + (this.f46038u + this.f46032o);
    L22:
        if (TextUtils.isEmpty(this.f46027j) == true) goto L39;
        r110.drawText(this.f46027j, r106, r105, this.f46021d);
        float r108 = this.f46021d.measureText(this.f46027j);
        if (TextUtils.isEmpty(this.f46028k) == true) goto L26;
        float r109 = this.f46022e.measureText(this.f46028k);
    L28:
        if (TextUtils.isEmpty(this.f46028k) == true) goto L31;
        r110.drawText(this.f46028k, r106 + r108, r105, this.f46022e);
    L31:
        if (TextUtils.isEmpty(this.H) == true) goto L36;
        float r111 = (r106 + r109) + r108;
        r110.drawText(this.H, r111, r105, this.f46021d);
        if (TextUtils.isEmpty(this.I) == true) goto L39;
        r110.drawText(this.I, r111 + this.f46021d.measureText(this.H), r105, this.f46022e);
        goto L39
    L36:
        if (TextUtils.isEmpty(this.f46043z) == true) goto L39;
        r110.drawText(this.f46043z, (r106 + r109) + r108, r105 - 2.0f, this.C);
        goto L39
    L26:
        r109 = 0.0f;
    L39:
        if (this.f46036s == false) goto L43;
        this.f46023f.setColor(this.f46024g);
        this.f46023f.setStrokeWidth(this.f46033p);
        r110.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f46023f);
        return;
    L43:
        return;
    L12:
        float r112 = getPaddingTop();
        float r113 = r102.descent;
        r105 = (r112 + (((r100 + r113) - r102.ascent) / 2.0f)) - r113;
        goto L13
    L8:
        if (TextUtils.isEmpty(this.f46027j) == false) goto L9;
    }

    public void setDeleteLineWidth(final float r100) {
        if (x() == false) goto L5;
        C(new b0(r100));
        return;
    L5:
        this.f46033p = r100;
    }

    public void setExtraText(final String r100) {
        if (x() == false) goto L5;
        C(new r(r100));
        return;
    L5:
        this.f46043z = r100;
        requestLayout();
        invalidate();
    }

    public void setExtraTextColor(final int r100) {
        if (x() == false) goto L5;
        C(new n(r100));
        return;
    L5:
        this.B = r100;
        this.C.setColor(r100);
        requestLayout();
        invalidate();
    }

    public void setExtraTextSize(float r100) {
        this.A = r100;
    }

    public void setHideYang(final boolean r100) {
        if (x() == false) goto L5;
        C(new y(r100));
        return;
    L5:
        this.f46026i = r100;
        invalidate();
        requestLayout();
    }

    public void setMaxPriceText(final String r100) {
        if (x() == false) goto L6;
        C(new w(r100));
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        this.H = null;
    L15:
        requestLayout();
        invalidate();
        return;
    L8:
        if (this.f46037t == true) goto L10;
    L12:
        this.H = r100;
        this.I = null;
    L13:
        this.H = "-" + this.H;
        goto L15
    L10:
        if (r100.contains(".") == false) goto L12;
        int r101 = r100.indexOf(".");
        this.H = r100.substring(0, r101);
        this.I = r100.substring(r101);
        goto L13
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView, com.bytedance.android.ec.core.widget.i
    public void setMaxWidth(float r100) {
        if (x() == true) goto L5;
        this.D = r100;
        requestLayout();
        invalidate();
        return;
    L5:
        if (r100 <= 0.0f) goto L7;
        super.setMaxWidth(r100);
    L8:
        C(new u());
        return;
    L7:
        super.setMaxWidth(Integer.MAX_VALUE);
        goto L8
    }

    public void setPrefixText(final String r100) {
        if (x() == false) goto L5;
        C(new k(r100));
        return;
    L5:
        this.f46039v = r100;
        requestLayout();
        invalidate();
    }

    public void setPrefixTextColor(final int r100) {
        if (x() == false) goto L6;
        C(new s(r100));
        return;
    }

    public void setPriceBold(final boolean r100) {
        if (x() == false) goto L5;
        C(new l(r100));
        return;
    L5:
        this.f46034q = r100;
        if (r100 == false) goto L8;
        this.f46021d.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    public void setPriceDecimalTextSize(final float r100) {
        if (x() == false) goto L5;
        C(new o(this, r100));
        return;
    L5:
        this.f46037t = true;
        this.f46031n = r100;
        this.f46022e.setTextSize(r100);
        invalidate();
        requestLayout();
    }

    public void setPriceText(final String r100) {
        if (x() == false) goto L6;
        C(new x(r100));
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (this.f46037t == true) goto L10;
    L12:
        this.f46027j = r100;
        this.f46028k = null;
    L13:
        requestLayout();
        invalidate();
        return;
    L10:
        if (r100.contains(".") == false) goto L12;
        int r101 = r100.indexOf(".");
        this.f46027j = r100.substring(0, r101);
        this.f46028k = r100.substring(r101);
        goto L13
    }

    public void setPriceTextColor(final int r100) {
        if (x() == false) goto L5;
        C(new z(r100));
        return;
    L5:
        this.f46024g = r100;
        this.f46020c.setColor(r100);
        this.f46021d.setColor(this.f46024g);
        this.f46022e.setColor(this.f46024g);
        this.f46023f.setColor(this.f46024g);
        invalidate();
        requestLayout();
    }

    public void setPriceTextSize(final float r100) {
        if (x() == false) goto L5;
        C(new a0(r100));
        return;
    L5:
        this.f46030m = r100;
        this.f46021d.setTextSize(r100);
        if (this.f46037t == false) goto L8;
        this.f46022e.setTextSize(r100 * 0.8f);
    L8:
        requestLayout();
        invalidate();
    }

    public void setShowDeleteLine(final boolean r100) {
        if (x() == false) goto L5;
        C(new c0(r100));
        return;
    L5:
        this.f46036s = r100;
        invalidate();
        requestLayout();
    }

    public void setSpaceSize(final float r100) {
        if (x() == false) goto L5;
        C(new p(r100));
        return;
    L5:
        this.f46032o = r100;
        invalidate();
        requestLayout();
    }

    public void setThinDecimal(final boolean r100) {
        if (x() == false) goto L5;
        C(new t(this, r100));
        return;
    L5:
        this.f46037t = r100;
        if (r100 == false) goto L8;
        this.f46031n = this.f46030m * 0.8f;
    L9:
        this.f46022e.setTextSize(this.f46031n);
        invalidate();
        requestLayout();
        return;
    L8:
        this.f46031n = this.f46030m;
        goto L9
    }

    public void setYangBold(final boolean r100) {
        if (x() == false) goto L5;
        C(new q(r100));
        return;
    L5:
        this.f46035r = r100;
        if (r100 == false) goto L8;
        this.f46020c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    public void setYangTextSize(final float r100) {
        if (x() == false) goto L5;
        C(new v(this, r100));
        return;
    L5:
        this.f46029l = r100;
        this.f46020c.setTextSize(r100);
        requestLayout();
        invalidate();
    }

    public void setupCustomPrefix4ContentDescription(String r100) {
        this.G = r100;
        setContentDescription(D());
    }

    public PriceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f46023f = new Paint();
        this.f46024g = -364470;
        this.f46026i = false;
        this.f46030m = UIUtils.sp2px(getContext(), 20.0f);
        this.f46032o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f46033p = UIUtils.sp2px(getContext(), 1.0f);
        this.f46038u = 0.0f;
        this.f46042y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r100, r101);
    }

    public final void E(final Context r100, AttributeSet r101) {
        if (r101 == null) goto L6;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.autoResizeByMeasureWidth, R.attr.extraText, R.attr.extraTextColor, R.attr.extraTextSize, R.attr.hideYang, R.attr.maxPriceText, R.attr.minTextSize, R.attr.needPriceBorder, R.attr.prefixSpaceSize, R.attr.prefixText, R.attr.prefixTextBold, R.attr.prefixTextColor, R.attr.prefixTextSize, R.attr.priceBold, R.attr.priceDecimalTextSize, R.attr.priceText, R.attr.priceTextColor, R.attr.priceTextSize, R.attr.priceViewMaxWidth, R.attr.showDeleteLine, R.attr.spaceSize, R.attr.suffixTextSize, R.attr.thinDecimal, R.attr.yangTextSize});
        this.f46027j = r102.getString(15);
        this.f46024g = r102.getColor(16, -364470);
        this.f46030m = r102.getDimension(17, this.f46030m);
        this.f46031n = r102.getDimension(14, this.f46031n);
        this.f46029l = r102.getDimension(23, 0.0f);
        this.f46026i = r102.getBoolean(4, false);
        this.f46032o = r102.getDimension(20, this.f46032o);
        this.f46034q = r102.getBoolean(13, this.f46034q);
        this.f46036s = r102.getBoolean(19, this.f46036s);
        this.f46037t = r102.getBoolean(22, false);
        this.f46039v = r102.getString(9);
        this.f46040w = r102.getDimension(12, this.f46030m);
        this.f46043z = r102.getString(1);
        this.B = r102.getColor(2, -364470);
        this.A = r102.getDimension(3, this.A);
        this.D = r102.getDimension(18, this.D);
        this.E = r102.getBoolean(7, false);
        r102.recycle();
    L6:
        if (x() == false) goto L8;
        C(new m(this, r100));
        return;
    L8:
        setFocusable(true);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        setPriceText(this.f46027j);
        setWillNotDraw(false);
        if (this.f46029l != 0.0f) goto L11;
        this.f46029l = this.f46030m * 0.8f;
    L11:
        this.f46025h = r100.getString(R.string.price_symbol_yang);
        Paint r103 = new Paint();
        this.f46020c = r103;
        r103.setTextSize(this.f46029l);
        this.f46020c.setColor(this.f46024g);
        this.f46020c.setAntiAlias(true);
        if (this.f46035r == false) goto L14;
        this.f46020c.setTypeface(Typeface.DEFAULT_BOLD);
    L14:
        Paint r104 = new Paint();
        this.f46021d = r104;
        r104.setTextSize(this.f46030m);
        this.f46021d.setColor(this.f46024g);
        this.f46021d.setAntiAlias(true);
        if (this.f46034q == false) goto L18;
        this.f46021d.setTypeface(Typeface.DEFAULT_BOLD);
    L18:
        if (this.E == false) goto L20;
        this.f46021d.setShadowLayer(2.0f, 0.0f, 2.0f, r100.getResources().getColor(R.color.shopping_color_1A1F0000));
    L20:
        Paint r105 = new Paint();
        this.f46022e = r105;
        if (this.f46037t == true) goto L23;
        this.f46031n = this.f46030m;
    L26:
        r105.setTextSize(this.f46031n);
        this.f46022e.setColor(this.f46024g);
        this.f46022e.setAntiAlias(true);
        if (this.f46034q == false) goto L29;
        this.f46022e.setTypeface(Typeface.DEFAULT_BOLD);
    L29:
        Paint r106 = new Paint();
        this.f46041x = r106;
        r106.setColor(this.f46024g);
        this.f46041x.setAntiAlias(true);
        this.f46041x.setTextSize(this.f46040w);
        if (this.f46034q == false) goto L32;
        this.f46041x.setTypeface(Typeface.DEFAULT_BOLD);
    L32:
        Paint r107 = new Paint();
        this.C = r107;
        r107.setColor(this.B);
        this.C.setAntiAlias(true);
        this.C.setTextSize(this.A);
        if (this.f46034q == false) goto L37;
        this.C.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L37:
        return;
    L23:
        if (this.f46031n != 0.0f) goto L26;
        this.f46031n = this.f46030m * 0.8f;
        goto L26
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (x() == false) goto L6;
        super.onMeasure(r110, r111);
        return;
    L6:
        if (TextUtils.isEmpty(this.f46025h) == true) goto L8;
        Rect r100 = new Rect();
        Paint r101 = this.f46020c;
        String r102 = this.f46025h;
        r101.getTextBounds(r102, 0, r102.length(), r100);
        this.f46038u = r100.width();
    L8:
        int r103 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        if (r103 == 1073741824) goto L57;
        float r104 = this.f46030m;
        if (this.f46037t == false) goto L14;
        float r105 = this.f46031n;
    L15:
        float r106 = this.f46029l;
        float r107 = this.f46040w;
        float r108 = this.A;
        float r109 = this.f46021d.getTextSize();
        float r113 = this.f46030m;
        if (r109 >= r113) goto L19;
        this.f46021d.setTextSize(r113);
    L19:
        if (this.f46022e.getTextSize() >= r105) goto L21;
        this.f46022e.setTextSize(r105);
    L21:
        float r114 = this.f46020c.getTextSize();
        float r115 = this.f46029l;
        if (r114 >= r115) goto L24;
        this.f46020c.setTextSize(r115);
    L24:
        float r116 = this.f46041x.getTextSize();
        float r117 = this.f46040w;
        if (r116 >= r117) goto L27;
        this.f46041x.setTextSize(r117);
    L27:
        float r118 = this.C.getTextSize();
        float r119 = this.A;
        if (r118 >= r119) goto L30;
        this.C.setTextSize(r119);
    L30:
        float r120 = getCalculateViewWidth();
        float r121 = this.D;
        if (r121 > 0.0f) goto L33;
    L54:
        if (r112 != 0) goto L56;
        r112 = (int) r120;
        goto L57
    L56:
        r112 = (int) Math.min(r120, r112);
        goto L57
    L33:
        if (r120 <= r121) goto L54;
    L35:
        if (r120 <= this.D) goto L54;
        if (r104 <= 1.0f) goto L54;
        float r122 = r104 - 1.0f;
        if (r122 < 0.0f) goto L41;
        this.f46021d.setTextSize(r122);
        r104 = r122;
    L41:
        float r123 = r105 - 1.0f;
        if (r123 < 0.0f) goto L44;
        this.f46022e.setTextSize(r123);
        r105 = r123;
    L44:
        float r124 = r106 - 1.0f;
        if (r124 < 0.0f) goto L47;
        this.f46020c.setTextSize(r124);
        r106 = r124;
    L47:
        float r125 = r107 - 1.0f;
        if (r125 < 0.0f) goto L50;
        this.f46041x.setTextSize(r125);
        r107 = r125;
    L50:
        float r126 = r108 - 1.0f;
        if (r126 < 0.0f) goto L53;
        this.C.setTextSize(r126);
        r108 = r126;
    L53:
        r120 = getCalculateViewWidth();
        goto L35
    L14:
        r105 = r104;
    L57:
        int r127 = View.MeasureSpec.getMode(r111);
        int r128 = TextView.getDefaultSize(getMinimumHeight(), r111);
        if (r127 == 1073741824) goto L64;
        float r129 = ((this.f46030m + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r128 != 0) goto L63;
        r128 = Math.round(r129);
        goto L64
    L63:
        r128 = Math.round(Math.min(r129, r128));
    L64:
        setMeasuredDimension(r112, r128);
    }

    public PriceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f46023f = new Paint();
        this.f46024g = -364470;
        this.f46026i = false;
        this.f46030m = UIUtils.sp2px(getContext(), 20.0f);
        this.f46032o = UIUtils.dip2Px(getContext(), 5.0f);
        this.f46033p = UIUtils.sp2px(getContext(), 1.0f);
        this.f46038u = 0.0f;
        this.f46042y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r100, r101);
    }
}
