package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.paneltitlebar.OPanelTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridLayout f24575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f24576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OPanelTitleBar f24577d;

    public e(LinearLayout r10, GridLayout r11, View r12, OPanelTitleBar r13) {
        this.f24574a = r10;
        this.f24575b = r11;
        this.f24576c = r12;
        this.f24577d = r13;
    }

    public static e a(View r10) {
        int r11 = R.id.category_grid_container;
        GridLayout r12 = (GridLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.category_list_divider;
        View r13 = i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        r11 = R.id.category_list_title;
        OPanelTitleBar r14 = (OPanelTitleBar) i0.a.a(r10, r11);
        if (r14 == null) goto L11;
        return new e((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static e c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_category_grid_list, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f24574a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
