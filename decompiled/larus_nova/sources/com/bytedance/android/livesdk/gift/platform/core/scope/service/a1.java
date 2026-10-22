package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.AIWishGiftRoomScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a1 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f131448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f131449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f131450c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public static Number c() {
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L30;
        IRoom r101 = r100.getRoom();
        if (r101 == null) goto L30;
        LiveMode r102 = r101.getStreamType();
        int r103 = x0.f131837a[r102.ordinal()];
        if (r103 == 1) goto L28;
        if (r103 == 2) goto L26;
        if (r103 == 3) goto L24;
        if (r103 == 4) goto L22;
        if (r103 == 5) goto L20;
        return AIWishGiftRoomScene.Unknown.getValue();
    L20:
        return AIWishGiftRoomScene.Media.getValue();
    L22:
        return AIWishGiftRoomScene.ScreenShot.getValue();
    L24:
        return AIWishGiftRoomScene.External.getValue();
    L26:
        return AIWishGiftRoomScene.Audio.getValue();
    L28:
        return AIWishGiftRoomScene.Video.getValue();
    L30:
        return AIWishGiftRoomScene.Unknown.getValue();
    }

    public final Number a() {
        int r100 = 0;
        Integer r101 = (Integer) this.f131450c.get("data_link_state", 0);
        if (r101 == null) goto L6;
        r100 = r101.intValue();
    L6:
        return Integer.valueOf(((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).Qc().j(r100));
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131448a.dispose();
    }

    public a1(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f131450c = r100;
        this.f131448a = new CompositeDisposable();
    }
}
