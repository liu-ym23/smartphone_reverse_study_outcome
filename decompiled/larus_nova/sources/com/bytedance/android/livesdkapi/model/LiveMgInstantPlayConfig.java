package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveMgInstantPlayConfig;", "", "()V", "anchorUploadLimitSize", "", "getAnchorUploadLimitSize", "()I", "setAnchorUploadLimitSize", "(I)V", "anchorUploadLimitTime", "getAnchorUploadLimitTime", "setAnchorUploadLimitTime", "audienceThresholdLimitTime", "getAudienceThresholdLimitTime", "setAudienceThresholdLimitTime", "open", "", "getOpen", "()Z", "setOpen", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveMgInstantPlayConfig {

    @SerializedName("anchor_upload_limit_size")
    private int anchorUploadLimitSize;

    @SerializedName("anchor_upload_limit_time")
    private int anchorUploadLimitTime;

    @SerializedName("audience_threshold_limit_time")
    private int audienceThresholdLimitTime;

    @SerializedName("open")
    private boolean open;

    public LiveMgInstantPlayConfig() {
        this.anchorUploadLimitTime = 10;
        this.anchorUploadLimitSize = 512;
        this.open = true;
        this.audienceThresholdLimitTime = 300;
    }

    public final int getAnchorUploadLimitSize() {
        return this.anchorUploadLimitSize;
    }

    public final int getAnchorUploadLimitTime() {
        return this.anchorUploadLimitTime;
    }

    public final int getAudienceThresholdLimitTime() {
        return this.audienceThresholdLimitTime;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final void setAnchorUploadLimitSize(int r100) {
        this.anchorUploadLimitSize = r100;
    }

    public final void setAnchorUploadLimitTime(int r100) {
        this.anchorUploadLimitTime = r100;
    }

    public final void setAudienceThresholdLimitTime(int r100) {
        this.audienceThresholdLimitTime = r100;
    }

    public final void setOpen(boolean r100) {
        this.open = r100;
    }
}
