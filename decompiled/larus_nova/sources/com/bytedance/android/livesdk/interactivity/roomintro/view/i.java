package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f140730a = null;

    static {
        f140730a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", (Throwable) r100);
    }
}
