package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class G {
    private final FrameLayout rootView;
    public final H stateConnected;
    public final I stateEmpty;

    public G(FrameLayout frameLayout, H h10, I i10) {
        this.rootView = frameLayout;
        this.stateConnected = h10;
        this.stateEmpty = i10;
    }

    public static G a(View view) {
        int i10 = R$id.state_connected;
        View viewA = C5437a.a(view, i10);
        if (viewA != null) {
            H hA = H.a(viewA);
            int i11 = R$id.state_empty;
            View viewA2 = C5437a.a(view, i11);
            if (viewA2 != null) {
                return new G((FrameLayout) view, hA, I.a(viewA2));
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static G b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_agent_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
