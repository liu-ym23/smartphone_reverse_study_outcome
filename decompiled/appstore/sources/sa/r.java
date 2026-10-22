package sa;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f24666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f24667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowLayout f24668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f24669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f24670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f24671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewPager2 f24672g;

    public r(FrameLayout r10, LinearLayout r11, FlowLayout r12, ImageView r13, TextView r14, ConstraintLayout r15, ViewPager2 r16) {
        this.f24666a = r10;
        this.f24667b = r11;
        this.f24668c = r12;
        this.f24669d = r13;
        this.f24670e = r14;
        this.f24671f = r15;
        this.f24672g = r16;
    }

    public static r a(View r10) {
        int r11 = R.id.search_history_container;
        LinearLayout r12 = (LinearLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L17;
        r11 = R.id.search_history_flow_layout;
        FlowLayout r13 = (FlowLayout) i0.a.a(r10, r11);
        if (r13 == null) goto L17;
        r11 = R.id.section_bar_right_btn;
        ImageView r14 = (ImageView) i0.a.a(r10, r11);
        if (r14 == null) goto L17;
        r11 = R.id.section_bar_title;
        TextView r15 = (TextView) i0.a.a(r10, r11);
        if (r15 == null) goto L17;
        r11 = R.id.section_title_bar;
        ConstraintLayout r16 = (ConstraintLayout) i0.a.a(r10, r11);
        if (r16 == null) goto L17;
        r11 = R.id.viewPager;
        ViewPager2 r17 = (ViewPager2) i0.a.a(r10, r11);
        if (r17 == null) goto L17;
        return new r((FrameLayout) r10, r12, r13, r14, r15, r16, r17);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public FrameLayout b() {
        return this.f24666a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
