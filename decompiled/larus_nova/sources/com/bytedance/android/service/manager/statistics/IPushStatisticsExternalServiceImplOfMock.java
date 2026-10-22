package com.bytedance.android.service.manager.statistics;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class IPushStatisticsExternalServiceImplOfMock implements IPushStatisticsExternalService {
    public IPushStatisticsExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public long getValidDeviceDozeDuration(Context r100) {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public long getValidDeviceKillDuration(Context r100) {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public boolean isEnablePushStatistics() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public void onProcessStart() {
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public void onPushStart() {
    }
}
