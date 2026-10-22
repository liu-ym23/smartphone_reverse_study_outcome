package x7;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f25615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f25616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f25617d;

    public j(LinearLayout r10, FrameLayout r11, FrameLayout r12, LinearLayout r13) {
        this.f25614a = r10;
        this.f25615b = r11;
        this.f25616c = r12;
        this.f25617d = r13;
    }

    public static j a(View r10) {
        int r11 = R.id.fl_base_content;
        FrameLayout r12 = (FrameLayout) i0.a.a(r10, R.id.fl_base_content);
        if (r12 == null) goto L9;
        r11 = R.id.fl_base_header;
        FrameLayout r13 = (FrameLayout) i0.a.a(r10, R.id.fl_base_header);
        if (r13 == null) goto L9;
        LinearLayout r14 = (LinearLayout) r10;
        return new j(r14, r12, r13, r14);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25614a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
