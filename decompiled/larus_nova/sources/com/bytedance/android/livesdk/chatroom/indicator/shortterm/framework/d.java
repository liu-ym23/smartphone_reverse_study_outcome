package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.animation.Animator;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator f106637a;

    public d(Animator r100) {
        this.f106637a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f106637a.end();
    }
}
