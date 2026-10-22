package T5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class m {
    public final TextView btnDidiCarSelectCta;
    public final LinearLayout llDidiCarTypeRows;
    public final LinearLayout llDidiEstimate;
    private final LinearLayout rootView;
    public final TextView tvDidiDisclaimer;
    public final TextView tvDidiEstimateValue;
    public final TextView tvDidiSelectedCount;

    public m(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnDidiCarSelectCta = textView;
        this.llDidiCarTypeRows = linearLayout2;
        this.llDidiEstimate = linearLayout3;
        this.tvDidiDisclaimer = textView2;
        this.tvDidiEstimateValue = textView3;
        this.tvDidiSelectedCount = textView4;
    }

    public static m a(View view) {
        int i10 = R$id.btnDidiCarSelectCta;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.llDidiCarTypeRows;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.llDidiEstimate;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.tvDidiDisclaimer;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tvDidiEstimateValue;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.tvDidiSelectedCount;
                            TextView textView4 = (TextView) C5437a.a(view, i10);
                            if (textView4 != null) {
                                return new m((LinearLayout) view, textView, linearLayout, linearLayout2, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
