package com.obric.cae.libs.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.obric.cae.libs.smartnetwork.CaeSmartNetworkManager;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.wifi.basicInfo.BasicInfoManager;
import com.obric.cae.libs.wifi.basicInfo.WifiChangeListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CaeWifiAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeWifiAdapter f31815d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CaeStatusReportManager f31816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CaeSmartNetworkManager f31817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BasicInfoManager f31818c;

    public CaeWifiAdapter(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f31816a = CaeStatusReportManager.getInstance(r4);
        this.f31817b = CaeSmartNetworkManager.getInstance(r4);
        this.f31818c = BasicInfoManager.getInstance(r4);
    }

    public static CaeWifiAdapter getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L19;
        if (f31815d != null) goto L17;
        monitor-enter(CaeWifiAdapter.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f31815d != null) goto L11;
        f31815d = new CaeWifiAdapter(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(CaeWifiAdapter.class);     // Catch: Throwable -> L13
    L17:
        return f31815d;
    L19:
        throw new IllegalArgumentException("context cannot be null");
    }

    public int getBand() {
        return this.f31818c.getBand();
    }

    public int getBandwidth() {
        return this.f31818c.getBandwidth();
    }

    public String getBssid() {
        return this.f31818c.getBssid();
    }

    public String getCaeVersion() {
        return this.f31816a.getCaeVersion();
    }

    public String getCaelibVersion() {
        return CaelibUtils.getCaelibVersion();
    }

    public int getChannel() {
        return this.f31818c.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        return this.f31818c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        return this.f31818c.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        return this.f31818c.getLastScanResults();
    }

    public LinkLayerQuality getLinkLayerQuality() {
        return this.f31816a.getLinkLayerQuality();
    }

    public int getLinkThroughput() {
        return this.f31817b.getLinkThroughput();
    }

    public int getRssi() {
        return this.f31818c.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        return this.f31818c.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        return this.f31818c.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        return this.f31818c.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.f31818c.getWifiStandard();
    }

    public int getWifiState() {
        return this.f31818c.getWifiState();
    }

    public void registerLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r3) {
        CaeStatusReportManager.LinkLayerQualityChangedListener r4 = (CaeStatusReportManager.LinkLayerQualityChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, CaeStatusReportManager.LinkLayerQualityChangedListener.class, "com.obric.aiagent.plugin");
        this.f31816a.registerLinkLayerQualityChangedListener(r4);
    }

    public void registerLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r3) {
        CaeSmartNetworkManager.CaeWifiLinkThroughputListener r4 = (CaeSmartNetworkManager.CaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r3, CaeSmartNetworkManager.CaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        this.f31817b.registerLinkThroughputListener(r4);
    }

    public boolean registerWifiChangeListener(WifiChangeListener r3) {
        WifiChangeListener r4 = (WifiChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, WifiChangeListener.class, "com.obric.aiagent.plugin");
        return this.f31818c.registerWifiChangeListener(r4);
    }

    public boolean startScan() {
        return this.f31818c.startScan();
    }

    public void unregisterLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r3) {
        CaeStatusReportManager.LinkLayerQualityChangedListener r4 = (CaeStatusReportManager.LinkLayerQualityChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, CaeStatusReportManager.LinkLayerQualityChangedListener.class, "com.obric.aiagent.plugin");
        this.f31816a.unregisterLinkLayerQualityChangedListener(r4);
    }

    public void unregisterLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r3) {
        CaeSmartNetworkManager.CaeWifiLinkThroughputListener r4 = (CaeSmartNetworkManager.CaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r3, CaeSmartNetworkManager.CaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        this.f31817b.unregisterLinkThroughputListener(r4);
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r3) {
        WifiChangeListener r4 = (WifiChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, WifiChangeListener.class, "com.obric.aiagent.plugin");
        return this.f31818c.unregisterWifiChangeListener(r4);
    }
}
