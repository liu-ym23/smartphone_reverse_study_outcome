package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowLayout f25503b;

    public b1(LinearLayout r10, FlowLayout r11) {
        this.f25502a = r10;
        this.f25503b = r11;
    }

    public static b1 a(View r10) {
        FlowLayout r11 = (FlowLayout) i0.a.a(r10, R.id.fl_hot_keyword);
        if (r11 == null) goto L7;
        return new b1((LinearLayout) r10, r11);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(R.id.fl_hot_keyword)));
    }

    public static b1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_search_result_hot_keyword, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25502a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
