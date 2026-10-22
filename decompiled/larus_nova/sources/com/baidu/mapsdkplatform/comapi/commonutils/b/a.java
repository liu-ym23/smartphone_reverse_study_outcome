package com.baidu.mapsdkplatform.comapi.commonutils.b;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32056c;

    public String toString() {
        return "DownloadThreadInfo{id=" + this.f32054a + ", start=" + this.f32055b + ", end=" + this.f32056c + '}';
    }

    public int a() {
        return this.f32056c;
    }

    public int b() {
        return this.f32055b;
    }

    public void a(int r100) {
        this.f32056c = r100;
    }

    public a(int r100, int r101, int r102) {
        this.f32054a = r100;
        this.f32055b = r101;
        this.f32056c = r102;
    }
}
