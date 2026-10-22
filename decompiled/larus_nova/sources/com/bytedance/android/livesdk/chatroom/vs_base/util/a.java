package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f118188a;

    public a(Function1 r100) {
        this.f118188a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.util.d, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f118188a.invoke(r100);
    }
}
