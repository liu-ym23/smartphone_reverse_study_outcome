package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.paneltitlebar.OPanelTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f24590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OPanelTitleBar f24591c;

    public h(LinearLayout r10, View r11, OPanelTitleBar r12) {
        this.f24589a = r10;
        this.f24590b = r11;
        this.f24591c = r12;
    }

    public static h a(View r10) {
        int r11 = R.id.divider;
        View r12 = i0.a.a(r10, r11);
        if (r12 == null) goto L9;
        r11 = R.id.list_item;
        OPanelTitleBar r13 = (OPanelTitleBar) i0.a.a(r10, r11);
        if (r13 == null) goto L9;
        return new h((LinearLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static h c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_ignore_update_title_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f24589a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
