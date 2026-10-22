package com.bytedance.server.security;

import android.content.Context;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface IBDSecurityPlugin {

    public interface Creator {
        IBDSecurityPlugin createPlugin(Context r1);

        String getPermission();

        boolean isEnable();
    }

    IBinder asBinder();

    void onStart();

    void onStop();
}
