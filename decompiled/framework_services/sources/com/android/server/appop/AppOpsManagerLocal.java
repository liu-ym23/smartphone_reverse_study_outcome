package com.android.server.appop;

import android.annotation.SystemApi;

/* JADX INFO: loaded from: classes.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface AppOpsManagerLocal {
    boolean isUidInForeground(int r1);
}
