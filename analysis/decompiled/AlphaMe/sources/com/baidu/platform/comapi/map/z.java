package com.baidu.platform.comapi.map;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private int f9258a;

    /* renamed from: b, reason: collision with root package name */
    private int f9259b;

    /* renamed from: c, reason: collision with root package name */
    private int f9260c;

    /* renamed from: d, reason: collision with root package name */
    private int f9261d;

    public static int c(int i4) {
        return ((i4 & 16711680) >> 16) | ((-16777216) & i4) | ((i4 & 255) << 16) | (65280 & i4);
    }

    public z a(int i4) {
        this.f9258a = i4;
        return this;
    }

    public z b(int i4) {
        this.f9259b = i4;
        return this;
    }

    public int d() {
        return this.f9259b;
    }

    public String toString() {
        return "Style: color:" + Integer.toHexString(this.f9258a) + " width:" + this.f9259b + " fillcolor:" + Integer.toHexString(this.f9260c);
    }

    public int a() {
        return this.f9258a;
    }

    public int b() {
        return this.f9260c;
    }

    public int c() {
        return this.f9261d;
    }
}
