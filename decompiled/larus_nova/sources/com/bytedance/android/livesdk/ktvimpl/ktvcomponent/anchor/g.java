package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f144007a = null;

    static {
        f144007a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("KtvComponentAnchorLogicWidget", "big event updateRealTimeChorusSwitch error: " + ((Throwable) r100).getMessage());
    }
}
