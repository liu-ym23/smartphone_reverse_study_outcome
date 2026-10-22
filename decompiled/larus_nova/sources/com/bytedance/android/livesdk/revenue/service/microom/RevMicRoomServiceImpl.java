package com.bytedance.android.livesdk.revenue.service.microom;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.revenue.util.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes11.dex */
public final class RevMicRoomServiceImpl extends f<IMicRoomService> implements a {
    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public RevMicRoomServiceImpl() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.microom.a
    public final boolean isLoyalAudience() {
        return k().isLoyalAudience();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.microom.a
    public final boolean isMicRoom(IRoom r100) {
        return k().isMicRoom(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.microom.a
    public final boolean willNext(IRoom r100) {
        return k().willNext(r100);
    }
}
