package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback f143513a;

    public r(KSongViceSingerTuningButtonOuterCallback r100) {
        this.f143513a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        cb0.b r101 = (cb0.b) r100;
        this.f143513a.h();
    }
}
