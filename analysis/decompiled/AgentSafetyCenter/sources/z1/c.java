package z1;

import jb.v;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.i implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f16156c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f16157f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f16158g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, nb.c cVar) {
        super(2, cVar);
        this.f16158g = dVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        c cVar2 = new c(this.f16158g, cVar);
        cVar2.f16157f = ((Number) obj).floatValue();
        return cVar2;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create(Float.valueOf(((Number) obj).floatValue()), (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        a2.p pVar = this.f16158g.f16159a;
        ob.a aVar = ob.a.f9351c;
        int i = this.f16156c;
        if (i == 0) {
            id.c.I(obj);
            float f5 = this.f16157f;
            Object objG = pVar.f88d.f75c.g(a2.j.f54e);
            if (objG == null) {
                objG = null;
            }
            p pVar2 = (p) objG;
            if (pVar2 == null) {
                throw w2.c.a("Required value was null.");
            }
            c1.b bVarA = c1.b.a((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L));
            this.f16156c = 1;
            obj = pVar2.invoke(bVarA, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return new Float(Float.intBitsToFloat((int) (((c1.b) obj).f2165a & 4294967295L)));
    }
}
