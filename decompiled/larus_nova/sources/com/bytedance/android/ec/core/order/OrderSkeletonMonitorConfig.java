package com.bytedance.android.ec.core.order;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderSkeletonMonitorConfig;", "Ljava/io/Serializable;", "on", "", "maxMonitorCount", "", "singleTimerDuration", "renderIntervalThreshold", "revertIntervalThreshold", "(ZIIII)V", "getMaxMonitorCount", "()I", "getOn", "()Z", "getRenderIntervalThreshold", "getRevertIntervalThreshold", "getSingleTimerDuration", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSkeletonMonitorConfig implements Serializable {

    @SerializedName("inspectionMaxCount")
    private final int maxMonitorCount;

    /* JADX INFO: renamed from: on, reason: collision with root package name */
    @SerializedName("on")
    private final boolean f45285on;

    @SerializedName("renderIntervalThreshold")
    private final int renderIntervalThreshold;

    @SerializedName("renderIntervalThreshold")
    private final int revertIntervalThreshold;

    @SerializedName("inspectionDuration")
    private final int singleTimerDuration;

    public OrderSkeletonMonitorConfig() {
        this(false, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ OrderSkeletonMonitorConfig copy$default(OrderSkeletonMonitorConfig r100, boolean r101, int r102, int r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f45285on;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxMonitorCount;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.singleTimerDuration;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.renderIntervalThreshold;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.revertIntervalThreshold;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.f45285on;
    }

    public final int component2() {
        return this.maxMonitorCount;
    }

    public final int component3() {
        return this.singleTimerDuration;
    }

    public final int component4() {
        return this.renderIntervalThreshold;
    }

    public final int component5() {
        return this.revertIntervalThreshold;
    }

    public final OrderSkeletonMonitorConfig copy(boolean r100, int r101, int r110, int r111, int r112) {
        return new OrderSkeletonMonitorConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderSkeletonMonitorConfig) == false) goto L16;
        OrderSkeletonMonitorConfig r101 = (OrderSkeletonMonitorConfig) r100;
        if (this.f45285on == r101.f45285on) goto L8;
        return false;
    L8:
        if (this.maxMonitorCount == r101.maxMonitorCount) goto L10;
        return false;
    L10:
        if (this.singleTimerDuration == r101.singleTimerDuration) goto L12;
        return false;
    L12:
        if (this.renderIntervalThreshold == r101.renderIntervalThreshold) goto L14;
        return false;
    L14:
        if (this.revertIntervalThreshold == r101.revertIntervalThreshold) goto L25;
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
    public int hashCode() {
        boolean r100 = this.f45285on;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((((r101 * 31) + this.maxMonitorCount) * 31) + this.singleTimerDuration) * 31) + this.renderIntervalThreshold) * 31) + this.revertIntervalThreshold;
    }

    public String toString() {
        return "OrderSkeletonMonitorConfig(on=" + this.f45285on + ", maxMonitorCount=" + this.maxMonitorCount + ", singleTimerDuration=" + this.singleTimerDuration + ", renderIntervalThreshold=" + this.renderIntervalThreshold + ", revertIntervalThreshold=" + this.revertIntervalThreshold + ")";
    }

    public final int getMaxMonitorCount() {
        return this.maxMonitorCount;
    }

    public final boolean getOn() {
        return this.f45285on;
    }

    public final int getRenderIntervalThreshold() {
        return this.renderIntervalThreshold;
    }

    public final int getRevertIntervalThreshold() {
        return this.revertIntervalThreshold;
    }

    public final int getSingleTimerDuration() {
        return this.singleTimerDuration;
    }

    public OrderSkeletonMonitorConfig(boolean r100, int r101, int r102, int r103, int r104) {
        this.f45285on = r100;
        this.maxMonitorCount = r101;
        this.singleTimerDuration = r102;
        this.renderIntervalThreshold = r103;
        this.revertIntervalThreshold = r104;
    }

    public /* synthetic */ OrderSkeletonMonitorConfig(boolean r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r105 & 2) == 0) goto L8;
        int r111 = 3;
    L9:
        int r106 = 5000;
        if ((r105 & 4) == 0) goto L12;
        int r107 = 5000;
    L14:
        if ((r105 & 8) == 0) goto L16;
        int r108 = 2000;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L9
    }
}
