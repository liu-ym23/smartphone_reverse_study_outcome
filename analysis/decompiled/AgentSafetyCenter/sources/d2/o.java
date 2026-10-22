package d2;

import android.graphics.Matrix;
import android.graphics.Shader;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final ad.y f3149a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3150b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3151c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3152d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3153e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3154f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3155g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3156h;

    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public o(ad.y yVar, long j10, int i, boolean z10) {
        float f5;
        q qVar;
        c1.c cVarE;
        int iH;
        boolean z11 = true;
        int i3 = z10 ? 2 : 1;
        this.f3149a = yVar;
        this.f3150b = i;
        if (o2.a.k(j10) != 0 || o2.a.j(j10) != 0) {
            i2.a.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) yVar.f635e;
        int size = arrayList2.size();
        int i10 = 0;
        float f10 = 0.0f;
        int i11 = 0;
        while (i10 < size) {
            r rVar = (r) arrayList2.get(i10);
            k2.d dVar = rVar.f3166a;
            int i12 = o2.a.i(j10);
            if (o2.a.d(j10)) {
                f5 = 0.0f;
                iH = o2.a.h(j10) - ((int) Math.ceil(f10));
                if (iH < 0) {
                    iH = 0;
                }
            } else {
                f5 = 0.0f;
                iH = o2.a.h(j10);
            }
            a aVar = new a(dVar, this.f3150b - i11, i3, o2.b.b(i12, iH, 5));
            float fB = aVar.b() + f10;
            e2.i iVar = aVar.f3039d;
            int i13 = iVar.f3439f + i11;
            int i14 = rVar.f3167b;
            int i15 = rVar.f3168c;
            q qVar2 = new q();
            qVar2.f3159a = aVar;
            qVar2.f3160b = i14;
            qVar2.f3161c = i15;
            qVar2.f3162d = i11;
            qVar2.f3163e = i13;
            qVar2.f3164f = f10;
            qVar2.f3165g = fB;
            VarHandle.storeStoreFence();
            arrayList.add(qVar2);
            if (iVar.f3437d || (i13 == this.f3150b && i10 != ac.a.x((ArrayList) this.f3149a.f635e))) {
                f10 = fB;
                i11 = i13;
                break;
            } else {
                i10++;
                f10 = fB;
                i11 = i13;
            }
        }
        f5 = 0.0f;
        z11 = false;
        this.f3153e = f10;
        this.f3154f = i11;
        this.f3151c = z11;
        this.f3156h = arrayList;
        this.f3152d = o2.a.i(j10);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            q qVar3 = (q) arrayList.get(i16);
            ?? r72 = qVar3.f3159a.f3041f;
            ArrayList arrayList4 = new ArrayList(r72.size());
            int size3 = r72.size();
            int i17 = 0;
            while (i17 < size3) {
                c1.c cVar = (c1.c) r72.get(i17);
                if (cVar != null) {
                    qVar = qVar3;
                    cVarE = cVar.e((Float.floatToRawIntBits(qVar3.f3164f) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
                } else {
                    qVar = qVar3;
                    cVarE = null;
                }
                arrayList4.add(cVarE);
                i17++;
                qVar3 = qVar;
            }
            kb.q.p0(arrayList4, arrayList3);
        }
        if (arrayList3.size() < ((List) this.f3149a.f632b).size()) {
            int size4 = ((List) this.f3149a.f632b).size() - arrayList3.size();
            ArrayList arrayList5 = new ArrayList(size4);
            for (int i18 = 0; i18 < size4; i18++) {
                arrayList5.add(null);
            }
            arrayList3 = kb.l.F0(arrayList3, arrayList5);
        }
        this.f3155g = arrayList3;
    }

    public static void a(o oVar, d1.o oVar2, d1.f0 f0Var, float f5, d1.i0 i0Var, n2.l lVar, td.h hVar) {
        oVar2.i();
        ArrayList arrayList = oVar.f3156h;
        if (arrayList.size() <= 1 || (f0Var instanceof d1.l0)) {
            k2.k.a(oVar, oVar2, f0Var, f5, i0Var, lVar, hVar);
        } else {
            if (!(f0Var instanceof d1.h0)) {
                g5.f.a();
                return;
            }
            int size = arrayList.size();
            float fMax = 0.0f;
            float fB = 0.0f;
            for (int i = 0; i < size; i++) {
                q qVar = (q) arrayList.get(i);
                fB += qVar.f3159a.b();
                fMax = Math.max(fMax, qVar.f3159a.c());
            }
            Shader shaderX = ((d1.h0) f0Var).x((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fB) & 4294967295L));
            Matrix matrix = new Matrix();
            shaderX.getLocalMatrix(matrix);
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                a aVar = ((q) arrayList.get(i3)).f3159a;
                aVar.f(oVar2, new d1.n(shaderX), f5, i0Var, lVar, hVar);
                oVar2.n(0.0f, aVar.b());
                matrix.setTranslate(0.0f, -aVar.b());
                shaderX.setLocalMatrix(matrix);
            }
        }
        oVar2.o();
    }

    public final void b(int i) {
        boolean z10 = false;
        int i3 = this.f3154f;
        if (i >= 0 && i < i3) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        i2.a.a("lineIndex(" + i + ") is out of bounds [0, " + i3 + ')');
    }
}
