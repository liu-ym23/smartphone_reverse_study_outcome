package com.bytedance.android.livesdk.chatroom.progressbar.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f107879a = null;

    static {
        f107879a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("VSSeekBar", "checkImageCustomMarks:" + ((Throwable) r100));
    }
}
