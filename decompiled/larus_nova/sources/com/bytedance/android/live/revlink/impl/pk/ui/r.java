package com.bytedance.android.live.revlink.impl.pk.ui;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkRandomView f97060a;

    public r(PkRandomView r100) {
        this.f97060a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TextView r101 = (TextView) this.f97060a.f97006c.findViewById(R.id.btn_start);
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L11;
        r101.setScaleX(((Float) r102).floatValue());
        TextView r103 = (TextView) this.f97060a.f97006c.findViewById(R.id.btn_start);
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L9;
        r103.setScaleY(((Float) r104).floatValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
