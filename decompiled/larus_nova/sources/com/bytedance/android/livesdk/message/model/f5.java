package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GamblingStatusChangedMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f5;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_preStatus", "I", "get_preStatus", "()I", "set_preStatus", "(I)V", "Lcom/bytedance/android/livesdk/chatroom/model/p0;", "_gameQuizInfo", "Lcom/bytedance/android/livesdk/chatroom/model/p0;", "get_gameQuizInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/p0;", "set_gameQuizInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/p0;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f5 extends o0 implements vh7.h {

    @SerializedName("game_quiz_info")
    protected com.bytedance.android.livesdk.chatroom.model.p0 _gameQuizInfo;

    @SerializedName("prev_status")
    protected int _preStatus;

    public f5() {
        this.type = MessageType.GAME_QUIZ;
    }

    public f5(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._preStatus = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._gameQuizInfo = new com.bytedance.android.livesdk.chatroom.model.p0(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.GAME_QUIZ;
    }
}
