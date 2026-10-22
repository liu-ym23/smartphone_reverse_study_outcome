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
public final class d {
    public final TextView btnAutherPrimary;
    public final TextView btnAutherSecondary;
    public final ImageView ivAutherIcon;
    public final LinearLayout llAutherKeyBlock;
    public final LinearLayout llAutherShell;
    private final LinearLayout rootView;
    public final TextView tvAutherDesc;
    public final TextView tvAutherStatus;
    public final TextView tvAutherTitle;

    public d(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnAutherPrimary = textView;
        this.btnAutherSecondary = textView2;
        this.ivAutherIcon = imageView;
        this.llAutherKeyBlock = linearLayout2;
        this.llAutherShell = linearLayout3;
        this.tvAutherDesc = textView3;
        this.tvAutherStatus = textView4;
        this.tvAutherTitle = textView5;
    }

    public static d a(View view) {
        int i10 = R$id.btnAutherPrimary;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.btnAutherSecondary;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.ivAutherIcon;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.llAutherKeyBlock;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        i10 = R$id.tvAutherDesc;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.tvAutherStatus;
                            TextView textView4 = (TextView) C5437a.a(view, i10);
                            if (textView4 != null) {
                                i10 = R$id.tvAutherTitle;
                                TextView textView5 = (TextView) C5437a.a(view, i10);
                                if (textView5 != null) {
                                    return new d(linearLayout2, textView, textView2, imageView, linearLayout, linearLayout2, textView3, textView4, textView5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static d b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_app_auther_credential, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
