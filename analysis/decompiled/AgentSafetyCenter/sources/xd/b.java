package xd;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p5.m;
import zd.g;
import zd.i;
import zd.l;
import zd.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15685a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ c f15686b;

    public /* synthetic */ b(c cVar, int i) {
        this.f15685a = i;
        this.f15686b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xd.e
    public final void a() throws IOException {
        vd.b bVar;
        int i = 11;
        int i3 = 10;
        int i10 = 9;
        int i11 = 12;
        int i12 = 2;
        int i13 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        boolean z10 = true;
        char c9 = 1;
        char c10 = 1;
        char c11 = 1;
        switch (this.f15685a) {
            case 0:
                c cVar = this.f15686b;
                cVar.n(":", false, false, false);
                m mVar = cVar.E;
                m mVar2 = cVar.F;
                g gVarT = mVar2.t(cVar.f15691e);
                cVar.f15691e = gVarT;
                if (!gVarT.c(7) || ((bVar = ((l) gVarT).f16593e) != vd.b.FOLDED && bVar != vd.b.LITERAL)) {
                    cVar.o();
                }
                cVar.f15691e = mVar.t(cVar.f15691e);
                if (!((ArrayList) mVar.f9741f).isEmpty()) {
                    cVar.h(true, false);
                    c.a(cVar);
                    cVar.m();
                    cVar.f15693g = (Integer) cVar.f15692f.f();
                }
                cVar.f15688b.g(new a(cVar, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0));
                c.b(cVar, false, true, false);
                mVar2.s(null);
                cVar.o();
                return;
            case 1:
                c cVar2 = this.f15686b;
                cVar2.m();
                cVar2.n(":", true, false, true);
                m mVar3 = cVar2.F;
                cVar2.f15691e = mVar3.t(cVar2.f15691e);
                cVar2.o();
                cVar2.f15691e = cVar2.E.t(cVar2.f15691e);
                c.a(cVar2);
                cVar2.f15688b.g(new a(cVar2, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0));
                c.b(cVar2, false, true, false);
                mVar3.s(cVar2.f15691e);
                cVar2.o();
                return;
            case 2:
                c cVar3 = this.f15686b;
                cVar3.f15691e = cVar3.E.t(cVar3.f15691e);
                c.a(cVar3);
                if (!(cVar3.f15691e instanceof zd.e)) {
                    od.f.s(cVar3.f15691e, "expected DocumentEndEvent, but got ");
                    return;
                }
                cVar3.m();
                if (((zd.e) cVar3.f15691e).f16583c) {
                    cVar3.n("...", true, false, false);
                    cVar3.m();
                }
                cVar3.f15687a.flush();
                cVar3.f15689c = new a(cVar3, objArr5 == true ? 1 : 0, i12);
                return;
            case 3:
                c cVar4 = this.f15686b;
                m mVar4 = cVar4.E;
                cVar4.f15691e = mVar4.t(cVar4.f15691e);
                if (!((ArrayList) mVar4.f9741f).isEmpty()) {
                    c.a(cVar4);
                    if (cVar4.f15691e instanceof zd.e) {
                        new b(cVar4, i12).a();
                        return;
                    }
                }
                cVar4.f15688b.g(new b(cVar4, i12));
                c.b(cVar4, true, false, false);
                return;
            case 4:
                new a(this.f15686b, c9 == true ? 1 : 0, i13).a();
                return;
            case 5:
                new a(this.f15686b, c11 == true ? 1 : 0, c10 == true ? 1 : 0).a();
                return;
            case 6:
                new a(this.f15686b, z10, i12).a();
                return;
            case 7:
                c cVar5 = this.f15686b;
                m mVar5 = cVar5.E;
                Boolean bool = cVar5.f15701p;
                ne.b bVar2 = cVar5.f15688b;
                cVar5.f15691e = mVar5.t(cVar5.f15691e);
                c.a(cVar5);
                if (cVar5.f15691e instanceof i) {
                    cVar5.f15693g = (Integer) cVar5.f15692f.f();
                    cVar5.f15694h--;
                    cVar5.n("}", false, false, false);
                    cVar5.F.s(null);
                    cVar5.o();
                    cVar5.f15689c = (e) bVar2.f();
                    return;
                }
                if (bool.booleanValue() || ((cVar5.f15697l > cVar5.f15707v && cVar5.f15709x) || cVar5.f15702q.booleanValue())) {
                    cVar5.m();
                }
                if (!bool.booleanValue() && c.c(cVar5)) {
                    bVar2.g(new b(cVar5, i3));
                    c.b(cVar5, false, true, true);
                    return;
                } else {
                    cVar5.n("?", true, false, false);
                    bVar2.g(new b(cVar5, i));
                    c.b(cVar5, false, true, false);
                    return;
                }
            case 8:
                c cVar6 = this.f15686b;
                g gVar = cVar6.f15691e;
                ne.b bVar3 = cVar6.f15688b;
                m mVar6 = cVar6.F;
                if (gVar instanceof zd.m) {
                    cVar6.f15693g = (Integer) cVar6.f15692f.f();
                    cVar6.f15694h--;
                    cVar6.n("]", false, false, false);
                    mVar6.s(null);
                    cVar6.o();
                    cVar6.f15689c = (e) bVar3.f();
                    return;
                }
                if (gVar instanceof zd.d) {
                    cVar6.E.s(gVar);
                    c.a(cVar6);
                    return;
                }
                if (cVar6.f15701p.booleanValue() || ((cVar6.f15697l > cVar6.f15707v && cVar6.f15709x) || cVar6.f15702q.booleanValue())) {
                    cVar6.m();
                }
                bVar3.g(new b(cVar6, i11));
                c.b(cVar6, false, false, false);
                cVar6.f15691e = mVar6.s(cVar6.f15691e);
                cVar6.o();
                return;
            case 9:
                c cVar7 = this.f15686b;
                g gVar2 = cVar7.f15691e;
                Boolean bool2 = cVar7.f15702q;
                ne.b bVar4 = cVar7.f15688b;
                Boolean bool3 = cVar7.f15701p;
                if (gVar2 instanceof i) {
                    cVar7.f15693g = (Integer) cVar7.f15692f.f();
                    cVar7.f15694h--;
                    if (bool3.booleanValue()) {
                        cVar7.n(",", false, false, false);
                        cVar7.m();
                    }
                    if (bool2.booleanValue()) {
                        cVar7.m();
                    }
                    cVar7.n("}", false, false, false);
                    cVar7.F.s(null);
                    cVar7.o();
                    cVar7.f15689c = (e) bVar4.f();
                    return;
                }
                cVar7.n(",", false, false, false);
                cVar7.f15691e = cVar7.E.t(cVar7.f15691e);
                c.a(cVar7);
                if (bool3.booleanValue() || ((cVar7.f15697l > cVar7.f15707v && cVar7.f15709x) || bool2.booleanValue())) {
                    cVar7.m();
                }
                if (!bool3.booleanValue() && c.c(cVar7)) {
                    bVar4.g(new b(cVar7, i3));
                    c.b(cVar7, false, true, true);
                    return;
                } else {
                    cVar7.n("?", true, false, false);
                    bVar4.g(new b(cVar7, i));
                    c.b(cVar7, false, true, false);
                    return;
                }
            case 10:
                c cVar8 = this.f15686b;
                cVar8.n(":", false, false, false);
                m mVar7 = cVar8.F;
                cVar8.f15691e = mVar7.t(cVar8.f15691e);
                cVar8.o();
                cVar8.f15688b.g(new b(cVar8, i10));
                c.b(cVar8, false, true, false);
                mVar7.s(cVar8.f15691e);
                cVar8.o();
                return;
            case 11:
                c cVar9 = this.f15686b;
                Boolean bool4 = cVar9.f15701p;
                m mVar8 = cVar9.F;
                if (bool4.booleanValue() || cVar9.f15697l > cVar9.f15707v || cVar9.f15702q.booleanValue()) {
                    cVar9.m();
                }
                cVar9.n(":", true, false, false);
                cVar9.f15691e = mVar8.t(cVar9.f15691e);
                cVar9.o();
                cVar9.f15688b.g(new b(cVar9, i10));
                c.b(cVar9, false, true, false);
                mVar8.s(cVar9.f15691e);
                cVar9.o();
                return;
            case 12:
                c cVar10 = this.f15686b;
                g gVar3 = cVar10.f15691e;
                ne.b bVar5 = cVar10.f15688b;
                m mVar9 = cVar10.F;
                Boolean bool5 = cVar10.f15701p;
                Boolean bool6 = cVar10.f15702q;
                if (gVar3 instanceof zd.m) {
                    cVar10.f15693g = (Integer) cVar10.f15692f.f();
                    cVar10.f15694h--;
                    if (bool5.booleanValue()) {
                        cVar10.n(",", false, false, false);
                        cVar10.m();
                    } else if (bool6.booleanValue()) {
                        cVar10.m();
                    }
                    cVar10.n("]", false, false, false);
                    mVar9.s(null);
                    cVar10.o();
                    if (bool6.booleanValue()) {
                        cVar10.m();
                    }
                    cVar10.f15689c = (e) bVar5.f();
                    return;
                }
                if (gVar3 instanceof zd.d) {
                    cVar10.f15691e = cVar10.E.s(gVar3);
                    return;
                }
                cVar10.n(",", false, false, false);
                c.a(cVar10);
                if (bool5.booleanValue() || ((cVar10.f15697l > cVar10.f15707v && cVar10.f15709x) || bool6.booleanValue())) {
                    cVar10.m();
                }
                bVar5.g(new b(cVar10, i11));
                c.b(cVar10, false, false, false);
                cVar10.f15691e = mVar9.s(cVar10.f15691e);
                cVar10.o();
                return;
            case 13:
                throw new d("expecting nothing, but got " + this.f15686b.f15691e);
            default:
                c cVar11 = this.f15686b;
                if (!(cVar11.f15691e instanceof p)) {
                    od.f.s(cVar11.f15691e, "expected StreamStartEvent, but got ");
                    return;
                }
                b bVar6 = new b(6);
                bVar6.f15686b = cVar11;
                VarHandle.storeStoreFence();
                cVar11.f15689c = bVar6;
                return;
        }
    }

    public /* synthetic */ b(int i) {
        this.f15685a = i;
    }
}
