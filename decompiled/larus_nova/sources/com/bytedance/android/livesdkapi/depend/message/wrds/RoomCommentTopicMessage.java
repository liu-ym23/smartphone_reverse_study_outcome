package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomCommentTopicMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/RoomCommentTopicMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewTopicComment;", "hotCommentList", "Ljava/util/List;", "getHotCommentList", "()Ljava/util/List;", "setHotCommentList", "(Ljava/util/List;)V", "", "commentType", "Ljava/lang/Integer;", "getCommentType", "()Ljava/lang/Integer;", "setCommentType", "(Ljava/lang/Integer;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCommentTopicMessage extends o0 implements h {

    @SerializedName("type")
    protected Integer commentType;

    @SerializedName("comment_topic_chat_list")
    protected List<PreviewTopicComment> hotCommentList;

    @SerializedName("icon")
    protected ImageModel icon;

    public RoomCommentTopicMessage() {
        this.commentType = 0;
        this.type = MessageType.ROOM_COMMENT_TOPIC_MESSAGE;
    }

    public final Integer getCommentType() {
        return this.commentType;
    }

    public final List<PreviewTopicComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public RoomCommentTopicMessage(g r100) {
        this.hotCommentList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.icon = x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.commentType = Integer.valueOf((int) r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.hotCommentList.add(new PreviewTopicComment(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.commentType != null) goto L21;
        this.commentType = 0;
    L21:
        this.type = MessageType.ROOM_COMMENT_TOPIC_MESSAGE;
    }

    public final void setCommentType(Integer r100) {
        this.commentType = r100;
    }

    public final void setHotCommentList(List<PreviewTopicComment> r100) {
        this.hotCommentList = r100;
    }

    public final void setIcon(ImageModel r100) {
        this.icon = r100;
    }
}
