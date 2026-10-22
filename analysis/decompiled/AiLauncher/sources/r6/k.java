package r6;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class k {
    public final ImageView btnBack;
    public final LinearLayout layoutEmpty;
    private final FrameLayout rootView;
    public final RecyclerView rvAuthList;
    public final NestedScrollView scrollAuthList;
    public final View topChromeBlur;
    public final TextView tvAuthorizedCount;

    public k(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, NestedScrollView nestedScrollView, View view, TextView textView) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.layoutEmpty = linearLayout;
        this.rvAuthList = recyclerView;
        this.scrollAuthList = nestedScrollView;
        this.topChromeBlur = view;
        this.tvAuthorizedCount = textView;
    }

    public static k a(View view) {
        View viewA;
        int i10 = R$id.btn_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.layout_empty;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.rv_auth_list;
                RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                if (recyclerView != null) {
                    i10 = R$id.scroll_auth_list;
                    NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                    if (nestedScrollView != null && (viewA = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                        i10 = R$id.tv_authorized_count;
                        TextView textView = (TextView) C5437a.a(view, i10);
                        if (textView != null) {
                            return new k((FrameLayout) view, imageView, linearLayout, recyclerView, nestedScrollView, viewA, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
