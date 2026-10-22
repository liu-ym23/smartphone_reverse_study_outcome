package com.bytedance.android.livehostapi.business.shareinter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/EmptyLiveSharePackageWrapper;", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveSharePackageWrapper;", "()V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptyLiveSharePackageWrapper implements LiveSharePackageWrapper {
    public static final EmptyLiveSharePackageWrapper INSTANCE = null;

    private EmptyLiveSharePackageWrapper() {
    }

    static {
        INSTANCE = new EmptyLiveSharePackageWrapper();
    }
}
