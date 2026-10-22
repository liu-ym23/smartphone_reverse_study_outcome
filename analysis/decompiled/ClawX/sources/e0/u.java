package e0;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class u {
    public static x0 a(View view, x0 x0Var, Rect rect) {
        WindowInsets windowInsetsB = x0Var.b();
        if (windowInsetsB != null) {
            return x0.c(view, view.computeSystemWindowInsets(windowInsetsB, rect));
        }
        rect.setEmpty();
        return x0Var;
    }

    public static void b(View view, k kVar) {
        t tVar = kVar != null ? new t(view, kVar) : null;
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (tVar != null) {
            view.setOnApplyWindowInsetsListener(tVar);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }
}
