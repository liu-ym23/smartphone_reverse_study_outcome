package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f25762c;

    public t0(FrameLayout r10, ImageView r11, FrameLayout r12) {
        this.f25760a = r10;
        this.f25761b = r11;
        this.f25762c = r12;
    }

    public static t0 a(View r10) {
        ImageView r11 = (ImageView) i0.a.a(r10, R.id.iv_video);
        if (r11 == null) goto L7;
        FrameLayout r12 = (FrameLayout) r10;
        return new t0(r12, r11, r12);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.iv_video)));
    }

    public static t0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_entity_video_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayout b() {
        return this.f25760a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
