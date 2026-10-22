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
public final class x {
    public final TextView btnOrderAction;
    public final View divOrderAction;
    public final LinearLayout llOrderActionRow;
    public final LinearLayout llOrderFields;
    public final LinearLayout llOrderPriceGroup;
    private final LinearLayout rootView;
    public final TextView tvOrderAmount;
    public final TextView tvOrderHint;
    public final TextView tvOrderSubtitle;
    public final TextView tvOrderTitle;

    public x(LinearLayout linearLayout, TextView textView, View view, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnOrderAction = textView;
        this.divOrderAction = view;
        this.llOrderActionRow = linearLayout2;
        this.llOrderFields = linearLayout3;
        this.llOrderPriceGroup = linearLayout4;
        this.tvOrderAmount = textView2;
        this.tvOrderHint = textView3;
        this.tvOrderSubtitle = textView4;
        this.tvOrderTitle = textView5;
    }

    public static x a(View view) {
        View viewA;
        int i10 = R$id.btnOrderAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null && (viewA = C5437a.a(view, (i10 = R$id.divOrderAction))) != null) {
            i10 = R$id.llOrderActionRow;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.llOrderFields;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.llOrderPriceGroup;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.tvOrderAmount;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tvOrderHint;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tvOrderSubtitle;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.tvOrderTitle;
                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                    if (textView5 != null) {
                                        return new x((LinearLayout) view, textView, viewA, linearLayout, linearLayout2, linearLayout3, textView2, textView3, textView4, textView5);
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

    public static x c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_order_action_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
