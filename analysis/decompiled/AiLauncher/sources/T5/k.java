package T5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class k {
    public final FrameLayout flDidiInstall;
    public final ImageView ivDidiAppIcon;
    public final ImageView ivDidiInstallLoading;
    private final LinearLayout rootView;
    public final TextView tvDidiAppExtra;
    public final TextView tvDidiAppName;
    public final TextView tvDidiAppSize;
    public final TextView tvDidiInstall;

    public k(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.flDidiInstall = frameLayout;
        this.ivDidiAppIcon = imageView;
        this.ivDidiInstallLoading = imageView2;
        this.tvDidiAppExtra = textView;
        this.tvDidiAppName = textView2;
        this.tvDidiAppSize = textView3;
        this.tvDidiInstall = textView4;
    }

    public static k a(View view) {
        int i10 = R$id.flDidiInstall;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.ivDidiAppIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.ivDidiInstallLoading;
                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                if (imageView2 != null) {
                    i10 = R$id.tvDidiAppExtra;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tvDidiAppName;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tvDidiAppSize;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tvDidiInstall;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    return new k((LinearLayout) view, frameLayout, imageView, imageView2, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
