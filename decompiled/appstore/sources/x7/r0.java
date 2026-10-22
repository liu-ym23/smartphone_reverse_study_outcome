package x7;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f25744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f25747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f25748f;

    public r0(ConstraintLayout r10, View r11, TextView r12, TextView r13, ConstraintLayout r14, View r15) {
        this.f25743a = r10;
        this.f25744b = r11;
        this.f25745c = r12;
        this.f25746d = r13;
        this.f25747e = r14;
        this.f25748f = r15;
    }

    public static r0 a(View r10) {
        int r11 = R.id.line_view2;
        View r12 = i0.a.a(r10, R.id.line_view2);
        if (r12 == null) goto L13;
        r11 = R.id.tv_all_update;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_all_update);
        if (r13 == null) goto L13;
        r11 = R.id.tv_update_amount;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_update_amount);
        if (r14 == null) goto L13;
        ConstraintLayout r15 = (ConstraintLayout) r10;
        r11 = R.id.update_all_tips;
        View r16 = i0.a.a(r10, R.id.update_all_tips);
        if (r16 == null) goto L13;
        return new r0(r15, r12, r13, r14, r15, r16);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f25743a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
