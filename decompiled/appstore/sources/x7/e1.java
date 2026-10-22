package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.SubButton;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SubButton f25552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25553g;

    public e1(ConstraintLayout r10, ImageView r11, ImageView r12, TextView r13, TextView r14, SubButton r15, TextView r16) {
        this.f25547a = r10;
        this.f25548b = r11;
        this.f25549c = r12;
        this.f25550d = r13;
        this.f25551e = r14;
        this.f25552f = r15;
        this.f25553g = r16;
    }

    public static e1 a(View r10) {
        int r11 = R.id.iv_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_icon);
        if (r12 == null) goto L17;
        r11 = R.id.tv_bottom_space;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.tv_bottom_space);
        if (r13 == null) goto L17;
        r11 = R.id.tv_category;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_category);
        if (r14 == null) goto L17;
        r11 = R.id.tv_name;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_name);
        if (r15 == null) goto L17;
        r11 = R.id.tv_sub_view;
        SubButton r16 = (SubButton) i0.a.a(r10, R.id.tv_sub_view);
        if (r16 == null) goto L17;
        r11 = R.id.tv_time;
        TextView r17 = (TextView) i0.a.a(r10, R.id.tv_time);
        if (r17 == null) goto L17;
        return new e1((ConstraintLayout) r10, r12, r13, r14, r15, r16, r17);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static e1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_sub, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25547a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
