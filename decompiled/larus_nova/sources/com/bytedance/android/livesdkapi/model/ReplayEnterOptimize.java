package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ReplayEnterOptimize;", "", "()V", "enablePreloadJsb", "", "getEnablePreloadJsb", "()Z", "setEnablePreloadJsb", "(Z)V", "enablePrepare", "getEnablePrepare", "setEnablePrepare", "enablePrepareBackground", "getEnablePrepareBackground", "setEnablePrepareBackground", "enableRequestBeforeEnter", "getEnableRequestBeforeEnter", "setEnableRequestBeforeEnter", "enterPreload", "getEnterPreload", "setEnterPreload", "ridCacheDuration", "", "getRidCacheDuration", "()I", "setRidCacheDuration", "(I)V", "schemaUidEnterOptimize", "getSchemaUidEnterOptimize", "setSchemaUidEnterOptimize", "uidCacheDuration", "getUidCacheDuration", "setUidCacheDuration", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayEnterOptimize {

    @SerializedName("enable_preload_jsb")
    private boolean enablePreloadJsb;

    @SerializedName("vs_video_prepare_enable")
    private boolean enablePrepare;

    @SerializedName("enable_prepare_background")
    private boolean enablePrepareBackground;

    @SerializedName("enable_request_before_enter")
    private boolean enableRequestBeforeEnter;

    @SerializedName("vs_video_enable_enter_preload")
    private boolean enterPreload;

    @SerializedName("schema_rid_cache_duration")
    private int ridCacheDuration;

    @SerializedName("replay_enable_uid_schema_optimize")
    private boolean schemaUidEnterOptimize;

    @SerializedName("schema_uid_cache_duration")
    private int uidCacheDuration;

    public ReplayEnterOptimize() {
        this.enterPreload = true;
        this.enablePreloadJsb = true;
        this.enablePrepare = true;
        this.ridCacheDuration = 1;
        this.uidCacheDuration = 10;
    }

    public final boolean getEnablePreloadJsb() {
        return this.enablePreloadJsb;
    }

    public final boolean getEnablePrepare() {
        return this.enablePrepare;
    }

    public final boolean getEnablePrepareBackground() {
        return this.enablePrepareBackground;
    }

    public final boolean getEnableRequestBeforeEnter() {
        return this.enableRequestBeforeEnter;
    }

    public final boolean getEnterPreload() {
        return this.enterPreload;
    }

    public final int getRidCacheDuration() {
        return this.ridCacheDuration;
    }

    public final boolean getSchemaUidEnterOptimize() {
        return this.schemaUidEnterOptimize;
    }

    public final int getUidCacheDuration() {
        return this.uidCacheDuration;
    }

    public final void setEnablePreloadJsb(boolean r100) {
        this.enablePreloadJsb = r100;
    }

    public final void setEnablePrepare(boolean r100) {
        this.enablePrepare = r100;
    }

    public final void setEnablePrepareBackground(boolean r100) {
        this.enablePrepareBackground = r100;
    }

    public final void setEnableRequestBeforeEnter(boolean r100) {
        this.enableRequestBeforeEnter = r100;
    }

    public final void setEnterPreload(boolean r100) {
        this.enterPreload = r100;
    }

    public final void setRidCacheDuration(int r100) {
        this.ridCacheDuration = r100;
    }

    public final void setSchemaUidEnterOptimize(boolean r100) {
        this.schemaUidEnterOptimize = r100;
    }

    public final void setUidCacheDuration(int r100) {
        this.uidCacheDuration = r100;
    }
}
