package com.android.server.net;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkManagementServiceOptEx {
    default void init(Context context, NetworkManagementService managementService) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateUidNetworkAccessPreviledge() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
