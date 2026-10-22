package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.OrientationAwareRecyclerView;
import com.obric.appstore.R;
import com.obric.oui.paneltitlebar.OPanelTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f24564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OrientationAwareRecyclerView f24565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OPanelTitleBar f24566d;

    public b(LinearLayout r10, View r11, OrientationAwareRecyclerView r12, OPanelTitleBar r13) {
        this.f24563a = r10;
        this.f24564b = r11;
        this.f24565c = r12;
        this.f24566d = r13;
    }

    public static b a(View r10) {
        int r11 = R.id.divider;
        View r12 = i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.obric_recycler_view;
        OrientationAwareRecyclerView r13 = (OrientationAwareRecyclerView) i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        r11 = R.id.pager_title;
        OPanelTitleBar r14 = (OPanelTitleBar) i0.a.a(r10, r11);
        if (r14 == null) goto L11;
        return new b((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static b c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.common_item_view_pager_app_horizontal, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f24563a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
