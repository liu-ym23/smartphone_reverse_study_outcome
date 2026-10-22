package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl;
import com.ss.android.socialbase.downloader.network.NetworkQuality;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
    public DownloadNetTrafficManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void addBandwidth(long r1, long r3) {
        NetTrafficManagerImpl.getInstance().addBandwidth(r1, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality getCurrentNetworkQuality() {
        return NetTrafficManagerImpl.getInstance().getCurrentNetworkQuality();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void reset() {
        NetTrafficManagerImpl.getInstance().reset();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getDownloadKBitsPerSecond() {
        return NetTrafficManagerImpl.getInstance().getDownloadKBitsPerSecond();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getRealTimeSpeed() {
        return NetTrafficManagerImpl.getInstance().getRealTimeSpeed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public long getTaskRunningTime() {
        return DeviceBandwidthSampler.getInstance().getTaskRunningTime();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r2) {
        NetTrafficManager.NetworkStateChangeListener r1 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        return NetTrafficManagerImpl.getInstance().register(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void remove(NetTrafficManager.NetworkStateChangeListener r2) {
        NetTrafficManager.NetworkStateChangeListener r1 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        NetTrafficManagerImpl.getInstance().remove(r1);
    }
}
