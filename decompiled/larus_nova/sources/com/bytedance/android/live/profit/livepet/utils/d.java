package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f87923a;

    public d(AnimatorSet r100) {
        this.f87923a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f87923a.cancel();
    }
}
