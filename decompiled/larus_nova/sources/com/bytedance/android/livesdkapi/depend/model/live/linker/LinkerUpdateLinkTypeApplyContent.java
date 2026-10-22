package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkerUpdateLinkTypeApplyContent extends FlexModelBase<ILinkerUpdateLinkTypeApplyContent> implements ILinkerUpdateLinkTypeApplyContent {
    public static final int SOURCE_GAME = 2;

    @SerializedName("ack_message")
    public String ackMessage;

    @SerializedName("client_no_toast")
    public Boolean clientNoToast;

    @SerializedName("from_open_id")
    public String fromOpenId;

    @SerializedName("from_user_id")
    long fromUserId;

    @SerializedName("link_type")
    public int linkType;

    @SerializedName("show_type")
    public long showType;

    @SerializedName("source")
    public int source;

    @SerializedName("to_open_id")
    String toOpenId;

    @SerializedName(a.KEY_TO_USER_ID)
    long toUserId;

    @SerializedName("toast")
    public String toast;

    public LinkerUpdateLinkTypeApplyContent() {
        super(ILinkerUpdateLinkTypeApplyContent.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public String getFromUserIdString() {
        return n0.e(Long.valueOf(this.fromUserId), this.fromOpenId);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public String getToUserIdString() {
        return n0.e(Long.valueOf(this.toUserId), this.toOpenId);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public String getAckMessage() {
        return this.ackMessage;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public Boolean getClientNoToast() {
        return this.clientNoToast;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public int getLinkType() {
        return this.linkType;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public long getShowType() {
        return this.showType;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public int getSource() {
        return this.source;
    }

    public long getToUserId() {
        return this.toUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public String getToast() {
        return this.toast;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent
    public void setClientNoToast(Boolean r100) {
        this.clientNoToast = r100;
    }
}
