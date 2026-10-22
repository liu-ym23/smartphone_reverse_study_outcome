package x7;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f25664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f25668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextureView f25669g;

    public l1(FrameLayout r10, ProgressBar r11, ImageView r12, ImageView r13, ImageView r14, FrameLayout r15, TextureView r16) {
        this.f25663a = r10;
        this.f25664b = r11;
        this.f25665c = r12;
        this.f25666d = r13;
        this.f25667e = r14;
        this.f25668f = r15;
        this.f25669g = r16;
    }

    public static l1 a(View r10) {
        int r11 = R.id.bottom_progress;
        ProgressBar r12 = (ProgressBar) i0.a.a(r10, R.id.bottom_progress);
        if (r12 == null) goto L15;
        r11 = R.id.img_view;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.img_view);
        if (r13 == null) goto L15;
        r11 = R.id.iv_start;
        ImageView r14 = (ImageView) i0.a.a(r10, R.id.iv_start);
        if (r14 == null) goto L15;
        r11 = R.id.mute_view;
        ImageView r15 = (ImageView) i0.a.a(r10, R.id.mute_view);
        if (r15 == null) goto L15;
        FrameLayout r16 = (FrameLayout) r10;
        r11 = R.id.video_view;
        TextureView r17 = (TextureView) i0.a.a(r10, R.id.video_view);
        if (r17 == null) goto L15;
        return new l1(r16, r12, r13, r14, r15, r16, r17);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static l1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.widget_video_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayout b() {
        return this.f25663a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
