package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.livesdk.chatroom.RoomPlatformApiForSaas;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/RoomPlatformImplForSaas;", "Lcom/bytedance/android/livesdk/chatroom/RoomPlatformApiForSaas;", "Lcom/bytedance/android/livesdk/chatroom/end/b;", "getAudienceEndFragment", "<init>", "()V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomPlatformImplForSaas extends RoomPlatformApiForSaas {
    @Override // com.bytedance.android.livesdk.chatroom.RoomPlatformApiForSaas
    public b getAudienceEndFragment() {
        return new LiveAudienceEndFragment();
    }

    public RoomPlatformImplForSaas() {
    }
}
