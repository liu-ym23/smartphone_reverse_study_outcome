package x7;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.AppGradeView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f25709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f25711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppGradeView f25712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Group f25713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l0 f25714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommonRecyclerView f25715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommonRecyclerView f25716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CommonRecyclerView f25717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f25718k;

    public o(LinearLayout r10, View r11, View r12, View r13, AppGradeView r14, Group r15, l0 r16, CommonRecyclerView r17, CommonRecyclerView r18, CommonRecyclerView r19, TextView r110) {
        this.f25708a = r10;
        this.f25709b = r11;
        this.f25710c = r12;
        this.f25711d = r13;
        this.f25712e = r14;
        this.f25713f = r15;
        this.f25714g = r16;
        this.f25715h = r17;
        this.f25716i = r18;
        this.f25717j = r19;
        this.f25718k = r110;
    }

    public static o a(View r13) {
        int r10 = R.id.fg_app_detail_line_view1;
        View r11 = i0.a.a(r13, R.id.fg_app_detail_line_view1);
        if (r11 == null) goto L25;
        r10 = R.id.fg_app_detail_line_view3;
        View r12 = i0.a.a(r13, R.id.fg_app_detail_line_view3);
        if (r12 == null) goto L25;
        r10 = R.id.fg_app_detail_line_view4;
        View r14 = i0.a.a(r13, R.id.fg_app_detail_line_view4);
        if (r14 == null) goto L25;
        r10 = R.id.grade_view;
        AppGradeView r15 = (AppGradeView) i0.a.a(r13, R.id.grade_view);
        if (r15 == null) goto L25;
        r10 = R.id.group_comment;
        Group r16 = (Group) i0.a.a(r13, R.id.group_comment);
        if (r16 == null) goto L25;
        r10 = R.id.layout_app_detail_header;
        View r17 = i0.a.a(r13, R.id.layout_app_detail_header);
        if (r17 == null) goto L25;
        l0 r18 = l0.a(r17);
        r10 = R.id.recycler_view_gift;
        CommonRecyclerView r19 = (CommonRecyclerView) i0.a.a(r13, R.id.recycler_view_gift);
        if (r19 == null) goto L25;
        r10 = R.id.recycler_view_image;
        CommonRecyclerView r110 = (CommonRecyclerView) i0.a.a(r13, R.id.recycler_view_image);
        if (r110 == null) goto L25;
        r10 = R.id.recycler_view_recommend;
        CommonRecyclerView r111 = (CommonRecyclerView) i0.a.a(r13, R.id.recycler_view_recommend);
        if (r111 == null) goto L25;
        r10 = R.id.tv_desc;
        TextView r112 = (TextView) i0.a.a(r13, R.id.tv_desc);
        if (r112 == null) goto L25;
        return new o((LinearLayout) r13, r11, r12, r14, r15, r16, r18, r19, r110, r111, r112);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r10)));
    }

    public LinearLayout b() {
        return this.f25708a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
