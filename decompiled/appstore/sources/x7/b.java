package x7;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.viewpager.TryCatchViewPager;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f25497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f25498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TryCatchViewPager f25499c;

    public b(RelativeLayout r10, LinearLayout r11, TryCatchViewPager r12) {
        this.f25497a = r10;
        this.f25498b = r11;
        this.f25499c = r12;
    }

    public static b a(View r10) {
        int r11 = R.id.point_layout;
        LinearLayout r12 = (LinearLayout) i0.a.a(r10, R.id.point_layout);
        if (r12 == null) goto L9;
        r11 = R.id.view_pager;
        TryCatchViewPager r13 = (TryCatchViewPager) i0.a.a(r10, R.id.view_pager);
        if (r13 == null) goto L9;
        return new b((RelativeLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public RelativeLayout b() {
        return this.f25497a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
