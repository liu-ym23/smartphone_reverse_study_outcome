package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f25535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25536c;

    public d1(ConstraintLayout r10, TextView r11, ImageView r12) {
        this.f25534a = r10;
        this.f25535b = r11;
        this.f25536c = r12;
    }

    public static d1 a(View r10) {
        int r11 = R.id.tv_keyword;
        TextView r12 = (TextView) i0.a.a(r10, R.id.tv_keyword);
        if (r12 == null) goto L9;
        r11 = R.id.tv_pager_title_space;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.tv_pager_title_space);
        if (r13 == null) goto L9;
        return new d1((ConstraintLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static d1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_search_tip_keyword, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25534a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
