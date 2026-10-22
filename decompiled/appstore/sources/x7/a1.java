package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25496c;

    public a1(LinearLayout r10, ImageView r11, TextView r12) {
        this.f25494a = r10;
        this.f25495b = r11;
        this.f25496c = r12;
    }

    public static a1 a(View r10) {
        int r11 = R.id.tv_pager_title_space;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.tv_pager_title_space);
        if (r12 == null) goto L9;
        r11 = R.id.tv_title;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_title);
        if (r13 == null) goto L9;
        return new a1((LinearLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static a1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_my_apps_title, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25494a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
