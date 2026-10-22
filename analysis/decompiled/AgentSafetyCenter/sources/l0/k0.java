package l0;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends p5.f {

    /* renamed from: d, reason: collision with root package name */
    public int f7689d;

    /* renamed from: f, reason: collision with root package name */
    public int f7691f;

    /* renamed from: h, reason: collision with root package name */
    public int f7693h;

    /* renamed from: c, reason: collision with root package name */
    public i0[] f7688c = new i0[16];

    /* renamed from: e, reason: collision with root package name */
    public int[] f7690e = new int[16];

    /* renamed from: g, reason: collision with root package name */
    public Object[] f7692g = new Object[16];

    public final void P() {
        this.f7689d = 0;
        this.f7691f = 0;
        Arrays.fill(this.f7692g, 0, this.f7693h, (Object) null);
        this.f7693h = 0;
    }

    public final void Q(k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        if (S()) {
            androidx.datastore.preferences.protobuf.j jVar = new androidx.datastore.preferences.protobuf.j();
            jVar.f1137d = this;
            VarHandle.storeStoreFence();
            while (true) {
                i0 i0Var = ((k0) jVar.f1137d).f7688c[jVar.f1134a];
                k0.b bVarB = i0Var.b(jVar);
                k0.d dVar2 = dVar;
                i2 i2Var2 = i2Var;
                s0.i iVar2 = iVar;
                j0 j0Var2 = j0Var;
                try {
                    i0Var.a(jVar, dVar2, i2Var2, iVar2, j0Var2);
                    int i = jVar.f1134a;
                    k0 k0Var = (k0) jVar.f1137d;
                    int i3 = k0Var.f7689d;
                    if (i < i3) {
                        i0 i0Var2 = k0Var.f7688c[i];
                        jVar.f1135b += i0Var2.f7684a;
                        jVar.f1136c += i0Var2.f7685b;
                        int i10 = i + 1;
                        jVar.f1134a = i10;
                        if (i10 >= i3) {
                            break;
                        }
                        dVar = dVar2;
                        i2Var = i2Var2;
                        iVar = iVar2;
                        j0Var = j0Var2;
                    } else {
                        break;
                    }
                } finally {
                }
            }
        }
        P();
    }

    public final boolean R() {
        return this.f7689d == 0;
    }

    public final boolean S() {
        return this.f7689d != 0;
    }

    public final void T(i0 i0Var) {
        int i = this.f7689d;
        i0[] i0VarArr = this.f7688c;
        if (i == i0VarArr.length) {
            i0[] i0VarArr2 = new i0[(i > 1024 ? 1024 : i) + i];
            System.arraycopy(i0VarArr, 0, i0VarArr2, 0, i);
            this.f7688c = i0VarArr2;
        }
        int i3 = this.f7691f;
        int i10 = i0Var.f7684a;
        int i11 = i0Var.f7685b;
        int i12 = i3 + i10;
        int[] iArr = this.f7690e;
        int length = iArr.length;
        if (i12 > length) {
            int i13 = (length > 1024 ? 1024 : length) + length;
            if (i13 >= i12) {
                i12 = i13;
            }
            int[] iArr2 = new int[i12];
            kb.k.f0(0, 0, iArr, iArr2, length);
            this.f7690e = iArr2;
        }
        int i14 = this.f7693h + i11;
        Object[] objArr = this.f7692g;
        int length2 = objArr.length;
        if (i14 > length2) {
            int i15 = (length2 <= 1024 ? length2 : 1024) + length2;
            if (i15 >= i14) {
                i14 = i15;
            }
            Object[] objArr2 = new Object[i14];
            System.arraycopy(objArr, 0, objArr2, 0, length2);
            this.f7692g = objArr2;
        }
        i0[] i0VarArr3 = this.f7688c;
        int i16 = this.f7689d;
        this.f7689d = i16 + 1;
        i0VarArr3[i16] = i0Var;
        this.f7691f += i0Var.f7684a;
        this.f7693h += i11;
    }
}
