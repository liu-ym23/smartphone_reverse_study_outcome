package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f109825a;

    public k(f r100) {
        this.f109825a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TextView r101 = f.b(this.f109825a);
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L17;
        r101.setAlpha(((Float) r102).floatValue());
        View r103 = f.a(this.f109825a);
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getVisibility() != 0) goto L18;
        View r104 = f.a(this.f109825a);
        if (r104 == null) goto L19;
        Object r105 = r100.getAnimatedValue();
        if (r105 == null) goto L14;
        r104.setAlpha(((Float) r105).floatValue());
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L19:
        return;
    L18:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
