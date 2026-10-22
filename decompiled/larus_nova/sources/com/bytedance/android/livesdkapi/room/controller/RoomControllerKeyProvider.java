package com.bytedance.android.livesdkapi.room.controller;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/RoomControllerKeyProvider;", "", "()V", "ROOM_CONTROLLER_UNIQUE_KEY", "", "generateKey", "roomId", "identityCode", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomControllerKeyProvider {
    public static final RoomControllerKeyProvider INSTANCE = null;
    public static final String ROOM_CONTROLLER_UNIQUE_KEY = "room_controller_unique_key";

    private RoomControllerKeyProvider() {
    }

    static {
        INSTANCE = new RoomControllerKeyProvider();
    }

    @JvmStatic
    public static final String generateKey(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        return r100 + "_" + r101;
    }
}
