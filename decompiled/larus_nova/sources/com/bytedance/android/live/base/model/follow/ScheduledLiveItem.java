package com.bytedance.android.live.base.model.follow;

import am3.g;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.ScheduledItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001e\u00102\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00105\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u0011\u00108\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b9\u0010\u0006R\u001e\u0010:\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/base/model/follow/ScheduledLiveItem;", "", "()V", "announcementContent", "", "getAnnouncementContent", "()Ljava/lang/String;", "setAnnouncementContent", "(Ljava/lang/String;)V", "avatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatar", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "followStatus", "", "getFollowStatus", "()Ljava/lang/Long;", "setFollowStatus", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lastFinishTime", "getLastFinishTime", "setLastFinishTime", "nextScheduledTime", "getNextScheduledTime", "setNextScheduledTime", "nickName", "getNickName", "setNickName", "openUserId", "getOpenUserId", "setOpenUserId", "reqFollow", "", "getReqFollow", "()Ljava/lang/Integer;", "setReqFollow", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "scheduledText", "getScheduledText", "setScheduledText", "secUid", "getSecUid", "setSecUid", "secret", "getSecret", "setSecret", "uidStr", "getUidStr", "userId", "getUserId", "()J", "setUserId", "(J)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScheduledLiveItem implements h {

    @SerializedName("announcement_content")
    protected String announcementContent;

    @SerializedName("avatar")
    protected ImageModel avatar;

    @SerializedName("follow_status")
    protected Long followStatus;

    @SerializedName("under_name_text")
    protected String lastFinishTime;

    @SerializedName("right_text")
    protected String nextScheduledTime;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openUserId;

    @SerializedName("req_follow")
    protected Integer reqFollow;

    @SerializedName("room_data")
    protected Room room;

    @SerializedName("scheduled_text")
    protected String scheduledText;

    @SerializedName("sec_uid")
    protected String secUid;

    @SerializedName("secret")
    protected Integer secret;

    @SerializedName("user_id")
    protected long userId;

    public final String getUidStr() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.userId);
        String r102 = this.openUserId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public ScheduledLiveItem() {
        this.lastFinishTime = "";
        this.nextScheduledTime = "";
        this.scheduledText = "";
        this.nickName = "";
        this.secUid = "";
        this.openUserId = "";
    }

    public final String getAnnouncementContent() {
        return this.announcementContent;
    }

    public final ImageModel getAvatar() {
        return this.avatar;
    }

    public final Long getFollowStatus() {
        return this.followStatus;
    }

    public final String getLastFinishTime() {
        return this.lastFinishTime;
    }

    public final String getNextScheduledTime() {
        return this.nextScheduledTime;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenUserId() {
        return this.openUserId;
    }

    public final Integer getReqFollow() {
        return this.reqFollow;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final String getScheduledText() {
        return this.scheduledText;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final Integer getSecret() {
        return this.secret;
    }

    public final long getUserId() {
        return this.userId;
    }

    public ScheduledLiveItem(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        if (r102 != 13) goto L8;
        this.secret = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 14) goto L10;
        this.reqFollow = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this.openUserId = am3.h.c(r100);
        goto L3
    L11:
        switch(r102) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            default: goto L12;
        };
    L17:
        this.scheduledText = am3.h.c(r100);
        goto L3
    L18:
        this.secUid = am3.h.c(r100);
        goto L3
    L19:
        this.nickName = am3.h.c(r100);
        goto L3
    L20:
        this.avatar = x.a(r100);
        goto L3
    L21:
        this.lastFinishTime = am3.h.c(r100);
        goto L3
    L22:
        this.nextScheduledTime = am3.h.c(r100);
        goto L3
    L23:
        this.userId = r100.j();
        goto L3
    L12:
        switch(r102) {
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            default: goto L13;
        };
    L14:
        this.followStatus = Long.valueOf(r100.j());
        goto L3
    L15:
        this.room = new Room(r100);
        goto L3
    L16:
        this.announcementContent = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L27:
        r100.d(r101);
        if (this.lastFinishTime != null) goto L31;
        this.lastFinishTime = "";
    L31:
        if (this.nextScheduledTime != null) goto L34;
        this.nextScheduledTime = "";
    L34:
        if (this.scheduledText != null) goto L37;
        this.scheduledText = "";
    L37:
        if (this.nickName != null) goto L40;
        this.nickName = "";
    L40:
        if (this.secUid != null) goto L43;
        this.secUid = "";
    L43:
        if (this.openUserId != null) goto L80;
        this.openUserId = "";
        return;
    }

    public final void setAnnouncementContent(String r100) {
        this.announcementContent = r100;
    }

    public final void setAvatar(ImageModel r100) {
        this.avatar = r100;
    }

    public final void setFollowStatus(Long r100) {
        this.followStatus = r100;
    }

    public final void setLastFinishTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lastFinishTime = r100;
    }

    public final void setNextScheduledTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nextScheduledTime = r100;
    }

    public final void setNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickName = r100;
    }

    public final void setOpenUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openUserId = r100;
    }

    public final void setReqFollow(Integer r100) {
        this.reqFollow = r100;
    }

    public final void setRoom(Room r100) {
        this.room = r100;
    }

    public final void setScheduledText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scheduledText = r100;
    }

    public final void setSecUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secUid = r100;
    }

    public final void setSecret(Integer r100) {
        this.secret = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }
}
