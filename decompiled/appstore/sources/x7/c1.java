package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f25512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f25513b;

    public c1(FrameLayout r10, TextView r11) {
        this.f25512a = r10;
        this.f25513b = r11;
    }

    public static c1 a(View r10) {
        TextView r11 = (TextView) i0.a.a(r10, R.id.tv_tip_text);
        if (r11 == null) goto L7;
        return new c1((FrameLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.tv_tip_text)));
    }

    public static c1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_search_result_yyb, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public FrameLayout b() {
        return this.f25512a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
