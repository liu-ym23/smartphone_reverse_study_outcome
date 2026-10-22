package x7;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f25776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowLayout f25777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowLayout f25778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f25779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f25780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f25781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f25782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommonRecyclerView f25783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommonRecyclerView f25784i;

    public w(NestedScrollView r10, FlowLayout r11, FlowLayout r12, ImageView r13, View r14, View r15, LinearLayout r16, CommonRecyclerView r17, CommonRecyclerView r18) {
        this.f25776a = r10;
        this.f25777b = r11;
        this.f25778c = r12;
        this.f25779d = r13;
        this.f25780e = r14;
        this.f25781f = r15;
        this.f25782g = r16;
        this.f25783h = r17;
        this.f25784i = r18;
    }

    public static w a(View r12) {
        int r10 = R.id.fl_hot_keyword;
        FlowLayout r11 = (FlowLayout) i0.a.a(r12, R.id.fl_hot_keyword);
        if (r11 == null) goto L21;
        r10 = R.id.fl_search_history;
        FlowLayout r13 = (FlowLayout) i0.a.a(r12, R.id.fl_search_history);
        if (r13 == null) goto L21;
        r10 = R.id.iv_history_clear;
        ImageView r14 = (ImageView) i0.a.a(r12, R.id.iv_history_clear);
        if (r14 == null) goto L21;
        r10 = R.id.line_view_1;
        View r15 = i0.a.a(r12, R.id.line_view_1);
        if (r15 == null) goto L21;
        r10 = R.id.line_view_2;
        View r16 = i0.a.a(r12, R.id.line_view_2);
        if (r16 == null) goto L21;
        r10 = R.id.ll_search_history_container;
        LinearLayout r17 = (LinearLayout) i0.a.a(r12, R.id.ll_search_history_container);
        if (r17 == null) goto L21;
        r10 = R.id.recycler_view_hot_app;
        CommonRecyclerView r18 = (CommonRecyclerView) i0.a.a(r12, R.id.recycler_view_hot_app);
        if (r18 == null) goto L21;
        r10 = R.id.recycler_view_recommend;
        CommonRecyclerView r19 = (CommonRecyclerView) i0.a.a(r12, R.id.recycler_view_recommend);
        if (r19 == null) goto L21;
        return new w((NestedScrollView) r12, r11, r13, r14, r15, r16, r17, r18, r19);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r10)));
    }

    public NestedScrollView b() {
        return this.f25776a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
