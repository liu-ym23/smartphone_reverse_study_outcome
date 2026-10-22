package x7;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25737e;

    public q0(ConstraintLayout r10, ConstraintLayout r11, View r12, TextView r13, TextView r14) {
        this.f25733a = r10;
        this.f25734b = r11;
        this.f25735c = r12;
        this.f25736d = r13;
        this.f25737e = r14;
    }

    public static q0 a(View r10) {
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = R.id.line_view3;
        View r13 = i0.a.a(r10, R.id.line_view3);
        if (r13 == null) goto L11;
        r12 = R.id.tv_ignore_update;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_ignore_update);
        if (r14 == null) goto L11;
        r12 = R.id.tv_ignore_update_amount;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_ignore_update_amount);
        if (r15 == null) goto L11;
        return new q0(r11, r11, r13, r14, r15);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }

    public ConstraintLayout b() {
        return this.f25733a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
