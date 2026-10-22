package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CloudCollaborateMemberActionMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/model/d3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "messageType", "Ljava/lang/Integer;", FaceService.neutralLabel, "()Ljava/lang/Integer;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "fromUser", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "", "collaborateRoomId", "Ljava/lang/Long;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/Long;", "inviteId", "G", "joinRoomTime", "getJoinRoomTime", "waitSec", "P", "joinedUserRoomId", "getJoinedUserRoomId", "Lcom/bytedance/android/livesdk/message/model/uk;", "joinedUserRtcInfo", "Lcom/bytedance/android/livesdk/message/model/uk;", "getJoinedUserRtcInfo", "()Lcom/bytedance/android/livesdk/message/model/uk;", "", "rejectReason", "Ljava/lang/String;", "getRejectReason", "()Ljava/lang/String;", "extra", "getExtra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d3 extends o0 implements vh7.h {

    @SerializedName("collaborate_room_id")
    protected Long collaborateRoomId;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("from_user")
    protected IBaseUser fromUser;

    @SerializedName("invite_id")
    protected Long inviteId;

    @SerializedName("join_room_time")
    protected Long joinRoomTime;

    @SerializedName("joined_user_room_id")
    protected Long joinedUserRoomId;

    @SerializedName("joined_user_rtc_info")
    protected uk joinedUserRtcInfo;

    @SerializedName("message_type")
    protected Integer messageType;

    @SerializedName("reject_reason")
    protected String rejectReason;

    @SerializedName("wait_sec")
    protected Long waitSec;

    public static final class a {
    }

    static {
    }

    public d3() {
        this.type = MessageType.CLOUD_GROUP_LIVE_MEMBER_ACTION;
    }

    public final Long E() {
        return this.collaborateRoomId;
    }

    public final Long G() {
        return this.inviteId;
    }

    public final Integer H() {
        return this.messageType;
    }

    public final Long P() {
        return this.waitSec;
    }

    public final IBaseUser getFromUser() {
        return this.fromUser;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public d3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = am3.h.c(r100);
        goto L3
    L8:
        this.rejectReason = am3.h.c(r100);
        goto L3
    L9:
        this.joinedUserRtcInfo = new uk(r100);
        goto L3
    L10:
        this.joinedUserRoomId = Long.valueOf(r100.j());
        goto L3
    L11:
        this.waitSec = Long.valueOf(r100.j());
        goto L3
    L12:
        this.joinRoomTime = Long.valueOf(r100.j());
        goto L3
    L13:
        this.inviteId = Long.valueOf(r100.j());
        goto L3
    L14:
        this.collaborateRoomId = Long.valueOf(r100.j());
        goto L3
    L15:
        this.fromUser = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L16:
        this.messageType = Integer.valueOf((int) r100.j());
        goto L3
    L17:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.CLOUD_GROUP_LIVE_MEMBER_ACTION;
    }
}
