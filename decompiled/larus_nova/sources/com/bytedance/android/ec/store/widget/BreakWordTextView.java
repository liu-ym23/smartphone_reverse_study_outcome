package com.bytedance.android.ec.store.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/store/widget/BreakWordTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextBySelf", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BreakWordTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f48972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f48974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpannableStringBuilder f48975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f48976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f48977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f48978g;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void requestLayout() {
        if (this.f48978g == true) goto L6;
        super.requestLayout();
        return;
    }

    public final void x() {
        int r100 = 0;
        if (this.f48976e.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f48973b = true;
        this.f48978g = true;
        float r102 = (this.f48977f - getPaddingLeft()) - getPaddingRight();
        CharSequence r103 = this.f48976e;
        this.f48975d.clear();
        this.f48975d.clearSpans();
        int r110 = TextViewCompat.getMaxLines(this);
        int r111 = 0;
        int r112 = 0;
    L9:
        if (r111 >= r110) goto L41;
        if (r111 != 0) goto L19;
        float r104 = 0.0f;
        if ((r103 instanceof Spanned) == false) goto L18;
        Object[] r113 = ((Spanned) r103).getSpans(r100, r103.length(), ReplacementSpan.class);
        int r114 = r113.length;
        int r105 = 0;
        float r115 = 0.0f;
    L15:
        if (r105 >= r114) goto L17;
        ReplacementSpan r106 = (ReplacementSpan) r113[r105];
        Spanned r107 = (Spanned) r103;
        r115 = r115 + r106.getSize(getPaint(), r103, r107.getSpanStart(r106), r107.getSpanEnd(r106), getPaint().getFontMetricsInt());
        r105 = r105 + 1;
        goto L15
    L17:
        r104 = r115;
    L18:
        float r116 = r102 - r104;
    L20:
        int r108 = getPaint().breakText(r103, r112, r103.length(), true, r116, this.f48974c) + r112;
        if (r108 >= r103.length()) goto L29;
        float r109 = this.f48974c[r100];
    L24:
        if (r108 >= r103.length()) goto L29;
        int r117 = r108 + 1;
        r109 = r109 + getPaint().measureText(r103, r108, r117);
        if (r109 > r116) goto L29;
        r108 = r117;
    L29:
        SpannableStringBuilder r118 = this.f48975d;
        CharSequence r119 = r103.subSequence(r112, r108);
        r118.append(r119);
        if ((r119 instanceof Spanned) == false) goto L35;
        int r120 = r118.length();
        int r121 = r120 - r119.length();
        Object[] r122 = r118.getSpans(r121, r120, Object.class);
        int r123 = r122.length;
        int r124 = 0;
    L32:
        if (r124 >= r123) goto L35;
        Object r125 = r122[r124];
        r118.removeSpan(r125);
        Spanned r126 = (Spanned) r119;
        int r127 = r126.getSpanStart(r125);
        r118.setSpan(r125, r127 + r121, r126.getSpanEnd(r125) + r121, r126.getSpanFlags(r125));
        r124 = r124 + 1;
    L35:
        if (r108 >= r103.length()) goto L41;
        if (r111 >= (r110 - 1)) goto L40;
        this.f48975d.append('\n');
    L40:
        r111 = r111 + 1;
        r112 = r108;
        r100 = 0;
        goto L9
    L19:
        r116 = r102;
    L41:
        setText(this.f48975d);
        this.f48978g = false;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public BreakWordTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f48974c = new float[]{0.0f};
        this.f48975d = new SpannableStringBuilder();
        this.f48976e = "";
        if (this.f48972a != null) goto L6;
        this.f48972a = "";
        return;
    }

    private final void setTextBySelf(CharSequence r100) {
        this.f48973b = true;
        setText(r100);
        this.f48973b = false;
    }

    public BreakWordTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f48974c = new float[]{0.0f};
        this.f48975d = new SpannableStringBuilder();
        this.f48976e = "";
        if (this.f48972a != null) goto L6;
        this.f48972a = "";
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f48977f == getMeasuredWidth()) goto L6;
        this.f48977f = getMeasuredWidth();
        x();
        super.onMeasure(r100, r101);
        return;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
        if (this.f48973b == false) goto L5;
        this.f48973b = false;
        return;
    L5:
        if (r100 == null) goto L9;
        this.f48976e = r100;
        x();
        return;
    }

    public BreakWordTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48974c = new float[]{0.0f};
        this.f48975d = new SpannableStringBuilder();
        this.f48976e = "";
        if (this.f48972a != null) goto L6;
        this.f48972a = "";
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
    }
}
