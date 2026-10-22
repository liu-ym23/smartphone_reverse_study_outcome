package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.animation.Animator;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator f106639a;

    public f(Animator r100) {
        this.f106639a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f106639a.end();
    }
}
