package com.bytedance.android.livesdk.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/EnlargeGuestCloseResponse;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EnlargeGuestCloseResponse implements vh7.h {
    public EnlargeGuestCloseResponse() {
    }

    public EnlargeGuestCloseResponse(am3.g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }
}
