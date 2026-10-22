package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f25501b;

    public b0(ConstraintLayout r10, OCardListItem r11) {
        this.f25500a = r10;
        this.f25501b = r11;
    }

    public static b0 a(View r10) {
        OCardListItem r11 = (OCardListItem) i0.a.a(r10, R.id.card);
        if (r11 == null) goto L7;
        return new b0((ConstraintLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.card)));
    }

    public static b0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_sysapp_wifi_update_setting, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25500a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
