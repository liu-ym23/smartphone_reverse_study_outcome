package com.bytedance.android.livesdk.interactivity.interactive;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveInteractiveAnnieXHelper f137351a;

    public e(LiveInteractiveAnnieXHelper r100) {
        this.f137351a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L5;
        this.f137351a.p(false);
        return;
    L5:
        if (this.f137351a.c() != true) goto L13;
        LiveInteractiveAnnieXHelper r101 = this.f137351a;
        if (r101.f137028m == 1) goto L9;
        return;
    L9:
        if (r101.f137027l != 0) goto L15;
        r101.s(false);
        return;
    L15:
        return;
    }
}
