package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f24600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f24601c;

    public l(LinearLayout r10, ImageView r11, OTextView r12) {
        this.f24599a = r10;
        this.f24600b = r11;
        this.f24601c = r12;
    }

    public static l a(View r10) {
        int r11 = R.id.action_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, r11);
        if (r12 == null) goto L9;
        r11 = R.id.action_text;
        OTextView r13 = (OTextView) i0.a.a(r10, r11);
        if (r13 == null) goto L9;
        return new l((LinearLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static l c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static l d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.obric_app_detail_relation_apps_action, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f24599a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
