package ce;

import ge.k;
import java.lang.invoke.VarHandle;
import zd.i;
import zd.j;
import zd.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2271a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2272b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2273c;

    public /* synthetic */ e(f fVar, boolean z10, int i) {
        this.f2271a = i;
        this.f2273c = fVar;
        this.f2272b = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ce.g
    public final zd.g a() {
        int i = this.f2271a;
        int i3 = 9;
        f fVar = this.f2273c;
        boolean z10 = this.f2272b;
        int i10 = 10;
        boolean z11 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        int i11 = 1;
        char c9 = 1;
        char c10 = 1;
        char c11 = 1;
        char c12 = 1;
        switch (i) {
            case 0:
                ne.b bVar = fVar.f2278d;
                ne.b bVar2 = fVar.f2277c;
                fe.b bVar3 = fVar.f2275a;
                if (bVar3.c(22)) {
                    fVar.f2279e = new e(fVar, z10, objArr2 == true ? 1 : 0);
                    return f.b(fVar, (ge.e) bVar3.k());
                }
                if (!bVar3.c(11)) {
                    if (!z10) {
                        if (!bVar3.c(10)) {
                            k kVarM = bVar3.m();
                            throw new a("while parsing a flow mapping", (yd.a) bVar.f(), "expected ',' or '}', but got ".concat(androidx.activity.b.A(kVarM.a())), kVarM.f4744a);
                        }
                        bVar3.k();
                        if (bVar3.c(22)) {
                            fVar.f2279e = new e(fVar, c9 == true ? 1 : 0, objArr == true ? 1 : 0);
                            return f.b(fVar, (ge.e) bVar3.k());
                        }
                    }
                    if (bVar3.c(15)) {
                        k kVarK = bVar3.k();
                        int i12 = 12;
                        if (bVar3.d(20, 10, 11)) {
                            fVar.f2279e = new b(fVar, i12);
                            return f.a(fVar, kVarK.f4745b);
                        }
                        bVar2.g(new b(fVar, i12));
                        return fVar.c(false, false);
                    }
                    if (!bVar3.c(11)) {
                        b bVar4 = new b(i10);
                        bVar4.f2264b = fVar;
                        VarHandle.storeStoreFence();
                        bVar2.g(bVar4);
                        return fVar.c(false, false);
                    }
                }
                k kVarK2 = bVar3.k();
                i iVar = new i(kVarK2.f4744a, kVarK2.f4745b);
                bVar.f();
                if (bVar3.c(22)) {
                    fVar.f2279e = new b(fVar, i3);
                } else {
                    fVar.f2279e = (g) bVar2.f();
                }
                return iVar;
            default:
                ne.b bVar5 = fVar.f2277c;
                ne.b bVar6 = fVar.f2278d;
                fe.b bVar7 = fVar.f2275a;
                if (bVar7.c(22)) {
                    fVar.f2279e = new e(fVar, z10, i11);
                    return f.b(fVar, (ge.e) bVar7.k());
                }
                if (!bVar7.c(13)) {
                    if (!z10) {
                        if (!bVar7.c(10)) {
                            k kVarM2 = bVar7.m();
                            throw new a("while parsing a flow sequence", (yd.a) bVar6.f(), "expected ',' or ']', but got ".concat(androidx.activity.b.A(kVarM2.a())), kVarM2.f4744a);
                        }
                        bVar7.k();
                        if (bVar7.c(22)) {
                            fVar.f2279e = new e(fVar, c12 == true ? 1 : 0, c11 == true ? 1 : 0);
                            return f.b(fVar, (ge.e) bVar7.k());
                        }
                    }
                    if (bVar7.c(15)) {
                        k kVarM3 = bVar7.m();
                        j jVar = new j(null, null, true, kVarM3.f4744a, kVarM3.f4745b, vd.a.FLOW);
                        b bVar8 = new b(14);
                        bVar8.f2264b = fVar;
                        VarHandle.storeStoreFence();
                        fVar.f2279e = bVar8;
                        return jVar;
                    }
                    if (!bVar7.c(13)) {
                        bVar5.g(new e(fVar, z11, c10 == true ? 1 : 0));
                        return fVar.c(false, false);
                    }
                }
                k kVarK3 = bVar7.k();
                m mVar = new m(kVarK3.f4744a, kVarK3.f4745b);
                if (bVar7.c(22)) {
                    fVar.f2279e = new b(fVar, i3);
                } else {
                    fVar.f2279e = (g) bVar5.f();
                }
                bVar6.f();
                return mVar;
        }
    }
}
