package com.bytedance.android.ec.common.api.inflow;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitBanner;", "Ljava/io/Serializable;", "()V", "availableAmount", "", "getAvailableAmount", "()Ljava/lang/String;", "benefitSchema", "Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitSchema;", "getBenefitSchema", "()Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitSchema;", "benefitType", "getBenefitType", "clickToast", "Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitToast;", "getClickToast", "()Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitToast;", "earliestAvailableExpiredTime", "", "getEarliestAvailableExpiredTime", "()J", "serverTime", "getServerTime", "text", "getText", "trackParams", "", "getTrackParams", "()Ljava/util/Map;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorBenefitBanner implements Serializable {

    @SerializedName("available_amount")
    private final String availableAmount;

    @SerializedName("benefit_schema")
    private final AnchorBenefitSchema benefitSchema;

    @SerializedName(a.KEY_BENEFIT_TYPE)
    private final String benefitType;

    @SerializedName("click_toast")
    private final AnchorBenefitToast clickToast;

    @SerializedName("earliest_available_expired_time")
    private final long earliestAvailableExpiredTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("text")
    private final String text;

    @SerializedName("track_param")
    private final Map<String, String> trackParams;

    public AnchorBenefitBanner() {
    }

    public final String getAvailableAmount() {
        return this.availableAmount;
    }

    public final AnchorBenefitSchema getBenefitSchema() {
        return this.benefitSchema;
    }

    public final String getBenefitType() {
        return this.benefitType;
    }

    public final AnchorBenefitToast getClickToast() {
        return this.clickToast;
    }

    public final long getEarliestAvailableExpiredTime() {
        return this.earliestAvailableExpiredTime;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final String getText() {
        return this.text;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }
}
