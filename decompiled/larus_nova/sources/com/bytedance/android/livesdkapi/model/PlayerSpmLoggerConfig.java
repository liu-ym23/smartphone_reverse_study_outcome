package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerSpmLoggerConfig;", "", "simpleLog", "", "enableEventLog", "useSpmLog", "printExecuteCost", "(ZZZZ)V", "asyncLog", "getAsyncLog", "()Z", "getEnableEventLog", "logObserverMemLeakFix", "getLogObserverMemLeakFix", "logTTLivePlayer", "getLogTTLivePlayer", "getPrintExecuteCost", "getSimpleLog", "unusedLogOpt", "getUnusedLogOpt", "unusedLogOptV2", "getUnusedLogOptV2", "getUseSpmLog", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerSpmLoggerConfig {

    @SerializedName("async_log")
    private final boolean asyncLog;

    @SerializedName("enable_event_log")
    private final boolean enableEventLog;

    @SerializedName("log_observer_mem_leak_fix")
    private final boolean logObserverMemLeakFix;

    @SerializedName("log_ttlive_player")
    private final boolean logTTLivePlayer;

    @SerializedName("print_execute_cost")
    private final boolean printExecuteCost;

    @SerializedName("simple_log")
    private final boolean simpleLog;

    @SerializedName("unused_log_opt")
    private final boolean unusedLogOpt;

    @SerializedName("unused_log_opt_v2")
    private final boolean unusedLogOptV2;

    @SerializedName("use_spm_log")
    private final boolean useSpmLog;

    public PlayerSpmLoggerConfig() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ PlayerSpmLoggerConfig copy$default(PlayerSpmLoggerConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.simpleLog;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.enableEventLog;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.useSpmLog;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.printExecuteCost;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.simpleLog;
    }

    public final boolean component2() {
        return this.enableEventLog;
    }

    public final boolean component3() {
        return this.useSpmLog;
    }

    public final boolean component4() {
        return this.printExecuteCost;
    }

    public final PlayerSpmLoggerConfig copy(boolean r100, boolean r101, boolean r102, boolean r103) {
        return new PlayerSpmLoggerConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerSpmLoggerConfig) == false) goto L14;
        PlayerSpmLoggerConfig r101 = (PlayerSpmLoggerConfig) r100;
        if (this.simpleLog == r101.simpleLog) goto L8;
        return false;
    L8:
        if (this.enableEventLog == r101.enableEventLog) goto L10;
        return false;
    L10:
        if (this.useSpmLog == r101.useSpmLog) goto L12;
        return false;
    L12:
        if (this.printExecuteCost == r101.printExecuteCost) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean r100 = this.simpleLog;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableEventLog;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.useSpmLog;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.printExecuteCost;
        if (r110 == true) goto L16;
        r101 = r110;
    L16:
        return r109 + r101;
    }

    public String toString() {
        return "PlayerSpmLoggerConfig(simpleLog=" + this.simpleLog + ", enableEventLog=" + this.enableEventLog + ", useSpmLog=" + this.useSpmLog + ", printExecuteCost=" + this.printExecuteCost + ")";
    }

    public final boolean getAsyncLog() {
        return this.asyncLog;
    }

    public final boolean getEnableEventLog() {
        return this.enableEventLog;
    }

    public final boolean getLogObserverMemLeakFix() {
        return this.logObserverMemLeakFix;
    }

    public final boolean getLogTTLivePlayer() {
        return this.logTTLivePlayer;
    }

    public final boolean getPrintExecuteCost() {
        return this.printExecuteCost;
    }

    public final boolean getSimpleLog() {
        return this.simpleLog;
    }

    public final boolean getUnusedLogOpt() {
        return this.unusedLogOpt;
    }

    public final boolean getUnusedLogOptV2() {
        return this.unusedLogOptV2;
    }

    public final boolean getUseSpmLog() {
        return this.useSpmLog;
    }

    public PlayerSpmLoggerConfig(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.simpleLog = r100;
        this.enableEventLog = r101;
        this.useSpmLog = r102;
        this.printExecuteCost = r103;
        this.asyncLog = true;
        this.logObserverMemLeakFix = true;
    }

    public /* synthetic */ PlayerSpmLoggerConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
