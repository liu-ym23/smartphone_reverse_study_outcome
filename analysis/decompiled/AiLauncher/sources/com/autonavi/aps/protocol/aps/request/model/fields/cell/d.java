package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f19010a = 65535;

    /* renamed from: b, reason: collision with root package name */
    private int f19011b = 65535;

    /* renamed from: c, reason: collision with root package name */
    private int f19012c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f19013d = 0;

    /* renamed from: e, reason: collision with root package name */
    private byte f19014e = 99;

    /* renamed from: f, reason: collision with root package name */
    private short f19015f = 0;

    /* renamed from: g, reason: collision with root package name */
    private short f19016g = Short.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f19017h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f19018i = Integer.MAX_VALUE;

    public void a(int i10) {
        this.f19010a = i10;
    }

    public int b() {
        return this.f19010a;
    }

    public int c() {
        return this.f19011b;
    }

    public int d() {
        return this.f19012c;
    }

    public long e() {
        return this.f19013d;
    }

    public byte f() {
        return this.f19014e;
    }

    public int g() {
        return g.a(this.f19015f);
    }

    public int h() {
        return g.a(this.f19016g);
    }

    public byte i() {
        return (byte) 5;
    }

    public int j() {
        return this.f19017h;
    }

    public int k() {
        return this.f19018i;
    }

    public void a(long j10) {
        this.f19013d = j10;
    }

    public void b(int i10) {
        this.f19011b = i10;
    }

    public void c(int i10) {
        this.f19012c = i10;
    }

    public void d(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f19015f = (short) i10;
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
        this.f19016g = (short) i10;
    }

    public void f(int i10) {
        this.f19017h = i10;
    }

    public void g(int i10) {
        this.f19018i = i10;
    }

    public void a(byte b10) {
        this.f19014e = b10;
    }
}
