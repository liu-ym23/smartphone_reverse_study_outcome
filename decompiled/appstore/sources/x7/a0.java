package x7;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f25488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f25489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f25491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f25493g;

    public a0(ConstraintLayout r10, TextView r11, FrameLayout r12, ImageView r13, FrameLayout r14, TextView r15, FrameLayout r16) {
        this.f25487a = r10;
        this.f25488b = r11;
        this.f25489c = r12;
        this.f25490d = r13;
        this.f25491e = r14;
        this.f25492f = r15;
        this.f25493g = r16;
    }

    public static a0 a(View r10) {
        int r11 = R.id.account_logout;
        TextView r12 = (TextView) i0.a.a(r10, R.id.account_logout);
        if (r12 == null) goto L17;
        r11 = R.id.head_content;
        FrameLayout r13 = (FrameLayout) i0.a.a(r10, R.id.head_content);
        if (r13 == null) goto L17;
        r11 = R.id.iv_icon;
        ImageView r14 = (ImageView) i0.a.a(r10, R.id.iv_icon);
        if (r14 == null) goto L17;
        r11 = R.id.nickname_content;
        FrameLayout r15 = (FrameLayout) i0.a.a(r10, R.id.nickname_content);
        if (r15 == null) goto L17;
        r11 = R.id.tv_name;
        TextView r16 = (TextView) i0.a.a(r10, R.id.tv_name);
        if (r16 == null) goto L17;
        r11 = R.id.user_info_container;
        FrameLayout r17 = (FrameLayout) i0.a.a(r10, R.id.user_info_container);
        if (r17 == null) goto L17;
        return new a0((ConstraintLayout) r10, r12, r13, r14, r15, r16, r17);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f25487a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
