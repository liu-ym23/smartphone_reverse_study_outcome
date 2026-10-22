package l5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class f {
    public final ImageView btnBack;
    private final FrameLayout rootView;
    public final RecyclerView rvSkills;
    public final View topChromeBlur;
    public final TextView tvTitle;

    public f(FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, View view, TextView textView) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.rvSkills = recyclerView;
        this.topChromeBlur = view;
        this.tvTitle = textView;
    }

    public static f a(View view) {
        View viewA;
        int i10 = R$id.btnBack;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.rvSkills;
            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
            if (recyclerView != null && (viewA = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                i10 = R$id.tvTitle;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    return new f((FrameLayout) view, imageView, recyclerView, viewA, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
