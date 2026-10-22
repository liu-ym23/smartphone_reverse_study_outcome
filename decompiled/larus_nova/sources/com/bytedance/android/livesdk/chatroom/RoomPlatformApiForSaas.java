package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/RoomPlatformApiForSaas;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/chatroom/end/b;", "getAudienceEndFragment", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomPlatformApiForSaas implements IService {
    public static final a Companion = null;
    private static RoomPlatformApiForSaas impl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RoomPlatformApiForSaas() {
    }

    public com.bytedance.android.livesdk.chatroom.end.b getAudienceEndFragment() {
        return null;
    }

    public static final /* synthetic */ RoomPlatformApiForSaas access$getImpl$cp() {
        return impl;
    }

    public static final /* synthetic */ void access$setImpl$cp(RoomPlatformApiForSaas r100) {
        impl = r100;
    }
}
