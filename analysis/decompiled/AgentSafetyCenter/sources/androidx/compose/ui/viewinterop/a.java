package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.ui.focus.FocusTargetNode$FocusTargetElement;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import k0.p;
import k0.s;
import k0.v1;
import k0.z;
import o2.c;
import r2.q;
import s0.g;
import t.o;
import t0.i;
import t4.f;
import u1.g0;
import u1.h;
import u1.j;
import v1.a1;
import w0.m;
import xb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final void a(l lVar, m mVar, l lVar2, s sVar, int i) {
        int i3;
        f fVar;
        o2.l lVar3;
        x xVar;
        c cVar;
        Object obj = r2.c.i;
        sVar.Z(-180024211);
        if ((i & 6) == 0) {
            i3 = (sVar.h(lVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(mVar) ? 32 : 16;
        }
        int i10 = i3 | 384;
        if ((i & 3072) == 0) {
            i10 |= sVar.h(obj) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= sVar.h(lVar2) ? 16384 : 8192;
        }
        if (sVar.P(i10 & 1, (i10 & 9363) != 9362)) {
            int iHashCode = Long.hashCode(sVar.T);
            m mVarD = mVar.d(FocusGroupPropertiesElement.f990c);
            FocusTargetNode$FocusTargetElement focusTargetNode$FocusTargetElement = FocusTargetNode$FocusTargetElement.f953c;
            m mVarM = o.m(sVar, mVarD.d(focusTargetNode$FocusTargetElement).d(FocusTargetPropertiesElement.f991c).d(focusTargetNode$FocusTargetElement));
            c cVar2 = (c) sVar.j(a1.f14363h);
            o2.l lVar4 = (o2.l) sVar.j(a1.f14368n);
            g gVarL = sVar.l();
            x xVar2 = (x) sVar.j(f4.c.f3915a);
            f fVar2 = (f) sVar.j(u4.a.f14046a);
            sVar.X(1314800527);
            int i11 = i10 & 14;
            int iHashCode2 = Long.hashCode(sVar.T);
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            p pVarY = z.y(sVar);
            t0.g gVar = (t0.g) sVar.j(i.f13120a);
            View view = (View) sVar.j(AndroidCompositionLocals_androidKt.f986f);
            boolean zH = sVar.h(context) | ((((i11 & 14) ^ 6) > 4 && sVar.f(lVar)) || (i11 & 6) == 4) | sVar.h(pVarY) | sVar.h(gVar) | sVar.d(iHashCode2) | sVar.h(view);
            Object objM = sVar.M();
            if (zH || objM == k0.m.f6974a) {
                fVar = fVar2;
                lVar3 = lVar4;
                xVar = xVar2;
                cVar = cVar2;
                Object mVar2 = new r2.m(context, lVar, pVarY, gVar, iHashCode2, view);
                sVar.i0(mVar2);
                objM = mVar2;
            } else {
                fVar = fVar2;
                lVar3 = lVar4;
                cVar = cVar2;
                xVar = xVar2;
            }
            xb.a aVar = (xb.a) objM;
            sVar.T(null, 125, 1, null);
            sVar.f7049r = true;
            x xVar3 = xVar;
            if (sVar.S) {
                sVar.k(aVar);
            } else {
                sVar.l0();
            }
            j.f13840e.getClass();
            z.B(gVarL, sVar, u1.i.f13835d);
            z.B(mVarM, sVar, r2.l.f10419h);
            z.B(cVar, sVar, r2.l.i);
            z.B(xVar3, sVar, r2.l.f10420j);
            z.B(fVar, sVar, r2.l.f10421k);
            z.B(lVar3, sVar, r2.l.f10422l);
            h hVar = u1.i.f13837f;
            if (sVar.S || !k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            z.B(lVar2, sVar, r2.l.f10417f);
            z.B(obj, sVar, r2.l.f10418g);
            sVar.q(true);
            sVar.q(false);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r2.k(lVar, mVar, lVar2, i);
        }
    }

    public static final void b(l lVar, m mVar, l lVar2, s sVar, int i, int i3) {
        int i10;
        sVar.Z(-1783766393);
        int i11 = (sVar.h(lVar) ? 4 : 2) | i;
        int i12 = i3 & 2;
        if (i12 != 0) {
            i10 = i11 | 48;
        } else {
            i10 = i11 | (sVar.f(mVar) ? 32 : 16);
        }
        int i13 = i10 | (sVar.h(lVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar.P(i13 & 1, (i13 & 147) != 146)) {
            if (i12 != 0) {
                mVar = w0.j.f15113c;
            }
            a(lVar, mVar, lVar2, sVar, ((i13 << 6) & 57344) | (i13 & 14) | 3072 | (i13 & 112));
        } else {
            sVar.S();
        }
        m mVar2 = mVar;
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r2.k(lVar, mVar2, lVar2, i, i3);
        }
    }

    public static final q c(g0 g0Var) {
        q qVar = g0Var.f13801r;
        if (qVar != null) {
            return qVar;
        }
        throw w2.c.a("Required value was null.");
    }
}
