package com.stepos.core.strategy;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stepos/core/strategy/RoutingConfig;", "", "largeSizeThreshold", "", "mediumSizeThreshold", "enableSharedMemory", "", "enableEventFD", "<init>", "(IIZZ)V", "getLargeSizeThreshold", "()I", "setLargeSizeThreshold", "(I)V", "getMediumSizeThreshold", "setMediumSizeThreshold", "getEnableSharedMemory", "()Z", "setEnableSharedMemory", "(Z)V", "getEnableEventFD", "setEnableEventFD", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RoutingConfig {
    private boolean enableEventFD;
    private boolean enableSharedMemory;
    private int largeSizeThreshold;
    private int mediumSizeThreshold;

    public RoutingConfig() {
        this(0, 0, false, false, 15, null);
    }

    public static /* synthetic */ RoutingConfig copy$default(RoutingConfig routingConfig, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = routingConfig.largeSizeThreshold;
        }
        if ((i12 & 2) != 0) {
            i11 = routingConfig.mediumSizeThreshold;
        }
        if ((i12 & 4) != 0) {
            z10 = routingConfig.enableSharedMemory;
        }
        if ((i12 & 8) != 0) {
            z11 = routingConfig.enableEventFD;
        }
        return routingConfig.copy(i10, i11, z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLargeSizeThreshold() {
        return this.largeSizeThreshold;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMediumSizeThreshold() {
        return this.mediumSizeThreshold;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableSharedMemory() {
        return this.enableSharedMemory;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getEnableEventFD() {
        return this.enableEventFD;
    }

    public final RoutingConfig copy(int largeSizeThreshold, int mediumSizeThreshold, boolean enableSharedMemory, boolean enableEventFD) {
        return new RoutingConfig(largeSizeThreshold, mediumSizeThreshold, enableSharedMemory, enableEventFD);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoutingConfig)) {
            return false;
        }
        RoutingConfig routingConfig = (RoutingConfig) other;
        return this.largeSizeThreshold == routingConfig.largeSizeThreshold && this.mediumSizeThreshold == routingConfig.mediumSizeThreshold && this.enableSharedMemory == routingConfig.enableSharedMemory && this.enableEventFD == routingConfig.enableEventFD;
    }

    public final boolean getEnableEventFD() {
        return this.enableEventFD;
    }

    public final boolean getEnableSharedMemory() {
        return this.enableSharedMemory;
    }

    public final int getLargeSizeThreshold() {
        return this.largeSizeThreshold;
    }

    public final int getMediumSizeThreshold() {
        return this.mediumSizeThreshold;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.largeSizeThreshold) * 31) + Integer.hashCode(this.mediumSizeThreshold)) * 31) + Boolean.hashCode(this.enableSharedMemory)) * 31) + Boolean.hashCode(this.enableEventFD);
    }

    public final void setEnableEventFD(boolean z10) {
        this.enableEventFD = z10;
    }

    public final void setEnableSharedMemory(boolean z10) {
        this.enableSharedMemory = z10;
    }

    public final void setLargeSizeThreshold(int i10) {
        this.largeSizeThreshold = i10;
    }

    public final void setMediumSizeThreshold(int i10) {
        this.mediumSizeThreshold = i10;
    }

    public String toString() {
        return "RoutingConfig(largeSizeThreshold=" + this.largeSizeThreshold + ", mediumSizeThreshold=" + this.mediumSizeThreshold + ", enableSharedMemory=" + this.enableSharedMemory + ", enableEventFD=" + this.enableEventFD + ")";
    }

    public RoutingConfig(int i10, int i11, boolean z10, boolean z11) {
        this.largeSizeThreshold = i10;
        this.mediumSizeThreshold = i11;
        this.enableSharedMemory = z10;
        this.enableEventFD = z11;
    }

    public /* synthetic */ RoutingConfig(int i10, int i11, boolean z10, boolean z11, int i12, i iVar) {
        this((i12 & 1) != 0 ? 102400 : i10, (i12 & 2) != 0 ? 10240 : i11, (i12 & 4) != 0 ? true : z10, (i12 & 8) != 0 ? true : z11);
    }
}
