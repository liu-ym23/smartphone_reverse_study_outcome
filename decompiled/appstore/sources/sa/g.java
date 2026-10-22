package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f24588a;

    public g(FrameLayout r10) {
        this.f24588a = r10;
    }

    public static g a(View r10) {
        if (r10 == null) goto L6;
        return new g((FrameLayout) r10);
    L6:
        throw new NullPointerException("rootView");
    }

    public static g c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static g d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_ignore_update_title_action, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayout b() {
        return this.f24588a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
