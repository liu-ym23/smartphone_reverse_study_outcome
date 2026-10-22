package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f18995a = 65535;

    /* renamed from: b, reason: collision with root package name */
    private int f18996b = 65535;

    /* renamed from: c, reason: collision with root package name */
    private int f18997c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f18998d = 0;

    /* renamed from: e, reason: collision with root package name */
    private byte f18999e = 99;

    /* renamed from: f, reason: collision with root package name */
    private short f19000f = 0;

    public void a(int i10) {
        this.f18995a = i10;
    }

    public int b() {
        return this.f18996b;
    }

    public int b_() {
        return this.f18995a;
    }

    public int c() {
        return this.f18997c;
    }

    public int d() {
        return this.f18998d;
    }

    public byte e() {
        return this.f18999e;
    }

    public int f() {
        return g.a(this.f19000f);
    }

    public byte i() {
        return (byte) 1;
    }

    public String toString() {
        return "GsmCell{mcc=" + this.f18995a + ", mnc=" + this.f18996b + ", lac=" + this.f18997c + ", cellId=" + this.f18998d + ", signal=" + ((int) this.f18999e) + ", cellAge=" + ((int) this.f19000f) + '}';
    }

    public void a(byte b10) {
        this.f18999e = b10;
    }

    public void b(int i10) {
        this.f18996b = i10;
    }

    public void c(int i10) {
        this.f18997c = i10;
    }

    public void d(int i10) {
        this.f18998d = i10;
    }

    public void e(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f19000f = (short) i10;
    }
}
