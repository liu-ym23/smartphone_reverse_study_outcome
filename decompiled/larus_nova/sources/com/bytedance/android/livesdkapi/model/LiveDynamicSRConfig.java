package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u0016\u0010$\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u000f0'j\b\u0012\u0004\u0012\u00020\u000f`(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveDynamicSRConfig;", "", "()V", "aiServiceSrEnable", "", "getAiServiceSrEnable", "()Z", "setAiServiceSrEnable", "(Z)V", "disableSceneList", "", "", "getDisableSceneList", "()Ljava/util/List;", "dynamicSrMode", "", "getDynamicSrMode", "()I", "setDynamicSrMode", "(I)V", "dynamicSrPredictEventName", "getDynamicSrPredictEventName", "()Ljava/lang/String;", "setDynamicSrPredictEventName", "(Ljava/lang/String;)V", "dynamicSrPredictInterval", "getDynamicSrPredictInterval", "setDynamicSrPredictInterval", "dynamicSrPredictMode", "getDynamicSrPredictMode", "setDynamicSrPredictMode", "dynamicSrPredictSkipList", "getDynamicSrPredictSkipList", "previewEnableSr", "getPreviewEnableSr", "setPreviewEnableSr", "scheduleMode", "getScheduleMode", "scheduleTimeInterval", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getScheduleTimeInterval", "()Ljava/util/ArrayList;", "isDSREnable", "isDSRPredictEnable", "isFirstFrameDSREnable", "isPlayingDSREnable", "isPredictSkip", "scene", "isRoomEnterDSRPredictEnable", "isSrEnable", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDynamicSRConfig {
    private boolean aiServiceSrEnable;

    @SerializedName("dynamic_sr_disable_list")
    private final List<String> disableSceneList;

    @SerializedName("dynamic_sr_mode")
    private int dynamicSrMode;

    @SerializedName("dynamic_sr_predict_event_name")
    private String dynamicSrPredictEventName;

    @SerializedName("dynamic_sr_predict_interval")
    private int dynamicSrPredictInterval;

    @SerializedName("dynamic_sr_predict_mode")
    private int dynamicSrPredictMode;

    @SerializedName("dynamic_sr_predict_skip_list")
    private final List<String> dynamicSrPredictSkipList;
    private boolean previewEnableSr;

    @SerializedName("schedule_mode")
    private final int scheduleMode;

    @SerializedName("schedule_time_interval")
    private final ArrayList<Integer> scheduleTimeInterval;

    public final boolean isDSREnable() {
        if (this.dynamicSrMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDSRPredictEnable() {
        if (this.dynamicSrPredictMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFirstFrameDSREnable() {
        if (this.dynamicSrMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isPlayingDSREnable() {
        if (this.dynamicSrMode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRoomEnterDSRPredictEnable() {
        if (this.dynamicSrPredictMode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveDynamicSRConfig() {
        this.dynamicSrPredictEventName = "";
        this.dynamicSrPredictInterval = 5;
        this.scheduleTimeInterval = CollectionsKt.arrayListOf(new Integer[]{5, 15});
        this.dynamicSrPredictSkipList = CollectionsKt.emptyList();
        this.disableSceneList = CollectionsKt.emptyList();
    }

    public final boolean getAiServiceSrEnable() {
        return this.aiServiceSrEnable;
    }

    public final List<String> getDisableSceneList() {
        return this.disableSceneList;
    }

    public final int getDynamicSrMode() {
        return this.dynamicSrMode;
    }

    public final String getDynamicSrPredictEventName() {
        return this.dynamicSrPredictEventName;
    }

    public final int getDynamicSrPredictInterval() {
        return this.dynamicSrPredictInterval;
    }

    public final int getDynamicSrPredictMode() {
        return this.dynamicSrPredictMode;
    }

    public final List<String> getDynamicSrPredictSkipList() {
        return this.dynamicSrPredictSkipList;
    }

    public final boolean getPreviewEnableSr() {
        return this.previewEnableSr;
    }

    public final int getScheduleMode() {
        return this.scheduleMode;
    }

    public final ArrayList<Integer> getScheduleTimeInterval() {
        return this.scheduleTimeInterval;
    }

    public final boolean isPredictSkip(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.dynamicSrPredictSkipList.contains(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean isSrEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.disableSceneList.contains(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final void setAiServiceSrEnable(boolean r100) {
        this.aiServiceSrEnable = r100;
    }

    public final void setDynamicSrMode(int r100) {
        this.dynamicSrMode = r100;
    }

    public final void setDynamicSrPredictEventName(String r100) {
        this.dynamicSrPredictEventName = r100;
    }

    public final void setDynamicSrPredictInterval(int r100) {
        this.dynamicSrPredictInterval = r100;
    }

    public final void setDynamicSrPredictMode(int r100) {
        this.dynamicSrPredictMode = r100;
    }

    public final void setPreviewEnableSr(boolean r100) {
        this.previewEnableSr = r100;
    }
}
