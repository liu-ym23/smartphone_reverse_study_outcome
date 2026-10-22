package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sh6.b f118291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f118292b;

    public b(sh6.b r100, c r101) {
        this.f118291a = r100;
        this.f118292b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        s22.e r100 = (s22.e) sh6.c.b(this.f118291a);
        if (r100 == null) goto L6;
        r100.removeListener(this.f118292b);
        return;
    }
}
