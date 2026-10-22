package com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends AnimatorListenerAdapter {
    public a() {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        xs2.b.a().post(new s(false));
    }
}
