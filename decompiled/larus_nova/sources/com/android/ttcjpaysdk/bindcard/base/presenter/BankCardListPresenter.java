package com.android.ttcjpaysdk.bindcard.base.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseContract;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseModel;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayAuthInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNameAndIdentifyCodeBillBean;
import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class BankCardListPresenter extends BasePresenter<BindCardBaseModel, BindCardBaseContract.BankCardListView> {
    public BankCardListPresenter() {
    }

    public void createBindCardOrder(Map<String, String> r100, final QuickBindCardAdapterBean r101) {
        getModel().memberCreateBizOrder(r100, new AnonymousClass2(this, r101));
    }

    public void createTwoElementAuthOrder(Map<String, String> r100, final QuickBindCardAdapterBean r101) {
        getModel().memberCreateBizOrder(r100, new AnonymousClass1(this, r101));
    }

    public void twoElementAuth(final CJPayNameAndIdentifyCodeBillBean r100, final QuickBindCardAdapterBean r101) {
        BindCardBaseModel r102 = getModel();
        String r103 = r100.member_biz_order_no;
        CJPayAuthInfo r104 = r100.busi_authorize_info.busi_auth_info;
        r102.nameAndIdentifyCodeVerify(r103, r104.id_name_mask, r104.id_type, r104.id_code_mask, new AnonymousClass3(this, r101, r100));
    }
}
