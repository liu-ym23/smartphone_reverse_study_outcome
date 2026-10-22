package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.stepos.common.widget.StepOSPAGEmptyLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import i0.C0756a;

/* renamed from: j2.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0780C {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17635a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f17636b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSPAGEmptyLayout f17637c;

    /* renamed from: d, reason: collision with root package name */
    public final MyRecyclerView f17638d;

    private C0780C(FrameLayout frameLayout, LinearLayout linearLayout, StepOSPAGEmptyLayout stepOSPAGEmptyLayout, MyRecyclerView myRecyclerView) {
        this.f17635a = frameLayout;
        this.f17636b = linearLayout;
        this.f17637c = stepOSPAGEmptyLayout;
        this.f17638d = myRecyclerView;
    }

    public static C0780C a(View view) {
        int i5 = R.id.empty_layer;
        LinearLayout linearLayout = (LinearLayout) C0756a.a(view, R.id.empty_layer);
        if (linearLayout != null) {
            i5 = R.id.empty_layout;
            StepOSPAGEmptyLayout stepOSPAGEmptyLayout = (StepOSPAGEmptyLayout) C0756a.a(view, R.id.empty_layout);
            if (stepOSPAGEmptyLayout != null) {
                i5 = R.id.recycler_view;
                MyRecyclerView myRecyclerView = (MyRecyclerView) C0756a.a(view, R.id.recycler_view);
                if (myRecyclerView != null) {
                    return new C0780C((FrameLayout) view, linearLayout, stepOSPAGEmptyLayout, myRecyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0780C c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.us_limit_manager_fragment, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.f17635a;
    }
}
