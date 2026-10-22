package bm1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.chatroom.replay.profilecard.ReplayLiveProfileDetailFragment;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLiveProfileDetailFragment f19548a;

    public f(ReplayLiveProfileDetailFragment r100) {
        this.f19548a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f19548a.f109884i.setVisibility(8);
    }
}
