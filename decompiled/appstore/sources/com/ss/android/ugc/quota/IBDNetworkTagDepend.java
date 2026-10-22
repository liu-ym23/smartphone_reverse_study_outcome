package com.ss.android.ugc.quota;

import androidx.annotation.Nullable;
import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;

/* JADX INFO: loaded from: classes4.dex */
public interface IBDNetworkTagDepend {
    boolean enable();

    boolean isNewInstall();

    @Nullable
    IBDNetworkLaunchMonitor launchMonitor();

    void onLaunchTypeUpdate(int r10);
}
