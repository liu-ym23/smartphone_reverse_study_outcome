package com.bytedance.android.service.manager.statistics;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IPushStatisticsExternalService {
    long getValidDeviceDozeDuration(Context r100);

    long getValidDeviceKillDuration(Context r100);

    boolean isEnablePushStatistics();

    void onProcessStart();

    void onPushStart();
}
