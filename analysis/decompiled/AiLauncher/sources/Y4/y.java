package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class y {
    private final LinearLayout rootView;
    public final TextView tvRecBadge;
    public final TextView tvRecDesc;
    public final TextView tvRecTitle;

    public y(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.tvRecBadge = textView;
        this.tvRecDesc = textView2;
        this.tvRecTitle = textView3;
    }

    public static y a(View view) {
        int i10 = R$id.tv_rec_badge;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tv_rec_desc;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.tv_rec_title;
                TextView textView3 = (TextView) C5437a.a(view, i10);
                if (textView3 != null) {
                    return new y((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static y c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_feishu_recommended, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
