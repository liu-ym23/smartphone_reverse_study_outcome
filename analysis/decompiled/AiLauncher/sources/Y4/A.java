package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class A {
    public final ImageButton btnMore;
    public final ImageView ivAgentIcon;
    private final LinearLayout rootView;
    public final TextView tvAgentIconChar;
    public final TextView tvDescription;
    public final TextView tvTitle;

    public A(LinearLayout linearLayout, ImageButton imageButton, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnMore = imageButton;
        this.ivAgentIcon = imageView;
        this.tvAgentIconChar = textView;
        this.tvDescription = textView2;
        this.tvTitle = textView3;
    }

    public static A a(View view) {
        int i10 = R$id.btn_more;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.iv_agent_icon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.tv_agent_icon_char;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tv_description;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tv_title;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            return new A((LinearLayout) view, imageButton, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static A c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_my_agent_market, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
