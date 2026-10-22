package l5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class e {
    public final ImageView btnBack;
    public final LinearLayout emptyView;
    public final ProgressBar loadingView;
    private final FrameLayout rootView;
    public final RecyclerView rvInstalledApps;
    public final View topChromeBlur;
    public final TextView tvTitle;

    public e(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, View view, TextView textView) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.emptyView = linearLayout;
        this.loadingView = progressBar;
        this.rvInstalledApps = recyclerView;
        this.topChromeBlur = view;
        this.tvTitle = textView;
    }

    public static e a(View view) {
        View viewA;
        int i10 = R$id.btnBack;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.emptyView;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.loadingView;
                ProgressBar progressBar = (ProgressBar) C5437a.a(view, i10);
                if (progressBar != null) {
                    i10 = R$id.rvInstalledApps;
                    RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                    if (recyclerView != null && (viewA = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                        i10 = R$id.tvTitle;
                        TextView textView = (TextView) C5437a.a(view, i10);
                        if (textView != null) {
                            return new e((FrameLayout) view, imageView, linearLayout, progressBar, recyclerView, viewA, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
