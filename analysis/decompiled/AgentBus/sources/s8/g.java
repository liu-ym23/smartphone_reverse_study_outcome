package s8;

import f8.q0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9554g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f9555h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(j jVar, int i2) {
        super(0);
        this.f9554g = i2;
        this.f9555h = jVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9554g) {
            case 0:
                return f8.v.c(this.f9555h);
            case 1:
                j jVar = this.f9555h;
                l8.o oVar = jVar.f9560m;
                ArrayList typeParameters = oVar.getTypeParameters();
                ArrayList arrayList = new ArrayList(d7.t.A0(typeParameters, 10));
                Iterator it = typeParameters.iterator();
                while (it.hasNext()) {
                    l8.c0 c0Var = (l8.c0) it.next();
                    q0 q0VarA = ((r8.f) jVar.f9562o.f163g).a(c0Var);
                    if (q0VarA == null) {
                        throw new AssertionError("Parameter " + c0Var + " surely belongs to class " + oVar + ", so it must be resolved");
                    }
                    arrayList.add(q0VarA);
                }
                return arrayList;
            default:
                j jVar2 = this.f9555h;
                if (l9.d.f(jVar2) == null) {
                    return null;
                }
                ((r8.a) jVar2.f9559l.f162f).f9024w.getClass();
                return null;
        }
    }
}
