package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyPayAgainParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "getIsFromFrontMethod", "", "getIsFromPayAgainGuide", "getIsPayAgainGuideDialog", "getIsPayAgainScene", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyPayAgainParams extends CJPayObject {
    boolean getIsFromFrontMethod();

    boolean getIsFromPayAgainGuide();

    boolean getIsPayAgainGuideDialog();

    boolean getIsPayAgainScene();
}
