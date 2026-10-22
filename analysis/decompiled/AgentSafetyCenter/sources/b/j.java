package b;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.p;
import androidx.lifecycle.s0;
import java.lang.invoke.VarHandle;
import k0.z;
import t.m0;
import v1.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewGroup.LayoutParams f1706a = new ViewGroup.LayoutParams(-2, -2);

    public static void a(p pVar, s0.c cVar) {
        View childAt = ((ViewGroup) pVar.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        z0 z0Var = childAt instanceof z0 ? (z0) childAt : null;
        if (z0Var != null) {
            z0Var.setParentCompositionContext(null);
            z0Var.setContent(cVar);
            return;
        }
        z0 z0Var2 = new z0(pVar);
        z0Var2.f14600m = z.v(null);
        VarHandle.storeStoreFence();
        z0Var2.setParentCompositionContext(null);
        z0Var2.setContent(cVar);
        View decorView = pVar.getWindow().getDecorView();
        if (s0.d(decorView) == null) {
            decorView.setTag(com.stepos.agentsafetycenter.R.id.view_tree_lifecycle_owner, pVar);
        }
        if (s0.e(decorView) == null) {
            decorView.setTag(com.stepos.agentsafetycenter.R.id.view_tree_view_model_store_owner, pVar);
        }
        if (m0.i(decorView) == null) {
            decorView.setTag(com.stepos.agentsafetycenter.R.id.view_tree_saved_state_registry_owner, pVar);
        }
        pVar.setContentView(z0Var2, f1706a);
    }
}
