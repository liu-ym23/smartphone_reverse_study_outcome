package x7;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.bouncelayout.ONestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f25629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ONestedScrollView f25631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sa.u f25632e;

    public k(FrameLayout r10, RecyclerView r11, View r12, ONestedScrollView r13, sa.u r14) {
        this.f25628a = r10;
        this.f25629b = r11;
        this.f25630c = r12;
        this.f25631d = r13;
        this.f25632e = r14;
    }

    public static k a(View r10) {
        int r11 = R.id.listview;
        RecyclerView r12 = (RecyclerView) i0.a.a(r10, R.id.listview);
        if (r12 == null) goto L13;
        r11 = R.id.page_status;
        View r13 = i0.a.a(r10, R.id.page_status);
        if (r13 == null) goto L13;
        r11 = R.id.recommend_container;
        ONestedScrollView r14 = (ONestedScrollView) i0.a.a(r10, R.id.recommend_container);
        if (r14 == null) goto L13;
        r11 = R.id.search_bar;
        View r15 = i0.a.a(r10, R.id.search_bar);
        if (r15 == null) goto L13;
        FrameLayout r16 = (FrameLayout) r10;
        return new k(r16, r12, r13, r14, sa.u.a(r15));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public FrameLayout b() {
        return this.f25628a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
