package cd3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcScrollingView f23375a;

    public d(SlcScrollingView r100) {
        this.f23375a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        SlcScrollingView r101 = this.f23375a;
        r101.f173630a = false;
        r101.b(0.0f);
        SlcScrollingView.b r102 = this.f23375a.f173632c;
        if (r102 == null) goto L6;
        r102.a();
        return;
    }
}
