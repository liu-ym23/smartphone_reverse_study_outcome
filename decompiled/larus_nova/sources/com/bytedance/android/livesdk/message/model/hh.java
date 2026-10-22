package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InteractOpenRewardMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hh;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "appId", "Ljava/lang/String;", "", "startId", "J", "", "rewardId", "I", "rewardCount", "rewardDiamonds", "rewardName", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hh extends o0 implements vh7.h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName("reward_count")
    public int rewardCount;

    @SerializedName("reward_diamonds")
    public int rewardDiamonds;

    @SerializedName("reward_id")
    public int rewardId;

    @SerializedName("reward_name")
    public String rewardName;

    @SerializedName("start_id")
    public long startId;

    public hh() {
        this.type = MessageType.OPEN_GAME_OPEN_REWARD_MESSAGE;
    }

    public hh(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.rewardName = am3.h.c(r100);
        goto L3
    L8:
        this.rewardDiamonds = r100.i();
        goto L3
    L9:
        this.rewardCount = r100.i();
        goto L3
    L10:
        this.rewardId = r100.i();
        goto L3
    L11:
        this.startId = r100.j();
        goto L3
    L12:
        this.appId = am3.h.c(r100);
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.OPEN_GAME_OPEN_REWARD_MESSAGE;
    }
}
