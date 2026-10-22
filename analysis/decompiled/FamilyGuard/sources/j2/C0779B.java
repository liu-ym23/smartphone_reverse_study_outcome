package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.familyguard.R;
import stepos.support.v4.view.ViewPager;

/* renamed from: j2.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0779B {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager f17633a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f17634b;

    private C0779B(ViewPager viewPager, ViewPager viewPager2) {
        this.f17633a = viewPager;
        this.f17634b = viewPager2;
    }

    public static C0779B a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ViewPager viewPager = (ViewPager) view;
        return new C0779B(viewPager, viewPager);
    }

    public static C0779B c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0779B d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.us_limit_manager_activity, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ViewPager b() {
        return this.f17633a;
    }
}
