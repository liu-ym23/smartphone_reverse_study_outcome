package b;

import android.util.Log;
import c7.r;
import ia.b0;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class k extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1093f;

    /* renamed from: g, reason: collision with root package name */
    public int f1094g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p7.k f1095h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(p7.k kVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f1093f = i2;
        this.f1095h = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f1093f) {
            case 0:
                return new k(this.f1095h, dVar, 0);
            default:
                return new k(this.f1095h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f1093f) {
            case 0:
                return new k(this.f1095h, dVar, 0).invokeSuspend(r.f1986a);
            default:
                return ((k) create(b0Var, dVar)).invokeSuspend(r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1093f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f1094g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1094g = 1;
                Object objInvoke = this.f1095h.invoke(this);
                return objInvoke == aVar ? aVar : objInvoke;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f1094g;
                try {
                    if (i10 == 0) {
                        e0.N(obj);
                        p7.k kVar = this.f1095h;
                        this.f1094g = 1;
                        if (kVar.invoke(this) == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                    }
                } catch (Exception e10) {
                    Log.w("SecureDataInitGate", "SDK init failed with exception: " + e10.getMessage(), e10);
                }
                return r.f1986a;
        }
    }
}
