package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25639g;

    public k0(ConstraintLayout r10, ConstraintLayout r11, ImageView r12, TextView r13, TextView r14, TextView r15, TextView r16) {
        this.f25633a = r10;
        this.f25634b = r11;
        this.f25635c = r12;
        this.f25636d = r13;
        this.f25637e = r14;
        this.f25638f = r15;
        this.f25639g = r16;
    }

    public static k0 a(View r10) {
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = R.id.iv_icon;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_icon);
        if (r13 == null) goto L15;
        r12 = R.id.tv_content;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_content);
        if (r14 == null) goto L15;
        r12 = R.id.tv_count;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_count);
        if (r15 == null) goto L15;
        r12 = R.id.tv_get;
        TextView r16 = (TextView) i0.a.a(r10, R.id.tv_get);
        if (r16 == null) goto L15;
        r12 = R.id.tv_name;
        TextView r17 = (TextView) i0.a.a(r10, R.id.tv_name);
        if (r17 == null) goto L15;
        return new k0(r11, r11, r13, r14, r15, r16, r17);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }

    public ConstraintLayout b() {
        return this.f25633a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
