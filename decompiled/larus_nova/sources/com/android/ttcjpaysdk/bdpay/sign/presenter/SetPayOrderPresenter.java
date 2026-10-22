package com.android.ttcjpaysdk.bdpay.sign.presenter;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bdpay.sign.bean.PayTypeItem;
import com.android.ttcjpaysdk.bdpay.sign.model.SignModel;
import com.android.ttcjpaysdk.bdpay.sign.view.ISetPayOrderView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\fJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/presenter/SetPayOrderPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bdpay/sign/model/SignModel;", "Lcom/android/ttcjpaysdk/bdpay/sign/view/ISetPayOrderView;", "()V", "queryPayList", "", "appId", "", "merchantId", "supportPayType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setPayOrder", "payTypeItem", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetPayOrderPresenter extends BasePresenter<SignModel, ISetPayOrderView> {
    public SetPayOrderPresenter() {
    }

    public final void queryPayList(String r100, String r101, ArrayList<String> r110) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "scene", "withhold");
        KtSafeMethodExtensionKt.safePut(r102, "trade_scene", "withholding_sign");
        KtSafeMethodExtensionKt.safePut(r102, "support_pay_type", KtSafeMethodExtensionKt.toJsonArray(r110));
        SignModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.request("bytepay.member_product.query_member_pay_list", r102, r100, r101, new AnonymousClass1(this));
        return;
    }

    public final void setPayOrder(String r100, String r101, PayTypeItem r110) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "payTypeItem");
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "pay_type_item", CJPayJsonParser.toJsonObject(r110));
        SignModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.request("bytepay.member_product.set_member_first_pay_type", r102, r100, r101, new C91061(this));
        return;
    }
}
