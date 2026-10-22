package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextView f25670J;
    public final TextView K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f25672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Group f25675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Group f25676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Group f25677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Group f25678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f25679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f25680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f25681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f25682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f25683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f25684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f25685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f25686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f25687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f25688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f25689s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f25690t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f25691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f25692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f25693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f25694x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ItemHorizontalView f25695y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f25696z;

    public m(LinearLayout r10, TextView r11, TextView r12, TextView r13, Group r14, Group r15, Group r16, Group r17, ImageView r18, View r19, View r110, View r111, View r112, View r113, TextView r114, TextView r115, TextView r116, TextView r20, TextView r21, TextView r22, TextView r23, TextView r24, TextView r25, TextView r26, ItemHorizontalView r27, TextView r28, TextView r29, TextView r30, TextView r31, TextView r32, TextView r33, TextView r34, TextView r35, TextView r36, TextView r37, TextView r38, TextView r39) {
        this.f25671a = r10;
        this.f25672b = r11;
        this.f25673c = r12;
        this.f25674d = r13;
        this.f25675e = r14;
        this.f25676f = r15;
        this.f25677g = r16;
        this.f25678h = r17;
        this.f25679i = r18;
        this.f25680j = r19;
        this.f25681k = r110;
        this.f25682l = r111;
        this.f25683m = r112;
        this.f25684n = r113;
        this.f25685o = r114;
        this.f25686p = r115;
        this.f25687q = r116;
        this.f25688r = r20;
        this.f25689s = r21;
        this.f25690t = r22;
        this.f25691u = r23;
        this.f25692v = r24;
        this.f25693w = r25;
        this.f25694x = r26;
        this.f25695y = r27;
        this.f25696z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
        this.I = r37;
        this.f25670J = r38;
        this.K = r39;
    }

    public static m a(View r41) {
        int r10 = R.id.appinfo_special_support;
        TextView r11 = (TextView) i0.a.a(r41, R.id.appinfo_special_support);
        if (r11 == null) goto L77;
        r10 = R.id.drag_one_step;
        TextView r12 = (TextView) i0.a.a(r41, R.id.drag_one_step);
        if (r12 == null) goto L77;
        r10 = R.id.find_more;
        TextView r13 = (TextView) i0.a.a(r41, R.id.find_more);
        if (r13 == null) goto L77;
        r10 = R.id.group_alias;
        Group r14 = (Group) i0.a.a(r41, R.id.group_alias);
        if (r14 == null) goto L77;
        r10 = R.id.group_feature;
        Group r15 = (Group) i0.a.a(r41, R.id.group_feature);
        if (r15 == null) goto L77;
        r10 = R.id.group_permission;
        Group r16 = (Group) i0.a.a(r41, R.id.group_permission);
        if (r16 == null) goto L77;
        r10 = R.id.group_system;
        Group r17 = (Group) i0.a.a(r41, R.id.group_system);
        if (r17 == null) goto L77;
        r10 = R.id.iv_from_logo;
        ImageView r18 = (ImageView) i0.a.a(r41, R.id.iv_from_logo);
        if (r18 == null) goto L77;
        r10 = R.id.line_view2;
        View r19 = i0.a.a(r41, R.id.line_view2);
        if (r19 == null) goto L77;
        r10 = R.id.line_view3;
        View r110 = i0.a.a(r41, R.id.line_view3);
        if (r110 == null) goto L77;
        r10 = R.id.line_view4;
        View r111 = i0.a.a(r41, R.id.line_view4);
        if (r111 == null) goto L77;
        r10 = R.id.line_view5;
        View r112 = i0.a.a(r41, R.id.line_view5);
        if (r112 == null) goto L77;
        r10 = R.id.line_view6;
        View r113 = i0.a.a(r41, R.id.line_view6);
        if (r113 == null) goto L77;
        r10 = R.id.tv_alias;
        TextView r114 = (TextView) i0.a.a(r41, R.id.tv_alias);
        if (r114 == null) goto L77;
        r10 = R.id.tv_alias_hint;
        TextView r115 = (TextView) i0.a.a(r41, R.id.tv_alias_hint);
        if (r115 == null) goto L77;
        r10 = R.id.tv_app_info_hint;
        TextView r20 = (TextView) i0.a.a(r41, R.id.tv_app_info_hint);
        if (r20 == null) goto L77;
        r10 = R.id.tv_app_update;
        TextView r21 = (TextView) i0.a.a(r41, R.id.tv_app_update);
        if (r21 == null) goto L77;
        r10 = R.id.tv_app_update_hint;
        TextView r22 = (TextView) i0.a.a(r41, R.id.tv_app_update_hint);
        if (r22 == null) goto L77;
        r10 = R.id.tv_brief_hint;
        TextView r23 = (TextView) i0.a.a(r41, R.id.tv_brief_hint);
        if (r23 == null) goto L77;
        r10 = R.id.tv_desc;
        TextView r24 = (TextView) i0.a.a(r41, R.id.tv_desc);
        if (r24 == null) goto L77;
        r10 = R.id.tv_developer;
        TextView r25 = (TextView) i0.a.a(r41, R.id.tv_developer);
        if (r25 == null) goto L77;
        r10 = R.id.tv_developers_hint;
        TextView r26 = (TextView) i0.a.a(r41, R.id.tv_developers_hint);
        if (r26 == null) goto L77;
        r10 = R.id.tv_feedback;
        TextView r27 = (TextView) i0.a.a(r41, R.id.tv_feedback);
        if (r27 == null) goto L77;
        r10 = R.id.tv_now_app;
        ItemHorizontalView r28 = (ItemHorizontalView) i0.a.a(r41, R.id.tv_now_app);
        if (r28 == null) goto L77;
        r10 = R.id.tv_permission;
        TextView r29 = (TextView) i0.a.a(r41, R.id.tv_permission);
        if (r29 == null) goto L77;
        r10 = R.id.tv_permission_hint;
        TextView r30 = (TextView) i0.a.a(r41, R.id.tv_permission_hint);
        if (r30 == null) goto L77;
        r10 = R.id.tv_source;
        TextView r31 = (TextView) i0.a.a(r41, R.id.tv_source);
        if (r31 == null) goto L77;
        r10 = R.id.tv_source_hint;
        TextView r32 = (TextView) i0.a.a(r41, R.id.tv_source_hint);
        if (r32 == null) goto L77;
        r10 = R.id.tv_system;
        TextView r33 = (TextView) i0.a.a(r41, R.id.tv_system);
        if (r33 == null) goto L77;
        r10 = R.id.tv_system_hint;
        TextView r34 = (TextView) i0.a.a(r41, R.id.tv_system_hint);
        if (r34 == null) goto L77;
        r10 = R.id.tv_type;
        TextView r35 = (TextView) i0.a.a(r41, R.id.tv_type);
        if (r35 == null) goto L77;
        r10 = R.id.tv_type_hint;
        TextView r36 = (TextView) i0.a.a(r41, R.id.tv_type_hint);
        if (r36 == null) goto L77;
        r10 = R.id.tv_update;
        TextView r37 = (TextView) i0.a.a(r41, R.id.tv_update);
        if (r37 == null) goto L77;
        r10 = R.id.tv_update_hint;
        TextView r38 = (TextView) i0.a.a(r41, R.id.tv_update_hint);
        if (r38 == null) goto L77;
        r10 = R.id.tv_version;
        TextView r39 = (TextView) i0.a.a(r41, R.id.tv_version);
        if (r39 == null) goto L77;
        r10 = R.id.tv_version_hint;
        TextView r40 = (TextView) i0.a.a(r41, R.id.tv_version_hint);
        if (r40 == null) goto L77;
        return new m((LinearLayout) r41, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    L77:
        throw new NullPointerException("Missing required view with ID: ".concat(r41.getResources().getResourceName(r10)));
    }

    public LinearLayout b() {
        return this.f25671a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
