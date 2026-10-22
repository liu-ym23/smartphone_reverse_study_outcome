package stepos.support.v7.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.stepos.agentsafetycenter.R;
import java.lang.reflect.Method;
import n3.m1;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.x1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class m implements stepos.support.v7.widget.e0, n3.s, te.u {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ o f12342c;

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
        r rVar;
        o oVar = this.f12342c;
        te.l lVarK = lVar.k();
        int i = 0;
        boolean z11 = lVarK != lVar;
        if (z11) {
            lVar = lVarK;
        }
        r[] rVarArr = oVar.J;
        int length = rVarArr != null ? rVarArr.length : 0;
        while (true) {
            if (i < length) {
                rVar = rVarArr[i];
                if (rVar != null && rVar.f12467h == lVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                rVar = null;
                break;
            }
        }
        if (rVar != null) {
            if (!z11) {
                oVar.n(rVar, z10);
            } else {
                oVar.l(rVar.f12460a, rVar, lVarK);
                oVar.n(rVar, true);
            }
        }
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        Window.Callback callback;
        o oVar = this.f12342c;
        if (lVar != null || !oVar.f12393l || (callback = oVar.f12388f.getCallback()) == null || oVar.f12400s) {
            return true;
        }
        callback.onMenuOpened(108, lVar);
        return true;
    }

    @Override // n3.s
    public m1 p(View view, m1 m1Var) {
        int i;
        boolean z10;
        boolean z11;
        int iD = m1Var.d();
        o oVar = this.f12342c;
        Context context = oVar.f12387c;
        ActionBarContextView actionBarContextView = oVar.f12406y;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = iD;
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) oVar.f12406y.getLayoutParams();
            if (oVar.f12406y.isShown()) {
                if (oVar.Q == null) {
                    oVar.Q = new Rect();
                    oVar.R = new Rect();
                }
                Rect rect = oVar.Q;
                Rect rect2 = oVar.R;
                rect.set(0, iD, 0, 0);
                ViewGroup viewGroup = oVar.D;
                Method method = x1.f12901a;
                if (method != null) {
                    try {
                        ((Boolean) method.invoke(viewGroup, rect, rect2)).getClass();
                    } catch (Exception e10) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e10);
                    }
                }
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? iD : 0)) {
                    marginLayoutParams.topMargin = iD;
                    View view2 = oVar.F;
                    if (view2 == null) {
                        View view3 = new View(context);
                        oVar.F = view3;
                        view3.setBackgroundColor(context.getResources().getColor(R.color.stepos_background_light));
                        oVar.D.addView(oVar.F, -1, new ViewGroup.LayoutParams(-1, iD));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        if (layoutParams.height != iD) {
                            layoutParams.height = iD;
                            oVar.F.setLayoutParams(layoutParams);
                        }
                    }
                    z11 = true;
                } else {
                    z11 = false;
                }
                z = oVar.F != null;
                i = (oVar.f12395n || !z) ? iD : 0;
                boolean z12 = z;
                z = z11;
                z10 = z12;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i = iD;
                z10 = false;
            } else {
                i = iD;
                z10 = false;
                z = false;
            }
            if (z) {
                oVar.f12406y.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = oVar.F;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        if (iD != i) {
            m1Var = m1Var.f(m1Var.b(), i, m1Var.c(), m1Var.a());
        }
        return n3.k0.d(view, m1Var);
    }
}
