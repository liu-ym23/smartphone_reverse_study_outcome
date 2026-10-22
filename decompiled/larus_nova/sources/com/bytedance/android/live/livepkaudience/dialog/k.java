package com.bytedance.android.live.livepkaudience.dialog;

import android.view.animation.Animation;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkAudienceGuestInviteDialog f81828a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public k(PkAudienceGuestInviteDialog r100) {
        this.f81828a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        PkAudienceGuestInviteDialog r101 = this.f81828a;
        Animation r102 = r101.f81656f;
        if (r102 == null) goto L8;
        HSImageView r103 = (HSImageView) r101.S90(R.id.head);
        if (r103 == null) goto L9;
        r103.startAnimation(r102);
        return;
    L9:
        return;
    }
}
