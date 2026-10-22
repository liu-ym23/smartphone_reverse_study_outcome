package w6;

import com.stepos.cloud.securedata.SecureDataEnvironment;
import w7.e0;

/* loaded from: classes.dex */
public final class i extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10801f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f10802g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SecureDataEnvironment f10803h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f10804i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f10805j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, SecureDataEnvironment secureDataEnvironment, String str, String str2, g7.d dVar) {
        super(2, dVar);
        this.f10802g = jVar;
        this.f10803h = secureDataEnvironment;
        this.f10804i = str;
        this.f10805j = str2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        i iVar = new i(this.f10802g, this.f10803h, this.f10804i, this.f10805j, dVar);
        iVar.f10801f = obj;
        return iVar;
    }

    @Override // p7.n
    public Object invoke(Object obj, Object obj2) {
        i iVar = (i) create((w2.b) obj, (g7.d) obj2);
        c7.r rVar = c7.r.f1986a;
        iVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        e0.N(obj);
        w2.b bVar = (w2.b) this.f10801f;
        w2.d dVarAccess$publicKeyKey = j.access$publicKeyKey(this.f10802g, this.f10803h, this.f10804i);
        bVar.getClass();
        q7.k.e(dVarAccess$publicKeyKey, "key");
        bVar.c(dVarAccess$publicKeyKey, this.f10805j);
        return c7.r.f1986a;
    }
}
