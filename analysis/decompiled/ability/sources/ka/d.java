package ka;

import ha.AbstractC1551g;
import ha.i;
import ha.j;
import ha.m;
import j4.C1597b;
import na.C1752b;
import oa.k;
import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4881a;
    public final boolean b;
    public final /* synthetic */ e c;

    public /* synthetic */ d(e eVar, boolean z10, int i) {
        this.f4881a = i;
        this.c = eVar;
        this.b = z10;
    }

    @Override // ka.f
    public final AbstractC1551g a() {
        switch (this.f4881a) {
            case 0:
                e eVar = this.c;
                C1597b c1597b = eVar.d;
                C1597b c1597b2 = eVar.c;
                C1752b c1752b = eVar.f4882a;
                Token$ID token$ID = Token$ID.Comment;
                boolean zC = c1752b.c(token$ID);
                boolean z10 = this.b;
                if (zC) {
                    eVar.e = new d(eVar, z10, 0);
                    return e.b(eVar, (oa.e) c1752b.k());
                }
                Token$ID token$ID2 = Token$ID.FlowMappingEnd;
                if (!c1752b.c(token$ID2)) {
                    Token$ID token$ID3 = Token$ID.FlowEntry;
                    if (!z10) {
                        if (!c1752b.c(token$ID3)) {
                            k kVarM = c1752b.m();
                            throw new ParserException("while parsing a flow mapping", (Mark) c1597b.a(), "expected ',' or '}', but got " + kVarM.a(), kVarM.f5460a);
                        }
                        c1752b.k();
                        if (c1752b.c(token$ID)) {
                            eVar.e = new d(eVar, true, 0);
                            return e.b(eVar, (oa.e) c1752b.k());
                        }
                    }
                    if (c1752b.c(Token$ID.Key)) {
                        k kVarK = c1752b.k();
                        if (c1752b.d(Token$ID.Value, token$ID3, token$ID2)) {
                            eVar.e = new C1652a(eVar, 12);
                            return e.a(eVar, kVarK.b);
                        }
                        c1597b2.b(new C1652a(eVar, 12));
                        return eVar.c(false, false);
                    }
                    if (!c1752b.c(token$ID2)) {
                        c1597b2.b(new C1652a(eVar, 10));
                        return eVar.c(false, false);
                    }
                }
                k kVarK2 = c1752b.k();
                i iVar = new i(kVarK2.f5460a, kVarK2.b);
                c1597b.a();
                if (c1752b.c(token$ID)) {
                    eVar.e = new C1652a(eVar, 9);
                } else {
                    eVar.e = (f) c1597b2.a();
                }
                return iVar;
            default:
                e eVar2 = this.c;
                C1597b c1597b3 = eVar2.c;
                C1597b c1597b4 = eVar2.d;
                C1752b c1752b2 = eVar2.f4882a;
                Token$ID token$ID4 = Token$ID.Comment;
                boolean zC2 = c1752b2.c(token$ID4);
                boolean z11 = this.b;
                if (zC2) {
                    eVar2.e = new d(eVar2, z11, 1);
                    return e.b(eVar2, (oa.e) c1752b2.k());
                }
                Token$ID token$ID5 = Token$ID.FlowSequenceEnd;
                if (!c1752b2.c(token$ID5)) {
                    if (!z11) {
                        if (!c1752b2.c(Token$ID.FlowEntry)) {
                            k kVarM2 = c1752b2.m();
                            throw new ParserException("while parsing a flow sequence", (Mark) c1597b4.a(), "expected ',' or ']', but got " + kVarM2.a(), kVarM2.f5460a);
                        }
                        c1752b2.k();
                        if (c1752b2.c(token$ID4)) {
                            eVar2.e = new d(eVar2, true, 1);
                            return e.b(eVar2, (oa.e) c1752b2.k());
                        }
                    }
                    if (c1752b2.c(Token$ID.Key)) {
                        k kVarM3 = c1752b2.m();
                        j jVar = new j(null, null, true, kVarM3.f5460a, kVarM3.b, DumperOptions$FlowStyle.FLOW);
                        eVar2.e = new C1652a(eVar2, 14);
                        return jVar;
                    }
                    if (!c1752b2.c(token$ID5)) {
                        c1597b3.b(new d(eVar2, false, 1));
                        return eVar2.c(false, false);
                    }
                }
                k kVarK3 = c1752b2.k();
                m mVar = new m(kVarK3.f5460a, kVarK3.b);
                if (c1752b2.c(token$ID4)) {
                    eVar2.e = new C1652a(eVar2, 9);
                } else {
                    eVar2.e = (f) c1597b3.a();
                }
                c1597b4.a();
                return mVar;
        }
    }
}
