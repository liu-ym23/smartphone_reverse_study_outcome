package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.stepos.familyguard.R;
import com.stepos.widget.button.StepOSButton;
import i0.C0756a;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17746a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSButton f17747b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f17748c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17749d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f17750e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f17751f;

    /* renamed from: g, reason: collision with root package name */
    public final Barrier f17752g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f17753h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f17754i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f17755j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f17756k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f17757l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f17758m;

    /* renamed from: n, reason: collision with root package name */
    public final Guideline f17759n;

    /* renamed from: o, reason: collision with root package name */
    public final Guideline f17760o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f17761p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f17762q;

    /* renamed from: r, reason: collision with root package name */
    public final Barrier f17763r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f17764s;

    private o(ConstraintLayout constraintLayout, StepOSButton stepOSButton, TextView textView, TextView textView2, ImageView imageView, TextView textView3, Barrier barrier, TextView textView4, ImageView imageView2, TextView textView5, TextView textView6, ImageView imageView3, TextView textView7, Guideline guideline, Guideline guideline2, TextView textView8, TextView textView9, Barrier barrier2, TextView textView10) {
        this.f17746a = constraintLayout;
        this.f17747b = stepOSButton;
        this.f17748c = textView;
        this.f17749d = textView2;
        this.f17750e = imageView;
        this.f17751f = textView3;
        this.f17752g = barrier;
        this.f17753h = textView4;
        this.f17754i = imageView2;
        this.f17755j = textView5;
        this.f17756k = textView6;
        this.f17757l = imageView3;
        this.f17758m = textView7;
        this.f17759n = guideline;
        this.f17760o = guideline2;
        this.f17761p = textView8;
        this.f17762q = textView9;
        this.f17763r = barrier2;
        this.f17764s = textView10;
    }

    public static o a(View view) {
        int i5 = R.id.btn_try_it_now;
        StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.btn_try_it_now);
        if (stepOSButton != null) {
            i5 = R.id.cancel_btn;
            TextView textView = (TextView) C0756a.a(view, R.id.cancel_btn);
            if (textView != null) {
                i5 = R.id.content_app_des;
                TextView textView2 = (TextView) C0756a.a(view, R.id.content_app_des);
                if (textView2 != null) {
                    i5 = R.id.content_app_icon;
                    ImageView imageView = (ImageView) C0756a.a(view, R.id.content_app_icon);
                    if (imageView != null) {
                        i5 = R.id.content_app_title;
                        TextView textView3 = (TextView) C0756a.a(view, R.id.content_app_title);
                        if (textView3 != null) {
                            i5 = R.id.content_barrier_top;
                            Barrier barrier = (Barrier) C0756a.a(view, R.id.content_barrier_top);
                            if (barrier != null) {
                                i5 = R.id.content_recommend_des;
                                TextView textView4 = (TextView) C0756a.a(view, R.id.content_recommend_des);
                                if (textView4 != null) {
                                    i5 = R.id.content_recommend_icon;
                                    ImageView imageView2 = (ImageView) C0756a.a(view, R.id.content_recommend_icon);
                                    if (imageView2 != null) {
                                        i5 = R.id.content_recommend_title;
                                        TextView textView5 = (TextView) C0756a.a(view, R.id.content_recommend_title);
                                        if (textView5 != null) {
                                            i5 = R.id.content_usage_des;
                                            TextView textView6 = (TextView) C0756a.a(view, R.id.content_usage_des);
                                            if (textView6 != null) {
                                                i5 = R.id.content_usage_icon;
                                                ImageView imageView3 = (ImageView) C0756a.a(view, R.id.content_usage_icon);
                                                if (imageView3 != null) {
                                                    i5 = R.id.content_usage_title;
                                                    TextView textView7 = (TextView) C0756a.a(view, R.id.content_usage_title);
                                                    if (textView7 != null) {
                                                        i5 = R.id.guide_line_end;
                                                        Guideline guideline = (Guideline) C0756a.a(view, R.id.guide_line_end);
                                                        if (guideline != null) {
                                                            i5 = R.id.guide_line_start;
                                                            Guideline guideline2 = (Guideline) C0756a.a(view, R.id.guide_line_start);
                                                            if (guideline2 != null) {
                                                                i5 = R.id.title;
                                                                TextView textView8 = (TextView) C0756a.a(view, R.id.title);
                                                                if (textView8 != null) {
                                                                    i5 = R.id.title_des;
                                                                    TextView textView9 = (TextView) C0756a.a(view, R.id.title_des);
                                                                    if (textView9 != null) {
                                                                        i5 = R.id.title_des_barrier_bottom;
                                                                        Barrier barrier2 = (Barrier) C0756a.a(view, R.id.title_des_barrier_bottom);
                                                                        if (barrier2 != null) {
                                                                            i5 = R.id.tv_instructions_for_minors;
                                                                            TextView textView10 = (TextView) C0756a.a(view, R.id.tv_instructions_for_minors);
                                                                            if (textView10 != null) {
                                                                                return new o((ConstraintLayout) view, stepOSButton, textView, textView2, imageView, textView3, barrier, textView4, imageView2, textView5, textView6, imageView3, textView7, guideline, guideline2, textView8, textView9, barrier2, textView10);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_minor_guide, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f17746a;
    }
}
