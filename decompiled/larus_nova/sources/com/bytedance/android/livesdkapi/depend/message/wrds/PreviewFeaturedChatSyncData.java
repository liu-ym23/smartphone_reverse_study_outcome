package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewFeaturedChatSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewFeaturedChatSyncData;", "", "()V", "hotCommentList", "", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewHotComment;", "getHotCommentList", "()Ljava/util/List;", "setHotCommentList", "(Ljava/util/List;)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewFeaturedChatSyncData implements h {

    @SerializedName("featured_chat_list")
    protected List<PreviewHotComment> hotCommentList;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("type")
    protected Integer type;

    public PreviewFeaturedChatSyncData() {
        this.type = 0;
    }

    public final List<PreviewHotComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final Integer getType() {
        return this.type;
    }

    public PreviewFeaturedChatSyncData(g r100) {
        this.hotCommentList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.icon = x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.type = Integer.valueOf((int) r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.hotCommentList.add(new PreviewHotComment(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.type != null) goto L31;
        this.type = 0;
        return;
    }

    public final void setHotCommentList(List<PreviewHotComment> r100) {
        this.hotCommentList = r100;
    }

    public final void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
