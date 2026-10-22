package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f160017a = null;

    static {
        f160017a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("MatchRoomLandScapeAnimUtil.mStateSubject ERROR ");
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r102.append(r103);
        ALogger.i("LiveMultiTab", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
