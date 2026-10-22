package com.amap.location.support.bean.cell;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellWcdma extends AmapCell implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public int f18088k;

    /* renamed from: l, reason: collision with root package name */
    public int f18089l;

    /* renamed from: m, reason: collision with root package name */
    public int f18090m;

    /* renamed from: n, reason: collision with root package name */
    public int f18091n;

    public AmapCellWcdma(boolean z10, boolean z11) {
        super(z10, z11);
        this.f18088k = 0;
        this.f18089l = 0;
        this.f18090m = Integer.MAX_VALUE;
        this.f18091n = Integer.MAX_VALUE;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AmapCell clone() {
        AmapCellWcdma amapCellWcdma = new AmapCellWcdma(this.f18067i, this.f18068j);
        amapCellWcdma.a(this);
        amapCellWcdma.f18088k = this.f18088k;
        amapCellWcdma.f18089l = this.f18089l;
        amapCellWcdma.f18090m = this.f18090m;
        amapCellWcdma.f18091n = this.f18091n;
        return amapCellWcdma;
    }

    public String toString() {
        return "AmapCellWcdma{lac=" + this.f18088k + ", cid=" + this.f18089l + ", psc=" + this.f18090m + ", uarfcn=" + this.f18091n + ", mcc='" + this.f18060b + "', mnc='" + this.f18061c + "', signalStrength=" + this.f18062d + ", asuLevel=" + this.f18063e + ", lastUpdateSystemMills=" + this.f18064f + ", lastUpdateUtcMills=" + this.f18065g + ", age=" + this.f18066h + ", main=" + this.f18067i + ", newApi=" + this.f18068j + '}';
    }
}
