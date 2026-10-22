package F4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.R$layout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class a {
    private final LinearLayout rootView;
    public final TextView tvOptionLabel;

    public a(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvOptionLabel = textView;
    }

    public static a a(View view) {
        int i10 = R$id.tv_option_label;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            return new a((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_float_card_option, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
