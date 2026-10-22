package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006¨\u0006)"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductServiceStruct;", "Ljava/io/Serializable;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "content", "getContent", "icon", "getIcon", "smallIcon", "getSmallIcon", "url", "getUrl", "hybridSchema", "getHybridSchema", "tag", "getTag", "", NsdHelper.serviceTypeKey, "Ljava/lang/Integer;", "getServiceType", "()Ljava/lang/Integer;", "setServiceType", "(Ljava/lang/Integer;)V", "subtitle", "getSubtitle", "", "showOnTop", "Z", "getShowOnTop", "()Z", "subtitleTextColor", "getSubtitleTextColor", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductServiceStruct implements Serializable {
    public static final a Companion = null;
    public static final int SERVICE_TYPE_CHARITY_GOODS = 35;
    public static final int SERVICE_TYPE_CROSSBORDER_QUALITY = 20;
    public static final int SERVICE_TYPE_INSURANCE = 19;
    public static final int SERVICE_TYPE_SECURE_BUY = 11;
    public static final int SERVICE_TYPE_THRESHOLD = 10000;

    @SerializedName("content")
    private final String content;

    @SerializedName("hybrid_schema")
    private final String hybridSchema;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("service_type")
    private Integer serviceType;

    @SerializedName("top_show")
    private final boolean showOnTop;

    @SerializedName("small_icon")
    private final String smallIcon;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName("subtitle_text_color")
    private final String subtitleTextColor;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductServiceStruct() {
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHybridSchema() {
        return this.hybridSchema;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getServiceType() {
        return this.serviceType;
    }

    public final boolean getShowOnTop() {
        return this.showOnTop;
    }

    public final String getSmallIcon() {
        return this.smallIcon;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getSubtitleTextColor() {
        return this.subtitleTextColor;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setServiceType(Integer r100) {
        this.serviceType = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
