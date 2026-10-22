package t;

import java.text.DecimalFormat;

/* renamed from: t.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1105e {

    /* renamed from: a, reason: collision with root package name */
    protected AbstractC1101a f22301a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f22302b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    protected float[] f22303c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    private int f22304d;

    /* renamed from: e, reason: collision with root package name */
    private String f22305e;

    public float a(float f5) {
        return (float) this.f22301a.a(f5, 0);
    }

    public String toString() {
        String str = this.f22305e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.f22304d; i5++) {
            str = str + "[" + this.f22302b[i5] + " , " + decimalFormat.format(this.f22303c[i5]) + "] ";
        }
        return str;
    }
}
