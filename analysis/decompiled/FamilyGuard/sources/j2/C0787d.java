package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;
import stepos.support.v4.view.ViewPager;

/* renamed from: j2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0787d {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17695a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17696b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f17697c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f17698d;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSTitleBar f17699e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewPager f17700f;

    private C0787d(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, StepOSTitleBar stepOSTitleBar, ViewPager viewPager) {
        this.f17695a = linearLayout;
        this.f17696b = textView;
        this.f17697c = textView2;
        this.f17698d = linearLayout2;
        this.f17699e = stepOSTitleBar;
        this.f17700f = viewPager;
    }

    public static C0787d a(View view) {
        int i5 = R.id.tab_app;
        TextView textView = (TextView) C0756a.a(view, R.id.tab_app);
        if (textView != null) {
            i5 = R.id.tab_category;
            TextView textView2 = (TextView) C0756a.a(view, R.id.tab_category);
            if (textView2 != null) {
                i5 = R.id.tab_row;
                LinearLayout linearLayout = (LinearLayout) C0756a.a(view, R.id.tab_row);
                if (linearLayout != null) {
                    i5 = R.id.title_bar;
                    StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
                    if (stepOSTitleBar != null) {
                        i5 = R.id.view_pager;
                        ViewPager viewPager = (ViewPager) C0756a.a(view, R.id.view_pager);
                        if (viewPager != null) {
                            return new C0787d((LinearLayout) view, textView, textView2, linearLayout, stepOSTitleBar, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0787d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0787d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_limit_manager, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17695a;
    }
}
