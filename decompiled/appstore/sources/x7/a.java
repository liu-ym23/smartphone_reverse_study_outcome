package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f25475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f25480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f25481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RelativeLayout f25482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f25483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f25484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f25485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f25486l;

    public a(RelativeLayout r10, ConstraintLayout r11, ImageView r12, ImageView r13, ImageView r14, ImageView r15, LinearLayout r16, RelativeLayout r17, TextView r18, TextView r19, TextView r110, TextView r111) {
        this.f25475a = r10;
        this.f25476b = r11;
        this.f25477c = r12;
        this.f25478d = r13;
        this.f25479e = r14;
        this.f25480f = r15;
        this.f25481g = r16;
        this.f25482h = r17;
        this.f25483i = r18;
        this.f25484j = r19;
        this.f25485k = r110;
        this.f25486l = r111;
    }

    public static a a(View r15) {
        int r10 = R.id.constraint_layout;
        ConstraintLayout r11 = (ConstraintLayout) i0.a.a(r15, R.id.constraint_layout);
        if (r11 == null) goto L27;
        r10 = R.id.iv_bg;
        ImageView r12 = (ImageView) i0.a.a(r15, R.id.iv_bg);
        if (r12 == null) goto L27;
        r10 = R.id.iv_close;
        ImageView r13 = (ImageView) i0.a.a(r15, R.id.iv_close);
        if (r13 == null) goto L27;
        r10 = R.id.iv_logo;
        ImageView r14 = (ImageView) i0.a.a(r15, R.id.iv_logo);
        if (r14 == null) goto L27;
        r10 = R.id.iv_stroke;
        ImageView r16 = (ImageView) i0.a.a(r15, R.id.iv_stroke);
        if (r16 == null) goto L27;
        r10 = R.id.permission_layout;
        LinearLayout r17 = (LinearLayout) i0.a.a(r15, R.id.permission_layout);
        if (r17 == null) goto L27;
        r10 = R.id.relative_layout;
        RelativeLayout r18 = (RelativeLayout) i0.a.a(r15, R.id.relative_layout);
        if (r18 == null) goto L27;
        r10 = R.id.tv_name;
        TextView r19 = (TextView) i0.a.a(r15, R.id.tv_name);
        if (r19 == null) goto L27;
        r10 = R.id.tv_permission_brief;
        TextView r110 = (TextView) i0.a.a(r15, R.id.tv_permission_brief);
        if (r110 == null) goto L27;
        r10 = R.id.tv_title;
        TextView r111 = (TextView) i0.a.a(r15, R.id.tv_title);
        if (r111 == null) goto L27;
        r10 = R.id.tv_version;
        TextView r112 = (TextView) i0.a.a(r15, R.id.tv_version);
        if (r112 == null) goto L27;
        return new a((RelativeLayout) r15, r11, r12, r13, r14, r16, r17, r18, r19, r110, r111, r112);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r10)));
    }

    public RelativeLayout b() {
        return this.f25475a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
