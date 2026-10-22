package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class x {
    public final ImageView ivAgentIcon;
    private final LinearLayout rootView;
    public final LinearLayout rowAgent;
    public final TextView tvAgentDesc;
    public final TextView tvAgentTitle;
    public final View vDivider;

    public x(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.ivAgentIcon = imageView;
        this.rowAgent = linearLayout2;
        this.tvAgentDesc = textView;
        this.tvAgentTitle = textView2;
        this.vDivider = view;
    }

    public static x a(View view) {
        View viewA;
        int i10 = R$id.iv_agent_icon;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.row_agent;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.tv_agent_desc;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tv_agent_title;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null && (viewA = C5437a.a(view, (i10 = R$id.v_divider))) != null) {
                        return new x((LinearLayout) view, imageView, linearLayout, textView, textView2, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static x c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_external_agent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
