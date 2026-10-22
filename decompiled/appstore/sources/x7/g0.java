package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f25573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f25574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonRecyclerView f25575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25576e;

    public g0(LinearLayout r10, View r11, View r12, CommonRecyclerView r13, TextView r14) {
        this.f25572a = r10;
        this.f25573b = r11;
        this.f25574c = r12;
        this.f25575d = r13;
        this.f25576e = r14;
    }

    public static g0 a(View r10) {
        int r11 = R.id.divider_2;
        View r12 = i0.a.a(r10, R.id.divider_2);
        if (r12 == null) goto L13;
        r11 = R.id.divider_3;
        View r13 = i0.a.a(r10, R.id.divider_3);
        if (r13 == null) goto L13;
        r11 = R.id.first_recommend_recycler_view;
        CommonRecyclerView r14 = (CommonRecyclerView) i0.a.a(r10, R.id.first_recommend_recycler_view);
        if (r14 == null) goto L13;
        r11 = R.id.tv_desc;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_desc);
        if (r15 == null) goto L13;
        return new g0((LinearLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static g0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_common_first_recommend_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25572a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
