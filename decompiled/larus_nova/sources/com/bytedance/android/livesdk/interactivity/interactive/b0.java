package com.bytedance.android.livesdk.interactivity.interactive;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveInteractiveHelper f137162a;

    public b0(LiveInteractiveHelper r100) {
        this.f137162a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L5;
        this.f137162a.p(false);
        return;
    L5:
        if (this.f137162a.c() != true) goto L13;
        LiveInteractiveHelper r101 = this.f137162a;
        if (r101.f137090k == 1) goto L9;
        return;
    L9:
        if (r101.f137089j != 0) goto L15;
        r101.s(false);
        return;
    L15:
        return;
    }
}
