package s;

import java.util.Arrays;
import java.util.Comparator;
import org.libpag.BuildConfig;
import s.C1044b;

/* loaded from: classes.dex */
public class h extends C1044b {

    /* renamed from: g, reason: collision with root package name */
    private int f20180g;

    /* renamed from: h, reason: collision with root package name */
    private i[] f20181h;

    /* renamed from: i, reason: collision with root package name */
    private i[] f20182i;

    /* renamed from: j, reason: collision with root package name */
    private int f20183j;

    /* renamed from: k, reason: collision with root package name */
    b f20184k;

    /* renamed from: l, reason: collision with root package name */
    C1045c f20185l;

    class a implements Comparator<i> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f20193c - iVar2.f20193c;
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        i f20187a;

        /* renamed from: b, reason: collision with root package name */
        h f20188b;

        public b(h hVar) {
            this.f20188b = hVar;
        }

        public boolean a(i iVar, float f5) {
            boolean z5 = true;
            if (!this.f20187a.f20191a) {
                for (int i5 = 0; i5 < 9; i5++) {
                    float f6 = iVar.f20199i[i5];
                    if (f6 != 0.0f) {
                        float f7 = f6 * f5;
                        if (Math.abs(f7) < 1.0E-4f) {
                            f7 = 0.0f;
                        }
                        this.f20187a.f20199i[i5] = f7;
                    } else {
                        this.f20187a.f20199i[i5] = 0.0f;
                    }
                }
                return true;
            }
            for (int i6 = 0; i6 < 9; i6++) {
                float[] fArr = this.f20187a.f20199i;
                float f8 = fArr[i6] + (iVar.f20199i[i6] * f5);
                fArr[i6] = f8;
                if (Math.abs(f8) < 1.0E-4f) {
                    this.f20187a.f20199i[i6] = 0.0f;
                } else {
                    z5 = false;
                }
            }
            if (z5) {
                h.this.G(this.f20187a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f20187a = iVar;
        }

        public final boolean c() {
            for (int i5 = 8; i5 >= 0; i5--) {
                float f5 = this.f20187a.f20199i[i5];
                if (f5 > 0.0f) {
                    return false;
                }
                if (f5 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i5 = 8;
            while (true) {
                if (i5 < 0) {
                    break;
                }
                float f5 = iVar.f20199i[i5];
                float f6 = this.f20187a.f20199i[i5];
                if (f6 == f5) {
                    i5--;
                } else if (f6 < f5) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f20187a.f20199i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f20187a != null) {
                for (int i5 = 0; i5 < 9; i5++) {
                    str = str + this.f20187a.f20199i[i5] + " ";
                }
            }
            return str + "] " + this.f20187a;
        }
    }

    public h(C1045c c1045c) {
        super(c1045c);
        this.f20180g = 128;
        this.f20181h = new i[128];
        this.f20182i = new i[128];
        this.f20183j = 0;
        this.f20184k = new b(this);
        this.f20185l = c1045c;
    }

    private final void F(i iVar) {
        int i5;
        int i6 = this.f20183j + 1;
        i[] iVarArr = this.f20181h;
        if (i6 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f20181h = iVarArr2;
            this.f20182i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f20181h;
        int i7 = this.f20183j;
        iVarArr3[i7] = iVar;
        int i8 = i7 + 1;
        this.f20183j = i8;
        if (i8 > 1 && iVarArr3[i7].f20193c > iVar.f20193c) {
            int i9 = 0;
            while (true) {
                i5 = this.f20183j;
                if (i9 >= i5) {
                    break;
                }
                this.f20182i[i9] = this.f20181h[i9];
                i9++;
            }
            Arrays.sort(this.f20182i, 0, i5, new a());
            for (int i10 = 0; i10 < this.f20183j; i10++) {
                this.f20181h[i10] = this.f20182i[i10];
            }
        }
        iVar.f20191a = true;
        iVar.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i5 = 0;
        while (i5 < this.f20183j) {
            if (this.f20181h[i5] == iVar) {
                while (true) {
                    int i6 = this.f20183j;
                    if (i5 >= i6 - 1) {
                        this.f20183j = i6 - 1;
                        iVar.f20191a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f20181h;
                        int i7 = i5 + 1;
                        iVarArr[i5] = iVarArr[i7];
                        i5 = i7;
                    }
                }
            } else {
                i5++;
            }
        }
    }

    @Override // s.C1044b
    public void B(d dVar, C1044b c1044b, boolean z5) {
        i iVar = c1044b.f20142a;
        if (iVar == null) {
            return;
        }
        C1044b.a aVar = c1044b.f20146e;
        int iB = aVar.b();
        for (int i5 = 0; i5 < iB; i5++) {
            i iVarE = aVar.e(i5);
            float fH = aVar.h(i5);
            this.f20184k.b(iVarE);
            if (this.f20184k.a(iVar, fH)) {
                F(iVarE);
            }
            this.f20143b += c1044b.f20143b * fH;
        }
        G(iVar);
    }

    @Override // s.C1044b, s.d.a
    public void a(i iVar) {
        this.f20184k.b(iVar);
        this.f20184k.e();
        iVar.f20199i[iVar.f20195e] = 1.0f;
        F(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // s.C1044b, s.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s.i b(s.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f20183j
            if (r0 >= r2) goto L32
            s.i[] r2 = r4.f20181h
            r2 = r2[r0]
            int r3 = r2.f20193c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            s.h$b r3 = r4.f20184k
            r3.b(r2)
            if (r1 != r5) goto L22
            s.h$b r2 = r4.f20184k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            s.h$b r2 = r4.f20184k
            s.i[] r3 = r4.f20181h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r4 = 0
            return r4
        L36:
            s.i[] r4 = r4.f20181h
            r4 = r4[r1]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s.h.b(s.d, boolean[]):s.i");
    }

    @Override // s.C1044b, s.d.a
    public void clear() {
        this.f20183j = 0;
        this.f20143b = 0.0f;
    }

    @Override // s.C1044b, s.d.a
    public boolean isEmpty() {
        return this.f20183j == 0;
    }

    @Override // s.C1044b
    public String toString() {
        String str = BuildConfig.FLAVOR + " goal -> (" + this.f20143b + ") : ";
        for (int i5 = 0; i5 < this.f20183j; i5++) {
            this.f20184k.b(this.f20181h[i5]);
            str = str + this.f20184k + " ";
        }
        return str;
    }
}
