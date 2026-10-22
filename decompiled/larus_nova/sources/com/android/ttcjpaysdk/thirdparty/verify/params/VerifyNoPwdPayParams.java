package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\nH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNoPwdPayParams;", "", "getNoPwdPayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "getNoPwdPayStyle", "", "getPayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "getShowNoPwdButton", "getSkipNoPwdConfirm", "", "getTradeNo", "", "getUid", "isLiveCounter", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyNoPwdPayParams {
    CJPayNoPwdPayInfo getNoPwdPayInfo();

    int getNoPwdPayStyle();

    CJPayPayInfo getPayInfo();

    int getShowNoPwdButton();

    boolean getSkipNoPwdConfirm();

    String getTradeNo();

    String getUid();

    boolean isLiveCounter();
}
