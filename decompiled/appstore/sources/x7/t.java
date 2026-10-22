package x7;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonRecyclerView f25759d;

    public t(LinearLayout r10, CommonRecyclerView r11, View r12, CommonRecyclerView r13) {
        this.f25756a = r10;
        this.f25757b = r11;
        this.f25758c = r12;
        this.f25759d = r13;
    }

    public static t a(View r10) {
        int r11 = R.id.app_recycler_view;
        CommonRecyclerView r12 = (CommonRecyclerView) i0.a.a(r10, R.id.app_recycler_view);
        if (r12 == null) goto L11;
        r11 = R.id.line_view;
        View r13 = i0.a.a(r10, R.id.line_view);
        if (r13 == null) goto L11;
        r11 = R.id.title_recycler_view;
        CommonRecyclerView r14 = (CommonRecyclerView) i0.a.a(r10, R.id.title_recycler_view);
        if (r14 == null) goto L11;
        return new t((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25756a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
