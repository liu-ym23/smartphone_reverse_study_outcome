package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class l {
    public final ImageView ivAiAppIcon;
    public final ImageView ivAiAppMore;
    private final LinearLayout rootView;
    public final TextView tvAiAppDesc;
    public final TextView tvAiAppName;

    public l(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivAiAppIcon = imageView;
        this.ivAiAppMore = imageView2;
        this.tvAiAppDesc = textView;
        this.tvAiAppName = textView2;
    }

    public static l a(View view) {
        int i10 = R$id.ivAiAppIcon;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.ivAiAppMore;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.tvAiAppDesc;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tvAiAppName;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        return new l((LinearLayout) view, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_amoo_ai_app, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
