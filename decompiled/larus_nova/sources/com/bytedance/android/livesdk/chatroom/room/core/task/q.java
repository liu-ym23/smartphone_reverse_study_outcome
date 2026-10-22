package com.bytedance.android.livesdk.chatroom.room.core.task;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f111061a;

    public q(r r100) {
        this.f111061a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        is2.i r102 = this.f111061a.f495588a;
        if (r102 == null) goto L6;
        is2.i.a.a(r102, c.class);
        return;
    }
}
