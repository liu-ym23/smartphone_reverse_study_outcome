package m8;

import android.util.Log;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f8470c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8471f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f8472g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f8473h;
    public final /* synthetic */ long i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(k0 k0Var, long j10, long j11, nb.c cVar) {
        super(2, cVar);
        this.f8472g = k0Var;
        this.f8473h = j10;
        this.i = j11;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        p pVar = new p(this.f8472g, this.f8473h, this.i, cVar);
        pVar.f8471f = obj;
        return pVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objL;
        ob.a aVar = ob.a.f9351c;
        int i = this.f8470c;
        try {
            if (i == 0) {
                id.c.I(obj);
                k0 k0Var = this.f8472g;
                long j10 = this.f8473h;
                long j11 = this.i;
                q8.t tVarU = k0Var.u();
                this.f8471f = null;
                this.f8470c = 1;
                obj = tVarU.c(j10, j11, this);
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
            objL = (List) obj;
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        Throwable thB = jb.i.b(objL);
        if (thB != null) {
            Log.e("BehaviorAnalysis", "getDashboardRowsInclusive failed", thB);
        }
        return objL instanceof jb.h ? kb.s.f7404c : objL;
    }
}
