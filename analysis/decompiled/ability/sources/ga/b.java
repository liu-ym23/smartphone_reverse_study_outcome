package ga;

import ha.AbstractC1551g;
import ha.C1548d;
import ha.C1549e;
import ha.i;
import ha.l;
import ha.m;
import ha.p;
import j4.C1597b;
import java.io.IOException;
import java.util.ArrayList;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.emitter.EmitterException;
import org.yaml.snakeyaml.events.Event$ID;

/* loaded from: classes4.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4511a;
    public final /* synthetic */ c b;

    public /* synthetic */ b(c cVar, int i) {
        this.f4511a = i;
        this.b = cVar;
    }

    @Override // ga.d
    public final void a() throws IOException {
        DumperOptions$ScalarStyle dumperOptions$ScalarStyle;
        switch (this.f4511a) {
            case 0:
                c cVar = this.b;
                boolean z10 = false;
                cVar.n(":", false, false, false);
                A5.c cVar2 = cVar.E;
                A5.c cVar3 = cVar.f4522F;
                AbstractC1551g abstractC1551gP = cVar3.p(cVar.e);
                cVar.e = abstractC1551gP;
                if (!abstractC1551gP.c(Event$ID.g) || ((dumperOptions$ScalarStyle = ((l) abstractC1551gP).e) != DumperOptions$ScalarStyle.FOLDED && dumperOptions$ScalarStyle != DumperOptions$ScalarStyle.LITERAL)) {
                    cVar.o();
                }
                cVar.e = cVar2.p(cVar.e);
                if (!((ArrayList) cVar2.b).isEmpty()) {
                    cVar.h(true, false);
                    c.a(cVar);
                    cVar.m();
                    cVar.g = (Integer) cVar.f.a();
                }
                cVar.b.b(new C1476a(cVar, z10, 0));
                c.b(cVar, false, true, false);
                cVar3.o(null);
                cVar.o();
                return;
            case 1:
                c cVar4 = this.b;
                cVar4.m();
                cVar4.n(":", true, false, true);
                A5.c cVar5 = cVar4.f4522F;
                cVar4.e = cVar5.p(cVar4.e);
                cVar4.o();
                cVar4.e = cVar4.E.p(cVar4.e);
                c.a(cVar4);
                cVar4.b.b(new C1476a(cVar4, false, 0));
                c.b(cVar4, false, true, false);
                cVar5.o(cVar4.e);
                cVar4.o();
                return;
            case 2:
                c cVar6 = this.b;
                cVar6.e = cVar6.E.p(cVar6.e);
                c.a(cVar6);
                if (!(cVar6.e instanceof C1549e)) {
                    throw new EmitterException("expected DocumentEndEvent, but got " + cVar6.e);
                }
                cVar6.m();
                boolean z11 = false;
                if (((C1549e) cVar6.e).c) {
                    cVar6.n("...", true, false, false);
                    cVar6.m();
                }
                cVar6.f4523a.flush();
                cVar6.c = new C1476a(cVar6, z11, 2);
                return;
            case 3:
                c cVar7 = this.b;
                A5.c cVar8 = cVar7.E;
                cVar7.e = cVar8.p(cVar7.e);
                if (!((ArrayList) cVar8.b).isEmpty()) {
                    c.a(cVar7);
                    if (cVar7.e instanceof C1549e) {
                        new b(cVar7, 2).a();
                        return;
                    }
                }
                cVar7.b.b(new b(cVar7, 2));
                c.b(cVar7, true, false, false);
                return;
            case 4:
                new C1476a(this.b, true, 0).a();
                return;
            case 5:
                new C1476a(this.b, true, 1).a();
                return;
            case 6:
                new C1476a(this.b, true, 2).a();
                return;
            case 7:
                c cVar9 = this.b;
                A5.c cVar10 = cVar9.E;
                Boolean bool = cVar9.p;
                C1597b c1597b = cVar9.b;
                cVar9.e = cVar10.p(cVar9.e);
                c.a(cVar9);
                if (cVar9.e instanceof i) {
                    cVar9.g = (Integer) cVar9.f.a();
                    cVar9.h--;
                    cVar9.n("}", false, false, false);
                    cVar9.f4522F.o(null);
                    cVar9.o();
                    cVar9.c = (d) c1597b.a();
                    return;
                }
                if (bool.booleanValue() || ((cVar9.l > cVar9.f4529v && cVar9.f4531x) || cVar9.f4525q.booleanValue())) {
                    cVar9.m();
                }
                if (!bool.booleanValue() && c.c(cVar9)) {
                    c1597b.b(new b(cVar9, 10));
                    c.b(cVar9, false, true, true);
                    return;
                } else {
                    cVar9.n("?", true, false, false);
                    c1597b.b(new b(cVar9, 11));
                    c.b(cVar9, false, true, false);
                    return;
                }
            case 8:
                c cVar11 = this.b;
                AbstractC1551g abstractC1551g = cVar11.e;
                C1597b c1597b2 = cVar11.b;
                A5.c cVar12 = cVar11.f4522F;
                if (abstractC1551g instanceof m) {
                    cVar11.g = (Integer) cVar11.f.a();
                    cVar11.h--;
                    cVar11.n("]", false, false, false);
                    cVar12.o(null);
                    cVar11.o();
                    cVar11.c = (d) c1597b2.a();
                    return;
                }
                if (abstractC1551g instanceof C1548d) {
                    cVar11.E.o(abstractC1551g);
                    c.a(cVar11);
                    return;
                }
                if (cVar11.p.booleanValue() || ((cVar11.l > cVar11.f4529v && cVar11.f4531x) || cVar11.f4525q.booleanValue())) {
                    cVar11.m();
                }
                c1597b2.b(new b(cVar11, 12));
                c.b(cVar11, false, false, false);
                cVar11.e = cVar12.o(cVar11.e);
                cVar11.o();
                return;
            case 9:
                c cVar13 = this.b;
                AbstractC1551g abstractC1551g2 = cVar13.e;
                Boolean bool2 = cVar13.f4525q;
                C1597b c1597b3 = cVar13.b;
                Boolean bool3 = cVar13.p;
                if (abstractC1551g2 instanceof i) {
                    cVar13.g = (Integer) cVar13.f.a();
                    cVar13.h--;
                    if (bool3.booleanValue()) {
                        cVar13.n(",", false, false, false);
                        cVar13.m();
                    }
                    if (bool2.booleanValue()) {
                        cVar13.m();
                    }
                    cVar13.n("}", false, false, false);
                    cVar13.f4522F.o(null);
                    cVar13.o();
                    cVar13.c = (d) c1597b3.a();
                    return;
                }
                cVar13.n(",", false, false, false);
                cVar13.e = cVar13.E.p(cVar13.e);
                c.a(cVar13);
                if (bool3.booleanValue() || ((cVar13.l > cVar13.f4529v && cVar13.f4531x) || bool2.booleanValue())) {
                    cVar13.m();
                }
                if (!bool3.booleanValue() && c.c(cVar13)) {
                    c1597b3.b(new b(cVar13, 10));
                    c.b(cVar13, false, true, true);
                    return;
                } else {
                    cVar13.n("?", true, false, false);
                    c1597b3.b(new b(cVar13, 11));
                    c.b(cVar13, false, true, false);
                    return;
                }
            case 10:
                c cVar14 = this.b;
                cVar14.n(":", false, false, false);
                A5.c cVar15 = cVar14.f4522F;
                cVar14.e = cVar15.p(cVar14.e);
                cVar14.o();
                cVar14.b.b(new b(cVar14, 9));
                c.b(cVar14, false, true, false);
                cVar15.o(cVar14.e);
                cVar14.o();
                return;
            case 11:
                c cVar16 = this.b;
                Boolean bool4 = cVar16.p;
                A5.c cVar17 = cVar16.f4522F;
                if (bool4.booleanValue() || cVar16.l > cVar16.f4529v || cVar16.f4525q.booleanValue()) {
                    cVar16.m();
                }
                cVar16.n(":", true, false, false);
                cVar16.e = cVar17.p(cVar16.e);
                cVar16.o();
                cVar16.b.b(new b(cVar16, 9));
                c.b(cVar16, false, true, false);
                cVar17.o(cVar16.e);
                cVar16.o();
                return;
            case 12:
                c cVar18 = this.b;
                AbstractC1551g abstractC1551g3 = cVar18.e;
                C1597b c1597b4 = cVar18.b;
                A5.c cVar19 = cVar18.f4522F;
                Boolean bool5 = cVar18.p;
                Boolean bool6 = cVar18.f4525q;
                if (abstractC1551g3 instanceof m) {
                    cVar18.g = (Integer) cVar18.f.a();
                    cVar18.h--;
                    if (bool5.booleanValue()) {
                        cVar18.n(",", false, false, false);
                        cVar18.m();
                    } else if (bool6.booleanValue()) {
                        cVar18.m();
                    }
                    cVar18.n("]", false, false, false);
                    cVar19.o(null);
                    cVar18.o();
                    if (bool6.booleanValue()) {
                        cVar18.m();
                    }
                    cVar18.c = (d) c1597b4.a();
                    return;
                }
                if (abstractC1551g3 instanceof C1548d) {
                    cVar18.e = cVar18.E.o(abstractC1551g3);
                    return;
                }
                cVar18.n(",", false, false, false);
                c.a(cVar18);
                if (bool5.booleanValue() || ((cVar18.l > cVar18.f4529v && cVar18.f4531x) || bool6.booleanValue())) {
                    cVar18.m();
                }
                c1597b4.b(new b(cVar18, 12));
                c.b(cVar18, false, false, false);
                cVar18.e = cVar19.o(cVar18.e);
                cVar18.o();
                return;
            case 13:
                throw new EmitterException("expecting nothing, but got " + this.b.e);
            default:
                c cVar20 = this.b;
                if (cVar20.e instanceof p) {
                    cVar20.c = new b(cVar20, 6);
                    return;
                } else {
                    throw new EmitterException("expected StreamStartEvent, but got " + cVar20.e);
                }
        }
    }
}
