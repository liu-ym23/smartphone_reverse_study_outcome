package F4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.R$layout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class b {
    public final ImageView ivOptionTrailing;
    private final LinearLayout rootView;
    public final TextView tvOptionLabel;

    public b(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.ivOptionTrailing = imageView;
        this.tvOptionLabel = textView;
    }

    public static b a(View view) {
        int i10 = R$id.iv_option_trailing;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.tv_option_label;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                return new b((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_float_card_option_checkmark, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
