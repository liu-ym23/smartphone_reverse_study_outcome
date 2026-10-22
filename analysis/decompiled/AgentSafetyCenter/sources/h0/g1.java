package h0;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4976c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4977f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4978g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4979h;
    public final /* synthetic */ l0 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4980j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f4981k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w.y0 f4982l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ s1.z0 f4983m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f4984n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4985o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Integer f4986p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4987q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Integer f4988r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, l0 l0Var, int i, int i3, w.y0 y0Var, s1.z0 z0Var, int i10, int i11, Integer num, ArrayList arrayList5, Integer num2) {
        super(1);
        this.f4976c = arrayList;
        this.f4977f = arrayList2;
        this.f4978g = arrayList3;
        this.f4979h = arrayList4;
        this.i = l0Var;
        this.f4980j = i;
        this.f4981k = i3;
        this.f4982l = y0Var;
        this.f4983m = z0Var;
        this.f4984n = i10;
        this.f4985o = i11;
        this.f4986p = num;
        this.f4987q = arrayList5;
        this.f4988r = num2;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i;
        s1.n0 n0Var = (s1.n0) obj;
        ArrayList arrayList = this.f4976c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n0Var.g((s1.o0) arrayList.get(i3), 0, 0, 0.0f);
        }
        ArrayList arrayList2 = this.f4977f;
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            n0Var.g((s1.o0) arrayList2.get(i10), 0, 0, 0.0f);
        }
        ArrayList arrayList3 = this.f4978g;
        int size3 = arrayList3.size();
        int i11 = 0;
        while (true) {
            i = this.f4984n;
            if (i11 >= size3) {
                break;
            }
            s1.o0 o0Var = (s1.o0) arrayList3.get(i11);
            int i12 = (this.f4980j - this.f4981k) / 2;
            s1.z0 z0Var = this.f4983m;
            n0Var.g(o0Var, this.f4982l.b(z0Var, z0Var.getLayoutDirection()) + i12, i - this.f4985o, 0.0f);
            i11++;
        }
        ArrayList arrayList4 = this.f4979h;
        int size4 = arrayList4.size();
        for (int i13 = 0; i13 < size4; i13++) {
            s1.o0 o0Var2 = (s1.o0) arrayList4.get(i13);
            Integer num = this.f4986p;
            n0Var.g(o0Var2, 0, i - (num != null ? num.intValue() : 0), 0.0f);
        }
        l0 l0Var = this.i;
        if (l0Var != null) {
            ArrayList arrayList5 = this.f4987q;
            int size5 = arrayList5.size();
            for (int i14 = 0; i14 < size5; i14++) {
                s1.o0 o0Var3 = (s1.o0) arrayList5.get(i14);
                int i15 = l0Var.f5052a;
                Integer num2 = this.f4988r;
                num2.getClass();
                n0Var.g(o0Var3, i15, i - num2.intValue(), 0.0f);
            }
        }
        return jb.v.f6774a;
    }
}
