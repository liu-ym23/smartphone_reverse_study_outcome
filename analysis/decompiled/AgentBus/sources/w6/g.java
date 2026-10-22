package w6;

import com.stepos.cloud.securedata.SecureDataEnvironment;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10794f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f10795g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SecureDataEnvironment f10796h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f10797i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, SecureDataEnvironment secureDataEnvironment, String str, g7.d dVar) {
        super(2, dVar);
        this.f10795g = jVar;
        this.f10796h = secureDataEnvironment;
        this.f10797i = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        g gVar = new g(this.f10795g, this.f10796h, this.f10797i, dVar);
        gVar.f10794f = obj;
        return gVar;
    }

    @Override // p7.n
    public Object invoke(Object obj, Object obj2) {
        g gVar = (g) create((w2.b) obj, (g7.d) obj2);
        c7.r rVar = c7.r.f1986a;
        gVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        e0.N(obj);
        w2.b bVar = (w2.b) this.f10794f;
        w2.d dVarAccess$publicKeyKey = j.access$publicKeyKey(this.f10795g, this.f10796h, this.f10797i);
        bVar.getClass();
        q7.k.e(dVarAccess$publicKeyKey, "key");
        bVar.b();
        bVar.f10649a.remove(dVarAccess$publicKeyKey);
        return c7.r.f1986a;
    }
}
