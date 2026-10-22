package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.stepos.familyguard.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* renamed from: j2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0788e {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17701a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17702b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSTitleBar f17703c;

    private C0788e(LinearLayout linearLayout, FrameLayout frameLayout, StepOSTitleBar stepOSTitleBar) {
        this.f17701a = linearLayout;
        this.f17702b = frameLayout;
        this.f17703c = stepOSTitleBar;
    }

    public static C0788e a(View view) {
        int i5 = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) C0756a.a(view, R.id.fragment_container);
        if (frameLayout != null) {
            i5 = R.id.title_bar;
            StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
            if (stepOSTitleBar != null) {
                return new C0788e((LinearLayout) view, frameLayout, stepOSTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0788e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0788e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_minor_main, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17701a;
    }
}
