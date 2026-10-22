package com.android.ttcjpaysdk.ttcjpayapi;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallbackWithId;", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", "onResult", "", "code", "", "msg", "", "callbackId", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IH5PayCallbackWithId extends IH5PayCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onResult(IH5PayCallbackWithId r100, int r101, String r102) {
            r100.onResult(r101, r102, -1);
        }
    }

    @Override // com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback
    void onResult(int r100, String r101);

    void onResult(int r100, String r101, int r102);
}
