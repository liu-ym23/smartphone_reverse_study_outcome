package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25585d;

    public h0(LinearLayout r10, ImageView r11, TextView r12, TextView r13) {
        this.f25582a = r10;
        this.f25583b = r11;
        this.f25584c = r12;
        this.f25585d = r13;
    }

    public static h0 a(View r10) {
        int r11 = R.id.iv_state_empty_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_state_empty_icon);
        if (r12 == null) goto L11;
        r11 = R.id.tv_state_empty_desc_text;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_state_empty_desc_text);
        if (r13 == null) goto L11;
        r11 = R.id.tv_state_empty_text;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_state_empty_text);
        if (r14 == null) goto L11;
        return new h0((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25582a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
