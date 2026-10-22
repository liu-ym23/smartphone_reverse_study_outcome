package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f19019a = 65535;

    /* renamed from: b, reason: collision with root package name */
    private int f19020b = 65535;

    /* renamed from: c, reason: collision with root package name */
    private int f19021c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f19022d = 0;

    /* renamed from: e, reason: collision with root package name */
    private byte f19023e = 99;

    /* renamed from: f, reason: collision with root package name */
    private short f19024f = 0;

    /* renamed from: g, reason: collision with root package name */
    private short f19025g = Short.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f19026h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f19027i = Integer.MAX_VALUE;

    public void a(int i10) {
        this.f19019a = i10;
    }

    public int b() {
        return this.f19019a;
    }

    public int c() {
        return this.f19020b;
    }

    public int d() {
        return this.f19021c;
    }

    public int e() {
        return this.f19022d;
    }

    public byte f() {
        return this.f19023e;
    }

    public int g() {
        return g.a(this.f19024f);
    }

    public int h() {
        return g.a(this.f19025g);
    }

    public byte i() {
        return (byte) 4;
    }

    public int j() {
        return this.f19026h;
    }

    public int k() {
        return this.f19027i;
    }

    public String toString() {
        return "WcdmaCell{mcc=" + this.f19019a + ", mnc=" + this.f19020b + ", lac=" + this.f19021c + ", cellId=" + this.f19022d + ", signal=" + ((int) this.f19023e) + ", cellAge=" + ((int) this.f19024f) + ", pci=" + ((int) this.f19025g) + ", arfcn=" + this.f19026h + ", timingAdvance=" + this.f19027i + '}';
    }

    public void a(byte b10) {
        this.f19023e = b10;
    }

    public void b(int i10) {
        this.f19020b = i10;
    }

    public void c(int i10) {
        this.f19021c = i10;
    }

    public void d(int i10) {
        this.f19022d = i10;
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
        this.f19024f = (short) i10;
    }

    public void f(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f19025g = (short) i10;
    }

    public void g(int i10) {
        this.f19026h = i10;
    }
}
