package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OChannelModifyMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/tg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "startTimeStamp", "J", "G", "()J", "setStartTimeStamp", "(J)V", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "channelUid", "", "channelOpenId", "Ljava/lang/String;", "getChannelOpenId", "()Ljava/lang/String;", "setChannelOpenId", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class tg extends o0 implements vh7.h {

    @SerializedName("channel_open_id")
    protected String channelOpenId;

    @SerializedName("channel_uid")
    protected long channelUid;

    @SerializedName("end_timestamp")
    protected long endTimeStamp;

    @SerializedName("start_timestamp")
    protected long startTimeStamp;

    public final String E() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.channelUid);
        String r102 = this.channelOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public tg() {
        this.type = MessageType.OFFICIAL_CHANNEL_MODIFY_MESSAGE;
    }

    public final long G() {
        return this.startTimeStamp;
    }

    public final long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public tg(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.startTimeStamp = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.endTimeStamp = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.channelUid = r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.channelOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.OFFICIAL_CHANNEL_MODIFY_MESSAGE;
    }
}
