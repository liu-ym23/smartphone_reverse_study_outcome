package com.bytedance.android.livesdk.castscreen.guide;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcPlayGuideNew f104507a;

    public i(PadAndPcPlayGuideNew r100) {
        this.f104507a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f104507a.d();
    }
}
