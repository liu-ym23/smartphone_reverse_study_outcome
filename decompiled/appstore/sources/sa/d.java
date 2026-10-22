package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIFrameLayout f24571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricAppItemView f24572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetworkImageView f24573c;

    public d(OUIFrameLayout r10, ObricAppItemView r11, NetworkImageView r12) {
        this.f24571a = r10;
        this.f24572b = r11;
        this.f24573c = r12;
    }

    public static d a(View r10) {
        int r11 = R.id.bottom_app_item;
        ObricAppItemView r12 = (ObricAppItemView) i0.a.a(r10, r11);
        if (r12 == null) goto L9;
        r11 = R.id.large_image;
        NetworkImageView r13 = (NetworkImageView) i0.a.a(r10, r11);
        if (r13 == null) goto L9;
        return new d((OUIFrameLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static d c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.home_card_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public OUIFrameLayout b() {
        return this.f24571a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
