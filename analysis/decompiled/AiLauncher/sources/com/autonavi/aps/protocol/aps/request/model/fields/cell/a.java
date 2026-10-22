package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f18987a = 65535;

    /* renamed from: b, reason: collision with root package name */
    private int f18988b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f18989c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f18990d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f18991e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f18992f = 0;

    /* renamed from: g, reason: collision with root package name */
    private byte f18993g = 99;

    /* renamed from: h, reason: collision with root package name */
    private short f18994h = 0;

    public void a(int i10) {
        this.f18987a = i10;
    }

    public int a_() {
        return this.f18987a;
    }

    public int b() {
        return this.f18988b;
    }

    public int c() {
        return this.f18989c;
    }

    public int d() {
        return this.f18990d;
    }

    public int e() {
        return this.f18991e;
    }

    public int f() {
        return this.f18992f;
    }

    public byte g() {
        return this.f18993g;
    }

    public int h() {
        return g.a(this.f18994h);
    }

    public byte i() {
        return (byte) 2;
    }

    public String toString() {
        return "CdmaCell{mcc=" + this.f18987a + ", sid=" + this.f18988b + ", nid=" + this.f18989c + ", bid=" + this.f18990d + ", lon=" + this.f18991e + ", lat=" + this.f18992f + ", signal=" + ((int) this.f18993g) + ", cellAge=" + ((int) this.f18994h) + '}';
    }

    public void a(byte b10) {
        this.f18993g = b10;
    }

    public void b(int i10) {
        this.f18988b = i10;
    }

    public void c(int i10) {
        this.f18989c = i10;
    }

    public void d(int i10) {
        this.f18990d = i10;
    }

    public void e(int i10) {
        this.f18991e = i10;
    }

    public void f(int i10) {
        this.f18992f = i10;
    }

    public void g(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f18994h = (short) i10;
    }
}
