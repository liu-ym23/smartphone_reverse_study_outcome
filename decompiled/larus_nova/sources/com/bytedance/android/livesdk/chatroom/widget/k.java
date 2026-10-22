package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f118832a;

    public k(j r100) {
        this.f118832a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L13;
        float r102 = ((Float) r101).floatValue();
        j r103 = this.f118832a;
        j.b(r103, r103.a(R.id.outer_avatar_frame), r102);
        if (r102 < 0.5f) goto L7;
        j r104 = this.f118832a;
        j.b(r104, r104.a(R.id.outer_avatar_frame2), r102 - 0.5f);
    L8:
        View r105 = this.f118832a.a(R.id.outer_avatar_frame);
        if (r105 == null) goto L14;
        r105.requestLayout();
        return;
    L14:
        return;
    L7:
        j r106 = this.f118832a;
        j.b(r106, r106.a(R.id.outer_avatar_frame2), r102 + 0.5f);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
