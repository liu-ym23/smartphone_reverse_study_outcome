package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f114529a;

    public k(i r100) {
        this.f114529a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ALogger.i("CarnivalBinarySeiHandler", "carnival state change. started=" + r101);
        if (r101.booleanValue() == true) goto L6;
        this.f114529a.b();
        return;
    }
}
