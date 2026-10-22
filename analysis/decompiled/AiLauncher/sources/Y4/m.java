package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class m {
    public final LinearLayout authPanel;
    public final TextView btnCancel;
    public final TextView btnConfirm;
    private final FrameLayout rootView;
    public final ScrollView scrollAuthContent;
    public final TextView tvAuthContent;
    public final TextView tvAuthTitle;

    public m(FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2, ScrollView scrollView, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.authPanel = linearLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.scrollAuthContent = scrollView;
        this.tvAuthContent = textView3;
        this.tvAuthTitle = textView4;
    }

    public static m a(View view) {
        int i10 = R$id.auth_panel;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.btn_cancel;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.btn_confirm;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.scroll_auth_content;
                    ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
                    if (scrollView != null) {
                        i10 = R$id.tv_auth_content;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.tv_auth_title;
                            TextView textView4 = (TextView) C5437a.a(view, i10);
                            if (textView4 != null) {
                                return new m((FrameLayout) view, linearLayout, textView, textView2, scrollView, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static m c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_agent_auth_consent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
