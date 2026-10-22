package sa;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.searchbar.v2.OSearchBar;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f24680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f24681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f24682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSearchBar f24683d;

    public u(ConstraintLayout r10, FrameLayout r11, ConstraintLayout r12, OSearchBar r13) {
        this.f24680a = r10;
        this.f24681b = r11;
        this.f24682c = r12;
        this.f24683d = r13;
    }

    public static u a(View r10) {
        int r11 = R.id.main;
        FrameLayout r12 = (FrameLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L10;
        ConstraintLayout r13 = (ConstraintLayout) r10;
        int r14 = R.id.searchbarView;
        OSearchBar r15 = (OSearchBar) i0.a.a(r10, r14);
        if (r15 != null) goto L7;
        r11 = r14;
        goto L10
    L7:
        return new u(r13, r12, r13, r15);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f24680a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
