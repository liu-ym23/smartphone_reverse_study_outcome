package b02;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.GroupWaveAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupWaveAnimationView f16838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f16839b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f16838a.removeView(this.f16839b);
    }

    public j(GroupWaveAnimationView r100, View r101) {
        this.f16838a = r100;
        this.f16839b = r101;
    }
}
