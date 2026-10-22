package com.bytedance.android.shopping.infeed.data.idl.ad;

import com.bytedance.android.shopping.anchorv3.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR$\u0010(\u001a\u0004\u0018\u00010'8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;", "Ljava/io/Serializable;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "showAdTag", "Z", "getShowAdTag", "()Z", "setShowAdTag", "(Z)V", "adPackCell", "getAdPackCell", "setAdPackCell", "", "adSource", "Ljava/lang/Integer;", "getAdSource", "()Ljava/lang/Integer;", "setAdSource", "(Ljava/lang/Integer;)V", "isFromOuter", "setFromOuter", "isSameRit", "setSameRit", "creativeId", "getCreativeId", "setCreativeId", "groupId", "getGroupId", "setGroupId", "logExtra", "getLogExtra", "setLogExtra", "Lorg/json/JSONObject;", "adOpenUrlParams", "Lorg/json/JSONObject;", "getAdOpenUrlParams", "()Lorg/json/JSONObject;", "setAdOpenUrlParams", "(Lorg/json/JSONObject;)V", "pricingType", "getPricingType", "setPricingType", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdBaseInfo implements Serializable {
    private JSONObject adOpenUrlParams;

    @SerializedName("AdPackCell")
    private String adPackCell;

    @SerializedName("ad_source")
    private Integer adSource;
    private String creativeId;
    private String groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f176231id;
    private boolean isFromOuter;
    private boolean isSameRit;
    private String logExtra;
    private Integer pricingType;

    @SerializedName("show_ad_tag")
    private boolean showAdTag;

    public final JSONObject a() {
        if (a.b(this.adPackCell) == true) goto L17;
    L8:
        JSONObject r100 = null;
    L9:
        if (r100 != null) goto L11;
        return null;
    L11:
        if (r100.has("raw_ad_data") == true) goto L14;
        r100 = null;
    L14:
        if (r100 != null) goto L16;
        return null;
    L16:
        return r100.optJSONObject("raw_ad_data");
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        r100 = new JSONObject(new JSONObject(this.adPackCell).optString(EventConstant.Key.RAW_DATA));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONObject getAdOpenUrlParams() {
        JSONObject r100 = this.adOpenUrlParams;
        if (r100 != null) goto L11;
        JSONObject r101 = a();
        JSONObject r102 = null;
        if (r101 == null) goto L9;
        JSONObject r103 = r101.optJSONObject("ad_open_url_params");
        if (r103 == null) goto L9;
        r102 = r103.optJSONObject("meta_params");
    L9:
        JSONObject r104 = r102;
        this.adOpenUrlParams = r104;
        return r104;
    L11:
        return r100;
    }

    public final String getCreativeId() {
        String r100 = this.creativeId;
        if (r100 != null) goto L9;
        JSONObject r101 = a();
        if (r101 == null) goto L7;
        r100 = r101.optString("creative_id");
    L8:
        this.creativeId = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final String getGroupId() {
        String r100 = this.groupId;
        if (r100 != null) goto L9;
        JSONObject r101 = a();
        if (r101 == null) goto L7;
        r100 = r101.optString("group_id");
    L8:
        this.groupId = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final String getLogExtra() {
        String r100 = this.logExtra;
        if (r100 != null) goto L9;
        JSONObject r101 = a();
        if (r101 == null) goto L7;
        r100 = r101.optString("log_extra");
    L8:
        this.logExtra = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final Integer getPricingType() {
        Integer r100 = this.pricingType;
        if (r100 != null) goto L9;
        JSONObject r101 = a();
        if (r101 == null) goto L7;
        r100 = Integer.valueOf(r101.optInt("pricing_type"));
    L8:
        this.pricingType = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public AdBaseInfo() {
        this.adSource = 0;
    }

    public final String getAdPackCell() {
        return this.adPackCell;
    }

    public final Integer getAdSource() {
        return this.adSource;
    }

    public final String getId() {
        return this.f176231id;
    }

    public final boolean getShowAdTag() {
        return this.showAdTag;
    }

    public final boolean isFromOuter() {
        return this.isFromOuter;
    }

    public final boolean isSameRit() {
        return this.isSameRit;
    }

    public final void setAdOpenUrlParams(JSONObject r100) {
        this.adOpenUrlParams = r100;
    }

    public final void setAdPackCell(String r100) {
        this.adPackCell = r100;
    }

    public final void setAdSource(Integer r100) {
        this.adSource = r100;
    }

    public final void setCreativeId(String r100) {
        this.creativeId = r100;
    }

    public final void setFromOuter(boolean r100) {
        this.isFromOuter = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setId(String r100) {
        this.f176231id = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public final void setPricingType(Integer r100) {
        this.pricingType = r100;
    }

    public final void setSameRit(boolean r100) {
        this.isSameRit = r100;
    }

    public final void setShowAdTag(boolean r100) {
        this.showAdTag = r100;
    }
}
