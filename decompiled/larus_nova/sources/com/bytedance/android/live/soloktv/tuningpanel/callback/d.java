package com.bytedance.android.live.soloktv.tuningpanel.callback;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningButtonOuterCallback f101574a;

    public d(SoloKtvTuningButtonOuterCallback r100) {
        this.f101574a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        cb0.b r101 = (cb0.b) r100;
        this.f101574a.h();
    }
}
