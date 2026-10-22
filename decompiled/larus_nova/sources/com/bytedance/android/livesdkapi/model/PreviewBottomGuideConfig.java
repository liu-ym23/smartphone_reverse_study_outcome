package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PreviewBottomGuideConfig;", "", "()V", "dontShowDays", "", "enable", "", "notClickTime", "style", "useFrequency", "waitDuration", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewBottomGuideConfig {

    @SerializedName("dont_show_days")
    public int dontShowDays;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("not_click_times")
    public int notClickTime;

    @SerializedName("style")
    public int style;

    @SerializedName("use_frequency")
    public boolean useFrequency;

    @SerializedName("wait_duration")
    public long waitDuration;

    public PreviewBottomGuideConfig() {
        this.waitDuration = 10000;
        this.notClickTime = 4;
        this.dontShowDays = 3;
    }
}
