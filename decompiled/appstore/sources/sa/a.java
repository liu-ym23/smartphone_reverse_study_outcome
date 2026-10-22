package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f24559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f24560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f24561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f24562d;

    public a(ConstraintLayout r10, FrameLayout r11, FrameLayout r12, FrameLayout r13) {
        this.f24559a = r10;
        this.f24560b = r11;
        this.f24561c = r12;
        this.f24562d = r13;
    }

    public static a a(View r10) {
        int r11 = R.id.fl_base_content;
        FrameLayout r12 = (FrameLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.fl_base_header;
        FrameLayout r13 = (FrameLayout) i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        r11 = R.id.fl_base_notify;
        FrameLayout r14 = (FrameLayout) i0.a.a(r10, r11);
        if (r14 == null) goto L11;
        return new a((ConstraintLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static a c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.common_fragment_base_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f24559a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
