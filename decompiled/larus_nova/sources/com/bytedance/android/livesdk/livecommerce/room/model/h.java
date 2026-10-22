package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.livesdkapi.room.state.RoomState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h {
    public static final boolean a(com.bytedance.android.ec.adapter.api.state.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isClickEnter");
        return !r100.f42699n.getBoolean(RoomState.EXTRA_BOOL_SLIDED_IN_VIEW_PAGER);
    }
}
