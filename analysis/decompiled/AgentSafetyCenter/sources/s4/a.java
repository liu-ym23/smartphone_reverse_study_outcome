package s4;

import androidx.room.u;
import jb.v;
import kc.t;
import pb.i;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f11368c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f11369f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f11370g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f11371h;
    public final /* synthetic */ l i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(u uVar, nb.c cVar, l lVar, boolean z10, boolean z11) {
        super(2, cVar);
        this.f11369f = uVar;
        this.f11370g = z10;
        this.f11371h = z11;
        this.i = lVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        boolean z10 = this.f11371h;
        return new a(this.f11369f, cVar, this.i, this.f11370g, z10);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f11368c;
        if (i != 0) {
            if (i == 1) {
                id.c.I(obj);
                return obj;
            }
            od.f.e("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        id.c.I(obj);
        l lVar = this.i;
        u uVar = this.f11369f;
        boolean z10 = this.f11371h;
        boolean z11 = this.f11370g;
        c cVar = new c(uVar, null, lVar, z10, z11);
        this.f11368c = 1;
        Object objW = uVar.w(z11, cVar, this);
        return objW == aVar ? aVar : objW;
    }
}
