package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f25539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f25546h;

    public e0(ConstraintLayout r10, ImageView r11, ImageView r12, TextView r13, TextView r14, TextView r15, TextView r16, TextView r17) {
        this.f25539a = r10;
        this.f25540b = r11;
        this.f25541c = r12;
        this.f25542d = r13;
        this.f25543e = r14;
        this.f25544f = r15;
        this.f25545g = r16;
        this.f25546h = r17;
    }

    public static e0 a(View r11) {
        int r10 = R.id.iv_list_space;
        ImageView r12 = (ImageView) i0.a.a(r11, R.id.iv_list_space);
        if (r12 == null) goto L19;
        r10 = R.id.iv_rate;
        ImageView r13 = (ImageView) i0.a.a(r11, R.id.iv_rate);
        if (r13 == null) goto L19;
        r10 = R.id.tv_comment;
        TextView r14 = (TextView) i0.a.a(r11, R.id.tv_comment);
        if (r14 == null) goto L19;
        r10 = R.id.tv_like;
        TextView r15 = (TextView) i0.a.a(r11, R.id.tv_like);
        if (r15 == null) goto L19;
        r10 = R.id.tv_nick_name;
        TextView r16 = (TextView) i0.a.a(r11, R.id.tv_nick_name);
        if (r16 == null) goto L19;
        r10 = R.id.tv_time;
        TextView r17 = (TextView) i0.a.a(r11, R.id.tv_time);
        if (r17 == null) goto L19;
        r10 = R.id.tv_version;
        TextView r18 = (TextView) i0.a.a(r11, R.id.tv_version);
        if (r18 == null) goto L19;
        return new e0((ConstraintLayout) r11, r12, r13, r14, r15, r16, r17, r18);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r10)));
    }

    public static e0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_common_app_comment_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f25539a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
