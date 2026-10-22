package rc;

/* loaded from: classes5.dex */
public class K {

    /* renamed from: e, reason: collision with root package name */
    public static K[] f39113e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[][][] f39114f;

    /* renamed from: a, reason: collision with root package name */
    public final float f39115a;

    /* renamed from: b, reason: collision with root package name */
    public final float f39116b;

    /* renamed from: c, reason: collision with root package name */
    public final float f39117c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39118d;

    static {
        M m10 = new M();
        f39113e = m10.e();
        f39114f = m10.c();
    }

    public K(float f10, float f11, float f12, String str) {
        this.f39115a = f10;
        this.f39116b = f11;
        this.f39117c = f12;
        this.f39118d = str;
    }

    public static AbstractC5284h b(int i10, int i11, Y0 y02) {
        if (i10 > 7) {
            i10 = 0;
        }
        if (i11 > 7) {
            i11 = 0;
        }
        return f39113e[f39114f[i10][i11][y02.m() / 2]].a(y02);
    }

    public final AbstractC5284h a(Y0 y02) {
        Z0 z0N = y02.n();
        float fO = z0N.O(y02.m(), z0N.I());
        return new L((this.f39115a / 18.0f) * fO, (this.f39116b / 18.0f) * fO, (this.f39117c / 18.0f) * fO);
    }

    public String c() {
        return this.f39118d;
    }
}
