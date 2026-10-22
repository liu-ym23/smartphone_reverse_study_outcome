package com.bytedance.android.livesdk.interactivity.interactive.episode;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EpisodeInteractiveDialog f137399a;

    public a(EpisodeInteractiveDialog r100) {
        this.f137399a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        EpisodeInteractiveDialog r102 = this.f137399a;
        int r103 = EpisodeInteractiveDialog.f137368l;
        r102.b();
    }
}
