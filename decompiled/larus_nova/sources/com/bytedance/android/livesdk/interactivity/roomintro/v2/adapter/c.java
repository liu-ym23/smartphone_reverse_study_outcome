package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f140610a = null;

    static {
        f140610a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("RoomIntroDialogV2", (Throwable) r100);
    }
}
