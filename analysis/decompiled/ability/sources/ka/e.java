package ka;

import ea.C1429b;
import ha.AbstractC1551g;
import ha.C1545a;
import ha.C1548d;
import ha.h;
import ha.k;
import ha.l;
import ha.n;
import j4.C1597b;
import java.util.HashMap;
import na.C1752b;
import oa.C1788a;
import oa.g;
import oa.j;
import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class e {
    public static final HashMap g;

    /* renamed from: a, reason: collision with root package name */
    public final C1752b f4882a;
    public AbstractC1551g b = null;
    public O2.a f = new O2.a(7, (Object) null, new HashMap(g));
    public final C1597b c = new C1597b(100);
    public final C1597b d = new C1597b(10);
    public f e = new C1652a(this, 19);

    static {
        HashMap map = new HashMap();
        g = map;
        map.put("!", "!");
        map.put("!!", "tag:yaml.org,2002:");
    }

    public e(la.a aVar, C1429b c1429b) {
        this.f4882a = new C1752b(aVar, c1429b);
    }

    public static l a(e eVar, Mark mark) {
        eVar.getClass();
        return new l(null, null, new h(true, false), "", mark, mark, DumperOptions$ScalarStyle.PLAIN);
    }

    public static C1548d b(e eVar, oa.e eVar2) {
        eVar.getClass();
        Mark mark = eVar2.f5460a;
        Mark mark2 = eVar2.b;
        return new C1548d(eVar2.c, eVar2.d, mark, mark2);
    }

    public final k c(boolean z10, boolean z11) {
        Mark mark;
        M0.k kVar;
        Mark mark2;
        Mark mark3;
        String str;
        Mark mark4;
        Mark mark5;
        Token$ID token$ID = Token$ID.Alias;
        C1752b c1752b = this.f4882a;
        boolean zC = c1752b.c(token$ID);
        C1597b c1597b = this.c;
        if (zC) {
            C1788a c1788a = (C1788a) c1752b.k();
            String str2 = c1788a.c;
            C1545a c1545a = new C1545a(str2, c1788a.f5460a, c1788a.b);
            if (str2 == null) {
                throw new NullPointerException("anchor is not specified for alias");
            }
            this.e = (f) c1597b.a();
            return c1545a;
        }
        Token$ID token$ID2 = Token$ID.Anchor;
        boolean zC2 = c1752b.c(token$ID2);
        Token$ID token$ID3 = Token$ID.Tag;
        String strQ = null;
        if (zC2) {
            oa.b bVar = (oa.b) c1752b.k();
            mark = bVar.f5460a;
            Mark mark6 = bVar.b;
            String str3 = bVar.c;
            if (c1752b.c(token$ID3)) {
                j jVar = (j) c1752b.k();
                mark2 = jVar.f5460a;
                mark3 = jVar.b;
                kVar = jVar.c;
            } else {
                kVar = null;
                mark3 = mark6;
                mark2 = null;
            }
            str = str3;
        } else if (c1752b.c(token$ID3)) {
            j jVar2 = (j) c1752b.k();
            Mark mark7 = jVar2.f5460a;
            mark3 = jVar2.b;
            M0.k kVar2 = jVar2.c;
            if (c1752b.c(token$ID2)) {
                oa.b bVar2 = (oa.b) c1752b.k();
                mark3 = bVar2.b;
                str = bVar2.c;
                mark2 = mark7;
            } else {
                mark2 = mark7;
                str = null;
            }
            kVar = kVar2;
            mark = mark2;
        } else {
            mark = null;
            kVar = null;
            mark2 = null;
            mark3 = null;
            str = null;
        }
        if (kVar != null) {
            String str4 = (String) kVar.b;
            strQ = (String) kVar.c;
            if (str4 != null) {
                if (!((HashMap) this.f.c).containsKey(str4)) {
                    throw new ParserException("while parsing a node", mark, "found undefined tag handle ".concat(str4), mark2);
                }
                strQ = B7.a.q(new StringBuilder(), (String) ((HashMap) this.f.c).get(str4), strQ);
            }
        }
        String str5 = strQ;
        if (mark == null) {
            mark4 = c1752b.m().f5460a;
            mark5 = mark4;
        } else {
            mark4 = mark;
            mark5 = mark3;
        }
        boolean z12 = str5 == null || str5.equals("!");
        Mark mark8 = mark5;
        DumperOptions$FlowStyle dumperOptions$FlowStyle = DumperOptions$FlowStyle.BLOCK;
        if (z11 && c1752b.c(Token$ID.BlockEntry)) {
            n nVar = new n(str, str5, z12, mark4, c1752b.m().b, dumperOptions$FlowStyle);
            this.e = new C1652a(this, 18);
            return nVar;
        }
        if (c1752b.c(Token$ID.Scalar)) {
            g gVar = (g) c1752b.k();
            l lVar = new l(str, str5, ((gVar.d && str5 == null) || "!".equals(str5)) ? new h(true, false) : str5 == null ? new h(false, true) : new h(false, false), gVar.c, mark4, gVar.b, gVar.e);
            this.e = (f) c1597b.a();
            return lVar;
        }
        boolean zC3 = c1752b.c(Token$ID.FlowSequenceStart);
        DumperOptions$FlowStyle dumperOptions$FlowStyle2 = DumperOptions$FlowStyle.FLOW;
        if (zC3) {
            n nVar2 = new n(str, str5, z12, mark4, c1752b.m().b, dumperOptions$FlowStyle2);
            this.e = new C1652a(this, 16);
            return nVar2;
        }
        if (c1752b.c(Token$ID.FlowMappingStart)) {
            ha.j jVar3 = new ha.j(str, str5, z12, mark4, c1752b.m().b, dumperOptions$FlowStyle2);
            this.e = new C1652a(this, 11);
            return jVar3;
        }
        if (z10 && c1752b.c(Token$ID.BlockSequenceStart)) {
            n nVar3 = new n(str, str5, z12, mark4, c1752b.m().f5460a, dumperOptions$FlowStyle);
            this.e = new C1652a(this, 5);
            return nVar3;
        }
        if (z10 && c1752b.c(Token$ID.BlockMappingStart)) {
            ha.j jVar4 = new ha.j(str, str5, z12, mark4, c1752b.m().f5460a, dumperOptions$FlowStyle);
            this.e = new C1652a(this, 0);
            return jVar4;
        }
        if (str != null || str5 != null) {
            l lVar2 = new l(str, str5, new h(z12, false), "", mark4, mark8, DumperOptions$ScalarStyle.PLAIN);
            this.e = (f) c1597b.a();
            return lVar2;
        }
        oa.k kVarM = c1752b.m();
        throw new ParserException(B7.a.q(new StringBuilder("while parsing a "), z10 ? "block" : "flow", " node"), mark4, "expected the node content, but found '" + kVarM.a() + "'", kVarM.f5460a);
    }
}
