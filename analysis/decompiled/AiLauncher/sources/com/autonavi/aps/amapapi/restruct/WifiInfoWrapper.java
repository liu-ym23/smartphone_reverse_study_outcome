package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class WifiInfoWrapper {

    /* renamed from: a, reason: collision with root package name */
    private WifiInfo f18319a;

    /* renamed from: b, reason: collision with root package name */
    private String f18320b;

    /* renamed from: c, reason: collision with root package name */
    private String f18321c;

    /* renamed from: d, reason: collision with root package name */
    private int f18322d = -1;

    public WifiInfoWrapper(WifiInfo wifiInfo) {
        this.f18319a = wifiInfo;
    }

    public String getBSSID() {
        if (this.f18321c == null) {
            this.f18321c = SystemApiWrapper.getBSSID(this.f18319a);
        }
        return this.f18321c;
    }

    public WifiInfo getOrigin() {
        return this.f18319a;
    }

    public int getRssi() {
        if (this.f18322d == -1) {
            this.f18322d = SystemApiWrapper.getRssi(this.f18319a);
        }
        return this.f18322d;
    }

    public String getSSID() {
        if (this.f18320b == null) {
            this.f18320b = SystemApiWrapper.getSSID(this.f18319a);
        }
        return this.f18320b;
    }

    public boolean isUseFul() {
        return (this.f18319a == null || TextUtils.isEmpty(getSSID()) || !Utils.wifiUseful(getBSSID())) ? false : true;
    }

    public WifiInfoWrapper(WifiInfo wifiInfo, String str, String str2) {
        this.f18319a = wifiInfo;
        this.f18320b = str;
        this.f18321c = str2;
    }
}
