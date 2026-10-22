package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EffectLiveCameraActivityProxy f68889a;

    public a(EffectLiveCameraActivityProxy r100) {
        this.f68889a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if ((r100 instanceof com.bytedance.android.live.effect.gesture.a) == false) goto L11;
        EffectLiveCameraActivityProxy r101 = this.f68889a;
        if (r100 == null) goto L10;
        com.bytedance.android.live.effect.gesture.a r102 = (com.bytedance.android.live.effect.gesture.a) r100;
        t r103 = r101.f68884b;
        if (r103 == null) goto L12;
        r103.onEvent(r102);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.gesture.LiveTouchEvent");
    }
}
