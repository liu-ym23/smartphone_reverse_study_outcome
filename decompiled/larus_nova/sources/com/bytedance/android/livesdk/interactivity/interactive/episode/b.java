package com.bytedance.android.livesdk.interactivity.interactive.episode;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EpisodeInteractiveDialog f137400a;

    public b(EpisodeInteractiveDialog r100) {
        this.f137400a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        EpisodeInteractiveDialog r102 = this.f137400a;
        int r103 = EpisodeInteractiveDialog.f137368l;
        r102.b();
    }
}
