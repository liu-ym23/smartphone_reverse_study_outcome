package d;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j0;
import androidx.lifecycle.t0;
import c.i;
import j1.f1;
import n7.o;
import w7.e0;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewGroup.LayoutParams f2737a = new ViewGroup.LayoutParams(-2, -2);

    public static void a(i iVar, j0.d dVar) {
        View childAt = ((ViewGroup) iVar.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        t0 t0Var = null;
        f1 f1Var = childAt instanceof f1 ? (f1) childAt : null;
        if (f1Var != null) {
            f1Var.setParentCompositionContext(null);
            f1Var.setContent(dVar);
            return;
        }
        f1 f1Var2 = new f1(iVar);
        f1Var2.setParentCompositionContext(null);
        f1Var2.setContent(dVar);
        View decorView = iVar.getWindow().getDecorView();
        if (j0.c(decorView) == null) {
            decorView.setTag(com.stepos.agentbus.R.id.view_tree_lifecycle_owner, iVar);
        }
        View view = decorView;
        while (true) {
            if (view == null) {
                break;
            }
            Object tag = view.getTag(com.stepos.agentbus.R.id.view_tree_view_model_store_owner);
            t0 t0Var2 = tag instanceof t0 ? (t0) tag : null;
            if (t0Var2 != null) {
                t0Var = t0Var2;
                break;
            } else {
                Object objO = o.o(view);
                view = objO instanceof View ? (View) objO : null;
            }
        }
        if (t0Var == null) {
            decorView.setTag(com.stepos.agentbus.R.id.view_tree_view_model_store_owner, iVar);
        }
        if (e0.y(decorView) == null) {
            decorView.setTag(com.stepos.agentbus.R.id.view_tree_saved_state_registry_owner, iVar);
        }
        iVar.setContentView(f1Var2, f2737a);
    }
}
