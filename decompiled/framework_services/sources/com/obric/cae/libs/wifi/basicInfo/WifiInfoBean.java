package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiInfoBean {
    public final WifiManager a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public Integer g;
    public int h;
    public int i;

    public WifiInfoBean(WifiManager r1) {
        this.a = r1;
        update();
    }

    public boolean equals(WifiInfoBean r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = this.b;
        if (r1 != null) goto L8;
    L32:
        return false;
    L8:
        if (r1.equals(r4.b) == true) goto L32;
        String r2 = this.c;
        if (r2 == null) goto L32;
        if (r2.equals(r4.c) == true) goto L32;
        if (this.d == r4.d) goto L19;
        return false;
    L19:
        if (this.e == r4.e) goto L22;
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
        return this.b;
    }

    public int getChannel() {
        return this.f;
    }

    public int getFrequency() {
        return this.d;
    }

    public int getRssi() {
        update();
        return this.e;
    }

    public int getRxLinkSpeedMbps() {
        return this.h;
    }

    public String getSsid() {
        return this.c;
    }

    public int getTxLinkSpeedMbps() {
        return this.i;
    }

    public int getWifiStandard() {
        return this.g.intValue();
    }

    public boolean is24GHz() {
        return WifiUtils.is24GHz(this.d);
    }

    public boolean is5GHz() {
        return WifiUtils.is5GHz(this.d);
    }

    public boolean is6GHz() {
        return WifiUtils.is6GHz(this.d);
    }

    public String toString() {
        return "mBssid=" + WifiUtils.maskMacAddress(this.b) + ", mSsid=" + WifiUtils.ssidHide(WifiUtils.removeDoubleQuotes(this.c)) + ", mFrequency=" + this.d + ", mRssi=" + this.e + ", mChannel=" + this.f + ", mRxLinkSpeed=" + this.h + ", mTxLinkSpeed=" + this.i;
    }

    public WifiInfoBean update() {
        WifiInfo r0 = this.a.getConnectionInfo();
        LogUtil.d("WifiInfoBean", "get WifiInfo:" + r0);
        this.b = r0.getBSSID();
        this.c = r0.getSSID();
        this.d = r0.getFrequency();
        this.e = r0.getRssi();
        this.f = WifiUtils.convertFrequencyMhzToChannel(this.d);
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
        this.g = Integer.valueOf(r0.getWifiStandard());
        return this;
    }
}
