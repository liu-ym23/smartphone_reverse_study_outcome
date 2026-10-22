package com.android.server;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IBoostNetwork {
    void boostNetworkInternal(ApplicationInfo r1);

    void handleBoostNetwork();

    void init(Context r1);
}
