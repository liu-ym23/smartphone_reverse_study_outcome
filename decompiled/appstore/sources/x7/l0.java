package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppStatusView f25651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Group f25653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f25655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f25657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f25658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f25659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f25660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f25661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f25662m;

    public l0(ConstraintLayout r10, AppStatusView r11, View r12, Group r13, ImageView r14, ImageView r15, TextView r16, TextView r17, View r18, TextView r19, TextView r110, TextView r111, TextView r112) {
        this.f25650a = r10;
        this.f25651b = r11;
        this.f25652c = r12;
        this.f25653d = r13;
        this.f25654e = r14;
        this.f25655f = r15;
        this.f25656g = r16;
        this.f25657h = r17;
        this.f25658i = r18;
        this.f25659j = r19;
        this.f25660k = r110;
        this.f25661l = r111;
        this.f25662m = r112;
    }

    public static l0 a(View r17) {
        int r10 = R.id.appStatusLay;
        AppStatusView r11 = (AppStatusView) i0.a.a(r17, R.id.appStatusLay);
        if (r11 == null) goto L29;
        r10 = R.id.fg_app_detail_line_view1;
        View r12 = i0.a.a(r17, R.id.fg_app_detail_line_view1);
        if (r12 == null) goto L29;
        r10 = R.id.group_app_rate;
        Group r13 = (Group) i0.a.a(r17, R.id.group_app_rate);
        if (r13 == null) goto L29;
        r10 = R.id.iv_logo;
        ImageView r14 = (ImageView) i0.a.a(r17, R.id.iv_logo);
        if (r14 == null) goto L29;
        r10 = R.id.iv_rating;
        ImageView r15 = (ImageView) i0.a.a(r17, R.id.iv_rating);
        if (r15 == null) goto L29;
        r10 = R.id.label_0;
        TextView r16 = (TextView) i0.a.a(r17, R.id.label_0);
        if (r16 == null) goto L29;
        r10 = R.id.label_1;
        TextView r18 = (TextView) i0.a.a(r17, R.id.label_1);
        if (r18 == null) goto L29;
        r10 = R.id.line_view;
        View r19 = i0.a.a(r17, R.id.line_view);
        if (r19 == null) goto L29;
        r10 = R.id.tv_company;
        TextView r110 = (TextView) i0.a.a(r17, R.id.tv_company);
        if (r110 == null) goto L29;
        r10 = R.id.tv_name;
        TextView r111 = (TextView) i0.a.a(r17, R.id.tv_name);
        if (r111 == null) goto L29;
        r10 = R.id.tv_play;
        TextView r112 = (TextView) i0.a.a(r17, R.id.tv_play);
        if (r112 == null) goto L29;
        r10 = R.id.tv_size;
        TextView r113 = (TextView) i0.a.a(r17, R.id.tv_size);
        if (r113 == null) goto L29;
        return new l0((ConstraintLayout) r17, r11, r12, r13, r14, r15, r16, r18, r19, r110, r111, r112, r113);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r10)));
    }

    public ConstraintLayout b() {
        return this.f25650a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
