package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemCacheConfig;", "", "()V", "cleanActionsWhenExit", "", "getCleanActionsWhenExit", "()I", "setCleanActionsWhenExit", "(I)V", "disableOldRelease", "", "getDisableOldRelease", "()Z", "setDisableOldRelease", "(Z)V", "enableCacheCleanReport", "getEnableCacheCleanReport", "setEnableCacheCleanReport", "enableCleanWhenExit", "getEnableCleanWhenExit", "setEnableCleanWhenExit", "enableDowngradeCleanWhenExit", "getEnableDowngradeCleanWhenExit", "setEnableDowngradeCleanWhenExit", "enableEnterRoomReport", "getEnableEnterRoomReport", "setEnableEnterRoomReport", "enableForceCleanWhenExit", "getEnableForceCleanWhenExit", "setEnableForceCleanWhenExit", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMemCacheConfig {
    public static final Companion Companion = null;
    private static final LiveMemCacheConfig DEBUG_CONFIG = null;

    @SerializedName("clean_actions_when_exit")
    private int cleanActionsWhenExit;

    @SerializedName("disable_old_release")
    private boolean disableOldRelease;

    @SerializedName("enable_cache_clean_report")
    private boolean enableCacheCleanReport;

    @SerializedName("enable_clean_when_exit")
    private boolean enableCleanWhenExit;

    @SerializedName("enable_downgrade_clean_when_exit")
    private boolean enableDowngradeCleanWhenExit;

    @SerializedName("enable_enter_room_report")
    private boolean enableEnterRoomReport;

    @SerializedName("enable_force_clean_when_exit")
    private boolean enableForceCleanWhenExit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemCacheConfig$Companion;", "", "()V", "DEBUG_CONFIG", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemCacheConfig;", "getDEBUG_CONFIG", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemCacheConfig;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final LiveMemCacheConfig getDEBUG_CONFIG() {
            return LiveMemCacheConfig.access$getDEBUG_CONFIG$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        LiveMemCacheConfig r100 = new LiveMemCacheConfig();
        r100.enableCleanWhenExit = true;
        r100.enableEnterRoomReport = true;
        DEBUG_CONFIG = r100;
    }

    public LiveMemCacheConfig() {
        this.cleanActionsWhenExit = 124;
    }

    public static final /* synthetic */ LiveMemCacheConfig access$getDEBUG_CONFIG$cp() {
        return DEBUG_CONFIG;
    }

    public final int getCleanActionsWhenExit() {
        return this.cleanActionsWhenExit;
    }

    public final boolean getDisableOldRelease() {
        return this.disableOldRelease;
    }

    public final boolean getEnableCacheCleanReport() {
        return this.enableCacheCleanReport;
    }

    public final boolean getEnableCleanWhenExit() {
        return this.enableCleanWhenExit;
    }

    public final boolean getEnableDowngradeCleanWhenExit() {
        return this.enableDowngradeCleanWhenExit;
    }

    public final boolean getEnableEnterRoomReport() {
        return this.enableEnterRoomReport;
    }

    public final boolean getEnableForceCleanWhenExit() {
        return this.enableForceCleanWhenExit;
    }

    public final void setCleanActionsWhenExit(int r100) {
        this.cleanActionsWhenExit = r100;
    }

    public final void setDisableOldRelease(boolean r100) {
        this.disableOldRelease = r100;
    }

    public final void setEnableCacheCleanReport(boolean r100) {
        this.enableCacheCleanReport = r100;
    }

    public final void setEnableCleanWhenExit(boolean r100) {
        this.enableCleanWhenExit = r100;
    }

    public final void setEnableDowngradeCleanWhenExit(boolean r100) {
        this.enableDowngradeCleanWhenExit = r100;
    }

    public final void setEnableEnterRoomReport(boolean r100) {
        this.enableEnterRoomReport = r100;
    }

    public final void setEnableForceCleanWhenExit(boolean r100) {
        this.enableForceCleanWhenExit = r100;
    }
}
