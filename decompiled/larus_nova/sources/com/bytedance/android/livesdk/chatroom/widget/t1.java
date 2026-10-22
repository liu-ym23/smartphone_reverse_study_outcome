package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerVisibilityControllerWidget f119185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f119186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f119187c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        VSPlayerViewControlContext r101 = this.f119185a.f118640o;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r102 = r101.getControlAnimEndEvent();
        if (r102 == null) goto L7;
        r102.post(Boolean.valueOf(this.f119186b));
    L7:
        this.f119187c.removeAllListeners();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        VSPlayerViewControlContext r101 = this.f119185a.f118640o;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r102 = r101.getControlAnimEndEvent();
        if (r102 == null) goto L7;
        r102.post(Boolean.valueOf(this.f119186b));
    L7:
        this.f119187c.removeAllListeners();
    }

    public t1(PlayerVisibilityControllerWidget r100, boolean r101, AnimatorSet r102) {
        this.f119185a = r100;
        this.f119186b = r101;
        this.f119187c = r102;
    }
}
