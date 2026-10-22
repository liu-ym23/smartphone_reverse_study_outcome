package com.android.ttcjpaysdk.thirdparty.verify.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/base/DoubleConfirmCountdownManager;", "", "isGlobalCountdownFinish", "", "()Z", "initCountdownFromCheckoutResponse", "", "removeCountdownTickListener", "listener", "Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyBaseManager$OnCountdownTickListener;", "setCountdownTickListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DoubleConfirmCountdownManager {
    void initCountdownFromCheckoutResponse();

    boolean isGlobalCountdownFinish();

    void removeCountdownTickListener(VerifyBaseManager.OnCountdownTickListener r100);

    void setCountdownTickListener(VerifyBaseManager.OnCountdownTickListener r100);
}
