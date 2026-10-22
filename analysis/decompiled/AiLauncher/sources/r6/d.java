package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class d {
    public final TextView btnDownload;
    public final LinearLayout formatContainer;
    public final ImageView ivClose;
    private final FrameLayout rootView;
    public final LinearLayout sheetPanel;

    public d(FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2) {
        this.rootView = frameLayout;
        this.btnDownload = textView;
        this.formatContainer = linearLayout;
        this.ivClose = imageView;
        this.sheetPanel = linearLayout2;
    }

    public static d a(View view) {
        int i10 = R$id.btnDownload;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.formatContainer;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.ivClose;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.sheetPanel;
                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout2 != null) {
                        return new d((FrameLayout) view, textView, linearLayout, imageView, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static d c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_download_format, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
