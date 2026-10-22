package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f25645f;

    public k1(ConstraintLayout r10, ImageView r11, ImageView r12, TextView r13, TextView r14, ConstraintLayout r15) {
        this.f25640a = r10;
        this.f25641b = r11;
        this.f25642c = r12;
        this.f25643d = r13;
        this.f25644e = r14;
        this.f25645f = r15;
    }

    public static k1 a(View r10) {
        int r11 = R.id.iv_uninstall_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_uninstall_icon);
        if (r12 == null) goto L13;
        r11 = R.id.iv_uninstall_next;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_uninstall_next);
        if (r13 == null) goto L13;
        r11 = R.id.tv_uninstall_desc;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_uninstall_desc);
        if (r14 == null) goto L13;
        r11 = R.id.tv_uninstall_number;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_uninstall_number);
        if (r15 == null) goto L13;
        ConstraintLayout r16 = (ConstraintLayout) r10;
        return new k1(r16, r12, r13, r14, r15, r16);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f25640a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
