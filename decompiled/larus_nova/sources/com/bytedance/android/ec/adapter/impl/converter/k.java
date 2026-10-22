package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k extends a<IBaseLiveRoomFunctionHandler, td.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f42787b = null;

    static {
        f42787b = new k();
    }

    public k() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.b c(IBaseLiveRoomFunctionHandler r100) {
        IBaseLiveRoomFunctionHandler r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        return new re.b(r101);
    }
}
