package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l extends a<ILiveRoomMessageHandler, td.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f42788b = null;

    static {
        f42788b = new l();
    }

    public l() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.c c(ILiveRoomMessageHandler r100) {
        ILiveRoomMessageHandler r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        return new re.c(r101);
    }
}
