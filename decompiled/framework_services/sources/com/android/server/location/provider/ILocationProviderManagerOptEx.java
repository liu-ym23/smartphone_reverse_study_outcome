package com.android.server.location.provider;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface ILocationProviderManagerOptEx {
    default void init(LocationProviderManager manager, Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean checkUidFreeze(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
