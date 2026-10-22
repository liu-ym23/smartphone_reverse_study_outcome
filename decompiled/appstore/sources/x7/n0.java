package x7;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25707c;

    public n0(FrameLayout r10, ImageView r11, ImageView r12) {
        this.f25705a = r10;
        this.f25706b = r11;
        this.f25707c = r12;
    }

    public static n0 a(View r10) {
        int r11 = R.id.iv_delete;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_delete);
        if (r12 == null) goto L9;
        r11 = R.id.iv_pic;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_pic);
        if (r13 == null) goto L9;
        return new n0((FrameLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public FrameLayout b() {
        return this.f25705a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
