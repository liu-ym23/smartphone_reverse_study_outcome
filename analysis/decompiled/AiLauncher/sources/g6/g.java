package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.stepos.ailauncher.oobe.R$layout;

/* loaded from: classes3.dex */
public final class g {
    public final LottieAnimationView lottieIllustration;
    private final LottieAnimationView rootView;

    public g(LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        this.rootView = lottieAnimationView;
        this.lottieIllustration = lottieAnimationView2;
    }

    public static g a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
        return new g(lottieAnimationView, lottieAnimationView);
    }

    public static g c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_item_wake_anywhere_page, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LottieAnimationView b() {
        return this.rootView;
    }
}
