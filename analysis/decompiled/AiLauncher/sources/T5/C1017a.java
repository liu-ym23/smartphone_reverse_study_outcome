package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* renamed from: T5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1017a {
    private final LinearLayout rootView;
    public final TextView tvFieldLabel;
    public final TextView tvFieldSubValue;
    public final TextView tvFieldValue;

    public C1017a(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.tvFieldLabel = textView;
        this.tvFieldSubValue = textView2;
        this.tvFieldValue = textView3;
    }

    public static C1017a a(View view) {
        int i10 = R$id.tvFieldLabel;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tvFieldSubValue;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.tvFieldValue;
                TextView textView3 = (TextView) C5437a.a(view, i10);
                if (textView3 != null) {
                    return new C1017a((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1017a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_card_order_action_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
