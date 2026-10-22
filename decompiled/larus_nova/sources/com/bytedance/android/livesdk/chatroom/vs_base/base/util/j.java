package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f117939a;

    public j(g r100) {
        this.f117939a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        wr1.b r102 = this.f117939a.f117935c;
        if (r102 == null) goto L7;
        LiveBlurAnimView r103 = r102.getView();
        if (r103 == null) goto L7;
        r103.setVisibility(8);
    L7:
        wr1.b r104 = this.f117939a.f117935c;
        if (r104 == null) goto L11;
        r104.b(1.0f);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        wr1.b r102 = this.f117939a.f117935c;
        if (r102 == null) goto L7;
        LiveBlurAnimView r103 = r102.getView();
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        wr1.b r104 = this.f117939a.f117935c;
        if (r104 == null) goto L11;
        r104.b(1.0f);
        return;
    }
}
