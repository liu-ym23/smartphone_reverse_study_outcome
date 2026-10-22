package com.android.ttcjpaysdk.integrated.counter.game.wrapper;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/CustomerServiceWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCustomerServiceBack", "Landroid/widget/ImageView;", "mCustomerServiceCall", "Landroid/widget/TextView;", "mCustomerServiceContent", "mCustomerServiceCopy", "mCustomerServiceQQ", "mCustomerServiceQQLayout", "Landroid/widget/LinearLayout;", "mCustomerServiceTel", "mCustomerServiceTelLayout", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerServiceWrapper extends BaseWrapper {
    public final ImageView mCustomerServiceBack;
    public final TextView mCustomerServiceCall;
    public final TextView mCustomerServiceContent;
    public final TextView mCustomerServiceCopy;
    public final TextView mCustomerServiceQQ;
    public final LinearLayout mCustomerServiceQQLayout;
    public final TextView mCustomerServiceTel;
    public final LinearLayout mCustomerServiceTelLayout;

    public CustomerServiceWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.mCustomerServiceTelLayout = (LinearLayout) r100.findViewById(R.id.cj_pay_customer_service_tel_layout);
        this.mCustomerServiceQQLayout = (LinearLayout) r100.findViewById(R.id.cj_pay_customer_service_qq_layout);
        this.mCustomerServiceContent = (TextView) r100.findViewById(R.id.cj_pay_customer_service_content);
        this.mCustomerServiceTel = (TextView) r100.findViewById(R.id.cj_pay_customer_service_tel);
        this.mCustomerServiceQQ = (TextView) r100.findViewById(R.id.cj_pay_customer_service_qq);
        this.mCustomerServiceCall = (TextView) r100.findViewById(R.id.cj_pay_customer_service_tel_call);
        this.mCustomerServiceCopy = (TextView) r100.findViewById(R.id.cj_pay_customer_service_qq_copy);
        this.mCustomerServiceBack = (ImageView) r100.findViewById(R.id.cj_pay_customer_service_back_view);
        hide();
    }
}
