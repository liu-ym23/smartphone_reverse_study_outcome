package x7;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f25788b;

    public x(FrameLayout r10, c1 r11) {
        this.f25787a = r10;
        this.f25788b = r11;
    }

    public static x a(View r10) {
        View r11 = i0.a.a(r10, R.id.search_result_split_view);
        if (r11 == null) goto L7;
        FrameLayout r12 = (FrameLayout) r10;
        return new x(r12, c1.a(r11));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.search_result_split_view)));
    }

    public FrameLayout b() {
        return this.f25787a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
