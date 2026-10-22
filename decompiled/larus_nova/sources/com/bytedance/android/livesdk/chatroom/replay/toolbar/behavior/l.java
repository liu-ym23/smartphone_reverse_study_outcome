package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f110037a;

    public l(m r100) {
        this.f110037a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f110037a.f110038a;
        ALogger.e(r101, "deleteReplay error", (Throwable) r100);
    }
}
