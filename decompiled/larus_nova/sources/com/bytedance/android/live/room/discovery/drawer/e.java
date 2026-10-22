package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f99430a = null;

    static {
        f99430a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e(LiveRecyclableWidget.ALOG_TAG_WIDGET, "接口请求失败");
    }
}
