package n3;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e0 {
    public static m1 a(View view, m1 m1Var, Rect rect) {
        WindowInsets windowInsetsG = m1Var.g();
        if (windowInsetsG != null) {
            return m1.h(view, view.computeSystemWindowInsets(windowInsetsG, rect));
        }
        rect.setEmpty();
        return m1Var;
    }

    public static void b(View view, s sVar) {
        d0 d0Var = sVar != null ? new d0(view, sVar) : null;
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (d0Var != null) {
            view.setOnApplyWindowInsetsListener(d0Var);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }
}
