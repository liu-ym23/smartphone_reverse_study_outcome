package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.room.IMiddlewareRoomService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class f4 {
    @JvmStatic
    public static final com.bytedance.android.live.room.k a() {
        return ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).roomCacheManager();
    }

    static {
    }
}
