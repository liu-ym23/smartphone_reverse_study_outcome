package Y4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class C {
    private final LinearLayout rootView;
    public final TextView tvMetaLabel;
    public final TextView tvMetaValue;

    public C(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvMetaLabel = textView;
        this.tvMetaValue = textView2;
    }

    public static C a(View view) {
        int i10 = R$id.tv_meta_label;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tv_meta_value;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                return new C((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
