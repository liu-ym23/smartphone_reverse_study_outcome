package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvRoomMidiViewV2 f69977a;

    public f(KtvRoomMidiViewV2 r100) {
        this.f69977a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        KtvRoomMidiViewV2 r101 = this.f69977a;
        if (r101.f69953r == false) goto L8;
        Animator r102 = r101.f69946k;
        if (r102 == null) goto L9;
        r102.start();
        return;
    L9:
        return;
    }
}
