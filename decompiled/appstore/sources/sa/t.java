package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f24678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f24679b;

    public t(FrameLayout r10, OButton r11) {
        this.f24678a = r10;
        this.f24679b = r11;
    }

    public static t a(View r10) {
        int r11 = R.id.btn;
        OButton r12 = (OButton) i0.a.a(r10, r11);
        if (r12 == null) goto L7;
        return new t((FrameLayout) r10, r12);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static t c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static t d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.oui_obutton_primary_light, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayout b() {
        return this.f24678a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
