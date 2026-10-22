package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* renamed from: Y4.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1126j {
    public final ImageView ivBack;
    public final LinearLayout rootContainer;
    private final LinearLayout rootView;
    public final RecyclerView rvSkills;
    public final SwipeRefreshLayout swipeRefresh;
    public final LinearLayout toolbarContainer;
    public final TextView tvTitle;

    public C1126j(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout3, TextView textView) {
        this.rootView = linearLayout;
        this.ivBack = imageView;
        this.rootContainer = linearLayout2;
        this.rvSkills = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
        this.toolbarContainer = linearLayout3;
        this.tvTitle = textView;
    }

    public static C1126j a(View view) {
        int i10 = R$id.iv_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R$id.rv_skills;
            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
            if (recyclerView != null) {
                i10 = R$id.swipe_refresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) C5437a.a(view, i10);
                if (swipeRefreshLayout != null) {
                    i10 = R$id.toolbar_container;
                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R$id.tv_title;
                        TextView textView = (TextView) C5437a.a(view, i10);
                        if (textView != null) {
                            return new C1126j(linearLayout, imageView, linearLayout, recyclerView, swipeRefreshLayout, linearLayout2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1126j c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_skill_essential, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
