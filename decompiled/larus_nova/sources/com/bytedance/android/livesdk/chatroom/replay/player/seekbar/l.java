package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f109748a = null;

    static {
        f109748a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ReplaySeekBar", "checkImageCustomMarks:" + ((Throwable) r100));
    }
}
