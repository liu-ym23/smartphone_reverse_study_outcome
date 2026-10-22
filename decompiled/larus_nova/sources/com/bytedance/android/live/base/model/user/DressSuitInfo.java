package com.bytedance.android.live.base.model.user;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class DressSuitInfo {
    public static final long DefaultScene = 0;
    public static final long IsPlaceholderImage = 1;

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    py.k badge;

    @SerializedName("extra")
    String extra;

    @SerializedName("name")
    String name;

    @SerializedName("scene")
    long scene;

    @SerializedName("schema")
    String schema;

    @SerializedName(com.bytedance.android.livesdk.message.model.z.ASSET_SUIT_ID)
    String suitId;

    @SerializedName("user_suit_id")
    String userSuitId;

    public DressSuitInfo() {
    }

    public py.k getBadge() {
        return this.badge;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getName() {
        return this.name;
    }

    public long getScene() {
        return this.scene;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSuitId() {
        return this.suitId;
    }

    public String getUserSuitId() {
        return this.userSuitId;
    }
}
