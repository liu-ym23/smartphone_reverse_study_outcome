package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17793a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17794b;

    private u(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f17793a = frameLayout;
        this.f17794b = frameLayout2;
    }

    public static u a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new u(frameLayout, frameLayout);
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.mm_limit_manager_search_activity, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.f17793a;
    }
}
