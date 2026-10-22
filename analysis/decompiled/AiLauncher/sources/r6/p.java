package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class p {
    public final TextView btnAppAction;
    public final ImageView ivAppIcon;
    private final LinearLayout rootView;
    public final TextView tvAppSubtitle;
    public final TextView tvAppTag;
    public final TextView tvAppTitle;
    public final TextView tvAppUpdateHint;

    public p(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnAppAction = textView;
        this.ivAppIcon = imageView;
        this.tvAppSubtitle = textView2;
        this.tvAppTag = textView3;
        this.tvAppTitle = textView4;
        this.tvAppUpdateHint = textView5;
    }

    public static p a(View view) {
        int i10 = R$id.btnAppAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.ivAppIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.tvAppSubtitle;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.tvAppTag;
                    TextView textView3 = (TextView) C5437a.a(view, i10);
                    if (textView3 != null) {
                        i10 = R$id.tvAppTitle;
                        TextView textView4 = (TextView) C5437a.a(view, i10);
                        if (textView4 != null) {
                            i10 = R$id.tvAppUpdateHint;
                            TextView textView5 = (TextView) C5437a.a(view, i10);
                            if (textView5 != null) {
                                return new p((LinearLayout) view, textView, imageView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static p c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_test_space_app, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
