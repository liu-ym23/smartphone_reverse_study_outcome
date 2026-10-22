package com.bytedance.android.livesdk.chatroom.tetris.row3;

import com.bytedance.android.livesdk.utils.g7;
import io.reactivex.functions.Consumer;
import zg1.q3;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongTouchTetris f111838a;

    public d(LongTouchTetris r100) {
        this.f111838a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((q3) r100) == null) goto L5;
        boolean r101 = g7.f158964a;
        g7.a(this.f111838a.L());
        return;
    L5:
        boolean r102 = g7.f158964a;
        g7.b(this.f111838a.L());
    }
}
