package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ScanResultBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f31830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ScanResult> f31831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WifiInfo f31832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f31833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f31834e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Context k;

    public ScanResultBean(Context r3, WifiManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.k = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f31830a = r4;
        if (r4.isWifiEnabled() == false) goto L5;
        r4.startScan();
    L5:
        update();
    }

    public int getBandwidth() {
        int r6 = this.f;
        if (r6 != 4) goto L5;
    L19:
        double r2 = Math.pow(2.0d, r6 - 1);
    L18:
        return (int) (r2 * 20.0d);
    L5:
        if (r6 == 5) goto L19;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L16;
        if (r6 == 3) goto L16;
        return -1;
    L16:
        r2 = Math.pow(2.0d, r6);
        goto L18
    }

    public int getCurrentChannelUsedCount() {
        if (this.f31834e == false) goto L5;
        int r0 = this.i;
        int r1 = this.j;
        if (r0 >= r1) goto L10;
        return r0;
    L10:
        return r1;
    L5:
        return this.i;
    }

    public List<ScanResult> getLastScanResults() {
        return this.f31831b;
    }

    public boolean startScan() {
        WifiManager r0 = this.f31830a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.startScan();
    }

    public void update() {
        this.f31831b = WifiUtils.getWifiScanResults(this.k, this.f31830a);
        WifiInfo r0 = this.f31830a.getConnectionInfo();
        this.f31832c = r0;
        if (this.f31831b == null) goto L31;
        if (r0 == null) goto L42;
        this.f31833d = r0.getBSSID();
        this.g = this.f31832c.getFrequency();
        Iterator<ScanResult> r1 = this.f31831b.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        ScanResult r2 = (ScanResult) ZeusTransformUtils.preCheckCast(r1.next(), ScanResult.class, "com.obric.aiagent.plugin");
        if (r2.BSSID.equals(this.f31833d) == false) goto L8;
        this.f = r2.channelWidth;
        if (LogUtil.isLoggable(3) == false) goto L15;
        LogUtil.d("ScanResultBean", "match bssid!, channelWidth:" + this.f);
    L15:
        if (this.f != 4) goto L17;
        this.f31834e = true;
        this.g = r2.centerFreq0;
        this.h = r2.centerFreq1;
    L17:
        this.i = 0;
        if (this.f31834e == false) goto L20;
        this.j = 0;
    L20:
        Iterator<ScanResult> r3 = this.f31831b.iterator();
    L22:
        if (r3.hasNext() == false) goto L43;
        int r4 = ((ScanResult) ZeusTransformUtils.preCheckCast(r3.next(), ScanResult.class, "com.obric.aiagent.plugin")).frequency;
        if (r4 != this.g) goto L27;
        this.i++;
    L27:
        if (this.f31834e == false) goto L22;
        if (r4 != this.h) goto L22;
        this.j++;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public ScanResultBean(List<ScanResult> r3, WifiInfo r4) {
        List<ScanResult> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.f31831b = r5;
        this.f31832c = r4;
    }
}
