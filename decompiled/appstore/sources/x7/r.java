package x7;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.AppItemTitleView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f25738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonRecyclerView f25740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppItemTitleView f25741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25742e;

    public r(NestedScrollView r10, CommonRecyclerView r11, CommonRecyclerView r12, AppItemTitleView r13, TextView r14) {
        this.f25738a = r10;
        this.f25739b = r11;
        this.f25740c = r12;
        this.f25741d = r13;
        this.f25742e = r14;
    }

    public static r a(View r10) {
        int r11 = R.id.recycler_view_recommend;
        CommonRecyclerView r12 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view_recommend);
        if (r12 == null) goto L13;
        r11 = R.id.recycler_view_update;
        CommonRecyclerView r13 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view_update);
        if (r13 == null) goto L13;
        r11 = R.id.title_view;
        AppItemTitleView r14 = (AppItemTitleView) i0.a.a(r10, R.id.title_view);
        if (r14 == null) goto L13;
        r11 = R.id.tv_disk;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_disk);
        if (r15 == null) goto L13;
        return new r((NestedScrollView) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public NestedScrollView b() {
        return this.f25738a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
