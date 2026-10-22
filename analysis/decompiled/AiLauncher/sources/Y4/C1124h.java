package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* renamed from: Y4.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1124h {
    public final ImageButton btnBack;
    private final LinearLayout rootView;
    public final RecyclerView rvAgents;
    public final TextView tvTitle;

    public C1124h(LinearLayout linearLayout, ImageButton imageButton, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.btnBack = imageButton;
        this.rvAgents = recyclerView;
        this.tvTitle = textView;
    }

    public static C1124h a(View view) {
        int i10 = R$id.btn_back;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.rv_agents;
            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
            if (recyclerView != null) {
                i10 = R$id.tv_title;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    return new C1124h((LinearLayout) view, imageButton, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1124h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C1124h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_select_external_agent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
