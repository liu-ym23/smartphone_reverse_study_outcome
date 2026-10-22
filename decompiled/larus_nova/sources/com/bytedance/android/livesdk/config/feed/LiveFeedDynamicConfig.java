package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JI\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamicConfig;", "", "enable", "", "dynamicOutFlow", "", "Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamic;", "dynamicInnerFlow", "dynamicDrawer", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDynamicDrawer", "()Ljava/util/List;", "getDynamicInnerFlow", "getDynamicOutFlow", "getEnable", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedDynamicConfig {

    @SerializedName("live_feed_dynamic_drawer")
    private final List<LiveFeedDynamic> dynamicDrawer;

    @SerializedName("live_feed_dynamic_innerflow")
    private final List<LiveFeedDynamic> dynamicInnerFlow;

    @SerializedName("live_feed_dynamic_outflow")
    private final List<LiveFeedDynamic> dynamicOutFlow;

    @SerializedName("enable")
    private final boolean enable;

    public LiveFeedDynamicConfig() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveFeedDynamicConfig copy$default(LiveFeedDynamicConfig r100, boolean r101, List r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.dynamicOutFlow;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.dynamicInnerFlow;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.dynamicDrawer;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<LiveFeedDynamic> component2() {
        return this.dynamicOutFlow;
    }

    public final List<LiveFeedDynamic> component3() {
        return this.dynamicInnerFlow;
    }

    public final List<LiveFeedDynamic> component4() {
        return this.dynamicDrawer;
    }

    public final LiveFeedDynamicConfig copy(boolean r100, List<LiveFeedDynamic> r101, List<LiveFeedDynamic> r102, List<LiveFeedDynamic> r103) {
        return new LiveFeedDynamicConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedDynamicConfig) == false) goto L14;
        LiveFeedDynamicConfig r101 = (LiveFeedDynamicConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dynamicOutFlow, r101.dynamicOutFlow) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dynamicInnerFlow, r101.dynamicInnerFlow) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicDrawer, r101.dynamicDrawer) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<LiveFeedDynamic> r103 = this.dynamicOutFlow;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        List<LiveFeedDynamic> r107 = this.dynamicInnerFlow;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        List<LiveFeedDynamic> r110 = this.dynamicDrawer;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "LiveFeedDynamicConfig(enable=" + this.enable + ", dynamicOutFlow=" + this.dynamicOutFlow + ", dynamicInnerFlow=" + this.dynamicInnerFlow + ", dynamicDrawer=" + this.dynamicDrawer + ")";
    }

    public final List<LiveFeedDynamic> getDynamicDrawer() {
        return this.dynamicDrawer;
    }

    public final List<LiveFeedDynamic> getDynamicInnerFlow() {
        return this.dynamicInnerFlow;
    }

    public final List<LiveFeedDynamic> getDynamicOutFlow() {
        return this.dynamicOutFlow;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public LiveFeedDynamicConfig(boolean r100, List<LiveFeedDynamic> r101, List<LiveFeedDynamic> r102, List<LiveFeedDynamic> r103) {
        this.enable = r100;
        this.dynamicOutFlow = r101;
        this.dynamicInnerFlow = r102;
        this.dynamicDrawer = r103;
    }

    public /* synthetic */ LiveFeedDynamicConfig(boolean r100, List r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
