package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25610e;

    public i0(LinearLayout r10, ImageView r11, TextView r12, TextView r13, TextView r14) {
        this.f25606a = r10;
        this.f25607b = r11;
        this.f25608c = r12;
        this.f25609d = r13;
        this.f25610e = r14;
    }

    public static i0 a(View r10) {
        int r11 = R.id.iv_state_retry_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_state_retry_icon);
        if (r12 == null) goto L13;
        r11 = R.id.tv_state_retry;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_state_retry);
        if (r13 == null) goto L13;
        r11 = R.id.tv_state_retry_sub_title;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_state_retry_sub_title);
        if (r14 == null) goto L13;
        r11 = R.id.tv_state_retry_title;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_state_retry_title);
        if (r15 == null) goto L13;
        return new i0((LinearLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25606a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
