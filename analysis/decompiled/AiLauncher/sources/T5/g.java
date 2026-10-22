package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class g {
    private final LinearLayout rootView;
    public final TextView tvStepBullet;
    public final TextView tvStepText;

    public g(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvStepBullet = textView;
        this.tvStepText = textView2;
    }

    public static g a(View view) {
        int i10 = R$id.tvStepBullet;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tvStepText;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                return new g((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static g b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_auther_guide_step, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
