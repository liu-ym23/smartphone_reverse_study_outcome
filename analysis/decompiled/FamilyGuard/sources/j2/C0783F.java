package j2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.common.widget.PageIndicator;
import com.stepos.familyguard.R;
import i0.C0756a;

/* renamed from: j2.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0783F {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17652a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17653b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f17654c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17655d;

    /* renamed from: e, reason: collision with root package name */
    public final z f17656e;

    /* renamed from: f, reason: collision with root package name */
    public final PageIndicator f17657f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewPager2 f17658g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f17659h;

    private C0783F(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, z zVar, PageIndicator pageIndicator, ViewPager2 viewPager2, TextView textView3) {
        this.f17652a = constraintLayout;
        this.f17653b = textView;
        this.f17654c = linearLayout;
        this.f17655d = textView2;
        this.f17656e = zVar;
        this.f17657f = pageIndicator;
        this.f17658g = viewPager2;
        this.f17659h = textView3;
    }

    public static C0783F a(View view) {
        int i5 = R.id.date;
        TextView textView = (TextView) C0756a.a(view, R.id.date);
        if (textView != null) {
            i5 = R.id.date_container;
            LinearLayout linearLayout = (LinearLayout) C0756a.a(view, R.id.date_container);
            if (linearLayout != null) {
                i5 = R.id.des;
                TextView textView2 = (TextView) C0756a.a(view, R.id.des);
                if (textView2 != null) {
                    i5 = R.id.digit_container;
                    View viewA = C0756a.a(view, R.id.digit_container);
                    if (viewA != null) {
                        z zVarA = z.a(viewA);
                        i5 = R.id.horizontalPageIndicator;
                        PageIndicator pageIndicator = (PageIndicator) C0756a.a(view, R.id.horizontalPageIndicator);
                        if (pageIndicator != null) {
                            i5 = R.id.view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) C0756a.a(view, R.id.view_pager);
                            if (viewPager2 != null) {
                                i5 = R.id.week;
                                TextView textView3 = (TextView) C0756a.a(view, R.id.week);
                                if (textView3 != null) {
                                    return new C0783F((ConstraintLayout) view, textView, linearLayout, textView2, zVarA, pageIndicator, viewPager2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
