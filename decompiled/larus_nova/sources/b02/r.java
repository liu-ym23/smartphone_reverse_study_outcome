package b02;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.LiveGiftComboViewNew;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f16850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveGiftComboViewNew f16851b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LiveGiftComboViewNew r101 = this.f16851b;
        r101.f128681e = 2;
        r101.g(this.f16850a);
    }

    public r(LiveGiftComboViewNew r100, com.bytedance.android.livesdk.gift.vs.panel.viewholder.b r101) {
        this.f16851b = r100;
        this.f16850a = r101;
    }
}
