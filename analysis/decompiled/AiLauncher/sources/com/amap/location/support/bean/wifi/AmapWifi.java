package com.amap.location.support.bean.wifi;

import V1.b;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapWifi implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public long f18131a;

    /* renamed from: b, reason: collision with root package name */
    public String f18132b;

    /* renamed from: d, reason: collision with root package name */
    public int f18134d;

    /* renamed from: e, reason: collision with root package name */
    public long f18135e;

    /* renamed from: g, reason: collision with root package name */
    public short f18137g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18138h;

    /* renamed from: c, reason: collision with root package name */
    public int f18133c = Const.I_DEF_CGI_SIG;

    /* renamed from: f, reason: collision with root package name */
    public long f18136f = 0;

    public AmapWifi() {
    }

    public static String c(long j10) {
        return b.a(j10);
    }

    public static long d(String str) {
        return b.b(str);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AmapWifi clone() {
        AmapWifi amapWifi = new AmapWifi(this.f18138h);
        amapWifi.f18131a = this.f18131a;
        amapWifi.f18132b = this.f18132b;
        amapWifi.f18133c = this.f18133c;
        amapWifi.f18134d = this.f18134d;
        amapWifi.f18135e = this.f18135e;
        amapWifi.f18136f = this.f18136f;
        amapWifi.f18137g = this.f18137g;
        amapWifi.f18138h = this.f18138h;
        return amapWifi;
    }

    public String b() {
        return this.f18138h + Const.STR_MART_WELL + this.f18131a;
    }

    public String toString() {
        return "AmapWifi{mac=" + this.f18131a + ", ssid=" + this.f18132b + ", rssi=" + this.f18133c + ", frequency=" + this.f18134d + ", timestamp=" + this.f18135e + ", lastUpdateUtcMills=" + this.f18136f + ", freshness=" + ((int) this.f18137g) + ", connected=" + this.f18138h + '}';
    }

    public AmapWifi(boolean z10) {
        this.f18138h = z10;
    }
}
