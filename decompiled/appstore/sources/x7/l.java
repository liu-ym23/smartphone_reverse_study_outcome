package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f25647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f25648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OFloatingTitleBar f25649d;

    public l(ConstraintLayout r10, RecyclerView r11, ConstraintLayout r12, OFloatingTitleBar r13) {
        this.f25646a = r10;
        this.f25647b = r11;
        this.f25648c = r12;
        this.f25649d = r13;
    }

    public static l a(View r10) {
        int r11 = R.id.list;
        RecyclerView r12 = (RecyclerView) i0.a.a(r10, R.id.list);
        if (r12 == null) goto L10;
        ConstraintLayout r13 = (ConstraintLayout) r10;
        OFloatingTitleBar r14 = (OFloatingTitleBar) i0.a.a(r10, R.id.titlebar);
        if (r14 != null) goto L7;
        r11 = R.id.titlebar;
        goto L10
    L7:
        return new l(r13, r12, r13, r14);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static l c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.fragment_sysapp_manage, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25646a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
