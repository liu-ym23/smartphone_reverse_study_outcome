package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.animation.Animation;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorLinkMatchInviteFragment f93507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorLinkInfoInviteView f93508b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f93508b.getIvAvatar() != null) goto L5;
        return;
    L5:
        if (this.f93507a.f93385i == null) goto L9;
        this.f93508b.getIvAvatar().startAnimation(this.f93507a.f93385i);
        return;
    }

    public s(AnchorLinkMatchInviteFragment r100, AnchorLinkInfoInviteView r101) {
        this.f93507a = r100;
        this.f93508b = r101;
    }
}
