package com.bytedance.android.livesdk.chatroom.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class t2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f114635a;

    public t2(SkinLoader$loopLoadImg$2 r100) {
        this.f114635a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a4 r102 = this.f114635a;
        if (r102 == null) goto L6;
        r102.b(SkinLoadResultType.ERROR, "remote error");
        return;
    }
}
