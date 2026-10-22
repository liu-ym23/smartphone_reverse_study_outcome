package h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.stepos.agentsafetycenter.R;
import java.util.WeakHashMap;
import m.z2;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements n3.s, l.w {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e0 f4892c;

    @Override // l.w
    public void d(l.l lVar, boolean z10) {
        d0 d0Var;
        e0 e0Var = this.f4892c;
        l.l lVarK = lVar.k();
        int i = 0;
        boolean z11 = lVarK != lVar;
        if (z11) {
            lVar = lVarK;
        }
        d0[] d0VarArr = e0Var.N;
        int length = d0VarArr != null ? d0VarArr.length : 0;
        while (true) {
            if (i < length) {
                d0Var = d0VarArr[i];
                if (d0Var != null && d0Var.f4773h == lVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                d0Var = null;
                break;
            }
        }
        if (d0Var != null) {
            if (!z11) {
                e0Var.q(d0Var, z10);
            } else {
                e0Var.o(d0Var.f4766a, d0Var, lVarK);
                e0Var.q(d0Var, true);
            }
        }
    }

    @Override // l.w
    public boolean f(l.l lVar) {
        Window.Callback callback;
        e0 e0Var = this.f4892c;
        if (lVar != lVar.k() || !e0Var.H || (callback = e0Var.f4795m.getCallback()) == null || e0Var.S) {
            return true;
        }
        callback.onMenuOpened(108, lVar);
        return true;
    }

    @Override // n3.s
    public m1 p(View view, m1 m1Var) {
        boolean z10;
        boolean z11;
        int iD = m1Var.d();
        e0 e0Var = this.f4892c;
        Context context = e0Var.f4794l;
        int iD2 = m1Var.d();
        ActionBarContextView actionBarContextView = e0Var.f4805w;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) e0Var.f4805w.getLayoutParams();
            if (e0Var.f4805w.isShown()) {
                if (e0Var.e0 == null) {
                    e0Var.e0 = new Rect();
                    e0Var.f0 = new Rect();
                }
                Rect rect = e0Var.e0;
                Rect rect2 = e0Var.f0;
                rect.set(m1Var.b(), m1Var.d(), m1Var.c(), m1Var.a());
                z2.a(e0Var.C, rect, rect2);
                int i = rect.top;
                int i3 = rect.left;
                int i10 = rect.right;
                ViewGroup viewGroup = e0Var.C;
                WeakHashMap weakHashMap = n3.k0.f8724a;
                m1 m1VarA = n3.f0.a(viewGroup);
                int iB = m1VarA == null ? 0 : m1VarA.b();
                int iC = m1VarA == null ? 0 : m1VarA.c();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i10) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i10;
                    z11 = true;
                }
                if (i <= 0 || e0Var.E != null) {
                    View view2 = e0Var.E;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i11 = marginLayoutParams2.height;
                        int i12 = marginLayoutParams.topMargin;
                        if (i11 != i12 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i12;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            e0Var.E.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    e0Var.E = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    e0Var.C.addView(e0Var.E, -1, layoutParams);
                }
                View view4 = e0Var.E;
                z = view4 != null;
                if (z && view4.getVisibility() != 0) {
                    View view5 = e0Var.E;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!e0Var.J && z) {
                    iD2 = 0;
                }
                z10 = z;
                z = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z = false;
            }
            if (z) {
                e0Var.f4805w.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = e0Var.E;
        if (view6 != null) {
            view6.setVisibility(z10 ? 0 : 8);
        }
        return n3.k0.d(view, iD != iD2 ? m1Var.f(m1Var.b(), iD2, m1Var.c(), m1Var.a()) : m1Var);
    }
}
