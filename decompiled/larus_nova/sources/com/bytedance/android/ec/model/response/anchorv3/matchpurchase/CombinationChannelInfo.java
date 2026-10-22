package com.bytedance.android.ec.model.response.anchorv3.matchpurchase;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationChannelInfo;", "Ljava/io/Serializable;", "()V", RemoteMessageConst.Notification.CHANNEL_ID, "", "getChannelId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "channelType", "getChannelType", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CombinationChannelInfo implements Serializable {

    @SerializedName("channel_id")
    private final Long channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Long channelType;

    public CombinationChannelInfo() {
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getChannelType() {
        return this.channelType;
    }
}
