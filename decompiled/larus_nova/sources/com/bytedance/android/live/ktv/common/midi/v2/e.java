package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvRoomMidiViewV2 f69976a;

    public e(KtvRoomMidiViewV2 r100) {
        this.f69976a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Animator r101 = this.f69976a.f69947l;
        if (r101 == null) goto L6;
        r101.start();
        return;
    }
}
