package x7;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f25770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewPager f25773e;

    public v(LinearLayout r10, LinearLayout r11, TextView r12, TextView r13, ViewPager r14) {
        this.f25769a = r10;
        this.f25770b = r11;
        this.f25771c = r12;
        this.f25772d = r13;
        this.f25773e = r14;
    }

    public static v a(View r10) {
        int r11 = R.id.ll_gift;
        LinearLayout r12 = (LinearLayout) i0.a.a(r10, R.id.ll_gift);
        if (r12 == null) goto L13;
        r11 = R.id.tv_gift_all;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_gift_all);
        if (r13 == null) goto L13;
        r11 = R.id.tv_gift_my;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_gift_my);
        if (r14 == null) goto L13;
        r11 = R.id.view_pager;
        ViewPager r15 = (ViewPager) i0.a.a(r10, R.id.view_pager);
        if (r15 == null) goto L13;
        return new v((LinearLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25769a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
