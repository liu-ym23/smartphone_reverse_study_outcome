package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f140726a = null;

    static {
        f140726a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", (Throwable) r100);
    }
}
