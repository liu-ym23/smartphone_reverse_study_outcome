package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class J {
    public final LinearLayout cardRemoteAgent;
    public final z entryRemoteAgent;
    private final NestedScrollView rootView;
    public final RecyclerView rvMyAgentMarket;

    public J(NestedScrollView nestedScrollView, LinearLayout linearLayout, z zVar, RecyclerView recyclerView) {
        this.rootView = nestedScrollView;
        this.cardRemoteAgent = linearLayout;
        this.entryRemoteAgent = zVar;
        this.rvMyAgentMarket = recyclerView;
    }

    public static J a(View view) {
        View viewA;
        int i10 = R$id.card_remote_agent;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null && (viewA = C5437a.a(view, (i10 = R$id.entry_remote_agent))) != null) {
            z zVarA = z.a(viewA);
            int i11 = R$id.rv_my_agent_market;
            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i11);
            if (recyclerView != null) {
                return new J((NestedScrollView) view, linearLayout, zVarA, recyclerView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static J c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_my_agent_sections, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public NestedScrollView b() {
        return this.rootView;
    }
}
