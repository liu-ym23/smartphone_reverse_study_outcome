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
public final class o {
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvTime;

    public o(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvContent = textView;
        this.tvTime = textView2;
    }

    public static o a(View view) {
        int i10 = R$id.tv_content;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tv_time;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                return new o((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static o c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_memory_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
