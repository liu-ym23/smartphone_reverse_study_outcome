package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25755e;

    public s0(ConstraintLayout r10, ConstraintLayout r11, ImageView r12, TextView r13, TextView r14) {
        this.f25751a = r10;
        this.f25752b = r11;
        this.f25753c = r12;
        this.f25754d = r13;
        this.f25755e = r14;
    }

    public static s0 a(View r10) {
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = R.id.iv_empty_icon;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_empty_icon);
        if (r13 == null) goto L11;
        r12 = R.id.tv_empty_title;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_empty_title);
        if (r14 == null) goto L11;
        r12 = R.id.tv_login;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_login);
        if (r15 == null) goto L11;
        return new s0(r11, r11, r13, r14, r15);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }

    public ConstraintLayout b() {
        return this.f25751a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
