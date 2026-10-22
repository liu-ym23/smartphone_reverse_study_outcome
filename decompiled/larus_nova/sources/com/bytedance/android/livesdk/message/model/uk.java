package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CloudCollaborateMemberActionMessage.RTCInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/uk;", "", "", "userIdStr", "Ljava/lang/String;", "getUserIdStr", "()Ljava/lang/String;", "rtcUserId", "getRtcUserId", "rtcExtInfo", "getRtcExtInfo", "", "rtcRole", "Ljava/lang/Integer;", "getRtcRole", "()Ljava/lang/Integer;", "userOpenIdStr", "getUserOpenIdStr", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class uk implements vh7.h {

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("rtc_role")
    protected Integer rtcRole;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    @SerializedName("user_id_str")
    protected String userIdStr;

    @SerializedName("user_open_id_str")
    protected String userOpenIdStr;

    public uk() {
    }

    public uk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.userIdStr = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcUserId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.rtcExtInfo = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.rtcRole = Integer.valueOf(r100.i());
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.userOpenIdStr = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
