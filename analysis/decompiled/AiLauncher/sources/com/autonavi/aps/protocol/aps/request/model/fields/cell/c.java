package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f19001a = 65535;

    /* renamed from: b, reason: collision with root package name */
    private int f19002b = 65535;

    /* renamed from: c, reason: collision with root package name */
    private int f19003c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f19004d = 0;

    /* renamed from: e, reason: collision with root package name */
    private byte f19005e = 99;

    /* renamed from: f, reason: collision with root package name */
    private short f19006f = 0;

    /* renamed from: g, reason: collision with root package name */
    private short f19007g = Short.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f19008h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f19009i = Integer.MAX_VALUE;

    public void a(int i10) {
        this.f19001a = i10;
    }

    public int b() {
        return this.f19002b;
    }

    public int c() {
        return this.f19003c;
    }

    public int c_() {
        return this.f19001a;
    }

    public int d() {
        return this.f19004d;
    }

    public byte e() {
        return this.f19005e;
    }

    public int f() {
        return g.a(this.f19006f);
    }

    public int g() {
        return g.a(this.f19007g);
    }

    public int h() {
        return this.f19008h;
    }

    public byte i() {
        return (byte) 3;
    }

    public int j() {
        return this.f19009i;
    }

    public void a(byte b10) {
        this.f19005e = b10;
    }

    public void b(int i10) {
        this.f19002b = i10;
    }

    public void c(int i10) {
        this.f19003c = i10;
    }

    public void d(int i10) {
        this.f19004d = i10;
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
        this.f19006f = (short) i10;
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
        this.f19007g = (short) i10;
    }

    public void g(int i10) {
        this.f19008h = i10;
    }

    public void h(int i10) {
        this.f19009i = i10;
    }
}
