package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR&\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveLinkMicDynamicCenterConfig;", "", "()V", "checkRuntimeReady", "", "getCheckRuntimeReady", "()Z", "setCheckRuntimeReady", "(Z)V", "debug", "getDebug", "setDebug", "debugIp", "", "getDebugIp", "()Ljava/lang/String;", "setDebugIp", "(Ljava/lang/String;)V", "enable", "getEnable", "setEnable", "logMixedInfo", "getLogMixedInfo", "setLogMixedInfo", "onlyReuseCardInFullScreenFeed", "getOnlyReuseCardInFullScreenFeed", "setOnlyReuseCardInFullScreenFeed", "reuseCard", "getReuseCard", "setReuseCard", "schema", "getSchema", "setSchema", "searchFeedPlayerAdjustOpt", "getSearchFeedPlayerAdjustOpt", "setSearchFeedPlayerAdjustOpt", "seiCacheKeys", "", "getSeiCacheKeys", "()Ljava/util/List;", "setSeiCacheKeys", "(Ljava/util/List;)V", "talkingStateInterval", "", "getTalkingStateInterval", "()J", "setTalkingStateInterval", "(J)V", "url", "getUrl", "setUrl", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLinkMicDynamicCenterConfig {

    @SerializedName("check_runtime_ready")
    private boolean checkRuntimeReady;

    @SerializedName("debug")
    private boolean debug;

    @SerializedName("debugIp")
    private String debugIp;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("log_mixed_info")
    private boolean logMixedInfo;

    @SerializedName("only_reuse_card_in_full_screen_feed")
    private boolean onlyReuseCardInFullScreenFeed;

    @SerializedName("reuse_card")
    private boolean reuseCard;

    @SerializedName("schema")
    private String schema;

    @SerializedName("search_feed_player_adjust_opt")
    private boolean searchFeedPlayerAdjustOpt;

    @SerializedName("sei_cache_keys")
    private List<String> seiCacheKeys;

    @SerializedName("talking_state_interval")
    private long talkingStateInterval;

    @SerializedName("url")
    private String url;

    public LiveLinkMicDynamicCenterConfig() {
        this.enable = true;
        this.debug = true;
        this.url = "";
        this.schema = "";
        this.debugIp = "";
        this.reuseCard = true;
        this.checkRuntimeReady = true;
        this.logMixedInfo = true;
        this.talkingStateInterval = 700;
        this.onlyReuseCardInFullScreenFeed = true;
        this.searchFeedPlayerAdjustOpt = true;
    }

    public final boolean getCheckRuntimeReady() {
        return this.checkRuntimeReady;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final String getDebugIp() {
        return this.debugIp;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getLogMixedInfo() {
        return this.logMixedInfo;
    }

    public final boolean getOnlyReuseCardInFullScreenFeed() {
        return this.onlyReuseCardInFullScreenFeed;
    }

    public final boolean getReuseCard() {
        return this.reuseCard;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getSearchFeedPlayerAdjustOpt() {
        return this.searchFeedPlayerAdjustOpt;
    }

    public final List<String> getSeiCacheKeys() {
        return this.seiCacheKeys;
    }

    public final long getTalkingStateInterval() {
        return this.talkingStateInterval;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCheckRuntimeReady(boolean r100) {
        this.checkRuntimeReady = r100;
    }

    public final void setDebug(boolean r100) {
        this.debug = r100;
    }

    public final void setDebugIp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.debugIp = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setLogMixedInfo(boolean r100) {
        this.logMixedInfo = r100;
    }

    public final void setOnlyReuseCardInFullScreenFeed(boolean r100) {
        this.onlyReuseCardInFullScreenFeed = r100;
    }

    public final void setReuseCard(boolean r100) {
        this.reuseCard = r100;
    }

    public final void setSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema = r100;
    }

    public final void setSearchFeedPlayerAdjustOpt(boolean r100) {
        this.searchFeedPlayerAdjustOpt = r100;
    }

    public final void setSeiCacheKeys(List<String> r100) {
        this.seiCacheKeys = r100;
    }

    public final void setTalkingStateInterval(long r100) {
        this.talkingStateInterval = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }
}
