package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiInfoBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f31835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f31837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31839e;
    public int f;
    public Integer g;
    public int h;
    public int i;

    public WifiInfoBean(WifiManager r1) {
        this.f31835a = r1;
        update();
    }

    public boolean equals(WifiInfoBean r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = this.f31836b;
        if (r1 != null) goto L8;
    L32:
        return false;
    L8:
        if (r1.equals(r4.f31836b) == true) goto L32;
        String r2 = this.f31837c;
        if (r2 == null) goto L32;
        if (r2.equals(r4.f31837c) == true) goto L32;
        if (this.f31838d == r4.f31838d) goto L19;
        return false;
    L19:
        if (this.f31839e == r4.f31839e) goto L22;
        return false;
    L22:
        if (this.f == r4.f) goto L25;
        return false;
    L25:
        if (this.h == r4.h) goto L28;
        return false;
    L28:
        if (this.i == r4.i) goto L30;
        return false;
    L30:
        return true;
    }

    public String getBssid() {
        return this.f31836b;
    }

    public int getChannel() {
        return this.f;
    }

    public int getFrequency() {
        return this.f31838d;
    }

    public int getRssi() {
        update();
        return this.f31839e;
    }

    public int getRxLinkSpeedMbps() {
        return this.h;
    }

    public String getSsid() {
        return this.f31837c;
    }

    public int getTxLinkSpeedMbps() {
        return this.i;
    }

    public int getWifiStandard() {
        return this.g.intValue();
    }

    public boolean is24GHz() {
        return WifiUtils.is24GHz(this.f31838d);
    }

    public boolean is5GHz() {
        return WifiUtils.is5GHz(this.f31838d);
    }

    public boolean is6GHz() {
        return WifiUtils.is6GHz(this.f31838d);
    }

    public String toString() {
        return "mBssid=" + WifiUtils.maskMacAddress(this.f31836b) + ", mSsid=" + WifiUtils.ssidHide(WifiUtils.removeDoubleQuotes(this.f31837c)) + ", mFrequency=" + this.f31838d + ", mRssi=" + this.f31839e + ", mChannel=" + this.f + ", mRxLinkSpeed=" + this.h + ", mTxLinkSpeed=" + this.i;
    }

    public WifiInfoBean update() {
        WifiInfo r0 = this.f31835a.getConnectionInfo();
        LogUtil.d("WifiInfoBean", "get WifiInfo:" + r0);
        this.f31836b = r0.getBSSID();
        this.f31837c = r0.getSSID();
        this.f31838d = r0.getFrequency();
        this.f31839e = r0.getRssi();
        this.f = WifiUtils.convertFrequencyMhzToChannel(this.f31838d);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 29) goto L5;
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
    L7:
        if (r1 < 30) goto L9;
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
        this.g = Integer.valueOf(r0.getWifiStandard());
    L10:
        return this;
    L9:
        this.i = r0.getLinkSpeed();
        this.h = 0;
        this.g = 0;
        goto L10
    L5:
        this.h = 0;
        this.i = 0;
        goto L7
    }
}
