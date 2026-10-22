package j2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.common.widget.PageIndicator;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17664a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17665b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f17666c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17667d;

    /* renamed from: e, reason: collision with root package name */
    public final z f17668e;

    /* renamed from: f, reason: collision with root package name */
    public final PageIndicator f17669f;

    /* renamed from: g, reason: collision with root package name */
    public final Group f17670g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewPager2 f17671h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f17672i;

    private H(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, z zVar, PageIndicator pageIndicator, Group group, ViewPager2 viewPager2, TextView textView3) {
        this.f17664a = constraintLayout;
        this.f17665b = textView;
        this.f17666c = linearLayout;
        this.f17667d = textView2;
        this.f17668e = zVar;
        this.f17669f = pageIndicator;
        this.f17670g = group;
        this.f17671h = viewPager2;
        this.f17672i = textView3;
    }

    public static H a(View view) {
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
                            i5 = R.id.info_group;
                            Group group = (Group) C0756a.a(view, R.id.info_group);
                            if (group != null) {
                                i5 = R.id.view_pager;
                                ViewPager2 viewPager2 = (ViewPager2) C0756a.a(view, R.id.view_pager);
                                if (viewPager2 != null) {
                                    i5 = R.id.week;
                                    TextView textView3 = (TextView) C0756a.a(view, R.id.week);
                                    if (textView3 != null) {
                                        return new H((ConstraintLayout) view, textView, linearLayout, textView2, zVarA, pageIndicator, group, viewPager2, textView3);
                                    }
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
