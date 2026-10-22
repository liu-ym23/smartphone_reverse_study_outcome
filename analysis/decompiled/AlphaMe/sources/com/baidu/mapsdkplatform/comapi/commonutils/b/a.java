package com.baidu.mapsdkplatform.comapi.commonutils.b;

import B0.g;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f7930a;

    /* renamed from: b, reason: collision with root package name */
    private int f7931b;

    /* renamed from: c, reason: collision with root package name */
    private int f7932c;

    public a(int i4, int i5, int i6) {
        this.f7930a = i4;
        this.f7931b = i5;
        this.f7932c = i6;
    }

    public int a() {
        return this.f7932c;
    }

    public int b() {
        return this.f7931b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadThreadInfo{id=");
        sb.append(this.f7930a);
        sb.append(", start=");
        sb.append(this.f7931b);
        sb.append(", end=");
        return g.o(sb, this.f7932c, '}');
    }

    public void a(int i4) {
        this.f7932c = i4;
    }
}
