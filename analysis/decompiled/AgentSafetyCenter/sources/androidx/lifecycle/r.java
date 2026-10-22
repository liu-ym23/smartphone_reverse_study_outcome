package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import java.util.List;
import s8.y2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1428c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1429f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1430g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r(xb.p pVar, nb.c cVar) {
        super(2, cVar);
        this.f1428c = 9;
        this.f1430g = (pb.i) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v20, types: [pb.i, xb.p] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f1428c) {
            case 0:
                r rVar = new r((s) this.f1430g, cVar, 0);
                rVar.f1429f = obj;
                return rVar;
            case 1:
                r rVar2 = new r((g9.a1) this.f1430g, cVar, 1);
                rVar2.f1429f = obj;
                return rVar2;
            case 2:
                r rVar3 = new r((i9.b0) this.f1430g, cVar, 2);
                rVar3.f1429f = obj;
                return rVar3;
            case 3:
                return new r((m8.k0) this.f1429f, (k8.d0) this.f1430g, cVar, 3);
            case 4:
                return new r((Context) this.f1429f, (b.m) this.f1430g, cVar, 4);
            case 5:
                r rVar4 = new r((ab.e) this.f1430g, cVar, 5);
                rVar4.f1429f = obj;
                return rVar4;
            case 6:
                return new r((Application) this.f1429f, (y2) this.f1430g, cVar, 6);
            case 7:
                return new r((Application) this.f1429f, (String) this.f1430g, cVar, 7);
            case 8:
                return new r((m8.k0) this.f1429f, (x8.a) this.f1430g, cVar, 8);
            case 9:
                r rVar5 = new r((xb.p) this.f1430g, cVar);
                rVar5.f1429f = obj;
                return rVar5;
            case 10:
                r rVar6 = new r((Context) this.f1430g, cVar, 10);
                rVar6.f1429f = obj;
                return rVar6;
            case 11:
                r rVar7 = new r(cVar, (xb.l) this.f1430g);
                rVar7.f1429f = obj;
                return rVar7;
            case 12:
                return new r((qa.b) this.f1429f, (List) this.f1430g, cVar, 12);
            default:
                r rVar8 = new r((v3.q0) this.f1430g, cVar, 13);
                rVar8.f1429f = obj;
                return rVar8;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Exception {
        switch (this.f1428c) {
            case 0:
                r rVar = (r) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                rVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                r rVar2 = (r) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                rVar2.invokeSuspend(vVar2);
                return vVar2;
            case 2:
                r rVar3 = (r) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar3 = jb.v.f6774a;
                rVar3.invokeSuspend(vVar3);
                return vVar3;
            case 3:
                r rVar4 = (r) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar4 = jb.v.f6774a;
                rVar4.invokeSuspend(vVar4);
                return vVar4;
            case 4:
                r rVar5 = (r) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar5 = jb.v.f6774a;
                rVar5.invokeSuspend(vVar5);
                return vVar5;
            case 5:
                return ((r) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 6:
                return ((r) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 7:
                return ((r) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 8:
                r rVar6 = (r) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar6 = jb.v.f6774a;
                rVar6.invokeSuspend(vVar6);
                return vVar6;
            case 9:
                return ((r) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 10:
                r rVar7 = (r) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar7 = jb.v.f6774a;
                rVar7.invokeSuspend(vVar7);
                return vVar7;
            case 11:
                return ((r) create((o4.k) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 12:
                return ((r) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((r) create((v3.q0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.lang.Cloneable, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r6v14, types: [pb.i, xb.p] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f1428c = i;
        this.f1430g = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(nb.c cVar, xb.l lVar) {
        super(2, cVar);
        this.f1428c = 11;
        this.f1430g = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, Object obj2, nb.c cVar, int i) {
        super(2, cVar);
        this.f1428c = i;
        this.f1429f = obj;
        this.f1430g = obj2;
    }
}
