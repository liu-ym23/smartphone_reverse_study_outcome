package com.autonavi.aps.protocol.aps.request.model.fields.wifi;

import com.autonavi.aps.protocol.aps.common.constant.WifiStandard;
import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f19066a = new a();

    /* renamed from: b, reason: collision with root package name */
    private String f19067b = "";

    /* renamed from: c, reason: collision with root package name */
    private byte f19068c = 0;

    /* renamed from: d, reason: collision with root package name */
    private short f19069d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f19070e = false;

    /* renamed from: f, reason: collision with root package name */
    private short f19071f;

    public a a() {
        return this.f19066a;
    }

    public String b() {
        return this.f19067b;
    }

    public byte c() {
        return this.f19068c;
    }

    public int d() {
        return g.a(this.f19069d);
    }

    public boolean e() {
        return this.f19070e;
    }

    public short f() {
        return this.f19071f;
    }

    public String toString() {
        return "MainWifi{mac=" + this.f19066a + ", ssid='" + this.f19067b + "', rssi=" + ((int) this.f19068c) + ", age=" + ((int) this.f19069d) + ", move=" + this.f19070e + ", wifiStandard=" + ((int) this.f19071f) + '}';
    }

    public void a(a aVar) {
        this.f19066a = aVar;
    }

    public void a(String str) {
        this.f19067b = str;
    }

    public void a(byte b10) {
        this.f19068c = b10;
    }

    public void a(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18510c;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18511d;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f19069d = (short) i10;
    }

    public void a(boolean z10) {
        this.f19070e = z10;
    }

    public void a(short s10) {
        this.f19071f = WifiStandard.getWifiStandardCode(s10);
    }
}
