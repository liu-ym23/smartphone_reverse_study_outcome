package aj4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.ugc.aweme.transition.ITransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f3923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ITransition f3924b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TransitionListener r101 = this.f3923a.f3920g;
        if (r101 == null) goto L5;
        r101.onShowEnd();
    L5:
        ITransition r102 = this.f3924b;
        if (r102 == null) goto L9;
        r102.onShowEnd();
        return;
    }

    public l(j r100, ITransition r101) {
        this.f3923a = r100;
        this.f3924b = r101;
    }
}
