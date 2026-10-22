package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/BadgeInfo;", "Ljava/io/Serializable;", "()V", "badgeImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBadgeImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "badgeImageType", "", "getBadgeImageType", "()I", "badgeMessage", "", "getBadgeMessage", "()Ljava/lang/String;", "badgeType", "getBadgeType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BadgeInfo implements Serializable {

    @SerializedName("badge_image")
    private final ECUrlModel badgeImage;

    @SerializedName("badge_image_type")
    private final int badgeImageType;

    @SerializedName("badge_message")
    private final String badgeMessage;

    @SerializedName("badge_type")
    private final int badgeType;

    public BadgeInfo() {
    }

    public final ECUrlModel getBadgeImage() {
        return this.badgeImage;
    }

    public final int getBadgeImageType() {
        return this.badgeImageType;
    }

    public final String getBadgeMessage() {
        return this.badgeMessage;
    }

    public final int getBadgeType() {
        return this.badgeType;
    }
}
