package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.ValueAnimator;
import android.widget.TextView;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecimalFormat f69978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KtvRoomMidiViewV2 f69979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f69980c;

    public g(DecimalFormat r100, KtvRoomMidiViewV2 r101, boolean r102) {
        this.f69978a = r100;
        this.f69979b = r101;
        this.f69980c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L15;
        float r102 = ((Float) r101).floatValue();
        String r103 = this.f69978a.format(Float.valueOf(r102));
        if (r102 <= 0.0f) goto L7;
    L10:
        TextView r104 = this.f69979b.f69941f;
        if (r104 == null) goto L18;
        r104.setText(r103 + 20998);
        return;
    L18:
        return;
    L7:
        if (r102 == 0.0f) goto L9;
        return;
    L9:
        if (this.f69980c == true) goto L10;
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
