package com.android.ttcjpaysdk.ttcjpayapi;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/ICJHostLoginCallback;", "", "onLoginCanceled", "", "data", "Landroid/os/Bundle;", "onLoginSuccess", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJHostLoginCallback {
    void onLoginCanceled(Bundle r100);

    void onLoginSuccess(Bundle r100);
}
