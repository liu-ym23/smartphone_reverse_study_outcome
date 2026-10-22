package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppStatusView f25587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25589d;

    public h1(LinearLayout r10, AppStatusView r11, ImageView r12, TextView r13) {
        this.f25586a = r10;
        this.f25587b = r11;
        this.f25588c = r12;
        this.f25589d = r13;
    }

    public static h1 a(View r10) {
        int r11 = R.id.app_status_view;
        AppStatusView r12 = (AppStatusView) i0.a.a(r10, R.id.app_status_view);
        if (r12 == null) goto L11;
        r11 = R.id.iv_icon;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_icon);
        if (r13 == null) goto L11;
        r11 = R.id.tv_name;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_name);
        if (r14 == null) goto L11;
        return new h1((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static h1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_vertical, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25586a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
