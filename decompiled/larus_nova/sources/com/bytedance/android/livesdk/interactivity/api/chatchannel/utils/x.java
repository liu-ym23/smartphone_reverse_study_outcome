package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f133023a;

    public x(Function1 r100) {
        this.f133023a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        RoomChannelData r101 = (RoomChannelData) r100;
        if (r101 != null) goto L5;
    L7:
        this.f133023a.invoke(null);
        return;
    L5:
        if (r101.getStatus() != 1) goto L7;
        this.f133023a.invoke(r101);
    }
}
