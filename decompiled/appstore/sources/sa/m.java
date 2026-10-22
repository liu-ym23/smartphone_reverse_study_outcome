package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppStatusView;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f24602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OImageAppIcon f24603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OUIFrameLayout f24604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f24605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObricAppStatusView f24606e;

    public m(View r10, OImageAppIcon r11, OUIFrameLayout r12, TextView r13, ObricAppStatusView r14) {
        this.f24602a = r10;
        this.f24603b = r11;
        this.f24604c = r12;
        this.f24605d = r13;
        this.f24606e = r14;
    }

    public static m a(View r10) {
        int r11 = R.id.appIcon;
        OImageAppIcon r12 = (OImageAppIcon) i0.a.a(r10, r11);
        if (r12 == null) goto L13;
        r11 = R.id.appIconBox;
        OUIFrameLayout r13 = (OUIFrameLayout) i0.a.a(r10, r11);
        if (r13 == null) goto L13;
        r11 = R.id.appName;
        TextView r14 = (TextView) i0.a.a(r10, r11);
        if (r14 == null) goto L13;
        r11 = R.id.appStatusLay;
        ObricAppStatusView r15 = (ObricAppStatusView) i0.a.a(r10, r11);
        if (r15 == null) goto L13;
        return new m(r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static m b(LayoutInflater r10, ViewGroup r11) {
        if (r11 == null) goto L6;
        r10.inflate(R.layout.obric_app_item_view_for_settings, r11);
        return a(r11);
    L6:
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f24602a;
    }
}
