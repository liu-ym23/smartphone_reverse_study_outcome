package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.animation.Animator;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator f106638a;

    public e(Animator r100) {
        this.f106638a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Animator r100 = this.f106638a;
        if (r100 == null) goto L6;
        r100.end();
        return;
    }
}
