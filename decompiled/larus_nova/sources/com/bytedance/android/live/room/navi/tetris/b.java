package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.utils.g7;
import io.reactivex.functions.Consumer;
import zg1.q3;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorRoomNavigatorTetris f99757a;

    public b(AnchorRoomNavigatorTetris r100) {
        this.f99757a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((q3) r100) == null) goto L5;
        boolean r101 = g7.f158964a;
        g7.a(this.f99757a.L());
        return;
    L5:
        boolean r102 = g7.f158964a;
        g7.b(this.f99757a.L());
    }
}
