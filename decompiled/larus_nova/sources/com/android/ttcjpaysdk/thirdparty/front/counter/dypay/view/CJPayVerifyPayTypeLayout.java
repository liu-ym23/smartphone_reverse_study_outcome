package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.component.agreement.CJRowSwitchText;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseConstant;
import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog.BankCardPointSelectionInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog.CJPayPaymentMethodLayoutData;
import com.android.ttcjpaysdk.thirdparty.utils.CJPayImageLoadUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020&H\u0002J\u000e\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020#J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0012J*\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020#2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&022\f\u00103\u001a\b\u0012\u0004\u0012\u00020&02J\u001c\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u00010\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/view/CJPayVerifyPayTypeLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIv", "Landroid/widget/ImageView;", "bankCardPointSelection", "Lcom/android/ttcjpaysdk/base/ui/component/agreement/CJRowSwitchText;", "combineLayout", "Landroid/widget/LinearLayout;", "combinedCardClickLayout", "ivCombineCardArrow", "onBankCardPointSwitchListener", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/view/OnBankCardPointSwitchListener;", "payIconIv", "payTypeClickLayout", "payTypeLayout", "Landroid/view/View;", "payTypeRootLayout", "paymentInfoTv", "Landroid/widget/TextView;", "paymentLinearLayout", "Landroid/view/ViewGroup;", "paymentNameTv", "subPayTypeTv", "tvBalancePayAmount", "tvBalanceType", "tvBankcardPayAmount", "tvBankcardType", "bankPointIsChecked", "", "getBankCardPointTipsView", "init", "", "methodInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData;", "initUnableToSwitchMethod", "refreshWithNewData", "setBankCardPointChecked", "isChecked", "setBankCardPointSwitchListener", "listener", "setSwitchEnabled", "enabled", "onPayTypeClick", "Lkotlin/Function0;", "onCombineCardClick", "setTextWithSpan", "textView", "content", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayVerifyPayTypeLayout extends FrameLayout {
    private final ImageView arrowIv;
    private CJRowSwitchText bankCardPointSelection;
    private LinearLayout combineLayout;
    private final LinearLayout combinedCardClickLayout;
    private ImageView ivCombineCardArrow;
    private OnBankCardPointSwitchListener onBankCardPointSwitchListener;
    private final ImageView payIconIv;
    private final LinearLayout payTypeClickLayout;
    private final View payTypeLayout;
    private final View payTypeRootLayout;
    private final TextView paymentInfoTv;
    private final ViewGroup paymentLinearLayout;
    private final TextView paymentNameTv;
    private final TextView subPayTypeTv;
    private TextView tvBalancePayAmount;
    private TextView tvBalanceType;
    private TextView tvBankcardPayAmount;
    private TextView tvBankcardType;

    public CJPayVerifyPayTypeLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayVerifyPayTypeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void initUnableToSwitchMethod() {
        CJPayViewExtensionsKt.viewGone(this.arrowIv);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.combineLayout, null, null, 0, null, 11, null);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.paymentInfoTv, null, null, 0, null, 11, null);
        CJPayViewExtensionsKt.viewGone(this.ivCombineCardArrow);
    }

    public final boolean bankPointIsChecked() {
        return this.bankCardPointSelection.isChecked();
    }

    public final View getBankCardPointTipsView() {
        CJRowSwitchText r100 = this.bankCardPointSelection;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTipsView();
    }

    public static final /* synthetic */ CJRowSwitchText access$getBankCardPointSelection$p(CJPayVerifyPayTypeLayout r100) {
        return r100.bankCardPointSelection;
    }

    public static final /* synthetic */ OnBankCardPointSwitchListener access$getOnBankCardPointSwitchListener$p(CJPayVerifyPayTypeLayout r100) {
        return r100.onBankCardPointSwitchListener;
    }

    public final void init(CJPayPaymentMethodLayoutData r100) {
        Intrinsics.checkNotNullParameter(r100, "methodInfo");
        BankCardPointSelectionInfo r101 = r100.getBankCardPointSelectionInfo();
        if (r101 == null) goto L6;
        this.bankCardPointSelection.setLeftContentText(r101.getLeftTitle());
        this.bankCardPointSelection.setTipsText(r101.getRightTitle());
        this.bankCardPointSelection.setChecked(r101.isChecked());
        this.bankCardPointSelection.setTipsTextVisible(r101.isChecked());
        this.bankCardPointSelection.setOnSwitchChangeListener(new CJPayVerifyPayTypeLayout$init$1$1(this));
        CJPayViewExtensionsKt.viewVisible(this.bankCardPointSelection);
        return;
    }

    public final void refreshWithNewData(CJPayPaymentMethodLayoutData r100) {
        Intrinsics.checkNotNullParameter(r100, "methodInfo");
        if ((r100 instanceof CJPayPaymentMethodLayoutData.TwoMethodData) == false) goto L10;
        CJPayViewExtensionsKt.viewGone(this.payIconIv);
        TextView r101 = this.subPayTypeTv;
        Context r102 = getContext();
        if (r102 == null) goto L7;
        String r103 = r102.getString(R.string.cj_pay_combine_pay_method);
    L8:
        r101.setText(r103);
        CJPayViewExtensionsKt.viewGone(this.paymentLinearLayout);
        CJPayViewExtensionsKt.viewVisible(this.combineLayout);
        CJPayPaymentMethodLayoutData.TwoMethodData r104 = (CJPayPaymentMethodLayoutData.TwoMethodData) r100;
        CJPayViewExtensionsKt.setTextAndVisible(this.tvBalanceType, r104.getTitle1());
        setTextWithSpan(this.tvBalancePayAmount, r104.getDesc1());
        CJPayViewExtensionsKt.setTextAndVisible(this.tvBankcardType, r104.getTitle2());
        setTextWithSpan(this.tvBankcardPayAmount, r104.getDesc2());
    L21:
        BankCardPointSelectionInfo r105 = r100.getBankCardPointSelectionInfo();
        if (r105 != null) goto L24;
        return;
    L24:
        if ((r100 instanceof CJPayPaymentMethodLayoutData.TwoMethodData) == false) goto L26;
        CJPayViewExtensionsKt.setTopMargin(this.bankCardPointSelection, CJPayBasicExtensionKt.dip2px(6.0f, getContext()));
        this.bankCardPointSelection.setLeftContentColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_tertiary));
        this.bankCardPointSelection.setTipsColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_secondary));
        this.bankCardPointSelection.setTipsSize(13);
        this.bankCardPointSelection.setLeftContentSize(13);
    L27:
        this.bankCardPointSelection.setLeftContentText(r105.getLeftTitle());
        this.bankCardPointSelection.setTipsText(r105.getRightTitle());
        this.bankCardPointSelection.setOnSwitchChangeListener(new CJPayVerifyPayTypeLayout$refreshWithNewData$1$1(this));
        CJPayViewExtensionsKt.viewVisible(this.bankCardPointSelection);
        return;
    L26:
        CJPayViewExtensionsKt.setTopMargin(this.bankCardPointSelection, CJPayBasicExtensionKt.dip2px(12.0f, getContext()));
        this.bankCardPointSelection.setLeftContentColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_secondary));
        this.bankCardPointSelection.setTipsColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_secondary));
        this.bankCardPointSelection.setTipsSize(14);
        this.bankCardPointSelection.setLeftContentSize(14);
        goto L27
    L7:
        r103 = null;
        goto L8
    L10:
        if ((r100 instanceof CJPayPaymentMethodLayoutData.SingleMethodData) == false) goto L21;
        CJPayPaymentMethodLayoutData.SingleMethodData r106 = (CJPayPaymentMethodLayoutData.SingleMethodData) r100;
        CJPayImageLoadUtils.loadImage(r106.getAssetIconUrl(), this.payIconIv);
        CJPayViewExtensionsKt.setTextAndVisible(this.subPayTypeTv, r106.getAssetText());
        String r107 = r106.getSubtitle();
        boolean r108 = false;
        if (r107 != null) goto L14;
    L19:
        if (r108 == false) goto L21;
        CJPayViewExtensionsKt.setTextAndVisible(this.paymentInfoTv, r106.getSubtitle());
        CJPayViewExtensionsKt.setTextAndVisible(this.paymentNameTv, r106.getSubDescTitle());
        CJPayViewExtensionsKt.viewVisible(this.paymentLinearLayout);
        goto L21
    L14:
        if (r107.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 != true) goto L19;
        r108 = true;
        goto L19
    L16:
        r109 = false;
        goto L17
    }

    public final void setBankCardPointChecked(boolean r100) {
        this.bankCardPointSelection.setChecked(r100);
    }

    public final void setBankCardPointSwitchListener(OnBankCardPointSwitchListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.onBankCardPointSwitchListener = r100;
    }

    private final void setTextWithSpan(TextView r100, String r110) {
        if (r110 == null) goto L5;
        List r101 = StringsKt.split$default(r110, new String[]{"$"}, false, 0, 6, null);
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L11:
        if (r110 != null) goto L13;
        r110 = "";
    L13:
        if (r100 != null) goto L15;
        return;
    L15:
        if (r110 != null) goto L17;
    L20:
        if (r102 == false) goto L23;
        return;
    L23:
        if (StringsKt.contains$default(r110, CJPayBaseConstant.CJ_PAY_TYPE_PAY, false, 2, null) == true) goto L25;
        r110 = "支付 " + r110;
    L25:
        SpannableString r103 = new SpannableString(r110);
        r103.setSpan(new ForegroundColorSpan(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_tertiary)), 0, 2, 18);
        r100.setText(r103);
        CJPayViewExtensionsKt.viewVisible(r100);
        return;
    L17:
        if (r110.length() == 0) goto L20;
        r102 = false;
        goto L20
    L9:
        if (r101.size() <= 2) goto L11;
        r110 = (String) ListProtector.get(r101, 1);
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public CJPayVerifyPayTypeLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_payment_method_info_layout, this);
        this.payTypeLayout = findViewById(R.id.cj_pay_combine_type_layout);
        this.payTypeRootLayout = findViewById(R.id.cj_pay_view_pay_type_combine_layout);
        this.paymentLinearLayout = (ViewGroup) findViewById(R.id.cj_pay_ll_payment);
        this.paymentInfoTv = (TextView) findViewById(R.id.cj_pay_tv_payment_info);
        this.paymentNameTv = (TextView) findViewById(R.id.cj_pay_tv_payment_name);
        this.arrowIv = (ImageView) findViewById(R.id.cj_pay_iv_arrow);
        this.payTypeClickLayout = (LinearLayout) findViewById(R.id.cj_pay_type_click_layout);
        this.combinedCardClickLayout = (LinearLayout) findViewById(R.id.cj_pay_combine_card_click_layout);
        this.combineLayout = (LinearLayout) findViewById(R.id.cj_pay_combine_pay_layout);
        this.ivCombineCardArrow = (ImageView) findViewById(R.id.cj_pay_combine_change_arrow);
        this.payIconIv = (ImageView) findViewById(R.id.cj_pay_iv_pay_icon);
        this.subPayTypeTv = (TextView) findViewById(R.id.cj_pay_tv_sub_pay_type);
        this.tvBalanceType = (TextView) findViewById(R.id.cj_pay_combine_balance_type);
        this.tvBalancePayAmount = (TextView) findViewById(R.id.cj_pay_combine_balance_amount);
        this.tvBankcardType = (TextView) findViewById(R.id.cj_pay_combine_card_type);
        this.tvBankcardPayAmount = (TextView) findViewById(R.id.cj_pay_combine_card_amount);
        this.bankCardPointSelection = (CJRowSwitchText) findViewById(R.id.cj_pay_bank_card_points_selection);
        initUnableToSwitchMethod();
    }

    public final void setSwitchEnabled(boolean r110, final Function0<Unit> r210, final Function0<Unit> r211) {
        Intrinsics.checkNotNullParameter(r210, "onPayTypeClick");
        Intrinsics.checkNotNullParameter(r211, "onCombineCardClick");
        if (r110 == true) goto L6;
        CJPayViewExtensionsKt.viewGone(this.arrowIv);
        CJPayViewExtensionsKt.viewGone(this.ivCombineCardArrow);
        this.payTypeClickLayout.setOnClickListener(null);
        this.combinedCardClickLayout.setOnClickListener(null);
        this.payTypeClickLayout.setClickable(false);
        this.combinedCardClickLayout.setClickable(false);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.combineLayout, null, null, 0, null, 11, null);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.paymentInfoTv, null, null, 0, null, 11, null);
        return;
    L6:
        CJPayViewExtensionsKt.viewVisible(this.arrowIv);
        CJPayViewExtensionsKt.viewVisible(this.ivCombineCardArrow);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.combineLayout, null, null, null, null, 15, null);
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.paymentInfoTv, null, null, null, null, 15, null);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.payTypeClickLayout, new AnonymousClass1(r210));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.combinedCardClickLayout, new AnonymousClass2(r211));
    }

    public /* synthetic */ CJPayVerifyPayTypeLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
