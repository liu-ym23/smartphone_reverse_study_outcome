package com.ss.android.socialbase.downloader.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class NetTrafficManagerImpl {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private final AtomicReference<NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final List<NetTrafficManager.NetworkStateChangeListener> listenerList;
    private final ExponentialGeometricAverage mDownloadBandwidth;
    private AtomicReference<NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = null;

        static {
            int[] r0 = new int[NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = r0;
            r0[NetworkQuality.POOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.MODERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.GOOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.EXCELLENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class ConnectionClassManagerHolder {
        public static final NetTrafficManagerImpl instance = null;

        private ConnectionClassManagerHolder() {
        }

        static {
            instance = new NetTrafficManagerImpl(null);
        }
    }

    /* synthetic */ NetTrafficManagerImpl(AnonymousClass1 r1) {
        this();
    }

    public static NetTrafficManagerImpl getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetTrafficManagerImpl() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new AtomicReference(NetworkQuality.UNKNOWN);
        this.listenerList = new CopyOnWriteArrayList();
    }

    public synchronized void addBandwidth(long r3, long r5) {
        monitor-enter(this);
        double r4 = ((r3 * 1.0d) / r5) * 8.0d;
        if (r5 != 0) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r4 < 3.0d) goto L25;
        this.mDownloadBandwidth.addMeasurement(r4);     // Catch: Throwable -> L27
        NetworkQuality r6 = getCurrentNetworkQuality();     // Catch: Throwable -> L27
        if (this.initiateStateChange == false) goto L21;
        this.sampleCount++;     // Catch: Throwable -> L27
        if (r6 == this.nextNetworkQuality.get()) goto L14;
        this.initiateStateChange = false;     // Catch: Throwable -> L27
        this.sampleCount = 1;     // Catch: Throwable -> L27
    L14:
        if (this.sampleCount >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE) goto L16;
    L18:
        monitor-exit(this);
        return;
    L16:
        if (significantlyOutsideCurrentBand() == false) goto L18;
        this.initiateStateChange = false;     // Catch: Throwable -> L27
        this.sampleCount = 1;     // Catch: Throwable -> L27
        this.currentNetworkQuality.set(this.nextNetworkQuality.get());     // Catch: Throwable -> L27
        notifyListeners();     // Catch: Throwable -> L27
        goto L18
    L21:
        if (this.currentNetworkQuality.get() == r6) goto L23;
        this.initiateStateChange = true;     // Catch: Throwable -> L27
        this.nextNetworkQuality = new AtomicReference(r6);     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
    }

    private boolean significantlyOutsideCurrentBand() {
        if (this.mDownloadBandwidth != null) goto L29;
        return false;
    L29:
        int r0 = AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[((NetworkQuality) ZeusTransformUtils.preCheckCast(this.currentNetworkQuality.get(), NetworkQuality.class, "com.obric.aiagent.plugin")).ordinal()];     // Catch: Throwable -> L26
        double r2 = 2000.0d;
        double r4 = 550.0d;
        if (r0 != 1) goto L8;
        r4 = 0.0d;
        r2 = 150.0d;
    L17:
        double r6 = this.mDownloadBandwidth.getAverage();     // Catch: Throwable -> L26
        if (r6 <= r2) goto L24;
        if (r6 <= (r2 * HYSTERESIS_TOP_MULTIPLIER)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r6 >= (r4 * HYSTERESIS_BOTTOM_MULTIPLIER)) goto L28;
        return true;
    L8:
        if (r0 != 2) goto L10;
        r2 = 550.0d;
        r4 = 150.0d;
        goto L17
    L10:
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L14;
        return true;
    L14:
        r2 = 3.4028234663852886E38d;
        r4 = 2000.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public void reset() {
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.reset();     // Catch: Throwable -> L7
    L5:
        this.currentNetworkQuality.set(NetworkQuality.UNKNOWN);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public synchronized NetworkQuality getCurrentNetworkQuality() {
        monitor-enter(this);
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L15
        if (r0 != null) goto L18;
        NetworkQuality r1 = NetworkQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L18:
        NetworkQuality r2 = mapBandwidthQuality(r0.getAverage());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return NetworkQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }

    private NetworkQuality mapBandwidthQuality(double r3) {
        if (r3 >= 0.0d) goto L7;
        return NetworkQuality.UNKNOWN;
    L7:
        if (r3 >= 150.0d) goto L11;
        return NetworkQuality.POOR;
    L11:
        if (r3 >= 550.0d) goto L15;
        return NetworkQuality.MODERATE;
    L15:
        if (r3 >= 2000.0d) goto L19;
        return NetworkQuality.GOOD;
    L19:
        return NetworkQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        monitor-enter(this);
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        double r1 = -1.0d;
    L7:
        monitor-exit(this);
        return r1;
    L6:
        r1 = r0.getAverage();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public double getRealTimeSpeed() {
        ExponentialGeometricAverage r2 = this.mDownloadBandwidth;
        if (r2 != null) goto L6;
        return 0.0d;
    L6:
        return r2.getRealTimeSpeed();
    }

    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r3) {
        NetTrafficManager.NetworkStateChangeListener r4 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.listenerList.add(r4);
    L6:
        return (NetworkQuality) ZeusTransformUtils.preCheckCast(this.currentNetworkQuality.get(), NetworkQuality.class, "com.obric.aiagent.plugin");
    }

    public void remove(NetTrafficManager.NetworkStateChangeListener r3) {
        NetTrafficManager.NetworkStateChangeListener r4 = (NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.listenerList.remove(r4);
        return;
    }

    private void notifyListeners() {
        int r1 = this.listenerList.size();     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        ((NetTrafficManager.NetworkStateChangeListener) ZeusTransformUtils.preCheckCast(this.listenerList.get(r2), NetTrafficManager.NetworkStateChangeListener.class, "com.obric.aiagent.plugin")).onBandwidthStateChange((NetworkQuality) ZeusTransformUtils.preCheckCast(this.currentNetworkQuality.get(), NetworkQuality.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L13:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
