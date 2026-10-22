package com.bytedance.android.livesdk.livecommerce.room.controller;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f151697a;

    public n(qk2.c.a r100) {
        this.f151697a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        xi2.k r101 = (xi2.k) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        if (r101.statusCode != 0) goto L7;
        v0 r102 = this.f151697a;
        if (r102 == null) goto L11;
        r102.onSuccess(r101);
        return;
    L11:
        return;
    L7:
        v0 r103 = this.f151697a;
        if (r103 == null) goto L13;
        r103.onError(null);
        return;
    }
}
