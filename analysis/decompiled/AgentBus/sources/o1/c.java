package o1;

import c7.r;
import m.x;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public int f7198f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f7199g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d f7200h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, g7.d dVar2) {
        super(2, dVar2);
        this.f7200h = dVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        c cVar = new c(this.f7200h, dVar);
        cVar.f7199g = ((Number) obj).floatValue();
        return cVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create(Float.valueOf(((Number) obj).floatValue()), (g7.d) obj2)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f7198f;
        if (i2 == 0) {
            e0.N(obj);
            float f10 = this.f7199g;
            d dVar = this.f7200h;
            Object objG = dVar.f7201a.f8315d.f8304f.g(p1.h.f8282e);
            if (objG == null) {
                objG = null;
            }
            n nVar = (n) objG;
            if (nVar == null) {
                throw x.i("Required value was null.");
            }
            t0.b bVar = new t0.b((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f10) & 4294967295L));
            this.f7198f = 1;
            obj = nVar.invoke(bVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
        }
        return new Float(Float.intBitsToFloat((int) (((t0.b) obj).f9654a & 4294967295L)));
    }
}
