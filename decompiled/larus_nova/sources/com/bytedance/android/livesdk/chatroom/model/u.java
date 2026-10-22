package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.ChorusAccompanist")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/u;", "", "", "rtcAppId", "Ljava/lang/String;", "getRtcAppId", "()Ljava/lang/String;", "setRtcAppId", "(Ljava/lang/String;)V", "rtcRoomId", "getRtcRoomId", "setRtcRoomId", "rtcUserId", "getRtcUserId", "setRtcUserId", "subRoomId", "getSubRoomId", "setSubRoomId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u implements vh7.h {

    @SerializedName("rtc_app_id")
    protected String rtcAppId;

    @SerializedName("rtc_room_id")
    protected String rtcRoomId;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    @SerializedName("sub_rtc_room_id")
    protected String subRoomId;

    public u() {
        this.rtcAppId = "";
        this.rtcRoomId = "";
        this.rtcUserId = "";
        this.subRoomId = "";
    }

    public u(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.rtcAppId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcRoomId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.rtcUserId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.subRoomId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.rtcAppId != null) goto L22;
        this.rtcAppId = "";
    L22:
        if (this.rtcRoomId != null) goto L25;
        this.rtcRoomId = "";
    L25:
        if (this.rtcUserId != null) goto L28;
        this.rtcUserId = "";
    L28:
        if (this.subRoomId != null) goto L46;
        this.subRoomId = "";
        return;
    }
}
