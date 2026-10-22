package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/p2;", "", "", "rtcRoomId", "Ljava/lang/String;", "getRtcRoomId", "()Ljava/lang/String;", "setRtcRoomId", "(Ljava/lang/String;)V", "rtcUserId", "getRtcUserId", "setRtcUserId", "rtcAppId", "getRtcAppId", "setRtcAppId", "mixStreamTaskId", "getMixStreamTaskId", "setMixStreamTaskId", "publicStreamId", "getPublicStreamId", "setPublicStreamId", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p2 implements vh7.h {

    @SerializedName("mix_stream_task_id")
    protected String mixStreamTaskId;

    @SerializedName("public_stream_id")
    protected String publicStreamId;

    @SerializedName("rtc_app_id")
    protected String rtcAppId;

    @SerializedName("rtc_room_id")
    protected String rtcRoomId;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    public p2() {
    }

    public p2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.rtcRoomId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcUserId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.rtcAppId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.mixStreamTaskId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.publicStreamId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
