package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BasicInfoManager {
    public static final int INT_ERROR = -1;
    public static BasicInfoManager h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f31819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiState f31820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScanResultBean f31821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChannelsEnvironment f31822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<WifiChangeListener> f31823e;
    public final Context f;
    public WifiInfoBean g;

    public class a extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasicInfoManager f31824a;

        public a(BasicInfoManager r1) {
            this.f31824a = r1;
        }

        public final void onReceive(Context r4, Intent r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            String r7 = r5.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r7) == false) goto L10;
            this.f31824a.f31820b.handleWifiStateChanged(r5.getIntExtra("wifi_state", 4));
            BasicInfoManager r8 = this.f31824a;
            int r9 = r8.f31820b.getState();
            Iterator<WifiChangeListener> r10 = r8.f31823e.iterator();
        L6:
            if (r10.hasNext() == false) goto L8;
            ((WifiChangeListener) ZeusTransformUtils.preCheckCast(r10.next(), WifiChangeListener.class, "com.obric.aiagent.plugin")).onWifiStateChanged(r9);
            goto L6
        L8:
            this.f31824a.b();
            return;
        L10:
            if ("android.net.wifi.STATE_CHANGE".equals(r7) == false) goto L17;
            NetworkInfo r11 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra("networkInfo"), NetworkInfo.class, "com.obric.aiagent.plugin");
            this.f31824a.f31820b.handleConnectStateChanged(r11.getDetailedState());
            BasicInfoManager r12 = this.f31824a;
            int r13 = r12.f31820b.getState();
            Iterator<WifiChangeListener> r14 = r12.f31823e.iterator();
        L13:
            if (r14.hasNext() == false) goto L15;
            ((WifiChangeListener) ZeusTransformUtils.preCheckCast(r14.next(), WifiChangeListener.class, "com.obric.aiagent.plugin")).onWifiStateChanged(r13);
            goto L13
        L15:
            this.f31824a.b();
            return;
        L17:
            if ("android.net.wifi.SCAN_RESULTS".equals(r7) == false) goto L23;
            this.f31824a.f31822d.update();
            this.f31824a.f31821c.update();
            BasicInfoManager r3 = this.f31824a;
            List<ScanResult> r15 = WifiUtils.getWifiScanResults(r3.f, r3.f31819a);
            Iterator<WifiChangeListener> r16 = r3.f31823e.iterator();
        L20:
            if (r16.hasNext() == false) goto L32;
            ((WifiChangeListener) ZeusTransformUtils.preCheckCast(r16.next(), WifiChangeListener.class, "com.obric.aiagent.plugin")).onScanInfoChanged(r15);
            goto L20
        L32:
            return;
        L23:
            if ("android.net.wifi.RSSI_CHANGED".equals(r7) == false) goto L31;
            this.f31824a.b();
            return;
        }
    }

    public BasicInfoManager(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.f31823e = new CopyOnWriteArrayList();
        a r0 = new a(this);
        this.f = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        WifiManager r2 = (WifiManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin");
        this.f31819a = r2;
        this.f31820b = new WifiState();
        this.g = new WifiInfoBean(r2);
        this.f31822d = new ChannelsEnvironment(r6, r2);
        this.f31821c = new ScanResultBean(r6, r2);
        IntentFilter r3 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r3.addAction("android.net.wifi.STATE_CHANGE");
        r3.addAction("android.net.wifi.SCAN_RESULTS");
        r3.addAction("android.net.wifi.RSSI_CHANGED");
        ZeusTransformUtils.registerReceiver(r6, r0, r3, "com.obric.aiagent.plugin");
        a();
        refreshData();
    }

    public static BasicInfoManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        monitor-enter(BasicInfoManager.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new BasicInfoManager(r3);     // Catch: Throwable -> L12
    L9:
        monitor-exit(BasicInfoManager.class);     // Catch: Throwable -> L12
        return h;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        if (this.f31819a.isWifiEnabled() == true) goto L5;
        this.f31820b.handleWifiStateChanged(1);
        return;
    L5:
        this.f31820b.handleWifiStateChanged(3);
        if (WifiUtils.isWifiConnected(this.f) == false) goto L8;
        this.f31820b.handleConnectStateChanged(NetworkInfo.DetailedState.CONNECTED);
        return;
    L8:
        this.f31820b.handleWifiStateChanged(3);
    }

    public final void b() {
        WifiInfoBean r0 = this.g.update();
        if (r0 != null) goto L5;
        return;
    L5:
        LogUtil.d("BasicInfoManager", "Update WifiInfoBean:" + r0.toString());
        if (r0.equals(this.g) == true) goto L14;
        Iterator<WifiChangeListener> r2 = this.f31823e.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((WifiChangeListener) ZeusTransformUtils.preCheckCast(r2.next(), WifiChangeListener.class, "com.obric.aiagent.plugin")).onWifiInfoChanged(true);
        goto L9
    L11:
        this.g = r0;
        return;
    }

    public int getBand() {
        int r1 = getFrequency();
        if (WifiUtils.is24GHz(r1) == false) goto L7;
        return 1;
    L7:
        if (WifiUtils.is5GHz(r1) == false) goto L11;
        return 2;
    L11:
        if (WifiUtils.is6GHz(r1) == false) goto L14;
        return 8;
    L14:
        return -1;
    }

    public int getBandwidth() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f31821c.getBandwidth();
    }

    public String getBssid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.g.getBssid();
    }

    public int getChannel() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.g.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f31821c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.g.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        if (getWifiState() >= 3) goto L7;
        return null;
    L7:
        return this.f31821c.getLastScanResults();
    }

    public int getRssi() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.g.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.g.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.g.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.g.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.g.getWifiStandard();
    }

    public int getWifiState() {
        return this.f31820b.getState();
    }

    public void refreshData() {
        b();
        startScan();
    }

    public boolean registerWifiChangeListener(WifiChangeListener r3) {
        WifiChangeListener r4 = (WifiChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, WifiChangeListener.class, "com.obric.aiagent.plugin");
        return this.f31823e.add(r4);
    }

    public boolean startScan() {
        if (getWifiState() >= 3) goto L6;
        LogUtil.i("BasicInfoManager", "startScan failed");
        return false;
    L6:
        LogUtil.i("BasicInfoManager", "startScan");
        return this.f31821c.startScan();
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r3) {
        WifiChangeListener r4 = (WifiChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, WifiChangeListener.class, "com.obric.aiagent.plugin");
        if (this.f31823e.contains(r4) == true) goto L5;
        return false;
    L5:
        return this.f31823e.remove(r4);
    }
}
