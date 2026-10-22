package com.obric.cae.libs.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.obric.cae.libs.smartnetwork.CaeSmartNetworkManager;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.wifi.basicInfo.BasicInfoManager;
import com.obric.cae.libs.wifi.basicInfo.WifiChangeListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CaeWifiAdapter {
    public static CaeWifiAdapter d;
    public final CaeStatusReportManager a;
    public final CaeSmartNetworkManager b;
    public final BasicInfoManager c;

    public CaeWifiAdapter(Context r2) {
        this.a = CaeStatusReportManager.getInstance(r2);
        this.b = CaeSmartNetworkManager.getInstance(r2);
        this.c = BasicInfoManager.getInstance(r2);
    }

    public static CaeWifiAdapter getInstance(Context r2) {
        if (r2 == null) goto L19;
        if (d != null) goto L17;
        monitor-enter(CaeWifiAdapter.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (d != null) goto L12;
        d = new CaeWifiAdapter(r2);     // Catch: Throwable -> L10
    L12:
        monitor-exit(CaeWifiAdapter.class);     // Catch: Throwable -> L10
    L17:
        return d;
    L19:
        throw new IllegalArgumentException("context cannot be null");
    }

    public int getBand() {
        return this.c.getBand();
    }

    public int getBandwidth() {
        return this.c.getBandwidth();
    }

    public String getBssid() {
        return this.c.getBssid();
    }

    public String getCaeVersion() {
        return this.a.getCaeVersion();
    }

    public String getCaelibVersion() {
        return CaelibUtils.getCaelibVersion();
    }

    public int getChannel() {
        return this.c.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        return this.c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        return this.c.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        return this.c.getLastScanResults();
    }

    public LinkLayerQuality getLinkLayerQuality() {
        return this.a.getLinkLayerQuality();
    }

    public int getLinkThroughput() {
        return this.b.getLinkThroughput();
    }

    public int getRssi() {
        return this.c.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        return this.c.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        return this.c.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        return this.c.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.c.getWifiStandard();
    }

    public int getWifiState() {
        return this.c.getWifiState();
    }

    public void registerLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r2) {
        this.a.registerLinkLayerQualityChangedListener(r2);
    }

    public void registerLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r2) {
        this.b.registerLinkThroughputListener(r2);
    }

    public boolean registerWifiChangeListener(WifiChangeListener r2) {
        return this.c.registerWifiChangeListener(r2);
    }

    public boolean startScan() {
        return this.c.startScan();
    }

    public void unregisterLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r2) {
        this.a.unregisterLinkLayerQualityChangedListener(r2);
    }

    public void unregisterLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r2) {
        this.b.unregisterLinkThroughputListener(r2);
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r2) {
        return this.c.unregisterWifiChangeListener(r2);
    }
}
