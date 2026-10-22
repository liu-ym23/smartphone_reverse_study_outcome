package v;

import java.util.ArrayList;
import java.util.Arrays;
import w.o;

/* loaded from: classes.dex */
public class j extends e implements i {

    /* renamed from: L0, reason: collision with root package name */
    public e[] f23197L0 = new e[4];

    /* renamed from: M0, reason: collision with root package name */
    public int f23198M0 = 0;

    @Override // v.i
    public void a() {
        this.f23198M0 = 0;
        Arrays.fill(this.f23197L0, (Object) null);
    }

    @Override // v.i
    public void b(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i5 = this.f23198M0 + 1;
        e[] eVarArr = this.f23197L0;
        if (i5 > eVarArr.length) {
            this.f23197L0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f23197L0;
        int i6 = this.f23198M0;
        eVarArr2[i6] = eVar;
        this.f23198M0 = i6 + 1;
    }

    @Override // v.i
    public void c(f fVar) {
    }

    public void r1(ArrayList<o> arrayList, int i5, o oVar) {
        for (int i6 = 0; i6 < this.f23198M0; i6++) {
            oVar.a(this.f23197L0[i6]);
        }
        for (int i7 = 0; i7 < this.f23198M0; i7++) {
            w.i.a(this.f23197L0[i7], i5, arrayList, oVar);
        }
    }

    public int s1(int i5) {
        int i6;
        int i7;
        for (int i8 = 0; i8 < this.f23198M0; i8++) {
            e eVar = this.f23197L0[i8];
            if (i5 == 0 && (i7 = eVar.f23037I0) != -1) {
                return i7;
            }
            if (i5 == 1 && (i6 = eVar.f23039J0) != -1) {
                return i6;
            }
        }
        return -1;
    }
}
