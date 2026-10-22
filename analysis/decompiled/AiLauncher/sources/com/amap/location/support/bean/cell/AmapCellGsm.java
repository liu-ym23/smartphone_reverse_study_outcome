package com.amap.location.support.bean.cell;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellGsm extends AmapCell implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public int f18074k;

    /* renamed from: l, reason: collision with root package name */
    public int f18075l;

    /* renamed from: m, reason: collision with root package name */
    public int f18076m;

    /* renamed from: n, reason: collision with root package name */
    public int f18077n;

    /* renamed from: o, reason: collision with root package name */
    public int f18078o;

    /* renamed from: p, reason: collision with root package name */
    public int f18079p;

    public AmapCellGsm(boolean z10, boolean z11) {
        super(z10, z11);
        this.f18074k = 0;
        this.f18075l = 0;
        this.f18076m = Integer.MAX_VALUE;
        this.f18077n = Integer.MAX_VALUE;
        this.f18078o = Integer.MAX_VALUE;
        this.f18079p = Integer.MAX_VALUE;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AmapCell clone() {
        AmapCellGsm amapCellGsm = new AmapCellGsm(this.f18067i, this.f18068j);
        amapCellGsm.a(this);
        amapCellGsm.f18074k = this.f18074k;
        amapCellGsm.f18075l = this.f18075l;
        amapCellGsm.f18076m = this.f18076m;
        amapCellGsm.f18077n = this.f18077n;
        amapCellGsm.f18078o = this.f18078o;
        amapCellGsm.f18079p = this.f18079p;
        return amapCellGsm;
    }

    public String toString() {
        return "AmapCellGsm{lac=" + this.f18074k + ", cid=" + this.f18075l + ", psc=" + this.f18076m + ", arfcn=" + this.f18077n + ", bsic=" + this.f18078o + ", timingAdvance=" + this.f18079p + ", mcc='" + this.f18060b + "', mnc='" + this.f18061c + "', signalStrength=" + this.f18062d + ", asuLevel=" + this.f18063e + ", lastUpdateSystemMills=" + this.f18064f + ", lastUpdateUtcMills=" + this.f18065g + ", age=" + this.f18066h + ", main=" + this.f18067i + ", newApi=" + this.f18068j + '}';
    }
}
