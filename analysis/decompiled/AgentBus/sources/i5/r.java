package i5;

import android.os.CancellationSignal;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import ia.b0;
import java.util.ArrayList;
import w7.e0;

/* loaded from: classes.dex */
public final class r extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f4703f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4704g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u f4705h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f4706i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4707j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i2, g7.d dVar, u uVar, String str) {
        super(2, dVar);
        this.f4705h = uVar;
        this.f4706i = str;
        this.f4707j = i2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        r rVar = new r(this.f4707j, dVar, this.f4705h, this.f4706i);
        rVar.f4704g = obj;
        return rVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((r) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objN;
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f4703f;
        u uVar = this.f4705h;
        if (i2 == 0) {
            e0.N(obj);
            b0 b0Var = (b0) this.f4704g;
            f fVar = uVar.f4728h;
            this.f4704g = b0Var;
            this.f4703f = 1;
            fVar.getClass();
            g3.n nVarD = g3.n.d(2, "SELECT * FROM offline_frame WHERE target_kind = ? ORDER BY id ASC LIMIT ?");
            nVarD.l(1, this.f4706i);
            nVarD.G(2, this.f4707j);
            obj = g3.d.a((OfflineQueueDatabase_Impl) fVar.f4653g, new CancellationSignal(), new a(fVar, nVarD, 4), this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (g gVar : (Iterable) obj) {
            try {
                objN = new p(gVar.f4657a, ((c5.d) uVar.f4721a).a(gVar.f4658b), gVar.f4660d, gVar.f4661e);
            } catch (Throwable th) {
                objN = e0.n(th);
            }
            if (objN instanceof c7.l) {
                objN = null;
            }
            p pVar = (p) objN;
            if (pVar != null) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }
}
