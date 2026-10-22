package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.model.live.CommentaryRoomInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.CommentaryChangeMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/WebcastCommentaryChangeMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "commentaryRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "getCommentaryRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "setCommentaryRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;)V", "", "operationType", "I", "getOperationType", "()I", "setOperationType", "(I)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastCommentaryChangeMessage extends o0 implements h {

    @SerializedName("commentary_room_info")
    protected CommentaryRoomInfo commentaryRoomInfo;

    @SerializedName(WikiFolderPushPlugin.OPT)
    protected int operationType;

    public WebcastCommentaryChangeMessage() {
        this.type = MessageType.COMMENTARY_CHANGE_MESSAGE;
    }

    public final CommentaryRoomInfo getCommentaryRoomInfo() {
        return this.commentaryRoomInfo;
    }

    public final int getOperationType() {
        return this.operationType;
    }

    public WebcastCommentaryChangeMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.commentaryRoomInfo = new CommentaryRoomInfo(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.operationType = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.COMMENTARY_CHANGE_MESSAGE;
    }

    public final void setCommentaryRoomInfo(CommentaryRoomInfo r100) {
        this.commentaryRoomInfo = r100;
    }

    public final void setOperationType(int r100) {
        this.operationType = r100;
    }
}
