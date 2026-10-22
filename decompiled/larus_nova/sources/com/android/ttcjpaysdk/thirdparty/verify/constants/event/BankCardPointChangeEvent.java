package com.android.ttcjpaysdk.thirdparty.verify.constants.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/constants/event/BankCardPointChangeEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "checkedState", "", "assetUniqueId", "", "(ZLjava/lang/String;)V", "getAssetUniqueId", "()Ljava/lang/String;", "getCheckedState", "()Z", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BankCardPointChangeEvent extends BaseEvent {
    private final String assetUniqueId;
    private final boolean checkedState;

    public final String getAssetUniqueId() {
        return this.assetUniqueId;
    }

    public final boolean getCheckedState() {
        return this.checkedState;
    }

    public BankCardPointChangeEvent(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "assetUniqueId");
        this.checkedState = r100;
        this.assetUniqueId = r101;
    }
}
