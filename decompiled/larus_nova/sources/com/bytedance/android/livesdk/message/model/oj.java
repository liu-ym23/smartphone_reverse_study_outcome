package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ResidentGuestMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/oj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "msgType", "Ljava/lang/Integer;", "getMsgType", "()Ljava/lang/Integer;", "setMsgType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/livesdk/message/model/nj;", "guestAllowContent", "Lcom/bytedance/android/livesdk/message/model/nj;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/nj;", "setGuestAllowContent", "(Lcom/bytedance/android/livesdk/message/model/nj;)V", "linkmicRoomAllowContent", "G", "setLinkmicRoomAllowContent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class oj extends o0 implements vh7.h {

    @SerializedName("guest_allow_content")
    protected nj guestAllowContent;

    @SerializedName("linkmic_room_allow_content")
    protected nj linkmicRoomAllowContent;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    protected Integer msgType;

    public static final class a {
    }

    static {
    }

    public oj() {
        this.type = MessageType.RESIDENT_GUEST_MESSAGE;
    }

    public final nj E() {
        return this.guestAllowContent;
    }

    public final nj G() {
        return this.linkmicRoomAllowContent;
    }

    public final Integer getMsgType() {
        return this.msgType;
    }

    public oj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.msgType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 100) goto L12;
        this.guestAllowContent = new nj(r100);
        goto L3
    L12:
        if (r102 != 101) goto L13;
        this.linkmicRoomAllowContent = new nj(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.RESIDENT_GUEST_MESSAGE;
    }
}
