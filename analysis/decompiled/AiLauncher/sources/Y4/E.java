package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stepos.ailauncher.agent.R$layout;

/* loaded from: classes3.dex */
public final class E {
    private final LinearLayout rootView;

    public E(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static E a(View view) {
        if (view != null) {
            return new E((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static E c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_skill_loading_footer, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
