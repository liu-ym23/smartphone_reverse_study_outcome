package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.github.chrisbanes.photoview.PhotoView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoView f25505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25509f;

    public c(ConstraintLayout r10, PhotoView r11, ImageView r12, TextView r13, TextView r14, TextView r15) {
        this.f25504a = r10;
        this.f25505b = r11;
        this.f25506c = r12;
        this.f25507d = r13;
        this.f25508e = r14;
        this.f25509f = r15;
    }

    public static c a(View r10) {
        int r11 = R.id.iv_bg;
        PhotoView r12 = (PhotoView) i0.a.a(r10, R.id.iv_bg);
        if (r12 == null) goto L15;
        r11 = R.id.iv_logo;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_logo);
        if (r13 == null) goto L15;
        r11 = R.id.tv_desc;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_desc);
        if (r14 == null) goto L15;
        r11 = R.id.tv_skip;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_skip);
        if (r15 == null) goto L15;
        r11 = R.id.tv_title;
        TextView r16 = (TextView) i0.a.a(r10, R.id.tv_title);
        if (r16 == null) goto L15;
        return new c((ConstraintLayout) r10, r12, r13, r14, r15, r16);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f25504a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
