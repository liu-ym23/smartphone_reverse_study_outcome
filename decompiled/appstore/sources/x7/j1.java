package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f25625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25627f;

    public j1(ConstraintLayout r10, ImageView r11, ImageView r12, ConstraintLayout r13, TextView r14, TextView r15) {
        this.f25622a = r10;
        this.f25623b = r11;
        this.f25624c = r12;
        this.f25625d = r13;
        this.f25626e = r14;
        this.f25627f = r15;
    }

    public static j1 a(View r10) {
        int r11 = R.id.iv_subscribe_icon;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_subscribe_icon);
        if (r12 == null) goto L13;
        r11 = R.id.iv_subscribe_next;
        ImageView r13 = (ImageView) i0.a.a(r10, R.id.iv_subscribe_next);
        if (r13 == null) goto L13;
        ConstraintLayout r14 = (ConstraintLayout) r10;
        r11 = R.id.tv_subscribe_desc;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_subscribe_desc);
        if (r15 == null) goto L13;
        r11 = R.id.tv_subscribe_number;
        TextView r16 = (TextView) i0.a.a(r10, R.id.tv_subscribe_number);
        if (r16 == null) goto L13;
        return new j1(r14, r12, r13, r14, r15, r16);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public ConstraintLayout b() {
        return this.f25622a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
