package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionOpenInfo;", "Ljava/io/Serializable;", "()V", "activityType", "", "getActivityType", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "openDesc", "getOpenDesc", "openShort", "getOpenShort", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "pageType", "getPageType", "showFlag", "", "getShowFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionOpenInfo implements Serializable {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
    private final String activityType;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("open_desc")
    private final String openDesc;

    @SerializedName("open_short")
    private final String openShort;

    @SerializedName("open_h5_url")
    private final String openUrl;

    @SerializedName("page_type")
    private final String pageType;

    @SerializedName("show_flag")
    private final Boolean showFlag;

    public PromotionOpenInfo() {
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getOpenDesc() {
        return this.openDesc;
    }

    public final String getOpenShort() {
        return this.openShort;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final Boolean getShowFlag() {
        return this.showFlag;
    }
}
