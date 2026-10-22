package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.paneltitlebar.OPanelTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPanelTitleBar f24595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OPanelTitleBar f24596b;

    public j(OPanelTitleBar r10, OPanelTitleBar r11) {
        this.f24595a = r10;
        this.f24596b = r11;
    }

    public static j a(View r10) {
        if (r10 == null) goto L6;
        OPanelTitleBar r11 = (OPanelTitleBar) r10;
        return new j(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public static j c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_update_title_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public OPanelTitleBar b() {
        return this.f24595a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
