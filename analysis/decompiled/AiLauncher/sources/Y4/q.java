package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class q {
    public final TextView btnLater;
    public final LinearLayout llCard;
    private final LinearLayout rootView;

    public q(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btnLater = textView;
        this.llCard = linearLayout2;
    }

    public static q a(View view) {
        int i10 = R$id.btn_later;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        LinearLayout linearLayout = (LinearLayout) view;
        return new q(linearLayout, textView, linearLayout);
    }

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_wecom_need_install, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
