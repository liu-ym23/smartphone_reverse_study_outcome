package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.MaxHeightRelativeLayout;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f25590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f25591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f25592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f25594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f25595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f25596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f25597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MaxHeightRelativeLayout f25598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f25599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f25600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f25601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f25602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f25603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f25604o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f25605p;

    public i(RelativeLayout r10, ConstraintLayout r11, LinearLayout r12, ImageView r13, ImageView r14, ImageView r15, ImageView r16, ImageView r17, MaxHeightRelativeLayout r18, TextView r19, TextView r110, TextView r111, TextView r112, TextView r113, TextView r114, TextView r115) {
        this.f25590a = r10;
        this.f25591b = r11;
        this.f25592c = r12;
        this.f25593d = r13;
        this.f25594e = r14;
        this.f25595f = r15;
        this.f25596g = r16;
        this.f25597h = r17;
        this.f25598i = r18;
        this.f25599j = r19;
        this.f25600k = r110;
        this.f25601l = r111;
        this.f25602m = r112;
        this.f25603n = r113;
        this.f25604o = r114;
        this.f25605p = r115;
    }

    public static i a(View r20) {
        int r10 = R.id.constraint_layout;
        ConstraintLayout r11 = (ConstraintLayout) i0.a.a(r20, R.id.constraint_layout);
        if (r11 == null) goto L35;
        r10 = R.id.content_layout;
        LinearLayout r12 = (LinearLayout) i0.a.a(r20, R.id.content_layout);
        if (r12 == null) goto L35;
        r10 = R.id.game_line;
        ImageView r13 = (ImageView) i0.a.a(r20, R.id.game_line);
        if (r13 == null) goto L35;
        r10 = R.id.iv_bg;
        ImageView r14 = (ImageView) i0.a.a(r20, R.id.iv_bg);
        if (r14 == null) goto L35;
        r10 = R.id.iv_close;
        ImageView r15 = (ImageView) i0.a.a(r20, R.id.iv_close);
        if (r15 == null) goto L35;
        r10 = R.id.iv_logo;
        ImageView r16 = (ImageView) i0.a.a(r20, R.id.iv_logo);
        if (r16 == null) goto L35;
        r10 = R.id.iv_stroke;
        ImageView r17 = (ImageView) i0.a.a(r20, R.id.iv_stroke);
        if (r17 == null) goto L35;
        r10 = R.id.relative_layout;
        MaxHeightRelativeLayout r18 = (MaxHeightRelativeLayout) i0.a.a(r20, R.id.relative_layout);
        if (r18 == null) goto L35;
        r10 = R.id.tv_content;
        TextView r19 = (TextView) i0.a.a(r20, R.id.tv_content);
        if (r19 == null) goto L35;
        r10 = R.id.tv_count;
        TextView r110 = (TextView) i0.a.a(r20, R.id.tv_count);
        if (r110 == null) goto L35;
        r10 = R.id.tv_instruction;
        TextView r111 = (TextView) i0.a.a(r20, R.id.tv_instruction);
        if (r111 == null) goto L35;
        r10 = R.id.tv_name;
        TextView r112 = (TextView) i0.a.a(r20, R.id.tv_name);
        if (r112 == null) goto L35;
        r10 = R.id.tv_time;
        TextView r113 = (TextView) i0.a.a(r20, R.id.tv_time);
        if (r113 == null) goto L35;
        r10 = R.id.tv_title;
        TextView r114 = (TextView) i0.a.a(r20, R.id.tv_title);
        if (r114 == null) goto L35;
        r10 = R.id.tv_use;
        TextView r115 = (TextView) i0.a.a(r20, R.id.tv_use);
        if (r115 == null) goto L35;
        return new i((RelativeLayout) r20, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r10)));
    }

    public static i c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static i d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.dialog_tv_gift_detail, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public RelativeLayout b() {
        return this.f25590a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
