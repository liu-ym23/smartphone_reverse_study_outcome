package t;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* renamed from: t.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1106f {

    /* renamed from: a, reason: collision with root package name */
    protected AbstractC1101a f22306a;

    /* renamed from: e, reason: collision with root package name */
    protected int f22310e;

    /* renamed from: f, reason: collision with root package name */
    protected String f22311f;

    /* renamed from: i, reason: collision with root package name */
    protected long f22314i;

    /* renamed from: b, reason: collision with root package name */
    protected int f22307b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int[] f22308c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    protected float[][] f22309d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    protected float[] f22312g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    protected boolean f22313h = false;

    /* renamed from: j, reason: collision with root package name */
    protected float f22315j = Float.NaN;

    public String toString() {
        String str = this.f22311f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.f22310e; i5++) {
            str = str + "[" + this.f22308c[i5] + " , " + decimalFormat.format(this.f22309d[i5]) + "] ";
        }
        return str;
    }
}
