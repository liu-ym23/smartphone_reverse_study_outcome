package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.widget.button.StepOSButton;
import i0.C0756a;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17765a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17766b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f17767c;

    /* renamed from: d, reason: collision with root package name */
    public final StepOSButton f17768d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f17769e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f17770f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f17771g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f17772h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f17773i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f17774j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f17775k;

    private p(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, StepOSButton stepOSButton, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2) {
        this.f17765a = linearLayout;
        this.f17766b = imageView;
        this.f17767c = frameLayout;
        this.f17768d = stepOSButton;
        this.f17769e = frameLayout2;
        this.f17770f = frameLayout3;
        this.f17771g = frameLayout4;
        this.f17772h = linearLayout2;
        this.f17773i = linearLayout3;
        this.f17774j = textView;
        this.f17775k = textView2;
    }

    public static p a(View view) {
        int i5 = R.id.avatar;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.avatar);
        if (imageView != null) {
            i5 = R.id.btn_switch;
            FrameLayout frameLayout = (FrameLayout) C0756a.a(view, R.id.btn_switch);
            if (frameLayout != null) {
                i5 = R.id.btn_turn_off;
                StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.btn_turn_off);
                if (stepOSButton != null) {
                    i5 = R.id.layout_app_manage;
                    FrameLayout frameLayout2 = (FrameLayout) C0756a.a(view, R.id.layout_app_manage);
                    if (frameLayout2 != null) {
                        i5 = R.id.layout_use_duration;
                        FrameLayout frameLayout3 = (FrameLayout) C0756a.a(view, R.id.layout_use_duration);
                        if (frameLayout3 != null) {
                            i5 = R.id.layout_whitelist;
                            FrameLayout frameLayout4 = (FrameLayout) C0756a.a(view, R.id.layout_whitelist);
                            if (frameLayout4 != null) {
                                i5 = R.id.ll_minor;
                                LinearLayout linearLayout = (LinearLayout) C0756a.a(view, R.id.ll_minor);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view;
                                    i5 = R.id.txt_age;
                                    TextView textView = (TextView) C0756a.a(view, R.id.txt_age);
                                    if (textView != null) {
                                        i5 = R.id.txt_name;
                                        TextView textView2 = (TextView) C0756a.a(view, R.id.txt_name);
                                        if (textView2 != null) {
                                            return new p(linearLayout2, imageView, frameLayout, stepOSButton, frameLayout2, frameLayout3, frameLayout4, linearLayout, linearLayout2, textView, textView2);
                                        }
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

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_minor_main, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17765a;
    }
}
