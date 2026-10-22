package com.bytedance.android.live.revlink.impl.player;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f97468a;

    public n(j r100) {
        this.f97468a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        j r102 = this.f97468a;
        if (r102.f97460l.f97438i == true) goto L8;
        wq2.f r103 = r102.E();
        if (r103 == null) goto L9;
        r103.y6();
        return;
    L9:
        return;
    }
}
