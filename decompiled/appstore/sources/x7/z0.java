package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f25820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppStatusView f25821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckBox f25822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f25824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f25826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f25827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f25828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f25829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f25830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f25831m;

    public z0(ConstraintLayout r10, TextView r11, AppStatusView r12, CheckBox r13, ImageView r14, ImageView r15, TextView r16, ImageView r17, TextView r18, TextView r19, TextView r110, TextView r111, TextView r112) {
        this.f25819a = r10;
        this.f25820b = r11;
        this.f25821c = r12;
        this.f25822d = r13;
        this.f25823e = r14;
        this.f25824f = r15;
        this.f25825g = r16;
        this.f25826h = r17;
        this.f25827i = r18;
        this.f25828j = r19;
        this.f25829k = r110;
        this.f25830l = r111;
        this.f25831m = r112;
    }

    public static z0 a(View r17) {
        int r10 = R.id.app_source;
        TextView r11 = (TextView) i0.a.a(r17, R.id.app_source);
        if (r11 == null) goto L29;
        r10 = R.id.app_status_view;
        AppStatusView r12 = (AppStatusView) i0.a.a(r17, R.id.app_status_view);
        if (r12 == null) goto L29;
        r10 = R.id.cb_check;
        CheckBox r13 = (CheckBox) i0.a.a(r17, R.id.cb_check);
        if (r13 == null) goto L29;
        r10 = R.id.iv_icon;
        ImageView r14 = (ImageView) i0.a.a(r17, R.id.iv_icon);
        if (r14 == null) goto L29;
        r10 = R.id.iv_rate;
        ImageView r15 = (ImageView) i0.a.a(r17, R.id.iv_rate);
        if (r15 == null) goto L29;
        r10 = R.id.tv_app_rank;
        TextView r16 = (TextView) i0.a.a(r17, R.id.tv_app_rank);
        if (r16 == null) goto L29;
        r10 = R.id.tv_bottom_space;
        ImageView r18 = (ImageView) i0.a.a(r17, R.id.tv_bottom_space);
        if (r18 == null) goto L29;
        r10 = R.id.tv_brief;
        TextView r19 = (TextView) i0.a.a(r17, R.id.tv_brief);
        if (r19 == null) goto L29;
        r10 = R.id.tv_category;
        TextView r110 = (TextView) i0.a.a(r17, R.id.tv_category);
        if (r110 == null) goto L29;
        r10 = R.id.tv_label_0;
        TextView r111 = (TextView) i0.a.a(r17, R.id.tv_label_0);
        if (r111 == null) goto L29;
        r10 = R.id.tv_label_1;
        TextView r112 = (TextView) i0.a.a(r17, R.id.tv_label_1);
        if (r112 == null) goto L29;
        r10 = R.id.tv_name;
        TextView r113 = (TextView) i0.a.a(r17, R.id.tv_name);
        if (r113 == null) goto L29;
        return new z0((ConstraintLayout) r17, r11, r12, r13, r14, r15, r16, r18, r19, r110, r111, r112, r113);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r10)));
    }

    public static z0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_horizontal, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25819a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
