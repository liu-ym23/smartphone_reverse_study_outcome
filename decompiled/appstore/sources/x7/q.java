package x7;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f25730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonRecyclerView f25732c;

    public q(NestedScrollView r10, CommonRecyclerView r11, CommonRecyclerView r12) {
        this.f25730a = r10;
        this.f25731b = r11;
        this.f25732c = r12;
    }

    public static q a(View r10) {
        int r11 = R.id.recycler_view_recommend;
        CommonRecyclerView r12 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view_recommend);
        if (r12 == null) goto L9;
        r11 = R.id.recycler_view_uninstall;
        CommonRecyclerView r13 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view_uninstall);
        if (r13 == null) goto L9;
        return new q((NestedScrollView) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public NestedScrollView b() {
        return this.f25730a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
