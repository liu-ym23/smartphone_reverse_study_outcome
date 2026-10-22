package com.amap.location.support.bean.cell;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellLte extends AmapCell implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public int f18080k;

    /* renamed from: l, reason: collision with root package name */
    public int f18081l;

    /* renamed from: m, reason: collision with root package name */
    public int f18082m;

    /* renamed from: n, reason: collision with root package name */
    public int f18083n;

    /* renamed from: o, reason: collision with root package name */
    public int f18084o;

    /* renamed from: p, reason: collision with root package name */
    public int f18085p;

    /* renamed from: q, reason: collision with root package name */
    public int f18086q;

    /* renamed from: r, reason: collision with root package name */
    public int f18087r;

    public AmapCellLte(boolean z10) {
        super(z10, true);
        this.f18080k = 0;
        this.f18081l = 0;
        this.f18082m = Integer.MAX_VALUE;
        this.f18083n = Integer.MAX_VALUE;
        this.f18084o = Integer.MAX_VALUE;
        this.f18085p = Integer.MAX_VALUE;
        this.f18086q = Integer.MAX_VALUE;
        this.f18087r = Integer.MAX_VALUE;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AmapCell clone() {
        AmapCellLte amapCellLte = new AmapCellLte(this.f18067i);
        amapCellLte.a(this);
        amapCellLte.f18080k = this.f18080k;
        amapCellLte.f18081l = this.f18081l;
        amapCellLte.f18082m = this.f18082m;
        amapCellLte.f18083n = this.f18083n;
        amapCellLte.f18084o = this.f18084o;
        return amapCellLte;
    }

    public String toString() {
        return "AmapCellLte{tac=" + this.f18080k + ", ci=" + this.f18081l + ", pci=" + this.f18082m + ", earfcn=" + this.f18083n + ", timingAdvance=" + this.f18084o + ", mcc='" + this.f18060b + "', mnc='" + this.f18061c + "', signalStrength=" + this.f18062d + ", asuLevel=" + this.f18063e + ", lastUpdateSystemMills=" + this.f18064f + ", lastUpdateUtcMills=" + this.f18065g + ", age=" + this.f18066h + ", main=" + this.f18067i + ", newApi=" + this.f18068j + '}';
    }
}
