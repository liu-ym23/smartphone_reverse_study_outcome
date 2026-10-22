package F4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.R$layout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class d {
    public final FrameLayout floatCardRoot;
    public final ImageView ivPageNext;
    public final ImageView ivPagePrev;
    public final LinearLayout layoutPagination;
    public final LinearLayout layoutToolbar;
    public final ProgressBar progressLoading;
    private final FrameLayout rootView;
    public final TextView tvError;
    public final TextView tvPagination;
    public final TextView tvSkip;
    public final View vDragHandle;
    public final ViewPager2 viewPager;

    public d(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, View view, ViewPager2 viewPager2) {
        this.rootView = frameLayout;
        this.floatCardRoot = frameLayout2;
        this.ivPageNext = imageView;
        this.ivPagePrev = imageView2;
        this.layoutPagination = linearLayout;
        this.layoutToolbar = linearLayout2;
        this.progressLoading = progressBar;
        this.tvError = textView;
        this.tvPagination = textView2;
        this.tvSkip = textView3;
        this.vDragHandle = view;
        this.viewPager = viewPager2;
    }

    public static d a(View view) {
        View viewA;
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = R$id.iv_page_next;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.iv_page_prev;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.layout_pagination;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.layout_toolbar;
                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R$id.progress_loading;
                        ProgressBar progressBar = (ProgressBar) C5437a.a(view, i10);
                        if (progressBar != null) {
                            i10 = R$id.tv_error;
                            TextView textView = (TextView) C5437a.a(view, i10);
                            if (textView != null) {
                                i10 = R$id.tv_pagination;
                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R$id.tv_skip;
                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                    if (textView3 != null && (viewA = C5437a.a(view, (i10 = R$id.v_drag_handle))) != null) {
                                        i10 = R$id.view_pager;
                                        ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
                                        if (viewPager2 != null) {
                                            return new d(frameLayout, frameLayout, imageView, imageView2, linearLayout, linearLayout2, progressBar, textView, textView2, textView3, viewA, viewPager2);
                                        }
                                    }
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
        View viewInflate = layoutInflater.inflate(R$layout.view_common_float_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
