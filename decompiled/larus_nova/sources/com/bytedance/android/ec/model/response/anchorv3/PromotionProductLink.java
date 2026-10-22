package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "Ljava/io/Serializable;", "()V", "groupH5Url", "", "getGroupH5Url", "()Ljava/lang/String;", "h5Url", "getH5Url", "joinMemberUrl", "getJoinMemberUrl", "lynxUrl", "getLynxUrl", "openAppUrl", "getOpenAppUrl", "smallAppUrl", "getSmallAppUrl", "universalLink", "getUniversalLink", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductLink implements Serializable {

    @SerializedName("group_h5_url")
    private final String groupH5Url;

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("join_member_url")
    private final String joinMemberUrl;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName(PdpOpenThirdParam.KEY_OPEN_APP_URL)
    private final String openAppUrl;

    @SerializedName("small_app_url")
    private final String smallAppUrl;

    @SerializedName("universal_link")
    private final String universalLink;

    public PromotionProductLink() {
    }

    public final String getGroupH5Url() {
        return this.groupH5Url;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final String getJoinMemberUrl() {
        return this.joinMemberUrl;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final String getOpenAppUrl() {
        return this.openAppUrl;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final String getUniversalLink() {
        return this.universalLink;
    }
}
