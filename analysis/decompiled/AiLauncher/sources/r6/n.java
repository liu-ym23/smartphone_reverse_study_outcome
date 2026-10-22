package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class n {
    private final LinearLayout rootView;
    public final TextView tvNotice;

    public n(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvNotice = textView;
    }

    public static n a(View view) {
        int i10 = R$id.tv_notice;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            return new n((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static n c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_auth_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
