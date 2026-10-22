package com.android.ttcjpaysdk.kmp.base.location;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/location/IKmpCJLocationService;", "Lcom/bytedance/kmp/spi/IKmpService;", "startLocationSubscription", "", "getLatestLocationInfoJson", "", "registerLocationCallback", "callback", "Lcom/android/ttcjpaysdk/kmp/base/location/IKmpCJLocationServiceCallback;", "code", "unregisterLocationCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLocationService extends a {
    String getLatestLocationInfoJson();

    void registerLocationCallback(IKmpCJLocationServiceCallback r100, String r101);

    void startLocationSubscription();

    void unregisterLocationCallback(IKmpCJLocationServiceCallback r100, String r101);
}
