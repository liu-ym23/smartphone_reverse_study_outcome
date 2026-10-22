package x4;

import c7.r;
import ia.b0;
import ia.d0;
import k5.s;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class d extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11162f;

    /* renamed from: g, reason: collision with root package name */
    public int f11163g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f11164h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i2, g7.d dVar, i iVar) {
        super(2, dVar);
        this.f11162f = i2;
        this.f11164h = iVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11162f) {
            case 0:
                return new d(0, dVar, this.f11164h);
            default:
                return new d(1, dVar, this.f11164h);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11162f) {
        }
        return ((d) create(b0Var, dVar)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f11162f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f11163g;
                if (i2 == 0) {
                    e0.N(obj);
                    i iVar = this.f11164h;
                    this.f11163g = 1;
                    if (i.b(iVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return r.f1986a;
            default:
                r rVar = r.f1986a;
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f11163g;
                if (i10 == 0) {
                    e0.N(obj);
                    long reconnectInitialDelayMs = this.f11164h.f11182b.getReconnectInitialDelayMs();
                    int i11 = this.f11164h.f11198r;
                    if (i11 > 5) {
                        i11 = 5;
                    }
                    long j2 = reconnectInitialDelayMs * (1 << i11);
                    long reconnectMaxDelayMs = this.f11164h.f11182b.getReconnectMaxDelayMs();
                    if (j2 > reconnectMaxDelayMs) {
                        j2 = reconnectMaxDelayMs;
                    }
                    this.f11164h.f11198r++;
                    i iVar2 = this.f11164h;
                    s.info$default(iVar2.f11186f, "BffBridge", "reconnect in " + j2 + "ms (attempt=" + iVar2.f11198r + ")", null, 4, null);
                    this.f11163g = 1;
                    if (d0.g(j2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                if (!this.f11164h.f11188h.get()) {
                    return rVar;
                }
                if (!this.f11164h.c()) {
                    s.info$default(this.f11164h.f11186f, "BffBridge", "still screen off after backoff, skip reconnect", null, 4, null);
                    return rVar;
                }
                i iVar3 = this.f11164h;
                q7.k.d(iVar3.f11201u, "access$getPendingQueue$p(...)");
                iVar3.d(!r13.isEmpty());
                return rVar;
        }
    }
}
