package com.baidu.platform.comapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f33367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33369d;

    public static int c(int r100) {
        int r101 = (((-16777216) & r100) | ((r100 & 255) << 16)) | (65280 & r100);
        return ((r100 & 16711680) >> 16) | r101;
    }

    public String toString() {
        return "Style: color:" + Integer.toHexString(this.f33366a) + " width:" + this.f33367b + " fillcolor:" + Integer.toHexString(this.f33368c);
    }

    public z() {
    }

    public int a() {
        return this.f33366a;
    }

    public int b() {
        return this.f33368c;
    }

    public int c() {
        return this.f33369d;
    }

    public int d() {
        return this.f33367b;
    }

    public z a(int r100) {
        this.f33366a = r100;
        return this;
    }

    public z b(int r100) {
        this.f33367b = r100;
        return this;
    }
}
