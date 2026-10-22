package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TeamPlayNewApplyMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/am;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "userId", "Ljava/lang/Long;", "", InstantPlayContext.NICKNAME, "Ljava/lang/String;", "", "needNotifyToApply", "Ljava/lang/Boolean;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class am extends o0 implements vh7.h {

    @SerializedName(InstantPlayContext.NEED_NOTIFY_TO_APPLY)
    public Boolean needNotifyToApply;

    @SerializedName(InstantPlayContext.NICKNAME)
    public String nickname;

    @SerializedName("user_id")
    public Long userId;

    public am() {
        this.userId = 0L;
        this.nickname = "";
        this.needNotifyToApply = Boolean.FALSE;
        this.type = MessageType.TEAM_PLAY_NEW_APPLY_MESSAGE;
    }

    public am(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nickname = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.needNotifyToApply = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.userId != null) goto L22;
        this.userId = 0L;
    L22:
        if (this.nickname != null) goto L25;
        this.nickname = "";
    L25:
        if (this.needNotifyToApply != null) goto L27;
        this.needNotifyToApply = Boolean.FALSE;
    L27:
        this.type = MessageType.TEAM_PLAY_NEW_APPLY_MESSAGE;
    }
}
