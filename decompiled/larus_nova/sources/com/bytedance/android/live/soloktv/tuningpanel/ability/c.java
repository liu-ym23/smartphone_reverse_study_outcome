package com.bytedance.android.live.soloktv.tuningpanel.ability;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningCore f101566a;

    public c(SoloKtvTuningCore r100) {
        this.f101566a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SoloKtvTuningCore r101 = this.f101566a;
        boolean r102 = ((Boolean) r100).booleanValue();
        r101.f101548b.f101558b.setValue(Boolean.valueOf(r102));
    }
}
