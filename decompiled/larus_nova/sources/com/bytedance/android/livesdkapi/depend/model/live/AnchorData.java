package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomAnchorData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "()V", "anchorInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/GameAnchorInfo;", "getAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/GameAnchorInfo;", "setAnchorInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/GameAnchorInfo;)V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "finishSchema", "getFinishSchema", "setFinishSchema", "frameScale", "getFrameScale", "setFrameScale", "groupIdList", "getGroupIdList", "setGroupIdList", "shareAnchorInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShareAnchorInfo;", "getShareAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ShareAnchorInfo;", "setShareAnchorInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ShareAnchorInfo;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorData extends FlexModelBase<IAnchorData> implements IAnchorData, h {

    @SerializedName("game_anchor_info")
    protected GameAnchorInfo anchorInfo;

    @SerializedName("conversation_id")
    protected String conversationId;

    @SerializedName("finish_schema")
    protected String finishSchema;

    @SerializedName("frame_scale")
    protected String frameScale;

    @SerializedName("group_id_list")
    protected String groupIdList;

    @SerializedName("share_anchor_info")
    protected ShareAnchorInfo shareAnchorInfo;

    public AnchorData() {
        super(IAnchorData.class);
        this.finishSchema = "";
    }

    public final GameAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public String getConversationId() {
        return this.conversationId;
    }

    public final String getFinishSchema() {
        return this.finishSchema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public String getFrameScale() {
        return this.frameScale;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public String getGroupIdList() {
        return this.groupIdList;
    }

    public final ShareAnchorInfo getShareAnchorInfo() {
        return this.shareAnchorInfo;
    }

    public AnchorData(g r100) {
        super(IAnchorData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.shareAnchorInfo = new ShareAnchorInfo(r100);
        goto L3
    L9:
        this.conversationId = am3.h.c(r100);
        goto L3
    L10:
        this.groupIdList = am3.h.c(r100);
        goto L3
    L11:
        this.frameScale = am3.h.c(r100);
        goto L3
    L12:
        this.anchorInfo = new GameAnchorInfo(r100);
        goto L3
    L13:
        this.finishSchema = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if (this.finishSchema != null) goto L34;
        this.finishSchema = "";
        return;
    }

    public final void setAnchorInfo(GameAnchorInfo r100) {
        this.anchorInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setFinishSchema(String r100) {
        this.finishSchema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public void setFrameScale(String r100) {
        this.frameScale = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorData
    public void setGroupIdList(String r100) {
        this.groupIdList = r100;
    }

    public final void setShareAnchorInfo(ShareAnchorInfo r100) {
        this.shareAnchorInfo = r100;
    }
}
