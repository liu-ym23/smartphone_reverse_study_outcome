package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/BackGroundCheckConfig;", "", "()V", "checkInterval", "", "getCheckInterval", "()J", "setCheckInterval", "(J)V", "checkScene", "", "getCheckScene", "()Ljava/lang/String;", "setCheckScene", "(Ljava/lang/String;)V", "checkTimes", "getCheckTimes", "setCheckTimes", "enableCheck", "", "getEnableCheck", "()Z", "setEnableCheck", "(Z)V", "enableSecondCheck", "getEnableSecondCheck", "setEnableSecondCheck", "enableSecondCheckProcess", "getEnableSecondCheckProcess", "setEnableSecondCheckProcess", "needMuteAudio", "getNeedMuteAudio", "setNeedMuteAudio", "notCheckScene", "getNotCheckScene", "setNotCheckScene", "processScene", "getProcessScene", "setProcessScene", "secondCheckInterval", "getSecondCheckInterval", "setSecondCheckInterval", "specialCheckTimes", "getSpecialCheckTimes", "setSpecialCheckTimes", "specialFrontCheckList", "getSpecialFrontCheckList", "setSpecialFrontCheckList", "specialNeedMuteAudio", "getSpecialNeedMuteAudio", "setSpecialNeedMuteAudio", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackGroundCheckConfig {

    @SerializedName("background_check_interval")
    private long checkInterval;

    @SerializedName("check_scene")
    private String checkScene;

    @SerializedName("check_times")
    private long checkTimes;

    @SerializedName("enable_check")
    private boolean enableCheck;

    @SerializedName("enable_second_check")
    private boolean enableSecondCheck;

    @SerializedName("enable_second_check_process")
    private boolean enableSecondCheckProcess;

    @SerializedName("need_mute_audio")
    private boolean needMuteAudio;

    @SerializedName("not_check_scene")
    private String notCheckScene;

    @SerializedName("process_scene")
    private String processScene;

    @SerializedName("second_check_interval")
    private long secondCheckInterval;

    @SerializedName("special_check_times")
    private long specialCheckTimes;

    @SerializedName("special_front_check_list")
    private String specialFrontCheckList;

    @SerializedName("special_need_mute_audio")
    private boolean specialNeedMuteAudio;

    public BackGroundCheckConfig() {
        this.checkScene = "";
        this.checkInterval = 2000;
        this.secondCheckInterval = 10;
        this.checkTimes = 3;
        this.notCheckScene = "inner_draw";
        this.needMuteAudio = true;
        this.processScene = "";
        this.specialFrontCheckList = "";
        this.specialCheckTimes = 3;
        this.specialNeedMuteAudio = true;
    }

    public final long getCheckInterval() {
        return this.checkInterval;
    }

    public final String getCheckScene() {
        return this.checkScene;
    }

    public final long getCheckTimes() {
        return this.checkTimes;
    }

    public final boolean getEnableCheck() {
        return this.enableCheck;
    }

    public final boolean getEnableSecondCheck() {
        return this.enableSecondCheck;
    }

    public final boolean getEnableSecondCheckProcess() {
        return this.enableSecondCheckProcess;
    }

    public final boolean getNeedMuteAudio() {
        return this.needMuteAudio;
    }

    public final String getNotCheckScene() {
        return this.notCheckScene;
    }

    public final String getProcessScene() {
        return this.processScene;
    }

    public final long getSecondCheckInterval() {
        return this.secondCheckInterval;
    }

    public final long getSpecialCheckTimes() {
        return this.specialCheckTimes;
    }

    public final String getSpecialFrontCheckList() {
        return this.specialFrontCheckList;
    }

    public final boolean getSpecialNeedMuteAudio() {
        return this.specialNeedMuteAudio;
    }

    public final void setCheckInterval(long r100) {
        this.checkInterval = r100;
    }

    public final void setCheckScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.checkScene = r100;
    }

    public final void setCheckTimes(long r100) {
        this.checkTimes = r100;
    }

    public final void setEnableCheck(boolean r100) {
        this.enableCheck = r100;
    }

    public final void setEnableSecondCheck(boolean r100) {
        this.enableSecondCheck = r100;
    }

    public final void setEnableSecondCheckProcess(boolean r100) {
        this.enableSecondCheckProcess = r100;
    }

    public final void setNeedMuteAudio(boolean r100) {
        this.needMuteAudio = r100;
    }

    public final void setNotCheckScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.notCheckScene = r100;
    }

    public final void setProcessScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.processScene = r100;
    }

    public final void setSecondCheckInterval(long r100) {
        this.secondCheckInterval = r100;
    }

    public final void setSpecialCheckTimes(long r100) {
        this.specialCheckTimes = r100;
    }

    public final void setSpecialFrontCheckList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.specialFrontCheckList = r100;
    }

    public final void setSpecialNeedMuteAudio(boolean r100) {
        this.specialNeedMuteAudio = r100;
    }
}
