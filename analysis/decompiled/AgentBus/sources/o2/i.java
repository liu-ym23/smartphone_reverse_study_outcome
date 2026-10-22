package o2;

import android.view.View;
import com.stepos.agentbus.R;

/* loaded from: classes.dex */
public abstract class i {
    public static void a(View view, f fVar) {
        h hVar = fVar != null ? new h(view, fVar) : null;
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (hVar != null) {
            view.setOnApplyWindowInsetsListener(hVar);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }
}
