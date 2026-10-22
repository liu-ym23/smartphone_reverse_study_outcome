package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.util.Log;
import com.bytedance.android.livesdk.livecommerce.event.ECEventV3;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends ECEventV3 {
    public c() {
        super("ec_controller_invoke");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final void k() {
        f("c_current_room_id", ControllerCenter.f151392c);
        LiveRoomProvider r100 = LiveRoomProvider.f151380h;
        f("c_cache_snapshot", LiveRoomProvider.a());
        f("c_provider_snapshot", r100.f());
        f("c_process_snapshot", LiveRoomProvider.e());
        f("c_invoke_stack", Log.getStackTraceString(new Throwable()));
        super.k();
    }

    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        f("c_what", r100);
    }
}
