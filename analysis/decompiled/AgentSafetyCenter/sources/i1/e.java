package i1;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5636a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5637b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5638c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5639d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5640e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5641f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5642g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5643h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final d f5644j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5645k;

    public e(String str, float f5, float f10, float f11, float f12, long j10, int i, boolean z10, int i3) {
        str = (i3 & 1) != 0 ? "" : str;
        long j11 = (i3 & 32) != 0 ? d1.p.f3024g : j10;
        int i10 = (i3 & 64) != 0 ? 5 : i;
        this.f5636a = str;
        this.f5637b = f5;
        this.f5638c = f10;
        this.f5639d = f11;
        this.f5640e = f12;
        this.f5641f = j11;
        this.f5642g = i10;
        this.f5643h = z10;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        d dVar = new d(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS);
        this.f5644j = dVar;
        arrayList.add(dVar);
    }

    public static g0 c(d dVar) {
        String str = dVar.f5625a;
        float f5 = dVar.f5626b;
        float f10 = dVar.f5627c;
        float f11 = dVar.f5628d;
        float f12 = dVar.f5629e;
        float f13 = dVar.f5630f;
        float f14 = dVar.f5631g;
        float f15 = dVar.f5632h;
        List list = dVar.i;
        ArrayList arrayList = dVar.f5633j;
        g0 g0Var = new g0();
        g0Var.f5673c = str;
        g0Var.f5674f = f5;
        g0Var.f5675g = f10;
        g0Var.f5676h = f11;
        g0Var.i = f12;
        g0Var.f5677j = f13;
        g0Var.f5678k = f14;
        g0Var.f5679l = f15;
        g0Var.f5680m = list;
        g0Var.f5681n = arrayList;
        VarHandle.storeStoreFence();
        return g0Var;
    }

    public final void a(List list, int i, String str, d1.f0 f0Var, float f5, d1.f0 f0Var2, float f10, float f11, int i3, int i10, float f12, float f13, float f14, float f15) {
        if (this.f5645k) {
            r1.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }
        ArrayList arrayList = ((d) this.i.get(r1.size() - 1)).f5633j;
        k0 k0Var = new k0();
        k0Var.f5720c = str;
        k0Var.f5721f = list;
        k0Var.f5722g = i;
        k0Var.f5723h = f0Var;
        k0Var.i = f5;
        k0Var.f5724j = f0Var2;
        k0Var.f5725k = f10;
        k0Var.f5726l = f11;
        k0Var.f5727m = i3;
        k0Var.f5728n = i10;
        k0Var.f5729o = f12;
        k0Var.f5730p = f13;
        k0Var.f5731q = f14;
        k0Var.f5732r = f15;
        VarHandle.storeStoreFence();
        arrayList.add(k0Var);
    }

    public final f d() {
        int i;
        if (this.f5645k) {
            r1.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }
        while (this.i.size() > 1) {
            ArrayList arrayList = this.i;
            if (this.f5645k) {
                r1.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
            ((d) arrayList.get(arrayList.size() - 1)).f5633j.add(c((d) arrayList.remove(arrayList.size() - 1)));
        }
        String str = this.f5636a;
        float f5 = this.f5637b;
        float f10 = this.f5638c;
        float f11 = this.f5639d;
        float f12 = this.f5640e;
        g0 g0VarC = c(this.f5644j);
        long j10 = this.f5641f;
        int i3 = this.f5642g;
        boolean z10 = this.f5643h;
        synchronized (f.f5658l) {
            i = f.f5657k;
            f.f5657k = i + 1;
        }
        f fVar = new f();
        fVar.f5659a = str;
        fVar.f5660b = f5;
        fVar.f5661c = f10;
        fVar.f5662d = f11;
        fVar.f5663e = f12;
        fVar.f5664f = g0VarC;
        fVar.f5665g = j10;
        fVar.f5666h = i3;
        fVar.i = z10;
        fVar.f5667j = i;
        VarHandle.storeStoreFence();
        this.f5645k = true;
        return fVar;
    }
}
