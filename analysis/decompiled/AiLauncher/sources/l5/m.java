package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.stepos.ailauncher.chat.R$layout;

/* loaded from: classes3.dex */
public final class m {
    public final ImageView ivScreenshot;
    private final ImageView rootView;

    public m(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.ivScreenshot = imageView2;
    }

    public static m a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new m(imageView, imageView);
    }

    public static m c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_amoo_app_screenshot, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ImageView b() {
        return this.rootView;
    }
}
