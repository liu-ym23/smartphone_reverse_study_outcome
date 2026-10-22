package b;

import android.graphics.Canvas;
import androidx.activity.e0;
import androidx.lifecycle.x;
import b1.q;
import d1.g0;
import d1.m0;
import d1.o;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import jb.v;
import k0.c1;
import k0.r2;
import kc.x0;
import r.i0;
import r.n;
import r.q0;
import r.w;
import s1.n0;
import u.y0;
import u.z0;
import u1.a2;
import u1.n1;
import u1.o0;
import u1.z1;
import v1.t;
import w.j0;
import w.k0;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1698c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1699f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1700g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1701h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(q qVar, b1.i iVar, xb.l lVar) {
        super(1);
        this.f1698c = 1;
        this.f1699f = qVar;
        this.f1700g = iVar;
        this.f1701h = (yb.l) lVar;
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [xb.l, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f1698c;
        boolean zBooleanValue = false;
        m0 m0Var = null;
        m0Var = null;
        int i3 = 1;
        v vVar = v.f6774a;
        Object obj2 = this.f1700g;
        Object obj3 = this.f1699f;
        Object obj4 = this.f1701h;
        switch (i) {
            case 0:
                i iVar = (i) obj4;
                ((e0) obj3).a((x) obj2, iVar);
                c cVar = new c(i3);
                cVar.f1687b = iVar;
                VarHandle.storeStoreFence();
                return cVar;
            case 1:
                q qVar = (q) obj;
                if (!yb.k.a(qVar, (q) obj3)) {
                    if (yb.k.a(qVar, ((b1.i) obj2).f1820c)) {
                        od.f.e("Focus search landed at the root.");
                        return null;
                    }
                    zBooleanValue = ((Boolean) ((yb.l) obj4).invoke(qVar)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            case 2:
                r.f fVar = new r.f(zBooleanValue ? 1 : 0);
                fVar.f10275c = (u0.q) obj3;
                fVar.f10274b = obj2;
                fVar.f10276d = (n) obj4;
                VarHandle.storeStoreFence();
                return fVar;
            case 3:
                g0 g0Var = (g0) obj;
                r2 r2Var = (r2) obj2;
                r2 r2Var2 = (r2) obj3;
                g0Var.b(r2Var2 != null ? ((Number) r2Var2.getValue()).floatValue() : 1.0f);
                g0Var.c(r2Var != null ? ((Number) r2Var.getValue()).floatValue() : 1.0f);
                g0Var.d(r2Var != null ? ((Number) r2Var.getValue()).floatValue() : 1.0f);
                r2 r2Var3 = (r2) obj4;
                g0Var.f(r2Var3 != null ? ((m0) r2Var3.getValue()).f3017a : m0.f3015b);
                return vVar;
            case 4:
                i0 i0Var = (i0) obj4;
                int iOrdinal = ((w) obj).ordinal();
                if (iOrdinal == 0) {
                    q0 q0Var = i0Var.f10306a;
                } else if (iOrdinal == 1) {
                    m0Var = (m0) obj3;
                } else {
                    if (iOrdinal != 2) {
                        g5.f.a();
                        return null;
                    }
                    q0 q0Var2 = i0Var.f10306a;
                }
                return m0.a(m0Var != null ? m0Var.f3017a : m0.f3015b);
            case 5:
                r2.q qVar2 = (r2.q) obj3;
                u1.g0 g0Var2 = (u1.g0) obj2;
                r2.q qVar3 = (r2.q) obj4;
                o oVarY = ((f1.d) obj).a0().y();
                if (qVar2.getView().getVisibility() != 8) {
                    qVar2.B = true;
                    n1 n1Var = g0Var2.f13800q;
                    t tVar = n1Var instanceof t ? (t) n1Var : null;
                    if (tVar != null) {
                        Canvas canvasA = d1.b.a(oVarY);
                        tVar.getAndroidViewsHandler$ui_release().getClass();
                        qVar3.draw(canvasA);
                    }
                    qVar2.B = false;
                }
                return vVar;
            case 6:
                float fFloatValue = ((Number) obj).floatValue();
                u.i iVar2 = (u.i) obj3;
                float f5 = iVar2.f13481u ? 1.0f : -1.0f;
                z0 z0Var = iVar2.f13480t;
                long jD = z0Var.d(z0Var.g(f5 * fFloatValue));
                z0 z0Var2 = ((y0) obj4).f13619a;
                float f10 = z0Var.f(z0Var.d(z0.a(z0Var2, z0Var2.f13631h, jD, 1))) * f5;
                if (Math.abs(f10) < Math.abs(fFloatValue)) {
                    CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + f10 + " < " + fFloatValue + ')');
                    cancellationException.initCause(null);
                    ((x0) obj2).e(cancellationException);
                }
                return vVar;
            case 7:
                n0 n0Var = (n0) obj;
                o0 o0Var = (o0) obj4;
                w.i0 i0Var2 = (w.i0) obj3;
                boolean z10 = i0Var2.f14985u;
                s1.o0 o0Var2 = (s1.o0) obj2;
                float f11 = i0Var2.f14983s;
                if (z10) {
                    n0.l(n0Var, o0Var2, o0Var.e0(f11), o0Var.e0(i0Var2.f14984t));
                } else {
                    n0Var.g(o0Var2, o0Var.e0(f11), o0Var.e0(i0Var2.f14984t), 0.0f);
                }
                return vVar;
            case 8:
                n0 n0Var2 = (n0) obj;
                j0 j0Var = (j0) obj3;
                long j10 = ((o2.i) j0Var.f14988s.invoke((o0) obj2)).f9116a;
                s1.o0 o0Var3 = (s1.o0) obj4;
                if (j0Var.f14989t) {
                    n0.m(n0Var2, o0Var3, (int) (j10 >> 32), (int) (j10 & 4294967295L));
                } else {
                    n0.o(n0Var2, o0Var3, (int) (j10 >> 32), (int) (j10 & 4294967295L), null, 12);
                }
                return vVar;
            case 9:
                n0 n0Var3 = (n0) obj;
                o0 o0Var4 = (o0) obj4;
                k0 k0Var = (k0) obj3;
                boolean z11 = k0Var.f14999w;
                s1.o0 o0Var5 = (s1.o0) obj2;
                float f12 = k0Var.f14995s;
                if (z11) {
                    n0.l(n0Var3, o0Var5, o0Var4.e0(f12), o0Var4.e0(k0Var.f14996t));
                } else {
                    n0Var3.g(o0Var5, o0Var4.e0(f12), o0Var4.e0(k0Var.f14996t), 0.0f);
                }
                return vVar;
            case 10:
                o0 o0Var6 = (o0) obj2;
                w.m0 m0Var2 = (w.m0) obj4;
                ((n0) obj).g((s1.o0) obj3, o0Var6.e0(m0Var2.f15009s.b(o0Var6.getLayoutDirection())), o0Var6.e0(m0Var2.f15009s.d()), 0.0f);
                return vVar;
            case 11:
                n0 n0Var4 = (n0) obj;
                ArrayList arrayList = (ArrayList) obj3;
                x.n nVar = (x.n) obj2;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    x.n nVar2 = (x.n) arrayList.get(i10);
                    if (nVar2 != nVar) {
                        nVar2.b(n0Var4);
                    }
                }
                if (nVar != null) {
                    nVar.b(n0Var4);
                }
                ((c1) obj4).getValue();
                return vVar;
            default:
                a2 a2Var = (a2) obj;
                z0.d dVar = (z0.d) a2Var;
                if (!((z0.a) ((t) u1.f.v((z0.d) obj2)).m8getDragAndDropManager()).f16139b.contains(dVar) || !t.n.d(dVar, t.o.h((sa.c) obj4))) {
                    return z1.f13977c;
                }
                ((u) obj3).f16098c = a2Var;
                return z1.f13979g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i) {
        super(1);
        this.f1698c = i;
        this.f1699f = obj;
        this.f1700g = obj2;
        this.f1701h = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ArrayList arrayList, x.n nVar, boolean z10, c1 c1Var) {
        super(1);
        this.f1698c = 11;
        this.f1699f = arrayList;
        this.f1700g = nVar;
        this.f1701h = c1Var;
    }
}
