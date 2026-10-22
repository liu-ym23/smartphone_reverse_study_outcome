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
public final class f {
    public final TextView btnAutherPrimary;
    public final ImageView ivAutherIcon;
    public final LinearLayout llAutherShell;
    private final LinearLayout rootView;
    public final TextView tvAutherDesc;
    public final TextView tvAutherStatus;
    public final TextView tvAutherTitle;

    public f(LinearLayout linearLayout, TextView textView, ImageView imageView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnAutherPrimary = textView;
        this.ivAutherIcon = imageView;
        this.llAutherShell = linearLayout2;
        this.tvAutherDesc = textView2;
        this.tvAutherStatus = textView3;
        this.tvAutherTitle = textView4;
    }

    public static f a(View view) {
        int i10 = R$id.btnAutherPrimary;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.ivAutherIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i10 = R$id.tvAutherDesc;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.tvAutherStatus;
                    TextView textView3 = (TextView) C5437a.a(view, i10);
                    if (textView3 != null) {
                        i10 = R$id.tvAutherTitle;
                        TextView textView4 = (TextView) C5437a.a(view, i10);
                        if (textView4 != null) {
                            return new f(linearLayout, textView, imageView, linearLayout, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static f b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_app_auther_oauth, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
