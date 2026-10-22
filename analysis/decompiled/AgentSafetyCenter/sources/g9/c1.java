package g9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4421c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4422f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f4423g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(String str, nb.c cVar, int i) {
        super(2, cVar);
        this.f4421c = i;
        this.f4423g = str;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4421c) {
            case 0:
                c1 c1Var = new c1(this.f4423g, cVar, 0);
                c1Var.f4422f = obj;
                return c1Var;
            default:
                c1 c1Var2 = new c1(this.f4423g, cVar, 1);
                c1Var2.f4422f = obj;
                return c1Var2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4421c) {
            case 0:
                c1 c1Var = (c1) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                c1Var.invokeSuspend(vVar);
                return vVar;
            default:
                return ((c1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objL;
        int i = this.f4421c;
        String str = this.f4423g;
        Object obj2 = this.f4422f;
        switch (i) {
            case 0:
                y3.b bVar = (y3.b) obj2;
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar = d1.f4428b;
                String str2 = (String) bVar.c(eVar);
                if (str2 == null) {
                    str2 = "";
                }
                List listV = p5.f.v(str2);
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : listV) {
                    if (!yb.k.a(((a1) obj3).f4403a, str)) {
                        arrayList.add(obj3);
                    }
                }
                bVar.e(eVar, p5.f.N(arrayList));
                return jb.v.f6774a;
            default:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                try {
                    objL = new JSONObject(str).toString();
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                return jb.i.b(objL) == null ? objL : str;
        }
    }
}
