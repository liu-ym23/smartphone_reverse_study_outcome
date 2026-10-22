package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.badge.OBadgeView;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OBadgeView f25510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OBadgeView f25511b;

    public c0(OBadgeView r10, OBadgeView r11) {
        this.f25510a = r10;
        this.f25511b = r11;
    }

    public static c0 a(View r10) {
        if (r10 == null) goto L6;
        OBadgeView r11 = (OBadgeView) r10;
        return new c0(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public static c0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.recommend_head_badge, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public OBadgeView b() {
        return this.f25510a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
