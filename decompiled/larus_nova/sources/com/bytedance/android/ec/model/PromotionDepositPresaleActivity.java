package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b1\u00102R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\"\u0010.\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u00065"}, d2 = {"Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "Ljava/io/Serializable;", "", "depositPrice", "J", "getDepositPrice", "()J", "beginTime", "getBeginTime", "endTime", "getEndTime", "restBeginTime", "getRestBeginTime", "restEndTime", "getRestEndTime", "currentTime", "getCurrentTime", "campaignId", "getCampaignId", "", "appointCount", "I", "getAppointCount", "()I", "setAppointCount", "(I)V", "appointStatus", "getAppointStatus", "setAppointStatus", "", "prefix", "Ljava/lang/String;", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgLogoPicture", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgLogoPicture", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBgLogoPicture", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "bgPicture", "getBgPicture", "setBgPicture", "style", "getStyle", "setStyle", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionDepositPresaleActivity implements Serializable {
    public static final a Companion = null;
    public static final int DEPOSIT_PRESALE_APPOINT_STATUS_RESERVED = 2;
    public static final String RESERVED = "reserved";
    public static final String SALE = "sale";
    public static final String WAIT_RESERVE = "wait_reserve";

    @SerializedName("appoint_count")
    private int appointCount;

    @SerializedName("appoint_status")
    private int appointStatus;

    @SerializedName("begin_time")
    private final long beginTime;

    @SerializedName("bg_logo_picture")
    private ECUrlModel bgLogoPicture;

    @SerializedName("bg_picture")
    private ECUrlModel bgPicture;

    @SerializedName("campaign_id")
    private final long campaignId;

    @SerializedName("current_time")
    private final long currentTime;

    @SerializedName("deposit_price")
    private final long depositPrice;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("rest_begin_time")
    private final long restBeginTime;

    @SerializedName("rest_end_time")
    private final long restEndTime;

    @SerializedName("style")
    private int style;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionDepositPresaleActivity() {
    }

    public final int getAppointCount() {
        return this.appointCount;
    }

    public final int getAppointStatus() {
        return this.appointStatus;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final ECUrlModel getBgLogoPicture() {
        return this.bgLogoPicture;
    }

    public final ECUrlModel getBgPicture() {
        return this.bgPicture;
    }

    public final long getCampaignId() {
        return this.campaignId;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final long getRestBeginTime() {
        return this.restBeginTime;
    }

    public final long getRestEndTime() {
        return this.restEndTime;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setAppointCount(int r100) {
        this.appointCount = r100;
    }

    public final void setAppointStatus(int r100) {
        this.appointStatus = r100;
    }

    public final void setBgLogoPicture(ECUrlModel r100) {
        this.bgLogoPicture = r100;
    }

    public final void setBgPicture(ECUrlModel r100) {
        this.bgPicture = r100;
    }

    public final void setPrefix(String r100) {
        this.prefix = r100;
    }

    public final void setStyle(int r100) {
        this.style = r100;
    }
}
