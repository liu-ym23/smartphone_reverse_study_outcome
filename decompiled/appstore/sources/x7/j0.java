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
public final class j0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25621d;

    public j0(ConstraintLayout r10, ImageView r11, View r12, TextView r13) {
        this.f25618a = r10;
        this.f25619b = r11;
        this.f25620c = r12;
        this.f25621d = r13;
    }

    public static j0 a(View r10) {
        int r11 = R.id.iv_next;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_next);
        if (r12 == null) goto L11;
        r11 = R.id.line_view;
        View r13 = i0.a.a(r10, R.id.line_view);
        if (r13 == null) goto L11;
        r11 = R.id.tv_title;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_title);
        if (r14 == null) goto L11;
        return new j0((ConstraintLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static j0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_common_title_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25618a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
