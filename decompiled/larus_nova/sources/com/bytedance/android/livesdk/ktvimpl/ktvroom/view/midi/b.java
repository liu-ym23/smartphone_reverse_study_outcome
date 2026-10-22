package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMidiView f145208a;

    public b(KtvComponentMidiView r100) {
        this.f145208a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Animator r101 = this.f145208a.f145160p;
        if (r101 == null) goto L6;
        r101.start();
        return;
    }
}
