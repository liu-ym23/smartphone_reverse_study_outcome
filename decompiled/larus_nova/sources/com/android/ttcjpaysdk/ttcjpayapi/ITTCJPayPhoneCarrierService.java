package com.android.ttcjpaysdk.ttcjpayapi;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/ITTCJPayPhoneCarrierService;", "", "getAuthToken", "", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/OnTTCJPayAuthTokenResult;", "getCurrentPhoneCarrier", "", "getMaskedPhoneInfo", "Lcom/android/ttcjpaysdk/ttcjpayapi/OnTTCJPayMaskedPhoneResult;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITTCJPayPhoneCarrierService {
    void getAuthToken(OnTTCJPayAuthTokenResult r100);

    String getCurrentPhoneCarrier();

    void getMaskedPhoneInfo(OnTTCJPayMaskedPhoneResult r100);
}
