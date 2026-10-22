package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import com.stepos.familyguard.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* renamed from: j2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0791h {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17713a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f17714b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSTitleBar f17715c;

    private C0791h(LinearLayout linearLayout, FragmentContainerView fragmentContainerView, StepOSTitleBar stepOSTitleBar) {
        this.f17713a = linearLayout;
        this.f17714b = fragmentContainerView;
        this.f17715c = stepOSTitleBar;
    }

    public static C0791h a(View view) {
        int i5 = R.id.fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) C0756a.a(view, R.id.fragment_container);
        if (fragmentContainerView != null) {
            i5 = R.id.title_bar;
            StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
            if (stepOSTitleBar != null) {
                return new C0791h((LinearLayout) view, fragmentContainerView, stepOSTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0791h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0791h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_package_limit, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17713a;
    }
}
