package ka;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ha.AbstractC1551g;
import ha.C1548d;
import ha.C1549e;
import ha.C1550f;
import ha.i;
import ha.l;
import ha.m;
import ha.o;
import ha.p;
import j4.C1597b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import na.C1752b;
import oa.h;
import oa.k;
import org.yaml.snakeyaml.DumperOptions$Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.tokens.Token$ID;

/* renamed from: ka.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1652a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4878a;
    public final /* synthetic */ e b;

    public /* synthetic */ C1652a(e eVar, int i) {
        this.f4878a = i;
        this.b = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ka.f
    public final AbstractC1551g a() throws NumberFormatException {
        Mark mark;
        boolean z10;
        int i = this.f4878a;
        Token$ID token$ID = Token$ID.FlowSequenceEnd;
        Token$ID token$ID2 = Token$ID.BlockEntry;
        int i6 = 17;
        Token$ID token$ID3 = Token$ID.BlockEnd;
        Token$ID token$ID4 = Token$ID.DocumentEnd;
        Token$ID token$ID5 = Token$ID.FlowEntry;
        Token$ID token$ID6 = Token$ID.StreamEnd;
        Token$ID token$ID7 = Token$ID.DocumentStart;
        Token$ID token$ID8 = Token$ID.Directive;
        Token$ID token$ID9 = Token$ID.Value;
        Token$ID token$ID10 = Token$ID.Comment;
        int i10 = 1;
        char c = 1;
        char c2 = 1;
        char c5 = 1;
        char c10 = 1;
        e eVar = this.b;
        switch (i) {
            case 0:
                eVar.d.b(eVar.f4882a.k().f5460a);
                return new C1652a(eVar, 1).a();
            case 1:
                C1752b c1752b = eVar.f4882a;
                C1597b c1597b = eVar.d;
                C1597b c1597b2 = eVar.c;
                C1752b c1752b2 = eVar.f4882a;
                if (c1752b.c(token$ID10)) {
                    eVar.e = new C1652a(eVar, 1);
                    return e.b(eVar, (oa.e) c1752b2.k());
                }
                Token$ID token$ID11 = Token$ID.Key;
                if (c1752b2.c(token$ID11)) {
                    k kVarK = c1752b2.k();
                    if (c1752b2.d(token$ID11, token$ID9, token$ID3)) {
                        eVar.e = new C1652a(eVar, 2);
                        return e.a(eVar, kVarK.b);
                    }
                    c1597b2.b(new C1652a(eVar, 2));
                    return eVar.c(true, true);
                }
                if (c1752b2.c(token$ID3)) {
                    k kVarK2 = c1752b2.k();
                    i iVar = new i(kVarK2.f5460a, kVarK2.b);
                    eVar.e = (f) c1597b2.a();
                    c1597b.a();
                    return iVar;
                }
                k kVarM = c1752b2.m();
                throw new ParserException("while parsing a block mapping", (Mark) c1597b.a(), "expected <block end>, but found '" + kVarM.a() + "'", kVarM.f5460a);
            case 2:
                C1752b c1752b3 = eVar.f4882a;
                C1597b c1597b3 = eVar.c;
                C1752b c1752b4 = eVar.f4882a;
                if (!c1752b3.c(token$ID9)) {
                    int i11 = 1;
                    if (c1752b4.c(Token$ID.Scalar)) {
                        c1597b3.b(new C1652a(eVar, i11));
                        return eVar.c(true, true);
                    }
                    eVar.e = new C1652a(eVar, i11);
                    return e.a(eVar, c1752b4.m().f5460a);
                }
                k kVarK3 = c1752b4.k();
                if (c1752b4.c(token$ID10)) {
                    C1653b c1653b = new C1653b(eVar);
                    eVar.e = c1653b;
                    return c1653b.a();
                }
                if (c1752b4.d(Token$ID.Key, token$ID9, token$ID3)) {
                    eVar.e = new C1652a(eVar, 1);
                    return e.a(eVar, kVarK3.b);
                }
                c1597b3.b(new C1652a(eVar, 1));
                return eVar.c(true, true);
            case 3:
                HashMap map = e.g;
                return eVar.c(true, false);
            case 4:
                int i12 = 4;
                C1752b c1752b5 = eVar.f4882a;
                C1597b c1597b4 = eVar.d;
                C1752b c1752b6 = eVar.f4882a;
                if (c1752b5.c(token$ID10)) {
                    eVar.e = new C1652a(eVar, i12);
                    return e.b(eVar, (oa.e) c1752b6.k());
                }
                if (c1752b6.c(token$ID2)) {
                    return new c(eVar, (oa.d) c1752b6.k(), 0).a();
                }
                if (c1752b6.c(token$ID3)) {
                    k kVarK4 = c1752b6.k();
                    m mVar = new m(kVarK4.f5460a, kVarK4.b);
                    eVar.e = (f) eVar.c.a();
                    c1597b4.a();
                    return mVar;
                }
                k kVarM2 = c1752b6.m();
                throw new ParserException("while parsing a block collection", (Mark) c1597b4.a(), "expected <block end>, but found '" + kVarM2.a() + "'", kVarM2.f5460a);
            case 5:
                eVar.d.b(eVar.f4882a.k().f5460a);
                return new C1652a(eVar, 4).a();
            case 6:
                C1752b c1752b7 = eVar.f4882a;
                if (c1752b7.c(token$ID10)) {
                    eVar.e = new C1652a(eVar, 6);
                    return e.b(eVar, (oa.e) c1752b7.k());
                }
                if (!c1752b7.d(token$ID8, token$ID7, token$ID4, token$ID6)) {
                    HashMap map2 = e.g;
                    return eVar.c(true, false);
                }
                l lVarA = e.a(eVar, c1752b7.m().f5460a);
                eVar.e = (f) eVar.c.a();
                return lVarA;
            case 7:
                C1752b c1752b8 = eVar.f4882a;
                Mark mark2 = c1752b8.m().f5460a;
                if (c1752b8.c(token$ID4)) {
                    mark = c1752b8.k().b;
                    z10 = true;
                } else {
                    mark = mark2;
                    z10 = false;
                }
                C1549e c1549e = new C1549e(mark2, mark, z10);
                eVar.e = new C1652a(eVar, 8);
                return c1549e;
            case 8:
                C1597b c1597b5 = eVar.d;
                C1597b c1597b6 = eVar.c;
                C1752b c1752b9 = eVar.f4882a;
                while (c1752b9.c(token$ID4)) {
                    c1752b9.k();
                }
                if (!c1752b9.c(token$ID6)) {
                    c1752b9.f5374a.g = 0;
                    Mark mark3 = c1752b9.m().f5460a;
                    HashMap map3 = new HashMap((HashMap) eVar.f.c);
                    HashMap map4 = e.g;
                    Iterator it = map4.keySet().iterator();
                    while (it.hasNext()) {
                        map3.remove((String) it.next());
                    }
                    eVar.f = new O2.a(7, (Object) null, map3);
                    while (c1752b9.c(token$ID8)) {
                        oa.f fVar = (oa.f) c1752b9.k();
                        String str = fVar.c;
                        List list = fVar.d;
                        Mark mark4 = fVar.f5460a;
                        Mark mark5 = mark3;
                        if (str.equals(YAMLFactory.FORMAT_NAME_YAML)) {
                            if (((DumperOptions$Version) eVar.f.b) != null) {
                                throw new ParserException(null, null, "found duplicate YAML directive", mark4);
                            }
                            if (((Integer) list.get(0)).intValue() != 1) {
                                throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", mark4);
                            }
                            if (((Integer) list.get(1)).intValue() == 0) {
                                eVar.f = new O2.a(7, DumperOptions$Version.V1_0, map3);
                            } else {
                                eVar.f = new O2.a(7, DumperOptions$Version.V1_1, map3);
                            }
                        } else if (fVar.c.equals("TAG")) {
                            String str2 = (String) list.get(0);
                            String str3 = (String) list.get(1);
                            if (map3.containsKey(str2)) {
                                throw new ParserException(null, null, B7.a.k("duplicate tag handle ", str2), mark4);
                            }
                            map3.put(str2, str3);
                        } else {
                            continue;
                        }
                        mark3 = mark5;
                    }
                    Mark mark6 = mark3;
                    HashMap map5 = new HashMap();
                    if (!map3.isEmpty()) {
                        map5 = new HashMap(map3);
                    }
                    HashMap map6 = map5;
                    for (String str4 : map4.keySet()) {
                        if (!map3.containsKey(str4)) {
                            map3.put(str4, (String) map4.get(str4));
                        }
                    }
                    DumperOptions$Version dumperOptions$Version = (DumperOptions$Version) eVar.f.b;
                    while (c1752b9.c(token$ID10)) {
                        c1752b9.k();
                    }
                    if (!c1752b9.c(token$ID6)) {
                        if (c1752b9.c(token$ID7)) {
                            C1550f c1550f = new C1550f(mark6, c1752b9.k().b, true, dumperOptions$Version, map6);
                            c1597b6.b(new C1652a(eVar, 7));
                            eVar.e = new C1652a(eVar, 6);
                            return c1550f;
                        }
                        throw new ParserException(null, null, "expected '<document start>', but found '" + c1752b9.m().a() + "'", c1752b9.m().f5460a);
                    }
                }
                h hVar = (h) c1752b9.k();
                o oVar = new o(hVar.f5460a, hVar.b);
                if (!c1597b6.f4773a.isEmpty()) {
                    throw new YAMLException("Unexpected end of stream. States left: " + c1597b6);
                }
                if (c1597b5.f4773a.isEmpty()) {
                    eVar.e = null;
                    return oVar;
                }
                throw new YAMLException("Unexpected end of stream. Marks left: " + c1597b5);
            case 9:
                C1752b c1752b10 = eVar.f4882a;
                C1548d c1548dB = e.b(eVar, (oa.e) c1752b10.k());
                if (!c1752b10.c(token$ID10)) {
                    eVar.e = (f) eVar.c.a();
                }
                return c1548dB;
            case 10:
                eVar.e = new d(eVar, false, 0 == true ? 1 : 0);
                return e.a(eVar, eVar.f4882a.m().f5460a);
            case 11:
                eVar.d.b(eVar.f4882a.k().f5460a);
                return new d(eVar, c == true ? 1 : 0, 0).a();
            case 12:
                C1752b c1752b11 = eVar.f4882a;
                if (!c1752b11.c(token$ID9)) {
                    eVar.e = new d(eVar, false, 0 == true ? 1 : 0);
                    return e.a(eVar, c1752b11.m().f5460a);
                }
                k kVarK5 = c1752b11.k();
                if (c1752b11.d(token$ID5, Token$ID.FlowMappingEnd)) {
                    eVar.e = new d(eVar, false, 0 == true ? 1 : 0);
                    return e.a(eVar, kVarK5.b);
                }
                eVar.c.b(new d(eVar, false, 0 == true ? 1 : 0));
                return eVar.c(false, false);
            case 13:
                eVar.e = new d(eVar, false, c2 == true ? 1 : 0);
                k kVarM3 = eVar.f4882a.m();
                return new i(kVarM3.f5460a, kVarM3.b);
            case 14:
                C1752b c1752b12 = eVar.f4882a;
                k kVarK6 = c1752b12.k();
                boolean zD = c1752b12.d(token$ID9, token$ID5, token$ID);
                int i13 = 15;
                if (zD) {
                    eVar.e = new C1652a(eVar, i13);
                    return e.a(eVar, kVarK6.b);
                }
                eVar.c.b(new C1652a(eVar, i13));
                return eVar.c(false, false);
            case 15:
                C1752b c1752b13 = eVar.f4882a;
                boolean zC = c1752b13.c(token$ID9);
                int i14 = 13;
                if (!zC) {
                    eVar.e = new C1652a(eVar, i14);
                    return e.a(eVar, c1752b13.m().f5460a);
                }
                k kVarK7 = c1752b13.k();
                if (c1752b13.d(token$ID5, token$ID)) {
                    eVar.e = new C1652a(eVar, i14);
                    return e.a(eVar, kVarK7.b);
                }
                eVar.c.b(new C1652a(eVar, i14));
                return eVar.c(false, false);
            case 16:
                eVar.d.b(eVar.f4882a.k().f5460a);
                return new d(eVar, c10 == true ? 1 : 0, c5 == true ? 1 : 0).a();
            case 17:
                C1752b c1752b14 = eVar.f4882a;
                if (c1752b14.c(token$ID10)) {
                    eVar.e = new C1652a(eVar, i6);
                    return e.b(eVar, (oa.e) c1752b14.k());
                }
                if (c1752b14.d(token$ID8, token$ID7, token$ID6)) {
                    return new C1652a(eVar, 8).a();
                }
                Mark mark7 = c1752b14.m().f5460a;
                C1550f c1550f2 = new C1550f(mark7, mark7, false, null, null);
                eVar.c.b(new C1652a(eVar, 7));
                eVar.e = new C1652a(eVar, 3);
                return c1550f2;
            case 18:
                C1752b c1752b15 = eVar.f4882a;
                C1752b c1752b16 = eVar.f4882a;
                if (c1752b15.c(token$ID10)) {
                    eVar.e = new C1652a(eVar, 18);
                    return e.b(eVar, (oa.e) c1752b16.k());
                }
                if (c1752b16.c(token$ID2)) {
                    return new c(eVar, (oa.d) c1752b16.k(), i10).a();
                }
                k kVarM4 = c1752b16.m();
                m mVar2 = new m(kVarM4.f5460a, kVarM4.b);
                eVar.e = (f) eVar.c.a();
                return mVar2;
            default:
                oa.i iVar2 = (oa.i) eVar.f4882a.k();
                p pVar = new p(iVar2.f5460a, iVar2.b);
                eVar.e = new C1652a(eVar, i6);
                return pVar;
        }
    }
}
