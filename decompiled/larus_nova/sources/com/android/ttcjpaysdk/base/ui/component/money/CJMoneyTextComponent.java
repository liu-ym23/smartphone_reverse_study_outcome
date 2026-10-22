package com.android.ttcjpaysdk.base.ui.component.money;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.ui.component.base.StdUIbaseDraw;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u001a\u0010(\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\nJ\u0018\u0010-\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/money/CJMoneyTextComponent;", "Lcom/android/ttcjpaysdk/base/ui/component/money/CJScrollAnimTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "defaultTextSize", "", "extraPadding", "hasMeasureExtraPadding", "", "hasTextSize", "moneyAmount", "moneyCurrency", "moneySize", "applyStyles", "", "formatStartPrice", "value", "generateMoneyText", "", "amount", "getDisplayedAmountStringNormalized", "getTagName", "modifyExtraPadding", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setTextAnim", "setTextWithoutAnim", "type", "Landroid/widget/TextView$BufferType;", "showSymbol", "currency", "spToPx", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJMoneyTextComponent extends CJScrollAnimTextView {
    private final String TAG;
    private final float defaultTextSize;
    private int extraPadding;
    private boolean hasMeasureExtraPadding;
    private boolean hasTextSize;
    private String moneyAmount;
    private String moneyCurrency;
    private float moneySize;

    public CJMoneyTextComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJMoneyTextComponent(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final String getTagName() {
        return "CJMoney";
    }

    public final String getDisplayedAmountStringNormalized() {
        String r100 = super.getCurrentDisplayedText();     // Catch: Throwable -> L42
        if (r100.length() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L14;
        CharSequence r102 = getText();     // Catch: Throwable -> L42
        if (r102 == null) goto L12;
        r100 = r102.toString();     // Catch: Throwable -> L42
        if (r100 != null) goto L14;
    L12:
        r100 = "";
    L14:
        if (r100.length() != 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
        return "";
    L19:
        int r104 = r100.length();     // Catch: Throwable -> L42
        int r105 = 0;
    L21:
        if (r105 >= r104) goto L31;
        char r106 = r100.charAt(r105);     // Catch: Throwable -> L42
        if ('0' <= r106) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == true) goto L29;
        r105 = r105 + 1;     // Catch: Throwable -> L42
        goto L21
    L29:
        r100 = r100.substring(r105);     // Catch: Throwable -> L42
        goto L31
    L25:
        if (r106 >= ':') goto L27;
        r107 = true;
    L31:
        int r108 = StringsKt.indexOf$default(r100, '.', 0, false, 6, null);     // Catch: Throwable -> L42
        if (r108 >= 0) goto L35;
        return r100 + ".00";
    L35:
        if (r108 != (r100.length() - 1)) goto L38;
        return r100 + CustomAlbumViewModel.DEFAULT_TAB_ID;
    L38:
        if (r108 != (r100.length() - 2)) goto L51;
        return r100 + '0';
    L51:
        return r100.substring(0, r108 + 3);
    L16:
        r103 = false;
        goto L17
    L6:
        r101 = false;
    L42:
        th = move-exception;
        CJLogger.c(this.TAG, "getDisplayedAmountStringNormalized", th);
        return "";
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_money_CJMoneyTextComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void applyStyles(Context r100) {
        setTextColor(CJPayThemeUtils.getColor(r100, R.attr.cj_pay_text_primary));
        if (CJPayOptimizeSwitch.Companion.get().fontSizeOpt == true) goto L5;
        setTextSize(0, this.moneySize);
    L8:
        setLetterSpacing(-0.02f);
        return;
    L5:
        if (this.hasTextSize == true) goto L8;
        setTextSize(0, this.moneySize);
        goto L8
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

    public final CharSequence generateMoneyText(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.moneyCurrency) == true) goto L13;
        if (r100 == null) goto L10;
        boolean r101 = StringsKt.contains$default(r100, this.moneyCurrency, false, 2, null);
    L11:
        if (r101 == true) goto L13;
        String r102 = this.moneyCurrency + r100;
    L14:
        this.moneyAmount = r102;
        int r103 = r102.length();
        int r104 = 0;
        int r105 = 0;
    L15:
        if (r104 >= r103) goto L25;
        char r106 = this.moneyAmount.charAt(r104);
        if ('0' <= r106) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L27;
        r105 = r104 + 1;
        r104 = r105;
    L27:
        if (r104 >= this.moneyAmount.length()) goto L29;
        SpannableString r108 = new SpannableString(this.moneyAmount);
        r108.setSpan(new RelativeSizeSpan(0.62f), 0, r104, 17);
        return r108;
    L29:
        return this.moneyAmount;
    L19:
        if (r106 >= ':') goto L21;
        r107 = true;
        goto L22
    L25:
        r104 = r105;
        goto L27
    L10:
        r101 = false;
    L13:
        r102 = String.valueOf(r100);
        goto L14
    }

    public final void modifyExtraPadding(int r100) {
        this.extraPadding = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        applyStyles(getContext());
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.money.CJScrollAnimTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        StdUIbaseDraw.INSTANCE.draw(r100, getWidth(), getHeight(), getTagName());
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.money.CJScrollAnimTextView
    public void setTextAnim(String r100) {
        Intrinsics.checkNotNullParameter(r100, "amount");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        super.setTextAnim(generateMoneyText(r100).toString());
    }

    public final CJMoneyTextComponent showSymbol(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.moneyCurrency = r100;
        setText(this.moneyAmount);
        return this;
    }

    private final float spToPx(Context r100, float r101) {
        return TypedValue.applyDimension(2, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_money_CJMoneyTextComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    @Override // android.widget.TextView, android.view.View
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
        if (TextUtils.isEmpty(this.moneyCurrency) == true) goto L12;
        this.hasMeasureExtraPadding = true;
        this.extraPadding = (int) (getPaint().measureText(String.valueOf(getText().charAt(0))) / 4);
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public final void setTextWithoutAnim(CharSequence r100, TextView.BufferType r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        super.setTextWithoutAnim(generateMoneyText(r100).toString());
    }

    public CJMoneyTextComponent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = spToPx(r100, 32.0f);
        this.defaultTextSize = r103;
        this.moneySize = r103;
        this.moneyAmount = "";
        this.moneyCurrency = "";
        this.TAG = "CJMoneyTextComponent";
        int r104 = 0;
        if (CJPayOptimizeSwitch.Companion.get().fontSizeOpt == false) goto L11;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textSize});
        if (r105.getIndexCount() > 0) goto L7;
    L9:
        boolean r106 = false;
    L10:
        r105.recycle();
        this.hasTextSize = r106;
        goto L11
    L7:
        if (r105.hasValue(0) == false) goto L9;
        r106 = true;
    L11:
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayMoneyCurrency, R.attr.CJPayMoneySize});
        int r108 = r107.getIndexCount();
    L12:
        if (r104 >= r108) goto L22;
        int r109 = r107.getIndex(r104);
        if (r109 != 1) goto L16;
        this.moneySize = r107.getDimension(r109, this.defaultTextSize);
    L21:
        r104 = r104 + 1;
        goto L12
    L16:
        if (r109 != 0) goto L21;
        String r110 = r107.getString(r109);
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        this.moneyCurrency = r110;
        goto L21
    L22:
        r107.recycle();
        CJPayFontUtils.setDouYinMediumTypeface(r100, this);
        applyStyles(r100);
    }

    public /* synthetic */ CJMoneyTextComponent(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = android.R.attr.textViewStyle;
    L8:
        this(r100, r101, r102);
    }
}
