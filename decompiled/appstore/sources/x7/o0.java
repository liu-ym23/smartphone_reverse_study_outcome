package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25723e;

    public o0(ConstraintLayout r10, ConstraintLayout r11, ImageView r12, TextView r13, TextView r14) {
        this.f25719a = r10;
        this.f25720b = r11;
        this.f25721c = r12;
        this.f25722d = r13;
        this.f25723e = r14;
    }

    public static o0 a(View r10) {
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = R.id.iv_empty_icon;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_empty_icon);
        if (r13 == null) goto L11;
        r12 = R.id.tv_empty_desc;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_empty_desc);
        if (r14 == null) goto L11;
        r12 = R.id.tv_empty_title;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_empty_title);
        if (r15 == null) goto L11;
        return new o0(r11, r11, r13, r14, r15);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }

    public ConstraintLayout b() {
        return this.f25719a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
