package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DropFrameConfig;", "", "dropInterval", "", "minFrameRate", "(II)V", "getDropInterval", "()I", "getMinFrameRate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DropFrameConfig {
    private final int dropInterval;
    private final int minFrameRate;

    public static /* synthetic */ DropFrameConfig copy$default(DropFrameConfig r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.dropInterval;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.minFrameRate;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.dropInterval;
    }

    public final int component2() {
        return this.minFrameRate;
    }

    public final DropFrameConfig copy(int r100, int r101) {
        return new DropFrameConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DropFrameConfig) == false) goto L10;
        DropFrameConfig r101 = (DropFrameConfig) r100;
        if (this.dropInterval == r101.dropInterval) goto L8;
        return false;
    L8:
        if (this.minFrameRate == r101.minFrameRate) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.dropInterval * 31) + this.minFrameRate;
    }

    public String toString() {
        return "DropFrameConfig(dropInterval=" + this.dropInterval + ", minFrameRate=" + this.minFrameRate + ")";
    }

    public final int getDropInterval() {
        return this.dropInterval;
    }

    public final int getMinFrameRate() {
        return this.minFrameRate;
    }

    public DropFrameConfig(int r100, int r101) {
        this.dropInterval = r100;
        this.minFrameRate = r101;
    }
}
