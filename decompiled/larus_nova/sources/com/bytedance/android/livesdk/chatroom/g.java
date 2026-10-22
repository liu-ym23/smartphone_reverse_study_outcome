package com.bytedance.android.livesdk.chatroom;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f106247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f106248b = null;

    public g() {
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
        f106248b = new g();
        f106247a = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final boolean a() {
        return f106247a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.i
    public final void d(boolean r100) {
        f106247a = r100;
    }
}
