package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.obric.appstore.R;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIFrameLayout f24597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkImageView f24598b;

    public k(OUIFrameLayout r10, NetworkImageView r11) {
        this.f24597a = r10;
        this.f24598b = r11;
    }

    public static k a(View r10) {
        int r11 = R.id.img;
        NetworkImageView r12 = (NetworkImageView) i0.a.a(r10, r11);
        if (r12 == null) goto L7;
        return new k((OUIFrameLayout) r10, r12);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static k c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.obric_app_detail_img, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public OUIFrameLayout b() {
        return this.f24597a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
