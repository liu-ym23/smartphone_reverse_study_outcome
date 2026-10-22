package com.bytedance.android.shopping.store.repository.vo;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/vo/ShopRemoteStruct;", "Ljava/io/Serializable;", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()I", "businessId", "", "getBusinessId", "()Ljava/lang/String;", "data", "getData", "secShopId", "getSecShopId", "userId", "getUserId", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRemoteStruct implements Serializable {

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID)
    private final String businessId;

    @SerializedName("data")
    private final String data;

    @SerializedName("sec_shop_id")
    private final String secShopId;

    @SerializedName("user_id")
    private final String userId;

    public ShopRemoteStruct() {
        this.actionType = -1;
        this.secShopId = "-1";
        this.userId = "-1";
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getData() {
        return this.data;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getUserId() {
        return this.userId;
    }
}
