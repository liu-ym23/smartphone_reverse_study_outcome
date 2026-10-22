package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f25774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25775b;

    public v0(ImageView r10, ImageView r11) {
        this.f25774a = r10;
        this.f25775b = r11;
    }

    public static v0 a(View r10) {
        if (r10 == null) goto L6;
        ImageView r11 = (ImageView) r10;
        return new v0(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public static v0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_banner, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ImageView b() {
        return this.f25774a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
