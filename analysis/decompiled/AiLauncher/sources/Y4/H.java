package Y4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class H {
    public final LinearLayout cardAddAgent;
    public final LinearLayout cardEntryRemote;
    public final LinearLayout cardEntryStep;
    public final LinearLayout containerMarket;
    public final LinearLayout llEntryCards;
    private final FrameLayout rootView;
    public final RecyclerView rvConnectedDevices;
    public final RecyclerView rvMarket;
    public final NestedScrollView svAgentContent;
    public final SwipeRefreshLayout swipeRefreshAgent;
    public final TextView tvMarketTitle;

    public H(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, RecyclerView recyclerView, RecyclerView recyclerView2, NestedScrollView nestedScrollView, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        this.rootView = frameLayout;
        this.cardAddAgent = linearLayout;
        this.cardEntryRemote = linearLayout2;
        this.cardEntryStep = linearLayout3;
        this.containerMarket = linearLayout4;
        this.llEntryCards = linearLayout5;
        this.rvConnectedDevices = recyclerView;
        this.rvMarket = recyclerView2;
        this.svAgentContent = nestedScrollView;
        this.swipeRefreshAgent = swipeRefreshLayout;
        this.tvMarketTitle = textView;
    }

    public static H a(View view) {
        int i10 = R$id.card_add_agent;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.card_entry_remote;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.card_entry_step;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.container_market;
                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout4 != null) {
                        i10 = R$id.ll_entry_cards;
                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout5 != null) {
                            i10 = R$id.rv_connected_devices;
                            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                            if (recyclerView != null) {
                                i10 = R$id.rv_market;
                                RecyclerView recyclerView2 = (RecyclerView) C5437a.a(view, i10);
                                if (recyclerView2 != null) {
                                    i10 = R$id.sv_agent_content;
                                    NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                    if (nestedScrollView != null) {
                                        i10 = R$id.swipe_refresh_agent;
                                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) C5437a.a(view, i10);
                                        if (swipeRefreshLayout != null) {
                                            i10 = R$id.tv_market_title;
                                            TextView textView = (TextView) C5437a.a(view, i10);
                                            if (textView != null) {
                                                return new H((FrameLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, recyclerView, recyclerView2, nestedScrollView, swipeRefreshLayout, textView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
