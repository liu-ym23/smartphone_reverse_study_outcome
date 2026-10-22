package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends a<ILiveRoomViewHandler, td.d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f42790b = null;

    static {
        f42790b = new n();
    }

    public n() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.d c(ILiveRoomViewHandler r100) {
        ILiveRoomViewHandler r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        return new re.d(r101);
    }
}
