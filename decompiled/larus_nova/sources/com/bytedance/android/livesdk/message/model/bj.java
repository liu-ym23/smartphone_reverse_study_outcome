package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bN\u0010OR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010,\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R$\u0010/\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR$\u00102\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR$\u00105\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR$\u00108\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR$\u0010;\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001a\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR$\u0010>\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001a\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001a\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001eR$\u0010K\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010\u001e¨\u0006P"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/bj;", "", "", "commentId", "J", "getCommentId", "()J", "setCommentId", "(J)V", "playId", "getPlayId", "setPlayId", "roomId", "getRoomId", "setRoomId", "userId", "getUserId", "setUserId", "anchorId", "getAnchorId", "setAnchorId", "giftId", "getGiftId", "setGiftId", "", "giftOrderId", "Ljava/lang/String;", "getGiftOrderId", "()Ljava/lang/String;", "setGiftOrderId", "(Ljava/lang/String;)V", "reviewId", "getReviewId", "setReviewId", "", "anonymousType", "I", "getAnonymousType", "()I", "setAnonymousType", "(I)V", "content", "getContent", "setContent", "status", "getStatus", "setStatus", "submitTime", "getSubmitTime", "setSubmitTime", "reviewSubmitTime", "getReviewSubmitTime", "setReviewSubmitTime", "reviewFinishTime", "getReviewFinishTime", "setReviewFinishTime", "createTime", "getCreateTime", "setCreateTime", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "extra", "getExtra", "setExtra", "Lcom/bytedance/android/live/base/model/user/User;", "userInfo", "Lcom/bytedance/android/live/base/model/user/User;", "getUserInfo", "()Lcom/bytedance/android/live/base/model/user/User;", "setUserInfo", "(Lcom/bytedance/android/live/base/model/user/User;)V", "userOpenId", "getUserOpenId", "setUserOpenId", "anchorOpenId", "getAnchorOpenId", "setAnchorOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class bj implements vh7.h {

    @SerializedName("anchor_id")
    protected long anchorId;

    @SerializedName("anchor_open_id")
    protected String anchorOpenId;

    @SerializedName("anonymous_type")
    protected int anonymousType;

    @SerializedName("comment_id")
    protected long commentId;

    @SerializedName("content")
    protected String content;

    @SerializedName("create_time")
    protected String createTime;

    @SerializedName("extra")
    protected String extra;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long giftId;

    @SerializedName("gift_order_id")
    protected String giftOrderId;

    @SerializedName(InstantPlayContext.PLAY_ID)
    protected long playId;

    @SerializedName("review_finish_time")
    protected String reviewFinishTime;

    @SerializedName("review_id")
    protected String reviewId;

    @SerializedName("review_submit_time")
    protected String reviewSubmitTime;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("status")
    protected int status;

    @SerializedName("submit_time")
    protected String submitTime;

    @SerializedName("update_time")
    protected String updateTime;

    @SerializedName("user_id")
    protected long userId;

    @SerializedName("user_info")
    protected User userInfo;

    @SerializedName("user_open_id")
    protected String userOpenId;

    public bj() {
    }

    public bj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L33;
        if (r102 != 100) goto L8;
        this.userInfo = new User(r100);
        goto L3
    L8:
        if (r102 != 5000) goto L10;
        this.userOpenId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 5001) goto L11;
        this.anchorOpenId = am3.h.c(r100);
        goto L3
    L11:
        switch(r102) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            default: goto L12;
        };
    L13:
        this.extra = am3.h.c(r100);
        goto L3
    L14:
        this.updateTime = am3.h.c(r100);
        goto L3
    L15:
        this.createTime = am3.h.c(r100);
        goto L3
    L16:
        this.reviewFinishTime = am3.h.c(r100);
        goto L3
    L17:
        this.reviewSubmitTime = am3.h.c(r100);
        goto L3
    L18:
        this.submitTime = am3.h.c(r100);
        goto L3
    L19:
        this.status = r100.i();
        goto L3
    L20:
        this.content = am3.h.c(r100);
        goto L3
    L21:
        this.anonymousType = r100.i();
        goto L3
    L22:
        this.reviewId = am3.h.c(r100);
        goto L3
    L23:
        this.giftOrderId = am3.h.c(r100);
        goto L3
    L24:
        this.giftId = r100.j();
        goto L3
    L25:
        this.anchorId = r100.j();
        goto L3
    L26:
        this.userId = r100.j();
        goto L3
    L27:
        this.roomId = r100.j();
        goto L3
    L28:
        this.playId = r100.j();
        goto L3
    L29:
        this.commentId = r100.j();
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L33:
        r100.d(r101);
    }
}
