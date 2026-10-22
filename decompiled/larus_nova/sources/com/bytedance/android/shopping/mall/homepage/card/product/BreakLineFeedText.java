package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/BreakLineFeedText;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextBySelf", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BreakLineFeedText extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f178011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f178012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f178013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpannableStringBuilder f178014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f178015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f178016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f178017g;

    public static final class a {
    }

    static {
    }

    public BreakLineFeedText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f178013c = new float[]{0.0f};
        this.f178014d = new SpannableStringBuilder();
        this.f178016f = true;
        this.f178017g = -1;
        if (this.f178011a != null) goto L6;
        this.f178011a = "";
        return;
    }

    private final void setTextBySelf(CharSequence r100) {
        this.f178012b = true;
        setText(r100);
        this.f178012b = false;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    public BreakLineFeedText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f178013c = new float[]{0.0f};
        this.f178014d = new SpannableStringBuilder();
        this.f178016f = true;
        this.f178017g = -1;
        if (this.f178011a != null) goto L6;
        this.f178011a = "";
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r210, int r211) {
        if (this.f178015e == true) goto L6;
        super.onMeasure(r210, r211);
        return;
    L6:
        int r100 = getLayoutParams().width;
        super.onMeasure(r210, r211);
        CharSequence r101 = getText();
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r104 >= r101.length()) goto L13;
        char r105 = r101.charAt(r104);
        if (r105 == '\n') goto L12;
        r102.append(r105);
    L12:
        r104 = r104 + 1;
        goto L8
    L13:
        CharSequence r106 = this.f178011a;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L16:
        int r107 = 1;
        if (StringsKt.startsWith$default(r106, r102, false, 2, null) == true) goto L19;
    L21:
        getLayoutParams().width = getMeasuredWidth();
        float r108 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f178014d.clear();
        this.f178014d.clearSpans();
        int r109 = TextViewCompat.getMaxLines(this);
        int r110 = 0;
        int r111 = 0;
    L22:
        if (r110 >= r109) goto L88;
        if (r110 != 0) goto L35;
        CharSequence r112 = this.f178011a;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L27:
        float r113 = 0.0f;
        if ((r112 instanceof Spanned) == false) goto L34;
        Object[] r114 = ((Spanned) r112).getSpans(r103, r112.length(), ReplacementSpan.class);
        int r115 = r114.length;
        int r116 = 0;
        float r117 = 0.0f;
    L31:
        if (r116 >= r115) goto L33;
        ReplacementSpan r118 = (ReplacementSpan) r114[r116];
        Spanned r119 = (Spanned) r112;
        int r212 = r116;
        CharSequence r120 = r112;
        r117 = r117 + r118.getSize(getPaint(), r120, r119.getSpanStart(r118), r119.getSpanEnd(r118), getPaint().getFontMetricsInt());
        r116 = r212 + 1;
        r114 = r114;
        r112 = r112;
        r115 = r115;
        goto L31
    L33:
        r113 = r117;
    L34:
        float r121 = r108 - r113;
    L36:
        CharSequence r122 = this.f178011a;
        if (r122 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L39:
        CharSequence r213 = r122;
        int r123 = r111;
        int r124 = getPaint().breakText(r122, r111, r122.length(), true, r121, this.f178013c) + r123;
        if (r124 >= r213.length()) goto L48;
        float r125 = this.f178013c[r103];
    L43:
        if (r124 >= r213.length()) goto L48;
        int r126 = r124 + 1;
        CharSequence r127 = r213;
        r125 = r125 + getPaint().measureText(r127, r124, r126);
        if (r125 > r121) goto L48;
        r124 = r126;
        r213 = r127;
    L48:
        if (r109 != r107) goto L66;
        int r128 = r124 + 1;
        CharSequence r129 = this.f178011a;
        if (r129 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L53:
        if (r128 >= r129.length()) goto L66;
        CharSequence r130 = this.f178011a;
        if (r130 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L57:
        char r131 = r130.charAt(r124);
        if (19968 <= r131) goto L61;
    L63:
        boolean r132 = false;
    L64:
        if (r132 == false) goto L66;
        r111 = r128;
    L67:
        SpannableStringBuilder r133 = this.f178014d;
        CharSequence r134 = this.f178011a;
        if (r134 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L70:
        CharSequence r135 = r134.subSequence(r123, r111);
        r133.append(r135);
        if ((r135 instanceof Spanned) == false) goto L75;
        int r136 = r133.length();
        int r137 = r136 - r135.length();
        Object[] r138 = r133.getSpans(r137, r136, Object.class);
        int r139 = r138.length;
        int r140 = 0;
    L73:
        if (r140 >= r139) goto L75;
        Object r141 = r138[r140];
        r133.removeSpan(r141);
        Spanned r142 = (Spanned) r135;
        int r143 = r142.getSpanStart(r141);
        int r144 = r143 + r137;
        float r145 = r108;
        r133.setSpan(r141, r144, r142.getSpanEnd(r141) + r137, r142.getSpanFlags(r141));
        r140 = r140 + 1;
        r108 = r145;
    L75:
        float r146 = r108;
        CharSequence r147 = this.f178011a;
        if (r147 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L79:
        if (r111 >= r147.length()) goto L88;
        r110 = r110 + 1;
        if (r109 <= 1) goto L87;
        if (this.f178016f == false) goto L87;
        this.f178014d.append('\n');
        ForegroundColorSpan r148 = new ForegroundColorSpan(this.f178017g);
        SpannableStringBuilder r149 = this.f178014d;
        r149.setSpan(r148, r149.length() - 1, this.f178014d.length(), 33);
    L87:
        r108 = r146;
        r103 = 0;
        r107 = 1;
        goto L22
    L61:
        if (40959 < r131) goto L63;
        r132 = true;
    L66:
        r111 = r124;
        goto L67
    L35:
        r121 = r108;
    L88:
        setTextBySelf(this.f178014d);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r211);
        getLayoutParams().width = r100;
        return;
    L19:
        if ((!Intrinsics.areEqual(getText().toString(), r102.toString())) == false) goto L21;
    }

    public BreakLineFeedText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f178013c = new float[]{0.0f};
        this.f178014d = new SpannableStringBuilder();
        this.f178016f = true;
        this.f178017g = -1;
        if (this.f178011a != null) goto L6;
        this.f178011a = "";
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        if (this.f178012b == true) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        this.f178011a = r100;
        return;
    }
}
