package e1;

import b8.z;
import d1.f0;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends c {

    /* renamed from: r, reason: collision with root package name */
    public static final z f3392r = new z(27);

    /* renamed from: d, reason: collision with root package name */
    public final s f3393d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3394e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3395f;

    /* renamed from: g, reason: collision with root package name */
    public final r f3396g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f3397h;
    public final float[] i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f3398j;

    /* renamed from: k, reason: collision with root package name */
    public final i f3399k;

    /* renamed from: l, reason: collision with root package name */
    public final p f3400l;

    /* renamed from: m, reason: collision with root package name */
    public final m f3401m;

    /* renamed from: n, reason: collision with root package name */
    public final i f3402n;

    /* renamed from: o, reason: collision with root package name */
    public final p f3403o;

    /* renamed from: p, reason: collision with root package name */
    public final m f3404p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3405q;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0267  */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(java.lang.String r33, float[] r34, e1.s r35, float[] r36, e1.i r37, e1.i r38, float r39, float r40, e1.r r41, int r42) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.q.<init>(java.lang.String, float[], e1.s, float[], e1.i, e1.i, float, float, e1.r, int):void");
    }

    @Override // e1.c
    public final float a(int i) {
        return this.f3395f;
    }

    @Override // e1.c
    public final float b(int i) {
        return this.f3394e;
    }

    @Override // e1.c
    public final boolean c() {
        return this.f3405q;
    }

    @Override // e1.c
    public final long d(float f5, float f10, float f11) {
        double d7 = f5;
        m mVar = this.f3404p;
        float fB = (float) mVar.b(d7);
        float fB2 = (float) mVar.b(f10);
        float fB3 = (float) mVar.b(f11);
        float[] fArr = this.i;
        if (fArr.length < 9) {
            return 0L;
        }
        float f12 = (fArr[6] * fB3) + (fArr[3] * fB2) + (fArr[0] * fB);
        float f13 = (fArr[7] * fB3) + (fArr[4] * fB2) + (fArr[1] * fB);
        return (Float.floatToRawIntBits(f12) << 32) | (4294967295L & Float.floatToRawIntBits(f13));
    }

    @Override // e1.c
    public final float e(float f5, float f10, float f11) {
        double d7 = f5;
        m mVar = this.f3404p;
        float fB = (float) mVar.b(d7);
        float fB2 = (float) mVar.b(f10);
        float fB3 = (float) mVar.b(f11);
        float[] fArr = this.i;
        return (fArr[8] * fB3) + (fArr[5] * fB2) + (fArr[2] * fB);
    }

    @Override // e1.c
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        q qVar = (q) obj;
        if (Float.compare(qVar.f3394e, this.f3394e) != 0 || Float.compare(qVar.f3395f, this.f3395f) != 0 || !yb.k.a(this.f3393d, qVar.f3393d) || !Arrays.equals(this.f3397h, qVar.f3397h)) {
            return false;
        }
        r rVar = qVar.f3396g;
        r rVar2 = this.f3396g;
        if (rVar2 != null) {
            return yb.k.a(rVar2, rVar);
        }
        if (rVar == null) {
            return true;
        }
        if (yb.k.a(this.f3399k, qVar.f3399k)) {
            return yb.k.a(this.f3402n, qVar.f3402n);
        }
        return false;
    }

    @Override // e1.c
    public final long f(float f5, float f10, float f11, float f12, c cVar) {
        float[] fArr = this.f3398j;
        float f13 = (fArr[6] * f11) + (fArr[3] * f10) + (fArr[0] * f5);
        float f14 = (fArr[7] * f11) + (fArr[4] * f10) + (fArr[1] * f5);
        float f15 = (fArr[8] * f11) + (fArr[5] * f10) + (fArr[2] * f5);
        m mVar = this.f3401m;
        return f0.a((float) mVar.b(f13), (float) mVar.b(f14), (float) mVar.b(f15), f12, cVar);
    }

    @Override // e1.c
    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.f3397h) + ((this.f3393d.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f5 = this.f3394e;
        int iFloatToIntBits = (iHashCode + (f5 == 0.0f ? 0 : Float.floatToIntBits(f5))) * 31;
        float f10 = this.f3395f;
        int iFloatToIntBits2 = (iFloatToIntBits + (f10 == 0.0f ? 0 : Float.floatToIntBits(f10))) * 31;
        r rVar = this.f3396g;
        int iHashCode2 = iFloatToIntBits2 + (rVar != null ? rVar.hashCode() : 0);
        if (rVar != null) {
            return iHashCode2;
        }
        return this.f3402n.hashCode() + ((this.f3399k.hashCode() + (iHashCode2 * 31)) * 31);
    }

    public q(String str, float[] fArr, s sVar, r rVar, int i) {
        double d7;
        o oVar;
        o oVar2;
        double d10 = rVar.f3406a;
        int i3 = 0;
        int i10 = 1;
        boolean z10 = d10 == -3.0d;
        double d11 = rVar.f3412g;
        double d12 = rVar.f3411f;
        if (z10) {
            d7 = -3.0d;
            oVar = new o(4);
            oVar.f3389b = rVar;
            VarHandle.storeStoreFence();
        } else {
            d7 = -3.0d;
            if (d10 == -2.0d) {
                oVar = new o(5);
                oVar.f3389b = rVar;
                VarHandle.storeStoreFence();
            } else if (d12 == 0.0d && d11 == 0.0d) {
                oVar = new o(6);
                oVar.f3389b = rVar;
                VarHandle.storeStoreFence();
            } else {
                oVar = new o(7);
                oVar.f3389b = rVar;
                VarHandle.storeStoreFence();
            }
        }
        if (d10 == d7) {
            oVar2 = new o(i3);
            oVar2.f3389b = rVar;
            VarHandle.storeStoreFence();
        } else if (d10 == -2.0d) {
            oVar2 = new o(i10);
            oVar2.f3389b = rVar;
            VarHandle.storeStoreFence();
        } else if (d12 == 0.0d && d11 == 0.0d) {
            oVar2 = new o(2);
            oVar2.f3389b = rVar;
            VarHandle.storeStoreFence();
        } else {
            oVar2 = new o(3);
            oVar2.f3389b = rVar;
            VarHandle.storeStoreFence();
        }
        this(str, fArr, sVar, null, oVar, oVar2, 0.0f, 1.0f, rVar, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [b8.z] */
    /* JADX WARN: Type inference failed for: r3v2, types: [e1.n] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public q(String str, float[] fArr, s sVar, double d7, float f5, float f10, int i) {
        n nVar;
        i nVar2 = f3392r;
        if (d7 == 1.0d) {
            nVar = nVar2;
        } else {
            n nVar3 = new n(0);
            nVar3.f3387b = d7;
            VarHandle.storeStoreFence();
            nVar = nVar3;
        }
        if (d7 != 1.0d) {
            nVar2 = new n(1);
            nVar2.f3387b = d7;
            VarHandle.storeStoreFence();
        }
        this(str, fArr, sVar, null, nVar, nVar2, f5, f10, new r(d7, 1.0d, 0.0d, 0.0d, 0.0d), i);
    }
}
