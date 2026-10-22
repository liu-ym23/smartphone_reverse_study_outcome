package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVisibilityControlWidget f118796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f118797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f118798c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LiveVisibilityControlContext r101 = this.f118796a.f118569p;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r102 = r101.getControlAnimEndEvent();
        if (r102 == null) goto L7;
        r102.post(Boolean.valueOf(this.f118797b));
    L7:
        this.f118798c.removeAllListeners();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LiveVisibilityControlContext r101 = this.f118796a.f118569p;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r102 = r101.getControlAnimEndEvent();
        if (r102 == null) goto L7;
        r102.post(Boolean.valueOf(this.f118797b));
    L7:
        this.f118798c.removeAllListeners();
    }

    public f1(LiveVisibilityControlWidget r100, boolean r101, AnimatorSet r102) {
        this.f118796a = r100;
        this.f118797b = r101;
        this.f118798c = r102;
    }
}
