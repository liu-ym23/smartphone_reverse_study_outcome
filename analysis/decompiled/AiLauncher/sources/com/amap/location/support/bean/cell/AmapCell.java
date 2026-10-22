package com.amap.location.support.bean.cell;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class AmapCell implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public long f18059a;

    /* renamed from: b, reason: collision with root package name */
    public String f18060b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f18061c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f18062d = 99;

    /* renamed from: e, reason: collision with root package name */
    public int f18063e = Integer.MAX_VALUE;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public long f18064f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f18065g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f18066h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18067i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18068j;

    public AmapCell(boolean z10, boolean z11) {
        this.f18067i = z10;
        this.f18068j = z11;
    }

    public void a(AmapCell amapCell) {
        if (amapCell != null) {
            this.f18060b = amapCell.f18060b;
            this.f18061c = amapCell.f18061c;
            this.f18062d = amapCell.f18062d;
            this.f18063e = amapCell.f18063e;
            this.f18064f = amapCell.f18064f;
            this.f18065g = amapCell.f18065g;
            this.f18066h = amapCell.f18066h;
            this.f18067i = amapCell.f18067i;
            this.f18068j = amapCell.f18068j;
            this.f18059a = amapCell.f18059a;
        }
    }
}
