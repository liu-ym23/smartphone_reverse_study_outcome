package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f100916a = null;

    static {
        f100916a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("observeFollowStatusChange error: ");
        if (r101 == null) goto L5;
        String r103 = r101.getMessage();
    L6:
        r102.append(r103);
        ALogger.e("PreRequestManager", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
