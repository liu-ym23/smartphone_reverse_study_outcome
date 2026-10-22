package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class q {
    public final TextView btnView;
    public final ImageView ivBrandIcon;
    public final ImageView ivServiceIcon;
    private final LinearLayout rootView;
    public final TextView tvBrandName;
    public final TextView tvServiceTitle;

    public q(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnView = textView;
        this.ivBrandIcon = imageView;
        this.ivServiceIcon = imageView2;
        this.tvBrandName = textView2;
        this.tvServiceTitle = textView3;
    }

    public static q a(View view) {
        int i10 = R$id.btnView;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.ivBrandIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.ivServiceIcon;
                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                if (imageView2 != null) {
                    i10 = R$id.tvBrandName;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tvServiceTitle;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            return new q((LinearLayout) view, textView, imageView, imageView2, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static q c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_life_service, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
