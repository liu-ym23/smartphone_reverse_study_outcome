package s;

import i1.d1;
import q7.i;
import q7.j;
import q7.m;

/* loaded from: classes.dex */
public final /* synthetic */ class b extends i implements p7.a {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f9150n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d1 f9151o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ m f9152p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(d dVar, d1 d1Var, p7.a aVar) {
        super(0, j.class, "localRect", "bringChildIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
        this.f9150n = dVar;
        this.f9151o = d1Var;
        this.f9152p = (m) aVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [p7.a, q7.m] */
    @Override // p7.a
    public final Object c() {
        return d.l0(this.f9150n, this.f9151o, this.f9152p);
    }
}
