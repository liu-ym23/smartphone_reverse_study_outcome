package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.BattleFeedBackCardMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u0;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "rivalUid", "Ljava/lang/Long;", "battleId", RemoteMessageConst.Notification.CHANNEL_ID, "", "feedbackCardType", "I", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "feedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "", "RivalOpenId", "Ljava/lang/String;", "getRivalOpenId", "()Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 extends o0 implements vh7.h {

    @SerializedName("rival_open_id")
    protected String RivalOpenId;

    @SerializedName("battle_id")
    public Long battleId;

    @SerializedName("channel_id")
    public Long channelId;

    @SerializedName("feedback_card")
    public FeedbackCard feedbackCard;

    @SerializedName("feedback_card_type")
    public int feedbackCardType;

    @SerializedName("rival_uid")
    public Long rivalUid;

    public u0() {
        this.feedbackCardType = 1;
        this.RivalOpenId = "";
        this.type = MessageType.LINK_MIC_BATTLE_FEEDBACK;
    }

    public u0(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L16;
        if (r103 != 5000) goto L7;
        this.RivalOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this.channelId = Long.valueOf(r100.j());
        goto L3
    L10:
        this.battleId = Long.valueOf(r100.j());
        goto L3
    L11:
        this.feedbackCard = new FeedbackCard(r100);
        goto L3
    L12:
        this.feedbackCardType = r100.i();
        r102 = r102 | true;
        goto L3
    L13:
        this.rivalUid = Long.valueOf(r100.j());
        goto L3
    L14:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if ((r102 & true) == true) goto L20;
        this.feedbackCardType = 1;
    L20:
        if (this.RivalOpenId != null) goto L22;
        this.RivalOpenId = "";
    L22:
        this.type = MessageType.LINK_MIC_BATTLE_FEEDBACK;
    }
}
