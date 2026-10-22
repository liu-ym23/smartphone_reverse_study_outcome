package h5;

import androidx.work.impl.WorkDatabase;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kc.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5291c;

    /* renamed from: f, reason: collision with root package name */
    public int f5292f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d0 f5293g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(d0 d0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f5291c = i;
        this.f5293g = d0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5291c) {
            case 0:
                return new a0(this.f5293g, cVar, 0);
            default:
                return new a0(this.f5293g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f5291c) {
        }
        return ((a0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException {
        Object wVar;
        int i = this.f5291c;
        d0 d0Var = this.f5293g;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f5292f;
                if (i3 == 0) {
                    id.c.I(obj);
                    this.f5292f = 1;
                    Object objA = d0.a(d0Var, this);
                    return objA == aVar ? aVar : objA;
                }
                if (i3 == 1) {
                    id.c.I(obj);
                    return obj;
                }
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i10 = this.f5292f;
                try {
                    if (i10 == 0) {
                        id.c.I(obj);
                        z0 z0Var = d0Var.f5335l;
                        a0 a0Var = new a0(d0Var, cVar, 0);
                        this.f5292f = 1;
                        obj = kc.w.E(z0Var, a0Var, this);
                        if (obj == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            od.f.e("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        id.c.I(obj);
                    }
                    wVar = (z) obj;
                } catch (u e10) {
                    wVar = new y(e10.f5384c);
                } catch (CancellationException unused) {
                    wVar = new w();
                } catch (Throwable th) {
                    g5.u.d().c(e0.f5338a, "Unexpected error in WorkerWrapper", th);
                    wVar = new w();
                }
                WorkDatabase workDatabase = d0Var.f5331g;
                a9.a aVar3 = new a9.a(2);
                aVar3.f243g = wVar;
                aVar3.f242f = d0Var;
                VarHandle.storeStoreFence();
                Object objT = workDatabase.t(aVar3);
                objT.getClass();
                return objT;
        }
    }
}
