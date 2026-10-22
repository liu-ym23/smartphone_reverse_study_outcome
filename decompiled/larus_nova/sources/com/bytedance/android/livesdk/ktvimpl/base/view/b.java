package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvAnchorLyricsDisplayView f143647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f143648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f143649c;

    public b(KtvAudienceLyricsDisplayView r100, Ref.IntRef r101, Ref.IntRef r102) {
        this.f143647a = r100;
        this.f143648b = r101;
        this.f143649c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f143647a.I = true;
        Ref.IntRef r101 = this.f143648b;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L10;
        r101.element = ((Integer) r102).intValue();
        Ref.IntRef r103 = this.f143649c;
        int r104 = r103.element;
        Ref.IntRef r105 = this.f143648b;
        int r106 = r105.element;
        if (r104 != r106) goto L7;
        return;
    L7:
        r103.element = r106;
        KtvAnchorLyricsDisplayView r107 = this.f143647a;
        r107.f143595q = r105.element;
        r107.invalidate();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
