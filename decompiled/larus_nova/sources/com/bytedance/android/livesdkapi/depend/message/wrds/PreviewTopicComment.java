package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomCommentTopicMessage.ChatItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewTopicComment;", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/AbsPreviewComment;", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewTopicComment extends AbsPreviewComment implements h {
    public PreviewTopicComment() {
        this.msgId = 0L;
        this.eventTime = 0L;
    }

    public PreviewTopicComment(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.type = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.msgId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.featuredChat = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.eventTime = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.guideText = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.msgId != null) goto L25;
        this.msgId = 0L;
    L25:
        if (this.eventTime != null) goto L46;
        this.eventTime = 0L;
        return;
    }
}
