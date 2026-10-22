package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* renamed from: Y4.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1120d {
    public final FrameLayout flContainer;
    public final ImageView ivBack;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final TextView tvNavTitle;

    public C1120d(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.flContainer = frameLayout;
        this.ivBack = imageView;
        this.root = linearLayout2;
        this.tvNavTitle = textView;
    }

    public static C1120d a(View view) {
        int i10 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.iv_back;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i10 = R$id.tv_nav_title;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    return new C1120d(linearLayout, frameLayout, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1120d b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static C1120d c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_connected_agents, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
