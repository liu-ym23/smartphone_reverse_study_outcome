package r2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f10412a = new i(0);

    public static final boolean a(View view, View view2) {
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view.getParent()) {
                return true;
            }
        }
        return false;
    }

    public static final Rect b(b1.h hVar, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        b1.q qVarG = b1.e.g(((b1.i) hVar).f1820c);
        c1.c cVarJ = qVarG != null ? b1.e.j(qVarG) : null;
        if (cVarJ == null) {
            return null;
        }
        int i = (int) cVarJ.f2167a;
        int i3 = iArr[0];
        int i10 = iArr2[0];
        int i11 = (int) cVarJ.f2168b;
        int i12 = iArr[1];
        int i13 = iArr2[1];
        return new Rect((i + i3) - i10, (i11 + i12) - i13, (((int) cVarJ.f2169c) + i3) - i10, (((int) cVarJ.f2170d) + i12) - i13);
    }

    public static final View c(w0.l lVar) {
        q qVar = u1.f.u(lVar.f15114c).f13801r;
        View interopView = qVar != null ? qVar.getInteropView() : null;
        if (interopView != null) {
            return interopView;
        }
        od.f.e("Could not fetch interop view");
        return null;
    }

    public static final void d(q qVar, g0 g0Var) {
        long jD = g0Var.H.f13743c.D(0L);
        int iRound = Math.round(Float.intBitsToFloat((int) (jD >> 32)));
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jD & 4294967295L)));
        qVar.layout(iRound, iRound2, qVar.getMeasuredWidth() + iRound, qVar.getMeasuredHeight() + iRound2);
    }
}
