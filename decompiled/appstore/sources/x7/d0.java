package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f25516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f25517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f25518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f25521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f25522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f25523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f25524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f25525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ProgressBar f25526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ProgressBar f25527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ProgressBar f25528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ProgressBar f25529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ProgressBar f25530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f25531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f25532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f25533r;

    public d0(RelativeLayout r10, FrameLayout r11, ConstraintLayout r12, ImageView r13, ImageView r14, ImageView r15, ImageView r16, ImageView r17, ImageView r18, ImageView r19, ProgressBar r110, ProgressBar r111, ProgressBar r112, ProgressBar r113, ProgressBar r114, TextView r115, TextView r116, TextView r20) {
        this.f25516a = r10;
        this.f25517b = r11;
        this.f25518c = r12;
        this.f25519d = r13;
        this.f25520e = r14;
        this.f25521f = r15;
        this.f25522g = r16;
        this.f25523h = r17;
        this.f25524i = r18;
        this.f25525j = r19;
        this.f25526k = r110;
        this.f25527l = r111;
        this.f25528m = r112;
        this.f25529n = r113;
        this.f25530o = r114;
        this.f25531p = r115;
        this.f25532q = r116;
        this.f25533r = r20;
    }

    public static d0 a(View r22) {
        int r10 = R.id.common_grade_layout;
        FrameLayout r11 = (FrameLayout) i0.a.a(r22, R.id.common_grade_layout);
        if (r11 == null) goto L39;
        r10 = R.id.grade_layout;
        ConstraintLayout r12 = (ConstraintLayout) i0.a.a(r22, R.id.grade_layout);
        if (r12 == null) goto L39;
        r10 = R.id.iv_comment_rating;
        ImageView r13 = (ImageView) i0.a.a(r22, R.id.iv_comment_rating);
        if (r13 == null) goto L39;
        r10 = R.id.iv_next;
        ImageView r14 = (ImageView) i0.a.a(r22, R.id.iv_next);
        if (r14 == null) goto L39;
        r10 = R.id.iv_rating_1;
        ImageView r15 = (ImageView) i0.a.a(r22, R.id.iv_rating_1);
        if (r15 == null) goto L39;
        r10 = R.id.iv_rating_2;
        ImageView r16 = (ImageView) i0.a.a(r22, R.id.iv_rating_2);
        if (r16 == null) goto L39;
        r10 = R.id.iv_rating_3;
        ImageView r17 = (ImageView) i0.a.a(r22, R.id.iv_rating_3);
        if (r17 == null) goto L39;
        r10 = R.id.iv_rating_4;
        ImageView r18 = (ImageView) i0.a.a(r22, R.id.iv_rating_4);
        if (r18 == null) goto L39;
        r10 = R.id.iv_rating_5;
        ImageView r19 = (ImageView) i0.a.a(r22, R.id.iv_rating_5);
        if (r19 == null) goto L39;
        r10 = R.id.progress1;
        ProgressBar r110 = (ProgressBar) i0.a.a(r22, R.id.progress1);
        if (r110 == null) goto L39;
        r10 = R.id.progress2;
        ProgressBar r111 = (ProgressBar) i0.a.a(r22, R.id.progress2);
        if (r111 == null) goto L39;
        r10 = R.id.progress3;
        ProgressBar r112 = (ProgressBar) i0.a.a(r22, R.id.progress3);
        if (r112 == null) goto L39;
        r10 = R.id.progress4;
        ProgressBar r113 = (ProgressBar) i0.a.a(r22, R.id.progress4);
        if (r113 == null) goto L39;
        r10 = R.id.progress5;
        ProgressBar r114 = (ProgressBar) i0.a.a(r22, R.id.progress5);
        if (r114 == null) goto L39;
        r10 = R.id.tv_comment_num;
        TextView r115 = (TextView) i0.a.a(r22, R.id.tv_comment_num);
        if (r115 == null) goto L39;
        r10 = R.id.tv_no_comment_tip;
        TextView r20 = (TextView) i0.a.a(r22, R.id.tv_no_comment_tip);
        if (r20 == null) goto L39;
        r10 = R.id.tv_point;
        TextView r21 = (TextView) i0.a.a(r22, R.id.tv_point);
        if (r21 == null) goto L39;
        return new d0((RelativeLayout) r22, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r10)));
    }

    public static d0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_app_grade_layout, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public RelativeLayout b() {
        return this.f25516a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
