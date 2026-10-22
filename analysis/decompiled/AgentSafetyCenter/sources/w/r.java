package w;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s1.o0[] f15035c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f15036f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s1.h0 f15037g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ yb.s f15038h;
    public final /* synthetic */ yb.s i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s f15039j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s1.o0[] o0VarArr, List list, s1.h0 h0Var, yb.s sVar, yb.s sVar2, s sVar3) {
        super(1);
        this.f15035c = o0VarArr;
        this.f15036f = list;
        this.f15037g = h0Var;
        this.f15038h = sVar;
        this.i = sVar2;
        this.f15039j = sVar3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        s1.n0 n0Var = (s1.n0) obj;
        s1.o0[] o0VarArr = this.f15035c;
        int length = o0VarArr.length;
        int i = 0;
        int i3 = 0;
        while (i3 < length) {
            int i10 = i;
            s1.o0 o0Var = o0VarArr[i3];
            o0Var.getClass();
            p.b(n0Var, o0Var, (s1.e0) this.f15036f.get(i10), this.f15037g.getLayoutDirection(), this.f15038h.f16096c, this.i.f16096c, this.f15039j.f15042a);
            i3++;
            i = i10 + 1;
        }
        return jb.v.f6774a;
    }
}
