package F4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.R$layout;
import com.stepos.agentframework.floatcard.view.MaxHeightScrollView;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class c {
    public final TextView btnConfirm;
    public final LinearLayout layoutOptions;
    public final LinearLayout layoutPageContent;
    public final ConstraintLayout layoutTitleRow;
    private final FrameLayout rootView;
    public final MaxHeightScrollView scrollOptions;
    public final TextView tvDescription;
    public final TextView tvRiskBadge;
    public final TextView tvSkipInline;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    public c(FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, MaxHeightScrollView maxHeightScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = frameLayout;
        this.btnConfirm = textView;
        this.layoutOptions = linearLayout;
        this.layoutPageContent = linearLayout2;
        this.layoutTitleRow = constraintLayout;
        this.scrollOptions = maxHeightScrollView;
        this.tvDescription = textView2;
        this.tvRiskBadge = textView3;
        this.tvSkipInline = textView4;
        this.tvSubtitle = textView5;
        this.tvTitle = textView6;
    }

    public static c a(View view) {
        int i10 = R$id.btn_confirm;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.layout_options;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.layout_page_content;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.layout_title_row;
                    ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                    if (constraintLayout != null) {
                        i10 = R$id.scroll_options;
                        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) C5437a.a(view, i10);
                        if (maxHeightScrollView != null) {
                            i10 = R$id.tv_description;
                            TextView textView2 = (TextView) C5437a.a(view, i10);
                            if (textView2 != null) {
                                i10 = R$id.tv_risk_badge;
                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R$id.tv_skip_inline;
                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R$id.tv_subtitle;
                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = R$id.tv_title;
                                            TextView textView6 = (TextView) C5437a.a(view, i10);
                                            if (textView6 != null) {
                                                return new c((FrameLayout) view, textView, linearLayout, linearLayout2, constraintLayout, maxHeightScrollView, textView2, textView3, textView4, textView5, textView6);
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

    public static c c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_float_card_page, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
