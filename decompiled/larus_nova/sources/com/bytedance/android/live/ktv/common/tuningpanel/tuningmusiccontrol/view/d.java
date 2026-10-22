package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningMusicControlContainer f70563a;

    public d(TuningMusicControlContainer r100) {
        this.f70563a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        fd2.a r101 = (fd2.a) r100;
        if ((r101 instanceof fd2.a.b) == false) goto L5;
    L8:
        TuningMusicControlContainer r102 = this.f70563a;
        int r103 = TuningMusicControlContainer.f70546n;
        r102.R5();
        return;
    L5:
        if ((r101 instanceof fd2.a.c) == true) goto L8;
        if ((r101 instanceof fd2.a.d) == true) goto L8;
    }
}
