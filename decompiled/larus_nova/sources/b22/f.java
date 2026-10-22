package b22;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftListWidgetNew;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGiftListWidgetNew f16994a;

    public f(VSGiftListWidgetNew r100) {
        this.f16994a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f16994a.f132435f;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }
}
