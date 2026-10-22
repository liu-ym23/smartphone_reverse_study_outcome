package x7;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f25764b;

    public u(FrameLayout r10, ViewPager2 r11) {
        this.f25763a = r10;
        this.f25764b = r11;
    }

    public static u a(View r10) {
        ViewPager2 r11 = (ViewPager2) i0.a.a(r10, R.id.view_pager);
        if (r11 == null) goto L7;
        return new u((FrameLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.view_pager)));
    }

    public FrameLayout b() {
        return this.f25763a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
