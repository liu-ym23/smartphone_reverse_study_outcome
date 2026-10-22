package com.bytedance.android.livesdk.chatroom.replay.commerce;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayECProductWidget f108281a;

    public a(ReplayECProductWidget r100) {
        this.f108281a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r101 = this.f108281a.f108279f;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(MapController.ITEM_LAYER_TAG);
    L6:
        r101.a();
    L8:
        return this.f108281a.f108280g;
    }
}
