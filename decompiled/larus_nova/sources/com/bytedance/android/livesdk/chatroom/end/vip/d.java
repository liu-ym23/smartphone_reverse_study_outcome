package com.bytedance.android.livesdk.chatroom.end.vip;

import android.animation.ValueAnimator;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f106141a;

    public d(ValueAnimator r100) {
        this.f106141a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f106141a.cancel();
    }
}
