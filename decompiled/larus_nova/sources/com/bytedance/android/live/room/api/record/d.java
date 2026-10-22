package com.bytedance.android.live.room.api.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecordMonitorServiceWidget f99103a;

    public d(LiveRecordMonitorServiceWidget r100) {
        this.f99103a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f99103a.f99082a;
        ALogger.e(r101, "publish error", (Throwable) r100);
    }
}
