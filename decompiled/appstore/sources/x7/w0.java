package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f25785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25786b;

    public w0(ImageView r10, ImageView r11) {
        this.f25785a = r10;
        this.f25786b = r11;
    }

    public static w0 a(View r10) {
        if (r10 == null) goto L6;
        ImageView r11 = (ImageView) r10;
        return new w0(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public static w0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_banner_small, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ImageView b() {
        return this.f25785a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
