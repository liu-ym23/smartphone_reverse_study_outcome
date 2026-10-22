package Y4;

import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public final class z {
    private final LinearLayout rootView;

    public z(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static z a(View view) {
        if (view != null) {
            return new z((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
