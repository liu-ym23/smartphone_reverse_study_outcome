package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.animation.ObjectAnimator;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarInteractPlayControlBehavior f61371a;

    public d(ToolbarInteractPlayControlBehavior r100) {
        this.f61371a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ObjectAnimator r102 = this.f61371a.f61339c;
        if (r102 == null) goto L6;
        r102.start();
        return;
    }
}
