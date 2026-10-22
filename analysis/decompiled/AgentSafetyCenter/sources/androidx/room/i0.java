package androidx.room;

import android.database.SQLException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1548c;

    /* renamed from: f, reason: collision with root package name */
    public int f1549f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1550g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n0 f1551h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(n0 n0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f1548c = i;
        this.f1551h = n0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f1548c) {
            case 0:
                i0 i0Var = new i0(this.f1551h, cVar, 0);
                i0Var.f1550g = obj;
                return i0Var;
            case 1:
                i0 i0Var2 = new i0(this.f1551h, cVar, 1);
                i0Var2.f1550g = obj;
                return i0Var2;
            default:
                i0 i0Var3 = new i0(this.f1551h, cVar, 2);
                i0Var3.f1550g = obj;
                return i0Var3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1548c) {
        }
        return ((i0) create((d0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        d0 d0Var;
        Object objC;
        Object objA;
        d0 d0Var2;
        Object objC2;
        i[] iVarArr;
        i iVar;
        switch (this.f1548c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f1549f;
                if (i != 0) {
                    if (i == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                o4.k kVar = (o4.k) this.f1550g;
                this.f1549f = 1;
                Object objA2 = n0.a(this.f1551h, kVar, this);
                return objA2 == aVar ? aVar : objA2;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f1549f;
                try {
                    if (i3 == 0) {
                        id.c.I(obj);
                        d0Var = (d0) this.f1550g;
                        this.f1550g = d0Var;
                        this.f1549f = 1;
                        objC = d0Var.c(this);
                        if (objC == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                od.f.e("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            id.c.I(obj);
                            objA = obj;
                            return (Set) objA;
                        }
                        d0Var = (d0) this.f1550g;
                        id.c.I(obj);
                        objC = obj;
                    }
                    if (!((Boolean) objC).booleanValue()) {
                        c0 c0Var = c0.f1514f;
                        i0 i0Var = new i0(this.f1551h, null, 0);
                        this.f1550g = null;
                        this.f1549f = 2;
                        objA = d0Var.a(c0Var, i0Var, this);
                        if (objA == aVar2) {
                            return aVar2;
                        }
                        return (Set) objA;
                    }
                } catch (SQLException unused) {
                }
                return kb.u.f7406c;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f1549f;
                jb.v vVar = jb.v.f6774a;
                boolean z10 = true;
                if (i10 == 0) {
                    id.c.I(obj);
                    d0Var2 = (d0) this.f1550g;
                    this.f1550g = d0Var2;
                    this.f1549f = 1;
                    objC2 = d0Var2.c(this);
                    if (objC2 == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            id.c.I(obj);
                            return vVar;
                        }
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    d0Var2 = (d0) this.f1550g;
                    id.c.I(obj);
                    objC2 = obj;
                }
                if (!((Boolean) objC2).booleanValue()) {
                    n0 n0Var = this.f1551h;
                    ab.c cVar = n0Var.f1592g;
                    long[] jArr = (long[]) cVar.f384c;
                    ReentrantLock reentrantLock = (ReentrantLock) cVar.f383b;
                    reentrantLock.lock();
                    try {
                        if (cVar.f382a) {
                            boolean z11 = false;
                            cVar.f382a = false;
                            int length = jArr.length;
                            iVarArr = new i[length];
                            int i11 = 0;
                            boolean z12 = false;
                            while (i11 < length) {
                                if (jArr[i11] <= 0) {
                                    z10 = z11;
                                }
                                boolean[] zArr = (boolean[]) cVar.f385d;
                                if (z10 != zArr[i11]) {
                                    zArr[i11] = z10;
                                    iVar = z10 ? i.f1545f : i.f1546g;
                                    z12 = true;
                                } else {
                                    iVar = i.f1544c;
                                }
                                iVarArr[i11] = iVar;
                                i11++;
                                z10 = true;
                                z11 = false;
                            }
                            if (!z12) {
                                iVarArr = null;
                            }
                            reentrantLock.unlock();
                        } else {
                            reentrantLock.unlock();
                            iVarArr = null;
                        }
                        if (iVarArr != null) {
                            c0 c0Var2 = c0.f1514f;
                            m0 m0Var = new m0(iVarArr, n0Var, d0Var2, null);
                            this.f1550g = null;
                            this.f1549f = 2;
                            if (d0Var2.a(c0Var2, m0Var, this) == aVar3) {
                                return aVar3;
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                return vVar;
        }
    }
}
