package b0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1340a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1341b;

    /* renamed from: c, reason: collision with root package name */
    public int f1342c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1343d;

    /* renamed from: e, reason: collision with root package name */
    public final k.t f1344e;

    /* renamed from: f, reason: collision with root package name */
    public final c7.o f1345f;

    public s1(int i2, ArrayList arrayList) {
        this.f1340a = arrayList;
        this.f1341b = i2;
        if (i2 < 0) {
            u1.a("Invalid start index");
        }
        this.f1343d = new ArrayList();
        k.t tVar = new k.t();
        int size = arrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            v0 v0Var = (v0) this.f1340a.get(i11);
            int i12 = v0Var.f1382c;
            int i13 = v0Var.f1383d;
            tVar.g(i12, new o0(i11, i10, i13));
            i10 += i13;
        }
        this.f1344e = tVar;
        this.f1345f = s7.a.H(new r1(0, this));
    }

    public final boolean a(int i2, int i10) {
        int i11;
        k.t tVar = this.f1344e;
        o0 o0Var = (o0) tVar.b(i2);
        if (o0Var == null) {
            return false;
        }
        int i12 = o0Var.f1253b;
        int i13 = i10 - o0Var.f1254c;
        o0Var.f1254c = i10;
        if (i13 == 0) {
            return true;
        }
        Object[] objArr = tVar.f5500c;
        long[] jArr = tVar.f5498a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i14 = 0;
        while (true) {
            long j2 = jArr[i14];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i15 = 8 - ((~(i14 - length)) >>> 31);
                for (int i16 = 0; i16 < i15; i16++) {
                    if ((255 & j2) < 128) {
                        o0 o0Var2 = (o0) objArr[(i14 << 3) + i16];
                        if (o0Var2.f1253b >= i12 && !o0Var2.equals(o0Var) && (i11 = o0Var2.f1253b + i13) >= 0) {
                            o0Var2.f1253b = i11;
                        }
                    }
                    j2 >>= 8;
                }
                if (i15 != 8) {
                    return true;
                }
            }
            if (i14 == length) {
                return true;
            }
            i14++;
        }
    }
}
