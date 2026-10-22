package s;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 implements u {

    /* renamed from: a, reason: collision with root package name */
    public wd.a f11016a;

    /* JADX WARN: Type inference failed for: r5v11, types: [xb.l, yb.l] */
    @Override // s.u, s.h
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final o1 a(n6.a aVar) {
        int[] iArr;
        Object[] objArr;
        int[] iArr2;
        Object[] objArr2;
        int i;
        wd.a aVar2 = this.f11016a;
        p.u uVar = (p.u) aVar2.f15390g;
        p.t tVar = new p.t(uVar.f9584e + 2);
        p.u uVar2 = new p.u(uVar.f9584e);
        int[] iArr3 = uVar.f9581b;
        Object[] objArr3 = uVar.f9582c;
        long[] jArr = uVar.f9580a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j10 = jArr[i3];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8;
                    int i11 = 8 - ((~(i3 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((255 & j10) < 128) {
                            int i13 = (i3 << 3) + i12;
                            int i14 = iArr3[i13];
                            g0 g0Var = (g0) objArr3[i13];
                            tVar.a(i14);
                            i = i10;
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            n nVar = (n) ((yb.l) aVar.f8776c).invoke(g0Var.f11013a);
                            v vVar = g0Var.f11014b;
                            n1 n1Var = new n1();
                            n1Var.f11060a = nVar;
                            n1Var.f11061b = vVar;
                            VarHandle.storeStoreFence();
                            uVar2.h(i14, n1Var);
                        } else {
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            i = i10;
                        }
                        j10 >>= i;
                        i12++;
                        i10 = i;
                        iArr3 = iArr2;
                        objArr3 = objArr2;
                    }
                    iArr = iArr3;
                    objArr = objArr3;
                    if (i11 != i10) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    objArr = objArr3;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                iArr3 = iArr;
                objArr3 = objArr;
            }
        }
        if (!uVar.a(0)) {
            int i15 = tVar.f9630b;
            if (i15 < 0) {
                g5.f.q("Index must be between 0 and size");
                return null;
            }
            tVar.b(i15 + 1);
            int[] iArr4 = tVar.f9629a;
            int i16 = tVar.f9630b;
            if (i16 != 0) {
                kb.k.f0(1, 0, iArr4, iArr4, i16);
            }
            iArr4[0] = 0;
            tVar.f9630b++;
        }
        if (!uVar.a(aVar2.f15389f)) {
            tVar.a(aVar2.f15389f);
        }
        int i17 = tVar.f9630b;
        if (i17 != 0) {
            int[] iArr5 = tVar.f9629a;
            iArr5.getClass();
            Arrays.sort(iArr5, 0, i17);
        }
        int i18 = aVar2.f15389f;
        od.f fVar = w.f11153b;
        o1 o1Var = new o1();
        o1Var.f11064c = tVar;
        o1Var.f11065f = uVar2;
        o1Var.f11066g = i18;
        o1Var.f11067h = fVar;
        VarHandle.storeStoreFence();
        return o1Var;
    }
}
