package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetworkQuality;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadNetTrafficManagerService {

    public static class DefaultDownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void addBandwidth(long r1, long r3) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public double getDownloadKBitsPerSecond() {
            return 0.0d;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public double getRealTimeSpeed() {
            return 0.0d;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public long getTaskRunningTime() {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void remove(NetTrafficManager.NetworkStateChangeListener r2) {
            NetTrafficManager.NetworkStateChangeListener r1 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void reset() {
        }

        public DefaultDownloadNetTrafficManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public NetworkQuality getCurrentNetworkQuality() {
            return NetworkQuality.UNKNOWN;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r2) {
            NetTrafficManager.NetworkStateChangeListener r1 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
            return NetworkQuality.UNKNOWN;
        }
    }

    void addBandwidth(long r1, long r3);

    NetworkQuality getCurrentNetworkQuality();

    double getDownloadKBitsPerSecond();

    double getRealTimeSpeed();

    long getTaskRunningTime();

    NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r1);

    void remove(NetTrafficManager.NetworkStateChangeListener r1);

    void reset();
}
