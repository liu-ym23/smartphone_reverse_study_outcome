package b;

import c7.r;
import com.stepos.cloud.securedata.SdkException;
import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;
import java.io.Serializable;
import s2.c0;
import s2.g0;
import s2.h0;
import s2.z;
import w6.x;
import w7.e0;

/* loaded from: classes.dex */
public final class f extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1073f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f1074g;

    /* renamed from: h, reason: collision with root package name */
    public Serializable f1075h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1076i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(z zVar, g7.d dVar) {
        super(1, dVar);
        this.f1076i = zVar;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        switch (this.f1073f) {
            case 0:
                return new f((String) this.f1075h, (String) this.f1076i, dVar);
            default:
                return new f((z) this.f1076i, dVar);
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g7.d dVar = (g7.d) obj;
        switch (this.f1073f) {
            case 0:
                return new f((String) this.f1075h, (String) this.f1076i, dVar).invokeSuspend(r.f1986a);
            default:
                return ((f) create(dVar)).invokeSuspend(r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws SdkException {
        Throwable th;
        h0 c0Var;
        switch (this.f1073f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f1074g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                x xVar = StepOSCloudSecureDataSdk.f2701h;
                if (xVar == null) {
                    q7.k.j("secureKeyManager");
                    throw null;
                }
                String str = (String) this.f1075h;
                String str2 = (String) this.f1076i;
                this.f1074g = 1;
                Object objB = xVar.b(str, str2, this);
                return objB == aVar ? aVar : objB;
            default:
                z zVar = (z) this.f1076i;
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f1074g;
                try {
                } catch (Throwable th2) {
                    g0 g0VarD = zVar.d();
                    this.f1075h = th2;
                    this.f1074g = 2;
                    Integer numA = g0VarD.a();
                    if (numA == aVar2) {
                        return aVar2;
                    }
                    obj = numA;
                    th = th2;
                }
                if (i10 == 0) {
                    e0.N(obj);
                    this.f1074g = 1;
                    obj = z.c(zVar, true, this);
                    if (obj == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) this.f1075h;
                        e0.N(obj);
                        c0Var = new c0(((Number) obj).intValue(), th);
                        return new c7.j(c0Var, Boolean.TRUE);
                    }
                    e0.N(obj);
                }
                c0Var = (h0) obj;
                return new c7.j(c0Var, Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, g7.d dVar) {
        super(1, dVar);
        this.f1075h = str;
        this.f1076i = str2;
    }
}
