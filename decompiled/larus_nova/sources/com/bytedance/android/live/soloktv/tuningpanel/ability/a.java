package com.bytedance.android.live.soloktv.tuningpanel.ability;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningCore f101564a;

    public a(SoloKtvTuningCore r100) {
        this.f101564a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f101564a.K(((Boolean) r100).booleanValue());
    }
}
