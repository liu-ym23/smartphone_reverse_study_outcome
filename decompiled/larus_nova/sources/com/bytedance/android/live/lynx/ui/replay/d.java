package com.bytedance.android.live.lynx.ui.replay;

import com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoViewForLynx f82800a;

    public d(ReplayVideoViewForLynx r100) {
        this.f82800a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IReplayPlayerHelper r102 = this.f82800a.A;
        if (r102 == null) goto L6;
        r102.resolutionDegrade();
        return;
    }
}
