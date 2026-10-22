package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.layout.OUIConstraintLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f24607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OUIConstraintLayout f24608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f24609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f24610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f24611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewStub f24612f;

    public n(View r10, OUIConstraintLayout r11, ImageView r12, TextView r13, FrameLayout r14, ViewStub r15) {
        this.f24607a = r10;
        this.f24608b = r11;
        this.f24609c = r12;
        this.f24610d = r13;
        this.f24611e = r14;
        this.f24612f = r15;
    }

    public static n a(View r10) {
        int r11 = R.id.appStatusButton;
        OUIConstraintLayout r12 = (OUIConstraintLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L15;
        r11 = R.id.appStatusButtonIc;
        ImageView r13 = (ImageView) i0.a.a(r10, r11);
        if (r13 == null) goto L15;
        r11 = R.id.appStatusButtonText;
        TextView r14 = (TextView) i0.a.a(r10, r11);
        if (r14 == null) goto L15;
        r11 = R.id.container;
        FrameLayout r15 = (FrameLayout) i0.a.a(r10, r11);
        if (r15 == null) goto L15;
        r11 = R.id.downloadViewStub;
        ViewStub r16 = (ViewStub) i0.a.a(r10, r11);
        if (r16 == null) goto L15;
        return new n(r10, r12, r13, r14, r15, r16);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static n b(LayoutInflater r10, ViewGroup r11) {
        if (r11 == null) goto L6;
        r10.inflate(R.layout.obric_app_status_view, r11);
        return a(r11);
    L6:
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f24607a;
    }
}
