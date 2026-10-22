package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ud;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "hot", "J", "getHot", "()J", "setHot", "(J)V", "rank", "getRank", "setRank", "singer", "getSinger", "setSinger", "getSinger$annotations", "()V", "", "singerOpenId", "Ljava/lang/String;", "getSingerOpenId", "()Ljava/lang/String;", "setSingerOpenId", "(Ljava/lang/String;)V", "getSingerOpenId$annotations", "<init>", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ud extends o0 implements vh7.h {

    @SerializedName("hot")
    protected long hot;

    @SerializedName("rank")
    protected long rank;

    @IgnoreProtoFieldCheck
    @SerializedName("singer")
    protected long singer;

    @IgnoreProtoFieldCheck
    @SerializedName("singer_open_id")
    protected String singerOpenId;

    public ud() {
        this.singerOpenId = "";
        this.type = MessageType.KTV_WEEKLY_SINGING_HOT_RANK_POS_MESSAGE;
    }

    public final long getRank() {
        return this.rank;
    }

    public ud(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hot = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.rank = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.singer = r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.singerOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.singerOpenId != null) goto L24;
        this.singerOpenId = "";
    L24:
        this.type = MessageType.KTV_WEEKLY_SINGING_HOT_RANK_POS_MESSAGE;
    }
}
