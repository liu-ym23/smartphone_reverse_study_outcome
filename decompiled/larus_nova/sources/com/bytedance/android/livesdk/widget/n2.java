package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class n2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f161870a = null;

    static {
        f161870a = new n2();
    }

    public n2() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L5;
        String r102 = com.bytedance.android.livesdk.utils.o1.a(r101);
    L6:
        ALogger.e("ScreenShotShareDialog", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
