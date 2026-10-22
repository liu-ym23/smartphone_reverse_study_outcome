package s;

import java.util.Arrays;
import java.util.HashSet;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class i implements Comparable<i> {

    /* renamed from: r, reason: collision with root package name */
    private static int f20190r = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f20191a;

    /* renamed from: b, reason: collision with root package name */
    private String f20192b;

    /* renamed from: f, reason: collision with root package name */
    public float f20196f;

    /* renamed from: j, reason: collision with root package name */
    a f20200j;

    /* renamed from: c, reason: collision with root package name */
    public int f20193c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f20194d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f20195e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20197g = false;

    /* renamed from: h, reason: collision with root package name */
    float[] f20198h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    float[] f20199i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    C1044b[] f20201k = new C1044b[16];

    /* renamed from: l, reason: collision with root package name */
    int f20202l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f20203m = 0;

    /* renamed from: n, reason: collision with root package name */
    boolean f20204n = false;

    /* renamed from: o, reason: collision with root package name */
    int f20205o = -1;

    /* renamed from: p, reason: collision with root package name */
    float f20206p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    HashSet<C1044b> f20207q = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f20200j = aVar;
    }

    static void e() {
        f20190r++;
    }

    public final void b(C1044b c1044b) {
        int i5 = 0;
        while (true) {
            int i6 = this.f20202l;
            if (i5 >= i6) {
                C1044b[] c1044bArr = this.f20201k;
                if (i6 >= c1044bArr.length) {
                    this.f20201k = (C1044b[]) Arrays.copyOf(c1044bArr, c1044bArr.length * 2);
                }
                C1044b[] c1044bArr2 = this.f20201k;
                int i7 = this.f20202l;
                c1044bArr2[i7] = c1044b;
                this.f20202l = i7 + 1;
                return;
            }
            if (this.f20201k[i5] == c1044b) {
                return;
            } else {
                i5++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f20193c - iVar.f20193c;
    }

    public final void g(C1044b c1044b) {
        int i5 = this.f20202l;
        int i6 = 0;
        while (i6 < i5) {
            if (this.f20201k[i6] == c1044b) {
                while (i6 < i5 - 1) {
                    C1044b[] c1044bArr = this.f20201k;
                    int i7 = i6 + 1;
                    c1044bArr[i6] = c1044bArr[i7];
                    i6 = i7;
                }
                this.f20202l--;
                return;
            }
            i6++;
        }
    }

    public void h() {
        this.f20192b = null;
        this.f20200j = a.UNKNOWN;
        this.f20195e = 0;
        this.f20193c = -1;
        this.f20194d = -1;
        this.f20196f = 0.0f;
        this.f20197g = false;
        this.f20204n = false;
        this.f20205o = -1;
        this.f20206p = 0.0f;
        int i5 = this.f20202l;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f20201k[i6] = null;
        }
        this.f20202l = 0;
        this.f20203m = 0;
        this.f20191a = false;
        Arrays.fill(this.f20199i, 0.0f);
    }

    public void i(d dVar, float f5) {
        this.f20196f = f5;
        this.f20197g = true;
        this.f20204n = false;
        this.f20205o = -1;
        this.f20206p = 0.0f;
        int i5 = this.f20202l;
        this.f20194d = -1;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f20201k[i6].A(dVar, this, false);
        }
        this.f20202l = 0;
    }

    public void j(a aVar, String str) {
        this.f20200j = aVar;
    }

    public final void k(d dVar, C1044b c1044b) {
        int i5 = this.f20202l;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f20201k[i6].B(dVar, c1044b, false);
        }
        this.f20202l = 0;
    }

    public String toString() {
        if (this.f20192b != null) {
            return BuildConfig.FLAVOR + this.f20192b;
        }
        return BuildConfig.FLAVOR + this.f20193c;
    }
}
