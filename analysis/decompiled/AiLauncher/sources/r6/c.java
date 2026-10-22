package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class c {
    public final ImageView btnBack;
    public final LinearLayout header;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final TextView tvTitle;
    public final WebView webView;

    public c(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, WebView webView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.header = linearLayout2;
        this.root = linearLayout3;
        this.tvTitle = textView;
        this.webView = webView;
    }

    public static c a(View view) {
        int i10 = R$id.btn_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.header;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                i10 = R$id.tv_title;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.web_view;
                    WebView webView = (WebView) C5437a.a(view, i10);
                    if (webView != null) {
                        return new c(linearLayout2, imageView, linearLayout, linearLayout2, textView, webView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static c b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static c c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_repair_web, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
