package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.rank.RankEntranceInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RankListHourEnterMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RankEntranceMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "getRankEntranceInfo", "rankEntranceInfo", "", "setRankEntranceInfo", "_rankEntranceInfo", "Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "get_rankEntranceInfo", "()Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "set_rankEntranceInfo", "(Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankEntranceMessage extends o0 implements vh7.h {

    @SerializedName("hour_enter_info")
    protected RankEntranceInfo _rankEntranceInfo;

    public RankEntranceMessage() {
        setType(MessageType.RANK_ENTRANCE);
    }

    public final RankEntranceInfo getRankEntranceInfo() {
        return this._rankEntranceInfo;
    }

    public final RankEntranceInfo get_rankEntranceInfo() {
        return this._rankEntranceInfo;
    }

    public RankEntranceMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._rankEntranceInfo = new RankEntranceInfo(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        setType(MessageType.RANK_ENTRANCE);
    }

    public final void setRankEntranceInfo(RankEntranceInfo r100) {
        this._rankEntranceInfo = r100;
    }

    public final void set_rankEntranceInfo(RankEntranceInfo r100) {
        this._rankEntranceInfo = r100;
    }
}
