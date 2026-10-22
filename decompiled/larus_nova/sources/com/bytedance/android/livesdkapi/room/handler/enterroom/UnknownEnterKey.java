package com.bytedance.android.livesdkapi.room.handler.enterroom;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/UnknownEnterKey;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
final class UnknownEnterKey extends EnterKey {
    public static final UnknownEnterKey INSTANCE = null;

    static {
        INSTANCE = new UnknownEnterKey();
    }

    private UnknownEnterKey() {
        super("Unknown", null);
    }
}
