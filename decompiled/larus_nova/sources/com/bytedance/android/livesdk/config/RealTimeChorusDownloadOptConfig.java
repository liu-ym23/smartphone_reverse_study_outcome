package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JH\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/RealTimeChorusDownloadOptConfig;", "", "enableOptimize", "", "goodNetworkLevelList", "", "", "musicDuration", "useParallelStrategy", "dropNetworkCheck", "(Z[Ljava/lang/Integer;IZZ)V", "getDropNetworkCheck", "()Z", "setDropNetworkCheck", "(Z)V", "getEnableOptimize", "setEnableOptimize", "getGoodNetworkLevelList", "()[Ljava/lang/Integer;", "setGoodNetworkLevelList", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getMusicDuration", "()I", "setMusicDuration", "(I)V", "getUseParallelStrategy", "setUseParallelStrategy", "component1", "component2", "component3", "component4", "component5", "copy", "(Z[Ljava/lang/Integer;IZZ)Lcom/bytedance/android/livesdk/config/RealTimeChorusDownloadOptConfig;", "equals", "other", "hashCode", "toString", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusDownloadOptConfig {

    @SerializedName("drop_network_check")
    private boolean dropNetworkCheck;

    @SerializedName("enable_optimize")
    private boolean enableOptimize;

    @SerializedName("good_network_level_list")
    private Integer[] goodNetworkLevelList;

    @SerializedName("music_duration")
    private int musicDuration;

    @SerializedName("use_parallel_strategy")
    private boolean useParallelStrategy;

    public RealTimeChorusDownloadOptConfig() {
        this(false, null, 0, false, false, 31, null);
    }

    public static /* synthetic */ RealTimeChorusDownloadOptConfig copy$default(RealTimeChorusDownloadOptConfig r100, boolean r101, Integer[] r102, int r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableOptimize;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.goodNetworkLevelList;
    L8:
        Integer[] r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.musicDuration;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.useParallelStrategy;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.dropNetworkCheck;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableOptimize;
    }

    public final Integer[] component2() {
        return this.goodNetworkLevelList;
    }

    public final int component3() {
        return this.musicDuration;
    }

    public final boolean component4() {
        return this.useParallelStrategy;
    }

    public final boolean component5() {
        return this.dropNetworkCheck;
    }

    public final RealTimeChorusDownloadOptConfig copy(boolean r100, Integer[] r101, int r110, boolean r111, boolean r112) {
        return new RealTimeChorusDownloadOptConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RealTimeChorusDownloadOptConfig) == false) goto L16;
        RealTimeChorusDownloadOptConfig r101 = (RealTimeChorusDownloadOptConfig) r100;
        if (this.enableOptimize == r101.enableOptimize) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.goodNetworkLevelList, r101.goodNetworkLevelList) == true) goto L10;
        return false;
    L10:
        if (this.musicDuration == r101.musicDuration) goto L12;
        return false;
    L12:
        if (this.useParallelStrategy == r101.useParallelStrategy) goto L14;
        return false;
    L14:
        if (this.dropNetworkCheck == r101.dropNetworkCheck) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean r100 = this.enableOptimize;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        Integer[] r104 = this.goodNetworkLevelList;
        if (r104 == null) goto L8;
        int r105 = Arrays.hashCode(r104);
    L9:
        int r106 = (((r103 + r105) * 31) + this.musicDuration) * 31;
        boolean r107 = this.useParallelStrategy;
        ?? r108 = r107;
        if (r107 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.dropNetworkCheck;
        if (r110 == true) goto L17;
        r101 = r110;
    L17:
        return r109 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "RealTimeChorusDownloadOptConfig(enableOptimize=" + this.enableOptimize + ", goodNetworkLevelList=" + Arrays.toString(this.goodNetworkLevelList) + ", musicDuration=" + this.musicDuration + ", useParallelStrategy=" + this.useParallelStrategy + ", dropNetworkCheck=" + this.dropNetworkCheck + ")";
    }

    public final boolean getDropNetworkCheck() {
        return this.dropNetworkCheck;
    }

    public final boolean getEnableOptimize() {
        return this.enableOptimize;
    }

    public final Integer[] getGoodNetworkLevelList() {
        return this.goodNetworkLevelList;
    }

    public final int getMusicDuration() {
        return this.musicDuration;
    }

    public final boolean getUseParallelStrategy() {
        return this.useParallelStrategy;
    }

    public final void setDropNetworkCheck(boolean r100) {
        this.dropNetworkCheck = r100;
    }

    public final void setEnableOptimize(boolean r100) {
        this.enableOptimize = r100;
    }

    public final void setGoodNetworkLevelList(Integer[] r100) {
        this.goodNetworkLevelList = r100;
    }

    public final void setMusicDuration(int r100) {
        this.musicDuration = r100;
    }

    public final void setUseParallelStrategy(boolean r100) {
        this.useParallelStrategy = r100;
    }

    public RealTimeChorusDownloadOptConfig(boolean r100, Integer[] r101, int r102, boolean r103, boolean r104) {
        this.enableOptimize = r100;
        this.goodNetworkLevelList = r101;
        this.musicDuration = r102;
        this.useParallelStrategy = r103;
        this.dropNetworkCheck = r104;
    }

    public /* synthetic */ RealTimeChorusDownloadOptConfig(boolean r100, Integer[] r101, int r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = true;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = new Integer[]{0, 5, 6, 7, 8};
    L9:
        Integer[] r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        int r106 = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
    L14:
        if ((r110 & 8) == 0) goto L16;
        boolean r107 = true;
    L18:
        if ((r110 & 16) == 0) goto L20;
        boolean r113 = true;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
