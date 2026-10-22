package com.android.ttcjpaysdk.bdpay.paymentmethod.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.MethodPayTypeInfo;
import com.android.ttcjpaysdk.bdpay.paymentmethod.utils.PaymentMethodUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/ui/CJPayPaymentSelectView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutId", "", "(Landroid/content/Context;I)V", "arrowView", "Landroid/widget/ImageView;", "tickView", "initView", "", "info", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPaymentSelectView extends FrameLayout {
    private ImageView arrowView;
    private ImageView tickView;

    public CJPayPaymentSelectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_select_layout, this, true);
    }

    public final void initView(MethodPayTypeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.tickView = (ImageView) findViewById(R.id.iv_tick);
        this.arrowView = (ImageView) findViewById(R.id.iv_arrow);
        int r101 = 4;
        if (r100.isEnable() == true) goto L13;
        ImageView r102 = this.arrowView;
        if (r102 == null) goto L8;
        r102.setVisibility(4);
    L8:
        ImageView r103 = this.tickView;
        if (r103 == null) goto L98;
        r103.setVisibility(4);
        return;
    L98:
        return;
    L13:
        String r104 = r100.getPaymentType();
        switch(r104.hashCode()) {
            case -1787710669: goto L84;
            case -1581701048: goto L81;
            case -1184259671: goto L78;
            case -563976606: goto L47;
            case -339185956: goto L44;
            case -159369463: goto L23;
            case -127611052: goto L20;
            case 3107561: goto L17;
            default: goto L104;
        };
    L104:
        return;
    L17:
        if (r104.equals(PaymentMethodUtils.ECNY) == false) goto L105;
    L86:
        ImageView r105 = this.arrowView;
        if (r105 == null) goto L90;
        r105.setVisibility(4);
    L90:
        ImageView r106 = this.tickView;
        if (r106 != null) goto L94;
        return;
    L94:
        if (r100.getChoose() == false) goto L96;
        r101 = 0;
    L96:
        r106.setVisibility(r101);
        return;
    L105:
        return;
    L20:
        if (r104.equals("new_bank_card") == true) goto L26;
        return;
    L26:
        if (r100.getChoose() == false) goto L35;
        ImageView r107 = this.arrowView;
        if (r107 == null) goto L31;
        r107.setVisibility(4);
    L31:
        ImageView r108 = this.tickView;
        if (r108 == null) goto L108;
        r108.setVisibility(0);
        return;
    L108:
        return;
    L35:
        ImageView r109 = this.arrowView;
        if (r109 == null) goto L39;
        r109.setVisibility(0);
    L39:
        ImageView r110 = this.tickView;
        if (r110 == null) goto L109;
        r110.setVisibility(4);
        return;
    L109:
        return;
    L23:
        if (r104.equals("combinepay") == true) goto L26;
        return;
    L44:
        if (r104.equals("balance") == true) goto L86;
        return;
    L47:
        if (r104.equals("credit_pay") == true) goto L50;
        return;
    L50:
        if (r100.getChoose() == false) goto L60;
        ImageView r111 = this.arrowView;
        if (r111 == null) goto L55;
        r111.setVisibility(4);
    L55:
        ImageView r112 = this.tickView;
        if (r112 == null) goto L112;
        r112.setVisibility(0);
        return;
    L112:
        return;
    L60:
        if (r100.is_credit_activate() == true) goto L69;
        ImageView r113 = this.arrowView;
        if (r113 == null) goto L65;
        r113.setVisibility(0);
    L65:
        ImageView r114 = this.tickView;
        if (r114 == null) goto L113;
        r114.setVisibility(4);
        return;
    L113:
        return;
    L69:
        ImageView r115 = this.arrowView;
        if (r115 == null) goto L73;
        r115.setVisibility(4);
    L73:
        ImageView r116 = this.tickView;
        if (r116 == null) goto L114;
        r116.setVisibility(4);
        return;
    L114:
        return;
    L78:
        if (r104.equals("income") == true) goto L86;
        return;
    L81:
        if (r104.equals("share_pay") == true) goto L86;
        return;
    L84:
        if (r104.equals("bank_card") == true) goto L86;
    }

    public CJPayPaymentSelectView(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(r101, this, true);
    }
}
