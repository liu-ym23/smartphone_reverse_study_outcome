package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f110856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f110857b;

    public s(Consumer r100, long r101) {
        this.f110856a = r100;
        this.f110857b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f110856a.accept(null);
        ALogger.i("observeDataV2", "isEventOptimize false accept null room_id" + this.f110857b);
    }
}
