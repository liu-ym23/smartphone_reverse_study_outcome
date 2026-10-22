package sa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricAppItemView f24614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OScrollView f24615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OPanelTitleBar f24616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f24617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OPanelTitleBar f24618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f24619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f24620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTextView f24621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f24622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTextView f24623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f24624l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f24625m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f24626n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OPanelTitleBar f24627o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OTextView f24628p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f24629q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f24630r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f24631s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f24632t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f24633u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f24634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f24635w;

    public o(LinearLayout r10, ObricAppItemView r11, OScrollView r12, OPanelTitleBar r13, TextView r14, OPanelTitleBar r15, TextView r16, TextView r17, OTextView r18, TextView r19, OTextView r110, TextView r111, View r112, TextView r113, OPanelTitleBar r114, OTextView r115, TextView r116, TextView r20, TextView r21, TextView r22, TextView r23, TextView r24, TextView r25) {
        this.f24613a = r10;
        this.f24614b = r11;
        this.f24615c = r12;
        this.f24616d = r13;
        this.f24617e = r14;
        this.f24618f = r15;
        this.f24619g = r16;
        this.f24620h = r17;
        this.f24621i = r18;
        this.f24622j = r19;
        this.f24623k = r110;
        this.f24624l = r111;
        this.f24625m = r112;
        this.f24626n = r113;
        this.f24627o = r114;
        this.f24628p = r115;
        this.f24629q = r116;
        this.f24630r = r20;
        this.f24631s = r21;
        this.f24632t = r22;
        this.f24633u = r23;
        this.f24634v = r24;
        this.f24635w = r25;
    }

    public static o a(View r27) {
        int r10 = R.id.appinfo_item;
        ObricAppItemView r11 = (ObricAppItemView) i0.a.a(r27, r10);
        if (r11 == null) goto L49;
        r10 = R.id.appinfo_scrollview;
        OScrollView r12 = (OScrollView) i0.a.a(r27, r10);
        if (r12 == null) goto L49;
        r10 = R.id.appinfo_title;
        OPanelTitleBar r13 = (OPanelTitleBar) i0.a.a(r27, r10);
        if (r13 == null) goto L49;
        r10 = R.id.brief_detail;
        TextView r14 = (TextView) i0.a.a(r27, r10);
        if (r14 == null) goto L49;
        r10 = R.id.brief_title;
        OPanelTitleBar r15 = (OPanelTitleBar) i0.a.a(r27, r10);
        if (r15 == null) goto L49;
        r10 = R.id.category_detail;
        TextView r16 = (TextView) i0.a.a(r27, r10);
        if (r16 == null) goto L49;
        r10 = R.id.category_title;
        TextView r17 = (TextView) i0.a.a(r27, r10);
        if (r17 == null) goto L49;
        r10 = R.id.developer_detail;
        OTextView r18 = (OTextView) i0.a.a(r27, r10);
        if (r18 == null) goto L49;
        r10 = R.id.developer_title;
        TextView r19 = (TextView) i0.a.a(r27, r10);
        if (r19 == null) goto L49;
        r10 = R.id.icp_detail;
        OTextView r110 = (OTextView) i0.a.a(r27, r10);
        if (r110 == null) goto L49;
        r10 = R.id.icp_title;
        TextView r111 = (TextView) i0.a.a(r27, r10);
        if (r111 == null) goto L49;
        r10 = R.id.margin_view;
        View r112 = i0.a.a(r27, r10);
        if (r112 == null) goto L49;
        r10 = R.id.new_feature_detail;
        TextView r113 = (TextView) i0.a.a(r27, r10);
        if (r113 == null) goto L49;
        r10 = R.id.new_feature_title;
        OPanelTitleBar r114 = (OPanelTitleBar) i0.a.a(r27, r10);
        if (r114 == null) goto L49;
        r10 = R.id.permission_detail;
        OTextView r115 = (OTextView) i0.a.a(r27, r10);
        if (r115 == null) goto L49;
        r10 = R.id.permission_title;
        TextView r20 = (TextView) i0.a.a(r27, r10);
        if (r20 == null) goto L49;
        r10 = R.id.source_detail;
        TextView r21 = (TextView) i0.a.a(r27, r10);
        if (r21 == null) goto L49;
        r10 = R.id.source_title;
        TextView r22 = (TextView) i0.a.a(r27, r10);
        if (r22 == null) goto L49;
        r10 = R.id.update_detail;
        TextView r23 = (TextView) i0.a.a(r27, r10);
        if (r23 == null) goto L49;
        r10 = R.id.update_title;
        TextView r24 = (TextView) i0.a.a(r27, r10);
        if (r24 == null) goto L49;
        r10 = R.id.version_detail;
        TextView r25 = (TextView) i0.a.a(r27, r10);
        if (r25 == null) goto L49;
        r10 = R.id.version_title;
        TextView r26 = (TextView) i0.a.a(r27, r10);
        if (r26 == null) goto L49;
        return new o((LinearLayout) r27, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r23, r24, r25, r26);
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r10)));
    }

    public LinearLayout b() {
        return this.f24613a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
