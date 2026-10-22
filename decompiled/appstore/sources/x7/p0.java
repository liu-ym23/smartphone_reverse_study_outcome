package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f25726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f25727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25729d;

    public p0(RelativeLayout r10, RelativeLayout r11, ImageView r12, TextView r13) {
        this.f25726a = r10;
        this.f25727b = r11;
        this.f25728c = r12;
        this.f25729d = r13;
    }

    public static p0 a(View r10) {
        RelativeLayout r11 = (RelativeLayout) r10;
        int r12 = R.id.iv_icon;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_icon);
        if (r13 == null) goto L9;
        r12 = R.id.title;
        TextView r14 = (TextView) i0.a.a(r10, R.id.title);
        if (r14 == null) goto L9;
        return new p0(r11, r11, r13, r14);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }

    public RelativeLayout b() {
        return this.f25726a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
