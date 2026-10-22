package x7;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25725b;

    public p(LinearLayout r10, CommonRecyclerView r11) {
        this.f25724a = r10;
        this.f25725b = r11;
    }

    public static p a(View r10) {
        CommonRecyclerView r11 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view);
        if (r11 == null) goto L7;
        return new p((LinearLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.recycler_view)));
    }

    public LinearLayout b() {
        return this.f25724a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
