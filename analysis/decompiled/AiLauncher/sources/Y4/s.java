package Y4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class s {
    public final LinearLayout btnAddAgent;
    public final ImageView btnBack;
    public final FrameLayout flContainer;
    private final FrameLayout rootView;
    public final View topChromeBlur;
    public final TextView tvTitle;

    public s(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout2, View view, TextView textView) {
        this.rootView = frameLayout;
        this.btnAddAgent = linearLayout;
        this.btnBack = imageView;
        this.flContainer = frameLayout2;
        this.topChromeBlur = view;
        this.tvTitle = textView;
    }

    public static s a(View view) {
        View viewA;
        int i10 = R$id.btn_add_agent;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.btn_back;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout != null && (viewA = C5437a.a(view, (i10 = R$id.top_chrome_blur))) != null) {
                    i10 = R$id.tv_title;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        return new s((FrameLayout) view, linearLayout, imageView, frameLayout, viewA, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
