package com.android.server;

import android.content.Context;
import android.os.IVold;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
public interface IObricStorageManagerService extends IObricBase {
    default void serviceKeyInit(Context context, IVold vold, int serviceId, int userId, byte[] secret) {
    }

    default void serviceKeyDelete(Context context, IVold vold, int serviceId, int userId) {
    }

    default void serviceLockStorage(Context context, IVold vold, int serviceId, int userId) {
    }

    default void serviceUnlockStorage(Context context, IVold vold, int serviceId, int userId, byte[] secret) {
    }
}
