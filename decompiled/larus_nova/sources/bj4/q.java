package bj4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.creativex.mediaimport.widget.gesture.ScaleGestureLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaleGestureLayout f19234a;

    public q(ScaleGestureLayout r100) {
        this.f19234a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        ScaleGestureLayout r101 = this.f19234a;
        int r102 = ScaleGestureLayout.M;
        r101.k();
        this.f19234a.f204201n.reset();
        ViewCompat.postInvalidateOnAnimation(this.f19234a);
        this.f19234a.f204209v = null;
    }
}
