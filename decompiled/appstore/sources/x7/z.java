package x7;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f25818b;

    public z(LinearLayout r10, View r11) {
        this.f25817a = r10;
        this.f25818b = r11;
    }

    public static z a(View r10) {
        View r11 = i0.a.a(r10, R.id.game_reservation_header);
        if (r11 == null) goto L7;
        return new z((LinearLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.game_reservation_header)));
    }

    public LinearLayout b() {
        return this.f25817a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
