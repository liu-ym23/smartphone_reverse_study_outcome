package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.VSCameraChangeEvent;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x4 extends dq1.e {
    public x4() {
    }

    @Override // dq1.e
    public final void a(VSCameraInfo r100, VSCameraInfo r110, Bundle r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "targetCamera");
        int r101 = a5.f114406a;
        if (r100 == null) goto L7;
        VSJumpCameraEvent.Companion r102 = VSJumpCameraEvent.Companion;
        VSJumpCameraEvent r103 = VSJumpCameraEvent.Companion.createEvent$default(r102, r100, null, false, null, 14, null);
        VSJumpCameraEvent r114 = r102.createEvent(r110, r111, r112, r113);
        xs2.b.a().post(new VSCameraChangeEvent(r103, r114));
        return;
    }
}
