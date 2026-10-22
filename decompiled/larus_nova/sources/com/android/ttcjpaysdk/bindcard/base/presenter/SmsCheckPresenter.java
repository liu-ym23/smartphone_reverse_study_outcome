package com.android.ttcjpaysdk.bindcard.base.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseContract;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseModel;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/presenter/SmsCheckPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseModel;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseContract$ISmsView;", "()V", "checkSMSForBindCard", "", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "smsCode", "", "smsToken", "sendSMSForBindCard", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmsCheckPresenter extends BasePresenter<BindCardBaseModel, BindCardBaseContract.ISmsView> {
    public SmsCheckPresenter() {
    }

    public final void sendSMSForBindCard(CJPayRealNameBean r100) {
        BindCardBaseModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.sendSMSForBindCard(r100, new C91191(this));
        return;
    }

    public final void checkSMSForBindCard(CJPayRealNameBean r100, String r101, String r102) {
        BindCardBaseModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.checkSMSForBindCard(r100, r101, r102, new AnonymousClass1(this));
        return;
    }
}
