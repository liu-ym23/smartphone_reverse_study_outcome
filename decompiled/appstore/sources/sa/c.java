package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.ui.FrameLayoutCenterChildrenInDecorView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayoutCenterChildrenInDecorView f24567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewStub f24568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewStub f24569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewStub f24570d;

    public c(FrameLayoutCenterChildrenInDecorView r10, ViewStub r11, ViewStub r12, ViewStub r13) {
        this.f24567a = r10;
        this.f24568b = r11;
        this.f24569c = r12;
        this.f24570d = r13;
    }

    public static c a(View r10) {
        int r11 = R.id.vs_state_empty_view;
        ViewStub r12 = (ViewStub) i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.vs_state_loading_view;
        ViewStub r13 = (ViewStub) i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        r11 = R.id.vs_state_retry_view;
        ViewStub r14 = (ViewStub) i0.a.a(r10, r11);
        if (r14 == null) goto L11;
        return new c((FrameLayoutCenterChildrenInDecorView) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static c c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.common_state_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayoutCenterChildrenInDecorView b() {
        return this.f24567a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
