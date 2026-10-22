package com.bytedance.android.gamecp.live_impl.preview;

import com.bytedance.android.gamecp.live_impl.GamePromoteRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {
    public static final boolean b(ILiveRoomControllerProvider.ProviderSource r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPreview");
        if (r100 != ILiveRoomControllerProvider.ProviderSource.PREVIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public static final GamePromoteRoomController a(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        ILiveRoomController r103 = com.bytedance.android.gamecp.live_impl.d.f57892d.b(r100, r101, r102);
        if ((r103 instanceof GamePromoteRoomController) == true) goto L7;
        return null;
    L7:
        return (GamePromoteRoomController) r103;
    }
}
