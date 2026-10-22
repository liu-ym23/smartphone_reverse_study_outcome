package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class n {
    public final TextView btnLater;
    public final TextView btnTryNow;
    public final FrameLayout flOverlay;
    public final LinearLayout llCard;
    private final FrameLayout rootView;
    public final TextView tvDesc;
    public final TextView tvTitle;

    public n(FrameLayout frameLayout, TextView textView, TextView textView2, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.btnLater = textView;
        this.btnTryNow = textView2;
        this.flOverlay = frameLayout2;
        this.llCard = linearLayout;
        this.tvDesc = textView3;
        this.tvTitle = textView4;
    }

    public static n a(View view) {
        int i10 = R$id.btn_later;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.btn_try_now;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i10 = R$id.ll_card;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.tv_desc;
                    TextView textView3 = (TextView) C5437a.a(view, i10);
                    if (textView3 != null) {
                        i10 = R$id.tv_title;
                        TextView textView4 = (TextView) C5437a.a(view, i10);
                        if (textView4 != null) {
                            return new n(frameLayout, textView, textView2, frameLayout, linearLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_feishu_auto_summary, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
