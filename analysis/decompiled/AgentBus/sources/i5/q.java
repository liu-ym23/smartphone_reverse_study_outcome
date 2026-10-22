package i5;

import android.os.CancellationSignal;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import ia.b0;
import w7.e0;

/* loaded from: classes.dex */
public final class q extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4699f;

    /* renamed from: g, reason: collision with root package name */
    public int f4700g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f4701h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u f4702i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(int i2, g7.d dVar, u uVar, String str) {
        super(2, dVar);
        this.f4699f = i2;
        this.f4702i = uVar;
        this.f4701h = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f4699f) {
            case 0:
                return new q(0, dVar, this.f4702i, this.f4701h);
            case 1:
                return new q(this.f4701h, this.f4702i, dVar);
            default:
                return new q(2, dVar, this.f4702i, this.f4701h);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f4699f) {
        }
        return ((q) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f4699f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f4700g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                f fVar = this.f4702i.f4728h;
                this.f4700g = 1;
                fVar.getClass();
                g3.n nVarD = g3.n.d(1, "SELECT COUNT(*) FROM offline_frame WHERE target_kind = ?");
                nVarD.l(1, this.f4701h);
                Object objA = g3.d.a((OfflineQueueDatabase_Impl) fVar.f4653g, new CancellationSignal(), new a(fVar, nVarD, 0), this);
                return objA == aVar ? aVar : objA;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f4700g;
                if (i10 == 0) {
                    e0.N(obj);
                    String str = this.f4701h;
                    if (!ga.k.t0(str)) {
                        l lVar = this.f4702i.f4729i;
                        this.f4700g = 1;
                        lVar.getClass();
                        g3.n nVarD2 = g3.n.d(1, "SELECT EXISTS(SELECT 1 FROM offline_frame_tombstone WHERE frame_id = ?)");
                        nVarD2.l(1, str);
                        obj = g3.d.a((OfflineQueueDatabase_Impl) lVar.f4687g, new CancellationSignal(), new b(3, lVar, nVarD2), this);
                        if (obj == aVar2) {
                            return aVar2;
                        }
                    }
                    return Boolean.valueOf(z);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e0.N(obj);
                boolean z4 = ((Boolean) obj).booleanValue();
                return Boolean.valueOf(z4);
            default:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f4700g;
                if (i11 != 0) {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                f fVar2 = this.f4702i.f4728h;
                this.f4700g = 1;
                fVar2.getClass();
                g3.n nVarD3 = g3.n.d(1, "SELECT IFNULL(SUM(size_bytes), 0) FROM offline_frame WHERE target_kind = ?");
                nVarD3.l(1, this.f4701h);
                Object objA2 = g3.d.a((OfflineQueueDatabase_Impl) fVar2.f4653g, new CancellationSignal(), new a(fVar2, nVarD3, 1), this);
                return objA2 == aVar3 ? aVar3 : objA2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, u uVar, g7.d dVar) {
        super(2, dVar);
        this.f4699f = 1;
        this.f4701h = str;
        this.f4702i = uVar;
    }
}
