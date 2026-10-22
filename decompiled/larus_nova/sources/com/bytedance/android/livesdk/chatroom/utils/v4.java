package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v4 implements dq1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f114655a;

    public v4(DataCenter r100) {
        this.f114655a = r100;
    }

    @Override // dq1.f
    public final boolean a(VSCameraInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "targetCamera");
        int r101 = a5.f114406a;
        DataCenter r102 = this.f114655a;
        if (r102 == null) goto L5;
        Boolean r103 = (Boolean) r102.get("data_broadcast_pause_state_new", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L10;
        com.bytedance.android.live.core.utils.f2.c("主播暂时离开，暂时无法切换", 0);
        return true;
    L10:
        return false;
    L5:
        r103 = null;
        goto L7
    }
}
