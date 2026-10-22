package Y4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class I {
    public final LinearLayout cardOtherAgent;
    public final LinearLayout cardStepAgent;
    private final ScrollView rootView;
    public final TextView tvOtherDesc;
    public final TextView tvOtherTitle;
    public final TextView tvStepDesc;
    public final TextView tvStepTitle;

    public I(ScrollView scrollView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = scrollView;
        this.cardOtherAgent = linearLayout;
        this.cardStepAgent = linearLayout2;
        this.tvOtherDesc = textView;
        this.tvOtherTitle = textView2;
        this.tvStepDesc = textView3;
        this.tvStepTitle = textView4;
    }

    public static I a(View view) {
        int i10 = R$id.card_other_agent;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.card_step_agent;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.tv_other_desc;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tv_other_title;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tv_step_desc;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.tv_step_title;
                            TextView textView4 = (TextView) C5437a.a(view, i10);
                            if (textView4 != null) {
                                return new I((ScrollView) view, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public ScrollView b() {
        return this.rootView;
    }
}
