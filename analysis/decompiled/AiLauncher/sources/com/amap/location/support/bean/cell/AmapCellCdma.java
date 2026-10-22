package com.amap.location.support.bean.cell;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellCdma extends AmapCell implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public int f18069k;

    /* renamed from: l, reason: collision with root package name */
    public int f18070l;

    /* renamed from: m, reason: collision with root package name */
    public int f18071m;

    /* renamed from: n, reason: collision with root package name */
    public int f18072n;

    /* renamed from: o, reason: collision with root package name */
    public int f18073o;

    public AmapCellCdma(boolean z10, boolean z11) {
        super(z10, z11);
        this.f18069k = 0;
        this.f18070l = 0;
        this.f18071m = 0;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AmapCell clone() {
        AmapCellCdma amapCellCdma = new AmapCellCdma(this.f18067i, this.f18068j);
        amapCellCdma.a(this);
        amapCellCdma.f18069k = this.f18069k;
        amapCellCdma.f18070l = this.f18070l;
        amapCellCdma.f18071m = this.f18071m;
        amapCellCdma.f18072n = this.f18072n;
        amapCellCdma.f18073o = this.f18073o;
        return amapCellCdma;
    }

    public String toString() {
        return "AmapCellCdma{sid=" + this.f18069k + ", nid=" + this.f18070l + ", bid=" + this.f18071m + ", latitude=" + this.f18072n + ", longitude=" + this.f18073o + ", mcc='" + this.f18060b + "', mnc='" + this.f18061c + "', signalStrength=" + this.f18062d + ", asuLevel=" + this.f18063e + ", lastUpdateSystemMills=" + this.f18064f + ", lastUpdateUtcMills=" + this.f18065g + ", age=" + this.f18066h + ", main=" + this.f18067i + ", newApi=" + this.f18068j + '}';
    }
}
