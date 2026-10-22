package com.bytedance.android.live.liveinteract.interactivesong.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractiveSongMvManager f74142a;

    public b(InteractiveSongMvManager r100) {
        this.f74142a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = System.currentTimeMillis();
        InteractiveSongMvManager r103 = this.f74142a;
        if ((r102 - r103.f74062p) <= r103.f74047a) goto L11;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r104 = r103.f74055i;
        if (r104 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r105 = r104.a();
        if (r105 == null) goto L9;
        r105.pause();
    L9:
        this.f74142a.f74059m = false;
        return;
    }
}
