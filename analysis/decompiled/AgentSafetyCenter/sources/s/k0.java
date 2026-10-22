package s;

import android.view.View;
import java.time.ZoneId;
import java.util.List;
import k0.z1;
import v1.c2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11038c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f11039f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11040g;

    /* renamed from: h, reason: collision with root package name */
    public Object f11041h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public Object f11042j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f11043k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f11044l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(int i, s8.d1 d1Var, ZoneId zoneId, List list, List list2, List list3, xb.l lVar, nb.c cVar) {
        super(2, cVar);
        this.f11039f = i;
        this.f11040g = d1Var;
        this.f11041h = zoneId;
        this.i = list;
        this.f11042j = list2;
        this.f11043k = list3;
        this.f11044l = lVar;
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [pb.i, xb.l] */
    /* JADX WARN: Type inference failed for: r11v5, types: [xb.l, yb.l] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f11038c) {
            case 0:
                k0 k0Var = new k0((l0) this.f11043k, (pb.i) this.f11044l, cVar);
                k0Var.i = obj;
                return k0Var;
            case 1:
                return new k0(this.f11039f, (s8.d1) this.f11040g, (ZoneId) this.f11041h, (List) this.i, (List) this.f11042j, (List) this.f11043k, (xb.l) this.f11044l, cVar);
            case 2:
                k0 k0Var2 = new k0((o1.w) this.f11040g, (xb.q) this.i, (xb.l) this.f11042j, (xb.l) this.f11043k, (xb.l) this.f11044l, cVar);
                k0Var2.f11041h = obj;
                return k0Var2;
            default:
                k0 k0Var3 = new k0((yb.u) this.f11040g, (z1) this.i, (androidx.lifecycle.x) this.f11042j, (c2) this.f11043k, (View) this.f11044l, cVar);
                k0Var3.f11041h = obj;
                return k0Var3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f11038c) {
            case 1:
                k0 k0Var = (k0) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                k0Var.invokeSuspend(vVar);
                break;
        }
        return ((k0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstInlineVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected instance arg in invoke
        	at jadx.core.dex.visitors.ConstInlineVisitor.addExplicitCast(ConstInlineVisitor.java:285)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceArg(ConstInlineVisitor.java:267)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:177)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:110)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:55)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:47)
        */
    @Override // pb.a
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.k0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k0(o1.w wVar, xb.q qVar, xb.l lVar, xb.l lVar2, xb.l lVar3, nb.c cVar) {
        super(2, cVar);
        this.f11040g = wVar;
        this.i = qVar;
        this.f11042j = lVar;
        this.f11043k = lVar2;
        this.f11044l = (yb.l) lVar3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k0(l0 l0Var, xb.l lVar, nb.c cVar) {
        super(2, cVar);
        this.f11043k = l0Var;
        this.f11044l = (pb.i) lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(yb.u uVar, z1 z1Var, androidx.lifecycle.x xVar, c2 c2Var, View view, nb.c cVar) {
        super(2, cVar);
        this.f11040g = uVar;
        this.i = z1Var;
        this.f11042j = xVar;
        this.f11043k = c2Var;
        this.f11044l = view;
    }
}
