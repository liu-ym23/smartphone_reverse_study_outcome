package com.bytedance.android.shopping.base.event;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/base/event/PdpFullNodeTraceSetting;", "Ljava/io/Serializable;", "aLogEnable", "", "monitorEnable", "(ZZ)V", "getALogEnable", "()Z", "getMonitorEnable", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpFullNodeTraceSetting implements Serializable {

    @SerializedName("alog_enable")
    private final boolean aLogEnable;

    @SerializedName("monitor_enable")
    private final boolean monitorEnable;

    public PdpFullNodeTraceSetting() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ PdpFullNodeTraceSetting copy$default(PdpFullNodeTraceSetting r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.aLogEnable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.monitorEnable;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.aLogEnable;
    }

    public final boolean component2() {
        return this.monitorEnable;
    }

    public final PdpFullNodeTraceSetting copy(boolean r100, boolean r101) {
        return new PdpFullNodeTraceSetting(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PdpFullNodeTraceSetting) == false) goto L10;
        PdpFullNodeTraceSetting r101 = (PdpFullNodeTraceSetting) r100;
        if (this.aLogEnable == r101.aLogEnable) goto L8;
        return false;
    L8:
        if (this.monitorEnable == r101.monitorEnable) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.aLogEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.monitorEnable;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "PdpFullNodeTraceSetting(aLogEnable=" + this.aLogEnable + ", monitorEnable=" + this.monitorEnable + ")";
    }

    public final boolean getALogEnable() {
        return this.aLogEnable;
    }

    public final boolean getMonitorEnable() {
        return this.monitorEnable;
    }

    public PdpFullNodeTraceSetting(boolean r100, boolean r101) {
        this.aLogEnable = r100;
        this.monitorEnable = r101;
    }

    public /* synthetic */ PdpFullNodeTraceSetting(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
