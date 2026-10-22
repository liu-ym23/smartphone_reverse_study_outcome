package com.bytedance.android.ec.core.widget.price;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.widget.i;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/PriceView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ec/core/widget/i;", "", "getPrice", "()Ljava/lang/Long;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/ec/core/widget/price/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/core/widget/price/a;", "getBuilder", "()Lcom/bytedance/android/ec/core/widget/price/a;", "builder", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PriceView extends AppCompatTextView implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f46121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f46122b;

    public PriceView(Context r100) {
        this(r100, null, 0, 14);
    }

    public PriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public PriceView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    public boolean x() {
        return true;
    }

    public final String A() {
        Long r100 = this.f46121a.f46127d;
        if (r100 == null) goto L76;
        long r101 = r100.longValue();
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L78
        String r103 = this.f46121a.f46139p;     // Catch: Exception -> L78
        boolean r104 = false;
        if (r103 != null) goto L8;
    L13:
        long r105 = 100;
        Long r106 = Long.valueOf(r101 / r105);     // Catch: Exception -> L78
        if (r106.longValue() == 0) goto L16;
        boolean r107 = true;
    L17:
        String r108 = null;
        if (r107 == true) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L23;
        String r109 = String.valueOf(r106.longValue());     // Catch: Exception -> L78
    L24:
        Long r110 = Long.valueOf(r101 % r105);     // Catch: Exception -> L78
        if (r110.longValue() == 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == true) goto L31;
        r110 = null;
    L31:
        if (r110 == null) goto L33;
        String r112 = String.valueOf(r110.longValue());     // Catch: Exception -> L78
    L34:
        r102.append(y(r109, r112));     // Catch: Exception -> L78
        Long r113 = this.f46121a.C;     // Catch: Exception -> L78
        if (r113 == null) goto L37;
        long r114 = r113.longValue();     // Catch: Exception -> L78
    L38:
        Long r115 = Long.valueOf(r114 / r105);     // Catch: Exception -> L78
        if (r115.longValue() == 0) goto L41;
        boolean r116 = true;
    L42:
        if (r116 == true) goto L45;
        r115 = null;
    L45:
        if (r115 == null) goto L47;
        String r117 = String.valueOf(r115.longValue());     // Catch: Exception -> L78
    L48:
        Long r118 = this.f46121a.C;     // Catch: Exception -> L78
        if (r118 == null) goto L51;
        long r119 = r118.longValue();     // Catch: Exception -> L78
    L52:
        Long r120 = Long.valueOf(r119 % r105);     // Catch: Exception -> L78
        if (r120.longValue() == 0) goto L55;
        boolean r121 = true;
    L56:
        if (r121 == true) goto L59;
        r120 = null;
    L59:
        if (r120 == null) goto L61;
        r108 = String.valueOf(r120.longValue());     // Catch: Exception -> L78
    L61:
        String r122 = y(r117, r108);     // Catch: Exception -> L78
        if (r122.length() <= 0) goto L64;
        boolean r123 = true;
    L65:
        if (r123 == false) goto L67;
        r102.append(r122);     // Catch: Exception -> L78
    L67:
        String r124 = this.f46121a.f46145v;     // Catch: Exception -> L78
        if (r124 != null) goto L70;
    L74:
        return r102.toString();
    L70:
        if (r124.length() <= 0) goto L72;
        r104 = true;
    L72:
        if (r104 != true) goto L74;
        r102.append(this.f46121a.f46145v);     // Catch: Exception -> L78
        goto L74
    L64:
        r123 = false;
        goto L65
    L55:
        r121 = false;
        goto L56
    L51:
        r119 = 0;
        goto L52
    L47:
        r117 = null;
        goto L48
    L41:
        r116 = false;
        goto L42
    L37:
        r114 = 0;
        goto L38
    L33:
        r112 = null;
        goto L34
    L27:
        r111 = false;
        goto L28
    L23:
        r109 = null;
        goto L24
    L16:
        r107 = false;
        goto L17
    L8:
        if (r103.length() <= 0) goto L10;
        boolean r125 = true;
    L11:
        if (r125 != true) goto L13;
        r102.append(this.f46121a.f46139p);     // Catch: Exception -> L78
        goto L13
    L10:
        r125 = false;
    L81:
        return "";
    L76:
        return "";
    }

    public final Long getPrice() {
        return this.f46121a.f46127d;
    }

    public final a getBuilder() {
        return this.f46121a;
    }

    public final void B(float r100) {
        a r101 = this.f46121a;
        r101.f46126c = UIUtils.dip2Px(getContext(), r100);
    }

    public final void C(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        if (x() == false) goto L9;
        r100.invoke(this.f46121a);
        this.f46122b.setStrokeWidth(this.f46121a.f46138o);
        this.f46122b.setColor(this.f46121a.f46137n);
        a r101 = this.f46121a;
        if (r101.E == true) goto L7;
        setTextSize(0, r101.f46126c);
    L7:
        this.f46121a.a();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (x() == true) goto L5;
        return;
    L5:
        if (this.f46121a.f46136m == false) goto L12;
        int r101 = getPaddingLeft();
        int r102 = getWidth() - getPaddingRight();
        a.c r103 = this.f46121a.f46124a;
        if (r103 == null) goto L9;
        getPaint().measureText(getText(), 0, r103.f46154a);
        r101 = Math.max(r101, (int) getPaint().measureText(getText(), 0, r103.f46154a));
        r102 = Math.min(r102, (int) getPaint().measureText(getText(), 0, r103.f46155b));
    L9:
        float r104 = 3;
        r100.drawLine(r101, getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r104), r102, ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r104) + getPaddingTop(), this.f46122b);
        return;
    }

    public void setMaxWidth(final float r100) {
        C(new C98401(r100));
    }

    public static String y(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        boolean r103 = false;
        if (r100 != null) goto L5;
    L10:
        if (r101 == null) goto L24;
        if (r101.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 != true) goto L24;
        if (r102.length() != 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        r102.append("0");
    L22:
        r102.append(".");
        r102.append(r101);
        goto L24
    L19:
        r105 = false;
        goto L20
    L14:
        r104 = false;
    L24:
        if (r102.length() <= 0) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r102.append("元");
    L29:
        return r102.toString();
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 != true) goto L10;
        r102.append(r100);
        goto L10
    L7:
        r106 = false;
        goto L8
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        if (x() == true) goto L5;
    L24:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (TextViewCompat.getAutoSizeTextType(this) == 1) goto L24;
        if (this.f46121a.E == false) goto L24;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = this.f46121a.F;
        int r104 = Integer.MAX_VALUE;
        if (r102 != 0) goto L11;
        int r105 = Integer.MAX_VALUE;
    L12:
        int r106 = Math.min(r103, r105);
        if (View.MeasureSpec.getMode(r101) == 0) goto L16;
        r104 = View.MeasureSpec.getSize(r101);
    L16:
        float r107 = this.f46121a.f46126c;
        setTextSize(0, r107);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
    L18:
        if (getMeasuredHeight() > r104) goto L22;
        if (getMeasuredWidth() > r106) goto L22;
        return;
    L22:
        if (r107 <= 0) goto L29;
        r107 = r107 - UIUtils.sp2px(getContext(), 1.0f);
        setTextSize(0, r107);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
        goto L18
    L29:
        return;
    L11:
        r105 = View.MeasureSpec.getSize(r100);
        goto L12
    }

    public static void z(PriceView r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 400;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter("DouyinNumberABC", "fontFamily");
        Typeface r103 = ECFontHelper.f45592e.b("DouyinNumberABC", r101, false);
        if (r103 == null) goto L9;
        r100.setTypeface(r103);
        return;
    }

    public PriceView(Context r100, AttributeSet r101, int r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L8;
        r110 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        int r102 = a.K;
        Intrinsics.checkNotNullParameter(this, "view");
        a r103 = new a(this);
        this.f46121a = r103;
        Paint r112 = new Paint();
        this.f46122b = r112;
        new Rect();
        if (x() == false) goto L19;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.pv_autoResize, R.attr.pv_hideYuanSymbol, R.attr.pv_prefixMarginRight, R.attr.pv_prefixText, R.attr.pv_prefixTextBold, R.attr.pv_prefixTextColor, R.attr.pv_prefixTextSizeRatio, R.attr.pv_priceBold, R.attr.pv_priceDecimalTextSizeRatio, R.attr.pv_priceInFen, R.attr.pv_priceInFenMax, R.attr.pv_priceTextColor, R.attr.pv_showStrikeThrough, R.attr.pv_strikeThroughColor, R.attr.pv_strikeThroughThickness, R.attr.pv_suffixText, R.attr.pv_suffixTextColor, R.attr.pv_suffixTextMarginLeft, R.attr.pv_suffixTextSizeRatio, R.attr.pv_twoDecimalPlaces, R.attr.pv_yuanSymbolBold, R.attr.pv_yuanSymbolMarginRight, R.attr.pv_yuanSymbolRatioOfPriceTextSize});
        r103.f46126c = getTextSize();
        r103.f46127d = Long.valueOf(r104.getInteger(9, 0));
        r103.C = Long.valueOf(r104.getInteger(10, 0));
        r103.f46129f = r104.getColor(11, CJBadgeTextView.BADGE_COLOR);
        r103.f46130g = r104.getFloat(8, 0.6666667f);
        r103.f46131h = r104.getBoolean(7, false);
        r103.f46132i = r104.getBoolean(1, false);
        r103.f46133j = r104.getFloat(22, 0.6666667f);
        r103.f46134k = r104.getBoolean(20, false);
        r103.f46135l = r104.getDimensionPixelSize(21, vf4.a.a(getContext(), 2.0f));
        r103.f46136m = r104.getBoolean(12, false);
        r103.f46137n = r104.getColor(13, r103.f46129f);
        r103.f46138o = r104.getDimensionPixelSize(14, vf4.a.a(getContext(), 1.0f));
        String r105 = r104.getString(3);
        String r106 = "";
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103.f46139p = r105;
        r103.f46141r = r104.getFloat(6, 1.0f);
        r103.f46142s = r104.getColor(5, r103.f46129f);
        r103.f46140q = r104.getBoolean(4, r103.f46131h);
        r103.f46143t = r104.getDimensionPixelSize(2, vf4.a.a(getContext(), 4.0f));
        String r107 = r104.getString(15);
        if (r107 == null) goto L17;
        r106 = r107;
    L17:
        r103.f46145v = r106;
        r103.f46147x = r104.getFloat(18, 1.0f);
        r103.f46149z = r104.getColor(16, r103.f46129f);
        r103.f46148y = r104.getDimensionPixelSize(17, vf4.a.a(getContext(), 2.0f));
        r103.E = r104.getBoolean(0, false);
        r103.H = r104.getBoolean(19, false);
        r104.recycle();
        r112.setStrokeWidth(r103.f46138o);
        r112.setColor(r103.f46137n);
        setMaxLines(1);
        setIncludeFontPadding(false);
        C(new AnonymousClass1(this));
        return;
    }
}
