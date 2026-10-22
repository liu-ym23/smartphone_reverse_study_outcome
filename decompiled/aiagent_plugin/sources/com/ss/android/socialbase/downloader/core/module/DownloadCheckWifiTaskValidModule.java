package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckWifiTaskValidModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckWifiTaskValidModule";

    public DownloadCheckWifiTaskValidModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r2) {
        if (r2.mDownloadInfo.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.init(r2);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L5:
        checkWifiTaskValid(this.mDownloadInfo);
        r6.proceed();
    }

    public static void checkWifiTaskValid(DownloadInfo r1) {
        if (r1.isFastDownload() == false) goto L5;
        return;
    L5:
        if (DeviceBandwidthSampler.isWifi() == false) goto L8;
        return;
    L8:
        if (r1.isOnlyWifi() == false) goto L15;
        DeviceBandwidthSampler.updateNetworkStatus();
        if (DeviceBandwidthSampler.isMobileNet() == false) goto L15;
        throw new DownloadOnlyWifiException();
    L15:
        if (r1.isDownloadFromReserveWifi() == true) goto L17;
        return;
    L17:
        if (r1.isPauseReserveOnWifi() == false) goto L25;
        DeviceBandwidthSampler.updateNetworkStatus();
        if (DeviceBandwidthSampler.isMobileNet() == true) goto L22;
        return;
    L22:
        throw new DownloadPauseReserveWifiException();
    }
}
