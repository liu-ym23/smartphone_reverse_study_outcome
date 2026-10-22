package Y4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class u {
    public final ImageView ivBack;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final View topChromeBlur;
    public final TextView tvReadmeFull;
    public final TextView tvTitle;

    public u(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, View view, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.ivBack = imageView;
        this.root = frameLayout2;
        this.topChromeBlur = view;
        this.tvReadmeFull = textView;
        this.tvTitle = textView2;
    }

    public static u a(View view) {
        int i10 = R$id.iv_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i10 = R$id.topChromeBlur;
            View viewA = C5437a.a(view, i10);
            if (viewA != null) {
                i10 = R$id.tv_readme_full;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tv_title;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        return new u(frameLayout, imageView, frameLayout, viewA, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
