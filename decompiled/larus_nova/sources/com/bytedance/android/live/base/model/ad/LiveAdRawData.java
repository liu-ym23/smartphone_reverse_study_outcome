package com.bytedance.android.live.base.model.ad;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.gson.JsonToStringAdapter;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001c\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/ad/LiveAdRawData;", "", "()V", "actionExtra", "", "adFeedbackCategoryTags", "", "adId", "", "Ljava/lang/Long;", "adNewFeedbackTags", "adSourceType", "", "Ljava/lang/Integer;", "clickTrackUrlList", "Lcom/bytedance/android/live/base/model/UrlModel;", "creativeId", "enterFromMerge", "enterMethod", "innerAfterTrackSeconds", "liveActionExtra", "logExtra", "logExtraJsonObject", "Lorg/json/JSONObject;", "getLogExtraJsonObject", "()Lorg/json/JSONObject;", "setLogExtraJsonObject", "(Lorg/json/JSONObject;)V", "originalSystemOrigin", "rawAdDataStr", BdpAppEventConstant.PARAMS_RIT, "getRit", "()Ljava/lang/String;", "setRit", "(Ljava/lang/String;)V", "systemOrigin", "trackUrlList", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAdRawData {

    @SerializedName("action_extra")
    public String actionExtra;

    @SerializedName("filter_words_category_details")
    public List<? extends Object> adFeedbackCategoryTags;

    @SerializedName("ad_id")
    public Long adId;

    @SerializedName("new_filter_words")
    public List<? extends Object> adNewFeedbackTags;

    @SerializedName("ad_source_type")
    public Integer adSourceType;

    @SerializedName("click_track_url_list")
    public UrlModel clickTrackUrlList;

    @SerializedName("creative_id")
    public Long creativeId;

    @SerializedName("enter_from_merge")
    public String enterFromMerge;

    @SerializedName("enter_method")
    public String enterMethod;

    @SerializedName("liveinner_after_seconds_track")
    public Integer innerAfterTrackSeconds;

    @SerializedName("live_action_extra")
    public String liveActionExtra;

    @SerializedName("log_extra")
    public String logExtra;
    private transient JSONObject logExtraJsonObject;

    @SerializedName("original_system_origin")
    public Integer originalSystemOrigin;

    @SerializedName("raw_ad_data")
    @JsonAdapter(JsonToStringAdapter.class)
    public String rawAdDataStr;
    private transient String rit;

    @SerializedName("system_origin")
    public Integer systemOrigin;

    @SerializedName("track_url_list")
    public UrlModel trackUrlList;

    public LiveAdRawData() {
    }

    public final JSONObject getLogExtraJsonObject() {
        if (this.logExtraJsonObject != null) goto L9;
        JSONObject r100 = new JSONObject(this.logExtra);     // Catch: Exception -> L6
    L7:
        this.logExtraJsonObject = r100;
    L6:
        r100 = new JSONObject();
    L9:
        return this.logExtraJsonObject;
    }

    public final String getRit() {
        if (this.rit != null) goto L11;
        JSONObject r100 = getLogExtraJsonObject();
        if (r100 == null) goto L8;
        String r101 = r100.optString(BdpAppEventConstant.PARAMS_RIT);
        if (r101 == null) goto L8;
    L9:
        this.rit = r101;
    L8:
        r101 = "";
    L11:
        return this.rit;
    }

    public final void setLogExtraJsonObject(JSONObject r100) {
        this.logExtraJsonObject = r100;
    }

    public final void setRit(String r100) {
        this.rit = r100;
    }
}
