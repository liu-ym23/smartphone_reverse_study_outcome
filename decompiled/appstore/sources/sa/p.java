package sa;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.widget.MarqueeTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.common.core.ui.view.ObricAppStatusView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements ViewBinding {
    public final OTextView A;
    public final OTextView B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f24636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f24637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f24638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f24639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f24640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NetworkImageView f24641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ObricAppItemView f24642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MarqueeTextView f24643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MarqueeTextView f24644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f24645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ObricAppStatusView f24646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppBarLayout f24647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f24648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ONestedScrollView f24649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OTabSegmentedLayout f24650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OChipGroup f24651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f24652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OButton f24653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f24654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MarqueeTextView f24655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f24656u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinearLayout f24657v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f24658w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f24659x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConstraintLayout f24660y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final OTextView f24661z;

    public p(CoordinatorLayout r10, TextView r11, RelativeLayout r12, ImageView r13, OTextView r14, NetworkImageView r15, ObricAppItemView r16, MarqueeTextView r17, MarqueeTextView r18, TextView r19, ObricAppStatusView r110, AppBarLayout r111, FrameLayout r112, ONestedScrollView r113, OTabSegmentedLayout r114, OChipGroup r115, b r116, OButton r20, View r21, MarqueeTextView r22, TextView r23, LinearLayout r24, View r25, b r26, ConstraintLayout r27, OTextView r28, OTextView r29, OTextView r30) {
        this.f24636a = r10;
        this.f24637b = r11;
        this.f24638c = r12;
        this.f24639d = r13;
        this.f24640e = r14;
        this.f24641f = r15;
        this.f24642g = r16;
        this.f24643h = r17;
        this.f24644i = r18;
        this.f24645j = r19;
        this.f24646k = r110;
        this.f24647l = r111;
        this.f24648m = r112;
        this.f24649n = r113;
        this.f24650o = r114;
        this.f24651p = r115;
        this.f24652q = r116;
        this.f24653r = r20;
        this.f24654s = r21;
        this.f24655t = r22;
        this.f24656u = r23;
        this.f24657v = r24;
        this.f24658w = r25;
        this.f24659x = r26;
        this.f24660y = r27;
        this.f24661z = r28;
        this.A = r29;
        this.B = r30;
    }

    public static p a(View r32) {
        int r10 = R.id.app_des;
        TextView r11 = (TextView) i0.a.a(r32, r10);
        if (r11 == null) goto L59;
        r10 = R.id.app_des_layout;
        RelativeLayout r12 = (RelativeLayout) i0.a.a(r32, r10);
        if (r12 == null) goto L59;
        r10 = R.id.app_des_more;
        ImageView r13 = (ImageView) i0.a.a(r32, r10);
        if (r13 == null) goto L59;
        r10 = R.id.appDeveloper;
        OTextView r14 = (OTextView) i0.a.a(r32, r10);
        if (r14 == null) goto L59;
        r10 = R.id.appIcon;
        NetworkImageView r15 = (NetworkImageView) i0.a.a(r32, r10);
        if (r15 == null) goto L59;
        r10 = R.id.app_info_item;
        ObricAppItemView r16 = (ObricAppItemView) i0.a.a(r32, r10);
        if (r16 == null) goto L59;
        r10 = R.id.appName;
        MarqueeTextView r17 = (MarqueeTextView) i0.a.a(r32, r10);
        if (r17 == null) goto L59;
        r10 = R.id.appNameOneliner;
        MarqueeTextView r18 = (MarqueeTextView) i0.a.a(r32, r10);
        if (r18 == null) goto L59;
        r10 = R.id.appSize;
        TextView r19 = (TextView) i0.a.a(r32, r10);
        if (r19 == null) goto L59;
        r10 = R.id.appStatusLay;
        ObricAppStatusView r110 = (ObricAppStatusView) i0.a.a(r32, r10);
        if (r110 == null) goto L59;
        r10 = R.id.appbar_layout;
        AppBarLayout r111 = (AppBarLayout) i0.a.a(r32, r10);
        if (r111 == null) goto L59;
        r10 = R.id.appinfo_header;
        FrameLayout r112 = (FrameLayout) i0.a.a(r32, r10);
        if (r112 == null) goto L59;
        r10 = R.id.appinfo_scrollview;
        ONestedScrollView r113 = (ONestedScrollView) i0.a.a(r32, r10);
        if (r113 == null) goto L59;
        r10 = R.id.appinfo_tab;
        OTabSegmentedLayout r114 = (OTabSegmentedLayout) i0.a.a(r32, r10);
        if (r114 == null) goto L59;
        r10 = R.id.category_container;
        OChipGroup r115 = (OChipGroup) i0.a.a(r32, r10);
        if (r115 == null) goto L59;
        r10 = R.id.classic_apps;
        View r20 = i0.a.a(r32, r10);
        if (r20 == null) goto L59;
        b r21 = b.a(r20);
        r10 = R.id.collapse_locator_appButton;
        OButton r22 = (OButton) i0.a.a(r32, r10);
        if (r22 == null) goto L59;
        r10 = R.id.collapse_locator_appIcon;
        View r23 = i0.a.a(r32, r10);
        if (r23 == null) goto L59;
        r10 = R.id.collapse_locator_appName;
        MarqueeTextView r24 = (MarqueeTextView) i0.a.a(r32, r10);
        if (r24 == null) goto L59;
        r10 = R.id.collapse_locator_appSize;
        TextView r25 = (TextView) i0.a.a(r32, r10);
        if (r25 == null) goto L59;
        r10 = R.id.images_container;
        LinearLayout r26 = (LinearLayout) i0.a.a(r32, r10);
        if (r26 == null) goto L59;
        r10 = R.id.margin_view;
        View r27 = i0.a.a(r32, r10);
        if (r27 == null) goto L59;
        r10 = R.id.relation_apps;
        View r28 = i0.a.a(r32, r10);
        if (r28 == null) goto L59;
        b r29 = b.a(r28);
        r10 = R.id.shrink_locator;
        ConstraintLayout r210 = (ConstraintLayout) i0.a.a(r32, r10);
        if (r210 == null) goto L59;
        r10 = R.id.tv_permissions;
        OTextView r211 = (OTextView) i0.a.a(r32, r10);
        if (r211 == null) goto L59;
        r10 = R.id.tv_privacy_agreement;
        OTextView r30 = (OTextView) i0.a.a(r32, r10);
        if (r30 == null) goto L59;
        r10 = R.id.tv_version;
        OTextView r31 = (OTextView) i0.a.a(r32, r10);
        if (r31 == null) goto L59;
        return new p((CoordinatorLayout) r32, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r21, r22, r23, r24, r25, r26, r27, r29, r210, r211, r30, r31);
    L59:
        throw new NullPointerException("Missing required view with ID: ".concat(r32.getResources().getResourceName(r10)));
    }

    public CoordinatorLayout b() {
        return this.f24636a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
