package com.obric.cae.libs.wifi.basicInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BasicInfoManager {
    public static final int INT_ERROR = -1;
    public static BasicInfoManager h;
    public final WifiManager a;
    public final WifiState b;
    public final ScanResultBean c;
    public final ChannelsEnvironment d;
    public final CopyOnWriteArrayList<WifiChangeListener> e;
    public final Context f;
    public WifiInfoBean g;

    public class a extends BroadcastReceiver {
        public final /* synthetic */ BasicInfoManager a;

        public a(BasicInfoManager r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r3, Intent r4) {
            String r5 = r4.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r5) == false) goto L10;
            this.a.b.handleWifiStateChanged(r4.getIntExtra("wifi_state", 4));
            BasicInfoManager r6 = this.a;
            int r7 = r6.b.getState();
            Iterator<WifiChangeListener> r8 = r6.e.iterator();
        L6:
            if (r8.hasNext() == false) goto L8;
            r8.next().onWifiStateChanged(r7);
            goto L6
        L8:
            this.a.b();
            return;
        L10:
            if ("android.net.wifi.STATE_CHANGE".equals(r5) == false) goto L17;
            NetworkInfo r9 = (NetworkInfo) r4.getParcelableExtra("networkInfo");
            this.a.b.handleConnectStateChanged(r9.getDetailedState());
            BasicInfoManager r10 = this.a;
            int r11 = r10.b.getState();
            Iterator<WifiChangeListener> r12 = r10.e.iterator();
        L13:
            if (r12.hasNext() == false) goto L15;
            r12.next().onWifiStateChanged(r11);
            goto L13
        L15:
            this.a.b();
            return;
        L17:
            if ("android.net.wifi.SCAN_RESULTS".equals(r5) == false) goto L23;
            this.a.d.update();
            this.a.c.update();
            BasicInfoManager r13 = this.a;
            List<ScanResult> r14 = WifiUtils.getWifiScanResults(r13.f, r13.a);
            Iterator<WifiChangeListener> r15 = r13.e.iterator();
        L20:
            if (r15.hasNext() == false) goto L32;
            r15.next().onScanInfoChanged(r14);
            goto L20
        L32:
            return;
        L23:
            if ("android.net.wifi.RSSI_CHANGED".equals(r5) == false) goto L31;
            this.a.b();
            return;
        }
    }

    public BasicInfoManager(Context r4) {
        this.e = new CopyOnWriteArrayList();
        a r0 = new a(this);
        this.f = r4;
        WifiManager r1 = (WifiManager) r4.getSystemService("wifi");
        this.a = r1;
        this.b = new WifiState();
        this.g = new WifiInfoBean(r1);
        this.d = new ChannelsEnvironment(r4, r1);
        this.c = new ScanResultBean(r4, r1);
        IntentFilter r2 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r2.addAction("android.net.wifi.STATE_CHANGE");
        r2.addAction("android.net.wifi.SCAN_RESULTS");
        r2.addAction("android.net.wifi.RSSI_CHANGED");
        r4.registerReceiver(r0, r2);
        a();
        refreshData();
    }

    public static BasicInfoManager getInstance(Context r2) {
        if (r2 == null) goto L16;
        monitor-enter(BasicInfoManager.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (h != null) goto L10;
        h = new BasicInfoManager(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(BasicInfoManager.class);     // Catch: Throwable -> L8
        return h;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        if (this.a.isWifiEnabled() == true) goto L5;
        this.b.handleWifiStateChanged(1);
        return;
    L5:
        this.b.handleWifiStateChanged(3);
        if (WifiUtils.isWifiConnected(this.f) == false) goto L8;
        this.b.handleConnectStateChanged(NetworkInfo.DetailedState.CONNECTED);
        return;
    L8:
        this.b.handleWifiStateChanged(3);
    }

    public final void b() {
        WifiInfoBean r0 = this.g.update();
        if (r0 != null) goto L5;
        return;
    L5:
        LogUtil.d("BasicInfoManager", "Update WifiInfoBean:" + r0.toString());
        if (r0.equals(this.g) == true) goto L14;
        Iterator<WifiChangeListener> r1 = this.e.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().onWifiInfoChanged(true);
        goto L9
    L11:
        this.g = r0;
        return;
    }

    public int getBand() {
        int r0 = getFrequency();
        if (WifiUtils.is24GHz(r0) == false) goto L7;
        return 1;
    L7:
        if (WifiUtils.is5GHz(r0) == false) goto L11;
        return 2;
    L11:
        if (WifiUtils.is6GHz(r0) == false) goto L14;
        return 8;
    L14:
        return -1;
    }

    public int getBandwidth() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.c.getBandwidth();
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
        return this.c.getCurrentChannelUsedCount();
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
        return this.c.getLastScanResults();
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
        return this.b.getState();
    }

    public void refreshData() {
        b();
        startScan();
    }

    public boolean registerWifiChangeListener(WifiChangeListener r2) {
        return this.e.add(r2);
    }

    public boolean startScan() {
        if (getWifiState() >= 3) goto L6;
        LogUtil.i("BasicInfoManager", "startScan failed");
        return false;
    L6:
        LogUtil.i("BasicInfoManager", "startScan");
        return this.c.startScan();
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r2) {
        if (this.e.contains(r2) == true) goto L5;
        return false;
    L5:
        return this.e.remove(r2);
    }
}
