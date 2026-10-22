package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMidiView f145209a;

    public c(KtvComponentMidiView r100) {
        this.f145209a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        KtvComponentMidiView r101 = this.f145209a;
        if (r101.f145153i == false) goto L8;
        Animator r102 = r101.f145159o;
        if (r102 == null) goto L9;
        r102.start();
        return;
    L9:
        return;
    }
}
