package x7;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.AppGradeView;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppGradeView f25701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonRecyclerView f25703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemHorizontalView f25704e;

    public n(LinearLayout r10, AppGradeView r11, View r12, CommonRecyclerView r13, ItemHorizontalView r14) {
        this.f25700a = r10;
        this.f25701b = r11;
        this.f25702c = r12;
        this.f25703d = r13;
        this.f25704e = r14;
    }

    public static n a(View r10) {
        int r11 = R.id.grade_view;
        AppGradeView r12 = (AppGradeView) i0.a.a(r10, R.id.grade_view);
        if (r12 == null) goto L13;
        r11 = R.id.line_view;
        View r13 = i0.a.a(r10, R.id.line_view);
        if (r13 == null) goto L13;
        r11 = R.id.recycler_view;
        CommonRecyclerView r14 = (CommonRecyclerView) i0.a.a(r10, R.id.recycler_view);
        if (r14 == null) goto L13;
        r11 = R.id.tv_app_item_view;
        ItemHorizontalView r15 = (ItemHorizontalView) i0.a.a(r10, R.id.tv_app_item_view);
        if (r15 == null) goto L13;
        return new n((LinearLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f25700a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
