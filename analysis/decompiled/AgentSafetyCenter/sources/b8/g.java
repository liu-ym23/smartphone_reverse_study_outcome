package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1961g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1961g = i;
    }

    @Override // w7.s
    public void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        switch (this.f1961g) {
            case 1:
                w7.l lVarG = m(fVar).g();
                if (lVarG != null) {
                    if (jsonNode == null) {
                        w7.n nVar = lVarG.i;
                        Iterator itDescendingIterator = fVar.f15312g.descendingIterator();
                        while (itDescendingIterator.hasNext()) {
                            if (((w7.l) itDescendingIterator.next()).i.equals(nVar)) {
                                return;
                            }
                        }
                    }
                    lVarG.a(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                }
                w7.j jVarJ = j();
                jVarJ.f15290a = b0.f1930s.f1938c;
                jVarJ.i = "internal.unresolvedRef";
                jVarJ.f15296g = "Reference {0} cannot be resolved";
                jVarJ.f15293d = aVar;
                jVarJ.f15291b = fVar.f15311f;
                jVarJ.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ.a());
            case 2:
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar, z10);
                return;
            case 3:
                w7.l lVarG2 = m(fVar).g();
                if (lVarG2 != null) {
                    if (jsonNode == null) {
                        w7.n nVar2 = lVarG2.i;
                        Iterator itDescendingIterator2 = fVar.f15312g.descendingIterator();
                        while (itDescendingIterator2.hasNext()) {
                            if (((w7.l) itDescendingIterator2.next()).i.equals(nVar2)) {
                                return;
                            }
                        }
                    }
                    lVarG2.a(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                }
                w7.j jVarJ2 = j();
                jVarJ2.f15290a = b0.X.f1938c;
                jVarJ2.i = "internal.unresolvedRef";
                jVarJ2.f15296g = "Reference {0} cannot be resolved";
                jVarJ2.f15293d = aVar;
                jVarJ2.f15291b = fVar.f15311f;
                jVarJ2.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ2.a());
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1961g) {
            case 0:
                JsonNode jsonNode3 = this.f1908b;
                if (jsonNode3.isNumber() && jsonNode.isNumber()) {
                    if (jsonNode3.decimalValue().compareTo(jsonNode.decimalValue()) != 0) {
                        w7.j jVarJ = j();
                        jVarJ.f15293d = aVar;
                        jVarJ.f15291b = fVar.f15311f;
                        jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                        jVarJ.f15294e = new Object[]{jsonNode3.asText(), jsonNode.asText()};
                        fVar.a(jVarJ.a());
                        return;
                    }
                    return;
                }
                if (jsonNode3.equals(jsonNode)) {
                    return;
                }
                w7.j jVarJ2 = j();
                jVarJ2.f15293d = aVar;
                jVarJ2.f15291b = fVar.f15311f;
                jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                jVarJ2.f15294e = new Object[]{jsonNode3.asText(), jsonNode.asText()};
                fVar.a(jVarJ2.a());
                return;
            case 1:
                w7.l lVarG = m(fVar).g();
                if (lVarG != null) {
                    lVarG.b(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                w7.j jVarJ3 = j();
                jVarJ3.f15290a = b0.f1930s.f1938c;
                jVarJ3.i = "internal.unresolvedRef";
                jVarJ3.f15296g = "Reference {0} cannot be resolved";
                jVarJ3.f15293d = aVar;
                jVarJ3.f15291b = fVar.f15311f;
                jVarJ3.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ3.a());
            case 2:
                Object objD = fVar.f15311f.f2224f.d(-1);
                String string = objD != null ? objD.toString() : null;
                w7.j jVarJ4 = j();
                jVarJ4.f15293d = aVar;
                jVarJ4.f15291b = fVar.f15311f;
                jVarJ4.f15319l = (Locale) fVar.f15306a.f7721f;
                jVarJ4.f15294e = new Object[]{string};
                fVar.a(jVarJ4.a());
                return;
            case 3:
                w7.l lVarG2 = m(fVar).g();
                if (lVarG2 != null) {
                    lVarG2.b(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                w7.j jVarJ5 = j();
                jVarJ5.f15290a = b0.X.f1938c;
                jVarJ5.i = "internal.unresolvedRef";
                jVarJ5.f15296g = "Reference {0} cannot be resolved";
                jVarJ5.f15293d = aVar;
                jVarJ5.f15291b = fVar.f15311f;
                jVarJ5.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ5.a());
            default:
                return;
        }
    }

    public stepos.support.v7.app.f m(w7.f fVar) {
        w7.l lVar;
        switch (this.f1961g) {
            case 1:
                String strAsText = this.f1908b.asText();
                w7.l lVar2 = this.f1955e;
                if (lVar2.f15325a == null || (lVar = lVar2.f15332h) == null) {
                    lVar = lVar2;
                }
                String strD = w7.n.d(lVar.i, strAsText);
                o oVar = new o(0);
                oVar.f1994f = lVar2;
                oVar.f1995g = strD;
                oVar.f1996h = strAsText;
                oVar.i = fVar;
                VarHandle.storeStoreFence();
                return new stepos.support.v7.app.f(oVar);
            default:
                n0 n0Var = new n0(0);
                n0Var.f1991f = this;
                n0Var.f1992g = fVar;
                VarHandle.storeStoreFence();
                return new stepos.support.v7.app.f(n0Var);
        }
    }

    private final void n(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
    }
}
