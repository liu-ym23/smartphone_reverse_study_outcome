package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkerUpdateLinkTypeReplyContent extends FlexModelBase<ILinkerUpdateLinkTypeReplyContent> implements ILinkerUpdateLinkTypeReplyContent {
    public static final int UPDATE_LINK_TYPE_REPLY_AGREE = 1;
    public static final int UPDATE_LINK_TYPE_REPLY_REJECT = 2;

    @SerializedName("from_open_id")
    public String _fromOpenId;

    @SerializedName("from_user_id")
    public long _fromUserId;

    @SerializedName("to_open_id")
    public String _toOpenId;

    @SerializedName(a.KEY_TO_USER_ID)
    public long _toUserId;

    @SerializedName("reply_prompts")
    public String prompts;

    @SerializedName("reply_type")
    public int replyType;

    public LinkerUpdateLinkTypeReplyContent() {
        super(ILinkerUpdateLinkTypeReplyContent.class);
    }

    public String getFromUserId() {
        return n0.e(Long.valueOf(this._fromUserId), this._fromOpenId);
    }

    public String getToUserId() {
        return n0.e(Long.valueOf(this._toUserId), this._toOpenId);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContentDef
    public String getPrompts() {
        return this.prompts;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContentDef
    public int getReplyType() {
        return this.replyType;
    }
}
