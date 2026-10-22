package T5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import s1.C5437a;

/* renamed from: T5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1018b {
    public final FrameLayout flAlipayInstall;
    public final ImageView ivAlipayAppIcon;
    public final ImageView ivAlipayInstallLoading;
    private final LinearLayout rootView;
    public final TextView tvAlipayAppExtra;
    public final TextView tvAlipayAppName;
    public final TextView tvAlipayAppSize;
    public final TextView tvAlipayInstall;

    public C1018b(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.flAlipayInstall = frameLayout;
        this.ivAlipayAppIcon = imageView;
        this.ivAlipayInstallLoading = imageView2;
        this.tvAlipayAppExtra = textView;
        this.tvAlipayAppName = textView2;
        this.tvAlipayAppSize = textView3;
        this.tvAlipayInstall = textView4;
    }

    public static C1018b a(View view) {
        int i10 = R$id.flAlipayInstall;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.ivAlipayAppIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.ivAlipayInstallLoading;
                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                if (imageView2 != null) {
                    i10 = R$id.tvAlipayAppExtra;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tvAlipayAppName;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tvAlipayAppSize;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tvAlipayInstall;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    return new C1018b((LinearLayout) view, frameLayout, imageView, imageView2, textView, textView2, textView3, textView4);
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
