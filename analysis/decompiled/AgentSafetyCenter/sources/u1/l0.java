package u1;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 implements o2.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f13861c;

    /* renamed from: f, reason: collision with root package name */
    public long f13862f;

    /* renamed from: g, reason: collision with root package name */
    public long f13863g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ o0 f13864h;

    @Override // o2.c
    public final float T() {
        return this.f13864h.T();
    }

    @Override // o2.c
    public final float a() {
        return this.f13864h.a();
    }

    public final void b(s1.n nVar, float f5) {
        o0 o0Var = this.f13864h;
        ed.o oVar = o0Var.f13884q;
        if (oVar == null) {
            oVar = new ed.o();
            o0Var.f13884q = oVar;
        }
        int iR0 = kb.k.r0((s1.n[]) oVar.f3838b, nVar);
        if (iR0 >= 0) {
            float[] fArr = (float[]) oVar.f3839c;
            if (fArr[iR0] != f5) {
                fArr[iR0] = f5;
                ((byte[]) oVar.f3840d)[iR0] = 1;
                return;
            } else {
                byte[] bArr = (byte[]) oVar.f3840d;
                if (bArr[iR0] == 2) {
                    bArr[iR0] = 0;
                    return;
                }
                return;
            }
        }
        int i = oVar.f3837a;
        s1.n[] nVarArr = (s1.n[]) oVar.f3838b;
        if (i == nVarArr.length) {
            int i3 = i * 2;
            oVar.f3838b = (s1.n[]) Arrays.copyOf(nVarArr, i3);
            oVar.f3839c = Arrays.copyOf((float[]) oVar.f3839c, i3);
            oVar.f3840d = Arrays.copyOf((byte[]) oVar.f3840d, i3);
        }
        ((s1.n[]) oVar.f3838b)[i] = nVar;
        ((byte[]) oVar.f3840d)[i] = 3;
        ((float[]) oVar.f3839c)[i] = f5;
        oVar.f3837a++;
    }
}
