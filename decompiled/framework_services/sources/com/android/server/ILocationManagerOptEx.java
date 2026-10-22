package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;
import com.android.server.location.LocationManagerService;

/* JADX INFO: loaded from: classes.dex */
public interface ILocationManagerOptEx {
    default void init(LocationManagerService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void init(LocationManagerService service, Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean checkUidFreeze(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
