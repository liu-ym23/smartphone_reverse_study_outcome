package com.bytedance.android.ec.store.search.cropped;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/search/cropped/ShopCroppedRouterParams;", "Ljava/io/Serializable;", "()V", "initScreenStatus", "", "getInitScreenStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopCroppedRouterParams implements Serializable {
    private final Integer initScreenStatus;

    public ShopCroppedRouterParams() {
        this.initScreenStatus = 0;
    }

    public final Integer getInitScreenStatus() {
        return this.initScreenStatus;
    }
}
