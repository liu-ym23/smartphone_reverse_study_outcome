package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.ui.widget.SubButton;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f25796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubButton f25797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f25798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonRecyclerView f25799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommonRecyclerView f25800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CommonRecyclerView f25801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f25803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f25804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f25805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f25806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f25807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f25808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f25809n;

    public y(NestedScrollView r10, SubButton r11, ImageView r12, CommonRecyclerView r13, CommonRecyclerView r14, CommonRecyclerView r15, TextView r16, TextView r17, TextView r18, TextView r19, View r110, View r111, View r112, View r113) {
        this.f25796a = r10;
        this.f25797b = r11;
        this.f25798c = r12;
        this.f25799d = r13;
        this.f25800e = r14;
        this.f25801f = r15;
        this.f25802g = r16;
        this.f25803h = r17;
        this.f25804i = r18;
        this.f25805j = r19;
        this.f25806k = r110;
        this.f25807l = r111;
        this.f25808m = r112;
        this.f25809n = r113;
    }

    public static y a(View r18) {
        int r10 = R.id.btn_sub;
        SubButton r11 = (SubButton) i0.a.a(r18, R.id.btn_sub);
        if (r11 == null) goto L31;
        r10 = R.id.iv_icon;
        ImageView r12 = (ImageView) i0.a.a(r18, R.id.iv_icon);
        if (r12 == null) goto L31;
        r10 = R.id.recycler_view_gift;
        CommonRecyclerView r13 = (CommonRecyclerView) i0.a.a(r18, R.id.recycler_view_gift);
        if (r13 == null) goto L31;
        r10 = R.id.recycler_view_recommend;
        CommonRecyclerView r14 = (CommonRecyclerView) i0.a.a(r18, R.id.recycler_view_recommend);
        if (r14 == null) goto L31;
        r10 = R.id.recycler_view_screen;
        CommonRecyclerView r15 = (CommonRecyclerView) i0.a.a(r18, R.id.recycler_view_screen);
        if (r15 == null) goto L31;
        r10 = R.id.tv_category;
        TextView r16 = (TextView) i0.a.a(r18, R.id.tv_category);
        if (r16 == null) goto L31;
        r10 = R.id.tv_desc;
        TextView r17 = (TextView) i0.a.a(r18, R.id.tv_desc);
        if (r17 == null) goto L31;
        r10 = R.id.tv_name;
        TextView r19 = (TextView) i0.a.a(r18, R.id.tv_name);
        if (r19 == null) goto L31;
        r10 = R.id.tv_time;
        TextView r110 = (TextView) i0.a.a(r18, R.id.tv_time);
        if (r110 == null) goto L31;
        r10 = R.id.view_line_1;
        View r111 = i0.a.a(r18, R.id.view_line_1);
        if (r111 == null) goto L31;
        r10 = R.id.view_line_2;
        View r112 = i0.a.a(r18, R.id.view_line_2);
        if (r112 == null) goto L31;
        r10 = R.id.view_line_3;
        View r113 = i0.a.a(r18, R.id.view_line_3);
        if (r113 == null) goto L31;
        r10 = R.id.view_line_4;
        View r114 = i0.a.a(r18, R.id.view_line_4);
        if (r114 == null) goto L31;
        return new y((NestedScrollView) r18, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r112, r113, r114);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r10)));
    }

    public NestedScrollView b() {
        return this.f25796a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
