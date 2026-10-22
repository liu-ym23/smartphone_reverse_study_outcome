package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t1 extends ECEventV3 {
    public t1() {
        Intrinsics.checkNotNullParameter("livesdk_ec_room_enter", "eventName");
        super("livesdk_ec_room_enter", 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final void k() {
        f("source_page", i("enter_from_merge") + "_temai_" + i("enter_method"));
        super.k();
    }
}
