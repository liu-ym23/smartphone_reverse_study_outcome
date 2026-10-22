package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class PreviewRoomData {

    @SerializedName("event_extra")
    public HashMap<String, String> eventExtra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f162654id;

    @SerializedName("need_log_duration")
    public boolean needLogDuration;

    @SerializedName("need_log_show")
    public boolean needLogShow;

    @SerializedName("owner_open_id")
    public String ownerOpenId;

    @SerializedName("stream_url")
    public StreamUrl streamUrl;

    public String buildPullUrl() {
        StreamUrl r100 = this.streamUrl;
        if (r100 != null) goto L7;
        return null;
    L7:
        return buildPullUrl(r100.defaultQualityName);
    }

    public String getSdkParams() {
        StreamUrl r100 = this.streamUrl;
        if (r100 != null) goto L7;
        return null;
    L7:
        return getSdkParams(r100.defaultQualityName);
    }

    public void init() {
        StreamUrl r100 = this.streamUrl;
        if (r100 == null) goto L8;
        r100.validatePullUrl();
        if (this.streamUrl.getLiveCoreSDKData() == null) goto L9;
        this.streamUrl.validateMultiPullData();
        return;
    L9:
        return;
    }

    public PreviewRoomData() {
        this.needLogDuration = true;
        this.needLogShow = false;
        this.eventExtra = new HashMap();
    }

    public String buildPullUrl(String r100) {
        StreamUrl r101 = this.streamUrl;
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.qualityMap.get(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        UrlBuilder r103 = new UrlBuilder(r102);
        r103.addParam("room_id", this.f162654id);
        r103.addParam("anchor_id", this.ownerOpenId);
        return r103.build();
    }

    public String getSdkParams(String r100) {
        StreamUrl r101 = this.streamUrl;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.sdkParamsMap.get(r100);
    }
}
