package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.familyguard.R;

/* renamed from: j2.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0778A {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17631a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17632b;

    private C0778A(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f17631a = frameLayout;
        this.f17632b = frameLayout2;
    }

    public static C0778A a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new C0778A(frameLayout, frameLayout);
    }

    public static C0778A c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0778A d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.us_fragment_activity, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.f17631a;
    }
}
