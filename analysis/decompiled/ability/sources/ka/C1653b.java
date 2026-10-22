package ka;

import ha.AbstractC1551g;
import java.util.LinkedList;
import java.util.List;
import na.C1752b;
import org.yaml.snakeyaml.tokens.Token$ID;

/* renamed from: ka.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1653b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4879a;
    public final /* synthetic */ e b;
    public final List c;

    public C1653b(e eVar) {
        this.f4879a = 0;
        this.b = eVar;
        this.c = new LinkedList();
    }

    @Override // ka.f
    public final AbstractC1551g a() {
        switch (this.f4879a) {
            case 0:
                LinkedList linkedList = (LinkedList) this.c;
                e eVar = this.b;
                C1752b c1752b = eVar.f4882a;
                C1752b c1752b2 = eVar.f4882a;
                if (c1752b.c(Token$ID.Comment)) {
                    linkedList.add((oa.e) c1752b2.k());
                    return a();
                }
                if (c1752b2.d(Token$ID.Key, Token$ID.Value, Token$ID.BlockEnd)) {
                    eVar.e = new C1653b(eVar, linkedList);
                    return e.a(eVar, c1752b2.m().f5460a);
                }
                if (!linkedList.isEmpty()) {
                    return e.b(eVar, (oa.e) linkedList.remove(0));
                }
                eVar.c.b(new C1652a(eVar, 1));
                return eVar.c(true, true);
            default:
                List list = this.c;
                boolean zIsEmpty = list.isEmpty();
                e eVar2 = this.b;
                return !zIsEmpty ? e.b(eVar2, (oa.e) list.remove(0)) : new C1652a(eVar2, 1).a();
        }
    }

    public C1653b(e eVar, LinkedList linkedList) {
        this.f4879a = 1;
        this.b = eVar;
        this.c = linkedList;
    }
}
