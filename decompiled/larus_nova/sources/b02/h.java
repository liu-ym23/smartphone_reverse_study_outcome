package b02;

import android.animation.Animator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboProgressAnimationView f16834a;

    public h(ComboProgressAnimationView r100) {
        this.f16834a = r100;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ComboProgressAnimationView r101 = this.f16834a;
        int r102 = ComboProgressAnimationView.f128638x;
        r101.n();
        this.f16834a.m(1800);
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ConstraintLayout r101 = (ConstraintLayout) this.f16834a.a(R.id.combo_progress_bar_container);
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }
}
