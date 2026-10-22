package com.android.ttcjpaysdk.base.ui.component;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.ui.component.base.StdUIbaseDraw;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u000fH\u0014J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u001a\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJMoneyTextView;", "Lcom/android/ttcjpaysdk/base/ui/component/CJTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultTextSize", "", "extraPadding", "hasMeasureExtraPadding", "", "moneyAmount", "", "moneyCurrency", "moneySize", "applyStyles", "", "formatStartPrice", "value", "getMoneyAmount", "", "getMoneyAmountString", "getTagName", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setText", "amount", "", "type", "Landroid/widget/TextView$BufferType;", "showSymbol", "currency", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJMoneyTextView extends CJTextView {
    private final float defaultTextSize;
    private int extraPadding;
    private boolean hasMeasureExtraPadding;
    private String moneyAmount;
    private String moneyCurrency;
    private float moneySize;

    public CJMoneyTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJMoneyTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.CJTextView
    public String getTagName() {
        return "CJMoney";
    }

    public final String getMoneyAmountString() {
        return formatStartPrice(this.moneyAmount);
    }

    public final double getMoneyAmount() {
        return CastDoubleProtector.parseDouble(getMoneyAmountString());
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJMoneyTextView#getMoneyAmount", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJMoneyTextView#getMoneyAmount", e);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private final void applyStyles(Context r100) {
        setTextColor(CJPayThemeUtils.getColor(r100, R.attr.cj_std_ui_component_textview_color));
        setTextSize(this.moneySize);
        setLetterSpacing(-0.02f);
    }

    private final String formatStartPrice(String r100) {
        int r101 = r100.length();
        int r102 = 0;
        String r103 = r100;
    L3:
        if (r102 >= r101) goto L9;
        char r104 = r100.charAt(r102);
        if (r104 < '0') goto L8;
        if (r104 <= '9') goto L9;
    L8:
        r102 = r102 + 1;
        r103 = r100.substring(r102, r100.length());
    L9:
        return r103;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        applyStyles(getContext());
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.CJTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        StdUIbaseDraw.INSTANCE.draw(r100, getWidth(), getHeight(), getTagName());
    }

    public final CJMoneyTextView showSymbol(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.moneyCurrency = r100;
        setText(this.moneyAmount);
        return this;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getText().length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L12:
        setMeasuredDimension(TextView.resolveSize(getMeasuredWidth() + this.extraPadding, r100), getMeasuredHeight());
        return;
    L8:
        if (this.hasMeasureExtraPadding == true) goto L12;
        if ((!StringsKt.isBlank(this.moneyCurrency)) == false) goto L12;
        this.hasMeasureExtraPadding = true;
        this.extraPadding = (int) (getPaint().measureText(String.valueOf(getText().charAt(0))) / 4);
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "amount");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        super.setText(r100, r101);
        return;
    L7:
        if ((!StringsKt.isBlank(this.moneyCurrency)) == false) goto L9;
        String r102 = this.moneyCurrency + r100;
    L10:
        this.moneyAmount = r102;
        int r103 = r102.length();
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r104 >= r103) goto L21;
        char r106 = this.moneyAmount.charAt(r104);
        if ('0' <= r106) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == true) goto L23;
        r105 = r104 + 1;
        r104 = r105;
    L23:
        if (r104 < this.moneyAmount.length()) goto L26;
        super.setText(this.moneyAmount, r101);
        return;
    L26:
        SpannableString r108 = new SpannableString(this.moneyAmount);
        r108.setSpan(new RelativeSizeSpan(0.62f), 0, r104, 17);
        super.setText(r108, r101);
        return;
    L15:
        if (r106 >= ':') goto L17;
        r107 = true;
        goto L18
    L21:
        r104 = r105;
        goto L23
    L9:
        r102 = r100.toString();
        goto L10
    }

    public CJMoneyTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.moneyAmount = "";
        this.defaultTextSize = 32.0f;
        this.moneySize = 32.0f;
        this.moneyCurrency = "";
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayMoneyCurrency, R.attr.CJPayMoneySize});
        int r104 = r103.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L13;
        int r106 = r103.getIndex(r105);
        if (r106 != 1) goto L7;
        this.moneySize = r103.getDimension(r106, this.defaultTextSize);
    L12:
        r105 = r105 + 1;
        goto L3
    L7:
        if (r106 != 0) goto L12;
        String r107 = r103.getString(r106);
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        this.moneyCurrency = r107;
        goto L12
    L13:
        r103.recycle();
        CJPayFontUtils.setDouYinMediumTypeface(r100, this);
        applyStyles(r100);
    }

    public /* synthetic */ CJMoneyTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = android.R.attr.textViewStyle;
    L8:
        this(r100, r101, r102);
    }
}
