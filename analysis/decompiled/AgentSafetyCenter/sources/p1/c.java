package p1;

import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f9685a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9686b;

    /* renamed from: c, reason: collision with root package name */
    public final a[] f9687c;

    /* renamed from: d, reason: collision with root package name */
    public int f9688d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f9689e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f9690f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f9691g;

    public c() {
        int i;
        b bVar = b.f9683c;
        this.f9685a = bVar;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            i = 3;
        } else {
            if (iOrdinal != 1) {
                f.a();
                throw null;
            }
            i = 2;
        }
        this.f9686b = i;
        this.f9687c = new a[20];
        this.f9689e = new float[20];
        this.f9690f = new float[20];
        this.f9691g = new float[3];
    }

    public final void a(float f5, long j10) {
        int i = (this.f9688d + 1) % 20;
        this.f9688d = i;
        a[] aVarArr = this.f9687c;
        a aVar = aVarArr[i];
        if (aVar != null) {
            aVar.f9681a = j10;
            aVar.f9682b = f5;
        } else {
            a aVar2 = new a();
            aVar2.f9681a = j10;
            aVar2.f9682b = f5;
            aVarArr[i] = aVar2;
        }
    }

    public final float b(float f5) {
        float[] fArr;
        float[] fArr2;
        float f10;
        b bVar;
        int i;
        float f11;
        float fSignum;
        float f12 = 0.0f;
        if (f5 <= 0.0f) {
            r1.a.b("maximumVelocity should be a positive value. You specified=" + f5);
        }
        int i3 = this.f9688d;
        a[] aVarArr = this.f9687c;
        a aVar = aVarArr[i3];
        if (aVar == null) {
            f11 = 0.0f;
            f10 = 0.0f;
        } else {
            int i10 = 0;
            a aVar2 = aVar;
            while (true) {
                a aVar3 = aVarArr[i3];
                b bVar2 = this.f9685a;
                fArr = this.f9689e;
                fArr2 = this.f9690f;
                if (aVar3 == null) {
                    f10 = f12;
                    bVar = bVar2;
                    i = 1;
                    break;
                }
                long j10 = aVar.f9681a;
                f10 = f12;
                int i11 = i3;
                long j11 = aVar3.f9681a;
                float f13 = j10 - j11;
                i = 1;
                float fAbs = Math.abs(j11 - aVar2.f9681a);
                bVar = bVar2;
                a aVar4 = bVar != b.f9683c ? aVar : aVar3;
                if (f13 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                fArr[i10] = aVar3.f9682b;
                fArr2[i10] = -f13;
                if (i11 == 0) {
                    i11 = 20;
                }
                int i12 = i11 - 1;
                i10++;
                if (i10 >= 20) {
                    break;
                }
                aVar2 = aVar4;
                i3 = i12;
                f12 = f10;
            }
            if (i10 >= this.f9686b) {
                int iOrdinal = bVar.ordinal();
                if (iOrdinal == 0) {
                    try {
                        float[] fArr3 = this.f9691g;
                        id.c.C(fArr2, fArr, i10, fArr3);
                        fSignum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                        fSignum = f10;
                    }
                } else {
                    if (iOrdinal != i) {
                        f.a();
                        return 0.0f;
                    }
                    int i13 = i10 - i;
                    float f14 = fArr2[i13];
                    int i14 = i13;
                    float fAbs2 = f10;
                    while (i14 > 0) {
                        int i15 = i14 - 1;
                        float f15 = fArr2[i15];
                        if (f14 != f15) {
                            float f16 = (fArr[i14] - fArr[i15]) / (f14 - f15);
                            fAbs2 += Math.abs(f16) * (f16 - (Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2))));
                            if (i14 == i13) {
                                fAbs2 *= 0.5f;
                            }
                        }
                        i14--;
                        f14 = f15;
                    }
                    fSignum = Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2));
                }
                f11 = fSignum * 1000;
            } else {
                f11 = f10;
            }
        }
        if (f11 == f10 || Float.isNaN(f11)) {
            return f10;
        }
        if (f11 <= f10) {
            float f17 = -f5;
            if (f11 < f17) {
                return f17;
            }
        } else if (f11 > f5) {
            f11 = f5;
        }
        return f11;
    }
}
