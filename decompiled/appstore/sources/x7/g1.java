package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25581e;

    public g1(ConstraintLayout r10, ImageView r11, TextView r12, ImageView r13, TextView r14) {
        this.f25577a = r10;
        this.f25578b = r11;
        this.f25579c = r12;
        this.f25580d = r13;
        this.f25581e = r14;
    }

    public static g1 a(View r10) {
        int r11 = R.id.iv_next;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_next);
        if (r12 == null) goto L13;
        r11 = R.id.tv_next;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_next);
        if (r13 == null) goto L13;
        r11 = R.id.tv_pager_title_space;
        ImageView r14 = (ImageView) i0.a.a(r10, R.id.tv_pager_title_space);
        if (r14 == null) goto L13;
        r11 = R.id.tv_title;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_title);
        if (r15 == null) goto L13;
        return new g1((ConstraintLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static g1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_title, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25577a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
