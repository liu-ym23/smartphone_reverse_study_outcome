package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class NetTrafficManager {
    private IDownloadNetTrafficManagerService service;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ConnectionClassManagerHolder {
        public static final NetTrafficManager instance = null;

        private ConnectionClassManagerHolder() {
        }

        static {
            instance = new NetTrafficManager(null);
        }
    }

    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(NetworkQuality r1);
    }

    /* synthetic */ NetTrafficManager(AnonymousClass1 r1) {
        this();
    }

    public static NetTrafficManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetTrafficManager() {
        this.service = (IDownloadNetTrafficManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadNetTrafficManagerService.class), IDownloadNetTrafficManagerService.class, "com.obric.aiagent.plugin");
    }

    public void addBandwidth(long r1, long r3) {
        this.service.addBandwidth(r1, r3);
    }

    public NetworkQuality getCurrentNetworkQuality() {
        return this.service.getCurrentNetworkQuality();
    }

    public void reset() {
        this.service.reset();
    }

    public double getDownloadKBitsPerSecond() {
        return this.service.getDownloadKBitsPerSecond();
    }

    public double getRealTimeSpeed() {
        return this.service.getRealTimeSpeed();
    }

    public long getTaskRunningTime() {
        return this.service.getTaskRunningTime();
    }

    public NetworkQuality register(NetworkStateChangeListener r3) {
        NetworkStateChangeListener r4 = (NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        return this.service.register(r4);
    }

    public void remove(NetworkStateChangeListener r3) {
        NetworkStateChangeListener r4 = (NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        this.service.remove(r4);
    }
}
