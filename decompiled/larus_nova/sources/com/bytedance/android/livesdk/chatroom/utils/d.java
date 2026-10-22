package com.bytedance.android.livesdk.chatroom.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements com.bytedance.android.livesdk.chatroom.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f114427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f114428b = null;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final int b(Context r100, Bundle r101, String r102, RoomBaseSession r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        return 3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final void reset() {
    }

    static {
        f114428b = new d();
        f114427a = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final boolean a() {
        return f114427a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final void d(boolean r100) {
        f114427a = r100;
    }
}
