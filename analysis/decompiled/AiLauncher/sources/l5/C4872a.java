package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import s1.C5437a;

/* renamed from: l5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4872a {
    public final LinearLayout homebarGuideCapsule;
    public final LottieAnimationView homebarGuideGlow;
    public final LinearLayout homebarGuideHostBlur;
    public final LottieAnimationView homebarGuideIllustration;
    public final ConstraintLayout homebarGuideRoot;
    public final View homebarGuideScrim;
    public final ImageView homebarGuideStill;
    public final View homebarGuideTapExit;
    public final ImageView homebarGuideThinking;
    private final ConstraintLayout rootView;

    public C4872a(ConstraintLayout constraintLayout, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView2, ConstraintLayout constraintLayout2, View view, ImageView imageView, View view2, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.homebarGuideCapsule = linearLayout;
        this.homebarGuideGlow = lottieAnimationView;
        this.homebarGuideHostBlur = linearLayout2;
        this.homebarGuideIllustration = lottieAnimationView2;
        this.homebarGuideRoot = constraintLayout2;
        this.homebarGuideScrim = view;
        this.homebarGuideStill = imageView;
        this.homebarGuideTapExit = view2;
        this.homebarGuideThinking = imageView2;
    }

    public static C4872a a(View view) {
        View viewA;
        int i10 = R$id.homebarGuideCapsule;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.homebarGuideGlow;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) C5437a.a(view, i10);
            if (lottieAnimationView != null) {
                i10 = R$id.homebarGuideHostBlur;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.homebarGuideIllustration;
                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) C5437a.a(view, i10);
                    if (lottieAnimationView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i10 = R$id.homebarGuideScrim;
                        View viewA2 = C5437a.a(view, i10);
                        if (viewA2 != null) {
                            i10 = R$id.homebarGuideStill;
                            ImageView imageView = (ImageView) C5437a.a(view, i10);
                            if (imageView != null && (viewA = C5437a.a(view, (i10 = R$id.homebarGuideTapExit))) != null) {
                                i10 = R$id.homebarGuideThinking;
                                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                if (imageView2 != null) {
                                    return new C4872a(constraintLayout, linearLayout, lottieAnimationView, linearLayout2, lottieAnimationView2, constraintLayout, viewA2, imageView, viewA, imageView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C4872a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C4872a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_homebar_longpress_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
