package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentContainerView f17716a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f17717b;

    private i(FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2) {
        this.f17716a = fragmentContainerView;
        this.f17717b = fragmentContainerView2;
    }

    public static i a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view;
        return new i(fragmentContainerView, fragmentContainerView);
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_privacy_settings, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FragmentContainerView b() {
        return this.f17716a;
    }
}
